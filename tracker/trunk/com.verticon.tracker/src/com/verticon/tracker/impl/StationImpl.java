/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 */
package com.verticon.tracker.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.tracker.Premises;
import com.verticon.tracker.SensorEvent;
import com.verticon.tracker.Station;
import com.verticon.tracker.StationLocation;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Station</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getPremises <em>Premises</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getLocationName <em>Location Name</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.StationImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StationImpl extends MinimalEObjectImpl.Container implements Station {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

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
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocationName() <em>Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationName()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCoordinates() <em>Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
	protected static final String COORDINATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<SensorEvent> events;

	private StationLocation lastLocation = null;
	private int lastNumberOfEvents = 0;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.STATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Premises getPremises() {
		if (eContainerFeatureID() != TrackerPackage.STATION__PREMISES) return null;
		return (Premises)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises basicGetPremises() {
		if (eContainerFeatureID() != TrackerPackage.STATION__PREMISES) return null;
		return (Premises)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremises(Premises newPremises, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPremises, TrackerPackage.STATION__PREMISES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPremises(Premises newPremises) {
		if (newPremises != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.STATION__PREMISES && newPremises != null)) {
			if (EcoreUtil.isAncestor(this, newPremises))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPremises != null)
				msgs = ((InternalEObject)newPremises).eInverseAdd(this, TrackerPackage.PREMISES__STATIONS, Premises.class, msgs);
			msgs = basicSetPremises(newPremises, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.STATION__PREMISES, newPremises, newPremises));
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getLocationName() {
		getCoordinates();
		return lastLocation != null ? lastLocation.getLocationName() : "";
	}



	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getCoordinates() {
		if (getEvents().size() != lastNumberOfEvents) {
			lastNumberOfEvents = getEvents().size();
			lastLocation = getLastLocation(getEvents());
		}
		return lastLocation != null ? lastLocation.getCoordinates() : "";

	}

	private static StationLocation getLastLocation(Collection<SensorEvent> events) {
		if (events.isEmpty()) {
			return null;
		}
		StationLocation result = null;
		for (SensorEvent event : events) {
			if(event instanceof StationLocation) {
				StationLocation stationLocation = (StationLocation) event;
				if (result == null) {
					result = stationLocation;
				} else {
					if (result.getDateTime().before(
							stationLocation.getDateTime())) {
						result = stationLocation;
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
	public EList<SensorEvent> getEvents() {
		if (events == null) {
			events = new EObjectContainmentWithInverseEList.Resolving<SensorEvent>(SensorEvent.class, this, TrackerPackage.STATION__EVENTS, TrackerPackage.SENSOR_EVENT__STATION);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.STATION__PREMISES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPremises((Premises)otherEnd, msgs);
			case TrackerPackage.STATION__EVENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvents()).basicAdd(otherEnd, msgs);
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
			case TrackerPackage.STATION__PREMISES:
				return basicSetPremises(null, msgs);
			case TrackerPackage.STATION__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
			case TrackerPackage.STATION__PREMISES:
				return eInternalContainer().eInverseRemove(this, TrackerPackage.PREMISES__STATIONS, Premises.class, msgs);
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
			case TrackerPackage.STATION__ID:
				return getId();
			case TrackerPackage.STATION__NAME:
				return getName();
			case TrackerPackage.STATION__DESCRIPTION:
				return getDescription();
			case TrackerPackage.STATION__PREMISES:
				if (resolve) return getPremises();
				return basicGetPremises();
			case TrackerPackage.STATION__LOCATION_NAME:
				return getLocationName();
			case TrackerPackage.STATION__COORDINATES:
				return getCoordinates();
			case TrackerPackage.STATION__EVENTS:
				return getEvents();
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
			case TrackerPackage.STATION__ID:
				setId((String)newValue);
				return;
			case TrackerPackage.STATION__NAME:
				setName((String)newValue);
				return;
			case TrackerPackage.STATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case TrackerPackage.STATION__PREMISES:
				setPremises((Premises)newValue);
				return;
			case TrackerPackage.STATION__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends SensorEvent>)newValue);
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
			case TrackerPackage.STATION__ID:
				setId(ID_EDEFAULT);
				return;
			case TrackerPackage.STATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TrackerPackage.STATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case TrackerPackage.STATION__PREMISES:
				setPremises((Premises)null);
				return;
			case TrackerPackage.STATION__EVENTS:
				getEvents().clear();
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
			case TrackerPackage.STATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TrackerPackage.STATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TrackerPackage.STATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case TrackerPackage.STATION__PREMISES:
				return basicGetPremises() != null;
			case TrackerPackage.STATION__LOCATION_NAME:
				return LOCATION_NAME_EDEFAULT == null ? getLocationName() != null : !LOCATION_NAME_EDEFAULT.equals(getLocationName());
			case TrackerPackage.STATION__COORDINATES:
				return COORDINATES_EDEFAULT == null ? getCoordinates() != null : !COORDINATES_EDEFAULT.equals(getCoordinates());
			case TrackerPackage.STATION__EVENTS:
				return events != null && !events.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}


} //StationImpl
