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
package com.verticon.tracker.location;

import org.eclipse.emf.ecore.EObject;

public interface LocationService {
	
	/**
	 * 
	 * @param eObject 
	 * @return location name of eObject or null if unknown
	 */
	String location(EObject eObject);
	
	/**
	 * 
	 * @param eObject 
	 * @return coordinates of eObject or null if unknown
	 */
	String coordinates(EObject eObject);
	
	/**
	 * 
	 * @param eObject 
	 * @return address of eObject or null if unknown
	 */
	String address(EObject eObject);

}
