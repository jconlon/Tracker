package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.ArrayList;
import java.util.List;

public class ComponentServices implements Node {

	private final List<WiredNode> children = new ArrayList<WiredNode>();
	private final static List<ComponentServices> instances = new ArrayList<ComponentServices>();

	ComponentServices(WiredNode... wiredNodes) {
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
		return "ComponentServices [children=" + children.size() + ", Pid="
				+ getPid() + ", Group=" + getGroup() + "]";
	}

	/**
	 * Get an existing instance or create a new instance.
	 * 
	 * @param child
	 * @return
	 */
	static ComponentServices add(WiredNode child) {
		for (ComponentServices container : instances) {
			if (container.children.contains(child)) {
				return container;
			}
			if (container.getPid().equals(child.getPid())) {
				container.addChild(child);
				child.setParent(container);
				return container;
			}
		}
		ComponentServices instance = new ComponentServices();
		instance.addChild(child);
		instances.add(instance);
		return instance;
	}

	/**
	 * Remove a child from an existing instance or return null if there was no
	 * previous instance or the number of children is zero after the remove.
	 * 
	 * @param child
	 * @return
	 */
	static ComponentServices remove(WiredNode child) {
		for (ComponentServices container : instances) {
			if (container.children.contains(child)) {
				container.children.remove(child);
				child.setParent(null);
				if (container.children.isEmpty()) {
					instances.remove(container);
					return null;
				}
				return container;
			}

		}

		return null;
	}

	/**
	 * @return the containers
	 */

	static ComponentServices[] getInstances() {
		ComponentServices[] containers = new ComponentServices[instances.size()];
		return instances.toArray(containers);
	}

	static boolean containsInstance(String pid) {
		for (ComponentServices instance : instances) {
			if (instance.getPid().equals(pid)) {
				return true;
			}
		}
		return false;
	}

	static ComponentServices findInstance(String pid) {
		for (ComponentServices instance : instances) {
			if (instance.getPid().equals(pid)) {
				return instance;
			}
		}
		return null;
	}

	// static void clear(){
	// instances.clear();
	// }

	/**
	 * @return the text
	 */
	public String nodeText() {
		return children.get(0).getComponentLabel();
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
		return children.isEmpty() ? null : children.get(0).getPid();
	}

	@Override
	public String getGroup() {
		return children.isEmpty() ? null : children.get(0).getGroup();
	}

	boolean addChild(WiredNode child) {
		return children.add(child);
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
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
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
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		return true;
	}

}
