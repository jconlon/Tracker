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
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerReportEditPlugin;
import com.verticon.tracker.fair.Fair;

/**
 * This is the central singleton for the Fair editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class FairEditorPlugin extends EMFPlugin {
	private static final String ID = "com.verticon.tracker.fair.editor";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FairEditorPlugin INSTANCE = new FairEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(FairEditorPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	protected static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}
	
	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairEditorPlugin() {
		super
			(new ResourceLocator [] {
				TrackerReportEditPlugin.INSTANCE,
			});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * For ticket 276 - Override the start method to register IAdapterFactory
	 * implementation PremisesProviderFactory on the Platform to 
	 * enable Fair objects to return a Premises.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static class Implementation extends EclipseUIPlugin {
		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			logger.debug(bundleMarker, "Stopped Bundle");
		}

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}

		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			Platform.getAdapterManager().registerAdapters(new PremisesProviderFactory(),
					Fair.class);
			logger.debug(bundleMarker, "Started Bundle");
		}
	}
	
	/**
	 * Tracker View implementations Animal View and Event View 
	 * need to find a Premises when an activeEditor 
	 * is selected.  These basic views cannot contain 
	 * package dependencies to compendium plugins 
	 * like com.verticon.tracker.fair. 
	 * 
	 * So to extract a Premises from a Fair document to 
	 * this IAdapterFactory can be used.
	 * @author jconlon
	 *
	 */
	static class PremisesProviderFactory implements IAdapterFactory {

		
		private static final java.lang.Class<?>[] types = {
			Premises.class
		};
		
		/**
		 * The actual providing of the Premises
		 */
		@SuppressWarnings("unchecked")
		public Object getAdapter(Object fair,
				java.lang.Class clazz) {
			if(clazz == Premises.class && fair instanceof Fair){
				return ((Fair)fair).getPremises();
			}else{
				return null;
			}
		}

		public java.lang.Class<?>[] getAdapterList() {
			return types;
		}
		
	}

}
