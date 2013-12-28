/**
 */
package org.usaha.ecvi;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecvi</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Ecvi#getVeterinarian <em>Veterinarian</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getMovementPurposes <em>Movement Purposes</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getConsignor <em>Consignor</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getConsignee <em>Consignee</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getAccessions <em>Accessions</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getGroup <em>Group</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getAnimal <em>Animal</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getGroupLot <em>Group Lot</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getAttachment <em>Attachment</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getCviNumber <em>Cvi Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getEntryPermitNumber <em>Entry Permit Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getExpirationDate <em>Expiration Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getShipmentDate <em>Shipment Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.Ecvi#getSpeciesCode <em>Species Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getEcvi()
 * @model extendedMetaData="name='eCVI_._type' kind='elementOnly'"
 * @generated
 */
public interface Ecvi extends EObject {
	/**
	 * Returns the value of the '<em><b>Veterinarian</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Veterinarian</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Veterinarian</em>' containment reference.
	 * @see #setVeterinarian(Veterinarian)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Veterinarian()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Veterinarian' namespace='##targetNamespace'"
	 * @generated
	 */
	Veterinarian getVeterinarian();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getVeterinarian <em>Veterinarian</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Veterinarian</em>' containment reference.
	 * @see #getVeterinarian()
	 * @generated
	 */
	void setVeterinarian(Veterinarian value);

	/**
	 * Returns the value of the '<em><b>Movement Purposes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movement Purposes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movement Purposes</em>' containment reference.
	 * @see #setMovementPurposes(MovementPurposes)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_MovementPurposes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='MovementPurposes' namespace='##targetNamespace'"
	 * @generated
	 */
	MovementPurposes getMovementPurposes();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getMovementPurposes <em>Movement Purposes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movement Purposes</em>' containment reference.
	 * @see #getMovementPurposes()
	 * @generated
	 */
	void setMovementPurposes(MovementPurposes value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' containment reference.
	 * @see #setOrigin(Premises)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Origin()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Origin' namespace='##targetNamespace'"
	 * @generated
	 */
	Premises getOrigin();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getOrigin <em>Origin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' containment reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(Premises value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(Premises)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Destination()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Destination' namespace='##targetNamespace'"
	 * @generated
	 */
	Premises getDestination();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Premises value);

	/**
	 * Returns the value of the '<em><b>Consignor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consignor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consignor</em>' containment reference.
	 * @see #setConsignor(Contact)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Consignor()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Consignor' namespace='##targetNamespace'"
	 * @generated
	 */
	Contact getConsignor();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getConsignor <em>Consignor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consignor</em>' containment reference.
	 * @see #getConsignor()
	 * @generated
	 */
	void setConsignor(Contact value);

	/**
	 * Returns the value of the '<em><b>Consignee</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consignee</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consignee</em>' containment reference.
	 * @see #setConsignee(Contact)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Consignee()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Consignee' namespace='##targetNamespace'"
	 * @generated
	 */
	Contact getConsignee();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getConsignee <em>Consignee</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consignee</em>' containment reference.
	 * @see #getConsignee()
	 * @generated
	 */
	void setConsignee(Contact value);

