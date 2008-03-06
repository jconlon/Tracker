package com.verticon.tracker.transaction.publisher;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;



/**
 * Controls the plug-in life cycle
 */
public class PublisherPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = 
		"com.verticon.tracker.transaction.publisher";

	// The shared instance
	private static PublisherPlugin plugin;
	
	final public static String TOPIC_ANIMAL = 
		"com/verticon/tracker/Animal";
	
	final public static String [] ANIMAL_TOPICS = new String[] {
		TOPIC_ANIMAL
	};
	
	public static final String EVENT_PROPERTY_ANIMAL = 
		"com.verticon.tracker.animal";
	
	private ServiceTracker tracker;
	
	private String symbolicName;
	
	public String getSymbolicName() {
		return symbolicName;
	}

	public void setSymbolicName(String symbolicName) {
		this.symbolicName = symbolicName;
	}

	/**
	 * The constructor
	 */
	public PublisherPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		symbolicName = context.getBundle().getSymbolicName();
		tracker = new ServiceTracker(context, EventAdmin.class.getName(), null);
		tracker.open();
		
	}
	
	public EventAdmin getService(){
		return (EventAdmin) tracker.getService();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		tracker.close();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static PublisherPlugin getDefault() {
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

}
