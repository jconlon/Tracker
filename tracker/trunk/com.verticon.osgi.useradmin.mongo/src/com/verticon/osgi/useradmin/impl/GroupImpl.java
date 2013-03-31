package com.verticon.osgi.useradmin.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.UserAdminPermission;

import com.google.common.eventbus.EventBus;

class GroupImpl extends UserImpl implements Group {

	private final List<Role> members;
	private final List<Role> requiredMembers;

	GroupImpl(String name, EventBus eventBus, Map<String, Object> properties,
			Map<String, Object> credentials,
			Collection<? extends Role> members,
			Collection<? extends Role> requiredMembers) {
		super(name, eventBus, properties, credentials);
		this.members = new CopyOnWriteArrayList<Role>(members);
		this.requiredMembers = new CopyOnWriteArrayList<Role>(requiredMembers);
	}

	@Override
	public boolean addMember(Role role) {
		checkPermissions();
		boolean result = false;
		if (!members.contains(role)) {
			result = members.add(role);
			if (result) {

				fireRoleChange();
			}
		}
		return result;
	}

	@Override
	public boolean addRequiredMember(Role role) {
		checkPermissions();
		boolean result = requiredMembers.add(role);
		if (result) {

			fireRoleChange();
		}
		return result;
	}

	@Override
	public boolean removeMember(Role role) {
		checkPermissions();
		boolean result = false;
		if (members.contains(role)) {
			result = members.remove(role);
		}
		if (requiredMembers.contains(role)) {
			result = requiredMembers.remove(role) || result;
		}
		if (result) {

			fireRoleChange();
		}
		return result;
	}

	@Override
	public Role[] getMembers() {
		return members.toArray(new Role[] {});
	}

	@Override
	public Role[] getRequiredMembers() {
		return requiredMembers.toArray(new Role[] {});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [name=" + getName() + "]";
	}

	@Override
	public int getType() {
		return Role.GROUP;
	}

	/**
	 * Verifies whether the caller has the right permissions to get or change
	 * the given key.
	 * 
	 * @throws SecurityException
	 *             in case the caller has not the right permissions to perform
	 *             the action.
	 */
	private void checkPermissions() throws SecurityException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager != null) {
			securityManager.checkPermission(new UserAdminPermission(
					UserAdminPermission.ADMIN, null));
		}
	}
}
