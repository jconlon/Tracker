/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.fair.Person;


/**
 * @author jconlon
 * 
 */
public class FairTableEditorUtils {

	/**
	 * Name, First Name, Last Name, Phone Number, Street, City,
	 * State, Zip Code
	 * @author jconlon
	 *
	 */
	public enum PeopleColumn {
		NAME("name"), FIRST_NAME("firstName"),LAST_NAME("lastName"), PHONE("phone"), 
		STREET("street"), CITY("city"), STATE("state"), ZIP("zip"), 
		PIN("pin"), COMMENTS("comments");

		String property;
		static List<String> columnNames;
		static String[] colNames;

		PeopleColumn(String property) {
			this.property = property;
		}

		static {
			columnNames = new ArrayList<String>();
			for (PeopleColumn col : PeopleColumn.values()) {
				columnNames.add(col.property);
			}

			colNames = new String[columnNames.size()];
			columnNames.toArray(colNames);
		}

	}
	
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
		nameColumn.setMoveable(true);

		// First Name
		final TableColumn firstNameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		firstNameColumn.setText("First Name");
		firstNameColumn.setMoveable(true);

		// Last Name
		final TableColumn lastNameTypeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		lastNameTypeColumn.setText("Last Name");
		lastNameTypeColumn.setMoveable(true);

		// Phone Number
		final TableColumn phoneColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		phoneColumn.setText("Phone Number");
		phoneColumn.setMoveable(true);

		// Street
		final TableColumn streetColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		streetColumn.setText("Street");
		streetColumn.setMoveable(true);

		// City
		final TableColumn cityColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		cityColumn.setText("City");
		cityColumn.setMoveable(true);
		

		// State
		final TableColumn stateColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		stateColumn.setText("State");
		stateColumn.setMoveable(true);

		// Zip Code
		final TableColumn zipColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		zipColumn.setText("Zip Code");
		zipColumn.setMoveable(true);
		
		//Pin
		final TableColumn pinColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		pinColumn.setText("Pin");
		pinColumn.setMoveable(true);
		
		// Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.LEFT,9);
		layout.addColumnData(new ColumnWeightData(2, 120, true));
		commentsColumn.setText("Comments");
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

		tableViewer.setColumnProperties(PeopleColumn.colNames);
		
		// Create the cell editors
	    CellEditor[] editors = new CellEditor[PeopleColumn.colNames.length];
			
	     // Column 1 : Name
	    TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[0] = textEditor;
		
		// Column 2 : First Name
	    textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[1] = textEditor;
		
		// Column 10 : Name (Free text)
	    textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[9] = textEditor;

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new ICellModifier(){

			//TODO Issue 217
			public boolean canModify(Object element, String property) {
				// Find the index of the column
//				if(PeopleColumn.COMMENTS.property.equals(property)){
//					return true;
//				}
//				if(PeopleColumn.NAME.property.equals(property)){
//					return false;
//				}
//				if(PeopleColumn.FIRST_NAME.property.equals(property)){
//					return true;
//				}

				return false;
			}

			public Object getValue(Object element, String property) {
				Person person = (Person) element;
				
				if(PeopleColumn.COMMENTS.property.equals(property)){
					return person.getComments();
				}
				if(PeopleColumn.FIRST_NAME.property.equals(property)){
					return person.getFirstName();
				}
				return null;
			}

			public void modify(Object element, String property, Object value) {
				TableItem item = (TableItem) element;
				Person person = (Person) item.getData();
				if(PeopleColumn.COMMENTS.property.equals(property)){
					 person.setComments((String)value);
				}else if(PeopleColumn.FIRST_NAME.property.equals(property)){
					 person.setFirstName((String)value);
				
					
				}
				
			}
			
		});

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
		nameColumn.setMoveable(true);

		// Number
		final TableColumn numberColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 30, true));
		numberColumn.setText("Number");
		numberColumn.setMoveable(true);

		// Exhibitor
		final TableColumn exhibitorColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		exhibitorColumn.setText("Exhibitor");
		exhibitorColumn.setMoveable(true);

		// Animal
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		animalColumn.setText("Animal");
		animalColumn.setMoveable(true);

		// Lot
		final TableColumn lotColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		lotColumn.setText("Lot");
		lotColumn.setMoveable(true);

		// Class
		final TableColumn clazzColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		clazzColumn.setText("Class");
		clazzColumn.setMoveable(true);

		// Department
		final TableColumn departmentColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		departmentColumn.setText("Department");
		departmentColumn.setMoveable(true);

		// Division
		final TableColumn divisionColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		divisionColumn.setText("Division");
		divisionColumn.setMoveable(true);

		// Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 300, true));
		commentsColumn.setText("Comments");
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
