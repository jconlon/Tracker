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

import java.io.FileNotFoundException;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.editor.util.TagsBean;
import com.verticon.tracker.editor.util.TrackerEditorUtils;

/**
 * Wizard for adding a template animal document to a Premises
 * based on a selection of TagID files (*.tags).
 * 
 * Pages: 1. Select the Animal document to use as a template
 * 
 * @author jconlon
 * 
 */
public class AddTagIdsAndTemplateWizard extends Wizard {

	private static final String MODIFY_WIZARD_TITLE = "Add Template To Premises";
	
	private ISelection selectionOfTagIdResources;
	private IEditorPart editor;
	private Premises premises;
	private IProject projectWithTemplate;

	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;

	public void init(IEditorPart editor,
			ISelection selection, Premises premises) throws PartInitException {
		if(selection.isEmpty()){
			throw new IllegalStateException("Selected tagId resources cannot be empty.");
		}
		this.selectionOfTagIdResources = selection;
		
		this.editor = editor;
		this.premises = premises;
		this.projectWithTemplate = TrackerEditorUtils.getProject(editor);
	}

	@Override
	public boolean canFinish() {
		if(premises == null){
			return false;
		}
		AnimalTemplateBean templateBean = selectAnimalDocumentWizardPage
				.getTemplateBean();
		return templateBean != null && templateBean.numberOfEvents() > 0;
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
//		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
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
		TagsBean tagsBean = null;

		try {
		    
			tagsBean = TrackerEditorUtils.getTagsBean(editor, selectionOfTagIdResources);
		} catch (FileNotFoundException e) {
			selectAnimalDocumentWizardPage.setErrorMessage(e.getMessage());
			return false;
		}
		if(tagsBean==null || tagsBean.getTags().isEmpty()){
			selectAnimalDocumentWizardPage.setErrorMessage(
					"Found no unique events to import from template "+tagsBean.getName());
			return false;
		}
		TrackerEditorUtils.addTagsAndTemplate(premises, tagsBean, selectAnimalDocumentWizardPage
				.getTemplateBean(), editor);
		// Refresh the current viewer
		IViewerProvider viewerProvider = (IViewerProvider)editor.getAdapter(IViewerProvider.class);
		if(viewerProvider !=null){
			if(viewerProvider.getViewer()!=null){
				viewerProvider.getViewer().refresh();
			}
		}

		return true;
	}

	public Premises getPremises() {
		return premises;
	}

}
