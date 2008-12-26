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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;

import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;
import com.verticon.tracker.ocl.query.wizards.ContextFreeQueryWizard;


/**
 * Action that pops up a dialog to accept a context metaclass and an OCL
 * condition expression, to query the model.
 */
public class ContextFreeQueryDelegate
	extends AbstractQueryDelegate {

	private static String TITLE = QueryOCLMessages.cfQuery_title;
	private static String NOT_FOUND = QueryOCLMessages.oclQuery_message_notFound;
	
	
	/**
	 * Initializes me.
	 */
	public ContextFreeQueryDelegate() {
		super();
	}

	@Override
	public void run(IAction action) {
		Collection<EObject> selection = getSelectedObjects();
		
		if (selection == null || selection.isEmpty()) {
			action.setEnabled(false);
			return;
		}

		ContextFreeQueryWizard wizard = new ContextFreeQueryWizard(null);
		WizardDialog dlg = new WizardDialog(getShell(), wizard);
		dlg.setTitle(TITLE);
		dlg.open();
		
		condition = wizard.getCondition();
		
		if (condition != null) {
			try {
				List<Object> results = performQueryWithProgress();

				if (results.isEmpty()) {
					MessageDialog.openInformation(getShell(), TITLE, NOT_FOUND);
				} else {
					selectInEditor(results);
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(getShell(), TITLE,
						QueryOCLMessages.message_exception);
				throw new RuntimeException(e);
			}
		}
	}
}
