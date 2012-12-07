/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.irouter.premises.event.test.system.internal;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.wireadmin.WireConstants;

/**
 * @author jconlon
 * 
 */
public class Configuator {
	private static final String FACTORY_PID = "com.verticon.tracker.irouter.premises.event";

	// Consumer
	private static final String TRIGGER_ON_ID_NAME = "triggeron.eid";
	private static final String PROP_TRANSACTION_STATE_NAME = "consumer.transaction.state";
	private static final String TRANSACTION_STATE_VALUE = "transaction.state.name";
	private static final String PROP_TRANSACTION_STATE_VALUE = "consumer.transaction.state.value";
	static final String ANIMAL_SCOPE = "premises.animald";
	static final String RAW_ANIMAL_WEIGHT_SCOPE = "raw.animal.weight";
	static final String RAW_POSITION_SCOPE = "raw.gps.position";
	static final String RAW_METTLER_WEIGHT_SCOPE = "raw.mettler.weight";

	// Producer
	static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
	static final String POSITION_SCOPE = "gps.position";
	static final String METTLER_WEIGHT_SCOPE = "mettler.weight";

	public void setConfigurationAdmin(ConfigurationAdmin configAdmin)
			throws IOException {

		// Configure the first instance
		Configuration config = configAdmin
				.createFactoryConfiguration(FACTORY_PID);
		Dictionary<String, Object> props = configure1();
		config.update(props);
	}

	/**
	 * Configuration of the Component under test.
	 * 
	 * @return
	 */
	private static Dictionary<String, Object> configure1() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put("com.verticon.tracker.irouter.premises.event.test", "testOne");
		props.put("tracker.wiring.group.name", "test");

		// Name of the Control State"
		props.put(PROP_TRANSACTION_STATE_NAME, TRANSACTION_STATE_VALUE);

		// Trigger on EID
		props.put(TRIGGER_ON_ID_NAME, Boolean.TRUE);

		// Value of the Control State"
		props.put(PROP_TRANSACTION_STATE_VALUE, 1);

		props.put(WireConstants.WIREADMIN_CONSUMER_SCOPE, new String[] {
				RAW_ANIMAL_WEIGHT_SCOPE, // Measurements ->WeighIn
				RAW_POSITION_SCOPE,// Positions -> Positions
				RAW_METTLER_WEIGHT_SCOPE,// Measurement -> GenericEvents
				ANIMAL_SCOPE // Animals -> Animals
				});
		// Monitor node
		props.put("tracker.monitor.label", "myName");

		props.put(WireConstants.WIREADMIN_PRODUCER_SCOPE, new String[] {
				ANIMAL_WEIGHT_SCOPE, // Measurements ->WeighIn
				POSITION_SCOPE,// Positions -> Positions
				METTLER_WEIGHT_SCOPE // Measurement -> GenericEvents
				});
		return props;
	}

}
