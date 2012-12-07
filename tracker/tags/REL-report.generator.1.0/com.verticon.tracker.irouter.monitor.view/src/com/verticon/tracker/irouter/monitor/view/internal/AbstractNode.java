package com.verticon.tracker.irouter.monitor.view.internal;

public abstract class AbstractNode implements INode {

	protected final String group;
	protected final String pid;
	protected final Long service_id;
	protected final String label;

	AbstractNode(String group, String pid, Long service_id, String label) {
		super();
		this.group = group;
		this.pid = pid;
		this.service_id = service_id;
		this.label = label;
	}

	@Override
	public String getText() {
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
	 * @return the service_id
	 */
	public Long getService_id() {
		return service_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result
				+ ((service_id == null) ? 0 : service_id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		AbstractNode other = (AbstractNode) obj;
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
		if (service_id == null) {
			if (other.service_id != null)
				return false;
		} else if (!service_id.equals(other.service_id))
			return false;
		return true;
	}
}