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
 * The WeatherComposite class models the NMEA 0183 standard Meteorological Composite
 * sentences starting with the prefix: $WIMDA
 * <p>
 * Examples of $WIMDA sentences:
 * </p>
 * <ul>
 * <li>
 * $WIMDA,29.8578,I,1.0111,B,26.1,C,,,16.1,,-1.6,C,0.0,T,1.4,M,0.0,N,0.0,M*7 C</li>
 * <li>
 * $WIMDA,29.8578,I,1.0111,B,26.1,C,,,16.2,,-1.5,C,0.0,T,1.4,M,0.0,N,0.0,M*7 C</li>
 * </ul>
 * 
 * 
 * Fields: </p>
 * <ol>
 * <li>
 * Barometric pressure, inches of mercury, to the nearest 0.01 inch</li>
 * <li>
 * I = inches of mercury</li>
 * <li>Barometric pressure, bars, to the nearest .001 bar</li>
 * <li>B = bars</li>
 * <li>Air temperature, degrees C, to the nearest 0.1 degree C</li>
 * <li>C = degrees C</li>
 * <li>Water temperature, degrees C (this field left blank by the WX Series
 * WeatherStation Sensor)</li>
 * <li>C = degrees C (this field left blank by the WX Series
 * WeatherStationSensor)</li>
 * <li>Relative humidity, percent, to the nearest 0.1 percent (this field left
 * blank if the relative humidity sensor is not available in the WX Series
 * WeatherStation Sensor, see Notes)</li>
 * <li>Absolute humidity, percent (this field left blank by the WX Series
 * WeatherStation Sensor)</li>
 * <li>Dew point, degrees C, to the nearest 0.1 degree C (this field left blank
 * if the relative humidity sensor is not available in the WX Series
 * WeatherStation Sensor, see Notes) <12> C = degrees C</li>
 * <li>Wind direction, degrees True, to the nearest 0.1 degree</li>
 * <li>T = true</li>
 * <li>Wind direction, degrees Magnetic, to the nearest 0.1 degree</li>
 * <li>M = magnetic</li>
 * <li>Wind speed, knots, to the nearest 0.1 knot PRELIMINARY - DRAFT 19 WX
 * Series WeatherStation Technical Manual revision 1.000 Proprietary and
 * Confidential</li>
 * <li></li>
 * <li>Wind speed, meters per second, to the nearest 0.1 m/s</li>
 * <li>Notes N = knots M = meters per second
 * 
 * </ol>
 * 
 */
public class WeatherComposite implements MessageAppender {

	private final Date date;

	/**
	 * 1. Barometric pressure, inches of mercury, to the nearest 0.01 inch
	 */
	private final float pressureInchesOfMercury;
	private static final String PRESSURE = "bar=";

	/**
	 * 3. Barometric pressure, bars, to the nearest .001 bar
	 */
	@SuppressWarnings("unused")
	private final float pressureBars;


	/**
	 * 5. Air temperature, degrees C, to the nearest 0.1 degree C
	 */
	private final float airTempDegrees;
	private static final String TMP = "tmp=";

	/**
	 * 9. Relative humidity, percent, to the nearest 0.1 percent
	 */
	private final float relativeHumidity;
	private static final String RELATIVE_HUMIDITY = "rHm=";
	/**
	 * 11. Dew point, degrees C, to the nearest 0.1 degree C
	 */
	private final float dewPoint;
	private static final String DEWPOINT = "dew=";
	/**
	 * 13. Wind direction, degrees True, to the nearest 0.1 degree
	 */
	private final float windDirectionTrue;
	private static final String WIND_DIRECTION = "wDr=";
	/**
	 * 19. Wind speed, meters per second, to the nearest 0.1 m/s
	 */
	private final float windSpeedMetersPerSecond;

	/**
	 * Windspeed in mph
	 */
	private final double windSpeedMilesPerHour;
	private static final String WIND_SPEED = "wSd=";



