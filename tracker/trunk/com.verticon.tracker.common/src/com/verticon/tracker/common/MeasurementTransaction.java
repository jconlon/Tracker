package com.verticon.tracker.common;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

/**
 * Immutable data object for adding a scope and an id to a 
 * measurement.
 * 
 * @author jconlon
 * @deprecated by Ticket#634
 * 
 */
public class MeasurementTransaction extends Measurement {

	protected final String scope;
	protected final String id;

	/**
	 * Encapsulate a Measurement in a MeasurementTransaction
	 * 
	 * @param measurement to encapsulate
	 * @param scope of measurement
	 * @param id of animal
	 * 
	 * @return MeasurementTransaction
	 */
	public static MeasurementTransaction newInstance(Measurement measurement,
			String scope, Long id) {
		if(scope == null){
			throw new IllegalArgumentException ("scope can not be null");
		}
		if(id==null){
			throw new IllegalArgumentException ("id can not be null");
		}
		if(measurement==null){
			throw new IllegalArgumentException ("measurement can not be null");
		}
		return new MeasurementTransaction(
				measurement.getValue(),
				measurement.getError(), 
				measurement.getUnit(),
				measurement.getTime(), 
				scope, 
				id.toString());
	}

	/**
	 * Use the static factory method to instantiate.
	 * 
	 * @param value
	 * @param error
	 * @param unit
	 * @param time
	 * @param scope
	 * @param id
	 */
	public MeasurementTransaction(double value, double error, Unit unit,
			long time, String scope, String id) {
		super(value, error, unit, time);
		this.scope = scope;
		this.id = id;
	}

	@Override
	public String toString() {
		return "MeasurementTransaction [id=" + id + ", scope=" + scope + ", value="
				+ getValue() + "]";
	}

	public String getScope() {
		return scope;
	}

	public String getId() {
		return id;
	}

}