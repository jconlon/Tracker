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
package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.custom.CTabFolder;

public interface IPropertiesFormProvider {
	
	/**
	 * Use the selection to create a Form in the cTabFolder.
	 * 
	 * @param selection
	 * @param adapterFactory
	 * @param cTabFolder
	 * @param nameOfTab
	 * @param showAdvanceProperties
	 */
	public void fillProperties(ISelection selection, 
			AdapterFactory adapterFactory, CTabFolder cTabFolder,
			String nameOfTab, boolean showAdvanceProperties);
	
	public void setStatusMessageObservable(
			IObservableValue statusMessageObservable);
	
	public WizardPage getWizardPage();

	public void setWizardPage(WizardPage wizardPage);
}
