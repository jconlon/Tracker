package com.verticon.osgi.useradmin.view.internal;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;

public class PropertySource implements IPropertySource {

	public static final String NAME = "name";
	public static final String ADD_PROPERTY = "add_property";
	public static final String REMOVE_PROPERTY = "remove_property";
	private static final String ADD_CREDENTIAL = "add_credential";
	private static final String REMOVE_CREDENTIAL = "remove_credential";

	private static final String PROPERTIES_CATEGORY = "Role Properties";
	private static final String CREDENTIALS_CATEGORY = "User Credentials";

	private final Role role;

	private final List<String> propIds = newArrayList();
	private final List<String> credIds = newArrayList();

	public PropertySource(Role role) {
		this.role = role;
	}

	@Override
	public Object getEditableValue() {
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		List<IPropertyDescriptor> descriptors = newArrayList();
		PropertyDescriptor d = null;

		descriptors.add(new PropertyDescriptor(NAME, "Name"));

		d = new TextPropertyDescriptor(ADD_PROPERTY, "");
		d.setCategory(PROPERTIES_CATEGORY);
		descriptors.add(d);

		Dictionary<String, String> properties = role.getProperties();
		for (Enumeration<String> e = properties.keys(); e.hasMoreElements();) {
			String key = e.nextElement();
			d = new TextPropertyDescriptor(key, key);
			d.setCategory(PROPERTIES_CATEGORY);
			descriptors.add(d);
			propIds.add(key);
		}

		if (role instanceof User) {
			Dictionary<String, String> credentials = ((User) role)
					.getCredentials();
			for (Enumeration<String> e = credentials.keys(); e
					.hasMoreElements();) {
				String key = e.nextElement();
				d = new TextPropertyDescriptor(key, key);
				d.setCategory(CREDENTIALS_CATEGORY);
				descriptors.add(d);
				credIds.add(key);
			}

			d = new TextPropertyDescriptor(ADD_CREDENTIAL, "");
			d.setCategory(CREDENTIALS_CATEGORY);
			descriptors.add(d);
		}

		return descriptors.toArray(new IPropertyDescriptor[descriptors.size()]);
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(NAME)) {
			return role.getName();
		} else if (id.equals(ADD_PROPERTY)) {
			return "<Add property...>";
		} else if (id.equals(REMOVE_PROPERTY)) {
			return "<Remove property...>";
		} else if (id.equals(ADD_CREDENTIAL)) {
			return "<Add credential...>";
		} else if (id.equals(REMOVE_CREDENTIAL)) {
			return "<Remove credential...>";
		} else if (propIds.contains(id)) {
			return role.getProperties().get(id);
		} else if (credIds.contains(id)) {
			return ((User) role).getCredentials().get(id);
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// empty
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setPropertyValue(Object id, Object value) {
		if (!(value instanceof String)) {
			return;
		}

		if (id.equals(ADD_PROPERTY)) {
			addProperty(role.getProperties(), (String) value);
		} else if (id.equals(ADD_CREDENTIAL)) {
			addProperty(((User) role).getCredentials(), (String) value);
		} else if (propIds.contains(id)) {
			changeProperty(role.getProperties(), (String) id, (String) value);
		} else if (credIds.contains(id)) {
			changeProperty(((User) role).getCredentials(), (String) id,
					(String) value);
		}
	}

	private void changeProperty(Dictionary<String, String> dict, String id,
			String value) {
		if (value.trim().length() == 0) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell();
			if (MessageDialog.openConfirm(shell, "Change property",
					"Do you want to remove '" + id + "'?")) {
				dict.remove(id);
				return;
			}
		}

		dict.put(id, value);
	}

	private void addProperty(Dictionary<String, String> dict, String value) {
		int pos = value.indexOf('=');

		if ((pos == -1) || (pos == 0) || (pos == value.length() - 1)) {
			return;
		}

		String key = value.substring(0, pos);
		String val = value.substring(pos + 1, value.length());

		dict.put(key, val);
	}
}
