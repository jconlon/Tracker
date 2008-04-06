/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.TrackerTableEditorUtils;
import com.verticon.tracker.fair.Fair;

/**
 * @author jconlon
 * 
 */
public class FairTableEditorUtils {

	/**
	 * Animals Table
	 */
	public static void createAnimalsTableViewer(ViewerPane viewerPane,
			final TableViewer tableViewer, AdapterFactory adapterFactory) {

		TrackerTableEditorUtils.createAnimalsTableViewer(viewerPane,
				tableViewer, adapterFactory);
		// The utility does not set the contentAdapter to find the Premises do
		// it again here
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) 
				{
					@Override
					public Object[] getElements(Object object) {
						if (object instanceof Fair) {
							Premises premises = ((Fair) object).getPremises();
							if (premises != null) {
								return premises.getAnimals().toArray();
							}
						} else if (object instanceof Premises) {
							Premises premises = (Premises) object;
							if (premises != null) {
								return premises.getAnimals().toArray();
							}
						}
						return null;
					}

				});

	}

	/**
	 * Events Table
	 */
	public static void createEventsTableViewer(ViewerPane viewerPane,
			final TableViewer tableViewer, AdapterFactory adapterFactory) {
		TrackerTableEditorUtils.createEventsTableViewer(viewerPane,
				tableViewer, adapterFactory);
		// The utility does not set the contentAdapter to find the Premises do
		// it again here
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) 
				{
					public Object[] getElements(Object object) {
						if (object instanceof Fair) {
							Premises premises = ((Fair) object).getPremises();
							if (premises != null) {
								return premises.eventHistory().toArray();
							}
						} else if (object instanceof Premises) {
							Premises premises = (Premises) object;
							if (premises != null) {
								return premises.eventHistory().toArray();
							}
						}
						return null;
					}

					public void notifyChanged(Notification notification) {

						switch (notification.getEventType()) {
						case Notification.ADD:
						case Notification.ADD_MANY:
							if (notification.getFeature() != TrackerPackage.eINSTANCE
									.getTag_Events()) {
								return;
							}
						}
						super.notifyChanged(notification);

					}
				});
	}

	/**
	 * People Table
	 * Name, First Name, Last Name, Phone Number, Street, City, State, Zip Code
	 */
	public static void createPeopleTableViewer(ViewerPane viewerPane,
			final TableViewer tableViewer, AdapterFactory adapterFactory) {

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
		layout.addColumnData(new ColumnWeightData(3, 100, true));
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
		layout.addColumnData(new ColumnWeightData(2, 250, true));
		streetColumn.setText("Street");

		// City
		final TableColumn cityColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		cityColumn.setText("City");

		// State
		final TableColumn stateColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 40, true));
		stateColumn.setText("State");

		// Zip Code
		final TableColumn zipColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 40, true));
		zipColumn.setText("Zip Code");


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

		
		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h" });

		/**
		 * The default ItemProvider returned via the adapterFactory for Premises
		 * should be able to handle all notifications of animals being added or
		 * removed.
		 * 
		 * To get Animal Elements override the getElements method
		 */
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) 
				{
					@Override
					public Object[] getElements(Object object) {
						Fair fair = (Fair)object;
						
						return fair.getPeople().toArray();
					}

				});
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));

	}
	
	/**
	 * Exhibits Table
	 * Name, Number, Exhibitor, Animal, Lot, Class, Department, Division, Comments
	 */
	public static void createExhibitsTableViewer(ViewerPane viewerPane,
			final TableViewer tableViewer, AdapterFactory adapterFactory) {

		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Name
		final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 100, true));
		nameColumn.setText("Exhibit Name");

		// Number
		final TableColumn numberColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 100, true));
		numberColumn.setText("Number");

		// Exhibitor
		final TableColumn exhibitorColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 140, true));
		exhibitorColumn.setText("Exhibitor");

		// Animal
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 140, true));
		animalColumn.setText("Animal");

		// Lot
		final TableColumn lotColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		lotColumn.setText("Lot");
		
		// Class
		final TableColumn clazzColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		clazzColumn.setText("Class");

		// Department 
		final TableColumn departmentColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		departmentColumn.setText("Department");

		// Division
		final TableColumn divisionColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
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
		//Name, Number, Exhibitor, Animal, Lot, Class, Department, Division, Comments
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

		/**
		 * The default ItemProvider returned via the adapterFactory for Premises
		 * should be able to handle all notifications of animals being added or
		 * removed.
		 * 
		 * To get Animal Elements override the getElements method
		 */
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) 
				{
					@Override
					public Object[] getElements(Object object) {
						return ((Fair) object).exhibits().toArray();
					}

				});
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));

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
