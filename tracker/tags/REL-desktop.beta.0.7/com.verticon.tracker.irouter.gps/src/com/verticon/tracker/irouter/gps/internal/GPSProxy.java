/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
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
import static com.verticon.tracker.irouter.gps.internal.GPSProducer.toRadians;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.microedition.io.Connection;
import javax.microedition.io.InputConnection;

import org.osgi.service.io.ConnectorService;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Closeables;

/**
 * Connects to GPS device, parses and validates GPS Fix Data ($GPGGA sentences) to send an 
 * OSGi Position with Longitude, Latitude, and Altitude measurements.
 * 
 * 
 * @author jconlon
 * 
 */
public class GPSProxy implements Callable<Void> {

	private final Logger logger = LoggerFactory.getLogger(GPSProxy.class);
	
	private final GPSProducer producer;
	private long lastTimeStamp=0;
	private long productionDelay;
	

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
		return "GPSProxy [pid=" + producer.getPid() + "]";
	}

	@Override
	public Void call() throws Exception {
		try {
			producer.setConnectedStatusVariable(false);
			productionDelay= TimeUnit.MILLISECONDS.convert(producer.getOutputRate(),TimeUnit.SECONDS);
			String uri = producer.getUri();
			logger.debug(bundleMarker, "{} Starting uri={} with productionDelay={}", 
					new Object[]{this, uri,productionDelay} );
			BufferedReader in = null;
			boolean swallowExcetionsDuringClose = true;
			Connection con = producer.getConnectorService().open(uri,
					ConnectorService.READ, true);
			checkState(con != null,
					"ConnectionService could not create a connection");
			InputConnection ssc = (InputConnection) con;
			try {
				InputStream is = ssc.openInputStream();
				in = new BufferedReader(new InputStreamReader(is));
				logger.debug(bundleMarker, "{} connected.", this);
				producer.setConnectedStatusVariable(true);
				while (!Thread.currentThread().isInterrupted()) {
					handle(in.readLine());
				}
				swallowExcetionsDuringClose = false;
				logger.debug(bundleMarker, "{} closing connection", this);
			} catch (InterruptedIOException e) {
				logger.debug(bundleMarker, "{} interrupted connection", this);
			} finally {
				producer.setConnectedStatusVariable(false);
				Closeables.close(in, swallowExcetionsDuringClose);
				logger.debug(bundleMarker, "{} closed connection", this);
			}
		} catch (Exception e) {
			logger.warn(bundleMarker,this+" failed to connect",e);
			throw e;
		}

		return null;
	}
	
	/**
	 * $GPGGA,123519,4807.038,N,01131.000,E,1,08,0.9,545.4,M,46.9,M,,*47
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
	private void handle(String sentence) {
		if (!sentence.startsWith("$GPGGA,")) {
			return;
		}
		long timeStamp = System.currentTimeMillis();
		long timeSinceLastProduction = timeStamp-lastTimeStamp;
		logger.debug(bundleMarker, "{} testing timeSinceLastProduction={}, productionDelay={}", 
				new Object[]{this, timeSinceLastProduction,productionDelay});
		if(lastTimeStamp!=0){
			if(timeSinceLastProduction < productionDelay){
				logger.debug(bundleMarker, "{} defering timeSinceLastProduction={} < productionDelay={}", 
						new Object[]{this, timeSinceLastProduction,productionDelay});
				return;
			}
		}
	
		String[] s = splitAndValidate(sentence);
		
		if(s==null){
			return;
		}
		logger.info(bundleMarker, "{} handling, {}", this, sentence);
		// Time of fix
		logger.debug(bundleMarker, "{} time={}", this, s[1]);
	
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
			logger.error(bundleMarker, "{} could not parse latitude={}", new Object[]{this, s[2]},e2);
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
			logger.error(bundleMarker, "{} could not parse longitude={}", new Object[]{this, s[4]},e1);
		}

		Measurement latitude = 
			new Measurement(
				toRadians( lat_val), 
				producer.getLatitudeError(),
				Unit.rad, 
				timeStamp
				);

		logger.debug(bundleMarker, "{} latitude degrees={}, measurement={}", 
				new Object[] {this, lat_val, latitude});
		
		Measurement longitude = 
			new Measurement(
				toRadians( lon_val), 
				producer.getLongitudeError(),
				Unit.rad, 
				timeStamp
				);
		
		logger.debug(bundleMarker, "{} longitude degrees={}, measurement={}", 
				new Object[] {this, lon_val, longitude});
		
		logger.debug(bundleMarker, "{} quality={}", this, s[6]);
		logger.debug(bundleMarker, "{} satelliteCount={}", this, s[7]);
		logger.debug(bundleMarker, "{} Horizontal dilution of position={}",
				this, s[8]);
		
		double altitudeInMeters;
		try {
			altitudeInMeters = Double.parseDouble(s[9]);
		} catch (NumberFormatException e) {
			logger.error(bundleMarker, "{} could not parse altitude measurement={}", 
					new Object[]{this, s[9]},e);
			return;
		}
		Measurement altitude = 
			new Measurement(
					altitudeInMeters, 
				producer.getAltitudeError(), 
				Unit.m, 
				timeStamp
				);
		
		logger.debug(bundleMarker,
				"{} Altitude, Meters, above mean sea measurement={}", this, altitude);
	
		logger.debug(bundleMarker, "{} Height of geoid={}", this, s[11]);
		
		producer.send(
				new Position(latitude, longitude, altitude, null, null)
		);
		lastTimeStamp=timeStamp;
	}
	
	private String[] splitAndValidate(String sentence){
		String checkCharacter = sentence.substring(sentence.lastIndexOf('*')+1);
		String calculatedCheckSum = getChecksum( sentence);
		if(!checkCharacter.equals(calculatedCheckSum)){
			producer.incrementCRCErrorStatusVariable();
			logger.error(bundleMarker,
					"{} checksum failure: sentence={} calculated checkSum={}", 
					new Object[]{this, sentence, calculatedCheckSum } );
			return null;
		}
		String[] s = sentence.split(",");
		if (s.length != 15) {
			producer.incrementIncompleteSentenceStatusVariable();
			logger.warn(bundleMarker,
					"{} incomplete sentence={} found only {} tokens.", new Object[]{this, sentence, s.length});
			return null;
		}
		int nulls = 0;
		for (String string : s) {
			if(string.length()<1){
				nulls++;
				if(nulls>2){
					producer.incrementIncompleteSentenceStatusVariable();
					logger.warn(bundleMarker,
							"{} Incomplete sentence={} found too many missing values.", this, sentence);
					return null;
				}
			}
		}
		
		return s;
	}

	  public String getChecksum(String sentence){
	    // Loop through all chars to get a checksum
	    int checksum = 0;
	    
	    for (char Character : sentence.toCharArray()) {
	      if (Character == '$'){
	        // Ignore the dollar sign
	      }
	      else if (Character == '*'){
	        // Stop processing before the asterisk
	        break;
	      }
	      else{
	        // Is this the first value for the checksum?
	        if (checksum == 0){
	          // Yes. Set the checksum to the value
	          checksum = (byte)Character;
	        }
	        else
	        {
	          // No. XOR the checksum with this character's value
	          checksum = checksum ^ (byte)Character;
	        }
	      }
	    }
	    // Return the checksum formatted as a two-character hexadecimal
	    return Integer.toHexString(checksum).toUpperCase();
	  }


}
