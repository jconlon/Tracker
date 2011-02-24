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
/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

import com.verticon.tracker.Premises;

/**
 * @author jconlon
 *
 */
public class TrackerMainModelWizard extends TrackerModelWizard {
	
	/**
	 * Just override the getEncoding to avoid a null pointer exception.
	 * @author jconlon
	 *
	 */
	class MyPage extends TrackerModelWizard.TrackerModelWizardInitialObjectCreationPage {

		@Override
		public String getEncoding() {
			return "UTF-8";
		}
		
		

		protected MyPage(String pageId) {
			super(pageId);
		}
		
	}
	
	
	/**
	 * Creates a Premises as the root of a new model.
	 * 
	 */
	@Override
	protected EObject createInitialModel() {
		Premises rootObject = trackerFactory.createPremises();
		return rootObject;
	}
	
	/**
	 * Override to add the MyPage instead of its superclass. 
	 */
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new TrackerModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerModelWizard_label"));
		newFileCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerModelWizard_description"));
		newFileCreationPage.setFileName(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerEditorFilenameDefaultBase") + "." + TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerEditorFilenameExtension"));
		addPage(newFileCreationPage);

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
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerEditorFilenameExtension");
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new MyPage("Whatever2");
		initialObjectCreationPage.setTitle(TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerModelWizard_label"));
		initialObjectCreationPage.setDescription(TrackerReportEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		//addPage(initialObjectCreationPage);
	}
	

}
