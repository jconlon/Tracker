package com.verticon.osgi.useradmin.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.osgi.useradmin.authenticator.AuthenticatorUtils;
import com.verticon.osgi.useradmin.authenticator.UserState;
import com.verticon.osgi.useradmin.authenticator.UserStateChangeListener;
import com.verticon.osgi.useradmin.ui.Utils;
//import com.verticon.osgi.useradmin.ui.Utils;

public class AuthenticatorImpl implements Authenticator {

	private Authorization authorization = null;
	private String uri = null;

	@Override
	public boolean isAuthenticatedUser() {
		return authorization != null;
	}

	@Override
	public boolean hasRole(String role) {
		return isAuthenticatedUser() && roles().contains(role);
	}

	/**
	 * @return the authorization
	 */
	Authorization getAuthorization() {
		return authorization;
	}


	/**
	 * @param authorization
	 *            the authorization to set
	 */
	void setAuthorization(Authorization authorization) {
		// cachedRoles = null;
		String name = authorization != null ? authorization.getName()
				: this.authorization != null ? this.authorization.getName()
						: "";

		UserState oldState = this.authorization != null ? UserState.SIGNED_ON
				: UserState.SIGNED_OFF;
		this.authorization = authorization;


		UserState newState = this.authorization != null ? UserState.SIGNED_ON
				: UserState.SIGNED_OFF;
		for (UserStateChangeListener listener : Activator.getDefault()
				.getUserStateChangeListeners()) {
			listener.handle(name, oldState, newState);
		}

	}

	boolean authenticate(String userName, String pass, String uri)
			throws Exception {
		checkNotNull(uri, "Parameter uri can not be null.");
		UserAdmin userAdmin = Activator.getDefault().getUserAdmin(uri);
		checkNotNull(userAdmin, "Failed to find the UserAdmin Service.");
		this.uri = uri;
		User user = getUser(userName, pass, userAdmin);// userAdmin.getRole(userName);

		if (user != null) {
			setAuthorization(userAdmin.getAuthorization(user));
		} else {
			setAuthorization(null); // not authenticated
		}

		return authorization != null;
	}



	private User getUser(String userName, String password, UserAdmin userAdmin)
			throws Exception {
		checkNotNull(userName);
		checkNotNull(password);
		Role role = userAdmin.getRole(userName);
		if (role instanceof User) {
			User user = (User) role;
			if (Utils.isAuthenticate(user, password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean isAssociatedWith(String role) {
		if ( hasRole(role) ){
			return true;
		}
		UserAdmin userAdmin = Activator.getDefault().getUserAdmin(uri);
		Role target = userAdmin.getRole(role);
		
		return Utils.isAssociatedWith(authorization, target, userAdmin);
	}

	@Override
	public Set<String> roles() {
		return newHashSet(authorization.getRoles());

	}

	@Override
	public String uri() {
		return uri;
	}

	/**
	 * Recursively find all the associates of this user.
	 */
	@Override
	public Set<String> associates() {
		UserAdmin userAdmin = Activator.getDefault().getUserAdmin(uri);
		return AuthenticatorUtils.getAssociates(userAdmin, authorization);
	}




}
