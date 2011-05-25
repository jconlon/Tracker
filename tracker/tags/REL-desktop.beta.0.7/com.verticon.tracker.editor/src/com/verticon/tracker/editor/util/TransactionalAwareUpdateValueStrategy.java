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
/**
 * 
 */
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UpdateValueStrategy for EMF model elements where OCL Constraints are used
 * and Transaction Roll backs are possible.
 * @author jconlon
 *
 */
final class TransactionalAwareUpdateValueStrategy extends 
  EMFUpdateValueStrategy implements IValidationListener{
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TransactionalAwareUpdateValueStrategy.class);
	private int validationStatus = IStatus.OK;
	private IStatus validationIStatus = null;
	
	/**
	 * Reference to the Binding of this strategy.  This is a workaround to 
	 */
	private Binding binding;

	

	void setBinding(Binding binding) {
		this.binding = binding;
	}

	
	/**
	 * Detects ModelValidation Errors and transaction roll backs to the 
	 * during a set.  Detection will specify to the bindings that 
	 * an update from the model to the target is necessary.
	 */
	@Override
	protected IStatus doSet(IObservableValue observableValue, Object value) {
		ModelValidationService.getInstance().addValidationListener(this);
		validationStatus = IStatus.OK;
		validationIStatus = null;
		IStatus result = super.doSet(observableValue, value);
		ModelValidationService.getInstance().removeValidationListener(this);
		if (this.validationStatus!=IStatus.OK) {
			logger.debug(bundleMarker,"Failed to validate {}  because {}",value, validationIStatus.getMessage());
			//Write the results to the status label
				result = validationIStatus;
				binding.updateModelToTarget();
		}
		 
		return result;
	}

	public void validationOccurred(ValidationEvent event) {
		if(event.getSeverity()!=IStatus.OK){
			this.validationStatus = event.getSeverity();
			List<IConstraintStatus> statuses = event.getValidationResults();
			IStatus[] children = statuses.toArray(new IStatus[statuses.size()]);
			IStatus worst = children[0];
			for (int i = 1; i < children.length; i++) {
				if (children[i].getSeverity() > worst.getSeverity()) {
					worst = children[i];
				}
			}
			
			validationIStatus = new MultiStatus(
					worst.getPlugin(),
					worst.getCode(),
					children,
					worst.getMessage(),
					null);  // the child status will have it (save on log space)
			
		}
		
	}

	
	
	
}