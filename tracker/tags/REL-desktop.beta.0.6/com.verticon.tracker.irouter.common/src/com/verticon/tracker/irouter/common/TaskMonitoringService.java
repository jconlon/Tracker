package com.verticon.tracker.irouter.common;

import static com.verticon.tracker.irouter.common.internal.bundle.BundleConstants.bundleMarker;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskMonitoringService implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(TaskMonitoringService.class);


	private final Executor executor;
	private final ICallableFactory callableFactory;
	
	// service that wraps an executor
	private ExecutorCompletionService<Void> compService;
	// Futures for all submitted Callables that have not yet been checked
	private Set<Future<Void>> futures = new CopyOnWriteArraySet<Future<Void>>();

	public TaskMonitoringService(Executor executor,
			ICallableFactory callableFactory) {
		super();
		this.executor = executor;
		this.callableFactory = callableFactory;
	}

	@Override
	public String toString() {
		return "TaskMonitoringService [pid=" + callableFactory.getPid()
				+ "]";
	}

	@Override
	public Void call() throws Exception {

		try {
			while (!Thread.currentThread().isInterrupted()) {
				this.compService = new ExecutorCompletionService<Void>(executor);
				
				submitTasks();
				
				monitorTasks();
				
				cancelRemainingTasks();
				
				if (!Thread.currentThread().isInterrupted()) {
					TimeUnit.SECONDS.sleep(callableFactory
							.getSecondsBetweenRestarts());
				}else{
					
					log.warn(bundleMarker,"{}: Thread is Interrupted", this);
				}
			}
		} catch (InterruptedException e) {
			log.debug(bundleMarker,"{}: Terminating.", this);
			//Allow thread to exit
		}
		cancelRemainingTasks();
		log.debug(bundleMarker,"{}: Terminated.", this);
		return null;
	}

	/**
	 * Cancel all runing tasks. 
	 * @param mayInterruptIfRunning
	 */
	public void cancelAndRestartTasks(boolean mayInterruptIfRunning) {
		for (Future<Void> future : futures) {
			future.cancel(mayInterruptIfRunning);
			break;
		}
	}

	private void cancelRemainingTasks() {
		
		log.debug(bundleMarker,"{}: canceling the remaining {} tasks", this, futures.size());
		
		for (Future<Void> f : futures) {
			boolean wasCanceled = f.cancel(true);
			if (log.isDebugEnabled()) {
				if(wasCanceled){
					log.debug(bundleMarker,"{}: canceled task", this);
				}else{
					log.debug(bundleMarker,"{}: failed to cancel task", this);
				}
				
			}
		}
		futures.clear();
	}


	/**
	 * Blocks until any of the tasks completes
	 * @throws InterruptedException
	 */
	private void monitorTasks() throws InterruptedException  {
		
		log.debug(bundleMarker,"{}: monitoring {} tasks", this, futures.size());
		
		Future<Void> completedFuture = compService.take();
		try {
			if (completedFuture.isCancelled()) {
				log.warn(bundleMarker,"{}: Task was canceled.", this);
			}else {
				completedFuture.get();
				log.info(bundleMarker,(String.format("%s: Task completed prematurely without throwing an error.", this)));
			}
		/*
		 * log as debug
		 * } catch (NoRouteToHostException e){
				log.info(this + ":No Route to Host {} ", uri);
				throw e;
		 */
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			if(cause instanceof NoRouteToHostException){
				log.debug(bundleMarker,this + ": Task could not connect to target host. "+ cause.getMessage());
			
			}else if(cause instanceof ConnectException){
				log.debug(bundleMarker,this + ": Task could not connect to target host."+ cause.getMessage());
			}else if(cause instanceof UnknownHostException){
				log.debug(bundleMarker,this + ": Task could not connect to unknown host."+ cause.getMessage());
			}else{
				log.error(bundleMarker,(String.format("%s: Task failed.", this)), cause);
			}
		} finally{
			boolean removed = futures.remove(completedFuture);
			if (!removed) {
				log.error(bundleMarker,"{}: task was NOT removed from set of tasks", this);
			}
		}
		
		
	}

	/**
	 * Submit all the tasks for monitoring.
	 * @throws InterruptedException
	 */
	private void submitTasks() throws InterruptedException {
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
		for (Callable<Void> c : callableFactory.getCallables()) {
			log.debug(bundleMarker,"{}: Submitting {}", this, c);
			
			futures.add(compService.submit(c));
		}
	}

	

}