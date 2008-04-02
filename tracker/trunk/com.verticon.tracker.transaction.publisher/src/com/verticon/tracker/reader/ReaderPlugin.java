package com.verticon.tracker.reader;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;

import com.verticon.tracker.reader.event.connection.ReaderCompletionService;
import com.verticon.tracker.reader.event.connection.RefreshablePublisher;



/**
 * Controls the plug-in life cycle
 */
public class ReaderPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = 
		"com.verticon.tracker.reader";

	
	// The shared instance
	private static ReaderPlugin plugin;
	
	final public static String TOPIC_ANIMAL = 
		"com/verticon/tracker/Animal";
	
	final public static String [] ANIMAL_TOPICS = new String[] {
		TOPIC_ANIMAL
	};
	
	public static final String EVENT_PROPERTY_ANIMAL = 
		"com.verticon.tracker.animal";
	
	public static final String EVENT_PROPERTY_READER_NAME = "com.verticon.tracker.reader.name";
	
	private ServiceTracker tracker;
	
	
	private ReaderCompletionService readerCompletionService = null;
	
	private BundleContext bundleContext;
	
	
	


	/**
	 * The constructor
	 */
	public ReaderPlugin() {
		plugin = this;
	}

	
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		bundleContext = context;
		tracker = new ServiceTracker(context, EventAdmin.class.getName(), null);
		tracker.open();
		readerCompletionService = new ReaderCompletionService();
		readerCompletionService.start();
		
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		readerCompletionService.stop();
		readerCompletionService = null;
		tracker.close();
		plugin = null;
		bundleContext=null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ReaderPlugin getDefault() {
		return plugin;
	}
	
	public EventAdmin getService(){
		return (EventAdmin) tracker.getService();
	}
	
	public String getSymbolicName() {
		return bundleContext.getBundle().getSymbolicName();
	}
	
	public BundleContext getBundleContext() {
		return bundleContext;
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

	public final Future<RefreshablePublisher> submit(Callable<RefreshablePublisher> task){
		return readerCompletionService.submit(task);
	}
}
