package com.verticon.tracker.tests;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Constants for logging.
 * @author jconlon
 *
 */
public class Constants {

	private static final String ID = "com.verticon.tracker.tests";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_TEST_TRACKER"));
		return bundleMarker;
	}
	
	private Constants() {//prevents instantiation
	}

}
