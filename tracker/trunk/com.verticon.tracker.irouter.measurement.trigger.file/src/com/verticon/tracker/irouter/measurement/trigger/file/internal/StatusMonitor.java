package com.verticon.tracker.irouter.measurement.trigger.file.internal;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

import com.verticon.tracker.irouter.measurement.trigger.file.StatusVar;

public class StatusMonitor implements Monitorable {

	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final AtomicLong timeOfLastMessage = new AtomicLong(0);
	private final AtomicInteger measurementCount = new AtomicInteger(0);
	private String lastFileName = "";
	private String lastMeasurementValue = "";

	
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
		switch(StatusVar.get(id)){
		case LAST_FILE_NAME:
			sv = new StatusVariable(id, StatusVariable.CM_SI, getLastFileName());
			break;
		case LAST_MEASUREMENT_VALUE:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getLastMeasurementValue());
			break;
		case MEASUREMENT_COUNT:
			sv = new StatusVariable(id, StatusVariable.CM_GAUGE,
					measurementCount.get());
			break;
		case WIRES_COUNT:
			sv = new StatusVariable(id,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
					);
			break;
		case LAST_MEASUREMENT_TIME:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getTimeOfLastMessage());
			break;
		default:
			throw new IllegalArgumentException("Unknown id: "+id);
		}
		return sv;
		
	}

	private String getTimeOfLastMessage() {
		return timeOfLastMessage.get() != 0 ? String.format("%tT",
				timeOfLastMessage.get()) : "";
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

	private void setTimeOfLastMessage() {
		timeOfLastMessage.set(System.currentTimeMillis());
	}

	void incMeasurementCount() {
		measurementCount.incrementAndGet();
		setTimeOfLastMessage();
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

	/**
	 * @return the lastFileName
	 */
	synchronized String getLastFileName() {
		return lastFileName;
	}

	/**
	 * @param lastFileName
	 *            the lastFileName to set
	 */
	synchronized void setLastFileName(String lastFileName) {
		this.lastFileName = lastFileName;
	}

	/**
	 * @return the lastMeasurementValue
	 */
	synchronized String getLastMeasurementValue() {
		return lastMeasurementValue;
	}

	/**
	 * @param lastMeasurementValue
	 *            the lastMeasurementValue to set
	 */
	synchronized void setLastMeasurementValue(String lastMeasurementValue) {
		this.lastMeasurementValue = lastMeasurementValue;
	}
}
