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
