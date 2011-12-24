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
				(Long) sr.get("service.id"),
				sr.get("tracker.monitor.label")!=null?(String)sr.get("tracker.monitor.label"):(String) sr.get("service.pid")
		);
	}

    ProducerWiredNode(String group, String pid,
			String scope, long service_id) {
		this(group, pid, scope, service_id, "unknown");
	}
    
    ProducerWiredNode(String group, String pid,
			String scope, long service_id, String label) {
		super(true, group, pid, scope, service_id, label);
	}
    
    ProducerWiredNode(ProducerWiredNode pwn){
    	this(pwn.group, pwn.pid, pwn.scope, pwn.service_id, pwn.label);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Producer [group=" + group + ", pid="
				+ pid + ", scope=" + scope + ", service_id=" + service_id + "]";
	}
    
}
