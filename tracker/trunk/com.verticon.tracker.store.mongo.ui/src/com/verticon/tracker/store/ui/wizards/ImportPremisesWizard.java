/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.store.ui.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.google.common.base.Strings;
import com.verticon.tracker.store.ui.Activator;

public class ImportPremisesWizard extends Wizard implements IImportWizard {

	private ImportPremisesWizardPage mainPage;

	public ImportPremisesWizard() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		URI uri = null;
		try {
			uri = mainPage.createImportedResource();

		} catch (Exception e) {
			mainPage.setErrorMessage("Failed to import "
					+ mainPage.getPremisesID() + ": " + e.getMessage());
			return false;
		}
		MessageDialog.openInformation(getShell(), "Imported Premises",
				"Imported premises " + mainPage.getPremisesID() + " from "
						+ Activator.getDefault().getTrackerStoreService().uri()
						+ " to " + uri);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("TrackerStore Premises Import Wizard"); // NON-NLS-1
		setNeedsProgressMonitor(true);
		// trackerStorePage = new SelectTrackerStorePage();
		mainPage = new ImportPremisesWizardPage("Import Premises", selection); // NON-NLS-1
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		if (!Activator.getDefault().hasTrackerStoreService()) {
			addPage(new ErrorWizardPage(
					"Import Premises",
					"Can't import premises - No Tracker Store Service",
					"Can't import premises! There is no active Tracker Store Service. Please Configure one and try again."));
		} else if (!Activator.getDefault().isAuthenticatedUser()) {
			addPage(new ErrorWizardPage(
					"Import Premises",
					"Can't import premises - You are not signed on",
					"Can't import premises! You are not an authenticated user. Please Sign On and try again."));
		} else {
			// addPage(trackerStorePage);
			addPage(mainPage);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return !Strings.isNullOrEmpty(mainPage.getPremisesID())
				&& mainPage.getFileName() != null;
	}

}
