/*******************************************************************************
 * Copyright (c) 2006 - 2010 ekke (ekkehard gentz) rosenheim germany.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * License: EPL (Eclipse Public License)
 * http://ekkes-corner.org, http://gentz-software.de
 * mailto: ekke[at]ekkes-corner.org
 * twitter: [at]ekkescorner
 * 
 * Contributors:
 *    ekke (ekkehard gentz) - initial API and implementation 
 * 
 ***********************************************copyright 2006 - 2010**********/
package org.ekkescorner.logging.logback.util;

import org.ekkescorner.logging.core.LoggingConstants;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author ekke
 * 
 * Prints the Name of the Bundle if its a BundleMarker
 *
 */
public class BundleMarkerConverter extends ClassicConverter {
	
	private static final String EMPTY = ""; //$NON-NLS-1$
	

	@Override
	public String convert(ILoggingEvent le) {
		Marker marker = le.getMarker();
		if (marker == null) {
			return EMPTY;
		} 
		if (marker.contains(MarkerFactory.getMarker(LoggingConstants.IS_BUNDLE_MARKER))) {
			return LoggingConstants.BUNDLE_PREFIX+marker.getName()+LoggingConstants.BUNDLE_POSTFIX;
		}
		return EMPTY;
	}

}
