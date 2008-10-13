package com.verticon.tracker.fair.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.util.FairTableEditorUtils;

/**
 * View of People at a Fair.
 * 
 * @author jconlon
 * 
 */
public class PeopleView extends TrackerView {

	private static final String NAME_OF_ITEM_IN_MASTER = "Person";
	
	/**
	 * Reference to Observable for table Input
	 */
	private IObservableList tableInput;

	/**
	 * Override point for subclasses to create the tableViewer columns. To fix
	 * Task number 261 this method now uses a databinding contentProvider for
	 * the tableViewer
	 * 
	 * @see #handleViewerInputChange()
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		FairTableEditorUtils.setUpPeopleTableViewer(tableViewer);
		masterFilteredTable.setColumns(tableViewer.getTable().getColumns());

		// // Set up databinding context here
		ObservableListContentProvider cp = new ObservableListContentProvider();
		tableViewer.setContentProvider(cp);

		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
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
		TableViewer tableViewer = masterFilteredTable.getViewer();
		Fair fair = getFair();
		if (tableInput != null) {
			tableInput.dispose();
		}
		if (fair == null) {
			return;
		}
		tableInput = EMFObservables.observeList(fair,
				FairPackage.Literals.FAIR__PEOPLE);

		tableViewer.setInput(tableInput);

	}

	@Override
	protected AdapterFactory createAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		//
		// adapterFactory.addAdapterFactory(new
		// ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		// adapterFactory.addAdapterFactory(new
		// ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		Person person = null;
		if (first instanceof Animal) {
			// logger.debug("Animal selection");
			// One Person per animal
			person = getPersonFromAnimal((Animal) first, getFair());
		} else if (first instanceof Event) {
			// logger.debug("Event selection");
			// One person per event
			person = getPersonFromEvent((Event) first, getFair());
		} else if (first instanceof Exhibit
				&& ((Exhibit) first).getExhibitor() != null) {
			// logger.debug("Exhibit selection");
			person = ((Exhibit) first).getExhibitor();
		} else if (first instanceof Person) {
			// logger.debug("Person selection");
			person = (Person) first;
		}
		setSelection(person);
	}

	/**
	 * Displays a one page wizard to add a Person to the model. The page prompts
	 * the user fill in a first and last name.
	 * 
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Fair fair = getFair();
		AddPeopleWizard wizard = new AddPeopleWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), fair);
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

	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}

	/**
	 * @param person
	 */
	private void setSelection(Object person) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		if (person != null) {
			tableViewer.setSelection(new StructuredSelection(person), true);
		} else {
			tableViewer.setSelection(new StructuredSelection());
		}
	}

	/**
	 * @return fair
	 */
	private Fair getFair() {
		Fair fair = null;
		for (Resource resource : getEditingDomain()
				.getResourceSet().getResources()) {
			Object o = resource.getContents().get(0);
			if (o instanceof Fair) {
				fair = (Fair) o;
				break;
			}
		}
		return fair;
	}

	private static Person getPersonFromAnimal(Animal animal, Fair fair) {
		if (animal == null || fair == null) {
			return null;
		}
		for (Exhibit exhibit : fair.exhibits()) {
			if (animal.equals(exhibit.getAnimal())) {
				return exhibit.getExhibitor();
			}
		}

		return null;
	}

	private static Person getPersonFromEvent(Event event, Fair fair) {
		if (event == null || fair == null) {
			return null;
		}
		if (event.getTag() != null && event.getTag().eContainer() != null) {
			Animal animal = (Animal) event.getTag().eContainer();
			return getPersonFromAnimal(animal, fair);
		}
		return null;
	}

}
