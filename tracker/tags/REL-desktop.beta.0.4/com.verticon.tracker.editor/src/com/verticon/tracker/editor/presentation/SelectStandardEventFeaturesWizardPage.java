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
/**
 * 
 */
package com.verticon.tracker.editor.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.TrackerPackage;

/**
 * WizardPage for selecting a single event EClass from a list of all standard
 * Events.  Includes an utility method for and returning an EClass non derived
 * features.
 * 
 * This is Page One of Three for the ImportStandardEventDataWizard
 * Ticket#501
 * 
 * @see ImportStandardEventDataWizard
 * @see SelectAnimalWizardPage
 * @author jconlon
 * 
 * 
 */
public class SelectStandardEventFeaturesWizardPage extends WizardPage implements
		ISelectionChangedListener {

	private ListViewer listViewer;
	
	/**
	 * Reference to the list of {@link EStructuralFeature}s that will be shown
	 * offered as features for mapping to spreadsheet columns.
	 */
	private static final List<EClass> EVENT_CLASS_LIST;
	static {
		List<EClass> list = new ArrayList<EClass>();
		list.add(TrackerPackage.Literals.ANIMAL_MISSING);
		list.add(TrackerPackage.Literals.DIED);
		list.add(TrackerPackage.Literals.EXPORTED);
		list.add(TrackerPackage.Literals.GENERIC_EVENT);
		list.add(TrackerPackage.Literals.ICVI);
		list.add(TrackerPackage.Literals.IMPORTED);
		list.add(TrackerPackage.Literals.LOST_TAG);
		list.add(TrackerPackage.Literals.MOVED_IN);
		list.add(TrackerPackage.Literals.MOVED_OUT);
		list.add(TrackerPackage.Literals.REPLACED_TAG);
		list.add(TrackerPackage.Literals.SLAUGHTERED);
		list.add(TrackerPackage.Literals.SIGHTING);
		list.add(TrackerPackage.Literals.TAG_RETIRED);
		list.add(TrackerPackage.Literals.TAG_ALLOCATED);
		list.add(TrackerPackage.Literals.TAG_APPLIED);
		list.add(TrackerPackage.Literals.WEIGH_IN);
		EVENT_CLASS_LIST = Collections.unmodifiableList(list);
	}

	public SelectStandardEventFeaturesWizardPage() {
		super("selectEvent");
		setTitle("Select Event");
		setDescription("Select the Event to add.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

		listViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);
		setControl(container);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		updatePageComplete();
	}
	
	/**
	 * 
	 * @return results of this wizardPage
	 */
	EClass getSelectedEvent(){
		if (listViewer.getSelection() == null) {
			return null;
		}
		IStructuredSelection selection = (IStructuredSelection) listViewer
				.getSelection();
		return (EClass) selection.getFirstElement();
	}
	
	/**
	 * Utility for finding non derived Features in an EClass
	 * @param eclass
	 * @return non derived Features
	 */
	static List<EStructuralFeature> getNonDerivedFeatures(EClass eclass){
		List<EStructuralFeature> featureList =  new ArrayList<EStructuralFeature>(); 
		for (EStructuralFeature feature : eclass.getEAllStructuralFeatures()) {
			if(!feature.isDerived()){
				featureList.add(feature);
			}
		 }
		return Collections.unmodifiableList(featureList);
	}
	
	private ListViewer createViewer(Composite parent) {
		ListViewer viewer = new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);

		viewer.setContentProvider(new IStructuredContentProvider() {
			
			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

		});
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {

				return ((EClass) element).getName();
			}

		});
		viewer.setInput(EVENT_CLASS_LIST);
		return viewer;
	}

	
	

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);

		if (listViewer.getSelection() == null) {
			setMessage(null);
			setErrorMessage("Please select an Event");
			return;
		}

		setPageComplete(true);

		setErrorMessage(null);
		setMessage(null);
		return;

	}

	

}
