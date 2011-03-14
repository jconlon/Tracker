/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.Option;
import com.verticon.google.kmlgx.ViewerOptions;
import com.verticon.opengis.kml.impl.AbstractObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Viewer Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.ViewerOptionsImpl#getOption <em>Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewerOptionsImpl extends AbstractObjectImpl implements ViewerOptions {
	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> option;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewerOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.VIEWER_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOption() {
		if (option == null) {
			option = new EObjectContainmentEList<Option>(Option.class, this, KmlgxPackage.VIEWER_OPTIONS__OPTION);
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.VIEWER_OPTIONS__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
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
			case KmlgxPackage.VIEWER_OPTIONS__OPTION:
				return getOption();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmlgxPackage.VIEWER_OPTIONS__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends Option>)newValue);
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
			case KmlgxPackage.VIEWER_OPTIONS__OPTION:
				getOption().clear();
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
			case KmlgxPackage.VIEWER_OPTIONS__OPTION:
				return option != null && !option.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewerOptionsImpl
