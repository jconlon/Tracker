/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.connector.socket;

//import gnu.io.NoSuchPortException;
//import gnu.io.PortInUseException;
//import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connection;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConnectionFactoryImpl implements ConnectionFactory {

	/**
	 * Create a new <code>Connection</code> object for a socket specified URI. uri
	 * will look like: socket://192.168.0.118:3001
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
	 *             If a <code>javax.microedition.io.Connection</code> object can
	 *             not not be created.
	 */
	public Connection createConnection(String name, int mode, boolean timeouts)
			throws IOException {

		switch (mode) {
		case ConnectorService.WRITE:
			return new SocketStreamConnection(name, timeouts) {

				@Override
				public DataInputStream openDataInputStream() throws IOException {
					throw new UnsupportedOperationException();
				}

				@Override
				public InputStream openInputStream() throws IOException {
					throw new UnsupportedOperationException();
				}

			};

		case ConnectorService.READ_WRITE:
			return new SocketStreamConnection(name, timeouts);

		case ConnectorService.READ:
			return new SocketStreamConnection(name, timeouts) {

				@Override
				public DataOutputStream openDataOutputStream()
						throws IOException {
					throw new UnsupportedOperationException();
				}

				@Override
				public OutputStream openOutputStream() throws IOException {
					throw new UnsupportedOperationException();
				}

			};
		}

		throw new IllegalArgumentException("Unknown value for mode: " + mode);
	}
}
