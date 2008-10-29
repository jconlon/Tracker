package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.Binding;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class SingleValueEAttributeControlBuilder implements ControlBuilder {

	private Text text;

	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {
		Text text = createControl(object, parent, itemPropertyDescriptor,
				adapterFactory);
		bind(object, dataBindingContext, itemPropertyDescriptor, text);
	}

	private Text createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory) {

		if (text != null) {
			text.dispose();
		}

		Text text = new Text(parent, SWT.BORDER | SWT.None);
		text.setEnabled(itemPropertyDescriptor.canSetProperty(object));

		GridData gridData = new GridData();
		gridData.verticalAlignment = SWT.FILL;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		text.setLayoutData(gridData);

		return text;
	}

	private void bind(Object object, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor, Text text) {
			
		EStructuralFeature eStructuralFeature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(object);
		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		
		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);
		
		Binding binding = dataBindingContext.bindValue(SWTObservables.observeText(text,
				SWT.Modify), EMFEditObservables.observeValue(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject),
				eObject, eStructuralFeature), tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget
		
	    
		if(tToMStrategy instanceof TransactionalAwareUpdateValueStrategy){
			TransactionalAwareUpdateValueStrategy st = 
				(TransactionalAwareUpdateValueStrategy)tToMStrategy;
			st.setBinding(binding);
		}
	}

	

	

}
