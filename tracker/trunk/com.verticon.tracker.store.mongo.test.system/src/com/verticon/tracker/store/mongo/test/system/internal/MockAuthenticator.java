package com.verticon.tracker.store.mongo.test.system.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.store.mongo.test.system.IMockAuthenticatorController;

public class MockAuthenticator implements Authenticator,
		IMockAuthenticatorController {

	private boolean isAuthenticatedUser = false;
	private List<String> roles = null;


	@Override
	public boolean isAuthenticatedUser() {
		return isAuthenticatedUser;
	}

	@Override
	public boolean hasRole(String role) {
		return roles != null && roles.contains(role);
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.store.mongo.test.system.internal.
	 * IMockAuthenticatorController#setRole(java.lang.String)
	 */
	@Override
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.store.mongo.test.system.internal.
	 * IMockAuthenticatorController#setAuthenticatedUser(boolean)
	 */
	@Override
	public void setAuthenticatedUser(boolean isAuthenticatedUser) {
		this.isAuthenticatedUser = isAuthenticatedUser;
	}

	@Override
	public boolean isAssociatedWith(String role) {
		// TODO Auto-generated method stub
		return hasRole(role);
	}

	@Override
	public Set<String> roles() {

		Set<String> result = null;

		if (roles != null) {
			result = ImmutableSet.copyOf(roles);
		} else {
			result = Collections.emptySet();
		}

		return result;
	}
}
