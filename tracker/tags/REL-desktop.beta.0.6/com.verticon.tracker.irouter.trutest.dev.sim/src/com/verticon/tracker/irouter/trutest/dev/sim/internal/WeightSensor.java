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
package com.verticon.tracker.irouter.trutest.dev.sim.internal;

import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.toast.devsim.fw.DoubleSensor;
import org.equinoxosgi.toast.devsim.fw.HtmlGenerator;

/**
 * 
 * @author jconlon, and the toast team
 *
 */
public class WeightSensor extends DoubleSensor {
	

	public WeightSensor(String name, String label, double minValue,
			double maxValue, double defaultValue, double smallIncrement,
			double largeIncrement, String units, IDeviceSimulatorListener listener) {
		super(name, label, minValue, maxValue, defaultValue, smallIncrement,
				largeIncrement, units, listener);
	}


	@Override
	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.replace("sensorValue", getPrintable());
		gen.replace("units", units);
		gen.write("WeightSensor.template", getClass());
	}

}
