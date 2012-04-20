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
package com.verticon.tracker.store.mongo.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.store.mongo.ui2"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private BundleContext context;

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
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		this.context = null;
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

	/**
	 * services
	 * "(&(objectclass=com.verticon.tracker.store.ITrackerStore)(tracker.premises.uri=urn:pin:H89234X))"
	 * 
	 * @param uri
	 * @return ITrackerStore
	 * @throws InvalidSyntaxException
	 */
	public ITrackerStore getStore(String uri) throws InvalidSyntaxException {
		String filter = new StringBuilder().append("(tracker.premises.uri=")
				.append(uri).append(')').toString();

		// Register directly with the service
		ServiceReference<?>[] references = context.getServiceReferences(
				ITrackerStore.class.getName(), filter);

		return references != null ? (ITrackerStore) context
				.getService(references[0]) : null;

	}
	
	/**
	 *
	 * @return ITrackerStore
	 */
	public ITrackerStore getRegister() {
		// Register directly with the service
		ServiceReference<ITrackerStore> reference = context.getServiceReference(
				ITrackerStore.class);
		
		return reference!=null?context.getService(reference):null;

	}

	public ITrackerStoreAdmin getLoader() {
		// Register directly with the service
		ServiceReference<ITrackerStoreAdmin> reference = context
				.getServiceReference(ITrackerStoreAdmin.class);
		
		return reference!=null?context.getService(reference):null;
	}
}
