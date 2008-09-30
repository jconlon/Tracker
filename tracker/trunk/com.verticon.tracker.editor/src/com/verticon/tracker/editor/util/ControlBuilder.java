package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;

public interface ControlBuilder {

	// /**
	// *
	// * @param object
	// * @param parent
	// * @param itemPropertyDescriptor
	// * @param adapterFactory
	// * @deprecated
	// */
	// @Deprecated
	// void createControl(Object object, Composite parent,
	// IItemPropertyDescriptor itemPropertyDescriptor,
	// AdapterFactory adapterFactory);
	//
	// /**
	// *
	// * @param object
	// * @param dataBindingContext
	// * @param itemPropertyDescriptor
	// * @deprecated
	// */
	// @Deprecated
	// void bind(Object object, DataBindingContext dataBindingContext,
	// IItemPropertyDescriptor itemPropertyDescriptor);
	//	
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
