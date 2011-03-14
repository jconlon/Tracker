/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.BuildingName;
import com.verticon.oasis.xal.Firm;
import com.verticon.oasis.xal.MailStop;
import com.verticon.oasis.xal.PostalCode;
import com.verticon.oasis.xal.SubPremise;
import com.verticon.oasis.xal.SubPremiseLocation;
import com.verticon.oasis.xal.SubPremiseName;
import com.verticon.oasis.xal.SubPremiseNumber;
import com.verticon.oasis.xal.SubPremiseNumberPrefix;
import com.verticon.oasis.xal.SubPremiseNumberSuffix;
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
 * An implementation of the model object '<em><b>Sub Premise</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremiseName <em>Sub Premise Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremiseLocation <em>Sub Premise Location</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremiseNumber <em>Sub Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremiseNumberPrefix <em>Sub Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremiseNumberSuffix <em>Sub Premise Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getBuildingName <em>Building Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getFirm <em>Firm</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getMailStop <em>Mail Stop</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getSubPremise <em>Sub Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.SubPremiseImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubPremiseImpl extends MinimalEObjectImpl.Container implements SubPremise {
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
	 * The cached value of the '{@link #getSubPremiseName() <em>Sub Premise Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremiseName()
	 * @generated
	 * @ordered
	 */
	protected EList<SubPremiseName> subPremiseName;

	/**
	 * The cached value of the '{@link #getSubPremiseLocation() <em>Sub Premise Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremiseLocation()
	 * @generated
	 * @ordered
	 */
	protected SubPremiseLocation subPremiseLocation;

	/**
	 * The cached value of the '{@link #getSubPremiseNumber() <em>Sub Premise Number</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremiseNumber()
	 * @generated
	 * @ordered
	 */
	protected EList<SubPremiseNumber> subPremiseNumber;

	/**
	 * The cached value of the '{@link #getSubPremiseNumberPrefix() <em>Sub Premise Number Prefix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremiseNumberPrefix()
	 * @generated
	 * @ordered
	 */
	protected EList<SubPremiseNumberPrefix> subPremiseNumberPrefix;

	/**
	 * The cached value of the '{@link #getSubPremiseNumberSuffix() <em>Sub Premise Number Suffix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremiseNumberSuffix()
	 * @generated
	 * @ordered
	 */
	protected EList<SubPremiseNumberSuffix> subPremiseNumberSuffix;

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
	 * The cached value of the '{@link #getFirm() <em>Firm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirm()
	 * @generated
	 * @ordered
	 */
	protected Firm firm;

	/**
	 * The cached value of the '{@link #getMailStop() <em>Mail Stop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailStop()
	 * @generated
	 * @ordered
	 */
	protected MailStop mailStop;

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
	 * The cached value of the '{@link #getSubPremise() <em>Sub Premise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremise()
	 * @generated
	 * @ordered
	 */
	protected SubPremise subPremise;

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
	protected SubPremiseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getSubPremise();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.SUB_PREMISE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubPremiseName> getSubPremiseName() {
		if (subPremiseName == null) {
			subPremiseName = new EObjectContainmentEList<SubPremiseName>(SubPremiseName.class, this, XalPackage.SUB_PREMISE__SUB_PREMISE_NAME);
		}
		return subPremiseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremiseLocation getSubPremiseLocation() {
		return subPremiseLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubPremiseLocation(SubPremiseLocation newSubPremiseLocation, NotificationChain msgs) {
		SubPremiseLocation oldSubPremiseLocation = subPremiseLocation;
		subPremiseLocation = newSubPremiseLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION, oldSubPremiseLocation, newSubPremiseLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubPremiseLocation(SubPremiseLocation newSubPremiseLocation) {
		if (newSubPremiseLocation != subPremiseLocation) {
			NotificationChain msgs = null;
			if (subPremiseLocation != null)
				msgs = ((InternalEObject)subPremiseLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION, null, msgs);
			if (newSubPremiseLocation != null)
				msgs = ((InternalEObject)newSubPremiseLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION, null, msgs);
			msgs = basicSetSubPremiseLocation(newSubPremiseLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION, newSubPremiseLocation, newSubPremiseLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubPremiseNumber> getSubPremiseNumber() {
		if (subPremiseNumber == null) {
			subPremiseNumber = new EObjectContainmentEList<SubPremiseNumber>(SubPremiseNumber.class, this, XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER);
		}
		return subPremiseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubPremiseNumberPrefix> getSubPremiseNumberPrefix() {
		if (subPremiseNumberPrefix == null) {
			subPremiseNumberPrefix = new EObjectContainmentEList<SubPremiseNumberPrefix>(SubPremiseNumberPrefix.class, this, XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX);
		}
		return subPremiseNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubPremiseNumberSuffix> getSubPremiseNumberSuffix() {
		if (subPremiseNumberSuffix == null) {
			subPremiseNumberSuffix = new EObjectContainmentEList<SubPremiseNumberSuffix>(SubPremiseNumberSuffix.class, this, XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX);
		}
		return subPremiseNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BuildingName> getBuildingName() {
		if (buildingName == null) {
			buildingName = new EObjectContainmentEList<BuildingName>(BuildingName.class, this, XalPackage.SUB_PREMISE__BUILDING_NAME);
		}
		return buildingName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Firm getFirm() {
		return firm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirm(Firm newFirm, NotificationChain msgs) {
		Firm oldFirm = firm;
		firm = newFirm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__FIRM, oldFirm, newFirm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirm(Firm newFirm) {
		if (newFirm != firm) {
			NotificationChain msgs = null;
			if (firm != null)
				msgs = ((InternalEObject)firm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__FIRM, null, msgs);
			if (newFirm != null)
				msgs = ((InternalEObject)newFirm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__FIRM, null, msgs);
			msgs = basicSetFirm(newFirm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__FIRM, newFirm, newFirm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailStop getMailStop() {
		return mailStop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMailStop(MailStop newMailStop, NotificationChain msgs) {
		MailStop oldMailStop = mailStop;
		mailStop = newMailStop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__MAIL_STOP, oldMailStop, newMailStop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailStop(MailStop newMailStop) {
		if (newMailStop != mailStop) {
			NotificationChain msgs = null;
			if (mailStop != null)
				msgs = ((InternalEObject)mailStop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__MAIL_STOP, null, msgs);
			if (newMailStop != null)
				msgs = ((InternalEObject)newMailStop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__MAIL_STOP, null, msgs);
			msgs = basicSetMailStop(newMailStop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__MAIL_STOP, newMailStop, newMailStop));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__POSTAL_CODE, oldPostalCode, newPostalCode);
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
				msgs = ((InternalEObject)postalCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__POSTAL_CODE, null, msgs);
			if (newPostalCode != null)
				msgs = ((InternalEObject)newPostalCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__POSTAL_CODE, null, msgs);
			msgs = basicSetPostalCode(newPostalCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__POSTAL_CODE, newPostalCode, newPostalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPremise getSubPremise() {
		return subPremise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubPremise(SubPremise newSubPremise, NotificationChain msgs) {
		SubPremise oldSubPremise = subPremise;
		subPremise = newSubPremise;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__SUB_PREMISE, oldSubPremise, newSubPremise);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubPremise(SubPremise newSubPremise) {
		if (newSubPremise != subPremise) {
			NotificationChain msgs = null;
			if (subPremise != null)
				msgs = ((InternalEObject)subPremise).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__SUB_PREMISE, null, msgs);
			if (newSubPremise != null)
				msgs = ((InternalEObject)newSubPremise).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.SUB_PREMISE__SUB_PREMISE, null, msgs);
			msgs = basicSetSubPremise(newSubPremise, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__SUB_PREMISE, newSubPremise, newSubPremise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.SUB_PREMISE__ANY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.SUB_PREMISE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.SUB_PREMISE__ANY_ATTRIBUTE);
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
			case XalPackage.SUB_PREMISE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NAME:
				return ((InternalEList<?>)getSubPremiseName()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION:
				return basicSetSubPremiseLocation(null, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER:
				return ((InternalEList<?>)getSubPremiseNumber()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX:
				return ((InternalEList<?>)getSubPremiseNumberPrefix()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX:
				return ((InternalEList<?>)getSubPremiseNumberSuffix()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__BUILDING_NAME:
				return ((InternalEList<?>)getBuildingName()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__FIRM:
				return basicSetFirm(null, msgs);
			case XalPackage.SUB_PREMISE__MAIL_STOP:
				return basicSetMailStop(null, msgs);
			case XalPackage.SUB_PREMISE__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.SUB_PREMISE__SUB_PREMISE:
				return basicSetSubPremise(null, msgs);
			case XalPackage.SUB_PREMISE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.SUB_PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NAME:
				return getSubPremiseName();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION:
				return getSubPremiseLocation();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER:
				return getSubPremiseNumber();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX:
				return getSubPremiseNumberPrefix();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX:
				return getSubPremiseNumberSuffix();
			case XalPackage.SUB_PREMISE__BUILDING_NAME:
				return getBuildingName();
			case XalPackage.SUB_PREMISE__FIRM:
				return getFirm();
			case XalPackage.SUB_PREMISE__MAIL_STOP:
				return getMailStop();
			case XalPackage.SUB_PREMISE__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.SUB_PREMISE__SUB_PREMISE:
				return getSubPremise();
			case XalPackage.SUB_PREMISE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.SUB_PREMISE__TYPE:
				return getType();
			case XalPackage.SUB_PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NAME:
				getSubPremiseName().clear();
				getSubPremiseName().addAll((Collection<? extends SubPremiseName>)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION:
				setSubPremiseLocation((SubPremiseLocation)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER:
				getSubPremiseNumber().clear();
				getSubPremiseNumber().addAll((Collection<? extends SubPremiseNumber>)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX:
				getSubPremiseNumberPrefix().clear();
				getSubPremiseNumberPrefix().addAll((Collection<? extends SubPremiseNumberPrefix>)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX:
				getSubPremiseNumberSuffix().clear();
				getSubPremiseNumberSuffix().addAll((Collection<? extends SubPremiseNumberSuffix>)newValue);
				return;
			case XalPackage.SUB_PREMISE__BUILDING_NAME:
				getBuildingName().clear();
				getBuildingName().addAll((Collection<? extends BuildingName>)newValue);
				return;
			case XalPackage.SUB_PREMISE__FIRM:
				setFirm((Firm)newValue);
				return;
			case XalPackage.SUB_PREMISE__MAIL_STOP:
				setMailStop((MailStop)newValue);
				return;
			case XalPackage.SUB_PREMISE__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE:
				setSubPremise((SubPremise)newValue);
				return;
			case XalPackage.SUB_PREMISE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.SUB_PREMISE__TYPE:
				setType(newValue);
				return;
			case XalPackage.SUB_PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NAME:
				getSubPremiseName().clear();
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION:
				setSubPremiseLocation((SubPremiseLocation)null);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER:
				getSubPremiseNumber().clear();
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX:
				getSubPremiseNumberPrefix().clear();
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX:
				getSubPremiseNumberSuffix().clear();
				return;
			case XalPackage.SUB_PREMISE__BUILDING_NAME:
				getBuildingName().clear();
				return;
			case XalPackage.SUB_PREMISE__FIRM:
				setFirm((Firm)null);
				return;
			case XalPackage.SUB_PREMISE__MAIL_STOP:
				setMailStop((MailStop)null);
				return;
			case XalPackage.SUB_PREMISE__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.SUB_PREMISE__SUB_PREMISE:
				setSubPremise((SubPremise)null);
				return;
			case XalPackage.SUB_PREMISE__ANY:
				getAny().clear();
				return;
			case XalPackage.SUB_PREMISE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.SUB_PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.SUB_PREMISE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NAME:
				return subPremiseName != null && !subPremiseName.isEmpty();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_LOCATION:
				return subPremiseLocation != null;
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER:
				return subPremiseNumber != null && !subPremiseNumber.isEmpty();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_PREFIX:
				return subPremiseNumberPrefix != null && !subPremiseNumberPrefix.isEmpty();
			case XalPackage.SUB_PREMISE__SUB_PREMISE_NUMBER_SUFFIX:
				return subPremiseNumberSuffix != null && !subPremiseNumberSuffix.isEmpty();
			case XalPackage.SUB_PREMISE__BUILDING_NAME:
				return buildingName != null && !buildingName.isEmpty();
			case XalPackage.SUB_PREMISE__FIRM:
				return firm != null;
			case XalPackage.SUB_PREMISE__MAIL_STOP:
				return mailStop != null;
			case XalPackage.SUB_PREMISE__POSTAL_CODE:
				return postalCode != null;
			case XalPackage.SUB_PREMISE__SUB_PREMISE:
				return subPremise != null;
			case XalPackage.SUB_PREMISE__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.SUB_PREMISE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.SUB_PREMISE__ANY_ATTRIBUTE:
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

} //SubPremiseImpl
