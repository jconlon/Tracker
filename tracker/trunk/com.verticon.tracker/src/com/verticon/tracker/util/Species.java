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
	CER("Cervids (Deer and Elk)"), 
	POU("Poultry"), 
	AQU("Aquaculture"), 
	RAT("Ratities (emu, ostrich)");

	private final String literal;

	Species(String literal) {
		this.literal = literal;
	}

	public String literal() {
		return literal;
	}

}
