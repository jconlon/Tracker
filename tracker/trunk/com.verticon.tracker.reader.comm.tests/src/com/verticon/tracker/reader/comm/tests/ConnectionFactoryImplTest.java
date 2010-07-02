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
package com.verticon.tracker.reader.comm.tests;

import static com.verticon.tracker.connector.comm.CommReaderPlugin.GNU_IO_RXTX_SERIAL_PORTS;
import static com.verticon.tracker.reader.comm.tests.Activator.bundleMarker;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.connector.comm.ConnectionFactoryImpl;

/**
 * Set of Junit (not plugin) tests of connections to a Bluetooth RFID Animal Tag
 * reader configured on the virtual comm port /dev/rfcomm0
 * 
 * Necessary configuration 1. pointer to shared libraries is a system property
 * set in the run dialog for this test:
 * -Djava.library.path=/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu
 * setting this programatically does no good Note this argument is not necessary
 * when the plugin is running within the Equinox/Eclipse/OSGi framework as the
 * libraries are contained in the rxtx plugin.
 * 
 * 2. A valid port needs to be set as a system property
 * -Dgnu.io.rxtx.SerialPorts=/dev/ttyS0:/dev/rfcomm0 is a valid configuration
 * 
 * 
 * 3. The testReadingFromInputStream test reads 4 tags in a loop then exits. 
 * So you will need a serial device 
 * connected to the port.  At the prompt read the four tags.
 * 
 * 
 * 
 * @author jconlon
 * 
 */
