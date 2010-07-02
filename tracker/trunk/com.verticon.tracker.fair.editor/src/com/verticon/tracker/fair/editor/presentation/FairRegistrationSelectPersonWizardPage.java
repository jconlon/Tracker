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
package com.verticon.tracker.fair.editor.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

class FairRegistrationSelectPersonWizardPage extends WizardPage
		implements ISelectionChangedListener {
	
	private CTabFolder detailFormTabFolder;
	private ScrolledComposite formParent;

	private Person selectedPerson = null;
	private TableViewer tableViewer;
	private boolean viewingOnlyPersons;
	private IPropertiesFormProvider defaultPropertiesFormProvider;

	private Composite child = null;

	private final AdapterFactory adapterFactory;

	protected FairRegistrationSelectPersonWizardPage(
			AdapterFactory adapterFactory) {
		super("selectPerson");
		this.adapterFactory = adapterFactory;
		setTitle("Select Person");
		setDescription("Select the person registering the animal.");
	}

	public void createControl(Composite parent) {
		child = createSash( parent);

		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		
		
		createTable(container);

		createLabelsAndButtons(container);
		createFormFolder(child);
		
		setControl(child);

	}
	
	static Composite createSash(Composite parent){
		// Create the SashForm
	    final SashForm sashForm = new SashForm(parent, SWT.VERTICAL);

	    // Change the width of the sashes
	    sashForm.SASH_WIDTH = 7;

	    // Change the color used to paint the sashes
	    sashForm.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));
	    // Set the relative weights for the buttons
//	    sashForm.setWeights(new int[] { 1, 2, 3});
	    return sashForm;
	}
	
	

	/**
	 * @param container
	 */
	private void createLabelsAndButtons(Composite container) {
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
	}

	/**
	 * @param container
	 */
	private void createTable(Composite container) {
		Composite tableComposite = new Composite(container, SWT.NONE);
		tableViewer = createSingleColumnTableViewer(tableComposite);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 300;
		data.widthHint = 300;
		tableComposite.setLayoutData(data);
		tableViewer.addSelectionChangedListener(this);
	}
	
	/**
	 * Second window will be the form
	 */
	private void createFormFolder(Composite container) {
		formParent = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);

		detailFormTabFolder = new CTabFolder(formParent, SWT.LEFT
				| SWT.H_SCROLL | SWT.V_SCROLL);
		detailFormTabFolder.setForeground(formParent.getDisplay()
				.getSystemColor(SWT.COLOR_BLACK));
		formParent.setContent(detailFormTabFolder);
	}


	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	

	public void selectionChanged(SelectionChangedEvent event) {
		// Remove all the tabs in the TabFolder
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(event.getSelection(), adapterFactory, detailFormTabFolder);
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

	private TableViewer createSingleColumnTableViewer(Composite tableComposite) {
		
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
			EList<Person> people = new BasicEList<Person>(fair.getPeople());
			
			Collections.sort(people, new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}});
			return ECollections.unmodifiableEList(people);
			
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
	 */
	private void fillPropertiesFolder(ISelection selection,
			AdapterFactory adapterFactory, CTabFolder cTabFolder) {
		if (defaultPropertiesFormProvider == null) {
			// logger.debug(bundleMarker,"Creating a defaultPropertiesFormProvider");
			defaultPropertiesFormProvider = new DefaultPropertiesFormProvider();
		}
		defaultPropertiesFormProvider.fillProperties(selection, adapterFactory,
				cTabFolder, "Person Details", true);
		cTabFolder.pack(true);

	}
	

	/**
	 * Disposes all the tabs in the TabFolder and resources.
	 */
	@Override
	public void dispose() {
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		detailFormTabFolder.dispose();
		child.dispose();
		formParent.dispose();
		super.dispose();
	}
}
