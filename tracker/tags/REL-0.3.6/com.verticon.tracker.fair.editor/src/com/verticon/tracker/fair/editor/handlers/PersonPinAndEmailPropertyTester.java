package com.verticon.tracker.fair.editor.handlers;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.tracker.fair.Person;

public class PersonPinAndEmailPropertyTester extends PropertyTester {

	enum Tests {hasPin, hasEmail};
	
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		Person person = (Person)receiver;
		switch (Tests.valueOf(property)) {
		case hasPin:
			boolean isSet = person.isSetPin();
			return isSet;
		case hasEmail:
			return person.getEmail()!=null;
		default:
			return false;
		}
	}

}
