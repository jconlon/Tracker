package com.verticon.osgi.useradmin.view.internal;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.service.useradmin.Role;

import com.verticon.osgi.useradmin.view.internal.UsersContentProvider.PropertiesNode;

public class UsersLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof Role) {
			switch (((Role) element).getType()) {
			case Role.GROUP:
				return SharedImages.getImage(SharedImages.GROUP_ICON);
			case Role.USER:
				return SharedImages.getImage(SharedImages.USER_ICON);
			case Role.ROLE:
				return SharedImages.getImage(SharedImages.ROLE_ICON);
			}
		}

		return SharedImages.getImage(SharedImages.ROLE_ICON);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Role) {
			return ((Role) element).getName();
		} else if (element instanceof PropertiesNode) {
			switch (((PropertiesNode) element).getType()) {
			case PropertiesNode.MEMBERS:
				return "Members";
			case PropertiesNode.REQUIRED_MEMBERS:
				return "RequiredMembers";
			}
		}

		return super.getText(element);
	}

}
