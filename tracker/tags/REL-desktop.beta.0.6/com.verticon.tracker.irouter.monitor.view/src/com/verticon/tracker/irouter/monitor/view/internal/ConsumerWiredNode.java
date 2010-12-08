package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Arrays;
import java.util.Map;


public class ConsumerWiredNode extends WiredNode {

    ConsumerWiredNode(Map<String, Object> sr) {
		super(
				false,
				(String) sr.get("tracker.wiring.group.name"), 
				(String) sr.get("service.pid"), 
				Arrays.toString((Object[])sr.get("wireadmin.consumer.scope")), 
				(Long) sr.get("service.id"),
				sr.get("tracker.monitor.label")!=null?(String)sr.get("tracker.monitor.label"):(String) sr.get("service.pid")
		);
	}
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Consumer [group=" + group + ", pid="
				+ pid + ", scope=" + scope + ", service_id=" + service_id + "]";
	}
	
	

}
