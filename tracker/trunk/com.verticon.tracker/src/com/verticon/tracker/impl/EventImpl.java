/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;
import com.verticon.tracker.util.TrackerConstants;
import com.verticon.tracker.util.TrackerUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getEventCode <em>Event Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#isElectronicallyRead <em>Electronically Read</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#isCorrection <em>Correction</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getDateKey <em>Date Key</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getPid <em>Pid</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.EventImpl#getPublisherName <em>Publisher Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventImpl extends MinimalEObjectImpl.Container implements Event {
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
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDateKey() <em>Date Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateKey()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_KEY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPid() <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPid()
	 * @generated
	 * @ordered
	 */
	protected static final String PID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPid() <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPid()
	 * @generated
	 * @ordered
	 */
	protected String pid = PID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublisherName() <em>Publisher Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisherName()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_NAME_EDEFAULT = null;

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
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDateTime(Date newDateTime) {
		Date oldDateTime = dateTime;
		dateTime = newDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__DATE_TIME, oldDateTime, dateTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract int getEventCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isElectronicallyRead() {
		return electronicallyRead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public boolean isCorrection() {
		return correction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__COMMENTS, oldComments, comments));
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tag getTag() {
		if (eContainerFeatureID() != TrackerPackage.EVENT__TAG) return null;
		return (Tag)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag basicGetTag() {
		if (eContainerFeatureID() != TrackerPackage.EVENT__TAG) return null;
		return (Tag)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTag(Tag newTag, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTag, TrackerPackage.EVENT__TAG, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTag(Tag newTag) {
		if (newTag != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.EVENT__TAG && newTag != null)) {
			if (EcoreUtil.isAncestor(this, newTag))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTag != null)
				msgs = ((InternalEObject)newTag).eInverseAdd(this, TrackerPackage.TAG__EVENTS, Tag.class, msgs);
			msgs = basicSetTag(newTag, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__TAG, newTag, newTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getId() {
		return getTag()!=null?getTag().getId():"";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("deprecation")
	public String getDate() {
		if(dateTime==null){
			return null;
		}
		return TrackerConstants.DAY_FORMAT.format(dateTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Used as a key for reporting and joining events by day
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getDateKey() {
		return getDate()+'|'+getId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPid() {
		return pid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPid(String newPid) {
		String oldPid = pid;
		pid = newPid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.EVENT__PID, oldPid, pid));
	}


	/**
	 * <!-- begin-user-doc -->
	 * Name of the premises that published the event to a ITrackerStore. 
	 * If there is no pid than it is the name of the enclosing premises.
	 * Will not resolve foreign publishers.  Use the findPublisherName() operation
	 * for that.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getPublisherName() {
		if(resolvedPublisherName!=null){
			return resolvedPublisherName;
		}
		String result = null;
		if(eContainer()!=null){
			//Has a tag parent
			if(eContainer().eContainer()!=null){
				//Has an animal grandParent
				if (eContainer().eContainer().eContainer() != null
						&& eContainer().eContainer().eContainer() instanceof Premises) {
					//Has an premises great-grandParent
					Premises premises = (Premises)eContainer().eContainer().eContainer();
					if(pid==null || pid.equals(premises.getUri())){
						result = premises.getName();
					}
				}
			}
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event dateEvent(final EventType type, final String name) {
		Event result = null;
				if(!dateEvents().isEmpty() && type!=null){
					CollectionFilter<Event> eventsProducer = new CollectionFilter<Event>();
					eventsProducer.addFilter(TrackerUtils.createFilterCriteria(type, name));
					List<Event> events = new ArrayList<Event>(eventsProducer.filterCopy(dateEvents()));
					if(events.isEmpty()){
						return null;
					}
					Collections.sort(events, TrackerUtils.DATE_COMPARATOR);
					result = events.get(events.size()-1);
				}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Event> dateEvents() {
		//Get all the days events
		if(getTag()!=null && getDate()!=null){
		CollectionFilter<Event> eventsProducer = new CollectionFilter<Event>();
			eventsProducer.addFilter(
					new FilterCriteria<Event>(){
		
						@Override
						public boolean passes(Event event) {
							return event.getDate().equals(EventImpl.this.getDate());
						}
					}
					
			);
			BasicEList<Event> events = new BasicEList<Event>(eventsProducer.filterCopy(getTag().getEvents()));
			return events;
		
		}
		EList<Event> result = ECollections.emptyEList();
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String values() {
		int last = toString().indexOf('(', toString().indexOf('(')+1);
		return last!=-1?
				toString().substring(last+1,toString().lastIndexOf(')')):null;
	}

	private String resolvedPublisherName = null;
	/**
	 * <!-- begin-user-doc -->
	 * Finds the local or foreign event publishers name. Uses the location service
	 * to find foreign publishers.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String findPublisherName() {
		String oldPublisherName = getPublisherName();
		resolvedPublisherName=null;
		String publisherName = getPublisherName();
		
		if(publisherName==null && pid!=null){
			resolvedPublisherName = TrackerPlugin.getDefault().name(pid);
		}
		
		String newPublisher = getPublisherName();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this, Notification.SET, TrackerPackage.EVENT__PUBLISHER_NAME, oldPublisherName, newPublisher));
		
		return newPublisher;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.EVENT__TAG:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTag((Tag)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.EVENT__TAG:
				return basicSetTag(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TrackerPackage.EVENT__TAG:
				return eInternalContainer().eInverseRemove(this, TrackerPackage.TAG__EVENTS, Tag.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.EVENT__DATE_TIME:
				return getDateTime();
			case TrackerPackage.EVENT__EVENT_CODE:
				return getEventCode();
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				return isElectronicallyRead();
			case TrackerPackage.EVENT__CORRECTION:
				return isCorrection();
			case TrackerPackage.EVENT__COMMENTS:
				return getComments();
			case TrackerPackage.EVENT__TAG:
				if (resolve) return getTag();
				return basicGetTag();
			case TrackerPackage.EVENT__ID:
				return getId();
			case TrackerPackage.EVENT__DATE:
				return getDate();
			case TrackerPackage.EVENT__DATE_KEY:
				return getDateKey();
			case TrackerPackage.EVENT__PID:
				return getPid();
			case TrackerPackage.EVENT__PUBLISHER_NAME:
				return getPublisherName();
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
			case TrackerPackage.EVENT__DATE_TIME:
				setDateTime((Date)newValue);
				return;
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				setElectronicallyRead((Boolean)newValue);
				return;
			case TrackerPackage.EVENT__CORRECTION:
				setCorrection((Boolean)newValue);
				return;
			case TrackerPackage.EVENT__COMMENTS:
				setComments((String)newValue);
				return;
			case TrackerPackage.EVENT__TAG:
				setTag((Tag)newValue);
				return;
			case TrackerPackage.EVENT__PID:
				setPid((String)newValue);
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
			case TrackerPackage.EVENT__DATE_TIME:
				setDateTime(DATE_TIME_EDEFAULT);
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
			case TrackerPackage.EVENT__TAG:
				setTag((Tag)null);
				return;
			case TrackerPackage.EVENT__PID:
				setPid(PID_EDEFAULT);
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
			case TrackerPackage.EVENT__DATE_TIME:
				return DATE_TIME_EDEFAULT == null ? dateTime != null : !DATE_TIME_EDEFAULT.equals(dateTime);
			case TrackerPackage.EVENT__EVENT_CODE:
				return getEventCode() != EVENT_CODE_EDEFAULT;
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
				return electronicallyRead != ELECTRONICALLY_READ_EDEFAULT;
			case TrackerPackage.EVENT__CORRECTION:
				return correction != CORRECTION_EDEFAULT;
			case TrackerPackage.EVENT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case TrackerPackage.EVENT__TAG:
				return basicGetTag() != null;
			case TrackerPackage.EVENT__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case TrackerPackage.EVENT__DATE:
				return DATE_EDEFAULT == null ? getDate() != null : !DATE_EDEFAULT.equals(getDate());
			case TrackerPackage.EVENT__DATE_KEY:
				return DATE_KEY_EDEFAULT == null ? getDateKey() != null : !DATE_KEY_EDEFAULT.equals(getDateKey());
			case TrackerPackage.EVENT__PID:
				return PID_EDEFAULT == null ? pid != null : !PID_EDEFAULT.equals(pid);
			case TrackerPackage.EVENT__PUBLISHER_NAME:
				return PUBLISHER_NAME_EDEFAULT == null ? getPublisherName() != null : !PUBLISHER_NAME_EDEFAULT.equals(getPublisherName());
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
		result.append(" (dateTime: ");
		result.append(dateTime);
		result.append(", electronicallyRead: ");
		result.append(electronicallyRead);
		result.append(", correction: ");
		result.append(correction);
		result.append(", comments: ");
		result.append(comments);
		result.append(", pid: ");
		result.append(pid);
		result.append(')');
		return result.toString();
	}

} //EventImpl