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

import java.io.PrintWriter;

import org.equinoxosgi.toast.devsim.fw.HtmlGenerator;
import org.equinoxosgi.toast.devsim.fw.SimulatedParameter;
import org.equinoxosgi.util.PropertyManager;

public class GpsCompassSensor extends SimulatedParameter {
	private static final String SE_BIG_ACTION = "bse";
	private static final String S_BIG_ACTION = "bs";
	private static final String SW_BIG_ACTION = "bsw";
	private static final String SE_SMALL_ACTION = "se";
	private static final String S_SMALL_ACTION = "s";
	private static final String SW_SMALL_ACTION = "sw";
	private static final String E_BIG_ACTION = "be";
	private static final String E_SMALL_ACTION = "e";
	private static final String W_SMALL_ACTION = "w";
	private static final String W_BIG_ACTION = "bw";
	private static final String NE_SMALL_ACTION = "ne";
	private static final String N_SMALL_ACTION = "n";
	private static final String NW_SMALL_ACTION = "nw";
	private static final String NE_BIG_ACTION = "bne";
	private static final String N_BIG_ACTION = "bn";
	private static final String NW_BIG_ACTION = "bnw";
	private static final String DEFAULT_ACTION = "def";
	private static final int BIG_WEST = -50;
	private static final int BIG_EAST = 50;
	private static final int BIG_NORTH = 50;
	private static final int BIG_SOUTH = -50;
	private static final int SMALL_WEST = -5;
	private static final int SMALL_EAST = 5;
	private static final int SMALL_NORTH = 5;
	private static final int SMALL_SOUTH = -5;
	private static final int HEADING_NORTHWEST = 305;
	private static final int HEADING_NORTH = 0;
	private static final int HEADING_NORTHEAST = 45;
	private static final int HEADING_WEST = 270;
	private static final int HEADING_EAST = 90;
	private static final int HEADING_SOUTHWEST = 225;
	private static final int HEADING_SOUTH = 180;
	private static final int HEADING_SOUTHEAST = 135;
	private static final String LATITUDE_PROPERTY = "toast.gps.latitude";
	private static final String LATITUDE_PROPERTY_DEFAULT = "38.88746";
	private static final String LONGITUDE_PROPERTY = "toast.gps.longitude";
	private static final String LONGITUDE_PROPERTY_DEFAULT = "-77.02202";
	private static final String HEADING_PROPERTY = "toast.gps.heading";
	private static final String HEADING_PROPERTY_DEFAULT = "90";
	private static final int MIN_LATITUDE = 3885000;
	private static final int MAX_LATITUDE = 3895000;
	private static final int MIN_LONGITUDE = -7708000;
	private static final int MAX_LONGITUDE = -7700000;
	private int latitude;
	private int longitude;
	private int heading;
	private GpsSimulator master;

	public GpsCompassSensor(String name, String label) {
		super(name, label);
		master = null;
		reset();
	}

	public void clearMaster() {
		if (master == null)
			return;
		heading = master.getHeading();
		latitude = master.getLatitude();
		longitude = master.getLongitude();
		master = null;
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("latitudeValue", getPrintableLatitude());
		gen.replace("longitudeValue", getPrintableLongitude());
		gen.replace("headingValue", getPrintableHeading());
		gen.write("GpsCompassSensor.template", getClass());
	}

	public boolean generateRefreshValue(PrintWriter writer, String prefix) {
		writer.print(prefix);
		writer.print("\"latitude\": \"");
		writer.print(getPrintableLatitude());
		writer.print("\", \"longitude\": \"");
		writer.print(getPrintableLongitude());
		writer.print("\", \"heading\": \"");
		writer.print(getPrintableHeading());
		writer.print('"');
		return true;
	}

	public int getHeading() {
		return master == null ? heading : master.getHeading();
	}

	public int getLatitude() {
		return master == null ? latitude : master.getLatitude();
	}

	public int getLongitude() {
		return master == null ? longitude : master.getLongitude();
	}

