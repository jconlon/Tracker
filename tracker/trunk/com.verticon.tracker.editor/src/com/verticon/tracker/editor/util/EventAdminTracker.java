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
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventAdminTracker extends ServiceTracker implements EventAdmin {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EventAdminTracker.class);

	public EventAdminTracker(BundleContext context) {
		super(context, EventAdmin.class.getName(), null);
	}

	public void postEvent(Event event) {
		EventAdmin ea = (EventAdmin) getService();
		if (ea != null) {
			ea.postEvent(event);
		} else {
			logger.error(bundleMarker,"Could not find EventAdmin Serivce");
		}

	}

	public void sendEvent(Event event) {
		EventAdmin ea = (EventAdmin) getService();
		if (ea != null) {
			ea.sendEvent(event);
		} else {
			logger.error(bundleMarker,"Could not find EventAdmin Serivce");
		}
	}

}