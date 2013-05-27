package com.verticon.mongo;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class MongoClientProvider implements IMongoClientProvider {

	private final String dbName;
	private final String uri;
	private final MongoClient mongoClient;

	MongoClientProvider(MongoClientBuilder builder) {
		super();
		this.dbName = builder.dbName;

		List<ServerAddress> servers = Utils.parseServers(builder.serverNames);
		this.uri = builder.serverNames + '/' + dbName;
		if (servers.size() == 1) {
			mongoClient = new MongoClient(servers.get(0));
		} else {
			mongoClient = new MongoClient(servers);
		}

		if (!Utils.authenticate(builder.userName, builder.password,
				mongoClient, dbName)) {
			throw new MongoException(
					"Failed to connect to Utils! Authentication failed!");
		}
	}



	@Override
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	@Override
	public String getDatabaseName() {
		return dbName;
	}

	@Override
	public String uri() {
		return uri;
	}

	public void close() {
		if (mongoClient != null) {
			mongoClient.close();
		}
	}
}
