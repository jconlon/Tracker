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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
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
	private static final String APPEND_INSTRUCTION = 
		"\n\nThe Add Reader Wizard looks for animal template files inside the project associated with the active editor."+
		" To add a Reader, make sure that the active editor has opened a file from a project that contains at least one animal template file.";
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
		projectWithTemplate = hasTemplates( workbench);
		if(projectWithTemplate==null){
			throw new PartInitException("Could not find any animal templates in the active editor's project."+APPEND_INSTRUCTION);
		}
		this.workbench = workbench;
	}
	
	private IProject hasTemplates(IWorkbench iworkbench)throws PartInitException {
		IProject result = null;
		//Project
		if (iworkbench != null){
			IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
				if (iworkbenchwindow != null){
						IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
							if (iworkbenchpage != null){
								IEditorPart editor = iworkbenchpage.getActiveEditor();
								if(editor ==null){
									throw new PartInitException("Could not find an active editor."+APPEND_INSTRUCTION);
								}else{
									IResource resource = TrackerEditorUtils.extractResource(editor);
									if(resource == null){
										throw new PartInitException("Could not find any resources in the active editor."+APPEND_INSTRUCTION);
									}else{
										IProject project = resource.getProject();
										TemplateVisitor visitor = new TemplateVisitor();
										try {
											project.accept(visitor);
											result = visitor.foundTemplate?project:null;
										} catch (CoreException e) {
											throw new PartInitException(e.getLocalizedMessage());
										}
									}

								}

							}
				}
		}

		return result;
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
		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
		selectAnimalDocumentWizardPage.setTitle("Select an Animal Document to use as a template for the Event Publisher");
		addPage(selectAnimalDocumentWizardPage);
		selectAnimalDocumentWizardPage.init(projectWithTemplate);

		publisherWizardSelection = new EventReaderWizardSelectionPage(
				"Select Event Reader", workbench);
		addPage(publisherWizardSelection);
	}
	
	private class TemplateVisitor implements IResourceVisitor{
		boolean foundTemplate = false;
		@Override
		public boolean visit(IResource resource) throws CoreException {
			if(resource.getFileExtension()!=null && resource.getFileExtension().equals("animal")){
				foundTemplate = true;
			}
			return !foundTemplate;
		}
		
	}

}
