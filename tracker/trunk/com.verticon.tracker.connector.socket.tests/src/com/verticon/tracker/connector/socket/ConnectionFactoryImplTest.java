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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.StreamConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

public class ConnectionFactoryImplTest extends TestCase {

	private static final String TARGET_SERVER = "socket://localhost:2345";

	private ConnectionFactory connectionFactory = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private InputStream is = null;
	private OutputStream os = null;
	private ExecutorService exec = Executors.newSingleThreadExecutor();
	

	
	public ConnectionFactoryImplTest() {
		super();
		exec.submit(new Server());
	}

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

	public void test_Streams() throws IOException, InterruptedException {
//		exec = Executors.newSingleThreadExecutor();
//		exec.submit(new Server());
		TimeUnit.MILLISECONDS.sleep(500);
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
//		TimeUnit.SECONDS.sleep(2);
		assertNotNull(is);
		os = ssc.openOutputStream();
		assertNotNull(os);
		ssc.close();

		

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
	
	class Server implements Callable<Void>{
		@Override
		public Void call() throws Exception {
			ServerSocket ss = new ServerSocket(2345);
		    ss.setSoTimeout(100);
		    System.out.println("Waiting");
		    Socket socket = ss.accept();
		    System.out.println("Accepted");

		    TimeUnit.SECONDS.sleep(2);
		    socket.close();
		    ss.close();
			return null;
		}
		
	}
}
