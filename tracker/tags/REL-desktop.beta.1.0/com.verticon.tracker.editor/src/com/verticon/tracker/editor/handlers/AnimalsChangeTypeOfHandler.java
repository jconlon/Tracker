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
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.actions.ChangeAnimalTypeWizard;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * @author jconlon
 *
 */
public class AnimalsChangeTypeOfHandler extends AbstractHandler implements
		IHandler {

	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selectionOfTagIdResources = HandlerUtil.getActiveMenuSelectionChecked(event);	
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		Premises premises = ((IPremisesProvider)editorPart.getAdapter(IPremisesProvider.class)).getPremises();
		
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editorPart
		.getAdapter(IPremisesProvider.class);
		
		ChangeAnimalTypeWizard wizard = new ChangeAnimalTypeWizard(premises);
		wizard.init(
				HandlerUtil.getActiveWorkbenchWindowChecked(event),
				editingDomainProvider.getEditingDomain(), 
				selectionOfTagIdResources);
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		
		return null;
	}

}
