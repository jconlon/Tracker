package com.verticon.tracker.store.mqtt.internal;

import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_NAMES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_DATES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE;
import static com.verticon.tracker.store.Query.RETRIEVE_PREMISES_WITH_POINT_TEMPLATE;
import static com.verticon.tracker.store.TrackerStoreUtils.jSONToMap;
import static com.verticon.tracker.store.mqtt.internal.MQTTTrackerStore.bundleMarker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.TrackerStoreUtils;

public class PremisesFind {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(PremisesFind.class);
	private static final int CACHE_SIZE = 10;
	private static final int NAME_CACHE_SIZE = 100;
	private static final int NAME_CACHE_EXPIRE_AFTER_TIME = 15;// Minutes
	private static final int CACHE_EXPIRE_AFTER_TIME = 5;// Minutes
	private final AtomicBoolean inCleanUp = new AtomicBoolean();
	private final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);
	private final Client client;
	private final BlockingQueue<MqttMessage> receiveQueue;
	private int waitSecondsForResponse;

	private final LoadingCache<String, Optional<Premises>> cache = CacheBuilder
			.newBuilder().maximumSize(CACHE_SIZE)
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

	PremisesFind(Client client, BlockingQueue<MqttMessage> receiveQueue) {
		this.client = client;
		this.receiveQueue = receiveQueue;
	}

	void activate(Map<String, Object> config) {
		waitSecondsForResponse = StatusAndConfigVariables
				.getWaitSecondsForRespsonse(config);
	}

	void deactivate() {
		executor.shutdownNow();
		cache.invalidateAll();
		nameCache.invalidateAll();
	}

	/**
	 * For invalidating cache
	 * 
	 * @param uri
	 */
	void invalidateCachedObject(String uri) {
		cache.invalidate(uri);

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

	// RETRIEVE_PREMISES_TEMPLATE
	private Premises findPremises(String premisesUri) {
		String query = RETRIEVE_PREMISES_TEMPLATE.replace(premisesUri);
		Premises premises = null;
		MqttMessage responseMessage;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);
			logger.debug(bundleMarker, "Received {} byte response.",
					responseMessage.getPayload().length);
			premises = TrackerStoreUtils.toPremises(responseMessage
					.getPayload());

		} catch (Exception e) {
			logger.error(bundleMarker, "Unable to retreive Premises "
					+ premisesUri, e);
		}

		logger.debug(bundleMarker, "Retreive premises {}", premises);
		return premises;
	}

	Premises retrievePremises(ITrackerStore.LongLatPoint point) {
		String query = RETRIEVE_PREMISES_WITH_POINT_TEMPLATE.replace(point
				.toString());
		Premises premises = null;
		MqttMessage responseMessage;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);
			if (responseMessage.getPayload().length != 0) {
				premises = TrackerStoreUtils.toPremises(responseMessage
						.getPayload());
				logger.debug(bundleMarker, "Retreived premises {}", premises);
			} else {
				logger.debug(bundleMarker, "Found no Premises at point {}",
						point);
			}
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to retreive Premises at point"
					+ point, e);
		}

		return premises;
	}

	/**
	 * 
	 */
	Premises find(String premisesUri, String fromDate, String toDate) {
		String query = RETRIEVE_PREMISES_WITH_DATES_TEMPLATE.replace(
				premisesUri, fromDate, toDate);
		Premises premises = null;
		MqttMessage responseMessage = null;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);
			logger.debug(bundleMarker, "Received {} byte response.",
					responseMessage.getPayload().length);
			premises = TrackerStoreUtils.toPremises(responseMessage
					.getPayload());

		} catch (IOException e) {
			if (responseMessage != null && responseMessage.getPayload() != null) {
				throw new IllegalStateException(new String(
						responseMessage.getPayload()));
			}
			logger.error(bundleMarker, "Unable to retreive premises "
					+ premisesUri, e);
		} catch (Exception e) {
			logger.error(bundleMarker, "Unable to retreive premises "
					+ premisesUri, e);
		}

		logger.debug(bundleMarker, "Retreive premises {}", premises);
		return premises;
	}

	Premises retrievePremises(ITrackerFind.LongLatPoint point, String fromDate,
			String toDate) {
		String query = RETRIEVE_PREMISES_WITH_POINT_AND_DATES_TEMPLATE.replace(
				point, fromDate, toDate);
		Premises premises = null;
		MqttMessage responseMessage;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);

			if (responseMessage.getPayload().length != 0) {
				premises = TrackerStoreUtils.toPremises(responseMessage
						.getPayload());
			} else {
				logger.debug(
						bundleMarker,
						"Failed to find premises at point {} with dates {} and {}",
						point, fromDate, toDate);
			}
		} catch (Exception e) {
			logger.error(bundleMarker, "Unable to retreive premises at point: "
					+ point + " for times " + fromDate + " " + toDate, e);
		}

		return premises;
	}

	Map<String, String> getPremisesNames(Set<String> uris) {
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
		String query = RETRIEVE_PREMISES_NAMES_TEMPLATE.replace(keys);
		MqttMessage responseMessage;
		String json;
		Map<String, String> result = null;
		try {
			receiveQueue.clear();
			client.publish(client.getQueryTopic(), 2, query.getBytes());
			responseMessage = receiveQueue.poll(waitSecondsForResponse,
					TimeUnit.SECONDS);

			if (responseMessage.getPayload().length != 0) {
				json = new String(responseMessage.getPayload());
				result = jSONToMap(json);
			} else {
				logger.debug(bundleMarker, "Failed to find premises names {} ",
						keys);
				result = new HashMap<String, String>();
			}

		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to find premises names " + keys,
					e);
		}
		Map<String, Optional<String>> out = newHashMap();
		for (String key : keys) {
			String value = result.get(key);
			out.put(key, Optional.fromNullable(value));
		}

		return out;
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
}
