package com.verticon.tracker.validation.core.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.osgi.service.metatype.AttributeDefinition;

import com.verticon.tracker.GenericEvent;

public class EventAttributeConstraint extends AbstractModelConstraint {

	/**
	 * Messages must return 4 variables.
	 * 
	 * To conform to the format and message text:
	 * 
	 * Core Constraint: {0} for GenericEvent {1}; attribute {2}. {3}"
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		if (!(eObj instanceof BasicEMap.Entry)) {
			return ctx.createSuccessStatus();
		}
		BasicEMap.Entry<String, String> eventAttribute = (BasicEMap.Entry<String, String>) eObj;
		GenericEvent ge = (GenericEvent) eObj.eContainer();
		if (ge.findAttributeDefinition(eventAttribute) == null) {
			return ctx
					.createFailureStatus(new Object[] {
							eObj.eClass().getName(), "of an unknown type",
							eventAttribute.getKey(),
							"Please delete this event, validate the schema, and recreate the event." });
		}

		String nameOfGenericEvent = ge.findAttributeDefinition(eventAttribute).getName();
		String valueOfAttribute = eventAttribute.getValue();
		String keyNameOfAttribute = eventAttribute.getKey();
		AttributeDefinition attributeDefinition = ge.findAttributeDefinition(eventAttribute);
		

		EMFEventType eType = ctx.getEventType();
		
		if (eType == EMFEventType.NULL) {
			// In the case of batch mode.
			if (valueOfAttribute == null || valueOfAttribute.length() == 0) {
				return createNullFailure(ctx, eObj, eventAttribute, ge,
						nameOfGenericEvent);

			}

			String result = attributeDefinition.validate(valueOfAttribute);
			if(result != null && result.length()!=0){
				
			return ctx.createFailureStatus(new Object[] {
					eObj.eClass().getName(),
					nameOfGenericEvent, keyNameOfAttribute,
					result });
			}
			
		} else {
			// In the case of live mode.
			Object newValue = ctx.getFeatureNewValue();
			String value = (String)newValue;
			
			if (value == null || value.length() == 0) {
				return createNullFailure(ctx, eObj, eventAttribute, ge,
						nameOfGenericEvent);
			}
			
			
			String result = attributeDefinition.validate(valueOfAttribute);
			if(result != null && result.length()!=0){
				return ctx.createFailureStatus(new Object[] {
					eObj.eClass().getName(),
					nameOfGenericEvent, keyNameOfAttribute,
					result });
			}
		}

		return ctx.createSuccessStatus();
	}

	/**
	 * @param ctx
	 * @param eObj
	 * @param eventAttribute
	 * @param ge
	 * @param nameOfEvent
	 * @return
	 */
	private IStatus createNullFailure(IValidationContext ctx, EObject eObj,
			BasicEMap.Entry<String, String> eventAttribute, GenericEvent ge,
			String nameOfEvent) {
		IStatus failureStatus = ctx
				.createFailureStatus(new Object[] {
						eObj.eClass().getName(),
						nameOfEvent,
						eventAttribute.getKey(),
						"The value must be a non null value." });
		return failureStatus;
	}


}
