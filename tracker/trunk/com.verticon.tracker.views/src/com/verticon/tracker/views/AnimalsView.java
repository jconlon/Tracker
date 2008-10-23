package com.verticon.tracker.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;

public class AnimalsView extends TrackerView implements ItemsView {

	private static final String NAME_OF_ITEM_IN_MASTER = "Animal";

	private ISelectionController animalSelectionController;

	/**
	 * Reference to Observable for table Input
	 */
	private IObservableList tableInput;

	public void handleViewerInputChange2() {
		handleViewerInputChange();
	}
	
	/**
	 * Override super to add an AnimalSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		super.createPartControl(base);
		animalSelectionController = new SelectionController(
				this, new AnimalsStrategy(this));
		animalSelectionController.open();
		getSite().getPage().addSelectionListener(animalSelectionController);
		getSite().getPage().addPartListener(animalSelectionController);
		tableViewer.addSelectionChangedListener(animalSelectionController);
	}

	/**
	 * Override super to remove the listeners and close the
	 * AnimalSelectionController
	 */
	@Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(animalSelectionController);
		animalSelectionController.close();
		getSite().getPage().removePartListener(animalSelectionController);
		getSite().getPage().removeSelectionListener(animalSelectionController);
		super.dispose();
	}
	
	/**
	 * Subclasses can override this to provide a more useful name for dialog.
	 * 
	 * @return singular name of the items for wizard
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
		Premises premises = getPremises(animalSelectionController
				.getEditingDomain());
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
		if (tableInput != null) {
			tableInput.dispose();
			tableInput = null;
		}

		tableInput = getObservableList();
		masterFilteredTable.getViewer().setInput(tableInput);
	}


	/**
	 * Sets up the Animals TableViewer.
	 * 
	 * Also used by AddEventWizard so access is package-friendly.
	 */
	static ObservableListContentProvider setUpAnimalsTableViewer(
			final TableViewer tableViewer, final AdapterFactory adapterFactory) {
		ObservableListContentProvider cp = new ObservableListContentProvider();
		IObservableMap[] maps = EMFObservables.observeMaps(cp
				.getKnownElements(), new EStructuralFeature[] {
				TrackerPackage.Literals.ANIMAL__ID,
				TrackerPackage.Literals.ANIMAL__TYPE,
				TrackerPackage.Literals.ANIMAL__SEX,
				TrackerPackage.Literals.ANIMAL__BREED,
				TrackerPackage.Literals.ANIMAL__BIRTH_DATE,
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
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
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

		// LastEventDateTime
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn lastEventDateTimeColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 130, true));
		lastEventDateTimeColumn.setText(getString("_UI_LastEventColumn_label"));
		lastEventDateTimeColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{5}"));

		// Weight
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn weightColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		weightColumn.setText("Weight");
		weightColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{6}"));

		// WeightGainPerDay
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn weightGainColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		weightGainColumn.setText("WeightGainPerDay");
		weightGainColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{7}"));

		// Comments
		viewerColumn = new TableViewerColumn(tableViewer, SWT.LEAD);
		final TableColumn commentsColumn = viewerColumn.getColumn();
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		commentsColumn.setText(getString("_UI_CommentsColumn_label"));
		commentsColumn.setMoveable(true);
		viewerColumn
				.setLabelProvider(new GenericObservableMapCellLabelProvider(
						maps, "{8}"));

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
					// } else if (currentColumn == ageColumn) {
					// sortIdentifier = AnimalSorter.AGE;
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
		// ageColumn.addListener(SWT.Selection, sortListener);
		weightColumn.addListener(SWT.Selection, sortListener);
		weightGainColumn.addListener(SWT.Selection, sortListener);
		commentsColumn.addListener(SWT.Selection, sortListener);

		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i" });

		return cp;
	}

	/**
	 * 
	 * @return an ObservableList of Animals
	 */
	private IObservableList getObservableList() {
		// There may be no editors return a null if so
		if (animalSelectionController.getEditingDomain() == null) {
			return null;
		}
		Premises premises = getPremises(animalSelectionController
				.getEditingDomain());
		if (premises == null) {
			return null;
		}
		return EMFObservables.observeList(premises,
				TrackerPackage.Literals.PREMISES__ANIMALS);
	}

}
