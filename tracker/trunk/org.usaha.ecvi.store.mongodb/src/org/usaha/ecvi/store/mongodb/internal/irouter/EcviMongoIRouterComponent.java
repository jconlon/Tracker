package org.usaha.ecvi.store.mongodb.internal.irouter;

import static org.usaha.ecvi.store.mongodb.internal.EcviMongoComponent.bundleMarker;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usaha.ecvi.store.IEcviStore;

/**
 * An iRouter Consumer/Producer Component that consumes Envelopes containing
 * Ecvi EMF objects and stores them to a MongoDB. It then produces responses
 * products to inform the frontend client as to the disposition of the Ecvi
 * storage operation.
 * 
 * This component is typically used in the backend for consuming Ecvi objects as
 * bytes from a MQTT producer.
 * 
 * Depends on one or more IEcviStore services.
 * 
 * Delegates all functionality to other classes.
 * 
 * 
 * @author jconlon
 * 
 */
public class EcviMongoIRouterComponent implements Consumer, Monitorable,
		Producer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EcviMongoIRouterComponent.class);
	private final Monitor monitor = new Monitor();
	private final LinkedBlockingQueue<Envelope> responseQueue = new LinkedBlockingQueue<Envelope>();
	private final ProductHandler productHandler = new ProductHandler(monitor,
			responseQueue);
	private final EcviConsumer ecviConsumer = new EcviConsumer(monitor,
			productHandler);
	private final ResponseProducer responseProducer = new ResponseProducer(
			responseQueue, monitor);
	private ExecutorService exec = null;

	/**
	 * @param ecviStore
	 *            the ecviStore to set
	 */
	void unsetEcviStore(IEcviStore ecviStore) {
		productHandler.unsetEcviStore(ecviStore);
	}

	/**
	 * @param ecviStore
	 *            the ecviStore to set
	 */
	void setEcviStore(IEcviStore ecviStore) {
		productHandler.setEcviStore(ecviStore);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		monitor.setMonitorListener(monitorListener);
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		monitor.unsetMonitorListener(monitorListener);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 */
	public void activate(Map<String, Object> config) throws IOException {
		responseProducer.activate(config);
		monitor.activate(config);
		productHandler.activate(config);
		exec = Executors.newSingleThreadExecutor();
		exec.submit(responseProducer);
		logger.debug(bundleMarker, "Activated with config={}", config);
	}

	public void deactivate() {
		productHandler.deactivate();
		exec.shutdownNow();
		exec = null;
		monitor.deactivate();
		responseProducer.deactivate();
		logger.debug(bundleMarker, "Deactivated");
	}

	@Override
	public String[] getStatusVariableNames() {
		return monitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return monitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return monitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return monitor.getDescription(id);
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		responseProducer.consumersConnected(wires);

	}

	@Override
	public Object polled(Wire wire) {
		return responseProducer.polled(wire);
	}

	@Override
	public void producersConnected(Wire[] wires) {
		ecviConsumer.producersConnected(wires);

	}

	@Override
	public void updated(Wire wire, Object in) {
		ecviConsumer.updated(wire, in);
	}

}
