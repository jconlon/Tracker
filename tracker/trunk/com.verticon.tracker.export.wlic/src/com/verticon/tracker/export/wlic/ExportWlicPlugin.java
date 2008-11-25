package com.verticon.tracker.export.wlic;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExportWlicPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String ID = "com.verticon.tracker.export.wlic";

	// The shared instance
	private static ExportWlicPlugin plugin;
	
	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(ExportWlicPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_MARKER"));
		return bundleMarker;
	}
	/**
	 * The constructor
	 */
	public ExportWlicPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		logger.debug(bundleMarker,"Started Bundle");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		logger.debug(bundleMarker,"Stopped Bundle");
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExportWlicPlugin getDefault() {
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
		return imageDescriptorFromPlugin(ID, path);
	}
}
