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
package com.verticon.tracker.store.mongo.test.system.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;

import com.google.common.base.Strings;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.util.AgricultureResourceFactoryImpl;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.osgi.metatype.MetatypePackage;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.admin.AdminPackage;
import com.verticon.tracker.util.TrackerResourceFactoryImpl;

public class TestUtils {

	static boolean isValidObject(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					System.err.println("\t" + childDiagnostic.getMessage());
				}
			}
			return false;
		}
		return true;

	}
	
	static void saveXMIResource(String fileName, Premises premises) throws IOException{
		checkNotNull(fileName);
		checkNotNull(premises);
		checkArgument(fileName.endsWith(".premises"));
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(new File("resources/" + fileName)
		.getAbsolutePath());
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(premises);
		resource.save(null);
	}
	
//	private static Set<String> getAnimalIDs(DB db, String uri, Date fromDate,
//			Date toDate) {
//		
//		BasicDBObject dateMatch = new BasicDBObject();
//		dateMatch.put("dateTime", new BasicDBObject(QueryOperators.GTE,
//				fromDate).append(QueryOperators.LT, toDate));
//
//		BasicDBObject elementMatch = new BasicDBObject();
//		elementMatch.put("$elemMatch", dateMatch.append("pid", uri));
//		BasicDBObject query = new BasicDBObject("events", elementMatch);
//
//		BasicDBObject keysToReturn = new BasicDBObject();
//		keysToReturn.put("animal._eProxyURI", 1);
//
//		// logger.info(bundleMarker, "query: {}",query);
//
//		Set<String> mongoIDs = new HashSet<String>();
//		DBCursor cur = db.getCollection("Tag").find(query, keysToReturn);
//		while (cur.hasNext()) {
//			DBObject response = cur.next();
//
//			DBObject subResult = (DBObject) response.get("animal");
//			String proxy = (String) subResult.get("_eProxyURI");
//			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
//			// | |
//			String mongoID = proxy.substring(proxy.lastIndexOf('/') + 1,
//					proxy.lastIndexOf('#'));
//			mongoIDs.add(mongoID);
//		}
//		
//		return mongoIDs;
//	}
	
	 static int eventCount(DB db, String uri) {
		

		int count = 0;
		BasicDBObject query = new BasicDBObject("events.pid", uri);

		BasicDBObject keysToReturn = new BasicDBObject();
		keysToReturn.put("events", 1);


		
		DBCursor cur = db.getCollection("Tag").find(query, keysToReturn);
		while (cur.hasNext()) {
			DBObject response = cur.next();

			BasicDBList subResult =  (BasicDBList) response.get("events");
			
			for (@SuppressWarnings("unused") Object object : subResult) {
//				System.out.println("************ "+subResult);
				count++;
			}
			
//			String proxy = (String) subResult.get("_eProxyURI");
			// "../Animal/4f5e3604a8d60b3072b2e919#840003002956464"
			
		
		}
		
		return count;
	}

	/**
	 * @return
	 */
	static Resource getXMIResource(String fileName, ResourceSet resourceSet) {
		URI uri = createURI(fileName);
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	static ResourceSet getResoureSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("agri", new AgricultureResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(AgriculturePackage.eNS_URI,
				AgriculturePackage.eINSTANCE);

		// Premises
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("premises", new TrackerResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TrackerPackage.eNS_URI,
				TrackerPackage.eINSTANCE);

		// KML
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("kml", new GenericXMLResourceFactoryImpl());

		return resourceSet;
	}

	static Resource createXMIResource(String fileName, ResourceSet resourceSet) {
		URI uri = createURI(fileName);
		Resource resource = resourceSet.createResource(uri);
		return resource;
	}

	static URI createURI(String fileName) {
		URI uri = URI.createFileURI(new File("resources/" + fileName)
				.getAbsolutePath());
		return uri;
	}

	static Resource getXMIResource(String fileName, String segment) {
		URI uri = URI.createPlatformPluginURI(
				"com.verticon.tracker.store.mongo.test.system", true);
		
		if(Strings.isNullOrEmpty(segment)){
			uri = uri.appendSegments(new String[] { "resources", fileName });
		}else{
			uri = uri.appendSegments(new String[] { "resources", segment, fileName });
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		return resource;
	}

	static DiffModel getDiff(EObject v1, EObject v2) throws Exception {
		MatchModel match = new GenericMatchEngine().contentMatch(v1, v2,
				Collections.<String, Object> emptyMap());
		DiffModel diff = new GenericDiffEngine().doDiff(match);
		return diff;
	}

	/**
	 * @param collection
	 * @throws IOException
	 */
	static boolean hasIndexedIDAttribute(String collection, DB db,
			String idField) {
		for (DBObject dbObject : db.getCollection(collection).getIndexInfo()) {
			if (dbObject.containsField("name")) {
				if (dbObject.get("name").equals(idField)) {
					return true;
				}
			}
		}
		return false;
	}

//	private static void setLastUpdate(DB db, Date date) {
//		DBCollection collection = db.getCollection("Members");
//		DBObject searchQuery = new BasicDBObject("id", Member.ONE.uri);
//		// searchQuery.put("pw", password);
//		BasicDBObject newValues = new BasicDBObject("update", date);
//		// newValues.append("name", "Some Name");
//		BasicDBObject set = new BasicDBObject("$set", newValues);
//		collection.update(searchQuery, set);
//	}

	/**
	 * @param db
	 */
	 static void removeLastModificationTimesOnAllResources(DB db) {
		db.getCollection("Updates").update(
				new BasicDBObject(),// All query
				new BasicDBObject("$unset", new BasicDBObject("update", 1)),
				false, true);

	}

	static void clearDB(DB db) {
		db.getCollection(AdminPackage.Literals.ADMIN.getName()).remove(
				new BasicDBObject());
		db.getCollection(TrackerPackage.Literals.ANIMAL.getName()).remove(
				new BasicDBObject());
		db.getCollection(TrackerPackage.Literals.TAG.getName()).remove(
				new BasicDBObject());
		db.getCollection(MetatypePackage.Literals.OCD.getName()).remove(
				new BasicDBObject());
		db.getCollection(TrackerPackage.Literals.PREMISES.getName()).remove(
				new BasicDBObject());
		db.getCollection(AgriculturePackage.Literals.LOCATION.getName())
				.remove(new BasicDBObject());
		db.getCollection(KmlPackage.eINSTANCE.getContainer().getName()).remove(
				new BasicDBObject());
	
		removeLastModificationTimesOnAllResources(db);
	}
}
