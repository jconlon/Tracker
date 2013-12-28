/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage
 * @generated
 */
public interface EcviFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcviFactory eINSTANCE = org.usaha.ecvi.impl.EcviFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Accession</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Accession</em>'.
	 * @generated
	 */
	Accession createAccession();

	/**
	 * Returns a new object of class '<em>Accessions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Accessions</em>'.
	 * @generated
	 */
	Accessions createAccessions();

	/**
	 * Returns a new object of class '<em>Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address</em>'.
	 * @generated
	 */
	Address createAddress();

	/**
	 * Returns a new object of class '<em>Animal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animal</em>'.
	 * @generated
	 */
	Animal createAnimal();

	/**
	 * Returns a new object of class '<em>Animal Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animal Tag</em>'.
	 * @generated
	 */
	AnimalTag createAnimalTag();

	/**
	 * Returns a new object of class '<em>Attachement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachement</em>'.
	 * @generated
	 */
	Attachement createAttachement();

	/**
	 * Returns a new object of class '<em>Contact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contact</em>'.
	 * @generated
	 */
	Contact createContact();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Ecvi</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecvi</em>'.
	 * @generated
	 */
	Ecvi createEcvi();

	/**
	 * Returns a new object of class '<em>Geo Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Geo Point</em>'.
	 * @generated
	 */
	GeoPoint createGeoPoint();

	/**
	 * Returns a new object of class '<em>Group Lot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Lot</em>'.
	 * @generated
	 */
	GroupLot createGroupLot();

	/**
	 * Returns a new object of class '<em>Laboratory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Laboratory</em>'.
	 * @generated
	 */
	Laboratory createLaboratory();

	/**
	 * Returns a new object of class '<em>Movement Purposes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Movement Purposes</em>'.
	 * @generated
	 */
	MovementPurposes createMovementPurposes();

	/**
	 * Returns a new object of class '<em>Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person</em>'.
	 * @generated
	 */
	Person createPerson();

	/**
	 * Returns a new object of class '<em>Phone Num</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Phone Num</em>'.
	 * @generated
	 */
	PhoneNum createPhoneNum();

	/**
	 * Returns a new object of class '<em>Premises</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Premises</em>'.
	 * @generated
	 */
	Premises createPremises();

	/**
	 * Returns a new object of class '<em>Program Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program Status</em>'.
	 * @generated
	 */
	ProgramStatus createProgramStatus();

	/**
	 * Returns a new object of class '<em>Result Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Value</em>'.
	 * @generated
	 */
	ResultValue createResultValue();

	/**
	 * Returns a new object of class '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test</em>'.
	 * @generated
	 */
	Test createTest();

	/**
	 * Returns a new object of class '<em>Veterinarian</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Veterinarian</em>'.
	 * @generated
	 */
	Veterinarian createVeterinarian();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EcviPackage getEcviPackage();

} //EcviFactory
