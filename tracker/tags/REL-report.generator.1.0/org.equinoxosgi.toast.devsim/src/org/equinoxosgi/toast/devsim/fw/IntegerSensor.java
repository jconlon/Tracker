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

import static org.equinoxosgi.toast.internal.devsim.bundle.Component.bundleMarker;

public class IntegerSensor extends SimulatedParameter {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(IntegerSensor.class);


	private static final String MIN_ACTION = "min";
	private static final String LARGE_DEC_ACTION = "bigdec";
	private static final String SMALL_DEC_ACTION = "dec";
	private static final String DEFAULT_ACTION = "def";
	private static final String SMALL_INC_ACTION = "inc";
	private static final String LARGE_INC_ACTION = "biginc";
	private static final String MAX_ACTION = "max";
	private static final String RUN_ACTION = "run";
	private static final String STOP_ACTION = "stop";
	private static final int NO_SCALE_FACTOR = 0;
	private static final long RUN_DELAY = 1000;
	protected int minValue;
	protected int maxValue;
	protected int defaultValue;
	protected int smallIncrement;
	protected int largeIncrement;
	protected int value;
	protected String units;
	protected int scaleFactor = NO_SCALE_FACTOR;
	protected Job job;
	protected int runningStep;
	private IDeviceSimulatorListener listener;

	public IntegerSensor(String name, String label, int scaleFactor,
			int minValue, int maxValue, int defaultValue, int smallIncrement,
			int largeIncrement, String units, IDeviceSimulatorListener listener) {
		this(name, label, minValue, maxValue, defaultValue, smallIncrement,
				largeIncrement, units, listener);
		this.scaleFactor = scaleFactor;
	}

	public IntegerSensor(String name, String label, int minValue, int maxValue,
			int defaultValue, int smallIncrement, int largeIncrement,
			String units, IDeviceSimulatorListener listener) {
		super(name, label);
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.defaultValue = defaultValue;
		this.smallIncrement = smallIncrement;
		this.largeIncrement = largeIncrement;
		this.units = units;
		this.listener = listener;
		value = defaultValue;
	}

	protected void decrementLarge() {
		stopRunning();
		setValue(Math.max(value - largeIncrement, minValue));
	}

	protected void decrementSmall() {
		stopRunning();
		setValue(Math.max(value - smallIncrement, minValue));
	}

	protected void firstStep() {
		runningStep = -1;
		nextStep();
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.replace("sensorValue", getPrintable());
		gen.replace("units", units);
		gen.write("/templates/IntegerSensor.template", getClass());
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
		if (scaleFactor == NO_SCALE_FACTOR)
			return Integer.toString(value);
		return Double.toString(1.0 * value / scaleFactor);
	}

	public int getValue() {
		return value;
	}

	protected void incrementLarge() {
		stopRunning();
		setValue(Math.min(value + largeIncrement, maxValue));
	}

	protected void incrementSmall() {
		stopRunning();
		setValue(Math.min(value + smallIncrement, maxValue));
	}

	protected void nextStep() {
		runningStep++;
		int range = maxValue - minValue;
		int increments = range / smallIncrement;
		int lengths = runningStep / increments;
		int remainder = runningStep % increments;
		if (lengths % 2 == 0) {
			setValue(minValue + remainder * smallIncrement); // increasing
		} else {
			setValue(maxValue - remainder * smallIncrement); // decreasing
		}
	}

	public void performAction(String action) {
		if (MIN_ACTION.equals(action))
			setToMin();
		else if (LARGE_DEC_ACTION.equals(action))
			decrementLarge();
		else if (SMALL_DEC_ACTION.equals(action))
			decrementSmall();
		else if (DEFAULT_ACTION.equals(action))
			setToDefault();
		else if (SMALL_INC_ACTION.equals(action))
			incrementSmall();
		else if (LARGE_INC_ACTION.equals(action))
			incrementLarge();
		else if (MAX_ACTION.equals(action))
			setToMax();
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

	protected void setToMax() {
		stopRunning();
		setValue(maxValue);
	}

	protected void setToMin() {
		stopRunning();
		setValue(minValue);
	}

	protected void setValue(int value) {
		this.value = value;
		if (listener != null)
			listener.valueChanged(name, value);
	    logger.debug(bundleMarker,"{} {}",label, getPrintable());
	}

	protected synchronized void startRunning() {
		if (job != null)
			return;
		firstStep();
		job = new Job(name) {
			protected IStatus run(IProgressMonitor monitor) {
				nextStep();
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
