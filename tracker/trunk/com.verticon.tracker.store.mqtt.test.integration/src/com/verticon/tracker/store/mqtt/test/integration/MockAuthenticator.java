package com.verticon.tracker.store.mqtt.test.integration;

import static com.verticon.tracker.store.mqtt.test.integration.Configurator.PREMISES_URI;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.PREMISES_URI_003ALKMN;
import static com.verticon.tracker.store.mqtt.test.integration.Configurator.PREMISES_URI_H89234X;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.verticon.osgi.useradmin.authenticator.Authenticator;

public class MockAuthenticator implements Authenticator {

	// private boolean isAuthenticatedUser = false;
	private final List<String> roles = Arrays.asList(PREMISES_URI_H89234X,
			PREMISES_URI_003ALKMN, PREMISES_URI, TRACKER_STORE_REGISTRANT,
			TRACKER_STORE_BI);

	@Override
	public boolean isAuthenticatedUser() {
		return true;// isAuthenticatedUser;
	}

	@Override
	public boolean hasRole(String role) {
		return true;// roles != null && roles.contains(role);
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see com.verticon.tracker.store.mongo.test.system.internal.
	// * IMockAuthenticatorController#setRole(java.lang.String)
	// */
	// @Override
	// public void setRoles(List<String> roles) {
	// this.roles = roles;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.verticon.tracker.store.mongo.test.system.internal.
	// * IMockAuthenticatorController#setAuthenticatedUser(boolean)
	// */
	// @Override
	// public void setAuthenticatedUser(boolean isAuthenticatedUser) {
	// this.isAuthenticatedUser = isAuthenticatedUser;
	// }

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

	@Override
	public String uri() {
		return "localhost";
	}

	@Override
	public Set<String> associates() {
		throw new UnsupportedOperationException("Not implemented.");
	}
}
