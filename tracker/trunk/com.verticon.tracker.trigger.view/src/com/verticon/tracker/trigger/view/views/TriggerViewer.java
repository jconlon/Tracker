/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.trigger.view.views;

import java.util.List;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Widget;

import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.ITriggerEntryModelListener;

/**
 * Viewer for the TriggerModel
 * 
 * @author jconlon
 * @see TriggerModel
 */
public class TriggerViewer {

	private TriggerComparator comparator;
	private TableViewer tableViewer;
	private final TriggerModel triggerModel = new TriggerModel();
	private ISelectionChangedListener listener;

	TriggerViewer(Composite parent) {
		addChildControls(parent);
	}

	/**
	 * @return the tableViewer
	 */
	TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * 
	 * Used by the actions
	 * 
	 * @return currently selected item
	 */
	public ISelection getSelection() {
		return tableViewer.getSelection();
	}

	/**
	 * Used by the cellmodifier and the actions
	 * 
	 * @return TriggerModel
	 */
	public TriggerModel getViewModel() {
		return triggerModel;
	}

	/**
	 * Used by the actions
	 * 
	 * @return Control
	 */
	public Control getControl() {
		return tableViewer.getControl();
	}

	void refresh() {
		tableViewer.refresh();
	}

	void setFilter(ViewerFilter filter) {
		tableViewer.addFilter(filter);
	}

	/**
	 * Used by actions
	 */
	@SuppressWarnings("unchecked")
	public void removeSelectedQueries() {
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();

		List<ITriggerEntry> selectedQueries = selection.toList();
		for (ITriggerEntry query : selectedQueries) {
			triggerModel.remove(query);
		}

	}

	/**
	 * Return the column names in a collection Used by the CellModifier
	 * 
	 * @return List containing column names
	 */
	List<String> getColumnNames() {
		return Column.columnNames;
	}

	void addSelectionChangedListener(ISelectionChangedListener listener) {
		this.listener = listener;
		tableViewer.addSelectionChangedListener(listener);
	}

	/**
	 * Release resources
	 */
	protected void dispose() {
		// Tell the label provider to release its resources
		tableViewer.getLabelProvider().dispose();
		tableViewer.removeSelectionChangedListener(listener);

	}

	/**
	 * Create a new shell, add the widgets, open the shell
	 */

	/**
	 * 
	 * @param composite
	 *            has a GridLayout(3, false)
	 */
	private void addChildControls(Composite composite) {

		// Create a composite around the table for tableColumnLayout
		Composite tableComposite = new Composite(composite, SWT.NONE);
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);

		// It should fill the parent and span 3 columns
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.FILL_BOTH);
		gridData.horizontalSpan = 3;
		tableComposite.setLayoutData(gridData);
		tableComposite.setBackground(composite.getDisplay().getSystemColor(
				SWT.COLOR_DARK_YELLOW));


		// tableComposite.setBackground(composite.getDisplay().getSystemColor(
		// SWT.COLOR_DARK_RED));

		int tableStyle = SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		tableViewer = new TableViewer(tableComposite, tableStyle) {
			/**
			 * 
			 * TriggerEntry.equals was implemented to equal logically equal
			 * other TriggerEntry objects in collections. Changing these values
			 * in this tableViewer will create the problem of not locating
			 * InputItems. Although it looks unnecessary the following overrided
			 * method is necessary to find the TriggerEntry elements associated
			 * MenuItems in the model.
			 * 
			 * @since 0.3.5
			 */
			@Override
			protected Widget doFindInputItem(Object element) {

				Widget result = super.doFindItem(element);
				return result;

			}
		};
		comparator = new TriggerComparator();
		tableViewer.setComparator(comparator);
		Menu headerMenu = new Menu(tableViewer.getTable());

		configureTableAndColumns(headerMenu, tableColumnLayout);

		configureTableViewer(tableViewer, triggerModel);
		tableViewer.getTable().setMenu(headerMenu);
	}

	private void configureTableAndColumns(Menu menu,
			TableColumnLayout tableColumnLayout) {

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		tableViewer.getTable().setLayoutData(gridData);

		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);

		Column.createTableViewerColumns(menu, tableViewer, tableColumnLayout);
	}

	/**
	 * Create the TableViewer
	 */
	private void configureTableViewer(TableViewer tableViewer,
			TriggerModel triggerModel) {
		tableViewer.setUseHashlookup(true);

		tableViewer.setContentProvider(new ModelContentProvider());

		tableViewer.setInput(triggerModel);

	}

	/**
	 * InnerClass that acts as a proxy for the model providing content for the
	 * Table.
	 */
	private class ModelContentProvider implements IStructuredContentProvider,
			ITriggerEntryModelListener {
		@Override
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if (newInput != null) {
				((TriggerModel) newInput).addChangeListener(this);
			}
			if (oldInput != null) {
				((TriggerModel) oldInput).removeChangeListener(this);
			}
		}

		@Override
		public void dispose() {
			triggerModel.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		@Override
		public Object[] getElements(Object parent) {

			Object[] results = triggerModel.entries().toArray();
			return results;
		}

		@Override
		public void addEntry(ITriggerEntry query) {
			tableViewer.add(query);
		}

		@Override
		public void removeEntry(ITriggerEntry query) {
			tableViewer.remove(query);

		}

		@Override
		public void updateEntry(ITriggerEntry query) {
			tableViewer.update(query, null);

		}
	}


}
