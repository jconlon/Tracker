package com.verticon.mongo.emf.transform.test.system;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.verticon.mongo.IMongoClientProvider;

public class MongoClientProviderForTest implements IMongoClientProvider {

	private static final String DEFAULT_DBName = "tracker";
	private MongoClient mongoClient = null;

	@Override
	public MongoClient getMongoClient() {
		if (mongoClient == null) {
			try {
				mongoClient = new MongoClient();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mongoClient;
	}

	@Override
	public String getDatabaseName() {
		return DEFAULT_DBName;
	}

	@Override
	public String uri() {
		return "localhost/" + DEFAULT_DBName;
	}

}
