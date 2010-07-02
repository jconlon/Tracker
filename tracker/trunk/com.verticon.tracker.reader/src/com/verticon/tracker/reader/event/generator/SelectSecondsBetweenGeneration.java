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
package com.verticon.tracker.reader.event.generator;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

/**
 * @author jconlon
 *
 */
class SelectSecondsBetweenGeneration extends WizardPage {

	private static final String SECONDS_BETWEEN_EVENTS = "Seconds between Generated Events: ";
	int secondsBetweenGenerations;
	private Slider slider;
	Text value;
	
	protected SelectSecondsBetweenGeneration(String pageName) {
		super(pageName);
		setTitle("Rate of Event Generation");
		setDescription("Specify the number of seconds between random event generation.");
	}

	/**
	 * @return
	 */
	private int getSpecifiedRate() {
		return slider.getMaximum() - slider.getSelection() + slider.getMinimum() - slider.getThumb();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		// create the desired layout for this wizard page
		GridLayout gridLayout = new GridLayout();
		int ncol = 2;
		gridLayout.numColumns = ncol;
		composite.setLayout(gridLayout);
		
//		Label label = new Label(composite, SWT.NULL);
//	    label.setText("Seconds Between Generations:");
		
		value = new Text(composite, SWT.BORDER | SWT.SINGLE);
		value.setEditable(false);
	    
	    slider = new Slider(composite, SWT.VERTICAL);
	    slider.setBounds(0, 0, 40, 200);
	    slider.setMaximum(200);
	    slider.setMinimum(1);
	    slider.setIncrement(1);
	    slider.setPageIncrement(5);
	    
	    slider.setThumb(4);
	    
	    slider.addListener(SWT.Selection, new Listener() {
	      public void handleEvent(Event event) {
	        int perspectiveValue = getSpecifiedRate();
	        value.setText(SECONDS_BETWEEN_EVENTS + perspectiveValue);
	        secondsBetweenGenerations=perspectiveValue;
	      }

		
	    });
	    
	   
	    slider.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
	    value.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

	    value.setText(SECONDS_BETWEEN_EVENTS + getSpecifiedRate());
	    composite.pack();
	    //textUser.forceFocus();
	    setPageComplete(true);
	    setControl(composite);
	}

	public int getSecondsBetweenGenerations() {
		return secondsBetweenGenerations;
	}

}
