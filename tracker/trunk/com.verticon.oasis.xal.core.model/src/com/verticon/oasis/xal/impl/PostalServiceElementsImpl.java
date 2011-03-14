/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressIdentifier;
import com.verticon.oasis.xal.AddressLatitude;
import com.verticon.oasis.xal.AddressLatitudeDirection;
import com.verticon.oasis.xal.AddressLongitude;
import com.verticon.oasis.xal.AddressLongitudeDirection;
import com.verticon.oasis.xal.Barcode;
import com.verticon.oasis.xal.EndorsementLineCode;
import com.verticon.oasis.xal.KeyLineCode;
import com.verticon.oasis.xal.PostalServiceElements;
import com.verticon.oasis.xal.SortingCode;
import com.verticon.oasis.xal.SupplementaryPostalServiceData;
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
 * An implementation of the model object '<em><b>Postal Service Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAddressIdentifier <em>Address Identifier</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getEndorsementLineCode <em>Endorsement Line Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getKeyLineCode <em>Key Line Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getBarcode <em>Barcode</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getSortingCode <em>Sorting Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAddressLatitude <em>Address Latitude</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAddressLatitudeDirection <em>Address Latitude Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAddressLongitude <em>Address Longitude</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAddressLongitudeDirection <em>Address Longitude Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getSupplementaryPostalServiceData <em>Supplementary Postal Service Data</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PostalServiceElementsImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalServiceElementsImpl extends MinimalEObjectImpl.Container implements PostalServiceElements {
	/**
	 * The cached value of the '{@link #getAddressIdentifier() <em>Address Identifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressIdentifier()
	 * @generated
	 * @ordered
	 */
	protected EList<AddressIdentifier> addressIdentifier;

	/**
	 * The cached value of the '{@link #getEndorsementLineCode() <em>Endorsement Line Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndorsementLineCode()
	 * @generated
	 * @ordered
	 */
	protected EndorsementLineCode endorsementLineCode;

	/**
	 * The cached value of the '{@link #getKeyLineCode() <em>Key Line Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyLineCode()
	 * @generated
	 * @ordered
	 */
	protected KeyLineCode keyLineCode;

	/**
	 * The cached value of the '{@link #getBarcode() <em>Barcode</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBarcode()
	 * @generated
	 * @ordered
	 */
	protected Barcode barcode;

	/**
	 * The cached value of the '{@link #getSortingCode() <em>Sorting Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortingCode()
	 * @generated
	 * @ordered
	 */
	protected SortingCode sortingCode;

	/**
	 * The cached value of the '{@link #getAddressLatitude() <em>Address Latitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLatitude()
	 * @generated
	 * @ordered
	 */
	protected AddressLatitude addressLatitude;

	/**
	 * The cached value of the '{@link #getAddressLatitudeDirection() <em>Address Latitude Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLatitudeDirection()
	 * @generated
	 * @ordered
	 */
	protected AddressLatitudeDirection addressLatitudeDirection;

	/**
	 * The cached value of the '{@link #getAddressLongitude() <em>Address Longitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLongitude()
	 * @generated
	 * @ordered
	 */
	protected AddressLongitude addressLongitude;

	/**
	 * The cached value of the '{@link #getAddressLongitudeDirection() <em>Address Longitude Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLongitudeDirection()
	 * @generated
	 * @ordered
	 */
	protected AddressLongitudeDirection addressLongitudeDirection;

	/**
	 * The cached value of the '{@link #getSupplementaryPostalServiceData() <em>Supplementary Postal Service Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplementaryPostalServiceData()
	 * @generated
	 * @ordered
	 */
	protected EList<SupplementaryPostalServiceData> supplementaryPostalServiceData;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Object type = TYPE_EDEFAULT;

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
	protected PostalServiceElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPostalServiceElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressIdentifier> getAddressIdentifier() {
		if (addressIdentifier == null) {
			addressIdentifier = new EObjectContainmentEList<AddressIdentifier>(AddressIdentifier.class, this, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER);
		}
		return addressIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndorsementLineCode getEndorsementLineCode() {
		return endorsementLineCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndorsementLineCode(EndorsementLineCode newEndorsementLineCode, NotificationChain msgs) {
		EndorsementLineCode oldEndorsementLineCode = endorsementLineCode;
		endorsementLineCode = newEndorsementLineCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE, oldEndorsementLineCode, newEndorsementLineCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndorsementLineCode(EndorsementLineCode newEndorsementLineCode) {
		if (newEndorsementLineCode != endorsementLineCode) {
			NotificationChain msgs = null;
			if (endorsementLineCode != null)
				msgs = ((InternalEObject)endorsementLineCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE, null, msgs);
			if (newEndorsementLineCode != null)
				msgs = ((InternalEObject)newEndorsementLineCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE, null, msgs);
			msgs = basicSetEndorsementLineCode(newEndorsementLineCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE, newEndorsementLineCode, newEndorsementLineCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyLineCode getKeyLineCode() {
		return keyLineCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKeyLineCode(KeyLineCode newKeyLineCode, NotificationChain msgs) {
		KeyLineCode oldKeyLineCode = keyLineCode;
		keyLineCode = newKeyLineCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE, oldKeyLineCode, newKeyLineCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyLineCode(KeyLineCode newKeyLineCode) {
		if (newKeyLineCode != keyLineCode) {
			NotificationChain msgs = null;
			if (keyLineCode != null)
				msgs = ((InternalEObject)keyLineCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE, null, msgs);
			if (newKeyLineCode != null)
				msgs = ((InternalEObject)newKeyLineCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE, null, msgs);
			msgs = basicSetKeyLineCode(newKeyLineCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE, newKeyLineCode, newKeyLineCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Barcode getBarcode() {
		return barcode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBarcode(Barcode newBarcode, NotificationChain msgs) {
		Barcode oldBarcode = barcode;
		barcode = newBarcode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE, oldBarcode, newBarcode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBarcode(Barcode newBarcode) {
		if (newBarcode != barcode) {
			NotificationChain msgs = null;
			if (barcode != null)
				msgs = ((InternalEObject)barcode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE, null, msgs);
			if (newBarcode != null)
				msgs = ((InternalEObject)newBarcode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE, null, msgs);
			msgs = basicSetBarcode(newBarcode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE, newBarcode, newBarcode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortingCode getSortingCode() {
		return sortingCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSortingCode(SortingCode newSortingCode, NotificationChain msgs) {
		SortingCode oldSortingCode = sortingCode;
		sortingCode = newSortingCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE, oldSortingCode, newSortingCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortingCode(SortingCode newSortingCode) {
		if (newSortingCode != sortingCode) {
			NotificationChain msgs = null;
			if (sortingCode != null)
				msgs = ((InternalEObject)sortingCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE, null, msgs);
			if (newSortingCode != null)
				msgs = ((InternalEObject)newSortingCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE, null, msgs);
			msgs = basicSetSortingCode(newSortingCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE, newSortingCode, newSortingCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLatitude getAddressLatitude() {
		return addressLatitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressLatitude(AddressLatitude newAddressLatitude, NotificationChain msgs) {
		AddressLatitude oldAddressLatitude = addressLatitude;
		addressLatitude = newAddressLatitude;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE, oldAddressLatitude, newAddressLatitude);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressLatitude(AddressLatitude newAddressLatitude) {
		if (newAddressLatitude != addressLatitude) {
			NotificationChain msgs = null;
			if (addressLatitude != null)
				msgs = ((InternalEObject)addressLatitude).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE, null, msgs);
			if (newAddressLatitude != null)
				msgs = ((InternalEObject)newAddressLatitude).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE, null, msgs);
			msgs = basicSetAddressLatitude(newAddressLatitude, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE, newAddressLatitude, newAddressLatitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLatitudeDirection getAddressLatitudeDirection() {
		return addressLatitudeDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressLatitudeDirection(AddressLatitudeDirection newAddressLatitudeDirection, NotificationChain msgs) {
		AddressLatitudeDirection oldAddressLatitudeDirection = addressLatitudeDirection;
		addressLatitudeDirection = newAddressLatitudeDirection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION, oldAddressLatitudeDirection, newAddressLatitudeDirection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressLatitudeDirection(AddressLatitudeDirection newAddressLatitudeDirection) {
		if (newAddressLatitudeDirection != addressLatitudeDirection) {
			NotificationChain msgs = null;
			if (addressLatitudeDirection != null)
				msgs = ((InternalEObject)addressLatitudeDirection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION, null, msgs);
			if (newAddressLatitudeDirection != null)
				msgs = ((InternalEObject)newAddressLatitudeDirection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION, null, msgs);
			msgs = basicSetAddressLatitudeDirection(newAddressLatitudeDirection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION, newAddressLatitudeDirection, newAddressLatitudeDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLongitude getAddressLongitude() {
		return addressLongitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressLongitude(AddressLongitude newAddressLongitude, NotificationChain msgs) {
		AddressLongitude oldAddressLongitude = addressLongitude;
		addressLongitude = newAddressLongitude;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE, oldAddressLongitude, newAddressLongitude);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressLongitude(AddressLongitude newAddressLongitude) {
		if (newAddressLongitude != addressLongitude) {
			NotificationChain msgs = null;
			if (addressLongitude != null)
				msgs = ((InternalEObject)addressLongitude).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE, null, msgs);
			if (newAddressLongitude != null)
				msgs = ((InternalEObject)newAddressLongitude).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE, null, msgs);
			msgs = basicSetAddressLongitude(newAddressLongitude, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE, newAddressLongitude, newAddressLongitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLongitudeDirection getAddressLongitudeDirection() {
		return addressLongitudeDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressLongitudeDirection(AddressLongitudeDirection newAddressLongitudeDirection, NotificationChain msgs) {
		AddressLongitudeDirection oldAddressLongitudeDirection = addressLongitudeDirection;
		addressLongitudeDirection = newAddressLongitudeDirection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION, oldAddressLongitudeDirection, newAddressLongitudeDirection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressLongitudeDirection(AddressLongitudeDirection newAddressLongitudeDirection) {
		if (newAddressLongitudeDirection != addressLongitudeDirection) {
			NotificationChain msgs = null;
			if (addressLongitudeDirection != null)
				msgs = ((InternalEObject)addressLongitudeDirection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION, null, msgs);
			if (newAddressLongitudeDirection != null)
				msgs = ((InternalEObject)newAddressLongitudeDirection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION, null, msgs);
			msgs = basicSetAddressLongitudeDirection(newAddressLongitudeDirection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION, newAddressLongitudeDirection, newAddressLongitudeDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupplementaryPostalServiceData> getSupplementaryPostalServiceData() {
		if (supplementaryPostalServiceData == null) {
			supplementaryPostalServiceData = new EObjectContainmentEList<SupplementaryPostalServiceData>(SupplementaryPostalServiceData.class, this, XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA);
		}
		return supplementaryPostalServiceData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.POSTAL_SERVICE_ELEMENTS__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Object newType) {
		Object oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.POSTAL_SERVICE_ELEMENTS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE);
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
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER:
				return ((InternalEList<?>)getAddressIdentifier()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE:
				return basicSetEndorsementLineCode(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE:
				return basicSetKeyLineCode(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE:
				return basicSetBarcode(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE:
				return basicSetSortingCode(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE:
				return basicSetAddressLatitude(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION:
				return basicSetAddressLatitudeDirection(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE:
				return basicSetAddressLongitude(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION:
				return basicSetAddressLongitudeDirection(null, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA:
				return ((InternalEList<?>)getSupplementaryPostalServiceData()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER:
				return getAddressIdentifier();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE:
				return getEndorsementLineCode();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE:
				return getKeyLineCode();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE:
				return getBarcode();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE:
				return getSortingCode();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE:
				return getAddressLatitude();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION:
				return getAddressLatitudeDirection();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE:
				return getAddressLongitude();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION:
				return getAddressLongitudeDirection();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA:
				return getSupplementaryPostalServiceData();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__TYPE:
				return getType();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER:
				getAddressIdentifier().clear();
				getAddressIdentifier().addAll((Collection<? extends AddressIdentifier>)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE:
				setEndorsementLineCode((EndorsementLineCode)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE:
				setKeyLineCode((KeyLineCode)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE:
				setBarcode((Barcode)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE:
				setSortingCode((SortingCode)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE:
				setAddressLatitude((AddressLatitude)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION:
				setAddressLatitudeDirection((AddressLatitudeDirection)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE:
				setAddressLongitude((AddressLongitude)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION:
				setAddressLongitudeDirection((AddressLongitudeDirection)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA:
				getSupplementaryPostalServiceData().clear();
				getSupplementaryPostalServiceData().addAll((Collection<? extends SupplementaryPostalServiceData>)newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__TYPE:
				setType(newValue);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER:
				getAddressIdentifier().clear();
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE:
				setEndorsementLineCode((EndorsementLineCode)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE:
				setKeyLineCode((KeyLineCode)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE:
				setBarcode((Barcode)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE:
				setSortingCode((SortingCode)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE:
				setAddressLatitude((AddressLatitude)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION:
				setAddressLatitudeDirection((AddressLatitudeDirection)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE:
				setAddressLongitude((AddressLongitude)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION:
				setAddressLongitudeDirection((AddressLongitudeDirection)null);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA:
				getSupplementaryPostalServiceData().clear();
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY:
				getAny().clear();
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE:
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
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_IDENTIFIER:
				return addressIdentifier != null && !addressIdentifier.isEmpty();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ENDORSEMENT_LINE_CODE:
				return endorsementLineCode != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__KEY_LINE_CODE:
				return keyLineCode != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__BARCODE:
				return barcode != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SORTING_CODE:
				return sortingCode != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE:
				return addressLatitude != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LATITUDE_DIRECTION:
				return addressLatitudeDirection != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE:
				return addressLongitude != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ADDRESS_LONGITUDE_DIRECTION:
				return addressLongitudeDirection != null;
			case XalPackage.POSTAL_SERVICE_ELEMENTS__SUPPLEMENTARY_POSTAL_SERVICE_DATA:
				return supplementaryPostalServiceData != null && !supplementaryPostalServiceData.isEmpty();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.POSTAL_SERVICE_ELEMENTS__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.POSTAL_SERVICE_ELEMENTS__ANY_ATTRIBUTE:
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
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //PostalServiceElementsImpl
