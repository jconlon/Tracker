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

import org.equinoxosgi.toast.devsim.IDeviceSimulatorListener;

public class NonRepeatableActionSensor extends SimulatedParameter {
	private static final String EXECUTE_ACTION = "execute";
	protected String actionName;
	protected IDeviceSimulatorListener listener;

	public NonRepeatableActionSensor(String name, String label,
			String commandName, IDeviceSimulatorListener listener) {
		super(name, label);
		this.actionName = commandName;
		this.listener = listener;
	}

	protected void executeOwnerAction() {
		if (listener == null)
			return;
		listener.performAction(name, actionName);
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("sensorName", name);
		gen.replace("sensorLabel", label);
		gen.write("/templates/NonRepeatableActionSensor.template", getClass());
	}

	public void performAction(String action) {
		if (EXECUTE_ACTION.equals(action)) {
			executeOwnerAction();
		}
	}
}
