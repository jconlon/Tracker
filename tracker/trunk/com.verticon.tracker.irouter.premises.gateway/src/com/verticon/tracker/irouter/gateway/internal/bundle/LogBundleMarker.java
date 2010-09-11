package com.verticon.tracker.irouter.gateway.internal.bundle;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class LogBundleMarker {

	//The identifier for this plugin
    public static final String ID = "com.verticon.tracker.irouter.gateway";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker =  MarkerFactory.getMarker(ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
}
