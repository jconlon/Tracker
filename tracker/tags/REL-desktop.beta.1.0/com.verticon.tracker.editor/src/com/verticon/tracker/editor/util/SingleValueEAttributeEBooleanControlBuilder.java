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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.edit.provider.AttributeItemPropertyDescriptor;

/**
 * Creates a Button Widget for a boolean attribute. 
 * This ControlBuilder supports creating widgets for StringToStringMap 
 * entries that are associated with an AttributeItemPropertyDescriptor.
 * 
 * This will dispose of IObservableValue when the Widget is disposed.
 * 
 * @author jconlon
 *
 */
class SingleValueEAttributeEBooleanControlBuilder implements
		ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SingleValueEAttributeEBooleanControlBuilder.class);

	//Needs disposing
	private IObservableValue model;
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.editor.util.ControlBuilder#createControl(java.lang.Object, org.eclipse.swt.widgets.Composite, org.eclipse.emf.edit.provider.IItemPropertyDescriptor, org.eclipse.emf.common.notify.AdapterFactory, org.eclipse.core.databinding.DataBindingContext)
	 */
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {

		Button button = createControl(object, parent, itemPropertyDescriptor);
		button.addDisposeListener(new DisposeListener(){
			
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
		
		bind(object, dataBindingContext, itemPropertyDescriptor, button);
	}

	private Button createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		Button button = new Button(parent, SWT.CHECK);
		button.setEnabled(itemPropertyDescriptor.canSetProperty(object));
		return button;
	}

	private void bind(Object object, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor, Button button) {

		EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);

		EObject eObject;
		UpdateValueStrategy tToMStrategy = null;
		UpdateValueStrategy mToTStrategy = null;
		
		if(itemPropertyDescriptor instanceof AttributeItemPropertyDescriptor){
			AttributeItemPropertyDescriptor attributeItemPropertyDescriptor = 
				((AttributeItemPropertyDescriptor)itemPropertyDescriptor);
			//The object is a GenericEvent but the bind needs to be on a particular 
			//child eventAttrribute of the GenericEvent which is a 
			//StringToStringMap entry
			Object stringToStringMapEntry = attributeItemPropertyDescriptor.findEntry(object);
			Assert.isNotNull(stringToStringMapEntry);
			
			eObject = (EObject)stringToStringMapEntry;
			
			//			eObject = (EObject) AdapterFactoryEditingDomain.unwrap(stringToStringMapEntry);
			//The attributeItemPropertyDescriptor can do its own validation
			tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(attributeItemPropertyDescriptor);
			mToTStrategy = UpdateStrategies.INSTANCE
			    .getModelToTargetStrategy(attributeItemPropertyDescriptor);
			
		}else{
			tToMStrategy = UpdateStrategies.INSTANCE
			.getTargetToModelStrategy(eStructuralFeature);

			mToTStrategy = UpdateStrategies.INSTANCE
			.getModelToTargetStrategy(eStructuralFeature);

			eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		}
		
		logger.debug(bundleMarker,"Binding eObject={} with descriptor= {} to a text widget", 
				eObject, 
				itemPropertyDescriptor);

		
		model = EMFEditProperties.value(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject), 
				eStructuralFeature).observe(eObject);
		
		dataBindingContext.bindValue(
				SWTObservables.observeSelection(button),
				model, 
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

		//FIXME normalize with SingleValueEAttributeControlBuilder
		}

}
