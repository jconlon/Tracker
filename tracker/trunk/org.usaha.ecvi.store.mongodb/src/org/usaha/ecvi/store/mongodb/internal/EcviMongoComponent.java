package org.usaha.ecvi.store.mongodb.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.store.IEcviStore;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.mongo.emf.transform.IFunctionProvider;

/**
 * 
 * Provides a way to store eCVIs to all IMongoClientProvider services
 * 
 * @author jconlon
 * 
 */
public class EcviMongoComponent implements IEcviStore {

	private static final String ECVI_COLLECTION_NAME = "Ecvi";
	private static final String PLUGIN_ID = "org.usaha.ecvi.store.mongodb.internal";
	// private Authenticator authenticator;

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		EcviMongoComponent.bundleMarker
				.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EcviMongoComponent.class);

	// DS Injected dependencies
	private final List<IMongoClientProvider> mongoProviders = new CopyOnWriteArrayList<IMongoClientProvider>();

	private IFunctionProvider functionProvider;

	// Created at activation
	private Function<EObject, DBObject> eToDB;
	
	void activate() {
		this.eToDB = functionProvider.getEObjectToDBObjectFunction();
	}

	void deactivate() {
		this.eToDB = null;
	}

	// DS injectors
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		// For every MongoClientProvider ensure there is an index for the
		// Collection
		ensureIndexes(iMongoClientProvider);
		mongoProviders.add(iMongoClientProvider);
	}

	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		mongoProviders.remove(iMongoClientProvider);
	}

	void setFunctionProvider(IFunctionProvider functionProvider) {
		this.functionProvider = functionProvider;
	}

	void unsetFunctionProvider(IFunctionProvider functionProvider) {
		this.functionProvider = null;
	}




	@Override
	public void record(Ecvi ecvi, String uri) throws IOException {
		checkNotNull(ecvi, "argument ecvi cannot be null");
		checkArgument(!isNullOrEmpty(uri),
				"argument uri cannot be null or empty");
		DBCollection coll = getCollection(uri);
		Ecvi targetPremises = EcoreUtil.copy(ecvi);
		DBObject dbObject = eToDB.apply(targetPremises);
		coll.insert(dbObject);
		logger.debug(bundleMarker, "Inserted ecvi with cviNumber= {}",
				ecvi.getCviNumber());
	}

	@Override
	public Iterable<String> getURIs() {
		return Iterables.transform(mongoProviders, uriFunction);
	}


	/**
	 * 
	 * @param uri
	 * @return the DBCollection associated with the uri or null if the uri is
	 *         not a provider
	 * @throws IOException
	 */
	private DBCollection getCollection(String uri) throws IOException {
		IMongoClientProvider iMongoClientProvider = getMongoClientProvider(uri);
		if (iMongoClientProvider == null) {

			logger.error(bundleMarker, "Unknown uri {}, try one of these {}",
					uri, this.getURIs());
			throw new IOException("Unknown uri: " + uri);
		}

		return getCollection(iMongoClientProvider);
	}

	private DBCollection getCollection(IMongoClientProvider iMongoClientProvider) {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());
		return db.getCollection(ECVI_COLLECTION_NAME);
	}

	/**
	 * 
	 * @param uri
	 * @return the provider associated with the uri or a null if it does not
	 *         exist
	 */
	private IMongoClientProvider getMongoClientProvider(String uri) {
		IMongoClientProvider mongoClientProvider = null;
		for (IMongoClientProvider mongoProvider : mongoProviders) {
			if (uri.equals(mongoProvider.uri())) {
				mongoClientProvider = mongoProvider;
				break;
			}
		}
		return mongoClientProvider;
	}

	/**
	 * Ensure secondary indexes on Ecvi Collection for: TODO determine secondary
	 * indexes
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	@SuppressWarnings("unused")
	private void ensureIndexes(IMongoClientProvider mongoClientProvider) {

		// Ecvi index on ?
		DBCollection coll = getCollection(mongoClientProvider);
		// coll.ensureIndex(new BasicDBObject("location.loc", "2d"));

		// coll = getCollection(ANIMAL);
		// coll.ensureIndex(new BasicDBObject("tags", 1));
		//
		// coll = getCollection(TAG);
		// coll.ensureIndex(new BasicDBObject("animal", 1));
		// coll.ensureIndex(new BasicDBObject("events.pid", 1));
		// coll.ensureIndex(new BasicDBObject("events.loc", "2d"));
		//
		// coll = getCollection(UPDATES);
		// coll.ensureIndex(new BasicDBObject("uri", 1));

	}



	private static final Function<IMongoClientProvider, String> uriFunction = new Function<IMongoClientProvider, String>() {
		@Override
		public String apply(IMongoClientProvider provider) {
			return provider.uri();
		}
	};

}
