/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.XalFactory;
import com.verticon.oasis.xal.XalPackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XalPackageImpl extends EPackageImpl implements XalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "xal.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressDetailsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLatitudeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLatitudeDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLinesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLongitudeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLongitudeDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass administrativeAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass administrativeAreaNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass barcodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildingNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryNameCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass departmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass departmentNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentLocalityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentLocalityNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentLocalityNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentThoroughfareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endorsementLineCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firmNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyLineCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass largeMailUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass largeMailUserIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass largeMailUserNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localityNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailStopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailStopNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailStopNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalCodeNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalCodeNumberExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalRouteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalRouteNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalRouteNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalServiceElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBoxNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBoxNumberExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBoxNumberPrefixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBoxNumberSuffixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postOfficeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postOfficeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postOfficeNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postTownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postTownNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postTownSuffixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberPrefixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberRangeFromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberRangeToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premiseNumberSuffixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sortingCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAdministrativeAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAdministrativeAreaNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseNumberPrefixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subPremiseNumberSuffixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplementaryPostalServiceDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareLeadingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberFromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberPrefixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberSuffixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareNumberToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfarePostDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfarePreDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thoroughfareTrailingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependentThoroughfaresTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurrence1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurrence2EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurrence3EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indicatorOccurrence4EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nameNumberOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberRangeOccurenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberRangeOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberTypeOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberTypeOccurrence1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numberTypeType1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rangeTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeOccurrenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeOccurrence1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeOccurrence2EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dependentThoroughfaresTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurrenceObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurrenceObject2EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurrenceObject3EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType indicatorOccurrenceObject4EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nameNumberOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberRangeOccurenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberRangeOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberTypeOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberTypeOccurrenceObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberTypeTypeObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rangeTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeOccurrenceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeOccurrenceObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeOccurrenceObject2EDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.verticon.oasis.xal.XalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XalPackageImpl() {
		super(eNS_URI, XalFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static XalPackage init() {
		if (isInited) return (XalPackage)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI);

		// Obtain or create and register package
		XalPackageImpl theXalPackage = (XalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Load packages
		theXalPackage.loadPackage();

		// Fix loaded packages
		theXalPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theXalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XalPackage.eNS_URI, theXalPackage);
		return theXalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddress() {
		if (addressEClass == null) {
			addressEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(0);
		}
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Mixed() {
        return (EAttribute)getAddress().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Code() {
        return (EAttribute)getAddress().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Type() {
        return (EAttribute)getAddress().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_AnyAttribute() {
        return (EAttribute)getAddress().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressDetails() {
		if (addressDetailsEClass == null) {
			addressDetailsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(1);
		}
		return addressDetailsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_PostalServiceElements() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_Address() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_AddressLines() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_Country() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_AdministrativeArea() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_Locality() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressDetails_Thoroughfare() {
        return (EReference)getAddressDetails().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_Any() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_AddressDetailsKey() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_AddressType() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_Code() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_CurrentStatus() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_Usage() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_ValidFromDate() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_ValidToDate() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressDetails_AnyAttribute() {
        return (EAttribute)getAddressDetails().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressIdentifier() {
		if (addressIdentifierEClass == null) {
			addressIdentifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(2);
		}
		return addressIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressIdentifier_Mixed() {
        return (EAttribute)getAddressIdentifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressIdentifier_Code() {
        return (EAttribute)getAddressIdentifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressIdentifier_IdentifierType() {
        return (EAttribute)getAddressIdentifier().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressIdentifier_Type() {
        return (EAttribute)getAddressIdentifier().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressIdentifier_AnyAttribute() {
        return (EAttribute)getAddressIdentifier().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLatitude() {
		if (addressLatitudeEClass == null) {
			addressLatitudeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(3);
		}
		return addressLatitudeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitude_Mixed() {
        return (EAttribute)getAddressLatitude().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitude_Code() {
        return (EAttribute)getAddressLatitude().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitude_Type() {
        return (EAttribute)getAddressLatitude().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitude_AnyAttribute() {
        return (EAttribute)getAddressLatitude().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLatitudeDirection() {
		if (addressLatitudeDirectionEClass == null) {
			addressLatitudeDirectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(4);
		}
		return addressLatitudeDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitudeDirection_Mixed() {
        return (EAttribute)getAddressLatitudeDirection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitudeDirection_Code() {
        return (EAttribute)getAddressLatitudeDirection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitudeDirection_Type() {
        return (EAttribute)getAddressLatitudeDirection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLatitudeDirection_AnyAttribute() {
        return (EAttribute)getAddressLatitudeDirection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLine() {
		if (addressLineEClass == null) {
			addressLineEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(5);
		}
		return addressLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLine_Mixed() {
        return (EAttribute)getAddressLine().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLine_Code() {
        return (EAttribute)getAddressLine().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLine_Type() {
        return (EAttribute)getAddressLine().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLine_AnyAttribute() {
        return (EAttribute)getAddressLine().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLines() {
		if (addressLinesEClass == null) {
			addressLinesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(6);
		}
		return addressLinesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddressLines_AddressLine() {
        return (EReference)getAddressLines().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLines_Any() {
        return (EAttribute)getAddressLines().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLines_AnyAttribute() {
        return (EAttribute)getAddressLines().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLongitude() {
		if (addressLongitudeEClass == null) {
			addressLongitudeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(7);
		}
		return addressLongitudeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitude_Mixed() {
        return (EAttribute)getAddressLongitude().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitude_Code() {
        return (EAttribute)getAddressLongitude().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitude_Type() {
        return (EAttribute)getAddressLongitude().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitude_AnyAttribute() {
        return (EAttribute)getAddressLongitude().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressLongitudeDirection() {
		if (addressLongitudeDirectionEClass == null) {
			addressLongitudeDirectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(8);
		}
		return addressLongitudeDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitudeDirection_Mixed() {
        return (EAttribute)getAddressLongitudeDirection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitudeDirection_Code() {
        return (EAttribute)getAddressLongitudeDirection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitudeDirection_Type() {
        return (EAttribute)getAddressLongitudeDirection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressLongitudeDirection_AnyAttribute() {
        return (EAttribute)getAddressLongitudeDirection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdministrativeArea() {
		if (administrativeAreaEClass == null) {
			administrativeAreaEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(9);
		}
		return administrativeAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_AddressLine() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_AdministrativeAreaName() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_SubAdministrativeArea() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_Locality() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_PostOffice() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdministrativeArea_PostalCode() {
        return (EReference)getAdministrativeArea().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeArea_Any() {
        return (EAttribute)getAdministrativeArea().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeArea_Indicator() {
        return (EAttribute)getAdministrativeArea().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeArea_Type() {
        return (EAttribute)getAdministrativeArea().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeArea_UsageType() {
        return (EAttribute)getAdministrativeArea().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeArea_AnyAttribute() {
        return (EAttribute)getAdministrativeArea().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdministrativeAreaName() {
		if (administrativeAreaNameEClass == null) {
			administrativeAreaNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(10);
		}
		return administrativeAreaNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeAreaName_Mixed() {
        return (EAttribute)getAdministrativeAreaName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeAreaName_Code() {
        return (EAttribute)getAdministrativeAreaName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeAreaName_Type() {
        return (EAttribute)getAdministrativeAreaName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdministrativeAreaName_AnyAttribute() {
        return (EAttribute)getAdministrativeAreaName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBarcode() {
		if (barcodeEClass == null) {
			barcodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(11);
		}
		return barcodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarcode_Mixed() {
        return (EAttribute)getBarcode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarcode_Code() {
        return (EAttribute)getBarcode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarcode_Type() {
        return (EAttribute)getBarcode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBarcode_AnyAttribute() {
        return (EAttribute)getBarcode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildingName() {
		if (buildingNameEClass == null) {
			buildingNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(12);
		}
		return buildingNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildingName_Mixed() {
        return (EAttribute)getBuildingName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildingName_Code() {
        return (EAttribute)getBuildingName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildingName_Type() {
        return (EAttribute)getBuildingName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildingName_TypeOccurrence() {
        return (EAttribute)getBuildingName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildingName_AnyAttribute() {
        return (EAttribute)getBuildingName().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountry() {
		if (countryEClass == null) {
			countryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(13);
		}
		return countryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_AddressLine() {
        return (EReference)getCountry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_CountryNameCode() {
        return (EReference)getCountry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_CountryName() {
        return (EReference)getCountry().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_AdministrativeArea() {
        return (EReference)getCountry().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Locality() {
        return (EReference)getCountry().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Thoroughfare() {
        return (EReference)getCountry().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_Any() {
        return (EAttribute)getCountry().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_AnyAttribute() {
        return (EAttribute)getCountry().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountryName() {
		if (countryNameEClass == null) {
			countryNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(14);
		}
		return countryNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryName_Mixed() {
        return (EAttribute)getCountryName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryName_Code() {
        return (EAttribute)getCountryName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryName_Type() {
        return (EAttribute)getCountryName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryName_AnyAttribute() {
        return (EAttribute)getCountryName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountryNameCode() {
		if (countryNameCodeEClass == null) {
			countryNameCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(15);
		}
		return countryNameCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryNameCode_Mixed() {
        return (EAttribute)getCountryNameCode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryNameCode_Code() {
        return (EAttribute)getCountryNameCode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryNameCode_Scheme() {
        return (EAttribute)getCountryNameCode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryNameCode_AnyAttribute() {
        return (EAttribute)getCountryNameCode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDepartment() {
		if (departmentEClass == null) {
			departmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(16);
		}
		return departmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_AddressLine() {
        return (EReference)getDepartment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_DepartmentName() {
        return (EReference)getDepartment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_MailStop() {
        return (EReference)getDepartment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDepartment_PostalCode() {
        return (EReference)getDepartment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_Any() {
        return (EAttribute)getDepartment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_Type() {
        return (EAttribute)getDepartment().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartment_AnyAttribute() {
        return (EAttribute)getDepartment().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDepartmentName() {
		if (departmentNameEClass == null) {
			departmentNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(17);
		}
		return departmentNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartmentName_Mixed() {
        return (EAttribute)getDepartmentName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartmentName_Code() {
        return (EAttribute)getDepartmentName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartmentName_Type() {
        return (EAttribute)getDepartmentName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDepartmentName_AnyAttribute() {
        return (EAttribute)getDepartmentName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependentLocality() {
		if (dependentLocalityEClass == null) {
			dependentLocalityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(18);
		}
		return dependentLocalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_AddressLine() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_DependentLocalityName() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_DependentLocalityNumber() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_PostBox() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_LargeMailUser() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_PostOffice() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_PostalRoute() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_Thoroughfare() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_Premise() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_DependentLocality() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentLocality_PostalCode() {
        return (EReference)getDependentLocality().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_Any() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_Connector() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_Indicator() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_Type() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_UsageType() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocality_AnyAttribute() {
        return (EAttribute)getDependentLocality().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependentLocalityName() {
		if (dependentLocalityNameEClass == null) {
			dependentLocalityNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(19);
		}
		return dependentLocalityNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityName_Mixed() {
        return (EAttribute)getDependentLocalityName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityName_Code() {
        return (EAttribute)getDependentLocalityName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityName_Type() {
        return (EAttribute)getDependentLocalityName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityName_AnyAttribute() {
        return (EAttribute)getDependentLocalityName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependentLocalityNumber() {
		if (dependentLocalityNumberEClass == null) {
			dependentLocalityNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(20);
		}
		return dependentLocalityNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityNumber_Mixed() {
        return (EAttribute)getDependentLocalityNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityNumber_Code() {
        return (EAttribute)getDependentLocalityNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityNumber_NameNumberOccurrence() {
        return (EAttribute)getDependentLocalityNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentLocalityNumber_AnyAttribute() {
        return (EAttribute)getDependentLocalityNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependentThoroughfare() {
		if (dependentThoroughfareEClass == null) {
			dependentThoroughfareEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(21);
		}
		return dependentThoroughfareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_AddressLine() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_ThoroughfarePreDirection() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_ThoroughfareLeadingType() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_ThoroughfareName() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_ThoroughfareTrailingType() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentThoroughfare_ThoroughfarePostDirection() {
        return (EReference)getDependentThoroughfare().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentThoroughfare_Any() {
        return (EAttribute)getDependentThoroughfare().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentThoroughfare_Type() {
        return (EAttribute)getDependentThoroughfare().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependentThoroughfare_AnyAttribute() {
        return (EAttribute)getDependentThoroughfare().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		if (documentRootEClass == null) {
			documentRootEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(24);
		}
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)getDocumentRoot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AddressDetails() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AddressLine() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AdministrativeArea() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CountryName() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Department() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Locality() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PostalCode() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PostBox() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PostOffice() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Premise() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PremiseNumber() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PremiseNumberPrefix() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PremiseNumberSuffix() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Thoroughfare() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ThoroughfareNumber() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ThoroughfareNumberPrefix() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ThoroughfareNumberSuffix() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XAL() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndorsementLineCode() {
		if (endorsementLineCodeEClass == null) {
			endorsementLineCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(25);
		}
		return endorsementLineCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndorsementLineCode_Mixed() {
        return (EAttribute)getEndorsementLineCode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndorsementLineCode_Code() {
        return (EAttribute)getEndorsementLineCode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndorsementLineCode_Type() {
        return (EAttribute)getEndorsementLineCode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndorsementLineCode_AnyAttribute() {
        return (EAttribute)getEndorsementLineCode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFirm() {
		if (firmEClass == null) {
			firmEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(26);
		}
		return firmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirm_AddressLine() {
        return (EReference)getFirm().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirm_FirmName() {
        return (EReference)getFirm().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirm_Department() {
        return (EReference)getFirm().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirm_MailStop() {
        return (EReference)getFirm().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFirm_PostalCode() {
        return (EReference)getFirm().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirm_Any() {
        return (EAttribute)getFirm().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirm_Type() {
        return (EAttribute)getFirm().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirm_AnyAttribute() {
        return (EAttribute)getFirm().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFirmName() {
		if (firmNameEClass == null) {
			firmNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(27);
		}
		return firmNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirmName_Mixed() {
        return (EAttribute)getFirmName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirmName_Code() {
        return (EAttribute)getFirmName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirmName_Type() {
        return (EAttribute)getFirmName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFirmName_AnyAttribute() {
        return (EAttribute)getFirmName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyLineCode() {
		if (keyLineCodeEClass == null) {
			keyLineCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(40);
		}
		return keyLineCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyLineCode_Mixed() {
        return (EAttribute)getKeyLineCode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyLineCode_Code() {
        return (EAttribute)getKeyLineCode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyLineCode_Type() {
        return (EAttribute)getKeyLineCode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyLineCode_AnyAttribute() {
        return (EAttribute)getKeyLineCode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLargeMailUser() {
		if (largeMailUserEClass == null) {
			largeMailUserEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(41);
		}
		return largeMailUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_AddressLine() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_LargeMailUserName() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_LargeMailUserIdentifier() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_BuildingName() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_Department() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_PostBox() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_Thoroughfare() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLargeMailUser_PostalCode() {
        return (EReference)getLargeMailUser().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUser_Any() {
        return (EAttribute)getLargeMailUser().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUser_Type() {
        return (EAttribute)getLargeMailUser().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUser_AnyAttribute() {
        return (EAttribute)getLargeMailUser().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLargeMailUserIdentifier() {
		if (largeMailUserIdentifierEClass == null) {
			largeMailUserIdentifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(42);
		}
		return largeMailUserIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserIdentifier_Mixed() {
        return (EAttribute)getLargeMailUserIdentifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserIdentifier_Code() {
        return (EAttribute)getLargeMailUserIdentifier().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserIdentifier_Indicator() {
        return (EAttribute)getLargeMailUserIdentifier().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserIdentifier_Type() {
        return (EAttribute)getLargeMailUserIdentifier().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserIdentifier_AnyAttribute() {
        return (EAttribute)getLargeMailUserIdentifier().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLargeMailUserName() {
		if (largeMailUserNameEClass == null) {
			largeMailUserNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(43);
		}
		return largeMailUserNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserName_Mixed() {
        return (EAttribute)getLargeMailUserName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserName_Code() {
        return (EAttribute)getLargeMailUserName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserName_Type() {
        return (EAttribute)getLargeMailUserName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLargeMailUserName_AnyAttribute() {
        return (EAttribute)getLargeMailUserName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocality() {
		if (localityEClass == null) {
			localityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(44);
		}
		return localityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_AddressLine() {
        return (EReference)getLocality().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_LocalityName() {
        return (EReference)getLocality().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_PostBox() {
        return (EReference)getLocality().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_LargeMailUser() {
        return (EReference)getLocality().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_PostOffice() {
        return (EReference)getLocality().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_PostalRoute() {
        return (EReference)getLocality().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_Thoroughfare() {
        return (EReference)getLocality().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_Premise() {
        return (EReference)getLocality().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_DependentLocality() {
        return (EReference)getLocality().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocality_PostalCode() {
        return (EReference)getLocality().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocality_Any() {
        return (EAttribute)getLocality().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocality_Indicator() {
        return (EAttribute)getLocality().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocality_Type() {
        return (EAttribute)getLocality().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocality_UsageType() {
        return (EAttribute)getLocality().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocality_AnyAttribute() {
        return (EAttribute)getLocality().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalityName() {
		if (localityNameEClass == null) {
			localityNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(45);
		}
		return localityNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalityName_Mixed() {
        return (EAttribute)getLocalityName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalityName_Code() {
        return (EAttribute)getLocalityName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalityName_Type() {
        return (EAttribute)getLocalityName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalityName_AnyAttribute() {
        return (EAttribute)getLocalityName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailStop() {
		if (mailStopEClass == null) {
			mailStopEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(46);
		}
		return mailStopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMailStop_AddressLine() {
        return (EReference)getMailStop().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMailStop_MailStopName() {
        return (EReference)getMailStop().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMailStop_MailStopNumber() {
        return (EReference)getMailStop().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStop_Any() {
        return (EAttribute)getMailStop().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStop_Type() {
        return (EAttribute)getMailStop().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStop_AnyAttribute() {
        return (EAttribute)getMailStop().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailStopName() {
		if (mailStopNameEClass == null) {
			mailStopNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(47);
		}
		return mailStopNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopName_Mixed() {
        return (EAttribute)getMailStopName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopName_Code() {
        return (EAttribute)getMailStopName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopName_Type() {
        return (EAttribute)getMailStopName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopName_AnyAttribute() {
        return (EAttribute)getMailStopName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailStopNumber() {
		if (mailStopNumberEClass == null) {
			mailStopNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(48);
		}
		return mailStopNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopNumber_Mixed() {
        return (EAttribute)getMailStopNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopNumber_Code() {
        return (EAttribute)getMailStopNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopNumber_NameNumberSeparator() {
        return (EAttribute)getMailStopNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailStopNumber_AnyAttribute() {
        return (EAttribute)getMailStopNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalCode() {
		if (postalCodeEClass == null) {
			postalCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(65);
		}
		return postalCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalCode_AddressLine() {
        return (EReference)getPostalCode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalCode_PostalCodeNumber() {
        return (EReference)getPostalCode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalCode_PostalCodeNumberExtension() {
        return (EReference)getPostalCode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalCode_PostTown() {
        return (EReference)getPostalCode().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCode_Any() {
        return (EAttribute)getPostalCode().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCode_Type() {
        return (EAttribute)getPostalCode().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCode_AnyAttribute() {
        return (EAttribute)getPostalCode().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalCodeNumber() {
		if (postalCodeNumberEClass == null) {
			postalCodeNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(66);
		}
		return postalCodeNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumber_Mixed() {
        return (EAttribute)getPostalCodeNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumber_Code() {
        return (EAttribute)getPostalCodeNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumber_Type() {
        return (EAttribute)getPostalCodeNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumber_AnyAttribute() {
        return (EAttribute)getPostalCodeNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalCodeNumberExtension() {
		if (postalCodeNumberExtensionEClass == null) {
			postalCodeNumberExtensionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(67);
		}
		return postalCodeNumberExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumberExtension_Mixed() {
        return (EAttribute)getPostalCodeNumberExtension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumberExtension_Code() {
        return (EAttribute)getPostalCodeNumberExtension().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumberExtension_NumberExtensionSeparator() {
        return (EAttribute)getPostalCodeNumberExtension().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumberExtension_Type() {
        return (EAttribute)getPostalCodeNumberExtension().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalCodeNumberExtension_AnyAttribute() {
        return (EAttribute)getPostalCodeNumberExtension().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalRoute() {
		if (postalRouteEClass == null) {
			postalRouteEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(68);
		}
		return postalRouteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalRoute_AddressLine() {
        return (EReference)getPostalRoute().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalRoute_PostalRouteName() {
        return (EReference)getPostalRoute().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalRoute_PostalRouteNumber() {
        return (EReference)getPostalRoute().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalRoute_PostBox() {
        return (EReference)getPostalRoute().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRoute_Any() {
        return (EAttribute)getPostalRoute().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRoute_Type() {
        return (EAttribute)getPostalRoute().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRoute_AnyAttribute() {
        return (EAttribute)getPostalRoute().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalRouteName() {
		if (postalRouteNameEClass == null) {
			postalRouteNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(69);
		}
		return postalRouteNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteName_Mixed() {
        return (EAttribute)getPostalRouteName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteName_Code() {
        return (EAttribute)getPostalRouteName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteName_Type() {
        return (EAttribute)getPostalRouteName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteName_AnyAttribute() {
        return (EAttribute)getPostalRouteName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalRouteNumber() {
		if (postalRouteNumberEClass == null) {
			postalRouteNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(70);
		}
		return postalRouteNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteNumber_Mixed() {
        return (EAttribute)getPostalRouteNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteNumber_Code() {
        return (EAttribute)getPostalRouteNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalRouteNumber_AnyAttribute() {
        return (EAttribute)getPostalRouteNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalServiceElements() {
		if (postalServiceElementsEClass == null) {
			postalServiceElementsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(71);
		}
		return postalServiceElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_AddressIdentifier() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_EndorsementLineCode() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_KeyLineCode() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_Barcode() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_SortingCode() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_AddressLatitude() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_AddressLatitudeDirection() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_AddressLongitude() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_AddressLongitudeDirection() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostalServiceElements_SupplementaryPostalServiceData() {
        return (EReference)getPostalServiceElements().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalServiceElements_Any() {
        return (EAttribute)getPostalServiceElements().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalServiceElements_Type() {
        return (EAttribute)getPostalServiceElements().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalServiceElements_AnyAttribute() {
        return (EAttribute)getPostalServiceElements().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBox() {
		if (postBoxEClass == null) {
			postBoxEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(72);
		}
		return postBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_AddressLine() {
        return (EReference)getPostBox().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_PostBoxNumber() {
        return (EReference)getPostBox().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_PostBoxNumberPrefix() {
        return (EReference)getPostBox().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_PostBoxNumberSuffix() {
        return (EReference)getPostBox().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_PostBoxNumberExtension() {
        return (EReference)getPostBox().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_Firm() {
        return (EReference)getPostBox().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostBox_PostalCode() {
        return (EReference)getPostBox().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBox_Any() {
        return (EAttribute)getPostBox().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBox_Indicator() {
        return (EAttribute)getPostBox().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBox_Type() {
        return (EAttribute)getPostBox().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBox_AnyAttribute() {
        return (EAttribute)getPostBox().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBoxNumber() {
		if (postBoxNumberEClass == null) {
			postBoxNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(73);
		}
		return postBoxNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumber_Mixed() {
        return (EAttribute)getPostBoxNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumber_Code() {
        return (EAttribute)getPostBoxNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumber_AnyAttribute() {
        return (EAttribute)getPostBoxNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBoxNumberExtension() {
		if (postBoxNumberExtensionEClass == null) {
			postBoxNumberExtensionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(74);
		}
		return postBoxNumberExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberExtension_Mixed() {
        return (EAttribute)getPostBoxNumberExtension().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberExtension_NumberExtensionSeparator() {
        return (EAttribute)getPostBoxNumberExtension().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberExtension_AnyAttribute() {
        return (EAttribute)getPostBoxNumberExtension().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBoxNumberPrefix() {
		if (postBoxNumberPrefixEClass == null) {
			postBoxNumberPrefixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(75);
		}
		return postBoxNumberPrefixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberPrefix_Mixed() {
        return (EAttribute)getPostBoxNumberPrefix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberPrefix_Code() {
        return (EAttribute)getPostBoxNumberPrefix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberPrefix_NumberPrefixSeparator() {
        return (EAttribute)getPostBoxNumberPrefix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberPrefix_AnyAttribute() {
        return (EAttribute)getPostBoxNumberPrefix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBoxNumberSuffix() {
		if (postBoxNumberSuffixEClass == null) {
			postBoxNumberSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(76);
		}
		return postBoxNumberSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberSuffix_Mixed() {
        return (EAttribute)getPostBoxNumberSuffix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberSuffix_Code() {
        return (EAttribute)getPostBoxNumberSuffix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberSuffix_NumberSuffixSeparator() {
        return (EAttribute)getPostBoxNumberSuffix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostBoxNumberSuffix_AnyAttribute() {
        return (EAttribute)getPostBoxNumberSuffix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostOffice() {
		if (postOfficeEClass == null) {
			postOfficeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(77);
		}
		return postOfficeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_AddressLine() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_PostOfficeName() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_PostOfficeNumber() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_PostalRoute() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_PostBox() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostOffice_PostalCode() {
        return (EReference)getPostOffice().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOffice_Any() {
        return (EAttribute)getPostOffice().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOffice_Indicator() {
        return (EAttribute)getPostOffice().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOffice_Type() {
        return (EAttribute)getPostOffice().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOffice_AnyAttribute() {
        return (EAttribute)getPostOffice().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostOfficeName() {
		if (postOfficeNameEClass == null) {
			postOfficeNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(78);
		}
		return postOfficeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeName_Mixed() {
        return (EAttribute)getPostOfficeName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeName_Code() {
        return (EAttribute)getPostOfficeName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeName_Type() {
        return (EAttribute)getPostOfficeName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeName_AnyAttribute() {
        return (EAttribute)getPostOfficeName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostOfficeNumber() {
		if (postOfficeNumberEClass == null) {
			postOfficeNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(79);
		}
		return postOfficeNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeNumber_Mixed() {
        return (EAttribute)getPostOfficeNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeNumber_Code() {
        return (EAttribute)getPostOfficeNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeNumber_Indicator() {
        return (EAttribute)getPostOfficeNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeNumber_IndicatorOccurrence() {
        return (EAttribute)getPostOfficeNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostOfficeNumber_AnyAttribute() {
        return (EAttribute)getPostOfficeNumber().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostTown() {
		if (postTownEClass == null) {
			postTownEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(80);
		}
		return postTownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostTown_AddressLine() {
        return (EReference)getPostTown().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostTown_PostTownName() {
        return (EReference)getPostTown().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostTown_PostTownSuffix() {
        return (EReference)getPostTown().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTown_Type() {
        return (EAttribute)getPostTown().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTown_AnyAttribute() {
        return (EAttribute)getPostTown().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostTownName() {
		if (postTownNameEClass == null) {
			postTownNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(81);
		}
		return postTownNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownName_Mixed() {
        return (EAttribute)getPostTownName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownName_Code() {
        return (EAttribute)getPostTownName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownName_Type() {
        return (EAttribute)getPostTownName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownName_AnyAttribute() {
        return (EAttribute)getPostTownName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostTownSuffix() {
		if (postTownSuffixEClass == null) {
			postTownSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(82);
		}
		return postTownSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownSuffix_Mixed() {
        return (EAttribute)getPostTownSuffix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownSuffix_Code() {
        return (EAttribute)getPostTownSuffix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostTownSuffix_AnyAttribute() {
        return (EAttribute)getPostTownSuffix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremise() {
		if (premiseEClass == null) {
			premiseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(83);
		}
		return premiseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_AddressLine() {
        return (EReference)getPremise().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseName() {
        return (EReference)getPremise().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseLocation() {
        return (EReference)getPremise().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseNumber() {
        return (EReference)getPremise().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseNumberRange() {
        return (EReference)getPremise().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseNumberPrefix() {
        return (EReference)getPremise().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PremiseNumberSuffix() {
        return (EReference)getPremise().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_BuildingName() {
        return (EReference)getPremise().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_SubPremise() {
        return (EReference)getPremise().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_Firm() {
        return (EReference)getPremise().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_MailStop() {
        return (EReference)getPremise().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_PostalCode() {
        return (EReference)getPremise().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremise_Premise() {
        return (EReference)getPremise().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_Any() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_PremiseDependency() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_PremiseDependencyType() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_PremiseThoroughfareConnector() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_Type() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremise_AnyAttribute() {
        return (EAttribute)getPremise().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseLocation() {
		if (premiseLocationEClass == null) {
			premiseLocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(84);
		}
		return premiseLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseLocation_Mixed() {
        return (EAttribute)getPremiseLocation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseLocation_Code() {
        return (EAttribute)getPremiseLocation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseLocation_AnyAttribute() {
        return (EAttribute)getPremiseLocation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseName() {
		if (premiseNameEClass == null) {
			premiseNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(85);
		}
		return premiseNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseName_Mixed() {
        return (EAttribute)getPremiseName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseName_Code() {
        return (EAttribute)getPremiseName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseName_Type() {
        return (EAttribute)getPremiseName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseName_TypeOccurrence() {
        return (EAttribute)getPremiseName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseName_AnyAttribute() {
        return (EAttribute)getPremiseName().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumber() {
		if (premiseNumberEClass == null) {
			premiseNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(86);
		}
		return premiseNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_Mixed() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_Code() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_Indicator() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_IndicatorOccurrence() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_NumberType() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_NumberTypeOccurrence() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_Type() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumber_AnyAttribute() {
        return (EAttribute)getPremiseNumber().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumberPrefix() {
		if (premiseNumberPrefixEClass == null) {
			premiseNumberPrefixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(87);
		}
		return premiseNumberPrefixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberPrefix_Value() {
        return (EAttribute)getPremiseNumberPrefix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberPrefix_Code() {
        return (EAttribute)getPremiseNumberPrefix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberPrefix_NumberPrefixSeparator() {
        return (EAttribute)getPremiseNumberPrefix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberPrefix_Type() {
        return (EAttribute)getPremiseNumberPrefix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberPrefix_AnyAttribute() {
        return (EAttribute)getPremiseNumberPrefix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumberRange() {
		if (premiseNumberRangeEClass == null) {
			premiseNumberRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(88);
		}
		return premiseNumberRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRange_PremiseNumberRangeFrom() {
        return (EReference)getPremiseNumberRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRange_PremiseNumberRangeTo() {
        return (EReference)getPremiseNumberRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_Indicator() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_IndicatorOccurence() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_NumberRangeOccurence() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_RangeType() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_Separator() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberRange_Type() {
        return (EAttribute)getPremiseNumberRange().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumberRangeFrom() {
		if (premiseNumberRangeFromEClass == null) {
			premiseNumberRangeFromEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(89);
		}
		return premiseNumberRangeFromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeFrom_AddressLine() {
        return (EReference)getPremiseNumberRangeFrom().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeFrom_PremiseNumberPrefix() {
        return (EReference)getPremiseNumberRangeFrom().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeFrom_PremiseNumber() {
        return (EReference)getPremiseNumberRangeFrom().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeFrom_PremiseNumberSuffix() {
        return (EReference)getPremiseNumberRangeFrom().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumberRangeTo() {
		if (premiseNumberRangeToEClass == null) {
			premiseNumberRangeToEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(90);
		}
		return premiseNumberRangeToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeTo_AddressLine() {
        return (EReference)getPremiseNumberRangeTo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeTo_PremiseNumberPrefix() {
        return (EReference)getPremiseNumberRangeTo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeTo_PremiseNumber() {
        return (EReference)getPremiseNumberRangeTo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremiseNumberRangeTo_PremiseNumberSuffix() {
        return (EReference)getPremiseNumberRangeTo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremiseNumberSuffix() {
		if (premiseNumberSuffixEClass == null) {
			premiseNumberSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(91);
		}
		return premiseNumberSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberSuffix_Mixed() {
        return (EAttribute)getPremiseNumberSuffix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberSuffix_Code() {
        return (EAttribute)getPremiseNumberSuffix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberSuffix_NumberSuffixSeparator() {
        return (EAttribute)getPremiseNumberSuffix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberSuffix_Type() {
        return (EAttribute)getPremiseNumberSuffix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremiseNumberSuffix_AnyAttribute() {
        return (EAttribute)getPremiseNumberSuffix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSortingCode() {
		if (sortingCodeEClass == null) {
			sortingCodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(94);
		}
		return sortingCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortingCode_Code() {
        return (EAttribute)getSortingCode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortingCode_Type() {
        return (EAttribute)getSortingCode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAdministrativeArea() {
		if (subAdministrativeAreaEClass == null) {
			subAdministrativeAreaEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(95);
		}
		return subAdministrativeAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAdministrativeArea_AddressLine() {
        return (EReference)getSubAdministrativeArea().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAdministrativeArea_SubAdministrativeAreaName() {
        return (EReference)getSubAdministrativeArea().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAdministrativeArea_Locality() {
        return (EReference)getSubAdministrativeArea().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAdministrativeArea_PostOffice() {
        return (EReference)getSubAdministrativeArea().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAdministrativeArea_PostalCode() {
        return (EReference)getSubAdministrativeArea().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeArea_Any() {
        return (EAttribute)getSubAdministrativeArea().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeArea_Indicator() {
        return (EAttribute)getSubAdministrativeArea().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeArea_Type() {
        return (EAttribute)getSubAdministrativeArea().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeArea_UsageType() {
        return (EAttribute)getSubAdministrativeArea().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeArea_AnyAttribute() {
        return (EAttribute)getSubAdministrativeArea().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAdministrativeAreaName() {
		if (subAdministrativeAreaNameEClass == null) {
			subAdministrativeAreaNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(96);
		}
		return subAdministrativeAreaNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeAreaName_Mixed() {
        return (EAttribute)getSubAdministrativeAreaName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeAreaName_Code() {
        return (EAttribute)getSubAdministrativeAreaName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeAreaName_Type() {
        return (EAttribute)getSubAdministrativeAreaName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAdministrativeAreaName_AnyAttribute() {
        return (EAttribute)getSubAdministrativeAreaName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremise() {
		if (subPremiseEClass == null) {
			subPremiseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(97);
		}
		return subPremiseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_AddressLine() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremiseName() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremiseLocation() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremiseNumber() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremiseNumberPrefix() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremiseNumberSuffix() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_BuildingName() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_Firm() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_MailStop() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_PostalCode() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubPremise_SubPremise() {
        return (EReference)getSubPremise().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremise_Any() {
        return (EAttribute)getSubPremise().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremise_Type() {
        return (EAttribute)getSubPremise().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremise_AnyAttribute() {
        return (EAttribute)getSubPremise().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremiseLocation() {
		if (subPremiseLocationEClass == null) {
			subPremiseLocationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(98);
		}
		return subPremiseLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseLocation_Mixed() {
        return (EAttribute)getSubPremiseLocation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseLocation_Code() {
        return (EAttribute)getSubPremiseLocation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremiseName() {
		if (subPremiseNameEClass == null) {
			subPremiseNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(99);
		}
		return subPremiseNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseName_Mixed() {
        return (EAttribute)getSubPremiseName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseName_Code() {
        return (EAttribute)getSubPremiseName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseName_Type() {
        return (EAttribute)getSubPremiseName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseName_TypeOccurrence() {
        return (EAttribute)getSubPremiseName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseName_AnyAttribute() {
        return (EAttribute)getSubPremiseName().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremiseNumber() {
		if (subPremiseNumberEClass == null) {
			subPremiseNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(100);
		}
		return subPremiseNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_Mixed() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_Code() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_Indicator() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_IndicatorOccurrence() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_NumberTypeOccurrence() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_PremiseNumberSeparator() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_Type() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumber_AnyAttribute() {
        return (EAttribute)getSubPremiseNumber().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremiseNumberPrefix() {
		if (subPremiseNumberPrefixEClass == null) {
			subPremiseNumberPrefixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(101);
		}
		return subPremiseNumberPrefixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberPrefix_Mixed() {
        return (EAttribute)getSubPremiseNumberPrefix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberPrefix_Code() {
        return (EAttribute)getSubPremiseNumberPrefix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberPrefix_NumberPrefixSeparator() {
        return (EAttribute)getSubPremiseNumberPrefix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberPrefix_Type() {
        return (EAttribute)getSubPremiseNumberPrefix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberPrefix_AnyAttribute() {
        return (EAttribute)getSubPremiseNumberPrefix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubPremiseNumberSuffix() {
		if (subPremiseNumberSuffixEClass == null) {
			subPremiseNumberSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(102);
		}
		return subPremiseNumberSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberSuffix_Mixed() {
        return (EAttribute)getSubPremiseNumberSuffix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberSuffix_Code() {
        return (EAttribute)getSubPremiseNumberSuffix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberSuffix_NumberSuffixSeparator() {
        return (EAttribute)getSubPremiseNumberSuffix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberSuffix_Type() {
        return (EAttribute)getSubPremiseNumberSuffix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubPremiseNumberSuffix_AnyAttribute() {
        return (EAttribute)getSubPremiseNumberSuffix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupplementaryPostalServiceData() {
		if (supplementaryPostalServiceDataEClass == null) {
			supplementaryPostalServiceDataEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(103);
		}
		return supplementaryPostalServiceDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplementaryPostalServiceData_Mixed() {
        return (EAttribute)getSupplementaryPostalServiceData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplementaryPostalServiceData_Code() {
        return (EAttribute)getSupplementaryPostalServiceData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplementaryPostalServiceData_Type() {
        return (EAttribute)getSupplementaryPostalServiceData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupplementaryPostalServiceData_AnyAttribute() {
        return (EAttribute)getSupplementaryPostalServiceData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfare() {
		if (thoroughfareEClass == null) {
			thoroughfareEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(104);
		}
		return thoroughfareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_AddressLine() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_Group() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareNumber() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareNumberRange() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareNumberPrefix() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareNumberSuffix() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfarePreDirection() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareLeadingType() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareName() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfareTrailingType() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_ThoroughfarePostDirection() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_DependentThoroughfare() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_DependentLocality() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_Premise() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_Firm() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfare_PostalCode() {
        return (EReference)getThoroughfare().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_Any() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_DependentThoroughfares() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_DependentThoroughfaresConnector() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_DependentThoroughfaresIndicator() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_DependentThoroughfaresType() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_Type() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfare_AnyAttribute() {
        return (EAttribute)getThoroughfare().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareLeadingType() {
		if (thoroughfareLeadingTypeEClass == null) {
			thoroughfareLeadingTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(105);
		}
		return thoroughfareLeadingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareLeadingType_Mixed() {
        return (EAttribute)getThoroughfareLeadingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareLeadingType_Code() {
        return (EAttribute)getThoroughfareLeadingType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareLeadingType_Type() {
        return (EAttribute)getThoroughfareLeadingType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareLeadingType_AnyAttribute() {
        return (EAttribute)getThoroughfareLeadingType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareName() {
		if (thoroughfareNameEClass == null) {
			thoroughfareNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(106);
		}
		return thoroughfareNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareName_Mixed() {
        return (EAttribute)getThoroughfareName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareName_Code() {
        return (EAttribute)getThoroughfareName().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareName_Type() {
        return (EAttribute)getThoroughfareName().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareName_AnyAttribute() {
        return (EAttribute)getThoroughfareName().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumber() {
		if (thoroughfareNumberEClass == null) {
			thoroughfareNumberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(107);
		}
		return thoroughfareNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_Mixed() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_Code() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_Indicator() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_IndicatorOccurrence() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_NumberOccurrence() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_NumberType() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_Type() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumber_AnyAttribute() {
        return (EAttribute)getThoroughfareNumber().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumberFrom() {
		if (thoroughfareNumberFromEClass == null) {
			thoroughfareNumberFromEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(108);
		}
		return thoroughfareNumberFromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberFrom_Mixed() {
        return (EAttribute)getThoroughfareNumberFrom().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberFrom_AddressLine() {
        return (EReference)getThoroughfareNumberFrom().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberFrom_ThoroughfareNumberPrefix() {
        return (EReference)getThoroughfareNumberFrom().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberFrom_ThoroughfareNumber() {
        return (EReference)getThoroughfareNumberFrom().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberFrom_ThoroughfareNumberSuffix() {
        return (EReference)getThoroughfareNumberFrom().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberFrom_Code() {
        return (EAttribute)getThoroughfareNumberFrom().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberFrom_AnyAttribute() {
        return (EAttribute)getThoroughfareNumberFrom().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumberPrefix() {
		if (thoroughfareNumberPrefixEClass == null) {
			thoroughfareNumberPrefixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(109);
		}
		return thoroughfareNumberPrefixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberPrefix_Mixed() {
        return (EAttribute)getThoroughfareNumberPrefix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberPrefix_Code() {
        return (EAttribute)getThoroughfareNumberPrefix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberPrefix_NumberPrefixSeparator() {
        return (EAttribute)getThoroughfareNumberPrefix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberPrefix_Type() {
        return (EAttribute)getThoroughfareNumberPrefix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberPrefix_AnyAttribute() {
        return (EAttribute)getThoroughfareNumberPrefix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumberRange() {
		if (thoroughfareNumberRangeEClass == null) {
			thoroughfareNumberRangeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(110);
		}
		return thoroughfareNumberRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberRange_AddressLine() {
        return (EReference)getThoroughfareNumberRange().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberRange_ThoroughfareNumberFrom() {
        return (EReference)getThoroughfareNumberRange().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberRange_ThoroughfareNumberTo() {
        return (EReference)getThoroughfareNumberRange().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_Code() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_Indicator() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_IndicatorOccurrence() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_NumberRangeOccurrence() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_RangeType() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_Separator() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_Type() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberRange_AnyAttribute() {
        return (EAttribute)getThoroughfareNumberRange().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumberSuffix() {
		if (thoroughfareNumberSuffixEClass == null) {
			thoroughfareNumberSuffixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(111);
		}
		return thoroughfareNumberSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberSuffix_Mixed() {
        return (EAttribute)getThoroughfareNumberSuffix().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberSuffix_Code() {
        return (EAttribute)getThoroughfareNumberSuffix().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberSuffix_NumberSuffixSeparator() {
        return (EAttribute)getThoroughfareNumberSuffix().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberSuffix_Type() {
        return (EAttribute)getThoroughfareNumberSuffix().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberSuffix_AnyAttribute() {
        return (EAttribute)getThoroughfareNumberSuffix().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareNumberTo() {
		if (thoroughfareNumberToEClass == null) {
			thoroughfareNumberToEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(112);
		}
		return thoroughfareNumberToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberTo_Mixed() {
        return (EAttribute)getThoroughfareNumberTo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberTo_AddressLine() {
        return (EReference)getThoroughfareNumberTo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberTo_ThoroughfareNumberPrefix() {
        return (EReference)getThoroughfareNumberTo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberTo_ThoroughfareNumber() {
        return (EReference)getThoroughfareNumberTo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThoroughfareNumberTo_ThoroughfareNumberSuffix() {
        return (EReference)getThoroughfareNumberTo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberTo_Code() {
        return (EAttribute)getThoroughfareNumberTo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareNumberTo_AnyAttribute() {
        return (EAttribute)getThoroughfareNumberTo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfarePostDirection() {
		if (thoroughfarePostDirectionEClass == null) {
			thoroughfarePostDirectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(113);
		}
		return thoroughfarePostDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePostDirection_Mixed() {
        return (EAttribute)getThoroughfarePostDirection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePostDirection_Code() {
        return (EAttribute)getThoroughfarePostDirection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePostDirection_Type() {
        return (EAttribute)getThoroughfarePostDirection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePostDirection_AnyAttribute() {
        return (EAttribute)getThoroughfarePostDirection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfarePreDirection() {
		if (thoroughfarePreDirectionEClass == null) {
			thoroughfarePreDirectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(114);
		}
		return thoroughfarePreDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePreDirection_Mixed() {
        return (EAttribute)getThoroughfarePreDirection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePreDirection_Code() {
        return (EAttribute)getThoroughfarePreDirection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePreDirection_Type() {
        return (EAttribute)getThoroughfarePreDirection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfarePreDirection_AnyAttribute() {
        return (EAttribute)getThoroughfarePreDirection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThoroughfareTrailingType() {
		if (thoroughfareTrailingTypeEClass == null) {
			thoroughfareTrailingTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(115);
		}
		return thoroughfareTrailingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareTrailingType_Mixed() {
        return (EAttribute)getThoroughfareTrailingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareTrailingType_Code() {
        return (EAttribute)getThoroughfareTrailingType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareTrailingType_Type() {
        return (EAttribute)getThoroughfareTrailingType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThoroughfareTrailingType_AnyAttribute() {
        return (EAttribute)getThoroughfareTrailingType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXal() {
		if (xalEClass == null) {
			xalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(122);
		}
		return xalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXal_AddressDetails() {
        return (EReference)getXal().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXal_Any() {
        return (EAttribute)getXal().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXal_Version() {
        return (EAttribute)getXal().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXal_AnyAttribute() {
        return (EAttribute)getXal().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDependentThoroughfaresType() {
		if (dependentThoroughfaresTypeEEnum == null) {
			dependentThoroughfaresTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(22);
		}
		return dependentThoroughfaresTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurence() {
		if (indicatorOccurenceEEnum == null) {
			indicatorOccurenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(28);
		}
		return indicatorOccurenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurrence() {
		if (indicatorOccurrenceEEnum == null) {
			indicatorOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(30);
		}
		return indicatorOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurrence1() {
		if (indicatorOccurrence1EEnum == null) {
			indicatorOccurrence1EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(31);
		}
		return indicatorOccurrence1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurrence2() {
		if (indicatorOccurrence2EEnum == null) {
			indicatorOccurrence2EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(32);
		}
		return indicatorOccurrence2EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurrence3() {
		if (indicatorOccurrence3EEnum == null) {
			indicatorOccurrence3EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(33);
		}
		return indicatorOccurrence3EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndicatorOccurrence4() {
		if (indicatorOccurrence4EEnum == null) {
			indicatorOccurrence4EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(34);
		}
		return indicatorOccurrence4EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNameNumberOccurrence() {
		if (nameNumberOccurrenceEEnum == null) {
			nameNumberOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(49);
		}
		return nameNumberOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberOccurrence() {
		if (numberOccurrenceEEnum == null) {
			numberOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(51);
		}
		return numberOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberRangeOccurence() {
		if (numberRangeOccurenceEEnum == null) {
			numberRangeOccurenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(53);
		}
		return numberRangeOccurenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberRangeOccurrence() {
		if (numberRangeOccurrenceEEnum == null) {
			numberRangeOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(55);
		}
		return numberRangeOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberTypeOccurrence() {
		if (numberTypeOccurrenceEEnum == null) {
			numberTypeOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(57);
		}
		return numberTypeOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberTypeOccurrence1() {
		if (numberTypeOccurrence1EEnum == null) {
			numberTypeOccurrence1EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(58);
		}
		return numberTypeOccurrence1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberTypeType() {
		if (numberTypeTypeEEnum == null) {
			numberTypeTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(61);
		}
		return numberTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumberTypeType1() {
		if (numberTypeType1EEnum == null) {
			numberTypeType1EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(62);
		}
		return numberTypeType1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRangeTypeType() {
		if (rangeTypeTypeEEnum == null) {
			rangeTypeTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(92);
		}
		return rangeTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeOccurrence() {
		if (typeOccurrenceEEnum == null) {
			typeOccurrenceEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(116);
		}
		return typeOccurrenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeOccurrence1() {
		if (typeOccurrence1EEnum == null) {
			typeOccurrence1EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(117);
		}
		return typeOccurrence1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeOccurrence2() {
		if (typeOccurrence2EEnum == null) {
			typeOccurrence2EEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(118);
		}
		return typeOccurrence2EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDependentThoroughfaresTypeObject() {
		if (dependentThoroughfaresTypeObjectEDataType == null) {
			dependentThoroughfaresTypeObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(23);
		}
		return dependentThoroughfaresTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurenceObject() {
		if (indicatorOccurenceObjectEDataType == null) {
			indicatorOccurenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(29);
		}
		return indicatorOccurenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurrenceObject() {
		if (indicatorOccurrenceObjectEDataType == null) {
			indicatorOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(35);
		}
		return indicatorOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurrenceObject1() {
		if (indicatorOccurrenceObject1EDataType == null) {
			indicatorOccurrenceObject1EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(36);
		}
		return indicatorOccurrenceObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurrenceObject2() {
		if (indicatorOccurrenceObject2EDataType == null) {
			indicatorOccurrenceObject2EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(37);
		}
		return indicatorOccurrenceObject2EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurrenceObject3() {
		if (indicatorOccurrenceObject3EDataType == null) {
			indicatorOccurrenceObject3EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(38);
		}
		return indicatorOccurrenceObject3EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIndicatorOccurrenceObject4() {
		if (indicatorOccurrenceObject4EDataType == null) {
			indicatorOccurrenceObject4EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(39);
		}
		return indicatorOccurrenceObject4EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNameNumberOccurrenceObject() {
		if (nameNumberOccurrenceObjectEDataType == null) {
			nameNumberOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(50);
		}
		return nameNumberOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberOccurrenceObject() {
		if (numberOccurrenceObjectEDataType == null) {
			numberOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(52);
		}
		return numberOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberRangeOccurenceObject() {
		if (numberRangeOccurenceObjectEDataType == null) {
			numberRangeOccurenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(54);
		}
		return numberRangeOccurenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberRangeOccurrenceObject() {
		if (numberRangeOccurrenceObjectEDataType == null) {
			numberRangeOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(56);
		}
		return numberRangeOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberTypeOccurrenceObject() {
		if (numberTypeOccurrenceObjectEDataType == null) {
			numberTypeOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(59);
		}
		return numberTypeOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberTypeOccurrenceObject1() {
		if (numberTypeOccurrenceObject1EDataType == null) {
			numberTypeOccurrenceObject1EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(60);
		}
		return numberTypeOccurrenceObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberTypeTypeObject() {
		if (numberTypeTypeObjectEDataType == null) {
			numberTypeTypeObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(63);
		}
		return numberTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberTypeTypeObject1() {
		if (numberTypeTypeObject1EDataType == null) {
			numberTypeTypeObject1EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(64);
		}
		return numberTypeTypeObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRangeTypeTypeObject() {
		if (rangeTypeTypeObjectEDataType == null) {
			rangeTypeTypeObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(93);
		}
		return rangeTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeOccurrenceObject() {
		if (typeOccurrenceObjectEDataType == null) {
			typeOccurrenceObjectEDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(119);
		}
		return typeOccurrenceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeOccurrenceObject1() {
		if (typeOccurrenceObject1EDataType == null) {
			typeOccurrenceObject1EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(120);
		}
		return typeOccurrenceObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeOccurrenceObject2() {
		if (typeOccurrenceObject2EDataType == null) {
			typeOccurrenceObject2EDataType = (EDataType)EPackage.Registry.INSTANCE.getEPackage(XalPackage.eNS_URI).getEClassifiers().get(121);
		}
		return typeOccurrenceObject2EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XalFactory getXalFactory() {
		return (XalFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("com.verticon.oasis.xal." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //XalPackageImpl
