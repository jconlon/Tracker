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

package com.verticon.tracker.ocl.query.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.jface.wizard.Wizard;


/**
 * Partial implementation of an OCL query wizard.
 */
abstract class AbstractQueryWizard
	extends Wizard {

	private IOCLQueryWizardPage page;
	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
	private final String pkgURIs;
	/**
	 * Initializes me.
	 */
	protected AbstractQueryWizard(String pkgURIs) {
		super();
		this.pkgURIs=pkgURIs;
	}

	@Override
	public void addPages() {
		super.addPages();
		
		page = createOclQueryPage(pkgURIs);
		addPage(page);
	}
	
	@Override
	public boolean performFinish() {
		condition = page.getCondition();
		
		return condition != null;
	}
	
	/**
	 * Implemented by subclasses to create the wizard page.
	 *
	 *@return the wizard page
	 */
	protected abstract IOCLQueryWizardPage createOclQueryPage(String pkgURIs);

	/**
	 * Obtains the OCL constraint condition specified by the user.
	 * 
	 * @return the condition, or <code>null</code> if the user canceled or
	 *     has not yet finished the wizard
	 */
	public BooleanOCLCondition<EClassifier, EClass, EObject> getCondition() {
		return condition;
	}
}
