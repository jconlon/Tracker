package com.verticon.tracker.irouter.wireadmin.internal;

public interface IWireCreator {

	/**
	 * Create a wire based on parameters
	 * @param wireParameters
	 */
	boolean createWire(WireParameters wireParameters);
}
