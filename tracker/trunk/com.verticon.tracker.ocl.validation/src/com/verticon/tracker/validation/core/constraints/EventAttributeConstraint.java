package com.verticon.tracker.validation.core.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.verticon.tracker.EventAttributeSchema;
import com.verticon.tracker.EventDataType;
import com.verticon.tracker.GenericEvent;

public class EventAttributeConstraint extends AbstractModelConstraint {

	public EventAttributeConstraint() {
		
	}

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
		if (ge.getEventSchema() == null) {
			return ctx
					.createFailureStatus(new Object[] {
							eObj.eClass().getName(), "of an unknown type",
							eventAttribute.getKey(),
							"Please delete this event, validate the schema, and recreate the event." });
		}

		String nameOfGenericEvent = ge.getEventSchema().getName();
		String valueOfAttribute = eventAttribute.getValue();
		String keyNameOfAttribute = eventAttribute.getKey();
		EventAttributeSchema eventAttributeSchema = ge
				.findSchema(eventAttribute);
		EventDataType eventDataType = eventAttributeSchema.getDataType();

		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {

			if (valueOfAttribute == null || valueOfAttribute.length() == 0) {
				return createNullFailure(ctx, eObj, eventAttribute, ge,
						nameOfGenericEvent);

			}

			switch (eventDataType.getValue()) {
			case EventDataType.INTEGER_VALUE:
				try {
					Integer.decode(valueOfAttribute);
				} catch (NumberFormatException e) {
					return ctx
							.createFailureStatus(new Object[] {
									eObj.eClass().getName(),
									nameOfGenericEvent, keyNameOfAttribute,
									"The value must be an Integer." });
				}
				break;
			case EventDataType.STRING_VALUE:
				// Just accept it
				break;
			case EventDataType.BOOLEAN_VALUE:
				if (!valueOfAttribute.toLowerCase().equals("true")
						&& !valueOfAttribute.toLowerCase().equals("false")) {
					return ctx.createFailureStatus(new Object[] {
							eObj.eClass().getName(), nameOfGenericEvent,
							keyNameOfAttribute,
							"The value must be set to true or false." });
				}
				break;

			}

			// In the case of live mode.
		} else {

			Object newValue = ctx.getFeatureNewValue();
			String value = (String)newValue;
			
			if (value == null || value.length() == 0) {
				return createNullFailure(ctx, eObj, eventAttribute, ge,
						nameOfGenericEvent);
			}
			
			switch (eventDataType.getValue()) {
			case EventDataType.INTEGER_VALUE:
				try {
					Integer.decode(value);
				} catch (NumberFormatException e) {
					return ctx
							.createFailureStatus(new Object[] {
									eObj.eClass().getName(),
									nameOfGenericEvent, keyNameOfAttribute,
									"The value must be an Integer." });
				}
				break;
			case EventDataType.STRING_VALUE:
				// Just accept it
				break;
			case EventDataType.BOOLEAN_VALUE:
				if (!value.toLowerCase().equals("true")
						&& !value.toLowerCase().equals("false")) {
					return ctx.createFailureStatus(new Object[] {
							eObj.eClass().getName(), nameOfGenericEvent,
							keyNameOfAttribute,
							"The value must be set to true or false." });
				}
				break;

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
