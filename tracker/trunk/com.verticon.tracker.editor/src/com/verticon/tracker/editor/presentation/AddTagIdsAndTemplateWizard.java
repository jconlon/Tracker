/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.io.FileNotFoundException;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.editor.util.TagsBean;

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
	private IEditorPart editor;
	private Premises premises;

	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;

	public void init(IEditorPart editor,
			IStructuredSelection selection) {
		this.selectionOfTagIdResources = selection;
		this.editor = editor;
		try {
			premises = ActionUtils.getPremises( editor);
		} catch (FileNotFoundException e) {
		
		}
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
		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
		addPage(selectAnimalDocumentWizardPage);
		selectAnimalDocumentWizardPage.init(editor);
	}
	

	@Override
	public boolean performFinish() {
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
