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

import com.google.common.base.Predicate;


/**
 * 
 * Predicate for a resoureUri specific GeoLocation
 * @author jconlon
 *
 */
class NotResourceUriPredicate implements Predicate<GeoLocation> {
	private final String resourceUri;

	NotResourceUriPredicate(String uri) {
		super();
		this.resourceUri = uri;
	}

	@Override
	public boolean apply(GeoLocation specific) {
		return !specific.getResourceUri().equals(resourceUri);
	}

}