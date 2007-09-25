package com.verticon.tracker.export.xls;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExportXlsPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String ID = "com.verticon.tracker.export.xls";

	// The shared instance
	private static ExportXlsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ExportXlsPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExportXlsPlugin getDefault() {
		return plugin;
	}

}
