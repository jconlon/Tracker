/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.agriculture.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.verticon.agriculture.AgriculturePackage;
import com.verticon.agriculture.Location;
import com.verticon.opengis.kml.Feature;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * 
 * See http://dev.eclipse.org/newslists/news.eclipse.tools.emf/msg33053.html for dealing with 
 * derived attributes.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getGeography <em>Geography</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getLivestock <em>Livestock</em>}</li>
 *   <li>{@link com.verticon.agriculture.impl.LocationImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends MinimalEObjectImpl.Container implements Location {
	/**
	 * The cached value of the '{@link #getGeography() <em>Geography</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeography()
	 * @generated
	 * @ordered
	 */
	protected com.verticon.opengis.kml.Container geography;

	/**
	 * The cached value of the '{@link #getLivestock() <em>Livestock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLivestock()
	 * @generated
	 * @ordered
	 */
	protected Premises livestock;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AgriculturePackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.verticon.opengis.kml.Container getGeography() {
		if (geography != null && geography.eIsProxy()) {
			InternalEObject oldGeography = (InternalEObject)geography;
			geography = (com.verticon.opengis.kml.Container)eResolveProxy(oldGeography);
			if (geography != oldGeography) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AgriculturePackage.LOCATION__GEOGRAPHY, oldGeography, geography));
			}
		}
		return geography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.verticon.opengis.kml.Container basicGetGeography() {
		return geography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeography(com.verticon.opengis.kml.Container newGeography) {
		com.verticon.opengis.kml.Container oldGeography = geography;
		geography = newGeography;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__GEOGRAPHY, oldGeography, geography));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises getLivestock() {
		if (livestock != null && livestock.eIsProxy()) {
			InternalEObject oldLivestock = (InternalEObject)livestock;
			livestock = (Premises)eResolveProxy(oldLivestock);
			if (livestock != oldLivestock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AgriculturePackage.LOCATION__LIVESTOCK, oldLivestock, livestock));
			}
		}
		return livestock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises basicGetLivestock() {
		return livestock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLivestock(Premises newLivestock) {
		Premises oldLivestock = livestock;
		livestock = newLivestock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgriculturePackage.LOCATION__LIVESTOCK, oldLivestock, livestock));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUri() {
		return getLivestock()==null?null:livestock.getUri();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				if (resolve) return getGeography();
				return basicGetGeography();
			case AgriculturePackage.LOCATION__LIVESTOCK:
				if (resolve) return getLivestock();
				return basicGetLivestock();
			case AgriculturePackage.LOCATION__URI:
				return getUri();
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				setGeography((com.verticon.opengis.kml.Container)newValue);
				return;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				setLivestock((Premises)newValue);
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				setGeography((com.verticon.opengis.kml.Container)null);
				return;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				setLivestock((Premises)null);
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
			case AgriculturePackage.LOCATION__GEOGRAPHY:
				return geography != null;
			case AgriculturePackage.LOCATION__LIVESTOCK:
				return livestock != null;
			case AgriculturePackage.LOCATION__URI:
				return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * Added to manage notifications for the derived attribute uri.
	 */
	private Adapter derivedURIAdapter = new AdapterImpl(){

		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification notification) {
			switch (notification.getFeatureID(Feature.class)) {
			case TrackerPackage.PREMISES__URI:
				fireNameChange(notification.getOldStringValue(),notification.getNewStringValue());
				break;

			}
		}

		private void fireNameChange(String oldFeatureName, String newFeatureName){
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(
						LocationImpl.this, 
						Notification.SET, AgriculturePackage.LOCATION__URI, oldFeatureName, newFeatureName));
		}
	};

	
	/** 
	 * Added to manage notifications for the derived attribute name.
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * Added to manage notifications for the derived attribute name.
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		if (notification.getFeature() == AgriculturePackage.Literals.LOCATION__LIVESTOCK)
		{
			switch (notification.getEventType())
			{
			case Notification.SET:
			case Notification.RESOLVE:
			{
				Premises oldValue = (Premises)notification.getOldValue();
				if (oldValue != null)
				{
					oldValue.eAdapters().remove(derivedURIAdapter);
				}
				Premises newValue = (Premises)notification.getNewValue();
				if (newValue != null)
				{
					newValue.eAdapters().add(derivedURIAdapter);
					
				}
				break;
			}
			}
		}
		super.eNotify(notification);
	}
	
	

} //LocationImpl
