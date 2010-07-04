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
package com.verticon.tracker.fair.poi.presentation;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.verticon.tracker.fair.poi.presentation.ExportXlsWizard.ExportType;


/**
 * SelectExportTypeWizardPage is the first page of the ExportXlsWizard 
 * that allows the user to specify
 * the data export type.
 * 
 * @see  SelectExportFilePathWizardPage
 * @see ExportXlsWizard
 * @author jconlon
 * 
 */
class SelectExportTypeWizardPage extends WizardPage {
	
	
	private ExportXlsWizard wizard;
	private Button[] radios;


	
	public SelectExportTypeWizardPage() {
		super("Select Type");
		setTitle("Select Type of Export");
		setDescription("Select the type of Export Report");

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
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns=1;
		container.setLayout(layout);
		setControl(container);
		Listener radioGroup = new Listener () {
		    public void handleEvent (Event event) {
		      wizard.setTypeToExport((ExportType)event.widget.getData());
		    }
		  };
		radios = new Button[ExportType.values().length];
		for (ExportType column : ExportType.values()){
			radios[column.ordinal()] = new Button(container, SWT.RADIO);
		    radios[column.ordinal()].setText(column.nameOfReport);
		    radios[column.ordinal()].setToolTipText(column.description);
		    radios[column.ordinal()].setData(column);
		    radios[column.ordinal()].addListener(SWT.Selection, radioGroup);
		}
		radios[ExportType.FAIR_SUMMARY.ordinal()].setSelection(true);

	}
	
	
	 /**
	 * Update the content before becoming visible.
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			wizard = (ExportXlsWizard) getWizard();
			for (Button button : radios) {
				if(button.getData()==wizard.getTypeToExport()){
					button.setSelection(true);
				}else{
					button.setSelection(false);
				}
			}
			
		}
		super.setVisible(visible);
	}

}
