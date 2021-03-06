/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.ocl.query.viewer.IOclQuery;
import com.verticon.tracker.ocl.query.viewer.IOclQueryModelListener;
import com.verticon.tracker.ocl.query.viewer.OclQueryViewModel;

/**
 * Viewer for the OclQueryViewModel
 * 
 * @author jconlon
 * @see OclQueryViewModel
 */
public class OclQueryViewer {

	 static final String EXECUTE_QUERY_TEXT = "Execute";
	 static final String EXECUTE_SELECTED_QUERY_TOOLTIP = "Execute the Selected Query";

	public OclQueryViewer(Composite parent) {

		this.addChildControls(parent);
	}

	private Table table;
	private TableViewer tableViewer;
	private Button executeButton;

	private OclQueryViewModel oclQueryViewModel = new OclQueryViewModel();
	

	/**
	 * 
	 * @author jconlon
	 * 
	 */
	public enum Column {
		NAME("Name"), TYPE("Type"), QUERY("Query"), ERRORS("Synatax Errors");

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
	 * Main method to test the window. Comment out TrackerLogger in
	 * OclQueryViewModel first.
	 */
	public static void main(String[] args) {

		Shell shell = new Shell();
		shell.setText("Task List - TableViewer Example");

		// Set layout for shell
		GridLayout layout = new GridLayout();
		shell.setLayout(layout);

		// Create a composite to hold the children
		Composite composite = new Composite(shell, SWT.NONE);
		final OclQueryViewer tableViewerExample = new OclQueryViewer(composite);

		tableViewerExample.getControl().addDisposeListener(
				new DisposeListener() {

					public void widgetDisposed(DisposeEvent e) {
						tableViewerExample.dispose();
					}

				});

		// Ask the shell to display its content
		shell.open();
		tableViewerExample.run(shell);
	}

	/**
	 * Run and wait for a close event
	 * 
	 * @param shell
	 *            Instance of Shell
	 */
	private void run(Shell shell) {

		setupExecuteQueryButton();

		Display display = shell.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * 
	 */
	private void setupExecuteQueryButton() {
		// Add a listener for the execute button
		executeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IOclQuery task = (IOclQuery) ((IStructuredSelection) tableViewer
						.getSelection()).getFirstElement();
				task.run();
			}
		});
	}

	/**
	 * Release resources
	 */
	public void dispose() {

		// Tell the label provider to release its ressources
		tableViewer.getLabelProvider().dispose();
	}

	/**
	 * Create a new shell, add the widgets, open the shell
	 * 
	 * @return the shell that was created
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
		tableViewer.setContentProvider(new QueryModelContentProvider());
		tableViewer.setLabelProvider(new OclQueryLabelProvider());
		// The input for the table viewer is the viewModel
		tableViewer.setInput(oclQueryViewModel);

		// Add the buttons
		createButtons(composite);
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

		// FIXME 1st column NAME
		TableColumn column = new TableColumn(table, SWT.LEFT, 0);
		column.setText(Column.NAME.property);
		column.setWidth(210);
		// Add listener to column so tasks are sorted by description when
		// clicked
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new OclQuerySorter(Column.NAME));
			}
		});

		// 3rd column with Context
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText(Column.TYPE.property);
		column.setWidth(80);
		// Add listener to column so tasks are sorted by type when clicked
		column.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new OclQuerySorter(Column.TYPE));
			}
		});

		// 3rd column with Query
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText(Column.QUERY.property);
		column.setWidth(400);
		// Add listener to column so tasks are sorted by percent when clicked
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new OclQuerySorter(Column.QUERY));
			}
		});

		// Errors
		column = new TableColumn(table, SWT.LEFT, 3);
		column.setText(Column.ERRORS.property);

		column.setWidth(70);
		// Add listener to column so tasks are sorted by percent when clicked
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new OclQuerySorter(Column.ERRORS));
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

		// Name (Free text)
		editors[0] = new TextCellEditor(table);
		((Text) editors[0].getControl()).setTextLimit(60);

		// Context
		editors[1] = new ComboBoxCellEditor(table, types(), SWT.READ_ONLY);

		// Query
		editors[2] = new TextCellEditor(table);
		((Text) editors[2].getControl()).setTextLimit(300);

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new OclQueryCellModifier(this));
		// Set the default sorter for the viewer
		tableViewer.setSorter(new OclQuerySorter(Column.NAME));
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						executeButton.setEnabled(OclQueryViewPart.canExecuteQuery(event));
					}
				});
	}

	public String[] types() {
		// show only EClasses (cannot query for EDataType values)

		List<EClassifier> classes = new LinkedList<EClassifier>(
				TrackerPackage.eINSTANCE.getEClassifiers());
		
		List<EClassifier> fairClasses = new LinkedList<EClassifier>(
				FairPackage.eINSTANCE.getEClassifiers());
		
		classes.addAll(fairClasses);
		
		for (Iterator<EClassifier> iter = classes.iterator(); iter.hasNext();) {
			if (!(iter.next() instanceof EClass)) {
				iter.remove();
			}
		}

		List<String> classNames = new LinkedList<String>();
		for (EClassifier classifier : classes) {
			classNames.add(classifier.getName());
		}
	

		String[] out = {};
		return classNames.toArray(out);
	}

	/*
	 * Close the window and dispose of resources
	 */
	public void close() {
		Shell shell = table.getShell();

		if (shell != null && !shell.isDisposed())
			shell.dispose();
	}

	/**
	 * InnerClass that acts as a proxy for the model providing content for the
	 * Table.
	 */
	class QueryModelContentProvider implements IStructuredContentProvider,
			IOclQueryModelListener {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if (newInput != null)
				((OclQueryViewModel) newInput).addChangeListener(this);
			if (oldInput != null)
				((OclQueryViewModel) oldInput).removeChangeListener(this);
		}

		public void dispose() {
			oclQueryViewModel.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		public Object[] getElements(Object parent) {
			return oclQueryViewModel.getTasks().toArray();
		}

		public void addQuery(IOclQuery query) {
			tableViewer.add(query);
		}

		public void removeOclQuery(IOclQuery query) {
			tableViewer.remove(query);

		}

		public void updateOclQuery(IOclQuery query) {
			tableViewer.update(query, null);

		}
	}

	/**
	 * Add the "Add", "Delete" and "Close" buttons
	 * 
	 * @param parent
	 *            the parent composite
	 */
	private void createButtons(Composite parent) {
		executeButton = new Button(parent, SWT.PUSH | SWT.CENTER);
		executeButton.setText(EXECUTE_QUERY_TEXT);
		executeButton.setToolTipText(EXECUTE_SELECTED_QUERY_TOOLTIP);

		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.widthHint = 80;
		executeButton.setLayoutData(gridData);
		setupExecuteQueryButton();
		executeButton.setEnabled(false);
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
	public OclQueryViewModel getViewModel() {
		return oclQueryViewModel;
	}

	/**
	 * Return the parent composite
	 */
	public Control getControl() {
		return table.getParent();
	}

	

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	void removeSelectedQueries() {
		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();

		List<IOclQuery> selectedQueries = selection.toList();
		for (IOclQuery query : selectedQueries) {
			oclQueryViewModel.removeQuery(query);
		}

	}
	
	void addSelectionChangedListener(ISelectionChangedListener listener) {
		tableViewer.addSelectionChangedListener(listener);
	}

	void removeSelectionChangedListener(ISelectionChangedListener listener) {
		tableViewer.removeSelectionChangedListener(listener);
	}
}
