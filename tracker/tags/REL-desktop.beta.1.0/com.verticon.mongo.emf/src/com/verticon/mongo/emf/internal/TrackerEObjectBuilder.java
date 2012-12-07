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

package com.verticon.mongo.emf.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.mongo.emf.EObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * Builds EMF Objects from customized MongoEMF documents
 * @author jconlon
 *
 */
class TrackerEObjectBuilder extends EObjectBuilder {

	/**
	 * @param converterService
	 * @param uriHandler
	 * @param includeAttributesForProxyReferences
	 * @param eClassCache
	 */
	public TrackerEObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean includeAttributesForProxyReferences,
			Map<String, EClass> eClassCache) {
		super(converterService, uriHandler,
				includeAttributesForProxyReferences, eClassCache);

	}

	/**
	 * @param converterService
	 * @param uriHandler
	 * @param includeAttributesForProxyReferences
	 */
	public TrackerEObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean includeAttributesForProxyReferences) {
		super(converterService, uriHandler, includeAttributesForProxyReferences);

	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.eclipselabs.mongo.emf.EObjectBuilder#buildEObject(com.mongodb.
//	 * DBCollection, com.mongodb.DBObject,
//	 * org.eclipse.emf.ecore.resource.Resource, boolean)
//	 */
//	@Override
//	public EObject buildEObject(DBCollection collection, DBObject dbObject,
//			Resource resource, boolean isProxy) {
//		// TODO Auto-generated method stub
//		return super.buildEObject(collection, dbObject, resource, isProxy);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipselabs.mongo.emf.EObjectBuilder#buildAttribute(com.mongodb.
	 * DBCollection, com.mongodb.DBObject,
	 * org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.EObject,
	 * org.eclipse.emf.ecore.EAttribute)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void buildAttribute(DBCollection collection, DBObject dbObject,
			Resource resource, EObject eObject, EAttribute attribute) {
		String name = eObject.eClass().getName();
		if (name.equals("Position")  || name.equals("Location")) {
			if (attribute.getName().equals("longitude")) {
				Object value = dbObject.get("loc");
				if (value != null && value instanceof List) {
					List<Object> list = (List<Object>) value;
					// System.out.println("longitude=" + list.get(0));
					buildAttributeValue(eObject, attribute, list.get(0));
				}
			} else if (attribute.getName().equals("latitude")) {
				Object value = dbObject.get("loc");
				if (value != null && value instanceof List) {
					List<Object> list = (List<Object>) value;
					// System.out.println("latitude=" + list.get(1));
					buildAttributeValue(eObject, attribute, list.get(1));
				}
			}
		}
		super.buildAttribute(collection, dbObject, resource, eObject, attribute);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipselabs.mongo.emf.EObjectBuilder#buildAttributeValue(org.eclipse
	 * .emf.ecore.EObject, org.eclipse.emf.ecore.EAttribute, java.lang.Object)
	 */
	@Override
	protected void buildAttributeValue(EObject eObject, EAttribute attribute,
			Object value) {
		super.buildAttributeValue(eObject, attribute, value);
	}

}