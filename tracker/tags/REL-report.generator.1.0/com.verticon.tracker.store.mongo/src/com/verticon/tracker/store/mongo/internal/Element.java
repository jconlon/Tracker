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
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.admin.AdminPackage;

/**
 * 
 * @author jconlon
 * 
 */
public enum Element {

//	LOCATION(null, AgriculturePackage.Literals.LOCATION,"loc"),
	//
//	CONTAINER("id", KmlPackage.eINSTANCE.getContainer(), null),
//	ASSOCIATION("name", AgriculturePackage.Literals.ASSOCIATION, null),
	//
//	PLACEMARK("id", KmlPackage.eINSTANCE.getPlacemark(), null),
	//
	PREMISES("uri", TrackerPackage.Literals.PREMISES, "location.loc"),
	//
	ANIMAL("id", TrackerPackage.Literals.ANIMAL, null),
	//
	TAG("id", TrackerPackage.Literals.TAG, "events.loc"),
	//
	OCD("iD", MetatypePackage.Literals.OCD, null),
	//
	ADMIN(null, AdminPackage.Literals.ADMIN, null);

	// private final String indexName;
	private final String indexKey;
	private final String colName;
	private final String geoIndexKey;
	final EClass eClass;
	private static final boolean IS_NATIVE_JSON = true;

	Element(String index, EClass eClass, String geoIndex) {
		this.indexKey = index;
		this.eClass = eClass;
		this.colName = eClass.getName();
		this.geoIndexKey=geoIndex;
	}

	String getIndexKey() {
		return indexKey;
	}

	String getCollectionName() {
		return colName;
	}

//	void ensureIndexForIDAttribute(DB db) {
////		if (!hasIndexedIDAttribute(db)) {
//			ensureIndex(db);
////		}
//	}
	//FIXME for alternate query languages
	String getQuery(String id) {
		String query;
		if(IS_NATIVE_JSON){
			query= indexKey==null?null:"{'"+indexKey + "' : '" + id + "'}";
		}else{
			//Simple query
			query= indexKey==null?null:indexKey + "=='" + id + "'";
		}
		return query;
		
	}

//	private boolean hasIndexedIDAttribute(DB db) {
//		if(indexKey==null){
//			return false;
//		}
//
//		for (DBObject dbObject : db.getCollection(getCollectionName())
//				.getIndexInfo()) {
//			if (dbObject.containsField("name")
//					&& dbObject.get("name").equals(indexKey + "_1")) {
//				return true;
//			}
//		}
//		return false;
//	}

	 void ensureIndex(DB db) {
		if(indexKey!=null){
			DBCollection coll = db.getCollection(colName);
			// create index on "id",ascending
			DBObject dbObject = new BasicDBObject(indexKey, 1);
			// unique,true
			coll.ensureIndex(dbObject, null, true);
		}
		if(geoIndexKey !=null){
			DBCollection coll = db.getCollection(colName);
			DBObject dbObject = new BasicDBObject(geoIndexKey, "2d");
			coll.ensureIndex(dbObject, null, true);
		}
	}

}
