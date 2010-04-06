package com.verticon.tracker.connector.comm;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.microedition.io.StreamConnection;

public class CommStreamConnection extends AbstractSerialPortConnection
		implements StreamConnection {

	public CommStreamConnection(String uri, boolean timeouts)
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

	public DataOutputStream openDataOutputStream() throws IOException {
		return new DataOutputStream(serialPort.getOutputStream());
	}

	public OutputStream openOutputStream() throws IOException {
		return serialPort.getOutputStream();
	}

}
