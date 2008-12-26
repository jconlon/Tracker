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
 * $Id: OCLQueryDelegate.java,v 1.1 2006/02/13 16:12:04 cdamus Exp $
 */

package com.verticon.tracker.ocl.query.actions;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;

import com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages;
import com.verticon.tracker.ocl.query.wizards.QueryWithContextWizard;


/**
 * Action that pops up a dialog to accept a context metaclass and an OCL
 * condition expression, to query the model.
 * 
 * This Delegate is called from the extension point.  It in turn calls a Wizard
 * that 
 */
public class OCLQueryDelegate
	extends AbstractQueryDelegate implements IExecutableExtension {

	private static String TITLE = QueryOCLMessages.oclQuery_title;
	private static String NOT_FOUND = QueryOCLMessages.oclQuery_message_notFound;
	
	
	
	private String pkgURIs;
	
	/**
	 * Initializes me.
	 */
	public OCLQueryDelegate() {
		super();
	}

	@Override
	public void run(IAction action) {
		Collection<EObject> selection = getSelectedObjects();
		
		if (selection == null || selection.isEmpty()) {
			action.setEnabled(false);
			return;
		}

		QueryWithContextWizard wizard = getWizard();
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

	/**
	 * @return
	 */
	protected QueryWithContextWizard getWizard() {
		QueryWithContextWizard wizard = new QueryWithContextWizard(pkgURIs);
		return wizard;
	}
	
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.pkgURIs = (String)data;
	}
}
