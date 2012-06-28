package org.json.ui.contentassist;

import com.google.inject.Provider;

public class MongoFieldProvider implements Provider<MongoFields>{

	private MongoFields set = new MongoFields();
	
	@Override
	public MongoFields get() {
		// TODO Auto-generated method stub
		return set;
	}

	
}
