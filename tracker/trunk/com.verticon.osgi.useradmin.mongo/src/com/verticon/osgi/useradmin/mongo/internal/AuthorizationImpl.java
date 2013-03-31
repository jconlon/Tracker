package com.verticon.osgi.useradmin.mongo.internal;

import static com.verticon.osgi.useradmin.mongo.internal.RoleChecker.isImpliedBy;
import static com.verticon.osgi.useradmin.mongo.internal.UserAdminComponent.bundleMarker;

import java.util.Set;

import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.google.common.eventbus.Subscribe;
import com.verticon.osgi.useradmin.impl.RoleChangedEvent;

public class AuthorizationImpl implements Authorization {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AuthorizationImpl.class);

	private final User user;
	private final UserAdminImpl userAdmin;

	/**
	 * Creates a new {@link AuthorizationImpl} instance for the given
	 * {@link User}.
	 * 
	 * @param user
	 *            the {@link User} to authorize, may be <code>null</code> for
	 *            the anonymous user;
	 * @param userAdmin
	 *            the userAdmin to use for obtaining the roles, cannot be
	 *            <code>null</code>.
	 */
	public AuthorizationImpl(User user, UserAdminImpl userAdmin) {
		this.user = user;
		this.userAdmin = userAdmin;
	}

	@Override
	public String getName() {
		return user.getName();
	}

	@Override
	public boolean hasRole(String name) {
		Role role = userAdmin.getRole(name);
		if (role == null) {
			// No role found, so it is never implied...
			return false;
		}
		return isImpliedBy(role, user);
	}

	/**
	 * Find the immediate implied Groups, then their groups,etc.
	 * 
	 * @see org.osgi.service.useradmin.Authorization#getRoles()
	 */
	@Override
	public synchronized String[] getRoles() {
		logger.debug(bundleMarker, "Finding Roles for {}", user);
		String[] result = null;
		Set<String> impliedRoleNames;
		try {
			impliedRoleNames = userAdmin.rolesCache.get(user).get();
			result = Iterables.toArray(impliedRoleNames, String.class);
		} catch (Exception e) {
			logger.error(bundleMarker, "Failed to get roles.", e);
			result = new String[] {};
		}
		return result;
	}

	@Subscribe
	public synchronized void handle(RoleChangedEvent event) {
		Role effectedRole = event.getRole();
		if (user.equals(effectedRole)) {
			userAdmin.rolesCache.invalidate(user);
		} else if (Role.GROUP == effectedRole.getType()
				&& isImpliedBy(effectedRole, user)) {
			userAdmin.rolesCache.invalidate(user);
		}
	}

}
