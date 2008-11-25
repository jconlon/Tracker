package com.verticon.tracker.editor.util;

import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleValueEAttributeENumControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(SingleValueEAttributeENumControlBuilder.class);

	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {

		Combo combo = createControl(object, parent, itemPropertyDescriptor);

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

		dataBindingContext.bindValue(SWTObservables.observeSelection(combo),
				EMFEditObservables.observeValue(AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject), eObject,
						eStructuralFeature), tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

	}

}
