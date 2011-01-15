/*******************************************************************************
 * Copyright (c) 2009 Paul VanderLei, Simon Archer, Jeff McAffer and others. All
 * rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Toast is an Equinox/OSGi system developed for the book Eclipse, Equinox and
 * OSGi - Creating Highly Modular Java Applications See http://equinoxosgi.org
 * 
 * Contributors: Paul VanderLei, Simon Archer and Jeff McAffer - initial API and
 * implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.gps.sim.internal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.equinoxosgi.toast.devsim.IDeviceSimulator;
import org.equinoxosgi.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.irouter.dev.Constants;
import com.verticon.tracker.irouter.dev.Constants.Property;
import com.verticon.tracker.irouter.dev.IDeviceListener;

/**
 * Simulates a GPS that is controlled from a web page that sends out two valid Nema sentences:
 * GPGGA GPRMC and a erroneous one. 
 * <ol>
 * <li>current time UTC</li>
 * <li>current date UTC</li>
 * <li>simulated  latitude</li>
 * <li>simulated longitude</li>
 * <li>simulated altitude</li>
 * <li>simulated heading</li>
 * <li>simulated speed</li>
 * <li>current connection status</li>
 * </ol>
 * 
 * @author Paul VanderLei, Simon Archer, Jeff McAffer and John Conlon
 *
 */
public class GpsSimulator implements IDeviceListener {
	private static final String ALTITUDE = "Altitude";

	private static final String CONNECTION = "Connection";

