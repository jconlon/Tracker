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

import static com.verticon.osgi.useradmin.authenticator.Authenticator.TRACKER_STORE_REGISTRANT;

import org.eclipse.core.expressions.PropertyTester;

/**
 * To register premesis the following must be true:
 * <ul>
 * <li>An ITrackerLoader service is available</li>
 * <li>and the signed in User is a member of the group TrackerStore_Registrant</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class CanRegisterPremisesPropertyTester extends PropertyTester {

	private static final String CAN_REGISTER_PREMISES = "canRegisterPremises";

	/**
	 * 
	 * Tests to see if there is a ITrackerStore and a the user has is a member
	 * of the group: TrackerStore_Registrant
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
		if (CAN_REGISTER_PREMISES.equals(property)) {
			result = Activator.getDefault().hasRole(TRACKER_STORE_REGISTRANT)
					&& Activator.getDefault().hasTrackerStoreService();
			result = result
					|| Activator.getDefault().hasMQTTTrackerStoreService();
		}
		return result;
	}

}
