/**
 */
package org.usaha.ecvi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.Address;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Person;
import org.usaha.ecvi.UsState;
import org.usaha.ecvi.Veterinarian;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Veterinarian</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.VeterinarianImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.VeterinarianImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.VeterinarianImpl#getLicenseIssueState <em>License Issue State</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.VeterinarianImpl#getLicenseNumber <em>License Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.VeterinarianImpl#getNationalAccreditationNumber <em>National Accreditation Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VeterinarianImpl extends MinimalEObjectImpl.Container implements Veterinarian {
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected Person person;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected Address address;

	/**
	 * The default value of the '{@link #getLicenseIssueState() <em>License Issue State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseIssueState()
	 * @generated
	 * @ordered
	 */
	protected static final UsState LICENSE_ISSUE_STATE_EDEFAULT = UsState.AA;

	/**
	 * The cached value of the '{@link #getLicenseIssueState() <em>License Issue State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseIssueState()
	 * @generated
	 * @ordered
	 */
	protected UsState licenseIssueState = LICENSE_ISSUE_STATE_EDEFAULT;

	/**
	 * This is true if the License Issue State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean licenseIssueStateESet;

	/**
	 * The default value of the '{@link #getLicenseNumber() <em>License Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicenseNumber() <em>License Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicenseNumber()
	 * @generated
	 * @ordered
	 */
	protected String licenseNumber = LICENSE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNationalAccreditationNumber() <em>National Accreditation Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalAccreditationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NATIONAL_ACCREDITATION_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNationalAccreditationNumber() <em>National Accreditation Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalAccreditationNumber()
	 * @generated
	 * @ordered
	 */
	protected String nationalAccreditationNumber = NATIONAL_ACCREDITATION_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VeterinarianImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.VETERINARIAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerson(Person newPerson, NotificationChain msgs) {
		Person oldPerson = person;
		person = newPerson;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__PERSON, oldPerson, newPerson);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(Person newPerson) {
		if (newPerson != person) {
			NotificationChain msgs = null;
			if (person != null)
				msgs = ((InternalEObject)person).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.VETERINARIAN__PERSON, null, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.VETERINARIAN__PERSON, null, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.VETERINARIAN__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.VETERINARIAN__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsState getLicenseIssueState() {
		return licenseIssueState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenseIssueState(UsState newLicenseIssueState) {
		UsState oldLicenseIssueState = licenseIssueState;
		licenseIssueState = newLicenseIssueState == null ? LICENSE_ISSUE_STATE_EDEFAULT : newLicenseIssueState;
		boolean oldLicenseIssueStateESet = licenseIssueStateESet;
		licenseIssueStateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE, oldLicenseIssueState, licenseIssueState, !oldLicenseIssueStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLicenseIssueState() {
		UsState oldLicenseIssueState = licenseIssueState;
		boolean oldLicenseIssueStateESet = licenseIssueStateESet;
		licenseIssueState = LICENSE_ISSUE_STATE_EDEFAULT;
		licenseIssueStateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE, oldLicenseIssueState, LICENSE_ISSUE_STATE_EDEFAULT, oldLicenseIssueStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLicenseIssueState() {
		return licenseIssueStateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicenseNumber(String newLicenseNumber) {
		String oldLicenseNumber = licenseNumber;
		licenseNumber = newLicenseNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__LICENSE_NUMBER, oldLicenseNumber, licenseNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNationalAccreditationNumber() {
		return nationalAccreditationNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNationalAccreditationNumber(String newNationalAccreditationNumber) {
		String oldNationalAccreditationNumber = nationalAccreditationNumber;
		nationalAccreditationNumber = newNationalAccreditationNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER, oldNationalAccreditationNumber, nationalAccreditationNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.VETERINARIAN__PERSON:
				return basicSetPerson(null, msgs);
			case EcviPackage.VETERINARIAN__ADDRESS:
				return basicSetAddress(null, msgs);
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
			case EcviPackage.VETERINARIAN__PERSON:
				return getPerson();
			case EcviPackage.VETERINARIAN__ADDRESS:
				return getAddress();
			case EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE:
				return getLicenseIssueState();
			case EcviPackage.VETERINARIAN__LICENSE_NUMBER:
				return getLicenseNumber();
			case EcviPackage.VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER:
				return getNationalAccreditationNumber();
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
			case EcviPackage.VETERINARIAN__PERSON:
				setPerson((Person)newValue);
				return;
			case EcviPackage.VETERINARIAN__ADDRESS:
				setAddress((Address)newValue);
				return;
			case EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE:
				setLicenseIssueState((UsState)newValue);
				return;
			case EcviPackage.VETERINARIAN__LICENSE_NUMBER:
				setLicenseNumber((String)newValue);
				return;
			case EcviPackage.VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER:
				setNationalAccreditationNumber((String)newValue);
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
			case EcviPackage.VETERINARIAN__PERSON:
				setPerson((Person)null);
				return;
			case EcviPackage.VETERINARIAN__ADDRESS:
				setAddress((Address)null);
				return;
			case EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE:
				unsetLicenseIssueState();
				return;
			case EcviPackage.VETERINARIAN__LICENSE_NUMBER:
				setLicenseNumber(LICENSE_NUMBER_EDEFAULT);
				return;
			case EcviPackage.VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER:
				setNationalAccreditationNumber(NATIONAL_ACCREDITATION_NUMBER_EDEFAULT);
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
			case EcviPackage.VETERINARIAN__PERSON:
				return person != null;
			case EcviPackage.VETERINARIAN__ADDRESS:
				return address != null;
			case EcviPackage.VETERINARIAN__LICENSE_ISSUE_STATE:
				return isSetLicenseIssueState();
			case EcviPackage.VETERINARIAN__LICENSE_NUMBER:
				return LICENSE_NUMBER_EDEFAULT == null ? licenseNumber != null : !LICENSE_NUMBER_EDEFAULT.equals(licenseNumber);
			case EcviPackage.VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER:
				return NATIONAL_ACCREDITATION_NUMBER_EDEFAULT == null ? nationalAccreditationNumber != null : !NATIONAL_ACCREDITATION_NUMBER_EDEFAULT.equals(nationalAccreditationNumber);
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
		result.append(" (licenseIssueState: ");
		if (licenseIssueStateESet) result.append(licenseIssueState); else result.append("<unset>");
		result.append(", licenseNumber: ");
		result.append(licenseNumber);
		result.append(", nationalAccreditationNumber: ");
		result.append(nationalAccreditationNumber);
		result.append(')');
		return result.toString();
	}

} //VeterinarianImpl
