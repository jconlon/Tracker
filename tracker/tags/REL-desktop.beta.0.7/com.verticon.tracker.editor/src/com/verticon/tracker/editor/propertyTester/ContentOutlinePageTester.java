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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/**
 * Tests that the active Editor adapts a IContentOutlinePage
 * 
 * @author jconlon
 *
 */
public class ContentOutlinePageTester extends PropertyTester {
	

	/**
	 * @return true if Active Editor adapts a IContentOutlinePage.
	 */
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		IViewReference[] viewrefs=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference iViewReference : viewrefs) {
			if(iViewReference.getId().equals(IPageLayout.ID_OUTLINE)){
				IContentOutlinePage contentOutlinePage = getContentOutlinePage();
				return contentOutlinePage!=null;
			}
				
		}
		return false;
	}
	
	
	private IContentOutlinePage getContentOutlinePage(){
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
		
		IContentOutlinePage contentOutlinePage = null;
		if(editor instanceof MultiPageEditorPart){
			MultiPageEditorPart multiPageEditorPart = (MultiPageEditorPart)editor;
			Object obj = multiPageEditorPart.getAdapter(IContentOutlinePage.class);
			if(obj != null){
			    contentOutlinePage = (IContentOutlinePage)obj;
				
			}
		}
		return contentOutlinePage;
	}

}
