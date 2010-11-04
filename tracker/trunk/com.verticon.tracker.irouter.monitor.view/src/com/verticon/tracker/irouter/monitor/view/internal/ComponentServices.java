package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ComponentServices implements INode {

	private final List<WiredNode> children = new ArrayList<WiredNode>();
	private final String pid;
	private final String group;
	private final String text;

	ComponentServices(WiredNode... wiredNodes) {
		if(wiredNodes.length>2){
			throw new IllegalArgumentException("There must be two or more wiredNodes.");
		}
		this.pid = wiredNodes[0].getPid();
		if(pid == null){
			throw new IllegalArgumentException("WiredNode Pid cannot be null");
		}
		this.group = wiredNodes[0].getGroup();
		if(pid == null){
			throw new IllegalArgumentException("WiredNode Group cannot be null");
		}
		this.text = wiredNodes[0].getComponentLabel();
		if(pid == null){
			throw new IllegalArgumentException("WiredNode ComponentLabel cannot be null");
		}
		
		for (WiredNode wiredNode : wiredNodes) {
			children.add(wiredNode);
			wiredNode.setParent(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComponentServices [name=" + text + ", children=" + children.size() + ", Pid="
				+ getPid() + ", Group=" + getGroup() + "]";
	}


	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the children
	 */
	public WiredNode[] getChildren() {
		WiredNode[] nodes = new WiredNode[children.size()];
		return children.toArray(nodes);
	}

	@Override
	public String getPid() {
		return pid;
	}

	@Override
	public String getGroup() {
		return group;
	}


	Collection<WiredNode> getSiblings(Long serviceId){
		Vector<WiredNode> nodesToKeep = new Vector<WiredNode>(3);
		for (WiredNode wiredNode : getChildren()) {
			if (!wiredNode.getService_id().equals(serviceId)) {
				nodesToKeep.add(wiredNode);
			}
		}
		return nodesToKeep;
	}

	/**
	 * Initially can't have grandparents
	 */
	@Override
	public ComponentServices getParent() {
		return null;
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
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		ComponentServices other = (ComponentServices) obj;
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
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
