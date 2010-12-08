package com.verticon.tracker.irouter.trutest.measurement.adapter.internal;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

public enum Converter {
	NATIVE(Double.NaN, null),
	GRAMS(1000, Unit.kg),
	OUNCES(35.27396195, Unit.kg),
	POUNDS(2.2046, Unit.kg), 
	INCHES(39.37, Unit.m), 
	MILLIMETERS(1000, Unit.m),
	FEET(3.281, Unit.m), 
	YARDS(1.094, Unit.m);
	
	private Converter(double conversion, Unit baseUnit) {
		this.conversion = conversion;
		this.baseUnit = baseUnit;
	}

	private final double conversion;
	private final Unit baseUnit;
	
	boolean isCompatable(Measurement m){
		return baseUnit!=null?baseUnit.equals(m.getUnit()):true;
	}
	
	double convert(Measurement m){
		return baseUnit == null? m.getValue(): m.mul(conversion).getValue();
	}
	
	
	
}
