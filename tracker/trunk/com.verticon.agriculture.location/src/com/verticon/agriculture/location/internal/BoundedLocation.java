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

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * Immutable data envelope for a Location with a boundary and a name.
 * 
 * @author jconlon
 * 
 */
public class BoundedLocation {

	private final String name;
	private final Polygon boundary;

	public BoundedLocation(Polygon boundary, String name) {
		this.boundary = boundary;
		this.name = name;
	}

	String getName() {
		return name;
	}

	public boolean contains(Point point) {
		return boundary.contains(point);
	}

	public double getArea() {
		return boundary.getArea();
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
		result = prime * result
				+ ((boundary == null) ? 0 : boundary.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BoundedLocation)) {
			return false;
		}
		BoundedLocation other = (BoundedLocation) obj;
		if (boundary == null) {
			if (other.boundary != null) {
				return false;
			}
		} else if (!boundary.equals(other.boundary)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
