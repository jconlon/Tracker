/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.reader.event.connection;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.views.ReaderViewPart;

/**
 * @author jconlon
 * 
 */
final public class ReaderCompletionService {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ReaderCompletionService.class);
	
	private  ExecutorService executorService = null;
	private  CompletionService<RefreshableReader> completionService = null;
	private  ScheduledExecutorService scheduler = null;

	
    public synchronized final Future<RefreshableReader> submit(Callable<RefreshableReader> task){
		return completionService.submit(task);
	}
    
    public synchronized final ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, int initialDelay, int delay, TimeUnit unit){
    	if(delay==0){
    		throw new IllegalArgumentException("The delay argument cannot be zero");
    	}
    	return scheduler.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

	public synchronized final void start() {
		logger.debug(bundleMarker,"Background task completion service starting.");
		
		if(executorService==null || executorService.isShutdown()){
			executorService = Executors.newCachedThreadPool();
			completionService = new ExecutorCompletionService<RefreshableReader>(
					executorService);
		}
		executorService.execute(runner);
	    scheduler =  Executors.newScheduledThreadPool(1);
	}

	public final synchronized boolean stop() throws InterruptedException {
		logger.info(bundleMarker,"Background task completion service shutingdown all background tasks and the service.");
		executorService.shutdownNow();
		scheduler.shutdown();
		return executorService.awaitTermination(3, TimeUnit.SECONDS);
		
	}
	

	private final Runnable runner = new Runnable() {
		@Override
		public void run() {
			logger.info(bundleMarker,"Background task completion service started.");
			try {
				while (true) {
					processFutures(completionService.take());
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();// reset inturuption
			}
			logger.info(bundleMarker,"Background task completion service finished.");
		}
	};

	private final void processFutures(Future<RefreshableReader> futurePub)
			throws InterruptedException {
		RefreshableReader pub = null;

		try {
		    pub = futurePub.get();
			refresh(pub);
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			logger.error(
				"Background reader task failed. "+
 cause.getClass().getSimpleName() + ' ' + cause.getMessage(), e);
			showErrorDialog(cause);
		} catch (CancellationException e){
			logger.debug(
				"Background task completion service removed a canceled reader task.");
		}

	}

	private final void showErrorDialog(Throwable cause) {
		final IStatus status = new Status(Status.ERROR,
				"com.verticon.tracker.reader", cause.getClass().getSimpleName(), cause);
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// Display the dialog
				ErrorDialog.openError(Display.getCurrent().getActiveShell(),
						"Reader Processing Failure",
						"Background reader task failed to execute.", status);

				refreshView();

			}
		});
	}

	private final void refresh(final RefreshableReader pub) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				pub.refresh();

			}
		});

	}

	private void refreshView() {
		ReaderViewPart view =  (ReaderViewPart) getActivePage().findViewReference("com.verticon.tracker.reader.view").getView(true);
		view.refresh();
	}

	/**
	 * Obtains the currently active workbench page.
	 * 
	 * @return the active page, or <code>null</code> if none is active
	 */
	private IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;

		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();

			if (window != null) {
				result = window.getActivePage();
			}
		}

		return result;
	}

}
