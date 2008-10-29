package com.verticon.tracker.editor.util;


import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.CheckISO7064Mod37_36;


/**
 * Utility class for finding UpdateValueStrategy for EMF features.
 * 
 * @author jconlon
 * 
 */
public class UpdateStrategies {

//	/**
//	 * slf4j Logger
//	 */
//	private final Logger logger = LoggerFactory
//			.getLogger(UpdateStrategies.class);
//	
	
	/**
	 * Private constructor prevents instantiation.
	 */
	private UpdateStrategies() {
		super();
	}

	
	/**
	 * The singleton instance
	 */
	static UpdateStrategies INSTANCE = new UpdateStrategies();

	private static final UpdateValueStrategy eReferenceSingleValueStrategy = new EReferenceSingleValueUpdateValueStrategy();
	private static final UpdateValueStrategy pinUpdateStrategy = new PinUpdateValueStrategy();
	private static final IValidator doubleValidator = new DoubleValidator();
	private static final IValidator integerValidator = new IntegerValidator();
	
	 /**
	 * Main entry to class to find a target to model strategy for a given
	 * Feature
	 * 
	 * @param eStructuralFeature
	 * @return
	 */
    UpdateValueStrategy getTargetToModelStrategy(
			EStructuralFeature eStructuralFeature) {
		if(eStructuralFeature instanceof EAttribute){
			EAttribute e = (EAttribute)eStructuralFeature;
			if(e.getEAttributeType().equals(TrackerPackage.eINSTANCE.getPremisesIdNumber())){
				return pinUpdateStrategy;
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
    
    private IValidator getValidator(EStructuralFeature eStructuralFeature){
    	
    	IValidator validator = null;
    	
    	switch (eStructuralFeature.getEType().getClassifierID()) {
    	case EcorePackage.EDOUBLE_OBJECT:
		case EcorePackage.EDOUBLE:
//			logger.debug("Returning double for element {} attribute {} and type {}", 
//					new Object[] {eStructuralFeature.getContainerClass(),
//					eStructuralFeature.getName(), eStructuralFeature.getEType().getName()});
			validator = doubleValidator;
			break;

		case EcorePackage.EINTEGER_OBJECT:
		case EcorePackage.EINT:
//			logger.debug("Returning Integer for element {} attribute {} and type {}", 
//					new Object[] {eStructuralFeature.getContainerClass(),
//					eStructuralFeature.getName(), eStructuralFeature.getEType().getName()});
			validator = integerValidator;
			break;
		case EcorePackage.ESTRING:  //Ignore string
			break;
		default:
//			logger.error("Null validation for element {} attribute {} and type {}", 
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

		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			IStatus result = super.doSet(observableValue, value);
			if (result.isOK()) {
				Object changed = observableValue;
				if (changed instanceof IObserving) {
					changed = ((IObserving) changed).getObserved();
				}
				
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
