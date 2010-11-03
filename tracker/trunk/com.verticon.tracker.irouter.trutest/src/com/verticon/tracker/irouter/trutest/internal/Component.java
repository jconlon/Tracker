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
package com.verticon.tracker.irouter.trutest.internal;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.monitor.MonitorListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Component implements ManagedServiceFactory {

	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.trutest.internal";
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	private final Logger log = LoggerFactory.getLogger(Component.class);
	private Map<String, Indicator> indicators = null;
	private ExecutorService exec;
	private ScheduledExecutorService scheduler;
	private BundleContext bc;
	private static MonitorListener monitorListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Component [name=" + getName() + "]";
	}

	protected void activate(BundleContext bc) throws Exception {
		this.bc = bc;
		// There will be multiple indicators each running within it's own thread
		exec = Executors.newCachedThreadPool();
		scheduler = Executors.newSingleThreadScheduledExecutor();
		indicators = new HashMap<String, Indicator>();
		log.debug(bundleMarker, "Started");
	}

	protected void deactivate(BundleContext context) throws Exception {
		Collection<Indicator> indicatorInstances = indicators.values();
		for (Indicator indicator : indicatorInstances) {
			indicator.unregisterMonitorable();
			indicator.stop();
		}
		indicators.clear();
		indicators = null;

		exec.shutdownNow();
		exec = null;
		scheduler.shutdownNow();
		scheduler = null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#updated(String,
	 *      Dictionary)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updated(String pid, Dictionary config)
			throws ConfigurationException {
		log.info(bundleMarker, "Updating pid {}", pid);

		Indicator indicator = (Indicator) indicators.get(pid);
		if (indicator == null) {
			indicator = new Indicator(pid, exec, scheduler);
			indicators.put(pid, indicator);
			indicator.registerMonitorable();
		}
		indicator.updated(bc, config);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#deleted(String)
	 */
	@Override
	public void deleted(String pid) {
		log.info(bundleMarker, "Deleting pid {}", pid);
		Indicator indicator = (Indicator) indicators.get(pid);
		if (indicator != null) {
			indicators.remove(pid);
			indicator.stop();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	 */
	@Override
	public String getName() {
		return "Tru-Test Indicator Factory";
	}

	/**
	 * @return the monitorListener
	 */
	public static MonitorListener getMonitorListener() {
		return monitorListener;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	public void setMonitorListener(MonitorListener monitorListener) {
		Component.monitorListener = monitorListener;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	public void unsetMonitorListener(MonitorListener monitorListener) {
		Component.monitorListener = null;
	}
}
