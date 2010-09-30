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
class DocumentHasNoEventsState implements State {

	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.presentation.State#getErrorMessage()
	 */
	public String getErrorMessage() {
		return "The Premises Document has no events to report.";
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
	 * @see com.verticon.tracker.export.wlic.presentation.State#update()
	 */
	public void update(SelectExportDateRangeWizardPage page) {
		page.disableReportHistory();
		page.disableDateTimeControls();
		page.disableDocument();
	}

}
