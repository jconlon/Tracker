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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.edit.provider.AttributeItemPropertyDescriptor;
import com.verticon.tracker.util.CheckISO7064Mod37_36;

/**
 * Utility class for finding UpdateValueStrategy for EMF features.
 * 
 * @author jconlon
 * 
 */
class UpdateStrategies {

	/**
	 * Private constructor prevents instantiation.
	 */
	private UpdateStrategies() {
		super();
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(UpdateStrategies.class);


	/**
	 * The singleton instance
	 */
	static UpdateStrategies INSTANCE = new UpdateStrategies();

	private static final UpdateValueStrategy eReferenceSingleValueStrategy = new EReferenceSingleValueUpdateValueStrategy();
	private static final UpdateValueStrategy pinUpdateStrategy = new PinUpdateValueStrategy();
	private static final IValidator doubleValidator = new DoubleValidator();
	private static final IValidator integerValidator = new IntegerValidator();
	private static final IConverter stringToBooleanConverter = new StringToBoolean();
	private static final IConverter booleanToStringConverter = new BooleanToString();
	
	 /**
	 * 
	 * 
	 * @param eStructuralFeature
	 * @return UpdateValueStrategy for a EFeature
	 */
    UpdateValueStrategy getTargetToModelStrategy(
			EStructuralFeature eStructuralFeature) {
		if(eStructuralFeature instanceof EAttribute){
			EAttribute e = (EAttribute)eStructuralFeature;
			if(e.getEAttributeType().equals(TrackerPackage.eINSTANCE.getPremisesIdNumber())){
				return pinUpdateStrategy;
			}else if(e.getEAttributeType().equals(TrackerPackage.eINSTANCE.getStringToStringMap())){
				logger.debug(bundleMarker,"Matched attribute={} with dataType={}",
						new Object[]{e.getName(),  e.getEAttributeType().getName()});
			}else{
				logger.debug(bundleMarker,
						"Did not match attribute={} with dataType={}",
						new Object[]{e.getName(), e.getEAttributeType().getName()});
			}
			
		} else if (eStructuralFeature instanceof EReference) {
			if (eStructuralFeature.isMany()) {
				return null;
			} else {
				return eReferenceSingleValueStrategy;
			}
			
		}
		
		
		return new TransactionalAwareUpdateValueStrategy().setAfterGetValidator(getValidator(eStructuralFeature));
	}
    
    /**
     * 
     * @param attributeItemPropertyDescriptor
     * @return UpdateValueStrategy for a AttributeItemPropertyDescriptor of a GenericEvent
     */
    UpdateValueStrategy getTargetToModelStrategy(
    		AttributeItemPropertyDescriptor attributeItemPropertyDescriptor){
    	
    	if(attributeItemPropertyDescriptor.isBoolean()){
    		return new UpdateValueStrategy().setBeforeSetValidator(
        			new AttributeDefinitionValidator(attributeItemPropertyDescriptor))
        				.setConverter(booleanToStringConverter);
    	}
    	return new UpdateValueStrategy().setBeforeSetValidator(
    			new AttributeDefinitionValidator(attributeItemPropertyDescriptor));
    }
    
    /**
     * 
     * @param attributeItemPropertyDescriptor
     * @return UpdateValueStrategy for a AttributeItemPropertyDescriptor of a GenericEvent
     */
    UpdateValueStrategy getModelToTargetStrategy(
    		AttributeItemPropertyDescriptor attributeItemPropertyDescriptor){
    	
    	if(attributeItemPropertyDescriptor.isBoolean()){
    		return new UpdateValueStrategy().setConverter(stringToBooleanConverter);
    	}
    	return null;
    }
    
    private IValidator getValidator(EStructuralFeature eStructuralFeature){
    	
    	IValidator validator = null;
    	
    	switch (eStructuralFeature.getEType().getClassifierID()) {
    	case EcorePackage.EDOUBLE_OBJECT:
		case EcorePackage.EDOUBLE:
			logger.debug(bundleMarker,"Returning double for element {} attribute {} and type {}", 
					new Object[] {eStructuralFeature.getContainerClass(),
					eStructuralFeature.getName(), eStructuralFeature.getEType().getName()});
			validator = doubleValidator;
			break;

		case EcorePackage.EINTEGER_OBJECT:
		case EcorePackage.EINT:
			logger.debug(bundleMarker,"Returning Integer for element {} attribute {} and type {}", 
					new Object[] {eStructuralFeature.getContainerClass(),
					eStructuralFeature.getName(), eStructuralFeature.getEType().getName()});
			validator = integerValidator;
			break;
		case EcorePackage.ESTRING:  //Ignore string
			break;
		default:
//			logger.error(bundleMarker,"Null validation for element {} attribute {} and type {}", 
//					new Object[] {eStructuralFeature.getContainerClass(),
//					eStructuralFeature.getName(), eStructuralFeature.getEType().getName()});
			break;
		}
    	
    	return validator;
    }
	
    /**
	 * Main entry to class to find a model to target strategy for a given
	 * Feature
	 * 
	 * @param eStructuralFeature
	 * @return
	 */
    UpdateValueStrategy getModelToTargetStrategy(
			EStructuralFeature eStructuralFeature) {
		return null;
	}
	
    /**
	 * Strategy for dealing with Single Valued EReferences.
	 * 
	 * @author jconlon
	 * 
	 */
	private static final class EReferenceSingleValueUpdateValueStrategy extends
			UpdateValueStrategy {

		/**
		 * Kludge to detect a space character in a choice list that denotes a
		 * null for nulling an EMF EReference
		 */
		@Override
		public Object convert(Object value) {
			if (value instanceof String && ((String) value).equals(" ")) {
				return null;
			}
			return super.convert(value);
		}

	}
	
	  /**
	 * Strategy for dealing with Pins
	 * 
	 * @author jconlon
	 * 
	 */
	private static final class PinUpdateValueStrategy extends
			UpdateValueStrategy {

		@Override
		public IStatus validateBeforeSet(Object value) {
			return new MyPinValidator().validate(value);
		}

		//If the value is a string of 7 spaces unset the value to a null.
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			IStatus result = null;
			if(value instanceof String && ((String)value).trim().length()<1){
			    result = super.doSet(observableValue, null);
			}else{
				result = super.doSet(observableValue, value);
			}
			return result;
		}
	}
	
