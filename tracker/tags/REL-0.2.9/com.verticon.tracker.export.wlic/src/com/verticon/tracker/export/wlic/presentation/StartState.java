/**
 * 
 */
package com.verticon.tracker.export.wlic.presentation;

/**
 * @author jconlon
 *
 */
public class StartState implements State {

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getErrorMessage()
	 */
	public String getErrorMessage() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getMessage()
	 */
	public String getMessage() {
		return "Starting...";
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
		
		
		if(page.getNumberOfValidEventsInDocument()==0){
			page.currentState =page.documentHasNoEvents;
			return;
			
		} else if(page.hasLastReport()){
			page.currentState =page.hasLastReport;
			
		}else{
			page.disableReportHistory();
			page.currentState =page.noLastReport;
			
		}
			
		

	}

}
