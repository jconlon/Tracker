package com.verticon.tracker.irouter.common.internal.bundle;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class BundleConstants {
	
	
	private BundleConstants() {
		throw new AssertionError();
	}
	/**
	 * Identify the plugin to the logger
	 */
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.common";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker= MarkerFactory.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
}
