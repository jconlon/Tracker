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
package com.verticon.tracker.validation.core.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.verticon.tracker.Tag;

public class NonNumberIdConstraint 
	extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			String id = null;
			if (eObj instanceof Tag) {
				id = ((Tag)eObj).getId();
			} 
			
			if (id == null || id.length() == 0) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
			try {
				Long.decode(id);
			} catch (NumberFormatException e) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
		// In the case of live mode.
		} else {
			Object newValue = ctx.getFeatureNewValue();
			
			if (newValue == null
				|| ((String)newValue).length() == 0) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
			try {
				Long.decode((String)newValue);
			} catch (NumberFormatException e) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
