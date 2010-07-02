/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Animal;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.ColumnUtils;
import com.verticon.tracker.editor.util.GenericViewSorter;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.presentation.IFairProvider;
import com.verticon.tracker.fair.views.PeopleView.PeopleColumn;

public class ExhibitsView extends TrackerView implements ItemsView{

	private static final String NAME_OF_ITEM_IN_MASTER = "Exhibit";
	
	
	private ISelectionController exhibitsSelectionController;
	
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
	 * Displays a several page wizard to add a Division, Department, Class, Lot,
	 * or Exhibit to the fair model.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Fair fair = getFair();
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
					wizard.disposeObservables();
					return object;
				}

			}
		}
		wizard.disposeObservables();
		return null;
	}
	
	private Fair getFair(){
		if(exhibitsSelectionController.getActiveEditorPart()!=null){
			IFairProvider o = (IFairProvider) exhibitsSelectionController.getActiveEditorPart().getAdapter(IFairProvider.class);
			if(o!=null){
				return o.getFair();
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
	public void handleViewerInputChange() {
		Fair premises = getFair();
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
		enableMenus(premises!=null);
	}

	 /**
	  * @return a collection of ViewerFilters
	  */
	 @Override
	 protected Collection<ViewerFilter> getViewerFilters(){
		 return ViewsPlugin.plugin.getViewerFilters(FairPackage.Literals.EXHIBIT);
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


	  Exhibit getExhibitFromAnimal(Animal animal) {
		Fair fair = getFair();
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
	 * 
	 */
	 private enum ExhibitColumn {
		NAME("Exhibit", new ColumnWeightData(3, 100, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getExhibitor()==null?"":exhibit1.getExhibitor().getName();
				String value2 = exhibit2.getExhibitor()==null?"":exhibit2.getExhibitor().getName();
				return value1.compareTo(value2);
			}}), 
		
		NUMBER("Number", new ColumnWeightData(3, 30, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				 if( exhibit1.getNumber() < exhibit2.getNumber()){
					 return -1;
				 }else if(exhibit1.getNumber() == exhibit2.getNumber()){
					return 0;
				 }
				 return 1;
			}}),  
		
		ANIMAL("Animal", new ColumnWeightData(2, 200, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = (exhibit1.getAnimal()==null || exhibit1.getAnimal().getId()==null)?
						"":exhibit1.getAnimal().getId();
				String value2 = (exhibit2.getAnimal()==null || exhibit2.getAnimal().getId()==null)?
						"":exhibit2.getAnimal().getId();
				return value1.compareTo(value2);
			}}), 
			
		ANIMAL_WEIGHT("Animal Weight", new ColumnWeightData(2, 80, true), 
					new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
					Double value1 = (exhibit1.getAnimal()==null || exhibit1.getAnimal().getWeight()==null)?
							0:exhibit1.getAnimal().getWeight();
					Double value2 = (exhibit2.getAnimal()==null || exhibit2.getAnimal().getWeight()==null)?
							0:exhibit2.getAnimal().getWeight();
					return value1.compareTo(value2);
		    }}), 

	    ANIMAL_WEIGHT_GAIN("Animal Weight Gain", new ColumnWeightData(2, 80, true), 
					new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
					Double value1 = (exhibit1.getAnimal()==null || exhibit1.getAnimal().getWeightGainPerDay()==null)?
							0:exhibit1.getAnimal().getWeightGainPerDay();
					Double value2 = (exhibit2.getAnimal()==null || exhibit2.getAnimal().getWeightGainPerDay()==null)?
							0:exhibit2.getAnimal().getWeightGainPerDay();
					return value1.compareTo(value2);
		    }}), 

		LOT("Lot", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getName()==null?
						"":exhibit1.getLot().getName();
				String value2 = exhibit2.getLot().getName()==null?
						"":exhibit2.getLot().getName();
				return value1.compareTo(value2);
			}}),  
		
		LOT_DESC("Lot Description", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getDescription()==null?
						"":exhibit1.getLot().getDescription();
				String value2 = exhibit2.getLot().getDescription()==null?
						"":exhibit2.getLot().getDescription();
				return value1.compareTo(value2);
			}}), 
		
		CLASS("Class", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getName()==null?
						"":exhibit1.getLot().getClass_().getName();
				String value2 = exhibit2.getLot().getClass_().getName()==null?
						"":exhibit2.getLot().getClass_().getName();
				return value1.compareTo(value2);
			}}),  
		
		CLASS_DESC("Class Description", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getDescription()==null?
						"":exhibit1.getLot().getClass_().getDescription();
				String value2 = exhibit2.getLot().getClass_().getDescription()==null?
						"":exhibit2.getLot().getClass_().getDescription();
				return value1.compareTo(value2);
			}}),  
				
		DEPARTMENT("Department", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getDepartment().getName()==null?
						"":exhibit1.getLot().getClass_().getDepartment().getName();
				String value2 = exhibit2.getLot().getClass_().getDepartment().getName()==null?
						"":exhibit2.getLot().getClass_().getDepartment().getName();
				return value1.compareTo(value2);
			}}), 
		
		DEPARTMENT_DESC("Department Description", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getDepartment().getDescription()==null?
						"":exhibit1.getLot().getClass_().getDepartment().getDescription();
				String value2 = exhibit2.getLot().getClass_().getDepartment().getDescription()==null?
						"":exhibit2.getLot().getClass_().getDepartment().getDescription();
				return value1.compareTo(value2);
			}}),  
		
		DIVISION("Division", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getDepartment().getDivision().getName()==null?
						"":exhibit1.getLot().getClass_().getDepartment().getDivision().getName();
				String value2 = exhibit2.getLot().getClass_().getDepartment().getDivision().getName()==null?
						"":exhibit2.getLot().getClass_().getDepartment().getDivision().getName();
				return value1.compareTo(value2);
			}}),  
		
		DIVISION_DESC("Division Description", new ColumnWeightData(2, 150, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String value1 = exhibit1.getLot().getClass_().getDepartment().getDivision().getDescription()==null?
						"":exhibit1.getLot().getClass_().getDepartment().getDivision().getDescription();
				String value2 = exhibit2.getLot().getClass_().getDepartment().getDivision().getDescription()==null?
						"":exhibit2.getLot().getClass_().getDepartment().getDivision().getDescription();
				return value1.compareTo(value2);
			}}),  
		
		COMMENTS("Comments", new ColumnWeightData(2, 120, true), 
		new Comparator<Exhibit>(){

			public int compare(Exhibit exhibit1, Exhibit exhibit2) {
				String comments1 = exhibit1.getComments()==null?"":exhibit1.getComments();
				String comments2 = exhibit2.getComments()==null?"":exhibit2.getComments();
				return comments1.compareTo(comments2);
			}});

		final ColumnWeightData layoutData;
		final String text;
		final Comparator<Exhibit> comparator;
		static List<String> columnNames;
		static String[] colNames;

		ExhibitColumn(String text, ColumnWeightData layoutData, Comparator<Exhibit> comparator) {
			this.text = text;
			this.layoutData = layoutData;
			this.comparator=comparator;
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
	@SuppressWarnings("unchecked")
	private void setUpExhibitsTableViewer(final TableViewer tableViewer) {
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		List<TableColumn> tableColumns = new ArrayList<TableColumn>(ExhibitColumn.values().length);
	    List<Comparator> comparators = new ArrayList<Comparator>(ExhibitColumn.values().length);
			
		for (ExhibitColumn col : ExhibitColumn.values()) {
			final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			tableColumns.add(nameColumn);
			comparators.add(col.comparator);
			nameColumn.setText(col.text);
			nameColumn.setMoveable(true);
			nameColumn.setData(col);
			boolean isVisible = ColumnUtils.isColumnVisible( memento, col.text);
			if(!isVisible){
				layout.addColumnData(new ColumnWeightData(0, 0, false));
			}else{
				layout.addColumnData(col.layoutData);
			}
			
			if(actions!=null){
				ColumnUtils.createMenuItem( actions, nameColumn, col.layoutData.minimumWidth, 
						isVisible);
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

		}
	

	
}
