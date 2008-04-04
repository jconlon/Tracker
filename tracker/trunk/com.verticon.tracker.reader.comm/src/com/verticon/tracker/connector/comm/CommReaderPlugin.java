package com.verticon.tracker.connector.comm;

import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.io.ConnectionFactory;

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
	 * The constructor
	 */
	public CommReaderPlugin() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
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
	}

	/*
	 * (non-Javadoc)
	 * 
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
	public static CommReaderPlugin getDefault() {
		return plugin;
	}
	
	private void configureValidSerialPorts(){
		
		System.setProperty(GNU_IO_RXTX_SERIAL_PORTS, 
				this.getPreferenceStore().getString(PreferenceConstants.P_SERIAL_PORTS));
	}

}
