/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.ui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.tracker.store.admin.Admin;

/**
 * Tests an Admin document to get the name of the admin to see if it is the same
 * as the current user and tests if the activator can find a TrackerStoreAdmin 
 * that can be used by the user.
 * 
 * @author jconlon
 * 
 */
public class CanLoadAdminPropertyTester extends PropertyTester {

	private static final String USER;
	static {
		StringBuilder currentUserAndHost = new StringBuilder(
				System.getProperty("user.name")).append('@');
		try {
			currentUserAndHost.append(InetAddress.getLocalHost().getHostName());

		} catch (UnknownHostException e) {
			// Should never happen
			e.printStackTrace();
		}
		USER = currentUserAndHost.toString();
	}

	/**
	 * 
	 * Tests an Admin to see if there is a ITrackerStoreAdmin service available
	 * for it.
	 * 
	 * Executes the property test determined by the parameter
	 * <code>property</code>.
	 * 
	 * @param receiver
	 *            the receiver of the property test
	 * @param property
	 *            the property to test
	 * @param args
	 *            additional arguments to evaluate the property. If no arguments
	 *            are specified in the <code>test</code> expression an array of
	 *            length 0 is passed
	 * @param expectedValue
	 *            the expected value of the property. The value is either of
	 *            type <code>java.lang.String</code> or a boxed base type. If no
	 *            value was specified in the <code>test</code> expressions then
	 *            <code>null</code> is passed
	 * 
	 * @return returns <code>true</code> if the property is equal to the
	 *         expected value; otherwise <code>false</code> is returned
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		boolean result = false;
		Admin admin = null;
		if (receiver instanceof List) {
			admin = (Admin) ((List<?>) receiver).get(0);
		} else {
			admin = (Admin) receiver;
		}
		// Current user must be the same as in the Admin admin name
		if (USER.equals(admin.getAdmin().getName())) {
			// Check with the service to see if the current user is an admin
			result = Activator.getDefault().hasTrackerStoreAdminService();
		}

		return result;
	}

}
