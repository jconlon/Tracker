/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store.mongo.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipselabs.mongo.emf.DBObjectBuilder;
import org.eclipselabs.mongo.emf.EObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;
import org.eclipselabs.mongo.emf.IDBObjectBuilderFactory;
import org.eclipselabs.mongo.emf.IEObjectBuilderFactory;

/**
 * @author jconlon
 * 
 */
public class BuilderFactory implements IDBObjectBuilderFactory,
		IEObjectBuilderFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.IEObjectBuilderFactory#createObjectBuilder(
	 * org.eclipselabs.mongo.emf.IConverterService,
	 * org.eclipse.emf.ecore.xmi.XMLResource.URIHandler, boolean, java.util.Map)
	 */
	@Override
	public EObjectBuilder createObjectBuilder(
			IConverterService converterService, URIHandler uriHandler,
			boolean includeAttributesForProxyReferences,
			Map<String, EClass> eClassCache) {
		return new TrackerEObjectBuilder(converterService, uriHandler,
				includeAttributesForProxyReferences);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipselabs.mongo.emf.IDBObjectBuilderFactory#createBuilder(org.
	 * eclipselabs.mongo.emf.IConverterService,
	 * org.eclipse.emf.ecore.xmi.XMLResource.URIHandler, boolean)
	 */
	@Override
	public DBObjectBuilder createBuilder(IConverterService converterService,
			URIHandler uriHandler, boolean serializeDefaultAttributeValues) {
		return new TrackerDBObjectBuilder(converterService, uriHandler,
				serializeDefaultAttributeValues);
	}

}
