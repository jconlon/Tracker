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
package com.verticon.tracker.irouter.gps.internal;

import static com.google.common.base.Preconditions.checkState;
import static com.verticon.tracker.irouter.gps.internal.GPSProducer.bundleMarker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;

import org.osgi.service.io.ConnectorService;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.messaging.MessageAppender;
import com.verticon.nmea.AirMarPitchRoll;
import com.verticon.nmea.HeadingAndGroundSpeed;
import com.verticon.nmea.PositionWrapper;
import com.verticon.nmea.WeatherComposite;

/**
 * Proxy that connects to a NMEA 0183 device, parses and validates GPS Fix Data
 * ($GPGGA sentences), Weather Composites ($WIMDA sentences) and AirMar
 * proprietary Pitch and Roll ($YXXDR sentences).
 * 
 * Creates objects that model each, envelopes and sends them back to the
 * GPSProducer if it is past the production delay.
 * 
 * @author jconlon
 * 
 */
public class GPSProxy implements Callable<Void> {

	// Heading and GroundSpeed
	private static final String $GPVTG = "$GPVTG";

	// Proprietary extensions
	private static final String $YXXDR = "$YXXDR";

	// Weather
	private static final String $WIMDA = "$WIMDA";

	// GPS
	private static final String $GPGGA = "$GPGGA,";

	private final Logger logger = LoggerFactory.getLogger(GPSProxy.class);

	private final GPSProducer producer;
	private long lastPositionTimeStamp = 0;
	private long lastWeatherTimeStamp = 0;
	private long lastOrientationTimeStamp = 0;
	private long lastHeadingTimeStamp = 0;
	private long lastCompositeTimeStamp = 0;
	private long productionDelay;

	private boolean compositeMessages = false;

	private NMEAComposite compositeMessage = null;

