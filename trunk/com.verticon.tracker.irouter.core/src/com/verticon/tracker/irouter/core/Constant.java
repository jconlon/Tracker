package com.verticon.tracker.irouter.core;

public enum Constant {
	ID_DEFAULT("Tracker"), 
	ID_PARAMETER("id"),
	ID_PROPERTY("tracker.id");
	
	private final String value;
	
	Constant(String value){
		this.value=value;
	}
	
	public String value() {return value;}
}
