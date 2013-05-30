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
package com.verticon.tracker.store.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Strings;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.store.ITrackerStore;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.store.ui"; //$NON-NLS-1$
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	// The shared instance
	private static Activator plugin;

	private ServiceTracker<Authenticator, Authenticator> authenticatorTracker;

	private ServiceTracker<ITrackerStore, ITrackerStore> storeTracker;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		authenticatorTracker = new ServiceTracker<Authenticator, Authenticator>(
				context, Authenticator.class.getName(), null);
		authenticatorTracker.open();
		storeTracker = new ServiceTracker<ITrackerStore, ITrackerStore>(
				context, ITrackerStore.class.getName(), null);
		storeTracker.open();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		authenticatorTracker.close();
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public ITrackerStore getTrackerStoreService() {
		ITrackerStore result = null;
		String userAdminURI = getUserAdminURI();
		if (!Strings.isNullOrEmpty(userAdminURI)) {
			for (ITrackerStore store : storeTracker
					.getServices(new ITrackerStore[0])) {
				if (userAdminURI.equals(store.uri())) {
					result = store;
					break;
				}
			}
		}
		return result;

	}

	public boolean hasRole(String name) {
		return authenticatorTracker.getService() != null ? authenticatorTracker
				.getService().hasRole(name) : false;
	}

	public boolean isAuthenticatedUser() {
		return authenticatorTracker.getService() != null ? authenticatorTracker
				.getService().isAuthenticatedUser() : false;
	}

	public String getUserAdminURI() {
		return authenticatorTracker.getService().uri();
	}

	/**
	 * 
	 * @return true if there is at least one service available to the admin user
	 */
	public boolean hasTrackerStoreService() {
		return getTrackerStoreService() != null;
	}

}
