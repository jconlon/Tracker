package com.verticon.tracker.irouter.wireadmin.internal;

public interface IWireCreator {

	/**
	 * Create a wire based on parameters
	 * @param wireParameters
	 */
	boolean handleWire(WireParameters wireParameters);
}
