/**
 * 
 */
package com.verticon.tracker.editor.presentation;

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

/**
 * @author jconlon
 *
 */
public class TrackerTableEditorUtils {
	
	/**
	 * Animals Table
	 */
	public static void createAnimalsTableViewer(ViewerPane viewerPane, final TableViewer tableViewer,  AdapterFactory adapterFactory) {
	

		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//Animal
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 220, true));
		animalColumn.setText(getString("_UI_AnimalColumn_label"));
		
		//Ain 
		final TableColumn ainColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 150, true));
		ainColumn.setText(getString("_UI_AinColumn_label"));
		
		//Animal
		final TableColumn animalTypeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		animalTypeColumn.setText(getString("_UI_AnimalColumn_label"));
		
		//Species
		final TableColumn speciesColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 40, true));
		speciesColumn.setText(getString("_UI_SpeciesColumn_label"));
		
		//Sex
		final TableColumn sexColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 50, true));
		sexColumn.setText(getString("_UI_SexColumn_label"));
		
		//Breed 
		final TableColumn breedColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 70, true));
		breedColumn.setText(getString("_UI_BreedColumn_label"));

		//BirthDate
		final TableColumn dDateColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 100, true));
		dDateColumn.setText(getString("_UI_BirthDateColumn_label"));

		//Age
		final TableColumn ageColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 80, true));
		ageColumn.setText(getString("_UI_AgeColumn_label"));

		//LastEventDateTime
		final TableColumn lastEventDateTimeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		lastEventDateTimeColumn.setText(getString("_UI_LastEventColumn_label"));

		//Comments
		final TableColumn commentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 200, true));
		commentsColumn.setText(getString("_UI_CommentsColumn_label"));

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
		commentsColumn.addListener(SWT.Selection, sortListener);
		
		
		tableViewer.setColumnProperties(
				new String [] {"a", "b", "c", "d", "e","f", "g", "h","i","j"});
		
		
		tableViewer.setContentProvider(
		        new AdapterFactoryContentProvider(adapterFactory) // 14.2.2
		        {
		          public Object [] getElements(Object object)
		          {
		            return ((Premises)object).getAnimals().toArray();
		          }
		          public void notifyChanged(Notification notification)
		          {
		        	//Only listen to changes to Animals and Events
		            switch (notification.getEventType())
		            {
		              case Notification.ADD:
		              case Notification.ADD_MANY:
		            	if (notification.getFeature() != TrackerPackage.eINSTANCE.getPremises_Animals()){
		            		if (notification.getFeature() != TrackerPackage.eINSTANCE.getTag_Events()){
		            			System.out.println("Animals table Ignoring change: "+notification);
		            			return;
		            		}
		                }
		            }
		            System.out.println("Animals table acting on change: "+notification.getFeature());
		            super.notifyChanged(notification);
//		            if(viewer!=null){
//						viewer.refresh();
//					}
		          }
		        });
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
	}

	/**
	 * Events Table
	 */
	public static void createEventsTableViewer(ViewerPane viewerPane, final TableViewer tableViewer,  AdapterFactory adapterFactory) {
	
		final Table table = tableViewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tableViewer.setUseHashlookup(true);

		//Event 
		final TableColumn animalColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 230, true));
		animalColumn.setText(getString("_UI_EventColumn_label"));
		
		
		//Animal ID Number
		final TableColumn animalIDColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 100, true));
		animalIDColumn.setText(getString("_UI_AnimalParentColumn_label"));
		
		//Tag ID Number
		final TableColumn tagIDColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 150, true));
		tagIDColumn.setText(getString("_UI_TagColumn_label"));
		
		//Date of Event
		final TableColumn dateTimeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 170, true));
		dateTimeColumn.setText(getString("_UI_DateTimeColumn_label"));
		

		//Event Type
		final TableColumn eventNameColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 60, true));
		eventNameColumn.setText(getString("_UI_EventNameColumn_label"));


		//Event Code
		final TableColumn eventCodeColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(2, 20, true));
		eventCodeColumn.setText(getString("_UI_EventCodeColumn_label"));

		//Comments
		final TableColumn eventCommentsColumn = new TableColumn(table, SWT.NONE);
		layout.addColumnData(new ColumnWeightData(3, 180, true));
		eventCommentsColumn.setText(getString("_UI_CommentsColumn_label"));
		

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
					sortIdentifier = EventSorter.EVENT_TEXT;
				}

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

				if (currentColumn == eventCodeColumn) {
					sortIdentifier = EventSorter.EVENT_CODE;
				}

				if (currentColumn == eventCommentsColumn) {
					sortIdentifier = EventSorter.EVENT_COMMENTS;
				}

				table.setSortDirection(dir);
				tableViewer.setSorter(new EventSorter(sortIdentifier,dir));
			}
			
		};
		
		animalIDColumn.addListener(SWT.Selection, sortListener);
		tagIDColumn.addListener(SWT.Selection, sortListener);
		animalColumn.addListener(SWT.Selection, sortListener);
		dateTimeColumn.addListener(SWT.Selection, sortListener);
		eventCodeColumn.addListener(SWT.Selection, sortListener);
		eventNameColumn.addListener(SWT.Selection, sortListener);
		eventCommentsColumn.addListener(SWT.Selection, sortListener);
		tableViewer.setColumnProperties(new String [] {"a", "b", "c", "d", "e", "f","g"});
		
		
		tableViewer.setContentProvider(
				new AdapterFactoryContentProvider(adapterFactory) // 14.2.2
				{
					public Object [] getElements(Object object)
					{
						return ((Premises)object).eventHistory().toArray();
					}
					public void notifyChanged(Notification notification)
					{
						switch (notification.getEventType())
						{
						case Notification.ADD:
						case Notification.ADD_MANY:
							if (notification.getFeature() != TrackerPackage.eINSTANCE.getTag_Events()) {
								return;
							}
						}
						super.notifyChanged(notification);
//						if(viewer!=null){
//							viewer.refresh();
//						}
					}
				});
		tableViewer.setLabelProvider(
				new AdapterFactoryLabelProvider(adapterFactory));
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
