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

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Strings;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.admin.api.ITrackerStoreAdmin;

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
	 * 
	 * @return true if there is at least one service available to the user
	 */
	public boolean hasTrackerStoreService(String uri){
		boolean result = false;
		try {
			result = getTrackerStoreServices(uri).length!=0;
		} catch (InvalidSyntaxException e) {
			
		}
		return result;
	}

	/**
	 * 
	 * @param uri value for created filter property tracker.premises.uri
	 * @return ITrackerStore services 
	 * @throws InvalidSyntaxException
	 */
	public ITrackerStore[] getTrackerStoreServices(String uri) throws InvalidSyntaxException {
		String filter = null;
		List<ITrackerStore> result = null;
		if(!Strings.isNullOrEmpty(uri)){
			filter = new StringBuilder().append("(tracker.premises.uri=")
				.append(uri).append(')').toString();
		}
		// Register directly with the service
		ServiceReference<?>[] references = context.getServiceReferences(
				ITrackerStore.class.getName(), filter);

		if (references != null){
			result = newArrayList();
			for (ServiceReference<?> serviceReference : references) {
				
				result.add((ITrackerStore) context.getService(serviceReference));
			}
		}else{
			result = Collections.emptyList();
		}
		return (ITrackerStore[])result.toArray(new ITrackerStore[result.size()]);
	}
	

	/**
	 * 
	 * @return true if there is at least one service available to the admin user
	 */
	public boolean hasTrackerStoreAdminService(){
		boolean result = false;
		try {
			result = getTrackerStoreAdminServices().length!=0;
		} catch (InvalidSyntaxException e) {
			
		}
		return result;
	}
	
	
	/**
	 * @deprecated use
	 * @return ITrackerStoreAdmin
	 */
	public ITrackerStoreAdmin getLoader() {
		// Register directly with the service
		ServiceReference<ITrackerStoreAdmin> reference = context
				.getServiceReference(ITrackerStoreAdmin.class);
		
		return reference!=null?context.getService(reference):null;
	}
	
	public ITrackerStoreAdmin[] getTrackerStoreAdminServices() throws InvalidSyntaxException {
		List<ITrackerStoreAdmin> result = null;
		ServiceReference<?>[] references = context.getServiceReferences(
				ITrackerStoreAdmin.class.getName(), null);
		if (references != null){
			result = newArrayList();
			ITrackerStoreAdmin trackerStoreAdmin = null;
			for (ServiceReference<?> serviceReference : references) {
				trackerStoreAdmin = (ITrackerStoreAdmin) context.getService(serviceReference);
				if(trackerStoreAdmin.isCurrentUserAdmin()){
					result.add(trackerStoreAdmin);
				}
			}
		}else{
			result = Collections.emptyList();
		}
		return (ITrackerStoreAdmin[])result.toArray(new ITrackerStoreAdmin[result.size()]);
	}
}
