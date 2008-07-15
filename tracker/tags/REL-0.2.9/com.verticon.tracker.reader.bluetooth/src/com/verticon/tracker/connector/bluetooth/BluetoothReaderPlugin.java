package com.verticon.tracker.connector.bluetooth;

import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.io.ConnectionFactory;



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
	 * The constructor
	 */
	public BluetoothReaderPlugin() {
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Hashtable properties = new Hashtable();
		properties.put(ConnectionFactory.IO_SCHEME, new String[] { SCHEMA });
		connectionFactory = new ConnectionFactoryImpl();
		context.registerService(ConnectionFactory.class.getName(), connectionFactory,
				properties);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		connectionFactory = null;
		plugin = null;
		super.stop(context);
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
