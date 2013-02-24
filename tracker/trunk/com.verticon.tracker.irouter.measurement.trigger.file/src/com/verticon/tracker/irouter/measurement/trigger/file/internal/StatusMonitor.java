package com.verticon.tracker.irouter.measurement.trigger.file.internal;


import static com.google.common.collect.Maps.newConcurrentMap;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

import com.verticon.tracker.irouter.measurement.trigger.file.StatusVar;

public class StatusMonitor implements Monitorable {

	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final AtomicLong timeOfLastMeasurement = new AtomicLong(0);
	private final AtomicLong timeOfLastFormatChange = new AtomicLong(0);
	private final AtomicInteger formatChangeCount = new AtomicInteger(0);
	private final AtomicInteger measurementCount = new AtomicInteger(0);
	private final Map<StatusVar, String> map = newConcurrentMap();

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
		case FORMAT_CHANGE_COUNT:
			sv = new StatusVariable(id, StatusVariable.CM_GAUGE,
					formatChangeCount.get());
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
		case LAST_FORMAT_CHANGE_TIME:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getTimeOfLastFormatChange());
			break;
		case WIRING_GROUP:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
 getWiringGroup());
			break;
		case MEASUREMENT_VALUE_FORMAT:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getMeasurementValueFormat());
			break;
		default:
			throw new IllegalArgumentException("Unknown id: "+id);
		}
		return sv;
		
	}



	private String getTimeOfLastFormatChange() {
		return timeOfLastFormatChange.get() != 0 ? String.format("%tT",
				timeOfLastFormatChange.get()) : "";
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


	void incMeasurementCount() {
		measurementCount.incrementAndGet();
		timeOfLastMeasurement.set(System.currentTimeMillis());
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
	 * @param lastFileName
	 *            the lastFileName to set
	 */
	void setLastFileName(String lastFileName) {
		map.put(StatusVar.LAST_FILE_NAME, lastFileName);
	}


	/**
	 * @param lastMeasurementValue
	 *            the lastMeasurementValue to set
	 */
	void setLastMeasurementValue(String lastMeasurementValue) {
		map.put(StatusVar.LAST_MEASUREMENT_VALUE, lastMeasurementValue);
	}

	/**
	 * @param wiringGroup
	 *            the wiringGroup to set
	 */
	void setWiringGroup(String wiringGroup) {
		map.put(StatusVar.WIRING_GROUP, wiringGroup);
	}

	void setMeasurementValueFormat(String value) {
		map.put(StatusVar.MEASUREMENT_VALUE_FORMAT, value);
		timeOfLastFormatChange.set(System.currentTimeMillis());
		formatChangeCount.incrementAndGet();
	}

	/**
	 * @return the formatPattern
	 */
	String getMeasurementValueFormat() {
		return map.get(StatusVar.MEASUREMENT_VALUE_FORMAT) != null ? map
				.get(StatusVar.MEASUREMENT_VALUE_FORMAT) : "";
	}

	void deactivate() {
		wiresConnected.set(0);
		timeOfLastMeasurement.set(0);
		measurementCount.set(0);
		map.clear();
	}

	/**
	 * @return the lastFileName
	 */
	private String getLastFileName() {
		return map.get(StatusVar.LAST_FILE_NAME) != null ? map
				.get(StatusVar.LAST_FILE_NAME) : "";
	}

	private String getWiringGroup() {
		return map.get(StatusVar.WIRING_GROUP) != null ? map
				.get(StatusVar.WIRING_GROUP) : "";
	}

	private String getTimeOfLastMessage() {
		return timeOfLastMeasurement.get() != 0 ? String.format("%tT",
				timeOfLastMeasurement.get()) : "";
	}



	/**
	 * @return the lastMeasurementValue
	 */
	private String getLastMeasurementValue() {
		return map.get(StatusVar.LAST_MEASUREMENT_VALUE) != null ? map
				.get(StatusVar.LAST_MEASUREMENT_VALUE) : "";
	}



}
