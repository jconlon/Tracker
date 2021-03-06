/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.ocl.query.viewer;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Constants for logging.
 * @author jconlon
 *
 */
@SuppressWarnings("ucd")
class Constants {

	private static final String ID = "com.verticon.tracker.ocl.query.viewer";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	@SuppressWarnings("ucd")
	protected static final Marker bundleMarker = createBundleMarker();
	private static final Marker createBundleMarker() {
		Marker bundleMarker = MarkerFactory.getMarker(ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_TEST_TRACKER"));
		return bundleMarker;
	}
	
	private Constants() {//prevents instantiation
	}

}
