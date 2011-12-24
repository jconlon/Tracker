package com.verticon.tracker.irouter.common;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;

public interface ITransactionHandler {

	/**
	 * Add envelopes to the transaction.  
	 * ID will be assigned by adding {@link TrackerConstants#ANIMAL_TAG_NUMBER_SCOPE}
	 * Transaction triggering will occur by adding {@link TrackerConstants#TRANSACTION_STATE_SCOPE}
	 * 
	 * @param envelope
	 */
	public abstract void add(Envelope envelope);

	/**
	 * Convenience method for retrieving measurements.
	 * @param scope
	 * @return measurement associated with the scope.
	 */
	public abstract Measurement get(String scope);

}