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

package com.verticon.tracker.editor.presentation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.TrackerPackage;

/**
 * SelectModifyEventsValuesPage is the Last page of the ModifyEventsWizard 
 * that allows the user to specify
 * the values for the event attributes selected on the previous 
 * SelectEventAttributesWizardPage page.
 * 
 * @see SelectEventAttributesWizardPage
 * @see ModifyEventsWizard
 * @author jconlon
 * 
 */
class SelectModifyEventsValuesPage extends WizardPage {

	private Text commentsField;
	private Collection<EAttribute> selectedAttributes;
	private Composite container;
	private Button correctionButton;
	private Button electrionicReadButton;

	
	public SelectModifyEventsValuesPage() {
		super("selectValues");
		setTitle("Select Attribute Values");
		setDescription("Select the values for the Event attributes");
	}

	

	/**
	 * Creates the top level control for this dialog page under the given parent
	 * composite, then calls <code>setControl</code> so that the created
	 * control can be accessed via <code>getControl</code>
	 * 
	 * @param parent
	 *            the parent composite
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		setControl(container);

		createCorrection(container);

		createElectronicRead(container);

		createComments(container);

	}

	/**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		commentsField.setEnabled(false);
		if (visible) {
			selectedAttributes = ((ModifyEventsWizard) getWizard())
					.getSelectionAttributes();
			if (selectedAttributes.contains(TrackerPackage.eINSTANCE
					.getEvent_Comments())) {
				commentsField.setEnabled(true);
			}
			if (selectedAttributes.contains(TrackerPackage.eINSTANCE
					.getEvent_Correction())) {
				correctionButton.setEnabled(true);
			}
			if (selectedAttributes.contains(TrackerPackage.eINSTANCE
					.getEvent_ElectronicallyRead())) {
				electrionicReadButton.setEnabled(true);
			}
		}
		super.setVisible(visible);
	}

	/**
	 * @param container
	 */
	private void createComments(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		final GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		label.setLayoutData(gridData);
		label.setText("Set the Event comments.");

		final Label label_1 = new Label(container, SWT.NONE);
		final GridData gridData_1 = new GridData(GridData.HORIZONTAL_ALIGN_END);
		label_1.setLayoutData(gridData_1);
		label_1.setText("Comments:");

		commentsField = new Text(container, SWT.BORDER);
		commentsField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		commentsField.setEnabled(false);

	}

	/**
	 * @param container
	 */
	private void createCorrection(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		final GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		label.setLayoutData(gridData);
		label.setText("Specify if this is an event Correction.");
		correctionButton = new Button(container, SWT.CHECK);
		correctionButton.setText("isCorrection");
		correctionButton.setEnabled(false);

	}

	/**
	 * @param container
	 */
	private void createElectronicRead(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		final GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		label.setLayoutData(gridData);
		label.setText("Specify if this event was Electronically Read.");

		electrionicReadButton = new Button(container, SWT.CHECK);
		electrionicReadButton.setText("isElectrionicallyRead");
		electrionicReadButton.setEnabled(false);

	}

	

	public Map<EAttribute, Object> getChangesToMakeOnSelectedEvents() {
		Map<EAttribute, Object> result = new HashMap<EAttribute, Object>();
		for (EAttribute attribute : selectedAttributes) {
			if (attribute == TrackerPackage.eINSTANCE.getEvent_Comments()) {
				result.put(attribute, commentsField.getText());
			}
			if (attribute == TrackerPackage.eINSTANCE.getEvent_Correction()) {
				result.put(attribute, correctionButton.getSelection());
			}
			if (attribute == TrackerPackage.eINSTANCE
					.getEvent_ElectronicallyRead()) {
				result.put(attribute, electrionicReadButton.getSelection());
			}

		}
		return result;
	}
}
