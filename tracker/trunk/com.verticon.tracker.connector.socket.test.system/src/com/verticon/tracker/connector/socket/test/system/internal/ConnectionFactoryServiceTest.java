package com.verticon.tracker.connector.socket.test.system.internal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.StreamConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectorService;

/**
 * 
 * ConnectorService is an OSGi service factory for creating connections based on
 * a URI. <b>ConnectionFactoryImpl</b> provides a socket based connection.
 * 
 * This system test DS finds the ConnectorService and tests the underlying
 * socket connections.
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the MockConsumer. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * @author jconlon
 * 
 */
public class ConnectionFactoryServiceTest extends TestCase {

	private static ConnectorService connectorService;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
	private ExecutorService exec = Executors.newSingleThreadExecutor();
	private static final String TARGET_SERVER = "socket://localhost:2345";
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private InputStream is = null;
	private OutputStream os = null;

	/**
	 * 
	 * @param connectorService
	 *            injected by DS
	 */
	public void setConnectorService(ConnectorService connectorService) {
		ConnectionFactoryServiceTest.connectorService = connectorService;
	}

	/**
	 * 
	 * Called by the test framework to setup the test case.
	 * 
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		startUpGate.await();// wait for startUp to finish

	}

	/**
	 * Called by the component to start the service;
	 */
	public void startup() {
		exec.submit(new Server());
		startUpGate.countDown();
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
		
		super.tearDown();
	}

	public void test_Connection() throws IOException {
		assertNotNull(connectorService);
		
		Connection con = connectorService.open(TARGET_SERVER);

		assertNotNull(con);

		assertTrue(con instanceof StreamConnection);

		StreamConnection ssc = (StreamConnection) con;

		try {
			is = ssc.openInputStream();
		} catch (Exception e) {
			fail(e.getLocalizedMessage()+" Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(is);
		os = ssc.openOutputStream();
		assertNotNull(os);

	}

	public void test_Streams() throws IOException {
		try {
			is = connectorService.openInputStream(TARGET_SERVER);
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(is);
		os = connectorService.openOutputStream(TARGET_SERVER);
		assertNotNull(os);

	}

	public void test_dataStreams() throws IOException {
		try {
			dis = connectorService.openDataInputStream(TARGET_SERVER);
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(dis);
		dos = connectorService.openDataOutputStream(TARGET_SERVER);
		assertNotNull(dos);

	}

	class Server implements Callable<Void> {
		@Override
		public Void call() throws Exception {
			ServerSocket ss = new ServerSocket(2345);
			ss.setSoTimeout(100);
//			System.out.println("Waiting");
			Socket socket = ss.accept();
//			System.out.println("Accepted");

			TimeUnit.SECONDS.sleep(2);
			socket.close();
			ss.close();
			return null;
		}

	}
}
