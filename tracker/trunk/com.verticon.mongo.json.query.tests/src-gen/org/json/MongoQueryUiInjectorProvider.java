/*
* generated by Xtext
*/
package org.json;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class MongoQueryUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return org.json.ui.internal.MongoQueryActivator.getInstance().getInjector("org.json.MongoQuery");
	}
	
}