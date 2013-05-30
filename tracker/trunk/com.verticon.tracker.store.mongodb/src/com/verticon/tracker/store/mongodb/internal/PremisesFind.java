package com.verticon.tracker.store.mongodb.internal;

import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES;
import static com.verticon.tracker.store.mongodb.internal.Utils.PREMISES_URI;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongodb.internal.Utils.createResourceWithEmptyURI;

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
import com.mongodb.DBObject;
import com.verticon.tracker.Premises;

public class PremisesFind {

	private static final int CACHE_SIZE = 10;
	private static final int CACHE_EXPIRE_AFTER_TIME = 5;// Minutes
	private final AtomicBoolean inCleanUp = new AtomicBoolean();
	private final Logger logger = LoggerFactory.getLogger(PremisesFind.class);
	private final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);;

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
			long after = cache.size();
			if (after < 1) {
				logger.debug(bundleMarker,
						"{} entries in cache finished cleaning up.", after);
				inCleanUp.set(false);
			} else {
				logger.debug(
						bundleMarker,
						"{} entries still in cache after cleanup, rescheduling cleanup task to execute in {} minute.",
						after, CACHE_EXPIRE_AFTER_TIME);
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
}
