/**
 * 
 */
package org.usaha.ecvi.store.mongodb.internal.irouter;

import static org.usaha.ecvi.store.mongodb.internal.EcviMongoComponent.bundleMarker;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listens to the responseQueue and forwards its products to consumers.
 * 
 * @author jconlon
 * 
 */
public class ResponseProducer implements Producer, Callable<Void> {
	private final BlockingQueue<Envelope> responseQueue;
	private final Monitor monitor;

	private Wire[] wires = null;
	private String producerScope;

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ResponseProducer.class);

	/**
	 * 
	 */
	public ResponseProducer(BlockingQueue<Envelope> responseQueue,
			Monitor monitor) {
		this.responseQueue = responseQueue;
		this.monitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#consumersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires = wires;
		monitor.setConsumersConnected(wires != null ? wires.length : 0);
		logger.debug(bundleMarker, "{} Consumers connected",
				wires != null ? wires.length : 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#polled(org.osgi.service.wireadmin
	 * .Wire)
	 */
	@Override
	public Object polled(Wire wire) {
		return null;
	}

	@Override
	public Void call() throws Exception {
		logger.debug(bundleMarker, "Execution loop started");
		while (!Thread.currentThread().isInterrupted()) {
			Envelope envelope = responseQueue.take();
			produce(envelope);

		}
		logger.debug(bundleMarker, "Execution loop terminated");
		return null;
	}

	private void produce(Envelope envelope) {
		if (wires == null) {
			logger.error(bundleMarker, "Cant send value to topic={}, No wires",
					envelope.getIdentification());
		} else {
			for (Wire wire : wires) {
				Envelope out = new BasicEnvelope(envelope.getValue(),
						envelope.getIdentification(), producerScope);
				logger.debug(
						bundleMarker,
						"Updating consumer "
								+ wire.toString()
								+ " with envelope identification(topic)={} and scope={}, value={}",
						envelope.getIdentification(),
						Arrays.toString(wire.getScope()), envelope.getValue());
				wire.update(out);
			}
			monitor.incrementTotalProductsProduced();
		}
	}

	void activate(Map<String, Object> config) {
		this.producerScope = StatusAndConfigVariables.getProducerScope(config);
	}

	void deactivate() {
		this.producerScope = null;
	}
}
