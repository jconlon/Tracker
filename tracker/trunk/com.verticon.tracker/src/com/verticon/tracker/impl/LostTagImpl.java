/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.ecore.EClass;

import com.verticon.tracker.LostTag;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lost Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LostTagImpl extends EventImpl implements LostTag {
	private static final int EVENT_CODE = 5;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LostTagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.LOST_TAG;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getEventCode() {
		return EVENT_CODE;
	}

} //LostTagImpl