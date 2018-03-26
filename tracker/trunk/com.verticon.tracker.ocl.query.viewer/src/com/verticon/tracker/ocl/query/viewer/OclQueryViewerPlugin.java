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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.emf.ui.api.IOclQuerySpec;
import com.verticon.emf.ui.api.IOclQuerySpecLoader;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

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

	private final Marker serviceResponseState = MarkerFactory.getMarker("Service Response " + PLUGIN_ID);
	public final static Marker uiState = MarkerFactory.getMarker("UI " + PLUGIN_ID);

	private BundleContext bundleContext;

	private OclQueryViewer viewer;

	/**
	 * @return the viewer
	 */
	public OclQueryViewer getViewer() {
		return viewer;
	}

	/**
	 * @param viewer
	 *            the viewer to set
	 */
	public void setViewer(OclQueryViewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * The constructor
	 */
	public OclQueryViewerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		this.bundleContext = context;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		this.bundleContext = null;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static OclQueryViewerPlugin getDefault() {
		return plugin;
	}

	/**
	 * Other components may offer default queries for the OCLViewer.
	 * 
	 * @return all default ocl queries offered by other components.
	 */
	private Collection<IOclQuery> getQueries() {
		ArrayList<IOclQuery> result = new ArrayList<IOclQuery>();
		if (bundleContext != null) {
			try {
				ServiceReference<?>[] references = bundleContext
						.getAllServiceReferences(IOclQuerySpecLoader.class.getName(), null);
				if (references != null) {
					ArrayList<IOclQuerySpec> specs = new ArrayList<IOclQuerySpec>();
					for (ServiceReference<?> serviceReference : references) {
						IOclQuerySpecLoader service = (IOclQuerySpecLoader) bundleContext.getService(serviceReference);
						specs.addAll(service.getQuerySpecs());
						bundleContext.ungetService(serviceReference);
					}

					for (IOclQuerySpec iOclQuerySpec : specs) {
						result.add(new OclQuery(iOclQuerySpec));
					}
				}
			} catch (InvalidSyntaxException e) {
				logger.error(serviceResponseState, "Failed to reference to IDefaultQueryLoader", e);
			}

		}
		return result;
	}

	public static Collection<IOclQuery> getExampleQueries() {
		return plugin.getQueries();
	}
}
