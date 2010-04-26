package com.verticon.tracker.reader.event.bluetooth;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

final class Constants {

	/**
	 * slf4j Marker to keep track of bundle
	 */
    static final Marker bundleMarker = createBundleMarker();
	
	// The identifier for this plugin
    static final String ID = "com.verticon.tracker.reader.bluetooth";

	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}
}
