/**
 * 
 */
package com.verticon.tracker.transaction.publisher.filetailer;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.editor.presentation.SelectFileWizardPage;
import com.verticon.tracker.transaction.publisher.IPublisher;
import com.verticon.tracker.transaction.publisher.IPublisherWizard;
import com.verticon.tracker.transaction.publisher.PublisherPlugin;

/**
 * Wizard for creating a FileTailerPublisher.
 * 
 * Pages: 1. Select the file to Tail for new TagIds
 * 
 * @author jconlon
 * 
 */
public class FileTailerPublisherWizard extends Wizard implements IPublisherWizard {

	private static final String WIZARD_TITLE = "Add a FileTailer Publisher";
	public static final String WIZARD_DIALOG_TAG = "AddPublisherWizard";

	private IWorkbench workbench;

	private SelectFileWizardPage selectCaptureFileWizardPage;
	private IPublisher publisher;

	public FileTailerPublisherWizard() {
		super();
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
		return selectCaptureFileWizardPage.getSelectedFile() != null;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		publisher = new FileTailer();
		publisher.setTarget(selectCaptureFileWizardPage.getSelectedFile()
				.getFullPath().toPortableString());

		return true;
	}

	@Override
	public void addPages() {
		setWindowTitle(WIZARD_TITLE);
		IEditorPart editor = workbench.getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		selectCaptureFileWizardPage = new SelectFileWizardPage(
				"selectACaptureFile",
				"Select a Capture File to be monitored by the FileTailer Publisher",
				"FileTailer will monitor the Capture File for newly appended Tag Ids.",
				new CaptureViewerFilter());
		addPage(selectCaptureFileWizardPage);
		selectCaptureFileWizardPage.init(editor);
	}

	/**
	 * Limit the selection to files with the tags extension.
	 * 
	 * @author jconlon
	 * 
	 */
	class CaptureViewerFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
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
				if (extension == null) {
					return false;
				}
				if (!extension.equalsIgnoreCase("Tags")) {
					return false;
				}
			}
			return true;
		}
	}

	public IPublisher getPublisher() {
		return publisher;
	}

}
