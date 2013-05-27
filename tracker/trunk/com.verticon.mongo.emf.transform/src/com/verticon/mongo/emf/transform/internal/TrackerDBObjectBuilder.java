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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.ImmutableList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;



/**
 * Builds MongoDB optimized documents
 * 
 * 
 * @author jconlon
 * 
 */
class TrackerDBObjectBuilder extends DBObjectBuilder {

	// CLASSURIs
	static final String CLASSURI_AREA = "http://www.verticon.com/location/1.0/loc#//Area";
	static final String CLASSURI_LOCATION = "http://www.verticon.com/location/1.0/loc#//Location";
	static final String CLASSURI_PREMISES_TAG = "http://www.verticon.com/tracker/0.4.2/premises#//Tag";
	static final String CLASSURI_STRING_TO_STRING_MAP = "http://www.verticon.com/tracker/0.4.2/premises#//StringToStringMap";
	static final String CLASSURI_OCD = "http://www.osgi.org/xmlns/metatype/v1.1.0#//OCD";
	static final String CLASSURI_AD = "http://www.osgi.org/xmlns/metatype/v1.1.0#//AD";
	static final String CLASSURI_OPTION = "http://www.osgi.org/xmlns/metatype/v1.1.0#//Option";
	static final String CLASSURI_ICON = "http://www.osgi.org/xmlns/metatype/v1.1.0#//Icon";

	/**
	 * All the Mongo DBObject will have this stripped out of the class to just
	 * show the class name
	 */
	static final String PREMISES_NAMESPACE = "http://www.verticon.com/tracker/0.4.2/premises#//";

	static final ImmutableList<String> IGNORED_URIS = ImmutableList.of(
			CLASSURI_LOCATION,
			CLASSURI_AREA,
			CLASSURI_PREMISES_TAG, CLASSURI_STRING_TO_STRING_MAP, CLASSURI_AD,
			CLASSURI_OPTION, CLASSURI_ICON);

	static final ImmutableList<String> ANIMAL_CLASS_NAMES = ImmutableList.of(
			"BovineBeef", "BovineBison", "BovineDairy", "Caprine", "Ovine",
			"Swine", "Equine");

	private Object latitude;
	private Object longitude;
	private final boolean serializeDefaultAttributeValues;

	public TrackerDBObjectBuilder(IConverterService converterService,
			org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler,
			boolean serializeDefaultAttributeValues) {
		super(converterService, uriHandler, serializeDefaultAttributeValues);
		this.serializeDefaultAttributeValues = serializeDefaultAttributeValues;

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
		if (name.equals("Position") || name.equals("Location")) {
			latitude = null;
			longitude = null;
		}

		BasicDBObject dbObject = new BasicDBObject();
		EClass eClass = eObject.eClass();

		// We have to add the URI of the class to the object so that we can
		// reconstruct the EMF object when we read it back out of MongoDB.
		String eClassString = EcoreUtil.getURI(eClass).toString();

		// Many class names in the Premises namespace are redundant and
		// should be ignored. Others should just be shortened.
		// Shorten the eClassString attribute for those that are not ignored.
		if (!IGNORED_URIS.contains(eClassString)) {
			eClassString = eClassString.replace(PREMISES_NAMESPACE, "");
			dbObject.put(Constants.ECLASS_KEY, eClassString);
		}

		// Save the XML extrinsic id if necessary
		buildExtrensicID(eObject, dbObject);

		// All attributes are mapped as key / value pairs with the key being the
		// attribute name.
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			// Remove the id attribute from all Premises Animals.
			// The animal document will use an ObjectId as primary
			// index and this will be referenced by the documents in
			// the Tag collection. This ObjectId is stored in the
			// Tag animal attribute. To find animals find the Tag id
			// and its animal attribute first, then use it to find the
			// animal.
			if (ANIMAL_CLASS_NAMES.contains(eClassString)
					&& attribute.getName().equals("id")) {
				continue;// Removes the id attribute
			}
			if (CLASSURI_PREMISES_TAG.equals(eClassString)
					&& attribute.getName().equals("id")) {
				// For Tags use the id for the primary key
				// and dont create an id attribute
				Object value = eObject.eGet(attribute);
				dbObject.put(Constants.ID_KEY, value);
				continue;
			}
			if (CLASSURI_OCD.equals(eClassString)
					&& attribute.getName().equals("iD")) {
				// For OCD use the iD as the primary key
				// and dont create an iD attribute
				Object value = eObject.eGet(attribute);
				dbObject.put(Constants.ID_KEY, value);
				continue;
			}
			if (!attribute.isTransient()
					&& (eObject.eIsSet(attribute) || (!attribute.isUnsettable() && serializeDefaultAttributeValues))) {
				// build normal attribute
				buildAttribute(eObject, dbObject, attribute);
			}
		}

		// All references are mapped as key / value pairs with the key being the
		// reference name.
		for (EReference reference : eClass.getEAllReferences()) {

			if (Reference.TAG_ANIMAL.is(eClass, reference)) {
				// Remove the reference from tag to the animal because
				// it will be created externally.)
				continue;
			}

			if (Reference.GENERIC_EVENT_OCD.is(eClass, reference)
					&& eObject.eIsSet(reference)) {
				// For GenericEvent.ocd consolidate the reference to just point
				// to the _id on the OCD
				EObject targetObject = (EObject) eObject.eGet(reference, false);
				dbObject.put(reference.getName(), EcoreUtil
						.getURI(targetObject).fragment());

			} else if (isAnimal_SireOrDam(eClass, reference)
					&& eObject.eIsSet(reference)) {
				// For Animal.sire or Animal.dam just point to the _id on the
				// Tag
				EObject targetObject = (EObject) eObject.eGet(reference, false);
				dbObject.put(reference.getName(), EcoreUtil
						.getURI(targetObject).fragment());

			} else if (!reference.isTransient() && eObject.eIsSet(reference)) {
				// Handle all others normally
				buildReference(eObject, dbObject, reference);

			}
		}

		return dbObject;
	}

	static boolean isAnimal_SireOrDam(EClass eClass, EReference reference) {
		return ANIMAL_CLASS_NAMES.contains(eClass.getName())
				&& (reference.equals("sire") || (reference.getName()
						.equals("dam")));

	}

	/**
	 * Shorten location oriented attributes names. There are two here.
	 * 
	 * TODO We are holding state for this, can it be refactored?
	 * <ol>
	 * <li>Position longitude and latitude</li>
	 * <li>Location longitude and latitude</li>
	 * </ol>
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

	static enum Reference {
		TAG_ANIMAL("Tag", "animal"), //
		GENERIC_EVENT_OCD("GenericEvent", "ocd"), //
		OCD_ICON("OCD", "icon");//

		final String className;
		final String referenceName;

		Reference(String className, String referenceName) {
			this.className = className;
			this.referenceName = referenceName;
		}

		boolean is(EClass eClass, EReference reference) {
			return eClass.getName().equals(className)
					&& reference.getName().equals(referenceName);
		}
	}
}
