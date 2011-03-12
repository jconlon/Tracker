/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink.impl;

import com.verticon.atom.authorlink.AtomRoot;
import com.verticon.atom.authorlink.Author;
import com.verticon.atom.authorlink.AuthorlinkPackage;
import com.verticon.atom.authorlink.Link;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atom Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getLink <em>Link</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.atom.authorlink.impl.AtomRootImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomRootImpl extends MinimalEObjectImpl.Container implements AtomRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuthorlinkPackage.Literals.ATOM_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, AuthorlinkPackage.ATOM_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author getAuthor() {
		return (Author)getMixed().get(AuthorlinkPackage.Literals.ATOM_ROOT__AUTHOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthor(Author newAuthor, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AuthorlinkPackage.Literals.ATOM_ROOT__AUTHOR, newAuthor, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(Author newAuthor) {
		((FeatureMap.Internal)getMixed()).set(AuthorlinkPackage.Literals.ATOM_ROOT__AUTHOR, newAuthor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return (String)getMixed().get(AuthorlinkPackage.Literals.ATOM_ROOT__EMAIL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		((FeatureMap.Internal)getMixed()).set(AuthorlinkPackage.Literals.ATOM_ROOT__EMAIL, newEmail);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getLink() {
		return (Link)getMixed().get(AuthorlinkPackage.Literals.ATOM_ROOT__LINK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(Link newLink, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AuthorlinkPackage.Literals.ATOM_ROOT__LINK, newLink, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(Link newLink) {
		((FeatureMap.Internal)getMixed()).set(AuthorlinkPackage.Literals.ATOM_ROOT__LINK, newLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)getMixed().get(AuthorlinkPackage.Literals.ATOM_ROOT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		((FeatureMap.Internal)getMixed()).set(AuthorlinkPackage.Literals.ATOM_ROOT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return (String)getMixed().get(AuthorlinkPackage.Literals.ATOM_ROOT__URI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		((FeatureMap.Internal)getMixed()).set(AuthorlinkPackage.Literals.ATOM_ROOT__URI, newUri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AuthorlinkPackage.ATOM_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case AuthorlinkPackage.ATOM_ROOT__AUTHOR:
				return basicSetAuthor(null, msgs);
			case AuthorlinkPackage.ATOM_ROOT__LINK:
				return basicSetLink(null, msgs);
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
			case AuthorlinkPackage.ATOM_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case AuthorlinkPackage.ATOM_ROOT__AUTHOR:
				return getAuthor();
			case AuthorlinkPackage.ATOM_ROOT__EMAIL:
				return getEmail();
			case AuthorlinkPackage.ATOM_ROOT__LINK:
				return getLink();
			case AuthorlinkPackage.ATOM_ROOT__NAME:
				return getName();
			case AuthorlinkPackage.ATOM_ROOT__URI:
				return getUri();
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
			case AuthorlinkPackage.ATOM_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__AUTHOR:
				setAuthor((Author)newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__EMAIL:
				setEmail((String)newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__LINK:
				setLink((Link)newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__NAME:
				setName((String)newValue);
				return;
			case AuthorlinkPackage.ATOM_ROOT__URI:
				setUri((String)newValue);
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
			case AuthorlinkPackage.ATOM_ROOT__MIXED:
				getMixed().clear();
				return;
			case AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case AuthorlinkPackage.ATOM_ROOT__AUTHOR:
				setAuthor((Author)null);
				return;
			case AuthorlinkPackage.ATOM_ROOT__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case AuthorlinkPackage.ATOM_ROOT__LINK:
				setLink((Link)null);
				return;
			case AuthorlinkPackage.ATOM_ROOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AuthorlinkPackage.ATOM_ROOT__URI:
				setUri(URI_EDEFAULT);
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
			case AuthorlinkPackage.ATOM_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case AuthorlinkPackage.ATOM_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case AuthorlinkPackage.ATOM_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case AuthorlinkPackage.ATOM_ROOT__AUTHOR:
				return getAuthor() != null;
			case AuthorlinkPackage.ATOM_ROOT__EMAIL:
				return EMAIL_EDEFAULT == null ? getEmail() != null : !EMAIL_EDEFAULT.equals(getEmail());
			case AuthorlinkPackage.ATOM_ROOT__LINK:
				return getLink() != null;
			case AuthorlinkPackage.ATOM_ROOT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case AuthorlinkPackage.ATOM_ROOT__URI:
				return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //AtomRootImpl
