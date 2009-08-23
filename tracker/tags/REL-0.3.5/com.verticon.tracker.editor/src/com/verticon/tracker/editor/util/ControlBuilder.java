package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;

interface ControlBuilder {

		
	/**
	 * Create a visual component for object within the parent and bind it with
	 * the dataBindingContext
	 * 
	 * @param object
	 * @param parent
	 * @param itemPropertyDescriptor
	 * @param adapterFactory
	 * @param dataBindingContext
	 */
	void createControl(Object object, Composite parent,
			IItemPropertyDescriptor itemPropertyDescriptor,
			AdapterFactory adapterFactory, DataBindingContext dataBindingContext);
}
