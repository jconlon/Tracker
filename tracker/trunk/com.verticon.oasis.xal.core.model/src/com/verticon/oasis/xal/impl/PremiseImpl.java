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
import com.verticon.oasis.xal.Premise;
import com.verticon.oasis.xal.PremiseLocation;
import com.verticon.oasis.xal.PremiseName;
import com.verticon.oasis.xal.PremiseNumber;
import com.verticon.oasis.xal.PremiseNumberPrefix;
import com.verticon.oasis.xal.PremiseNumberRange;
import com.verticon.oasis.xal.PremiseNumberSuffix;
import com.verticon.oasis.xal.SubPremise;
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
 * An implementation of the model object '<em><b>Premise</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseName <em>Premise Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseLocation <em>Premise Location</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseNumber <em>Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseNumberRange <em>Premise Number Range</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseNumberPrefix <em>Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseNumberSuffix <em>Premise Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getBuildingName <em>Building Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getSubPremise <em>Sub Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getFirm <em>Firm</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getMailStop <em>Mail Stop</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremise <em>Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseDependency <em>Premise Dependency</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseDependencyType <em>Premise Dependency Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getPremiseThoroughfareConnector <em>Premise Thoroughfare Connector</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.PremiseImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PremiseImpl extends MinimalEObjectImpl.Container implements Premise {
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
	 * The cached value of the '{@link #getPremiseName() <em>Premise Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseName()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseName> premiseName;

	/**
	 * The cached value of the '{@link #getPremiseLocation() <em>Premise Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseLocation()
	 * @generated
	 * @ordered
	 */
	protected PremiseLocation premiseLocation;

	/**
	 * The cached value of the '{@link #getPremiseNumber() <em>Premise Number</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumber()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumber> premiseNumber;

	/**
	 * The cached value of the '{@link #getPremiseNumberRange() <em>Premise Number Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberRange()
	 * @generated
	 * @ordered
	 */
	protected PremiseNumberRange premiseNumberRange;

	/**
	 * The cached value of the '{@link #getPremiseNumberPrefix() <em>Premise Number Prefix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberPrefix()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumberPrefix> premiseNumberPrefix;

	/**
	 * The cached value of the '{@link #getPremiseNumberSuffix() <em>Premise Number Suffix</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseNumberSuffix()
	 * @generated
	 * @ordered
	 */
	protected EList<PremiseNumberSuffix> premiseNumberSuffix;

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
	 * The cached value of the '{@link #getSubPremise() <em>Sub Premise</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPremise()
	 * @generated
	 * @ordered
	 */
	protected EList<SubPremise> subPremise;

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
	 * The cached value of the '{@link #getPremise() <em>Premise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremise()
	 * @generated
	 * @ordered
	 */
	protected Premise premise;

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
	 * The default value of the '{@link #getPremiseDependency() <em>Premise Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseDependency()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREMISE_DEPENDENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremiseDependency() <em>Premise Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseDependency()
	 * @generated
	 * @ordered
	 */
	protected Object premiseDependency = PREMISE_DEPENDENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPremiseDependencyType() <em>Premise Dependency Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseDependencyType()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREMISE_DEPENDENCY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremiseDependencyType() <em>Premise Dependency Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseDependencyType()
	 * @generated
	 * @ordered
	 */
	protected Object premiseDependencyType = PREMISE_DEPENDENCY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPremiseThoroughfareConnector() <em>Premise Thoroughfare Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseThoroughfareConnector()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREMISE_THOROUGHFARE_CONNECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremiseThoroughfareConnector() <em>Premise Thoroughfare Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremiseThoroughfareConnector()
	 * @generated
	 * @ordered
	 */
	protected Object premiseThoroughfareConnector = PREMISE_THOROUGHFARE_CONNECTOR_EDEFAULT;

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
	protected PremiseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getPremise();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.PREMISE__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseName> getPremiseName() {
		if (premiseName == null) {
			premiseName = new EObjectContainmentEList<PremiseName>(PremiseName.class, this, XalPackage.PREMISE__PREMISE_NAME);
		}
		return premiseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseLocation getPremiseLocation() {
		return premiseLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseLocation(PremiseLocation newPremiseLocation, NotificationChain msgs) {
		PremiseLocation oldPremiseLocation = premiseLocation;
		premiseLocation = newPremiseLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_LOCATION, oldPremiseLocation, newPremiseLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseLocation(PremiseLocation newPremiseLocation) {
		if (newPremiseLocation != premiseLocation) {
			NotificationChain msgs = null;
			if (premiseLocation != null)
				msgs = ((InternalEObject)premiseLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE_LOCATION, null, msgs);
			if (newPremiseLocation != null)
				msgs = ((InternalEObject)newPremiseLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE_LOCATION, null, msgs);
			msgs = basicSetPremiseLocation(newPremiseLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_LOCATION, newPremiseLocation, newPremiseLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumber> getPremiseNumber() {
		if (premiseNumber == null) {
			premiseNumber = new EObjectContainmentEList<PremiseNumber>(PremiseNumber.class, this, XalPackage.PREMISE__PREMISE_NUMBER);
		}
		return premiseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberRange getPremiseNumberRange() {
		return premiseNumberRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumberRange(PremiseNumberRange newPremiseNumberRange, NotificationChain msgs) {
		PremiseNumberRange oldPremiseNumberRange = premiseNumberRange;
		premiseNumberRange = newPremiseNumberRange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_NUMBER_RANGE, oldPremiseNumberRange, newPremiseNumberRange);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberRange(PremiseNumberRange newPremiseNumberRange) {
		if (newPremiseNumberRange != premiseNumberRange) {
			NotificationChain msgs = null;
			if (premiseNumberRange != null)
				msgs = ((InternalEObject)premiseNumberRange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE_NUMBER_RANGE, null, msgs);
			if (newPremiseNumberRange != null)
				msgs = ((InternalEObject)newPremiseNumberRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE_NUMBER_RANGE, null, msgs);
			msgs = basicSetPremiseNumberRange(newPremiseNumberRange, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_NUMBER_RANGE, newPremiseNumberRange, newPremiseNumberRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumberPrefix> getPremiseNumberPrefix() {
		if (premiseNumberPrefix == null) {
			premiseNumberPrefix = new EObjectContainmentEList<PremiseNumberPrefix>(PremiseNumberPrefix.class, this, XalPackage.PREMISE__PREMISE_NUMBER_PREFIX);
		}
		return premiseNumberPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PremiseNumberSuffix> getPremiseNumberSuffix() {
		if (premiseNumberSuffix == null) {
			premiseNumberSuffix = new EObjectContainmentEList<PremiseNumberSuffix>(PremiseNumberSuffix.class, this, XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX);
		}
		return premiseNumberSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BuildingName> getBuildingName() {
		if (buildingName == null) {
			buildingName = new EObjectContainmentEList<BuildingName>(BuildingName.class, this, XalPackage.PREMISE__BUILDING_NAME);
		}
		return buildingName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubPremise> getSubPremise() {
		if (subPremise == null) {
			subPremise = new EObjectContainmentEList<SubPremise>(SubPremise.class, this, XalPackage.PREMISE__SUB_PREMISE);
		}
		return subPremise;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__FIRM, oldFirm, newFirm);
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
				msgs = ((InternalEObject)firm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__FIRM, null, msgs);
			if (newFirm != null)
				msgs = ((InternalEObject)newFirm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__FIRM, null, msgs);
			msgs = basicSetFirm(newFirm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__FIRM, newFirm, newFirm));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__MAIL_STOP, oldMailStop, newMailStop);
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
				msgs = ((InternalEObject)mailStop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__MAIL_STOP, null, msgs);
			if (newMailStop != null)
				msgs = ((InternalEObject)newMailStop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__MAIL_STOP, null, msgs);
			msgs = basicSetMailStop(newMailStop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__MAIL_STOP, newMailStop, newMailStop));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__POSTAL_CODE, oldPostalCode, newPostalCode);
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
				msgs = ((InternalEObject)postalCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__POSTAL_CODE, null, msgs);
			if (newPostalCode != null)
				msgs = ((InternalEObject)newPostalCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__POSTAL_CODE, null, msgs);
			msgs = basicSetPostalCode(newPostalCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__POSTAL_CODE, newPostalCode, newPostalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premise getPremise() {
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremise(Premise newPremise, NotificationChain msgs) {
		Premise oldPremise = premise;
		premise = newPremise;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE, oldPremise, newPremise);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremise(Premise newPremise) {
		if (newPremise != premise) {
			NotificationChain msgs = null;
			if (premise != null)
				msgs = ((InternalEObject)premise).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE, null, msgs);
			if (newPremise != null)
				msgs = ((InternalEObject)newPremise).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.PREMISE__PREMISE, null, msgs);
			msgs = basicSetPremise(newPremise, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE, newPremise, newPremise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.PREMISE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPremiseDependency() {
		return premiseDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseDependency(Object newPremiseDependency) {
		Object oldPremiseDependency = premiseDependency;
		premiseDependency = newPremiseDependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_DEPENDENCY, oldPremiseDependency, premiseDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPremiseDependencyType() {
		return premiseDependencyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseDependencyType(Object newPremiseDependencyType) {
		Object oldPremiseDependencyType = premiseDependencyType;
		premiseDependencyType = newPremiseDependencyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_DEPENDENCY_TYPE, oldPremiseDependencyType, premiseDependencyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPremiseThoroughfareConnector() {
		return premiseThoroughfareConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseThoroughfareConnector(Object newPremiseThoroughfareConnector) {
		Object oldPremiseThoroughfareConnector = premiseThoroughfareConnector;
		premiseThoroughfareConnector = newPremiseThoroughfareConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__PREMISE_THOROUGHFARE_CONNECTOR, oldPremiseThoroughfareConnector, premiseThoroughfareConnector));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.PREMISE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.PREMISE__ANY_ATTRIBUTE);
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
			case XalPackage.PREMISE__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__PREMISE_NAME:
				return ((InternalEList<?>)getPremiseName()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__PREMISE_LOCATION:
				return basicSetPremiseLocation(null, msgs);
			case XalPackage.PREMISE__PREMISE_NUMBER:
				return ((InternalEList<?>)getPremiseNumber()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__PREMISE_NUMBER_RANGE:
				return basicSetPremiseNumberRange(null, msgs);
			case XalPackage.PREMISE__PREMISE_NUMBER_PREFIX:
				return ((InternalEList<?>)getPremiseNumberPrefix()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX:
				return ((InternalEList<?>)getPremiseNumberSuffix()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__BUILDING_NAME:
				return ((InternalEList<?>)getBuildingName()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__SUB_PREMISE:
				return ((InternalEList<?>)getSubPremise()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__FIRM:
				return basicSetFirm(null, msgs);
			case XalPackage.PREMISE__MAIL_STOP:
				return basicSetMailStop(null, msgs);
			case XalPackage.PREMISE__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.PREMISE__PREMISE:
				return basicSetPremise(null, msgs);
			case XalPackage.PREMISE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.PREMISE__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.PREMISE__PREMISE_NAME:
				return getPremiseName();
			case XalPackage.PREMISE__PREMISE_LOCATION:
				return getPremiseLocation();
			case XalPackage.PREMISE__PREMISE_NUMBER:
				return getPremiseNumber();
			case XalPackage.PREMISE__PREMISE_NUMBER_RANGE:
				return getPremiseNumberRange();
			case XalPackage.PREMISE__PREMISE_NUMBER_PREFIX:
				return getPremiseNumberPrefix();
			case XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX:
				return getPremiseNumberSuffix();
			case XalPackage.PREMISE__BUILDING_NAME:
				return getBuildingName();
			case XalPackage.PREMISE__SUB_PREMISE:
				return getSubPremise();
			case XalPackage.PREMISE__FIRM:
				return getFirm();
			case XalPackage.PREMISE__MAIL_STOP:
				return getMailStop();
			case XalPackage.PREMISE__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.PREMISE__PREMISE:
				return getPremise();
			case XalPackage.PREMISE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.PREMISE__PREMISE_DEPENDENCY:
				return getPremiseDependency();
			case XalPackage.PREMISE__PREMISE_DEPENDENCY_TYPE:
				return getPremiseDependencyType();
			case XalPackage.PREMISE__PREMISE_THOROUGHFARE_CONNECTOR:
				return getPremiseThoroughfareConnector();
			case XalPackage.PREMISE__TYPE:
				return getType();
			case XalPackage.PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.PREMISE__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_NAME:
				getPremiseName().clear();
				getPremiseName().addAll((Collection<? extends PremiseName>)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_LOCATION:
				setPremiseLocation((PremiseLocation)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER:
				getPremiseNumber().clear();
				getPremiseNumber().addAll((Collection<? extends PremiseNumber>)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_RANGE:
				setPremiseNumberRange((PremiseNumberRange)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_PREFIX:
				getPremiseNumberPrefix().clear();
				getPremiseNumberPrefix().addAll((Collection<? extends PremiseNumberPrefix>)newValue);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX:
				getPremiseNumberSuffix().clear();
				getPremiseNumberSuffix().addAll((Collection<? extends PremiseNumberSuffix>)newValue);
				return;
			case XalPackage.PREMISE__BUILDING_NAME:
				getBuildingName().clear();
				getBuildingName().addAll((Collection<? extends BuildingName>)newValue);
				return;
			case XalPackage.PREMISE__SUB_PREMISE:
				getSubPremise().clear();
				getSubPremise().addAll((Collection<? extends SubPremise>)newValue);
				return;
			case XalPackage.PREMISE__FIRM:
				setFirm((Firm)newValue);
				return;
			case XalPackage.PREMISE__MAIL_STOP:
				setMailStop((MailStop)newValue);
				return;
			case XalPackage.PREMISE__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.PREMISE__PREMISE:
				setPremise((Premise)newValue);
				return;
			case XalPackage.PREMISE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.PREMISE__PREMISE_DEPENDENCY:
				setPremiseDependency(newValue);
				return;
			case XalPackage.PREMISE__PREMISE_DEPENDENCY_TYPE:
				setPremiseDependencyType(newValue);
				return;
			case XalPackage.PREMISE__PREMISE_THOROUGHFARE_CONNECTOR:
				setPremiseThoroughfareConnector(newValue);
				return;
			case XalPackage.PREMISE__TYPE:
				setType(newValue);
				return;
			case XalPackage.PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.PREMISE__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.PREMISE__PREMISE_NAME:
				getPremiseName().clear();
				return;
			case XalPackage.PREMISE__PREMISE_LOCATION:
				setPremiseLocation((PremiseLocation)null);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER:
				getPremiseNumber().clear();
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_RANGE:
				setPremiseNumberRange((PremiseNumberRange)null);
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_PREFIX:
				getPremiseNumberPrefix().clear();
				return;
			case XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX:
				getPremiseNumberSuffix().clear();
				return;
			case XalPackage.PREMISE__BUILDING_NAME:
				getBuildingName().clear();
				return;
			case XalPackage.PREMISE__SUB_PREMISE:
				getSubPremise().clear();
				return;
			case XalPackage.PREMISE__FIRM:
				setFirm((Firm)null);
				return;
			case XalPackage.PREMISE__MAIL_STOP:
				setMailStop((MailStop)null);
				return;
			case XalPackage.PREMISE__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.PREMISE__PREMISE:
				setPremise((Premise)null);
				return;
			case XalPackage.PREMISE__ANY:
				getAny().clear();
				return;
			case XalPackage.PREMISE__PREMISE_DEPENDENCY:
				setPremiseDependency(PREMISE_DEPENDENCY_EDEFAULT);
				return;
			case XalPackage.PREMISE__PREMISE_DEPENDENCY_TYPE:
				setPremiseDependencyType(PREMISE_DEPENDENCY_TYPE_EDEFAULT);
				return;
			case XalPackage.PREMISE__PREMISE_THOROUGHFARE_CONNECTOR:
				setPremiseThoroughfareConnector(PREMISE_THOROUGHFARE_CONNECTOR_EDEFAULT);
				return;
			case XalPackage.PREMISE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.PREMISE__ANY_ATTRIBUTE:
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
			case XalPackage.PREMISE__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.PREMISE__PREMISE_NAME:
				return premiseName != null && !premiseName.isEmpty();
			case XalPackage.PREMISE__PREMISE_LOCATION:
				return premiseLocation != null;
			case XalPackage.PREMISE__PREMISE_NUMBER:
				return premiseNumber != null && !premiseNumber.isEmpty();
			case XalPackage.PREMISE__PREMISE_NUMBER_RANGE:
				return premiseNumberRange != null;
			case XalPackage.PREMISE__PREMISE_NUMBER_PREFIX:
				return premiseNumberPrefix != null && !premiseNumberPrefix.isEmpty();
			case XalPackage.PREMISE__PREMISE_NUMBER_SUFFIX:
				return premiseNumberSuffix != null && !premiseNumberSuffix.isEmpty();
			case XalPackage.PREMISE__BUILDING_NAME:
				return buildingName != null && !buildingName.isEmpty();
			case XalPackage.PREMISE__SUB_PREMISE:
				return subPremise != null && !subPremise.isEmpty();
			case XalPackage.PREMISE__FIRM:
				return firm != null;
			case XalPackage.PREMISE__MAIL_STOP:
				return mailStop != null;
			case XalPackage.PREMISE__POSTAL_CODE:
				return postalCode != null;
			case XalPackage.PREMISE__PREMISE:
				return premise != null;
			case XalPackage.PREMISE__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.PREMISE__PREMISE_DEPENDENCY:
				return PREMISE_DEPENDENCY_EDEFAULT == null ? premiseDependency != null : !PREMISE_DEPENDENCY_EDEFAULT.equals(premiseDependency);
			case XalPackage.PREMISE__PREMISE_DEPENDENCY_TYPE:
				return PREMISE_DEPENDENCY_TYPE_EDEFAULT == null ? premiseDependencyType != null : !PREMISE_DEPENDENCY_TYPE_EDEFAULT.equals(premiseDependencyType);
			case XalPackage.PREMISE__PREMISE_THOROUGHFARE_CONNECTOR:
				return PREMISE_THOROUGHFARE_CONNECTOR_EDEFAULT == null ? premiseThoroughfareConnector != null : !PREMISE_THOROUGHFARE_CONNECTOR_EDEFAULT.equals(premiseThoroughfareConnector);
			case XalPackage.PREMISE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.PREMISE__ANY_ATTRIBUTE:
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
		result.append(", premiseDependency: ");
		result.append(premiseDependency);
		result.append(", premiseDependencyType: ");
		result.append(premiseDependencyType);
		result.append(", premiseThoroughfareConnector: ");
		result.append(premiseThoroughfareConnector);
		result.append(", type: ");
		result.append(type);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //PremiseImpl
