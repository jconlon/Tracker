/**
 * 
 */
package com.verticon.tracker.reader.event.filetailer;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.editor.presentation.SelectFileWizardPage;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderWizard;

/**
 * Wizard for creating a FileTailerPublisher.
 * 
 * Pages: 1. Select the file to Tail for new TagIds
 * 
 * @author jconlon
 * 
 */
public class FileTailerReaderWizard extends Wizard implements
		IReaderWizard {

	private static final String WIZARD_TITLE = "Add a FileTailer Publisher";

	/**
	 * Finished product of this Wizard
	 */
	private IReader publisher;

	/**
	 * Workbench where activity takes place
	 */
	private IWorkbench workbench;

	/**
	 * Page to prompt for the selection of the capture file to monitor.
	 */
	private SelectFileWizardPage selectCaptureFileWizardPage;
	

	/**
	 * Sets up the workbench.
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
	}
	
	/**
	 * Adds a single page to query the user for the name of a capture file.
	 */
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
	 * Determines if the wizard can enable the Finish Button
	 */
	@Override
	public boolean canFinish() {
		return selectCaptureFileWizardPage.getSelectedFile() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		publisher = new FileTailerEventReader();
		publisher.setTarget(selectCaptureFileWizardPage.getSelectedFile()
				.getFullPath().toPortableString());
		return true;
	}
	
	/**
	 * Return the finished publisher
	 */
	public IReader getReader() {
		return publisher;
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

	

}
