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
package com.verticon.tracker.irouter.gateway.internal;

import static com.verticon.tracker.common.EventAdminConstant.IROUTER_PAYLOAD;
import static com.verticon.tracker.irouter.gateway.internal.bundle.LogBundleMarker.bundleMarker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.framework.Constants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.common.MeasurementTransaction;

public class TransactionEventHandler implements EventHandler {

	private static final String TRACKER_EDITING_DOMAIN = 
		"com.verticon.transaction.editor.TrackerEditingDomain";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TransactionEventHandler.class);

	/**
	 * Get the animal from the event and publish it.
	 */
	public void handleEvent(org.osgi.service.event.Event event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(TRACKER_EDITING_DOMAIN);
		if (domain == null) {
			logger.error(bundleMarker, "Can't find the EditingDomain");
			return;
		}

		handleIRouterPayload(event, domain);

	}

	private void handleIRouterPayload(org.osgi.service.event.Event event,
			TransactionalEditingDomain domain) {
		String source = (String) event
				.getProperty(Constants.BUNDLE_SYMBOLICNAME);// EVENT_ADMIN_PROPERTY_SOURCE);
		Object payload = event.getProperty(IROUTER_PAYLOAD.toProp());
		if (payload == null) {
			logger.error(bundleMarker, "No payload from iRouter component={}",
					source);
			return;
		}
		if (!(payload instanceof MeasurementTransaction)) {
			logger.error(bundleMarker,
					"Unsupported payload from iRouter component={}", source);
			return;
		}
		MeasurementTransaction transaction = (MeasurementTransaction) payload;
		addTransactionToDomain(source, domain, transaction);

	}

	/**
	 * Handle an event
	 * 
	 * @param source
	 * @param domain
	 * @param event
	 * @param id
	 */
	private void addTransactionToDomain(String source,
			TransactionalEditingDomain domain,
			MeasurementTransaction transaction) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				logger.debug(bundleMarker, "Processing {}", resource.toString());
			}
			addTransactionToResource(source, domain, resource, transaction);

		}
	}

	private void addTransactionToResource(final String source,
			final TransactionalEditingDomain domain, final Resource resource,
			final MeasurementTransaction transaction) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					Animal animal = premises.findAnimal(transaction.getId());

					if (animal == null) {
						logger.warn(
								bundleMarker,
								"The Premises in resource {} contained no animal with id = {}",
								resource.toString(), transaction.getId());
						return;
					}

					Event trackerEvent = null;
					try {
						trackerEvent = MeasurementTransactionUtils.createEvent(
								animal.activeTag(), transaction);
					} catch (EventCreationException e) {
						logger.error(bundleMarker, "Failed to create event", e);
						return;
					}
					if (trackerEvent == null) {
						logger.error(bundleMarker,
								"MeasurementTransactionUtils.createEvent returned a null event.");
						return;
					}
					addEventToAnimal(trackerEvent, source, animal);
				} else {
					logger.warn(bundleMarker,
							"Resource {} contained no premises to process",
							resource.toString());
				}
			}
		});

	}

	private void addEventToAnimal(Event event, String source, Animal animal) {

		animal.activeTag().getEvents().add(event);

		logger.info(bundleMarker, "{} added {}, to animal {}, ", new Object[] {
				source, simpleName(event), animal.getId() });
	}

	private static final String simpleName(Event event) {
		String name = event.getClass().getSimpleName();
		return name.substring(0, name.indexOf("Impl"));
	}

}
