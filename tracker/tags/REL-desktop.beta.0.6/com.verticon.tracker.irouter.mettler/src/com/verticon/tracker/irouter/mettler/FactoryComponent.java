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
package com.verticon.tracker.irouter.mettler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.osgi.service.monitor.MonitorListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class FactoryComponent implements ManagedServiceFactory {

	protected static String PLUGIN_ID = "com.verticon.tracker.irouter.mettler";
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	private final Logger log = LoggerFactory.getLogger(FactoryComponent.class);
	private Map<String, Balance> balances = null;
	private ExecutorService exec;
	private BundleContext bc;
	private static MonitorListener monitorListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FactoryComponent [name=" + getName() + "]";
	}

	protected void activate(BundleContext bc) throws Exception {
		this.bc = bc;
		// There will be multiple balances each running within it's own thread
		exec = Executors.newCachedThreadPool();
		balances = new HashMap<String, Balance>();
		log.debug(bundleMarker,"Started");
	}

	protected void deactivate(BundleContext context) throws Exception {
		Collection<Balance> balanceInstances = balances.values();
		for (Balance balance : balanceInstances) {
			balance.stop();
		}
		balances.clear();
		balances = null;

		exec.shutdown();
		exec = null;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#deleted(String)
	 */
	@Override
	public void deleted(String pid) {
		Balance balance = (Balance) balances.get(pid);
		if (balance != null) {
			balances.remove(pid);
			balance.stop();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	 */
	@Override
	public String getName() {
		return "Weight Measurement Producer Factory";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.cm.ManagedServiceFactory#updated(java.lang.String,
	 * java.util.Dictionary)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updated(String pid, Dictionary config)
			throws ConfigurationException {
		log.info(bundleMarker,"Updating pid {}", pid);

		Balance balance = (Balance) balances.get(pid);
		if (balance == null) {
			balance = new Balance(pid, config, exec);
			balances.put(pid, balance);
		}
		balance.updated(bc, config);
	}

	/**
	 * @return the monitorListener
	 */
	public static MonitorListener getMonitorListener() {
		return monitorListener;
	}

	
	/**
	 * @param monitorListener the monitorListener to set
	 */
	public void setMonitorListener(MonitorListener monitorListener) {
		FactoryComponent.monitorListener = monitorListener;
	}
	
	/**
	 * @param monitorListener the monitorListener to set
	 */
	public void unsetMonitorListener(MonitorListener monitorListener) {
		FactoryComponent.monitorListener = null;
	}

}
