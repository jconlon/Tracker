/*******************************************************************************
 * Copyright (c) 2008 Trevor S. Kaufman.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Trevor S. Kaufman - initial API and implementation
 ******************************************************************************/
package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
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
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.views.PeopleView.PeopleColumn;

public class ExhibitsView extends TrackerView {

	protected static final String NAME_OF_ITEM_IN_MASTER = "Exhibit";

	/**
	 * Override point for subclasses to create the tableViewer columns.
	 */
	@Override
	protected void setUpTable(AdapterFactory adapterFactory) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		setUpExhibitsTableViewer(tableViewer);
		masterFilteredTable.setColumns(tableViewer.getTable().getColumns());

		tableViewer.setContentProvider(new ExhibitsContentAdapter(
				adapterFactory));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
	}

	/**
	 * Override point for subclasses to obtain the necessary input to feed the
	 * tableViewer.
	 */
	@Override
	protected void handleViewerInputChange() {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		Fair rootObject = getFair();
		if (rootObject != null) {
			tableViewer.setInput(rootObject);
		}

	}

	/**
	 * Setup for Exhibit, Person, Event, and Exhibit
	 * 
	 * @param sselection
	 */
	@Override
	protected void handleMasterSelection(Object first) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		Object exhibit = null;
		if (first instanceof Animal) {
			// logger.debug("Animal selection");
			exhibit = getExhibitFromAnimal((Animal) first, getFair());
		} else if (first instanceof Event) {
			// logger.debug("Event selection");
			exhibit = getExhibitFromEvent((Event) first, getFair());
		} else if (first instanceof Exhibit) {
			// logger.debug("Exhibit selection");
			exhibit = first;
		} else if (first instanceof Person) {
			// logger.debug("Person selection");
			// A person can have multiple exhibits
			Person person = (Person) first;
			List<Exhibit> exhibits = new ArrayList<Exhibit>();
			Fair fair = (Fair) person.eContainer();
			for (Exhibit exhib : fair.exhibits()) {
				if (person == exhib.getExhibitor()) {
					exhibits.add(exhib);
				}
			}
			tableViewer.setSelection(new StructuredSelection(exhibits), true);
			return;
		}
		setSelection(exhibit);
	}

	@Override
	protected String getNameOfItemInMaster() {
		return NAME_OF_ITEM_IN_MASTER;
	}

	@Override
	protected AdapterFactory createAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		return adapterFactory;
	}

	/**
	 * Displays a several page wizard to add a Division, Department, Class, Lot,
	 * or Exhibit to the fair model.
	 */
	@Override
	protected Object addAnItem() {
		// Instantiates and initializes the wizard
		Fair fair = getFair();
		AddExhibitWizard wizard = new AddExhibitWizard(fair, getSite()
				.getWorkbenchWindow().getWorkbench().getActiveWorkbenchWindow());
		// Instantiates the wizard container with the wizard and opens it
		WizardDialog dialog = new WizardDialog(getSite().getShell(), wizard);
		dialog.create();
		dialog.open();

		wizard.dispose();

		for (Object object : wizard.getResults()) {
			if (object instanceof Exhibit) {

				return object;
			}

		}
		return null;
	}
	
	/**
	 * @param exhibitToSelect
	 */
	private void setSelection(Object exhibitToSelect) {
		TableViewer tableViewer = masterFilteredTable.getViewer();
		if (exhibitToSelect != null) {
			tableViewer.setSelection(new StructuredSelection(exhibitToSelect),
					true);
		} else {
			tableViewer.setSelection(new StructuredSelection());
		}
	}

	/**
	 * @return fair
	 */
	private Fair getFair() {
		Fair fair = null;
		for (Resource resource : getEditingDomain()
				.getResourceSet().getResources()) {
			Object o = resource.getContents().get(0);
			if (o instanceof Fair) {
				fair = (Fair) o;
				break;
			}
		}
		return fair;
	}

	private static Exhibit getExhibitFromAnimal(Animal animal, Fair fair) {
		if (animal == null || fair == null) {
			return null;
		}
		for (Exhibit exhibit : fair.exhibits()) {
			if (animal.equals(exhibit.getAnimal())) {
				return exhibit;
			}
		}

		return null;
	}

	private static Exhibit getExhibitFromEvent(Event event, Fair fair) {
		if (event == null || fair == null) {
			return null;
		}
		if (event.getTag() != null && event.getTag().eContainer() != null) {
			Animal animal = (Animal) event.getTag().eContainer();
			return getExhibitFromAnimal(animal, fair);
		}
		return null;
	}

	/**
	 * Enum on Exhibit Element
	 * 
	 * @author jconlon
	 * 
	 */
	public enum ExhibitColumn {
		NAME("Exhibit", new ColumnWeightData(3, 100, true)), NUMBER("Number",
				new ColumnWeightData(3, 30, true)), EXHIBITOR("Exhibitor",
				new ColumnWeightData(2, 150, true)), ANIMAL("Animal",
				new ColumnWeightData(2, 200, true)), LOT("Lot",
				new ColumnWeightData(2, 150, true)), CLASS("Class",
				new ColumnWeightData(2, 150, true)), DEPARTMENT("Department",
				new ColumnWeightData(2, 150, true)), DIVISION("Division",
				new ColumnWeightData(2, 150, true)), COMMENTS("Comments",
				new ColumnWeightData(2, 120, true));

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
				tableViewer.setSorter(new ExhibitSorter(
						(ExhibitColumn) currentColumn.getData(), dir));
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
}
