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

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.TrackerStoreUtils;
import com.verticon.tracker.store.ui.Activator;

public class ImportAnimalWizardPage extends WizardNewFileCreationPage {

	private Text animalID;

	public ImportAnimalWizardPage(String pageName,
			IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); // NON-NLS-1
		setDescription("Imports an Animal from the TrackerStore into the workspace within a template Premises."); // NON-NLS-1
		setFileExtension("premises");
		setFileName("importedAnimal");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createAdvancedControls(Composite parent) {
		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		Label label = new Label(fileSelectionArea, SWT.LEFT);
		label.setText("Enter the animal identification number");
		label.setLayoutData(gridData);

		label = new Label(fileSelectionArea, SWT.LEFT);
		label.setText("ain:");
		animalID = new Text(fileSelectionArea, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		animalID.setLayoutData(gridData);
		animalID.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		fileSelectionArea.moveAbove(null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createLinkTarget()
	 */
	@Override
	protected void createLinkTarget() {
	}

	URI createImportedResource() throws IOException {
		String ain = animalID.getText();
		ITrackerStore trackerStore = Activator.getDefault()
				.getTrackerStoreService();
		URI uri = createURI();
		TrackerStoreUtils
				.retrieveAndSaveContainedAnimal(ain, trackerStore, uri);
		return uri;
	}

	private URI createURI() {
		IPath containerPath = getContainerFullPath();
		IPath newFilePath = containerPath.append(getFileName());
		IFile newFileHandle = createFileHandle(newFilePath);
		// return the raw file location
		String raw = newFileHandle.getLocationURI().getRawPath();
		URI uri = URI.createFileURI(raw);
		return uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getNewFileLabel()
	 */
	@Override
	protected String getNewFileLabel() {
		return "New File Name:"; // NON-NLS-1
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
	 */
	@Override
	protected IStatus validateLinkedResource() {
		return new Status(IStatus.OK, "com.verticon.tracker.store.ui",
				IStatus.OK, "", null); // NON-NLS-1 //NON-NLS-2
	}

	String getAnimalID() {
		return animalID.getText();
	}

	private void updatePageComplete() {
		setPageComplete(false);
		setPageComplete(getAnimalID() != null && createURI() != null
				&& !createURI().isEmpty());
	}
}
