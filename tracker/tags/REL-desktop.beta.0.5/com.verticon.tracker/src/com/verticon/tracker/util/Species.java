/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.util;

/**
 * @author jconlon
 * 
 */
public enum Species {
	BOV("Bovine (Bison and Cattle)"), 
	CAM("Camelid (Alpaca and Llama)"), 
	EQU("Equine (Horses)"), 
	POR("Porcine (Swine)"), 
	OVI("Ovine (Sheep)"), 
	CAP("Caprine (Goats)"), 
	CER("Cervids (Deer and Elk)"),  // NO_UCD
	POU("Poultry"),  // NO_UCD
	AQU("Aquaculture"),  // NO_UCD
	RAT("Ratities (emu, ostrich)");// NO_UCD

	private final String literal;

	private Species(String literal) {
		this.literal = literal;
	}

	public String literal() {
		return literal;
	}

}
