package com.verticon.tracker.connector.comm;

import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.io.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.event.comm.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class CommReaderPlugin extends AbstractUIPlugin {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(CommReaderPlugin.class);

	public static final String GNU_IO_RXTX_SERIAL_PORTS = "gnu.io.rxtx.SerialPorts";

	private static final String COMM_SCHEMA = "comm";

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.tracker.connector.comm";

	// The shared instance
	private static CommReaderPlugin plugin;
	
	private ConnectionFactoryImpl connectionFactory;

	/**
	 * The constructor
	 */
	public CommReaderPlugin() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		configureValidSerialPorts();
		Hashtable properties = new Hashtable();
		properties.put(ConnectionFactory.IO_SCHEME, new String[] { COMM_SCHEMA });
		connectionFactory = new ConnectionFactoryImpl();
		connectionFactory.start(context);
		context.registerService(ConnectionFactory.class.getName(), connectionFactory,
				properties);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		connectionFactory.stop(context);
		connectionFactory = null;
		plugin = null;
		
		super.stop(context);
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