public class ConnectionFactoryImplTest extends TestCase {
	static final String JAVA_LIBRARY_PATH = "java.library.path";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConnectionFactoryImplTest.class);
	private static final String INTERRUPTED = "Interrupted";
	private static final String FELL_THROUGH = "Fell through";
	private ConnectionFactory instance;

	protected void setUp() throws Exception {
		super.setUp();
		instance = new ConnectionFactoryImpl();
	}

	protected void tearDown() throws Exception {
		instance = null;
		super.tearDown();
	}

	public void testProperties() {
		logger.debug(bundleMarker, GNU_IO_RXTX_SERIAL_PORTS + "={}", System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
		logger.debug(bundleMarker, JAVA_LIBRARY_PATH + "={}", System
				.getProperty(JAVA_LIBRARY_PATH)); 
		
		assertNotNull("Serial ports not set", System
				.getProperty(GNU_IO_RXTX_SERIAL_PORTS));
		
	}

	@SuppressWarnings("unchecked")
	public void testGetPortIdentifiers() {
		int countOfPorts = 0;
		Enumeration e = CommPortIdentifier.getPortIdentifiers();
		while (e.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) e.nextElement();
			logger.debug(bundleMarker,"Found a com port {}"+com.getName());
			countOfPorts++;
			StringBuilder sb = new StringBuilder(com.getName());

			switch (com.getPortType()) {
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

			if (com.isCurrentlyOwned()) {
				sb.append("is currently owned by ");
				sb.append(com.getCurrentOwner() );
				sb.append(',');
			} else {
				sb.append("is currently not owned.");
			}
			logger.debug(bundleMarker,sb.toString());
			CommPort port = null;
			try {
				port = com.open(this.getName(), 10);
				port.enableReceiveTimeout(10);
				logger.debug(bundleMarker,"Timeout ENabled on port {}",port.getName());
				port.close();
			} catch (PortInUseException e1) {
				logger.error(bundleMarker,"Port "+com.getName()+" in use.",e1 );
				fail("Port in use");
				
			} catch (UnsupportedCommOperationException e1) {
				logger.error(bundleMarker,"Port "+port.getName()+" unsupported operation.",e1 );
				fail("Timeout is not enabled");
			} finally {
				if (port != null) {
					port.close();
				}
			}

		}
		assertEquals("Only expected one port", 1, countOfPorts);

	}

	public void testCreateConnection() {
		String portName = testPortSetting();
		
		try {
			instance.createConnection(null, ConnectorService.WRITE, true);
			fail("Should have thrown an exception");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Failed to instantiate " + null);
			assertTrue(e.getCause() instanceof URISyntaxException);
		}

		try {
			instance.createConnection("Comm:funky=2", ConnectorService.WRITE,
					true);
			fail("Should have thrown an IOException");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Failed to instantiate "
					+ "Comm:funky=2");
			assertTrue(e.getCause() instanceof URISyntaxException);
		}

		Connection c = null;
		try {
			c = instance.createConnection("comm:"+portName,
					ConnectorService.WRITE, true);

		} catch (IOException e) {
			fail(e.toString());
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (IOException e) {
				fail("Failed to close.");
			}
		}

	}

	static String testPortSetting() {
		String portName = System.getProperty(GNU_IO_RXTX_SERIAL_PORTS);
		if(portName.contains(":")){
			portName = portName.substring(0, portName.indexOf(':'));
		}
		assertNotNull("Serial ports not set",portName );
		assertTrue("Port name is blank: <"+ portName+'>', portName.trim().length() > 3);
		return portName;
	}

	public void testTwoConnections() {
		String portName = testPortSetting();
		
		InputConnection c = null;
		BufferedReader rin = null;
		try {
			c = (InputConnection) instance.createConnection(
					"comm:"+portName, ConnectorService.READ, true);

			InputStream in = c.openInputStream();
			rin = new BufferedReader(new InputStreamReader(in));

			rin.close();

		} catch (IOException e) {
			fail("Failed to open first connection " + e.toString());
		} finally {
			if (c != null)
				try {
					c.close();
				} catch (IOException e) {
					fail("Failed to close first connection because: "
							+ e.getMessage());
				}
		}

		try {
			c = (InputConnection) instance.createConnection(
					"comm:"+portName, ConnectorService.READ, true);

			InputStream in = c.openInputStream();
			rin = new BufferedReader(new InputStreamReader(in));

			rin.close();

		} catch (IOException e) {
			fail("Could not open second connection " + e.toString());
		} finally {
			if (c != null)
				try {
					c.close();
				} catch (IOException e) {
					fail("Failed to close because: " + e.getMessage());
				}
		}
	}

	/**
	 * Requires a Serial Reader.
	 */
	public void testReadingFromInputStream(){
		String portName = testPortSetting();
		System.out.println("This test requires a serial device reader connected to "+portName);
		
		int ch;
	    System.out.print ("Type y to continue: ");
	    
	    try {
			ch = System.in.read ();
			if(ch != 'y'){
				System.out.println("Defering testReadingFromInputStream");
				logger.debug(bundleMarker,"Skipping testReadingFromInputStream");
				return;
			}
		} catch (IOException e1) {
			System.out.println("Defering testReadingFromInputStream");
			logger.debug(bundleMarker,"Skipping testReadingFromInputStream");
			return;
		}
	    

		
		InputConnection c =null;
		BufferedReader rin = null;
		int messages = 0;
		try {
			c = (InputConnection) instance.createConnection(
					"comm:"+portName,
					ConnectorService.READ , true);

			InputStream in = c.openInputStream();
			rin = new BufferedReader(new InputStreamReader(in));
            System.out.println("Read four tags from "+ portName + " connected serial reader.");
            
			while (messages<4) {
				String line = rin.readLine();
				if(line.length()==15){
					System.out.println(line);
					messages++;
				}
			}
            System.out.println("Test completed.  Thank you for your input.");
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


	public void testReadInterupptedCommStream() {
		logger.debug(bundleMarker,"Begining testReadInterupptedCommStream");
		final String portName = testPortSetting();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService<String>(
				executorService);
		final StringBuffer message = new StringBuffer();

		Callable<String> runner = new Callable<String>() {
			StringBuilder builder = new StringBuilder();
			
			private void process(int count, byte[] data){
				System.out.print("Processing buffer ");
				System.out.write(data, 0, count);
				System.out.println("");
				char c ;
				for (int i = 0; i < count; i++) {
					c = (char)data[i];
					if(c=='\r'| c=='\n'){
						if(builder.length()==15){
							System.out.println(builder.toString());
						}
						builder.delete(0, 15);
					}else{
						builder.append(c);
					}
					
				}
				
			}
			
			public String call() {
				InputConnection c = null;
				byte[] tmp=new byte[1024];
				try {
					c = (InputConnection) instance.createConnection(
							"comm:"+portName, ConnectorService.READ, true);
					InputStream in = c.openInputStream();
					logger.debug(bundleMarker,"Connected to {}", portName);
					while (!Thread.currentThread().isInterrupted()) {
					      if(in.available()>0){
					          int i=in.read(tmp, 0, 1024);
					          if(i<0)break;
					          process(i, tmp);
					      }
//					      System.out.println("Sleeping");
						  TimeUnit.MILLISECONDS.sleep(500);
					     
					}
					message.append(FELL_THROUGH);
//					System.out.println("Fell through");

				} catch (IOException e) {
					fail(e.toString());
				} catch (InterruptedException e) {
//					System.out.println("Interrupted");
					logger.debug(bundleMarker,"Interrupted {}",portName);
					message.append(INTERRUPTED);
				} finally {
					if (c != null)
						try {
							c.close();

							logger.debug(bundleMarker,"Closing connection to {}",portName);
						} catch (IOException e) {
							fail("Failed to close because: " + e.getMessage());
						}
				}

				return message.toString();
			}

		};

		logger.debug(bundleMarker, "Submitting first Task");
		Future<String> task = completionService.submit(runner);

		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}
		logger.debug(bundleMarker, "Canceling Stream");
		task.cancel(true);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}

		// assertEquals("Did not fall through the loop when
		// canceled",FELL_THROUGH, message.toString());
		assertEquals("Was not interrupted", INTERRUPTED, message.toString());
		message.delete(0, message.capacity());
		
		logger.debug(bundleMarker, "Submitting second Task");
		task = completionService.submit(runner);

		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}
		logger.debug(bundleMarker, "Canceling Second Stream");
		task.cancel(true);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}

		// assertEquals("Did not fall through the loop when
		// canceled",FELL_THROUGH, message.toString());
		assertEquals("Was not interrupted", INTERRUPTED, message.toString());

	}

