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
/**
 * 
 */
package com.verticon.tracker.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.ColumnUtils;
import com.verticon.tracker.editor.util.GenericViewSorter;
import com.verticon.tracker.util.TrackerUtils;

enum EventColumn {
	DATE(EventsView.getString("_UI_DateTimeColumn_label"), new ColumnWeightData(2, 170, true),
			TrackerPackage.Literals.EVENT__DATE_TIME, "{0}", 
			new Comparator<Event>() {
		public int compare(Event event1, Event event2) {
				Date date1 = event1.getDateTime() == null ? TrackerUtils.DATE_REFERENCE
						.getTime()
						: event1.getDateTime();
				Date date2 = event2.getDateTime() == null ? TrackerUtils.DATE_REFERENCE
						.getTime()
						: event2.getDateTime();
				return date1.compareTo(date2);
			}
		}
	),

	EVENT_NAME(EventsView.getString("_UI_EventNameColumn_label"), new ColumnWeightData(2, 60, true),
			TrackerPackage.Literals.EVENT__EVENT_CODE, "{1}", //FIXME Wrong Literal
			new Comparator<Event>() {
		public int compare(Event event1, Event event2) {
			return event1.getClass().getSimpleName().compareTo(
					event2.getClass().getSimpleName());
		}
	}),

	ANIMAL(AnimalsView.getString("_UI_AnimalParentColumn_label"), new ColumnWeightData(3, 230, true),
			TrackerPackage.Literals.EVENT__ID, "{2}", 
			new Comparator<Event>() {
		public int compare(Event event1, Event event2) {
			Animal animal1 = (Animal) event1.getTag().eContainer();
			Animal animal2 = (Animal) event2.getTag().eContainer();
			return animal1.getId().compareTo(animal2.getId());
		}
	}),
	
	TAG(AnimalsView.getString("_UI_TagColumn_label"), new ColumnWeightData(2, 150, true),
			TrackerPackage.Literals.EVENT__TAG, "{3}", 
			new Comparator<Event>() {
		public int compare(Event event1, Event event2) {
			return event1.getId().compareTo(event2.getId());
		}
	}),
	
	
	
	COMMENTS(AnimalsView.getString("_UI_CommentsColumn_label"), new ColumnWeightData(3, 180, true),
			TrackerPackage.Literals.EVENT__COMMENTS, "{4}", 
			new Comparator<Event>() {
		public int compare(Event event1, Event event2) {
			String comments1 = event1.getComments() == null ? "" : event1
					.getComments();
			String comments2 = event2.getComments() == null ? "" : event2
					.getComments();
			return comments1.compareTo(comments2);
		}
	});
	
	
	
	final ColumnWeightData layoutData;
	final String text;
	/**
	 * The feature field is not used by this class, because content and 
	 * label providers are not added to the individual columns at this time.  
	 * It is included as a place holder to show how it is used in the other 
	 * column enums.
	 */
	final EStructuralFeature feature;
	final String pattern;
	final Comparator<Event> comparator;
	
	static List<String> columnNames;
	static String[] colNames;
	static EStructuralFeature[] features;

	/**
	 * 
	 * @param text of columnName
	 * @param layoutData of column
	 * @param feature to map
	 * @param pattern of MessageFormat outputing of the value of the data
	 * @param comparator for sorting of the column
	 */
	EventColumn(String text, ColumnWeightData layoutData,
			EStructuralFeature feature, String pattern, Comparator<Event> comparator) {
		this.text = text;
		this.layoutData = layoutData;
		this.feature = feature;
		this.pattern = pattern;
		this.comparator=comparator;
	}

	static {
		columnNames = new ArrayList<String>(values().length);
		List<EStructuralFeature> eStructrualFeatures = new ArrayList<EStructuralFeature>(values().length);
		for (EventColumn col : values()) {
			columnNames.add(col.name());
			eStructrualFeatures.add(col.feature);
		}

		colNames = new String[columnNames.size()];
		columnNames.toArray(colNames);
		
		features = new EStructuralFeature[eStructrualFeatures.size()];
		eStructrualFeatures.toArray(features);
	}

	@SuppressWarnings("unchecked")
	static GenericViewSorter setup(TableViewer tableViewer, IMemento memento, 
			final AdapterFactory adapterFactory,  List<Action> actions){// Menu parent){
		
//		ObservableListContentProvider cp = new ObservableListContentProvider();
//		IObservableMap[] maps = EMFObservables.observeMaps(cp
//				.getKnownElements(), features);
		
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		List<TableColumn> tableColumns = new ArrayList<TableColumn>(EventColumn.values().length);
	    List<Comparator<Event>> comparators = new ArrayList<Comparator<Event>>(EventColumn.values().length);

       
		for (EventColumn col : values()) {
			TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
					SWT.LEAD);
		    TableColumn nameColumn = viewerColumn.getColumn();
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
			//Label Providers are created for the whole table in the Events View
//			if (col == EVENT_NAME) {
//				viewerColumn
//						.setLabelProvider(new GenericObservableMapCellLabelProvider(
//								maps, col.pattern) {
//							private final ITableLabelProvider lp = new AdapterFactoryLabelProvider(
//									adapterFactory);
//
//							@Override
//							public Image getImage(Object element) {
//								return lp.getColumnImage(element, 0);
//							}
//						});
//			} else {
//			viewerColumn
//					.setLabelProvider(new GenericObservableMapCellLabelProvider(
//							maps, col.pattern));
//			}

			if(actions!=null){
				ColumnUtils.createMenuItem( actions, nameColumn, col.layoutData.minimumWidth, 
						isVisible);
			}
		}
		
		TableColumn[] tableCols = new TableColumn[tableColumns.size()];
        Comparator[] compares = new Comparator[comparators.size()];
        
        GenericViewSorter sorter = new GenericViewSorter(
				tableViewer,  
				tableColumns.toArray(tableCols),
				comparators.toArray(compares));
        
		if (memento != null){
					sorter.init(memento);
		}
		
		tableViewer.setSorter(sorter);
		tableViewer.setColumnProperties(colNames);
//		tableViewer.setContentProvider(cp);
	
		return sorter;
	}
	
}