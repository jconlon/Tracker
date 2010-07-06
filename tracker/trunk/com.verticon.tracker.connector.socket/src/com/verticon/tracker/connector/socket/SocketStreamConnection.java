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
package com.verticon.tracker.connector.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

import javax.microedition.io.StreamConnection;

/**
 * 
 * @author jconlon
 *
 */
public class SocketStreamConnection implements StreamConnection {

	private static final int PORT_TIMEOUT_DEFAULT = 5000;
	private final int port;
	private final String hostName;
	private final boolean timeouts;
	private Socket socket = null;
	
	public static final byte DELAY = 0x01;
	public static final byte LINGER = 0x02;
	public static final byte KEEPALIVE = 0x03;
	public static final byte SENDBUF = 0x04;
	public static final byte RCVBUF = 0x05;
	
	public SocketStreamConnection(String name, boolean timeouts) {//throws MalformedURLException {
		super();
		URI uri = URI.create(name);
		
		if(!uri.getScheme().equals("socket")){
			throw new IllegalArgumentException("Not a socket schema");
		}
		
		
		hostName = uri.getHost();// matcher.group(2);
		if(hostName==null){
			throw new IllegalArgumentException("No hostname found. Check format.");
		}
		port = uri.getPort();// Integer.parseInt(matcher.group(3));
		if(port<0){
			throw new IllegalArgumentException("No port found. Check format.");
		}
		this.timeouts = timeouts;
	}


	@Override
	public DataInputStream openDataInputStream() throws IOException {
		createSocketIfNull();
		return new DataInputStream(socket.getInputStream());
	}


	private void createSocketIfNull() throws UnknownHostException, IOException {
		if(socket == null){
			socket = new Socket(hostName, port);
			if(timeouts){
				socket.setSoTimeout(PORT_TIMEOUT_DEFAULT);
			}
			
		}
	}



	@Override
	public InputStream openInputStream() throws IOException {
		createSocketIfNull();
		return socket.getInputStream();
	}



	@Override
	public void close() throws IOException {
		if(socket != null){
			socket.close();
		}
	}



	@Override
	public DataOutputStream openDataOutputStream() throws IOException {
		createSocketIfNull();
		return new DataOutputStream(socket.getOutputStream());
	}



	@Override
	public OutputStream openOutputStream() throws IOException {
		createSocketIfNull();
		return socket.getOutputStream();
	}
	

	


	public boolean isTimeouts() {
		return timeouts;
	}


	public String getHostName() {
		return hostName;
	}


	public String getAddress() throws IOException{
		if(socket != null && socket.isClosed()){
			throw new IOException("socket is closed.");
		}
		createSocketIfNull();
		return socket.getInetAddress().toString();
		
	}
	
	public int getPort() throws IOException{
		return port;
		
	}
	
	public int getLocalPort() throws IOException{
		if(socket != null && socket.isClosed()){
			throw new IOException("socket is closed.");
		}
		createSocketIfNull();
		return socket.getLocalPort();
	}
	
	public String getLocalAddress() throws IOException{
		if(socket != null && socket.isClosed()){
			throw new IOException("socket is closed.");
		}
		createSocketIfNull();
		return socket.getLocalAddress().toString();
		
	}
	
	public void setSocketOption(byte option, int value) 
		throws IllegalArgumentException, IOException{
		if(socket == null){
			socket = new Socket(hostName, port);
		}else if (socket.isConnected()){
			throw new IOException("Cannot set options on a connected socket.");
		}
		
		switch (option) {
		case LINGER:
			socket.setSoLinger(true, value);
			break;
			
		case KEEPALIVE:
			socket.setKeepAlive(value!=0);
			break;
			
		case RCVBUF:
			socket.setReceiveBufferSize(value);
			break;

		case SENDBUF:
			socket.setSendBufferSize(value);
			break;
			
		default:
			throw new IllegalArgumentException("Unknown option.");
		}
	}
	
	public int getSocketOption(byte option) throws 
		IllegalArgumentException, IOException{
		if(socket == null){
			throw new IOException("Socket does not exist.");
		}
		
		switch (option) {
		case LINGER:
			return socket.getSoLinger();
			
		case KEEPALIVE:
			return socket.getKeepAlive()?1:0;
			
		case RCVBUF:
			return socket.getReceiveBufferSize();
			
		case SENDBUF:
			return socket.getSendBufferSize();
			
		default:
			throw new IllegalArgumentException("Unknown option.");
		}
	}
}
