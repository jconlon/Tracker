package com.verticon.osgi.useradmin.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.util.tracker.ServiceTracker;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.osgi.useradmin.authenticator.UserStateChangeListener;
import com.verticon.osgi.useradmin.authenticator.Utils;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.osgi.useradmin.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private ServiceTracker<UserAdmin, UserAdmin> userAdminTracker;
	private ServiceTracker<UserStateChangeListener, UserStateChangeListener> userStateChangeListeners;

	private final AuthenticatorImpl authenticator = new AuthenticatorImpl();

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		userAdminTracker = new ServiceTracker<UserAdmin, UserAdmin>(context,
				UserAdmin.class, null);
		userAdminTracker.open();
		userStateChangeListeners = new ServiceTracker<UserStateChangeListener, UserStateChangeListener>(
				context, UserStateChangeListener.class, null);
		userStateChangeListeners.open();
		context.registerService(Authenticator.class, authenticator, null);
		// context.registerService(UserAdminListener.class, authenticator,
		// null);

	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		removeAuthorization();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	UserAdmin getUserAdmin() {
		return userAdminTracker.getService();
	}

	UserStateChangeListener[] getUserStateChangeListeners() {
		UserStateChangeListener[] listeners = new UserStateChangeListener[] {};
		return userStateChangeListeners.getServices(listeners);
	}

	boolean isAuthenticatedUser() {
		return authenticator.isAuthenticatedUser();
	}

	boolean hasRole(String role) {
		return authenticator.hasRole(role);
	}

	void authenticate(String userName, String pass) throws Exception {
		authenticator.authenticate(userName, pass);
	}

	void removeAuthorization() {
		authenticator.setAuthorization(null);
	}

	void changePassword(String password, String newPassword) throws Exception {
		UserAdmin userAdmin = getUserAdmin();
		checkNotNull(userAdmin,
				"Illegal State: Failed to find the UserAdmin Service.");
		checkNotNull(authenticator.getAuthorization(),
				"Illegal State: User must have an Authorization.");
		String name = authenticator.getAuthorization().getName();
		User user = (User) userAdmin.getRole(name);
		boolean authorized = Utils.isAuthenticate(user, password);
		if (!authorized) {
			throw new SecurityException(
					"Could not authenticate the current user.");
		}
		Utils.resetPassword(user, newPassword);
	}
}
