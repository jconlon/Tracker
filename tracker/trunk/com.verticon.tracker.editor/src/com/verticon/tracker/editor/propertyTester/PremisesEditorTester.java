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
package com.verticon.tracker.editor.propertyTester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;

import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Tests that the active Editor manages a Premises and is using a non-transaction based
 * editing domain.
 * 
 * @author jconlon
 *
 */
public class PremisesEditorTester extends PropertyTester {
	

	private static final String IS_PREMISES_EDITOR = "isPremisesEditor";
	
	private static final String IS_SIMPLE_PREMISES_EDITOR = "isSimplePremisesEditor";
	/**
	 * @return true if Active Editor is managing a Premises and is non-transactional.
	 */
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		
		boolean passedTest = false;
		if(IS_PREMISES_EDITOR.equals(property)){
			passedTest = validateIsPremisesEditor();
		}else
		if(IS_SIMPLE_PREMISES_EDITOR.equals(property)){
			
			passedTest =  validateIsSimplePremisesEditor();
		}
	    
		return passedTest;
	}

	
	private boolean validateIsPremisesEditor() {
		IPremisesProvider premisesProvider = getPremisesProvider();
		return premisesProvider!=null&&
				premisesProvider.getPremises()!=null;
	}
	
	private boolean validateIsSimplePremisesEditor() {
		IPremisesProvider premisesProvider = getPremisesProvider();
		return premisesProvider!=null && validateEditingDomain( premisesProvider);
	}
	
	protected boolean validateEditingDomain(IPremisesProvider premisesProvider){
		if(premisesProvider.getPremises()!=null){
			EditingDomain ed = premisesProvider.getEditingDomain();
			//Basic Editing domain will be a org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
			//Transaction will be org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl
//			System.out.println("Editing domain is a "+ed);
			
			return ed.getClass().equals(AdapterFactoryEditingDomain.class);
		}
		return false;
	}
	
	private IPremisesProvider getPremisesProvider(){
		IWorkbench wb = PlatformUI.getWorkbench();
		if(wb == null){
			return null;
		}
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		if(win == null){
			return null;
		}
		IWorkbenchPage page = win.getActivePage();
		if(page == null){
			return null;
		}
		IEditorPart editor = page.getActiveEditor();
		if(editor == null){
			return null;
		}   
		
		IPremisesProvider premisesProvider = null;
		if(editor instanceof MultiPageEditorPart){
			MultiPageEditorPart multiPageEditorPart = (MultiPageEditorPart)editor;
			Object obj = multiPageEditorPart.getAdapter(IPremisesProvider.class);
			if(obj != null){
			    premisesProvider = (IPremisesProvider)obj;
				
			}
		}
		return premisesProvider;
	}

}
