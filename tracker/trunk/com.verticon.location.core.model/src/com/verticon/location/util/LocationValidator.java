/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.location.util;

import com.verticon.location.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.verticon.location.LocationPackage
 * @generated
 */
public class LocationValidator extends EObjectValidator {
	
	public static final String COORDINATE_REGEX = "^(\\-?\\d+(\\.\\d+)?),(\\-?\\d+(\\.\\d+)?),(\\-?\\d+(\\.\\d+)?)$";
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LocationValidator INSTANCE = new LocationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.verticon.location";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return LocationPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case LocationPackage.LOCATION:
				return validateLocation((Location)value, diagnostics, context);
			case LocationPackage.AREA:
				return validateArea((Area)value, diagnostics, context);
			case LocationPackage.ALTITUDE_MODE:
				return validateAltitudeMode((AltitudeMode)value, diagnostics, context);
			case LocationPackage.POINT_FORMAT_EXCEPTION:
				return validatePointFormatException((IllegalArgumentException)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocation(Location location, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(location, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArea(Area area, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(area, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(area, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(area, diagnostics, context);
		if (result || diagnostics != null) result &= validateArea_ValidCoordinatesFormat(area, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidCoordinatesFormat constraint of '<em>Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateArea_ValidCoordinatesFormat(Area area, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String coordinates = area.getBoundry().trim();
		String[] coords = coordinates.split(" ");
		//There must be 3 or more coordinates
		boolean isValid = coords.length>2;
		if(isValid){
			//All must be valid coordinates
			for (String string : coords) {
				if(!string.matches(COORDINATE_REGEX)){
					isValid=false;
					break;
				}
			}
			if(isValid){
				//The first and the last must be the same coordinates
				String first = coords[0];
				String last = coords[coords.length-1];
				isValid = first.equals(last);
			}
		}
		
		
		if (!isValid) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "ValidCoordinatesFormat", getObjectLabel(area, context) },
						 new Object[] { area },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAltitudeMode(AltitudeMode altitudeMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePointFormatException(IllegalArgumentException pointFormatException, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //LocationValidator
