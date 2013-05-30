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
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.TrackerStoreUtils;
import com.verticon.tracker.store.ui.Activator;
import com.verticon.ui.dialogs.DateDialog;

public class ImportPremisesWizardPage extends WizardNewFileCreationPage {

	private Text premisesID;
	private Text fromDate;
	private Text toDate;

	public ImportPremisesWizardPage(String pageName,
			IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); // NON-NLS-1
		setDescription("Imports a Premises from the TrackerStore into the workspace."); // NON-NLS-1
		setFileExtension("premises");
		setFileName("importedPremises");
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
		final Composite premisesSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.FILL_HORIZONTAL);
		premisesSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		premisesSelectionArea.setLayout(fileSelectionLayout);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		Label label = new Label(premisesSelectionArea, SWT.LEFT);
		label.setText("Enter the Premises identification number, begining and ending dates of the animal events");
		label.setLayoutData(gridData);

		// Pin
		label = new Label(premisesSelectionArea, SWT.LEFT);
		label.setText("pin:");
		label.setToolTipText("Premises Identification Number");
		premisesID = new Text(premisesSelectionArea, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		premisesID.setLayoutData(gridData);
		premisesID.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		// From date
		label = new Label(premisesSelectionArea, SWT.LEFT);
		label.setText("begining date:");
		label.setToolTipText("Begining of the animal event history timespan");
		fromDate = new Text(premisesSelectionArea, SWT.SINGLE | SWT.BORDER);
		Button button = new Button(premisesSelectionArea, SWT.PUSH);
		button.setText("set");
		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				callDateDialog(fromDate);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
				callDateDialog(fromDate);
			}

		});
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		fromDate.setLayoutData(gridData);
		fromDate.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		// To date
		label = new Label(premisesSelectionArea, SWT.LEFT);
		label.setText("ending date:");
		label.setToolTipText("End of the animal event history timespan");
		toDate = new Text(premisesSelectionArea, SWT.SINGLE | SWT.BORDER);
		Button button2 = new Button(premisesSelectionArea, SWT.PUSH);
		button2.setText("set");
		button2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				callDateDialog(toDate);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
				callDateDialog(toDate);
			}

		});
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		toDate.setLayoutData(gridData);
		toDate.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		premisesSelectionArea.moveAbove(null);

	}

	private void callDateDialog(Text text) {
		DateDialog dateDialog = new DateDialog(getShell(),
				ITrackerStore.DATE_PATTERN);
		if (dateDialog.open() == Window.OK) {
			text.setText(dateDialog.getDateTime());

		}
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
		String pin = premisesID.getText();
		ITrackerFind trackerStore = Activator.getDefault()
				.getTrackerStoreService();
		URI uri = createURI();
		TrackerStoreUtils.retrieveAndImportPremises(pin, trackerStore, uri,
				fromDate.getText(), toDate.getText());
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

	String getPremisesID() {
		return premisesID.getText();
	}

	private void updatePageComplete() {
		setPageComplete(false);
		setPageComplete(getPremisesID() != null && createURI() != null
				&& !createURI().isEmpty());
	}
}
