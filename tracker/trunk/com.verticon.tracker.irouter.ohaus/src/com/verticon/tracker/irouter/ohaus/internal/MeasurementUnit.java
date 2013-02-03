package com.verticon.tracker.irouter.ohaus.internal;

public enum MeasurementUnit {
	GRAMS("g"), KILOGRAMS("kg"), POUNDS("lb"), OUNCES("oz"), POUNDS_OUNCES(
			"lb:oz");
	String key;


	private MeasurementUnit(String key) {
		this.key = key;
	}
	
	static MeasurementUnit getUnit(String s) {
		for (MeasurementUnit unit : values()) {
			if (unit.key.equals(s)) {
				return unit;
			}
		}
		throw new IllegalStateException("No such key: " + s);
	}

	double convertToKiloGrams(String response) {
		double value = Double.NaN;
		if (response.contains(":")) {
			// This is an pound ounce, Create all ounces
			value = parsePoundOunces(response);
		} else {
			value = Double.parseDouble(response);
		}
		double result = convertToKilograms(value);
		return result;
	}

	double convertToKilograms(double value) {
		double result = Double.NaN;
		switch (this) {
		case KILOGRAMS:
			result = value;
			break;
		case GRAMS:
			result = value / 1000;
			break;
		case POUNDS:
			result = value / 2.20462;
			break;
		case POUNDS_OUNCES:
		case OUNCES:
			result = value / 35.275;
			break;
		}
		return result;
	}

	double parsePoundOunces(String response) {
		// TODO
		return Double.NaN;
	}

}