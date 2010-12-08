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

import java.util.Comparator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a ComboViewer for a multi choice reference.

 * This will dispose of IObservableValue when the Combo Widget of the Viewer
 * is disposed.
 * 
 * @author jconlon
 *
 */
class SingleValueEReferenceControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SingleValueEReferenceControlBuilder.class);
	
	//Needs disposing
	private IObservableValue model;
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.editor.util.ControlBuilder#createControl(java.lang.Object, org.eclipse.swt.widgets.Composite, org.eclipse.emf.edit.provider.IItemPropertyDescriptor, org.eclipse.emf.common.notify.AdapterFactory, org.eclipse.core.databinding.DataBindingContext)
	 */
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {
	
		ComboViewer comboViewer = createControl(object, parent,
				itemPropertyDescriptor, adapterFactory);

		comboViewer.getCombo().addDisposeListener(new DisposeListener(){
			
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
		bind(object, dataBindingContext, itemPropertyDescriptor, comboViewer);

	}

	private ComboViewer createControl(Object object, Composite parent,
			IItemPropertyDescriptor propertyDescriptor,
			AdapterFactory adapterFactory) {
		ComboViewer comboViewer = new ComboViewer(parent,
				SWT.DROP_DOWN);

		// Getting choices may or may not include a null.
		// Nulls in choices will cause an error
		
		///
       EList<Object> choices = new BasicEList<Object>(propertyDescriptor.getChoiceOfValues(object).size());
		
		for (Object object2 : propertyDescriptor.getChoiceOfValues(object)) {
			if (object2 != null) {
				choices.add(object2);
			} else {
				choices.add(" ");
			}
		}

		if (choices.isEmpty()) {
			return comboViewer;
		}
		final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				adapterFactory);
		Comparator<Object> comparator = new Comparator<Object>(){

			public int compare(Object o1, Object o2) {
				return labelProvider.getText(o1).compareTo(labelProvider.getText(o2));
			}
			
		};
		ECollections.sort(choices, comparator);
		
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		comboViewer.setInput(choices.toArray());
		return comboViewer;
	}

	private void bind(Object object, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor,
			ComboViewer comboViewer) {

		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);
		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);
		

		model = EMFEditProperties.value(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject), 
				eStructuralFeature).observe(eObject);
		
		dataBindingContext.bindValue(
				ViewersObservables.observeSingleSelection(comboViewer), 
				model,
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

	}

	
}
