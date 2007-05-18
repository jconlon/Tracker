package com.verticon.tracker.transaction.publisher;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class TrackerFileTailPublisherPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.transaction.publisher.test";

	// The shared instance
	private static TrackerFileTailPublisherPlugin plugin;
	
	private FileTailPublisher fileTailPublisher ;
	
	/**
	 * The constructor
	 */
	public TrackerFileTailPublisherPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		fileTailPublisher = new FileTailPublisher();
		fileTailPublisher.start();
		getPluginPreferences().addPropertyChangeListener(fileTailPublisher);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		getPluginPreferences().removePropertyChangeListener(fileTailPublisher);
		fileTailPublisher.stop();
		fileTailPublisher = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TrackerFileTailPublisherPlugin getDefault() {
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
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public FileTailPublisher getFileTailPublisher() {
		return fileTailPublisher;
	}
}
