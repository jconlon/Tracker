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

import org.eclipse.emf.ecore.EClass;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.verticon.agriculture.AgriculturePackage;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.admin.AdminPackage;

/**
 * @author jconlon
 * 
 */
public enum Element {

	LOCATION(null, AgriculturePackage.Literals.LOCATION),
	//
	CONTAINER("id", KmlPackage.eINSTANCE.getContainer()),
	//
	PREMISES("uri", TrackerPackage.Literals.PREMISES),
	//
	ANIMAL("id", TrackerPackage.Literals.ANIMAL),
	//
	TAG("id", TrackerPackage.Literals.TAG),
	//
	OCD("iD", MetatypePackage.Literals.OCD),
	//
	ADMIN(null, AdminPackage.Literals.ADMIN);

	// private final String indexName;
	private final String key;
	private final String colName;
	final EClass eClass;

	Element(String index, EClass eClass) {
		this.key = index;
		this.eClass = eClass;
		this.colName = eClass.getName();
	}

	String getIndexKey() {
		return key;
	}

	String getCollectionName() {
		return colName;
	}

	void ensureIndexForIDAttribute(DB db) {
		if (!hasIndexedIDAttribute(db)) {
			ensureIndex(db);
		}
	}

	String getQuery(String id) {
		return key==null?null:key + "=='" + id + "'";
	}

	private boolean hasIndexedIDAttribute(DB db) {
		if(key==null){
			return false;
		}

		for (DBObject dbObject : db.getCollection(getCollectionName())
				.getIndexInfo()) {
			if (dbObject.containsField("name")
					&& dbObject.get("name").equals(key + "_1")) {
				return true;
			}
		}
		return false;
	}

	private void ensureIndex(DB db) {
		if(key==null){
			return;
		}
		DBCollection coll = db.getCollection(getCollectionName());
		// create index on "id",ascending
		DBObject dbObject = new BasicDBObject(key, 1);
		// unique,true
		coll.ensureIndex(dbObject, null, true);
		return;
	}

}
