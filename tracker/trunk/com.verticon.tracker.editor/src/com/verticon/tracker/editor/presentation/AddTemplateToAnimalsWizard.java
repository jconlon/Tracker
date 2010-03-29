/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.editor.util.AnimalTemplateBean;

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
			ISelection selection) {
		selectedAnimals = TrackerEditorUtils.getSelectedAnimals(selection);
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
