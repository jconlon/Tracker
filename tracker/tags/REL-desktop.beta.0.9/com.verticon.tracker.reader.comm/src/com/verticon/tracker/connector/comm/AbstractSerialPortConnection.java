package com.verticon.tracker.connector.comm;
import static com.verticon.tracker.connector.comm.CommReaderPlugin.bundleMarker;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for 
 * @author jconlon
 *
 */
public abstract class AbstractSerialPortConnection {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AbstractSerialPortConnection.class);
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
		logger.debug(bundleMarker,"{} closing serialPort",uri);
//				
//		if(Thread.currentThread().isInterrupted()){
//			Thread.interrupted();
//			serialPort.close();
//			Thread.currentThread().interrupt();
//		}else{
			serialPort.close();//This prints a stacktrace due to RxTx but it can't be helped in this release
//		}
//			

		logger.debug(bundleMarker,"{} closed serialPort",uri);
	}

}