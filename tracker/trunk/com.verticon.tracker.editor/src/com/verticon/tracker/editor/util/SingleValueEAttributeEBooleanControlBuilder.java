package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class SingleValueEAttributeEBooleanControlBuilder implements
		ControlBuilder {

	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {

		Button button = createControl(object, parent, itemPropertyDescriptor);

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

		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);

		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);

		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);

		dataBindingContext.bindValue(SWTObservables.observeSelection(button),
				EMFEditObservables.observeValue(AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject), eObject,
						eStructuralFeature), tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

	}

}
