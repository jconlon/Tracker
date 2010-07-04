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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Lot;

class BaseConfigureExhibitWizardPage extends WizardPage implements ISelectionChangedListener{

	private static final String LOT_NAME = "lotName";
	private Lot selectedLot;
	private ListViewer listViewer;
	private final Fair fair;
	protected boolean failedTofindAnyLots = false;

	protected BaseConfigureExhibitWizardPage(String pageName, Fair fair) {
		super(pageName);
		this.fair=fair;
	}

	

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		listViewer = createViewer(container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan=3;
		data.heightHint = 300;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		listViewer.addSelectionChangedListener(this);
		
	    
	    
		setControl(container);
	
	}

	@Override
	public void setVisible(boolean visible) {
		if(visible){
			selectedLot=null;
			listViewer.setInput("");
			listViewer.refresh();
			ISelection oldLot = findOldLot();
			if(oldLot!=null ){
				listViewer.setSelection(oldLot);
			}else{
				setPageComplete(false);
			}
		}
		super.setVisible(visible);
	}
	
	private ISelection findOldLot(){
		ISelection result = null;
		String oldLotName = getDialogSettings().get(LOT_NAME);
		if(oldLotName != null){
			for (Lot lot : getLots()) {
				if(oldLotName.equals(lot.getName())){
					result = new StructuredSelection(lot);
					break;
				}
			}
			
		}
		
		return result;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		updatePageComplete();
	}

	public Lot getSelectedLot() {
		return selectedLot;
	}

	public void setSelectedLot(Lot selectedLot) {
		this.selectedLot = selectedLot;
	}

	private ListViewer createViewer(Composite parent) {
		ListViewer viewer =
			new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		viewer.setUseHashlookup(true);
		
		
		viewer.setContentProvider(new IStructuredContentProvider() {
			List<Lot> model = new ArrayList<Lot>();
	
			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			}
	
			public void dispose() {
			}
	
			public Object[] getElements(Object parent) {
				if (model.isEmpty()) {
					List<Lot>lots = getLots();
					if(lots.isEmpty()){
						failedTofindAnyLots = true;
					}else{
						model.addAll(getLots());
					}
				}
				return model.toArray();
			}
	
		});
		
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Lot)element).getName();
			}
		});
		return viewer;
		
		
	}

	private EList<Lot> getLots() {
		
		if(fair!=null){
			EList<Lot> lots = new BasicEList<Lot>();
			for (Division division : fair.getDivisions()) {
				for (Department department : division.getDepartments()) {
					for (com.verticon.tracker.fair.Class clazz : department.getClasses()) {
							lots.addAll(clazz.getLots());
					}
				}
			}
			Collections.sort(lots, new Comparator<Lot>() {
				@Override
				public int compare(Lot o1, Lot o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}});
			return ECollections.unmodifiableEList(lots);
		}
		
		return ECollections.emptyEList();
	}

	/**
	 * Update the current page complete state based on the field content.
	 */
	private void updatePageComplete() {
		setPageComplete(false);
	
		if(failedTofindAnyLots){
			setMessage(null);
			setErrorMessage(
				"Found no lots in the fair.  You must create at least one Lot to use this filter. ");
			return;
		}
		if (listViewer.getSelection() == null) {
			setMessage(null);
			setErrorMessage(
				"Please select a Lot from the list");
			return;
		}
	
		IStructuredSelection selection =(IStructuredSelection) listViewer.getSelection();
		try {
			selectedLot =validate((Lot) selection.getFirstElement());
			getDialogSettings().put(LOT_NAME, selectedLot.getName());
			
		} catch (Exception e) {
			setMessage(null);
			setErrorMessage(
				e.getMessage());
			return;
		}
	
		setPageComplete(true);
		setErrorMessage(null);
		setMessage(null);
		return;
	
	}
	
	protected Lot validate(Lot lot) throws Exception{
		return lot;
	}

}