	/**
	 * Identify the plugin to the logger
	 */
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.gps.dev.sim";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	private static final SimpleDateFormat TIME_FORMAT_GMT = new SimpleDateFormat(
			"HHmmss");
	private static final SimpleDateFormat DATE_FORMAT_GMT = new SimpleDateFormat(
	"ddMMyy");//230394 Date - 23rd of March 1994
	static {
		TIME_FORMAT_GMT.setTimeZone(TimeZone.getTimeZone("GMT"));
		DATE_FORMAT_GMT.setTimeZone(TimeZone.getTimeZone("GMT"));
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	protected Logger log = LoggerFactory.getLogger(GpsSimulator.class);
	private static final String DEFAULT_TIME_SECONDS = "2";
	private static final String MY_PREFIX = "gps.sim.";
	
	private static final DecimalFormat MINUTES_FORMAT = new DecimalFormat(
			"00.0000");
	private static final DecimalFormat KNOTS_FORMAT = new DecimalFormat(
			"000.0");
	private static final DecimalFormat ALTITUDE_FORMAT = new DecimalFormat(
			"##0.0");
	private static final DecimalFormat LONGITUDE_FORMAT = new DecimalFormat(
			"000");
	private static final DecimalFormat LATITUDE_FORMAT = new DecimalFormat(
			"00");
	private static final DecimalFormat TRACK_FORMAT = new DecimalFormat(
			"000.0");//084.4
	private int secondsBetweenOutput = 2;
	private AtomicBoolean run = new AtomicBoolean(true);
	private List<String> messages = new LinkedList<String>();

	private static final String COMPASS = "compass";
	private static final String GPS = "GPS";
	private static final String SPEED = "Speed";
	private IDeviceSimulator simulator;
	private GpsCompassSensor compass;
	private GpsSpeedSensor speed;
	private GpsSpeedSensor altitude;

	int getHeading() {
		return compass.getHeading();
	}

	int getLatitude() {
		return compass.getLatitude();
	}

	int getLongitude() {
		return compass.getLongitude();
	}

	int getSpeed() {
		return simulator.getIntegerValue(GPS, SPEED);
	}
	
	int getAltitude() {
		return simulator.getIntegerValue(GPS, ALTITUDE);
	}

	public void setDevSim(IDeviceSimulator value) {
		simulator = value;
	}

	public void shutdown() {
		run.set(false);
		simulator.unregisterDevice(GPS);
		messages.clear();
	}

	public void startup() {
		String timing = PropertyManager.getProperty(MY_PREFIX + "timer.secs",
				DEFAULT_TIME_SECONDS);
		try {
			secondsBetweenOutput = Integer.parseInt(timing);
		} catch (NumberFormatException e) {
			log.warn(bundleMarker,
					"Failed to parse the {}{} setting default to 2 seconds.",
					MY_PREFIX, "timer.secs");
		}

		simulator.registerDevice(GPS, GPS);
		simulator.addBooleanActuator(GPS, CONNECTION, CONNECTION);
		compass = new GpsCompassSensor(COMPASS, COMPASS);
		simulator.addParameter(compass, GPS);
		speed = new GpsSpeedSensor(SPEED, SPEED, 0, 250, 0, 5, 50, "kph");
		altitude = new GpsSpeedSensor(ALTITUDE, ALTITUDE, 0, 250, 0, 5, 50, "meters");
		
		simulator.addParameter(speed, GPS);
		simulator.addParameter(altitude, GPS);
		run.set(true);
		log.debug(bundleMarker, "Started");
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
					+ prop.toString().toLowerCase(), "2343"

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

	@Override
	public void connected(OutputStream out, InputStream in) throws IOException,
			InterruptedException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		log.info(bundleMarker, "Connected");
		simulator.setBooleanValue(GPS, CONNECTION, true);
		IOException ex = null;
		try {
			while (!Thread.currentThread().isInterrupted() && run.get()) {
				for (String reply : process()) {
					if (reply != null) {
						writer.write(reply);
						log.debug(bundleMarker, "Replying {}", reply);
					}
				}
				writer.flush();

			}
		} catch (IOException e) {
			ex = e;
		} finally {
			log.info("Disconnected");
			simulator.setBooleanValue(GPS, CONNECTION, false);
		}
		if (ex != null) {
			throw ex;
		}

	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	private Iterable<String> process() throws InterruptedException {
		TimeUnit.SECONDS.sleep(secondsBetweenOutput);
		messages.clear();
		Date now = new Date();
		String time = TIME_FORMAT_GMT.format(now) + ".000";//123519 Fix taken at 12:35:19 UTC
		String date = DATE_FORMAT_GMT.format(now);
		String lattitude = getOutput(getLatitude(), 'N', 'S', LATITUDE_FORMAT);
		String lon = getOutput(getLongitude(), 'W', 'E', LONGITUDE_FORMAT);
		String altitude = getOutputAltitude();
		messages.add(buildGPGGA(time, lattitude, lon, altitude));
		//Add a fill message
		messages.add("$GPGSA,A,3,02,10,05,12,25,29,,,,,,,4.28,1.94,3.81*03\r\n");
		messages.add(buildGPRMC(time, date, lattitude, lon));
		return messages;
	}

	/**
	 * GGA - essential fix data which provide 3D location and accuracy data.
	 * 
	 * $GPGGA,123519,     4807.038,N,01131.000 ,E,1,08,0.9,  545.4,M, 46.9,M,,*47
	 * 
	 * Where: GGA Global Positioning System Fix Data 
	 * 123519 Fix taken at 12:35:19 UTC 
	 * 4807.038,N Latitude 48 deg 07.038' N 
	 * 01131.000,E Longitude 11 deg 31.000' E 
	 * 1 Fix quality: 0 = invalid 1 = GPS fix (SPS) 2 = DGPS
	 * fix 3 = PPS fix 4 = Real Time Kinematic 5 = Float RTK 6 = estimated (dead
	 * reckoning) (2.3 feature) 7 = Manual input mode 8 = Simulation mode 
	 * 
	 * 08 Number of satellites being tracked 
	 * 0.9 Horizontal dilution of position
	 * 545.4,M Altitude, Meters, above mean sea level 
	 * 46.9,M Height of geoid (mean sea level) above WGS84 ellipsoid 
	 * (empty field) time in seconds since last DGPS update (empty field) DGPS station ID number 
	 * 47 the checksum data, always begins with *
	 * 
	 * @param time
	 * @param lattitude
	 * @param lon
	 * @param altitude
	 * @return
	 */
	private String buildGPGGA(String time, String lattitude, String lon,
			String altitude) {
		StringBuilder sb = new StringBuilder("$GPGGA,");
		sb.append(time);// 1
		sb.append(',');
		sb.append(lattitude);// 2,3
		sb.append(',');
		sb.append(lon);// 4,5
		sb.append(",1,6,");// quality 6 satelliteCount 7
		sb.append("1.94,");// Horizontal dilution of position 8
		sb.append(altitude);// 9,10
		sb.append(",-34.0,M,");// height of the geoid
		// ?
		sb.append(",*");
		String check = getChecksum(sb.toString());
		sb.append(check);
		sb.append("\r\n");
		return sb.toString();
	}

	/**
	 * RMC - NMEA has its own version of essential gps pvt (position, velocity, time) data. 
	 * It is called RMC, The Recommended Minimum, which will look similar to: 
	 * 
	 * $GPRMC,123519,    A,4807.038, N,01131.000, E,022.4,084.4,230394,003.1,W*6A
	 * 
	 * Where: RMC Recommended Minimum sentence C 
	 * 123519 Fix taken at 12:35:19 UTC 
	 * A Status A=active or V=Void. 
	 * 4807.038,N Latitude 48 deg 07.038' N
	 * 01131.000,E Longitude 11 deg 31.000' E 
	 * 022.4 Speed over the ground in knots 
	 * 084.4 Track angle in degrees True 
	 * 230394 Date - 23rd of March 1994
	 * 003.1,W Magnetic Variation 
	 * 6A The checksum data, always begins with *
	 * 
	 * 
	 * @param time
	 * @param lattitude
	 * @param lon
	 * @param altitude
	 * @return
	 */
	private String buildGPRMC(String time, String date, String lattitude, String lon) {
		StringBuilder sb = new StringBuilder("$GPRMC,");

		sb.append(time);// 1
		sb.append(",A,");//2
		sb.append(lattitude);// 2,3
		sb.append(',');
		sb.append(lon);// 4,5
		sb.append(',');
		double knots = getSpeed()/1.852;
		sb.append(KNOTS_FORMAT.format(knots));// 022.4 Speed over the ground in knots 
		sb.append(',');
		double track = getHeading();
		sb.append(TRACK_FORMAT.format(track));//084.4 Track angle in degrees True 
		sb.append(',');
		sb.append(date);// 230394 Date - 23rd of March 1994
		sb.append(',');
		sb.append("003.1,W");// 003.1,W Magnetic Variation 
		sb.append('*');
		String check = getChecksum(sb.toString());
		sb.append(check);
		sb.append("\r\n");
		return sb.toString();
	}

	String getOutputAltitude() {
		double alt =  simulator.getIntegerValue(GPS, ALTITUDE);
		String out = ALTITUDE_FORMAT.format(alt);
		return out+",M";
	}

	private String getOutput(int raw, char neg, char pos,
			DecimalFormat dfDegrees) {
		String append = "," + neg;
		if (raw < 0) {
			raw = raw * -1;
			append = "," + pos;
		}
		double degrees = 1.0 * raw / 100000;
		double fraction = degrees % 1;
		String firstDegrees = dfDegrees.format(degrees);
		double minutesAsDecimal = fraction * 60;

		String result = firstDegrees + MINUTES_FORMAT.format(minutesAsDecimal)
				+ append;
//		System.out.println("raw=" + raw + ", degrees=" + firstDegrees
//				+ ", minutes=" + minutesAsDecimal + ", result=" + result);
		return result;
	}

	private String getChecksum(String sentence) {
		// Loop through all chars to get a checksum
		int checksum = 0;
		for (char Character : sentence.toCharArray()) {
			if (Character == '$') {
				// Ignore the dollar sign
			} else if (Character == '*') {
				// Stop processing before the asterisk
				break;
			} else {
				// Is this the first value for the checksum?
				if (checksum == 0) {
					// Yes. Set the checksum to the value
					checksum = (byte) Character;
				} else {
					// No. XOR the checksum with this character's value
					checksum = checksum ^ (byte) Character;
				}
			}
		}
		// Return the checksum formatted as a two-character hexadecimal
		return Integer.toHexString(checksum).toUpperCase();
	}

}
