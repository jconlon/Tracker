package com.verticon.osgi.useradmin.authenticator;

import java.util.Set;

/**
 * Used to determine if the user is authenticated and if the user has role
 * assigned.
 * 
 * 
 * @author jconlon
 * 
 */
public interface Authenticator {

	/**
	 * Members of the <B>TrackerStore_BI</B> group can use the generic query
	 * facility
	 * 
	 */
	final String TRACKER_STORE_BI = "TrackerStore_BI";

	/**
	 * Members of the <B>TrackerStore_Registrant</B> group can register
	 * premises.
	 * 
	 */
	final String TRACKER_STORE_REGISTRANT = "TrackerStore_Registrant";

	/**
	 * 
	 * @return true if the user is signed on with a valid username and password
	 */
	boolean isAuthenticatedUser();

	/**
	 * @param role
	 * @return true if the user is an authorized member of a group
	 */
	boolean hasRole(String role);

	/**
	 * A user is in an association with a role if the user has the role, , the
	 * role has a property called public set to true, or if the role and the
	 * user have a common role that contains a property association set to true.
	 * 
	 * 
	 * @param role
	 * @return true if the role is public, user has this role, or there is a
	 *         common association
	 */
	boolean isAssociatedWith(String role);

	/**
	 * Use this to get a snapshot of all the role names of this user.
	 * 
	 * @return all the role names in an immutableSet
	 */
	Set<String> roles();

	/**
	 * Identifier for this Authenticator
	 * 
	 * @return uri
	 */
	String uri();

	/**
	 * 
	 * @return collection of all the users associations
	 */
	Set<String> associates();

}
