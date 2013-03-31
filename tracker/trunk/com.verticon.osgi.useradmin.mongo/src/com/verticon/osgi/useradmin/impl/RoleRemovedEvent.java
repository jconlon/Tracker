package com.verticon.osgi.useradmin.impl;

import org.osgi.service.useradmin.Role;

public class RoleRemovedEvent {
	private final Role role;

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	public RoleRemovedEvent(Role role) {
		super();
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleRemovedEvent [role=" + role + "]";
	}

}
