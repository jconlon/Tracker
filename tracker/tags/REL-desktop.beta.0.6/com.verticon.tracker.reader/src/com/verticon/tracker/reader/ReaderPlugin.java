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
package com.verticon.tracker.reader;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.editor.util.EventAdminTracker;
import com.verticon.tracker.reader.event.connection.ReaderCompletionService;
import com.verticon.tracker.reader.event.connection.RefreshableReader;



/**
 * Controls the plug-in life cycle
 */
public class ReaderPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = 
		"com.verticon.tracker.reader";

	
	// The shared instance
	private static ReaderPlugin plugin;
	private EventAdminTracker tracker;
	private ReaderCompletionService readerCompletionService = null;
	private BundleContext bundleContext;
	

	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(ReaderPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}
	

	/**
	 * The constructor
	 */
	public ReaderPlugin() {
		plugin = this;
	}

	
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		bundleContext = context;
		tracker = new EventAdminTracker(context);
		tracker.open();
		readerCompletionService = new ReaderCompletionService();
	    
		readerCompletionService.start();
		logger.debug(bundleMarker, "Started Bundle");
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		readerCompletionService.stop();
		readerCompletionService = null;
		tracker.close();
		plugin = null;
		bundleContext=null;
		super.stop(context);
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ReaderPlugin getDefault() {
		return plugin;
	}
	
	public EventAdmin getService(){
		return (EventAdmin) tracker.getService();
	}
	
	public String getSymbolicName() {
		return bundleContext.getBundle().getSymbolicName();
	}
	
	public BundleContext getBundleContext() {
		return bundleContext;
	}

	

	protected final Future<RefreshableReader> submit(Callable<RefreshableReader> task){
		return readerCompletionService.submit(task);
	}
	
	public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, int initialDelay, int delay, TimeUnit unit){
    	return readerCompletionService.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

}
