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

import org.eclipse.jface.wizard.IWizardPage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;


/**
 * Interface for OCL query wizard pages to provide the query condition.
 */
interface IOCLQueryWizardPage
	extends IWizardPage {
	
	/**
	 * Obtains the OCL constraint condition specified by the user in this page.
	 * 
	 * @return the condition, or <code>null</code> if the page is not complete
	 *     or the user canceled the wizard
	 */
	BooleanOCLCondition<EClassifier, EClass, EObject> getCondition();
}
