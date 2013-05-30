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

package com.verticon.tracker.store.mongodb.test.system;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ValidationException;

/**
 * 
 * 
 * For creating ConfigAdmin configuration for a dependent service of the
 * com.verticon.tracker.update.mongo component.
 * 
 * The dependent service is:
 * <ol>
 * <li>IMongoClientProvider</li>
 * </ol>
 * 
 * 
 * @author jconlon
 * 
 */
public class Configurator {

	static String PLUGIN_ID = "com.verticon.tracker.store.mongodb.test.system";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Configurator.class);

	static final String PREMISES_URI_H89234X = "urn:pin:H89234X";

	static final String PREMISES_URI_003ALKMN = "urn:pin:003ALKM";

	static final String PREMISES_URI = "jc:www.verticon";

	static final String ANIMAL_COLLECTION = "Animal";

	static final String OCD_COLLECTION = "OCD";

	static final String TAG_COLLECTION = "Tag";

	static final String PREMISES_COLLECTION = "Premises";

	static final String UPDATES_COLLECTION = "Updates";

	static final String DOC_PREMISES = "example.premises";

	static final String TAG_ID_1 = "1234567890";

	static final String TAG_ID_WITH_GENERIC_EVENT = "840456789012341";

	static final String FILE_TMP_OUT_PREMISES1 = "/tmp/out1.premises";

	static final String FILE_TMP_OUT_PREMISES2 = "/tmp/out2.premises";

	static final String TAG_ID_WITH_SIRE_AND_DAM = "840456789012343";

	private static final String FACTORY_PID_TRACKERSTORE = "com.verticon.tracker.store.mongodb";

	private static final String UNITTEST_PROPERTIES = "private/localhost.properties";

	// private static final String UNITTEST_PROPERTIES =
	// "private/tuna_replSet.properties";

	// private static final String UNITTEST_PROPERTIES =
	// "private/tuna.properties";

	// private static final String UNITTEST_PROPERTIES =
	// "private/mongolabs.properties";

	private static Properties localProps = new Properties();

	public Configurator() {
		super();
		init();
	}

	void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "Setting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

		// Configure the IMongoClientProvider
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID_TRACKERSTORE);
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("iMongoClientProvider", "remote");
		if (localProps.get("dbname") != null) {
			props.put("dbname", localProps.get("dbname"));
		} else {
			props.put("dbname", "test_tracker");
		}

		if (localProps.get("connection.uri") != null) {
			props.put("connection.uri", localProps.get("connection.uri"));
		}
		logger.info(bundleMarker, "Mongo Host{}", props.get("connection.uri"));
		if (localProps.get("password") != null) {
			props.put("password", localProps.get("password"));
		}
		if (localProps.get("username") != null) {
			props.put("username", localProps.get("username"));
		}
		// take all defaults
		// config.update(props);
		// logger.debug(bundleMarker,
		// "Created Configuration for IMongoClientProvider {}",
		// config.getPid());
		//
		// // Configure the MongoDB Consumer
		// config =
		// configAdmin.createFactoryConfiguration(FACTORY_PID_CONSUMER);
		// props = new Hashtable<String, Object>();
		props.put("tracker.wiring.group.name", "test");
		props.put("tracker.premises.uri", PREMISES_URI_H89234X);
		props.put("premises.animal.default", TrackerPackage.BOVINE_BISON);
		// wireadmin.consumer.scope
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				"animal.weight", "premises.tag", "gps.position",
				"mettler.weight", "premises.animal" });
		// take all defaults
		config.update(props);
		logger.debug(bundleMarker,
				"Created Configuration for IMongoClientProvider {}",
				config.getPid());

	}

	void unsetConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		logger.debug(bundleMarker, "UnSetting ConfigurationAdmin");
		deleteConfigurations(configAdmin);

	}

	private void deleteConfigurations(ConfigurationAdmin configAdmin) {
		try {
			Configuration[] configs = configAdmin.listConfigurations(null);
			if (configs != null) {
				for (Configuration configuration : configs) {
					logger.debug(bundleMarker, "Deleting Configuration {}",
							configuration.getPid());
					configuration.delete();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static boolean hasIndexedIDAttribute(DBCollection collection, String idField) {
		for (DBObject dbObject : collection.getIndexInfo()) {
			if (dbObject.containsField("name")) {
				if (dbObject.get("name").equals(idField)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param db
	 */
	static void removeLastModificationTimesOnAllResources(
			DBCollection collection) {
		collection.update(
				new BasicDBObject(),// All query
				new BasicDBObject("$unset", new BasicDBObject("update", 1)),
				false, true);

	}

	static boolean validateObject(EObject eObject) throws ValidationException {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR
				|| diagnostic.getSeverity() == Diagnostic.WARNING) {
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					throw new ValidationException(eObject,
							childDiagnostic.getMessage());
				}
			}
		}
		return true;
	}

	static void saveXMIResource(String fileName, Premises premises)
			throws IOException {
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

	static Resource getXMIResource(String fileName, String segment) {
		String pluginID = "com.verticon.tracker.store.mongodb.test.system";
		return getXMIResource(pluginID, fileName, segment);
	}

	static Resource getXMIResource(String pluginID, String fileName,
			String segment) {
		URI uri = URI.createPlatformPluginURI(pluginID, true);

		if (Strings.isNullOrEmpty(segment)) {
			uri = uri.appendSegments(new String[] { "resources", fileName });
		} else {
			uri = uri.appendSegments(new String[] { "resources", segment,
					fileName });
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		assertThat(resource, is(notNullValue()));
		assertThat(resource.getContents().size(), is(1));
		return resource;
	}

	// db.Tag.aggregate([
	// {$match: {"events.pid":"urn:pin:003ALKM"}},
	// {$unwind:"$events"},
	// { $group: { _id: null,
	// count: { $sum: 1 } } }
	// ]).result[0].count
	static int eventCount(DBCollection coll, String uri) {

		// create our pipeline operations, first with the $match
		DBObject match = new BasicDBObject("$match", new BasicDBObject(
				"events.pid", uri));

		// // build the $projection operation
		// DBObject fields = new BasicDBObject("department", 1);
		// fields.put("amount", 1);
		// fields.put("_id", 0);
		// DBObject project = new BasicDBObject("$project", fields );

		// Build the unwind
		DBObject unwind = new BasicDBObject("$unwind", "$events");

		// Now the $group operation
		DBObject groupFields = new BasicDBObject("_id", null).append("count",
				new BasicDBObject("$sum", 1));
		DBObject group = new BasicDBObject("$group", groupFields);

		// run aggregation
		AggregationOutput output = coll.aggregate(match, unwind, group);

		return (Integer) Iterables.get(output.results(), 0).get("count");

	}

	// static int eventCount(DBCollection coll, String uri) {
	// int count = 0;
	// BasicDBObject query = new BasicDBObject("events.pid", uri);
	//
	// BasicDBObject keysToReturn = new BasicDBObject();
	// keysToReturn.put("events", 1);
	//
	// DBCursor cur = coll.find(query, keysToReturn);
	// while (cur.hasNext()) {
	// DBObject response = cur.next();
	// BasicDBList subResult = (BasicDBList) response.get("events");
	// count = count + subResult.size();
	//
	// }
	//
	// return count;
	// }

	static boolean isValidObject(EObject eObject) {
		EcoreUtil.resolveAll(eObject);
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

	void init() {
		Bundle bundle = Platform
				.getBundle("com.verticon.tracker.store.mongodb.test.system");
		URL fileURL = bundle.getEntry(UNITTEST_PROPERTIES);
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
			if (file.exists()) {
				localProps.load(new FileReader(file));
			}
		} catch (Exception e1) {
			throw new IllegalStateException(e1);
		}
	}
}
