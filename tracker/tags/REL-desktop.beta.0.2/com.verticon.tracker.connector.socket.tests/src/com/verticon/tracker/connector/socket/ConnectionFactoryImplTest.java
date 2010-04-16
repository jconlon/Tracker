package com.verticon.tracker.connector.socket;

import java.io.IOException;

import javax.microedition.io.Connection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

public class ConnectionFactoryImplTest extends TestCase {

	ConnectionFactory connectionFactory = new ConnectionFactoryImpl();
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void test_uri_parsing() throws IOException {
		Connection con = connectionFactory.createConnection(
				"socket://192.168.0.118:3001", 
				ConnectorService.READ_WRITE, true);
		
		assertNotNull(con);
		
		assertTrue(con instanceof SocketStreamConnection);
		
		SocketStreamConnection ssc = (SocketStreamConnection)con;
		
		assertEquals("192.168.0.118", ssc.getHostName());
		
		assertEquals(3001, ssc.getPort());
		
		assertTrue(ssc.isTimeouts());
    }
	
	public void test_uri_parsing2() throws IOException {
		Connection con = connectionFactory.createConnection(
				"socket://mudshark:3004", 
				ConnectorService.READ_WRITE, false);
		
		assertNotNull(con);
		
		assertTrue(con instanceof SocketStreamConnection);
		
		SocketStreamConnection ssc = (SocketStreamConnection)con;
		
		assertEquals("mudshark", ssc.getHostName());
		
		assertEquals(3004, ssc.getPort());
		
		assertFalse(ssc.isTimeouts());
    }
	
	public void test_uri_parsing3() throws IOException {
		try {
			connectionFactory.createConnection(
					"sockex://mudshark:3004", 
					ConnectorService.READ_WRITE, false);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//expected
			return;
		}
		fail("Should throw IllegalArgumentException");
		
    }
	
	public void test_uri_parsing4() throws IOException {
		try {
			connectionFactory.createConnection(
					"socket:mudshark:3004", 
					ConnectorService.READ_WRITE, false);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//expected
			return;
		}
		fail("Should throw IllegalArgumentException");
		
    }
}
