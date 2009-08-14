/**
 * 
 */
package com.verticon.tracker.export.wlic.presentation;

/**
 * @author jconlon
 *
 */
interface State {
	boolean isPageComplete();
	String getMessage();
	String getErrorMessage();
	
	void update(SelectExportDateRangeWizardPage page);
}
