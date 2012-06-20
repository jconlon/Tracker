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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mongo.emf.DBObjectBuilder;
import org.eclipselabs.mongo.emf.IConverterService;

import com.mongodb.DBObject;
import com.verticon.mongo.emf.api.IDBObjectBuilderDecorator;

/**
 * Builds MongoDB optimized documents
 * 
 * @author jconlon
 *
 */
class TrackerDBObjectBuilder extends DBObjectBuilder {

	private Object latitude;
	private Object longitude;
	private final List<IDBObjectBuilderDecorator> decorators;
	
	public TrackerDBObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean serializeDefaultAttributeValues,List<IDBObjectBuilderDecorator> decorators) {
		super(converterService, uriHandler, serializeDefaultAttributeValues);
		this.decorators=decorators;

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
		if (name.equals("Position")  || name.equals("Location")) {
			latitude = null;
			longitude = null;
		}

		DBObject result = super.buildDBObject(eObject);
		for (IDBObjectBuilderDecorator decorator : decorators) {
			decorator.decorateDBObject(eObject, result);
		}
		return result;
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

//	/* (non-Javadoc)
//	 * @see org.eclipselabs.mongo.emf.DBObjectBuilder#buildFeatureMap(com.mongodb.DBObject, org.eclipse.emf.ecore.EAttribute, java.lang.Object)
//	 */
//	@Override
//	protected void buildFeatureMap(DBObject dbObject, EAttribute attribute,
//			Object value) {
//		if(ATTS.containsKey(attribute.getName())){
//			System.out.println("Found "+attribute.getName());
//			buildMyFeatureMap(dbObject, attribute, value);
////			super.buildFeatureMap(dbObject, attribute, value);
//		}else{
//			// TODO Auto-generated method stub
//			super.buildFeatureMap(dbObject, attribute, value);
//
//		}
//	}
//	
//	protected void buildMyFeatureMap(DBObject dbObject, EAttribute attribute, Object value)
//	{
//		FeatureMap.Internal featureMap = (FeatureMap.Internal) value;
//		Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();
//		ArrayList<Object> dbFeatureMap = new ArrayList<Object>();
//
//		while (iterator.hasNext())
//		{
////			DBObject dbEntry = new BasicDBObject();
//			FeatureMap.Entry entry = iterator.next();
//			EStructuralFeature feature = entry.getEStructuralFeature();
////			dbEntry.put("key", EcoreUtil.getURI(feature).toString());
//
//			if (feature instanceof EAttribute)
//			{
//				EDataType eDataType = ((EAttribute) feature).getEAttributeType();
//
//				if (!MongoURIHandlerImpl.isNativeType(eDataType)){
////					dbEntry.put("value", convertEMFValueToMongoDBValue(eDataType, entry.getValue()));
//					dbFeatureMap.add(convertEMFValueToMongoDBValue(eDataType, entry.getValue()));
//				}else{
////					dbEntry.put("value", entry.getValue());
//					dbFeatureMap.add(entry.getValue());
//				}
//			}
//			else{
////				dbEntry.put("value", buildReferencedObject((EReference) feature, (EObject) entry.getValue()));
//				dbFeatureMap.add(buildReferencedObject((EReference) feature, (EObject) entry.getValue()));
//			}
//
////			dbFeatureMap.add(dbEntry);
//		}
//
////		dbObject.put(attribute.getName(), dbFeatureMap);
////		String attName = attribute.getName().replace("GroupGroup", "").replace("abstract", "");
//		
////		attName = attName.replace("GroupGroup", "");
////		char c = attName.toLowerCase().charAt(0);
////		attName = attName.substring(1);
////		StringBuffer buff = new StringBuffer();
////		buff.append('_').append(c).append(attName);
//		dbObject.put(ATTS.get(attribute.getName()), dbFeatureMap);
//	}

	private void writeLocation(DBObject dbObject) {
		dbObject.put("loc", new Object[] { longitude, latitude });
		longitude = null;
		latitude = null;
	}
}