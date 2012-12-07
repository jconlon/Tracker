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
package com.verticon.tracker.editor.presentation;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.TrackerEditorUtils;

/**
 * Wizard for adding a template animal document to one or more animals.
 * 
 * Pages: 1. Select the Animal document to use as a template
 * 
 * @author jconlon
 * 
 */
public class AddTemplateToAnimalsWizard extends Wizard {

	private static final String MODIFY_WIZARD_TITLE = "Add Template To Animals";
	private static final String MODIFY_EVENTS_WIZARD = "ModifyEventsWizard";
	private Collection<Animal> selectedAnimals;
	private IEditorPart editor;
	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;
	private IProject projectWithTemplate;

	public AddTemplateToAnimalsWizard() {
		IDialogSettings trackerSettings = TrackerReportEditorPlugin.getPlugin()
				.getDialogSettings();
		IDialogSettings wizardSettings = trackerSettings
				.getSection(MODIFY_EVENTS_WIZARD);
		if (wizardSettings == null) {
			wizardSettings = trackerSettings
					.addNewSection(MODIFY_EVENTS_WIZARD);
		}
		setDialogSettings(wizardSettings);
	}

	public void init(IEditorPart editor,
			ISelection selection) throws PartInitException {
		selectedAnimals = TrackerEditorUtils.getSelectedAnimals(selection);
		this.editor = editor;
		this.projectWithTemplate = TrackerEditorUtils.getProject(editor);
	}

	@Override
	public boolean canFinish() {
		return selectAnimalDocumentWizardPage.isPageComplete();
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		if(projectWithTemplate==null){
			selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage(true);
			
		}else{
			selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage(false);
		}
		addPage(selectAnimalDocumentWizardPage);
		selectAnimalDocumentWizardPage.init(projectWithTemplate);
	}

	@Override
	public boolean performFinish() {
		TrackerEditorUtils.addTemplateToAnimals(selectedAnimals, selectAnimalDocumentWizardPage
				.getTemplateBean(), editor);
		// Refresh the current viewer
		IViewerProvider viewerProvider = (IViewerProvider)editor.getAdapter(IViewerProvider.class);
		if(viewerProvider !=null){
			viewerProvider.getViewer().refresh();
		}

		return true;
	}

}
