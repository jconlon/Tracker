/**
 * 
 */
package com.verticon.tracker;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * @author jconlon
 *
 */
public class TrackerPlugin extends Plugin {

	   //The identifier for this plugin
	   public static final String ID = "com.verticon.tracker";

	   // The shared instance.
	   private static TrackerPlugin plugin;

	   
	   /**
	    * The constructor.
	    */
	   public TrackerPlugin() {
	      plugin = this;
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
	     
	      plugin = null;
	   }

	   /**
	    * Returns the shared instance.
	    */
	   public static TrackerPlugin getDefault() {
	      return plugin;
	   }

}
