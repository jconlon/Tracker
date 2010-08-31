package com.verticon.tracker.irouter.wireadmin.internal;

import java.util.Dictionary;

/**
 * Parameter object
 * @author jconlon
 *
 */
public class WireParameters {
	private final String producerPid;
	private final String consumerPid;
	private final Dictionary<String, ?> properties;
	
	
	public WireParameters(String producerPid, String consumerPid,
			Dictionary<String, ?> properties) {
		super();
		this.producerPid = producerPid;
		this.consumerPid = consumerPid;
		this.properties = properties;
	}
	
	
	@Override
	public String toString() {
		return "WireParameters [consumerPid=" + consumerPid + ", producerPid="
				+ producerPid + "]";
	}


	public String getProducerPid() {
		return producerPid;
	}


	public String getConsumerPid() {
		return consumerPid;
	}


	public Dictionary<String, ?> getProperties() {
		return properties;
	}


}
