package com.verticon.tracker.irouter.measurement.trigger.internal;

import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.ARMED_STATE;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.FIRE;
import static com.verticon.tracker.irouter.measurement.trigger.internal.MeasurementTrigger.PLUGIN_ID;

import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;

/**
 * Checks values that rise
 * 
 * @author jconlon
 * 
 */
public class CheckRisingThreashold extends StateMachine {

	CheckRisingThreashold(double lowValue, double highValue) {
		super(lowValue, highValue);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CheckRisingThreashold [lowValue=" + lowValue + ", highValue="
				+ highValue + "]";
	}
	
	
	void evaluatedForArmedCondition(Measurement measurement) {
		if (measurement.getValue() <= lowValue) {
			state = ARMED_STATE;
		}
	}

	void evaluatedForFiredCondition(Measurement measurement) {
		if (measurement.getValue() >= highValue) {
			state = new State(FIRE, PLUGIN_ID, System.currentTimeMillis());
		}
	}

	

}
