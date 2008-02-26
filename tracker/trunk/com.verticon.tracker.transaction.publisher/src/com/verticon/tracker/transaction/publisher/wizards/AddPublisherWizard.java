/**
 * 
 */
package com.verticon.tracker.transaction.publisher.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.editor.presentation.SelectAnimalDocumentWizardPage;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.transaction.publisher.IPublisher;
import com.verticon.tracker.transaction.publisher.IPublisherWizard;
import com.verticon.tracker.transaction.publisher.PublisherPlugin;
import com.verticon.tracker.transaction.publisher.views.PublisherViewModel;

/**
 * Wizard for adding a publisher to the Publisher Views.
 * 
 * Pages: 1. Select the Animal document to use as a template 2. Select the file
 * to Tail new TagIds
 * 
 * 
 * 
 * @author jconlon
 * 
 */
public class AddPublisherWizard extends Wizard {

	private static final String WIZARD_TITLE = "Add an Event Publisher";
	public static final String WIZARD_DIALOG_TAG = "AddPublisherWizard";

	private final PublisherViewModel publisherViewModel;
	private IWorkbench workbench;

	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;

	private PublisherWizardSelectionPage publisherWizardSelection;

	public AddPublisherWizard(PublisherViewModel publisherViewModel) {
		super();
		this.publisherViewModel = publisherViewModel;
		IDialogSettings trackerSettings = PublisherPlugin.getDefault()
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

	public void init(IWorkbench workbench) {
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
		IPublisherWizard publisherWizard = (IPublisherWizard) wizardNode
				.getWizard();
		if (publisherWizard == null || publisherWizard.getPublisher() == null) {
			return false;
		}

		IPublisher publisher = publisherWizard.getPublisher();
		publisher.setTemplate(templateFile.getFullPath().toPortableString());

		publisherViewModel.addPublisher(publisher);
		return true;
	}

	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
		selectAnimalDocumentWizardPage.setTitle("Select an Animal Document to use as a template for the Event Publisher");
		addPage(selectAnimalDocumentWizardPage);

		IEditorPart editor = workbench.getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		selectAnimalDocumentWizardPage.init(editor);

		publisherWizardSelection = new PublisherWizardSelectionPage(
				"Select the Type of Event Publisher to Create", workbench);
		addPage(publisherWizardSelection);
	}

}
