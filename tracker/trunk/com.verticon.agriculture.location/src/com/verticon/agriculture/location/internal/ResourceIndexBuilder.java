/*******************************************************************************
 * Copyright (c) 2011 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.agriculture.location.internal;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.google.common.base.Strings;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.agriculture.util.AgricultureSwitch;

/**
 * Builds a List of GeoLocations that are contained in an 
 * Agriculture document.
 * 
 * @author jconlon
 *
 */
class ResourceIndexBuilder extends AgricultureSwitch<Object> {
	/**
	 * GeoLocations discovered in the Agriculture resourceUri
	 */
	private List<IGeoLocation> geoLocations = newArrayList();
	
	/**
	 * resourceUri of the Agriculture document to identify problems to the user
	 */
	private final URI resourceUri;
	private boolean foundAgriculture = false;
	/**
	 * Existing index
	 */
	private final Map<String, IGeoLocation> index;

	/**
	 * 
	 * @param resourceUri 
	 * @param index
	 */
	ResourceIndexBuilder(URI resourceUri, Map<String, IGeoLocation> index) {
		super();
		this.resourceUri = resourceUri;
		this.index = index;
	}

	/**
	 * 
	 * @see com.verticon.agriculture.util.AgricultureSwitch#caseAgriculture(com.verticon.agriculture.Agriculture)
	 */
	@Override
	public Object caseAgriculture(Agriculture agriculture) {
		foundAgriculture = true;
		return Boolean.TRUE;
	}

	/**
	 * Build a new geoLocation from the Location and add it to the list of geoLocations. 
	 * 
	 * @return a Boolean.False or a CoreException indicating a mapping conflict
	 * @see com.verticon.agriculture.util.AgricultureSwitch#caseLocation(com.verticon.agriculture.Location)
	 */
	@Override
	public Object caseLocation(Location location) {
		String locationURI = location.getUri();
		if (Strings.isNullOrEmpty(locationURI)) {

			String message = " Location uri must not be null in agriculture document "
					+ resourceUri;
			IStatus status = new Status(IStatus.ERROR, Component.PLUGIN_ID,
					message);
			Diagnostician.INSTANCE.createDefaultDiagnostic(location);
			Diagnostic diagnostic = BasicDiagnostic.toDiagnostic(status);
			MarkerHelper mh = new MarkerHelper();

			try {
				mh.createMarkers(diagnostic);
			} catch (CoreException e) {
			}
			return new CoreException(status);
		}

		Object result = Boolean.FALSE;
		if (index.containsKey(locationURI)) {
			URI existingAgriDocResourceUriValue = index.get(locationURI)
					.getAgriDocResourceUri();

			if (!existingAgriDocResourceUriValue.equals(resourceUri)) {

				String message = " Location uri="
						+ locationURI
						+ " in agriculture document resource "
						+ resourceUri
						+ " is already mapped by another agriculture document resource "
						+ existingAgriDocResourceUriValue;
				IStatus status = new Status(IStatus.ERROR, Component.PLUGIN_ID,
						message);
				Diagnostician.INSTANCE.createDefaultDiagnostic(location);
				Diagnostic diagnostic = BasicDiagnostic.toDiagnostic(status);
				MarkerHelper mh = new MarkerHelper();
				result = new CoreException(status);
				try {
					mh.createMarkers(diagnostic);
				} catch (CoreException e) {
				}
			}
		}else{
			IGeoLocation geoLocation = new GeoLocationFactory().build(location,
					resourceUri);
			geoLocations.add(geoLocation);
		}

		return result;
	}

	/**
	 * @return the geoLocations
	 */
    List<IGeoLocation> getGeoLocations() {
		return geoLocations;
	}
    
	/**
	 * @return the foundAgriculture
	 */
	boolean isFoundAgriculture() {
		return foundAgriculture;
	}
	
}