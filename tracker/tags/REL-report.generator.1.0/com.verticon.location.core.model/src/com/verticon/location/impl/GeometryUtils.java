package com.verticon.location.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * Utilities for creating Points and Polygons.
 * 
 * @author jconlon
 *
 */
public class GeometryUtils {
	private static final GeometryFactory geometryFactory = new GeometryFactory();
	
	static Point createPoint(String point) {
		return geometryFactory.createPoint(createCoordinate(point));
	}
	
	static Polygon createPolygon(String coordinates) {
		String[] coordinateStrings = coordinates.split(" ");
		List<String> coordinateList = Arrays.asList(coordinateStrings);
		LinearRing linearRing = createLinearRing(coordinateList);
		return geometryFactory.createPolygon(linearRing, null);
	}

	private static LinearRing createLinearRing(List<String> s) {
		return geometryFactory.createLinearRing(createCoordinates(s));
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
	
	private static Coordinate createCoordinate(String point) {
		String[] results = point.split(",\\s*"); // split on commas
		if(results.length<2){
			throw new IllegalArgumentException("The argument '"+point+"' cannot be split into more than one coordinate value");
		}
		return new Coordinate(Double.parseDouble(results[0]),
				Double.parseDouble(results[1]));
	}

	
}
