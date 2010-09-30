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
package com.verticon.tracker.export.wlic.presentation;

class NoLastReportState implements State {

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPageComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(SelectExportDateRangeWizardPage page) {
		//This state is transitional, set up the startTime of Report
		page.setStartTimeOfReportToCalendarOfEarliestEvent();
		
		
		if(page.getEventsToReport()==0){
			page.currentState=page.invalidReportDefinition;
		}else{
			page.currentState=page.validReportDefinition;
		}

	}

}
