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
package com.verticon.tracker.fair.poi.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.editor.presentation.IFairProvider;
import com.verticon.tracker.fair.poi.presentation.ImportFairExhibitDataWizard;

/**
 * @author jconlon
 *
 */
public class XlsFairImportHandler extends AbstractHandler{
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editorPart = HandlerUtil.getActiveEditorChecked(event);
		Fair fair = ((IFairProvider)editorPart.getAdapter(IFairProvider.class)).getFair();
		EditingDomain editingDomain = 
			((IEditingDomainProvider)editorPart.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		
		ImportFairExhibitDataWizard wizard = new ImportFairExhibitDataWizard();
		wizard.init(
				HandlerUtil.getActiveWorkbenchWindowChecked(event),  
				editingDomain,
				fair,
				HandlerUtil.getActiveMenuSelection(event));
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShellChecked(event), wizard);
		dialog.open();
		return null;
	}

}
