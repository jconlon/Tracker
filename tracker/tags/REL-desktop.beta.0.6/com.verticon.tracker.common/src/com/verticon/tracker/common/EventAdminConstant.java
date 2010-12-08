package com.verticon.tracker.common;

/**
 * @deprecated by Ticket#634
 * 
 * @author jconlon
 *
 */
public enum EventAdminConstant {
	/**
	 * EventAdmin topic jointly used by iRouter and Tracker
	 */
	EVENT_ADMIN_TOPIC("com/verticon/tracker/event"), 
	
	/**
	 * Measurement transactions can be sent to the eventadmin as payloads
	 */
	IROUTER_PAYLOAD("com.verticon.tracker.irouter.payload");
	
	private final String propertyValue;
	
	private EventAdminConstant(String value){
		this.propertyValue=value;
	}
	
	/**
	 * 
	 * @return property propertyValue
	 */
	public String toProp() {
		return propertyValue;
	}

}