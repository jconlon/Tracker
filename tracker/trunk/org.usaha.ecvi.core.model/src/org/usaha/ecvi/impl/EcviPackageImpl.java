/**
 */
package org.usaha.ecvi.impl;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.usaha.ecvi.Accession;
import org.usaha.ecvi.Accessions;
import org.usaha.ecvi.Address;
import org.usaha.ecvi.Animal;
import org.usaha.ecvi.AnimalTag;
import org.usaha.ecvi.Attachement;
import org.usaha.ecvi.Contact;
import org.usaha.ecvi.DocType;
import org.usaha.ecvi.DocumentRoot;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.GeoPoint;
import org.usaha.ecvi.GroupLot;
import org.usaha.ecvi.ISO3166Country;
import org.usaha.ecvi.Laboratory;
import org.usaha.ecvi.MovementPurpose;
import org.usaha.ecvi.MovementPurposes;
import org.usaha.ecvi.Person;
import org.usaha.ecvi.PhoneDevice;
import org.usaha.ecvi.PhoneNum;
import org.usaha.ecvi.Premises;
import org.usaha.ecvi.ProgramStatus;
import org.usaha.ecvi.ProgramStatusName;
import org.usaha.ecvi.ProgramStatusValue;
import org.usaha.ecvi.ResultName;
import org.usaha.ecvi.ResultValue;
import org.usaha.ecvi.Sex;
import org.usaha.ecvi.SpeciesCode;
import org.usaha.ecvi.TagType;
import org.usaha.ecvi.Test;
import org.usaha.ecvi.UsState;
import org.usaha.ecvi.Veterinarian;

