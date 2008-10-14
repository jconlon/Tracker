package com.verticon.tracker.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.presentation.EventHistoryContentProvider;
import com.verticon.tracker.editor.presentation.EventSorter;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;

public class EventsView extends TrackerView {

	private static final String NAME_OF_ITEM_IN_MASTER = "Event";


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
	@Override
	protected void handleViewerInputChange() {
		Premises premises = getPremises(getEditingDomain());
		TableViewer viewer = masterFilteredTable.getViewer();
		viewer.setInput(premises);
	}

	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		TableViewer viewer = masterFilteredTable.getViewer();
		if (first instanceof Animal) {
			// logger.debug("Animal selection");
			String id = ((Animal) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(), true);
		} else if (first instanceof Event) {
			// logger.debug("Event selection");
			String id = ((Event) first).getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(first), true);
		} else if (first instanceof Exhibit
				&& ((Exhibit) first).getAnimal() != null) {
			// logger.debug("Exhibit selection");
			String id = ((Exhibit) first).getAnimal().getId();
			setTagIdFilter(id);
			viewer.setSelection(new StructuredSelection(), true);
		} else if (first instanceof Person) {
			// logger.debug("Person selection");
			Person person = (Person) first;
			List<Event> events = new ArrayList<Event>();
			Fair fair = (Fair) person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if (person == exhib.getExhibitor()) {
					events.addAll(exhib.getAnimal().eventHistory());
				}
			}
			setTagIdFilter("");
			// logger.debug("Person selection associated with {} events.",
			// events.size());
			viewer.setSelection(new StructuredSelection(events), true);
		}
	}

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
		Premises premises = getPremises(getEditingDomain());
		AddEventWizard wizard = new AddEventWizard();
		wizard.init(getSite().getWorkbenchWindow().getWorkbench()
				.getActiveWorkbenchWindow(), premises, tableViewer
				.getSelection());
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
		wizard.dispose();
		for (Object object : wizard.getResults()) {
			return object;

		}
		return null;
	}

	/**
	 * Setup the proper filter TagID
	 * 
	 * @param tagId
	 */
	private void setTagIdFilter(String tagId) {
		masterFilteredTable.setFilterText(tagId);
		masterFilteredTable.getColumnCombo().select(3);
	}

	/**
	 * Convienence method to find the Root
	 * 
	 * @return
	 */
	private static Premises getPremises(EditingDomain editingDomain) {
		Resource resource = editingDomain.getResourceSet().getResources()
				.get(0);
		Object rootObject = resource.getContents().get(0);
		if (rootObject instanceof Premises) {
			return (Premises) rootObject;
		} else if (rootObject instanceof Fair) {
			return ((Fair) rootObject).getPremises();
		}

		return null;
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
