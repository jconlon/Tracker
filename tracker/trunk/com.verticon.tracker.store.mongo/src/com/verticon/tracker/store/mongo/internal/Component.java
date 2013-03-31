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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_BI;
import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;
import static com.verticon.tracker.store.mongo.internal.StatusAndConfigVariables.PREMISES_URI;
import static com.verticon.tracker.store.mongo.internal.StatusAndConfigVariables.PROVIDED_COLLECTION;
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import com.verticon.mongo.MongoDBCollectionProvider;
import com.verticon.mongo.emf.api.IResourceSetFactory;
import com.verticon.mongo.emf.api.SingleMongoLocator;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.StoreLogonException;

/**
 * 
 * Declarative Services component that delegates implementations and adds user
 * administration. <br>
 * <br>
 * <ul>
 * <li>
 * Authenticated users can retrieve animals.</li>
 * <li>
 * Members of the <b>current premises</b> can retrieve the premises and can
 * record animals</li>
 * <li>
 * Members of the <B>TrackerRetrieveGlobal</B> group can retrieve any premises
 * and do generic queries.</li
 * <li>
 * Members of the <B>TrackerRegisterPremises</B> group can register premises.</li>
 * </ul>
 * 
 * 
 * @author jconlon
 * 
 */
public class Component implements ITrackerStore, Consumer, Monitorable,
		MongoDBCollectionProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	// Provided services
	private final MongoStatusMonitor statusMonitor = new MongoStatusMonitor();
	private final MongoConsumer tagConsumer;
	private final TrackerStore trackerStore;

	// DS Injected dependencies
	private IResourceSetFactory resourceSetFactory;
	private Authenticator authenticator;


	// Created from configuration
	protected final SingleMongoLocator mongoLocator;
	private DBCollection providedCollection;

	public Component() {
		super();
		this.tagConsumer = new MongoConsumer(statusMonitor);
		this.trackerStore = new TrackerStore(statusMonitor, tagConsumer);
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

	/**
	 * Members of the <b>current premises</b> group can record animal records
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#recordAnimals(com.verticon.tracker.Premises)
	 */
	@Override
	public int recordAnimals(Premises premises) throws IOException {
		checkHasRole(premises);
		return trackerStore.recordAnimals(premises);

	}


	/**
	 * Authenticated users can retrieve animals.
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#retrieveAnimal(java.lang.String)
	 */
	@Override
	public Animal retrieveAnimal(String ain) {
		checkAuthenticated();
		return trackerStore.retrieveAnimal(ain);
	}

	/**
	 * Members of the <B>TrackerRegisterPremises</B> group can register
	 * premises.
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#register(com.verticon.tracker
	 *      .Premises)
	 */
	@Override
	public void register(Premises premises) throws IOException {
		checkNotNull(premises, "Premises must not be null.");
		checkForRegistratonMembership();
		trackerStore.register(premises);
	}


	/**
	 * 
	 * Members of the <b>current premises</b> can retrieve the premises, and
	 * Members of the <B>TrackerRetrieveGlobal</B> group can retrieve any
	 * premises
	 * 
	 * The animals in this uri may have had events published by other Premises
	 * if the user does not have the authority to see these events, these events
	 * will be omitted from the animals in this premises document.
	 * 
	 * @see #filterEventsByAuthorityToAccessPID
	 * @see com.verticon.tracker.store.ITrackerStore#retrievePremises(String,
	 *      String, String)
	 */
	@Override
	public Premises retrievePremises(String uri, String fromDate, String toDate)
			throws IOException {
		checkIsAssociated(uri);
		return trackerStore.retrievePremises(uri, fromDate, toDate);
	}

	/**
	 * Members of the <B>TrackerRetrieveGlobal</B> group can make a generic
	 * query
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#query(org.eclipse.emf.ecore.EClass,
	 *      java.lang.String)
	 */
	@Override
	public EList<EObject> query(EClass eClass, String query) {
		checkRetrieveGlobalMembership(null);
		return trackerStore.query(eClass, query);
	}

	/**
	 * Location services is using this method for name resolutions.
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#retrievePremises(java.lang.String)
	 */
	@Override
	public Premises retrievePremises(String uri) throws IOException {
		checkNotNull(uri, "Premises uri must not be null.");
		checkAuthenticated();
		return trackerStore.retrievePremises(uri);
	}

	/**
	 * Members of the <b>current premises</b> can retrieve the premises, and
	 * Members of the <B>TrackerRetrieveGlobal</B> group can retrieve any
	 * premises
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#retrievePremises(com.verticon.tracker.store.ITrackerStore.LongLatPoint)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		Premises premises = trackerStore.retrievePremises(point);
		checkIsAssociated(premises.getUri());
		return premises;
	}

	/**
	 * Members of the <b>current premises</b> can retrieve the premises, and
	 * Members of the <B>TrackerRetrieveGlobal</B> group can retrieve any
	 * premises
	 * 
	 * @see com.verticon.tracker.store.ITrackerStore#retrievePremises(com.verticon.tracker.store.ITrackerStore.LongLatPoint,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point, String in, String out)
			throws IOException {
		Premises premises = trackerStore.retrievePremises(point, in, out);
		checkIsAssociated(premises.getUri());
		return premises;
	}

	@Override
	public String uri() {
		return trackerStore.uri();
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
	 * @param authenticator
	 *            the authenticator to set
	 */
	void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param authenticator
	 *            the authenticator to set
	 */
	void unsetAuthenticator(Authenticator authenticator) {
		this.authenticator = null;
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

		Integer defaultAnimalKey = Utils.getConfigurationInteger(config
				.get(StatusAndConfigVariables.DEFAULT_ANIMAL.configID));

		ResourceSetFactoryContext resourceFactory = ResourceSetFactoryContext
				.instance(resourceSetFactory, mongoLocator,
						getPremisesURI(config));
		try {
			DB db = mongoLocator.getTrackerDatabase();
			ensureIndexes(db);
			this.providedCollection = getProvidedCollectionName(config) != null ? db
					.getCollection(getProvidedCollectionName(config)) : db
					.getCollection("useradmin");

			tagConsumer.activate(defaultAnimalKey, resourceFactory, db);
			trackerStore.activate(resourceFactory, getPremisesURI(config), db,
					filterEventsByAuthorityToAccessPID);
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
	 * Some events may be published by Premises that are not visible for this
	 * user. Filter these out.
	 * 
	 */
	private final Predicate<Event> filterEventsByAuthorityToAccessPID = new Predicate<Event>() {
		@Override
		public boolean apply(Event event) {
			boolean result = true;
			String pid = event.getPid();
			if (!Strings.isNullOrEmpty(pid)) {
				result = authenticator.isAssociatedWith(pid);
			}

			return result;
		}
	};

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		tagConsumer.deactivate();
		trackerStore.deactivate();
	}

	private void checkAuthenticated() {
		boolean allowed = authenticator != null
				&& authenticator.isAuthenticatedUser();
		if (!allowed) {
			throw new SecurityException("User is not authenticated.");
		}
	}

	/**
	 * Members of the <B>TrackerRegisterPremises</B> group can register
	 * premises.
	 */
	private void checkForRegistratonMembership() {
		checkAuthenticated();
		if (!authenticator.hasRole(TRACKER_STORE_REGISTRANT)) {
			throw new SecurityException(
					"User has no authority to register this premises.");
		}
	}

	private void checkHasRole(Premises premises) {
		checkNotNull(premises, "Premises must not be null.");
		checkHasRole(premises.getUri());
	}

	private void checkHasRole(String uri) {
		checkNotNull(uri, "Premises uri must not be null.");
		checkAuthenticated();
		if (!authenticator.hasRole(uri)) {
			throw new SecurityException(
String.format(
					"User has no role authority to access %s premises.", uri));
		}
	}

	/**
	 * Must be authenticated and in a common association.
	 */
	private void checkIsAssociated(String target) {
		checkNotNull(target, "Target argument must not be null. ");
		checkAuthenticated();
		if (!authenticator.isAssociatedWith(target)) {
			throw new SecurityException(
					String.format(
					"User has no association authority to access %s premises.",
							target));
		}
	}

	/**
	 * Must be authorized and in the premises, or authorized and in the global
	 * retrieve group
	 */
	private void checkRetrieveGlobalMembership(String uri) {
		checkAuthenticated();
		boolean allowed = uri != null ? authenticator.hasRole(uri) : false;
		if (allowed) {
			return;
		}

		if (!authenticator.hasRole(TRACKER_STORE_BI)) {
			throw new SecurityException(
					uri != null ? "User has no authority to retrieve this premises."
							: "User has no authority to perform a generic query.");
		}
	}
	private void ensureIndexes(DB db) throws UnknownHostException,
			StoreLogonException {
		// Ensure indexes on the collections
		for (Element e : Element.values()) {
			e.ensureIndex(db);
		}

	}

	private static String getPremisesURI(Map<String, Object> config) {
		return (String) config.get(PREMISES_URI.configID);
	}

	private static String getProvidedCollectionName(Map<String, Object> config) {
		return (String) config.get(PROVIDED_COLLECTION.configID);
	}

	@Override
	public DBCollection getCollection() {
		return providedCollection;
	}


}
