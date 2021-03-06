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

package com.verticon.tracker.store.location.test.system.internal;

import static com.verticon.tracker.store.mongo.test.system.Member.ONE;
import static com.verticon.tracker.store.mongo.test.system.Variables.PREMISES_URI;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.mongo.test.system.Member;
import com.verticon.tracker.store.mongo.test.system.Variables;

/**
 * @author jconlon
 * 
 */
public class Configuator {
	private static final String FACTORY_PID = "com.verticon.tracker.store.mongo";
	static final String MONGO_LOCALHOST = "mongodb://localhost";
    
	static final String ANIMAL_SCOPE = "premises.animald";
	static final String TAG_SCOPE = "premises.tag";
	static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
    static final String POSITION_SCOPE = "gps.position";
    static final String METTLER_WEIGHT_SCOPE = "mettler.weight";
    


	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {
		// Configure the first instance
		Configuration config = configAdmin.createFactoryConfiguration(FACTORY_PID);
		Dictionary<String, Object> props = configure1();
		config.update(props);
		
//		//The second
//		config = configAdmin.createFactoryConfiguration(FACTORY_PID);
//		props = configure2();
//		config.update(props);
	}

	private static Dictionary<String, Object> configure1() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		//MongoConnection related variables
		props.put(Variables.MONGO_URI.configID, MONGO_LOCALHOST);
		
		//Provided 
		props.put("com.verticon.tracker.mongo.test","testOne");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.BOVINE_BISON);
		props.put("tracker.wiring.group.name", "test");
		props.put(PREMISES_URI.configID, ONE.uri);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[]{
				TAG_SCOPE,//Tags ->Tags
				ANIMAL_WEIGHT_SCOPE, //Measurements ->WeighIn
				POSITION_SCOPE,//Positions -> Positions
				METTLER_WEIGHT_SCOPE,//Measurement -> GenericEvents
				ANIMAL_SCOPE//Animals -> Animals
				});
		return props;
	}
	
	@SuppressWarnings("unused")
	private static Dictionary<Object, Object> configure2() {
		Dictionary<Object, Object> props = new Properties();
		props.put(Variables.MONGO_URI.configID, MONGO_LOCALHOST);
		props.put("com.verticon.tracker.mongo.test","testTwo");
		props.put(Variables.DEFAULT_ANIMAL.configID, TrackerPackage.SWINE);
		props.put("tracker.wiring.group.name", "test2");
		props.put(Variables.PREMISES_URI.configID, Member.THREE.uri);
		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[]{TAG_SCOPE});
		return props;
	}


}
