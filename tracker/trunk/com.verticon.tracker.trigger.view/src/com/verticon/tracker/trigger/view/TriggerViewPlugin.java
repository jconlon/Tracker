/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.trigger.view;


import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Collection;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.collect.ImmutableMap;

/**
 * The activator class controls the plug-in life cycle
 */
public class TriggerViewPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.trigger.view"; //$NON-NLS-1$
	private static final String P_LABEL = "tracker.monitor.label";
	@SuppressWarnings("unused")
	private static final String P_FACTORY_PID = "service.factoryPid";
	private static final String P_EVENT_TOPICS = "event.topics";
	private static final String P_EVENT_PROPERTY_VERTICON_STRING = "com.verticon.product.string";
	private static final String FILTER = "(service.factoryPid=com.verticon.tracker.irouter.eventadmin.gateway)";
	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(TriggerViewPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();

	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}

	// The shared instance
	private static TriggerViewPlugin plugin;
	private EventAdminTracker eventAdminTracker;
	
	/**
	 * The constructor
	 */
	public TriggerViewPlugin() {
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		eventAdminTracker = new EventAdminTracker(context);
		eventAdminTracker.open();

		logger.debug(bundleMarker, "Started Bundle");
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TriggerViewPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Send the string to the event bus
	 * 
	 * @param payload
	 */
	public void post(String payload, String topic) throws ServiceException {
		Map<String, String> output = ImmutableMap.of(
				P_EVENT_PROPERTY_VERTICON_STRING, payload);
		Event event = new Event(topic, output);
		eventAdminTracker.postEvent(event);
	}


	public Map<String, String> getTopicsByNodeLabel() {

		// String filter = "&(objectClass=" + EventHandler.class.getName()
		// + ")(port=" + myport + ")";
		Map<String, String> topicsByNode = newHashMap();

		try {
			Collection<ServiceReference<EventHandler>> serviceReferences = getBundle()
					.getBundleContext().getServiceReferences(
							EventHandler.class,
							FILTER);
			for (ServiceReference<EventHandler> serviceReference : serviceReferences) {
				String key = (String) serviceReference.getProperty(P_LABEL);
				if(isNullOrEmpty(key)){
					throw new IllegalArgumentException(
							"Bad configuration on the EventAdmin Gateway service the Node Label must not be empty.");
				}
				String value = (String) serviceReference
						.getProperty(P_EVENT_TOPICS);
				if(isNullOrEmpty(value)){
					throw new IllegalArgumentException(
							"Bad configuration on the EventAdmin Gateway service the topics must not be empty.");
				}
				topicsByNode.put(key, value);
			}
		} catch (InvalidSyntaxException e) {
			logger.error(bundleMarker,
					"Failed while querying for gateway services.", e);
		}

		return topicsByNode;

	}


	class EventAdminTracker extends ServiceTracker<EventAdmin, EventAdmin>
			implements EventAdmin {

		public EventAdminTracker(BundleContext context) {
			super(context, EventAdmin.class.getName(), null);
		}

		@Override
		public void postEvent(Event event) {
			EventAdmin ea = getService();
			if (ea != null) {
				ea.postEvent(event);
			} else {
				throw new ServiceException("Could not find EventAdmin Serivce");
			}

		}


		@Override
		public void sendEvent(Event event) {
			EventAdmin ea = getService();
			if (ea != null) {
				ea.sendEvent(event);
			} else {
				throw new ServiceException("Could not find EventAdmin Serivce");
			}
		}

	}
}
