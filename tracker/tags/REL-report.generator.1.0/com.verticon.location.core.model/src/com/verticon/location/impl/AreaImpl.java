/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.verticon.location.Area;
import com.verticon.location.LocationPackage;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.location.impl.AreaImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.verticon.location.impl.AreaImpl#getBoundary <em>Boundary</em>}</li>
 *   <li>{@link com.verticon.location.impl.AreaImpl#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AreaImpl extends MinimalEObjectImpl.Container implements Area {
	
	private Polygon polygon = null;
	
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
	 * The default value of the '{@link #getBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundary()
	 * @generated
	 * @ordered
	 */
	protected static final String BOUNDARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundary()
	 * @generated
	 * @ordered
	 */
	protected String boundary = BOUNDARY_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LocationPackage.Literals.AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.AREA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoundary() {
		return boundary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundaryGen(String newBoundary) {
		String oldBoundary = boundary;
		boundary = newBoundary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.AREA__BOUNDARY, oldBoundary, boundary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Clears the polygon after each set
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setBoundary(String boundary) {
		setBoundaryGen(boundary);
		polygon=null;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.AREA__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAreaMeasurement() {
		Polygon p = getPolygon();
		return p!=null?p.getArea():Double.NaN;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsPoint(String point) throws IllegalArgumentException {
		Point geoPoint = GeometryUtils.createPoint(point);
		Polygon p = getPolygon();
		return p!=null&&geoPoint!=null?p.contains(geoPoint):false;
	}
	
	private Polygon getPolygon(){
		if(polygon==null){
			polygon = GeometryUtils.createPolygon(boundary);
		}
		return polygon;
	}
	
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.AREA__NAME:
				return getName();
			case LocationPackage.AREA__BOUNDARY:
				return getBoundary();
			case LocationPackage.AREA__COMMENTS:
				return getComments();
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
			case LocationPackage.AREA__NAME:
				setName((String)newValue);
				return;
			case LocationPackage.AREA__BOUNDARY:
				setBoundary((String)newValue);
				return;
			case LocationPackage.AREA__COMMENTS:
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
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LocationPackage.AREA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LocationPackage.AREA__BOUNDARY:
				setBoundary(BOUNDARY_EDEFAULT);
				return;
			case LocationPackage.AREA__COMMENTS:
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LocationPackage.AREA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LocationPackage.AREA__BOUNDARY:
				return BOUNDARY_EDEFAULT == null ? boundary != null : !BOUNDARY_EDEFAULT.equals(boundary);
			case LocationPackage.AREA__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", boundary: ");
		result.append(boundary);
		result.append(", comments: ");
		result.append(comments);
		result.append(')');
		return result.toString();
	}

} //AreaImpl
