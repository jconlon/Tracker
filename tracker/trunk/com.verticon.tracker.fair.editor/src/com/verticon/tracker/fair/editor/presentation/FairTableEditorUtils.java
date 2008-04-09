/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
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

import com.verticon.tracker.fair.Fair;

/**
 * @author jconlon
 * 
 */
public class FairTableEditorUtils {

//	/**
//	 * Animals Table
//	 */
//	public static void createAnimalsTableViewer(ViewerPane viewerPane,
//			final TableViewer tableViewer, AdapterFactory adapterFactory) {
//
//		TrackerTableEditorUtils.createAnimalsTableViewer(viewerPane,
//				tableViewer, adapterFactory);
//
//	}

//	/**
//	 * Events Table
//	 */
//	public static void createEventsTableViewer(ViewerPane viewerPane,
//			final TableViewer tableViewer, AdapterFactory adapterFactory) {
//		TrackerTableEditorUtils.createEventsTableViewer(viewerPane,
//				tableViewer, adapterFactory);
//	
//	}

	/**
	 * People Table Name, First Name, Last Name, Phone Number, Street, City,
	 * State, Zip Code
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
				} else if (currentColumn == commentsColumn){
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
		commentsColumn.addListener(SWT.Selection, sortListener);

		tableViewer.setColumnProperties(new String[] { "a", "b", "c", "d", "e",
				"f", "g", "h", "i"});

		/**
		 * The default ItemProvider returned via the adapterFactory for Premises
		 * should be able to handle all notifications of animals being added or
		 * removed.
		 * 
		 * To get People Elements override the getElements method
		 */
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				Fair fair = (Fair) object;

				return fair.getPeople().toArray();
			}

		});
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));

	}

	/**
	 * Exhibits Table Name, Number, Exhibitor, Animal, Lot, Class, Department,
	 * Division, Comments
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

		/**
		 * The default ItemProvider returned via the adapterFactory for Premises
		 * should be able to handle all notifications of animals being added or
		 * removed.
		 * 
		 * To get Animal Elements override the getElements method
		 */
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				return ((Fair) object).exhibits().toArray();
			}

//			/**
//			 * Exhibits table shows the hierarchy elements of the Exhibit. These
//			 * elements are shown in the table columns through ItemProviders so
//			 * they by default adapt to a string based on the name of these elements.
//			 * 
//			 * Detecting changes to these hierarchy element names will be used to trigger 
//			 * viewer.refresh.
//			 * 
//			 * Additions and deletions are handled more discreetly 
//			 * with NotifyChangedToViewerRefresh.
//			 * 
//			 */
//			@Override
//			public void notifyChanged(Notification n) {
//				super.notifyChanged(n);
//				Object notifier = n.getNotifier();
//				// find out the type of the notifier which could be either 'Log'
//				// or 'Exhibit'
//
//				if (notifier instanceof Lot) {
//					handleLotNotification(n);
//				} else if (notifier instanceof com.verticon.tracker.fair.Class) {
//					handleClassNotification(n);
//				}else if (notifier instanceof Department) {
//					handleDepartmentNotification(n);
//				}else if (notifier instanceof Division) {
//					handleDivisionNotification(n);
//				}
//
//			}
//			
//			// output a message about changes to the Class Name
//			private void handleDepartmentNotification(Notification n) {
//				int featureID = n.getFeatureID(Lot.class);
//				if (featureID == FairPackage.DEPARTMENT__NAME) {
//										System.out.println("xThe department " + n.getOldStringValue()
//												+ " is now " + n.getNewStringValue());
////					viewer.refresh();
//				}
//			}
//			
//			// output a message about changes to the Class Name
//			private void handleDivisionNotification(Notification n) {
//				int featureID = n.getFeatureID(Lot.class);
//				if (featureID == FairPackage.DIVISION__NAME) {
//					System.out.println("xThe division " + n.getOldStringValue()
//							+ " is now " + n.getNewStringValue());
////					viewer.refresh();
//				}
//			}
//			
//
//			// output a message about changes to the Class Name
//			private void handleClassNotification(Notification n) {
//				int featureID = n.getFeatureID(Lot.class);
//				if (featureID == FairPackage.CLASS__NAME) {
//					System.out.println("xThe className " + n.getOldStringValue()
//							+ " is now " + n.getNewStringValue());
////					viewer.refresh();
//				}
//			}
//
//			// output a message about new exhibits
//			private void handleLotNotification(Notification n) {
//				int featureID = n.getFeatureID(Lot.class);
//				if (featureID == FairPackage.LOT__EXHIBITS) {
//					Lot lot = (Lot) n.getNotifier();
//					if (n.getEventType() == Notification.ADD) {
//						System.out.println("xNew Exhibit was added to the Lot: "
//								+ lot.getName());
////						NotifyChangedToViewerRefresh.handleNotifyChanged(
////								viewer, n.getNotifier(), n.getEventType(), n
////										.getFeature(), n.getOldValue(), n
////										.getNewValue(), n.getPosition());
//
//					} else if (n.getEventType() == Notification.REMOVE) {
//						System.out
//								.println("xNew Exhibit was removed from the Lot: "
//										+ lot.getName());
////						NotifyChangedToViewerRefresh.handleNotifyChanged(
////								viewer, n.getNotifier(), n.getEventType(), n
////										.getFeature(), n.getOldValue(), n
////										.getNewValue(), n.getPosition());
//
//					}
//
//				} else if (featureID == FairPackage.LOT__NAME) {
//					System.out.println("xThe Lot name " + n.getOldStringValue()
//							+ " was changed to " + n.getNewStringValue());
////					viewer.refresh();
//				}
//			}

			
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
