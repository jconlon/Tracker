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

import java.io.PrintWriter;
import java.util.List;

import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.toast.devsim.fw.HtmlGenerator;
import org.equinoxosgi.toast.devsim.fw.SimulatedParameter;

public class EIDSensor extends SimulatedParameter {
	protected long value;
	private final IDeviceSimulatorListener listener;
	private final List<Long> eids;

	public EIDSensor(String name, String label, IDeviceSimulatorListener listener,List<Long> eids) {
		super(name, label);
		this.listener=listener;
		this.eids=eids;
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.replace("sensorValue", getPrintable());
		gen.write("EIDSensorTop.template", getClass());
		for (Long eid : eids) {
			gen.write("<option value=\""+eid+ "\">"+eid+"</option>");
		}
		
		gen.write("EIDSensorBottom.template", getClass());
	}

	public boolean generateRefreshValue(PrintWriter writer, String prefix) {
		writer.print(prefix);
		writer.print('"');
		writer.print(name);
		writer.print("\": \"");
		writer.print(getPrintable());
		writer.print('"');
		return true;
	}

	protected String getPrintable() {
		return Long.toString(value);
	}

	public void performAction(String action) {
		if(action.trim().length()<1){
			return;
		}
		setValue(Long.parseLong(action));
	}

	public void setValue(long value) {
		this.value = value;
		if (listener != null)
			listener.valueChanged(name, value);
	}
}
