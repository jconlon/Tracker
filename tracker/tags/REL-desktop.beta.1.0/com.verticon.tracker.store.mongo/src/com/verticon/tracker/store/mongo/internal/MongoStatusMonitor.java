/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongo.internal;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoStatusMonitor implements Monitorable {

	// config
	private Map<String, Object> config;
	private String status = "NOT Connected";
	private MonitorListener monitorListener;
	private final AtomicLong lastUpdate = new AtomicLong(0);
	private final AtomicInteger totalAnimalsUpdated = new AtomicInteger(0);
	private final AtomicInteger totalAnimalsAdded = new AtomicInteger(0);
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalAnimalsProcessed = new AtomicInteger(0);
	private final AtomicInteger totalProductsConsumed = new AtomicInteger(0);
	private final Map<String, IMonitorableProvider> providers = newHashMap();

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MongoStatusMonitor.class);

	@Override
	public String[] getStatusVariableNames() {
		return StatusAndConfigVariables.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		logger.debug("Getting var {}", id);

		if (providers.containsKey(id)) {
			return providers.get(id).getStatusVariable(id);
		}

		return StatusAndConfigVariables.getStatusVariable(id, config, status,
				lastUpdate, totalAnimalsUpdated, totalAnimalsAdded,
				totalAnimalsProcessed, producersConnected,totalProductsConsumed);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return StatusAndConfigVariables.instance(id).notifiesOnChange;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		switch (StatusAndConfigVariables.instance(id)) {
		case NEW_ANIMALS_ADDED:
			totalAnimalsAdded.set(0);
			return true;
		case TOTAL_ANIMALS_PROCESSED:
			totalAnimalsProcessed.set(0);
			return true;
		case PRODUCTS_CONSUMED:
			totalProductsConsumed.set(0);
			return true;
		case UPDATED_ANIMALS:
			totalAnimalsUpdated.set(0);
			return true;
		default:
			if (providers.containsKey(id)) {
				return providers.get(id).resetStatusVariable(id);
			}
			return false;
		}

	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return StatusAndConfigVariables.instance(id).description;
	}

	void activate(Map<String, Object> config) {
		this.config = config;
	}

	void deactivate() {
		providers.clear();
	}

	void update(StatusVariable statusVariable) {
		if (monitorListener != null) {
			monitorListener.updated((String) config.get("service.pid"),
					statusVariable);

		}
	}

	/**
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = monitorListener;
	}

	/**
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = null;
	}

	void incrementTotalAnimalsAdded() {
		totalAnimalsAdded.getAndIncrement();
		logger.debug(bundleMarker, "animalSaves={}", totalAnimalsAdded.get());
	}
	
	void incrementTotalProductsConsumed() {
		totalProductsConsumed.getAndIncrement();
		logger.debug(bundleMarker, "productsConsumed={}", totalProductsConsumed.get());
	}

	void incrementTotalAnimalsUpdated() {
		int initial = totalAnimalsUpdated.getAndIncrement();
		logger.debug(bundleMarker, "Incrementing animals updated initialAnimalUpdates={} after increment animalUpdates={}",
				initial, totalAnimalsUpdated.get());
	}

    void addTotalAnimalsProcessed(Integer animalsProcessed) {
		totalAnimalsProcessed.addAndGet(animalsProcessed);
		logger.debug(bundleMarker, "animalProcessed={}", animalsProcessed);
	}

	void setLastUpdate(Long newValue) {
		lastUpdate.set(newValue);
	}

	void setStatus(String s) {
		status = s;
		logger.debug(Utils.bundleMarker, "Status: {}", status);
	}

	void setProducersConnected(Integer i) {
		producersConnected.set(i);
	}

	void register(String id, IMonitorableProvider provider) {
		providers.put(id, provider);
	}

}
