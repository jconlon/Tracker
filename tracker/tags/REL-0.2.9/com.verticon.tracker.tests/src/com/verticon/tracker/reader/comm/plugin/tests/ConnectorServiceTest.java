/**
 * 
 */
package com.verticon.tracker.reader.comm.plugin.tests;

import gnu.io.CommPortIdentifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import junit.framework.TestCase;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.tests.Activator;

/**
 * @author jconlon
 *
 */
public class ConnectorServiceTest extends TestCase {

	ConnectorService ioService = null;
	BundleContext bc = null;
	
	/**
	 * @param name
	 */
	public ConnectorServiceTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		Activator a = Activator.INSTANCE();
		bc = a.getContext();
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		bc=null;
		super.tearDown();
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
	
	
	
	public void testFindingServiceAndReadingFromInputStream(){
		assertNotNull(bc);
		
		//Start the reader 
		Bundle[] bundles = bc.getBundles();
		boolean startedBundle = false;
		for (Bundle bundle : bundles) {
			
			if(bundle.getSymbolicName().equals("com.verticon.tracker.reader.comm")){
				System.out.println("Starting "+ bundle.getSymbolicName());
				try {
					bundle.start();
					startedBundle = true;
				} catch (BundleException e) {
					fail("Failed to start bundle. "+e.getMessage());
				}
			}
		}

		assertTrue("Did not start the bundle", startedBundle);
	    ServiceReference sr = bc.getServiceReference(ConnectorService.class.getName());
	    
	    assertNotNull("Failed to find a ConnectorServiceReference.", sr);
	    
	    ConnectorService cs = (ConnectorService)bc.getService(sr);
	    
	    assertNotNull("Failed to find a ConnectorService.", cs);
	    
	    
	    BufferedReader rin = null;
	    InputStream in =null;
		try {
		    in =  cs.openInputStream("comm:/dev/rfcomm0");
		    rin = new BufferedReader(new InputStreamReader(in));
		    System.out.println("Connected");
		    int messages = 0;
		    while (messages<4){
		    	String line = rin.readLine();
		    	System.out.println(line);
		    	messages++;
		    }
		} catch (IOException e) {
			fail(e.toString());
		} finally{
			if(in !=null)
				try {
					in.close();
				} catch (IOException e) {
					fail("Failed to close because: "+e.getMessage());
				}
		}
	    
	}
}
