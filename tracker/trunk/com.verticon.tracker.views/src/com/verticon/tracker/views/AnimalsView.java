package com.verticon.tracker.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.TrackerTableEditorUtils;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class AnimalsView extends TrackerView {

	private static final String NAME_OF_ITEM_IN_MASTER = "Animal";
	
	/**
	 * Reference to Observable for table Input
	 */
	private IObservableList tableInput;

	/**
	 * Subclasses can override this to provide a more useful name for
	 * deleteAction dialog.
	 * 
	 * @return plural name of the items to delete
	 */
	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}

	/**
	 * Displays a two page wizard to add an Animal to the model. First page
	 * prompts for animal type, the second prompts for a tag id.
	 * 
	 * This has the side effect of creating a tagApplied event for the animal
	 * with the datetime of this action.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Premises premises = getPremises(getEditingDomain());
		AddAnimalWizard wizard = new AddAnimalWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
		wizard.dispose();
		for (Object object : wizard.getResults()) {
			return object;

		}
		return null;
	}

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 * 
	 * To fix Task number 261 this method now uses a databinding contentProvider
	 * for the tableViewer
	 * 
	 * @see #handleViewerInputChange()
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer viewer = masterFilteredTable.getViewer();
		TrackerTableEditorUtils.setUpAnimalsTableViewer(viewer);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());
		// Set up databinding context here
		ObservableListContentProvider cp = new ObservableListContentProvider();
		viewer.setContentProvider(cp);
		viewer
				.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary tableInput to feed
	 * the tableViewer.
	 * 
	 * @see #setUpTable(AdapterFactory)
	 */
	@Override
	protected void handleViewerInputChange() {
		Premises premises = getPremises(getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		if (tableInput != null) {
			tableInput.dispose();
		}
		if (premises == null) {
			return;
		}
		tableInput = EMFObservables.observeList(premises,
				TrackerPackage.Literals.PREMISES__ANIMALS);
		viewer.setInput(tableInput);
	}

	/**
	 * Override point for subclasses to control how to deal with selections on
	 * the main editors.
	 * 
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		TableViewer viewer = masterFilteredTable.getViewer();
		if (first instanceof Animal) {
			// logger.debug("Animal selection");
			viewer.setSelection(new StructuredSelection(first), true);
		} else if (first instanceof Event) {
			// logger.debug("Event selection");
			Object animal = ((Event) first).eContainer().eContainer();
			viewer.setSelection(new StructuredSelection(animal), true);
		} else if (first instanceof Exhibit
				&& ((Exhibit) first).getAnimal() != null) {
			// logger.debug("Exhibit selection");
			viewer.setSelection(new StructuredSelection(((Exhibit) first)
					.getAnimal()), true);
		} else if (first instanceof Person) {
			// logger.debug("Person selection");
			Person person = (Person) first;
			List<Animal> animals = new ArrayList<Animal>();
			Fair fair = (Fair) person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if (person == exhib.getExhibitor()) {
					animals.add(exhib.getAnimal());
				}
			}
			//logger.debug("Person selection associated with {} animals.",animals
			// .size());
			viewer.setSelection(new StructuredSelection(animals), true);
		}
	}

	/**
	 * Convienence method to find the Root
	 * 
	 * @return premises
	 */
	private static Premises getPremises(EditingDomain editingDomain) {
		Resource resource = editingDomain.getResourceSet().getResources()
				.get(0);
		Object rootObject = resource.getContents().get(0);
		if (rootObject instanceof Premises) {
			return (Premises) rootObject;
		} else if (rootObject instanceof Fair) {
			return ((Fair) rootObject).getPremises();
		}

		return null;
	}

}
