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
package com.verticon.tracker.connector.socket.experiments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import javax.microedition.io.StreamConnection;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.connector.socket.ConnectionFactoryImpl;

public class CallableConnectionClient {
	private static final String URI = "socket://lantronix:3001";

	// private static final String URI ="socket://192.168.0.118:3001" this works
	// too

	public static void main(String[] args) throws IOException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput;
		Future<Void> future = null;
		System.out.println("Start - Submits task");
		System.out.println("Shutdown - shutsdown the executor after execution");
		System.out
				.println("ShutdownNow - shutsdown the executor with Interrupt");
		System.out.println("Cancel - cancels the future after execution");
		System.out.println("CancelNow - shutsdown the future with interrupt");
		System.out.println(" - Status");

		while ((userInput = stdIn.readLine()) != null) {
			if (userInput.startsWith("Start")) {
				if (future == null || future.isDone()) {
					try {
						String[] startArgs = userInput.split("\\s");
						if(startArgs[1] !=null){
							future = exec.submit(new Task(startArgs[1]));
						}else{
							future = exec.submit(new Task(URI));
						}
					} catch (RejectedExecutionException e) {
						System.out.println("Task submit rejected, executor shutdown="
										+ exec.isShutdown()
										+ " terminated="
										+ exec.isTerminated());

					}
				} else if (!future.isDone()) {
					System.out.println("Can't do that. Task is not done.");
				}
			} else if (userInput.equals("Shutdown")) {
				exec.shutdown();// This does nothing if the task is running

			} else if (userInput.equals("ShutdownNow")) {
				exec.shutdownNow();

			} else if (userInput.equals("Cancel")) {
				if (future != null) {
					future.cancel(false);// This does nothing if the task is
											// running

				} else {
					System.out.println("Can't do that. No Task is running");
				}

			} else if (userInput.equals("CancelNow")) {
				if (future != null) {
					future.cancel(true);

				} else {
					System.out.println("Can't do that. No Task is running");
				}

			} else {
				if (future != null && future.isCancelled()) {
					System.out.println(" Task is canceled, executor shutdown="
							+ exec.isShutdown() + " terminated="
							+ exec.isTerminated());
				} else if (future != null && future.isDone()) {
					System.out.println(" Task is done, executor shutdown="
							+ exec.isShutdown() + " terminated="
							+ exec.isTerminated());
				} else if (future == null) {
					System.out
							.println("Null task. No Task is running, executor shutdown="
									+ exec.isShutdown()
									+ " terminated="
									+ exec.isTerminated());
				} else {
					System.out.println("Task running, executor shutdown="
							+ exec.isShutdown() + " terminated="
							+ exec.isTerminated());
				}
			}
		}
		stdIn.close();
	}


	 
}

class Task implements Callable<Void> {
	 
	private final String uri;
	
	public Task(String uri) {
		super();
		this.uri = uri;
	}

	public Void call() throws Exception {
		StreamConnection connection = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			try {
				ConnectionFactory cfactory = new ConnectionFactoryImpl();
				connection = (StreamConnection) cfactory.createConnection(
						uri, ConnectorService.READ_WRITE, true);

				out = new PrintWriter(connection.openOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(connection
						.openInputStream()));
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host in "+uri);
				throw e;
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for "
						+ "the connection to: lantronix.");
				// e.printStackTrace();
				throw e;
			}

			String userInput = "S";

			while (!Thread.currentThread().isInterrupted()) {
				out.println(userInput);
				// Typically reads will block waiting data
				// Need to timeout on reads so the interrupt will cancel
				// before the read unblocks
				try {
					System.out.println("echo: " + in.readLine());
				} catch (SocketTimeoutException e) {
					// System.out.println("timeout");
				}
			}
		} finally {
			if (out != null) {
				System.out.println("Closing out");
				out.close();
			}
			if (in != null) {
				System.out.println("Closing in");
				in.close();
			}
			if (connection != null) {
				System.out.println("Closing connection");
				connection.close();
			}
		}

		return null;
	}
}
