package com.verticon.tracker.irouter.wireadmin.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Parameter object
 * @author jconlon
 *
 */
public class WireParameters {
	private final String producerPid;
	private final String consumerPid;
	private final String group;
	private boolean delete;
	
	
	public WireParameters(String producerPid, String consumerPid,
			String group) {
		super();
		this.producerPid = producerPid;
		this.consumerPid = consumerPid;
		this.group = group;
	}
	
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WireParameters [producerPid=" + producerPid + ", consumerPid="
				+ consumerPid + ", group=" + group + "]";
	}


	public String getProducerPid() {
		return producerPid;
	}


	public String getConsumerPid() {
		return consumerPid;
	}


	public Dictionary<String, String> getProperties() {
		Dictionary<String, String> result = new Hashtable<String, String>();
		result.put(TRACKER_WIRE_GROUP_NAME,group);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((consumerPid == null) ? 0 : consumerPid.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result
				+ ((producerPid == null) ? 0 : producerPid.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WireParameters other = (WireParameters) obj;
		if (consumerPid == null) {
			if (other.consumerPid != null)
				return false;
		} else if (!consumerPid.equals(other.consumerPid))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (producerPid == null) {
			if (other.producerPid != null)
				return false;
		} else if (!producerPid.equals(other.producerPid))
			return false;
		return true;
	}




	public void setDelete(boolean delete) {
		this.delete = delete;
	}




	public boolean isDelete() {
		return delete;
	}

	
}
