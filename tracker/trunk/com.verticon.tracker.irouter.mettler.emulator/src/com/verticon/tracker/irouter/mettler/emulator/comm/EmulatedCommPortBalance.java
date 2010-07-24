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
package com.verticon.tracker.irouter.mettler.emulator.comm;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class EmulatedCommPortBalance {

	private static final int GRAMS_MAX = 480;
	private static final int SLEEP_MINUTES_BETWEEN_RUNS = 1;
	private static final int SLEEP_MILLS_BETWEEN_READS = 500;
	private static final double TRIGGER = .75;

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Usage: java PortTyper portName");
			return;
		}

		try {
			CommPortIdentifier com = CommPortIdentifier
					.getPortIdentifier(args[0]);
			CommPort thePort = com.open("PortOpener", 10);
			emulate(thePort.getOutputStream());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	 static char getChar(double currentWeight){
		
		if(GRAMS_MAX * TRIGGER <= currentWeight){
			return 'x';
		}
		
		return '.';
	}
	
	private static void emulate(OutputStream out) throws IOException {
		double grams = 1.1;
		int count = 0;
		while (true) {
			grams = grams + 3.4;
			String message = String.format("S D %10.2f g\r\n", grams);
			out.write(message.getBytes());
			out.flush();
			try {
				if (grams > GRAMS_MAX) {
					grams = .1;
					count = 0;
					System.out.println("Sleeping");
					TimeUnit.MINUTES.sleep(SLEEP_MINUTES_BETWEEN_RUNS);
					System.out.println("Waking up...");
				} else {
					count++;
					if (count % 80 == 0) {
						System.out.println(getChar( grams));
					} else {
						System.out.print(getChar( grams));
					}
					TimeUnit.MILLISECONDS.sleep(SLEEP_MILLS_BETWEEN_READS);
				}
			} catch (InterruptedException e) {
				break;
			}
		}
		
		
	}
}
