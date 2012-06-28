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
 * LocationService for finding the names and addresses of target objects using:
 * <ol>
 * <li>references to the objects themselves,</li>
 * <li>object identifiers,</li>
 * <li>and object coordinates.</li>
 * 
 * @author jconlon
 * 
 */
public interface LocationService {

	/**
	 * 
	 * 
	 * @param targetUri
	 * @return geoFeature containing the target object
	 */
	String name(String targetUri);

	/**
	 * 
	 * @param target
	 * @return address of the geoFeature containing the target object
	 */
	String address(String targetUri);

	/**
	 * 
	 * @param container
	 * @param coordinates
	 * @return location within the container referenced by the coordinates
	 */
	String positionIn(String targetUri, String coordinates);
	
	/**
	 * 
	 * @param container
	 * @return names of locations within the uri
	 */
	Set<String> locationsIn(String targetUri);

}
