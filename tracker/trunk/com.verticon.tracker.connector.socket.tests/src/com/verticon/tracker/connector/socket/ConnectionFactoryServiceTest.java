package com.verticon.tracker.connector.socket;

import static com.verticon.tracker.connector.socket.ConnectionFactoryImplTest.TARGET_SERVER;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connection;
import javax.microedition.io.StreamConnection;

import junit.framework.TestCase;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;

public class ConnectionFactoryServiceTest extends TestCase {

	private ConnectorService connectorService;
	private ServiceReference sr;
	private Bundle bundle;
	
	DataInputStream dis = null;
	DataOutputStream dos = null;
	InputStream is = null;
	OutputStream os = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		bundle = FrameworkUtil.getBundle(ConnectionFactoryServiceTest.class);
		sr = bundle.getBundleContext().getServiceReference(ConnectorService.class.getName());
		
	}

	protected void tearDown() throws Exception {
		if(dis != null){
			dis.close();
		}
		if(dos != null){
			dos.close();
		}
		if(is != null){
			is.close();
		}
		if(os != null){
			os.close();
		}
		connectorService = null;
		super.tearDown();
	}
	
	
	public void test_ConnectionFactory_service(){
		assertNotNull(bundle);
		assertNotNull(sr);
		
		Object o = bundle.getBundleContext().getService(sr);
		assertNotNull(o);
		assertTrue(o instanceof ConnectorService);
	}
	public void test_Connection() throws IOException {
		connectorService =(ConnectorService) bundle.getBundleContext().getService(sr);
		
		Connection con = connectorService.open(
				TARGET_SERVER);

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
	
	public void test_Streams() throws IOException {
		connectorService =(ConnectorService) bundle.getBundleContext().getService(sr);
		
		
		try {
			is = connectorService.openInputStream(TARGET_SERVER);
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(is);
		os = connectorService.openOutputStream(TARGET_SERVER);
		assertNotNull(os);

	}
	
	public void test_dataStreams() throws IOException{
		connectorService =(ConnectorService) bundle.getBundleContext().getService(sr);
		
		
		try {
			dis = connectorService.openDataInputStream(TARGET_SERVER);
		} catch (Exception e) {
			fail("Make sure the server is running at " + TARGET_SERVER);
		}
		assertNotNull(dis);
		dos = connectorService.openDataOutputStream(TARGET_SERVER);
		assertNotNull(dos);

    }
}
