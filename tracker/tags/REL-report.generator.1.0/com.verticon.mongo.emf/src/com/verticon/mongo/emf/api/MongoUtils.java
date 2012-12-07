package com.verticon.mongo.emf.api;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.mongo.emf.ext.ECollection;

import com.google.common.base.Strings;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/**
 * Utilities for manipulating MongoDB resources.
 * 
 * @author jconlon
 *
 */
public class MongoUtils {

	private static MongoURI getMongoDBURI(String hostname, String port,
			String database) {
		return new MongoURI(getURITail("mongodb", hostname, port, database));
	}

	public static EList<EObject> query(ResourceSet resourceSet, URI base,
			String collectionName, String query) {
		checkNotNull(base);
		checkNotNull(collectionName);
		checkNotNull(query);
		URI uri = createQueryURI(base, collectionName, query);
		Resource resource = resourceSet.getResource(uri, true);
		ECollection result = (ECollection) resource.getContents().get(0);
		return result.getValues();
	}

	public static URI createQueryURI(URI base, String collectionName,
			String query) {
		return createEMFCollectionURI(base, collectionName).appendQuery(
				URI.encodeQuery(query, false));
	}

	public static URI getEMFBaseURI(String hostname, String port,
			String database) {
		return URI.createURI(getURITail("mongodb", hostname, port, database));// +'/';
	}

	public static DB getMongoDB(String hostname, String port, String database)
			throws MongoException, UnknownHostException {
		return getMongoDBURI(hostname, port, database).connectDB();
	}

	/**
	 * 
	 * @param db
	 * @return Mapping MongoDB Collection names to EMF name spaces
	 */
	public static Map<String, String> getEMFCollections(DB db) {
		Map<String, String> emfCollections = new HashMap<String, String>();
		DBObject query = new BasicDBObject();
		DBObject filter = new BasicDBObject();
		filter.put("_eClass", 1);
		filter.put("_id", 0);
		DBObject answer = null;
		for (String name : db.getCollectionNames()) {
			DBCollection coll = db.getCollection(name);
			answer = coll.findOne(query, filter);
			if (answer != null) {
				String eClass = (String) answer.get("_eClass");
				if (!Strings.isNullOrEmpty(eClass)) {
					emfCollections.put(name,
							eClass.substring(0, eClass.indexOf("#//") + 3)
									+ name);
				}
			}
		}

		return Collections.unmodifiableMap(emfCollections);
	}

	/**
	 * Given a package namespace uri with a tagged element, find all the
	 * Subclasses and references subclasses from the package
	 * 
	 * @param nsURI
	 * @return EList of all the
	 */
	public static EList<Object> getChildren(String nsURI) {
		checkArgument(!Strings.isNullOrEmpty(nsURI),
				"nsURI must not be null or empty");
		String base = null;
		String target = null;
		int index = nsURI.indexOf("#//");
		if (index != -1) {
			base = nsURI.substring(0, index);
			target = nsURI.substring(index + 3);
		} else {
			throw new IllegalStateException(nsURI + " has no tagged element.");
		}

		EList<Object> choices = new UniqueEList.FastCompare<Object>();
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(base);
		if (ePackage == null) {
			throw new IllegalStateException("Could not find " + base);
		}

		EClassifier targetClassifier = ePackage.getEClassifier(target);
		if (targetClassifier == null) {
			throw new IllegalStateException("Could not find " + target);
		}

		EClass targetClass = null;
		if (targetClassifier instanceof EClass) {
			targetClass = (EClass) targetClassifier;
		}
		if (targetClass == null) {
			throw new IllegalStateException(target + " is not an EClass");
		}

		addSubClasses(choices, ePackage, targetClass);

		addReferences(choices, ePackage, targetClass);
		return choices;
	}

	public static void fillAttributes(String nsURI, List<String> attributes) {
		checkArgument(!Strings.isNullOrEmpty(nsURI),
				"nsURI must not be null or empty");
		String base = null;
		String target = null;
		int index = nsURI.indexOf("#//");
		if (index != -1) {
			base = nsURI.substring(0, index);
			target = nsURI.substring(index + 3);
		} else {
			throw new IllegalStateException(nsURI + " has no tagged element.");
		}

		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(base);
		if (ePackage == null) {
			throw new IllegalStateException("Could not find " + base);
		}

		EClassifier targetClassifier = ePackage.getEClassifier(target);
		if (targetClassifier == null) {
			throw new IllegalStateException("Could not find " + target);
		}

		EClass targetClass = null;
		if (targetClassifier instanceof EClass) {
			targetClass = (EClass) targetClassifier;
		}
		if (targetClass == null) {
			throw new IllegalStateException(target + " is not an EClass");
		}

		addAttributeNames(null, attributes, targetClass);
		for (EReference reference : targetClass.getEAllReferences()) {
			String referenceName = reference.getName()+'.';
			targetClass = reference.getEReferenceType();
			addAttributeNames(referenceName, attributes, targetClass);
		}
		Collections.sort(attributes);
	}

	private static void addAttributeNames(String prefix, List<String> attributes,
			EClass targetClass) {
		boolean addMongoLonLat = false;
		for (EAttribute attribute : targetClass.getEAllAttributes()) {
			if(
					attribute.getName().equals("longitude")||
					attribute.getName().equals("latitude")
			){
				addMongoLonLat = true;
				continue;
			}
				attributes.add(prefix!=null?prefix+attribute.getName():attribute.getName());			
		}
		if(addMongoLonLat){
			attributes.add(prefix!=null?prefix+"loc":"loc");
		}
	}

	private static URI createEMFCollectionURI(URI base, String collectionName) {
		return base.appendSegment(collectionName).appendSegment("");
	}

	private static String getURITail(String authority, String hostname,
			String port, String database) {
		return authority + "://" + hostname + (port != null ? ":" + port : "")
				+ "/" + database;
	}

	private static void addSubClasses(EList<Object> choices, EPackage ePackage,
			EClass targetClass) {
		for (Iterator<EClassifier> iterator = ePackage.getEClassifiers()
				.iterator(); iterator.hasNext();) {
			EClassifier classifier = iterator.next();
			if (classifier instanceof EClass) {
				if (targetClass.isSuperTypeOf((EClass) classifier)) {
					choices.add((EClass) classifier);
				}

			}
		}
	}

	private static void addReferences(EList<Object> choices, EPackage ePackage,
			EClass targetClass) {
		for (EReference ref : targetClass.getEAllReferences()) {
			EClass refEClass = ref.getEReferenceType();
			if (!choices.contains(refEClass)) {
				choices.add(refEClass);
				addSubClasses(choices, ePackage, refEClass);
				addReferences(choices, ePackage, refEClass);
				for (EAttribute eAttribute : refEClass.getEAllAttributes()) {
					EDataType eType = eAttribute.getEAttributeType();

					if (eType != null) {
						choices.add(eType);
					}
				}
			}

		}
	}
}
