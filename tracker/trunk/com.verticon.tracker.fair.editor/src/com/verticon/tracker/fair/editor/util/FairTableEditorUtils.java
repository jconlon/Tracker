/**
 * 
 */
package com.verticon.tracker.fair.editor.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.fair.editor.presentation.ExhibitSorter;
import com.verticon.tracker.fair.editor.presentation.FairEditorPlugin;


/**
 * @author jconlon
 * 
 */
public class FairTableEditorUtils {

	// Suppress default constructor for noninstantiability
	private FairTableEditorUtils() {
		throw new AssertionError();
	}

	/**
	 * Enum on Person Element
	 * @author jconlon
	 *
	 */
	public enum PeopleColumn {
		NAME("Name",new ColumnWeightData(3, 200, true)), 
		FIRST_NAME("First Name",new ColumnWeightData(2, 100, true)),
		LAST_NAME("Last Name",new ColumnWeightData(2, 100, true)), 
		SALES_ORDER("Sales Order in Auction",new ColumnWeightData(2, 150, true)),
		PHONE("Phone",new ColumnWeightData(2, 100, true)), 
		STREET("Street",new ColumnWeightData(2, 200, true)), 
		CITY("City",new ColumnWeightData(2, 80, true)), 
		STATE("State",new ColumnWeightData(2, 20, true)), 
		ZIP("Zip",new ColumnWeightData(2, 20, true)), 
		PIN("Premieses ID",new ColumnWeightData(2, 40, true)), 
		COMMENTS("Comments",new ColumnWeightData(2, 120, true));

		ColumnLayoutData layoutData;
		String text;
		static List<String> columnNames;
		static String[] colNames;
		

		PeopleColumn(String text, ColumnLayoutData layoutData) {
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
	 * People Table Name, First Name, Last Name, Phone Number, Street, City,
	 * State, Zip Code
	 */
	public static void setUpPeopleTableViewer(final TableViewer tableViewer) {
		
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
				tableViewer.setSorter(new PeopleSorter((PeopleColumn)currentColumn.getData(), dir));
			}

		};
		
		for (PeopleColumn col : PeopleColumn.values()) {
			final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
			layout.addColumnData(col.layoutData);
			nameColumn.setText(col.text);
			nameColumn.setMoveable(true);
			nameColumn.setData(col);
			nameColumn.addListener(SWT.Selection, sortListener);
		}

		tableViewer.setColumnProperties(PeopleColumn.colNames);
		
//		// Create the cell editors
//	    CellEditor[] editors = new CellEditor[PeopleColumn.colNames.length];
//			
//	     // Column 1 : Name
//	    TextCellEditor textEditor = new TextCellEditor(table);
//		((Text) textEditor.getControl()).setTextLimit(60);
//		editors[0] = textEditor;
//		
//		// Column 2 : First Name
//	    textEditor = new TextCellEditor(table);
//		((Text) textEditor.getControl()).setTextLimit(60);
//		editors[1] = textEditor;
//		
//		// Column 10 : Name (Free text)
//	    textEditor = new TextCellEditor(table);
//		((Text) textEditor.getControl()).setTextLimit(60);
//		editors[9] = textEditor;

//		// Assign the cell editors to the viewer
//		tableViewer.setCellEditors(editors);
//		// Set the cell modifier for the viewer
//		tableViewer.setCellModifier(new ICellModifier(){
//
//		   //TODO Issue 217
//			public boolean canModify(Object element, String text) {
//				// Find the index of the column
////				if(PeopleColumn.COMMENTS.property.equals(text)){
////					return true;
////				}
////				if(PeopleColumn.NAME.property.equals(text)){
////					return false;
////				}
////				if(PeopleColumn.FIRST_NAME.property.equals(text)){
////					return true;
////				}
//
//				return false;
//			}
//
//			public Object getValue(Object element, String text) {
//				Person person = (Person) element;
//				
//				if(PeopleColumn.COMMENTS.property.equals(text)){
//					return person.getComments();
//				}
//				if(PeopleColumn.FIRST_NAME.property.equals(text)){
//					return person.getFirstName();
//				}
//				return null;
//			}
//
//			public void modify(Object element, String text, Object value) {
//				TableItem item = (TableItem) element;
//				Person person = (Person) item.getData();
//				if(PeopleColumn.COMMENTS.property.equals(text)){
//					 person.setComments((String)value);
//				}else if(PeopleColumn.FIRST_NAME.property.equals(text)){
//					 person.setFirstName((String)value);
//				
//					
//				}
//				
//			}
//			
//		});

	}


	/**
	 * Enum on Exhibit Element
	 * @author jconlon
	 *
	 */
	public enum ExhibitColumn {
		NAME("Exhibit",new ColumnWeightData(3, 100, true)), 
		NUMBER("Number",new ColumnWeightData(3, 30, true)), 
		EXHIBITOR("Exhibitor",new ColumnWeightData(2, 150, true)),
		ANIMAL("Animal",new ColumnWeightData(2, 200, true)),
		LOT("Lot",new ColumnWeightData(2, 150, true)),
		CLASS("Class",new ColumnWeightData(2, 150, true)),
		DEPARTMENT("Department",new ColumnWeightData(2, 150, true)),
		DIVISION("Division",new ColumnWeightData(2, 150, true)),
		COMMENTS("Comments",new ColumnWeightData(2, 120, true));

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
	public static void setUpExhibitsTableViewer(final TableViewer tableViewer) {
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
				tableViewer.setSorter(new ExhibitSorter((ExhibitColumn)currentColumn.getData(), dir));
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

 

