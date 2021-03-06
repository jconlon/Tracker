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
