package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Animal;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.views.PeopleView.PeopleColumn;

public class ExhibitsView extends TrackerView implements ItemsView{

	private static final String NAME_OF_ITEM_IN_MASTER = "Exhibit";
	
	
	private ISelectionController exhibitsSelectionController;
	
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
				this, new ExhibitsStrategy(this));
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
	 * Displays a several page wizard to add a Division, Department, Class, Lot,
	 * or Exhibit to the fair model.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Fair fair = getFair(exhibitsSelectionController.getEditingDomain());
		AddExhibitWizard wizard = new AddExhibitWizard(fair, getSite()
				.getWorkbenchWindow().getWorkbench().getActiveWorkbenchWindow());
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();

		wizard.dispose();
		if(results == WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				if (object instanceof Exhibit) {

					return object;
				}

			}
		}
		return null;
	}
	
	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		setUpExhibitsTableViewer(tableViewer);
		masterFilteredTable.setColumns(tableViewer.getTable().getColumns());

		tableViewer.setContentProvider(new ExhibitsContentAdapter(
				adapterFactory));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	@Override
	protected void handleViewerInputChange() {
		Fair premises = getFair(exhibitsSelectionController.getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
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
	 * @param exhibitToSelect
	 */
	 void setSelection(Object exhibitToSelect) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		if (exhibitToSelect != null) {
			tableViewer.setSelection(new StructuredSelection(exhibitToSelect),
					true);
		} else {
			tableViewer.setSelection(new StructuredSelection());
		}
	}

	 
	 /**
		 * @return fair
		 */
		private Fair getFair(EditingDomain domain) {
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

	  Exhibit getExhibitFromAnimal(Animal animal) {
		Fair fair = getFair(exhibitsSelectionController.getEditingDomain());
		if (animal == null || fair == null) {
			return null;
		}
		for (Exhibit exhibit : fair.exhibits()) {
			if (animal.equals(exhibit.getAnimal())) {
				return exhibit;
			}
		}

		return null;
	}

	/**
	 * Enum on Exhibit Element
	 * 
	 * @author jconlon
	 * 
	 */
	 enum ExhibitColumn {
		NAME("Exhibit", new ColumnWeightData(3, 100, true)), 
		
		NUMBER("Number", new ColumnWeightData(3, 30, true)), 
		
//		EXHIBITOR("Exhibitor",new ColumnWeightData(2, 150, true)), 
		
		ANIMAL("Animal", new ColumnWeightData(2, 200, true)), 
		
		LOT("Lot", new ColumnWeightData(2, 150, true)), 
		
		CLASS("Class", new ColumnWeightData(2, 150, true)), 
				
		DEPARTMENT("Department", new ColumnWeightData(2, 150, true)), 
		
		DIVISION("Division", new ColumnWeightData(2, 150, true)), 
		
		COMMENTS("Comments", new ColumnWeightData(2, 120, true));

		ColumnLayoutData layoutData;
		String text;
		static List<String> columnNames;
		static String[] colNames;

		ExhibitColumn(String text, ColumnLayoutData layoutData) {
			this.text = text;
			this.layoutData = layoutData;
		}

		static {
			columnNames = new ArrayList<String>();
			for (PeopleColumn col : PeopleColumn.values()) {
				columnNames.add(col.name());
			}

			colNames = new String[columnNames.size()];
			columnNames.toArray(colNames);
		}

	}

	/**
	 * Exhibits Table Name, Number, Exhibitor, Animal, Lot, Class, Department,
	 * Division, Comments
	 */
	private static void setUpExhibitsTableViewer(final TableViewer tableViewer) {
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
				tableViewer.setSorter(new ExhibitSorter(
						(ExhibitColumn) currentColumn.getData(), dir));
			}

		};

		for (ExhibitColumn col : ExhibitColumn.values()) {
			final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			layout.addColumnData(col.layoutData);
			nameColumn.setText(col.text);
			nameColumn.setMoveable(true);
			nameColumn.setData(col);
			nameColumn.addListener(SWT.Selection, sortListener);
		}

		tableViewer.setColumnProperties(PeopleColumn.colNames);

	}

	
}
