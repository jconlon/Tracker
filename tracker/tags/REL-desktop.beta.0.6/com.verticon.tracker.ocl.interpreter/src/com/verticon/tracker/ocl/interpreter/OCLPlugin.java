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

package com.verticon.tracker.ocl.interpreter;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
@SuppressWarnings("ucd")
public class OCLPlugin extends AbstractUIPlugin {

	
	// The shared instance.
	private static OCLPlugin plugin;

	/**
	 * The constructor.
	 */
	public OCLPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Obtains my plug-in ID.
	 * 
	 * @return my plug-in ID
	 */
	public static String getPluginId() {
		return getDefault().getBundle().getSymbolicName();
	}
	
	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static OCLPlugin getDefault() {
		return plugin;
	}
}
