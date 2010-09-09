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

public class LongActuator extends SimulatedParameter {
	private static final int NO_SCALE_FACTOR = 0;
	protected long value;
	protected String units;
	protected int scaleFactor;

	public LongActuator(String name, String label, int scaleFactor,
			String units) {
		super(name, label);
		this.scaleFactor = scaleFactor;
		this.units = units;
	}

	public LongActuator(String name, String label, String units) {
		super(name, label);
		this.scaleFactor = NO_SCALE_FACTOR;
		this.units = units;
	}

	public void generate(HtmlGenerator gen) {
		gen.replace("actuatorName", name);
		gen.replace("actuatorLabel", label);
		gen.replace("actuatorValue", getPrintable());
		gen.replace("units", units);
		gen.write("/templates/LongActuator.template", getClass());
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
			return Long.toString(value);
		return Double.toString(1.0 * value / scaleFactor);
	}

	public void performAction(String action) {
	}

	public void setValue(long value) {
		this.value = value;
	}
}
