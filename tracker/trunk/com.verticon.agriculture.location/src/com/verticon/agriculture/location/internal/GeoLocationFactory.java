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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Boundary;
import com.verticon.opengis.kml.Container;
import com.verticon.opengis.kml.LinearRing;
import com.verticon.opengis.kml.Placemark;
import com.verticon.opengis.kml.Polygon;
import com.verticon.opengis.kml.util.KmlSwitch;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

/**
 * Factory for creating GeoLocation objects.
 * 
 * @author jconlon
 * 
 */
public class GeoLocationFactory extends KmlSwitch<Object> {
	private static final GeometryFactory geometryFactory = new GeometryFactory();
	private List<BoundedLocation> boundedLocations = newArrayList();
	private String address;
	private String placeMarkName = null;

	/**
	 * Build a GeoLocation from the container.
	 * 
	 * @param container
	 * @param id
	 * @param resourceUri
	 * @return GeoLocation
	 * @throws Exception
	 */
	IGeoLocation build(Container container, String id, URI resourceUri,
			ImmutableSet<String> associatedUris) {
		this.address = container.getAddress();
		placeMarkName = null;
		boundedLocations.clear();

		TreeIterator<Object> it = EcoreUtil.getAllContents(container, true);
		while (it.hasNext()) {
			EObject eobject = (EObject) it.next();
			// Visit all objects in the container
			Object drillDeeper = doSwitch(eobject);
			if (drillDeeper != null) {
				if (drillDeeper instanceof Boolean) {
					if (!(Boolean) drillDeeper) {
						it.prune();
					}
				}

			}
		}
		return new GeoLocation(id, resourceUri, address,
				ImmutableList.copyOf(boundedLocations), container.getName(),
				ImmutableSet.copyOf(associatedUris));
	}
	
	IGeoLocation build(Location location,  URI resourceUri) {
		this.address = location.getAddress();
		placeMarkName = null;
		boundedLocations.clear();
		if(location.getGeography()!=null){
			TreeIterator<Object> it = EcoreUtil.getAllContents(location.getGeography(), true);
			while (it.hasNext()) {
				EObject eobject = (EObject) it.next();
				// Visit all objects in the container
				Object drillDeeper = doSwitch(eobject);
				if (drillDeeper != null) {
					if (drillDeeper instanceof Boolean) {
						if (!(Boolean) drillDeeper) {
							it.prune();
						}
					}
				}
			}
			
		}
		return  new GeoLocation(location.getUri(), resourceUri, address,
				ImmutableList.copyOf(boundedLocations), location.getName(),
				getAssociatedResourceUris(location));
	}
	
	/**
	 * Create a set of URIS for the Premises and KML Container resources
	 * @param location
	 * @return
	 */
	private ImmutableSet<String> getAssociatedResourceUris(Location location) {
		Set<String> associatedUris = newHashSet();
		if(location.getGeography()!=null){
			associatedUris.add(location.getGeography().eResource().getURI()
					.toString());
		}
		associatedUris.add(location.getLivestock().eResource().getURI()
				.toString());
		return ImmutableSet.copyOf(associatedUris);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.opengis.kml.util.KmlSwitch#casePlacemark(com.verticon.opengis
	 * .kml.Placemark)
	 */
	@Override
	public Object casePlacemark(Placemark placeMark) {
		placeMarkName = placeMark.getName();
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.opengis.kml.util.KmlSwitch#casePolygon(com.verticon.opengis
	 * .kml.Polygon)
	 */
	@Override
	public Object casePolygon(Polygon object) {
		BoundedLocation namedPolygon = new BoundedLocation(
				openGisToJTS(object), placeMarkName);
		boundedLocations.add(namedPolygon);
		return Boolean.FALSE;
	}

	static com.vividsolutions.jts.geom.Polygon openGisToJTS(Polygon polygon) {
		Boundary boundry = polygon.getOuterBoundaryIs();
		LinearRing lr = boundry.getLinearRing();
		com.vividsolutions.jts.geom.LinearRing jts_lr = openGisToJTS(lr);
		return geometryFactory.createPolygon(jts_lr, null);
	}

	private static com.vividsolutions.jts.geom.LinearRing openGisToJTS(
			LinearRing lr) {
		List<String> s = lr.getCoordinates();
		com.vividsolutions.jts.geom.LinearRing jts_lr = geometryFactory
				.createLinearRing(createCoordinates(s));
		return jts_lr;
	}

	private static Coordinate[] createCoordinates(List<String> points) {
		for (Iterator<String> iterator = points.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (string.length() == 0) {
				iterator.remove();
			}

		}
		Coordinate[] results = new Coordinate[points.size()];
		for (int i = 0; i < points.size(); i++) {
			results[i] = createCoordinate(points.get(i));
		}
		return results;
	}

	static Coordinate createCoordinate(String point) {
		String[] results = point.split(",\\s*"); // split on commas
		return new Coordinate(Double.parseDouble(results[0]),
				Double.parseDouble(results[1]));
	}

	static Point createPoint(String point) {
		return geometryFactory.createPoint(GeoLocationFactory
				.createCoordinate(point));
	}

}
