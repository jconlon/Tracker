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
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.util.FairSwitch;
import com.verticon.tracker.util.TrackerSwitch;

public class FairRegistrationSelection extends FairSwitch<Object> {
	
	private final Collection<Animal> selectedAnimals = new HashSet<Animal>();

	private Lot selectedLot = null;
	private Person selectedPerson = null;
	private Object unwantedObject = null;
	
	
	
	private FairRegistrationSelection(Collection<?> collection) {
		super();
		processSelection(collection);
	}

	/**
	 * The selection is valid if there is no unwanted object 
	 * (an unwanted object is also two Lots or two Person in the selection)
	 * and 
	 * there are animals selected 
	 * and
	 * one Lot or one Person selected.
	 * 
	 * @return
	 */
	boolean isValidRegistration(){
		if(unwantedObject!=null){
			//System.out.println(this + " returning false with unwanted object "+ unwantedObject);
			return false;
		}
		//Need a Fair
		if(getFair()==null){
			return false;
		}
		
		if(selectedAnimals.isEmpty()){
			return false;
		}
		return true;
	}
	
	
	
	public Lot getSelectedLot() {
		return selectedLot;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public Collection<Animal> getSelectedAnimals() {
		return selectedAnimals;
	}
	
	private void processSelection(Collection<?> collection){
		
		for (Object object : collection) {
			if(object instanceof EObject){
				doSwitch((EObject)object);
			}else{
				unwantedObject=object;
			}
		}
		
	}

	private final TrackerSwitch<Object> trackerVisitor = new TrackerSwitch<Object>(){

		@Override
		public Object caseAnimal(Animal object) {
			selectedAnimals.add(object);
			return Boolean.TRUE;
		}
		
		
		
		@Override
		public Object caseEvent(Event object) {
			selectedAnimals.add((Animal)object.getTag().eContainer());
			return Boolean.TRUE;
		}



		@Override
		public Object defaultCase(EObject object) {
			unwantedObject = object;
			return Boolean.TRUE;
		}
		
	};

	@Override
	public Object caseLot(Lot object) {
		if(selectedLot == null){
			selectedLot = object;
		}else{
			unwantedObject=object;
		}

		return Boolean.TRUE;
	}

	@Override
	public Object casePerson(Person object) {
		if(selectedPerson == null){
			selectedPerson = object;
		}else{
			unwantedObject=object;
		}
		return Boolean.TRUE;
	}

	@Override
	public Object defaultCase(EObject object) {
		trackerVisitor.doSwitch(object);
		return Boolean.TRUE;
	}
	
	public static FairRegistrationSelection instance(Collection<?> collection){
		return new FairRegistrationSelection(collection);
	}
	
	/**
	 * 
	 * @return fair
	 */
	public Fair getFair(){
		Fair result = null;
		
		if(getSelectedPerson() !=null){
			result= (Fair)getSelectedPerson().eContainer();
		}
		else if(getSelectedLot()!=null){
			result = (Fair)getSelectedLot().getClass_().getDepartment().getDivision().eContainer();
		}
		
		if (result==null && FairEditorTester.getFairProvider()!=null){
			result = FairEditorTester.getFairProvider().getFair();
		}
		return result;
	}
}
