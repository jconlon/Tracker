/**
 * 
 */
package com.verticon.tracker.connector.bluetooth;


import java.io.IOException;

import javax.microedition.io.Connection;

import org.osgi.service.io.ConnectionFactory;

import com.intel.bluetooth.MicroeditionConnector;


/**
 * @author jconlon
 *
 */
public class ConnectionFactoryImpl implements ConnectionFactory {

	/**
	 * Create a new <code>Connection</code> object for a comm specified URI.
	 * uri will look like: btspp://000A8401DB20:2;authenticate=false;encrypt=false;master=false
	 * 
	 * @param name
	 *            The full URI passed to the <code>ConnectorService.open</code>
	 *            method
	 * @param mode
	 *            The mode parameter passed to the
	 *            <code>ConnectorService.open</code> method
	 * @param timeouts
	 *            The timeouts parameter passed to the
	 *            <code>ConnectorService.open</code> method
	 * @return A new <code>javax.microedition.io.Connection</code> object.
	 * @throws IOException
	 *             If a <code>javax.microedition.io.Connection</code> object
	 *             can not not be created.
	 */
	public Connection createConnection(String name, int mode, boolean timeouts)
			throws IOException {
		
		return MicroeditionConnector.open(name, mode, timeouts);

	}

}
