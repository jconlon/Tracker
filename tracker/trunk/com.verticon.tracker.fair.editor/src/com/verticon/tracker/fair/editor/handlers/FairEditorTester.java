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
package com.verticon.tracker.fair.editor.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;

import com.verticon.tracker.fair.editor.presentation.IFairProvider;

/**
 * Tests that the active Editor manages a Premises and is using a non-transaction based
 * editing domain.
 * 
 * @author jconlon
 *
 */
public class FairEditorTester extends PropertyTester {
	

	private static final String IS_FAIR_EDITOR = "isFairEditor";
	
	private static final String IS_SIMPLE_FAIR_EDITOR = "isSimpleFairEditor";
	/**
	 * @return true if Active Editor is managing a Premises and is non-transactional.
	 */
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		
		boolean passedTest = false;
		if(IS_FAIR_EDITOR.equals(property)){
			passedTest = validateIsFairEditor();
		}else
		if(IS_SIMPLE_FAIR_EDITOR.equals(property)){
			
			passedTest =  validateIsSimpleFairEditor();
		}
	    
		return passedTest;
	}

	
	private boolean validateIsFairEditor() {
		IFairProvider fairProvider = getFairProvider();
		return fairProvider!=null && fairProvider.getFair()!=null;
	}
	
	private boolean validateIsSimpleFairEditor() {
		IFairProvider fairProvider = getFairProvider();
		return fairProvider!=null && validateEditingDomain( fairProvider);
	}
	
	protected boolean validateEditingDomain(IFairProvider fairProvider){
		if(fairProvider.getFair()!=null){
			EditingDomain ed = fairProvider.getEditingDomain();
			//Basic Editing domain will be a org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain
			//Transaction will be org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl
//			System.out.println("Editing domain is a "+ed);
			
			return ed.getClass().equals(AdapterFactoryEditingDomain.class);
		}
		return false;
	}
	
	static IFairProvider getFairProvider(){
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
		
		IFairProvider fairProvider = null;
		if(editor instanceof MultiPageEditorPart){
			MultiPageEditorPart multiPageEditorPart = (MultiPageEditorPart)editor;
			Object obj = multiPageEditorPart.getAdapter(IFairProvider.class);
			if(obj != null){
			    fairProvider = (IFairProvider)obj;
				
			}
		}
		return fairProvider;
	}

}
