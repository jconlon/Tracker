package com.verticon.tracker.connector.comm;

import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.io.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.reader.event.comm.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class CommReaderPlugin extends AbstractUIPlugin {
	
	public static final String GNU_IO_RXTX_SERIAL_PORTS = "gnu.io.rxtx.SerialPorts";

	//Schema provided for connections
	private static final String SCHEMA = "comm";

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.connector.comm";

	// The shared instance
	private static CommReaderPlugin plugin;
	
	// The ConnectionFactory Service implementation
	private ConnectionFactoryImpl connectionFactory;

	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(CommReaderPlugin.class);

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		configureValidSerialPorts();
		Hashtable properties = new Hashtable();
		properties.put(ConnectionFactory.IO_SCHEME, new String[] { SCHEMA });
		connectionFactory = new ConnectionFactoryImpl();
		context.registerService(ConnectionFactory.class.getName(), connectionFactory,
				properties);
		logger.debug(bundleMarker, "Started Bundle");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		connectionFactory = null;
		plugin = null;
		
		super.stop(context);
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static CommReaderPlugin getDefault() {
		return plugin;
	}
	
	private void configureValidSerialPorts(){
		
		System.setProperty(GNU_IO_RXTX_SERIAL_PORTS, 
				this.getPreferenceStore().getString(PreferenceConstants.P_SERIAL_PORTS));
	}

}
