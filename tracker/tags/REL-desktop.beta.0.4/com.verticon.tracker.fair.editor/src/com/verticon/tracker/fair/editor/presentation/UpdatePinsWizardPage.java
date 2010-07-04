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
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * First page of the UpdatePinsWizard that is called from People elements.
 * 
 * @author jconlon
 * 
 */
class UpdatePinsWizardPage extends WizardPage {
	
	private Button movedInButton;
	private Button movedOutButton;

	/**
	 * Displays the Person, the Lot, and the animal and asks confirmation
	 * to create the Exhibit
	 */
	protected UpdatePinsWizardPage() {
		super("updatePins");
		setTitle("Update Premises ID");
		setDescription("Update the PremisesId attribute on movedIn and/or movedOut events.");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);
		setControl(container);
		createMovedInUI(container);
		createMovedOutUI(container);
		setMessage(null);
		setErrorMessage(null);
		setPageComplete(true);
	}
	

	protected boolean updateMovedIn(){
		return movedInButton.getSelection();
	}
	
	protected boolean updateMovedOut(){
		return movedOutButton.getSelection();
	}
	
	/**
	 * @param container
	 */
	private void createMovedInUI(Composite container) {
		Label label = new Label(container, SWT.NULL);
		label.setText("Update all MovedIn Pins: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));

		movedInButton = new Button(container, SWT.CHECK);
		movedInButton.setText("Update");
		movedInButton.setSelection(true);
		movedInButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePageComplete();
			}

		});
	}
	
	
	/**
	 * @param container
	 */
	private void createMovedOutUI(Composite container) {
		Label label = new Label(container, SWT.NULL);
		label.setText("Update all MovedOut Pins: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));

		movedOutButton = new Button(container, SWT.CHECK);
		movedOutButton.setText("Update");
		movedOutButton.setSelection(true);
		movedOutButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePageComplete();
			}

		});
	}
	
	
	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);
		
		if (!movedInButton.getSelection() && !movedOutButton.getSelection()) {
			setMessage(null);
			setErrorMessage("Please enable Pin updates for either MovedIn or MovedOut events.");
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}
	
	

}
