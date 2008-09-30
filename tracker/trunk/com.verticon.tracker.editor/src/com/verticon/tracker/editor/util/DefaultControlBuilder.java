package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultControlBuilder implements ControlBuilder {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(DefaultControlBuilder.class);
	
	public void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext) {
		
		logger.error("Setting up a default text widget for feature {}",
				itemPropertyDescriptor.getFeature(object));
		Text text = new Text(
				parent, SWT.NONE);
		{
			GridData gridData = new GridData();
			gridData.verticalAlignment = SWT.FILL;
			gridData.horizontalAlignment = SWT.FILL;
			text.setLayoutData(gridData);
		}
		Object genericFeature = itemPropertyDescriptor.getFeature(object);
		if (genericFeature instanceof EStructuralFeature) {
			EStructuralFeature eStructuralFeature = (EStructuralFeature) genericFeature;
			if (eStructuralFeature.isMany()) {
				text.setText("Unvisualized multiValued "
						+ eStructuralFeature.getName());
			} else {
				text.setText("Unvisualized singleValued \n"
						+ eStructuralFeature.getName());
			}
		} else {
			text.setText("Unvisulized non EStructuralFeature \n"
					+ itemPropertyDescriptor.getFeature(object));
		}
		
		
		text.setForeground(parent.getDisplay().getSystemColor(
				SWT.COLOR_RED));

	}

	

}
