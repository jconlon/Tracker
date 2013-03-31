package com.verticon.tracker.store.location.test.system.internal;

import static com.google.common.collect.Sets.newHashSet;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.tracker.store.mongo.test.system.Member;

public class MockAuthenticator implements Authenticator {

	private final Set<String> authorized = newHashSet();

	private final boolean isAuthenticatedUser = true;
	private final List<String> roles = Lists.newArrayList(
			"TrackerStore_Registrant", "TrackerStore_BI", Member.ONE.uri);



	protected void activated() {

	}

	@Override
	public boolean isAuthenticatedUser() {
		return isAuthenticatedUser;
	}

	@Override
	public boolean hasRole(String role) {
		if (!authorized.contains(role)) {
			System.out.printf("%s authorizing %s%n", this, role);
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
		return hasRole(role);
	}

	@Override
	public Set<String> roles() {
		return Sets.newHashSet(roles);
	}


}
