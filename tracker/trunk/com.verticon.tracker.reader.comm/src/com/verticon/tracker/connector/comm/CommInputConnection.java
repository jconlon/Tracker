package com.verticon.tracker.connector.comm;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.microedition.io.InputConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InputConnection for SerialPorts. Offers InputStream and DataInputStream.
 * @author jconlon
 *
 */
public class CommInputConnection extends AbstractSerialPortConnection implements
		InputConnection {
	
//	private InputStream inputStream;
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(this.getClass());

	public CommInputConnection(String uri, boolean timeouts)
			throws MalformedURLException, NoSuchPortException,
			PortInUseException, UnsupportedCommOperationException {
		super(uri, timeouts);

	}

	public DataInputStream openDataInputStream() throws IOException {
		return new DataInputStream(serialPort.getInputStream());
	}

	public InputStream openInputStream() throws IOException {
		logger.debug("{} opening inputStream",uri);
		return serialPort.getInputStream();
	}
	
	public void close() throws IOException {
		logger.debug("{} closing serialPort",uri);
		super.close();
	}

}
