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
package com.verticon.tracker.ocl.query.handlers;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;
import com.verticon.tracker.ocl.query.wizards.ContextFreeQueryWizard;

/**
 * @author jconlon
 *
 */
public class OCLContextFreeQueryHandler extends AbstractHandler implements
		IHandler {

	private static String TITLE = QueryOCLMessages.cfQuery_title;
	private static String NOT_FOUND = QueryOCLMessages.oclQuery_message_notFound;
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		IViewerProvider viewerProvider = (IViewerProvider)editorPart.getAdapter(IViewerProvider.class);
		
		IWorkbenchWindow workbenchWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Collection<EObject> context = OCLQueryHandler.getContext(event, editorPart);
		
		ContextFreeQueryWizard wizard = new ContextFreeQueryWizard(null);
		WizardDialog dlg = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
		dlg.setTitle(TITLE);
		dlg.open();
		
		
		
		BooleanOCLCondition<EClassifier, EClass, EObject> condition = wizard.getCondition();
		
		if (condition != null) {
			try {

				List<Object> results = OCLQueryHandler.performQueryWithProgress(
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

}
