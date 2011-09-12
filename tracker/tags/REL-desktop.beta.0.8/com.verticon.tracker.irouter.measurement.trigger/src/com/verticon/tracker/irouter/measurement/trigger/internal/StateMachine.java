package com.verticon.tracker.irouter.measurement.trigger.internal;

import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.ARMED;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.FIRE;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.RESET;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.RESET_STATE;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.bundleMarker;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class StateMachine {

	protected final double lowValue;
	protected final double highValue;
	protected State state = RESET_STATE;
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(CheckRisingThreashold.class);

	public StateMachine(double lowValue, double highValue) {
		super();
		this.lowValue = lowValue;
		this.highValue = highValue;
	}

	State processMeasurement(Measurement measurement) {
		logger.debug(bundleMarker, "{} processing measurement={}", this,
				measurement);
		switch (state.getValue()) {
		case RESET:
			evaluatedForArmedCondition(measurement);
			break;
		case ARMED:
			evaluatedForFiredCondition(measurement);
			break;
		case FIRE:
			state = RESET_STATE;
			evaluatedForArmedCondition(measurement);
			break;
		}
		
		return state;
	}

    abstract void evaluatedForArmedCondition(Measurement measurement);
	
	abstract void evaluatedForFiredCondition(Measurement measurement);
	
	static StateMachine getInstance(String type, double lowValue, double highValue ){
		if(type.equals("rising")){
			return new CheckRisingThreashold(lowValue, highValue);
		}else if (type.equals("falling")){
			return new CheckFallingThreashold(lowValue, highValue);
		}
		
		throw new IllegalArgumentException("Unknown statemachine "+type);
	}
}