	/**
	 * $WIMDA is the NMEA 0183 standard Meteorological Composite.
	 * <p>
	 * Examples
	 * </p>
	 * <ul>
	 * <li>
	 * $WIMDA,29.8578,I,1.0111,B,26.1,C,,,16.1,,-1.6,C,0.0,T,1.4,M,0.0,N,0.0,M*7
	 * C</li>
	 * <li>$WIMDA, 29.8578, I, 1.0111, B, 26.1, C, , , 16.2, , -1.5, C, 0.0,
	 * T,1.4,M,0.0,N,0.0,M*7C</li>
	 * <li>$WIMDA, 28.3636, I, 0.9605, B, 20.4, C, , , 35.2, , 4.5, C, ,
	 * ,,,,,,*40</li>
	 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
	 * </ul>
	 * 
	 * <p>
	 * NMEA 0183 Transducer Measurements. Used in the WX Series WeatherStation
	 * Sensor to provide vessel attitude (pitch and roll) data.
	 * </p>
	 * Fields: </p>
	 * <ol>
	 * <li>
	 * Barometric pressure, inches of mercury, to the nearest 0.01 inch</li>
	 * <li>
	 * I = inches of mercury</li>
	 * <li>Barometric pressure, bars, to the nearest .001 bar</li>
	 * <li>B = bars</li>
	 * <li>Air temperature, degrees C, to the nearest 0.1 degree C</li>
	 * <li>C = degrees C</li>
	 * <li>Water temperature, degrees C (this field left blank by the WX Series
	 * WeatherStation Sensor)</li>
	 * <li>C = degrees C (this field left blank by the WX Series
	 * WeatherStationSensor)</li>
	 * <li>Relative humidity, percent, to the nearest 0.1 percent (this field
	 * left blank if the relative humidity sensor is not available in the WX
	 * Series WeatherStation Sensor, see Notes)</li>
	 * <li>Absolute humidity, percent (this field left blank by the WX Series
	 * WeatherStation Sensor)</li>
	 * <li>Dew point, degrees C, to the nearest 0.1 degree C (this field left
	 * blank if the relative humidity sensor is not available in the WX Series
	 * WeatherStation Sensor, see Notes)</li>
	 * <li>C = degrees C</li>
	 * <li>Wind direction, degrees True, to the nearest 0.1 degree</li>
	 * <li>T = true</li>
	 * <li>Wind direction, degrees Magnetic, to the nearest 0.1 degree</li>
	 * <li>M = magnetic</li>
	 * <li>Wind speed, knots, to the nearest 0.1 knot PRELIMINARY - DRAFT 19 WX
	 * Series WeatherStation Technical Manual revision 1.000 Proprietary and
	 * Confidential</li>
	 * <li></li>
	 * <li>Wind speed, meters per second, to the nearest 0.1 m/s</li>
	 * <li>Notes N = knots M = meters per second
	 * 
	 * </ol>
	 * 
	 * @param sentence
	 */
	public WeatherComposite(String[] sentence) {
		this.date = new Date();
		// 1. Barometric pressure, inches of mercury, to the nearest 0.01 inch
		this.pressureInchesOfMercury = createValue(sentence[1]);

		// 3. Barometric pressure, bars, to the nearest .001 bar
		this.pressureBars = createValue(sentence[3]);

		// 5. Air temperature, degrees C, to the nearest 0.1 degree C
		this.airTempDegrees = createValue(sentence[5]);

		// 9. Relative humidity, percent, to the nearest 0.1 percent
		this.relativeHumidity = createValue(sentence[9]);
	
		 // 11. Dew point, degrees C, to the nearest 0.1 degree C
		this.dewPoint = createValue(sentence[11]);

		// 13. Wind direction, degrees True, to the nearest 0.1 degree
		this.windDirectionTrue = createValue(sentence[13]);

		// 19. Wind speed, meters per second, to the nearest 0.1 m/s
		this.windSpeedMetersPerSecond = createValue(sentence[19]);

		// Windspeed MPH
		if (Float.isInfinite(windSpeedMetersPerSecond)
				|| Float.isNaN(windSpeedMetersPerSecond)) {
			this.windSpeedMilesPerHour = Double.NaN;
		} else {
			this.windSpeedMilesPerHour = windSpeedMetersPerSecond * 2.2369362920544;
		}

	}

	private static float createValue(String s) throws NumberFormatException {
		float value = Float.NaN;
		if (s != null && s.trim().length() > 0) {
			value = Float.parseFloat(s);
		}
		return value;
	}

	@Override
	public void appendMessage(StringBuffer output, String delimiter) {
		appendFloatValue(output, delimiter, this.airTempDegrees, TMP, "%.1f");
		appendFloatValue(output, delimiter, this.pressureInchesOfMercury,
				PRESSURE, "%.2f");
		appendFloatValue(output, delimiter, this.dewPoint, DEWPOINT, "%.1f");
		appendFloatValue(output, delimiter, this.relativeHumidity,
				RELATIVE_HUMIDITY, "%.1f");
		appendFloatValue(output, delimiter, this.windDirectionTrue,
				WIND_DIRECTION, "%.1f");
		appendDoubleValue(output, delimiter, this.windSpeedMilesPerHour,
				WIND_SPEED);
	}

	@Override
	public Date getDate() {
		return date;
	}

	private void appendFloatValue(StringBuffer output, String delimiter,
			float value, String label,String format) {
		if (value != Float.NaN) {
			output.append(delimiter);
			output.append(label);
			output.append(String.format(format, value));
		}
	}

	private void appendDoubleValue(StringBuffer output, String delimiter,
			double value, String label) {
		if (value != Double.NaN) {
			output.append(delimiter);
			output.append(label);
			output.append(String.format("%.3f", value));
		}
	}

	public static boolean canCreateFrom(String message) {
		return message.contains(TMP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("WeatherComposite [date=");
		buf.append(date).append(',');
		appendMessage(buf, ",");
		buf.append(']');
		return buf.toString();
	}

}
