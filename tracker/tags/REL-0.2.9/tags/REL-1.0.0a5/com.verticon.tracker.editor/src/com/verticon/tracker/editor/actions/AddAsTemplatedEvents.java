/**
 * 
 */
package com.verticon.tracker.editor.actions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * @author jconlon
 *
 */
public class AddAsTemplatedEvents extends AbstractAddAsEvent {

	EventHistory template = null;

	/**
	 * Find the template file, and get the EventHistory from it.
	 */
	@Override
	public void run(IAction action) {
		TrackerEditor editor = getTrackerEditor(targetPart);
		if(editor==null){
			//TODO Add a warning dialog here.
			return;
		}
		
		IProject project = extractResource( editor).getProject();
		
		WSFileDialog dialog = 
			new WSFileDialog(
					targetPart.getSite().getShell(), 
					SWT.SINGLE, 
					"Select a template", 
					project, 
					true, 
					new String[]{"tracker"}, 
					null);
		
		dialog.setPatternFilter(new TemplateViewerFilter());
		
		if(dialog.open()==Window.CANCEL){
	    	return;
	    }
	
		IResource result = dialog.getSingleResult();
		if(result == null){
			return;
		}
		IFile f = (IFile)result;
		
		Resource templateResource;
		try {
			templateResource = getResource(f);
		} catch (IOException e) {
			MessageDialog.openError(
			          targetPart.getSite().getShell(),
						"Failed to load a template",
						e.getLocalizedMessage());
				return;
		}
		template = getEventHistory(templateResource);
		
		if(template==null){
			return;
		}

		processSelection(editor);

	}
	
	public static EventHistory getEventHistory(Resource resource){
		Object o = resource.getContents().get(0);
		if(o instanceof EventHistory){
			return (EventHistory)o;
		}
		return null;
	}

    public static Resource getResource(IFile file) throws IOException {
		      
		           ResourceSet resourceSet = new ResourceSetImpl();
		
		            URI uri = URI.createPlatformResourceURI(file.getFullPath()
		                    .toString());
		            Resource resource = resourceSet.createResource(uri);
		            if (!resource.isLoaded()) {
		                resource.load(null);
		            }
		            return resource;
    }

	/**
	 * return a copy the events in the template
	 */
	@Override
	protected Collection<Event> createEvents(TrackerFactory trackerFactory, AnimalId animalId, Long tag) {
		Copier copier = new Copier();	  
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Object o : template.getEvents()) {
			Event templateEvent =(Event)o;
			if(!containsEvent(tag, templateEvent.getEventCode()) ){
				outputEvent= (Event) copier.copy(templateEvent);
				outputEvent.setAin(animalId);
				outputEvent.setDateTime(findDate());
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
//	IResource extractSelection(ISelection sel) {
//	      if (!(sel instanceof IStructuredSelection))
//	         return null;
//	      IStructuredSelection ss = (IStructuredSelection) sel;
//	      Object element = ss.getFirstElement();
//	      if (element instanceof IResource)
//	         return (IResource) element;
//	      if (!(element instanceof IAdaptable))
//	         return null;
//	      IAdaptable adaptable = (IAdaptable)element;
//	      Object adapter = adaptable.getAdapter(IResource.class);
//	      return (IResource) adapter;
//	   }


}
