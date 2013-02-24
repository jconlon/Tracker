package com.verticon.tracker.irouter.eventadmin.gateway.internal;


import static com.google.common.collect.Maps.newConcurrentMap;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

import com.verticon.tracker.irouter.eventadmin.gateway.StatusVar;



public class StatusMonitor implements Monitorable {

	private final AtomicInteger wiresConnected = new AtomicInteger(0);
	private final AtomicLong timeOfLastMessage = new AtomicLong(0);
	private final AtomicInteger productCount = new AtomicInteger(0);
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

		case PRODUCT_COUNT:
			sv = new StatusVariable(id, StatusVariable.CM_GAUGE,
					productCount.get());
			break;
		case WIRES_COUNT:
			sv = new StatusVariable(id,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
					);
			break;
		case LAST_PRODUCT_TIME:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
					getTimeOfLastMessage());
			break;
		case WIRING_GROUP:
			sv = new StatusVariable(id, StatusVariable.CM_SI,
 getWiringGroup());
			break;

		default:
			throw new IllegalArgumentException("Unknown id: "+id);
		}
		return sv;
		
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


	void incCount() {
		productCount.incrementAndGet();
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
	 * @param wiringGroup
	 *            the wiringGroup to set
	 */
	void setWiringGroup(String wiringGroup) {
		map.put(StatusVar.WIRING_GROUP, wiringGroup);
	}


	void deactivate() {
		wiresConnected.set(0);
		timeOfLastMessage.set(0);
		productCount.set(0);
		map.clear();
	}


	private String getWiringGroup() {
		return map.get(StatusVar.WIRING_GROUP) != null ? map
				.get(StatusVar.WIRING_GROUP) : "";
	}

	private String getTimeOfLastMessage() {
		return timeOfLastMessage.get() != 0 ? String.format("%tT",
				timeOfLastMessage.get()) : "";
	}

	private void setTimeOfLastMessage() {
		timeOfLastMessage.set(System.currentTimeMillis());
	}


}
