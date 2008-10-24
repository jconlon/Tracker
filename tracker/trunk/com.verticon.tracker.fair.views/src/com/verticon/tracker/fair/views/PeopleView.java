package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
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

import com.verticon.tracker.Animal;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;

/**
 * View of People at a Fair.
 * 
 * @author jconlon
 * 
 */
public class PeopleView extends TrackerView implements ItemsView{

	private static final String NAME_OF_ITEM_IN_MASTER = "Person";
	
	private ISelectionController exhibitsSelectionController;
	
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
		exhibitsSelectionController = new SelectionController(
				this, new PeopleStrategy(this));
		exhibitsSelectionController.open();
		getSite().getPage().addSelectionListener(exhibitsSelectionController);
		getSite().getPage().addPartListener(exhibitsSelectionController);
		tableViewer.addSelectionChangedListener(exhibitsSelectionController);
	}
	
	/**
	 * Override super to remove the listeners and close the
	 * AnimalSelectionController
	 */
	@Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(exhibitsSelectionController);
		exhibitsSelectionController.close();
		getSite().getPage().removePartListener(exhibitsSelectionController);
		getSite().getPage().removeSelectionListener(exhibitsSelectionController);
		super.dispose();
	}
	
	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}
	
	/**
	 * Displays a one page wizard to add a Person to the model. The page prompts
	 * the user fill in a first and last name.
	 * 
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Fair fair = getFair(exhibitsSelectionController.getEditingDomain());
		AddPeopleWizard wizard = new AddPeopleWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), fair);
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();
		wizard.dispose();
		if(results == WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				return object;
			}
		}
		return null;
	}
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
		ObservableListContentProvider cp = setUpPeopleTableViewer(tableViewer,
				adapterFactory);
		masterFilteredTable.setColumns(tableViewer.getTable().getColumns());

		// // Set up databinding context here
		tableViewer.setContentProvider(cp);
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

//	/**
//	 * @param fair
//	 */
//	private void getObservableList(Fair fair) {
//		tableInput = EMFObservables.observeList(fair,
//				FairPackage.Literals.FAIR__PEOPLE);
//	}

	private IObservableList getObservableList() {
		// There may be no editors return a null if so
		if (exhibitsSelectionController.getEditingDomain() == null) {
			return null;
		}
		Fair premises = getFair(exhibitsSelectionController
				.getEditingDomain());
		if (premises == null) {
			return null;
		}
		return EMFObservables.observeList(premises,
				FairPackage.Literals.FAIR__PEOPLE);
	}
	
	 @Override
	protected AdapterFactory createAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		return adapterFactory;
	}

	
	/**
	 * @param person
	 */
	 void setSelection(Object person) {
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
	private Fair getFair(EditingDomain domain) {
//		EditingDomain domain = exhibitsSelectionController.getEditingDomain();
		if (domain == null) {
			return null;
		}
		
		Fair fair = null;
		for (Resource resource : domain
				.getResourceSet().getResources()) {
			Object o = resource.getContents().get(0);
			if (o instanceof Fair) {
				fair = (Fair) o;
				break;
			}
		}
		return fair;
	}

    static Person getPersonFromAnimal(Animal animal, Fair fair) {
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

//	private static Person getPersonFromEvent(Event event, Fair fair) {
//		if (event == null || fair == null) {
//			return null;
//		}
//		if (event.getTag() != null && event.getTag().eContainer() != null) {
//			Animal animal = (Animal) event.getTag().eContainer();
//			return getPersonFromAnimal(animal, fair);
//		}
//		return null;
//	}

	/**
	 * Enum on Person Element
	 * 
	 * @author jconlon
	 * 
	 */
	enum PeopleColumn {
		// NAME(
		// "Name", new ColumnWeightData(3, 200, true)),
		FIRST_NAME("First Name", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__FIRST_NAME, "{0}"),

		LAST_NAME("Last Name", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__LAST_NAME, "{1}"),

		EXHIBITOR_NUMBER("Exhibitor #", new ColumnWeightData(2, 90, true),
				FairPackage.Literals.PERSON__EXHIBITOR_NUMBER,
				"{2,number,######}"),

		SALES_ORDER("Sales Order",
				new ColumnWeightData(2, 150, true),
				FairPackage.Literals.PERSON__SALES_ORDER, "{3,number,###}"),

		PHONE("Phone", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__PHONE, "{4}"),

		STREET("Street", new ColumnWeightData(2, 200, true),
				FairPackage.Literals.PERSON__STREET, "{5}"),

		CITY("City", new ColumnWeightData(2, 80, true),
				FairPackage.Literals.PERSON__CITY, "{6}"),

		STATE("State", new ColumnWeightData(2, 45, true),
				FairPackage.Literals.PERSON__STATE, "{7}"),

		ZIP("Zip", new ColumnWeightData(2, 45, true),
				FairPackage.Literals.PERSON__ZIP_CODE, "{8}"),

		PIN("Premieses ID", new ColumnWeightData(2, 70, true),
				FairPackage.Literals.PERSON__PIN, "{9}"),

		COMMENTS("Comments", new ColumnWeightData(2, 120, true),
				FairPackage.Literals.PERSON__COMMENTS, "{10}");

		final ColumnLayoutData layoutData;
		final String text;
		final EStructuralFeature feature;
		final String pattern;
		
		static List<String> columnNames;
		static String[] colNames;
		static EStructuralFeature[] features;

		PeopleColumn(String text, ColumnLayoutData layoutData,
				EStructuralFeature feature, String pattern) {
			this.text = text;
			this.layoutData = layoutData;
			this.feature = feature;
			this.pattern = pattern;
		}

		static {
			columnNames = new ArrayList<String>();
			List<EStructuralFeature> eStructrualFeatures = new ArrayList<EStructuralFeature>();
			for (PeopleColumn col : PeopleColumn.values()) {
				columnNames.add(col.name());
				eStructrualFeatures.add(col.feature);
			}

			colNames = new String[columnNames.size()];
			columnNames.toArray(colNames);
			
			features = new EStructuralFeature[eStructrualFeatures.size()];
			eStructrualFeatures.toArray(features);
		}

	}

	
	/**
	 * People Table Name, First Name, Last Name, Phone Number, Street, City,
	 * State, Zip Code
	 */
	static ObservableListContentProvider setUpPeopleTableViewer(
			final TableViewer tableViewer, final AdapterFactory adapterFactory) {
		ObservableListContentProvider cp = new ObservableListContentProvider();
		IObservableMap[] maps = EMFObservables.observeMaps(cp
				.getKnownElements(), PeopleColumn.features);
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

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
				table.setSortDirection(dir);
				tableViewer.setSorter(new PeopleSorter(
						(PeopleColumn) currentColumn.getData(), dir));
			}

		};
      
		for (PeopleColumn col : PeopleColumn.values()) {
			TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
					SWT.LEAD);
			final TableColumn nameColumn = viewerColumn.getColumn();
			layout.addColumnData(col.layoutData);
			nameColumn.setText(col.text);
			nameColumn.setMoveable(true);
			nameColumn.setData(col);
			nameColumn.addListener(SWT.Selection, sortListener);
			if (col == PeopleColumn.FIRST_NAME) {
				viewerColumn
						.setLabelProvider(new GenericObservableMapCellLabelProvider(
								maps, col.pattern) {
							private final ITableLabelProvider lp = new AdapterFactoryLabelProvider(
									adapterFactory);

							@Override
							public Image getImage(Object element) {
								return lp.getColumnImage(element, 0);
							}
						});
			} else {
			viewerColumn
					.setLabelProvider(new GenericObservableMapCellLabelProvider(
							maps, col.pattern));
			}
			
		}

		tableViewer.setColumnProperties(PeopleColumn.colNames);
		return cp;
	}



}
