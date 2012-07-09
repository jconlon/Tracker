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
package com.verticon.location.service;

import java.util.Set;

/**
 * ILocationService for finding the names and addresses of target objects using:
 * <ol>
 * <li>references to the objects themselves,</li>
 * <li>object identifiers,</li>
 * <li>and object coordinates.</li>
 * 
 * @author jconlon
 * 
 */
public interface ILocationService {

	/**
	 * 
	 * 
	 * @param targetId
	 * @return geoFeature containing the target id
	 */
	String name(String targetId);

	/**
	 * 
	 * @param targetId 
	 * @return address of the geoFeature containing the target id
	 */
	String address(String targetId);
	
	/**
	 * 
	 * @param point in Longitude,Latitude,and Altitude format
	 * @return name of location containing the point
	 */
	String locate(String point);
	
	/**
	 * 
	 * @param targetId
	 * @return names of locations within the target
	 */
	Set<String> locationsIn(String targetId);

}
