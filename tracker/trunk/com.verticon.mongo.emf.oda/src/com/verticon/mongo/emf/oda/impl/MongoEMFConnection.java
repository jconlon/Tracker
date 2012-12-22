package com.verticon.mongo.emf.oda.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Properties;

import org.eclipse.datatools.connectivity.oda.IConnection;
import org.eclipse.datatools.connectivity.oda.IQuery;
import org.eclipse.datatools.connectivity.oda.OdaException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.oda.ecore.impl.Connection;

import com.mongodb.DB;
import com.mongodb.MongoURI;
import com.verticon.mongo.emf.api.MongoURIBuilder;
import com.verticon.mongo.emf.api.MongoUtils;
import com.verticon.mongo.emf.api.SingleMongoLocator;

/**
 * Implementation class of IConnection for an ODA runtime driver.
 * 
 * @author jconlon
 * 
 */
public class MongoEMFConnection extends Connection implements IConnection {
	private DB db = null;
	private URI baseURI = null;
	public static final String HOST_PROPERTY_NAME = "host"; //$NON-NLS-1$
	public static final String PORT_PROPERTY_NAME = "port"; //$NON-NLS-1$
	public static final String DB_PROPERTY_NAME = "database"; //$NON-NLS-1$
	public static final String DB_PASSWORD_NAME = "password"; //$NON-NLS-1$
	public static final String DB_USER_NAME = "username"; //$NON-NLS-1$
	private SingleMongoLocator mongoLocator;

	/**
	 * Connect to a MongoDB.
	 * 
	 * The properties contain a hostName, port, and a database.
	 * 
	 * @param connProperties
	 */
	@Override
	public void open(Properties connProperties) throws OdaException {
		db = connectToMongoDB(connProperties);
		baseURI = getBaseURI(connProperties);
		if (MongoEMFComponent.getResourceSetFactory() == null) {
			throw new OdaException(
					"ResourceSetFactory service is not available");
		}

		try {
			this.mongoLocator = new SingleMongoLocator(baseURI.toString(),
					connProperties.getProperty("username"),
					connProperties.getProperty("password"));

		} catch (Exception e) {
			throw new OdaException(e);
		}

		this.resourceSet = getResourceSet();

	}

	/*
	 * @see org.eclipse.datatools.connectivity.oda.IConnection#close()
	 */
	@Override
	public void close() throws OdaException {
		super.close();
		db = null;
		baseURI = null;
	}

	/**
	 * @return the resourceSet
	 */
	@Override
	public ResourceSet getResourceSet() {
		if (mongoLocator != null) {
			return MongoEMFComponent.getResourceSetFactory().createResourceSet(
					mongoLocator);
		}

		throw new IllegalStateException("mongoLocator is blank");
	}

	@Override
	public IQuery newQuery(String dataSetType) throws OdaException {
		if (!isOpen()) {
			throw new OdaException(new IllegalStateException());
		}

		// only one type of data set supported
		return new MongoEMFQuery(this);
	}

	/**
	 * @return the db
	 */
	DB getDb() {
		return db;
	}

	/**
	 * @return the baseURI
	 */
	URI getBaseURI() {
		return baseURI;
	}

	private DB connectToMongoDB(Properties connProperties) throws OdaException {
		String hostname = connProperties.getProperty(HOST_PROPERTY_NAME);
		checkNotNull(hostname);
		String port = connProperties.getProperty(PORT_PROPERTY_NAME);
		String db = connProperties.getProperty(DB_PROPERTY_NAME);
		checkNotNull(db);
		String user = connProperties.getProperty(DB_USER_NAME);
		String password = connProperties.getProperty(DB_PASSWORD_NAME);
		DB mongo;
		try {
			mongo = MongoUtils.getMongoDB(hostname, port, db, user, password);

		} catch (Exception e) {
			throw new OdaException(e);
		}
		return mongo;

	}

	private URI getBaseURI(Properties connProperties) throws OdaException {
		String hostname = connProperties.getProperty(HOST_PROPERTY_NAME);
		checkNotNull(hostname);
		String port = connProperties.getProperty(PORT_PROPERTY_NAME);
		String database = connProperties.getProperty(DB_PROPERTY_NAME);
		checkNotNull(database);
		String username = connProperties.getProperty(DB_USER_NAME);
		String password = connProperties.getProperty(DB_PASSWORD_NAME);
		MongoURI mongoURI = new MongoURIBuilder().host(hostname).port(port)
				.db(database).user(username).pw(password).build();
		return MongoUtils.getEMFBaseURI(mongoURI);
	}

}
