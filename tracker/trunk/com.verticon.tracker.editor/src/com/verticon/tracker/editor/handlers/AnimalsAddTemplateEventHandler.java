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
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.AddTemplateToAnimalsWizard;

/**
 * Handler that invokes a Wizard to add Template Events to a Selection 
 * of Animals
 * 
 * @author jconlon
 *
 */
public class AnimalsAddTemplateEventHandler extends AbstractHandler implements
		IHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		
		try {
			AddTemplateToAnimalsWizard wizard = new AddTemplateToAnimalsWizard();
			wizard.init(editorPart, selection);
			WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
			dialog.open();
		} catch (PartInitException e) {
			ErrorDialog.openError(HandlerUtil.getActiveShell(event), "Add Template Problem", //$NON-NLS-1$
					null, // no special message
					((PartInitException) e).getStatus());
		}
		
		return null;
	}

}
