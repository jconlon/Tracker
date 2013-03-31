package com.verticon.osgi.useradmin.mongo.internal;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class MongoUtils {

	private static final String REQUIRED_MEMBERS = "requiredMembers";
	private static final String MEMBERS = "members";

	private MongoUtils() {
		super();
	}

	/**
	 * {$or:[{members:'jcondor'},{requiredMembers:'jcondor'}]}
	 * 
	 * @param name
	 * @return
	 */
	static DBObject getGroupsQuery(String name) {
		DBObject q1 = new BasicDBObject(MEMBERS, name);
		DBObject q2 = new BasicDBObject(REQUIRED_MEMBERS, name);
		DBObject q = QueryBuilder.start().or(q1, q2).get();
		return q;
	}

	/**
	 * TODO Create a Mongo Query from an LDAP filter
	 * 
	 * @param ldapFilterValue
	 * @return optimized query
	 */
	static DBObject createQueryFromFilter(String ldapFilterValue) {
		return new BasicDBObject();
	}

	/**
	 * TODO Ensure indexes on the collections
	 * 
	 * @param collection
	 * @throws UnknownHostException
	 */
	static void ensureIndexes(DBCollection collection) {
		collection.ensureIndex(new BasicDBObject("requiredMembers", 1));
		collection.ensureIndex(new BasicDBObject("members", 1));
	}

}
