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
package com.verticon.tracker.editor.presentation;
import java.util.Collection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.verticon.tracker.editor.util.TrackerEditorUtils;


/**
 * Creates a Tracker Animal Template model
 * 
 * @author jconlon
 *
 */
public class TrackerAnimalModelWizard extends TrackerModelWizard {

	@Override
   public void init(IWorkbench workbench, IStructuredSelection selection) {
	// TODO Auto-generated method stub
	super.init(workbench, selection);
	this.setWindowTitle(TrackerReportEditorPlugin.INSTANCE.getString("_UI_Animal_Wizard_label"));
}

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
			initialObjectNames = TrackerEditorUtils.getModelInstances(trackerPackage.getAnimal());
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
		myNewFileCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE
				.getString("_UI_AnimalTemplateWizard_label"));
		myNewFileCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE
				.getString("_UI_AnimalTemplateWizard_description"));
		myNewFileCreationPage.setFileName(TrackerReportEditorPlugin.INSTANCE
				.getString("_UI_AnimalTemplateFilenameDefaultBase")
				+ "."
				+ TrackerReportEditorPlugin.INSTANCE
						.getString("_UI_AnimalTemplateFilenameExtension"));
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
					String defaultModelBaseFilename = TrackerReportEditorPlugin.INSTANCE
							.getString("_UI_AnimalTemplateFilenameDefaultBase");
					String defaultModelFilenameExtension = //FIXME
						TrackerReportEditorPlugin.INSTANCE.getString("_UI_AnimalTemplateFilenameExtension");
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					myNewFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new TrackerModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE
				.getString("_UI_AnimalTemplateWizard_label"));
		initialObjectCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	/**
	 * Creates the new Animal template model file.
	 * 
	 */
	private static class MyNewFileCreationPage extends WizardNewFileCreationPage {
		
		protected MyNewFileCreationPage(String pageId,
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
				String requiredExt = TrackerReportEditorPlugin.INSTANCE
						.getString("_UI_AnimalTemplateFilenameExtension");
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
	@Override
	public IFile getModelFile() {
		return myNewFileCreationPage.getModelFile();
	}
}
