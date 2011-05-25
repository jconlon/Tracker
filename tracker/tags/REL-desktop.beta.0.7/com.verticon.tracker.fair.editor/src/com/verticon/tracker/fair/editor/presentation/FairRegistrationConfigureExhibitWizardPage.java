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


import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.YoungPerson;

class FairRegistrationConfigureExhibitWizardPage extends BaseConfigureExhibitWizardPage  {

	protected FairRegistrationConfigureExhibitWizardPage(Fair  fair) {
		super("selectLot", fair);
		setTitle("Select Lot");
		setDescription("Select the Lot to assign the Exhibit");
	}

	protected Lot validate(Lot lot)throws Exception{
		if(((FairRegistrationWizard)getWizard()).getSelectedPerson() instanceof YoungPerson){
			
		}else{
			//Can't someone that is not a YoungPerson register for a youth fair
			String nameOfDivision = lot.getClass_().getDepartment().getDivision().getName();
			if(nameOfDivision.equals("Youth")) {
				throw new Exception("Can't register the Person "+
						((FairRegistrationWizard)getWizard()).getSelectedPerson().getName()+ 
						" to a Youth Division. Select a YoungPerson or different Lot instead.");
			}
		}
		
		return lot;
	}
}
