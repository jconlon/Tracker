package com.verticon.tracker.store.mongodb.internal;

import static com.verticon.tracker.store.mongodb.internal.StatusAndConfigVariables.instance;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

import com.verticon.tracker.store.IUpdateStats;

public class Monitor implements Monitorable {

	private Map<String, Object> config;
	private MonitorListener monitorListener;
	private String status = "NOT Connected";
	private final AtomicLong lastConsumedProduct = new AtomicLong(0);
	private final AtomicLong lastProducedProduct = new AtomicLong(0);
	private final AtomicLong lastRecord = new AtomicLong(0);
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private final AtomicLong lastConnectRequest = new AtomicLong(0);
	private final AtomicInteger totalProductsConsumed = new AtomicInteger(0);
	private final AtomicInteger totalProductsProduced = new AtomicInteger(0);
	private final AtomicInteger totalAnimalsProcessed = new AtomicInteger(0);
	private final AtomicInteger totalAnimalsAdded = new AtomicInteger(0);
	private final AtomicInteger totalEventsAdded = new AtomicInteger(0);
	private final AtomicInteger totalTagsAdded = new AtomicInteger(0);
	private final AtomicInteger totalPremesisRegistered = new AtomicInteger(0);
	private final AtomicInteger totalExceptionsEncountered = new AtomicInteger(
			0);


	@Override
	public String[] getStatusVariableNames() {
		return StatusAndConfigVariables.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		StatusAndConfigVariables var = instance(id);
		switch (var) {
		case PREMISES_URI:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));

		case DEFAULT_ANIMAL:
			Integer key = com.verticon.tracker.store.TrackerStoreUtils.getConfigurationInteger(config
					.get(var.configID));
			String name = com.verticon.tracker.store.TrackerStoreUtils.getAnimalEClass(key).getName();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, name);

		case STATUS:
			return new StatusVariable(id, StatusVariable.TYPE_STRING, status);

		case LAST_CONSUMED_TIME:
			String ds = lastConsumedProduct.get() == 0 ? "None" : new Date(
					lastConsumedProduct.get()).toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case LAST_PRODUCED_TIME:
			ds = lastProducedProduct.get() == 0 ? "None" : new Date(
					lastProducedProduct.get()).toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case LAST_RECORD_TIME:
			ds = lastRecord.get() == 0 ? "None" : new Date(lastRecord.get())
					.toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case PRODUCERS_CONNECTED:
			return new StatusVariable(id, StatusVariable.CM_GAUGE,
					producersConnected.get());

		case PRODUCTS_CONSUMED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalProductsConsumed.get());

		case PRODUCTS_PRODUCED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalProductsProduced.get());
		case PREMISES_REGISTERED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalPremesisRegistered.get());

		case ANIMALS_PROCESSED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalAnimalsProcessed.get());

		case EVENTS_ADDED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalEventsAdded.get());

		case TAGS_ADDED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalTagsAdded.get());

		case ANIMALS_ADDED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalAnimalsAdded.get());
		case EXCEPTIONS:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalExceptionsEncountered.get());
		case KEY_MONGODB_SERVER:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		
		case KEY_MONGODB_DBNAME:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));

		case LAST_CONNECTION_TIME:
			ds = lastConnectRequest.get() == 0 ? "None" : new Date(
					lastConnectRequest.get()).toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case CONSUMERS_CONNECTED:
			return new StatusVariable(id, StatusVariable.CM_GAUGE,
					consumersConnected.get());

		default:
			break;
		}
		throw new IllegalArgumentException("Invalid Status Variable name "
				+ var);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return instance(id).notifiesOnChange;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		switch (instance(id)) {
		case ANIMALS_ADDED:
			totalAnimalsAdded.set(0);
			return true;
		case ANIMALS_PROCESSED:
			totalAnimalsProcessed.set(0);
			return true;
		case PRODUCTS_CONSUMED:
			totalProductsConsumed.set(0);
			return true;
		case EVENTS_ADDED:
			totalEventsAdded.set(0);
			return true;
		case PREMISES_REGISTERED:
			totalPremesisRegistered.set(0);
			return true;
		case TAGS_ADDED:
			totalTagsAdded.set(0);
			return true;
		case EXCEPTIONS:
			totalExceptionsEncountered.set(0);
			return true;
		default:
			return false;
		}

	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return instance(id).description;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	public void setMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = monitorListener;
	}

	/**
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	public void unsetMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = null;
	}

	public void activate(Map<String, Object> config) {
		this.config = config;
		setStatus("Activated " + new Date());
	}


	public void deactivate() {
		this.config = null;
		setStatus("Deactivated " + new Date());
		monitorListener = null;
	}

	// /Setables for the vars
	public void incrementTotalProductsConsumed() {
		lastConsumedProduct.set(System.currentTimeMillis());
		totalProductsConsumed.getAndIncrement();
		status="";
	}

	public void incrementTotalProductsProduced() {
		lastProducedProduct.set(System.currentTimeMillis());
		totalProductsProduced.getAndIncrement();
		status = "";
	}

	public void incrementTotalPremisesRegisted() {
		totalPremesisRegistered.getAndIncrement();
	}

	public void setProducersConnected(int count) {
		producersConnected.set(count);
	}

	public void setConsumersConnected(int count) {
		consumersConnected.set(count);
	}

	private void setStatus(String status) {
		this.status = status;
	}

	public void add(IUpdateStats stats) {
		totalAnimalsAdded.addAndGet(stats.getAnimalsAdded());
		totalAnimalsProcessed.addAndGet(stats.getAnimalsProcessed());
		totalEventsAdded.addAndGet(stats.getEventsAdded());
		totalTagsAdded.addAndGet(stats.getTagsAdded());
		totalExceptionsEncountered.addAndGet(stats.getExceptions().size());
		if (!stats.getExceptions().isEmpty()) {
			status = stats.getExceptions().toString();
		}
		lastRecord.set(System.currentTimeMillis());
	}

	public void add(String message, Exception e) {
		status = message + " " + e;
	}

	public void update(StatusVariable statusVariable) {
		if (monitorListener != null) {
			monitorListener.updated((String) config.get("service.pid"),
					statusVariable);

		}
	}

	public void setConnectRequest() {
		lastConnectRequest.set(System.currentTimeMillis());
	}
}
