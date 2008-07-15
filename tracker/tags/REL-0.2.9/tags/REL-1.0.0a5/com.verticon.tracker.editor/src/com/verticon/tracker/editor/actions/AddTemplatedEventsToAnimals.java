/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * ActionDelegate associated with animal objects in order to add Events from 
 * a template to the Animal selections. 
 * 
 * Prompts the user for a template selection.
 * Uses dates associated with the template events.
 * 
 * 
 * @author jconlon
 * 
 */
public class AddTemplatedEventsToAnimals implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;

	private ISelection selection;
	
	protected IResource resource;

	/**
	 * 
	 */
	public AddTemplatedEventsToAnimals() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		Collection<Animal> selectedAnimals = getAnimals(selection);
		if(selectedAnimals.isEmpty())throw new IllegalStateException("Action called but no animals are selected.");
		
		TrackerEditor editor = AbstractAddToParentActionDelegate.getTrackerEditor(targetPart);
		IProject project = AbstractAddToParentActionDelegate.extractResource(editor).getProject();
		EditingDomain editingDomain = editor.getEditingDomain();

//		Date date =  askForDate();
		EventHistory template = askForTemplate("Choose an Event template to add to these "
				+ selectedAnimals.size() + " selected animals.",project);
		
		if(template==null){
			return;
		}
		
		processSelected(editingDomain, selectedAnimals,  template, null);
	}
	
	/**
	 * "MM/dd/yy HH:mm:ss"
	 * "yyMMddHHmmss"
	 * "yyyy.MM.dd.HH.mm.ss"
	 * 
	 * @return
	 */
//	private Date askForDate(){
//		String s;
//		SimpleDateFormat dateFormater = new SimpleDateFormat("yyMMddHHmmss");
//		Date date = null;
//		try {
//			 date = dateFormater.parse(s);
//		} catch (ParseException e) {
//			return new Date();
//		}
//		return new Date();
//	}
	
	private EventHistory askForTemplate(String message, IResource rootElement){

		WSFileDialog dialog = new WSFileDialog(targetPart.getSite().getShell(),
				SWT.SINGLE, 
				message,
				rootElement, 
				true, 
				new String[] { "tracker" },
				null);

		dialog.setPatternFilter(new TemplateViewerFilter());

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

	    resource = dialog.getSingleResult();
		if (resource == null) {
			return null;
		}

		IFile f = (IFile)resource;
		
		Resource templateResource;
		try {
			templateResource = AddAsTemplatedEvents.getResource(f);
		} catch (IOException e) {
			MessageDialog.openError(
			          targetPart.getSite().getShell(),
						"Failed to load template "+resource.getFullPath(),
						e.getLocalizedMessage());
				return null;
		}
		return AddAsTemplatedEvents.getEventHistory(templateResource);
	}
	
	private void processSelected(EditingDomain editingDomain,Collection<Animal> selectedAnimals, EventHistory template, Date date){
		Premises premises = (Premises)selectedAnimals.iterator().next().eContainer().eContainer();
		EventHistory eventHistory = premises.getEventHistory();
		
		List<Event> eventsForAllAnimals = new ArrayList<Event>();
		Collection<Event> eventsPerAnimal;
		for (Animal animal : selectedAnimals) {
			 eventsPerAnimal = createEvents( template,  animal,  premises);
			 eventsForAllAnimals.addAll(eventsPerAnimal);
		}
		
		
		if (eventsForAllAnimals.isEmpty()) {
			MessageDialog.openWarning(targetPart.getSite().getShell(),
					"No unique tags in file",
					"Found no unique events to import from template "+resource.getFullPath());
			return;
		}
		
		
		Command command = AddCommand.create(
				editingDomain, 
				eventHistory,
				TrackerPackage.eINSTANCE.getEventHistory_Events(), 
				eventsForAllAnimals);
		editingDomain.getCommandStack().execute(command);


		MessageDialog.openInformation(targetPart.getSite().getShell(),
				"Add to EventHistory", 
				"Added " + 
				eventsForAllAnimals.size() + 
				" children  to EventHistory");
	}
	
	protected Collection<Event> createEvents(EventHistory template, Animal animal, Premises premises) {
		Copier copier = new Copier();	  
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Object o : template.getEvents()) {
			Event templateEvent =(Event)o;
			if(canAddEventToAnimal(animal, templateEvent, premises) ){
				outputEvent= (Event) copier.copy(templateEvent);
				outputEvent.setAin(animal.getAin());
//				outputEvent.setDateTime(date);
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
	/**
	 * TODO create a preference policy for adding duplicates.
	 * @param animal
	 * @param event
	 * @param premises
	 * @return true if no similar event is associated with the animal
	 */
	public static boolean canAddEventToAnimal(Animal animal, Event event, Premises premises){
		List elist = premises.getEventHistory().getEvents();
		for (Object object : elist) {
			Event ev = (Event) object;
			if (ev.getEventCode() == event.getEventCode() && ev.getAin() == animal.getAin()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());
	}

	public static final Collection<Animal> getAnimals(ISelection selection) {
		ArrayList<Animal> selectedAnimals = new ArrayList<Animal>();
		if (selection instanceof IStructuredSelection) {
			for (Iterator iter = ((IStructuredSelection) selection).iterator(); iter
					.hasNext();) {
				selectedAnimals.add((Animal) iter.next());
			}
		}
		return selectedAnimals;
	}

}
