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

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Predicate;

/**
 * 
 * Predicate for passing all GeoLocations that are not in a resoureUri.
 * 
 * Filters out all GeoLocations that are in the resourceUri.
 * 
 * @author jconlon
 * 
 */
class NotResourceUriPredicate implements Predicate<GeoLocation> {
	private final URI resourceUri;

	NotResourceUriPredicate(URI resourceUri) {
		super();
		this.resourceUri = resourceUri;
	}

	/**
	 * returns true for all GeoLocations that are not in the resource
	 */
	@Override
	public boolean apply(GeoLocation specific) {
		return !specific.getAgriDocResourceUri().equals(resourceUri);
	}

}