package com.verticon.tracker.connector.comm;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.microedition.io.OutputConnection;

public class CommOutputConnection extends AbstractSerialPortConnection implements OutputConnection{

	
	public CommOutputConnection(String uri, boolean timeouts) throws MalformedURLException, NoSuchPortException,
			PortInUseException, UnsupportedCommOperationException {
		super(uri, timeouts);
	}
	
	public DataOutputStream openDataOutputStream() throws IOException {
		return new DataOutputStream(serialPort.getOutputStream());
	}

	public OutputStream openOutputStream() throws IOException {
		return serialPort.getOutputStream();
	}


}
