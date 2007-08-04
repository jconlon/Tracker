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
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileDialog;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.util.CommonUtilities;
import com.verticon.tracker.util.TrackerLog;

/**
 * @author jconlon
 * 
 */
public class ActionUtils {

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
	public static final TagsBean getTagsBean(TrackerEditor editor,
			ISelection selection) throws FileNotFoundException {
		IResource resource = getSelectedResource(editor, selection);

		TrackerLog.logInfo("Adding tags from resource "
				+ resource.getFullPath());
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

	public static final TemplateBean getTemplateBean(TrackerEditor editor,
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

		TemplateBean templateBean = new TemplateBean(animal, f.getName());
		return templateBean;
	}

	public static final Premises getPremises(TrackerEditor editor) {
		Premises premises = null;
		EditingDomain editingDomain = editor.getEditingDomain();
		Resource modelResource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = modelResource.getContents().get(0);
		premises = (Premises) rootObject;
		return premises;
	}

	public static final void addTemplate(Premises premises, TagsBean tagsBean,
			TemplateBean templateBean, TrackerEditor editor) {
		// The date in the templateBean takes precedence over the tagsBean
		if (templateBean.getDate() == null) {
			templateBean.setDate(tagsBean.getDate());
		}

		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;
		int newAnimalsCreated =0;
		
		int existingAnimals =0;
		for (Long tag : tagsBean.getTags()) {
			Animal animal = premises.findAnimal(tag);
			if (animal != null) {
				existingAnimals++;
				command = createAddEventsToTagCommand(animal.activeTag(), templateBean.getEvents(),
						editor.getEditingDomain());
				compoundCommand.append(command);
			} else {
				newAnimalsCreated++;
				command = createAddAnimalToPremiseCommand(premises,
						templateBean.getAnimal(tag), editor.getEditingDomain());
				compoundCommand.append(command);
			}
		}
		editor.getEditingDomain().getCommandStack().execute(compoundCommand);
		MessageDialog.openInformation(
				editor.getSite().getShell(),
				TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateWizard_label"),
				"The "+templateBean.getName() +" and "+ tagsBean.getName()+ 
				" added "+templateBean.getEvents().size()+ " events to "+
				newAnimalsCreated+ " new Animals and " +
				existingAnimals+" existing animals.");
	}

	/**
	 * Adds all events in the eventTemplate to the animal's active tag.
	 * 
	 * @param animal
	 * @param templateBean
	 * @param editor
	 */
	public static final void addTemplate(Animal animal,
			TemplateBean templateBean, TrackerEditor editor) {
		Command command = createAddEventsToTagCommand(animal.activeTag(), templateBean.getEvents(),
				editor.getEditingDomain());
		editor.getEditingDomain().getCommandStack().execute(command);

	}
	
	public static final void addTemplate(Collection<Animal> animals,
			TemplateBean templateBean, TrackerEditor editor) {
		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;
		int numberOfEventsInTemplate = templateBean.numberOfEvents();
		for (Animal animal : animals) {
			 command = createAddEventsToTagCommand(animal.activeTag(), templateBean.getEvents(),
					editor.getEditingDomain());
			 compoundCommand.append(command);
		}
		
		editor.getEditingDomain().getCommandStack().execute(compoundCommand);
		MessageDialog.openInformation(
				editor.getSite().getShell(),
				TrackerReportEditorPlugin.INSTANCE.getString("_UI_TrackerTemplateWizard_label"),
				"The "+templateBean.getName() +
				" added "+numberOfEventsInTemplate+ " events to "+
				animals.size()+ " animals.");

	}
	
	public static final Collection<Animal> getSelectedAnimals(ISelection selection) {
		ArrayList<Animal> selectedAnimals = new ArrayList<Animal>();
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> iter = ((IStructuredSelection) selection).iterator(); iter
					.hasNext();) {
				Object o = iter.next();
				if(o instanceof Animal){
					selectedAnimals.add((Animal) o);
				}
			}
		}
		return selectedAnimals;
	}

	private static Command createAddEventsToTagCommand(Tag tag,
			Collection<Event> events, EditingDomain editingDomain) {
		Command command = AddCommand.create(editingDomain, tag,
				TrackerPackage.eINSTANCE.getTag(), events);
		return command;
	}

	private static Command createAddAnimalToPremiseCommand(Premises premises,
			Animal animal, EditingDomain editingDomain) {
		Command command = AddCommand.create(editingDomain, premises,
				TrackerPackage.eINSTANCE.getPremises(), animal);
		return command;
	}

	private static IResource getSelectedResource(TrackerEditor editor,
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

	private static Resource getResource(IFile file) throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		return resource;
	}

	public static TrackerEditor getTrackerEditor(IWorkbenchPart targetPart) {
		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (editor == null || (!(editor instanceof TrackerEditor))) {
			TrackerLog.logError("The active editor is not a TrackerEditor.",
					null);
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add tags",
					"Could not find an active TrackerEditor ");
			return null;
		}
		return (TrackerEditor) editor;
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
					model.addAll(getModelInstances(TrackerPackage.eINSTANCE.getEvent()));
				}
				return model.toArray();
			}

		}

		);
		dialog.setInput("dont care just send some imput");

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		//This will be a string of event names
		Object[] results = dialog.getResult();

		if(results == null || results.length != 1){
			return null;
		} 
		String nameOfEvent = (String)results[0];
		EClass eClass = (EClass)TrackerPackage.eINSTANCE.getEClassifier(nameOfEvent);
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
					model.addAll(getModelInstances(TrackerPackage.eINSTANCE.getAnimal()));
				
				}
				return model.toArray();
			}

		}

		);
		dialog.setInput("dont care just send some imput");

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		//This will be a string of animal names
		Object[] results = dialog.getResult();

		if(results == null || results.length != 1){
			return null;
		} 
		String nameOfEvent = (String)results[0];
		EClass eClass = (EClass)TrackerPackage.eINSTANCE.getEClassifier(nameOfEvent);
		return (Animal) TrackerFactory.eINSTANCE.create(eClass);
	}
	
	public static final TemplateBean createTemplateBean(Animal animal, Event event){
		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.getEvents().add(event);
		animal.getTags().add(tag);
		TemplateBean templateBean = new TemplateBean(animal,"User prompted dialog");
		return templateBean;
	}

	private static final IResource extractResource(IEditorPart editor) {
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
			return new Date();
		}

		return date;
	}

	public static List<String> getModelInstances(EClass superEClass) {
		
			List<String> initialObjectNames = new ArrayList<String>();
			
			for (EClassifier eClassifier : TrackerPackage.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						if(superEClass.isSuperTypeOf(eClass)){
								initialObjectNames.add(eClass.getName());
						}
						
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		
		return initialObjectNames;
	}
}
