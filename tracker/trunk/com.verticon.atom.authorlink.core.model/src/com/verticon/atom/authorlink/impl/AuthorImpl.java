/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink.impl;

import com.verticon.atom.authorlink.Author;
import com.verticon.atom.authorlink.AuthorlinkPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.atom.authorlink.impl.AuthorImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AuthorImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AuthorImpl#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthorImpl extends MinimalEObjectImpl.Container implements Author {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuthorlinkPackage.Literals.AUTHOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, AuthorlinkPackage.AUTHOR__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getName() {
		return getGroup().list(AuthorlinkPackage.Literals.AUTHOR__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUri() {
		return getGroup().list(AuthorlinkPackage.Literals.AUTHOR__URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEmail() {
		return getGroup().list(AuthorlinkPackage.Literals.AUTHOR__EMAIL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AuthorlinkPackage.AUTHOR__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
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
			case AuthorlinkPackage.AUTHOR__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case AuthorlinkPackage.AUTHOR__NAME:
				return getName();
			case AuthorlinkPackage.AUTHOR__URI:
				return getUri();
			case AuthorlinkPackage.AUTHOR__EMAIL:
				return getEmail();
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
			case AuthorlinkPackage.AUTHOR__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case AuthorlinkPackage.AUTHOR__NAME:
				getName().clear();
				getName().addAll((Collection<? extends String>)newValue);
				return;
			case AuthorlinkPackage.AUTHOR__URI:
				getUri().clear();
				getUri().addAll((Collection<? extends String>)newValue);
				return;
			case AuthorlinkPackage.AUTHOR__EMAIL:
				getEmail().clear();
				getEmail().addAll((Collection<? extends String>)newValue);
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
			case AuthorlinkPackage.AUTHOR__GROUP:
				getGroup().clear();
				return;
			case AuthorlinkPackage.AUTHOR__NAME:
				getName().clear();
				return;
			case AuthorlinkPackage.AUTHOR__URI:
				getUri().clear();
				return;
			case AuthorlinkPackage.AUTHOR__EMAIL:
				getEmail().clear();
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
			case AuthorlinkPackage.AUTHOR__GROUP:
				return group != null && !group.isEmpty();
			case AuthorlinkPackage.AUTHOR__NAME:
				return !getName().isEmpty();
			case AuthorlinkPackage.AUTHOR__URI:
				return !getUri().isEmpty();
			case AuthorlinkPackage.AUTHOR__EMAIL:
				return !getEmail().isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //AuthorImpl
