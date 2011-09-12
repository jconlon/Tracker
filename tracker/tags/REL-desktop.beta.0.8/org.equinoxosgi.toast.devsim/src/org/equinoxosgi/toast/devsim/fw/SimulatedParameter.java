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

public abstract class SimulatedParameter {
	protected String name;
	protected String label;

	public SimulatedParameter(String name, String label) {
		super();
		this.name = name;
		this.label = label;
	}

	public abstract void generate(HtmlGenerator gen);

	public boolean generateRefreshValue(PrintWriter writer, String prefix) {
		return false;
	}

	public String getName() {
		return name;
	}

	public abstract void performAction(String action);

	public void resetToDefault() {
	}

	public void run() {
	}
}