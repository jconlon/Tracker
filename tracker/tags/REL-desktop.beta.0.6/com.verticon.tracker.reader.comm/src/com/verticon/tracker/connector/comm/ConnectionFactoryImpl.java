package com.verticon.tracker.connector.comm;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;

import javax.microedition.io.Connection;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConnectionFactoryImpl implements ConnectionFactory {

	/**
	 * Create a new <code>Connection</code> object for a comm specified URI.
	 * uri will look like: comm://COM1;baudrate=9600;databits=9
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

		try {
			switch (mode) {
			case ConnectorService.WRITE:
				return new CommOutputConnection(name, timeouts);

			case ConnectorService.READ_WRITE:
				return new CommStreamConnection( name,  timeouts);

			case ConnectorService.READ:
				return new CommInputConnection(name, timeouts);
			}
		} catch (NoSuchPortException e) {
			throw new IOException(name+ " No Such Port.");
		} catch (PortInUseException e) {
			throw new IOException(name +" Port In Use.");
		} catch (UnsupportedCommOperationException e) {
			throw new IOException(name+ " Unsupported Comm Operation. "+
					(e.getMessage()==null?"":e.getMessage()));
		}

		throw new IllegalArgumentException("Unknown value for mode: "+mode);
	}
}
