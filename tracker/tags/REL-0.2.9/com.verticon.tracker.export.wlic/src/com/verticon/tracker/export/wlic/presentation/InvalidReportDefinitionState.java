/**
 * 
 */
package com.verticon.tracker.export.wlic.presentation;

/**
 * @author jconlon
 *
 */
public class InvalidReportDefinitionState implements State {

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getErrorMessage()
	 */
	public String getErrorMessage() {
		
		return "Invalid report - No events to report";
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getMessage()
	 */
	public String getMessage() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#isPageComplete()
	 */
	public boolean isPageComplete() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#update(com.verticon.tracker.export.wlic.presentation.SelectExportDateRangeWizardPage)
	 */
	public void update(SelectExportDateRangeWizardPage page) {
		if(page.getEventsToReport()>0){
			page.currentState=page.validReportDefinition;
		}

	}

}
