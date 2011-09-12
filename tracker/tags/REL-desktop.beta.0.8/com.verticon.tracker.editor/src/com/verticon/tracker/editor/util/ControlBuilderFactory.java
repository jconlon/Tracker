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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.edit.provider.AttributeItemPropertyDescriptor;

class ControlBuilderFactory {

	/**
	 * slf4j Logger
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(ControlBuilderFactory.class);

	/**
	 * Constructor suppressed for noninstantiability
	 */
	private ControlBuilderFactory() {
		throw new AssertionError();
	}

	protected static ControlBuilder getInstance(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		
		//Reference
		if (isEReference(object, itemPropertyDescriptor)) {
			EReference eReference = (EReference) itemPropertyDescriptor
					.getFeature(object);
			
			//Create a text widget that is backed by dialog that can select 
			//multiple values
			if (eReference.isMany()) {
				logger.debug(bundleMarker,
						"Creating MultiValueEReferencControlBuilder for object={} with itemPropertyDescriptor={}",
						object.getClass().getSimpleName(), itemPropertyDescriptor);
				return new MultiValueEReferencControlBuilder();
				
			//Create a ComboViewer for a single value EReference Builder
			} else {
				
				logger.debug(bundleMarker,
						"Creating SingleValueEReferenceControlBuilder for object={} with itemPropertyDescriptor={}",
						object.getClass().getSimpleName(), itemPropertyDescriptor);
				
				return new SingleValueEReferenceControlBuilder();
			}
		
		//Boolean
		} else if (isSingleValueEAttributeEBoolean(object,
				itemPropertyDescriptor)) {
			logger.debug(bundleMarker,
					"Creating SingleValueEAttributeEBooleanControlBuilder for object={} with itemPropertyDescriptor={}",
					object.getClass().getSimpleName(), itemPropertyDescriptor);
			return new SingleValueEAttributeEBooleanControlBuilder();
		
		//ENum
		} else if (isSingleValueEAttributeEENum(object, itemPropertyDescriptor)) {
			logger.debug(bundleMarker,
					"Creating SingleValueEAttributeENumControlBuilder for object={} with itemPropertyDescriptor={}",
					object.getClass().getSimpleName(), itemPropertyDescriptor);
			return new SingleValueEAttributeENumControlBuilder();
		
		
		//Create a text widget for attributes that may or may not use AttributeItemPropertyDescriptor 
		} else if (isSingleValueEAttribute(object, itemPropertyDescriptor)&& itemPropertyDescriptor.getChoiceOfValues(object)==null) {
			logger.debug(bundleMarker,
					"Creating SingleValueEAttributeControlBuilder for object={} with itemPropertyDescriptor={}",
					object.getClass().getSimpleName(), itemPropertyDescriptor);
			return new SingleValueEAttributeControlBuilder();
		 
		//Create a combo widget for attributes that may or may not use AttributeItemPropertyDescriptor 
		} else if(isSingleValueEAttribute(object, itemPropertyDescriptor) && itemPropertyDescriptor.getChoiceOfValues(object)!=null){
				logger.debug(bundleMarker,
						"Creating SingleValueEAttributeChoiceControlBuilder for object={} with itemPropertyDescriptor={}",
						object.getClass().getSimpleName(), itemPropertyDescriptor);
				return new SingleValueEAttributeChoiceControlBuilder();
				
		} 
		
		//Default
		logger.debug(bundleMarker,
				"Creating DefaultControlBuilder for object={} with itemPropertyDescriptor={}",
				object.getClass().getSimpleName(), itemPropertyDescriptor);
		return new DefaultControlBuilder();
	}

	/**
	 * Object is an EReference ?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isEReference(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		Object genericFeature = itemPropertyDescriptor.getFeature(object);
		
		return (genericFeature instanceof EReference);
	}

	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
    static boolean isSingleValueEAttribute(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		
		Object genericFeature = itemPropertyDescriptor.getFeature(object);
		

		return (genericFeature instanceof EAttribute)
				&& !((EAttribute) genericFeature).isMany();

	}

	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	 static boolean isSingleValueEAttributeEBoolean(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		if (!isSingleValueEAttribute(object, itemPropertyDescriptor)) {
			return false;
		}
		EAttribute eAttribute = (EAttribute) itemPropertyDescriptor
				.getFeature(object);
		
		if(itemPropertyDescriptor instanceof AttributeItemPropertyDescriptor){
			AttributeItemPropertyDescriptor attributeItemPropertyDescriptor = 
				((AttributeItemPropertyDescriptor)itemPropertyDescriptor);
			if(attributeItemPropertyDescriptor.isBoolean()){
				return true;
			}
		}
		return eAttribute.getEAttributeType() == EcorePackage.Literals.EBOOLEAN;
		
	}
	
	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isSingleValueEAttributeEENum(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		if (!isSingleValueEAttribute(object, itemPropertyDescriptor)) {
			return false;
		}
		EAttribute eAttribute = (EAttribute) itemPropertyDescriptor
				.getFeature(object);

		return (eAttribute.getEAttributeType() instanceof EEnum);

	}
}
