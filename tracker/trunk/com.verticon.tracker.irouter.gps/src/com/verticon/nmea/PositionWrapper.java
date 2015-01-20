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

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;

import com.verticon.messaging.MessageAppender;

/**
 * Wrapper for assisting with Position Objects.
 * 
 * @author jconlon
 * 
 */
public class PositionWrapper implements MessageAppender {
	private static final String LOC = "loc=";
	static final String ALT = "alt=";
	// static final String LNG = "lng=";
	// static final String LAT = "lat=";
	static final String GPS = "GPS=";

	public PositionWrapper(Position position) {
		super();
		this.position = position;
	}

	public PositionWrapper(String[] s, long timeStamp, double longError,
			double latError, double altError) {
		this(create(s, timeStamp, longError, latError, altError));
	}

	private final Position position;

	@Override
	public void appendMessage(StringBuffer output, String delimiter) {
		if (position == null) {
			return;
		}
		Double latDegrees = NMEAUtilities.toDegrees(position.getLatitude()
				.getValue());
		Double longDegrees = NMEAUtilities.toDegrees(position.getLongitude()
				.getValue());
		if (!latDegrees.equals(Double.NaN) && !longDegrees.equals(Double.NaN)) {
			output.append(delimiter);
			output.append(LOC);
			output.append(String.format("%.4f", latDegrees));
			output.append(',');
			output.append(String.format("%.4f", longDegrees));
			output.append(delimiter);
			output.append(GPS);
			output.append(String.format("%.3f",
					convertToDegreesMinutes(latDegrees)));
			output.append('_');
			output.append(String.format("%.3f",
					convertToDegreesMinutes(longDegrees)));
		}

		Double alt = position.getAltitude().getValue();
		if (!alt.equals(Double.NaN)) {
			output.append(delimiter);
			output.append(ALT);
			output.append(String.format("%.4f", alt));
		}
		
		

	}

	private double convertToDegreesMinutes(double value) {

		double fractionalPart = value % 1;
		double integralPart = value - fractionalPart;

		double minutes = fractionalPart * 60;

		double out = integralPart * 100;

		return out + minutes;

	}

	@Override
	public Date getDate() {
		if (position != null) {
			return new Date(position.getLatitude().getTime());
		}
		return null;
	}

	public Position getPosition() {
		return position;
	}

	public static boolean canCreateFrom(String message) {
		return message.contains(LOC) && message.contains(GPS)
				&& message.contains(ALT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (position == null) {
			return "Position";
		}
		StringBuffer buf = new StringBuffer("Position [date=");
		buf.append(getDate());
		buf.append(',');
		appendMessage(buf, ",");
		buf.append(']');
		return buf.toString();
	}

	public static Position create(String[] s, long timeStamp, double longError,
			double latError, double altError) {
		// Latitude
		String raw_lat = s[2];
		String lat_deg = raw_lat.substring(0, 2);
		String lat_min1 = raw_lat.substring(2, 4);
		String lat_min2 = raw_lat.substring(5);
		String lat_min3 = "0." + lat_min1 + lat_min2;
		float lat_val = 0;
		try {
			float lat_dec = Float.parseFloat(lat_min3) / .6f;
			lat_val = Float.parseFloat(lat_deg) + lat_dec;

			// Latitude direction
			String lat_direction = s[3];
			if (lat_direction.equals("N")) {
				// do nothing
			} else {
				lat_val = lat_val * -1;
			}
		} catch (NumberFormatException e2) {
			throw new IllegalArgumentException(String.format(
					"Could not parse latitude=%s", s[2]));
		}

		// Longitude
		String raw_lon = s[4];
		String lon_deg = raw_lon.substring(0, 3);
		String lon_min1 = raw_lon.substring(3, 5);
		String lon_min2 = raw_lon.substring(6);
		String lon_min3 = "0." + lon_min1 + lon_min2;
		float lon_val = 0;
		try {
			float lon_dec = Float.parseFloat(lon_min3) / .6f;
			lon_val = Float.parseFloat(lon_deg) + lon_dec;
			// Longitude direction
			String lon_direction = s[5];
			if (lon_direction.equals("E")) {
				// do nothing
			} else {
				lon_val = lon_val * -1;
			}
		} catch (NumberFormatException e1) {
			throw new IllegalArgumentException(String.format(
					"Could not parse longitude=%s", s[4]));
		}

		Measurement latitude = new Measurement(
				NMEAUtilities.toRadians(lat_val), latError, Unit.rad, timeStamp);

		Measurement longitude = new Measurement(
				NMEAUtilities.toRadians(lon_val), longError, Unit.rad,
				timeStamp);

		double altitudeInMeters;
		try {
			altitudeInMeters = Double.parseDouble(s[9]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format(
					"Could not parse altitude=%s", s[9]));
		}
		Measurement altitude = new Measurement(altitudeInMeters, altError,
				Unit.m, timeStamp);

		return new Position(latitude, longitude, altitude, null, null);

	}

}