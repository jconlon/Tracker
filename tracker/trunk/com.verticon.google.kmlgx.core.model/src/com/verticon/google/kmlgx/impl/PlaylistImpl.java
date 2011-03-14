/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.Playlist;
import com.verticon.google.kmlgx.TourPrimitive;
import com.verticon.opengis.kml.impl.AbstractObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.PlaylistImpl#getAbstractTourPrimitiveGroupGroup <em>Abstract Tour Primitive Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.PlaylistImpl#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaylistImpl extends AbstractObjectImpl implements Playlist {
	/**
	 * The cached value of the '{@link #getAbstractTourPrimitiveGroupGroup() <em>Abstract Tour Primitive Group Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractTourPrimitiveGroupGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap abstractTourPrimitiveGroupGroup;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaylistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.PLAYLIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAbstractTourPrimitiveGroupGroup() {
		if (abstractTourPrimitiveGroupGroup == null) {
			abstractTourPrimitiveGroupGroup = new BasicFeatureMap(this, KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP);
		}
		return abstractTourPrimitiveGroupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TourPrimitive> getAbstractTourPrimitiveGroup() {
		return getAbstractTourPrimitiveGroupGroup().list(KmlgxPackage.Literals.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP:
				return ((InternalEList<?>)getAbstractTourPrimitiveGroupGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return ((InternalEList<?>)getAbstractTourPrimitiveGroup()).basicRemove(otherEnd, msgs);
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
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP:
				if (coreType) return getAbstractTourPrimitiveGroupGroup();
				return ((FeatureMap.Internal)getAbstractTourPrimitiveGroupGroup()).getWrapper();
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return getAbstractTourPrimitiveGroup();
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
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP:
				((FeatureMap.Internal)getAbstractTourPrimitiveGroupGroup()).set(newValue);
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
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP:
				getAbstractTourPrimitiveGroupGroup().clear();
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
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP:
				return abstractTourPrimitiveGroupGroup != null && !abstractTourPrimitiveGroupGroup.isEmpty();
			case KmlgxPackage.PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return !getAbstractTourPrimitiveGroup().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (abstractTourPrimitiveGroupGroup: ");
		result.append(abstractTourPrimitiveGroupGroup);
		result.append(')');
		return result.toString();
	}

} //PlaylistImpl
