package com.verticon.tracker.connector.bluetooth;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.InputConnection;



public class WrappedConnection implements InputConnection {
	
	private final InputConnection connection;
	
	private DataInputStream dataInputStream = null;
	private InputStream inputStream = null;
	
	public WrappedConnection(InputConnection connection) {
		this.connection=connection;
	}

	public void close() throws IOException {
		
		try {
			connection.close();
			if(dataInputStream != null){
				dataInputStream.close();
			}
			if(inputStream != null){
				inputStream.close();
			}
		} catch (IOException e) {
			throw e;
		}
		
	}

	public DataInputStream openDataInputStream() throws IOException {
		try {
			dataInputStream = connection.openDataInputStream();
			return dataInputStream;
		} catch (IOException e) {
			throw e;
		}
	}

	public InputStream openInputStream() throws IOException {
		try {
			inputStream =  connection.openInputStream();
			return inputStream;
		} catch (IOException e) {
			throw e;
		}
	}

}
