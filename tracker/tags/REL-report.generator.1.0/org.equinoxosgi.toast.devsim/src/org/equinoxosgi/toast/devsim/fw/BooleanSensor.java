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
package org.equinoxosgi.toast.devsim.fw;

import java.io.PrintWriter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooleanSensor extends SimulatedParameter {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(BooleanSensor.class);


	private static final String DEFAULT_ACTION = "def";
	private static final String YES_ACTION = "yes";
	private static final String NO_ACTION = "no";
	private static final String RUN_ACTION = "run";
	private static final String STOP_ACTION = "stop";
	private static final long RUN_DELAY = 1000;
	protected boolean defaultValue;
	protected boolean value;
	protected Job job;
	private IDeviceSimulatorListener listener;

	public BooleanSensor(String name, String label, boolean defaultValue,
			IDeviceSimulatorListener listener) {
		super(name, label);
		this.defaultValue = defaultValue;
		this.listener = listener;
		value = defaultValue;
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.replace("sensorValue", getPrintable());
		gen.write("/templates/BooleanSensor.template", getClass());
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
		return value ? "Y" : "N";
	}

	public boolean getValue() {
		return value;
	}

	public void performAction(String action) {
		if (YES_ACTION.equals(action))
			setToTrue();
		else if (NO_ACTION.equals(action))
			setToFalse();
		else if (DEFAULT_ACTION.equals(action))
			setToDefault();
		else if (RUN_ACTION.equals(action))
			startRunning();
		else if (STOP_ACTION.equals(action))
			stopRunning();
	}

	public void resetToDefault() {
		setToDefault();
	}

	public void run() {
		startRunning();
	}

	protected void setToDefault() {
		stopRunning();
		setValue(defaultValue);
	}

	protected void setToFalse() {
		stopRunning();
		setValue(false);
	}

	protected void setToTrue() {
		stopRunning();
		setValue(true);
	}

	protected void setValue(boolean value) {
		this.value = value;
		if (listener != null)
			listener.valueChanged(name, value);
		logger.debug("{} {}",label, String.valueOf(getPrintable()));
	}

	protected synchronized void startRunning() {
		if (job != null)
			return;
		setValue(defaultValue);
		Job job = new Job(name) {
			protected IStatus run(IProgressMonitor monitor) {
				setValue(!value);
				schedule(RUN_DELAY);
				return Status.OK_STATUS;
			}
		};
		job.schedule(RUN_DELAY);
	}

	protected synchronized void stopRunning() {
		if (job == null)
			return;
		job.cancel();
		try {
			job.join();
		} catch (InterruptedException e) {
			// shutting down, ok to ignore
		}
		job = null;
	}
}
