package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.store.mongodb.internal.Utils.ANIMAL;
import static com.verticon.tracker.store.mongodb.internal.Utils.ID_KEY;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.Utils.TAG;
import static com.verticon.tracker.store.mongodb.internal.Utils.UPDATES;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongodb.internal.Utils.createResourceWithEmptyURI;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.QueryOperators;
import com.mongodb.util.JSON;
import com.verticon.mongo.IMongoClientProvider;
import com.verticon.mongo.emf.transform.IFunctionProvider;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.IOCDFind;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerUpdate;
import com.verticon.tracker.store.IUpdateStats;

public class UpdateAndFind implements ITrackerUpdate, ITrackerFind,
 IOCDFind {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(UpdateAndFind.class);

	// DS Injected dependencies
	private IMongoClientProvider iMongoClientProvider;
	private IFunctionProvider functionProvider;

	private Function<EObject, DBObject> eToDB;
	private AnimalRecorder animalRecorder;
	private AnimalFinder animalFinder;

	private final OCDFind oCDFind = new OCDFind(this);

	private final PremisesFind premisesFind = new PremisesFind(this);
	private final MongoDBTrackerStore mongoDBTrackerStore;

	UpdateAndFind(MongoDBTrackerStore mongoDBTrackerStore) {
		super();
		this.mongoDBTrackerStore = mongoDBTrackerStore;
	}

	@Override
	public void register(Premises premises) throws IOException {
		Premises targetPremises = EcoreUtil.copy(premises);
		targetPremises.getAnimals().clear();
		targetPremises.getUnAppliedTags().clear();
		DBObject dbObject = eToDB.apply(targetPremises);
		DBCollection coll = getCollection(PREMISES);
		dbObject.put(ID_KEY, premises.getUri());
		coll.update(new BasicDBObject(PREMISES_URI, premises.getUri()),
				dbObject, true, false);
		premisesFind.invalidate(premises.getUri());

	}

	@Override
	public IUpdateStats recordAnimals(Premises premises) throws IOException {
		return animalRecorder.record(premises);
	}

	@Override
	public IUpdateStats record(String uri, List<Animal> animals)
			throws IOException {
		return animalRecorder.record(uri, animals);
	}

	@Override
	public Animal retrieveAnimal(String ain) {
		return animalFinder.retrieveAnimal(ain);
	}

	@Override
	public Premises retrievePremises(String premisesUri) throws IOException {
		return premisesFind.find(premisesUri);
	}



	@Override
	public Premises retrievePremises(String premisesUri, String fromDate,
			String toDate) throws IOException {
		Premises result = retrievePremises(premisesUri);
		if (result == null) {
			return null;
		}
		animalFinder.findAndAddAnimals(result, fromDate, toDate);

		return result;
	}

	/**
	 * 
	 * db.Premises.find( { "location.loc" : { $near :
	 * [-90.95048182270057,43.47622307339506,0 ] , $maxDistance : 1 } } )
	 * 
	 * 
	 * @param point
	 * @return Premises
	 * @throws IOException
	 */
	@Override
	public Premises retrievePremises(LongLatPoint point) throws IOException {
		Resource resource = createResourceWithEmptyURI();

		DBObject spec = new BasicDBObject("$near", point.toArray());

		DBObject query = new BasicDBObject("location.loc", spec);
		DBCollection coll = getCollection(PREMISES);
		DBCursor cursor = coll.find(query).limit(1);
		DBObject dbObject = cursor.next();
		if (dbObject == null) {
			logger.debug(bundleMarker,
					"Failed to find premises with query: {}", query);
			return null;
		}
		Function<DBObject, EObject> builder = functionProvider
				.getDBObjectToEObjectFunction(coll, resource);

		return (Premises) EcoreUtil.copy(builder.apply(dbObject));

	}

	@Override
	public Premises retrievePremises(LongLatPoint point, String fromDate,
			String toDate) throws IOException {
		Premises result = retrievePremises(point);

		animalFinder.findAndAddAnimals(result, fromDate, toDate);
		return result;
	}


	@Override
	public OCD find(String id) {
		return oCDFind.find(id);
	}

	@Override
	public String uri() {
		return iMongoClientProvider.uri();
	}

	@Override
	public Map<String, String> getPremisesNames(Set<String> uris) {
		Map<String, String> result = newHashMap();
		DBCollection coll = getCollection(PREMISES);

		BasicDBObject q = new BasicDBObject();
		q.put(ID_KEY, new BasicDBObject(QueryOperators.IN, uris));

		DBObject f = new BasicDBObject("name", 1);

		DBCursor cursor = coll.find(q, f);
		String uri;
		String name;
		for (DBObject dbObject : cursor) {
			uri = (String) dbObject.get(ID_KEY);
			name = (String) dbObject.get("name");
			result.put(uri, name);
		}

		return result;
	}

	public void checkForRegistratonMembership() {
		mongoDBTrackerStore.checkForRegistratonMembership();
	}

	void activate() {
		this.eToDB = functionProvider.getEObjectToDBObjectFunction();
		this.animalRecorder = new AnimalRecorder(this);
		this.animalFinder = new AnimalFinder(this);
		ensureIndexes();
	}


	void deactivate() {
		this.eToDB = null;
		this.animalRecorder = null;
		this.oCDFind.deactivate();
		this.premisesFind.deactivate();
	}

	// DS injectors
	void setMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		this.iMongoClientProvider = iMongoClientProvider;
	}

	void unsetMongoClientProvider(IMongoClientProvider iMongoClientProvider) {
		this.iMongoClientProvider = null;
	}

	void setFunctionProvider(IFunctionProvider functionProvider) {
		this.functionProvider = functionProvider;
	}

	void unsetFunctionProvider(IFunctionProvider functionProvider) {
		this.functionProvider = null;
	}

	DBCollection getCollection(String name) {
		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());
		return db.getCollection(name);
	}


	/**
	 * @return the functionProvider
	 */
	IFunctionProvider getFunctionProvider() {
		return functionProvider;
	}

	/**
	 * Executes a command on the database. Only aggregation commands are
	 * supported.
	 * 
	 * @TODO This needs to be constrained to meet RoleBase Access of the user.
	 * @param query
	 * @return results
	 */
	@Override
	public String query(String query) {
		DBObject cmd = (DBObject) JSON.parse(query);

		MongoClient mongoClient = iMongoClientProvider.getMongoClient();
		DB db = mongoClient.getDB(iMongoClientProvider.getDatabaseName());

		CommandResult cr = db.command(cmd);

		String result = cr.toString();
		logger.debug(bundleMarker, "Query: {}, Response: {}", cmd, result);
		return result;
	}

	/**
	 * Ensure secondary indexes Premises geo location.loc Animal tags (an array
	 * of strings pointing to the Tag primary index Tag - animal (ObjectID) and
	 * geo events.loc
	 * 
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	private void ensureIndexes() {

		// Animals index on tags
		DBCollection coll = getCollection(PREMISES);
		coll.ensureIndex(new BasicDBObject("location.loc", "2d"));

		coll = getCollection(ANIMAL);
		coll.ensureIndex(new BasicDBObject("tags", 1));

		coll = getCollection(TAG);
		coll.ensureIndex(new BasicDBObject("animal", 1));
		coll.ensureIndex(new BasicDBObject("events.pid", 1));
		coll.ensureIndex(new BasicDBObject("events.loc", "2d"));

		coll = getCollection(UPDATES);
		coll.ensureIndex(new BasicDBObject("uri", 1));

	}



}
