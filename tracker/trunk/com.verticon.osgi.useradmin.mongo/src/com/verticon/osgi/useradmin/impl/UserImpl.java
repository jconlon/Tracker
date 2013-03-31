package com.verticon.osgi.useradmin.impl;

import java.util.Dictionary;
import java.util.Map;

import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;

import com.google.common.eventbus.EventBus;

class UserImpl extends RoleImpl implements User {

	private final Dictionary<String, ?> credentials;

	UserImpl(String name, EventBus eventBus, Map<String, Object> properties,
			Map<String, Object> credentials) {
		super(name, eventBus, properties);
		this.credentials = new ObservableHashtable<String, Object>(this,
				ObservableHashtable.Type.CREDENTIALS, credentials);
	}

	@Override
	public Dictionary<String, ?> getCredentials() {
		return credentials;
	}

	@Override
	public boolean hasCredential(String key, Object value) {
		Object result = credentials.get(key);
		if (result != null && result.equals(value)) {
			return true;
		}
		return false;
	}

	@Override
	public int getType() {
		return Role.USER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + getName() + "]";
	}
}
