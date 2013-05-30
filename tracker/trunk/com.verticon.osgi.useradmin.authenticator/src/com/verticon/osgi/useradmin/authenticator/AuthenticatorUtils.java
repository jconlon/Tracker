package com.verticon.osgi.useradmin.authenticator;

import java.util.HashSet;
import java.util.Set;

import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.UserAdmin;

public class AuthenticatorUtils {

	public static Set<String> getAssociates(UserAdmin userAdmin,
			Authorization authorization) {
		Set<String> associates = new HashSet<String>();
		for (String role : authorization.getRoles()) {
			addRoles(associates, role, userAdmin);
		}
		return associates;
	}

	private static void addRoles(Set<String> associates, String name,
			UserAdmin userAdmin) {
		Role role = userAdmin.getRole(name);
		if (role.getType() == Role.GROUP) {
			if (associates.add(name)) {
				Group grp = (Group) role;
				String[] roles = userAdmin.getAuthorization(grp).getRoles();
				for (String n : roles) {
					addRoles(associates, n, userAdmin);
				}
			}


		}
	}

}
