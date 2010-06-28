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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.editor.util.TagsBean;

/**
 * Wizard for adding an animal and event to a Premises
 * based on a selection of TagID files (*.tags).
 * 
 * Pages: 
 * 1. Select the Animal to add
 * 2. Select the Event to add
 * 	
 * 
 * @see SelectAnimalWizardPage
 * @see SelectEventWizardPage
 * @author jconlon
 * @since 0.2
 * 
 */
public class AddTagIdsAnimalAndEventWizard extends Wizard {

	private static final String MODIFY_WIZARD_TITLE = "Add Animal To Premises";
	private ISelection selectionOfTagIdResources;
	private IEditorPart editor;
	private SelectAnimalWizardPage selectAnimalWizardPage;
	private SelectEventWizardPage selectEventWizardPage;
	
	private final Premises premises;
	
	public AddTagIdsAnimalAndEventWizard(Premises premises) {
		super();
		this.premises = premises;
	}

	public void init(IEditorPart editor,
			ISelection selection) {
		this.selectionOfTagIdResources = selection;
		this.editor = editor;
	}

	@Override
	public boolean canFinish() {
		Animal animal = selectAnimalWizardPage.getSelectedAnimal();
		Event event = selectEventWizardPage.getSelectedEvent();
		return (event != null && animal != null);
	}
	

	
	/**
	 * Will need two pages. The first to choose a default animal the second to 
	 * choose an event.
	 */
	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		selectAnimalWizardPage = new SelectAnimalWizardPage(premises);
		addPage(selectAnimalWizardPage);
		selectEventWizardPage = new SelectEventWizardPage(premises);
		addPage(selectEventWizardPage);
	}
	

	@Override
	public boolean performFinish() {
		TagsBean tagsBean = null;

		try {
			tagsBean = TrackerEditorUtils.getTagsBean(editor, selectionOfTagIdResources);
		} catch (FileNotFoundException e) {
			selectAnimalWizardPage.setErrorMessage(e.getMessage());
			return false;
		}
		if(tagsBean==null || tagsBean.getTags().isEmpty()){
			selectAnimalWizardPage.setErrorMessage(
					"Found no unique events to import from template "+tagsBean.getName());
			return false;
		}
		TrackerEditorUtils.addTagsAndTemplate(premises, tagsBean, getTemplateAnimalBean(), editor);
		// Refresh the current viewer
		IViewerProvider viewerProvider = (IViewerProvider)editor.getAdapter(IViewerProvider.class);
		if(viewerProvider !=null){
			viewerProvider.getViewer().refresh();
		}
		return true;
	}
	
	
	private AnimalTemplateBean getTemplateAnimalBean(){
		return AnimalTemplateBean.instance(getSelectedAnimal(), 
				selectEventWizardPage.getSelectedEvent());
	}

	Animal getSelectedAnimal(){
		return selectAnimalWizardPage.getSelectedAnimal();
	}
	
}
