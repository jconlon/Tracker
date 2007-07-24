package com.verticon.tracker.editor.dialogs;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.verticon.tracker.editor.presentation.TrackerTemplateWizard;

public class TemplateViewerFilter extends ViewerFilter {
	
	String extensionTarget ="tracker";

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
            if (!extension.equalsIgnoreCase(extensionTarget)) {
            	return false;
            }
            
            try {
				String prop = resource.getPersistentProperty(
						TrackerTemplateWizard.TRACKER_FILE_TYPE);
				return TrackerTemplateWizard.TRACKER_FILE_TYPE_TEMPLATE.equals(prop);
			} catch (CoreException e) {
				return false;
			}
            
        }
        return false;
	}

}
