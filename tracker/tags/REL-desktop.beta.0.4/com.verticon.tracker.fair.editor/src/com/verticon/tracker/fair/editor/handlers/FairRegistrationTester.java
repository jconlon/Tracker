/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.editor.handlers;

import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;

public class FairRegistrationTester extends PropertyTester {

	private static final String NOT_FAIR_REGISTION_SELECTION = "notFairRegistionSelection";
	private static final String IS_FAIR_REGISTION_SELECTION = "isFairRegistionSelection";

	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {   
		boolean result = false;
		if(receiver instanceof Collection<?> && !((Collection<?>)receiver).isEmpty() ){
			Collection<?> selection = (Collection<?>)receiver;
			result = FairRegistrationSelection.instance(selection).isValidRegistration();
		}
		
		if(IS_FAIR_REGISTION_SELECTION.equals(property)){
			return result;
		}else
		if(NOT_FAIR_REGISTION_SELECTION.equals(property)){
			
			return !result;
		}
		return false;
	}

}
