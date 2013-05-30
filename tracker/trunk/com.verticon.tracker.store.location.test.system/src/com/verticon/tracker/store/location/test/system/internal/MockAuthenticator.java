package com.verticon.tracker.store.location.test.system.internal;

import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.location.test.system.internal.Configuator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.location.test.system.internal.Configuator.URN_PIN_003CZKO;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.verticon.osgi.useradmin.authenticator.Authenticator;

public class MockAuthenticator implements Authenticator {

	private final Set<String> authorized = newHashSet();

	private final boolean isAuthenticatedUser = true;
	private final List<String> roles = Lists.newArrayList(
			"TrackerStore_Registrant", "TrackerStore_BI", PREMISES_URI_H89234X);

	private final Set<String> associates = newHashSet(PREMISES_URI_H89234X,
			"nothing", URN_PIN_003CZKO);

	protected void activated() {

	}

	@Override
	public boolean isAuthenticatedUser() {
		return isAuthenticatedUser;
	}

	@Override
	public boolean hasRole(String role) {
		if (!authorized.contains(role)) {
			// System.out.printf("%s authorizing %s%n", this, role);
			authorized.add(role);
		}
		return roles.contains(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockAuthenticator []";
	}

	@Override
	public boolean isAssociatedWith(String role) {
		// return hasRole(role);
		return true;
	}

	@Override
	public Set<String> roles() {
		return Sets.newHashSet(roles);
	}

	@Override
	public String uri() {
		return "localhost:27017/test_trackerstore_location";
	}

	@Override
	public Set<String> associates() {

		return associates;
	}

}
