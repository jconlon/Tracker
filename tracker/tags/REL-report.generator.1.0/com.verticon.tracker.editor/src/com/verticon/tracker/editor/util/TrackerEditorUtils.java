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
/**
 * 
 */
package com.verticon.tracker.editor.util;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_IGNORE_WINDOW;
import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.util.TrackerUtils;

/**
 * @author jconlon
 * 
 */
public class TrackerEditorUtils {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TrackerEditorUtils.class);
	
	private static final String ADD_TEMPLATE_TO_ANIMALS_OPERATION = "Add Template to Animals Operation";
	private static final String ADD_TEMPLATE_TO_PREMISES_OPERATION = "Add Template to Premises Operation";

	// Suppress default constructor for noninstantiability
	private TrackerEditorUtils() {
		throw new AssertionError();
	}

	/**
	 * Processes the selection to creates a TagsBean.
	 * 
	 * @param editor
	 * @param selection
	 * @return TagsBean
	 * @throws FileNotFoundException
	 */
	private static final TagsBean getTagsBean(IPremisesProvider editor,
			ISelection selection) throws FileNotFoundException {
		IResource resource = getSelectedResource(editor, selection);
		
		logger.info(bundleMarker,"Adding tags from resource {}", resource.getFullPath());
		Scanner sc = null;
		//Use a list to keep order Ticket #382
		List<Long> tagNumbers = null;
		FileNotFoundException ex = null;
		try {
			sc = new Scanner(new File(resource.getLocationURI()));
			tagNumbers = new ArrayList<Long>(5);
			Long tagNumber;
			while (sc.hasNextLong()) {
				tagNumber = sc.nextLong();
				if(tagNumbers.contains(tagNumber)){
					continue;
				}
				tagNumbers.add(tagNumber);
			}

		} catch (FileNotFoundException e) {
			ex = e;
		} finally {
			if(sc !=null){
				sc.close();
			}
			if (ex != null) {
				throw ex;
			}
		}

		Date dateOfTags = createDateFromResourceName(resource);

		TagsBean tagsBean = new TagsBean(dateOfTags, tagNumbers, resource
				.getFullPath().toOSString());
		return tagsBean;
	}
	
	/**
	 * 
	 * @param adaptable
	 * @param selection
	 * @return TagsBean
	 * @throws FileNotFoundException
	 */
	public static final TagsBean getTagsBean(IAdaptable adaptable,
			ISelection selection) throws FileNotFoundException {
		IPremisesProvider premisesProvider = (IPremisesProvider)adaptable.getAdapter(IPremisesProvider.class);
		if(premisesProvider==null){
			throw new IllegalArgumentException("adaptable parameter does not support a IPremisesProvider");
		}
		return getTagsBean(premisesProvider,
				 selection);
	}

	


	/**
	 * Add an animal template to the premises.  Duplicate tags will be ignored.
	 * 
	 * @param premises
	 * @param tagsBean
	 * @param animalTemplateBean
	 * @param editor
	 */
	public static final void addTagsAndTemplate(Premises premises, TagsBean tagsBean,
			AnimalTemplateBean animalTemplateBean, IEditorPart editor) {
		
		IPremisesProvider premisesProvider = (IPremisesProvider)editor.getAdapter(IPremisesProvider.class);
		if(premisesProvider==null){
			MessageDialog.openError(editor.getSite().getShell(),
					ADD_TEMPLATE_TO_PREMISES_OPERATION, "The Active Editor does not support a IPremisesProvider");
			return;
		}
		
		// The date in the templateBean takes precedence over the date in the tagsBean
		// Setting a date in that is before the reference date will create a
		// date that is the current time.
		if (animalTemplateBean.getDate() == null) {
			animalTemplateBean.setDateForAllEvents(tagsBean.getDate());
		}

		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;
		int newAnimalsCreated = 0;

		int existingAnimals = 0;
		int deferedEvents = 0;
		for (Long tag : tagsBean.getTags()) {
			Animal animal = premises.findAnimal(tag.toString());
			if (animal != null) {
				existingAnimals++;
				Collection<Event> potentialEventsToAdd = animalTemplateBean.getEvents(premises);
				Tag activeTag = animal.activeTag()!=null?animal.activeTag():animal.getTags().get(0);
									
				Collection<Event> eventsToAddThatWhereNotDeferred = filterOutDeferedEvents(activeTag, potentialEventsToAdd);
				
				deferedEvents = deferedEvents + (potentialEventsToAdd.size() - eventsToAddThatWhereNotDeferred.size());
				command = createAddCommand(activeTag, premisesProvider.getEditingDomain(),
						eventsToAddThatWhereNotDeferred);

				
			} else {
				try {
					animal = animalTemplateBean.getAnimal(tag.toString(),premises);
					command = AddCommand.create(
							premisesProvider.getEditingDomain(), //Domain
							premises, //Owner
							TrackerPackage.Literals.PREMISES__ANIMALS,
							animal//value
					);
					newAnimalsCreated++;
				} catch (PremisesPolicyException e) {
					logger.warn(bundleMarker,"Did not create a new animal for tag={}.",tag,e);
				}
				
			}
			if(command !=null){
				compoundCommand.append(command);
			}
		}
		premisesProvider.getEditingDomain().getCommandStack().execute(compoundCommand);
		MessageDialog.openInformation(editor.getSite().getShell(),
				ADD_TEMPLATE_TO_PREMISES_OPERATION, "The "
						+ animalTemplateBean.getFileNameOfTemplate() + " and " + tagsBean.getName()
						+ " processed " + animalTemplateBean.getEvents(null).size()
						+ " events on " + newAnimalsCreated
						+ " new Animals and " + existingAnimals
						+ " existing animals. With "+deferedEvents+" events deferred.");
	}

	/**
	 * Add an animal template to the animals.  Duplicate tags tags will be ignored.
	 * 
	 * @param animals
	 * @param templateBean
	 * @param editor
	 */
	public static final void addTemplateToAnimals(Collection<Animal> animals,
			AnimalTemplateBean templateBean, IEditorPart editor) {
		IPremisesProvider premisesProvider = (IPremisesProvider)editor.getAdapter(IPremisesProvider.class);
		if(premisesProvider==null){
			MessageDialog.openError(editor.getSite().getShell(),
					ADD_TEMPLATE_TO_ANIMALS_OPERATION, "The Active Editor does not support a IPremisesProvider");
			return;
		}
		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;
		int numberOfEventsInTemplate = templateBean.numberOfEvents();
		int deferedEvents = 0;
		for (Animal animal : animals) {
			if (animal.getTags() == null || animal.getTags().isEmpty()) {
				// show dialog
				MessageDialog.openError(editor.getSite().getShell(),
						"Failed to add template",
						"No tag is assigned to animal " + animal + ".");
				continue;
			}
			Tag tag = animal.activeTag();
			if (tag == null) {
				tag = animal.getTags().get(0);
			}
			Collection<Event> potentialEventsToAdd = templateBean.getEvents((Premises)animal.eContainer());
			Collection<Event> eventsToAddTheWhereNotDeferred = filterOutDeferedEvents(
					animal.activeTag(), potentialEventsToAdd);
			deferedEvents = deferedEvents + (potentialEventsToAdd.size() - eventsToAddTheWhereNotDeferred.size());
			
			command = createAddCommand(animal.activeTag(), premisesProvider.getEditingDomain(),
					eventsToAddTheWhereNotDeferred);
			if(command !=null){
				compoundCommand.append(command);
			}
		}

		try {
			premisesProvider.getEditingDomain().getCommandStack().execute(compoundCommand);
			MessageDialog.openInformation(editor.getSite().getShell(),
					ADD_TEMPLATE_TO_ANIMALS_OPERATION, "The "
							+ templateBean.getFileNameOfTemplate() + " processed "
							+ numberOfEventsInTemplate + " events on "
							+ animals.size() + " animals.  With "+deferedEvents+" events deferred.");
		} catch (Exception e) {
			MessageDialog.openError(editor.getSite().getShell(), 
					ADD_TEMPLATE_TO_ANIMALS_OPERATION, 
					"Failed to add Template Events because: " + e);
			
		}

	}

	public static final Collection<Animal> getSelectedAnimals(
			ISelection selection) {
		ArrayList<Animal> selectedAnimals = new ArrayList<Animal>();
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				Object o = iter.next();
				if (o instanceof Animal) {
					selectedAnimals.add((Animal) o);
				}
			}
		}
		return selectedAnimals;
	}


	/**
	 * @param tag
	 * @param editingDomain
	 * @param eventsToAdd
	 * @return AddCommand
	 */
	private static Command createAddCommand(Tag tag,
			EditingDomain editingDomain, Collection<Event> eventsToAdd) {
		Command command = null;
		if(!eventsToAdd.isEmpty()){
			command = AddCommand.create(editingDomain, tag,
					TrackerPackage.eINSTANCE.getTag(), eventsToAdd);
		}
	    
		return command;
	}

	/**
	 * @param tag
	 * @param events
	 * @return Collection of Events without the deferred events
	 */
	private static Collection<Event> filterOutDeferedEvents(Tag tag,
			Collection<Event> events) {
		if(tag==null){
			throw new NullPointerException("tag argument cannot be null");
		}
		Collection<Event> eventsToAdd = new ArrayList<Event>();
		for (Event event : events) {
			
			if(TrackerEditorUtils.canAddEventToAnimal((Animal)tag.eContainer(), event) ){
				//FIXME to not add concurrent times
				eventsToAdd.add(event);
				
			}
		}
		return eventsToAdd;
	}
	
	

	

	private static IResource getSelectedResource(IPremisesProvider editor,
			ISelection selection) {
		IResource resource = null;
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				resource = (IResource) iter.next();
			}
		}
		return resource;
	}

	protected static Resource getResource(IFile file) throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		return resource;
	}


	public static final IResource extractResource(IEditorPart editor) {
		if(editor==null){
			return null;
		}
		IEditorInput input = editor.getEditorInput();
		if (!(input instanceof IFileEditorInput))
			return null;
		return ((IFileEditorInput) input).getFile();
	}

	private static final Date createDateFromResourceName(IResource resource) {
		String fileName = resource.getName().substring(0,
				resource.getName().indexOf('.'));
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyMMddHHmmss");
		Date date = null;
		try {
			date = dateFormater.parse(fileName);
		} catch (ParseException e) {
			return null;
		}

		return date;
	}

	public static List<String> getModelInstances(EClass superEClass) {

		List<String> initialObjectNames = new ArrayList<String>();

		for (EClassifier eClassifier : TrackerPackage.eINSTANCE
				.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (!eClass.isAbstract()) {
					if (superEClass.isSuperTypeOf(eClass)) {
						initialObjectNames.add(eClass.getName());
					}

				}
			}
		}
		Collections.sort(initialObjectNames, CommonPlugin.INSTANCE
				.getComparator());

		return initialObjectNames;
	}

	protected static boolean validate(Premises premises,
			List<Diagnostic> validationDiagnostics) {
		validationDiagnostics.clear();
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(premises);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			validationDiagnostics.add(diagnostic);
		}
		return validationDiagnostics.isEmpty();
	}

	public static Premises getPremises(IFile file) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		if (resource.getContents().get(0) instanceof Premises) {
			return (Premises) resource.getContents().get(0);
		}
		throw new IOException("Cannot process the file " + file.getName()
				+ ", because it is not a Tracker Model Document!");
	}
	
	/**
	 * Preference policy to avoid adding duplicates.
	 * @param animalToReceiveEvent
	 * @param eventToAdd
	 * @return true if the event can be added
	 */
	public static boolean canAddEventToAnimal(Animal animalToReceiveEvent, Event eventToAdd){
		//Get rid of the Explicit Document Policy violations first
		String ocdId = null;
		if(eventToAdd instanceof GenericEvent){
			ocdId = ((GenericEvent)eventToAdd).getOcd().getID();
		}
		if(!animalToReceiveEvent.canContain(TrackerUtils.getType(eventToAdd), ocdId)){
			return false;
		}
		for (Event historicalEvent : animalToReceiveEvent.eventHistory()) {
			if (historicalEvent.getEventCode() == eventToAdd.getEventCode()) {
				Date historicalEventDate = historicalEvent.getDateTime();
				Date eventToAddDate = eventToAdd.getDateTime();
				//Subtract the timeout interval seconds from the eventToAddDate
				Calendar cal = Calendar.getInstance();
				cal.setTime(eventToAddDate);
				IPreferenceStore store = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
				int timeoutWindow = store.getInt(P_IGNORE_WINDOW);
				cal.add(Calendar.SECOND, -timeoutWindow);
				Date subtractedDate = cal.getTime();
				if(historicalEventDate.after(subtractedDate)){
					logger.info(bundleMarker,
							"Defered adding the event {} to the animal {} because it's dateTime {} is within {} second(s) of an similar event on the animal. Check the duplicate event window in user preferences.",
							new Object[] {
										eventToAdd.getClass().getSimpleName(), 
										animalToReceiveEvent.getId(),
										eventToAddDate,
										timeoutWindow}
					);
					return false;
				}

			}
		}
		return true;
	}
	
	public static final Collection<Event> getSelectedEvents(
			ISelection selection) {
		ArrayList<Event> selectedEvents = new ArrayList<Event>();
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				Object o = iter.next();
				if (o instanceof Event) {
					selectedEvents.add((Event) o);
				}
			}
		}
		return selectedEvents;
	}
	
	public static final IValidator singleSelectionValidator = new IValidator(){
		@Override
		public IStatus validate(Object value) {
			if(value==null){
				return ValidationStatus.info("Please select an event");
			}
			return ValidationStatus.ok();
		}
	};

	private static final String APPEND_INSTRUCTION = 
		"\n\nThis looks for animal template files inside the project associated with the active editor."+
		" To use, make sure that the active editor has opened a file from a project that contains at least one animal template file.";
	
	public static IProject hasTemplates(IWorkbench iworkbench)throws PartInitException {
		IProject result = null;
		//Project
		if (iworkbench != null){
			IWorkbenchWindow iworkbenchwindow = iworkbench.getActiveWorkbenchWindow();
				if (iworkbenchwindow != null){
						IWorkbenchPage iworkbenchpage = iworkbenchwindow.getActivePage();
							if (iworkbenchpage != null){
								IEditorPart editor = iworkbenchpage.getActiveEditor();
								result = getProject(editor);

							}
				}
		}

		return result;
	}

	public static IProject getProject(IEditorPart editor) throws PartInitException {
		IProject result = null;
		if(editor ==null){
			throw new PartInitException("Could not find an active editor."+APPEND_INSTRUCTION);
		}else{
			IResource resource = TrackerEditorUtils.extractResource(editor);
			if(resource == null){
				throw new PartInitException("Could not find any resources in the active editor."+APPEND_INSTRUCTION);
			}else{
				IProject project = resource.getProject();
				TemplateVisitor visitor = new TemplateVisitor();
				try {
					project.accept(visitor);
					result = visitor.foundTemplate?project:null;
				} catch (CoreException e) {
					throw new PartInitException(e.getLocalizedMessage());
				}
			}

		}
		return result;
	}

	
}

class TemplateVisitor implements IResourceVisitor{
	boolean foundTemplate = false;
	@Override
	public boolean visit(IResource resource) throws CoreException {
		if(resource.getFileExtension()!=null && resource.getFileExtension().equals("animal")){
			foundTemplate = true;
		}
		return !foundTemplate;
	}
	
}
