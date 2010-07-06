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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connection;
import javax.microedition.io.StreamConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactoryImplTest extends TestCase {

	static final String TARGET_SERVER = "socket://localhost:2345";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConnectionFactoryImplTest.class);

	ConnectionFactory connectionFactory = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	InputStream is = null;
	OutputStream os = null;

	protected void setUp() throws Exception {
		super.setUp();
		connectionFactory = new ConnectionFactoryImpl();

	}

	protected void tearDown() throws Exception {
		if (dis != null) {
			dis.close();
		}
		if (dos != null) {
			dos.close();
		}
		if (is != null) {
			is.close();
		}
		if (os != null) {
			os.close();
		}
		connectionFactory = null;
		super.tearDown();
	}

	public void test_uri_parsing() throws IOException {
		Connection con = connectionFactory.createConnection(TARGET_SERVER,
				ConnectorService.READ_WRITE, true);

		assertNotNull(con);

		assertTrue(con instanceof SocketStreamConnection);

		SocketStreamConnection ssc = (SocketStreamConnection) con;

		assertEquals("localhost", ssc.getHostName());

		assertEquals(2345, ssc.getPort());

		assertTrue(ssc.isTimeouts());
	}

	public void test_uri_parsing2() throws IOException {
		Connection con = connectionFactory.createConnection(
				"socket://mudshark:3004", ConnectorService.READ_WRITE, false);

		assertNotNull(con);

		assertTrue(con instanceof SocketStreamConnection);

		SocketStreamConnection ssc = (SocketStreamConnection) con;

		assertEquals("mudshark", ssc.getHostName());

		assertEquals(3004, ssc.getPort());

		assertFalse(ssc.isTimeouts());
	}

	public void test_uri_parsing3() throws IOException {
		try {
			connectionFactory.createConnection("sockex://mudshark:3004",
					ConnectorService.READ_WRITE, false);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// expected
			return;
		}
		fail("Should throw IllegalArgumentException");

	}

	public void test_uri_parsing4() throws IOException {
		try {
			connectionFactory.createConnection("socket:mudshark:3004",
					ConnectorService.READ_WRITE, false);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// expected
			return;
		}
		fail("Should throw IllegalArgumentException");

	}

	public void test_Streams() throws IOException {
		Connection con = connectionFactory.createConnection(TARGET_SERVER,
				ConnectorService.READ_WRITE, true);

		assertNotNull(con);

		assertTrue(con instanceof SocketStreamConnection);

		StreamConnection ssc = (StreamConnection) con;

		try {
			is = ssc.openInputStream();
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(is);
		os = ssc.openOutputStream();
		assertNotNull(os);

	}

	public void test_dataStreams() throws IOException {
		Connection con = connectionFactory.createConnection(TARGET_SERVER,
				ConnectorService.READ_WRITE, true);

		assertNotNull(con);

		assertTrue(con instanceof SocketStreamConnection);

		StreamConnection ssc = (StreamConnection) con;

		try {
			dis = ssc.openDataInputStream();
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(dis);
		dos = ssc.openDataOutputStream();
		assertNotNull(dos);

	}
}