import org.usaha.ecvi.util.EcviValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcviPackageImpl extends EPackageImpl implements EcviPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessionsEClass = null;

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
	private EClass animalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animalTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactEClass = null;

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
	private EClass ecviEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupLotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laboratoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movementPurposesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phoneNumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass premisesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass veterinarianEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum docTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum iso3166CountryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum movementPurposeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum phoneDeviceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum programStatusNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum programStatusValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resultNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sexEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum speciesCodeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tagTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum usStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType addressLine1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType addressLine2EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType animalSexDetailEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType attachementCommentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType breedEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType countyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cviNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType docTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType entryPermitNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fileNameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType groupLotDescriptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType groupLotSexDetailEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iso3166CountryObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType latitudeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longitudeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mimeTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType movementPurposeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phoneDeviceObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phoneNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phoneNumCommentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phoneNumNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType premIdEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType programStatusNameObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType programStatusValueObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resultNameObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sexObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType speciesCodeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tagTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType townEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType usStateObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType zipCodeEDataType = null;

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
	 * @see org.usaha.ecvi.EcviPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EcviPackageImpl() {
		super(eNS_URI, EcviFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EcviPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EcviPackage init() {
		if (isInited) return (EcviPackage)EPackage.Registry.INSTANCE.getEPackage(EcviPackage.eNS_URI);

		// Obtain or create and register package
		EcviPackageImpl theEcviPackage = (EcviPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcviPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcviPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEcviPackage.createPackageContents();

		// Initialize created meta-data
		theEcviPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEcviPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return EcviValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theEcviPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EcviPackage.eNS_URI, theEcviPackage);
		return theEcviPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccession() {
		return accessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccession_Laboratory() {
		return (EReference)accessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccession_Id() {
		return (EAttribute)accessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccession_InfieldTest() {
		return (EAttribute)accessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessions() {
		return accessionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccessions_Accession() {
		return (EReference)accessionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Line1() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Line2() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Town() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_County() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_State() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_ZIP() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_Country() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_GeoPoint() {
		return (EReference)addressEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimal() {
		return animalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_AnimalTag() {
		return (EReference)animalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimal_Test() {
		return (EReference)animalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Age() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Breed() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_InspectionDate() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_Sex() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimal_SexDetail() {
		return (EAttribute)animalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimalTag() {
		return animalTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalTag_BrandImage() {
		return (EAttribute)animalTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalTag_Number() {
		return (EAttribute)animalTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimalTag_Type() {
		return (EAttribute)animalTagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttachement() {
		return attachementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachement_Payload() {
		return (EAttribute)attachementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachement_Comment() {
		return (EAttribute)attachementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachement_DocType() {
		return (EAttribute)attachementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachement_Filename() {
		return (EAttribute)attachementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachement_MimeType() {
		return (EAttribute)attachementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContact() {
		return contactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_PremId() {
		return (EAttribute)contactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_PremName() {
		return (EAttribute)contactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Address() {
		return (EReference)contactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Person() {
		return (EReference)contactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ECVI() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcvi() {
		return ecviEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Veterinarian() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_MovementPurposes() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Origin() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Destination() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Consignor() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Consignee() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Accessions() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_Group() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Animal() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_Group1() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_GroupLot() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcvi_Attachment() {
		return (EReference)ecviEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_CviNumber() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_EntryPermitNumber() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_ExpirationDate() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_IssueDate() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_ShipmentDate() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcvi_SpeciesCode() {
		return (EAttribute)ecviEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoPoint() {
		return geoPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoPoint_Lat() {
		return (EAttribute)geoPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoPoint_Lng() {
		return (EAttribute)geoPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupLot() {
		return groupLotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Age() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Breed() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Description() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Quantity() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Sex() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_SexDetail() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Species() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupLot_Unit() {
		return (EAttribute)groupLotEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaboratory() {
		return laboratoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaboratory_LabName() {
		return (EAttribute)laboratoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaboratory_PremId() {
		return (EAttribute)laboratoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaboratory_Address() {
		return (EReference)laboratoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaboratory_AccessionDate() {
		return (EAttribute)laboratoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaboratory_AccessionNumber() {
		return (EAttribute)laboratoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovementPurposes() {
		return movementPurposesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovementPurposes_MovementPurpose() {
		return (EAttribute)movementPurposesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Name() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Phone() {
		return (EReference)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhoneNum() {
		return phoneNumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNum_Comment() {
		return (EAttribute)phoneNumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNum_Number() {
		return (EAttribute)phoneNumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNum_Type() {
		return (EAttribute)phoneNumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPremises() {
		return premisesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_PremId() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPremises_PremName() {
		return (EAttribute)premisesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_Address() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_ProgramStatus() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPremises_Person() {
		return (EReference)premisesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgramStatus() {
		return programStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgramStatus_Name() {
		return (EAttribute)programStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgramStatus_Value() {
		return (EAttribute)programStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgramStatus_ValueOther() {
		return (EAttribute)programStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultValue() {
		return resultValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultValue_ResultInteger() {
		return (EAttribute)resultValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultValue_ResultString() {
		return (EAttribute)resultValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultValue_ResultFloat() {
		return (EAttribute)resultValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultValue_ResultName() {
		return (EAttribute)resultValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTest() {
		return testEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_Result() {
		return (EReference)testEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTest_Idref() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTest_TestCode() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVeterinarian() {
		return veterinarianEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVeterinarian_Person() {
		return (EReference)veterinarianEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVeterinarian_Address() {
		return (EReference)veterinarianEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVeterinarian_LicenseIssueState() {
		return (EAttribute)veterinarianEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVeterinarian_LicenseNumber() {
		return (EAttribute)veterinarianEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVeterinarian_NationalAccreditationNumber() {
		return (EAttribute)veterinarianEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDocType() {
		return docTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getISO3166Country() {
		return iso3166CountryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMovementPurpose() {
		return movementPurposeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPhoneDevice() {
		return phoneDeviceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProgramStatusName() {
		return programStatusNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProgramStatusValue() {
		return programStatusValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResultName() {
		return resultNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSex() {
		return sexEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSpeciesCode() {
		return speciesCodeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTagType() {
		return tagTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUsState() {
		return usStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAddressLine1() {
		return addressLine1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAddressLine2() {
		return addressLine2EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAge() {
		return ageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAnimalSexDetail() {
		return animalSexDetailEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAttachementComment() {
		return attachementCommentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBreed() {
		return breedEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCounty() {
		return countyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCviNumber() {
		return cviNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDocTypeObject() {
		return docTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEntryPermitNumber() {
		return entryPermitNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFileName() {
		return fileNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGroupLotDescription() {
		return groupLotDescriptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGroupLotSexDetail() {
		return groupLotSexDetailEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getISO3166CountryObject() {
		return iso3166CountryObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLatitude() {
		return latitudeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLongitude() {
		return longitudeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMimeType() {
		return mimeTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMovementPurposeObject() {
		return movementPurposeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhoneDeviceObject() {
		return phoneDeviceObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhoneNumber() {
		return phoneNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhoneNumComment() {
		return phoneNumCommentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhoneNumNumber() {
		return phoneNumNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPremId() {
		return premIdEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProgramStatusNameObject() {
		return programStatusNameObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProgramStatusValueObject() {
		return programStatusValueObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResultNameObject() {
		return resultNameObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSexObject() {
		return sexObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSpeciesCodeObject() {
		return speciesCodeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTagTypeObject() {
		return tagTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTown() {
		return townEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUsStateObject() {
		return usStateObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getZipCode() {
		return zipCodeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcviFactory getEcviFactory() {
		return (EcviFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		accessionEClass = createEClass(ACCESSION);
		createEReference(accessionEClass, ACCESSION__LABORATORY);
		createEAttribute(accessionEClass, ACCESSION__ID);
		createEAttribute(accessionEClass, ACCESSION__INFIELD_TEST);

		accessionsEClass = createEClass(ACCESSIONS);
		createEReference(accessionsEClass, ACCESSIONS__ACCESSION);

		addressEClass = createEClass(ADDRESS);
		createEAttribute(addressEClass, ADDRESS__LINE1);
		createEAttribute(addressEClass, ADDRESS__LINE2);
		createEAttribute(addressEClass, ADDRESS__TOWN);
		createEAttribute(addressEClass, ADDRESS__COUNTY);
		createEAttribute(addressEClass, ADDRESS__STATE);
		createEAttribute(addressEClass, ADDRESS__ZIP);
		createEAttribute(addressEClass, ADDRESS__COUNTRY);
		createEReference(addressEClass, ADDRESS__GEO_POINT);

		animalEClass = createEClass(ANIMAL);
		createEReference(animalEClass, ANIMAL__ANIMAL_TAG);
		createEReference(animalEClass, ANIMAL__TEST);
		createEAttribute(animalEClass, ANIMAL__AGE);
		createEAttribute(animalEClass, ANIMAL__BREED);
		createEAttribute(animalEClass, ANIMAL__INSPECTION_DATE);
		createEAttribute(animalEClass, ANIMAL__SEX);
		createEAttribute(animalEClass, ANIMAL__SEX_DETAIL);

		animalTagEClass = createEClass(ANIMAL_TAG);
		createEAttribute(animalTagEClass, ANIMAL_TAG__BRAND_IMAGE);
		createEAttribute(animalTagEClass, ANIMAL_TAG__NUMBER);
		createEAttribute(animalTagEClass, ANIMAL_TAG__TYPE);

		attachementEClass = createEClass(ATTACHEMENT);
		createEAttribute(attachementEClass, ATTACHEMENT__PAYLOAD);
		createEAttribute(attachementEClass, ATTACHEMENT__COMMENT);
		createEAttribute(attachementEClass, ATTACHEMENT__DOC_TYPE);
		createEAttribute(attachementEClass, ATTACHEMENT__FILENAME);
		createEAttribute(attachementEClass, ATTACHEMENT__MIME_TYPE);

		contactEClass = createEClass(CONTACT);
		createEAttribute(contactEClass, CONTACT__PREM_ID);
		createEAttribute(contactEClass, CONTACT__PREM_NAME);
		createEReference(contactEClass, CONTACT__ADDRESS);
		createEReference(contactEClass, CONTACT__PERSON);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ECVI);

		ecviEClass = createEClass(ECVI);
		createEReference(ecviEClass, ECVI__VETERINARIAN);
		createEReference(ecviEClass, ECVI__MOVEMENT_PURPOSES);
		createEReference(ecviEClass, ECVI__ORIGIN);
		createEReference(ecviEClass, ECVI__DESTINATION);
		createEReference(ecviEClass, ECVI__CONSIGNOR);
		createEReference(ecviEClass, ECVI__CONSIGNEE);
		createEReference(ecviEClass, ECVI__ACCESSIONS);
		createEAttribute(ecviEClass, ECVI__GROUP);
		createEReference(ecviEClass, ECVI__ANIMAL);
		createEAttribute(ecviEClass, ECVI__GROUP1);
		createEReference(ecviEClass, ECVI__GROUP_LOT);
		createEReference(ecviEClass, ECVI__ATTACHMENT);
		createEAttribute(ecviEClass, ECVI__CVI_NUMBER);
		createEAttribute(ecviEClass, ECVI__ENTRY_PERMIT_NUMBER);
		createEAttribute(ecviEClass, ECVI__EXPIRATION_DATE);
		createEAttribute(ecviEClass, ECVI__ISSUE_DATE);
		createEAttribute(ecviEClass, ECVI__SHIPMENT_DATE);
		createEAttribute(ecviEClass, ECVI__SPECIES_CODE);

		geoPointEClass = createEClass(GEO_POINT);
		createEAttribute(geoPointEClass, GEO_POINT__LAT);
		createEAttribute(geoPointEClass, GEO_POINT__LNG);

		groupLotEClass = createEClass(GROUP_LOT);
		createEAttribute(groupLotEClass, GROUP_LOT__AGE);
		createEAttribute(groupLotEClass, GROUP_LOT__BREED);
		createEAttribute(groupLotEClass, GROUP_LOT__DESCRIPTION);
		createEAttribute(groupLotEClass, GROUP_LOT__QUANTITY);
		createEAttribute(groupLotEClass, GROUP_LOT__SEX);
		createEAttribute(groupLotEClass, GROUP_LOT__SEX_DETAIL);
		createEAttribute(groupLotEClass, GROUP_LOT__SPECIES);
		createEAttribute(groupLotEClass, GROUP_LOT__UNIT);

		laboratoryEClass = createEClass(LABORATORY);
		createEAttribute(laboratoryEClass, LABORATORY__LAB_NAME);
		createEAttribute(laboratoryEClass, LABORATORY__PREM_ID);
		createEReference(laboratoryEClass, LABORATORY__ADDRESS);
		createEAttribute(laboratoryEClass, LABORATORY__ACCESSION_DATE);
		createEAttribute(laboratoryEClass, LABORATORY__ACCESSION_NUMBER);

		movementPurposesEClass = createEClass(MOVEMENT_PURPOSES);
		createEAttribute(movementPurposesEClass, MOVEMENT_PURPOSES__MOVEMENT_PURPOSE);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__NAME);
		createEReference(personEClass, PERSON__PHONE);

		phoneNumEClass = createEClass(PHONE_NUM);
		createEAttribute(phoneNumEClass, PHONE_NUM__COMMENT);
		createEAttribute(phoneNumEClass, PHONE_NUM__NUMBER);
		createEAttribute(phoneNumEClass, PHONE_NUM__TYPE);

		premisesEClass = createEClass(PREMISES);
		createEAttribute(premisesEClass, PREMISES__PREM_ID);
		createEAttribute(premisesEClass, PREMISES__PREM_NAME);
		createEReference(premisesEClass, PREMISES__ADDRESS);
		createEReference(premisesEClass, PREMISES__PROGRAM_STATUS);
		createEReference(premisesEClass, PREMISES__PERSON);

		programStatusEClass = createEClass(PROGRAM_STATUS);
		createEAttribute(programStatusEClass, PROGRAM_STATUS__NAME);
		createEAttribute(programStatusEClass, PROGRAM_STATUS__VALUE);
		createEAttribute(programStatusEClass, PROGRAM_STATUS__VALUE_OTHER);

		resultValueEClass = createEClass(RESULT_VALUE);
		createEAttribute(resultValueEClass, RESULT_VALUE__RESULT_INTEGER);
		createEAttribute(resultValueEClass, RESULT_VALUE__RESULT_STRING);
		createEAttribute(resultValueEClass, RESULT_VALUE__RESULT_FLOAT);
		createEAttribute(resultValueEClass, RESULT_VALUE__RESULT_NAME);

		testEClass = createEClass(TEST);
		createEReference(testEClass, TEST__RESULT);
		createEAttribute(testEClass, TEST__IDREF);
		createEAttribute(testEClass, TEST__TEST_CODE);

		veterinarianEClass = createEClass(VETERINARIAN);
		createEReference(veterinarianEClass, VETERINARIAN__PERSON);
		createEReference(veterinarianEClass, VETERINARIAN__ADDRESS);
		createEAttribute(veterinarianEClass, VETERINARIAN__LICENSE_ISSUE_STATE);
		createEAttribute(veterinarianEClass, VETERINARIAN__LICENSE_NUMBER);
		createEAttribute(veterinarianEClass, VETERINARIAN__NATIONAL_ACCREDITATION_NUMBER);

		// Create enums
		docTypeEEnum = createEEnum(DOC_TYPE);
		iso3166CountryEEnum = createEEnum(ISO3166_COUNTRY);
		movementPurposeEEnum = createEEnum(MOVEMENT_PURPOSE);
		phoneDeviceEEnum = createEEnum(PHONE_DEVICE);
		programStatusNameEEnum = createEEnum(PROGRAM_STATUS_NAME);
		programStatusValueEEnum = createEEnum(PROGRAM_STATUS_VALUE);
		resultNameEEnum = createEEnum(RESULT_NAME);
		sexEEnum = createEEnum(SEX);
		speciesCodeEEnum = createEEnum(SPECIES_CODE);
		tagTypeEEnum = createEEnum(TAG_TYPE);
		usStateEEnum = createEEnum(US_STATE);

		// Create data types
		addressLine1EDataType = createEDataType(ADDRESS_LINE1);
		addressLine2EDataType = createEDataType(ADDRESS_LINE2);
		ageEDataType = createEDataType(AGE);
		animalSexDetailEDataType = createEDataType(ANIMAL_SEX_DETAIL);
		attachementCommentEDataType = createEDataType(ATTACHEMENT_COMMENT);
		breedEDataType = createEDataType(BREED);
		countyEDataType = createEDataType(COUNTY);
		cviNumberEDataType = createEDataType(CVI_NUMBER);
		docTypeObjectEDataType = createEDataType(DOC_TYPE_OBJECT);
		entryPermitNumberEDataType = createEDataType(ENTRY_PERMIT_NUMBER);
		fileNameEDataType = createEDataType(FILE_NAME);
		groupLotDescriptionEDataType = createEDataType(GROUP_LOT_DESCRIPTION);
		groupLotSexDetailEDataType = createEDataType(GROUP_LOT_SEX_DETAIL);
		iso3166CountryObjectEDataType = createEDataType(ISO3166_COUNTRY_OBJECT);
		latitudeEDataType = createEDataType(LATITUDE);
		longitudeEDataType = createEDataType(LONGITUDE);
		mimeTypeEDataType = createEDataType(MIME_TYPE);
		movementPurposeObjectEDataType = createEDataType(MOVEMENT_PURPOSE_OBJECT);
		phoneDeviceObjectEDataType = createEDataType(PHONE_DEVICE_OBJECT);
		phoneNumberEDataType = createEDataType(PHONE_NUMBER);
		phoneNumCommentEDataType = createEDataType(PHONE_NUM_COMMENT);
		phoneNumNumberEDataType = createEDataType(PHONE_NUM_NUMBER);
		premIdEDataType = createEDataType(PREM_ID);
		programStatusNameObjectEDataType = createEDataType(PROGRAM_STATUS_NAME_OBJECT);
		programStatusValueObjectEDataType = createEDataType(PROGRAM_STATUS_VALUE_OBJECT);
		resultNameObjectEDataType = createEDataType(RESULT_NAME_OBJECT);
		sexObjectEDataType = createEDataType(SEX_OBJECT);
		speciesCodeObjectEDataType = createEDataType(SPECIES_CODE_OBJECT);
		tagTypeObjectEDataType = createEDataType(TAG_TYPE_OBJECT);
		townEDataType = createEDataType(TOWN);
		usStateObjectEDataType = createEDataType(US_STATE_OBJECT);
		zipCodeEDataType = createEDataType(ZIP_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(accessionEClass, Accession.class, "Accession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccession_Laboratory(), this.getLaboratory(), null, "laboratory", null, 1, 1, Accession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccession_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Accession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccession_InfieldTest(), theXMLTypePackage.getBoolean(), "infieldTest", null, 1, 1, Accession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessionsEClass, Accessions.class, "Accessions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessions_Accession(), this.getAccession(), null, "accession", null, 1, -1, Accessions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddress_Line1(), this.getAddressLine1(), "line1", null, 1, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_Line2(), this.getAddressLine2(), "line2", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_Town(), this.getTown(), "town", null, 1, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_County(), this.getCounty(), "county", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_State(), this.getUsState(), "state", null, 1, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_ZIP(), this.getZipCode(), "zIP", null, 1, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_Country(), this.getISO3166Country(), "country", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_GeoPoint(), this.getGeoPoint(), null, "geoPoint", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(animalEClass, Animal.class, "Animal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnimal_AnimalTag(), this.getAnimalTag(), null, "animalTag", null, 1, 6, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimal_Test(), this.getTest(), null, "test", null, 0, -1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Age(), this.getAge(), "age", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Breed(), this.getBreed(), "breed", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_InspectionDate(), theXMLTypePackage.getDate(), "inspectionDate", null, 1, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_Sex(), this.getSex(), "sex", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimal_SexDetail(), this.getAnimalSexDetail(), "sexDetail", null, 0, 1, Animal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(animalTagEClass, AnimalTag.class, "AnimalTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnimalTag_BrandImage(), theXMLTypePackage.getBase64Binary(), "brandImage", null, 0, 1, AnimalTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalTag_Number(), theXMLTypePackage.getString(), "number", null, 1, 1, AnimalTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimalTag_Type(), this.getTagType(), "type", null, 0, 1, AnimalTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachementEClass, Attachement.class, "Attachement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttachement_Payload(), theXMLTypePackage.getBase64Binary(), "payload", null, 1, 1, Attachement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachement_Comment(), this.getAttachementComment(), "comment", null, 0, 1, Attachement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachement_DocType(), this.getDocType(), "docType", null, 1, 1, Attachement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachement_Filename(), this.getFileName(), "filename", null, 1, 1, Attachement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachement_MimeType(), this.getMimeType(), "mimeType", null, 0, 1, Attachement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContact_PremId(), this.getPremId(), "premId", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_PremName(), theXMLTypePackage.getString(), "premName", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContact_Address(), this.getAddress(), null, "address", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContact_Person(), this.getPerson(), null, "person", null, 1, -1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ECVI(), this.getEcvi(), null, "eCVI", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(ecviEClass, Ecvi.class, "Ecvi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcvi_Veterinarian(), this.getVeterinarian(), null, "veterinarian", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_MovementPurposes(), this.getMovementPurposes(), null, "movementPurposes", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Origin(), this.getPremises(), null, "origin", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Destination(), this.getPremises(), null, "destination", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Consignor(), this.getContact(), null, "consignor", null, 0, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Consignee(), this.getContact(), null, "consignee", null, 0, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Accessions(), this.getAccessions(), null, "accessions", null, 0, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Animal(), this.getAnimal(), null, "animal", null, 0, -1, Ecvi.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_Group1(), ecorePackage.getEFeatureMapEntry(), "group1", null, 0, -1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_GroupLot(), this.getGroupLot(), null, "groupLot", null, 0, -1, Ecvi.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEcvi_Attachment(), this.getAttachement(), null, "attachment", null, 0, -1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_CviNumber(), this.getCviNumber(), "cviNumber", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_EntryPermitNumber(), this.getEntryPermitNumber(), "entryPermitNumber", null, 0, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_ExpirationDate(), theXMLTypePackage.getDate(), "expirationDate", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_IssueDate(), theXMLTypePackage.getDate(), "issueDate", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_ShipmentDate(), theXMLTypePackage.getDate(), "shipmentDate", null, 0, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcvi_SpeciesCode(), this.getSpeciesCode(), "speciesCode", null, 1, 1, Ecvi.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geoPointEClass, GeoPoint.class, "GeoPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeoPoint_Lat(), this.getLatitude(), "lat", null, 1, 1, GeoPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoPoint_Lng(), this.getLongitude(), "lng", null, 1, 1, GeoPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupLotEClass, GroupLot.class, "GroupLot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroupLot_Age(), this.getAge(), "age", null, 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Breed(), this.getBreed(), "breed", null, 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Description(), this.getGroupLotDescription(), "description", null, 1, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Quantity(), theXMLTypePackage.getFloat(), "quantity", null, 1, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Sex(), this.getSex(), "sex", null, 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_SexDetail(), this.getGroupLotSexDetail(), "sexDetail", null, 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Species(), this.getSpeciesCode(), "species", null, 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupLot_Unit(), theXMLTypePackage.getString(), "unit", "Number", 0, 1, GroupLot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(laboratoryEClass, Laboratory.class, "Laboratory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLaboratory_LabName(), theXMLTypePackage.getString(), "labName", null, 0, 1, Laboratory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaboratory_PremId(), this.getPremId(), "premId", null, 0, 1, Laboratory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLaboratory_Address(), this.getAddress(), null, "address", null, 0, 1, Laboratory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaboratory_AccessionDate(), theXMLTypePackage.getDate(), "accessionDate", null, 1, 1, Laboratory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaboratory_AccessionNumber(), theXMLTypePackage.getString(), "accessionNumber", null, 0, 1, Laboratory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(movementPurposesEClass, MovementPurposes.class, "MovementPurposes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovementPurposes_MovementPurpose(), this.getMovementPurpose(), "movementPurpose", null, 1, -1, MovementPurposes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Phone(), this.getPhoneNum(), null, "phone", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phoneNumEClass, PhoneNum.class, "PhoneNum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhoneNum_Comment(), this.getPhoneNumComment(), "comment", null, 0, 1, PhoneNum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNum_Number(), this.getPhoneNumNumber(), "number", null, 1, 1, PhoneNum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNum_Type(), this.getPhoneDevice(), "type", null, 1, 1, PhoneNum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(premisesEClass, Premises.class, "Premises", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPremises_PremId(), this.getPremId(), "premId", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPremises_PremName(), theXMLTypePackage.getString(), "premName", null, 0, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Address(), this.getAddress(), null, "address", null, 1, 1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_ProgramStatus(), this.getProgramStatus(), null, "programStatus", null, 0, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPremises_Person(), this.getPerson(), null, "person", null, 1, -1, Premises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programStatusEClass, ProgramStatus.class, "ProgramStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgramStatus_Name(), this.getProgramStatusName(), "name", null, 1, 1, ProgramStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgramStatus_Value(), this.getProgramStatusValue(), "value", null, 1, 1, ProgramStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgramStatus_ValueOther(), theXMLTypePackage.getString(), "valueOther", null, 0, 1, ProgramStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resultValueEClass, ResultValue.class, "ResultValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResultValue_ResultInteger(), theXMLTypePackage.getInteger(), "resultInteger", null, 0, 1, ResultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultValue_ResultString(), theXMLTypePackage.getString(), "resultString", null, 0, 1, ResultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultValue_ResultFloat(), theXMLTypePackage.getFloat(), "resultFloat", null, 0, 1, ResultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultValue_ResultName(), this.getResultName(), "resultName", null, 1, 1, ResultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTest_Result(), this.getResultValue(), null, "result", null, 1, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTest_Idref(), theXMLTypePackage.getIDREF(), "idref", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTest_TestCode(), theXMLTypePackage.getString(), "testCode", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(veterinarianEClass, Veterinarian.class, "Veterinarian", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVeterinarian_Person(), this.getPerson(), null, "person", null, 1, 1, Veterinarian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVeterinarian_Address(), this.getAddress(), null, "address", null, 0, 1, Veterinarian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVeterinarian_LicenseIssueState(), this.getUsState(), "licenseIssueState", null, 0, 1, Veterinarian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVeterinarian_LicenseNumber(), theXMLTypePackage.getString(), "licenseNumber", null, 0, 1, Veterinarian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVeterinarian_NationalAccreditationNumber(), theXMLTypePackage.getString(), "nationalAccreditationNumber", null, 0, 1, Veterinarian.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(docTypeEEnum, DocType.class, "DocType");
		addEEnumLiteral(docTypeEEnum, DocType.SCANNED_PAPER_CVI);
		addEEnumLiteral(docTypeEEnum, DocType.SCANNED_TEST_CHART);
		addEEnumLiteral(docTypeEEnum, DocType.PDFCVI);
		addEEnumLiteral(docTypeEEnum, DocType.PDF_TEST_CHART);
		addEEnumLiteral(docTypeEEnum, DocType.OTHER);

		initEEnum(iso3166CountryEEnum, ISO3166Country.class, "ISO3166Country");
		addEEnumLiteral(iso3166CountryEEnum, ISO3166Country.USA);

		initEEnum(movementPurposeEEnum, MovementPurpose.class, "MovementPurpose");
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.SHOW);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.RACE);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.RODEO);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.SALE);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.PET);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.BREEDING);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.FEEDING);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.GRAZING);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.TRAINING);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.SLAUGHTER);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.MEDICAL_TREATMENT);
		addEEnumLiteral(movementPurposeEEnum, MovementPurpose.OTHER);

		initEEnum(phoneDeviceEEnum, PhoneDevice.class, "PhoneDevice");
		addEEnumLiteral(phoneDeviceEEnum, PhoneDevice.UNKNOWN);
		addEEnumLiteral(phoneDeviceEEnum, PhoneDevice.LANDLINE);
		addEEnumLiteral(phoneDeviceEEnum, PhoneDevice.CELLPHONE);
		addEEnumLiteral(phoneDeviceEEnum, PhoneDevice.FAX);

		initEEnum(programStatusNameEEnum, ProgramStatusName.class, "ProgramStatusName");
		addEEnumLiteral(programStatusNameEEnum, ProgramStatusName.BOVINE_TUBERCULOSIS);
		addEEnumLiteral(programStatusNameEEnum, ProgramStatusName.BRUCELLOSIS_STATE);
		addEEnumLiteral(programStatusNameEEnum, ProgramStatusName.BRUCELLOSIS_HERD);

		initEEnum(programStatusValueEEnum, ProgramStatusValue.class, "ProgramStatusValue");
		addEEnumLiteral(programStatusValueEEnum, ProgramStatusValue.FREE);
		addEEnumLiteral(programStatusValueEEnum, ProgramStatusValue.MODIFIED_ACCREDITED);
		addEEnumLiteral(programStatusValueEEnum, ProgramStatusValue.MODIFIED_ADVANCED_ACCREDITED);
		addEEnumLiteral(programStatusValueEEnum, ProgramStatusValue.OTHER);

		initEEnum(resultNameEEnum, ResultName.class, "ResultName");
		addEEnumLiteral(resultNameEEnum, ResultName.RESULT);
		addEEnumLiteral(resultNameEEnum, ResultName.COMMENT);

		initEEnum(sexEEnum, Sex.class, "Sex");
		addEEnumLiteral(sexEEnum, Sex.FEMALE);
		addEEnumLiteral(sexEEnum, Sex.MALE);
		addEEnumLiteral(sexEEnum, Sex.GENDER_UNKNOWN);
		addEEnumLiteral(sexEEnum, Sex.SPAYED_FEMALE);
		addEEnumLiteral(sexEEnum, Sex.NEUTERED_MALE);
		addEEnumLiteral(sexEEnum, Sex.TRUE_HERMAPHRODITE);
		addEEnumLiteral(sexEEnum, Sex.OTHER);

		initEEnum(speciesCodeEEnum, SpeciesCode.class, "SpeciesCode");
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.UNK);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.BOV);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.CAP);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.CER);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.EQU);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.OVI);
		addEEnumLiteral(speciesCodeEEnum, SpeciesCode.POR);

		initEEnum(tagTypeEEnum, TagType.class, "TagType");
		addEEnumLiteral(tagTypeEEnum, TagType.UN);
		addEEnumLiteral(tagTypeEEnum, TagType.AIN);
		addEEnumLiteral(tagTypeEEnum, TagType.AMID);
		addEEnumLiteral(tagTypeEEnum, TagType.BRAND);
		addEEnumLiteral(tagTypeEEnum, TagType.BRANDIMAGE);
		addEEnumLiteral(tagTypeEEnum, TagType.BT);
		addEEnumLiteral(tagTypeEEnum, TagType.IMP);
		addEEnumLiteral(tagTypeEEnum, TagType.MGT);
		addEEnumLiteral(tagTypeEEnum, TagType.N840RFID);
		addEEnumLiteral(tagTypeEEnum, TagType.NUES8);
		addEEnumLiteral(tagTypeEEnum, TagType.NUES9);
		addEEnumLiteral(tagTypeEEnum, TagType.OFORID);
		addEEnumLiteral(tagTypeEEnum, TagType.OTH);
		addEEnumLiteral(tagTypeEEnum, TagType.NAME);
		addEEnumLiteral(tagTypeEEnum, TagType.SGFLID);
		addEEnumLiteral(tagTypeEEnum, TagType.NPIN);
		addEEnumLiteral(tagTypeEEnum, TagType.TAT);

		initEEnum(usStateEEnum, UsState.class, "UsState");
		addEEnumLiteral(usStateEEnum, UsState.AA);
		addEEnumLiteral(usStateEEnum, UsState.AE);
		addEEnumLiteral(usStateEEnum, UsState.AK);
		addEEnumLiteral(usStateEEnum, UsState.AL);
		addEEnumLiteral(usStateEEnum, UsState.AP);
		addEEnumLiteral(usStateEEnum, UsState.AR);
		addEEnumLiteral(usStateEEnum, UsState.AS);
		addEEnumLiteral(usStateEEnum, UsState.AZ);
		addEEnumLiteral(usStateEEnum, UsState.CA);
		addEEnumLiteral(usStateEEnum, UsState.CO);
		addEEnumLiteral(usStateEEnum, UsState.CT);
		addEEnumLiteral(usStateEEnum, UsState.DC);
		addEEnumLiteral(usStateEEnum, UsState.DE);
		addEEnumLiteral(usStateEEnum, UsState.FL);
		addEEnumLiteral(usStateEEnum, UsState.FM);
		addEEnumLiteral(usStateEEnum, UsState.GA);
		addEEnumLiteral(usStateEEnum, UsState.GU);
		addEEnumLiteral(usStateEEnum, UsState.HI);
		addEEnumLiteral(usStateEEnum, UsState.IA);
		addEEnumLiteral(usStateEEnum, UsState.ID);
		addEEnumLiteral(usStateEEnum, UsState.IL);
		addEEnumLiteral(usStateEEnum, UsState.IN);
		addEEnumLiteral(usStateEEnum, UsState.KS);
		addEEnumLiteral(usStateEEnum, UsState.KY);
		addEEnumLiteral(usStateEEnum, UsState.LA);
		addEEnumLiteral(usStateEEnum, UsState.MA);
		addEEnumLiteral(usStateEEnum, UsState.MD);
		addEEnumLiteral(usStateEEnum, UsState.ME);
		addEEnumLiteral(usStateEEnum, UsState.MH);
		addEEnumLiteral(usStateEEnum, UsState.MI);
		addEEnumLiteral(usStateEEnum, UsState.MN);
		addEEnumLiteral(usStateEEnum, UsState.MO);
		addEEnumLiteral(usStateEEnum, UsState.MP);
		addEEnumLiteral(usStateEEnum, UsState.MS);
		addEEnumLiteral(usStateEEnum, UsState.MT);
		addEEnumLiteral(usStateEEnum, UsState.NC);
		addEEnumLiteral(usStateEEnum, UsState.ND);
		addEEnumLiteral(usStateEEnum, UsState.NE);
		addEEnumLiteral(usStateEEnum, UsState.NH);
		addEEnumLiteral(usStateEEnum, UsState.NJ);
		addEEnumLiteral(usStateEEnum, UsState.NM);
		addEEnumLiteral(usStateEEnum, UsState.NV);
		addEEnumLiteral(usStateEEnum, UsState.NY);
		addEEnumLiteral(usStateEEnum, UsState.OH);
		addEEnumLiteral(usStateEEnum, UsState.OK);
		addEEnumLiteral(usStateEEnum, UsState.OR);
		addEEnumLiteral(usStateEEnum, UsState.PA);
		addEEnumLiteral(usStateEEnum, UsState.PR);
		addEEnumLiteral(usStateEEnum, UsState.PW);
		addEEnumLiteral(usStateEEnum, UsState.RI);
		addEEnumLiteral(usStateEEnum, UsState.SC);
		addEEnumLiteral(usStateEEnum, UsState.SD);
		addEEnumLiteral(usStateEEnum, UsState.TN);
		addEEnumLiteral(usStateEEnum, UsState.TX);
		addEEnumLiteral(usStateEEnum, UsState.UT);
		addEEnumLiteral(usStateEEnum, UsState.VA);
		addEEnumLiteral(usStateEEnum, UsState.VI);
		addEEnumLiteral(usStateEEnum, UsState.VT);
		addEEnumLiteral(usStateEEnum, UsState.WA);
		addEEnumLiteral(usStateEEnum, UsState.WI);
		addEEnumLiteral(usStateEEnum, UsState.WV);
		addEEnumLiteral(usStateEEnum, UsState.WY);

		// Initialize data types
		initEDataType(addressLine1EDataType, String.class, "AddressLine1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(addressLine2EDataType, String.class, "AddressLine2", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ageEDataType, String.class, "Age", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(animalSexDetailEDataType, String.class, "AnimalSexDetail", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(attachementCommentEDataType, String.class, "AttachementComment", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(breedEDataType, String.class, "Breed", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(countyEDataType, String.class, "County", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cviNumberEDataType, String.class, "CviNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(docTypeObjectEDataType, DocType.class, "DocTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(entryPermitNumberEDataType, String.class, "EntryPermitNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fileNameEDataType, String.class, "FileName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(groupLotDescriptionEDataType, String.class, "GroupLotDescription", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(groupLotSexDetailEDataType, String.class, "GroupLotSexDetail", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iso3166CountryObjectEDataType, ISO3166Country.class, "ISO3166CountryObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(latitudeEDataType, BigDecimal.class, "Latitude", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longitudeEDataType, BigDecimal.class, "Longitude", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(mimeTypeEDataType, String.class, "MimeType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(movementPurposeObjectEDataType, MovementPurpose.class, "MovementPurposeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phoneDeviceObjectEDataType, PhoneDevice.class, "PhoneDeviceObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phoneNumberEDataType, String.class, "PhoneNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phoneNumCommentEDataType, String.class, "PhoneNumComment", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phoneNumNumberEDataType, String.class, "PhoneNumNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(premIdEDataType, String.class, "PremId", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(programStatusNameObjectEDataType, ProgramStatusName.class, "ProgramStatusNameObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(programStatusValueObjectEDataType, ProgramStatusValue.class, "ProgramStatusValueObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resultNameObjectEDataType, ResultName.class, "ResultNameObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sexObjectEDataType, Sex.class, "SexObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(speciesCodeObjectEDataType, SpeciesCode.class, "SpeciesCodeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tagTypeObjectEDataType, TagType.class, "TagTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(townEDataType, String.class, "Town", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(usStateObjectEDataType, UsState.class, "UsStateObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(zipCodeEDataType, String.class, "ZipCode", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (accessionEClass, 
		   source, 
		   new String[] {
			 "name", "AccessionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAccession_Laboratory(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Laboratory",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAccession_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getAccession_InfieldTest(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "InfieldTest"
		   });		
		addAnnotation
		  (accessionsEClass, 
		   source, 
		   new String[] {
			 "name", "Accessions_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAccessions_Accession(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Accession",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (addressEClass, 
		   source, 
		   new String[] {
			 "name", "Address",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAddress_Line1(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Line1",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_Line2(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Line2",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_Town(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Town",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_County(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "County",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_State(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "State",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_ZIP(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ZIP",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_Country(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Country",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAddress_GeoPoint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "GeoPoint",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (addressLine1EDataType, 
		   source, 
		   new String[] {
			 "name", "Line1_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "200"
		   });		
		addAnnotation
		  (addressLine2EDataType, 
		   source, 
		   new String[] {
			 "name", "Line2_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "200"
		   });			
		addAnnotation
		  (ageEDataType, 
		   source, 
		   new String[] {
			 "name", "AgeType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "[0-9]{1,2}(d|wk|mo|a) (19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])"
		   });		
		addAnnotation
		  (animalEClass, 
		   source, 
		   new String[] {
			 "name", "Animal_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAnimal_AnimalTag(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AnimalTag",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAnimal_Test(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Test",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAnimal_Age(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Age"
		   });		
		addAnnotation
		  (getAnimal_Breed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Breed"
		   });			
		addAnnotation
		  (getAnimal_InspectionDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "InspectionDate"
		   });		
		addAnnotation
		  (getAnimal_Sex(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Sex"
		   });		
		addAnnotation
		  (getAnimal_SexDetail(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SexDetail"
		   });		
		addAnnotation
		  (animalSexDetailEDataType, 
		   source, 
		   new String[] {
			 "name", "SexDetail_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "100"
		   });		
		addAnnotation
		  (animalTagEClass, 
		   source, 
		   new String[] {
			 "name", "AnimalTag_._type",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getAnimalTag_BrandImage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "BrandImage"
		   });		
		addAnnotation
		  (getAnimalTag_Number(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Number"
		   });		
		addAnnotation
		  (getAnimalTag_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type"
		   });		
		addAnnotation
		  (attachementEClass, 
		   source, 
		   new String[] {
			 "name", "AttachmentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAttachement_Payload(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Payload",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAttachement_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment"
		   });			
		addAnnotation
		  (getAttachement_DocType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DocType"
		   });		
		addAnnotation
		  (getAttachement_Filename(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Filename"
		   });		
		addAnnotation
		  (getAttachement_MimeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MimeType"
		   });		
		addAnnotation
		  (attachementCommentEDataType, 
		   source, 
		   new String[] {
			 "name", "Comment_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "250"
		   });			
		addAnnotation
		  (breedEDataType, 
		   source, 
		   new String[] {
			 "name", "BreedType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "minLength", "2",
			 "maxLength", "3",
			 "pattern", "[A-Z]{2,3}"
		   });		
		addAnnotation
		  (contactEClass, 
		   source, 
		   new String[] {
			 "name", "ContactType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getContact_PremId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PremId",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getContact_PremName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PremName",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getContact_Address(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Address",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getContact_Person(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Person",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (countyEDataType, 
		   source, 
		   new String[] {
			 "name", "CountyType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "minLength", "3",
			 "maxLength", "40"
		   });		
		addAnnotation
		  (cviNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "CviNumber_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "100"
		   });		
		addAnnotation
		  (docTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DocType_._type"
		   });		
		addAnnotation
		  (docTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DocType_._type:Object",
			 "baseType", "DocType_._type"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_ECVI(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eCVI",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ecviEClass, 
		   source, 
		   new String[] {
			 "name", "eCVI_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEcvi_Veterinarian(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Veterinarian",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_MovementPurposes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MovementPurposes",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Origin(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Origin",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Consignor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Consignor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Consignee(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Consignee",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Accessions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Accessions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEcvi_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:7"
		   });		
		addAnnotation
		  (getEcvi_Animal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Animal",
			 "namespace", "##targetNamespace",
			 "group", "#group:7"
		   });		
		addAnnotation
		  (getEcvi_Group1(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:9"
		   });		
		addAnnotation
		  (getEcvi_GroupLot(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "GroupLot",
			 "namespace", "##targetNamespace",
			 "group", "#group:9"
		   });		
		addAnnotation
		  (getEcvi_Attachment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attachment",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getEcvi_CviNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CviNumber"
		   });		
		addAnnotation
		  (getEcvi_EntryPermitNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "EntryPermitNumber"
		   });			
		addAnnotation
		  (getEcvi_ExpirationDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ExpirationDate"
		   });			
		addAnnotation
		  (getEcvi_IssueDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IssueDate"
		   });			
		addAnnotation
		  (getEcvi_ShipmentDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ShipmentDate"
		   });			
		addAnnotation
		  (getEcvi_SpeciesCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SpeciesCode"
		   });		
		addAnnotation
		  (entryPermitNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "EntryPermitNumber_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "100"
		   });		
		addAnnotation
		  (fileNameEDataType, 
		   source, 
		   new String[] {
			 "name", "Filename_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "250"
		   });		
		addAnnotation
		  (geoPointEClass, 
		   source, 
		   new String[] {
			 "name", "GeoPointType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getGeoPoint_Lat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lat"
		   });		
		addAnnotation
		  (getGeoPoint_Lng(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lng"
		   });		
		addAnnotation
		  (groupLotEClass, 
		   source, 
		   new String[] {
			 "name", "GroupLot_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getGroupLot_Age(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Age"
		   });		
		addAnnotation
		  (getGroupLot_Breed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Breed"
		   });		
		addAnnotation
		  (getGroupLot_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getGroupLot_Quantity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Quantity"
		   });		
		addAnnotation
		  (getGroupLot_Sex(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Sex"
		   });		
		addAnnotation
		  (getGroupLot_SexDetail(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SexDetail"
		   });		
		addAnnotation
		  (getGroupLot_Species(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Species"
		   });			
		addAnnotation
		  (getGroupLot_Unit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Unit"
		   });		
		addAnnotation
		  (groupLotDescriptionEDataType, 
		   source, 
		   new String[] {
			 "name", "Description_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "200"
		   });		
		addAnnotation
		  (groupLotSexDetailEDataType, 
		   source, 
		   new String[] {
			 "name", "SexDetail_._1_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "100"
		   });			
		addAnnotation
		  (iso3166CountryEEnum, 
		   source, 
		   new String[] {
			 "name", "ISO3166CountryType"
		   });		
		addAnnotation
		  (iso3166CountryObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ISO3166CountryType:Object",
			 "baseType", "ISO3166CountryType"
		   });		
		addAnnotation
		  (laboratoryEClass, 
		   source, 
		   new String[] {
			 "name", "Laboratory_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLaboratory_LabName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LabName",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getLaboratory_PremId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PremId",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getLaboratory_Address(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Address",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getLaboratory_AccessionDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "AccessionDate"
		   });			
		addAnnotation
		  (getLaboratory_AccessionNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "AccessionNumber"
		   });			
		addAnnotation
		  (latitudeEDataType, 
		   source, 
		   new String[] {
			 "name", "LatitudeType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#decimal",
			 "minInclusive", "-90.0",
			 "maxInclusive", "90.0"
		   });			
		addAnnotation
		  (longitudeEDataType, 
		   source, 
		   new String[] {
			 "name", "LongitudeType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#decimal",
			 "minInclusive", "-180.0",
			 "maxInclusive", "180.0"
		   });			
		addAnnotation
		  (mimeTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "MimeTypeType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "^.{1,127}/.{1,127}$"
		   });		
		addAnnotation
		  (movementPurposeEEnum, 
		   source, 
		   new String[] {
			 "name", "MovementPurposeType"
		   });		
		addAnnotation
		  (movementPurposeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "MovementPurposeType:Object",
			 "baseType", "MovementPurposeType"
		   });		
		addAnnotation
		  (movementPurposesEClass, 
		   source, 
		   new String[] {
			 "name", "MovementPurposeListType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMovementPurposes_MovementPurpose(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MovementPurpose",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "name", "PersonType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPerson_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPerson_Phone(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Phone",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (phoneDeviceEEnum, 
		   source, 
		   new String[] {
			 "name", "PhoneDeviceType"
		   });		
		addAnnotation
		  (phoneDeviceObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "PhoneDeviceType:Object",
			 "baseType", "PhoneDeviceType"
		   });		
		addAnnotation
		  (phoneNumEClass, 
		   source, 
		   new String[] {
			 "name", "PhoneNumType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getPhoneNum_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment"
		   });		
		addAnnotation
		  (getPhoneNum_Number(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Number"
		   });		
		addAnnotation
		  (getPhoneNum_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type"
		   });			
		addAnnotation
		  (phoneNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "PhoneNumber",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "length", "10",
			 "pattern", "[0-9]{10}"
		   });		
		addAnnotation
		  (phoneNumCommentEDataType, 
		   source, 
		   new String[] {
			 "name", "Comment_._1_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "100"
		   });		
		addAnnotation
		  (phoneNumNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "Number_._type",
			 "baseType", "PhoneNumber",
			 "pattern", "[0-9]{10}"
		   });			
		addAnnotation
		  (premIdEDataType, 
		   source, 
		   new String[] {
			 "name", "PremIdType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "[A-Z0-9]{6,8}"
		   });		
		addAnnotation
		  (premisesEClass, 
		   source, 
		   new String[] {
			 "name", "PremType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPremises_PremId(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PremId",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPremises_PremName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PremName",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPremises_Address(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Address",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPremises_ProgramStatus(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ProgramStatus",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPremises_Person(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Person",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (programStatusEClass, 
		   source, 
		   new String[] {
			 "name", "ProgramStatusType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getProgramStatus_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getProgramStatus_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value"
		   });			
		addAnnotation
		  (getProgramStatus_ValueOther(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ValueOther"
		   });		
		addAnnotation
		  (programStatusNameEEnum, 
		   source, 
		   new String[] {
			 "name", "Name_._type"
		   });		
		addAnnotation
		  (programStatusNameObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Name_._type:Object",
			 "baseType", "Name_._type"
		   });		
		addAnnotation
		  (programStatusValueEEnum, 
		   source, 
		   new String[] {
			 "name", "Value_._type"
		   });		
		addAnnotation
		  (programStatusValueObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Value_._type:Object",
			 "baseType", "Value_._type"
		   });			
		addAnnotation
		  (resultNameEEnum, 
		   source, 
		   new String[] {
			 "name", "ResultNameType"
		   });		
		addAnnotation
		  (resultNameObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ResultNameType:Object",
			 "baseType", "ResultNameType"
		   });			
		addAnnotation
		  (resultValueEClass, 
		   source, 
		   new String[] {
			 "name", "ResultValueType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResultValue_ResultInteger(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResultInteger",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResultValue_ResultString(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResultString",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResultValue_ResultFloat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResultFloat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResultValue_ResultName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ResultName"
		   });			
		addAnnotation
		  (sexEEnum, 
		   source, 
		   new String[] {
			 "name", "SexType"
		   });		
		addAnnotation
		  (sexObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "SexType:Object",
			 "baseType", "SexType"
		   });			
		addAnnotation
		  (speciesCodeEEnum, 
		   source, 
		   new String[] {
			 "name", "SpeciesCodeType"
		   });		
		addAnnotation
		  (speciesCodeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "SpeciesCodeType:Object",
			 "baseType", "SpeciesCodeType"
		   });			
		addAnnotation
		  (tagTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "TagType"
		   });		
		addAnnotation
		  (tagTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "TagType:Object",
			 "baseType", "TagType"
		   });		
		addAnnotation
		  (testEClass, 
		   source, 
		   new String[] {
			 "name", "TestType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTest_Result(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Result",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getTest_Idref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "idref"
		   });		
		addAnnotation
		  (getTest_TestCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TestCode"
		   });		
		addAnnotation
		  (townEDataType, 
		   source, 
		   new String[] {
			 "name", "Town_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "200"
		   });			
		addAnnotation
		  (usStateEEnum, 
		   source, 
		   new String[] {
			 "name", "UsState"
		   });		
		addAnnotation
		  (usStateObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "UsState:Object",
			 "baseType", "UsState"
		   });		
		addAnnotation
		  (veterinarianEClass, 
		   source, 
		   new String[] {
			 "name", "Veterinarian_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getVeterinarian_Person(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Person",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVeterinarian_Address(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Address",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVeterinarian_LicenseIssueState(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LicenseIssueState"
		   });		
		addAnnotation
		  (getVeterinarian_LicenseNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LicenseNumber"
		   });		
		addAnnotation
		  (getVeterinarian_NationalAccreditationNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NationalAccreditationNumber"
		   });			
		addAnnotation
		  (zipCodeEDataType, 
		   source, 
		   new String[] {
			 "name", "ZipCode",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "[0-9]{5} [0-9]{5}-[0-9]{4}"
		   });
	}

} //EcviPackageImpl
