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

/**
 * Graphic Model of a WireAdmin Producer or Consumer.
 * 
 * @author jconlon
 * 
 */
public abstract class WiredNode implements Node {

	protected final String group;
	protected final String pid;
	protected final String scope;
	protected final Long service_id;
	protected final String label;
	protected final boolean isProducer;
	protected ComponentServices parent;

	/**
	 * @return the parent
	 */
	public ComponentServices getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(ComponentServices parent) {
		this.parent = parent;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + (isProducer ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((parent == null) ? 0 : 1239);
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result
				+ ((service_id == null) ? 0 : service_id.hashCode());
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
		if (isProducer != other.isProducer)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
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
		return true;
	}

	protected WiredNode(boolean isProducer, String group, String pid,
			String scope, long service_id, String label) {
		super();
		this.isProducer=isProducer;
		this.group = group;
		this.pid = pid;
		this.scope = scope;
		this.service_id = service_id;
		this.label = label;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.monitor.view.internal.Node#nodeText()
	 */
	@Override
	public String nodeText() {
		String name = (String) pid;
		String prefix = "com.verticon.tracker.irouter.";
		if (pid.contains(prefix)) {
			int nameIndex2 = name.indexOf('.', prefix.length());
			name = name.substring(prefix.length(), nameIndex2);
		} else {
			int nameIndex = name.indexOf('-');
			if (nameIndex != -1) {
				name = name.substring(0, nameIndex);
			}
		}
		return name;
	}

	

	

	/**
	 * @return the group
	 */
	@Override
	public String getGroup() {
		return group;
	}

	/**
	 * @return the pid
	 */
	@Override
	public String getPid() {
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

	public String getComponentLabel() {
		return label;
	}

}
