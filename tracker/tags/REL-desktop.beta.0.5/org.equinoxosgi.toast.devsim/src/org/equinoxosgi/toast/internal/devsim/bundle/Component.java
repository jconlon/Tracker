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
package org.equinoxosgi.toast.internal.devsim.bundle;

import org.equinoxosgi.toast.devsim.IDeviceSimulator;
import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;
import org.equinoxosgi.toast.devsim.fw.DeviceSimulatorServlet;
import org.equinoxosgi.toast.devsim.fw.SimulatedParameter;
import org.equinoxosgi.util.PropertyManager;
import org.osgi.service.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;




public class Component implements IDeviceSimulator {
	
	private static final String PLUGIN_ID = "org.equinoxosgi.toast.devsim";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);

	private static String ID_DEFAULT = "Tracker"; 
	private static String ID_PROPERTY="tracker.id";

	
	private static final String SERVLET_ALIAS_ROOT_PROPERTY = "servlet.alias.root";
	private static final String SERVLET_ALIAS_ROOT_DEFAULT = "/client";
	private static final String SERVLET_SUFFIX = "/devices";
	private static final String RESOURCES_PATH = "/resources";

	private DeviceSimulatorServlet servlet;
	private String servletAlias;
	private String resourcesAlias;
	private HttpService httpService;

	public void addBooleanActuator(String deviceName, String actuatorName,
			String label) {
		servlet.addBooleanActuator(deviceName, actuatorName, label);
	}

	public void addBooleanSensor(String deviceName, String sensorName,
			String label, boolean defaultValue) {
		servlet.addBooleanSensor(deviceName, sensorName, label, defaultValue);
	}

	public void addIntegerActuator(String deviceName, String actuatorName,
			String label, int scaleFactor, String units) {
		servlet.addIntegerActuator(deviceName, actuatorName, label,
				scaleFactor, units);
	}

	public void addIntegerActuator(String deviceName, String actuatorName,
			String label, String units) {
		servlet.addIntegerActuator(deviceName, actuatorName, label, units);
	}
	
	@Override
	public void addLongActuator(String deviceName, String actuatorName,
			String label, String units) {
		servlet.addLongActuator(deviceName, actuatorName, label, units);
	}

	@Override
	public void addStringActuator(String deviceName, String actuatorName,
			String label, String units) {
		servlet.addStringActuator(deviceName, actuatorName, label, units);
	}

	public void addIntegerSensor(String deviceName, String sensorName,
			String label, int scaleFactor, int minValue, int maxValue,
			int defaultValue, int smallInc, int largeInc, String units) {
		servlet.addIntegerSensor(deviceName, sensorName, label, scaleFactor,
				minValue, maxValue, defaultValue, smallInc, largeInc, units);
	}

	public void addIntegerSensor(String deviceName, String sensorName,
			String label, int minValue, int maxValue, int defaultValue,
			int smallInc, int largeInc, String units) {
		servlet.addIntegerSensor(deviceName, sensorName, label, minValue,
				maxValue, defaultValue, smallInc, largeInc, units);
	}

	public void addNonRepeatableActionSensor(String deviceName,
			String sensorName, String label, String actionName) {
		servlet.addNonRepeatableActionSensor(deviceName, sensorName, label,
				actionName);
	}

	public void addParameter(SimulatedParameter parameter, String deviceName) {
		servlet.addParameter(parameter, deviceName);
	}

	public void addRepeatableActionSensor(String deviceName, String sensorName,
			String label, String actionName) {
		servlet.addRepeatableActionSensor(deviceName, sensorName, label,
				actionName);
	}

	public boolean getBooleanValue(String deviceName, String parameterName) {
		return servlet.getBooleanValue(deviceName, parameterName);
	}

	public int getIntegerValue(String deviceName, String parameterName) {
		return servlet.getIntegerValue(deviceName, parameterName);
	}
	
	public double getDoubleValue(String deviceName, String parameterName) {
		return servlet.getIntegerValue(deviceName, parameterName);
	}


	public void registerDevice(String name, String label) {
		servlet.registerDevice(name, label);
	}

	public void registerDevice(String name, String label,
			IDeviceSimulatorListener listener) {
		servlet.registerDevice(name, label, listener);
	}

	public void setBooleanValue(String deviceName, String parameterName,
			boolean value) {
		servlet.setBooleanValue(deviceName, parameterName, value);
	}

	public void setHttp(HttpService value) {
		httpService = value;
	}

	public void setIntegerValue(String deviceName, String parameterName,
			int value) {
		servlet.setIntegerValue(deviceName, parameterName, value);
	}
	
	@Override
	public void setStringValue(String deviceName, String parameterName,
			String value) {
		servlet.setStringValue(deviceName, parameterName, value);
	}

	@Override
	public void setLongValue(String deviceName, String parameterName, long value) {
		servlet.setLongValue(deviceName, parameterName, value);
	}

	protected void shutdown() {
		httpService.unregister(servletAlias);
		httpService.unregister(resourcesAlias);
		servlet = null;
	}

	protected void startup() {
		try {
			String servletAliasRoot = PropertyManager.getProperty(
					SERVLET_ALIAS_ROOT_PROPERTY, SERVLET_ALIAS_ROOT_DEFAULT);
			servletAlias = servletAliasRoot + SERVLET_SUFFIX;
			resourcesAlias = servletAlias + RESOURCES_PATH;

			String id = PropertyManager.getProperty(ID_PROPERTY,
					ID_DEFAULT);
			servlet = new DeviceSimulatorServlet(id);
			httpService.registerServlet(servletAlias, servlet, null, null);
			httpService.registerResources(resourcesAlias, RESOURCES_PATH, null);
		    logger.debug("Registered DeviceSimulatorServlet at "
					+ servletAlias);
		} catch (Exception e) {
			logger.error(bundleMarker,this+
					" Error registering servlet with HttpService", e);
		}
	}

	public void unregisterDevice(String name) {
		servlet.unregisterDevice(name);
	}

	

	
}
