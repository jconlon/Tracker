/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.DependentLocality;
import com.verticon.oasis.xal.LargeMailUser;
import com.verticon.oasis.xal.Locality;
import com.verticon.oasis.xal.LocalityName;
import com.verticon.oasis.xal.PostBox;
import com.verticon.oasis.xal.PostOffice;
import com.verticon.oasis.xal.PostalCode;
import com.verticon.oasis.xal.PostalRoute;
import com.verticon.oasis.xal.Premise;
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
 * An implementation of the model object '<em><b>Locality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getLocalityName <em>Locality Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getLargeMailUser <em>Large Mail User</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getPostOffice <em>Post Office</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getPostalRoute <em>Postal Route</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getPremise <em>Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getDependentLocality <em>Dependent Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getUsageType <em>Usage Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.LocalityImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalityImpl extends MinimalEObjectImpl.Container implements Locality {
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
	 * The cached value of the '{@link #getLocalityName() <em>Locality Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalityName()
	 * @generated
	 * @ordered
	 */
	protected EList<LocalityName> localityName;

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
	 * The cached value of the '{@link #getLargeMailUser() <em>Large Mail User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeMailUser()
	 * @generated
	 * @ordered
	 */
	protected LargeMailUser largeMailUser;

	/**
	 * The cached value of the '{@link #getPostOffice() <em>Post Office</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostOffice()
	 * @generated
	 * @ordered
	 */
	protected PostOffice postOffice;

	/**
	 * The cached value of the '{@link #getPostalRoute() <em>Postal Route</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalRoute()
	 * @generated
	 * @ordered
	 */
	protected PostalRoute postalRoute;

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
	 * The cached value of the '{@link #getPremise() <em>Premise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremise()
	 * @generated
	 * @ordered
	 */
	protected Premise premise;

	/**
	 * The cached value of the '{@link #getDependentLocality() <em>Dependent Locality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentLocality()
	 * @generated
	 * @ordered
	 */
	protected DependentLocality dependentLocality;

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
	 * The default value of the '{@link #getIndicator() <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicator()
	 * @generated
	 * @ordered
	 */
	protected static final Object INDICATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndicator() <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndicator()
	 * @generated
	 * @ordered
	 */
	protected Object indicator = INDICATOR_EDEFAULT;

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
	 * The default value of the '{@link #getUsageType() <em>Usage Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageType()
	 * @generated
	 * @ordered
	 */
	protected static final Object USAGE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsageType() <em>Usage Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageType()
	 * @generated
	 * @ordered
	 */
	protected Object usageType = USAGE_TYPE_EDEFAULT;

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
	protected LocalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getLocality();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddressLine> getAddressLine() {
		if (addressLine == null) {
			addressLine = new EObjectContainmentEList<AddressLine>(AddressLine.class, this, XalPackage.LOCALITY__ADDRESS_LINE);
		}
		return addressLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LocalityName> getLocalityName() {
		if (localityName == null) {
			localityName = new EObjectContainmentEList<LocalityName>(LocalityName.class, this, XalPackage.LOCALITY__LOCALITY_NAME);
		}
		return localityName;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POST_BOX, oldPostBox, newPostBox);
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
				msgs = ((InternalEObject)postBox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POST_BOX, null, msgs);
			if (newPostBox != null)
				msgs = ((InternalEObject)newPostBox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POST_BOX, null, msgs);
			msgs = basicSetPostBox(newPostBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POST_BOX, newPostBox, newPostBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LargeMailUser getLargeMailUser() {
		return largeMailUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLargeMailUser(LargeMailUser newLargeMailUser, NotificationChain msgs) {
		LargeMailUser oldLargeMailUser = largeMailUser;
		largeMailUser = newLargeMailUser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__LARGE_MAIL_USER, oldLargeMailUser, newLargeMailUser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLargeMailUser(LargeMailUser newLargeMailUser) {
		if (newLargeMailUser != largeMailUser) {
			NotificationChain msgs = null;
			if (largeMailUser != null)
				msgs = ((InternalEObject)largeMailUser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__LARGE_MAIL_USER, null, msgs);
			if (newLargeMailUser != null)
				msgs = ((InternalEObject)newLargeMailUser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__LARGE_MAIL_USER, null, msgs);
			msgs = basicSetLargeMailUser(newLargeMailUser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__LARGE_MAIL_USER, newLargeMailUser, newLargeMailUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostOffice getPostOffice() {
		return postOffice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostOffice(PostOffice newPostOffice, NotificationChain msgs) {
		PostOffice oldPostOffice = postOffice;
		postOffice = newPostOffice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POST_OFFICE, oldPostOffice, newPostOffice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostOffice(PostOffice newPostOffice) {
		if (newPostOffice != postOffice) {
			NotificationChain msgs = null;
			if (postOffice != null)
				msgs = ((InternalEObject)postOffice).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POST_OFFICE, null, msgs);
			if (newPostOffice != null)
				msgs = ((InternalEObject)newPostOffice).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POST_OFFICE, null, msgs);
			msgs = basicSetPostOffice(newPostOffice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POST_OFFICE, newPostOffice, newPostOffice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalRoute getPostalRoute() {
		return postalRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalRoute(PostalRoute newPostalRoute, NotificationChain msgs) {
		PostalRoute oldPostalRoute = postalRoute;
		postalRoute = newPostalRoute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POSTAL_ROUTE, oldPostalRoute, newPostalRoute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalRoute(PostalRoute newPostalRoute) {
		if (newPostalRoute != postalRoute) {
			NotificationChain msgs = null;
			if (postalRoute != null)
				msgs = ((InternalEObject)postalRoute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POSTAL_ROUTE, null, msgs);
			if (newPostalRoute != null)
				msgs = ((InternalEObject)newPostalRoute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POSTAL_ROUTE, null, msgs);
			msgs = basicSetPostalRoute(newPostalRoute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POSTAL_ROUTE, newPostalRoute, newPostalRoute));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__THOROUGHFARE, oldThoroughfare, newThoroughfare);
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
				msgs = ((InternalEObject)thoroughfare).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__THOROUGHFARE, null, msgs);
			if (newThoroughfare != null)
				msgs = ((InternalEObject)newThoroughfare).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__THOROUGHFARE, null, msgs);
			msgs = basicSetThoroughfare(newThoroughfare, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__THOROUGHFARE, newThoroughfare, newThoroughfare));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__PREMISE, oldPremise, newPremise);
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
				msgs = ((InternalEObject)premise).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__PREMISE, null, msgs);
			if (newPremise != null)
				msgs = ((InternalEObject)newPremise).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__PREMISE, null, msgs);
			msgs = basicSetPremise(newPremise, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__PREMISE, newPremise, newPremise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentLocality getDependentLocality() {
		return dependentLocality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependentLocality(DependentLocality newDependentLocality, NotificationChain msgs) {
		DependentLocality oldDependentLocality = dependentLocality;
		dependentLocality = newDependentLocality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__DEPENDENT_LOCALITY, oldDependentLocality, newDependentLocality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependentLocality(DependentLocality newDependentLocality) {
		if (newDependentLocality != dependentLocality) {
			NotificationChain msgs = null;
			if (dependentLocality != null)
				msgs = ((InternalEObject)dependentLocality).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__DEPENDENT_LOCALITY, null, msgs);
			if (newDependentLocality != null)
				msgs = ((InternalEObject)newDependentLocality).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__DEPENDENT_LOCALITY, null, msgs);
			msgs = basicSetDependentLocality(newDependentLocality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__DEPENDENT_LOCALITY, newDependentLocality, newDependentLocality));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POSTAL_CODE, oldPostalCode, newPostalCode);
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
				msgs = ((InternalEObject)postalCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POSTAL_CODE, null, msgs);
			if (newPostalCode != null)
				msgs = ((InternalEObject)newPostalCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XalPackage.LOCALITY__POSTAL_CODE, null, msgs);
			msgs = basicSetPostalCode(newPostalCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__POSTAL_CODE, newPostalCode, newPostalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, XalPackage.LOCALITY__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIndicator() {
		return indicator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndicator(Object newIndicator) {
		Object oldIndicator = indicator;
		indicator = newIndicator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__INDICATOR, oldIndicator, indicator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUsageType() {
		return usageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageType(Object newUsageType) {
		Object oldUsageType = usageType;
		usageType = newUsageType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XalPackage.LOCALITY__USAGE_TYPE, oldUsageType, usageType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, XalPackage.LOCALITY__ANY_ATTRIBUTE);
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
			case XalPackage.LOCALITY__ADDRESS_LINE:
				return ((InternalEList<?>)getAddressLine()).basicRemove(otherEnd, msgs);
			case XalPackage.LOCALITY__LOCALITY_NAME:
				return ((InternalEList<?>)getLocalityName()).basicRemove(otherEnd, msgs);
			case XalPackage.LOCALITY__POST_BOX:
				return basicSetPostBox(null, msgs);
			case XalPackage.LOCALITY__LARGE_MAIL_USER:
				return basicSetLargeMailUser(null, msgs);
			case XalPackage.LOCALITY__POST_OFFICE:
				return basicSetPostOffice(null, msgs);
			case XalPackage.LOCALITY__POSTAL_ROUTE:
				return basicSetPostalRoute(null, msgs);
			case XalPackage.LOCALITY__THOROUGHFARE:
				return basicSetThoroughfare(null, msgs);
			case XalPackage.LOCALITY__PREMISE:
				return basicSetPremise(null, msgs);
			case XalPackage.LOCALITY__DEPENDENT_LOCALITY:
				return basicSetDependentLocality(null, msgs);
			case XalPackage.LOCALITY__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.LOCALITY__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case XalPackage.LOCALITY__ANY_ATTRIBUTE:
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
			case XalPackage.LOCALITY__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.LOCALITY__LOCALITY_NAME:
				return getLocalityName();
			case XalPackage.LOCALITY__POST_BOX:
				return getPostBox();
			case XalPackage.LOCALITY__LARGE_MAIL_USER:
				return getLargeMailUser();
			case XalPackage.LOCALITY__POST_OFFICE:
				return getPostOffice();
			case XalPackage.LOCALITY__POSTAL_ROUTE:
				return getPostalRoute();
			case XalPackage.LOCALITY__THOROUGHFARE:
				return getThoroughfare();
			case XalPackage.LOCALITY__PREMISE:
				return getPremise();
			case XalPackage.LOCALITY__DEPENDENT_LOCALITY:
				return getDependentLocality();
			case XalPackage.LOCALITY__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.LOCALITY__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case XalPackage.LOCALITY__INDICATOR:
				return getIndicator();
			case XalPackage.LOCALITY__TYPE:
				return getType();
			case XalPackage.LOCALITY__USAGE_TYPE:
				return getUsageType();
			case XalPackage.LOCALITY__ANY_ATTRIBUTE:
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
			case XalPackage.LOCALITY__ADDRESS_LINE:
				getAddressLine().clear();
				getAddressLine().addAll((Collection<? extends AddressLine>)newValue);
				return;
			case XalPackage.LOCALITY__LOCALITY_NAME:
				getLocalityName().clear();
				getLocalityName().addAll((Collection<? extends LocalityName>)newValue);
				return;
			case XalPackage.LOCALITY__POST_BOX:
				setPostBox((PostBox)newValue);
				return;
			case XalPackage.LOCALITY__LARGE_MAIL_USER:
				setLargeMailUser((LargeMailUser)newValue);
				return;
			case XalPackage.LOCALITY__POST_OFFICE:
				setPostOffice((PostOffice)newValue);
				return;
			case XalPackage.LOCALITY__POSTAL_ROUTE:
				setPostalRoute((PostalRoute)newValue);
				return;
			case XalPackage.LOCALITY__THOROUGHFARE:
				setThoroughfare((Thoroughfare)newValue);
				return;
			case XalPackage.LOCALITY__PREMISE:
				setPremise((Premise)newValue);
				return;
			case XalPackage.LOCALITY__DEPENDENT_LOCALITY:
				setDependentLocality((DependentLocality)newValue);
				return;
			case XalPackage.LOCALITY__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.LOCALITY__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case XalPackage.LOCALITY__INDICATOR:
				setIndicator(newValue);
				return;
			case XalPackage.LOCALITY__TYPE:
				setType(newValue);
				return;
			case XalPackage.LOCALITY__USAGE_TYPE:
				setUsageType(newValue);
				return;
			case XalPackage.LOCALITY__ANY_ATTRIBUTE:
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
			case XalPackage.LOCALITY__ADDRESS_LINE:
				getAddressLine().clear();
				return;
			case XalPackage.LOCALITY__LOCALITY_NAME:
				getLocalityName().clear();
				return;
			case XalPackage.LOCALITY__POST_BOX:
				setPostBox((PostBox)null);
				return;
			case XalPackage.LOCALITY__LARGE_MAIL_USER:
				setLargeMailUser((LargeMailUser)null);
				return;
			case XalPackage.LOCALITY__POST_OFFICE:
				setPostOffice((PostOffice)null);
				return;
			case XalPackage.LOCALITY__POSTAL_ROUTE:
				setPostalRoute((PostalRoute)null);
				return;
			case XalPackage.LOCALITY__THOROUGHFARE:
				setThoroughfare((Thoroughfare)null);
				return;
			case XalPackage.LOCALITY__PREMISE:
				setPremise((Premise)null);
				return;
			case XalPackage.LOCALITY__DEPENDENT_LOCALITY:
				setDependentLocality((DependentLocality)null);
				return;
			case XalPackage.LOCALITY__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.LOCALITY__ANY:
				getAny().clear();
				return;
			case XalPackage.LOCALITY__INDICATOR:
				setIndicator(INDICATOR_EDEFAULT);
				return;
			case XalPackage.LOCALITY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case XalPackage.LOCALITY__USAGE_TYPE:
				setUsageType(USAGE_TYPE_EDEFAULT);
				return;
			case XalPackage.LOCALITY__ANY_ATTRIBUTE:
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
			case XalPackage.LOCALITY__ADDRESS_LINE:
				return addressLine != null && !addressLine.isEmpty();
			case XalPackage.LOCALITY__LOCALITY_NAME:
				return localityName != null && !localityName.isEmpty();
			case XalPackage.LOCALITY__POST_BOX:
				return postBox != null;
			case XalPackage.LOCALITY__LARGE_MAIL_USER:
				return largeMailUser != null;
			case XalPackage.LOCALITY__POST_OFFICE:
				return postOffice != null;
			case XalPackage.LOCALITY__POSTAL_ROUTE:
				return postalRoute != null;
			case XalPackage.LOCALITY__THOROUGHFARE:
				return thoroughfare != null;
			case XalPackage.LOCALITY__PREMISE:
				return premise != null;
			case XalPackage.LOCALITY__DEPENDENT_LOCALITY:
				return dependentLocality != null;
			case XalPackage.LOCALITY__POSTAL_CODE:
				return postalCode != null;
			case XalPackage.LOCALITY__ANY:
				return any != null && !any.isEmpty();
			case XalPackage.LOCALITY__INDICATOR:
				return INDICATOR_EDEFAULT == null ? indicator != null : !INDICATOR_EDEFAULT.equals(indicator);
			case XalPackage.LOCALITY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case XalPackage.LOCALITY__USAGE_TYPE:
				return USAGE_TYPE_EDEFAULT == null ? usageType != null : !USAGE_TYPE_EDEFAULT.equals(usageType);
			case XalPackage.LOCALITY__ANY_ATTRIBUTE:
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
		result.append(", indicator: ");
		result.append(indicator);
		result.append(", type: ");
		result.append(type);
		result.append(", usageType: ");
		result.append(usageType);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //LocalityImpl
