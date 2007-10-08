/**
 * 
 */
package com.verticon.tracker.transaction.publisher.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.editor.presentation.SelectAnimalDocumentWizardPage;
import com.verticon.tracker.editor.presentation.SelectFileWizardPage;
import com.verticon.tracker.editor.util.AnimalTemplateBean;
import com.verticon.tracker.transaction.publisher.FileTailer;
import com.verticon.tracker.transaction.publisher.PublisherPlugin;
import com.verticon.tracker.transaction.publisher.PublisherViewModel;

/**
 * Wizard for adding a publisher to the Publisher Views.
 * 
 * Pages: 
 * 	1. Select the Animal document to use as a template 
 *  2. Select the file to Tail new TagIds
 * 	
 * 
 * 
 * @author jconlon
 * 
 */
public class AddPublisherWizard extends Wizard {

	private static final String WIZARD_TITLE = "Add a FileTailer Publisher";
	public static final String WIZARD_DIALOG_TAG = "AddPublisherWizard";

	private final PublisherViewModel publisherViewModel;
	private IWorkbench workbench;

	private SelectAnimalDocumentWizardPage selectAnimalDocumentWizardPage;
	
	private SelectFileWizardPage selectCaptureFileWizardPage;

	public AddPublisherWizard(PublisherViewModel publisherViewModel) {
		super();
		this.publisherViewModel = publisherViewModel;
		IDialogSettings trackerSettings = PublisherPlugin.getDefault().getDialogSettings();
		
		IDialogSettings wizardSettings = trackerSettings
				.getSection(WIZARD_DIALOG_TAG);
		if (wizardSettings == null) {
			wizardSettings = trackerSettings
					.addNewSection(WIZARD_DIALOG_TAG);
		}
		setDialogSettings(wizardSettings);
	}
	
	@Override
	public boolean canFinish() {
		AnimalTemplateBean templateBean = selectAnimalDocumentWizardPage
				.getTemplateBean();
		if( templateBean != null && templateBean.numberOfEvents() > 0){
			return selectCaptureFileWizardPage.getSelectedFile()!=null;
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
		FileTailer publisher = new FileTailer();
		IFile templateFile = selectAnimalDocumentWizardPage.getSelectedFile();
		publisher.setTemplate(templateFile.getFullPath().toPortableString());
		publisher.setTarget(selectCaptureFileWizardPage.getSelectedFile().getFullPath().toPortableString());
		
		publisherViewModel.addPublisher(publisher);
		return true;
	}
	
	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		selectAnimalDocumentWizardPage = new SelectAnimalDocumentWizardPage();
		addPage(selectAnimalDocumentWizardPage);
		IEditorPart editor = workbench
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		selectAnimalDocumentWizardPage.init(editor);
		selectCaptureFileWizardPage= new SelectFileWizardPage(
				"selectACaptureFile", 
				"Select a Capture File to be monitored by the FileTailer Publisher", 
				"FileTailer will monitor the Capture File for newly appended Tag Ids.", 
				new CaptureViewerFilter()
		);
		addPage(selectCaptureFileWizardPage);
		selectCaptureFileWizardPage.init(editor);
	}


	/**
	 * Limit the selection to files with the tags extension.
	 * @author jconlon
	 *
	 */
	class CaptureViewerFilter extends ViewerFilter{
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			 IResource resource = null;
		        if (element instanceof IResource) {
		            resource = (IResource) element;
		        } else if (element instanceof IAdaptable) {
		            IAdaptable adaptable = (IAdaptable) element;
		            resource = (IResource) adaptable.getAdapter(IResource.class);
		        }
		        if (resource != null && !resource.isDerived()) {
		        	   if (resource.getType() != IResource.FILE) {
		        		   return true;
		        	   }
		        	   
		            String extension = resource.getFileExtension();
		            if(extension==null){
		            	return false;
		            }
		            if (!extension.equalsIgnoreCase("Tags")) {
		            	return false;
		            }
		        }
		        return true;
		}
		
	}


}
