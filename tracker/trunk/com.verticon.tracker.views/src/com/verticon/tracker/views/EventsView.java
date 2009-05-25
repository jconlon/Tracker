package com.verticon.tracker.views;

import java.util.Comparator;
import java.util.Date;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.util.GenericViewSorter;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.util.TrackerUtils;

public class EventsView extends TrackerView implements ItemsView{

	private static final String NAME_OF_ITEM_IN_MASTER = "Event";

	private ISelectionController eventSelectionController;
	
	
	/**
	 * Subclasses can override this to provide a more useful name for
	 *  dialog.
	 * 
	 * @return singular name of the items for wizard
	 */
	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}
	
	/**
	 * Displays a one page wizard to add an Event to the model. The page prompts
	 * the user to choose the animal from a combo widget and to choose the event
	 * type from a list.
	 * 
	 * If an event was selected in the master the animal number will be selected
	 * in the wizard page.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Premises premises = getPremises(eventSelectionController.getEditingDomain());
		AddEventWizard wizard = new AddEventWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises, tableViewer
				.getSelection());
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		int results = dialog.open();
		wizard.dispose();
		if(results == WizardDialog.OK){
			for (Object object : wizard.getResults()) {
				return object;

			}
		}
		return null;
	}

	
	/**
	 * Override point for subclasses to create the tableViewer columns.
	 * 
	 * For Task number 261 would like to use a databinding contentProvider for
	 * the tableViewer
	 * 
	 * @see #handleViewerInputChange()
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer viewer = masterFilteredTable.getViewer();
		setUpEventsTableViewer(viewer);
		masterFilteredTable.setColumns(viewer.getTable().getColumns());

		 viewer.setContentProvider(new EventHistoryContentProvider(
				adapterFactory));
		 viewer.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	public void handleViewerInputChange() {
		Premises premises = getPremises(eventSelectionController.getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
		enableMenus(premises!=null);
	}
	

	/**
	 * Override super to add an AnimalSelectionController
	 */
	@Override
	public void createPartControl(Composite base) {
		super.createPartControl(base);
		eventSelectionController = new SelectionController(
				this, new EventsStrategy(this));
		eventSelectionController.open();
		getSite().getPage().addSelectionListener(eventSelectionController);
		getSite().getPage().addPartListener(eventSelectionController);
		tableViewer.addSelectionChangedListener(eventSelectionController);
		handleViewerInputChange();
	}

	/**
	 * Override super to remove the listeners and close the AnimalSelectionController
	 */
	 @Override
	public void dispose() {
		tableViewer.removeSelectionChangedListener(eventSelectionController);
		eventSelectionController.close();
		getSite().getPage().removePartListener(eventSelectionController);
		getSite().getPage().removeSelectionListener(eventSelectionController);
		super.dispose();
	}

	/**
	 * Events Table
	 */
	private void setUpEventsTableViewer(final TableViewer eventsTableViewer) {

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


		createTableSorter( eventsTableViewer, 
				new TableColumn[] {
					tagIDColumn, 
					animalIDColumn, 
					dateTimeColumn, 
					eventNameColumn,
					eventCommentsColumn});
		eventsTableViewer.setColumnProperties(new String[] { "a", "b", "c",
				"d", "e" });

	}

	/**
	 * Order of comparators must match with the array of columns" tagId,
	 * animalId, dateTime, eventName, eventComments
	 * 
	 * @param viewer
	 * @param tableColumns
	 */
	@SuppressWarnings("unchecked")
	private void createTableSorter(final TableViewer viewer,
			TableColumn[] tableColumns) {
		Comparator<Event> tagIDNumberComparator = new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				return event1.getId().compareTo(event2.getId());
			}
		};

		Comparator<Event> animalIDNumberComparator = new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				Animal animal1 = (Animal) event1.getTag().eContainer();
				Animal animal2 = (Animal) event2.getTag().eContainer();
				return animal1.getId().compareTo(animal2.getId());
			}
		};
		Comparator<Event> dateComparator = new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				Date date1 = event1.getDateTime() == null ? TrackerUtils.DATE_REFERENCE
						.getTime()
						: event1.getDateTime();
				Date date2 = event2.getDateTime() == null ? TrackerUtils.DATE_REFERENCE
						.getTime()
						: event2.getDateTime();
				return date1.compareTo(date2);
			}
		};
		Comparator<Event> nameComparator = new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				return event1.getClass().getSimpleName().compareTo(
						event2.getClass().getSimpleName());
			}
		};

		Comparator<Event> commentsComparator = new Comparator<Event>() {
			public int compare(Event event1, Event event2) {
				String comments1 = event1.getComments() == null ? "" : event1
						.getComments();
				String comments2 = event2.getComments() == null ? "" : event2
						.getComments();
				return comments1.compareTo(comments2);
			}
		};
	    sorter = new GenericViewSorter(viewer, tableColumns,
		// Remember order is important
				// tagId, animalId, dateTime, eventName, eventComments
				new Comparator[] { tagIDNumberComparator,
						animalIDNumberComparator, dateComparator,
						nameComparator, commentsComparator });
		if (memento != null){
			sorter.init(memento);
		}
		viewer.setSorter(sorter);
	}


}
