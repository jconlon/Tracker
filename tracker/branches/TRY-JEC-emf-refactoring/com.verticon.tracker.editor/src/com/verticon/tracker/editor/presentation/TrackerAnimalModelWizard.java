package com.verticon.tracker.editor.presentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


/**
 * Creates a Tracker Animal Template model
 * 
 * @author jconlon
 *
 */
public class TrackerAnimalModelWizard extends TrackerModelWizard {

	/**
	 * Need a unique NeFileCreation page.
	 */
	private  MyNewFileCreationPage myNewFileCreationPage;
	
	/**
	 * Just present the user with Animal subclasses to choose as the root in the model.
	 * 
	 */
	@Override
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			
			for (EClassifier eClassifier : trackerPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						if(trackerPackage.getAnimal().isSuperTypeOf(eClass)){
								initialObjectNames.add(eClass.getName());
						}
						
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}
	

	/**
	 * Override to use a different NewFileCreationPage
	 */
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		myNewFileCreationPage = new MyNewFileCreationPage("Whatever", selection);
		myNewFileCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateWizard_label"));
		myNewFileCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateWizard_description"));
		myNewFileCreationPage.setFileName(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateFilenameDefaultBase") + "." + TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateFilenameExtension"));
		addPage(myNewFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					myNewFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateFilenameDefaultBase");
					String defaultModelFilenameExtension = TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateFilenameExtension");
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					myNewFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new TrackerModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateWizard_label"));
		initialObjectCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	/**
	 * Creates the new Animal template model file.
	 * 
	 */
	public class MyNewFileCreationPage extends WizardNewFileCreationPage {
		
		public MyNewFileCreationPage(String pageId,
				IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * 
		 */
	@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				// Make sure the file ends in ".tracker".
				//
				String requiredExt = TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateFilenameExtension");
				String enteredExt = new Path(getFileName()).getFileExtension();
				if (enteredExt == null || !enteredExt.equals(requiredExt)) {
					setErrorMessage(TrackerReportEditorPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return false;
			}
		}

		/**
		 * 
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}

	/**
	 * 
	 */
	public IFile getModelFile() {
		return myNewFileCreationPage.getModelFile();
	}
}
