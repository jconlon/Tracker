package com.verticon.tracker.transaction.publisher;

import java.io.IOException;

public interface ITransactionPublisher {

	/**
	 * Loads the animalTeplate from the file
	 * 
	 * @throws IOException
	 */
	public abstract void init() throws IOException;

	/**
	 * Called by client objects to publish the tag as a Templated Event to 
	 * all Premises in all Resources of the EditingDomain
	 * 
	 * @param tag
	 */
	public abstract void publish(Long tag);

}