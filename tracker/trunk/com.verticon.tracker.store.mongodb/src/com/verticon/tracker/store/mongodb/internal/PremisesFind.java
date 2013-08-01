package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.store.mongodb.internal.Utils.ID_KEY;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongodb.internal.Utils.createResourceWithEmptyURI;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;
import com.verticon.tracker.Premises;

public class PremisesFind {

	private static final int CACHE_SIZE = 10;
	private static final int CACHE_EXPIRE_AFTER_TIME = 5;// Minutes
	private static final int NAME_CACHE_SIZE = 100;
	private static final int NAME_CACHE_EXPIRE_AFTER_TIME = 15;// Minutes
	private final AtomicBoolean inCleanUp = new AtomicBoolean();
	private final Logger logger = LoggerFactory.getLogger(PremisesFind.class);
	private final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);

	private final UpdateAndFind updateAndFind;

	private final LoadingCache<String, Optional<Premises>> cache = CacheBuilder
			.newBuilder()
			.maximumSize(CACHE_SIZE)
			.expireAfterAccess(CACHE_EXPIRE_AFTER_TIME, TimeUnit.MINUTES)
			.build(new CacheLoader<String, Optional<Premises>>() {
				@Override
				public Optional<Premises> load(String id) {
					if (inCleanUp.compareAndSet(false, true)) {
						scheduleCleanUp();
					}
					return Optional.fromNullable(findPremises(id));
				}
			});

	private final LoadingCache<String, Optional<String>> nameCache = CacheBuilder
			.newBuilder().maximumSize(NAME_CACHE_SIZE)
			.expireAfterAccess(NAME_CACHE_EXPIRE_AFTER_TIME, TimeUnit.MINUTES)
			.build(new CacheLoader<String, Optional<String>>() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * com.google.common.cache.CacheLoader#loadAll(java.lang.Iterable
				 * )
				 */
				@Override
				public Map<String, Optional<String>> loadAll(
						Iterable<? extends String> keys) throws Exception {
					if (inCleanUp.compareAndSet(false, true)) {
						scheduleCleanUp();
					}
					return getNames(keys);
				}

				@Override
				public Optional<String> load(String key) throws Exception {
					throw new UnsupportedOperationException();
				}

			});

	PremisesFind(UpdateAndFind updateAndFind) {
		this.updateAndFind = updateAndFind;
	}

	void invalidate(String id) {
		cache.invalidate(id);
	}

	Premises find(String id) {
		Premises result = null;
		try {
			Optional<Premises> optional = cache.get(id);
			if (optional.isPresent()) {
				result = EcoreUtil.copy(optional.get());

			} else {
				cache.invalidate(id);
				result = null;
			}

			// logger.debug(bundleMarker, "Found {} for {}", optionalOCD, id);
		} catch (ExecutionException e) {
			logger.error(bundleMarker, "Failed to find Premises " + id, e);
		}
		return result;
	}

	void deactivate() {
		executor.shutdownNow();
		cache.invalidateAll();
		nameCache.invalidateAll();
	}

	private void scheduleCleanUp() {
		logger.debug(bundleMarker,
				"Scheduling cleanup to execute in {} minute.",
				CACHE_EXPIRE_AFTER_TIME);
		executor.schedule(cleanUpTask, CACHE_EXPIRE_AFTER_TIME,
				TimeUnit.MINUTES);
	}

	private final Runnable cleanUpTask = new Runnable() {
		@Override
		public void run() {
			cache.cleanUp();
			nameCache.cleanUp();
			long after = cache.size();
			long nameAfter = nameCache.size();
			if (after < 1 || nameAfter < 1) {
				logger.debug(bundleMarker,
						"Entries in cache finished cleaning up: cache={}, nameCache{}",
						after, nameCache);

				inCleanUp.set(false);
			} else {
				logger.debug(
						bundleMarker,
						"Entries still in cache after cleanup, rescheduling cleanup task to execute in {} minute: cache={}, nameCache{}",
						new Object[] { CACHE_EXPIRE_AFTER_TIME, after,
								nameAfter });
				executor.schedule(this, CACHE_EXPIRE_AFTER_TIME,
						TimeUnit.MINUTES);
			}

		}
	};


	private Premises findPremises(String premisesUri) {
		DBCollection coll = updateAndFind.getCollection(PREMISES);
		DBObject dbObject = coll.findOne(new BasicDBObject(PREMISES_URI,
				premisesUri));

		if (dbObject == null) {
			return null;
		}
		Function<DBObject, EObject> builder = updateAndFind
				.getFunctionProvider().getDBObjectToEObjectFunction(coll,
						createResourceWithEmptyURI());

		return (Premises) EcoreUtil.copy(builder.apply(dbObject));
	}

	public Map<String, String> getPremisesNames(Set<String> uris) {
		Map<String, String> result = newHashMap();
		try {
			Map<String, Optional<String>> tempResult = nameCache.getAll(uris);
			for (Entry<String, Optional<String>> entry : tempResult.entrySet()) {
				if (entry.getValue().isPresent()) {
					result.put(entry.getKey(), entry.getValue().get());
				} else {
					nameCache.invalidate(entry.getKey());
				}
			}
		} catch (ExecutionException e) {
			logger.error(bundleMarker, "Failed to find premises names " + uris,
					e);
		}
		return result;
	}

	private Map<String, Optional<String>> getNames(
			Iterable<? extends String> keys) {
		Map<String, String> result = newHashMap();
		DBCollection coll = updateAndFind.getCollection(PREMISES);

		BasicDBObject q = new BasicDBObject();
		q.put(ID_KEY, new BasicDBObject(QueryOperators.IN, keys));

		DBObject f = new BasicDBObject("name", 1);

		DBCursor cursor = coll.find(q, f);
		String uri;
		String name;
		for (DBObject dbObject : cursor) {
			uri = (String) dbObject.get(ID_KEY);
			name = (String) dbObject.get("name");
			result.put(uri, name);
		}

		Map<String, Optional<String>> out = newHashMap();
		for (String key : keys) {
			String value = result.get(key);
			out.put(key, Optional.fromNullable(value));
		}

		return out;
	}

}
