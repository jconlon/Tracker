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

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.util.TrackerUtils;

/**
 * WizardPage for selecting an Animal type. 
 * 	
 * 
 * @see AddTagIdsAnimalAndEventWizard
 * @see SelectEventWizardPage
 * @author jconlon
 * @since 0.2
 * 
 */
class SelectAnimalWizardPage extends WizardPage  {

//	private ListViewer listViewer;
	private final Premises premises;
	private final Model model = new Model();
	private AdapterFactory adapterFactory = new TrackerItemProviderAdapterFactory();
	private TableViewer tableViewer;
	
	//Disposables
	private DataBindingContext dataBindingContext;
	private IObservableValue selection;
	private IObservableList inputList;
	
	
	protected SelectAnimalWizardPage(Premises premises) {
		super("selectAnimal");
		setTitle("Animal Selection");
		setDescription("Select the Type of Animal to add.");
		this.premises=premises;
	}

	@Override
	public void dispose() {
		if(dataBindingContext !=null){
			dataBindingContext.dispose();
		}
		selection.dispose();
		inputList.dispose();
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		setPageComplete(false);
		dataBindingContext = new DataBindingContext();
		WizardPageSupport.create(this, dataBindingContext);
		Composite composite = new Composite(parent, SWT.NONE);
		
		// Set up data binding.
		tableViewer = createSingleColumnForTableViewer(composite);
		
		
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;
		data.heightHint = 300;
		data.widthHint = 300;
		tableViewer.getTable().setLayoutData(data);

		selection = ViewerProperties
				.singleSelection().observe(tableViewer);

		
		dataBindingContext.bindValue(
				selection, 
				model.selection,
				new UpdateValueStrategy().setAfterConvertValidator(TrackerEditorUtils.singleSelectionValidator),
				null
				
		);
		
		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(
				composite);
		setControl(composite);	
		
		
//		
//		Composite container = new Composite(parent, SWT.NULL);
//		final GridLayout gridLayout = new GridLayout();
//		gridLayout.numColumns = 3;
//		container.setLayout(gridLayout);
//		listViewer=createViewer( container);
//		GridData data = new GridData(GridData.FILL_BOTH);
//		data.grabExcessHorizontalSpace=true;
//		data.grabExcessVerticalSpace=true;
//		data.heightHint = 400;
//		data.widthHint = 300;
//		listViewer.getControl().setLayoutData(data);
//        listViewer.addSelectionChangedListener(this);
//		setControl(container);
	}
	
	protected TableViewer createSingleColumnForTableViewer(
			Composite tableComposite) {

		final TableViewer v = new TableViewer(tableComposite);

		ObservableListContentProvider cp = new ObservableListContentProvider();
		v.setContentProvider(cp);
		v.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory){
			

			@Override
			public Image getColumnImage(Object object, int columnIndex) {
				// The second column has the image
				return super.getColumnImage(object, 1);
			}

			@Override
			public String getColumnText(Object object, int columnIndex) {
				// The second column has the name
				return super.getColumnText(object, 1);
			}});
		
		return v;

	}
	
//	private ListViewer createViewer(Composite parent) {
//		ListViewer viewer =
//			new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
//		viewer.setUseHashlookup(true);
//		
//		viewer.setContentProvider(new IStructuredContentProvider() {
//			List<String> model = new ArrayList<String>();
//
//			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
//			}
//
//			public void dispose() {
//			}
//
//			public Object[] getElements(Object parent) {
//				if (model.isEmpty()) {
//					model.addAll(TrackerEditorUtils.getModelInstances(TrackerPackage.eINSTANCE
//							.getAnimal()));
//				}
//				return model.toArray();
//			}
//
//		});
//		viewer.setLabelProvider(new LabelProvider() {
//			public String getText(Object element) {
//
//				return (String) element;
//			}
//
//		});
//		return viewer;
//	}
	
	Animal getSelectedAnimal() {
			return (model.selection.getValue() == null ) ? null
					: (Animal) model.selection.getValue();
	}
	
	public void setVisible(boolean visible) {
		   super.setVisible(visible);
		   // Set the initial field focus
		   if (visible) {
		      fillTable();
		   }
	}
	 
//	public Animal getAnimal(){
//		if (listViewer.getSelection() == null ) {
//	         return null;
//	     }
//		IStructuredSelection selection =(IStructuredSelection) listViewer.getSelection();
//		String animalName =(String) selection.getFirstElement();
//		if(animalName==null){
//			return null;
//		}
//		EClass eClass = (EClass) TrackerPackage.eINSTANCE.getEClassifier(animalName);
//		return (Animal) TrackerFactory.eINSTANCE.create(eClass);
//	}

	/**
	 * Fill the table with appropriate Events types based on the Premises Policy
	 * 
	 */
	private void fillTable(){
		List<Animal> animals = TrackerUtils.getAppropriateAnimals(premises);
		inputList = new WritableList(animals, Animal.class);
		tableViewer.setInput(inputList);
	}

//
//	 /**
//	    * Update the current page complete state
//	    * based on the field content.
//	    */
//	   private void updatePageComplete() {
//	      setPageComplete(false);
//
//	      if (listViewer.getSelection() == null ) {
//	         setMessage(null);
//	         setErrorMessage("Please select an Animal");
//	         return;
//	      }
//
//	      setPageComplete(true);
//
//	      
//	      setErrorMessage(null);
//	      setMessage(null);
//	         return;
//	      
//	   }

//	public void selectionChanged(SelectionChangedEvent event) {
//		updatePageComplete();
//	}

//	@Override
//	public void setVisible(boolean visible) {
//		if(visible){
//			listViewer.setInput(TrackerUtils.getAppropriateAnimals(premises));
//			listViewer.refresh();
//		}
//		super.setVisible(visible);
//	}

	@Override
	public boolean canFlipToNextPage() {
		
		return getSelectedAnimal()!=null;
	}
	
	private class Model{
		IObservableValue selection = new WritableValue(null, Animal.class);
	}
}