	private String getPrintableHeading() {
		return Integer.toString(getHeading());
	}

	private String getPrintableLatitude() {
		return Double.toString(1.0 * getLatitude() / 100000);
	}

	private String getPrintableLongitude() {
		return Double.toString(1.0 * getLongitude() / 100000);
	}

	private void move(int deltaLat, int deltaLon, int newHeading) {
		if (master != null)
			return;
		latitude += deltaLat;
		latitude = latitude < MIN_LATITUDE ? MIN_LATITUDE : latitude;
		latitude = latitude > MAX_LATITUDE ? MAX_LATITUDE : latitude;
		longitude += deltaLon;
		longitude = longitude < MIN_LONGITUDE ? MIN_LONGITUDE : longitude;
		longitude = longitude > MAX_LONGITUDE ? MAX_LONGITUDE : longitude;
		heading = newHeading;
	}

	public void performAction(String action) {
		if (NW_BIG_ACTION.equals(action))
			move(BIG_NORTH, BIG_WEST, HEADING_NORTHWEST);
		else if (N_BIG_ACTION.equals(action))
			move(BIG_NORTH, 0, HEADING_NORTH);
		else if (NE_BIG_ACTION.equals(action))
			move(BIG_NORTH, BIG_EAST, HEADING_NORTHEAST);
		else if (NW_SMALL_ACTION.equals(action))
			move(SMALL_NORTH, SMALL_WEST, HEADING_NORTHWEST);
		else if (N_SMALL_ACTION.equals(action))
			move(SMALL_NORTH, 0, HEADING_NORTH);
		else if (NE_SMALL_ACTION.equals(action))
			move(SMALL_NORTH, SMALL_EAST, HEADING_NORTHEAST);
		else if (W_BIG_ACTION.equals(action))
			move(0, BIG_WEST, HEADING_WEST);
		else if (W_SMALL_ACTION.equals(action))
			move(0, SMALL_WEST, HEADING_WEST);
		else if (E_SMALL_ACTION.equals(action))
			move(0, SMALL_EAST, HEADING_EAST);
		else if (E_BIG_ACTION.equals(action))
			move(0, BIG_EAST, HEADING_EAST);
		else if (SW_SMALL_ACTION.equals(action))
			move(SMALL_SOUTH, SMALL_WEST, HEADING_SOUTHWEST);
		else if (S_SMALL_ACTION.equals(action))
			move(SMALL_SOUTH, 0, HEADING_SOUTH);
		else if (SE_SMALL_ACTION.equals(action))
			move(SMALL_SOUTH, SMALL_EAST, HEADING_SOUTHEAST);
		else if (SW_BIG_ACTION.equals(action))
			move(BIG_SOUTH, BIG_WEST, HEADING_SOUTHWEST);
		else if (S_BIG_ACTION.equals(action))
			move(BIG_SOUTH, 0, HEADING_SOUTH);
		else if (SE_BIG_ACTION.equals(action))
			move(BIG_SOUTH, BIG_EAST, HEADING_SOUTHEAST);
		else if (DEFAULT_ACTION.equals(action))
			setToDefault();
	}

	private void reset() {
		String propertyValue = PropertyManager.getProperty(LATITUDE_PROPERTY,
				LATITUDE_PROPERTY_DEFAULT);
		latitude = (int) (Double.parseDouble(propertyValue) * 100000);
		propertyValue = PropertyManager.getProperty(LONGITUDE_PROPERTY,
				LONGITUDE_PROPERTY_DEFAULT);
		longitude = (int) (Double.parseDouble(propertyValue) * 100000);
		propertyValue = PropertyManager.getProperty(HEADING_PROPERTY,
				HEADING_PROPERTY_DEFAULT);
		heading = (int) Double.parseDouble(propertyValue);
	}

	public void resetToDefault() {
		setToDefault();
	}

	public void setMaster(GpsSimulator master) {
		this.master = master;
	}

	private void setToDefault() {
		if (master != null)
			return;
		reset();
	}
}
