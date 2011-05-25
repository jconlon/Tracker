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
package com.verticon.tracker.irouter.gps.dev.fake.internal;

import static com.google.common.base.Preconditions.checkState;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.equinoxosgi.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * Fake GPS Server is used for testing. The type of Server is determined by the
 * property gps.fake.type and the default is a ServerSocket.
 * 
 * Socket is determined by the property gps.fake.socket and the default is 2343.
 * 
 * Port is determined by the property gps.fake.port and there is no default.
 * 
 * 
 * @author jconlon
 * 
 */
public class FakeGPSServer implements IDeviceListener {

	static String PLUGIN_ID = "com.verticon.tracker.irouter.gps.dev.fake";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(FakeGPSServer.class);


	private static final String FILE_OF_SENTENCES = "/com.verticon.tracker.irouter.gps.dev.fake/src/test.txt";
	private static final String DEFAULT_SOCKET = "2343";
	private static final String MY_PREFIX = "gps.fake.";
	private static List<String> lines = null;

	public FakeGPSServer() {
		logger.info(bundleMarker, "{} waiting for connections on socket://localhost:{}, ",this,getProperty(Property.SOCKET));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FakeGPSServer [" + MY_PREFIX + getProperty(Property.TYPE) + "]";
	}

	@Override
	public Object getProperty(Property prop) {
		switch (prop) {
		case PREFIX:
			return MY_PREFIX;
		case TYPE:
			String type = PropertyManager.getProperty(MY_PREFIX
					+ Property.TYPE.toString().toLowerCase(),
					Constants.DeviceType.SERVER_SOCKET.name()// default is a
																// serversocket
					);
			return Constants.DeviceType.valueOf(type);
		case SOCKET:
			Object result = PropertyManager.getProperty(MY_PREFIX
					+ prop.toString().toLowerCase(), DEFAULT_SOCKET

			);
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}

			if (result instanceof String) {
				return new Integer((String) result);

			} else {
				throw new IllegalArgumentException("Unknown property type "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}

		default:
			result = PropertyManager.getProperty(MY_PREFIX
					+ prop.toString().toLowerCase());
			if (result == null) {
				throw new IllegalArgumentException("Unknown property "
						+ MY_PREFIX + prop.toString().toLowerCase());
			}
			return result;
		}
	}

	void connect(){
		int s = (Integer) getProperty(Property.SOCKET);
		Socket socket = null;
		ServerSocket ss = null;
		while(!Thread.currentThread().isInterrupted()){
		try {
			ss = new ServerSocket(s);
			try {
//			ss.setSoTimeout(100);
			    logger.info(bundleMarker, "{} waiting at socket://localhost:{}, ",this,getProperty(Property.SOCKET));
			    socket = ss.accept();
			    logger.info(bundleMarker, "{} accepted socket://localhost:{}, ",this,getProperty(Property.SOCKET));
			    connected(socket.getOutputStream(), socket.getInputStream());
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					socket.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
		logger.info(bundleMarker, "{} connected socket://localhost:{}, ",this,getProperty(Property.SOCKET));

		if (lines == null) {
			URI uri = URI.createPlatformPluginURI(FILE_OF_SENTENCES, true);
			uri = CommonPlugin.resolve(uri);
			File file = null;
			if(uri.isFile()){
				checkState(uri.isFile(), uri + " is not a file");
				 file = new File(uri.toFileString());
			}else{
				//Standalone launch get the file as a resource
				file = new File(getClass().getResource("/test.txt").getFile());
			}
			checkState(file.exists(), file.toString() + " does not exist");
			lines = Files.readLines(file, Charsets.UTF_8);
		}

		String output;
		while (!Thread.currentThread().isInterrupted()) {
			for (String line : lines) {
				output = line + "\r\n";
				out.write(output.getBytes());
				out.flush();
			}
		}

		logger.info(bundleMarker, "{} disconnected from socket://localhost:{}, ",this,getProperty(Property.SOCKET));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime
				* result
				+ ((getProperty(Property.TYPE) == null) ? 0 : getProperty(
						Property.TYPE).hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FakeGPSServer other = (FakeGPSServer) obj;
		if (getProperty(Property.TYPE) != other.getProperty(Property.TYPE))
			return false;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FakeGPSServer().connect();

	}

}
