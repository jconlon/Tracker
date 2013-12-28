/**
 */
package org.usaha.ecvi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.usaha.ecvi.Accession;
import org.usaha.ecvi.Accessions;
import org.usaha.ecvi.EcviPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accessions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.AccessionsImpl#getAccession <em>Accession</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessionsImpl extends MinimalEObjectImpl.Container implements Accessions {
	/**
	 * The cached value of the '{@link #getAccession() <em>Accession</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccession()
	 * @generated
	 * @ordered
	 */
	protected EList<Accession> accession;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.ACCESSIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Accession> getAccession() {
		if (accession == null) {
			accession = new EObjectContainmentEList<Accession>(Accession.class, this, EcviPackage.ACCESSIONS__ACCESSION);
		}
		return accession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.ACCESSIONS__ACCESSION:
				return ((InternalEList<?>)getAccession()).basicRemove(otherEnd, msgs);
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
			case EcviPackage.ACCESSIONS__ACCESSION:
				return getAccession();
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
			case EcviPackage.ACCESSIONS__ACCESSION:
				getAccession().clear();
				getAccession().addAll((Collection<? extends Accession>)newValue);
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
			case EcviPackage.ACCESSIONS__ACCESSION:
				getAccession().clear();
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
			case EcviPackage.ACCESSIONS__ACCESSION:
				return accession != null && !accession.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AccessionsImpl
