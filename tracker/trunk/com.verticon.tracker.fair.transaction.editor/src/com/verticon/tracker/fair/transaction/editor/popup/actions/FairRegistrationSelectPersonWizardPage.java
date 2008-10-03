package com.verticon.tracker.fair.transaction.editor.popup.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;

import com.verticon.tracker.editor.util.DefaultPropertiesFormProvider;
import com.verticon.tracker.editor.util.IPropertiesFormProvider;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.YoungPerson;

public class FairRegistrationSelectPersonWizardPage extends WizardPage
		implements ISelectionChangedListener {

	private Person selectedPerson = null;
	private TableViewer tableViewer;
	private boolean viewingOnlyPersons;
	private IPropertiesFormProvider defaultPropertiesFormProvider;
	protected CTabFolder cTabFolder;
	Composite child = null;

	private final AdapterFactory adapterFactory;

	protected FairRegistrationSelectPersonWizardPage(
			AdapterFactory adapterFactory) {
		super("selectPerson");
		this.adapterFactory = adapterFactory;
		setTitle("Select Person");
		setDescription("Select the person registering the animal.");
	}

	public void createControl(Composite parent) {
		child = new Composite(parent, SWT.NULL);
		child.setLayout(new FillLayout(SWT.VERTICAL));

		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		Composite tableComposite = new Composite(container, SWT.NONE);
		tableViewer = createSingleColumnTableViewer(tableComposite);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 300;
		data.widthHint = 300;
		tableComposite.setLayoutData(data);
		tableViewer.addSelectionChangedListener(this);

		Label label = new Label(container, SWT.NULL);
		label.setText("Filter on Person Type: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));

		Button personButton = new Button(container, SWT.RADIO);
		personButton.setText("Person");
		personButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedPerson=null;
				tableViewer.setSelection(null);
				setPageComplete(false);
				viewingOnlyPersons = true;
				tableViewer.refresh();
			}

		});

		Button youngPersonButton = new Button(container, SWT.RADIO);
		youngPersonButton.setText("Young Person");
		youngPersonButton.setSelection(true);
		youngPersonButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedPerson=null;
				tableViewer.setSelection(null);
				setPageComplete(false);
				viewingOnlyPersons = false;
				tableViewer.refresh();
				
			}

		});
		cTabFolder = new CTabFolder(child, SWT.LEFT);
		cTabFolder.setForeground(child.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		cTabFolder.setBackground(child.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));

		setControl(child);

	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public boolean needToCreatePerson() {
		return selectedPerson == null;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		// Remove all the tabs in the TabFolder
		for (CTabItem item : cTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(event.getSelection(), adapterFactory, cTabFolder);
		updatePageComplete();
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			selectedPerson = null;
			tableViewer.setInput("");
			tableViewer.refresh();
			tableViewer.setSelection(null);
			setPageComplete(false);
		}
		super.setVisible(visible);
	}

	protected TableViewer createSingleColumnTableViewer(Composite tableComposite) {
		
		final TableViewer v = new TableViewer(tableComposite);
		 v.getTable().setLinesVisible(true);

		 TableColumn singleColumn = new TableColumn(v.getTable(), SWT.NONE);
		 TableColumnLayout tableColumnLayout = new TableColumnLayout();
		 tableColumnLayout.setColumnData(singleColumn, new ColumnWeightData(100));
		 tableComposite.setLayout(tableColumnLayout);
		
		v.setUseHashlookup(true);

		v.setContentProvider(new IStructuredContentProvider() {
			List<Person> model = new ArrayList<Person>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(getPersons());
				}
				return model.toArray();
			}

		});

		v.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		v.addFilter(new MyViewerFilter());
		return v;

	}

	protected Collection<Person> getPersons() {
		Fair fair = ((FairRegistrationWizard) getWizard()).findFair();
		if (fair != null) {
			return fair.getPeople();
		}

		return Collections.emptyList();
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (tableViewer.getSelection() == null) {
			setMessage(null);
			setErrorMessage("Please select a "
					+(viewingOnlyPersons?"":"Young")+
					"Person from the list");
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) tableViewer
				.getSelection();
		selectedPerson = (Person) selection.getFirstElement();

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

	private class MyViewerFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {

			if (element instanceof YoungPerson) {
				return !viewingOnlyPersons;
			}

			if (element instanceof Person) {
				return viewingOnlyPersons;
			}

			return false;
		}

	}

	/**
	 * @param selection
	 * @return
	 */
	protected void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
			defaultPropertiesFormProvider.setWizardPage(this);
		}

		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, "Person Details", true);
		setControl(child);
		return;

	}
	

}
