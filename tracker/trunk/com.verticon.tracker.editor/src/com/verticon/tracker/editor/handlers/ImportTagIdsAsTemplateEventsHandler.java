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
package com.verticon.tracker.editor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.editor.presentation.AddTagIdsAndTemplateWizard;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Handler associated with a selection on a Capture *.tags file.
 * 
 * Calls Wizard that prompts the user to select a Template to add to the set of animals 
 * associated with the AINs in the capture *.tags file.
 * 
 * For AINs that are not already assigned to animals an animal will be created.
 * 
 * Capture *.tags files can also contain a timestamp in their name.  This will be the default date for all events
 * overriding any event dates in the PremisesTemplates.
 * 
 * 
 * @author jconlon
 * @since 0.3.1
 * 
 */
public class ImportTagIdsAsTemplateEventsHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selectionOfTagIdResources = HandlerUtil.getActiveMenuSelectionChecked(event);	
		if(selectionOfTagIdResources.isEmpty()){
			throw new ExecutionException("Selected tagId resources cannot be empty.");
		}
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);

		try{
			IPremisesProvider premisesProvider = (IPremisesProvider) editorPart
			.getAdapter(IPremisesProvider.class);

			AddTagIdsAndTemplateWizard wizard = new AddTagIdsAndTemplateWizard();
			wizard.init(
					editorPart, 
					selectionOfTagIdResources, 
					premisesProvider.getPremises());
			Shell shell = HandlerUtil.getActiveShellChecked(event);
			WizardDialog dialog = new WizardDialog(
					shell, wizard);
			dialog.open();
		} catch (PartInitException e) {
			ErrorDialog.openError(HandlerUtil.getActiveShell(event), "Add Import TagIds As Template Problem", //$NON-NLS-1$
					null, // no special message
					((PartInitException) e).getStatus());
		}
		
		return null;
	}

}
