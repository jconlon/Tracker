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
package com.verticon.tracker.export.wlic.presentation;


/**
 * @author jconlon
 *
 */
class InitializationErrorState implements State {

	private final Exception initializationError;
	
	protected InitializationErrorState(Exception initializationError) {
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
