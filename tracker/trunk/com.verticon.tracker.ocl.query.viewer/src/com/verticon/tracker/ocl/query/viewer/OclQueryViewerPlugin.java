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
package com.verticon.tracker.ocl.query.viewer;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class OclQueryViewerPlugin extends AbstractUIPlugin {

	// The plug-in ID
	protected static final String PLUGIN_ID = "com.verticon.tracker.ocl.query.viewer";

	// The shared instance
	private static OclQueryViewerPlugin plugin;

	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(OclQueryViewerPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}
	
	/**
	 * The constructor
	 */
	public OclQueryViewerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		logger.debug(bundleMarker, "Started Bundle");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	protected static OclQueryViewerPlugin getDefault() {
		return plugin;
	}

	
}
