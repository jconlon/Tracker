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
import java.net.UnknownHostException;

import javax.microedition.io.StreamConnection;

import org.osgi.service.io.ConnectionFactory;
import org.osgi.service.io.ConnectorService;

import com.verticon.tracker.connector.socket.ConnectionFactoryImpl;

public class ConnectionClient {
    private static final String URI = "socket://lantronix:3001";
    //private static final String URI ="socket://192.168.0.118:3001" this works too
    

	public static void main(String[] args) throws IOException {

    	StreamConnection connnection  = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            ConnectionFactory cfactory = new ConnectionFactoryImpl();
             connnection = (StreamConnection) cfactory.createConnection(
            		URI,
            		ConnectorService.READ_WRITE, true);
            
            out = new PrintWriter(connnection.openOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
            		connnection.openInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: lantronix.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: lantronix.");
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

	while ((userInput = stdIn.readLine()) != null) {
	    out.println(userInput);
	    System.out.println("echo: " + in.readLine());
	}

	out.close();
	in.close();
	stdIn.close();
	connnection.close();
    }
}

