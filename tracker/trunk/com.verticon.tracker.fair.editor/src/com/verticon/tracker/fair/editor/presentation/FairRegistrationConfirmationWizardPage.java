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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.util.DefaultPropertiesFormProvider;
import com.verticon.tracker.editor.util.IPropertiesFormProvider;

/**
 * Shows a list of the selected animals with an option of editing their
 * attributes.
 * 
 * @author jconlon
 * 
 */
class FairRegistrationConfirmationWizardPage extends WizardPage
		implements ISelectionChangedListener {

	private static final String MOVED_OUT_SELECTION = "movedOutSelection";
	private static final String MOVED_IN_SELECTION = "movedInSelection";
	private CTabFolder detailFormTabFolder;
	private ScrolledComposite formParent;
	
	private Button movedInButton;
	private Button movedOutButton;


	private ListViewer listViewer;
	private IPropertiesFormProvider defaultPropertiesFormProvider;
	private Composite child = null;
	private Text personText = null;
	private Text lotText = null;
	
	

	private final AdapterFactory adapterFactory;

	protected FairRegistrationConfirmationWizardPage(
			AdapterFactory adapterFactory) {
		super("confirmRegistration");
		this.adapterFactory = adapterFactory;
		setTitle("ConfirmRegistration");
		setDescription("Confirm registration of person exhibiting animals.");
	}

	public void createControl(Composite parent) {
		child =  FairRegistrationSelectPersonWizardPage.createSash( parent);
		Composite container = new Composite(child, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		listViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);

		personText=createPersonUI(container);

		lotText = createLotUI(container);
		
		createPinGroup(container);
		

		createFormFolder(child);
		
		setControl(child);

	}

	/**
	 * @param container
	 */
	private void createPinGroup(Composite parent) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
//		group.setLocation(50, 50);
 
		group.setText("Update Pins in Animal Events");
 
		createMovedInUI(group);
		createMovedOutUI(group);
		group.pack();
	}
	
	

	protected boolean updateMovedIn(){
		return movedInButton.getSelection();
	}
	
	protected boolean updateMovedOut(){
		return movedOutButton.getSelection();
	}
	
	public void selectionChanged(SelectionChangedEvent event) {
		// Remove all the tabs in the TabFolder
		for (CTabItem item : detailFormTabFolder.getItems()) {
			item.dispose();
		}
		fillPropertiesFolder(event.getSelection(), adapterFactory, detailFormTabFolder);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			listViewer.setInput("");
			listViewer.refresh();
			listViewer.setSelection(null);
			personText.setText(((FairRegistrationWizard)getWizard()).getSelectedPerson().getName());
			lotText.setText(((FairRegistrationWizard)getWizard()).getSelectedLot().getName());
			

		}
		super.setVisible(visible);
	}
	
	/**
	 * @param container
	 */
	private void createMovedInUI(Composite container) {
		movedInButton = new Button(container, SWT.CHECK);
		movedInButton.setText("Update all MovedIn Pins");
		movedInButton.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		movedInButton.setSelection(getDialogSettings().getBoolean(MOVED_IN_SELECTION));
		movedInButton.setLocation(20,20);
		movedInButton.addSelectionListener(
				
				new SelectionListener(){

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						movedInSelected();
					}

					@Override
					public void widgetSelected(SelectionEvent e) {
						movedInSelected();
					}
					
				});
		
		movedInButton.pack();
		
		
	}
	
	private void movedInSelected(){
		getDialogSettings().put(MOVED_IN_SELECTION, movedInButton.getSelection());
	}
	
	private void movedOutSelected(){
		getDialogSettings().put(MOVED_OUT_SELECTION, movedOutButton.getSelection());
	}
	
	/**
	 * @param container
	 */
	private void createMovedOutUI(Composite container) {
		movedOutButton = new Button(container, SWT.CHECK);
		movedOutButton.setText("Update all MovedOut Pins");
		movedOutButton.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		movedOutButton.setSelection(getDialogSettings().getBoolean(MOVED_OUT_SELECTION));
		
		movedOutButton.setLocation(20,45);
		movedOutButton.addSelectionListener(
				
				new SelectionListener(){

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						movedOutSelected();
					}

					@Override
					public void widgetSelected(SelectionEvent e) {
						movedOutSelected();
					}
					
					
				});
		
		movedOutButton.pack();
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


	/**
	 * @param container
	 */
	private Text createPersonUI(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		label.setText("Person: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		Text personText = new Text(container, SWT.SINGLE | SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		personText.setLayoutData(gridData);
		return personText;
	}

	/**
	 * @param container
	 */
	private Text createLotUI(Composite container) {
		final Label label = new Label(container, SWT.NONE);
		label.setText("Lot: ");
		label.setBackground(container.getDisplay().getSystemColor(
				SWT.COLOR_YELLOW));
		Text lotText = new Text(container, SWT.SINGLE | SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		lotText.setLayoutData(gridData);
		return lotText;
	}

	private ListViewer createViewer(Composite parent) {
		ListViewer viewer = new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);

		viewer.setContentProvider(new IStructuredContentProvider() {
			List<Animal> model = new ArrayList<Animal>();

			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					model.addAll(((FairRegistrationWizard) getWizard())
							.getAnimalsToRegister());
				}
				return model.toArray();
			}

		});

		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Animal) element).getId();
			}

		});
		return viewer;

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
				cTabFolder, "Animal Details", true);
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
