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
import static com.google.common.collect.Sets.newHashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.google.common.collect.ImmutableSet;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.agriculture.util.AgricultureSwitch;
import com.verticon.opengis.kml.Container;

class ResoureIndexBuilder extends AgricultureSwitch<Object> {
	/**
	 * GeoLocations for the resourceUri
	 */
	 List<GeoLocation> geoLocations = newArrayList();
	private final String resourceUri;
	private boolean foundAgriculture = false;
	private final Map<String, GeoLocation> index;

	ResoureIndexBuilder(String resourceUri, Map<String, GeoLocation> index) {
		super();
		this.resourceUri = resourceUri;
		this.index = index;
	}

	/**
	 * Validate the agriculture element
	 * 
	 * @see com.verticon.agriculture.util.AgricultureSwitch#caseAgriculture(com.verticon.agriculture.Agriculture)
	 */
	@Override
	public Object caseAgriculture(Agriculture agriculture) {
		Object result = null;
		foundAgriculture = true;
		// validate this object
		Diagnostic diagnostic = Diagnostician.INSTANCE
				.validate(agriculture);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			MarkerHelper mh = new MarkerHelper();
			try {
				mh.createMarkers(diagnostic);
				IStatus status = new Status(IStatus.ERROR,
						Component.PLUGIN_ID, diagnostic.getMessage());
				result = new CoreException(status);
			} catch (CoreException e) {
				result = e;
			}

		} else {
			result = Boolean.TRUE;// Descend into Agriculture
		}

		return result;
	}

	/**
	 * Validate that the location is uniquely defined by only one resource
	 * and build a geoLocation for every Agriculture Location
	 * 
	 * @see com.verticon.agriculture.util.AgricultureSwitch#caseLocation(com.verticon.agriculture.Location)
	 */
	@Override
	public Object caseLocation(Location location) {
		Object result = Boolean.FALSE;
		String id = location.getUri();
		Container container = location.getGeography();
		GeoLocation geoLocation;

		if (index.containsKey(id)) {
			String uriOfExistingLocation = index.get(id).getResourceUri();

			if (!uriOfExistingLocation.equals(resourceUri)) {

				String message = "Location is mapped by another agriculture resource at "
						+ uriOfExistingLocation;
				IStatus status = new Status(IStatus.ERROR,
						Component.PLUGIN_ID, message);
				Diagnostician.INSTANCE.createDefaultDiagnostic(location);
				Diagnostic diagnostic = BasicDiagnostic
						.toDiagnostic(status);
				MarkerHelper mh = new MarkerHelper();
				try {
					mh.createMarkers(diagnostic);
					result = new CoreException(status);
				} catch (CoreException e) {
					result = e;
				}

			}
		}

		geoLocation = new GeoLocationFactory().build(container, id, resourceUri,getAssociatedUris( location));
		geoLocations.add(geoLocation);

		return result;
	}
	
	private ImmutableSet<String> getAssociatedUris(Location location){
		Set<String> associatedUris = newHashSet();
		associatedUris.add(location.getGeography().eResource().getURI().toString());
		associatedUris.add(location.getLivestock().eResource().getURI().toString());
		return ImmutableSet.copyOf(associatedUris);
	}
	
	/**
	 * @return the foundAgriculture
	 */
    boolean isFoundAgriculture() {
		return foundAgriculture;
	}
}