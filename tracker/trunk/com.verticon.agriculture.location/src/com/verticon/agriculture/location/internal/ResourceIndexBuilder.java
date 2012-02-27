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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.verticon.agriculture.Agriculture;
import com.verticon.agriculture.Location;
import com.verticon.agriculture.util.AgricultureSwitch;
import com.verticon.opengis.kml.Container;

class ResourceIndexBuilder extends AgricultureSwitch<Object> {
	/**
	 * GeoLocations for the resourceUri
	 */
	List<GeoLocation> geoLocations = newArrayList();
	private final URI resourceUri;
	private boolean foundAgriculture = false;
	private final Map<String, GeoLocation> index;

	ResourceIndexBuilder(URI resourceUri, Map<String, GeoLocation> index) {
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
	 * Validate that an Agriculture.Location uri is mapped only once.
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

		Container container = location.getGeography();
		GeoLocation geoLocation;

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
		}

		geoLocation = new GeoLocationFactory().build(container, locationURI,
				resourceUri, getAssociatedUris(location));
		geoLocations.add(geoLocation);

		return result;
	}

	private ImmutableSet<String> getAssociatedUris(Location location) {
		Set<String> associatedUris = newHashSet();
		associatedUris.add(location.getGeography().eResource().getURI()
				.toString());
		associatedUris.add(location.getLivestock().eResource().getURI()
				.toString());
		return ImmutableSet.copyOf(associatedUris);
	}

	/**
	 * @return the foundAgriculture
	 */
	boolean isFoundAgriculture() {
		return foundAgriculture;
	}
}