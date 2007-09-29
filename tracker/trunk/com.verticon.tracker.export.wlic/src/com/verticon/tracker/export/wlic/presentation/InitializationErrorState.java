/**
 * 
 */
package com.verticon.tracker.export.wlic.presentation;


/**
 * @author jconlon
 *
 */
public class InitializationErrorState implements State {

	private final Exception initializationError;
	
	public InitializationErrorState(Exception initializationError) {
		this.initializationError=initializationError;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getErrorMessage()
	 */
	public String getErrorMessage() {
		String message = initializationError.getMessage()==null?initializationError.toString():
			initializationError.getMessage();
		return "Could not initialized because "+ message;
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
		page.disableReportHistory();
		page.disableDateTimeControls();
		page.disableDocument();
	}

}
