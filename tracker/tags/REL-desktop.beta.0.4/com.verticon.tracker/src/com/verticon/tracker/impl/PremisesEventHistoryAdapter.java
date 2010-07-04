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
package com.verticon.tracker.impl;

import static com.verticon.tracker.TrackerPlugin.bundleMarker;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

/**
 * Implements the Premises eventHistory method. Works 
 * with similar EventHistoryAdapter on each Animal child element to 
 * maintain an active list of references to all events. 
 * @author jconlon
 *
 */
public class PremisesEventHistoryAdapter extends AdapterImpl implements
		EventHistory {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(PremisesEventHistoryAdapter.class);
	private final EList<Event> events = new BasicEList<Event>();

	/**
	 * Premises that is being adapted
	 */
	private Premises premises = null;
	private Adapter forwardingAdapter = null;

	public PremisesEventHistoryAdapter() {
		super();

	}

	public synchronized EList<Event> eventHistory() {
		if (premises.getAnimals().isEmpty()) {
			events.clear();
		} else if (events.isEmpty()) {
			logger.debug(bundleMarker,"Building events from scratch");
			for (Animal animal : premises.getAnimals()) {
				events.addAll(animal.eventHistory());
			}
		}
		return ECollections.unmodifiableEList(events);
	}

	public synchronized void setForwarding(Adapter adapter) {
		logger.debug(bundleMarker,"Setting forwarding to adapter={} on={}", adapter, this);
		this.forwardingAdapter = adapter;
	}

	@Override
	public synchronized void notifyChanged(Notification notification) {
		if (notification.isTouch()) {
			return;
		}

		// find out the type of the notifier - AnimalEventHistoryAdapter,
		// Animal, Premises
		Object notifier = notification.getNotifier();
		if (notifier instanceof EventHistory) {
			handleEventHistoryNotification(notification);
		} else if (notifier instanceof Premises) {
			handlePremisesNotification(notification);
		} else {
			logger.error(bundleMarker,"BaseHandler: Did not handle {} from {}",
					notification, notifier);
		}

	}

	/**
	 * Set the animal before calling calling super.
	 */
	@Override
	public synchronized void setTarget(Notifier target) {
		if (premises == null && target instanceof Premises) {
			premises = (Premises) target;
		}
		super.setTarget(target);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == EventHistory.class;
	}
	
	/**
	 * Handles all notifications from EventHistory notifiers
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	private void handleEventHistoryNotification(Notification n) {
		switch (n.getEventType()) {

		case Notification.ADD:
			Event event = (Event) n.getNewValue();
			if (events.contains(event)) {

			} else {
				events.add(event);
				logger.debug(bundleMarker,"{} added ", event.getClass().getSimpleName());
				forward(n);
			}
			break;

		case Notification.ADD_MANY:
			EList<Event> eventsToAdd = (EList<Event>) n.getNewValue();
			if (events.addAll(eventsToAdd)) {
				logger.debug(bundleMarker,"Added {} events", eventsToAdd.size());
				forward(n);
			}
			break;

		case Notification.REMOVE_MANY:
			EList<Event> eventsToRemove = (EList<Event>) n.getOldValue();
			if (events.removeAll(eventsToRemove)) {
				logger.debug(bundleMarker,"Removed {} events", eventsToRemove.size());
				forward(n);
			}
			break;

		case Notification.REMOVE:
			Event eventToRemove = (Event) n.getOldValue();
			if (events.contains(eventToRemove)) {
				events.remove(eventToRemove);
				logger.debug(bundleMarker,"{} removed from events", eventToRemove.getClass()
						.getSimpleName());
				forward(n);
			} else {
				logger.warn(bundleMarker,"{} already removed from events", eventToRemove
						.getClass().getSimpleName());
			}

			break;

		default:
			
			break;
		}

	}

	
	/**
	 * Notifications from Premises
	 * 
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	private void handlePremisesNotification(Notification n) {
		EList<Event> eventsChanged = null;
		switch (n.getFeatureID(Premises.class)) {
		case TrackerPackage.PREMISES__ANIMALS:
			switch (n.getEventType()) {
			case Notification.ADD:
				Animal animal = (Animal) n.getNewValue();
				eventsChanged = animal.eventHistory();
				if (events.addAll(eventsChanged)) {
					logger.debug(bundleMarker,"Animal {} added one or more events", animal
							.getId());
					forwardAdd(eventsChanged);
				}
				break;
			case Notification.ADD_MANY:
				EList<Animal> animalsToAdd = (EList<Animal>) n.getNewValue();
				eventsChanged = new BasicEList<Event>();
				for (Animal animalToAdd : animalsToAdd) {
					eventsChanged.addAll(animalToAdd.eventHistory());

				}
				if (events.addAll(eventsChanged)) {
					logger.debug(bundleMarker,"{} animals added one or more events",
							animalsToAdd.size());
					forwardAdd(eventsChanged);
				}
				break;
			case Notification.REMOVE:
				animal = (Animal) n.getOldValue();
				eventsChanged = animal.eventHistory();

				if (events.removeAll(animal.eventHistory())) {
					logger.debug(bundleMarker,"Animal {} removed {} events", animal.getId(),
							eventsChanged.size());
					forwardRemove(eventsChanged);
				}

				break;

			case Notification.REMOVE_MANY:
				EList<Animal> tagsToRemove = (EList<Animal>) n.getOldValue();
				eventsChanged = new BasicEList<Event>();
				for (Animal animalToRemove : tagsToRemove) {
					eventsChanged.addAll(animalToRemove.eventHistory());
				}

				if (events.removeAll(eventsChanged)) {
					logger.debug(bundleMarker,"Several animals removed {} events",
							eventsChanged.size());
				}
				break;
			default:
				logger.error(bundleMarker,"Did not handle Premises {}", n);
				break;
			}

		default:
			break;
		}

	}

	

	private void forward(Notification n) {
		if (forwardingAdapter == null) {
			logger.debug(bundleMarker,"Forwarding adapter for {} is null {}", this, this.forwardingAdapter);
		} else {
			forwardingAdapter.notifyChanged(n);
		}
	}

	private void forwardAdd(EList<Event> eventsToAdd) {
		forward(new NotificationWrapper(
				this, 
				new NotificationImpl(Notification.ADD_MANY, null, eventsToAdd))
		);
	}

	private void forwardRemove(EList<Event> eventsToRemove) {
		forward(new NotificationWrapper(
				this,
				new NotificationImpl(Notification.REMOVE_MANY, eventsToRemove,
				null))
		);
	}
}
