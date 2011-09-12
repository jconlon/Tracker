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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.vividsolutions.jts.geom.Point;

/**
 * Immutable Data envelope for a Location that contains multiple 
 * bounded locations.
 * 
 * @author jconlon
 *
 */
public class GeoLocation {

	private final String id;
	private final String resourceUri; 
	private final String address;
	private final String name;
	private final ImmutableList<BoundedLocation> boundedLocations;
	private final ImmutableSet<String> associatedUris;

	
	/**
	 * 
	 * @param id of the location, typically the premises uri
	 * @param resourceUri of the agriculture document
	 * @param address of the GeoLocation
	 * @param subLocations inside this GeoLocation
	 * @param name of location
	 */
	GeoLocation(String id, String resourceUri, String address,
			ImmutableList<BoundedLocation> subLocations,String name, ImmutableSet<String> associatedUris) {
		super();
		this.id = id;
		this.resourceUri = resourceUri;
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
	 String getResourceUri() {
		return resourceUri;
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
	Set<String> polygonNames(){
		Set<String> result = newHashSet();
		for (BoundedLocation polygon : boundedLocations) {
			result.add(polygon.getName());
		}
		return result;
	}


	 String getName() {
		return name;
	}

	boolean hasUri(String uri){
		return associatedUris.contains(uri);
	}
}
