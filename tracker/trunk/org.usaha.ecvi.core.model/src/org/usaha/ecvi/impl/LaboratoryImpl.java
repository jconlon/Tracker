/**
 */
package org.usaha.ecvi.impl;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.Address;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Laboratory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Laboratory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.LaboratoryImpl#getLabName <em>Lab Name</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.LaboratoryImpl#getPremId <em>Prem Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.LaboratoryImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.LaboratoryImpl#getAccessionDate <em>Accession Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.LaboratoryImpl#getAccessionNumber <em>Accession Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaboratoryImpl extends MinimalEObjectImpl.Container implements Laboratory {
	/**
	 * The default value of the '{@link #getLabName() <em>Lab Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAB_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabName() <em>Lab Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabName()
	 * @generated
	 * @ordered
	 */
	protected String labName = LAB_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPremId() <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremId()
	 * @generated
	 * @ordered
	 */
	protected static final String PREM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremId() <em>Prem Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremId()
	 * @generated
	 * @ordered
	 */
	protected String premId = PREM_ID_EDEFAULT;

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
	 * The default value of the '{@link #getAccessionDate() <em>Accession Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessionDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar ACCESSION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessionDate() <em>Accession Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessionDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar accessionDate = ACCESSION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccessionNumber() <em>Accession Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessionNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCESSION_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessionNumber() <em>Accession Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessionNumber()
	 * @generated
	 * @ordered
	 */
	protected String accessionNumber = ACCESSION_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaboratoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.LABORATORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabName() {
		return labName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabName(String newLabName) {
		String oldLabName = labName;
		labName = newLabName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__LAB_NAME, oldLabName, labName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPremId() {
		return premId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremId(String newPremId) {
		String oldPremId = premId;
		premId = newPremId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__PREM_ID, oldPremId, premId));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__ADDRESS, oldAddress, newAddress);
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
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.LABORATORY__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.LABORATORY__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getAccessionDate() {
		return accessionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessionDate(XMLGregorianCalendar newAccessionDate) {
		XMLGregorianCalendar oldAccessionDate = accessionDate;
		accessionDate = newAccessionDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__ACCESSION_DATE, oldAccessionDate, accessionDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccessionNumber() {
		return accessionNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessionNumber(String newAccessionNumber) {
		String oldAccessionNumber = accessionNumber;
		accessionNumber = newAccessionNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.LABORATORY__ACCESSION_NUMBER, oldAccessionNumber, accessionNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.LABORATORY__ADDRESS:
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
			case EcviPackage.LABORATORY__LAB_NAME:
				return getLabName();
			case EcviPackage.LABORATORY__PREM_ID:
				return getPremId();
			case EcviPackage.LABORATORY__ADDRESS:
				return getAddress();
			case EcviPackage.LABORATORY__ACCESSION_DATE:
				return getAccessionDate();
			case EcviPackage.LABORATORY__ACCESSION_NUMBER:
				return getAccessionNumber();
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
			case EcviPackage.LABORATORY__LAB_NAME:
				setLabName((String)newValue);
				return;
			case EcviPackage.LABORATORY__PREM_ID:
				setPremId((String)newValue);
				return;
			case EcviPackage.LABORATORY__ADDRESS:
				setAddress((Address)newValue);
				return;
			case EcviPackage.LABORATORY__ACCESSION_DATE:
				setAccessionDate((XMLGregorianCalendar)newValue);
				return;
			case EcviPackage.LABORATORY__ACCESSION_NUMBER:
				setAccessionNumber((String)newValue);
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
			case EcviPackage.LABORATORY__LAB_NAME:
				setLabName(LAB_NAME_EDEFAULT);
				return;
			case EcviPackage.LABORATORY__PREM_ID:
				setPremId(PREM_ID_EDEFAULT);
				return;
			case EcviPackage.LABORATORY__ADDRESS:
				setAddress((Address)null);
				return;
			case EcviPackage.LABORATORY__ACCESSION_DATE:
				setAccessionDate(ACCESSION_DATE_EDEFAULT);
				return;
			case EcviPackage.LABORATORY__ACCESSION_NUMBER:
				setAccessionNumber(ACCESSION_NUMBER_EDEFAULT);
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
			case EcviPackage.LABORATORY__LAB_NAME:
				return LAB_NAME_EDEFAULT == null ? labName != null : !LAB_NAME_EDEFAULT.equals(labName);
			case EcviPackage.LABORATORY__PREM_ID:
				return PREM_ID_EDEFAULT == null ? premId != null : !PREM_ID_EDEFAULT.equals(premId);
			case EcviPackage.LABORATORY__ADDRESS:
				return address != null;
			case EcviPackage.LABORATORY__ACCESSION_DATE:
				return ACCESSION_DATE_EDEFAULT == null ? accessionDate != null : !ACCESSION_DATE_EDEFAULT.equals(accessionDate);
			case EcviPackage.LABORATORY__ACCESSION_NUMBER:
				return ACCESSION_NUMBER_EDEFAULT == null ? accessionNumber != null : !ACCESSION_NUMBER_EDEFAULT.equals(accessionNumber);
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
		result.append(" (labName: ");
		result.append(labName);
		result.append(", premId: ");
		result.append(premId);
		result.append(", accessionDate: ");
		result.append(accessionDate);
		result.append(", accessionNumber: ");
		result.append(accessionNumber);
		result.append(')');
		return result.toString();
	}

} //LaboratoryImpl
