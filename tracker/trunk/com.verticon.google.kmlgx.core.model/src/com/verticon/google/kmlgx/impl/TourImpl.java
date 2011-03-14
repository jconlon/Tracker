/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.Playlist;
import com.verticon.google.kmlgx.Tour;
import com.verticon.opengis.kml.impl.FeatureImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.TourImpl#getPlaylist <em>Playlist</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TourImpl extends FeatureImpl implements Tour {
	/**
	 * The cached value of the '{@link #getPlaylist() <em>Playlist</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaylist()
	 * @generated
	 * @ordered
	 */
	protected Playlist playlist;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.TOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playlist getPlaylist() {
		return playlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlaylist(Playlist newPlaylist, NotificationChain msgs) {
		Playlist oldPlaylist = playlist;
		playlist = newPlaylist;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmlgxPackage.TOUR__PLAYLIST, oldPlaylist, newPlaylist);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaylist(Playlist newPlaylist) {
		if (newPlaylist != playlist) {
			NotificationChain msgs = null;
			if (playlist != null)
				msgs = ((InternalEObject)playlist).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TOUR__PLAYLIST, null, msgs);
			if (newPlaylist != null)
				msgs = ((InternalEObject)newPlaylist).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TOUR__PLAYLIST, null, msgs);
			msgs = basicSetPlaylist(newPlaylist, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TOUR__PLAYLIST, newPlaylist, newPlaylist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.TOUR__PLAYLIST:
				return basicSetPlaylist(null, msgs);
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
			case KmlgxPackage.TOUR__PLAYLIST:
				return getPlaylist();
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
			case KmlgxPackage.TOUR__PLAYLIST:
				setPlaylist((Playlist)newValue);
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
			case KmlgxPackage.TOUR__PLAYLIST:
				setPlaylist((Playlist)null);
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
			case KmlgxPackage.TOUR__PLAYLIST:
				return playlist != null;
		}
		return super.eIsSet(featureID);
	}

} //TourImpl
