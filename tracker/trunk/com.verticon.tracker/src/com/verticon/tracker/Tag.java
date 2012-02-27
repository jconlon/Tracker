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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.verticon.osgi.metatype.OCD;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Tag#isUsainNumberUsed <em>Usain Number Used</em>}</li>
 *   <li>{@link com.verticon.tracker.Tag#getEvents <em>Events</em>}</li>
 *   <li>{@link com.verticon.tracker.Tag#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.Tag#getAnimal <em>Animal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getTag()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='IDIsValidURISegment'"
 * @generated
 */
public interface Tag extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Usain Number Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usain Number Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usain Number Used</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getTag_UsainNumberUsed()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUsainNumberUsed();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.tracker.Event}.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Event#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see com.verticon.tracker.TrackerPackage#getTag_Events()
	 * @see com.verticon.tracker.Event#getTag
	 * @model opposite="tag" containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.verticon.tracker.TrackerPackage#getTag_Id()
	 * @model default="" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Tag#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Animal</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Animal#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' container reference.
	 * @see #setAnimal(Animal)
	 * @see com.verticon.tracker.TrackerPackage#getTag_Animal()
	 * @see com.verticon.tracker.Animal#getTags
	 * @model opposite="tags" transient="false"
	 * @generated
	 */
	Animal getAnimal();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Tag#getAnimal <em>Animal</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Animal</em>' container reference.
	 * @see #getAnimal()
	 * @generated
	 */
	void setAnimal(Animal value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" ocdIdDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(eContainer instanceof Animal){\n\treturn ((Animal)eContainer).canContain(eventType, ocdId);\n}else if (eContainer instanceof Premises){\n\tif(eventType!=<%EventType%>.TAG_APPLIED){\n\t\treturn Boolean.FALSE;\n\t}\n}\nreturn Boolean.TRUE;'"
	 * @generated
	 */
	boolean canContain(EventType eventType, String ocdId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (OCD ocd : findOCDs()) {\n\tif(ocd.getID().equals(ocdId)){\n\t\treturn ocd;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	OCD findOCD(String ocdId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final EList<OCD> results = new <%org.eclipse.emf.common.util.BasicEList%><OCD>();\n<%com.verticon.osgi.metatype.util.MetatypeSwitch%><Boolean> ocdVisitor = new MetatypeSwitch<Boolean>(){\n\t@Override\n\tpublic Boolean caseOCD(OCD object) {\n\t\tresults.add(object);\n\t\treturn Boolean.FALSE;\n\t}\n\n\t@Override\n\tpublic Boolean caseDocumentRoot(<%com.verticon.osgi.metatype.DocumentRoot%> object) {\n\t\treturn  Boolean.TRUE;\n\t}\n\n\t\t\t\n\t@Override\n\tpublic Boolean caseMetaData(<%com.verticon.osgi.metatype.MetaData%> object) {\n\t\treturn  Boolean.TRUE;\n\t}\n\n\t@Override\n\tpublic Boolean defaultCase(EObject object) {\n\t\treturn Boolean.FALSE;\n\t}\n};\nif(eResource()!=null && eResource().getResourceSet()!=null ){\n\tfor(<%org.eclipse.emf.common.util.TreeIterator%><?> iter = <%org.eclipse.emf.ecore.util.EcoreUtil%>.getAllContents(eResource().getResourceSet(), true); iter.hasNext();){\n\t\tObject o =  iter.next();\n\t\tif(o instanceof EObject){\n\t\t\t<%org.eclipse.emf.ecore.EObject%> eObject = (EObject)o;\n\t\t\tif(ocdVisitor.doSwitch(eObject) == Boolean.FALSE){\n\t\t\t\titer.prune();\n\t\t\t}\n\t\t}\n\t}\n}\nreturn results;'"
	 * @generated
	 */
	EList<OCD> findOCDs();

} // Tag
