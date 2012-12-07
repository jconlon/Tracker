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
package com.verticon.tracker.fair.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;

public class AnimalsRegisteredWithPinsConstraint extends AbstractModelConstraint {

	
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Animal) {
				Animal animal = (Animal) eObj;
				String exhibitorsPin = getAnimalExhibitorsPin(animal);
				if(needsMoveInAndMoveOutWithPins( animal,  exhibitorsPin)){
					
					return ctx.createFailureStatus(new Object[] { animal, exhibitorsPin });
				}
			}
		} 
		
		return ctx.createSuccessStatus();

	}
	
	/**
	 * 
	 * @param animal
	 * @param pin
	 * @return true if at least one movedIn sourcePin and one movedOut destinationPin equals pin
	 */
	private boolean needsMoveInAndMoveOutWithPins(Animal animal, String pin){
		
		if(pin ==null){
			return false;
		}
		boolean needsMovedInPinSet = true;
		boolean needsMovedOutPinSet = true;
		for (Event event : animal.eventHistory()) {
			if(event instanceof MovedIn && needsMovedInPinSet){
				needsMovedInPinSet = !pin.equals(((MovedIn)event).getSourcePin());
			}
			else
			if(event instanceof MovedOut && needsMovedOutPinSet){
					needsMovedOutPinSet = !pin.equals(((MovedOut)event).getDestinationPin());
			}
				
		}
		
		
		return needsMovedInPinSet || needsMovedOutPinSet;
	}

	private String getAnimalExhibitorsPin(Animal animal){
		String exhibitorsPin = null;
		if(animal.eResource()!=null && animal.eResource().getResourceSet()!=null){
			ResourceSet rs = animal.eResource().getResourceSet();
			Fair fair = getFair(rs);
			if(fair != null){
				for (Exhibit exhibit : fair.exhibits()) {
					if(animal.equals(exhibit.getAnimal())){
						exhibitorsPin = exhibit.getExhibitor().getPin();
						break;
					}
				}
			}
		}
		return exhibitorsPin;
	}
	

	 private Fair getFair(ResourceSet resourceSet) {
		Resource modelResource = resourceSet
		.getResources().get(0);
		EObject eObject = modelResource.getContents().get(0);
		if(eObject instanceof Fair){
			return (Fair)eObject;
		}
		return null;
	}
}
