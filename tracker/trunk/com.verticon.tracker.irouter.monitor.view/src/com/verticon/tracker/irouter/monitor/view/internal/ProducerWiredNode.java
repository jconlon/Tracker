package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Arrays;
import java.util.Map;


public class ProducerWiredNode extends WiredNode {

    ProducerWiredNode(Map<String, Object> sr) {
		super(
				true,
				(String) sr.get("tracker.wiring.group.name"), 
				(String) sr.get("service.pid"), 
				Arrays.toString((Object[])sr.get("wireadmin.producer.scope")), 
				(Long) sr.get("service.id")
		);
	}

    ProducerWiredNode(String group, String pid,
			String scope, long service_id) {
		super(true, group, pid, scope, service_id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProducerWiredNode [group=" + group + ", pid="
				+ pid + ", scope=" + scope + ", service_id=" + service_id + "]";
	}
    
}
