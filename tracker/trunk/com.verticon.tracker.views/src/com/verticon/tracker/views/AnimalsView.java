package com.verticon.tracker.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
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
		viewer.setContentProvider(setUpAnimalsTableViewer(viewer,
				adapterFactory));
		masterFilteredTable.setColumns(viewer.getTable().getColumns());
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

	/**
	 * Animals Table
	 */
	 static ObservableListContentProvider setUpAnimalsTableViewer(final TableViewer tableViewer,
			 final AdapterFactory adapterFactory) {
		 ObservableListContentProvider cp = new ObservableListContentProvider();
			IObservableMap[] maps = EMFObservables.observeMaps(cp
					.getKnownElements(), new EStructuralFeature[] {
					TrackerPackage.Literals.ANIMAL__ID,
					TrackerPackage.Literals.ANIMAL__TYPE,
					TrackerPackage.Literals.ANIMAL__SEX,
					TrackerPackage.Literals.ANIMAL__BREED,
					TrackerPackage.Literals.ANIMAL__BIRTH_DATE,
					TrackerPackage.Literals.ANIMAL__AGE,
					TrackerPackage.Literals.ANIMAL__LAST_EVENT_DATE_TIME,
					TrackerPackage.Literals.ANIMAL__WEIGHT,
					TrackerPackage.Literals.ANIMAL__WEIGHT_GAIN_PER_DAY,
					TrackerPackage.Literals.ANIMAL__COMMENTS,
					TrackerPackage.Literals.ANIMAL__SPECIES, });
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Ain
		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		final TableColumn ainColumn = viewerColumn.getColumn();
		// new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 120, true));
		ainColumn.setText(getString("_UI_AinColumn_label"));
		ainColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{0}"));
		
		// Type
		viewerColumn = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		final TableColumn animalTypeColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 90, true));
		animalTypeColumn.setText(getString("_UI_AnimalTypeColumn_label"));
		animalTypeColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{1}") {

					private final ITableLabelProvider lp = new AdapterFactoryLabelProvider(
							adapterFactory);
					@Override
					public Image getImage(Object element) {
						return lp.getColumnImage(element, 0);
					}
				});
		

		// Sex
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn sexColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 62, true));
		sexColumn.setText(getString("_UI_SexColumn_label"));
		sexColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{2}"));
		
		// Breed
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn breedColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		breedColumn.setText(getString("_UI_BreedColumn_label"));
		breedColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{3}"));
		
		// BirthDate
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn dDateColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 120, true));
		dDateColumn.setText(getString("_UI_BirthDateColumn_label"));
		dDateColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{4,date,medium}"));

		// Age
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn ageColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		ageColumn.setText(getString("_UI_AgeColumn_label"));
		ageColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{5}"));

		// LastEventDateTime
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn lastEventDateTimeColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 130, true));
		lastEventDateTimeColumn.setText(getString("_UI_LastEventColumn_label"));
		lastEventDateTimeColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{6}"));

		// Weight
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn weightColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		weightColumn.setText("Weight");
		weightColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{7}"));

		// WeightGainPerDay
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn weightGainColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		weightGainColumn.setText("WeightGainPerDay");
		weightGainColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{8}"));

		// Comments
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn commentsColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		commentsColumn.setText(getString("_UI_CommentsColumn_label"));
		commentsColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{9}"));

		Listener sortListener = new Listener() {

			public void handleEvent(org.eclipse.swt.widgets.Event e) {
				// determine new sort column and direction
				TableColumn sortColumn = table.getSortColumn();
				TableColumn currentColumn = (TableColumn) e.widget;
				int dir = table.getSortDirection();
				if (sortColumn == currentColumn) {
					dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
				} else {
					table.setSortColumn(currentColumn);
					dir = SWT.UP;
				}

				// sort the data based on column and direction

				int sortIdentifier = 0;

				if (currentColumn == ainColumn) {
					sortIdentifier = AnimalSorter.AIN;
				} else if (currentColumn == animalTypeColumn) {
					sortIdentifier = AnimalSorter.ANIMAL;
				} else if (currentColumn == dDateColumn) {
					sortIdentifier = AnimalSorter.BIRTHDATE;
				} else if (currentColumn == sexColumn) {
					sortIdentifier = AnimalSorter.SEX;
				} else if (currentColumn == breedColumn) {
					sortIdentifier = AnimalSorter.BREED;
				} else if (currentColumn == ageColumn) {
					sortIdentifier = AnimalSorter.AGE;
				} else if (currentColumn == weightColumn) {
					sortIdentifier = AnimalSorter.WEIGHT;
				} else if (currentColumn == weightGainColumn) {
					sortIdentifier = AnimalSorter.WEIGHT_GAIN;

				} else if (currentColumn == commentsColumn) {
					sortIdentifier = AnimalSorter.COMMENTS;
				} else if (currentColumn == lastEventDateTimeColumn) {
					sortIdentifier = AnimalSorter.LAST_EVENT_DATE;
				}

				table.setSortDirection(dir);
				tableViewer.setSorter(new AnimalSorter(sortIdentifier, dir));
			}

		};

		breedColumn.addListener(SWT.Selection, sortListener);
		ainColumn.addListener(SWT.Selection, sortListener);
		lastEventDateTimeColumn.addListener(SWT.Selection, sortListener);
		animalTypeColumn.addListener(SWT.Selection, sortListener);
		sexColumn.addListener(SWT.Selection, sortListener);
		dDateColumn.addListener(SWT.Selection, sortListener);
		ageColumn.addListener(SWT.Selection, sortListener);
		weightColumn.addListener(SWT.Selection, sortListener);
		weightGainColumn.addListener(SWT.Selection, sortListener);
		commentsColumn.addListener(SWT.Selection, sortListener);

		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i", "j" });

		return cp;
	}
}
