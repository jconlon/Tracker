package com.verticon.osgi.useradmin.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;

import com.google.common.eventbus.EventBus;

public class RoleFactory {

	private static final Map<String, Object> EMPTY_DICTIONARY = Collections
			.emptyMap();
	private static final List<Role> EMPTY_MEMBERS = Collections.emptyList();

	private final EventBus eventBus;

	public RoleFactory(EventBus eventBus) {
		super();

		this.eventBus = eventBus;
	}

	public Role createRole(String name) {
		return createRole(name, EMPTY_DICTIONARY);
	}

	public Role createRole(String name, Map<String, Object> properties) {
		return new RoleImpl(name, eventBus, properties);
	}

	public User createUser(String name) {
		return createUser(name, EMPTY_DICTIONARY, EMPTY_DICTIONARY);
	}

	public User createUser(String name, Map<String, Object> properties,
			Map<String, Object> credentials) {
		return new UserImpl(name, eventBus, properties, credentials);
	}

	public Group createGroup(String name) {
		return createGroup(name, EMPTY_DICTIONARY, EMPTY_DICTIONARY,
				EMPTY_MEMBERS, EMPTY_MEMBERS);
	}

	public Group createGroup(String name, Map<String, Object> properties,
			Map<String, Object> credentials,
			Collection<? extends Role> members,
			Collection<? extends Role> requiredMembers) {
		return new GroupImpl(name, eventBus, properties, credentials, members,
				requiredMembers);
	}

	// private Role createRole(int type, String name) {
	// Role result = null;
	// if (type == Role.USER) {
	// result = new UserImpl(name, eventBus, null, null);
	// } else if (type == Role.GROUP) {
	// result = new GroupImpl(name, eventBus);
	// } else {
	// result = new RoleImpl(name, eventBus);
	// }
	// return result;
	//
	// }
}
