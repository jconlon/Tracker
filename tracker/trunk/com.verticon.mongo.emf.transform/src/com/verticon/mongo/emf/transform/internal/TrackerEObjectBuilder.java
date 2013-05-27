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

package com.verticon.mongo.emf.transform.internal;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.google.common.cache.LoadingCache;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.verticon.mongo.emf.transform.internal.TrackerDBObjectBuilder.Reference;

/**
 * Builds EMF EObjects from MongoDB DBObjects optimized by
 * TrackerDBObjectBuilder.
 * 
 * @author jconlon
 * 
 */
class TrackerEObjectBuilder extends EObjectBuilder {

	private final LoadingCache<String, EClass> loadingCache;
	
	/**
	 * @param converterService
	 * @param uriHandler
	 * @param includeAttributesForProxyReferences
	 * @param loadingCache
	 */
	public TrackerEObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean includeAttributesForProxyReferences,
			LoadingCache<String, EClass> loadingCache) {
		super(converterService, uriHandler, includeAttributesForProxyReferences);
		this.loadingCache = loadingCache;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.mongo.emf.transform.internal.EObjectBuilder#getEClass(org
	 * .eclipse.emf.ecore.resource.ResourceSet, java.lang.String)
	 */
	@Override
	protected EClass getEClass(ResourceSet resourceSet, String eClassURI) {
		return loadingCache.getUnchecked(eClassURI);
	}



	/**
	 * Some attributes had their names shortened. Restore the name for
	 * <ol>
	 * <li>Position longitude and latitude</li>
	 * <li>Location longitude and latitude</li>
	 * </ol>
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void buildAttribute(DBCollection collection, DBObject dbObject,
			Resource resource, EObject eObject, EAttribute attribute) {
		String eObjectClassName = eObject.eClass().getName();

		if (eObjectClassName.equals("Tag") && attribute.getName().equals("id")) {
			// Add the id attribute back
			buildAttributeValue(eObject, attribute,
					dbObject.get(Constants.ID_KEY));
		}
		if (eObjectClassName.equals("Position")
				|| eObjectClassName.equals("Location")) {
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
			} else {

				super.buildAttribute(collection, dbObject, resource, eObject,
						attribute);
			}
		} else if (eObjectClassName.equals("OCD")
				&& attribute.getName().equals("iD")) {
			buildAttributeValue(eObject, attribute,
					dbObject.get(Constants.ID_KEY));
		} else {

			super.buildAttribute(collection, dbObject, resource, eObject,
					attribute);
		}

	}

	/**
	 * Some objects had their Class information stripped. Reintroduce Class in:
	 * <ol>
	 * <li>Premises Tags</li>
	 * <li>Premises StringToStringMap</li>
	 * </ol>
	 */
	@Override
	protected EObject createEObject(ResourceSet resourceSet, DBObject dbObject) {
		String eClassURI = (String) dbObject.get(Constants.ECLASS_KEY);
		if (eClassURI == null) {
			if (dbObject.containsField("events")
					&& dbObject.containsField("animal")) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_PREMISES_TAG;

			} else if (dbObject.containsField("key")
					&& dbObject.containsField("value")
					&& dbObject.keySet().size() == 2) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_STRING_TO_STRING_MAP;

			} else if (dbObject.containsField("iD")
					&& dbObject.containsField("name")) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_AD;

			} else if (dbObject.containsField("label")
					&& dbObject.containsField("value")) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_OPTION;

			} else if (dbObject.containsField("resource")
					&& dbObject.containsField("size")
					&& dbObject.keySet().size() == 2) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_ICON;

			} else if (dbObject.containsField("loc")
					&& dbObject.containsField("name")) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_LOCATION;

			} else if (dbObject.containsField("boundary")
					&& dbObject.containsField("name")) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_AREA;

			}else if (dbObject.containsField("key")
					
					&& dbObject.keySet().size() == 1) {
				eClassURI = TrackerDBObjectBuilder.CLASSURI_STRING_TO_STRING_MAP;

			} else {
				throw new IllegalStateException("Unsupported object: "
						+ dbObject);
			}
		} else if (!eClassURI.contains("http:")) {
			eClassURI = TrackerDBObjectBuilder.PREMISES_NAMESPACE + eClassURI;
		}

		EClass eClass = getEClass(resourceSet, eClassURI);
		return EcoreUtil.create(eClass);
	}

	/**
	 * <ol>
	 * <li>Reintroduce a Class and a references to OCD in GenericEvent</li>
	 * </ol>
	 */
	@Override
	protected void buildReference(DBCollection collection, DBObject dbObject,
			Resource resource, EObject eObject, EReference reference) {

		EClass eClass = eObject.eClass();
		// For GenericEvent objects reintroduce a class and a reference
		if (Reference.GENERIC_EVENT_OCD.is(eClass, reference)) {

			String ref = (String) dbObject.get("ocd");

			// Should look like this
			// "../OCD/#mettler.weight",
			// "_type" : "http://www.osgi.org/xmlns/metatype/v1.1.0#//OCD"
			DBObject dbReference = new BasicDBObject(Constants.PROXY_KEY,
					"../OCD/" + ref + "#/").append(Constants.ECLASS_KEY,
					TrackerDBObjectBuilder.CLASSURI_OCD);

			// System.out.println("ocd" + " = " + refId);

			EObject target = buildReferencedObject(collection, dbReference,
					resource, true);
			eObject.eSet(reference, target);

		}

		else if (Reference.TAG_ANIMAL.is(eClass, reference)) {
			// do nothing
		}

		else if (TrackerDBObjectBuilder.isAnimal_SireOrDam(eClass, reference)) {
			// do nothing
		}

		else if (TrackerDBObjectBuilder.ANIMAL_CLASS_NAMES.contains(eObject
				.eClass().getName()) && reference.getName().equals("tags")) {

			@SuppressWarnings("unchecked")
			List<String> tagIds = (List<String>) dbObject.get("tags");
			if (tagIds != null && !tagIds.isEmpty() && collection != null) {
				DB db = collection.getDB();
				DBCollection coll = db.getCollection("Tag");
				DBObject q = new BasicDBObject(Constants.ID_KEY,
						new BasicDBObject("$in", tagIds));
				DBCursor cursor = coll.find(q);

				@SuppressWarnings("unchecked")
				EList<EObject> eObjects = (EList<EObject>) eObject
						.eGet(reference);

				for (DBObject dbReference : cursor) {
					EObject target = buildReferencedObject(collection,
							dbReference, resource, true);
					eObjects.add(target);
				}
			}

		}

		else {
			super.buildReference(collection, dbObject, resource, eObject,
					reference);
		}
	}

	/**
	 * <ol>
	 * <li>Customize creation of Proxies for GenericEvent OCD references</li>
	 * </ol>
	 */
	@Override
	protected EObject buildProxy(DBCollection collection, DBObject dbReference,
			ResourceSet resourceSet, boolean referenceResolvesProxies) {

		// For OCD references inside the GenericEvent build a proxy
		if (dbReference.get(Constants.ECLASS_KEY).equals(
				TrackerDBObjectBuilder.CLASSURI_OCD)) {
			EObject eObject = createEObject(resourceSet, dbReference);
			String s = (String) dbReference.get(Constants.PROXY_KEY);
			URI uri = URI.createURI(s);
			String cName = uri.segment(1);
			DBCollection referenceCollection = collection.getDB()
					.getCollection(cName);
			if (referenceCollection != null) {
				String iD = uri.segment(2);
				DBObject referenceDBObject = new BasicDBObject(
						Constants.ID_KEY, iD);
				DBObject referencedDBObject = referenceCollection
						.findOne(referenceDBObject);

				if (referencedDBObject != null) {
					for (EAttribute attribute : eObject.eClass()
							.getEAllAttributes()) {
						if (!attribute.isTransient()
								&& !FeatureMapUtil.isFeatureMap(attribute)) {
							buildAttribute(referenceCollection,
									referencedDBObject, null, eObject,
									attribute);
						}
					}
					// Build the references
					List<EReference> refs = eObject.eClass().getEReferences();
					Resource resource = resourceSet.createResource(uri);

					for (EReference reference : refs) {
						buildReference(referenceCollection, referencedDBObject,
								resource, eObject, reference);
					}
				}
			}
			return eObject;
		}

		return super.buildProxy(collection, dbReference, resourceSet,
				referenceResolvesProxies);
	}

}