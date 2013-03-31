package com.verticon.osgi.useradmin.view.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class SharedImages {

	public final static String ICONS_PATH = "icons/";
	public static final String GROUP_ICON = ICONS_PATH + "group.gif";
	public static final String USER_ICON = ICONS_PATH + "user.gif";
	public static final String ROLE_ICON = ICONS_PATH + "role.gif";

	public static ImageDescriptor getImageDescriptor(String key) {
		return Activator.getDefault().getImageRegistry().getDescriptor(key);
	}

	public static Image getImage(String key) {
		return Activator.getDefault().getImageRegistry().get(key);
	}
}
