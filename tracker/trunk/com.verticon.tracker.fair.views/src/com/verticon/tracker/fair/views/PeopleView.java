package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.Comparator;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

import com.verticon.tracker.Animal;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.GenericViewSorter;
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
		handleViewerInputChange();
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
	public void handleViewerInputChange() {
		if (tableInput != null) {
			tableInput.dispose();
			tableInput = null;
		}
		tableInput = getObservableList();
		masterFilteredTable.getViewer().setInput(tableInput);
		enableMenus(tableInput!=null);
	}


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
	 * Enum specifying columns for the Person Element 
	 * 
	 * @author jconlon
	 * 
	 */
	enum PeopleColumn {
		FIRST_NAME("First Name", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__FIRST_NAME, "{0}", 
				new Comparator<Person>(){

					public int compare(Person person1, Person person2) {
						String value1 = person1.getFirstName()==null?"":person1.getFirstName();
						String value2 = person2.getFirstName()==null?"":person2.getFirstName();
						return value1.compareTo(value2);
					}}),

		LAST_NAME("Last Name", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__LAST_NAME, "{1}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getLastName()==null?"":person1.getLastName();
				String value2 = person2.getLastName()==null?"":person2.getLastName();
				return value1.compareTo(value2);
			}}),

		EXHIBITOR_NUMBER("Exhibitor #", new ColumnWeightData(2, 90, true),
				FairPackage.Literals.PERSON__EXHIBITOR_NUMBER,
				"{2,number,######}", 
				new Comparator<Person>(){

					public int compare(Person person1, Person person2) {
						return person1.getExhibitorNumber() <= person2.getExhibitorNumber() ? -1
								: person1.getExhibitorNumber() == person2.getExhibitorNumber() ? 0
										: 1;
					}}),

		SALES_ORDER("Sales Order",
				new ColumnWeightData(2, 150, true),
				FairPackage.Literals.PERSON__SALES_ORDER, "{3,number,###}",
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				return person1.getSalesOrder() - person2.getSalesOrder();
				
			}}),

		PHONE("Phone", new ColumnWeightData(2, 100, true),
				FairPackage.Literals.PERSON__PHONE, "{4}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getPhone()==null?"":person1.getPhone();
				String value2 = person2.getPhone()==null?"":person2.getPhone();
				return value1.compareTo(value2);
			}}),

		STREET("Street", new ColumnWeightData(2, 200, true),
				FairPackage.Literals.PERSON__STREET, "{5}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getStreet()==null?"":person1.getStreet();
				String value2 = person2.getStreet()==null?"":person2.getStreet();
				return value1.compareTo(value2);
			}}),

		CITY("City", new ColumnWeightData(2, 80, true),
				FairPackage.Literals.PERSON__CITY, "{6}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getCity()==null?"":person1.getCity();
				String value2 = person2.getCity()==null?"":person2.getCity();
				return value1.compareTo(value2);
			}}),

		STATE("State", new ColumnWeightData(2, 45, true),
				FairPackage.Literals.PERSON__STATE, "{7}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getState()==null?"":person1.getState();
				String value2 = person2.getState()==null?"":person2.getState();
				return value1.compareTo(value2);
			}}),

		ZIP("Zip", new ColumnWeightData(2, 45, true),
				FairPackage.Literals.PERSON__ZIP_CODE, "{8}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getZipCode()==null?"":person1.getZipCode();
				String value2 = person2.getZipCode()==null?"":person2.getZipCode();
				return value1.compareTo(value2);
			}}),

	    EMAIL("Email", new ColumnWeightData(2, 200, true),
					FairPackage.Literals.PERSON__EMAIL, "{9}", 
					new Comparator<Person>(){

				public int compare(Person person1, Person person2) {
					String value1 = person1.getEmail()==null?"":person1.getEmail();
					String value2 = person2.getEmail()==null?"":person2.getEmail();
					return value1.compareTo(value2);
				}}),
				
		PIN("Premieses ID", new ColumnWeightData(2, 70, true),
				FairPackage.Literals.PERSON__PIN, "{10}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getPin()==null?"":person1.getPin();
				String value2 = person2.getPin()==null?"":person2.getPin();
				return value1.compareTo(value2);
			}}),

		COMMENTS("Comments", new ColumnWeightData(2, 120, true),
				FairPackage.Literals.PERSON__COMMENTS, "{11}", 
				new Comparator<Person>(){

			public int compare(Person person1, Person person2) {
				String value1 = person1.getComments()==null?"":person1.getComments();
				String value2 = person2.getComments()==null?"":person2.getComments();
				return value1.compareTo(value2);
			}});

		final ColumnLayoutData layoutData;
		final String text;
		final EStructuralFeature feature;
		final String pattern;
		final Comparator<Person> comparator;
		
		static List<String> columnNames;
		static String[] colNames;
		static EStructuralFeature[] features;

		PeopleColumn(String text, ColumnLayoutData layoutData,
				EStructuralFeature feature, String pattern, Comparator<Person> comparator) {
			this.text = text;
			this.layoutData = layoutData;
			this.feature = feature;
			this.pattern = pattern;
			this.comparator=comparator;
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
	@SuppressWarnings("unchecked")
	private ObservableListContentProvider setUpPeopleTableViewer(
			final TableViewer tableViewer, final AdapterFactory adapterFactory) {
		ObservableListContentProvider cp = new ObservableListContentProvider();
		IObservableMap[] maps = EMFObservables.observeMaps(cp
				.getKnownElements(), PeopleColumn.features);
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
        List<TableColumn> tableColumns = new ArrayList<TableColumn>(PeopleColumn.values().length);
        List<Comparator> comparators = new ArrayList<Comparator>(PeopleColumn.values().length);
		for (PeopleColumn col : PeopleColumn.values()) {
			TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
					SWT.LEAD);
			final TableColumn nameColumn = viewerColumn.getColumn();
			tableColumns.add(nameColumn);
			comparators.add(col.comparator);
			layout.addColumnData(col.layoutData);
			nameColumn.setText(col.text);
			nameColumn.setMoveable(true);
			nameColumn.setData(col);
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
        TableColumn[] tableCols = new TableColumn[tableColumns.size()];
        Comparator[] compares = new Comparator[comparators.size()];
	    sorter = new GenericViewSorter(
				tableViewer,  tableColumns.toArray(tableCols),
					comparators.toArray(compares));
		if (memento != null){
					sorter.init(memento);
		}
		
		tableViewer.setSorter(sorter);
		tableViewer.setColumnProperties(PeopleColumn.colNames);
		return cp;
	}



}
