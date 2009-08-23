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
