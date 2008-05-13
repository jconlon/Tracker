/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author jconlon
 * 
 */
public class FairTableEditorUtils {

	/**
	 * People Table Name, First Name, Last Name, Phone Number, Street, City,
	 * State, Zip Code
	 */
	public static TableViewer createPeopleTableViewer(ViewerPane viewerPane) {
		final TableViewer tableViewer = (TableViewer)viewerPane.getViewer();
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Name
		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 200, true));
		nameColumn.setText("Name");

		// First Name
		final TableColumn firstNameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		firstNameColumn.setText("First Name");

		// Last Name
		final TableColumn lastNameTypeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		lastNameTypeColumn.setText("Last Name");

		// Phone Number
		final TableColumn phoneColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		phoneColumn.setText("Phone Number");

		// Street
		final TableColumn streetColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		streetColumn.setText("Street");

		// City
		final TableColumn cityColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		cityColumn.setText("City");

		// State
		final TableColumn stateColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		stateColumn.setText("State");

		// Zip Code
		final TableColumn zipColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		zipColumn.setText("Zip Code");
		
		// Zip Code
		final TableColumn pinColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		pinColumn.setText("Pin");
		
		// Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 120, true));
		commentsColumn.setText("Comments");

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

				if (currentColumn == nameColumn) {
					sortIdentifier = PeopleSorter.NAME;
				} else if (currentColumn == firstNameColumn) {
					sortIdentifier = PeopleSorter.FIRST_NAME;
				} else if (currentColumn == lastNameTypeColumn) {
					sortIdentifier = PeopleSorter.LAST_NAME;
				} else if (currentColumn == stateColumn) {
					sortIdentifier = PeopleSorter.STATE;
				} else if (currentColumn == phoneColumn) {
					sortIdentifier = PeopleSorter.PHONE;
				} else if (currentColumn == streetColumn) {
					sortIdentifier = PeopleSorter.STREET;
				} else if (currentColumn == cityColumn) {
					sortIdentifier = PeopleSorter.CITY;
				} else if (currentColumn == zipColumn) {
					sortIdentifier = PeopleSorter.ZIP;
				} else if (currentColumn == pinColumn){
					sortIdentifier = PeopleSorter.PIN;
				}else if (currentColumn == commentsColumn){
					sortIdentifier = PeopleSorter.COMMENTS;
				}

				table.setSortDirection(dir);
				tableViewer.setSorter(new PeopleSorter(sortIdentifier, dir));
			}

		};

		cityColumn.addListener(SWT.Selection, sortListener);
		nameColumn.addListener(SWT.Selection, sortListener);
		firstNameColumn.addListener(SWT.Selection, sortListener);
		lastNameTypeColumn.addListener(SWT.Selection, sortListener);
		phoneColumn.addListener(SWT.Selection, sortListener);
		streetColumn.addListener(SWT.Selection, sortListener);
		stateColumn.addListener(SWT.Selection, sortListener);
		zipColumn.addListener(SWT.Selection, sortListener);
		pinColumn.addListener(SWT.Selection, sortListener);
		commentsColumn.addListener(SWT.Selection, sortListener);

		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i", "j"});

		return tableViewer;

	}

	/**
	 * Exhibits Table Name, Number, Exhibitor, Animal, Lot, Class, Department,
	 * Division, Comments
	 */
	public static TableViewer createExhibitsTableViewer(ViewerPane viewerPane) {
		final TableViewer tableViewer = (TableViewer)viewerPane.getViewer();
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Name
		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 100, true));
		nameColumn.setText("Exhibit");

		// Number
		final TableColumn numberColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 30, true));
		numberColumn.setText("Number");

		// Exhibitor
		final TableColumn exhibitorColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		exhibitorColumn.setText("Exhibitor");

		// Animal
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		animalColumn.setText("Animal");

		// Lot
		final TableColumn lotColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		lotColumn.setText("Lot");

		// Class
		final TableColumn clazzColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		clazzColumn.setText("Class");

		// Department
		final TableColumn departmentColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		departmentColumn.setText("Department");

		// Division
		final TableColumn divisionColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		divisionColumn.setText("Division");

		// Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 300, true));
		commentsColumn.setText("Comments");

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

				if (currentColumn == nameColumn) {
					sortIdentifier = ExhibitSorter.NAME;

				} else if (currentColumn == animalColumn) {
					sortIdentifier = ExhibitSorter.ANIMAL;

				} else if (currentColumn == departmentColumn) {
					sortIdentifier = ExhibitSorter.DEPARTMENT;

				} else if (currentColumn == numberColumn) {
					sortIdentifier = ExhibitSorter.NUMBER;

				} else if (currentColumn == exhibitorColumn) {
					sortIdentifier = ExhibitSorter.EXHIBITOR;

				} else if (currentColumn == clazzColumn) {
					sortIdentifier = ExhibitSorter.CLASS;

				} else if (currentColumn == lotColumn) {
					sortIdentifier = ExhibitSorter.LOT;

				} else if (currentColumn == divisionColumn) {
					sortIdentifier = ExhibitSorter.DIVISION;

				} else if (currentColumn == commentsColumn) {
					sortIdentifier = ExhibitSorter.COMMENTS;

				}

				table.setSortDirection(dir);
				tableViewer.setSorter(new ExhibitSorter(sortIdentifier, dir));
			}

		};
		// Name, Number, Exhibitor, Animal, Lot, Class, Department, Division,
		// Comments
		departmentColumn.addListener(SWT.Selection, sortListener);
		nameColumn.addListener(SWT.Selection, sortListener);
		numberColumn.addListener(SWT.Selection, sortListener);
		commentsColumn.addListener(SWT.Selection, sortListener);
		exhibitorColumn.addListener(SWT.Selection, sortListener);
		animalColumn.addListener(SWT.Selection, sortListener);
		lotColumn.addListener(SWT.Selection, sortListener);
		divisionColumn.addListener(SWT.Selection, sortListener);
		clazzColumn.addListener(SWT.Selection, sortListener);

		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i" });
		return tableViewer;

	}

	/**
	 * This looks up a string in the plugin's plugin.properties file. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static String getString(String key) {
		return FairEditorPlugin.INSTANCE.getString(key);
	}

}
