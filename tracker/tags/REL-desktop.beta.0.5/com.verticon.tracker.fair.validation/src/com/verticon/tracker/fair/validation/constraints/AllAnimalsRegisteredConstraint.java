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
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;

public class AllAnimalsRegisteredConstraint extends AbstractModelConstraint {

	
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Animal) {
				Animal animal = (Animal) eObj;
				if(animalNeedsToBeRegistered(animal)){
					
					return ctx.createFailureStatus(new Object[] { animal });
				}
			}
		} 
		
		return ctx.createSuccessStatus();

	}

	private boolean animalNeedsToBeRegistered(Animal animal){
		boolean animalNeedsToBeRegistered = false;
		if(animal.eResource()!=null && animal.eResource().getResourceSet()!=null){
			ResourceSet rs = animal.eResource().getResourceSet();
			Fair fair = getFair(rs);
			if(fair != null){
				animalNeedsToBeRegistered = true;
				for (Exhibit exhibit : fair.exhibits()) {
					if(animal.equals(exhibit.getAnimal())){
						animalNeedsToBeRegistered = false;
						break;
					}
				}
			}
		}
		return animalNeedsToBeRegistered;
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
