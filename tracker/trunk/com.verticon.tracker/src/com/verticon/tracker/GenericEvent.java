/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker;

import com.verticon.osgi.metatype.OCD;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.osgi.service.metatype.AttributeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.GenericEvent#getEventAttributes <em>Event Attributes</em>}</li>
 *   <li>{@link com.verticon.tracker.GenericEvent#getOcd <em>Ocd</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getGenericEvent()
 * @model
 * @generated
 */
public interface GenericEvent extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * @NOT
	 */
	public static final int EVENT_CODE = 200;
	
	/**
	 * Returns the value of the '<em><b>Event Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Attributes</em>' map.
	 * @see com.verticon.tracker.TrackerPackage#getGenericEvent_EventAttributes()
	 * @model mapType="com.verticon.tracker.StringToStringMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getEventAttributes();

	/**
	 * Returns the value of the '<em><b>Ocd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocd</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocd</em>' reference.
	 * @see #setOcd(OCD)
	 * @see com.verticon.tracker.TrackerPackage#getGenericEvent_Ocd()
	 * @model
	 * @generated
	 */
	OCD getOcd();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.GenericEvent#getOcd <em>Ocd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocd</em>' reference.
	 * @see #getOcd()
	 * @generated
	 */
	void setOcd(OCD value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="com.verticon.osgi.metatype.AttributeDefinition" eventAttributeMapType="com.verticon.tracker.StringToStringMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(getOcd() ==null ){\n\treturn null;\n}\n\nfor (AttributeDefinition attributeDefinition : this.getOcd().getAttributeDefinitions(\n<%org.osgi.service.metatype.ObjectClassDefinition%>.ALL)) {\n\tif(eventAttribute.getKey().equals(attributeDefinition.getName())){\n\t\t\treturn attributeDefinition;\n\t}\n}\n\nreturn null;'"
	 * @generated
	 */
	AttributeDefinition findAttributeDefinition(Map.Entry<String, String> eventAttribute);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getOcd()==null?null:getOcd().getName(); '"
	 * @generated
	 */
	String findName();

} 
