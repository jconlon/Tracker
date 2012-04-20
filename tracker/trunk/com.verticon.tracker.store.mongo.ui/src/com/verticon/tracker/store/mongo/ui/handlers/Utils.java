/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.mongo.ui.handlers;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;



public class Utils {
	static String PLUGIN_ID = "com.verticon.tracker.store.mongo.ui";
	/**
	 * slf4j Marker to keep track of bundle
	 */
    static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		Utils.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
}
