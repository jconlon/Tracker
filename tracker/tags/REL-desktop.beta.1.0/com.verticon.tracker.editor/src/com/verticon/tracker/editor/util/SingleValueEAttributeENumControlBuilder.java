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
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a Combo Widget for a multi choice attribute. 

 * This will dispose of IObservableValue when the Combo Widget is disposed.
 * 
 * @author jconlon
 *
 */
class SingleValueEAttributeENumControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SingleValueEAttributeENumControlBuilder.class);

	//Needs disposing
	private IObservableValue model;
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.editor.util.ControlBuilder#createControl(java.lang.Object, org.eclipse.swt.widgets.Composite, org.eclipse.emf.edit.provider.IItemPropertyDescriptor, org.eclipse.emf.common.notify.AdapterFactory, org.eclipse.core.databinding.DataBindingContext)
	 */
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {

		Combo combo = createControl(object, parent, itemPropertyDescriptor);
		combo.addDisposeListener(new DisposeListener(){
			
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
		bind(object, dataBindingContext, itemPropertyDescriptor, combo);
	}

	private Combo createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		Combo combo = new Combo(parent, SWT.DROP_DOWN);
		combo.setEnabled(itemPropertyDescriptor.canSetProperty(object));

		EAttribute eAttribute = (EAttribute) itemPropertyDescriptor
				.getFeature(object);
		EEnum enummer = (EEnum) eAttribute.getEAttributeType();

		for (EEnumLiteral lit : enummer.getELiterals()) {
			combo.add(lit.getLiteral());
		}

		return combo;
	}

	private void bind(Object object, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor, Combo combo) {

		EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);

		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);

		logger.debug(bundleMarker,"Binding {} feature {} to a combo widget", eObject
				.getClass().getSimpleName(), eStructuralFeature.getName());

		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);

		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);

		model = EMFEditProperties.value(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject), 
				eStructuralFeature).observe(eObject);
		
		dataBindingContext.bindValue(
				SWTObservables.observeSelection(combo),
				model, 
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget
		//FIXME normalize with SingleValueEAttributeControlBuilder
	}

}
