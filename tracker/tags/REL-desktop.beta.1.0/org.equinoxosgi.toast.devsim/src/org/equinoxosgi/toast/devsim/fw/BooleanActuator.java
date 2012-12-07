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

public class BooleanActuator extends SimulatedParameter {
	protected boolean value;

	public BooleanActuator(String name, String label) {
		super(name, label);
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("actuatorName", name);
		gen.replace("actuatorLabel", label);
		gen.replace("actuatorValue", getPrintable());
		gen.write("/templates/BooleanActuator.template", getClass());
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

	public void performAction(String action) {
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
