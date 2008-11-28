package com.verticon.tracker.connector.bluetooth;

import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.io.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;




/**
 * The activator class controls the plug-in life cycle
 */
public class BluetoothReaderPlugin extends AbstractUIPlugin {

	//Schema provided for connections
	private static final String SCHEMA = "btspp";

	
	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.connector.bluetooth";

	// The shared instance
	private static BluetoothReaderPlugin plugin;
	
	// The ConnectionFactory Service implementation
	private ConnectionFactoryImpl connectionFactory;
	
	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(BluetoothReaderPlugin.class);

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
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Hashtable properties = new Hashtable();
		properties.put(ConnectionFactory.IO_SCHEME, new String[] { SCHEMA });
		connectionFactory = new ConnectionFactoryImpl();
		context.registerService(ConnectionFactory.class.getName(), connectionFactory,
				properties);
		logger.debug(bundleMarker, "Started Bundle");
	}

	/*
	 * (non-Javadoc)
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
	public static BluetoothReaderPlugin getDefault() {
		return plugin;
	}

}
