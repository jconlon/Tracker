/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.verticon.location.AltitudeMode;
import com.verticon.location.Area;
import com.verticon.location.Location;
import com.verticon.location.LocationFactory;
import com.verticon.location.LocationPackage;
import com.verticon.location.util.LocationValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationFactoryImpl extends EFactoryImpl implements LocationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LocationFactory init() {
		try {
			LocationFactory theLocationFactory = (LocationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.verticon.com/location/1.0/loc"); 
			if (theLocationFactory != null) {
				return theLocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LocationPackage.LOCATION: return createLocation();
			case LocationPackage.AREA: return createArea();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LocationPackage.ALTITUDE_MODE:
				return createAltitudeModeFromString(eDataType, initialValue);
			case LocationPackage.POINT_FORMAT_EXCEPTION:
				return createPointFormatExceptionFromString(eDataType, initialValue);
			case LocationPackage.POLYGON:
				return createPolygonFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LocationPackage.ALTITUDE_MODE:
				return convertAltitudeModeToString(eDataType, instanceValue);
			case LocationPackage.POINT_FORMAT_EXCEPTION:
				return convertPointFormatExceptionToString(eDataType, instanceValue);
			case LocationPackage.POLYGON:
				return convertPolygonToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location createLocation() {
		LocationImpl location = new LocationImpl();
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Area createArea() {
		AreaImpl area = new AreaImpl();
		return area;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltitudeMode createAltitudeModeFromString(EDataType eDataType, String initialValue) {
		AltitudeMode result = AltitudeMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAltitudeModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IllegalArgumentException createPointFormatExceptionFromString(EDataType eDataType, String initialValue) {
		return (IllegalArgumentException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPointFormatExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String createPolygonFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) {
			return null;
		}
		String polygon = initialValue.trim();
		if(polygon.isEmpty()){
			return null;
		}
		if(!LocationValidator.validateCoordinatesLength(polygon)){
			throw new IllegalArgumentException("Number of text segments seperated by a space must be greater than 3: "+polygon);
		}

		String errorMessage = LocationValidator.validateCoordinateFormat(polygon);
		if (errorMessage != null) {
			throw new IllegalArgumentException(errorMessage);
		}
		return polygon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPolygonToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationPackage getLocationPackage() {
		return (LocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LocationPackage getPackage() {
		return LocationPackage.eINSTANCE;
	}

} //LocationFactoryImpl
