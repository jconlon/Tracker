/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.Arrays;
import java.util.Map;

import org.osgi.framework.ServiceReference;
import org.osgi.service.wireadmin.Producer;

/**
 * Graphic Model of a WireAdmin Producer or Consumer.
 * @author jconlon
 *
 */
public class WiredNode {

	enum Type {PRODUCER, CONSUMER};
	
	private final Type type;
	private final String group;
	private final String pid;
	private final String scope;
	private final Long service_id;
	
	
	
	WiredNode(ServiceReference sr){
		this(
				isProducer(sr), 
				(String) sr.getProperty("tracker.wiring.group.name"), 
				(String) sr.getProperty("service.pid"), 
				isProducer(sr)?
					Arrays.toString((Object[])sr.getProperty("wireadmin.producer.scope")):
					Arrays.toString((Object[])sr.getProperty("wireadmin.consumer.scope")), 
				(Long) sr.getProperty("service.id"));
	}
	
	WiredNode(Map<String,Object> sr){
		this(
				isProducer(sr), 
				(String) sr.get("tracker.wiring.group.name"), 
				(String) sr.get("service.pid"), 
				isProducer(sr)?
					Arrays.toString((Object[])sr.get("wireadmin.producer.scope")):
					Arrays.toString((Object[])sr.get("wireadmin.consumer.scope")), 
				(Long) sr.get("service.id"));
	}
	
    WiredNode(boolean isProducer, String group, String pid, String scope,
			long service_id) {
		super();
		this.type = isProducer?Type.PRODUCER:Type.CONSUMER;
		this.group = group;
		this.pid = pid;
		this.scope = scope;
		this.service_id = service_id;
	}

     String nodeText(){
    	StringBuilder buf = new StringBuilder(
    			group);
    	buf.append('\n');
    	
    	String name = (String) pid;
    	String prefix = "com.verticon.tracker.irouter.";
    	int nameIndex2 = name.indexOf('.', prefix.length());
    	buf.append(name.substring(prefix.length(), nameIndex2));//.append('-');
//    	buf.append(type).append('\n').append(scope);
    	return buf.toString();
    }
     
    boolean isProducer(){
    	return type == Type.PRODUCER;
    }
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WiredNode [type=" + type + ", group=" + group + ", pid="
				+ pid + ", scope=" + scope + ", service_id=" + service_id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + service_id.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		WiredNode other = (WiredNode) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (scope == null) {
			if (other.scope != null)
				return false;
		} else if (!scope.equals(other.scope))
			return false;
		if (service_id == null) {
			if (other.service_id != null)
				return false;
		} else if (!service_id.equals(other.service_id))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/**
	 * @return the group
	 */
	String getGroup() {
		return group;
	}

	/**
	 * @return the pid
	 */
	String getPid() {
		return pid;
	}

	/**
	 * @return the scope
	 */
	String getScope() {
		return scope;
	}

	/**
	 * @return the service_id
	 */
	Long getService_id() {
		return service_id;
	}
	
	static boolean isProducer(ServiceReference sr){
	    	String[] objectClass = (String[]) sr.getProperty("objectClass");
			return objectClass[0].equals(Producer.class.getName());
	}
	
	static boolean isProducer(Map<String,Object> sr){
    	String[] objectClass = (String[]) sr.get("objectClass");
		return objectClass[0].equals(Producer.class.getName());
}
	
}

