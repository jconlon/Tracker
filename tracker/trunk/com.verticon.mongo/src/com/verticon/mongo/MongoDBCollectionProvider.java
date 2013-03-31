package com.verticon.mongo;

import com.mongodb.DBCollection;

public interface MongoDBCollectionProvider {

	DBCollection getCollection();
}
