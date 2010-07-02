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
package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface used by Add New Exhibit WizardPage specifying chaining callback
 * functionality between the New Exhibit WizardPages.
 * 
 * @author jconlon
 * 
 */
public interface AddExhibitWizardPageParent extends IWizardPage {
	Command getCommand(EObject eObject);
	
	boolean newTargetHasValue();
	
	IObservableValue getSelectedTarget();
}
