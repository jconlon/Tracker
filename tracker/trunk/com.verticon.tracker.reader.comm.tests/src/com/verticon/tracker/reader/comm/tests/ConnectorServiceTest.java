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
/**
 * 
 */
package com.verticon.tracker.reader.comm.tests;

import static com.verticon.tracker.reader.comm.tests.Activator.bundleMarker;
import static com.verticon.tracker.reader.comm.tests.ConnectionFactoryImplTest.JAVA_LIBRARY_PATH;
import static com.verticon.tracker.reader.comm.tests.ConnectionFactoryImplTest.testPortSetting;
import static com.verticon.tracker.reader.event.comm.CommReaderPlugin.GNU_IO_RXTX_SERIAL_PORTS;
import gnu.io.CommPortIdentifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jconlon
 *
 */
public class ConnectorServiceTest extends TestCase {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConnectorServiceTest.class);
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
		Activator a = Activator.getDefault();
		bc = a.getBundle().getBundleContext();
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		bc=null;
		super.tearDown();
	}

	public void testProperties() {
		logger.debug(bundleMarker, GNU_IO_RXTX_SERIAL_PORTS + "={}", 
				System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
		logger.debug(bundleMarker, JAVA_LIBRARY_PATH + "={}", System
				.getProperty(JAVA_LIBRARY_PATH)); 
		
		assertNotNull("Serial ports not set", System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
		testPortSetting();
		
	}
	
	@SuppressWarnings("unchecked")
	public void testGetPortIdentifiers(){
		int countOfPorts = 0;
		Enumeration e = CommPortIdentifier.getPortIdentifiers();
	    while (e.hasMoreElements()) {
	      CommPortIdentifier com = (CommPortIdentifier) e.nextElement();
		  countOfPorts++;
		  StringBuilder sb = new StringBuilder(com.getName());
	      
	      switch(com.getPortType()){
		      case CommPortIdentifier.PORT_SERIAL:
		      	sb.append(", a serial port, ");
			break;
		      case CommPortIdentifier.PORT_PARALLEL:
		      	sb.append(", a parallel port, ");
			break;
		      default:
		      	sb.append(", a port of unknown type, ");
			break;
	      }
	      
	      if (com.isCurrentlyOwned()){
		      sb.append("is currently owned by " + com.getCurrentOwner()+ ".");
		      logger.debug(bundleMarker,sb.toString());
	      }
	      else {
		      sb.append("is currently not owned.");
		      logger.debug(bundleMarker,sb.toString());
	      }
	    }
	    assertEquals("Only expected one port",1, countOfPorts);
 
	}
	
	
	/**
	 * User is prompted to run this optional test. 
	 * 
	 * Test requires a serial connected to the 
	 * serial port to read in 4 tags. 
	 */
	public void testFindingServiceAndReadingFromInputStream(){
		String portName = testPortSetting();
		assertNotNull(bc);
		
        System.out.println("This test requires a serial device reader connected to "+portName);
		
		int ch;
	    System.out.print ("Type y to continue: ");
	    
	    try {
			ch = System.in.read ();
			if(ch != 'y'){
				System.out.println("Defering testFindingServiceAndReadingFromInputStream");
				logger.debug(bundleMarker,"Skipping testReadingFromInputStream");
				return;
			}
		} catch (IOException e1) {
			System.out.println("Defering testFindingServiceAndReadingFromInputStream");
			logger.debug(bundleMarker,"Skipping testFindingServiceAndReadingFromInputStream");
			return;
		}
		
		startBundles(logger, bc);
		
	    ServiceReference sr = bc.getServiceReference(ConnectorService.class.getName());
	    
	    assertNotNull("Failed to find a ConnectorServiceReference.", sr);
	    
	    ConnectorService cs = (ConnectorService)bc.getService(sr);
	    
	    assertNotNull("Failed to find a ConnectorService.", cs);
	    
	    
	    BufferedReader rin = null;
	    InputStream in =null;
		try {
		    in =  cs.openInputStream("comm:"+portName);
		    rin = new BufferedReader(new InputStreamReader(in));
		    logger.debug(bundleMarker,"Connected to {}",portName);
		    int messages = 0;
		    System.out.println("With a serial port RFID reader connected to port: "+
		    		portName+", read 4 tags.");
		    logger.info(bundleMarker,"Waiting for four tag reads at serial port: {}",portName);
		    while (messages<4){
		    	String line = rin.readLine();
		    	System.out.println(line);
		    	logger.info(bundleMarker,"Read tag: {}",line);
		    	messages++;
		    }
		} catch (IOException e) {
			fail(e.toString());
		} finally{
			if(in !=null)
				try {
					in.close();
					System.out.println("Closed "+portName);
					logger.debug(bundleMarker,"Closed {}",portName);
					TimeUnit.SECONDS.sleep(20);
				} catch (IOException e) {
					fail("Failed to close because: "+e.getMessage());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	    
	}

	static void startBundles(Logger logger, BundleContext bc) {
		//Start the equinox.io and the reader bundles
		Bundle ioBundle = null;
		Bundle readerCommBundle = null;
		Bundle[] bundles = bc.getBundles();
		for (Bundle bundle : bundles) {
			if(bundle.getSymbolicName().equals("com.verticon.tracker.reader.comm")){
				readerCommBundle = bundle;
				if(bundle.getState()!=Bundle.ACTIVE){
					logger.debug(bundleMarker,"Starting "+ readerCommBundle.getSymbolicName());
					try {
						readerCommBundle.start();

					} catch (BundleException e) {
						fail("Failed to start readerCommBundle. "+e.getMessage());
					}
				}
			}else 
				if(bundle.getSymbolicName().equals("org.eclipse.equinox.io") ) {
				ioBundle = bundle;
				if(bundle.getState()!=Bundle.ACTIVE){
					logger.debug(bundleMarker,"Starting "+ ioBundle.getSymbolicName());
					try {
						ioBundle.start();
					
					} catch (BundleException e) {
						fail("Failed to start bundle. "+e.getMessage());
					}
				}
			}else{
//				logger.debug(bundleMarker,"Saw bundle {}",bundle.getSymbolicName());
			}
		}

		assertNotNull("Did not find the reader.conn bundle",readerCommBundle);
		assertEquals("Did not start the reader.conn bundle", Bundle.ACTIVE, readerCommBundle.getState());
		
		assertNotNull("Did not find the equinox.io bundle",ioBundle);
		assertEquals("Did not start the equinox.io bundle", Bundle.ACTIVE, ioBundle.getState());
		
		
		assertEquals("Did not start the reader.conn.tests bundle", Bundle.ACTIVE, bc.getBundle().getState());
	}
	
}
