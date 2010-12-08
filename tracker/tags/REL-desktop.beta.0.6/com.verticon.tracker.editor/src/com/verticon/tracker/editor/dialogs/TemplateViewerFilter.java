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
package com.verticon.tracker.editor.dialogs;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TemplateViewerFilter extends ViewerFilter {
	
	private final static String extensionTarget ="animal";

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
        IResource resource = null;
        if (element instanceof IResource) {
            resource = (IResource) element;
        } else if (element instanceof IAdaptable) {
            IAdaptable adaptable = (IAdaptable) element;
            resource = (IResource) adaptable.getAdapter(IResource.class);
        }
        if (resource != null && !resource.isDerived()) {
        	   if (resource.getType() != IResource.FILE) {
        		   return true;
        	   }
            String extension = resource.getFileExtension();
            if(extension==null){
            	return false;
            }
            if (!extension.equalsIgnoreCase(extensionTarget)) {
            	return false;
            }
            
            return true;
        }
        return false;
	}

}