	private static final class MyPinValidator implements IValidator {
		public IStatus validate(Object value) {
			String initialValue = (String)value;
			if(initialValue.length()!=7){
				return ValidationStatus.error("Premises Id must contain 7 digits: " + initialValue+
					", to delete enter 7 spaces.");
			}
			if(initialValue.trim().length()<1){
				return ValidationStatus.ok();
			}
			try {
				if(CheckISO7064Mod37_36.verify(initialValue)){
					return ValidationStatus.ok();
				}
			} catch (NumberFormatException e) {
				return ValidationStatus.error("NumberFormat "+e);
			}
			
			return ValidationStatus.error(initialValue+" " +
					"is a not legal Premises Id. To delete enter 7 spaces.");
			
		}
		
	}
	
}
 
/**
 * Validator for AttributeDefinition based attributes of GenericEvent objects.
 * @author jconlon
 *
 */
final class AttributeDefinitionValidator implements IValidator{

	private final AttributeItemPropertyDescriptor attributeItemPropertyDescriptor;
	
    AttributeDefinitionValidator(
			AttributeItemPropertyDescriptor attributeItemPropertyDescriptor) {
		super();
		this.attributeItemPropertyDescriptor = attributeItemPropertyDescriptor;
	}
	@Override
	public IStatus validate(Object value) {
		String error = attributeItemPropertyDescriptor.validate((String)value);
		return error==null || error.trim().length()==0?
				ValidationStatus.ok():
			    ValidationStatus.error(error);
	}
	
}


final class DoubleValidator implements IValidator {
	public IStatus validate(Object value) {
		String s = (String)value;
		try {
			Double.parseDouble(s);
			return ValidationStatus.ok();
		} catch (NumberFormatException e) {
			return ValidationStatus
			.error("Value must be numeric.");
		}

	}
}

final class IntegerValidator implements IValidator {
	public IStatus validate(Object value) {
		String s = (String)value;
		try {
			Integer.parseInt(s);
			return ValidationStatus.ok();
		} catch (NumberFormatException e) {
			return ValidationStatus
			.error("Value must be numeric.");
		}

	}
}

final class BooleanToString extends Converter{
	public BooleanToString() {
		super(Boolean.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		Boolean b = (Boolean)fromObject;
		
		return b==null || !b? "false": "true";
		
	}
}

final class StringToBoolean extends Converter{
	public StringToBoolean() {
		super(String.class, Boolean.class);
	}

	@Override
	public Object convert(Object fromObject) {
		String b = (String)fromObject;
		
		return b==null || b.toLowerCase().equals("false")? Boolean.FALSE: Boolean.TRUE;
		
	}
}
