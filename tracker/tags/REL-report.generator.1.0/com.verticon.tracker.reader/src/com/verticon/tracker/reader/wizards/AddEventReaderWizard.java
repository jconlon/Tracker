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
package com.verticon.tracker.reader.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;

import com.verticon.tracker.editor.presentation.SelectAnimalDocumentWizardPage;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderWizard;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.reader.views.ReaderViewModel;

/**
 * Wizard for adding an EventReader to the Reader Views.
 * 
 * Pages: 1. Select the Animal document to use as a template 2. Select the file
 * to Tail new TagIds
 * 
 * 
 * 
 * @author jconlon
 * 
 */
public class AddEventReaderWizard extends Wizard {

	private static final String WIZARD_TITLE = "Add an Event Reader";
	private static final String WIZARD_DIALOG_TAG = "AddReaderWizard";

	private final ReaderViewModel readerViewModel;
	private IWorkbench workbench;

	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;

	private EventReaderWizardSelectionPage publisherWizardSelection;
	
	private IProject projectWithTemplate = null;

	public AddEventReaderWizard(ReaderViewModel readerViewModel) {
		super();
		this.readerViewModel = readerViewModel;
		IDialogSettings trackerSettings = ReaderPlugin.getDefault()
				.getDialogSettings();

		IDialogSettings wizardSettings = trackerSettings
				.getSection(WIZARD_DIALOG_TAG);
		if (wizardSettings == null) {
			wizardSettings = trackerSettings.addNewSection(WIZARD_DIALOG_TAG);
		}
		setDialogSettings(wizardSettings);
	}

	@Override
	public boolean canFinish() {
		AnimalTemplateBean templateBean = selectAnimalDocumentWizardPage
				.getTemplateBean();
		if (templateBean != null && templateBean.numberOfEvents() > 0) {
			publisherWizardSelection.isPageComplete();
		}

		return false;
	}

	public void init(IWorkbench workbench) throws PartInitException {
		projectWithTemplate = TrackerEditorUtils.hasTemplates( workbench);
//		if(projectWithTemplate==null){
//			throw new PartInitException("Could not find any animal templates in the active editor's project."+APPEND_INSTRUCTION);
//		}
		this.workbench = workbench;
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IFile templateFile = selectAnimalDocumentWizardPage.getSelectedFile();
		IWizardNode wizardNode = publisherWizardSelection.getSelectedNode();
		IReaderWizard publisherWizard = (IReaderWizard) wizardNode
				.getWizard();
		if (publisherWizard == null || publisherWizard.getReader() == null) {
			return false;
		}

		IReader publisher = publisherWizard.getReader();
		publisher.setTemplate(templateFile.getFullPath().toPortableString());

		readerViewModel.addReader(publisher);
		return true;
	}

	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		if(projectWithTemplate==null){
			selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage(true);
			
		}else{
			selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage(false);
		}
		selectAnimalDocumentWizardPage.setTitle("Select an Animal Document to use as a template for the Event Publisher");
		addPage(selectAnimalDocumentWizardPage);
		selectAnimalDocumentWizardPage.init(projectWithTemplate);

		publisherWizardSelection = new EventReaderWizardSelectionPage(
				"Select Event Reader", workbench);
		addPage(publisherWizardSelection);
	}
	
}
