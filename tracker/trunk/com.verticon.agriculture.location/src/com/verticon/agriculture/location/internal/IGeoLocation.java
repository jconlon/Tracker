package com.verticon.agriculture.location.internal;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.vividsolutions.jts.geom.Point;

public interface IGeoLocation {

	/**
	 * @return the id
	 */
	public abstract String getID();

	/**
	 * @return the resourceUri
	 */
	public abstract URI getAgriDocResourceUri();

	/**
	 * @return the address
	 */
	public abstract String getAddress();

	/**
	 * 
	 * @param point
	 * @return name of the smallest polygon containing the point
	 */
	public abstract String locate(Point point);

	/**
	 * 
	 * @return the names of all the polygons
	 */
	public abstract Set<String> polygonNames();

	public abstract String getName();

	public abstract boolean hasUri(String uri);

}