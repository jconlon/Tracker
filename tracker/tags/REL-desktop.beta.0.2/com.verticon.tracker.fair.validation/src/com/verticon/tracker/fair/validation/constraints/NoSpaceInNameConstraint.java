package com.verticon.tracker.fair.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.verticon.tracker.fair.Person;

public class NoSpaceInNameConstraint extends AbstractModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.
		
		
		if (eType == EMFEventType.NULL) {
			
			
			if(eObj instanceof Person){
				String firstName = ((Person)eObj).getFirstName();
				String lastName = ((Person)eObj).getLastName();
			if (lastName == null || 
				lastName.length() == 0 ||
				lastName.matches("^.*\\s.*$")) {
					return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}else if (firstName == null || 
				firstName.length() == 0 ||
				firstName.matches("^.*\\s.*$")) {
					return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
			}
		} else{
			Object newValue = ctx.getFeatureNewValue();
			
			if (newValue == null || 
				((String)newValue).length() == 0 ||
				((String)newValue).matches("^.*\\s.*$")) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
		}

		return ctx.createSuccessStatus();
		
	}

}
