package com.verticon.tracker.export.wlic.presentation;

public class HasLastReportState implements State {

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
		page.setStartTimeOfReportToCalendarOfLastReport();
		
		
		if(page.getEventsToReport()==0){
			page.currentState=page.invalidReportDefinition;
		}else{
			page.currentState=page.validReportDefinition;
		}

	}

}
