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
package org.equinoxosgi.toast.devsim;

import org.equinoxosgi.toast.devsim.fw.SimulatedParameter;

public interface IDeviceSimulator {
	public void addBooleanActuator(String deviceName, String actuatorName,
			String label);

	public void addBooleanSensor(String deviceName, String sensorName,
			String label, boolean defaultValue);

	public void addIntegerActuator(String deviceName, String actuatorName,
			String label, int scaleFactor, String units);

	public void addIntegerActuator(String deviceName, String actuatorName,
			String label, String units);

	public void addLongActuator(String deviceName, String actuatorName,
			String label, String units);

	public void addStringActuator(String deviceName, String actuatorName,
			String label, String units);


	public void addIntegerSensor(String deviceName, String sensorName,
			String label, int scaleFactor, int minValue, int maxValue,
			int defaultValue, int smallInc, int largeInc, String units);

	public void addIntegerSensor(String deviceName, String sensorName,
			String label, int minValue, int maxValue, int defaultValue,
			int smallInc, int largeInc, String units);
	
	public void addNonRepeatableActionSensor(String deviceName,
			String sensorName, String label, String actionName);

	public void addParameter(SimulatedParameter parameter, String deviceName);

	public void addRepeatableActionSensor(String deviceName, String sensorName,
			String label, String actionName);

	public boolean getBooleanValue(String deviceName, String parameterName);

	public int getIntegerValue(String deviceName, String parameterName);
	
	public double getDoubleValue(String deviceName, String parameterName);
	
	public void registerDevice(String name, String label);

	public void registerDevice(String deviceName, String deviceLabel,
			IDeviceSimulatorListener listener);

	public void setBooleanValue(String deviceName, String parameterName,
			boolean value);

	public void setIntegerValue(String deviceName, String parameterName,
			int value);

	public void setStringValue(String deviceName, String parameterName,
			String value);

	public void setLongValue(String deviceName, String parameterName,
			long value);

	public void unregisterDevice(String name);
}
