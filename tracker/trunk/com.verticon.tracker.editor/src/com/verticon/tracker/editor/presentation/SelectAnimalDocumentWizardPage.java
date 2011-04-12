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

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.util.AnimalTemplateBean;

/**
 * @author jconlon
 *
 */
public class SelectAnimalDocumentWizardPage extends WizardPage implements ISelectionChangedListener {

	private TreeViewer treeViewer;
	private IProject project;
	private IFile selectedFile;
	private final boolean needsFileDialog ;
	private FileFieldEditor fileFieldEditor = null;
	
	public SelectAnimalDocumentWizardPage(boolean needsFileDialog) {
		super("selectAnimalDocument");
		setTitle("Select Animal Document");
		setDescription("Select the Animal Document to use as an Event Template");
		this.needsFileDialog =needsFileDialog;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		if(!needsFileDialog){
			final GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 3;
			container.setLayout(gridLayout);
			treeViewer=createViewer( container);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.grabExcessHorizontalSpace=true;
			data.grabExcessVerticalSpace=true;
			data.heightHint = 400;
			data.widthHint = 300;
			treeViewer.getControl().setLayoutData(data);
			treeViewer.addSelectionChangedListener(this);
		}else{
			fileFieldEditor = new FileFieldEditor("templateFile", "Animal Template File", container){

				/* (non-Javadoc)
				 * @see org.eclipse.jface.preference.FileFieldEditor#checkState()
				 */
				@Override
				protected boolean checkState() {
					boolean state =  super.checkState();
					if(state && !getStringValue().isEmpty()){
						selectedFile = convert(getStringValue());
						updatePageComplete();
					}
					return state;
				}};
				fileFieldEditor.setFileExtensions(new String[]{"*.animal"});
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot workspaceRoot = workspace.getRoot();
				fileFieldEditor.setFilterPath(workspaceRoot.getRawLocation().toFile());
			
		}
		setControl(container);
	}
	   
	private TreeViewer createViewer(Composite parent) {
		TreeViewer viewer =
			new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new WorkbenchContentProvider());
		viewer.setLabelProvider(new WorkbenchLabelProvider());
		viewer.addFilter(new TemplateViewerFilter());
		return viewer;
	}
	
	/**
	 * Update the content before becoming visible.
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible && !needsFileDialog) {
			treeViewer.setInput(project);
			treeViewer.refresh();
		}
		super.setVisible(visible);
	}

	public AnimalTemplateBean getTemplateBean() {
		AnimalTemplateBean result = null;
		if(selectedFile!=null){
			result = getTemplateAnimalBean(selectedFile);;
		}
		
		return result;
	}
	
	/**
	 * @param resource
	 * @return
	 */
	private AnimalTemplateBean getTemplateAnimalBean(IFile animalTemplateFile) {
		AnimalTemplateBean result = null;
		if(animalTemplateFile.isAccessible()){
			result = AnimalTemplateBean.instance(animalTemplateFile);
		}
		return result;
	}
	
	public void init(IProject project){
		this.project =project;
	}


	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		List<IResource> selectedResources = new ArrayList<IResource>();
		if (!selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection sel = (IStructuredSelection)selection;
				for (Iterator<?> i = sel.iterator();i.hasNext();) {
					Object next = i.next();
					IResource resource= null;			
					if (next instanceof IResource)
						resource= (IResource)next;
					else if (next instanceof IAdaptable) {
						if (resource == null)
							resource= (IResource)((IAdaptable)next).getAdapter(IResource.class);
					}
					if (resource != null) {
						selectedResources.add(resource);
					}
				}
			}
		}
		if((!selectedResources.isEmpty()) && selectedResources.get(0) instanceof IFile){
			selectedFile =  (IFile)selectedResources.get(0);
		} else{
			selectedFile = null;
		}
		
		updatePageComplete();
	}

	 /**
	    * Update the current page complete state
	    * based on the field content.
	    */
	   private void updatePageComplete() {
	      setPageComplete(false);

	      if (selectedFile == null) {
	         setMessage(null);
	         setErrorMessage("Please select an existing Animal Document file");
	         return;
	      }

	      AnimalTemplateBean templateAnimalBean =  getTemplateBean();
	      if (templateAnimalBean == null || templateAnimalBean.numberOfEvents()==0) {
		         setMessage(null);
		         setErrorMessage(
		            "Animal document has no events. Please specify an Animal Document that has at least one event.");
		         return;
		      }
	      
	      setPageComplete(true);

	      
	      setErrorMessage(null);
	      setMessage(
	            "Animal Document contains "+templateAnimalBean.numberOfEvents()+" event(s).",
	            IMessageProvider.INFORMATION);
	         return;
	      
	   }
	boolean fileFieldIsValid() {
		return fileFieldEditor!=null;
	}

	public IFile getSelectedFile() {
		return selectedFile;
	}
	
	private static IFile convert(String fileName) {
		   File file = new File(fileName);
		   return convert(file);
	}
	private static IFile convert(File file) {
		IWorkspace workspace= ResourcesPlugin.getWorkspace();
		   IPath location= Path.fromOSString(file.getAbsolutePath());
		   return workspace.getRoot().getFileForLocation(location);
	}
}
