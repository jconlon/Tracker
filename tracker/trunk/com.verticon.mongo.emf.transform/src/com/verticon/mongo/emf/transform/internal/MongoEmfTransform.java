package com.verticon.mongo.emf.transform.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.verticon.mongo.emf.transform.IFunctionProvider;

public class MongoEmfTransform implements IFunctionProvider {

	private static final int CACHE_SIZE = 30;
	private static final int CACHE_EXPIRE_AFTER_TIME = 5;// 5;// Minutes
	private final AtomicBoolean inCleanUp = new AtomicBoolean();
	private final static String PLUGIN_ID = "com.verticon.mongo.emf.transform";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);

	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(MongoEmfTransform.class);

	private final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);;



	private final IFunctionProvider delegate;
	private final org.eclipse.emf.ecore.xmi.XMLResource.URIHandler uriHandler = new URIHandlerImpl();

	private final ResourceSet resourceSet = new ResourceSetImpl();



	private final LoadingCache<String, EClass> cache = CacheBuilder
			.newBuilder().maximumSize(CACHE_SIZE)
			.expireAfterWrite(CACHE_EXPIRE_AFTER_TIME, TimeUnit.MINUTES)
			.build(new CacheLoader<String, EClass>() {
				@Override
				public EClass load(String eClassURI) {
					if (inCleanUp.compareAndSet(false, true)) {
						scheduleCleanUp();
					}
					return (EClass) resourceSet.getEObject(
							URI.createURI(eClassURI), true);
				}
			});


	public MongoEmfTransform() {
		IConverterService converterService = new ConverterService();

		TrackerDBObjectBuilder trackerDBObjectBuilder = new TrackerDBObjectBuilder(
				converterService, uriHandler, false);// serializeDefaultAttributeValues

		TrackerEObjectBuilder trackerEObjectBuilder = new TrackerEObjectBuilder(
				converterService, uriHandler, true, cache);

		delegate = new FunctionProviderImpl(trackerDBObjectBuilder,
				trackerEObjectBuilder);

	}

	@Override
	public Function<EObject, DBObject> getEObjectToDBObjectFunction() {
		return delegate.getEObjectToDBObjectFunction();
	}

	@Override
	public Function<DBObject, EObject> getDBObjectToEObjectFunction(
			DBCollection collection, Resource resource) {
		return delegate.getDBObjectToEObjectFunction(collection, resource);
	}

	void deactivate() {
		cache.invalidateAll();
		executor.shutdownNow();
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
				logger.debug(
						bundleMarker,
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

}
