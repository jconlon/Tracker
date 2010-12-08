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
package com.verticon.tracker.reader.handlers;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.views.ReaderViewPart;
import com.verticon.tracker.reader.wizards.AddEventReaderWizard;

public class AddTagIDReaderHandler extends AbstractHandler{

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AddTagIDReaderHandler.class);
	/**
	 * Open the Readers view.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Get the active window

		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		if (window == null)
			return null;

		// Get the active page

		IWorkbenchPage page = window.getActivePage();
		if (page == null)
			return null;

		// Start the addEventReader Wizard
		try {
			ReaderViewPart viewer = (ReaderViewPart) page.showView(ReaderViewPart.ID);
			AddEventReaderWizard addWizard = new AddEventReaderWizard(viewer.getModel());
			addWizard.init(window.getWorkbench());
			WizardDialog dialog = new WizardDialog(window.getShell(),addWizard);
			dialog.open();
		} catch (PartInitException e) {
			logger.error(bundleMarker,"Failed to open the Readers view", e);
			ErrorDialog.openError(window.getShell(), "Add Reader Problems", //$NON-NLS-1$
					null, // no special message
					((PartInitException) e).getStatus());
		}
		
		return null;
	}

}
