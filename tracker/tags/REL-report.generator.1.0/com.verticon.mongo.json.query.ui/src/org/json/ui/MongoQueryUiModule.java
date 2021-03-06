/*
 * generated by Xtext
 */
package org.json.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.json.ui.contentassist.MongoFieldProvider;
import org.json.ui.contentassist.MongoFields;

import com.google.inject.Provider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MongoQueryUiModule extends org.json.ui.AbstractMongoQueryUiModule {
	public MongoQueryUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Provider<MongoFields> provideMongoFieldsProvider() {
		return new MongoFieldProvider();
	}
}
