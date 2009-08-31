package com.verticon.tracker.fair.editor.handlers;

import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class PersonRegisteredTester extends PropertyTester {
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		
		
		if(receiver instanceof Collection){
			Collection<Person> people = (Collection<Person>)receiver;
			for (Person person : people) {//Everyperson must be registered 
				if(!isPersonRegistered( person)){
					return false;
				}
			}
			
			
			return true;
		}
		
		return false;
	}

	boolean isPersonRegistered(Person person){
		Fair fair = (Fair)person.eContainer();
		for (Exhibit exhibit : fair.exhibits()) {
			if(exhibit.getExhibitor()!=null && exhibit.getExhibitor().equals(person)){
				return true;
			}
		}
		return false;
	}
}
