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

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.vividsolutions.jts.geom.Point;

/**
 * Immutable Data envelope for a Location that contains multiple bounded
 * locations.
 * 
 * @author jconlon
 * 
 */
public class GeoLocation {

	private final String id;
	private final URI agriDocResourceUri;
	private final String address;
	private final String name;
	private final ImmutableList<BoundedLocation> boundedLocations;
	private final ImmutableSet<String> associatedUris;

	/**
	 * 
	 * @param id
	 *            of the location, typically the premises uri
	 * @param agriDocResourceUri
	 *            of the agriculture document
	 * @param address
	 *            of the GeoLocation
	 * @param subLocations
	 *            inside this GeoLocation
	 * @param name
	 *            of location
	 */
	GeoLocation(String id, URI agriDocResourceUri, String address,
			ImmutableList<BoundedLocation> subLocations, String name,
			ImmutableSet<String> associatedUris) {
		super();
		this.id = id;
		this.agriDocResourceUri = agriDocResourceUri;
		this.address = address;
		this.boundedLocations = subLocations;
		this.name = name;
		this.associatedUris = associatedUris;
	}

	/**
	 * @return the id
	 */
	String getID() {
		return id;
	}

	/**
	 * @return the resourceUri
	 */
	URI getAgriDocResourceUri() {
		return agriDocResourceUri;
	}

	/**
	 * @return the address
	 */
	String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param point
	 * @return name of the smallest polygon containing the point
	 */
	String locate(Point point) {
		String result = null;
		BoundedLocation currentPolygon = null;
		for (BoundedLocation polygon : boundedLocations) {
			if (polygon.contains(point)) {
				if (currentPolygon == null) {
					currentPolygon = polygon;
					result = polygon.getName();
				} else if (polygon.getArea() < currentPolygon.getArea()) {
					currentPolygon = polygon;
					result = polygon.getName();
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @return the names of all the polygons
	 */
	Set<String> polygonNames() {
		Set<String> result = newHashSet();
		for (BoundedLocation polygon : boundedLocations) {
			result.add(polygon.getName());
		}
		return result;
	}

	String getName() {
		return name;
	}

	boolean hasUri(String uri) {
		return associatedUris.contains(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((associatedUris == null) ? 0 : associatedUris.hashCode());
		result = prime
				* result
				+ ((boundedLocations == null) ? 0 : boundedLocations.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((agriDocResourceUri == null) ? 0 : agriDocResourceUri
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoLocation other = (GeoLocation) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (associatedUris == null) {
			if (other.associatedUris != null)
				return false;
		} else if (!associatedUris.equals(other.associatedUris))
			return false;
		if (boundedLocations == null) {
			if (other.boundedLocations != null)
				return false;
		} else if (!boundedLocations.equals(other.boundedLocations))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (agriDocResourceUri == null) {
			if (other.agriDocResourceUri != null)
				return false;
		} else if (!agriDocResourceUri.equals(other.agriDocResourceUri))
			return false;
		return true;
	}

}
