package com.verticon.tracker.connector.comm;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.microedition.io.InputConnection;

public abstract class AbstractSerialPortConnection {

	protected String uri;
	protected boolean timeouts;
	protected  SerialPortParmsBean parms;
	protected SerialPort serialPort;
	
	public AbstractSerialPortConnection(String uri, boolean timeouts) throws MalformedURLException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
		super();
		this.uri = uri;
		this.timeouts = timeouts;
		try {
			parms = new SerialPortParmsBean(uri);
		} catch (URISyntaxException e) {
			MalformedURLException ex = new MalformedURLException("Failed to instantiate "+uri);
			ex.initCause(e);
			throw ex;
		}
		CommPortIdentifier comm = CommPortIdentifier.getPortIdentifier(parms.getPortName());
		serialPort = (SerialPort) comm.open("com.verticon.tracker.connector.comm",10);
		parms.setParameters(serialPort);
		
	}
	
	public void close() throws IOException {
		serialPort.close();
	}

}