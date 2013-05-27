package com.verticon.mongo;

import com.mongodb.MongoClient;

public interface IMongoClientProvider {

	/**
	 * Returns a shared MongoClient. Life cycle of this client is managed by
	 * this service. User should not close this client.
	 * 
	 * The user should not reference Mongo DB or DBCollection artifacts as this
	 * will keep connections open.
	 * 
	 * @return shared MongoClient
	 */
	MongoClient getMongoClient();

	/**
	 * 
	 * @return the databaseName
	 */
	String getDatabaseName();

	String uri();

}
