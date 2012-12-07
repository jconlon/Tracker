
package org.json;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MongoQueryStandaloneSetup extends MongoQueryStandaloneSetupGenerated{

	public static void doSetup() {
		new MongoQueryStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

