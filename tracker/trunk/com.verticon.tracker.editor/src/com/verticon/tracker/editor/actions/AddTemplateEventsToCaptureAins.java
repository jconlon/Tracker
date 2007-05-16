/**
 * 
 */
package com.verticon.tracker.editor.actions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.util.CommonUtilities;

/**
 * Action associated with a selection on a Capture *.tags file.  Prompts the user to select a PremisesTemplate
 * of Events to add to the set of animals associated with the AINs in the capture *.tags file.
 * 
 * For AINs that are not already assigned to animals an animal will be created if there is an animal in the 
 * PremisesTemplate.  Only the first animal is used all others are ignored.
 * 
 * Capture *.tags files can also contain a timestamp in their name.  This will be the default date for all events
 * overriding any event dates in the PremisesTemplates.
 * 
 * TODO change class name to AddTemplateEventsToCaptureAins
 * @author jconlon
 * 
 */
public class AddTemplateEventsToCaptureAins extends AbstractAddAsEvent {

	EventHistory eventHistoryTemplate = null;
	Animal defaultAnimal = null;

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
		eventHistoryTemplate = CommonUtilities.getEventHistoryFromTemplate(templateResource);
		
		defaultAnimal = CommonUtilities.getDefaultAnimalFromTemplate(templateResource);
		
		if(eventHistoryTemplate==null && defaultAnimal ==null){
			System.out.println("eventHistory="+eventHistoryTemplate+" defaultAnimal="+defaultAnimal);
			return;
		}

		processSelection(editor);

	}

	/**
	 * If there is a datestamp encoded in the capture file update the eventHistory to override them.
	 */
	private void overrideEventHistoryTemplateDatesIfNecessary() {
		Date date = createDateFromResourceName();
		if(date!=null){
			for (Object object : eventHistoryTemplate.getEvents()) {
				((Event )object).setDateTime(date);
			}
		}
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
	 * 
	 * return a copy the events in the template
	 */
	@Override
	protected Collection<Event> createEvents(TrackerFactory trackerFactory, AnimalId animalId, Long tag) {
		overrideEventHistoryTemplateDatesIfNecessary();
		return CommonUtilities.createEvents(eventHistoryTemplate,  animalId,  premises);
	}

}
