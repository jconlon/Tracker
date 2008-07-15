package com.verticon.tracker.reader.comm.tests;

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

import com.verticon.tracker.connector.comm.ConnectionFactoryImpl;
import com.verticon.tracker.connector.comm.SerialPortParmsBean;

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
 * 2. list of valid ports needs to be set as a system property either
 * -Dgnu.io.rxtx.SerialPorts=/dev/rfcomm0 or
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
	private static final String INTERRUPTED = "Interrupted";
	private static final String FELL_THROUGH = "Fell through";
	static {
		// Not the same as
		// -Djava.library.path=/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu
		// System.setProperty("java.library.path",
		// "/home/jconlon/downloads/rxtx/rxtx-2.1-7-bins-r2/Linux/i686-unknown-linux-gnu");

		// same as -Dgnu.io.rxtx.SerialPorts=/dev/ttyS0:/dev/rfcomm0
		// System.setProperty("gnu.io.rxtx.SerialPorts",
		// "/dev/ttyS0:/dev/rfcomm0");
		System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/rfcomm0");

	}

	SerialPortParmsBean parmsbean;
	ConnectionFactory instance;

	protected void setUp() throws Exception {
		super.setUp();
		instance = new ConnectionFactoryImpl();
	}

	protected void tearDown() throws Exception {
		instance = null;
		super.tearDown();
	}

	public void testProperties() {
		assertEquals("/dev/rfcomm0", System
				.getProperty("gnu.io.rxtx.SerialPorts"));
	}

	@SuppressWarnings("unchecked")
	public void testGetPortIdentifiers() {
		int countOfPorts = 0;
		Enumeration e = CommPortIdentifier.getPortIdentifiers();
		while (e.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) e.nextElement();
			countOfPorts++;
			System.out.print(com.getName());

			switch (com.getPortType()) {
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

			if (com.isCurrentlyOwned()) {
				System.out.println("is currently owned by "
						+ com.getCurrentOwner() + ".");
			} else {
				System.out.println("is currently not owned.");
			}
			CommPort port = null;
			try {
				port = com.open(this.getName(), 10);
				port.enableReceiveTimeout(10);
				System.out.println("Timeout ENabled");
				port.close();
			} catch (PortInUseException e1) {
				fail("Port in use");
				e1.printStackTrace();
			} catch (UnsupportedCommOperationException e1) {
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
			c = instance.createConnection("comm:/dev/rfcomm0",
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

	public void testTwoConnections() {
		InputConnection c = null;
		BufferedReader rin = null;
		try {
			c = (InputConnection) instance.createConnection(
					"comm:/dev/rfcomm0", ConnectorService.READ, true);

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
					"comm:/dev/rfcomm0", ConnectorService.READ, true);

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

//	/**
//	 * uses
//	 * /dev/rfcomm0
//	 */
//	public void testReadingFromInputStream(){
//		InputConnection c =null;
//		BufferedReader rin = null;
//		int messages = 0;
//		try {
//			c = (InputConnection) instance.createConnection(
//					"comm:/dev/rfcomm0",
//					ConnectorService.READ , true);
//
//			InputStream in = c.openInputStream();
//			rin = new BufferedReader(new InputStreamReader(in));
//
//			while (messages<4) {
//				String line = rin.readLine();
//				if(line.length()==15){
//					System.out.println(line);
//					messages++;
//				}
//			}
//
//		} catch (IOException e) {
//			fail(e.toString());
//		} finally{
//			if(c !=null)
//				try {
//					c.close();
//				} catch (IOException e) {
//					fail("Failed to close because: "+e.getMessage());
//				}
//		}
//	}


	public void testReadInterupptedCommStream() {
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
//					System.out.println("Processing char {" +c+'}');
					if(c=='\r'| c=='\n'){
						if(builder.length()==15){
							System.out.println(builder.toString());
						}
						builder.delete(0, 15);
					}else{
						builder.append(c);
//						System.out.println("Appending {"+c+'}');
					}
					
				}
				
			}
			
			public String call() {
				InputConnection c = null;
				byte[] tmp=new byte[1024];
				try {
					c = (InputConnection) instance.createConnection(
							"comm:/dev/rfcomm0", ConnectorService.READ, true);

					InputStream in = c.openInputStream();

					System.out.println("Entering Stream");
					while (!Thread.currentThread().isInterrupted()) {
					      if(in.available()>0){
					          int i=in.read(tmp, 0, 1024);
					          if(i<0)break;
					          process(i, tmp);
					      }
					      System.out.println("Sleeping");
						  TimeUnit.MILLISECONDS.sleep(500);
					     
					}
					message.append(FELL_THROUGH);
					System.out.println("Fell through");

				} catch (IOException e) {
					fail(e.toString());
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
					message.append(INTERRUPTED);
				} finally {
					if (c != null)
						try {
							c.close();
							System.out.println("Closing");
						} catch (IOException e) {
							fail("Failed to close because: " + e.getMessage());
						}
				}

				return message.toString();
			}

		};

		System.out.println("Submitting first Task");
		Future<String> task = completionService.submit(runner);

		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}
		System.out.println("Canceling Stream");
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
		
		System.out.println("Submitting second Task");
		task = completionService.submit(runner);

		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			fail("Should not have this sleep interupted");
			Thread.currentThread().interrupt();
		}
		System.out.println("Canceling Second Stream");
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
//					System.out.println("Entering NIO");
//					while (source.read(buffer) != -1) {
//						buffer.flip();
//						dest.write(buffer);
//						buffer.compact();
//
//						System.out.println("SleepingNIO");
//						TimeUnit.MILLISECONDS.sleep(500);
//						System.out.println("In read loop");
//					}
//					message.append(FELL_THROUGH);
//					System.out.println("Fell through");
//
//				} catch (IOException e) {
//					fail(e.toString());
//				} catch (InterruptedException e) {
//					System.out.println("Interrupted");
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
//		System.out.println("Canceling NIO");
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
