/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.io.FileNotFoundException;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.TagsBean;
import com.verticon.tracker.editor.util.AnimalTemplateBean;

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
	private IStructuredSelection selectionOfTagIdResources;
	private TrackerEditor editor;
	@SuppressWarnings("unused")
	private IWorkbenchWindow workbenchWindow;
	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;


	public void init(IWorkbenchWindow workbenchWindow, TrackerEditor editor,
			IStructuredSelection selection) {
		this.workbenchWindow = workbenchWindow;
		this.selectionOfTagIdResources = selection;
		this.editor = editor;
	}

	@Override
	public boolean canFinish() {
		AnimalTemplateBean templateBean = selectAnimalDocumentWizardPage
				.getTemplateBean();
		return templateBean != null && templateBean.numberOfEvents() > 0;
	}

	@Override
	public void addPages() {
		setWindowTitle(MODIFY_WIZARD_TITLE);
		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
		addPage(selectAnimalDocumentWizardPage);
		selectAnimalDocumentWizardPage.init(editor);
	}
	

	@Override
	public boolean performFinish() {

		Premises premises = ActionUtils.getPremises( editor);
		TagsBean tagsBean = null;

		try {
			tagsBean = ActionUtils.getTagsBean(editor, selectionOfTagIdResources);
		} catch (FileNotFoundException e) {
			selectAnimalDocumentWizardPage.setErrorMessage(e.getMessage());
			return false;
		}
		if(tagsBean==null || tagsBean.getTags().isEmpty()){
			selectAnimalDocumentWizardPage.setErrorMessage(
					"Found no unique events to import from template "+tagsBean.getName());
			return false;
		}
		ActionUtils.addTagsAndTemplate(premises, tagsBean, selectAnimalDocumentWizardPage
				.getTemplateBean(), editor);
		// Refresh the current viewer
		editor.getViewer().refresh();

		return true;
	}

}
