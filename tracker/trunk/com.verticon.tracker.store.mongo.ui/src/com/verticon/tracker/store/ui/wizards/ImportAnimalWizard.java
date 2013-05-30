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

public class ImportAnimalWizard extends Wizard implements IImportWizard {

	private ImportAnimalWizardPage mainPage;

	public ImportAnimalWizard() {
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
					+ mainPage.getAnimalID() + ": " + e.getMessage());
			return false;
		}
		MessageDialog.openInformation(getShell(), "Imported Animal",
				"Imported " + mainPage.getAnimalID() + " from "
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
		setWindowTitle("TrackerStore Animal Import Wizard"); // NON-NLS-1
		setNeedsProgressMonitor(true);
		// trackerStorePage = new SelectTrackerStorePage();
		mainPage = new ImportAnimalWizardPage("Import Animal", selection); // NON-NLS-1
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
					"Import Animal",
					"Can't import animal - No Tracker Store Service!",
					"Can't import animal! There is no active Tracker Store Service. Please go to the Configure menu, and configure a Tracker Store and try again."));
		} else if (!Activator.getDefault().isAuthenticatedUser()) {
			addPage(new ErrorWizardPage(
					"Import Animal",
					"Can't import animal - You are not an authenticated user!",
					"Can't import animal! You are not signed on as an authenticated user. Please go to the User menu, sign on and try again."));
		} else {
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
		return !Strings.isNullOrEmpty(mainPage.getAnimalID())
				&& mainPage.getFileName() != null;
	}

}
