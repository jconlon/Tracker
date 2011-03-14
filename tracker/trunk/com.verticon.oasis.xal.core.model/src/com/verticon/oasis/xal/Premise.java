/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Premise</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.Premise#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseName <em>Premise Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseLocation <em>Premise Location</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseNumber <em>Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseNumberRange <em>Premise Number Range</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseNumberPrefix <em>Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseNumberSuffix <em>Premise Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getBuildingName <em>Building Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getSubPremise <em>Sub Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getFirm <em>Firm</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getMailStop <em>Mail Stop</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremise <em>Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseDependency <em>Premise Dependency</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseDependencyType <em>Premise Dependency Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getPremiseThoroughfareConnector <em>Premise Thoroughfare Connector</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Premise#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPremise()
 * @model extendedMetaData="name='Premise_._type' kind='elementOnly'"
 * @generated
 */
public interface Premise extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Premise Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the name of the premise (house, building, park, farm, etc). A premise name is specified when the premise cannot be addressed using a street name plus premise (house) number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseName> getPremiseName();

	/**
	 * Returns the value of the '<em><b>Premise Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * LOBBY, BASEMENT, GROUND FLOOR, etc...
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Location</em>' containment reference.
	 * @see #setPremiseLocation(PremiseLocation)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseLocation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseLocation' namespace='##targetNamespace'"
	 * @generated
	 */
	PremiseLocation getPremiseLocation();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremiseLocation <em>Premise Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Location</em>' containment reference.
	 * @see #getPremiseLocation()
	 * @generated
	 */
	void setPremiseLocation(PremiseLocation value);

	/**
	 * Returns the value of the '<em><b>Premise Number</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the identifier of the premise (house, building, etc). Premises in a street are often uniquely identified by means of consecutive identifiers. The identifier can be a number, a letter or any combination of the two.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseNumber()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumber' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumber> getPremiseNumber();

	/**
	 * Returns the value of the '<em><b>Premise Number Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification for defining the premise number range. Some premises have number as Building C1-C7
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Range</em>' containment reference.
	 * @see #setPremiseNumberRange(PremiseNumberRange)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseNumberRange()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberRange' namespace='##targetNamespace'"
	 * @generated
	 */
	PremiseNumberRange getPremiseNumberRange();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremiseNumberRange <em>Premise Number Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Number Range</em>' containment reference.
	 * @see #getPremiseNumberRange()
	 * @generated
	 */
	void setPremiseNumberRange(PremiseNumberRange value);

	/**
	 * Returns the value of the '<em><b>Premise Number Prefix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumberPrefix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A in A12
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Prefix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseNumberPrefix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberPrefix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumberPrefix> getPremiseNumberPrefix();

	/**
	 * Returns the value of the '<em><b>Premise Number Suffix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.PremiseNumberSuffix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A in 12A
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Suffix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseNumberSuffix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberSuffix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PremiseNumberSuffix> getPremiseNumberSuffix();

	/**
	 * Returns the value of the '<em><b>Building Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.BuildingName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the name of a building.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Building Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_BuildingName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BuildingName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BuildingName> getBuildingName();

	/**
	 * Returns the value of the '<em><b>Sub Premise</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.SubPremise}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a single sub-premise. Examples of sub-premises are apartments and suites. Each sub-premise should be uniquely identifiable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Premise</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_SubPremise()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubPremise' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SubPremise> getSubPremise();

	/**
	 * Returns the value of the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a firm, company, organization, etc. It can be specified as part of an address that contains a street or a postbox. It is therefore different from a large mail user address, which contains no street.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Firm</em>' containment reference.
	 * @see #setFirm(Firm)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_Firm()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Firm' namespace='##targetNamespace'"
	 * @generated
	 */
	Firm getFirm();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getFirm <em>Firm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firm</em>' containment reference.
	 * @see #getFirm()
	 * @generated
	 */
	void setFirm(Firm value);

	/**
	 * Returns the value of the '<em><b>Mail Stop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MailStop is where the the mail is delivered to within a premise/subpremise/firm or a facility.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mail Stop</em>' containment reference.
	 * @see #setMailStop(MailStop)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_MailStop()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MailStop' namespace='##targetNamespace'"
	 * @generated
	 */
	MailStop getMailStop();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getMailStop <em>Mail Stop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail Stop</em>' containment reference.
	 * @see #getMailStop()
	 * @generated
	 */
	void setMailStop(MailStop value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PostalCode is the container element for either simple or complex (extended) postal codes. Type: Area Code, Postcode, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' containment reference.
	 * @see #setPostalCode(PostalCode)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PostalCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCode' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalCode getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPostalCode <em>Postal Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' containment reference.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(PostalCode value);

	/**
	 * Returns the value of the '<em><b>Premise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a single premise, for example a house or a building. The premise as a whole has a unique premise (house) number or a premise name.  There could be more than 
	 * one premise in a street referenced in an address. For example a building address near a major shopping centre or raiwlay station
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise</em>' containment reference.
	 * @see #setPremise(Premise)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_Premise()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Premise' namespace='##targetNamespace'"
	 * @generated
	 */
	Premise getPremise();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremise <em>Premise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise</em>' containment reference.
	 * @see #getPremise()
	 * @generated
	 */
	void setPremise(Premise value);

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':13' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Premise Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * STREET, PREMISE, SUBPREMISE, PARK, FARM, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Dependency</em>' attribute.
	 * @see #setPremiseDependency(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseDependency()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='PremiseDependency'"
	 * @generated
	 */
	Object getPremiseDependency();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremiseDependency <em>Premise Dependency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Dependency</em>' attribute.
	 * @see #getPremiseDependency()
	 * @generated
	 */
	void setPremiseDependency(Object value);

	/**
	 * Returns the value of the '<em><b>Premise Dependency Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * NEAR, ADJACENT TO, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Dependency Type</em>' attribute.
	 * @see #setPremiseDependencyType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseDependencyType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='PremiseDependencyType'"
	 * @generated
	 */
	Object getPremiseDependencyType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremiseDependencyType <em>Premise Dependency Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Dependency Type</em>' attribute.
	 * @see #getPremiseDependencyType()
	 * @generated
	 */
	void setPremiseDependencyType(Object value);

	/**
	 * Returns the value of the '<em><b>Premise Thoroughfare Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DES, DE, LA, LA, DU in RUE DU BOIS. These terms connect a premise/thoroughfare type and premise/thoroughfare name. Terms may appear with names AVE DU BOIS
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Thoroughfare Connector</em>' attribute.
	 * @see #setPremiseThoroughfareConnector(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_PremiseThoroughfareConnector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='PremiseThoroughfareConnector'"
	 * @generated
	 */
	Object getPremiseThoroughfareConnector();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getPremiseThoroughfareConnector <em>Premise Thoroughfare Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Thoroughfare Connector</em>' attribute.
	 * @see #getPremiseThoroughfareConnector()
	 * @generated
	 */
	void setPremiseThoroughfareConnector(Object value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * COMPLEXE in COMPLEX DES JARDINS, A building, station, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Premise#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getPremise_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':18' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // Premise
