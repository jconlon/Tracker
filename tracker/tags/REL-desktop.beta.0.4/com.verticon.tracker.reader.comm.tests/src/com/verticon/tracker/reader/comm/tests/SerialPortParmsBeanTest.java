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

import gnu.io.SerialPort;

import java.net.URISyntaxException;

import junit.framework.TestCase;

import com.verticon.tracker.connector.comm.SerialPortParmsBean;


/**
 * @author jconlon
 * 
 */
public class SerialPortParmsBeanTest extends TestCase {

	SerialPortParmsBean instance;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSerialPortParmsBeanConstruction() {
		try {
			instance = new SerialPortParmsBean("");
			fail("Should have thrown an exception");
		} catch (URISyntaxException e) {

		}
		assertNull(instance);

		try {
			instance = new SerialPortParmsBean(null);
			fail("Should have thrown an URISyntaxException");
		} catch (URISyntaxException e) {

		}
		
		try {
			instance = new SerialPortParmsBean("Comm:funky=2");
			fail("Should have thrown an URISyntaxException");
		} catch (URISyntaxException e) {
			assertEquals("Comm is an unsupported schema. The schema must be comm.", e.getReason());
		}

		try {
			instance = new SerialPortParmsBean("comm:funky=2");
			fail("Should have thrown an URISyntaxException");
		} catch (URISyntaxException e) {
			assertEquals("funky=2 is an unsupported schemaSpecificPart. The first token must be a comm port name.", e.getReason());
		}
		
		try {
			instance = new SerialPortParmsBean("comm:COM1;baudrate=300");
			assertEquals("COM1", instance.getPortName());
			assertEquals(300, instance.getBaudRate());
			//rest are defaults
			assertEquals(SerialPort.DATABITS_8, instance.getDataBits());
			assertEquals(SerialPort.FLOWCONTROL_NONE, instance.getFlowControl());
			assertEquals(SerialPort.PARITY_NONE, instance.getParity());
			assertEquals(SerialPort.STOPBITS_1, instance.getStopBits());
		} catch (URISyntaxException e) {
			fail(e.toString());
		}
		
		try {
			instance = new SerialPortParmsBean("comm:COM1;baudrate=300;stopbits=1.5");
			assertEquals("COM1", instance.getPortName());
			assertEquals(300, instance.getBaudRate());
			assertEquals(SerialPort.STOPBITS_1_5, instance.getStopBits());
			//rest are defaults
			assertEquals(SerialPort.DATABITS_8, instance.getDataBits());
			assertEquals(SerialPort.FLOWCONTROL_NONE, instance.getFlowControl());
			assertEquals(SerialPort.PARITY_NONE, instance.getParity());
			
		} catch (URISyntaxException e) {
			fail(e.toString());
		}
		
		try {
			instance = new SerialPortParmsBean("comm:/dev/stty0;baudrate=19200;databits=7;parity=M;stopbits=2;flowcontrol=xonxoffin");

			assertEquals("/dev/stty0", instance.getPortName());
			assertEquals(19200, instance.getBaudRate());
			assertEquals(SerialPort.STOPBITS_2, instance.getStopBits());
			assertEquals(SerialPort.DATABITS_7, instance.getDataBits());
			assertEquals(SerialPort.FLOWCONTROL_XONXOFF_IN, instance.getFlowControl());
			assertEquals(SerialPort.PARITY_MARK, instance.getParity());
			
		} catch (URISyntaxException e) {
			fail(e.toString());
		}

	}
}
