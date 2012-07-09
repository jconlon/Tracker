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
import static com.verticon.tracker.store.mongo.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongo.internal.Utils.validateObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.verticon.tracker.Event;
import com.verticon.tracker.store.StoreAccessException;
import com.verticon.tracker.store.StoreLogonException;
import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.Resource;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;

public class TrackerStoreAdmin implements ITrackerStoreAdmin, Predicate<Event>,
		IMonitorableProvider {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(TrackerStoreAdmin.class);
	private ResourceSetFactoryContext resourceFactory;
	private volatile Resource persistedResource;
	private AtomicReference<Admin> persistedAdmin2 = new AtomicReference<Admin>();
	private final MongoStatusMonitor statusMonitor;
	private static final String USER;
	static {
		StringBuilder currentUserAndHost = new StringBuilder(
				System.getProperty("user.name")).append('@');
		try {
			currentUserAndHost.append(InetAddress.getLocalHost().getHostName());

		} catch (UnknownHostException e) {
			// Should never happen
			e.printStackTrace();
		}
		USER = currentUserAndHost.toString();
	}

	TrackerStoreAdmin(MongoStatusMonitor statusMonitor) {
		super();
		this.statusMonitor = statusMonitor;
		statusMonitor.register(
				StatusAndConfigVariables.MONGO_ADMIN_LOADED.statusVarID, this);
		statusMonitor.register(
				StatusAndConfigVariables.IS_ADMINISTRATOR.statusVarID, this);
		statusMonitor.register(
				StatusAndConfigVariables.IS_PUBLISHER.statusVarID, this);
	}

	/**
	 * 
	 * Only a user on a host that matches the name of the admin can load an
	 * Admin Document.
	 * 
	 * @param admin
	 *            document to load
	 * @throws StoreLogonException
	 *             if an unauthorized user tries to load the document
	 */
	@Override
	public synchronized boolean load(Admin admin) throws IOException {
		checkNotNull(admin, "Admin must not be null.");
		validateObject(admin);
		if (!USER.equals(admin.getAdmin().getName())) {
			throw new StoreAccessException(
					"Can't load this document you are not the admin named in the document.");
		}

		if (persistedAdmin2.get() != null) {
			if (!USER.equals(persistedAdmin2.get().getAdmin().getName())) {
				throw new StoreAccessException(
						"Can't load this document you are not the admin named in the persisted configuration.");
			}
		}

		Admin admiCopy = EcoreUtil.copy(admin);

		resourceFactory.add(admiCopy, Element.ADMIN);
		resourceFactory.save(admiCopy, Element.ADMIN);
		persistedAdmin2.set(admiCopy);
		updateStatus();
		return isAdminLoaded();
	}
	
	private boolean isAdminLoaded(){
		return persistedAdmin2.get()!=null;
	}
	
	@Override
	public String uri() {
		return resourceFactory != null ? resourceFactory.getMongoBaseURI()
				: null;
	}

	@Override
	public synchronized StatusVariable getStatusVariable(String id) {
		switch (StatusAndConfigVariables.instance(id)) {
		case MONGO_ADMIN_LOADED:
			logger.info(bundleMarker,"Returning MongoAdmin Loaded "+isAdminLoaded());
			return new StatusVariable(id, StatusVariable.TYPE_BOOLEAN,
					isAdminLoaded());

		case IS_ADMINISTRATOR:
			return new StatusVariable(id, StatusVariable.TYPE_BOOLEAN,
					isCurrentUserAdmin());

		case IS_PUBLISHER:
			return new StatusVariable(id, StatusVariable.TYPE_BOOLEAN,
					canPublishAnimals());

		}
		return null;
	}

	@Override
	public synchronized boolean resetStatusVariable(String id) {
		switch (StatusAndConfigVariables.instance(id)) {
		case MONGO_ADMIN_LOADED:
			loadAdminFromMongo();
			
			logger.debug(bundleMarker, "Reset adminLoaded now is {}", isAdminLoaded());
			statusMonitor
					.update(getStatusVariable(StatusAndConfigVariables.MONGO_ADMIN_LOADED.statusVarID));
		case IS_ADMINISTRATOR:
		case IS_PUBLISHER:
			return true;
		}
		return false;
	}

	/**
	 * Can an event be read from this premises?
	 * 
	 * @param event
	 * @return true if the event can be read
	 */
	@Override
	public synchronized boolean apply(Event event) {
		boolean result = true;
		if (persistedResource == null) {
			loadAdminFromMongo();
			loadResourceElementForInstanceURI();
		}

		if (persistedResource != null) {
			if (!Strings.isNullOrEmpty(event.getPid())) {
				result = persistedResource.canAccess(event.getPid());
			}
		}
		return result;
	}

	synchronized void activate(ResourceSetFactoryContext resourceFactory) {
		this.resourceFactory = resourceFactory;
		loadAdminFromMongo();
		if (isAdminLoaded()) {
			logger.debug(bundleMarker, "Activated with loaded Admin");

		} else {
			logger.debug(bundleMarker, "Activated without an Admin");

		}
	}

	@Override
	public synchronized boolean isCurrentUserAdmin() {
		loadAdminFromMongo();
		if (!isAdminLoaded()) {
			return true;
		}
		return USER.equals(persistedAdmin2.get().getAdmin().getName());
	}
	
	synchronized boolean isValidUri(String uri) {
		
		if (isAdminLoaded()) {
			for (Resource candidatePresistedResource : persistedAdmin2.get().getResource()) {
				if (uri.equals(
						candidatePresistedResource.getUri())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	private void updateStatus() {
		statusMonitor
				.update(getStatusVariable(StatusAndConfigVariables.MONGO_ADMIN_LOADED.statusVarID));
		statusMonitor
				.update(getStatusVariable(StatusAndConfigVariables.IS_ADMINISTRATOR.statusVarID));
		statusMonitor
				.update(getStatusVariable(StatusAndConfigVariables.IS_PUBLISHER.statusVarID));

	}

	/**
	 * Can the user publish to the uri they are connected to?
	 * Yes - If there is no loaded admin document or 
	 * there is one and the resource has the same uri as the 
	 * connection
	 * 
	 * @throws StoreLogonException
	 * @throws UnknownHostException
	 */
	private boolean canPublishAnimals() {
		loadResourceElementForInstanceURI();
		if (persistedResource != null) {
			if (!USER.equals(persistedResource.getPublisher().getName())) {
				return false;
			}

		}
		return true;
	}

	private void loadResourceElementForInstanceURI() {
		persistedResource = null;
		if (isAdminLoaded()) {
			for (Resource candidatePresistedResource : persistedAdmin2.get().getResource()) {
				if (resourceFactory.getPremisesUri().equals(
						candidatePresistedResource.getUri())) {
					this.persistedResource = candidatePresistedResource;
					break;
				}
			}
		}
	
	}

	private void loadAdminFromMongo() {
	    persistedAdmin2.set(null);
		org.eclipse.emf.ecore.resource.Resource resource = resourceFactory
				.getResource(Element.ADMIN, "1");
		logger.debug(bundleMarker, "Loading Admin from {}",resource.getURI());
		if (!resource.getContents().isEmpty()) {
			persistedAdmin2.set((Admin) resource.getContents().get(0));
			assert(isAdminLoaded());
		}
		
	}

}
