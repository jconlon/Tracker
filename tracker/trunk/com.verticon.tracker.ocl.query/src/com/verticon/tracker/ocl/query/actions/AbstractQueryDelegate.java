/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package com.verticon.tracker.ocl.query.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;


/**
 * This action delegate provides a base class for building ocl queries.
 * 
 */
public abstract class AbstractQueryDelegate
	extends ActionDelegate
	implements IEditorActionDelegate {

	/**
	 * The shell this action is hosted in.
	 */
	private Shell shell = null;

	/**
	 * The active editor
	 */
	private IQueryDataSetProvider editor = null;

	/**
	 * Selected {@link EObject}s.
	 */
	private Collection<EObject> selectedEObjects = Collections.emptyList();

	/**
	 * Initializes me.
	 */
	protected AbstractQueryDelegate() {
		super();
	}
	
	/**
	 * Retrieves the user's selection.  If the actual selection is empty,
	 * then I return, instead, the roots of all resources in the current
	 * editor's resource set.
	 * 
	 * @return a collection of selected {@link EObject}s
	 */
	protected Collection<EObject> getSelectedObjects() {
		Collection<EObject> result = selectedEObjects;
		
		if (editor != null && (result == null || result.isEmpty())) {
			result = new ArrayList<EObject>();
			ResourceSet rset = editor.getEditingDomain().getResourceSet();
			for (Resource res : rset.getResources()) {
				if (res.isLoaded()) {
					result.addAll(res.getContents());
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the shell to use for opening dialogs.
	 * 
	 * @return my shell
	 */
	protected Shell getShell() {
		return shell;
	}
	
	/**
	 * Selects the specified <code>objects</code> in the current editor.
	 * 
	 * @param objects the objects to select (may be empty)
	 */
	protected void selectInEditor(Collection<?> objects) {
		editor.setSelectionToViewer(objects);
	}

	/**
	 * Gets all of the {@link EObject}s in the current selection, if any.
	 */
	@Override
	public void selectionChanged(IAction action, final ISelection selection) {
		selectedEObjects = Collections.emptyList();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selectedEObjects = new ArrayList<EObject>();
			for (Iterator<?> iter = structuredSelection.iterator(); iter.hasNext();) {
				Object next = iter.next();
				
				if (next instanceof EObject) {
					selectedEObjects.add((EObject)next);
				}
			}
		}
		
		action.setEnabled(!selectedEObjects.isEmpty());
	}

	/**
	 * Get the active library editor and its host shell.
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if(targetEditor==null){
			return;
		}
		Object o = targetEditor.getAdapter(IQueryDataSetProvider.class);
		if(o==null){
			throw new UnsupportedOperationException("Please choose an Editor that implements an IQueryDataSetProvider.");
		}
		IQueryDataSetProvider queryDataSetProvider = 
			(IQueryDataSetProvider)o;
		
		
		
		this.editor = queryDataSetProvider;
		
		if (targetEditor != null) {
			this.shell = targetEditor.getSite().getShell();
		}
	}
}