/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getAin <em>Ain</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getEventCode <em>Event Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#isElectronicallyRead <em>Electronically Read</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#isCorrection <em>Correction</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventImpl extends EObjectImpl implements Event {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getDateTime() <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateTime() <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTime()
	 * @generated
	 * @ordered
	 */
	protected Date dateTime = DATE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAin() <em>Ain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAin()
	 * @generated
	 * @ordered
	 */
	protected AnimalId ain = null;

	/**
	 * The default value of the '{@link #getEventCode() <em>Event Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventCode()
	 * @generated
	 * @ordered
	 */
	protected static final int EVENT_CODE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isElectronicallyRead() <em>Electronically Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isElectronicallyRead()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ELECTRONICALLY_READ_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isElectronicallyRead() <em>Electronically Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isElectronicallyRead()
	 * @generated
	 * @ordered
	 */
	protected boolean electronicallyRead = ELECTRONICALLY_READ_EDEFAULT;

	/**
	 * The default value of the '{@link #isCorrection() <em>Correction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CORRECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCorrection() <em>Correction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrection()
	 * @generated
	 * @ordered
	 */
	protected boolean correction = CORRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EventImpl() {
		super();
		dateTime = new Date();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateTime(Date newDateTime) {
		Date oldDateTime = dateTime;
		dateTime = newDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalId getAin() {
		if (ain != null && ain.eIsProxy()) {
			InternalEObject oldAin = (InternalEObject)ain;
			ain = (AnimalId)eResolveProxy(oldAin);
			if (ain != oldAin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.EVENT__AIN, oldAin, ain));
			}
		}
		return ain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalId basicGetAin() {
		return ain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAin(AnimalId newAin) {
		AnimalId oldAin = ain;
		ain = newAin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__AIN, oldAin, ain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract int getEventCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isElectronicallyRead() {
		return electronicallyRead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectronicallyRead(boolean newElectronicallyRead) {
		boolean oldElectronicallyRead = electronicallyRead;
		electronicallyRead = newElectronicallyRead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__ELECTRONICALLY_READ, oldElectronicallyRead, electronicallyRead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCorrection() {
		return correction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrection(boolean newCorrection) {
		boolean oldCorrection = correction;
		correction = newCorrection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__CORRECTION, oldCorrection, correction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long getId() {
		return getAin()!=null?Long.parseLong(getAin().getIdNumber()):0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.EVENT__DATE_TIME:
				return getDateTime();
			case TrackerPackage.EVENT__AIN:
				if (resolve) return getAin();
				return basicGetAin();
			case TrackerPackage.EVENT__EVENT_CODE:
				return new Integer(getEventCode());
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				return isElectronicallyRead() ? Boolean.TRUE : Boolean.FALSE;
			case TrackerPackage.EVENT__CORRECTION:
				return isCorrection() ? Boolean.TRUE : Boolean.FALSE;
			case TrackerPackage.EVENT__COMMENTS:
				return getComments();
			case TrackerPackage.EVENT__ID:
				return new Long(getId());
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
			case TrackerPackage.EVENT__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.EVENT__AIN:
				setAin((AnimalId)newValue);
				return;
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				setElectronicallyRead(((Boolean)newValue).booleanValue());
				return;
			case TrackerPackage.EVENT__CORRECTION:
				setCorrection(((Boolean)newValue).booleanValue());
				return;
			case TrackerPackage.EVENT__COMMENTS:
				setComments((String)newValue);
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
			case TrackerPackage.EVENT__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
				return;
			case TrackerPackage.EVENT__AIN:
				setAin((AnimalId)null);
				return;
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				setElectronicallyRead(ELECTRONICALLY_READ_EDEFAULT);
				return;
			case TrackerPackage.EVENT__CORRECTION:
				setCorrection(CORRECTION_EDEFAULT);
				return;
			case TrackerPackage.EVENT__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
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
			case TrackerPackage.EVENT__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.EVENT__AIN:
				return ain != null;
			case TrackerPackage.EVENT__EVENT_CODE:
				return getEventCode() != EVENT_CODE_EDEFAULT;
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				return electronicallyRead != ELECTRONICALLY_READ_EDEFAULT;
			case TrackerPackage.EVENT__CORRECTION:
				return correction != CORRECTION_EDEFAULT;
			case TrackerPackage.EVENT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case TrackerPackage.EVENT__ID:
				return getId() != ID_EDEFAULT;
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
		result.append(" (dateTime: ");
		result.append(dateTime);
		result.append(", electronicallyRead: ");
		result.append(electronicallyRead);
		result.append(", correction: ");
		result.append(correction);
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //EventImpl