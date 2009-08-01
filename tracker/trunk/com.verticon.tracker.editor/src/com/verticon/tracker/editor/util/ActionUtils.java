/**
 * 
 */
package com.verticon.tracker.editor.util;

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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
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
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_IGNORE_WINDOW;
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

	// Suppress default constructor for noninstantiability
	private ActionUtils() {
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
	public static final TagsBean getTagsBean(IPremisesProvider editor,
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

	public static final AnimalTemplateBean getTemplateBean(TrackerEditor editor,
			IWorkbenchPart targetPart) {
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
		IFile animalTemplateFile = (IFile) result;
		
		AnimalTemplateBean templateBean;
		
		templateBean = AnimalTemplateBean.instance(animalTemplateFile);
		
		if(templateBean == null){
			MessageDialog
			.openError(targetPart.getSite().getShell(),
					"Failed to load a template",
					"Could not extract a template");

		}
       return templateBean;
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
									
				Collection<Event> eventsToAddTheWhereNotDeferred = filterOutDeferedEvents(activeTag, potentialEventsToAdd);
				deferedEvents = deferedEvents + (potentialEventsToAdd.size() - eventsToAddTheWhereNotDeferred.size());
				command = createAddCommand(activeTag, premisesProvider.getEditingDomain(),
						eventsToAddTheWhereNotDeferred);

				
			} else {
				newAnimalsCreated++;
				command = AddCommand.create(
						premisesProvider.getEditingDomain(), //Domain
						premises, //Owner
						TrackerPackage.Literals.PREMISES__ANIMALS,
						animalTemplateBean.getAnimal(tag.toString(),premises)//value
				);
				
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
	 * @return Collection of Events without the deferred events
	 */
	public static Collection<Event> filterOutDeferedEvents(Tag tag,
			Collection<Event> events) {
		if(tag==null){
			throw new NullPointerException("tag argument cannot be null");
		}
		Collection<Event> eventsToAdd = new ArrayList<Event>();
		for (Event event : events) {
			
			if(ActionUtils.canAddEventToAnimal((Animal)tag.eContainer(), event) ){
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

	public static IPremisesProvider getTrackerEditor(IWorkbenchPart targetPart) {
		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (editor == null || (!(editor instanceof TrackerEditor))) {
			logger.error(bundleMarker,"The active editor is not a TrackerEditor.");
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add tags",
					"Could not find an active TrackerEditor ");
			return null;
		}
		return (IPremisesProvider) editor;
	}

	public static Event promptUserForEvent(IWorkbenchPart targetPart) {
		ListDialog dialog = new ListDialog(targetPart.getSite().getShell());

		dialog.setMessage("Select the Type of Event to add.");
		dialog.setTitle("Event Selection");
		dialog.setLabelProvider(new LabelProvider() {
			@Override
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
			@Override
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
	
}
