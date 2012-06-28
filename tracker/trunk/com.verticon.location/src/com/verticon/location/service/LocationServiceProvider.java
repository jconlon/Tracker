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

/**
 * 
 * @author jconlon
 *
 */
public interface LocationServiceProvider extends LocationService{
	
	/**
	 * 
	 * @param target
	 * @return true if a locationService is provided for the target
	 */
	boolean canHandle(Object target);
}
