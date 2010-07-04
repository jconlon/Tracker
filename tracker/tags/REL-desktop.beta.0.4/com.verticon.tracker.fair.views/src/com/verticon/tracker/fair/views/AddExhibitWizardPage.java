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
package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;

/**
 * The WizardPage for creating an Exhibit. This page is the last page of
 * AddExhibitWizardPageParent WizardPages. It uses the callback functions of
 * AddExhibitWizardPageParent to call up to it's immediate parent WizardPage.
 * 
 * @see AddExhibitWizardPageParent#getCommand(EObject)
 * @author jconlon
 */
public class AddExhibitWizardPage extends WizardPage implements
		AddExhibitWizardPageParent {
	final IObservableValue createAnExhibit = new WritableValue(null, Boolean.class);
	final Fair fair;
	final AddExhibitWizardPageParent parentPage;
	
	private final class SingleDigitValidator implements IValidator {
		public IStatus validate(Object value) {
			Boolean i = (Boolean) value;
			if (!i) {
				return ValidationStatus.info("Please check selection to create a Exhibit.");
			}
			
			return ValidationStatus.ok();
		}
	}

	protected AddExhibitWizardPage(Fair fair, AddExhibitWizardPageParent parent) {
		super("Exhibit", "Add an Exhibit", null);
		this.fair = fair;
		this.parentPage = parent;
	}

	public void createControl(Composite parent) {
		DataBindingContext dbc = new DataBindingContext();
		WizardPageSupport.create(this, dbc);
		Composite composite = new Composite(parent, SWT.NONE);
		Label label = new Label(composite, SWT.NONE);
		label.setText("Create an Exhibit:");
		
	    Button createButton = new Button(composite, SWT.CHECK);

		dbc.bindValue(SWTObservables.observeSelection(createButton),
				createAnExhibit, new UpdateValueStrategy()
				.setAfterConvertValidator(new SingleDigitValidator()),
				null);

		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(composite);
		setControl(composite);
	}

	public Command getCommand(EObject child) {
		if (newTargetHasValue()) {
			Exhibit exhibit = FairFactory.eINSTANCE.createExhibit();
			return parentPage.getCommand(exhibit);
		}
		return parentPage.getCommand(null);
	}

	public boolean newTargetHasValue() {
		if (createAnExhibit.getValue() == null) {
			return false;
		}
		return (Boolean) createAnExhibit.getValue();
	}

	public IObservableValue getSelectedTarget() {
		return null;
	}
}