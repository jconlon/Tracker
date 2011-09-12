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
package com.verticon.tracker.irouter.gps.dev.test.system.internal;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayListWithCapacity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;

import junit.framework.TestCase;

import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Closeables;
import com.google.common.io.Files;

/**
 * 
 * This System test is for testing GPS devices and capturing sentences in an Output
 * file that are used by the com.verticon.irouter.gps.dev.fake project as output
 * sentences.  See the Output directory for the captured sentences.
 * 
 * Initially bluetooth and socket connected gps were tested although other 
 * gps devices with other connections should work as well.
 * 
 * ConnectorService is an OSGi service factory for creating connections based on
 * a URI. <b>ConnectionFactoryImpl</b> provides a socket based connection.
 * 
 * This system test finds the ConnectorService and tests the underlying
 * socket or bluetooth GPS connections. 
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

	
	private static final int NUMBER_OF_SENTENCES_TO_CAPTURE = 100;
	private static final String CAPTURED_SENTENCES_FILE = "Output/test.txt";
	

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ConnectionFactoryServiceTest.class);


	private static ConnectorService connectorService;
	/**
	 * To synchronize the DS and JUnit initializations.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);
//	private final static String TARGET_SERVER = 
//		"btspp://001C881333D6:1;authenticate=false;encrypt=false;master=false";
	
	private final static String TARGET_SERVER = "socket://localhost:2343";
	
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

	public void startup() {
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

	public void test_ConnectionFactory_service() {
		assertNotNull(connectorService);
	}

	public void test_Connection() throws IOException {
		Connection con = connectorService.open(TARGET_SERVER,
				ConnectorService.READ, true);

		assertNotNull(con);

		assertTrue("but was "+con.getClass(), con instanceof InputConnection);

		InputConnection ssc = (InputConnection) con;
		
		List<String> messages = newArrayListWithCapacity(NUMBER_OF_SENTENCES_TO_CAPTURE);


		BufferedReader in = null;
		boolean threw = true;
		try {
			is = ssc.openInputStream();
			assertNotNull(is);
			in = new BufferedReader(new InputStreamReader(is));
			
			while(messages.size()<NUMBER_OF_SENTENCES_TO_CAPTURE){
				String message = in.readLine();
				if(isNullOrEmpty(message)){
					throw new IOException("Recieved a null or empty message.");
				}
				logger.debug("Read message={}",message);
				messages.add(message);
			}
			threw = false;
		} finally {
			Closeables.close(in, threw);
			
		}
		
		assertFalse(messages.isEmpty());
		assertEquals(NUMBER_OF_SENTENCES_TO_CAPTURE, messages.size());
		
		File file = new File(CAPTURED_SENTENCES_FILE);
		Files.write("", file, Charsets.UTF_8);
		for (String string : messages) {
			Files.append(string+"\n", file, Charsets.UTF_8);
		}
		
	}

	/*
	 * Examples and format of the primary sentence used by the GPSProxy: GGA
	 *  GGA - Global Positioning System Fix Data
        GGA,123519,    4807.038, N,01131.324, E,1,08,0.9,  545.4,M, 46.9,M,    ,*42
        
        GGA,234838.404,4328.5692,N,09057.1154,W,6,0 ,99.99,352.7,M,-34.0,M,    ,*59
        GGA,234839.204,4328.5692,N,09057.1153,W,2,8 ,1.05, 352.7,M,-34.0,M,0000,0000*61 
        GGA,234841.000,4328.5694,N,09057.1151,W,2,10,0.88, 352.7,M,-34.0,M,0000,0000*51 
        
           123519       Fix taken at 12:35:19 UTC
           4807.038,N   Latitude 48 deg 07.038' N
           01131.324,E  Longitude 11 deg 31.324' E
           1            Fix quality: 0 = invalid
                                     1 = GPS fix
                                     2 = DGPS fix
           08           Number of satellites being tracked
           0.9          Horizontal dilution of position
           545.4,M      Altitude, Metres, above mean sea level
           46.9,M       Height of geoid (mean sea level) above WGS84
                        ellipsoid
           (empty field) time in seconds since last DGPS update
           (empty field) DGPS station ID number

	 */

}
