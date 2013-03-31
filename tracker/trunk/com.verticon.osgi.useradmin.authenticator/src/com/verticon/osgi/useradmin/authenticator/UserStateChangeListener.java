package com.verticon.osgi.useradmin.authenticator;

public interface UserStateChangeListener {

	void handle(String userName, UserState oldState, UserState newState);
}
