package com.verticon.tracker.fair.editor.handlers;

import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class PersonRegisteredTester extends PropertyTester {
	

	/**
	 * Must be a collection of people that are registered.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		
		
		if(receiver instanceof Collection){
			Collection<?> objects = (Collection<?>)receiver;
			for (Object object : objects) {//Everyperson must be registered 
				if(object instanceof Person){
					if(!isPersonRegistered( (Person)object)){
						return false;
					}
				}else{
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
