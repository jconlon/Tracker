package com.verticon.tracker.store.mongodb.test.system;

import java.util.List;

public interface IMockAuthenticatorController {

	public abstract void setRoles(List<String> roles);

	/**
	 * @param isAuthenticatedUser
	 *            the isAuthenticatedUser to set
	 */
	public abstract void setAuthenticatedUser(boolean isAuthenticatedUser);

}