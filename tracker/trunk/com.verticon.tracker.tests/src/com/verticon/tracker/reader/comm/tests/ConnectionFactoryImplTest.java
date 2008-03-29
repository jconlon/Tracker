package com.verticon.tracker.reader.comm.tests;

import gnu.io.CommPortIdentifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Enumeration;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.connector.comm.ConnectionFactoryImpl;
import com.verticon.tracker.connector.comm.SerialPortParmsBean;


/**
 * Set of Junit (not plugin) tests of connections to a Bluetooth RFID Animal Tag reader
 * configured on the virtual comm port /dev/rfcomm0
 * 
 * Necessary configuration 
 * 1. pointer to shared libraries is a system property set in the run dialog for this test:
 * -Djava.library.path=/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu
 *  setting this programatically does no good
 *  Note this argument is not necessary when the plugin is running within the Equinox/Eclipse/OSGi
 *  framework as the libraries are contained in the rxtx plugin.
 * 
 * 2. list of valid ports needs to be set as a system property
 * either
 * -Dgnu.io.rxtx.SerialPorts=/dev/rfcomm0
 * or
 * System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/rfcomm0");
 * 
 * Note: /dev/ttyS0 is connected to a UPS and is unavailable.
 * 
 * Last test reads 4 tags in a loop then exits.
 * 
 * 
 * 
 * @author jconlon
 *
 */
public class ConnectionFactoryImplTest extends TestCase {
	static{
		//Not the same as -Djava.library.path=/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu
		//System.setProperty("java.library.path", "/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu");
		
		//same as -Dgnu.io.rxtx.SerialPorts=/dev/ttyS0:/dev/rfcomm0
//		System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyS0:/dev/rfcomm0");
		System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/rfcomm0");
		
		
	}

	SerialPortParmsBean parmsbean;
	ConnectionFactory instance;
	
	protected void setUp() throws Exception {
		super.setUp();
		instance = new ConnectionFactoryImpl();
	}

	protected void tearDown() throws Exception {
		instance=null;
		super.tearDown();
	}

	public void testProperties(){
		assertEquals("/dev/rfcomm0",
				System.getProperty("gnu.io.rxtx.SerialPorts"));
	}
	
	@SuppressWarnings("unchecked")
	public void testGetPortIdentifiers(){
		int countOfPorts = 0;
		Enumeration e = CommPortIdentifier.getPortIdentifiers();
	    while (e.hasMoreElements()) {
	      CommPortIdentifier com = (CommPortIdentifier) e.nextElement();
		  countOfPorts++;
	      System.out.print(com.getName());
	      
	      switch(com.getPortType()){
		      case CommPortIdentifier.PORT_SERIAL:
		      	System.out.print(", a serial port, ");
			break;
		      case CommPortIdentifier.PORT_PARALLEL:
		      	System.out.print(", a parallel port, ");
			break;
		      default:
		      	System.out.print(", a port of unknown type, ");
			break;
	      }
	      
	      if (com.isCurrentlyOwned()){
		      System.out.println("is currently owned by "
		       + com.getCurrentOwner()+ ".");
	      }
	      else {
		      	System.out.println("is currently not owned.");
	      }
	    }
	    assertEquals("Only expected one port",1, countOfPorts);

	}
	public void testCreateConnection() {
		try {
			 instance.createConnection( null, ConnectorService.WRITE ,  true);
			fail("Should have thrown an exception");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Failed to instantiate "+null);
			assertTrue(e.getCause() instanceof URISyntaxException);
		}
		

		try {
			instance.createConnection( "Comm:funky=2", 
					ConnectorService.WRITE ,  true);
			fail("Should have thrown an IOException");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Failed to instantiate "+"Comm:funky=2");
			assertTrue(e.getCause() instanceof URISyntaxException);
		}

		Connection c = null;
		try {
			 c = instance.createConnection( "comm:/dev/rfcomm0", 
					ConnectorService.WRITE ,  true);
			
		
		} catch (IOException e) {
			fail(e.toString());
		} finally{
			try {
				if(c!=null)c.close();
			} catch (IOException e) {
				fail("Failed to close.");
			}
		}

	}
	
	/**
	 * uses 
	 * /dev/rfcomm0
	 */
	public void testReadingFromInputStream(){
		InputConnection c =null;
		BufferedReader rin = null;
		int messages = 0;
		try {
			 c = (InputConnection) instance.createConnection( 
					"comm:/dev/rfcomm0", 
					ConnectorService.READ ,  true);
			
		    InputStream in =  c.openInputStream();
		    rin = new BufferedReader(new InputStreamReader(in));
			
			while (messages<4) {
				String line = rin.readLine();
				if(line.length()==15){
					System.out.println(line);
					messages++;
				}
			}
		    
		} catch (IOException e) {
			fail(e.toString());
		} finally{
			if(c !=null)
				try {
					c.close();
				} catch (IOException e) {
					fail("Failed to close because: "+e.getMessage());
				}
		}
	}
}
