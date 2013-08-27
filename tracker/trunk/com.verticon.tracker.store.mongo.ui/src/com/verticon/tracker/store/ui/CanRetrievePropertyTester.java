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

import org.eclipse.core.expressions.PropertyTester;

public class CanRetrievePropertyTester extends PropertyTester {

	private static final String CAN_RETRIEVE_ANIMALS = "canRetrieveAnimals";
	private static final String CAN_RETRIEVE_PREMISES = "canRetrievePremises";

	/**
	 * 
	 * For premises retrievals tests if user is in the premises or the Retrieve
	 * Global Group.
	 * 
	 * For animal retrievals test if the user is authorized.
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

		boolean results = false;
		if (CAN_RETRIEVE_PREMISES.equals(property)) {
			results = Activator.getDefault().isAuthenticatedUser();
		} else if (CAN_RETRIEVE_ANIMALS.equals(property)) {
			results = Activator.getDefault().isAuthenticatedUser();
		}
		results = results
				|| Activator.getDefault().hasMQTTTrackerStoreService();
		return results;
	}

}
