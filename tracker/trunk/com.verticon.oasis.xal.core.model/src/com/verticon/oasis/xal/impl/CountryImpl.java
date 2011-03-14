/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.AdministrativeArea;
import com.verticon.oasis.xal.Country;
import com.verticon.oasis.xal.CountryName;
import com.verticon.oasis.xal.CountryNameCode;
import com.verticon.oasis.xal.Locality;
import com.verticon.oasis.xal.Thoroughfare;
import com.verticon.oasis.xal.XalPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getCountryNameCode <em>Country Name Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getCountryName <em>Country Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getAdministrativeArea <em>Administrative Area</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getLocality <em>Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.CountryImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CountryImpl extends MinimalEObjectImpl.Container implements Country {
	/**
	 * The cached value of the '{@link #getAddressLine() <em>Address Line</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLine()
	 * @generated
	 * @ordered
	 */
	protected EList<AddressLine> addressLine;

	/**
	 * The cached value of the '{@link #getCountryNameCode() <em>Country Name Code</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountryNameCode()
	 * @generated
	 * @ordered
	 */
	protected EList<CountryNameCode> countryNameCode;

	/**
	 * The cached value of the '{@link #getCountryName() <em>Country Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountryName()
	 * @generated
	 * @ordered
	 */
	protected EList<CountryName> countryName;

	/**
	 * The cached value of the '{@link #getAdministrativeArea() <em>Administrative Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdministrativeArea()
	 * @generated
	 * @ordered
	 */
	protected AdministrativeArea administrativeArea;

	/**
	 * The cached value of the '{@link #getLocality() <em>Locality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocality()
	 * @generated
	 * @ordered
	 */
	protected Locality locality;

	/**
	 * The cached value of the '{@link #getThoroughfare() <em>Thoroughfare</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThoroughfare()
	 * @generated
	 * @ordered
	 */
	protected Thoroughfare thoroughfare;

	/**
	 * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAny()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap any;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getCountry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.COUNTRY__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CountryNameCode> getCountryNameCode() {
		if (countryNameCode == null) {
			countryNameCode = new EObjectContainmentEList<CountryNameCode>(CountryNameCode.class, this, XalPackage.COUNTRY__COUNTRY_NAME_CODE);
		}
		return countryNameCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CountryName> getCountryName() {
		if (countryName == null) {
			countryName = new EObjectContainmentEList<CountryName>(CountryName.class, this, XalPackage.COUNTRY__COUNTRY_NAME);
		}
		return countryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdministrativeArea getAdministrativeArea() {
		return administrativeArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdministrativeArea(AdministrativeArea newAdministrativeArea, NotificationChain msgs) {
		AdministrativeArea oldAdministrativeArea = administrativeArea;
		administrativeArea = newAdministrativeArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__ADMINISTRATIVE_AREA, oldAdministrativeArea, newAdministrativeArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministrativeArea(AdministrativeArea newAdministrativeArea) {
		if (newAdministrativeArea != administrativeArea) {
			NotificationChain msgs = null;
			if (administrativeArea != null)
				msgs = ((InternalEObject)administrativeArea).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__ADMINISTRATIVE_AREA, null, msgs);
			if (newAdministrativeArea != null)
				msgs = ((InternalEObject)newAdministrativeArea).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__ADMINISTRATIVE_AREA, null, msgs);
			msgs = basicSetAdministrativeArea(newAdministrativeArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__ADMINISTRATIVE_AREA, newAdministrativeArea, newAdministrativeArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locality getLocality() {
		return locality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocality(Locality newLocality, NotificationChain msgs) {
		Locality oldLocality = locality;
		locality = newLocality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__LOCALITY, oldLocality, newLocality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocality(Locality newLocality) {
		if (newLocality != locality) {
			NotificationChain msgs = null;
			if (locality != null)
				msgs = ((InternalEObject)locality).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__LOCALITY, null, msgs);
			if (newLocality != null)
				msgs = ((InternalEObject)newLocality).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__LOCALITY, null, msgs);
			msgs = basicSetLocality(newLocality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__LOCALITY, newLocality, newLocality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Thoroughfare getThoroughfare() {
		return thoroughfare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfare(Thoroughfare newThoroughfare, NotificationChain msgs) {
		Thoroughfare oldThoroughfare = thoroughfare;
		thoroughfare = newThoroughfare;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__THOROUGHFARE, oldThoroughfare, newThoroughfare);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfare(Thoroughfare newThoroughfare) {
		if (newThoroughfare != thoroughfare) {
			NotificationChain msgs = null;
			if (thoroughfare != null)
				msgs = ((InternalEObject)thoroughfare).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__THOROUGHFARE, null, msgs);
			if (newThoroughfare != null)
				msgs = ((InternalEObject)newThoroughfare).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.COUNTRY__THOROUGHFARE, null, msgs);
			msgs = basicSetThoroughfare(newThoroughfare, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.COUNTRY__THOROUGHFARE, newThoroughfare, newThoroughfare));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.COUNTRY__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.COUNTRY__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XalPackage.COUNTRY__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.COUNTRY__COUNTRY_NAME_CODE:
				return ((InternalEList<?>)getCountryNameCode()).basicRemove(otherEnd, msgs);
			case XalPackage.COUNTRY__COUNTRY_NAME:
				return ((InternalEList<?>)getCountryName()).basicRemove(otherEnd, msgs);
			case XalPackage.COUNTRY__ADMINISTRATIVE_AREA:
				return basicSetAdministrativeArea(null, msgs);
			case XalPackage.COUNTRY__LOCALITY:
				return basicSetLocality(null, msgs);
			case XalPackage.COUNTRY__THOROUGHFARE:
				return basicSetThoroughfare(null, msgs);
			case XalPackage.COUNTRY__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.COUNTRY__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case XalPackage.COUNTRY__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.COUNTRY__COUNTRY_NAME_CODE:
				return getCountryNameCode();
			case XalPackage.COUNTRY__COUNTRY_NAME:
				return getCountryName();
			case XalPackage.COUNTRY__ADMINISTRATIVE_AREA:
				return getAdministrativeArea();
			case XalPackage.COUNTRY__LOCALITY:
				return getLocality();
			case XalPackage.COUNTRY__THOROUGHFARE:
				return getThoroughfare();
			case XalPackage.COUNTRY__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.COUNTRY__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case XalPackage.COUNTRY__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.COUNTRY__COUNTRY_NAME_CODE:
				getCountryNameCode().clear();
				getCountryNameCode().addAll((Collection<? extends CountryNameCode>)newValue);
				return;
			case XalPackage.COUNTRY__COUNTRY_NAME:
				getCountryName().clear();
				getCountryName().addAll((Collection<? extends CountryName>)newValue);
				return;
			case XalPackage.COUNTRY__ADMINISTRATIVE_AREA:
				setAdministrativeArea((AdministrativeArea)newValue);
				return;
			case XalPackage.COUNTRY__LOCALITY:
				setLocality((Locality)newValue);
				return;
			case XalPackage.COUNTRY__THOROUGHFARE:
				setThoroughfare((Thoroughfare)newValue);
				return;
			case XalPackage.COUNTRY__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.COUNTRY__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case XalPackage.COUNTRY__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.COUNTRY__COUNTRY_NAME_CODE:
				getCountryNameCode().clear();
				return;
			case XalPackage.COUNTRY__COUNTRY_NAME:
				getCountryName().clear();
				return;
			case XalPackage.COUNTRY__ADMINISTRATIVE_AREA:
				setAdministrativeArea((AdministrativeArea)null);
				return;
			case XalPackage.COUNTRY__LOCALITY:
				setLocality((Locality)null);
				return;
			case XalPackage.COUNTRY__THOROUGHFARE:
				setThoroughfare((Thoroughfare)null);
				return;
			case XalPackage.COUNTRY__ANY:
				getAny().clear();
				return;
			case XalPackage.COUNTRY__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case XalPackage.COUNTRY__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.COUNTRY__COUNTRY_NAME_CODE:
				return countryNameCode != null && !countryNameCode.isEmpty();
			case XalPackage.COUNTRY__COUNTRY_NAME:
				return countryName != null && !countryName.isEmpty();
			case XalPackage.COUNTRY__ADMINISTRATIVE_AREA:
				return administrativeArea != null;
			case XalPackage.COUNTRY__LOCALITY:
				return locality != null;
			case XalPackage.COUNTRY__THOROUGHFARE:
				return thoroughfare != null;
			case XalPackage.COUNTRY__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.COUNTRY__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (any: ");
		result.append(any);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //CountryImpl
