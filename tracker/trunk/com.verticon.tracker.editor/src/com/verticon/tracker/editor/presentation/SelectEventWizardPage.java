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
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.util.TrackerUtils;


/**
 * 
 * A wizard page presenting a table selection of Events that can be created for 
 * this animal.  Table inputList is built from getNewChildDescriptors on the active
 * Tag of the animal selected in the first page of this wizard.
 * 
 * Table shows Event names and images.
 * 
 * BESTPRACTICE for WizardPage Table DataBinding Dispose
 * 
 * @author jconlon
 *
 */
class SelectEventWizardPage extends WizardPage {

	private final Premises premises;
	private final Model model = new Model();
	private AdapterFactory adapterFactory = new TrackerItemProviderAdapterFactory();
	private TableViewer tableViewer;
	
	//Disposables
	private DataBindingContext dataBindingContext;
	private IObservableValue selection;
	private IObservableList inputList;
	
	
	protected SelectEventWizardPage(Premises premises) {
		super("selectEvent");
		setTitle("Event Selection");
		setDescription("Select the Type of Event to add.");
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
	

	 Event getSelectedEvent() {
		return (model.selection.getValue() == null ) ? null
				: (Event) model.selection.getValue();
	}
	
	public void setVisible(boolean visible) {
		   super.setVisible(visible);
		   // Set the initial field focus
		   if (visible) {
		      fillTable();
		   }
	}

	/**
	 * Fill the table with appropriate Events types based on the Premises Policy
	 * 
	 */
	private void fillTable(){
		Animal selectedAnimal = ((AddTagIdsAnimalAndEventWizard) getWizard()).getSelectedAnimal();
		List<Event> events = TrackerUtils.getAppropriateEvents( premises, selectedAnimal.getType());
		inputList = new WritableList(events, Event.class);
		tableViewer.setInput(inputList);
	}
	
	
	private class Model{
		IObservableValue selection = new WritableValue(null, Event.class);
	}
	
	
}