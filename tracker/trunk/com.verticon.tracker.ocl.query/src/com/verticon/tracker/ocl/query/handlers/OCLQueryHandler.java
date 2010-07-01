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
package com.verticon.tracker.ocl.query.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;
import com.verticon.tracker.ocl.query.wizards.QueryWithContextWizard;

public class OCLQueryHandler extends AbstractHandler {

	private static String TITLE = QueryOCLMessages.oclQuery_title;
	private static String NOT_FOUND = QueryOCLMessages.oclQuery_message_notFound;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String packageURIsParam = 
			event.getParameter("com.verticon.tracker.ocl.commands.packageURIs"); 
		
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IViewerProvider viewerProvider = (IViewerProvider)editorPart.getAdapter(IViewerProvider.class);
		IWorkbenchWindow workbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		Collection<EObject> context = getContext(event,editorPart);
		
		
		QueryWithContextWizard wizard = new QueryWithContextWizard(packageURIsParam);
		WizardDialog dlg = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dlg.setTitle(TITLE);
		dlg.open();
		
		BooleanOCLCondition<EClassifier, EClass, EObject> condition = wizard.getCondition();
		
		if (condition != null) {
			try {

				List<Object> results = performQueryWithProgress(
						workbenchWindow,
						context,
						condition
				);

				if (results.isEmpty()) {
					MessageDialog.openInformation(
							HandlerUtil.getActiveShellChecked(event), TITLE, NOT_FOUND);
				} else {
					viewerProvider.getViewer().setSelection(
							new StructuredSelection(results.toArray()));
					
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(HandlerUtil.getActiveShellChecked(event), TITLE,
						QueryOCLMessages.message_exception);
				
			}
		}
		return null;
	}

	/**
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	 static Collection<EObject> getContext(ExecutionEvent event, IEditorPart editor)
			throws ExecutionException {
		Collection<EObject> context = Collections.emptyList();
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		
		if(selection ==null){
			context = new ArrayList<EObject>();
			IEditingDomainProvider iEditingDomainProvider = (IEditingDomainProvider)editor.getAdapter(IEditingDomainProvider.class);
			ResourceSet rset = iEditingDomainProvider.getEditingDomain().getResourceSet();
			for (Resource res : rset.getResources()) {
				if (res.isLoaded()) {
					context.addAll(res.getContents());
				}
			}
			return context;
		}
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			context = new ArrayList<EObject>();
			for (Iterator<?> iter = structuredSelection.iterator(); iter.hasNext();) {
				Object next = iter.next();
				
				if (next instanceof EObject) {
					context.add((EObject)next);
				}
			}
		}
		return context;
	}

	/**
	 * @return
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
   static List<Object> performQueryWithProgress(IWorkbenchWindow window, final Collection<EObject> context,
			final BooleanOCLCondition<EClassifier, EClass, EObject> condition)
			throws InvocationTargetException, InterruptedException {
				final List<Object> res = new ArrayList<Object>();
				window.run(true, true, new IRunnableWithProgress() {
			
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						try {
							IQueryResult result = performQuery(context, 
									monitor,
									condition);
							res.addAll(result);
						} catch (Exception e) {
							throw new InvocationTargetException(e);
						}
						
					}});
				return res;
	}

	
	/**
	 * Implements the inherited method using an OCL query condition.
	 */
	private static IQueryResult performQuery(
			Collection<EObject> context, IProgressMonitor monitor,
			BooleanOCLCondition<EClassifier, EClass, EObject> condition) throws Exception {
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
