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
package com.verticon.tracker.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.GenericEventImpl#getEventAttributes <em>Event Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.GenericEventImpl#getOcd <em>Ocd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericEventImpl extends EventImpl implements GenericEvent {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The cached value of the '{@link #getEventAttributes() <em>Event Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventAttributes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> eventAttributes;

	/**
	 * The cached value of the '{@link #getOcd() <em>Ocd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcd()
	 * @generated
	 * @ordered
	 */
	protected OCD ocd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.GENERIC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getEventAttributes() {
		if (eventAttributes == null) {
			eventAttributes = new EcoreEMap<String,String>(TrackerPackage.Literals.STRING_TO_STRING_MAP, StringToStringMapImpl.class, this, TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES);
		}
		return eventAttributes;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCD getOcd() {
		if (ocd != null && ocd.eIsProxy()) {
			InternalEObject oldOcd = (InternalEObject)ocd;
			ocd = (OCD)eResolveProxy(oldOcd);
			if (ocd != oldOcd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.GENERIC_EVENT__OCD, oldOcd, ocd));
			}
		}
		return ocd;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCD basicGetOcd() {
		return ocd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOcdGen(OCD newOcd) {
		OCD oldOcd = ocd;
		ocd = newOcd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.GENERIC_EVENT__OCD, oldOcd, ocd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * When a new ObjectClassDefinition is set clear attributes if it is empty 
	 * and build attributes if there are no preexisting ones.
	 * 
	 * TODO this method only creates a crude set of attributes, refactor it
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOcd(OCD newOcd) {
		setOcdGen(newOcd);
		
		if(newOcd == null || (!newOcd.eIsProxy() && newOcd.getAD().isEmpty())){
			getEventAttributes().clear();//Is this right?
			return;
		}else if (getEventAttributes().isEmpty()) {
			//There is metadata in the newOcdref and there are no EventAttributes
			//Add entries for all the attributes -> Is this right?
			for (AttributeDefinition attributeDefinition : newOcd.getAttributeDefinitions(ObjectClassDefinition.ALL)) {
				StringToStringMapImpl eventAttribute =new StringToStringMapImpl();
				eventAttribute.setKey(attributeDefinition.getName());
				if(attributeDefinition.getType()!= AttributeDefinition.BOOLEAN && attributeDefinition.getDefaultValue()!=null){
					eventAttribute.setValue(attributeDefinition.getDefaultValue()[0]);
				}
				getEventAttributes().add(eventAttribute);
			}
			return;
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinition findAttributeDefinition(Map.Entry<String, String> eventAttribute) {
		if(getOcd() ==null ){
			return null;
		}
		
		for (AttributeDefinition attributeDefinition : this.getOcd().getAttributeDefinitions(
		ObjectClassDefinition.ALL)) {
			if(eventAttribute.getKey().equals(attributeDefinition.getName())){
					return attributeDefinition;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String findName() {
		return getOcd()==null?null:getOcd().getName(); 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object value(String key) {
		for (Map.Entry<String, String> eventAttribute : getEventAttributes().entrySet()) {
					if(eventAttribute.getKey().equals(key)){
						String value = eventAttribute.getValue();
						AttributeDefinition ad = findAttributeDefinition(eventAttribute);
						switch (ad.getType()) {
						case AttributeDefinition.DOUBLE:
							return Double.parseDouble(value);
						case AttributeDefinition.BOOLEAN:
							return Boolean.parseBoolean(value);
						case AttributeDefinition.BYTE:
							return Byte.parseByte(value);
						case AttributeDefinition.CHARACTER:
							return value.charAt(0);
						case AttributeDefinition.FLOAT:
							return Float.parseFloat(value);
						case AttributeDefinition.INTEGER:
							return Integer.parseInt(value);	
						case AttributeDefinition.LONG:
							return Long.parseLong(value);
						case AttributeDefinition.SHORT:
							return Short.parseShort(value);	
						case AttributeDefinition.STRING:
							return value;
						default:
							break;
						}
					}
				}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasRequiredAttributes(DiagnosticChain diagnostics, Map context) {
		// -> specify the condition that violates the invariant
		// All attributes defined in the OCD are required to be present in the document but
		//  not all attributes NEED to be set this validates if all requiredAttributes are not null
		boolean doesNotHavaAllRequiredAttributes;
		OCD ocd = getOcd();
		String message =null;		
		if(ocd!=null &&  
				ocd.getAttributeDefinitions(OCD.REQUIRED)!=null && 
		                ocd.getAttributeDefinitions(OCD.REQUIRED).length!=0){
			doesNotHavaAllRequiredAttributes = false;
		        //get the Attribute definitions from the OCD
			for (AttributeDefinition requiredAttributeDefinition : ocd.getAttributeDefinitions(OCD.REQUIRED)) {
				String value = this.getEventAttributes().get(requiredAttributeDefinition.getName());
				if(value==null){
					doesNotHavaAllRequiredAttributes=true;
					message=" is missing attribute("+requiredAttributeDefinition.getName()+')';
				}
			}
		}else{
			doesNotHavaAllRequiredAttributes = false;
		}
				
		if(doesNotHavaAllRequiredAttributes) {
			if (diagnostics != null) {
				diagnostics.add
				// -> verify the details of the diagnostic, including severity and message
					(new BasicDiagnostic
						(Diagnostic.ERROR,
							TrackerValidator.DIAGNOSTIC_SOURCE,
						        TrackerValidator.GENERIC_EVENT__HAS_REQUIRED_ATTRIBUTES,
							EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", 
		                                           new Object[] { "hasRequiredAttributes"+ message, EObjectValidator.getObjectLabel(this, context) }),
							new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasValidAttributes(DiagnosticChain diagnostics, Map context) {
		// -> specify the condition that violates the invariant
		boolean doesNotHavaAllValidAttributes;
		OCD ocd = getOcd();
		String message = null;
		
		if(ocd!=null &&  
				ocd.getAttributeDefinitions(OCD.ALL)!=null && 
				ocd.getAttributeDefinitions(OCD.ALL).length!=0){
			doesNotHavaAllValidAttributes = false;
		        //Get all the attributes in the event
			for (Map.Entry<String, String> eventAttribute : getEventAttributes()) {
		                if(eventAttribute.getValue()==null){
		                        //Dont validate nulls.  Let the hasRequiredAttributes invariant deal with these
					continue;
		                }
			 	AttributeDefinition ad = findAttributeDefinition(eventAttribute);
		                //For every attribute get the value and validate it.
				message = ad.validate(eventAttribute.getValue());
				if(message==null ||  message.trim().length()==0){
					//IsValid
				}else{
					doesNotHavaAllValidAttributes = true;
		                        message = "attribute("+eventAttribute.getKey()+") dataType "+message;
				}
			}
		}else{
			doesNotHavaAllValidAttributes = false;
		}
		
		if (doesNotHavaAllValidAttributes) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
							TrackerValidator.DIAGNOSTIC_SOURCE,
							TrackerValidator.GENERIC_EVENT__HAS_VALID_ATTRIBUTES,
							EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
				 				 new Object[] { "hasValidAttributes "+message, EObjectValidator.getObjectLabel(this, context) }),
							new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasAllAttributes(DiagnosticChain diagnostics, Map context) {
		// -> specify the condition that violates the invariant
		// All attributes defined in the OCD are required to be present in the document but
		//  not all attributes NEED to be set this validates if all attributes are present
		boolean doesNotHavaAllAttributes;
		OCD ocd = getOcd();
				
		String message =null;
		if(ocd!=null &&  ocd.getAttributeDefinitions(OCD.ALL)!=null && 
				              ocd.getAttributeDefinitions(OCD.ALL).length!=0){
			doesNotHavaAllAttributes = false;
		        //get the Attribute definitions from the OCD
			for (AttributeDefinition attributeDefinition : ocd.getAttributeDefinitions(OCD.ALL)) {
				//for every attributeDefinition there needs to be a entry
				boolean foundAttributeEntry = false;
				for (Map.Entry<String, String> entry : this.getEventAttributes()) {
					if(entry.getKey().equals(attributeDefinition.getName())){
						foundAttributeEntry = true;
					}else{
						message=" is missing attribute("+attributeDefinition.getName()+')';
					}
				}
				if(!foundAttributeEntry){
					doesNotHavaAllAttributes = true;
					break;
				}
			}
		}else{
			doesNotHavaAllAttributes = false;
		}
				
		if (doesNotHavaAllAttributes) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
							TrackerValidator.DIAGNOSTIC_SOURCE,
						        TrackerValidator.GENERIC_EVENT__HAS_ALL_ATTRIBUTES,
							EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", 
									new Object[] {
									"hasAllAttributes"+ message, 
									EObjectValidator.getObjectLabel(this, context) 
									}),
							new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				return ((InternalEList<?>)getEventAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				if (coreType) return getEventAttributes();
				else return getEventAttributes().map();
			case TrackerPackage.GENERIC_EVENT__OCD:
				if (resolve) return getOcd();
				return basicGetOcd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				((EStructuralFeature.Setting)getEventAttributes()).set(newValue);
				return;
			case TrackerPackage.GENERIC_EVENT__OCD:
				setOcd((OCD)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				getEventAttributes().clear();
				return;
			case TrackerPackage.GENERIC_EVENT__OCD:
				setOcd((OCD)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
				return eventAttributes != null && !eventAttributes.isEmpty();
			case TrackerPackage.GENERIC_EVENT__OCD:
				return ocd != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getEventCode() {
		return EVENT_CODE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.impl.EventImpl#values()
	 */
	@Override
	public String values() {
		StringBuffer buf = new StringBuffer();
		for (Map.Entry<String, String> eventAttribute : getEventAttributes().entrySet()) {
			buf.append(eventAttribute.getKey());
			buf.append(": ");
			buf.append(eventAttribute.getValue());
			buf.append(", ");
		}
		String out =  buf.toString();
		return out.contains(",")?out.substring(0,out.length()-2):out;
	}
	
	

} //GenericEventImpl
