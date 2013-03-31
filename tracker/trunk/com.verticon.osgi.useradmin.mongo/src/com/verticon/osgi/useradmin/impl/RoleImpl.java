package com.verticon.osgi.useradmin.impl;

import java.util.Dictionary;
import java.util.Map;

import org.osgi.service.useradmin.Role;

import com.google.common.eventbus.EventBus;

class RoleImpl implements Role {


	private final String name;
	private final Dictionary<String, ?> properties;
	private final EventBus eventBus;
	private final RoleChangedEvent roleChangeEvent;

	RoleImpl(String name, EventBus eventBus, Map<String, Object> properties) {
		super();
		this.name = name;
		this.eventBus = eventBus;
		this.properties = new ObservableHashtable<String, Object>(this,
				ObservableHashtable.Type.PROPERTIES, properties);
		this.roleChangeEvent = new RoleChangedEvent(this);

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getType() {
		return Role.ROLE;
	}

	@Override
	public Dictionary<String, ?> getProperties() {
		return properties;
	}

	void fireRoleChange() {
		eventBus.post(roleChangeEvent);
		// listener.roleChanged(this);
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RoleImpl)) {
			return false;
		}
		RoleImpl other = (RoleImpl) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [name=" + getName() + "]";
	}

}