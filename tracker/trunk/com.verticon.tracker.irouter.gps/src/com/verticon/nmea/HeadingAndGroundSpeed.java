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

import java.util.Date;

import com.verticon.messaging.MessageAppender;

/**
 * $GPVTG is the NMEA 0183 standard Course Over Ground and Ground Speed.
 * 
 * 
 * <p>
 * Examples
 * </p>
 * <ul>
 * <li>$GPVTG,127.6,T,129.0,M,0.0,N,0.0,K,D*2E</li>
 * <li>$GPVTG,10.3,T,11.7,M,0.0,N,0.0,K,D*23</li>
 * 0 1 2 3 4 5 6 7 8 9
 * </ul>
 * 
 * <p>
 * Fields:
 * </p>
 * 
 * <ol>
 * <li>Course Over Ground, degrees True, to the nearest 0.1 degree</li>
 * <li>T = True</li>
 * <li>Course Over Ground, degrees Magnetic, to the nearest 0.1 degree</li>
 * <li>M = Magnetic</li>
 * <li>Speed Over Ground, knots, to the nearest 0.1 knot</li>
 * <li>N = Knots</li>
 * <li>Speed Over Ground, km/hr, to the nearest 0.1 km/hr</li>
 * <li>K = km/hr</li>
 * <li>Mode indicator: A = Autonomous mode D = Differential mode E = Estimated
 * (dead reckoning) mode M = Manual input mode S = Simulator mode N = Data not
 * valid
 * <p>
 * The only values transmitted by the WX Series WeatherStation Sensor for the
 * Mode indicator are A, D, and N.
 * </p>
 * </li>
 * 
 * 
 * </ol>
 * 
 */
public class HeadingAndGroundSpeed implements MessageAppender {

	private static final String HEADING_TRUE = "hdt=";
	private static final String GROUND_SPEED = "spe=";

	private final float heading, speedInKMH;
	private final Date date;

	public HeadingAndGroundSpeed(float heading, float speedInKMH) {
		super();
		this.heading = heading;
		this.speedInKMH = speedInKMH;
		this.date = new Date();
	}

	@Override
	public void appendMessage(StringBuffer output, String delimiter) {
		output.append(delimiter);
		output.append(HEADING_TRUE);
		output.append(heading);
		output.append(delimiter);
		output.append(GROUND_SPEED);
		output.append(speedInKMH);
	}


	public HeadingAndGroundSpeed(String[] sentence) {
		this.heading = Float.parseFloat(sentence[1]);
		this.speedInKMH = Float.parseFloat(sentence[7]);
		this.date = new Date();
	}

	public static boolean canCreateFrom(String message) {
		return message.contains(GROUND_SPEED) && message.contains(HEADING_TRUE);
	}

	@Override
	public Date getDate() {
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("HeadingAndGroundSpeed [date=");
		buf.append(date).append(',');
		appendMessage(buf, ",");
		buf.append(']');
		return buf.toString();
	}
}
