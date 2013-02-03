package com.verticon.tracker.irouter.measurement.trigger.file;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

public enum WeightUnit {
	POUNDS(2.20462), OUNCES(0.0283495), KILOGRAMS(1), GRAMS(1000);

	private final double f;

	private WeightUnit(double f) {
		this.f = f;
	}

	public Double convertValue(Measurement measurement) {
		checkNotNull(measurement);
		checkState(measurement.getUnit().equals(Unit.kg),
				"Can only convert weight measurements");
		return measurement.getValue() * f;
	}

	public Double convertError(Measurement measurement) {
		checkNotNull(measurement);
		checkState(measurement.getUnit().equals(Unit.kg),
				"Can only convert weight measurements");
		return measurement.getError() * f;
	}

	/**
	 * Gets a formated value of the measurement.
	 * 
	 * @param measurement
	 * @param formatString
	 * @return formated string from values dateTime, unit, value, error
	 */
	public String getFormatedValue(Measurement measurement, String formatString) {
		checkNotNull(measurement);
		double value, error;
		long dateTime = measurement.getTime();
		String unit;

		if (measurement.getUnit().equals(Unit.kg)) {
			value = convertValue(measurement);
			error = convertError(measurement);
			unit = this.toString();
		} else {
			value = measurement.getValue();
			error = measurement.getError();
			unit = measurement.getUnit().toString();
		}
		return String.format(formatString, dateTime, unit, value, error);
	}
	
	public double convertToKilograms(double value) {
		return value / f;
	}

	public Measurement getMeasurement(double value, double error) {
		return new Measurement(convertToKilograms(value),
				convertToKilograms(error), Unit.kg, System.currentTimeMillis());
	}
}
