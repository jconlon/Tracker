package com.verticon.osgi.useradmin.view.internal;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.osgi.useradmin.authenticator.Authenticator;
import com.verticon.osgi.useradmin.authenticator.UserAdminProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.verticon.osgi.useradmin.view";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		Activator.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	static final String ADMINISTRATORS = "administrators";

	// The shared instance
	private static Activator plugin;
	private ServiceTracker<UserAdminProvider, UserAdminProvider> userAdminProviderTracker;
	private ServiceTracker<Authenticator, Authenticator> authenticatorAdminTracker;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		userAdminProviderTracker = new ServiceTracker(context,
				UserAdminProvider.class.getName(), null);
		userAdminProviderTracker.open();

		authenticatorAdminTracker = new ServiceTracker(context,
				Authenticator.class.getName(), null);
		authenticatorAdminTracker.open();

		Platform.getAdapterManager().registerAdapters(new RoleAdapterFactory(),
				Role.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
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
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		reg.put(SharedImages.GROUP_ICON,
				imageDescriptorFromPlugin(PLUGIN_ID, SharedImages.GROUP_ICON));
		reg.put(SharedImages.USER_ICON,
				imageDescriptorFromPlugin(PLUGIN_ID, SharedImages.USER_ICON));
		reg.put(SharedImages.ROLE_ICON,
				imageDescriptorFromPlugin(PLUGIN_ID, SharedImages.ROLE_ICON));
	}

	UserAdmin getUserAdmin() {
		UserAdmin result = null;
		Authenticator authenticator = authenticatorAdminTracker.getService();
		if (authenticator != null && authenticator.uri() != null) {
			result = userAdminProviderTracker.getService() != null ? userAdminProviderTracker
					.getService().get(authenticator.uri()) : null;
		}
		return result;
	}

	boolean isUserAdmininistrator() {
		Authenticator authenticator = authenticatorAdminTracker.getService();
		return authenticator != null ? authenticator.hasRole(ADMINISTRATORS)
				: false;
	}

	boolean hasAdministrator() {
		boolean hasAdminstrator = false;
		UserAdmin userAdmin = getUserAdmin();
		if (userAdmin != null) {
			Role role = userAdmin.getRole(ADMINISTRATORS);
			if (role != null) {
				if (Role.GROUP == role.getType()) {
					Group adminstrators = (Group) role;
					if (adminstrators.getMembers().length > 0
							|| adminstrators.getRequiredMembers().length > 0) {
						hasAdminstrator = true;
					}
				}
			}
		}

		return hasAdminstrator;
	}

}