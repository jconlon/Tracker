/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.udp.internal;

import static com.verticon.tracker.irouter.udp.internal.MessageConsumer.POISON;
import static com.verticon.tracker.irouter.udp.internal.MessageConsumer.bundleMarker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Closeables;

/**
 * Sends messages to a UDP host.
 * 
 * @author jconlon
 * 
 */
public class UDPSender implements Callable<Void> {

	private final Logger logger = LoggerFactory.getLogger(UDPSender.class);

	private final int port;
	private final String name;
	
	private final BlockingQueue<String> messageQueue;
	private final String prefix;


	


	UDPSender(String name, int port, BlockingQueue<String> messageQueue,
			String prefix) {
		super();
		this.port = port;
		this.name = name;
		this.messageQueue = messageQueue;
		this.prefix = prefix;

	}


	@Override
	public Void call() throws Exception {
		while (!Thread.currentThread().isInterrupted()) {
			String message = messageQueue.take();
			if (message.equals(POISON)) {
				break;
			}
			String outPut = prefix + message;
			// System.out.println('[' + outPut + "], length=" +
			// outPut.length());
			logger.info(bundleMarker, "Sending [{}], length={}", outPut,
					outPut.length());
			send(outPut.getBytes());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UDPSender [name=" + name + " port=" + port + "]";
	}

	private void send(byte[] buf) throws IOException {
		boolean swallowExcetionsDuringClose = true;
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName(name);

			// send request
			DatagramPacket packet = new DatagramPacket(buf, buf.length,
					address, port);
			socket.send(packet);

		} catch (IOException e) {
			logger.error(bundleMarker, "{} problem sending datagram", this);
		} finally {
			Closeables.close(socket, swallowExcetionsDuringClose);
		}
	}

}
