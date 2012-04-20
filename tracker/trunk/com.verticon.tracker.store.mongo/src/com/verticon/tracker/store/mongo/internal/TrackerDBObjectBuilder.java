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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mongo.emf.DBObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;

import com.mongodb.DBObject;

class TrackerDBObjectBuilder extends DBObjectBuilder {

	
	private Object latitude;
	private Object longitude;

	
	public TrackerDBObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean serializeDefaultAttributeValues) {
		super(converterService, uriHandler, serializeDefaultAttributeValues);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.DBObjectBuilder#buildDBObject(org.eclipse.emf
	 * .ecore.EObject)
	 */
	@Override
	public DBObject buildDBObject(EObject eObject) {
		String name = eObject.eClass().getName();
		if (name.equals("Position")) {
			latitude = null;
			longitude = null;
		}
		return super.buildDBObject(eObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.DBObjectBuilder#buildAttributeValue(com.mongodb
	 * .DBObject, org.eclipse.emf.ecore.EAttribute, java.lang.Object)
	 */
	@Override
	protected void buildAttributeValue(DBObject dbObject, EAttribute attribute,
			Object value) {
		String name = attribute.getName();
		// Latitude
		if (name.equals("latitude")) {
			latitude = value;
			if (longitude != null) {
				writeLocation(dbObject);
			}
			return;
			// Longitude
		} else if (name.equals("longitude")) {
			longitude = value;
			if (latitude != null) {
				writeLocation(dbObject);
			}
			return;
		}
		super.buildAttributeValue(dbObject, attribute, value);
	}

	private void writeLocation(DBObject dbObject) {
		dbObject.put("loc", new Object[] { longitude, latitude });
		longitude = null;
		latitude = null;
	}
}