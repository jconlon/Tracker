package com.verticon.tracker.irouter.mqtt.internal;


import static com.verticon.tracker.irouter.mqtt.internal.StatusAndConfigVariables.instance;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;


public class Monitor implements Monitorable {

	private Map<String, Object> config;
	private MonitorListener monitorListener;
	private String status = "NOT Connected";
	private final AtomicLong lastConsumedTime = new AtomicLong(0);
	private final AtomicLong lastProducedTime = new AtomicLong(0);
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private final AtomicInteger totalProductsConsumed = new AtomicInteger(0);
	private final AtomicInteger totalProductsProduced = new AtomicInteger(0);
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


		case STATUS:
			return new StatusVariable(id, StatusVariable.TYPE_STRING, status);

		case LAST_CONSUMED_TIME:
			String ds = lastConsumedTime.get() == 0 ? "None" : new Date(
					lastConsumedTime.get()).toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case LAST_PRODUCED_TIME:
			ds = lastProducedTime.get() == 0 ? "None" : new Date(
					lastProducedTime.get())
					.toString();
			return new StatusVariable(id, StatusVariable.TYPE_STRING, ds);

		case CONSUMERS_CONNECTED:
			return new StatusVariable(id, StatusVariable.CM_GAUGE,
					consumersConnected.get());

		case PRODUCERS_CONNECTED:
			return new StatusVariable(id, StatusVariable.CM_GAUGE,
					producersConnected.get());

		case PRODUCTS_CONSUMED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalProductsConsumed.get());

		case EXCEPTIONS:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalExceptionsEncountered.get());
		case KEY_SERVER:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));

		case MQTT_SUBSCRIBER_TOPICS:
			String[] topics = (String[]) config.get(var.configID);
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					topics != null ? Arrays.toString(topics) : "");
		case CLIENT_ID:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		case PRODUCTS_PRODUCED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalProductsProduced.get());

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
		case LAST_CONSUMED_TIME:
			lastConsumedTime.set(0);
			return true;
		case LAST_PRODUCED_TIME:
			lastProducedTime.set(0);
			return true;
		case PRODUCTS_CONSUMED:
			totalProductsConsumed.set(0);
			return true;
		case PRODUCTS_PRODUCED:
			totalProductsProduced.set(0);
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
		lastConsumedTime.set(System.currentTimeMillis());
		totalProductsConsumed.getAndIncrement();
		status="";
	}

	public void incrementTotalProductsProduced() {
		lastProducedTime.set(System.currentTimeMillis());
		totalProductsProduced.getAndIncrement();
	}

	public void setProducersConnected(int count) {
		producersConnected.set(count);
	}

	private void setStatus(String status) {
		this.status = status;
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


	public void setConsumersConnected(int i) {
		consumersConnected.set(i);

	}
}
