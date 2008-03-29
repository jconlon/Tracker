package com.verticon.tracker.connector.comm;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.microedition.io.InputConnection;

public class CommInputConnection extends AbstractSerialPortConnection implements
		InputConnection {

	public CommInputConnection(String uri, boolean timeouts)
			throws MalformedURLException, NoSuchPortException,
			PortInUseException, UnsupportedCommOperationException {
		super(uri, timeouts);

	}

	public DataInputStream openDataInputStream() throws IOException {
		return new DataInputStream(serialPort.getInputStream());
	}

	public InputStream openInputStream() throws IOException {
		return serialPort.getInputStream();
	}

}
