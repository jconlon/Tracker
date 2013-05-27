package com.verticon.tracker.store.mongodb.internal;

import static com.verticon.tracker.store.mongodb.internal.Utils.OCD;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;
import static com.verticon.tracker.store.mongodb.internal.Utils.createResourceWithEmptyURI;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
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
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.store.IOCDFind;

public class OCDFind implements IOCDFind {

	private static final int CACHE_SIZE = 10;
	private static final int CACHE_EXPIRE_AFTER_TIME = 5;// Minutes
	private final AtomicBoolean inCleanUp = new AtomicBoolean();
	private final Logger logger = LoggerFactory.getLogger(OCDFind.class);
	private final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);;

	private final UpdateAndFind updateAndFind;

	private final LoadingCache<String, Optional<OCD>> cache = CacheBuilder
			.newBuilder()
			.maximumSize(CACHE_SIZE)
			.expireAfterAccess(CACHE_EXPIRE_AFTER_TIME, TimeUnit.MINUTES)
			.build(new CacheLoader<String, Optional<OCD>>() {
				@Override
				public Optional<OCD> load(String id) {
					if (inCleanUp.compareAndSet(false, true)) {
						scheduleCleanUp();
					}
					OCD result = null;
					DBCollection coll = updateAndFind.getCollection(OCD);
					DBObject q = new BasicDBObject("_id", id);
					DBObject dbObject = coll.findOne(q);
					if (dbObject != null) {
						Function<DBObject, EObject> builder = updateAndFind
								.getFunctionProvider()
								.getDBObjectToEObjectFunction(coll,
										createResourceWithEmptyURI());

						result = (OCD) builder.apply(dbObject);
					}

					return Optional.fromNullable(result);
				}
			});


	OCDFind(UpdateAndFind updateAndFind) {
		this.updateAndFind = updateAndFind;
	}

	@Override
	public OCD find(String id) {
		OCD result = null;
		try {
			Optional<OCD> optionalOCD = cache.get(id);
			if (!optionalOCD.isPresent()) {
				cache.invalidate(id);
			}
			result = optionalOCD.orNull();
			// logger.debug(bundleMarker, "Found {} for {}", optionalOCD, id);
		} catch (ExecutionException e) {
			logger.error(bundleMarker, "Failed to find OCD " + id, e);
		}
		return result;
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

	void deactivate() {
		executor.shutdownNow();
		cache.invalidateAll();
	}
}
