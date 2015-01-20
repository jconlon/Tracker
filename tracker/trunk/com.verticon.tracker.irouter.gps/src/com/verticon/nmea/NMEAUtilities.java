/*******************************************************************************
 * Copyright (c) 2015 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.nmea;

/**
 * Utilites for dealing with NMEA objects.
 * 
 * @author jconlon
 * 
 */
public class NMEAUtilities {

	private NMEAUtilities() {

	}

	private static final double PiOver180 = Math.PI / 180.0;
	

	/**
	 * Convert degrees to radians.
	 * 
	 * @param degrees
	 * @return radians
	 */
	public static double toRadians(double degrees) {
		return degrees * PiOver180;
	}

	/**
	 * Convert radians to degrees.
	 * 
	 * @param radians
	 * @return degrees
	 */
	public static double toDegrees(double radians) {
		return radians / PiOver180;
	}


}
