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
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.util.CommonUtilities;

/**
 * ActionDelegate associated with a pop-up menu to Add Template Events on a selection of 
 * animal objects.  Adds Events from a template to these selected Animal. 
 * 
 * Prompts the user for a template selection.
 * Uses dates associated with the template events.
 * 
 * 
 * @author jconlon
 * 
 */
public class AddTemplatedEventsToSelectedAnimals implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;

	private ISelection selection;
	
	protected IResource resource;
	
	

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

		Premises premisesTemplate = askForPremisesTemplate("Choose an Event template to add to these "
				+ selectedAnimals.size() + " selected animals.",project);
		
		if(premisesTemplate==null){
			return;
		}
		
		processSelected(editingDomain, selectedAnimals,  premisesTemplate, null);
	}
	
	
	
	private Premises askForPremisesTemplate(String message, IResource rootElement){

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
			templateResource = AddTemplateEventsToCaptureAins.getResource(f);
		} catch (IOException e) {
			MessageDialog.openError(
			          targetPart.getSite().getShell(),
						"Failed to load template "+resource.getFullPath(),
						e.getLocalizedMessage());
				return null;
		}
		return CommonUtilities.getPremisesFromTemplate(templateResource);
	}
	
	/**
	 * Add the events from the premisesTemplate to the selectedAnimals.
	 * REWORK implement
	 * @param editingDomain
	 * @param selectedAnimals
	 * @param premisesTemplate
	 * @param date
	 */
	private void processSelected(EditingDomain editingDomain,Collection<Animal> selectedAnimals, Premises premisesTemplate, Date date){		
//		List<Event> eventsForAllAnimals = new ArrayList<Event>();
//		Collection<Event> eventsPerAnimal;
//		for (Animal animal : selectedAnimals) {
//			 eventsPerAnimal = CommonUtilities.createEvents( premisesTemplate,  animal.getAin(),  premises);
//			 eventsForAllAnimals.addAll(eventsPerAnimal);
//		}
//		
//		
//		if (eventsForAllAnimals.isEmpty()) {
//			MessageDialog.openWarning(targetPart.getSite().getShell(),
//					"No unique tags in file",
//					"Found no unique events to import from template "+resource.getFullPath());
//			return;
//		}
//		
//		
//		Command command = AddCommand.create(
//				editingDomain, 
//				eventHistory,
//				TrackerPackage.eINSTANCE.getEventHistory_Events(), 
//				eventsForAllAnimals);
//		editingDomain.getCommandStack().execute(command);
//
//
//		MessageDialog.openInformation(targetPart.getSite().getShell(),
//				"Add to EventHistory", 
//				"Added " + 
//				eventsForAllAnimals.size() + 
//				" children  to EventHistory");
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
			for (Iterator<?> iter = ((IStructuredSelection) selection).iterator(); iter
					.hasNext();) {
				Object o = iter.next();
				if(o instanceof Animal){
					selectedAnimals.add((Animal) iter.next());
				}
			}
		}
		return selectedAnimals;
	}

}
