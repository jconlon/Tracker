package com.verticon.osgi.useradmin.view.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;
import org.osgi.service.useradmin.Role;

public class RoleAdapterFactory implements IAdapterFactory {

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(final Object adaptableObject, Class adapterType) {
		if (adapterType.equals(IPropertySource.class)) {
			return new PropertySource((Role) adaptableObject);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<IPropertySource>[] getAdapterList() {
		return new Class[] { IPropertySource.class };
	}

}
