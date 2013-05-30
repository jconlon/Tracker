package com.verticon.osgi.useradmin.ui;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class Utils {

	/**
	 * This is the attribute key in the User document that holds the password.
	 * 
	 */
	private static final String PASS_CREDENTIAL = System.getProperty(
			"org.osgi.useradmin.pass.credential", "password");

	private Utils() {
	}

	/**
	 * Validate if there is an association between a User authorization and a
	 * target role.
	 * 
	 * @param authorization
	 *            of a user
	 * @param target
	 *            role. A role that is null is always associated with the user
	 * @param userAdmin
	 *            service to use
	 * @return true if an association exists
	 */
	final public static boolean isAssociatedWith(Authorization authorization,
			Role target, UserAdmin userAdmin) {
		if (target == null) {
			return true;// a null target is one that is always associated
		}
		checkNotNull(authorization, "Authorization parameter is null.");

		checkNotNull(userAdmin, "UserAdmin paramter is null.");
		// Is there a hasRole relationship?
		if (authorization.hasRole(target.getName())) {
			return true;
		}
		// Is the target public?
		Object value = target.getProperties().get("public");
		if (value != null) {
			if (value.equals("true") || value.equals(Boolean.TRUE)) {
				return true;
			}
		}
		// Do the user and the target belong to a common association?
		Set<String> userRoles = ImmutableSet.copyOf(authorization.getRoles());
		Set<String> targetRoles = ImmutableSet.copyOf(authorization.getRoles());
		Set<String> intersection = Sets.intersection(userRoles, targetRoles);
		boolean isAssociate = false;
		for (String name : intersection) {
			Role intersect = userAdmin.getRole(name);
			Object o = intersect.getProperties().get("association");
			if (o != null) {
				if (o.equals("true") || o.equals(Boolean.TRUE)) {
					isAssociate = true;
					break;
				}
			}
		}
		return isAssociate;
	}

	final public static boolean isAuthenticate(User user, String password)
			throws Exception {
		if (user.getCredentials().get(PASS_CREDENTIAL) == null) {
			throw new SecurityException(String.format(
							"%s authentication disabled. Contact the system administrator.",
					user.getName()));
		}
		return user.hasCredential(PASS_CREDENTIAL, encrypt(password));
	}

	final public static boolean isPasswordNullOrEmpty(User user) {
		String cipherText = (String) user.getCredentials().get(PASS_CREDENTIAL);
		return isNullOrEmpty(cipherText);

	}

	@SuppressWarnings("unchecked")
	final public static void resetPassword(User user, String password)
			throws Exception {
		checkNotNull(user);
		checkNotNull(password);
		user.getCredentials().put(PASS_CREDENTIAL, encrypt(password));
	}

	final static private byte[] sha1(String plaintext) throws Exception {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1"); // step 2
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}
		try {
			md.update(plaintext.getBytes("UTF-8")); // step 3
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		return md.digest(); // step 4
	}

	final static private String encrypt(String plaintext) throws Exception {
		byte raw[] = sha1(plaintext);
		String hash = DatatypeConverter.printBase64Binary(raw);
		return hash;
	}
}
