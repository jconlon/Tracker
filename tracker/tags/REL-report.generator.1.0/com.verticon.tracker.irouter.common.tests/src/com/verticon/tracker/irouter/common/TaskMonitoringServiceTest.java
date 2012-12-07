/**
 * 
 */
package com.verticon.tracker.irouter.common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jconlon
 *
 */
public class TaskMonitoringServiceTest {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(TaskMonitoringServiceTest.class);


	ExecutorService exec = null;
	MockCallableFactory cf = null;
	TaskMonitoringService instance = null;
	private Future<Void> taskMonitorFuture;
	int counter = 0;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 exec = Executors.newCachedThreadPool();
		 cf = new MockCallableFactory();
		 instance = new TaskMonitoringService(exec, cf);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		if(taskMonitorFuture !=null){
			taskMonitorFuture.cancel(true);
			taskMonitorFuture = null;
		}
		if(exec != null){
			exec.shutdownNow();
		}
		exec = null;
	    cf = null;
	    instance = null;
	    counter=0;
	}

	/**
	 * Test method for {@link com.verticon.tracker.irouter.common.TaskMonitoringService#call()}.
	 * @throws InterruptedException 
	 */
	@Test
	public void testMonitoringTasks() throws InterruptedException {
		log.debug("=============== Starting testMonitoringTasks" );
		taskMonitorFuture = exec.submit(instance);
		TimeUnit.SECONDS.sleep(60);
		assertEquals(8, counter);
	}

	/**
	 * Test method for {@link com.verticon.tracker.irouter.common.TaskMonitoringService#cancelAndRestartTasks(boolean)}.
	 * @throws InterruptedException 
	 */
	@Test
	public void testCancelAndRestartTasks() throws InterruptedException {
		log.debug("=============== Starting testCancelAndRestartTasks" );
		taskMonitorFuture = exec.submit(instance);
		TimeUnit.SECONDS.sleep(20);
		log.debug("............Canceling  cancelAndRestartTasks" );
		instance.cancelAndRestartTasks(true);
		
		TimeUnit.SECONDS.sleep(20);
		log.debug("............Canceling  cancelAndRestartTasks" );
		instance.cancelAndRestartTasks(true);
		
		TimeUnit.SECONDS.sleep(20);
		log.debug("............Canceling  cancelAndRestartTasks" );
		instance.cancelAndRestartTasks(true);
		assertEquals(9, counter);
	}

	class MockCallableFactory implements ICallableFactory{

		@Override
		public synchronized Collection<Callable<Void>> getCallables() {
//			try {
//				closeConnection();
//			} catch (IOException e) {
//				log.error(this + ": Failed to close connection.", e);
//			}
			List<Callable<Void>> list = new ArrayList<Callable<Void>>();
			list.add(new MockCallable1());
			list.add(new MockCallableErrorGenerator());
			return list;
		}

		@Override
		public String getPid() {
			
			return "Test";
		}

		@Override
		public long getSecondsBetweenRestarts() {
			return 2;
		}
		
	}
	
	class MockCallable1 implements Callable<Void>{
		boolean wasCanceled = false;
		@Override
		public String toString() {
			return "MockCallable1 []";
		}

		@Override
		public Void call() throws Exception {
			log.info(this+" starting");
			try {
				while (!Thread.currentThread().isInterrupted()) {
					log.debug(this+" running");
					TimeUnit.SECONDS.sleep(2);
				}
			} catch (InterruptedException e) {
				log.info(this+" exiting");
				wasCanceled=true;
			}
			return null;
		}
		
	}
	
	class MockCallable2 implements Callable<Void>{
		boolean wasCanceled = false;
		@Override
		public Void call() throws Exception {
			log.info(this+" starting");
			try {
				while (!Thread.currentThread().isInterrupted()) {
					log.debug(this+" running");
					TimeUnit.SECONDS.sleep(2);
				}
			} catch (InterruptedException e) {
				log.info(this+" exiting");
				wasCanceled=true;
			}
			return null;
		}
		
	}
	
	class MockCallableErrorGenerator implements Callable<Void>{
		boolean wasCanceled = false;
		@Override
		public String toString() {
			return "MockCallableErrorGenerator []";
		}

		@Override
		public Void call() throws Exception {
			int count = 0;
			log.info(this+" starting");
			counter++;
			try {
				while (!Thread.currentThread().isInterrupted()) {
					count++;
					if(count>3){
						throw new Exception("Count exceeded");
					}
					log.debug(this+" running count " + count);
					TimeUnit.SECONDS.sleep(2);
					
				}
			} catch (InterruptedException e) {
				log.info(this+" interrupted");
				wasCanceled=true;
			} finally {
				log.info(this+" exiting");
			}
			return null;
		}
		
	}
}
