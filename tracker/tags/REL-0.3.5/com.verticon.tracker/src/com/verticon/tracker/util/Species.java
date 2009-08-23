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
