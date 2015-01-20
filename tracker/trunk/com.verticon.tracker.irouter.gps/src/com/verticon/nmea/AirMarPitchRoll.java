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
 * <p>
 * Models Proprietary Airmar Pitch and Roll sentences
 * </p>
 * <p>
 * Examples
 * </p>
 * <ul>
 * <li>
 * $YXXDR, A,0.1,D,PTCH, A,-2.0,D,ROLL*73</li>
 * <li>
 * $YXXDR, A,0.0,D,PTCH, A,-1.8,D,ROLL*79</li>
 * </ul>
 * 
 * <p>
 * NMEA 0183 Transducer Measurements. Used in the WX Series WeatherStation
 * Sensor to provide vessel attitude (pitch and roll) data.
 * </p>
 * Syntax The fields in the B version of the XDR sentence are as follows:
 * <ol>
 * <li>A = angular displacement</li>
 * <li>Pitch: oscillation of vessel about its latitudinal axis. Bow moving up is
 * positive. Value reported to the nearest 0.1 degree.</li>
 * <li>D = degrees</li>
 * <li>PTCH (ID indicating pitch of vessel)</li>
 * <li>A = angular displacement</li>
 * <li>Roll: oscillation of vessel about its longitudinal axis. Roll to the
 * starboard is positive. Value reported to the nearest 0.1 degree.</li>
 * <li>D = degrees</li>
 * <li>ROLL (ID indicating roll of vessel)</li>
 * </ol>
 * <p>
 * Notes
 * </p>
 * The reported pitch and roll values are adjusted by the azimuth, pitch, and
 * roll offsets established with the $PAMTC,ATTOFF command.
 * 
 */
public class AirMarPitchRoll implements MessageAppender {

	private static final String ROL = "rol=";
	private static final String PTC = "ptc=";

	private final float pitchDegrees, rollDegrees;
	private final Date date;

	public AirMarPitchRoll(float pitchDegrees, float rollDegrees) {
		super();
		this.pitchDegrees = pitchDegrees;
		this.rollDegrees = rollDegrees;
		this.date = new Date();
	}

	@Override
	public void appendMessage(StringBuffer output, String delimiter) {
		output.append(delimiter);
		output.append(PTC);
		output.append(pitchDegrees);
		output.append(delimiter);
		output.append(ROL);
		output.append(rollDegrees);
	}


	public AirMarPitchRoll(String[] sentence) {
		this.pitchDegrees = Float.parseFloat(sentence[2]);
		this.rollDegrees = Float.parseFloat(sentence[6]);
		this.date = new Date();
	}

	public static boolean canCreateFrom(String message) {
		return message.contains(PTC) && message.contains(ROL);
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
		StringBuffer buf = new StringBuffer("AirMarPitchRoll [date=");
		buf.append(date).append(',');
		appendMessage(buf, ",");
		buf.append(']');
		return buf.toString();
	}
}
