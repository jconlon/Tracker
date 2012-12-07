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

import java.util.Map;
import java.util.Set;

/**
 * ILocationService is a Geolocation service for finding location names 
 * and addresses of objects using:
 * <ol>
 * <li>object id references (typically URIs),</li>
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
	
	/**
	 * @param the object id
	 * @return id to name map of all the associates of the object
	 */
	Map<String,String> getAssociates(String id);

}
