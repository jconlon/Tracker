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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimulatedDevice {
	private static final String ACTION_PARAMETER = "action";
	private static final String PARAMETER_PARAMETER = "parameter";
	private static final String REFRESH_VALUES_ACTION = "refresh";
	private static final String CONTENT_TYPE_PLAIN = "text/plain";
	private static final String RUN_ACTION = "run";
	private static final String RESET_ACTION = "reset";
	private List<SimulatedParameter> parameters;
	private String label;
	private String name;
	private boolean evenOdd;
	private HtmlGenerator gen;

	public SimulatedDevice(String name, String label) {
		super();
		parameters = new ArrayList<SimulatedParameter>(37);
		this.name = name;
		this.label = label;
	}

	public void addParameter(SimulatedParameter parameter) {
		parameters.add(parameter);
	}

	public void generate(HttpServletRequest request,
			HttpServletResponse response, String id) throws IOException {
		String parameterName = request.getParameter(PARAMETER_PARAMETER);
		SimulatedParameter parameter = getParameterForName(parameterName);
		String action = request.getParameter(ACTION_PARAMETER);
		PrintWriter writer = response.getWriter();
		if (parameter == null) {
			if (REFRESH_VALUES_ACTION.equals(action)) {
				response.setContentType(CONTENT_TYPE_PLAIN);
				generateRefreshValues(writer);
				return;
			} else if (RUN_ACTION.equals(action)) {
				runAll();
			} else if (RESET_ACTION.equals(action)) {
				resetAll();
			}
		} else {
			parameter.performAction(action);
		}
		generatePage(writer, id);
	}

	private void generatePage(PrintWriter writer, String id) {
		gen = new HtmlGenerator(writer);
		gen.replace("id", id);
		gen.replace("deviceName", name);
		gen.replace("deviceLabel", label);
		gen.write("/templates/DevicePageTop.template", getClass());
		generateParameters();
		gen.write("/templates/DevicePageBottom.template", getClass());
	}

	private void generateParameters() {
		resetEvenOdd();
		for (int i = 0; i < parameters.size(); i++) {
			SimulatedParameter parameter = (SimulatedParameter) parameters
					.get(i);
			gen.replace("evenOdd", nextEvenOdd());
			parameter.generate(gen);
		}
	}

	private void generateRefreshValues(PrintWriter writer) {
		String prefix = "{ ";
		for (int i = 0; i < parameters.size(); i++) {
			SimulatedParameter parameter = (SimulatedParameter) parameters
					.get(i);
			if (parameter.generateRefreshValue(writer, prefix))
				prefix = ", ";
		}
		writer.print(" }");
	}

	public boolean getBooleanValue(String parameterName) {
		return ((BooleanSensor) getParameterForName(parameterName)).getValue();
	}

	public int getIntegerValue(String parameterName) {
		return ((IntegerSensor) getParameterForName(parameterName)).getValue();
	}
	
	public double getDoubleValue(String parameterName) {
		return ((DoubleSensor) getParameterForName(parameterName)).getValue();
	}

	public String getLabel() {
		return label;
	}

	private SimulatedParameter getParameterForName(String parameterName) {
		for (Iterator<SimulatedParameter> iter = parameters.iterator(); iter.hasNext();) {
			SimulatedParameter parameter = iter.next();
			if (parameter.getName().equals(parameterName))
				return parameter;
		}
		return null;
	}

	private String nextEvenOdd() {
		evenOdd = !evenOdd;
		return evenOdd ? "even" : "odd";
	}

	private void resetAll() {
		for (int i = 0; i < parameters.size(); i++) {
			SimulatedParameter parameter = (SimulatedParameter) parameters
					.get(i);
			parameter.resetToDefault();
		}
	}

	private void resetEvenOdd() {
		evenOdd = true;
	}

	private void runAll() {
		for (int i = 0; i < parameters.size(); i++) {
			SimulatedParameter parameter = (SimulatedParameter) parameters
					.get(i);
			parameter.run();
		}
	}

	public void setBooleanValue(String parameterName, boolean value) {
		((BooleanActuator) getParameterForName(parameterName)).setValue(value);
	}

	public void setIntegerValue(String parameterName, int value) {
		((IntegerActuator) getParameterForName(parameterName)).setValue(value);
	}
	
	public void setStringValue(String parameterName, String value) {
		((StringActuator) getParameterForName(parameterName)).setValue(value);
	}

	public void setLongValue(String parameterName, Long value) {
		((LongActuator) getParameterForName(parameterName)).setValue(value);
	}
}
