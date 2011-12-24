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
 * @author jconlon
 *
 */
public class BoundedLocation {

	private final String name;
	private final Polygon boundary;
	

	public BoundedLocation(Polygon boundary, String name) {
		this.boundary = boundary;
		this.name=name;
	}
	
	String getName(){
		return name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6116358305710976838L;

	public boolean contains(Point point) {
		return boundary.contains(point);
	}

	public double getArea() {
		return boundary.getArea();
	}

}
