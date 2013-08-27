package com.verticon.tracker.store.mongodb.internal.irouter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.Query;
import com.verticon.tracker.store.mongodb.internal.Monitor;

public class MongoDBProducer implements Producer, Callable<Void> {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MongoDBProducer.class);

	private Wire[] wires = null;

	private final BlockingQueue<Envelope> queryQueue;
	private final ITrackerFind trackerFind;
	private final Monitor monitor;

	private String scope;

	private Authenticator authenticator;

	public MongoDBProducer(LinkedBlockingQueue<Envelope> queryQueue,
			ITrackerFind trackerFind, Monitor monitor) {
		super();
		this.queryQueue = queryQueue;
		this.trackerFind = trackerFind;
		this.monitor = monitor;
	}

	/**
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		monitor.setConsumersConnected(wires != null ? wires.length : 0);
		logger.debug(bundleMarker, "{} Consumers connected",
				wires != null ? wires.length : 0);

	}

	@Override
	public Void call() throws Exception {
		logger.debug(bundleMarker, "Execution loop started");
		while (!Thread.currentThread().isInterrupted()) {
			Envelope envelope = queryQueue.take();
			if ((envelope.getIdentification() instanceof String)
					&& ((String) envelope.getIdentification())
							.endsWith("Response")) {
				// Forward response from animal event recording
				produce((String) envelope.getIdentification(),
						(byte[]) envelope.getValue());
			} else {
				try {
					handleQuery(envelope.getIdentification(),
							envelope.getValue());
				} catch (Exception e) {
					logger.error(bundleMarker, "Failed to handle query", e);
				}
			}

		}
		logger.debug(bundleMarker, "Execution loop terminated");
		return null;
	}


	/**
	 * Queries may produce envelope products with a payload, a null payload if
	 * the query fails to return a value an error String.
	 * 
	 * @param topic
	 * @param value a String or a byte[] carrying a string
	 */
	private void handleQuery(Object id, Object value) {
		checkArgument(id instanceof String, "Envelope id is not a String");
		String query;
		if (value instanceof String) {
			query = (String) value;
		} else if (value instanceof byte[]) {
			query = new String((byte[]) value);
		} else {
			throw new IllegalArgumentException(
					"Value is not a String or a String as a byte[]");
		}

		// checkArgument(value instanceof byte[],
		// "Envelope value is not a byte array");

		String topic = (String) id;
		String outboundTopic = topic.replace("Query", "Response");
		String accessProblem = checkAccess();
		if (accessProblem != null) {
			produce(outboundTopic, accessProblem.getBytes());
			return;
		}
		logger.debug(bundleMarker, "Handling query={} from topic={}, ", query,
				topic);
		try {
			Query queryTemplate = Query.instance(query);
			Optional<byte[]> payload = queryTemplate.find(trackerFind, query);
			if (payload.isPresent()) {
				logger.debug(bundleMarker,
						"Responding with value to query={} on topic={}, ",
						query, outboundTopic);
				produce(outboundTopic, payload.get());
			} else {
				logger.debug(bundleMarker,
						"Responding with null to query={} on topic={}, ",
						query, outboundTopic);
				produce(outboundTopic, "".getBytes());
			}
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to handle query.", e);
			String out = "Failed to handle query because: "
					+ e.getLocalizedMessage();
			produce(outboundTopic, out.getBytes());
		}
	}

	private String checkAccess() {
		boolean allowed = authenticator != null
				&& authenticator.isAuthenticatedUser();
		if (!allowed) {
			return "User is not authenticated.";
		}

		return null;
	}

	private void produce(String topic, byte[] payload) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value to topic={}, No wires",
					topic);
		} else {
			for (Wire wire : wires) {
				Envelope envelope = new BasicEnvelope(payload, topic, scope);
				logger.debug(
						bundleMarker,
						"Updating wire with envelope identification(topic)={} and scope={}",
						topic, Arrays.toString(wire.getScope()));
				wire.update(envelope);
			}
			monitor.incrementTotalProductsProduced();
		}
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

}
