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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.AddTagIdsAnimalAndEventWizard;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Handler associated with a selection on a Capture *.tags file.
 * 
 * Calls Wizard that prompts the user to choose 
 * 1. an Animal default
 * 2. an Event type
 * 
 * to be added to animals associated with the AINs in the capture *.tags file.
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
public class ImportTagIdsAsSelectedEventsHandler extends AbstractHandler{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selectionOfTagIdResources = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		Premises premises = ((IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class)).getPremises();
		
		AddTagIdsAnimalAndEventWizard wizard = new AddTagIdsAnimalAndEventWizard( premises);
		wizard.init(
				editorPart, 
				selectionOfTagIdResources);
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		
		
		return null;
	}

}
