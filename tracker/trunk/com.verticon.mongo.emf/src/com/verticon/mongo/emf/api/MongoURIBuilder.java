package com.verticon.mongo.emf.api;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.net.URI;

import com.mongodb.MongoURI;

public class MongoURIBuilder {

	private final String MONGO_DB = "mongodb://";

	private String host = null;
	private Integer port = null;
	private String db = null;
	private String user = null;
	private String pw = null;

	public MongoURIBuilder() {

	}

	public MongoURIBuilder(String str) {
		URI uri = URI.create(str);
		host = uri.getHost();
		port = uri.getPort();
		db = uri.getPath();
		String userInfo = uri.getUserInfo();
		if (userInfo != null) {
			user = userInfo.substring(0, userInfo.indexOf(':'));
			pw = userInfo.substring(userInfo.indexOf(':') + 1,
					userInfo.length());
		}

	}


	/**
	 * @param host
	 *            the host to set
	 */
	public MongoURIBuilder host(String host) {
		this.host = host;
		return this;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public MongoURIBuilder port(Integer port) {
		this.port = port;
		return this;
	}

	public MongoURIBuilder port(String port) {
		if (isNullOrEmpty(port)) {

		} else {
			this.port = Integer.parseInt(port);
		}
		return this;
	}

	/**
	 * @param db
	 *            the db to set
	 */
	public MongoURIBuilder db(String db) {
		this.db = db;
		return this;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public MongoURIBuilder user(String user) {
		this.user = user;
		return this;
	}

	/**
	 * @param pw
	 *            the pw to set
	 */
	public MongoURIBuilder pw(String pw) {
		this.pw = pw;
		return this;
	}

	public MongoURI build() {
		return build(true);
	}

	public MongoURI buildWithoutUserInfo() {
		return build(false);
	}

	/**
	 * mongodb://jconlon:aPassword@ds045757.mongolab.com:45757
	 * 
	 * @return
	 */
	private MongoURI build(boolean includeUserInfo) {
		checkNotNull(host);
		checkNotNull(db);

		StringBuilder builder = new StringBuilder(MONGO_DB);
		if (isNullOrEmpty(user) || isNullOrEmpty(pw) || !includeUserInfo) {
			// do nothing
		} else {
			builder.append(user).append(':').append(pw).append('@');
		}
		builder.append(host);

		if (port != null) {
			builder.append(':').append(port);
		}
		builder.append('/').append(db);

		return new MongoURI(builder.toString());
	}

}
