package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.CheckISO7064Mod37_36;

public class UpdateStrategies {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	static UpdateStrategies INSTANCE = new UpdateStrategies();

	
	protected UpdateValueStrategy getTargetToModelStrategy(EStructuralFeature eStructuralFeature){
//		if(FairPackage.eINSTANCE.getPerson_Pin().equals(eStructuralFeature)){
//			return new CustomUpdateValueStrategy();
//		}
//		if(eStructuralFeature.getEType().equals(TrackerPackage.eINSTANCE.getPremisesIdNumber()))
		
		if(eStructuralFeature instanceof EAttribute){
			EAttribute e = (EAttribute)eStructuralFeature;
			if(e.getEAttributeType().equals(TrackerPackage.eINSTANCE.getPremisesIdNumber())){
				return new CustomUpdateValueStrategy();
			}
		}
		
		
		return null;
	}
	
	protected UpdateValueStrategy getModelToTargetStrategy(EStructuralFeature eStructuralFeature){
		
		return null;
	}
	
	private static final class CustomUpdateValueStrategy extends UpdateValueStrategy {

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
	
	private static class MyPinValidator implements IValidator{
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
