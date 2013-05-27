package com.verticon.mongo;

import static com.google.common.base.Preconditions.checkNotNull;

public class MongoClientBuilder {

	String dbName = null;
	// private String uri = null;
	String userName = null;
	String password = null;
	String serverNames = null;

	public MongoClientBuilder() {
		// TODO Auto-generated constructor stu
	}

	public MongoClientBuilder dbName(String dbName) {
		this.dbName = dbName;
		return this;
	}

	public MongoClientBuilder serverNames(String serverNames) {
		this.serverNames = serverNames;
		return this;
	}

	public MongoClientBuilder userName(String userName) {
		this.userName = userName;
		return this;
	}

	public MongoClientBuilder password(String password) {
		this.password = password;
		return this;
	}

	public MongoClientProvider build() {
		checkNotNull(dbName, "DBName can not be empty.");
		checkNotNull(serverNames, "ServerNames can not be empty.");
		return new MongoClientProvider(this);
	}
}
