package com.verticon.tracker.store.location.test.system.internal;

import java.util.List;

public interface IMockAuthenticatorController {

	public abstract void setRoles(List<String> roles);

	/**
	 * @param isAuthenticatedUser
	 *            the isAuthenticatedUser to set
	 */
	public abstract void setAuthenticatedUser(boolean isAuthenticatedUser);

}