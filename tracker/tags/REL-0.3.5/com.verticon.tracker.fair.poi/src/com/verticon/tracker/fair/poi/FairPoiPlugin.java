/**
 * 
 */
package com.verticon.tracker.fair.poi;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author jconlon
 * 
 */
public class FairPoiPlugin extends AbstractUIPlugin {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(FairPoiPlugin.class);

	private static final String ID = "com.verticon.tracker.fair.poi";

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		logger.debug(bundleMarker, "Started Bundle");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		logger.debug(bundleMarker, "Stopped Bundle");
	}

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = createBundleMarker();

	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
		return bundleMarker;
	}

}
