package com.verticon.tracker.views;

import java.util.Comparator;
import java.util.Date;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.GenericViewSorter;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.util.TrackerUtils;

public class AnimalsView extends TrackerView  {

	private static final String NAME_OF_ITEM_IN_MASTER = "Animal";

	private ISelectionController selectionController;

	/**
	 * Reference to Observable for table Input
	 */
	private IObservableList tableInput;


	/**
	 * Override super to add an AnimalSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		super.createPartControl(base);
		
		selectionController = new SelectionController(
				this, new AnimalsStrategy(this));
		selectionController.open();
		getSite().getPage().addSelectionListener(selectionController);
		getSite().getPage().addPartListener(selectionController);
		tableViewer.addSelectionChangedListener(selectionController);
		//Fill view if there is an activeEditorPart.
		handleViewerInputChange();
	}

	/**
	 * Override super to remove the listeners and close the
	 * AnimalSelectionController
	 */
	@Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(selectionController);
		selectionController.close();
		getSite().getPage().removePartListener(selectionController);
		getSite().getPage().removeSelectionListener(selectionController);
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
		Premises premises = getPremises(selectionController
				.getEditingDomain());
		AddAnimalWizard wizard = new AddAnimalWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();
		wizard.dispose();
		if(results==WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				return object;

			}
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
				adapterFactory,this)
				);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());
	}

	/**
	 * Override point for subclasses to obtain the necessary tableInput to feed
	 * the tableViewer.
	 * 
	 * @see #setUpTable(AdapterFactory)
	 */
	public void handleViewerInputChange() {
		if (tableInput != null) {
			tableInput.dispose();
			tableInput = null;
		}

		tableInput = getObservableList();
		masterFilteredTable.getViewer().setInput(tableInput);
		enableMenus(tableInput!=null);
	}

   
	/**
	 * Sets up the Animals TableViewer.
	 * 
	 * Also used by AddEventWizard so access is package-friendly.
	 */
	static ObservableListContentProvider setUpAnimalsTableViewer(
			final TableViewer tableViewer, final AdapterFactory adapterFactory,
			AnimalsView instance) {
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

		GenericViewSorter sorter = createTableSorter( tableViewer, 
				new TableColumn[] {
				ainColumn,animalTypeColumn,sexColumn,
				breedColumn, dDateColumn, lastEventDateTimeColumn, 
				weightColumn, weightGainColumn, commentsColumn
				}, instance!=null?instance.memento:null );
		
		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i" });

		if(instance !=null){
			instance.sorter=sorter;
			if (instance.memento != null){
				sorter.init(instance.memento);
			}
		}
		return cp;
	}

	/**
	 * 
	 * @return an ObservableList of Animals
	 */
	private IObservableList getObservableList() {
		// There may be no editors return a null if so
		if (selectionController.getEditingDomain() == null) {
			return null;
		}
		Premises premises = getPremises(selectionController
				.getEditingDomain());
		if (premises == null) {
			return null;
		}
		return EMFObservables.observeList(premises,
				TrackerPackage.Literals.PREMISES__ANIMALS);
	}
	
	/**
	 * Order of comparators must match with the array of columns" 
	 * ainColumn,animalTypeColumn,sexColumn,
	 * breedColumn, dDateColumn, lastEventDateTimeColumn, 
	 * weightColumn, weightGainColumn, commentsColumn
	 * 
	 * @param viewer
	 * @param tableColumns
	 */
	@SuppressWarnings("unchecked")
	private static GenericViewSorter createTableSorter(final TableViewer viewer,
			TableColumn[] tableColumns,IMemento memento) {
		
//		ainColumn, animalTypeColumn,sexColumn,
//		 * breedColumn, dDateColumn, lastEventDateTimeColumn, 
//		 * weightColumn, weightGainColumn, commentsColumn
//		 * 
		Comparator<Animal> ainComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				return animal1.getId().compareTo(animal2.getId());
			}
		};
		
		Comparator<Animal> typeComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				return animal1.getClass().getSimpleName().compareTo(animal2.getClass().getSimpleName());
			}
		};

		Comparator<Animal> sexComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				return animal1.getSexCode().compareTo(animal2.getSexCode());
			}
		};
		
		
		Comparator<Animal> breedComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				return animal1.getBreed().compareTo(animal2.getBreed());
			}
		};
		
		
		
		Comparator<Animal> bdateComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				Date date1 = animal1.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getBirthDate();
				Date date2 = animal2.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getBirthDate();
				return date1.compareTo(date2);
			}
		};
		
		Comparator<Animal> lastEventTimeComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				Date date1 = animal1.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getLastEventDateTime();
				Date date2 = animal2.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getLastEventDateTime();
				return date1.compareTo(date2);
			}
		};
		
		Comparator<Animal> weightComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				if(animal1.getWeight()==null && animal2.getWeight()==null){
					return 0;
				}
				if(animal1.getWeight()==null){
					return -1;
				}
				if(animal2.getWeight()==null){
					return 1;
				}
				return animal1.getWeight().compareTo(animal2.getWeight());
			}
		};
		
		Comparator<Animal> weightGainComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				if(animal1.getWeightGainPerDay()==null && animal2.getWeightGainPerDay()==null){
					return 0;
				}
				if(animal1.getWeightGainPerDay()==null){
					return -1;
				}
				if(animal2.getWeightGainPerDay()==null){
					return 1;
				}
				return animal1.getWeightGainPerDay().compareTo(animal2.getWeightGainPerDay());
			}
		};

		Comparator<Animal> commentsComparator = new Comparator<Animal>() {
			public int compare(Animal animal1, Animal animal2) {
				String comments1 = animal1.getComments() == null ? "" : animal1
						.getComments();
				String comments2 = animal2.getComments() == null ? "" : animal2
						.getComments();
				return comments1.compareTo(comments2);
			}
		};
		GenericViewSorter sorter = new GenericViewSorter(viewer, tableColumns,
		// Remember order is important
				// ainColumn,animalTypeColumn,sexColumn,
				//  breedColumn, dDateColumn, lastEventDateTimeColumn, 
				// weightColumn, weightGainColumn, commentsColumn
				  
				new Comparator[] { 
						ainComparator,
						typeComparator,
						sexComparator,
						breedComparator, 
						bdateComparator,
						lastEventTimeComparator,
						weightComparator, 
						weightGainComparator,
						commentsComparator });
		
		viewer.setSorter(sorter);
		return sorter;
	}


}
