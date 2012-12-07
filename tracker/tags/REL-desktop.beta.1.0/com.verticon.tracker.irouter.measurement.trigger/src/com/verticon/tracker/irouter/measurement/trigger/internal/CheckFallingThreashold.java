package com.verticon.tracker.irouter.measurement.trigger.internal;

import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.*;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;

/**
 * Checks values that fall
 * 
 * @author jconlon
 * 
 */
public class CheckFallingThreashold extends StateMachine {

	CheckFallingThreashold(double lowValue, double highValue) {
		super(lowValue, highValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckFallingThreashold [lowValue=" + lowValue + ", highValue="
				+ highValue + "]";
	}

	void evaluatedForArmedCondition(Measurement measurement) {
		if (measurement.getValue() >= highValue) {
			state = ARMED_STATE;
		}
	}

	void evaluatedForFiredCondition(Measurement measurement) {
		if (measurement.getValue() <= lowValue) {
			state = new State(FIRE, PLUGIN_ID, System.currentTimeMillis());
		}
	}

}
