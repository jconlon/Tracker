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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.tracker.store.mongo.internal.StatusAndConfigVariables.MONGO_URI;
import static com.verticon.tracker.store.mongo.internal.StatusAndConfigVariables.PREMISES_URI;
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongo.internal.Utils.ensureGeoLocationIndex;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.mongo.emf.api.IResourceSetFactory;
import com.verticon.mongo.emf.api.SingleMongoLocator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.StoreLogonException;
import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;

/**
 * 
 * Declarative Services component that delegates implementations.
 * 
 * @author jconlon
 * 
 */
public class Component implements ITrackerStore, Consumer, Monitorable,
		ITrackerStoreAdmin {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	//Provided services
	private final MongoStatusMonitor statusMonitor = new MongoStatusMonitor();
	private final MongoConsumer tagConsumer;
	private final TrackerStore trackerStore;
	private final TrackerStoreAdmin trackerStoreAdmin;

	// DS Injected dependencies
	private IResourceSetFactory resourceSetFactory;
	
	// Created from configuration
	private SingleMongoLocator mongoLocator;


	public Component() {
		super();
		this.tagConsumer = new MongoConsumer(statusMonitor);
		this.trackerStore = new TrackerStore(statusMonitor, tagConsumer);
		this.trackerStoreAdmin = new TrackerStoreAdmin(statusMonitor);
		this.mongoLocator = new SingleMongoLocator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin
	 * .Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object in) {
		tagConsumer.updated(wire, in);
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
		tagConsumer.producersConnected(wires);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.service.monitor.Monitorable#getStatusVariableNames()
	 */
	@Override
	public String[] getStatusVariableNames() {
		return statusMonitor.getStatusVariableNames();
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
		return statusMonitor.getStatusVariable(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#notifiesOnChange(java.lang.String)
	 */
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return statusMonitor.notifiesOnChange(id);
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
		return statusMonitor.resetStatusVariable(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.monitor.Monitorable#getDescription(java.lang.String)
	 */
	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return statusMonitor.getDescription(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#update(com.verticon.agriculture
	 * .Location)
	 */
	@Override
	public void register(Location location) throws IOException {
		trackerStore.register(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#recordAnimals(com.verticon.tracker
	 * .Premises)
	 */
	@Override
	public int recordAnimals(Premises premises) throws IOException {
		return trackerStore.recordAnimals(premises);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrieveAnimal(java.lang.String)
	 */
	@Override
	public Animal retrieveAnimal(String ain) {
		return trackerStore.retrieveAnimal(ain);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrieveLocation(java.lang.String
	 * )
	 */
	@Override
	public Location retrieveLocation(String id) {
		return trackerStore.retrieveLocation(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrievePremises(java.lang.String
	 * )
	 */
	@Override
	public Agriculture retrieveLocations(Set<String> uris) {
		return trackerStore.retrieveLocations(uris);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.store.ITrackerStore#retrieveAnimals(java.lang.String
	 * , java.util.Date, java.util.Date)
	 */
	@Override
	public Premises retrievePremises(String uri, String fromDate, String toDate)
			throws ParseException {
		return trackerStore.retrievePremises(uri, fromDate, toDate);
	}

	@Override
	public EList<EObject> query(EClass eClass, String query) {
		return trackerStore.query(eClass, query);
	}

	@Override
	public boolean load(Admin admin) throws IOException {
		return trackerStoreAdmin.load(admin);
	}
	
	@Override
	public boolean isCurrentUserAdmin() {
		return trackerStoreAdmin.isCurrentUserAdmin();
	}


	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}
	
	/**
	 * Declaratives Services service injection
	 * 
	 * @param resourceSetFactory
	 *            the resourceSetFactory to set
	 */
	void setResourceSetFactory(IResourceSetFactory resourceSetFactory) {
		this.resourceSetFactory = resourceSetFactory;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to unset
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}
	
	/**
	 * Declaratives Services service injection
	 * 
	 * @param resourceSetFactory
	 *            the resourceSetFactory to unset
	 */
	void unsetResourceSetFactory(IResourceSetFactory resourceSetFactory) {
		this.resourceSetFactory = null;
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 */
	void activate(Map<String, Object> config) throws IOException {
		logger.debug(bundleMarker, "activating with config={}", config);
		statusMonitor.activate(config);
		try {
			mongoLocator.configure(config);
		} catch (MongoException e1) {
			throw e1;
		} catch (URISyntaxException e1) {
			throw new IOException(e1);
		}
		
//		URI mongoURI = URI.createURI((String) config.get(MONGO_URI.configID));
//
//		checkNotNull(mongoURI, "Mongo Connection URI must not be null");
//		URI mongouri = mongoURI;
//		checkArgument(!Strings.isNullOrEmpty(mongouri.scheme()),
//				"%s must start with mongo://", mongoURI);
//		checkArgument(mongouri.scheme().equals("mongo"),
//				"%s must start with mongo://", mongoURI);
//		checkNotNull(mongoURI, "The hostname in the  URI must not be null");
//
//		checkArgument(!Strings.isNullOrEmpty(getPremisesURI(config)),
//				"Premises URI must not be null.");

		

		Integer defaultAnimalKey = Utils.getConfigurationInteger(config
				.get(StatusAndConfigVariables.DEFAULT_ANIMAL.configID));
		
		ResourceSetFactoryContext resourceFactory = ResourceSetFactoryContext.instance(resourceSetFactory,mongoLocator,
				getPremisesURI(config)
		);
		try {
//			DB db = connect(resourceFactory);
			DB db = mongoLocator.getTrackerDatabase();
			ensureIndexes(db);
			trackerStoreAdmin.activate(resourceFactory);
			tagConsumer.activate(defaultAnimalKey, resourceFactory, db);
			trackerStore.activate(resourceFactory, getPremisesURI(config), db,
					trackerStoreAdmin);
			Date lastUpdateDate = Utils.getLastUpdate(getPremisesURI(config),
					db);
			Long time = lastUpdateDate == null ? 0 : lastUpdateDate.getTime();
			statusMonitor.setLastUpdate(time);
			statusMonitor.setStatus("Connected " + new Date());
			logger.debug(bundleMarker, "Activated");
		} catch (IOException e) {
			statusMonitor.setStatus(e.toString());
			logger.error(bundleMarker, "failed to activate.", e);
			throw e;
		}

	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		tagConsumer.deactivate();
		trackerStore.deactivate();
	}

	private void ensureIndexes(DB db)
			throws UnknownHostException, StoreLogonException {
		
		// Ensure indexes on the collections
		for (Element e : Element.values()) {
			e.ensureIndexForIDAttribute(db);
		}
		ensureGeoLocationIndex(db);
		
	}

	private static String getPremisesURI(Map<String, Object> config) {
		return (String) config.get(PREMISES_URI.configID);
	}


	

}
