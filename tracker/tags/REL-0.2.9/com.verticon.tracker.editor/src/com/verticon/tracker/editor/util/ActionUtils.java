/**
 * 
 */
package com.verticon.tracker.editor.util;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Preferences;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.util.CommonUtilities;

/**
 * @author jconlon
 * 
 */
public class ActionUtils {

	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ActionUtils.class);
	
	private static final String ADD_TEMPLATE_TO_ANIMALS_OPERATION = "Add Template to Animals Operation";
	private static final String ADD_TEMPLATE_TO_PREMISES_OPERATION = "Add Template to Premises Operation";

	private ActionUtils() {
	}

	/**
	 * Processes the selection to creates a TagsBean.
	 * 
	 * @param editor
	 * @param selection
	 * @return
	 * @throws FileNotFoundException
	 */
	public static final TagsBean getTagsBean(IQueryDataSetProvider editor,
			ISelection selection) throws FileNotFoundException {
		IResource resource = getSelectedResource(editor, selection);
		
		logger.info("Adding tags from resource {}", resource.getFullPath());
		Scanner sc = null;
		Set<Long> tagNumbers = null;
		FileNotFoundException ex = null;
		try {
			sc = new Scanner(new File(resource.getLocationURI()));
			tagNumbers = new HashSet<Long>();
			while (sc.hasNextLong()) {
				tagNumbers.add(sc.nextLong());
			}

		} catch (FileNotFoundException e) {
			ex = e;
		} finally {
			sc.close();
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
	 * @return
	 * @throws FileNotFoundException
	 */
	public static final TagsBean getTagsBean(IAdaptable adaptable,
			ISelection selection) throws FileNotFoundException {
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)adaptable.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			throw new IllegalArgumentException("adaptable parameter does not support a IQueryDataSetProvider");
		}
		return getTagsBean(queryDataSetProvider,
				 selection);
	}

	public static final AnimalTemplateBean getTemplateBean(TrackerEditor editor,
			IWorkbenchPart targetPart) {
		Animal animal = null;
		IProject project = extractResource(editor).getProject();

		WSFileDialog dialog = new WSFileDialog(targetPart.getSite().getShell(),
				SWT.SINGLE, "Select a template", project, true,
				new String[] { "animal" }, null);

		dialog.setPatternFilter(new TemplateViewerFilter());

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		IResource result = dialog.getSingleResult();
		if (result == null) {
			return null;
		}
		IFile f = (IFile) result;

		Resource templateResource;
		try {
			templateResource = getResource(f);
		} catch (IOException e) {
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to load a template", e.getLocalizedMessage());
			return null;
		}
		animal = CommonUtilities.getAnimalFromTemplate(templateResource);

		if (animal == null) {
			MessageDialog
					.openError(targetPart.getSite().getShell(),
							"Failed to load a template",
							"Could not extract a template");

			return null;
		}

		AnimalTemplateBean templateBean = new AnimalTemplateBean(animal, f.getName());
		return templateBean;
	}

	public static final Premises getPremises(IQueryDataSetProvider editor) {
		Premises premises = null;
		EditingDomain editingDomain = editor.getEditingDomain();
		Resource modelResource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = modelResource.getContents().get(0);
		premises = (Premises) rootObject;
		return premises;
	}
	

	public static final Premises getPremises(IAdaptable adaptable) throws FileNotFoundException {
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)adaptable.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			throw new FileNotFoundException("adaptable parameter does not support a IQueryDataSetProvider");
		}
		return getPremises(queryDataSetProvider);
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
		
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)editor.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			MessageDialog.openError(editor.getSite().getShell(),
					ADD_TEMPLATE_TO_PREMISES_OPERATION, "The Active Editor does not support a IQueryDataSetProvider");
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

				Collection<Event> eventsToAddTheWhereNotDeferred = filterOutDeferedEvents(animal.activeTag(), potentialEventsToAdd);
				deferedEvents = deferedEvents + (potentialEventsToAdd.size() - eventsToAddTheWhereNotDeferred.size());
				command = createAddCommand(animal.activeTag(), queryDataSetProvider.getEditingDomain(),
						eventsToAddTheWhereNotDeferred);

				
			} else {
				newAnimalsCreated++;
				command = createAddAnimalToPremiseCommand(
						premises,
						animalTemplateBean.getAnimal(tag.toString(),premises),//adds all events as well 
						queryDataSetProvider.getEditingDomain());
				
			}
			if(command !=null){
				compoundCommand.append(command);
			}
		}
		queryDataSetProvider.getEditingDomain().getCommandStack().execute(compoundCommand);
		MessageDialog.openInformation(editor.getSite().getShell(),
				ADD_TEMPLATE_TO_PREMISES_OPERATION, "The "
						+ animalTemplateBean.getName() + " and " + tagsBean.getName()
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
		IQueryDataSetProvider queryDataSetProvider = (IQueryDataSetProvider)editor.getAdapter(IQueryDataSetProvider.class);
		if(queryDataSetProvider==null){
			MessageDialog.openError(editor.getSite().getShell(),
					ADD_TEMPLATE_TO_ANIMALS_OPERATION, "The Active Editor does not support a IQueryDataSetProvider");
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
			
			command = createAddCommand(animal.activeTag(), queryDataSetProvider.getEditingDomain(),
					eventsToAddTheWhereNotDeferred);
			if(command !=null){
				compoundCommand.append(command);
			}
		}

		queryDataSetProvider.getEditingDomain().getCommandStack().execute(compoundCommand);
		MessageDialog.openInformation(editor.getSite().getShell(),
				ADD_TEMPLATE_TO_ANIMALS_OPERATION, "The "
						+ templateBean.getName() + " processed "
						+ numberOfEventsInTemplate + " events on "
						+ animals.size() + " animals.  With "+deferedEvents+" events deferred.");

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
	 * @return
	 */
	public static Command createAddCommand(Tag tag,
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
	 * @return
	 */
	public static Collection<Event> filterOutDeferedEvents(Tag tag,
			Collection<Event> events) {
		Collection<Event> eventsToAdd = new ArrayList<Event>();
		for (Event event : events) {
			
			if(ActionUtils.canAddEventToAnimal((Animal)tag.eContainer(), event) ){
				//FIXME to not add concurrent times
				eventsToAdd.add(event);
				
			}
		}
		return eventsToAdd;
	}
	
	

	private static Command createAddAnimalToPremiseCommand(Premises premises,
			Animal animal, EditingDomain editingDomain) {
		Command command = AddCommand.create(editingDomain, premises,
				TrackerPackage.eINSTANCE.getPremises(), animal);
		return command;
	}

	private static IResource getSelectedResource(IQueryDataSetProvider editor,
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

	public static Resource getResource(IFile file) throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		return resource;
	}

	public static IQueryDataSetProvider getTrackerEditor(IWorkbenchPart targetPart) {
		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (editor == null || (!(editor instanceof TrackerEditor))) {
			logger.error("The active editor is not a TrackerEditor.");
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add tags",
					"Could not find an active TrackerEditor ");
			return null;
		}
		return (IQueryDataSetProvider) editor;
	}

	public static Event promptUserForEvent(IWorkbenchPart targetPart) {
		ListDialog dialog = new ListDialog(targetPart.getSite().getShell());

		dialog.setMessage("Select the Type of Event to add.");
		dialog.setTitle("Event Selection");
		dialog.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {

				return (String) element;
			}

		}

		);
		dialog.setContentProvider(new IStructuredContentProvider() {
			List<String> model = new ArrayList<String>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(getModelInstances(TrackerPackage.eINSTANCE
							.getEvent()));
				}
				return model.toArray();
			}

		}

		);
		dialog.setInput("dont care just send some imput");

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		// This will be a string of event names
		Object[] results = dialog.getResult();

		if (results == null || results.length != 1) {
			return null;
		}
		String nameOfEvent = (String) results[0];
		EClass eClass = (EClass) TrackerPackage.eINSTANCE
				.getEClassifier(nameOfEvent);
		return (Event) TrackerFactory.eINSTANCE.create(eClass);

	}

	public static Animal promptUserForAnimal(IWorkbenchPart targetPart) {
		ListDialog dialog = new ListDialog(targetPart.getSite().getShell());

		dialog.setMessage("Select the Type of Animal to add.");
		dialog.setTitle("Animal Selection");
		dialog.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {

				return (String) element;
			}

		}

		);
		dialog.setContentProvider(new IStructuredContentProvider() {
			List<String> model = new ArrayList<String>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(getModelInstances(TrackerPackage.eINSTANCE
							.getAnimal()));

				}
				return model.toArray();
			}

		}

		);
		dialog.setInput("dont care just send some imput");

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		// This will be a string of animal names
		Object[] results = dialog.getResult();

		if (results == null || results.length != 1) {
			return null;
		}
		String nameOfAnimal = (String) results[0];
		EClass eClass = (EClass) TrackerPackage.eINSTANCE
				.getEClassifier(nameOfAnimal);
		return (Animal) TrackerFactory.eINSTANCE.create(eClass);
	}

	public static final AnimalTemplateBean createTemplateBean(Animal animal,
			Event event) {
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(event);
		animal.getTags().add(tag);
		AnimalTemplateBean templateBean = new AnimalTemplateBean(animal,
				"User prompted dialog");
		return templateBean;
	}

	public static final IResource extractResource(IEditorPart editor) {
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

	public static boolean validate(Premises premises,
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
		for (Event historicalEvent : animalToReceiveEvent.eventHistory()) {
			if (historicalEvent.getEventCode() == eventToAdd.getEventCode()) {
				Date historicalEventDate = historicalEvent.getDateTime();
				Date eventToAddDate = eventToAdd.getDateTime();
				//Subtract the timeout interval seconds from the eventToAddDate
				Calendar cal = Calendar.getInstance();
				cal.setTime(eventToAddDate);
				Preferences store = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
				int timeoutWindow = store.getInt(PreferenceConstants.P_IGNORE_WINDOW);
				cal.add(Calendar.SECOND, -timeoutWindow);
				Date subtractedDate = cal.getTime();
				if(historicalEventDate.after(subtractedDate)){
					logger.info(
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
	
	


	
}
