package com.verticon.tracker.connector.bluetooth;
import static com.verticon.tracker.connector.bluetooth.BluetoothReaderPlugin.bundleMarker;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.InputConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WrappedConnection implements InputConnection {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(WrappedConnection.class);
	private final InputConnection connection;
	
	private DataInputStream dataInputStream = null;
	private InputStream inputStream = null;
	
	public WrappedConnection(InputConnection connection) {
		logger.debug(bundleMarker,"Constructing wrapped connection");
		this.connection=connection;
	}

	public void close() throws IOException {
		
		try {
			logger.debug(bundleMarker,"Closing connection");
			connection.close();
			if(dataInputStream != null){
				logger.debug(bundleMarker,"Closing dataInputStream");
				dataInputStream.close();
			}
			if(inputStream != null){
				logger.debug(bundleMarker,"Closing inputStream");
				inputStream.close();
			}
		} catch (IOException e) {
			logger.error(bundleMarker,"Failed to close connection",e);
			throw e;
		}
		
	}

	public DataInputStream openDataInputStream() throws IOException {
		logger.info(bundleMarker,"Opening DataInputStream connection");
		try {
			dataInputStream = connection.openDataInputStream();
			return dataInputStream;
		} catch (IOException e) {
			logger.error(bundleMarker,"Failed to open connection",e);
			throw e;
		}
	}

	public InputStream openInputStream() throws IOException {
		logger.debug(bundleMarker,"Opening InputStream connection");
		try {
			inputStream =  connection.openInputStream();
			return inputStream;
		} catch (IOException e) {
			logger.error(bundleMarker,"Failed to open connection",e);
			throw e;
		}
	}

}
