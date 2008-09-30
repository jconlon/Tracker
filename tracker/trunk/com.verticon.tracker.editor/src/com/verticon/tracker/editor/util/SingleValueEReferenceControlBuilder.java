package com.verticon.tracker.editor.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleValueEReferenceControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SingleValueEReferenceControlBuilder.class);
	
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {

		logger.debug("Creating Control For {}", object);
		
		ComboViewer comboViewer = createControl(object, parent,
				itemPropertyDescriptor, adapterFactory);

		bind(object, dataBindingContext, itemPropertyDescriptor, comboViewer);

	}

	private ComboViewer createControl(Object object, Composite parent,
			IItemPropertyDescriptor propertyDescriptor,
			AdapterFactory adapterFactory) {
		 EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		ComboViewer comboViewer = new ComboViewer(parent,
				SWT.DROP_DOWN);

		// Getting choices may or may not include a null.
		// Nulls in choices will cause an error
		List<Object> choices = new ArrayList<Object>();
		
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
		

		dataBindingContext.bindValue(ViewersObservables
				.observeSingleSelection(comboViewer), EMFEditObservables
				.observeValue(AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject), eObject,
						eStructuralFeature),
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

	}

	
}
