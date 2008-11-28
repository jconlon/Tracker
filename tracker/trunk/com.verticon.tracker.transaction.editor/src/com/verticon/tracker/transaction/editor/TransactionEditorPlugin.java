/**
 * <copyright>
 * </copyright>
 *
 * $Id: EXTLibraryEditorPlugin.java,v 1.1 2006/01/30 16:30:09 cdamus Exp $
 */
package com.verticon.tracker.transaction.editor;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.editor.util.TrackerConstants;
import com.verticon.tracker.transaction.editor.event.TransactionEventHandler;

/**
 * This is the central singleton for the EXTLibrary editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class TransactionEditorPlugin extends EMFPlugin {
	private static final String ID = "com.verticon.tracker.transaction.editor";

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TransactionEditorPlugin INSTANCE = new TransactionEditorPlugin();

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
	private final static Logger logger = LoggerFactory.getLogger(TransactionEditorPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
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
	public TransactionEditorPlugin() {
		super
		  (new ResourceLocator [] {
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
	 * <!-- end-user-doc -->
	 * @generated 
	 */
	public static class Implementation extends EclipseUIPlugin {

		// final public static String [] ANIMAL_TOPICS = new String[] {
		// "com/verticon/tracker/Animal"
		// };
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
			Dictionary<String, String> d = new Hashtable<String, String>();
			d.put(EventConstants.EVENT_TOPIC,
					TrackerConstants.EVENT_ADMIN_TOPIC_READER);
			context.registerService(EventHandler.class.getName(), 
					new TransactionEventHandler(), d);
			logger.debug(bundleMarker, "Started Bundle");
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			logger.debug(bundleMarker, "Stopped Bundle");
		}
	}

}
