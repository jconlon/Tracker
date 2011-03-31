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
package com.verticon.tracker;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EMap;
import org.osgi.service.metatype.AttributeDefinition;

import com.verticon.osgi.metatype.OCD;

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
	 * @model required="true"
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model keyDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (Map.Entry<String, String> eventAttribute : getEventAttributes().entrySet()) {\n\t\t\tif(eventAttribute.getKey().equals(key)){\n\t\t\t\tString value = eventAttribute.getValue();\n\t\t\t\tAttributeDefinition ad = findAttributeDefinition(eventAttribute);\n\t\t\t\tswitch (ad.getType()) {\n\t\t\t\tcase AttributeDefinition.DOUBLE:\n\t\t\t\t\treturn Double.parseDouble(value);\n\t\t\t\tcase AttributeDefinition.BOOLEAN:\n\t\t\t\t\treturn Boolean.parseBoolean(value);\n\t\t\t\tcase AttributeDefinition.BYTE:\n\t\t\t\t\treturn Byte.parseByte(value);\n\t\t\t\tcase AttributeDefinition.CHARACTER:\n\t\t\t\t\treturn value.charAt(0);\n\t\t\t\tcase AttributeDefinition.FLOAT:\n\t\t\t\t\treturn Float.parseFloat(value);\n\t\t\t\tcase AttributeDefinition.INTEGER:\n\t\t\t\t\treturn Integer.parseInt(value);\t\n\t\t\t\tcase AttributeDefinition.LONG:\n\t\t\t\t\treturn Long.parseLong(value);\n\t\t\t\tcase AttributeDefinition.SHORT:\n\t\t\t\t\treturn Short.parseShort(value);\t\n\t\t\t\tcase AttributeDefinition.STRING:\n\t\t\t\t\treturn value;\n\t\t\t\tdefault:\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t}\nreturn null;'"
	 * @generated
	 */
	Object value(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// -> specify the condition that violates the invariant\n// All attributes defined in the OCD are required to be present in the document but\n//  not all attributes NEED to be set this validates if all requiredAttributes are not null\nboolean doesNotHavaAllRequiredAttributes;\nOCD ocd = getOcd();\nString message =null;\t\t\nif(ocd!=null &&  \n\t\tocd.getAttributeDefinitions(OCD.REQUIRED)!=null && \n                ocd.getAttributeDefinitions(OCD.REQUIRED).length!=0){\n\tdoesNotHavaAllRequiredAttributes = false;\n        //get the Attribute definitions from the OCD\n\tfor (AttributeDefinition requiredAttributeDefinition : ocd.getAttributeDefinitions(OCD.REQUIRED)) {\n\t\tString value = this.getEventAttributes().get(requiredAttributeDefinition.getName());\n\t\tif(value==null){\n\t\t\tdoesNotHavaAllRequiredAttributes=true;\n\t\t\tmessage=\" is missing attribute(\"+requiredAttributeDefinition.getName()+\')\';\n\t\t}\n\t}\n}else{\n\tdoesNotHavaAllRequiredAttributes = false;\n}\n\t\t\nif(doesNotHavaAllRequiredAttributes) {\n\tif (diagnostics != null) {\n\t\tdiagnostics.add\n\t\t// -> verify the details of the diagnostic, including severity and message\n\t\t\t(new BasicDiagnostic\n\t\t\t\t(Diagnostic.ERROR,\n\t\t\t\t\tTrackerValidator.DIAGNOSTIC_SOURCE,\n\t\t\t\t        TrackerValidator.GENERIC_EVENT__HAS_REQUIRED_ATTRIBUTES,\n\t\t\t\t\tEcorePlugin.INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", \n                                           new Object[] { \"hasRequiredAttributes\"+ message, EObjectValidator.getObjectLabel(this, context) }),\n\t\t\t\t\tnew Object [] { this }));\n\t}\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean hasRequiredAttributes(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// -> specify the condition that violates the invariant\nboolean doesNotHavaAllValidAttributes;\nOCD ocd = getOcd();\nString message = null;\n\nif(ocd!=null &&  \n\t\tocd.getAttributeDefinitions(OCD.ALL)!=null && \n\t\tocd.getAttributeDefinitions(OCD.ALL).length!=0){\n\tdoesNotHavaAllValidAttributes = false;\n        //Get all the attributes in the event\n\tfor (Map.Entry<String, String> eventAttribute : getEventAttributes()) {\n                if(eventAttribute.getValue()==null){\n                        //Dont validate nulls.  Let the hasRequiredAttributes invariant deal with these\n\t\t\tcontinue;\n                }\n\t \tAttributeDefinition ad = findAttributeDefinition(eventAttribute);\n                //For every attribute get the value and validate it.\n\t\tmessage = ad.validate(eventAttribute.getValue());\n\t\tif(message==null ||  message.trim().length()==0){\n\t\t\t//IsValid\n\t\t}else{\n\t\t\tdoesNotHavaAllValidAttributes = true;\n                        message = \"attribute(\"+eventAttribute.getKey()+\") dataType \"+message;\n\t\t}\n\t}\n}else{\n\tdoesNotHavaAllValidAttributes = false;\n}\n\nif (doesNotHavaAllValidAttributes) {\n\tif (diagnostics != null) {\n\t\tdiagnostics.add\n\t\t\t(new BasicDiagnostic\n\t\t\t\t(Diagnostic.ERROR,\n\t\t\t\t\tTrackerValidator.DIAGNOSTIC_SOURCE,\n\t\t\t\t\tTrackerValidator.GENERIC_EVENT__HAS_VALID_ATTRIBUTES,\n\t\t\t\t\tEcorePlugin.INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\",\n\t\t \t\t\t\t new Object[] { \"hasValidAttributes \"+message, EObjectValidator.getObjectLabel(this, context) }),\n\t\t\t\t\tnew Object [] { this }));\n\t}\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean hasValidAttributes(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// -> specify the condition that violates the invariant\n// All attributes defined in the OCD are required to be present in the document but\n//  not all attributes NEED to be set this validates if all attributes are present\nboolean doesNotHavaAllAttributes;\nOCD ocd = getOcd();\n\t\t\nString message =null;\nif(ocd!=null &&  ocd.getAttributeDefinitions(OCD.ALL)!=null && \n\t\t              ocd.getAttributeDefinitions(OCD.ALL).length!=0){\n\tdoesNotHavaAllAttributes = false;\n        //get the Attribute definitions from the OCD\n\tfor (AttributeDefinition attributeDefinition : ocd.getAttributeDefinitions(OCD.ALL)) {\n\t\t//for every attributeDefinition there needs to be a entry\n\t\tboolean foundAttributeEntry = false;\n\t\tfor (Map.Entry<String, String> entry : this.getEventAttributes()) {\n\t\t\tif(entry.getKey().equals(attributeDefinition.getName())){\n\t\t\t\tfoundAttributeEntry = true;\n\t\t\t}else{\n\t\t\t\tmessage=\" is missing attribute(\"+attributeDefinition.getName()+\')\';\n\t\t\t}\n\t\t}\n\t\tif(!foundAttributeEntry){\n\t\t\tdoesNotHavaAllAttributes = true;\n\t\t\tbreak;\n\t\t}\n\t}\n}else{\n\tdoesNotHavaAllAttributes = false;\n}\n\t\t\nif (doesNotHavaAllAttributes) {\n\tif (diagnostics != null) {\n\t\tdiagnostics.add\n\t\t\t(new BasicDiagnostic\n\t\t\t\t(Diagnostic.ERROR,\n\t\t\t\t\tTrackerValidator.DIAGNOSTIC_SOURCE,\n\t\t\t\t        TrackerValidator.GENERIC_EVENT__HAS_ALL_ATTRIBUTES,\n\t\t\t\t\tEcorePlugin.INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", \n\t\t\t\t\t\t\tnew Object[] {\n\t\t\t\t\t\t\t\"hasAllAttributes\"+ message, \n\t\t\t\t\t\t\tEObjectValidator.getObjectLabel(this, context) \n\t\t\t\t\t\t\t}),\n\t\t\t\t\tnew Object [] { this }));\n\t}\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean hasAllAttributes(DiagnosticChain diagnostics, Map context);

} 
