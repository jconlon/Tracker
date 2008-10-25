package com.verticon.tracker.views;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.presentation.EventSorter;
import com.verticon.tracker.editor.util.ISelectionController;
import com.verticon.tracker.editor.util.ItemsView;
import com.verticon.tracker.editor.util.SelectionController;
import com.verticon.tracker.editor.util.TrackerView;

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
		 viewer
				.setLabelProvider(new AdapterFactoryLabelProvider(
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
	static void setUpEventsTableViewer(final TableViewer eventsTableViewer) {

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

	
}
