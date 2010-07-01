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

package com.verticon.tracker.ocl.query.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;


/**
 * This action delegate provides a base class for building ocl queries.
 * 
 */
public abstract class AbstractQueryDelegate
	extends ActionDelegate
	implements IEditorActionDelegate {


	/**
	 * The active editor
	 */
	private IEditorPart editor = null;

	/**
	 * Selected {@link EObject}s.
	 */
	private Collection<EObject> selectedEObjects = Collections.emptyList();

	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
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
			IEditingDomainProvider iEditingDomainProvider = (IEditingDomainProvider)editor.getAdapter(IEditingDomainProvider.class);
			ResourceSet rset = iEditingDomainProvider.getEditingDomain().getResourceSet();
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
		return editor.getEditorSite().getShell();
	}
	
	/**
	 * Selects the specified <code>objects</code> in the current editor.
	 * 
	 * @param objects the objects to select (may be empty)
	 */
	protected void selectInEditor( Collection<?> objects) {
		if (objects != null && !objects.isEmpty()) {
			IViewerProvider iViewerProvider = (IViewerProvider)editor.getAdapter(IViewerProvider.class);
			iViewerProvider.getViewer().setSelection(new StructuredSelection(objects.toArray()));
		}	
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
		if(targetEditor.getAdapter(IViewerProvider.class)==null){
			throw new UnsupportedOperationException("Please choose an Editor that implements an IViewerProvider.");
		}
		if(targetEditor.getAdapter(IEditingDomainProvider.class)==null){
			throw new UnsupportedOperationException("Please choose an Editor that implements an IEditingDomainProvider.");
		}
		
		this.editor = targetEditor;
	}

	/**
	 * Implements the inherited method using an OCL query condition.
	 */
	protected IQueryResult performQuery(Collection<EObject> context, IProgressMonitor monitor) throws Exception {
		if (null == context) {
			throw new NullPointerException("Argument 'context' is null"); //$NON-NLS-1$
		}
	
		// Build the select query statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(context), new WHERE(condition), monitor);
	
		// clear the condition for next invocation
		condition = null;
		
		// Execute query
		return statement.execute();
	}
}