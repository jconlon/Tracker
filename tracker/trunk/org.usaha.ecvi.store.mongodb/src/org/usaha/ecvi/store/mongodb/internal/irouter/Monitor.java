package org.usaha.ecvi.store.mongodb.internal.irouter;

import static org.usaha.ecvi.store.mongodb.internal.irouter.StatusAndConfigVariables.instance;

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
	private final AtomicLong lastConsumedProduct = new AtomicLong(0);
	private final AtomicLong lastProducedProduct = new AtomicLong(0);
	private final AtomicLong lastRecord = new AtomicLong(0);
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger consumersConnected = new AtomicInteger(0);
	private final AtomicLong lastConnectRequest = new AtomicLong(0);
	private final AtomicInteger totalProductsConsumed = new AtomicInteger(0);
	private final AtomicInteger totalProductsProduced = new AtomicInteger(0);
	private final AtomicInteger totalEcvisRecorded = new AtomicInteger(0);
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
		case MONGO_PROVIDER_URI:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));

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
		case ECVIS_RECORDED:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalEcvisRecorded.get());

		case EXCEPTIONS:
			return new StatusVariable(id, StatusVariable.CM_CC,
					totalExceptionsEncountered.get());

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
		case PRODUCTS_CONSUMED:
			totalProductsConsumed.set(0);
			return true;
		case ECVIS_RECORDED:
			totalEcvisRecorded.set(0);
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

	void activate(Map<String, Object> config) {
		this.config = config;
		setStatus("Activated " + new Date());
	}

	void deactivate() {
		this.config = null;
		setStatus("Deactivated " + new Date());
		monitorListener = null;
	}

	void incrementTotalProductsConsumed() {
		lastConsumedProduct.set(System.currentTimeMillis());
		totalProductsConsumed.getAndIncrement();
		status = "";
	}

	void incrementTotalProductsProduced() {
		lastProducedProduct.set(System.currentTimeMillis());
		totalProductsProduced.getAndIncrement();
		status = "";
	}

	void incrementTotalEcvisRecorded() {
		lastRecord.set(System.currentTimeMillis());
		totalEcvisRecorded.getAndIncrement();
	}

	void incrementTotalExceptions() {
		totalExceptionsEncountered.getAndIncrement();
	}

	void setProducersConnected(int count) {
		producersConnected.set(count);
	}

	void setConsumersConnected(int count) {
		consumersConnected.set(count);
	}

	private void setStatus(String status) {
		this.status = status;
	}

	void add(String message, Exception e) {
		status = message + " " + e;
	}

	void update(StatusVariable statusVariable) {
		if (monitorListener != null) {
			monitorListener.updated((String) config.get("service.pid"),
					statusVariable);

		}
	}

	void setConnectRequest() {
		lastConnectRequest.set(System.currentTimeMillis());
	}
}
