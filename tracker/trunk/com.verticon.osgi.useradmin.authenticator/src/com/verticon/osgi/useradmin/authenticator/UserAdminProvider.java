package com.verticon.osgi.useradmin.authenticator;

import org.osgi.service.useradmin.UserAdmin;

public interface UserAdminProvider {
	Iterable<String> getURIs();

	UserAdmin get(String uri);
}
