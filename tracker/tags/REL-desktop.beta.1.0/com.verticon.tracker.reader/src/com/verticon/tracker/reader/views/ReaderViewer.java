/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.reader.views;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;

/**
 * The ReaderViewer class is meant to be a fairly complete use of the
 * org.eclipse.jface.viewers.TableViewer class to implement an editable table
 * with text, combobox and image editors.
 * 
 * ReaderViewer draws from sample code writen by Laurent Gauthier
 * http://www.eclipse.org/articles/Article-Table-viewer/table_viewer.html and
 * the sample code in the Eclipse org.eclipse.ui.views.tasklist.TaskList class
 * and some sample code in SWT fragments from the eclipse.org web site.
 * 
 * Known issue: We were not able to get the images to be center aligned in the
 * checkbox column.
 * 
 * @author jconlon
 * @author Laurent Gauthier
 * @created Apr 2, 2003
 */

class ReaderViewer {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ReaderViewer.class);
	
	private Table table;
	private TableViewer tableViewer;

	private final ReaderViewModel readerViewModel = new ReaderViewModel();

    enum Column {
		NAME("name"), 
		TYPE("type"), 
		TEMPLATE("template"), 
		TARGET("target");

		String property;
		static List<String> columnNames;
		static String[] colNames;

		Column(String property) {
			this.property = property;
		}

		static {
			columnNames = new ArrayList<String>();
			for (Column col : Column.values()) {
				columnNames.add(col.property);
			}

			colNames = new String[columnNames.size()];
			columnNames.toArray(colNames);
		}

	}

	/**
	 * @param parent
	 */
	protected ReaderViewer(Composite parent) {
		this.addChildControls(parent);
	}

	/**
	 * Main method to test the window
	 */
	public static void main(String[] args) {

		Shell shell = new Shell();
		shell.setText("Task List - TableViewer Example");

		// Set layout for shell
		GridLayout layout = new GridLayout();
		shell.setLayout(layout);

		// Create a composite to hold the children
		Composite composite = new Composite(shell, SWT.NONE);
		final ReaderViewer readerViewer = new ReaderViewer(composite);

		readerViewer.getControl().addDisposeListener(
				new DisposeListener() {

					public void widgetDisposed(DisposeEvent e) {
						readerViewer.dispose();
					}

				});

		// Ask the shell to display its content
		shell.open();
		readerViewer.run(shell);
	}

	/**
	 * Run and wait for a close event
	 * 
	 * @param shell
	 *            Instance of Shell
	 */
	private void run(Shell shell) {

		Display display = shell.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Release resources
	 */
	protected void dispose() {

		// Tell the label provider to release its ressources
		tableViewer.getLabelProvider().dispose();
	}

	/**
	 * Create a new shell, add the widgets, open the shell
	 * 
	 * 
	 */
	private void addChildControls(Composite composite) {

		// Create a composite to hold the children
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.FILL_BOTH);
		composite.setLayoutData(gridData);

		// Set numColumns to 3 for the buttons
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 4;
		composite.setLayout(layout);

		// Create the table
		createTable(composite);

		// Create and setup the TableViewer
		createTableViewer();
		tableViewer.setContentProvider(new ExampleContentProvider());
		tableViewer.setLabelProvider(new ReaderLabelProvider());
		// The input for the table viewer is the viewModel
		tableViewer.setInput(readerViewModel);

	}

	/**
	 * Create the Table
	 */
	private void createTable(Composite parent) {
		int style = SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(parent, style);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no
		// effect!!
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("Started");
		column.setWidth(60);

		// 2nd column with Publisher Name
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Name");
		column.setWidth(100);
		// Add listener to column so tasks are sorted by description when
		// clicked
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new ReaderSorter(Column.NAME));
			}
		});

		// 3rd column with Publisher Type
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Type");
		column.setWidth(70);
		// Add listener to column so tasks are sorted by type when clicked
		column.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new ReaderSorter(Column.TYPE));
			}
		});

		// 4th column with Publisher template
		column = new TableColumn(table, SWT.CENTER, 3);
		column.setText("Template");
		column.setWidth(200);
		// Add listener to column so tasks are sorted by percent when clicked
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new ReaderSorter(Column.TEMPLATE));
			}
		});

		// 5th column with Publisher target
		column = new TableColumn(table, SWT.CENTER, 4);
		column.setText("Target");
		column.setWidth(200);
		// Add listener to column so tasks are sorted by percent when clicked
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new ReaderSorter(Column.TARGET));
			}
		});
	}

	/**
	 * Create the TableViewer
	 */
	private void createTableViewer() {

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(Column.colNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[Column.colNames.length];

		// Column 1 : Started (Checkbox)
		editors[0] = new CheckboxCellEditor(table);

		// Column 2 : Name (Free text)
		TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[1] = textEditor;

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new ReaderCellModifier(this));
		// Set the default sorter for the viewer
		tableViewer.setSorter(new ReaderSorter(Column.NAME));
	}

	/**
	 * InnerClass that acts as a proxy for the ExampleTaskList providing content
	 * for the Table. It implements the ITaskListViewer interface since it must
	 * register changeListeners with the ExampleTaskList
	 */
	class ExampleContentProvider implements IStructuredContentProvider,
			IReaderModelListener {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if (newInput != null)
				((ReaderViewModel) newInput).addChangeListener(this);
			if (oldInput != null)
				((ReaderViewModel) oldInput).removeChangeListener(this);
		}

		public void dispose() {
			readerViewModel.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		public Object[] getElements(Object parent) {
			return readerViewModel.getTasks().toArray();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#addTask(ExampleTask)
		 */
		public void addReader(IReader reader){
			logger.debug(bundleMarker,"Adding reader {}",reader);
			tableViewer.add(reader);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#removeTask(ExampleTask)
		 */
		public void removeReader(IReader reader) {
			logger.debug(bundleMarker,"Removing reader {}",reader);
			tableViewer.remove(reader);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#updateTask(ExampleTask)
		 */
		public void updateReader(IReader reader) {
//			logger.debug(bundleMarker,"Updating reader {}",reader);
			tableViewer.update(reader, null);
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	void removeSelectedReaders() {
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();

		List<IReader> selectedReaders = selection.toList();
		for (IReader reader : selectedReaders) {
			readerViewModel.removeReader(reader);
		}

	}

	void addSelectionChangedListener(ISelectionChangedListener listener) {
		tableViewer.addSelectionChangedListener(listener);
	}

	void removeSelectionChangedListener(ISelectionChangedListener listener) {
		tableViewer.removeSelectionChangedListener(listener);
	}

	/**
	 * Return the column names in a collection
	 * 
	 * @return List containing column names
	 */
	public List<String> getColumnNames() {
		return Column.columnNames;
	}

	/**
	 * @return currently selected item
	 */
	public ISelection getSelection() {
		return tableViewer.getSelection();
	}

	/**
	 * Return the ExampleTaskList
	 */
	public ReaderViewModel getReaderViewModel() {
		return readerViewModel;
	}

	/**
	 * Return the parent composite
	 */
	public Control getControl() {
		return table.getParent();
	}

	/**
	 * Refresh the table of Readers
	 */
	void refreshTableViewer(){
		tableViewer.refresh();
	}
}