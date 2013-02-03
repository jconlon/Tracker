package com.verticon.tracker.irouter.ohaus.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

import com.verticon.tracker.irouter.ohaus.StatusVar;

public class StatusMonitor implements Monitorable {

	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final AtomicLong timeOfLastProductCreation = new AtomicLong(0);
	private final AtomicInteger measurementCount = new AtomicInteger(0);
	private final AtomicBoolean isConnected = new AtomicBoolean();
	private String lastScaleValue = "";

	@SuppressWarnings("unused")
	private MonitorListener monitorListener;

	@Override
	public String[] getStatusVariableNames() {
		return StatusVar.identifiers;
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {

		StatusVariable sv = null;
		switch (StatusVar.get(id)) {
		case CONNECTION_STATUS:
			sv = new StatusVariable(id, StatusVariable.CM_DER, isConnected());
			break;
		case LAST_STABLE_SCALE_VALUE:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getLastStableScaleValue());
			break;
		case MEASUREMENT_COUNT:
			sv = new StatusVariable(id, StatusVariable.CM_GAUGE,
					measurementCount.get());
			break;
		case WIRES_COUNT:
			sv = new StatusVariable(id, StatusVariable.CM_GAUGE,
					wiresConnected.get());
			break;
		case LAST_MEASUREMENT_SENT_TIME:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getTimeOfLastMeasurement());
			break;
		default:
			throw new IllegalArgumentException("Unknown id: " + id);
		}
		return sv;

	}

	private String getTimeOfLastMeasurement() {
		return timeOfLastProductCreation.get() != 0 ? String.format("%tT",
				timeOfLastProductCreation.get()) : "";
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return StatusVar.get(id).description;
	}

	void setWiresConnected(int newValue) {
		wiresConnected.set(newValue);
	}

	private void setTimeOfLastMessageProduct() {
		timeOfLastProductCreation.set(System.currentTimeMillis());
	}

	void incMeasurementCount() {
		measurementCount.incrementAndGet();
		setTimeOfLastMessageProduct();
	}

	/**
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = monitorListener;
	}

	/**
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		this.monitorListener = null;
	}

	boolean isConnected() {
		return isConnected.get();
	}

	void setConnectStatus(boolean connected) {
		isConnected.set(connected);
	}

	/**
	 * @return the lastScaleValue
	 */
	synchronized String getLastStableScaleValue() {
		return lastScaleValue;
	}

	/**
	 * @param lastScaleValue
	 *            the lastScaleValue to set
	 */
	synchronized void setLastStableScaleValue(String lastScaleValue) {
		this.lastScaleValue = lastScaleValue;
	}
}
