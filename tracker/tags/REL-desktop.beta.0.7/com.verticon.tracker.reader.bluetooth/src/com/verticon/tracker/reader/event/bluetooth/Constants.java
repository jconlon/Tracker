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
