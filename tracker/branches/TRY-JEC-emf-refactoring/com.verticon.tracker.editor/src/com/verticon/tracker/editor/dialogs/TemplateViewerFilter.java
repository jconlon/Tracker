package com.verticon.tracker.editor.dialogs;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TemplateViewerFilter extends ViewerFilter {
	
	String extensionTarget ="animal";

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
            
            //FIXME rework the following after removal of TrackerTemplate and addition of TrackerAnimalModelWizard
            
//            try {
//				String prop = resource.getPersistentProperty(
//						TrackerTemplateWizard.TRACKER_FILE_TYPE);
//				return TrackerTemplateWizard.TRACKER_FILE_TYPE_TEMPLATE.equals(prop);
//			} catch (CoreException e) {
//				return false;
//			}
            
        }
        return false;
	}

}
