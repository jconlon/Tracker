/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.BuildingName;
import com.verticon.oasis.xal.Department;
import com.verticon.oasis.xal.LargeMailUser;
import com.verticon.oasis.xal.LargeMailUserIdentifier;
import com.verticon.oasis.xal.LargeMailUserName;
import com.verticon.oasis.xal.PostBox;
import com.verticon.oasis.xal.PostalCode;
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
 * An implementation of the model object '<em><b>Large Mail User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getLargeMailUserName <em>Large Mail User Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getLargeMailUserIdentifier <em>Large Mail User Identifier</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getBuildingName <em>Building Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LargeMailUserImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LargeMailUserImpl extends MinimalEObjectImpl.Container implements LargeMailUser {
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
	 * The cached value of the '{@link #getLargeMailUserName() <em>Large Mail User Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeMailUserName()
	 * @generated
	 * @ordered
	 */
	protected EList<LargeMailUserName> largeMailUserName;

	/**
	 * The cached value of the '{@link #getLargeMailUserIdentifier() <em>Large Mail User Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 * @ordered
	 */
	protected LargeMailUserIdentifier largeMailUserIdentifier;

	/**
	 * The cached value of the '{@link #getBuildingName() <em>Building Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildingName()
	 * @generated
	 * @ordered
	 */
	protected EList<BuildingName> buildingName;

	/**
	 * The cached value of the '{@link #getDepartment() <em>Department</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment()
	 * @generated
	 * @ordered
	 */
	protected Department department;

	/**
	 * The cached value of the '{@link #getPostBox() <em>Post Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostBox()
	 * @generated
	 * @ordered
	 */
	protected PostBox postBox;

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
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected PostalCode postalCode;

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
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

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
	protected LargeMailUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getLargeMailUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.LARGE_MAIL_USER__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LargeMailUserName> getLargeMailUserName() {
		if (largeMailUserName == null) {
			largeMailUserName = new EObjectContainmentEList<LargeMailUserName>(LargeMailUserName.class, this, XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME);
		}
		return largeMailUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LargeMailUserIdentifier getLargeMailUserIdentifier() {
		return largeMailUserIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLargeMailUserIdentifier(LargeMailUserIdentifier newLargeMailUserIdentifier, NotificationChain msgs) {
		LargeMailUserIdentifier oldLargeMailUserIdentifier = largeMailUserIdentifier;
		largeMailUserIdentifier = newLargeMailUserIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER, oldLargeMailUserIdentifier, newLargeMailUserIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLargeMailUserIdentifier(LargeMailUserIdentifier newLargeMailUserIdentifier) {
		if (newLargeMailUserIdentifier != largeMailUserIdentifier) {
			NotificationChain msgs = null;
			if (largeMailUserIdentifier != null)
				msgs = ((InternalEObject)largeMailUserIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER, null, msgs);
			if (newLargeMailUserIdentifier != null)
				msgs = ((InternalEObject)newLargeMailUserIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER, null, msgs);
			msgs = basicSetLargeMailUserIdentifier(newLargeMailUserIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER, newLargeMailUserIdentifier, newLargeMailUserIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BuildingName> getBuildingName() {
		if (buildingName == null) {
			buildingName = new EObjectContainmentEList<BuildingName>(BuildingName.class, this, XalPackage.LARGE_MAIL_USER__BUILDING_NAME);
		}
		return buildingName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartment(Department newDepartment, NotificationChain msgs) {
		Department oldDepartment = department;
		department = newDepartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__DEPARTMENT, oldDepartment, newDepartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment(Department newDepartment) {
		if (newDepartment != department) {
			NotificationChain msgs = null;
			if (department != null)
				msgs = ((InternalEObject)department).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__DEPARTMENT, null, msgs);
			if (newDepartment != null)
				msgs = ((InternalEObject)newDepartment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__DEPARTMENT, null, msgs);
			msgs = basicSetDepartment(newDepartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__DEPARTMENT, newDepartment, newDepartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBox getPostBox() {
		return postBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostBox(PostBox newPostBox, NotificationChain msgs) {
		PostBox oldPostBox = postBox;
		postBox = newPostBox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__POST_BOX, oldPostBox, newPostBox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostBox(PostBox newPostBox) {
		if (newPostBox != postBox) {
			NotificationChain msgs = null;
			if (postBox != null)
				msgs = ((InternalEObject)postBox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__POST_BOX, null, msgs);
			if (newPostBox != null)
				msgs = ((InternalEObject)newPostBox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__POST_BOX, null, msgs);
			msgs = basicSetPostBox(newPostBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__POST_BOX, newPostBox, newPostBox));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__THOROUGHFARE, oldThoroughfare, newThoroughfare);
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
				msgs = ((InternalEObject)thoroughfare).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__THOROUGHFARE, null, msgs);
			if (newThoroughfare != null)
				msgs = ((InternalEObject)newThoroughfare).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__THOROUGHFARE, null, msgs);
			msgs = basicSetThoroughfare(newThoroughfare, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__THOROUGHFARE, newThoroughfare, newThoroughfare));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCode getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalCode(PostalCode newPostalCode, NotificationChain msgs) {
		PostalCode oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__POSTAL_CODE, oldPostalCode, newPostalCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(PostalCode newPostalCode) {
		if (newPostalCode != postalCode) {
			NotificationChain msgs = null;
			if (postalCode != null)
				msgs = ((InternalEObject)postalCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__POSTAL_CODE, null, msgs);
			if (newPostalCode != null)
				msgs = ((InternalEObject)newPostalCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LARGE_MAIL_USER__POSTAL_CODE, null, msgs);
			msgs = basicSetPostalCode(newPostalCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__POSTAL_CODE, newPostalCode, newPostalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.LARGE_MAIL_USER__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LARGE_MAIL_USER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE);
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
			case XalPackage.LARGE_MAIL_USER__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME:
				return ((InternalEList<?>)getLargeMailUserName()).basicRemove(otherEnd, msgs);
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER:
				return basicSetLargeMailUserIdentifier(null, msgs);
			case XalPackage.LARGE_MAIL_USER__BUILDING_NAME:
				return ((InternalEList<?>)getBuildingName()).basicRemove(otherEnd, msgs);
			case XalPackage.LARGE_MAIL_USER__DEPARTMENT:
				return basicSetDepartment(null, msgs);
			case XalPackage.LARGE_MAIL_USER__POST_BOX:
				return basicSetPostBox(null, msgs);
			case XalPackage.LARGE_MAIL_USER__THOROUGHFARE:
				return basicSetThoroughfare(null, msgs);
			case XalPackage.LARGE_MAIL_USER__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.LARGE_MAIL_USER__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE:
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
			case XalPackage.LARGE_MAIL_USER__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME:
				return getLargeMailUserName();
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER:
				return getLargeMailUserIdentifier();
			case XalPackage.LARGE_MAIL_USER__BUILDING_NAME:
				return getBuildingName();
			case XalPackage.LARGE_MAIL_USER__DEPARTMENT:
				return getDepartment();
			case XalPackage.LARGE_MAIL_USER__POST_BOX:
				return getPostBox();
			case XalPackage.LARGE_MAIL_USER__THOROUGHFARE:
				return getThoroughfare();
			case XalPackage.LARGE_MAIL_USER__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.LARGE_MAIL_USER__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.LARGE_MAIL_USER__TYPE:
				return getType();
			case XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE:
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
			case XalPackage.LARGE_MAIL_USER__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME:
				getLargeMailUserName().clear();
				getLargeMailUserName().addAll((Collection<? extends LargeMailUserName>)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER:
				setLargeMailUserIdentifier((LargeMailUserIdentifier)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__BUILDING_NAME:
				getBuildingName().clear();
				getBuildingName().addAll((Collection<? extends BuildingName>)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__DEPARTMENT:
				setDepartment((Department)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__POST_BOX:
				setPostBox((PostBox)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__THOROUGHFARE:
				setThoroughfare((Thoroughfare)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__TYPE:
				setType((String)newValue);
				return;
			case XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE:
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
			case XalPackage.LARGE_MAIL_USER__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME:
				getLargeMailUserName().clear();
				return;
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER:
				setLargeMailUserIdentifier((LargeMailUserIdentifier)null);
				return;
			case XalPackage.LARGE_MAIL_USER__BUILDING_NAME:
				getBuildingName().clear();
				return;
			case XalPackage.LARGE_MAIL_USER__DEPARTMENT:
				setDepartment((Department)null);
				return;
			case XalPackage.LARGE_MAIL_USER__POST_BOX:
				setPostBox((PostBox)null);
				return;
			case XalPackage.LARGE_MAIL_USER__THOROUGHFARE:
				setThoroughfare((Thoroughfare)null);
				return;
			case XalPackage.LARGE_MAIL_USER__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.LARGE_MAIL_USER__ANY:
				getAny().clear();
				return;
			case XalPackage.LARGE_MAIL_USER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE:
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
			case XalPackage.LARGE_MAIL_USER__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_NAME:
				return largeMailUserName != null && !largeMailUserName.isEmpty();
			case XalPackage.LARGE_MAIL_USER__LARGE_MAIL_USER_IDENTIFIER:
				return largeMailUserIdentifier != null;
			case XalPackage.LARGE_MAIL_USER__BUILDING_NAME:
				return buildingName != null && !buildingName.isEmpty();
			case XalPackage.LARGE_MAIL_USER__DEPARTMENT:
				return department != null;
			case XalPackage.LARGE_MAIL_USER__POST_BOX:
				return postBox != null;
			case XalPackage.LARGE_MAIL_USER__THOROUGHFARE:
				return thoroughfare != null;
			case XalPackage.LARGE_MAIL_USER__POSTAL_CODE:
				return postalCode != null;
			case XalPackage.LARGE_MAIL_USER__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.LARGE_MAIL_USER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.LARGE_MAIL_USER__ANY_ATTRIBUTE:
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

} //LargeMailUserImpl
