package com.verticon.tracker.editor.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.TrackerEditor;
import com.verticon.tracker.util.TrackerLog;

public abstract class AbstractAddToParentActionDelegate {

	protected IWorkbenchPart targetPart;

	private ISelection selection;

	protected IResource resource;

	protected Premises premises;

	public AbstractAddToParentActionDelegate() {
		super();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

	}

	public void run(IAction action) {
		TrackerEditor editor = getTrackerEditor(targetPart);
		if(editor==null){
			return;
		}
		processSelection(editor);
	}

	public static  TrackerEditor getTrackerEditor(IWorkbenchPart targetPart){
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			

		if (editor == null || (!(editor instanceof TrackerEditor))) {
			TrackerLog
					.logError("The active editor is not a TrackerEditor.", null);
			MessageDialog.openError(targetPart.getSite().getShell(),
					"Failed to add tags",
					"Could not find an active TrackerEditor ");
			return null;
		}
		return (TrackerEditor)editor;
	}
	
	protected void processSelection(TrackerEditor editor) {
		
		if (selection instanceof IStructuredSelection) {
			for (Iterator iter = ((IStructuredSelection) selection).iterator(); iter
					.hasNext();) {
				resource = (IResource) iter.next();
				TrackerLog.logInfo("Adding tags from resource "
						+ resource.getName());
				Scanner sc = null;
				try {
					sc = new Scanner(new File(resource.getLocationURI()));
					Set<Long> tagNumbers = new HashSet<Long>();
					while (sc.hasNextLong()) {
						tagNumbers.add(sc.nextLong());
					}

					processTags(tagNumbers,  editor);

				} catch (FileNotFoundException e) {
					TrackerLog.logError("Could not find the tags file.", e);

				} catch (NoAnimalFoundException e) {
					TrackerLog.logError("Failed to add tags from file "
							+ resource.getFullPath(), e);
					MessageDialog
							.openError(
									targetPart.getSite().getShell(),
									"Failed to add tags",
									"Failed to add tags from file "
											+ resource.getFullPath()
											+ " because: "
											+ e.getLocalizedMessage()
											+ "  Add tags from the file as Animals first.");
					return;

				} finally {
					if (sc != null) {
						sc.close();
					}
				}

			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());
	}

	
	
	
	public static final IResource extractResource(IEditorPart editor) {
		IEditorInput input = editor.getEditorInput();
		if (!(input instanceof IFileEditorInput))
			return null;
		return ((IFileEditorInput) input).getFile();
	}

	
	@SuppressWarnings("unchecked")
	private void processTags(Set<Long> tags, TrackerEditor editor)
			throws NoAnimalFoundException {
		if (tags.isEmpty()) {
			MessageDialog.openWarning(targetPart.getSite().getShell(),
					"No tags in file", "Found no tags in file "
							+ resource.getFullPath());
			return;
		}
		EditingDomain editingDomain = editor.getEditingDomain();
		Resource modelResource = (Resource) editingDomain.getResourceSet()
				.getResources().get(0);
		Object rootObject = modelResource.getContents().get(0);
		premises = (Premises) rootObject;
		Object parent = createParent(premises);
		Collection childrenFromAllTags = new ArrayList();
		Collection childrenAssociatedWithTag = null;
		for (Long long1 : tags) {
		    childrenAssociatedWithTag = createChildren(long1);
			if(childrenAssociatedWithTag!=null && !childrenAssociatedWithTag.isEmpty()){
				childrenFromAllTags.addAll(childrenAssociatedWithTag);
			}
		}

		if (childrenFromAllTags.isEmpty()) {
			MessageDialog.openWarning(targetPart.getSite().getShell(),
					"No unique tags in file",
					"Found no unique tags to import from file "
							+ resource.getFullPath());
			return;
		}
		Command command = AddCommand.create(
				editingDomain, 
				parent,
				getFeature(), 
				childrenFromAllTags);
		editingDomain.getCommandStack().execute(command);

		String nameOfParent = parent.getClass().getSimpleName().substring(0,
				parent.getClass().getSimpleName().indexOf("Impl"));

		MessageDialog.openInformation(targetPart.getSite().getShell(),
				"Add to " + nameOfParent, 
				"Added " + 
				childrenFromAllTags.size() + 
				" children  to " + nameOfParent);
	}

	protected abstract Object createParent(Premises premises);

	protected abstract Object getFeature();

	protected abstract Collection createChildren(Long tag)
			throws NoAnimalFoundException;

	/**
	 * Find an animalID associated with an Animal in the Animals 
	 * TODO Consolidate to an utility class.
	 * 
	 * @param tag
	 * @return animalID or null
	 */
	protected AnimalId findAnimalId(Long tag) {
		List elist = premises.getAnimals().getAnimal();
		for (Object object : elist) {
			Animal animal = (Animal) object;
			if (animal.getIdNumber().longValue() == tag) {
				return animal.getAin();
			}
		}
		return null;
	}

	/**
	 * Find an event in the EventHistory. TODO Consolidate to an utility class
	 * 
	 * @param tag
	 * @param eventCode
	 * @return event or null
	 */
	protected boolean containsEvent(Long tag, int eventCode) {
		List elist = premises.getEventHistory().getEvents();
		for (Object object : elist) {
			Event event = (Event) object;
			if (event.getEventCode() == eventCode && event.getId() == tag.longValue()) {
				return true;
			}
		}
		return false;
	}
	
	

}