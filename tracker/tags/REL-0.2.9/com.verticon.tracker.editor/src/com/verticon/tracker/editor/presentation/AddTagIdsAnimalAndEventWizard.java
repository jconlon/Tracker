/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.io.FileNotFoundException;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.ActionUtils;
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
	private IStructuredSelection selectionOfTagIdResources;
	private IEditorPart editor;
	private SelectAnimalWizardPage selectAnimalWizardPage;
	private SelectEventWizardPage selectEventWizardPage;


	public void init(IEditorPart editor,
			IStructuredSelection selection) {
		this.selectionOfTagIdResources = selection;
		this.editor = editor;
	}

	@Override
	public boolean canFinish() {
		Animal animal = selectAnimalWizardPage.getAnimal();
		Event event = selectEventWizardPage.getEvent();
		return (event!=null && animal!=null);
	}

	/**
	 * Will need two pages. The first to choose a default animal the second to 
	 * choose an event.
	 */
	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		selectAnimalWizardPage = new SelectAnimalWizardPage();
		addPage(selectAnimalWizardPage);
		selectEventWizardPage = new SelectEventWizardPage();
		addPage(selectEventWizardPage);
	}
	

	@Override
	public boolean performFinish() {

		Premises premises;
		try {
			premises = ActionUtils.getPremises( editor);
		} catch (FileNotFoundException e1) {
			selectEventWizardPage.setErrorMessage(e1.getMessage());
			return false;
		}
		TagsBean tagsBean = null;

		try {
			tagsBean = ActionUtils.getTagsBean(editor, selectionOfTagIdResources);
		} catch (FileNotFoundException e) {
			selectAnimalWizardPage.setErrorMessage(e.getMessage());
			return false;
		}
		if(tagsBean==null || tagsBean.getTags().isEmpty()){
			selectAnimalWizardPage.setErrorMessage(
					"Found no unique events to import from template "+tagsBean.getName());
			return false;
		}
		ActionUtils.addTagsAndTemplate(premises, tagsBean, getTemplateAnimalBean(), editor);
		// Refresh the current viewer
		IViewerProvider viewerProvider = (IViewerProvider)editor.getAdapter(IViewerProvider.class);
		if(viewerProvider !=null){
			viewerProvider.getViewer().refresh();
		}
		return true;
	}
	
	
	private AnimalTemplateBean getTemplateAnimalBean(){
		Animal animal = selectAnimalWizardPage.getAnimal();
		Event event = selectEventWizardPage.getEvent();
		return ActionUtils.createTemplateBean(animal, event);
	}

}