	/**
	 * Returns the value of the '<em><b>Accessions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessions</em>' containment reference.
	 * @see #setAccessions(Accessions)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Accessions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Accessions' namespace='##targetNamespace'"
	 * @generated
	 */
	Accessions getAccessions();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getAccessions <em>Accessions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessions</em>' containment reference.
	 * @see #getAccessions()
	 * @generated
	 */
	void setAccessions(Accessions value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:7'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Animal</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.Animal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Animal()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Animal' namespace='##targetNamespace' group='#group:7'"
	 * @generated
	 */
	EList<Animal> getAnimal();

	/**
	 * Returns the value of the '<em><b>Group1</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group1</em>' attribute list.
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Group1()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:9'"
	 * @generated
	 */
	FeatureMap getGroup1();

	/**
	 * Returns the value of the '<em><b>Group Lot</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.GroupLot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Lot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Lot</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_GroupLot()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='GroupLot' namespace='##targetNamespace' group='#group:9'"
	 * @generated
	 */
	EList<GroupLot> getGroupLot();

	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.Attachement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_Attachment()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Attachment' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Attachement> getAttachment();

	/**
	 * Returns the value of the '<em><b>Cvi Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the CVI number for this CVI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cvi Number</em>' attribute.
	 * @see #setCviNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_CviNumber()
	 * @model dataType="org.usaha.ecvi.CviNumber" required="true"
	 *        extendedMetaData="kind='attribute' name='CviNumber'"
	 * @generated
	 */
	String getCviNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getCviNumber <em>Cvi Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cvi Number</em>' attribute.
	 * @see #getCviNumber()
	 * @generated
	 */
	void setCviNumber(String value);

	/**
	 * Returns the value of the '<em><b>Entry Permit Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Permit Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Permit Number</em>' attribute.
	 * @see #setEntryPermitNumber(String)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_EntryPermitNumber()
	 * @model dataType="org.usaha.ecvi.EntryPermitNumber"
	 *        extendedMetaData="kind='attribute' name='EntryPermitNumber'"
	 * @generated
	 */
	String getEntryPermitNumber();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getEntryPermitNumber <em>Entry Permit Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Permit Number</em>' attribute.
	 * @see #getEntryPermitNumber()
	 * @generated
	 */
	void setEntryPermitNumber(String value);

	/**
	 * Returns the value of the '<em><b>Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the last date on which this CVI remains valid.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expiration Date</em>' attribute.
	 * @see #setExpirationDate(XMLGregorianCalendar)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_ExpirationDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
	 *        extendedMetaData="kind='attribute' name='ExpirationDate'"
	 * @generated
	 */
	XMLGregorianCalendar getExpirationDate();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getExpirationDate <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiration Date</em>' attribute.
	 * @see #getExpirationDate()
	 * @generated
	 */
	void setExpirationDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the date on which the CVI was issued.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Issue Date</em>' attribute.
	 * @see #setIssueDate(XMLGregorianCalendar)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_IssueDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
	 *        extendedMetaData="kind='attribute' name='IssueDate'"
	 * @generated
	 */
	XMLGregorianCalendar getIssueDate();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getIssueDate <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Date</em>' attribute.
	 * @see #getIssueDate()
	 * @generated
	 */
	void setIssueDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Shipment Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the date on which the animals will leave the origin premises to commence their interstate movement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shipment Date</em>' attribute.
	 * @see #setShipmentDate(XMLGregorianCalendar)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_ShipmentDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
	 *        extendedMetaData="kind='attribute' name='ShipmentDate'"
	 * @generated
	 */
	XMLGregorianCalendar getShipmentDate();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getShipmentDate <em>Shipment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shipment Date</em>' attribute.
	 * @see #getShipmentDate()
	 * @generated
	 */
	void setShipmentDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Species Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.SpeciesCode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the Species for all the animals contained in this CVI.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Species Code</em>' attribute.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see #isSetSpeciesCode()
	 * @see #unsetSpeciesCode()
	 * @see #setSpeciesCode(SpeciesCode)
	 * @see org.usaha.ecvi.EcviPackage#getEcvi_SpeciesCode()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='SpeciesCode'"
	 * @generated
	 */
	SpeciesCode getSpeciesCode();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Ecvi#getSpeciesCode <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Species Code</em>' attribute.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see #isSetSpeciesCode()
	 * @see #unsetSpeciesCode()
	 * @see #getSpeciesCode()
	 * @generated
	 */
	void setSpeciesCode(SpeciesCode value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Ecvi#getSpeciesCode <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpeciesCode()
	 * @see #getSpeciesCode()
	 * @see #setSpeciesCode(SpeciesCode)
	 * @generated
	 */
	void unsetSpeciesCode();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Ecvi#getSpeciesCode <em>Species Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Species Code</em>' attribute is set.
	 * @see #unsetSpeciesCode()
	 * @see #getSpeciesCode()
	 * @see #setSpeciesCode(SpeciesCode)
	 * @generated
	 */
	boolean isSetSpeciesCode();

} // Ecvi
