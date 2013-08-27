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

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;

import com.google.common.base.Strings;
import com.verticon.tracker.Premises;

public class CanPublishAnimalsPropertyTester extends PropertyTester {

	private static final String CAN_PUBLISH_ANIMALS = "canPublishAnimals";

	/**
	 * 
	 * Tests a Premises to see if there is a ITrackerLoader service available
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
		if (CAN_PUBLISH_ANIMALS.equals(property)) {
			Premises premises = null;
			if (receiver instanceof List) {
				premises = (Premises) ((List<?>) receiver).get(0);
			} else {
				premises = (Premises) receiver;
			}

			String uri = premises.getUri();
			if (!Strings.isNullOrEmpty(uri)) {

				// Tracker Store service with this uri and a member of the
				// premises
				result = Activator.getDefault().hasTrackerStoreService()
						&& Activator.getDefault().hasRole(uri);
				result = result
						|| Activator.getDefault().hasMQTTTrackerStoreService();
			}
		}

		return result;
	}

}
