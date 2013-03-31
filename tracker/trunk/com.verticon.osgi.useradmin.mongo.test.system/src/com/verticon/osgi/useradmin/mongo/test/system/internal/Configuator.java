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

package com.verticon.osgi.useradmin.mongo.test.system.internal;


import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;


/**
 * @author jconlon
 * 
 */
public class Configuator {//implements MongoDBCollectionProvider {
	private static final String FACTORY_PID = "com.verticon.mongo";


	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {

		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID);
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("com.verticon.osgi.useradmin.test", "testOne");
		props.put("collection", "useradmin");

		config.update(props);
	}


//	@Override
//	public DBCollection getCollection() {
//		DBCollection result = null;
//		Mongo client;
//		try {
//			client = new Mongo();
//			DB db = client.getDB("ua_repo");
//			result = db.getCollection("useradmin");
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MongoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return result;
//	}


}
