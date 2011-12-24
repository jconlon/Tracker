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
package com.verticon.tracker.irouter.bwcontrol;

import static com.google.common.base.Preconditions.checkState;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;

/**
 * @author jconlon
 * 
 * TODO add a Flavor to restrict to receive only Envelopes
 */
public class Component implements Consumer, Producer, Monitorable {

	static final String PLUGIN_ID = "com.verticon.tracker.irouter.bwcontrol";
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	private final Logger logger = LoggerFactory.getLogger(Component.class);

	private Map<String, Object> config = null;
	private BWConsumer consumer = null;
	private BWProducer producer = null;
	private BlockingQueue<String> commandQueue = new LinkedBlockingQueue<String>();
	private ScheduledExecutorService scheduler = null;
	private ExecutorService exec = null;
	

	/**
	 * @return the scheduler
	 */
	public ScheduledExecutorService getScheduler() {
		return scheduler;
	}

	/**
	 * @return the commandQueue
	 */
	public BlockingQueue<String> getCommandQueue() {
		return commandQueue;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		logger.debug(bundleMarker, "{} activating properties={}", this, config);
		scheduler=Executors.newSingleThreadScheduledExecutor();
		consumer = new BWConsumer(this);
		producer = new BWProducer(this);
		exec=Executors.newSingleThreadExecutor();
		exec.submit(producer);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		logger.debug(bundleMarker, "deactivating {}", this);
		scheduler.shutdownNow();
		exec.shutdownNow();
		this.config.clear();
		exec=null;
		consumer = null;
		producer = null;
		scheduler = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#polled(org.osgi.service.wireadmin
	 * .Wire)
	 */
	@Override
	public Object polled(Wire wire) {
		return producer.polled(wire);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#consumersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		producer.consumersConnected(wires);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 * .Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object value) {
		consumer.updated(wire, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#producersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void producersConnected(Wire[] wires) {
		consumer.producersConnected(wires);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.monitor.Monitorable#getStatusVariableNames()
	 */
	@Override
	public String[] getStatusVariableNames() {
		return ObjectArrays.concat(
				consumer.getStatusVariableNames(),
				producer.getStatusVariableNames(), String.class
				);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#getStatusVariable(java.lang.String)
	 */
	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return id.startsWith("producer.")? producer.getStatusVariable(id):
			consumer.getStatusVariable(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#notifiesOnChange(java.lang.String)
	 */
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return id.startsWith("producer.")? producer.notifiesOnChange(id):
			consumer.notifiesOnChange(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#resetStatusVariable(java.lang.String
	 * )
	 */
	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return id.startsWith("producer.")? producer.resetStatusVariable(id):
			consumer.resetStatusVariable(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#getDescription(java.lang.String)
	 */
	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return id.startsWith("producer.")? producer.getDescription(id):
			consumer.getDescription(id);
	}


	String getPid() {
		return config != null ? (String) config.get("service.pid") : "null";
	}
	
	String getConfigurationString(String key) {
		checkState(!Strings.isNullOrEmpty((String) config.get(key)),
				key + " attribute can not be null or empty");
		return (String)config.get( key);
	}

	Double getConfigurationDouble(String key) {
		checkState(config.get(key)!=null,
				key + " attribute can not be null");
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Double((String)conf);
		}
		return (Double)conf;
	}
	
	String[] getConfigurationArray(String key) {
		checkState(config.get(key)!=null,
				key + " attribute can not be null");
		Object conf = config.get( key);
		if(conf instanceof String){
			return ((String)conf).split(",");
		}
		return (String[])conf;
	}

	Integer getConfigurationInteger(String key) {
		checkState(config.get(key)!=null,
				key + " attribute can not be null");
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Integer((String)conf);
		}
		return (Integer)conf;
	}
	
	Boolean getConfigurationBoolean(String key) {
		checkState(config.get(key)!=null,
				key + " attribute can not be null");
		Object conf = config.get( key);
		if(conf instanceof String){
			return Boolean.valueOf((String)conf);
		}
		return (Boolean)conf;
	}

	 Long getConfigurationLong(String key) {
		 checkState(config.get(key)!=null,
					key + " attribute can not be null");
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Long((String)conf);
		}
		return (Long)conf;
	}


}
