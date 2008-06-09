/**
 * 
 */
package com.verticon.tracker.editor.util;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.editor.presentation.AnimalSorter;
import com.verticon.tracker.editor.presentation.EventSorter;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

/**
 * @author jconlon
 *
 */
public class TrackerTableEditorUtils {
	
	/**
	 * Animals Table
	 */
	public static TableViewer createAnimalsTableViewer(ViewerPane viewerPane) {
		final TableViewer tableViewer = (TableViewer)viewerPane.getViewer();
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//Animal
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 220, true));
		animalColumn.setText(getString("_UI_AnimalColumn_label"));
		animalColumn.setMoveable(true);
		
		//Ain 
		final TableColumn ainColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 150, true));
		ainColumn.setText(getString("_UI_AinColumn_label"));
		ainColumn.setMoveable(true);
		
		//Animal
		final TableColumn animalTypeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		animalTypeColumn.setText(getString("_UI_AnimalColumn_label"));
		animalTypeColumn.setMoveable(true);
		
		//Species
		final TableColumn speciesColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 40, true));
		speciesColumn.setText(getString("_UI_SpeciesColumn_label"));
		speciesColumn.setMoveable(true);
		
		//Sex
		final TableColumn sexColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		sexColumn.setText(getString("_UI_SexColumn_label"));
		sexColumn.setMoveable(true);
		
		//Breed 
		final TableColumn breedColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 70, true));
		breedColumn.setText(getString("_UI_BreedColumn_label"));
		breedColumn.setMoveable(true);

		//BirthDate
		final TableColumn dDateColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		dDateColumn.setText(getString("_UI_BirthDateColumn_label"));
		dDateColumn.setMoveable(true);
		
		//Age
		final TableColumn ageColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		ageColumn.setText(getString("_UI_AgeColumn_label"));
		ageColumn.setMoveable(true);
		
		//LastEventDateTime
		final TableColumn lastEventDateTimeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		lastEventDateTimeColumn.setText(getString("_UI_LastEventColumn_label"));
		lastEventDateTimeColumn.setMoveable(true);
		
		//Weight
		final TableColumn weightColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		weightColumn.setText("Weight");
		weightColumn.setMoveable(true);
		
		//WeightGainPerDay
		final TableColumn weightGainColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		weightGainColumn.setText("WeightGainPerDay");
		weightGainColumn.setMoveable(true);
		
		//Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		commentsColumn.setText(getString("_UI_CommentsColumn_label"));
		commentsColumn.setMoveable(true);
		
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
				
				if (currentColumn == animalColumn) {
					sortIdentifier = AnimalSorter.ANIMAL_TEXT;
				}else if (currentColumn == ainColumn) {
					sortIdentifier = AnimalSorter.AIN;
				}else if (currentColumn == animalTypeColumn) {
					sortIdentifier = AnimalSorter.ANIMAL;
				}else if (currentColumn == dDateColumn) {
					sortIdentifier = AnimalSorter.BIRTHDATE;
				}else if (currentColumn == speciesColumn) {
					sortIdentifier = AnimalSorter.SPECIES;
				}else if (currentColumn == sexColumn) {
					sortIdentifier = AnimalSorter.SEX;
				}else if (currentColumn == breedColumn) {
					sortIdentifier = AnimalSorter.BREED;
				}else if (currentColumn == ageColumn) {
					sortIdentifier = AnimalSorter.AGE;
					
				}else if (currentColumn == weightColumn) {
					sortIdentifier = AnimalSorter.WEIGHT;
				}else if (currentColumn == weightGainColumn) {
					sortIdentifier = AnimalSorter.WEIGHT_GAIN;
					
				}else if (currentColumn == commentsColumn) {
					sortIdentifier = AnimalSorter.COMMENTS;
				}else if (currentColumn == lastEventDateTimeColumn){
					sortIdentifier = AnimalSorter.LAST_EVENT_DATE;
				}

				table.setSortDirection(dir);
				tableViewer.setSorter(new AnimalSorter(sortIdentifier,dir));
			}

		};

		breedColumn.addListener(SWT.Selection, sortListener);
		animalColumn.addListener(SWT.Selection, sortListener);
		ainColumn.addListener(SWT.Selection, sortListener);
		lastEventDateTimeColumn.addListener(SWT.Selection, sortListener);
		animalTypeColumn.addListener(SWT.Selection, sortListener);
		speciesColumn.addListener(SWT.Selection, sortListener);
		sexColumn.addListener(SWT.Selection, sortListener);
		dDateColumn.addListener(SWT.Selection, sortListener);
		ageColumn.addListener(SWT.Selection, sortListener);
		
		weightColumn.addListener(SWT.Selection, sortListener);
		weightGainColumn.addListener(SWT.Selection, sortListener);
		
		commentsColumn.addListener(SWT.Selection, sortListener);
		
		
		tableViewer.setColumnProperties(
				new String [] {"a", "b", "c", "d", "e","f", "g", "h","i","j","k","l"});
		
		return tableViewer;
		
	}

	
	
	/**
	 * Events Table
	 */
	public static void setUpEventsTableViewer(
			final TableViewer eventsTableViewer) {
		
		final Table table = eventsTableViewer.getTable();
		
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		eventsTableViewer.setUseHashlookup(true);
		
		
		// Date of Event
		final TableColumn dateTimeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 170, true));
		dateTimeColumn.setText(getString("_UI_DateTimeColumn_label"));
		dateTimeColumn.setMoveable(true);

		// Event Type
		final TableColumn eventNameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 60, true));
		eventNameColumn.setText(getString("_UI_EventNameColumn_label"));
		eventNameColumn.setMoveable(true);

		// Animal
		final TableColumn animalIDColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 230, true));
		animalIDColumn.setText(getString("_UI_AnimalParentColumn_label"));
		animalIDColumn.setMoveable(true);

		// Tag ID Number
		final TableColumn tagIDColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		tagIDColumn.setText(getString("_UI_TagColumn_label"));
		tagIDColumn.setMoveable(true);

		// Comments
		final TableColumn eventCommentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 180, true));
		eventCommentsColumn.setText(getString("_UI_CommentsColumn_label"));
		eventCommentsColumn.setMoveable(true);

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

				if (currentColumn == animalIDColumn) {
					sortIdentifier = EventSorter.ANIMAL_IDNUMBER;
				}

				if (currentColumn == tagIDColumn) {
					sortIdentifier = EventSorter.TAG_IDNUMBER;
				}

				if (currentColumn == dateTimeColumn) {
					sortIdentifier = EventSorter.DATETIME;
				}

				if (currentColumn == eventNameColumn) {
					sortIdentifier = EventSorter.EVENT_TYPE;
				}

				if (currentColumn == eventCommentsColumn) {
					sortIdentifier = EventSorter.EVENT_COMMENTS;
				}

				table.setSortDirection(dir);
				eventsTableViewer
						.setSorter(new EventSorter(sortIdentifier, dir));
			}

		};

		animalIDColumn.addListener(SWT.Selection, sortListener);
		tagIDColumn.addListener(SWT.Selection, sortListener);
		dateTimeColumn.addListener(SWT.Selection, sortListener);
		eventNameColumn.addListener(SWT.Selection, sortListener);
		eventCommentsColumn.addListener(SWT.Selection, sortListener);
		eventsTableViewer.setColumnProperties(new String[] { "a", "b", "c",
				"d", "e" });

	}
		/**
		 * This looks up a string in the plugin's plugin.properties file.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static String getString(String key) {
			return TrackerReportEditorPlugin.INSTANCE.getString(key);
		}
		
		
}
