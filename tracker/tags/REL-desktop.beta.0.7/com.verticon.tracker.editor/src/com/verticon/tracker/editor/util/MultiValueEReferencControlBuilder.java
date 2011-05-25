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
package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a Text Widget for a reference with a multivalue dialog. 
 * 
 * This will dispose of IObservableValue when the Widget is disposed.
 * 
 * @author jconlon
 *
 */
class MultiValueEReferencControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MultiValueEReferencControlBuilder.class);
	
	//Needs disposing
	private IObservableValue model;
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.editor.util.ControlBuilder#createControl(java.lang.Object, org.eclipse.swt.widgets.Composite, org.eclipse.emf.edit.provider.IItemPropertyDescriptor, org.eclipse.emf.common.notify.AdapterFactory, org.eclipse.core.databinding.DataBindingContext)
	 */
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {
		
		Text text = createControl( object,  parent,
				 itemPropertyDescriptor,
				 adapterFactory);
		text.addDisposeListener(new DisposeListener(){
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if(model!=null){
					model.dispose();
					logger.debug(bundleMarker,"{} disposed model",this);
				}else{
					logger.debug(bundleMarker,"{} widget disposed but model was null", this);
				}
			}
		});
		bind(object, dataBindingContext,
			 itemPropertyDescriptor,
				adapterFactory, text);
	}

	private Text createControl(final Object object, final Composite parent,
			final IItemPropertyDescriptor itemPropertyDescriptor,
			final AdapterFactory adapterFactory) {

		Composite composite = new Composite(parent, SWT.BORDER);
		// composite.setBounds(25, 25, 10, 20);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		Text text = new Text(composite, SWT.None | SWT.READ_ONLY);
		GridData gridData = new GridData();
		gridData.verticalAlignment = SWT.FILL;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		text.setLayoutData(gridData);
		Button button = new Button(composite, SWT.PUSH);
		// button.setBounds(5, 5, 10, 20);
		button.setText(" ");
		button.setToolTipText("Edit values");
		GridData gridData2 = new GridData();
		gridData2.verticalAlignment = SWT.FILL;
		gridData2.horizontalAlignment = SWT.FILL;
		// gridData2.widthHint = 5;
		button.setLayoutData(gridData2);
		button.addSelectionListener(new SelectionAdapter(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Object> choiceOfValues = 
					new ArrayList<Object>(itemPropertyDescriptor.getChoiceOfValues(object));
				EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
				EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);
				ILabelProvider labelProvider = 
					getLabelProvider(
						itemPropertyDescriptor, object);
				//Call the dialog
				EList<?> results = createDialog(
						eObject,
						itemPropertyDescriptor, 
						parent.getShell(),
						choiceOfValues,  
						eStructuralFeature,
						labelProvider,true);
				List<?> currentValues = (List<?>) eObject
						.eGet(eStructuralFeature);
				if (results != null && results.equals(currentValues)) {
					logger.debug(bundleMarker,"Values are equal");
				} else {
					handleResults(results, eObject, eStructuralFeature);
				}
				
				

			}
			
			

			/**
			 * @param results
			 */
			private void handleResults(EList<?> results, EObject eObject,
					EStructuralFeature eStructuralFeature) {
				logger.debug(bundleMarker,"Handling Result: " + results);
				//Is it easier to just do a set on the model which because
				//of the binding and the converter will fill in the text
				//box, like below?
				EditingDomain ed = AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject);

				ed.getCommandStack().execute(
						SetCommand.create(ed, eObject, eStructuralFeature,
								results));
			}
			
		});
		
		return text;
	}

	 private void bind(Object object, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor,
			final AdapterFactory adapterFactory, Text text) {
			
		EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);
	
		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		
		UpdateValueStrategy st = new UpdateValueStrategy() {

			/**
			 * Used instead of createConverter
			 */
			@Override
			public Object convert(Object value) {
				if (value instanceof EObjectResolvingEList<?>) {
					StringBuilder result = new StringBuilder();
					EObjectResolvingEList<?> c = (EObjectResolvingEList<?>) value;
					for (Object object : c) {
						if (result.length() > 0) {
							result.append(' ');
						}
						IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory
								.adapt(object, IItemLabelProvider.class);

						result.append(labelProvider.getText(object));
						
					}

					return result.toString();
				}
				return super.convert(value);
			}

		};
		model = EMFEditProperties.value(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject), //May throw nulls
				eStructuralFeature).observe(eObject);
		
		dataBindingContext.bindValue(
				SWTObservables.observeText(text,SWT.Modify), 
				model, 
				null, // TargetToModel
				st);// ModelToTarget
		
	}
	
	static EList<?> createDialog(EObject eObject,
			IItemPropertyDescriptor itemPropertyDescriptor, Shell shell,
			List<?> choiceOfValues, EStructuralFeature feature,
			ILabelProvider labelProvider, boolean multiline) {
	
		FeatureEditorDialog dialog = new FeatureEditorDialog(
				shell,
				labelProvider, 
				eObject, 
				feature.getEType(),
				(List<?>)eObject.eGet(feature),
				"Choose references",
				choiceOfValues, 
				multiline, 
				true //sorted
				);
		
		dialog.open();
		
		return dialog.getResult();
	}
	
	 protected static ILabelProvider getLabelProvider(
			IItemPropertyDescriptor itemPropertyDescriptor, Object object) {
		final IItemLabelProvider itemLabelProvider = itemPropertyDescriptor
				.getLabelProvider(object);
		return new LabelProvider() {
			@Override
			public String getText(Object object) {
				return itemLabelProvider.getText(object);
			}

			@Override
			public Image getImage(Object object) {
				return ExtendedImageRegistry.getInstance().getImage(
						itemLabelProvider.getImage(object));
			}
		};
	}

}
