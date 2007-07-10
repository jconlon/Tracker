/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.verticon.tracker.Animals;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

import com.verticon.tracker.UnAppliedTags;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getPremisesId <em>Premises Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getEmailContact <em>Email Contact</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getEventHistory <em>Event History</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getUnAppliedTags <em>Un Applied Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PremisesImpl extends EObjectImpl implements Premises {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getPremisesId() <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremisesId()
	 * @generated
	 * @ordered
	 */
	protected static final String PREMISES_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremisesId() <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremisesId()
	 * @generated
	 * @ordered
	 */
	protected String premisesId = PREMISES_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmailContact() <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailContact()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_CONTACT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getEmailContact() <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailContact()
	 * @generated
	 * @ordered
	 */
	protected String emailContact = EMAIL_CONTACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnimals() <em>Animals</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimals()
	 * @generated
	 * @ordered
	 */
	protected Animals animals;

	/**
	 * The cached value of the '{@link #getEventHistory() <em>Event History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventHistory()
	 * @generated
	 * @ordered
	 */
	protected EventHistory eventHistory;

	/**
	 * The cached value of the '{@link #getUnAppliedTags() <em>Un Applied Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnAppliedTags()
	 * @generated
	 * @ordered
	 */
	protected UnAppliedTags unAppliedTags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PremisesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.PREMISES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPremisesId() {
		return premisesId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremisesId(String newPremisesId) {
		String oldPremisesId = premisesId;
		premisesId = newPremisesId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__PREMISES_ID, oldPremisesId, premisesId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailContact() {
		return emailContact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailContact(String newEmailContact) {
		String oldEmailContact = emailContact;
		emailContact = newEmailContact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__EMAIL_CONTACT, oldEmailContact, emailContact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animals getAnimals() {
		return animals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnimals(Animals newAnimals, NotificationChain msgs) {
		Animals oldAnimals = animals;
		animals = newAnimals;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__ANIMALS, oldAnimals, newAnimals);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnimals(Animals newAnimals) {
		if (newAnimals != animals) {
			NotificationChain msgs = null;
			if (animals != null)
				msgs = ((InternalEObject)animals).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__ANIMALS, null, msgs);
			if (newAnimals != null)
				msgs = ((InternalEObject)newAnimals).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__ANIMALS, null, msgs);
			msgs = basicSetAnimals(newAnimals, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__ANIMALS, newAnimals, newAnimals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventHistory getEventHistory() {
		return eventHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventHistory(EventHistory newEventHistory, NotificationChain msgs) {
		EventHistory oldEventHistory = eventHistory;
		eventHistory = newEventHistory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__EVENT_HISTORY, oldEventHistory, newEventHistory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventHistory(EventHistory newEventHistory) {
		if (newEventHistory != eventHistory) {
			NotificationChain msgs = null;
			if (eventHistory != null)
				msgs = ((InternalEObject)eventHistory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__EVENT_HISTORY, null, msgs);
			if (newEventHistory != null)
				msgs = ((InternalEObject)newEventHistory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__EVENT_HISTORY, null, msgs);
			msgs = basicSetEventHistory(newEventHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__EVENT_HISTORY, newEventHistory, newEventHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnAppliedTags getUnAppliedTags() {
		return unAppliedTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnAppliedTags(UnAppliedTags newUnAppliedTags, NotificationChain msgs) {
		UnAppliedTags oldUnAppliedTags = unAppliedTags;
		unAppliedTags = newUnAppliedTags;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__UN_APPLIED_TAGS, oldUnAppliedTags, newUnAppliedTags);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnAppliedTags(UnAppliedTags newUnAppliedTags) {
		if (newUnAppliedTags != unAppliedTags) {
			NotificationChain msgs = null;
			if (unAppliedTags != null)
				msgs = ((InternalEObject)unAppliedTags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__UN_APPLIED_TAGS, null, msgs);
			if (newUnAppliedTags != null)
				msgs = ((InternalEObject)newUnAppliedTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__UN_APPLIED_TAGS, null, msgs);
			msgs = basicSetUnAppliedTags(newUnAppliedTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__UN_APPLIED_TAGS, newUnAppliedTags, newUnAppliedTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.PREMISES__ANIMALS:
				return basicSetAnimals(null, msgs);
			case TrackerPackage.PREMISES__EVENT_HISTORY:
				return basicSetEventHistory(null, msgs);
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return basicSetUnAppliedTags(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.PREMISES__PREMISES_ID:
				return getPremisesId();
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				return getEmailContact();
			case TrackerPackage.PREMISES__ANIMALS:
				return getAnimals();
			case TrackerPackage.PREMISES__EVENT_HISTORY:
				return getEventHistory();
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return getUnAppliedTags();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.PREMISES__PREMISES_ID:
				setPremisesId((String)newValue);
				return;
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				setEmailContact((String)newValue);
				return;
			case TrackerPackage.PREMISES__ANIMALS:
				setAnimals((Animals)newValue);
				return;
			case TrackerPackage.PREMISES__EVENT_HISTORY:
				setEventHistory((EventHistory)newValue);
				return;
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				setUnAppliedTags((UnAppliedTags)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.PREMISES__PREMISES_ID:
				setPremisesId(PREMISES_ID_EDEFAULT);
				return;
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				setEmailContact(EMAIL_CONTACT_EDEFAULT);
				return;
			case TrackerPackage.PREMISES__ANIMALS:
				setAnimals((Animals)null);
				return;
			case TrackerPackage.PREMISES__EVENT_HISTORY:
				setEventHistory((EventHistory)null);
				return;
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				setUnAppliedTags((UnAppliedTags)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.PREMISES__PREMISES_ID:
				return PREMISES_ID_EDEFAULT == null ? premisesId != null : !PREMISES_ID_EDEFAULT.equals(premisesId);
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				return EMAIL_CONTACT_EDEFAULT == null ? emailContact != null : !EMAIL_CONTACT_EDEFAULT.equals(emailContact);
			case TrackerPackage.PREMISES__ANIMALS:
				return animals != null;
			case TrackerPackage.PREMISES__EVENT_HISTORY:
				return eventHistory != null;
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return unAppliedTags != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (premisesId: ");
		result.append(premisesId);
		result.append(", emailContact: ");
		result.append(emailContact);
		result.append(')');
		return result.toString();
	}

} //PremisesImpl