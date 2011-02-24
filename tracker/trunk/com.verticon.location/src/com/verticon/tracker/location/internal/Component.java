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
package com.verticon.tracker.location.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.location.LocationService;
import com.verticon.tracker.location.LocationServiceProvider;

public class Component implements LocationService{

	List<LocationServiceProvider> serviceProviders = new CopyOnWriteArrayList<LocationServiceProvider>();
	
	@Override
	public String location(EObject eObject) {
		String result = null;
		for (LocationServiceProvider locationServiceProvider : serviceProviders) {
			if(locationServiceProvider.canHandle(eObject)){
				result = locationServiceProvider.location(eObject);
			}
		}
		return result;
	}

	@Override
	public String coordinates(EObject eObject) {
		String result = null;
		for (LocationServiceProvider locationServiceProvider : serviceProviders) {
			if(locationServiceProvider.canHandle(eObject)){
				result = locationServiceProvider.coordinates(eObject);
			}
		}
		return result;
	}
	
	@Override
	public String address(EObject eObject) {
		String result = null;
		for (LocationServiceProvider locationServiceProvider : serviceProviders) {
			if(locationServiceProvider.canHandle(eObject)){
				result = locationServiceProvider.address(eObject);
			}
		}
		return result;
	}

	public void setLocationServiceProivder(LocationServiceProvider locationServiceProvider){
		serviceProviders.add(locationServiceProvider);
	}
	
	public void unsetLocationServiceProivder(LocationServiceProvider locationServiceProvider){
		serviceProviders.remove(locationServiceProvider);
	}
	
	public void deactivate(){
		serviceProviders.clear();
	}
}
