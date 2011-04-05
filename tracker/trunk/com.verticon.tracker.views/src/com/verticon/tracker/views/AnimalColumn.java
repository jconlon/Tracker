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

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

import com.verticon.tracker.Animal;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.util.ColumnUtils;
import com.verticon.tracker.editor.util.GenericViewSorter;
import com.verticon.tracker.util.TrackerUtils;

enum AnimalColumn {
	AIN(AnimalsView.getString("_UI_AinColumn_label"), new ColumnWeightData(3, 130, true),
			TrackerPackage.Literals.ANIMAL__ID, "{0}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			return animal1.getId().compareTo(animal2.getId());
		}
	}),

	TYPE(AnimalsView.getString("_UI_AnimalTypeColumn_label"), new ColumnWeightData(2, 105, true),
			TrackerPackage.Literals.ANIMAL__TYPE, "{1}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			return animal1.getClass().getSimpleName().compareTo(animal2.getClass().getSimpleName());
		}
	}),

	SEX(AnimalsView.getString("_UI_SexColumn_label"), new ColumnWeightData(2, 62, true),
			TrackerPackage.Literals.ANIMAL__SEX, "{2}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
				return animal1.getSexCode().compareTo(animal2.getSexCode());
			
		}
	}),
	
	BREED(AnimalsView.getString("_UI_BreedColumn_label"), new ColumnWeightData(2, 50, true),
			TrackerPackage.Literals.ANIMAL__BREED, "{3}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			return animal1.getBreed().compareTo(animal2.getBreed());
			
		}
	}),
	
	BIRTHDATE(AnimalsView.getString("_UI_BirthDateColumn_label"), new ColumnWeightData(2, 120, true),
			TrackerPackage.Literals.ANIMAL__BIRTH_DATE, "{4}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			Date date1 = animal1.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getBirthDate();
			Date date2 = animal2.getBirthDate()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getBirthDate();
			return date1.compareTo(date2);
		}
	}),
	
	LASTEVENT(AnimalsView.getString("_UI_LastEventColumn_label"), new ColumnWeightData(2, 130, true),
			TrackerPackage.Literals.ANIMAL__LAST_EVENT_DATE_TIME, "{5}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			Date date1 = animal1.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal1.getLastEventDateTime();
			Date date2 = animal2.getLastEventDateTime()==null?TrackerUtils.DATE_REFERENCE.getTime():animal2.getLastEventDateTime();
			return date1.compareTo(date2);
		}
	}),
	
	
	WEIGHT(AnimalsView.getString("_UI_WeightColumn_label"), new ColumnWeightData(2, 50, true),
			TrackerPackage.Literals.ANIMAL__WEIGHT, "{6}", 
			new Comparator<Animal>() {
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
	}),
	
	WEIGHTGAIN(AnimalsView.getString("_UI_WeightGainPerDayColumn_label"), new ColumnWeightData(2, 80, true),
			TrackerPackage.Literals.ANIMAL__WEIGHT_GAIN_PER_DAY, "{7}", 
			new Comparator<Animal>() {
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
	}),
	
	VID(AnimalsView.getString("_UI_VisualIDColumn_label"), new ColumnWeightData(2, 80, true),
			TrackerPackage.Literals.ANIMAL__VISUAL_ID, "{8}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			String vid1 = animal1.getVisualID() == null ? "" : animal1
					.getVisualID();
			String vid2 = animal2.getVisualID() == null ? "" : animal2
					.getVisualID();
			return vid1.compareTo(vid2);
		}
	}),
	

	LOCATION(AnimalsView.getString("_UI_LocationColumn_label"), new ColumnWeightData(2, 80, true),
			TrackerPackage.Literals.ANIMAL__LOCATION, "{9}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			String loc1 = animal1.getLocation() == null ? "" : animal1
					.getLocation();
			String loc2 = animal2.getLocation() == null ? "" : animal2
					.getLocation();
			return loc1.compareTo(loc2);
		}
	}),
	
	AID(AnimalsView.getString("_UI_AlternativeIDColumn_label"), new ColumnWeightData(2, 120, true),
			TrackerPackage.Literals.ANIMAL__ALTERNATIVE_ID, "{10}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			String id1 =animal1.getAlternativeID() == null ? "" : animal1
					.getAlternativeID();
			String id2 = animal2.getAlternativeID() == null ? "" : animal2
					.getAlternativeID();
			return id1.compareTo(id2);
		}
	}),
	
	COMMENTS(AnimalsView.getString("_UI_CommentsColumn_label"), new ColumnWeightData(2, 200, true),
			TrackerPackage.Literals.ANIMAL__COMMENTS, "{11}", 
			new Comparator<Animal>() {
		public int compare(Animal animal1, Animal animal2) {
			String comments1 = animal1.getComments() == null ? "" : animal1
					.getComments();
			String comments2 = animal2.getComments() == null ? "" : animal2
					.getComments();
			return comments1.compareTo(comments2);
		}
	});
	
	
	
	final ColumnWeightData layoutData;
	final String text;
	final EStructuralFeature feature;
	final String pattern;
	final Comparator<Animal> comparator;
	
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
	AnimalColumn(String text, ColumnWeightData layoutData,
			EStructuralFeature feature, String pattern, Comparator<Animal> comparator) {
		this.text = text;
		this.layoutData = layoutData;
		this.feature = feature;
		this.pattern = pattern;
		this.comparator=comparator;
	}

	static {
		columnNames = new ArrayList<String>(values().length);
		List<EStructuralFeature> eStructrualFeatures = new ArrayList<EStructuralFeature>(values().length);
		for (AnimalColumn col : values()) {
			columnNames.add(col.name());
			eStructrualFeatures.add(col.feature);
		}

		colNames = new String[columnNames.size()];
		columnNames.toArray(colNames);
		
		features = new EStructuralFeature[eStructrualFeatures.size()];
		eStructrualFeatures.toArray(features);
		
	}

	/**
	 * Set up the Animals Table on the TableViewer.  
	 * 
	 * @param tableViewer
	 * @param memento
	 * @param adapterFactory
	 * @param actions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static GenericViewSorter setupTable(TableViewer tableViewer, IMemento memento, 
			final AdapterFactory adapterFactory,  List<Action> actions){// Menu parent){
		
		//Create a content provider that will take a list of Premises Animals
		//This will be disposed with the table
		ObservableListContentProvider cp = new ObservableListContentProvider();
		
		//Create an array of maps one for each feature.  The map keys will be the set 
		//of elements in the content provider (animals from the premises) the detail 
		//to observe is the feature.
		//
		//These maps will be disposed along with the table
		final IObservableMap[] maps = new IObservableMap[features.length];
		
		for (int i = 0; i < features.length; i++) {
			maps[i] = EMFProperties.value(features[i]).observeDetail(cp.getKnownElements());
		}
		
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		List<TableColumn> tableColumns = new ArrayList<TableColumn>(AnimalColumn.values().length);
	    List<Comparator<Animal>> comparators = new ArrayList<Comparator<Animal>>(AnimalColumn.values().length);

       
		for (AnimalColumn col : values()) {
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
			
			if (col == TYPE) {
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
		tableViewer.setContentProvider(cp);
		
		return sorter;
	}
	
}