//	public void testReadInterupptedCommNIO() {
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		CompletionService<String> completionService = new ExecutorCompletionService<String>(
//				executorService);
//		final StringBuffer message = new StringBuffer();
//
//		Callable<String> runner = new Callable<String>() {
//
//			public String call() {
//				InputConnection c = null;
//				BufferedReader rin = null;
//				ByteArrayInputStream fs;
//				// StringBuffer stringBuffer = new StringBuffer();
//				try {
//					c = (InputConnection) instance.createConnection(
//							"comm:/dev/rfcomm0", ConnectorService.READ, true);
//
//					InputStream in = c.openInputStream();
//					ReadableByteChannel source = Channels.newChannel(in);
//					ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 20);
//					WritableByteChannel dest = Channels.newChannel(System.out);
//					// rin = new BufferedReader(new InputStreamReader(in));
//					// char[] cbuf = new char[17];
//					// int off = 0;
//					logger.debug(bundleMarker, "Entering NIO");
//					while (source.read(buffer) != -1) {
//						buffer.flip();
//						dest.write(buffer);
//						buffer.compact();
//
//						logger.debug(bundleMarker, "SleepingNIO");
//						TimeUnit.MILLISECONDS.sleep(500);
//						logger.debug(bundleMarker, "In read loop");
//					}
//					message.append(FELL_THROUGH);
//					logger.debug(bundleMarker, "Fell through");
//
//				} catch (IOException e) {
//					fail(e.toString());
//				} catch (InterruptedException e) {
//					logger.debug(bundleMarker, "Interrupted");
//					message.append(INTERRUPTED);
//				} finally {
//					if (c != null)
//						try {
//							c.close();
//						} catch (IOException e) {
//							fail("Failed to close because: " + e.getMessage());
//						}
//				}
//
//				return message.toString();
//			}
//
//		};
//
//		Future<String> task = completionService.submit(runner);
//
//		try {
//			TimeUnit.SECONDS.sleep(15);
//		} catch (InterruptedException e) {
//			fail("Should not have this sleep interupted");
//			Thread.currentThread().interrupt();
//		}
//		logger.debug(bundleMarker, "Canceling NIO");
//		task.cancel(true);
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			fail("Should not have this sleep interupted");
//			Thread.currentThread().interrupt();
//		}
//
//		// assertEquals("Did not fall through the loop when
//		// canceled",FELL_THROUGH, message.toString());
//		assertEquals("Was not interrupted", INTERRUPTED, message.toString());
//
//	}
}
