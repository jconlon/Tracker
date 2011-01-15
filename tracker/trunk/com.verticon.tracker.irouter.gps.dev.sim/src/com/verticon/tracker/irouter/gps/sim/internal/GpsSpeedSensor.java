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

import org.equinoxosgi.toast.devsim.fw.HtmlGenerator;
import org.equinoxosgi.toast.devsim.fw.IntegerSensor;

public class GpsSpeedSensor extends IntegerSensor {
	private GpsSimulator master;

	public GpsSpeedSensor(String name, String label, int minValue,
			int maxValue, int defaultValue, int smallIncrement,
			int largeIncrement, String units) {
		super(name, label, minValue, maxValue, defaultValue, smallIncrement,
				largeIncrement, units, null);
	}

	public void clearMaster() {
		if (master == null)
			return;
		value = master.getSpeed();
		master = null;
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.replace("sensorValue", getPrintable());
		gen.replace("units", units);
		gen.write("GpsSpeedSensor.template", getClass());
	}

	public int getValue() {
		return master == null ? super.getValue() : master.getSpeed();
	}

	public void setMaster(GpsSimulator master) {
		this.master = master;
	}

	protected void setValue(int value) {
		if (master != null)
			return;
		super.setValue(value);
	}
}