	GPSProxy(GPSProducer producer) {
		this.producer = producer;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GPSProxy [pid=" + producer.getPid() + " productionDelay="
				+ productionDelay + " compositeMessages=" + compositeMessages
				+ "]";
	}

	@Override
	public Void call() throws Exception {
		try {
			producer.setConnectedStatusVariable(false);
			productionDelay = TimeUnit.MILLISECONDS.convert(
					producer.getOutputRate(), TimeUnit.SECONDS);
			compositeMessages = producer.getCompositeMessages();
			String uri = producer.getUri();
			logger.debug(bundleMarker, "{} Starting uri={}", new Object[] {
					this, uri });
			BufferedReader in = null;
			boolean swallowExcetionsDuringClose = true;
			Connection con = producer.getConnectorService().open(uri,
					ConnectorService.READ, true);
			checkState(con != null,
					"ConnectionService could not create a connection");
			InputConnection ssc = (InputConnection) con;
			InputStream is = null;
			try {
				is = ssc.openInputStream();
				in = new BufferedReader(new InputStreamReader(is));
				logger.debug(bundleMarker, "{} connected.", this);
				producer.setConnectedStatusVariable(true);
				while (!Thread.currentThread().isInterrupted()) {
					handle(in.readLine());
				}
				swallowExcetionsDuringClose = false;
				logger.info(bundleMarker, "{} closing connection", this);
			} catch (InterruptedIOException e) {
				logger.debug(bundleMarker, "{} interrupted connection", this);
			} finally {
				close(con, swallowExcetionsDuringClose);
				producer.setConnectedStatusVariable(false);
				logger.info(bundleMarker, "{} closed connection", this);
			}
		} catch (Exception e) {
			logger.warn(bundleMarker, this + " failed to connect", e);
			throw e;
		}

		return null;
	}

	public void close(Connection con, boolean swallowIOException)
			throws IOException {
		if (con == null) {
			return;
		}
		try {
			con.close();
		} catch (IOException e) {
			if (swallowIOException) {
				logger.warn(bundleMarker, this
						+ "IOException thrown while closing connection.", e);
			} else {
				throw e;
			}
		}
	}

	private void handle(String sentence) {
		long timeStamp = System.currentTimeMillis();
		if (sentence.startsWith($GPGGA)) {

			handleGPGGA(sentence, timeStamp);
		} else if (sentence.startsWith($WIMDA)) {

			handleWIMDA(sentence, timeStamp);
		} else if (sentence.startsWith($YXXDR)) {

			handleYXXDR(sentence, timeStamp);
		} else if (sentence.startsWith($GPVTG)) {

			handleGPVTG(sentence, timeStamp);
		} else {
			logger.debug(bundleMarker,
					"{} defered sending unknown sentence: {}", this, sentence);
			return;
		}
	}

	/**
	 * $GPVTG is the NMEA 0183 standard Course Over Ground and Ground Speed.
	 * 
	 * 
	 * <p>
	 * Examples
	 * </p>
	 * <ul>
	 * <li>$GPVTG,127.6,T,129.0,M,0.0,N,0.0,K,D*2E</li>
	 * <li>$GPVTG,10.3, T, 11.7, M, 0.0, N, 0.0, K,D*23</li>
	 * </ul>
	 * 0 1 2 3 4 5 6 7 8 9 10
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
	 * <li>Mode indicator: A = Autonomous mode D = Differential mode E =
	 * Estimated (dead reckoning) mode M = Manual input mode S = Simulator mode
	 * N = Data not valid
	 * <p>
	 * The only values transmitted by the WX Series WeatherStation Sensor for
	 * the Mode indicator are A, D, and N.
	 * </p>
	 * </li>
	 * 
	 * 
	 * </ol>
	 * 
	 * @param sentence
	 * @param timeStamp
	 */
	private void handleGPVTG(String sentence, long timeStamp) {
		if (compositeMessages) {
			String[] s = splitAndValidate(sentence, 10, 1);
			if (s == null) {
				return;
			}
			MessageAppender message = new HeadingAndGroundSpeed(s);
			handleComposite(message, timeStamp);
			return;
		}
		String[] s = checkSplitAndValidate(sentence, 10, 1, timeStamp,
				lastHeadingTimeStamp);

		if (s == null) {
			return;
		}
		HeadingAndGroundSpeed orientation = new HeadingAndGroundSpeed(s);

		logger.info(bundleMarker, "Sending {}, ", orientation);

		Envelope envelope = producer.packageAndSend(orientation);
		producer.setLastHeadingEnvelopeUpdater(envelope);
		producer.totalHeadings.incrementAndGet();

		lastHeadingTimeStamp = timeStamp;

	}

	private void handleComposite(MessageAppender message, long timeStamp) {

		if (compositeMessage == null) {
			compositeMessage = new NMEAComposite();
		}
		compositeMessage.add(message);
		long millisSinceLastProduction = timeStamp - lastCompositeTimeStamp;
		logger.debug(
				bundleMarker,
				"{} testing timeSinceLastProduction={}, productionDelay={}",
				new Object[] { this, millisSinceLastProduction, productionDelay });

		if (lastCompositeTimeStamp != 0) {
			if (millisSinceLastProduction < productionDelay) {
				return;
			}
		}

		logger.info(bundleMarker, "Sending {}, ", compositeMessage);

		Envelope envelope = producer.packageAndSend(compositeMessage);
		producer.setLastEnvelopeUpdater(envelope);
		producer.totalEnvelopes.incrementAndGet();

		lastCompositeTimeStamp = timeStamp;
		compositeMessage = null;
	}

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
	 * @param timeStamp
	 */
	private void handleWIMDA(String sentence, long timeStamp) {
		if (compositeMessages) {
			String[] s = splitAndValidate(sentence, 21, 10);
			if (s == null) {
				return;
			}
			MessageAppender message = new WeatherComposite(s);
			handleComposite(message, timeStamp);
			return;
		}

		String[] s = checkSplitAndValidate(sentence, 21, 10, timeStamp,
				lastWeatherTimeStamp);

		if (s == null) {
			return;
		}
		WeatherComposite wc = new WeatherComposite(s);
		logger.info(bundleMarker, "Sending {}, ", wc);
		Envelope envelope = producer.packageAndSend(wc);
		producer.setLastWeatherEnvelopeUpdater(envelope);
		producer.totalWeathers.incrementAndGet();

		lastWeatherTimeStamp = timeStamp;

	}

	/**
	 * NMEA 0183 YXXDR is a proprietary sentence prefix. Parse the sentence and
	 * send it to the proprietary handlers.
	 * 
	 * @param sentence
	 */
	private void handleYXXDR(String sentence, long timeStamp) {
		// AirMar Pitch and Roll
		if (sentence.startsWith("$YXXDR,A")) {
			handleAirMarPitchAndRoll(sentence, timeStamp);
		}

		// AirMar
		// $YXXDR,C,,C,WCHR,C,,C,WCHT,C,,C,HINX,P,0.9704,B,STNP*41timeStamp
		// is ignored

	}

	/**
	 * <p>
	 * Handle Proprietary Airmar Pitch and Roll sentences
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
	 * <li>Pitch: oscillation of vessel about its latitudinal axis. Bow moving
	 * up is positive. Value reported to the nearest 0.1 degree.</li>
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
	 * The reported pitch and roll values are adjusted by the azimuth, pitch,
	 * and roll offsets established with the $PAMTC,ATTOFF command.
	 * 
	 * 
	 * 
	 * @param sentence
	 */
	private void handleAirMarPitchAndRoll(String sentence, long timeStamp) {
		if (compositeMessages) {
			String[] s = splitAndValidate(sentence, 9, 1);
			if (s == null) {
				return;
			}
			MessageAppender message = new AirMarPitchRoll(s);
			handleComposite(message, timeStamp);
			return;
		}
		String[] s = checkSplitAndValidate(sentence, 9, 1, timeStamp,
				lastOrientationTimeStamp);

		if (s == null) {
			return;
		}
		AirMarPitchRoll orientation = new AirMarPitchRoll(s);
		logger.info(bundleMarker, "Sending {}, ", orientation);

		Envelope envelope = producer.packageAndSend(orientation);
		producer.setLastOrientationEnvelopeUpdater(envelope);
		producer.totalOrientations.incrementAndGet();

		lastOrientationTimeStamp = timeStamp;

	}

	/**
	 * NMEA 0183 standard GPS Fix Data.
	 * 
	 * $GPGGA,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47
	 * $GPGGA,221235.80,4328.5718,N,09057.1076,W,2,9,1.2,344.0,M,-32.4,M,,*6C
	 * 
	 * Where: GGA Global Positioning System Fix Data 123519 Fix taken at
	 * 12:35:19 UTC 4807.038,N Latitude 48 deg 07.038' N 01131.000,E Longitude
	 * 11 deg 31.000' E 1 Fix quality: 0 = invalid 1 = GPS fix (SPS) 2 = DGPS
	 * fix 3 = PPS fix 4 = Real Time Kinematic 5 = Float RTK 6 = estimated (dead
	 * reckoning) (2.3 feature) 7 = Manual input mode 8 = Simulation mode 08
	 * Number of satellites being tracked 0.9 Horizontal dilution of position
	 * 545.4,M Altitude, Meters, above mean sea level 46.9,M Height of geoid
	 * (mean sea level) above WGS84 ellipsoid (empty field) time in seconds
	 * since last DGPS update (empty field) DGPS station ID number 47 the
	 * checksum data, always begins with *
	 * 
	 * @param sentence
	 */
	private void handleGPGGA(String sentence, long timeStamp) {
		if (compositeMessages) {
			String[] s = splitAndValidate(sentence, 15, 2);
			if (s == null) {
				return;
			}
			MessageAppender message = new PositionWrapper(s, timeStamp,
					producer.getLongitudeError(), producer.getLatitudeError(),
					producer.getAltitudeError());
			handleComposite(message, timeStamp);
			return;
		}
		String[] s = checkSplitAndValidate(sentence, 15, 2, timeStamp,
				lastPositionTimeStamp);

		if (s == null) {
			return;
		}

		logger.info(bundleMarker, "{} handling, {}", this, sentence);
		// Time of fix
		logger.debug(bundleMarker, "{} time={}", this, s[1]);

		PositionWrapper positionW = new PositionWrapper(s, timeStamp,
				producer.getLongitudeError(), producer.getLatitudeError(),
				producer.getAltitudeError());

		producer.packageAndSend(positionW);
		// For backward compatability
		Envelope envelope = producer.packageAndSend(positionW.getPosition());

		producer.setLastPositionEnvelopeUpdater(envelope);
		producer.totalPositions.incrementAndGet();
		lastPositionTimeStamp = timeStamp;
	}

	private final String[] checkSplitAndValidate(String sentence,
			int numberOfTokens, int acceptableNulls, long timeStamp,
			long lastTimeStamp) {

		long millisSinceLastProduction = timeStamp - lastTimeStamp;
		logger.debug(
				bundleMarker,
				"{} testing timeSinceLastProduction={}, productionDelay={}",
				new Object[] { this, millisSinceLastProduction, productionDelay });

		if (lastTimeStamp != 0) {
			if (millisSinceLastProduction < productionDelay) {
				return null;
			}
		}
		return splitAndValidate(sentence, numberOfTokens, acceptableNulls);
	}

	private String[] splitAndValidate(String sentence, int numberOfTokens,
			int acceptableNulls) {
		if (sentence == null || sentence.trim().length() < 1) {
			logger.error(bundleMarker, "{} sentence is null", this);
			return null;
		}
		String checkCharacter = sentence
				.substring(sentence.lastIndexOf('*') + 1);
		String calculatedCheckSum = getChecksum(sentence);
		if (!checkCharacter.equals(calculatedCheckSum)) {
			producer.incrementCRCErrorStatusVariable();
			logger.error(bundleMarker,
					"{} checksum failure: sentence={} calculated checkSum={}",
					new Object[] { this, sentence, calculatedCheckSum });
			return null;
		}
		String[] s = sentence.split(",");

		if (s.length != numberOfTokens) {
			producer.incrementIncompleteSentenceStatusVariable();
			logger.warn(
					bundleMarker,
					"{} incomplete sentence={} expected {} found only {} tokens.",
					new Object[] { this, sentence, numberOfTokens, s.length });
			return null;
		}
		int nulls = 0;
		for (String string : s) {
			if (string.length() < 1) {
				nulls++;
				if (nulls > acceptableNulls) {
					producer.incrementIncompleteSentenceStatusVariable();
					logger.debug(
							bundleMarker,
							"{} Incomplete sentence={} Found more than {} missing values.",
							this, sentence, acceptableNulls);
					return null;
				}
			}
		}

		return s;
	}

	public String getChecksum(String sentence) {
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
