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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replaced Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.ReplacedTag#getOldId <em>Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.ReplacedTag#isUsainNumberUsedForOldId <em>Usain Number Used For Old Id</em>}</li>
 *   <li>{@link com.verticon.tracker.ReplacedTag#getOldTag <em>Old Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getReplacedTag()
 * @model
 * @generated
 */
public interface ReplacedTag extends Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Old Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Id</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_OldId()
	 * @model default="" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getOldId();

	/**
	 * Returns the value of the '<em><b>Usain Number Used For Old Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usain Number Used For Old Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usain Number Used For Old Id</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_UsainNumberUsedForOldId()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUsainNumberUsedForOldId();

	/**
	 * Returns the value of the '<em><b>Old Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Tag</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Tag</em>' reference.
	 * @see #setOldTag(Tag)
	 * @see com.verticon.tracker.TrackerPackage#getReplacedTag_OldTag()
	 * @model required="true"
	 * @generated
	 */
	Tag getOldTag();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.ReplacedTag#getOldTag <em>Old Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Tag</em>' reference.
	 * @see #getOldTag()
	 * @generated
	 */
	void setOldTag(Tag value);

} // ReplacedTag