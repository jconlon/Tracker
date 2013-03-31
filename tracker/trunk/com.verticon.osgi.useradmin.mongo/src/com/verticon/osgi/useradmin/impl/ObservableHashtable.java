package com.verticon.osgi.useradmin.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Hashtable;
import java.util.Map;

import org.osgi.service.useradmin.UserAdminPermission;

class ObservableHashtable<K, V> extends Hashtable<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4639971650197626515L;
	private final RoleImpl roleImpl;

	private final Type type;

	ObservableHashtable(RoleImpl roleImpl, Type type, Map<K, V> properties) {
		super();
		super.putAll(properties);
		this.roleImpl = roleImpl;
		this.type = type;
	}

	enum Type {
		PROPERTIES, CREDENTIALS;
		String get() {
			switch (this) {
			case PROPERTIES:
				return null;
			default:
				return UserAdminPermission.GET_CREDENTIAL;
			}
		}
		String change() {
			switch (this) {
			case PROPERTIES:
				return UserAdminPermission.CHANGE_PROPERTY;
			default:
				return UserAdminPermission.CHANGE_CREDENTIAL;
			}
		}
		String remove() {
			switch (this) {
			case PROPERTIES:
				return UserAdminPermission.CHANGE_PROPERTY;
			default:
				return UserAdminPermission.CHANGE_CREDENTIAL;
			}
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Hashtable#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public synchronized V put(K key, V value) {
		if (!isUnderConstruction()) {
			checkPermissions(getAsPermissionName(key), type.change());
		}

		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null!");
		}
		if (value == null) {
			throw new IllegalArgumentException("Value cannot be null!");
		}

		if (key instanceof String) {
		} else {
			throw new IllegalArgumentException("Key must be a String!");
		}
		if ((value instanceof String) || (value instanceof byte[])) {
		} else {
			throw new IllegalArgumentException(
					"Value cannot be String or a byte[]!");
		}

		V oldValue = super.put(key, value);
		if (!isUnderConstruction()) {
			roleImpl.fireRoleChange();
		}
		return oldValue;

	}

	private boolean isUnderConstruction() {
		return roleImpl == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Hashtable#get(java.lang.Object)
	 */
	@Override
	public synchronized V get(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null!");
		}

		checkPermissions(getAsPermissionName(key), type.get());

		return super.get(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Hashtable#remove(java.lang.Object)
	 */
	@Override
	public synchronized V remove(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null!");
		}

		checkPermissions(getAsPermissionName(key), type.remove());

		V oldValue = super.remove(key);
		if (roleImpl != null)
			roleImpl.fireRoleChange();
		return oldValue;
	}

	protected String getAsPermissionName(Object key) {
		String k = UserAdminPermission.ADMIN;
		if (key instanceof String) {
			k = (String) key;
		}
		return k;
	}

	/**
	 * Verifies whether the caller has the right permissions to get or change
	 * the given key.
	 * 
	 * @param name
	 *            of the property that is to be accessed or changed, cannot be
	 *            <code>null</code>;
	 * @param action
	 *            the action name to perform, can be <code>null</code>
	 *            indicating there is no check.
	 * @throws SecurityException
	 *             in case the caller has not the right permissions to perform
	 *             the action.
	 */
	private void checkPermissions(String name, String action)
			throws SecurityException {
		checkNotNull(name);
		if (action == null) {
			return;
		}
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager != null) {
			securityManager.checkPermission(new UserAdminPermission(name,
					action));
		}
	}
}
