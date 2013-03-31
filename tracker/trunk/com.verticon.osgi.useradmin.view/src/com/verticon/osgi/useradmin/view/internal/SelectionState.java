package com.verticon.osgi.useradmin.view.internal;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.osgi.service.useradmin.Role;

import com.google.common.collect.Sets;
import com.verticon.osgi.useradmin.view.internal.UsersContentProvider.PropertiesNode;

/**
 * Always enabled: CreateUser, CreateGroup
 * 
 * @author jconlon
 * 
 */
enum SelectionState {
	USER, // One user - REMOVE
	GROUP, // One group REMOVE
	USERS, // More than one user REMOVE
	GROUPS, // More than two groups REMOVE
	MEMBERS, // select remove all members
	REQUIRED_MEMBERS, // ADD TO MEMBER ALL_PERSON
	ROLE_AND_GROUP, // One user and one group or two groups- AUTHORIZE,

	ROLES_AND_ONE_REQUIRED_MEMBERS, // ADD TO MEMBER
	ROLES_AND_ONE_MEMBERS, // ADD TO MEMBER

	ROLES_IN_MEMBERS, // REMOVE_FROM_MEMBER
	ROLES_IN_REQUIRED_MEMBERS, // REMOVE_FROM_REQUIRED_MEMBER
	NO_ADMINISTRATORS, // Only the createInitialAdministors action is showing
	NOT_ADMINISTRATOR, // There are admins but the user is not an administrator
	NO_USER_ADMIN, // No service
	NOTHING;

	static SelectionState instance(IStructuredSelection selection) {
		if (Activator.getDefault().getUserAdmin() == null) {
			return NO_USER_ADMIN;
		}
		SelectionState result = NOTHING;
		List<PropertiesNode> requiredMembers = newArrayList();
		List<PropertiesNode> members = newArrayList();
		Set<Role> users = newHashSet();
		Set<Role> groups = newHashSet();

		if (selection.size() > 1) {
			for (Iterator<?> i = selection.iterator(); i.hasNext();) {
				Object o = i.next();
				if (o instanceof Role) {
					Role role = (Role) o;
					if (role.getType() == Role.GROUP) {
						groups.add(role);
					} else {
						users.add(role);
					}
				} else if (o instanceof PropertiesNode) {
					PropertiesNode pn = (PropertiesNode) o;
					if (pn.getType() == PropertiesNode.MEMBERS) {
						members.add(pn);
					} else if (pn.getType() == PropertiesNode.REQUIRED_MEMBERS) {
						requiredMembers.add(pn);
					}
				}
			}
			// Determine instance
			if (users.size() == selection.size()) {
				result = USERS;
			} else if (groups.size() == selection.size()) {
				if (groups.size() > 2) {
					result = GROUPS;
				} else {
					result = ROLE_AND_GROUP;
				}
			} else if (requiredMembers.size() == selection.size()) {
				result = REQUIRED_MEMBERS;
			} else if (members.size() == selection.size()) {
				result = MEMBERS;

			} else if (users.size() == 1 && groups.size() == 1
					&& selection.size() == 2) {
				result = ROLE_AND_GROUP;
			} else if (requiredMembers.size() == 1 && members.isEmpty()) {

				// Are all the roles (users and groups) in the Members?
				PropertiesNode member = requiredMembers.get(0);
				if (member.getChildren() != null) {
					Set<Role> children = newHashSet(member.getChildren());
					int numberOfIntersections = Sets.intersection(
							Sets.union(users, groups), children).size();
					if (numberOfIntersections == users.size()) {
						// ALL
						result = ROLES_IN_REQUIRED_MEMBERS;
					} else if (numberOfIntersections == 0) {
						// NONE
						result = ROLES_AND_ONE_REQUIRED_MEMBERS;
					}
				} else {
					result = ROLES_AND_ONE_REQUIRED_MEMBERS;
				}
			} else if (members.size() == 1 && requiredMembers.isEmpty()) {
				// Are all the users in the Members?
				PropertiesNode member = members.get(0);
				if (member.getChildren() != null) {
					Set<Role> memberRoles = newHashSet(member.getChildren());
					Set<Role> roles = Sets.union(users, groups);

					int numberOfRolesInMembers = Sets.intersection(roles,
							memberRoles).size();
					if (numberOfRolesInMembers == roles.size()) {
						// ALL
						result = ROLES_IN_MEMBERS;
					} else if (numberOfRolesInMembers == 0) {
						// NONE
						result = ROLES_AND_ONE_MEMBERS;
					}
				} else {
					result = ROLES_AND_ONE_MEMBERS;
				}
			}

		} else if (selection.size() == 1) {
			Object o = selection.getFirstElement();
			if (o instanceof Role) {
				Role role = (Role) o;
				if (role.getType() == Role.GROUP) {
					result = GROUP;
				} else {
					result = USER;
				}

			} else if (o instanceof PropertiesNode) {
				PropertiesNode pn = (PropertiesNode) o;
				if (pn.getType() == PropertiesNode.MEMBERS) {
					result = MEMBERS;
				} else if (pn.getType() == PropertiesNode.REQUIRED_MEMBERS) {
					result = REQUIRED_MEMBERS;
				}
			}
		}
		return result;

	}
}