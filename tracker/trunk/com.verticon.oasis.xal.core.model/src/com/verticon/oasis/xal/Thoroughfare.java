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
 * A representation of the model object '<em><b>Thoroughfare</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getGroup <em>Group</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumber <em>Thoroughfare Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberRange <em>Thoroughfare Number Range</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareName <em>Thoroughfare Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfare <em>Dependent Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentLocality <em>Dependent Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getPremise <em>Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getFirm <em>Firm</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares <em>Dependent Thoroughfares</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresConnector <em>Dependent Thoroughfares Connector</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresIndicator <em>Dependent Thoroughfares Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresType <em>Dependent Thoroughfares Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.Thoroughfare#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare()
 * @model extendedMetaData="name='Thoroughfare_._type' kind='elementOnly'"
 * @generated
 */
public interface Thoroughfare extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:1'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Eg.: 23 Archer street or 25/15 Zero Avenue, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareNumber()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumber' namespace='##targetNamespace' group='#group:1'"
	 * @generated
	 */
	EList<ThoroughfareNumber> getThoroughfareNumber();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number Range</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareNumberRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A container to represent a range of numbers (from x thru y)for a thoroughfare. eg. 1-2 Albert Av
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number Range</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareNumberRange()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumberRange' namespace='##targetNamespace' group='#group:1'"
	 * @generated
	 */
	EList<ThoroughfareNumberRange> getThoroughfareNumberRange();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number Prefix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareNumberPrefix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Prefix before the number. A in A12 Archer Street
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number Prefix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareNumberPrefix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumberPrefix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number Suffix</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareNumberSuffix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Suffix after the number. A in 12A Archer Street
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number Suffix</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareNumberSuffix()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumberSuffix' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Pre Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * North Baker Street, where North is the pre-direction. The direction appears before the name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Pre Direction</em>' containment reference.
	 * @see #setThoroughfarePreDirection(ThoroughfarePreDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfarePreDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfarePreDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfarePreDirection getThoroughfarePreDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePreDirection <em>Thoroughfare Pre Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Pre Direction</em>' containment reference.
	 * @see #getThoroughfarePreDirection()
	 * @generated
	 */
	void setThoroughfarePreDirection(ThoroughfarePreDirection value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Leading Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Appears before the thoroughfare name. Ed. Spanish: Avenida Aurora, where Avenida is the leading type / French: Rue Moliere, where Rue is the leading type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Leading Type</em>' containment reference.
	 * @see #setThoroughfareLeadingType(ThoroughfareLeadingType)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareLeadingType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareLeadingType' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareLeadingType getThoroughfareLeadingType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareLeadingType <em>Thoroughfare Leading Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Leading Type</em>' containment reference.
	 * @see #getThoroughfareLeadingType()
	 * @generated
	 */
	void setThoroughfareLeadingType(ThoroughfareLeadingType value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.ThoroughfareName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the name of a Thoroughfare (also dependant street name): street name, canal name, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ThoroughfareName> getThoroughfareName();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Trailing Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Appears after the thoroughfare name. Ed. British: Baker Lane, where Lane is the trailing type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Trailing Type</em>' containment reference.
	 * @see #setThoroughfareTrailingType(ThoroughfareTrailingType)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfareTrailingType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareTrailingType' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareTrailingType getThoroughfareTrailingType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfareTrailingType <em>Thoroughfare Trailing Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Trailing Type</em>' containment reference.
	 * @see #getThoroughfareTrailingType()
	 * @generated
	 */
	void setThoroughfareTrailingType(ThoroughfareTrailingType value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Post Direction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 221-bis Baker Street North, where North is the post-direction. The post-direction appears after the name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Post Direction</em>' containment reference.
	 * @see #setThoroughfarePostDirection(ThoroughfarePostDirection)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_ThoroughfarePostDirection()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ThoroughfarePostDirection' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfarePostDirection getThoroughfarePostDirection();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getThoroughfarePostDirection <em>Thoroughfare Post Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Post Direction</em>' containment reference.
	 * @see #getThoroughfarePostDirection()
	 * @generated
	 */
	void setThoroughfarePostDirection(ThoroughfarePostDirection value);

	/**
	 * Returns the value of the '<em><b>Dependent Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DependentThroughfare is related to a street; occurs in GB, IE, ES, PT
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Thoroughfare</em>' containment reference.
	 * @see #setDependentThoroughfare(DependentThoroughfare)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentThoroughfare()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DependentThoroughfare' namespace='##targetNamespace'"
	 * @generated
	 */
	DependentThoroughfare getDependentThoroughfare();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfare <em>Dependent Thoroughfare</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Thoroughfare</em>' containment reference.
	 * @see #getDependentThoroughfare()
	 * @generated
	 */
	void setDependentThoroughfare(DependentThoroughfare value);

	/**
	 * Returns the value of the '<em><b>Dependent Locality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Dependent localities are Districts within cities/towns, locality divisions, postal 
	 * divisions of cities, suburbs, etc. DependentLocality is a recursive element, but no nesting deeper than two exists (Locality-DependentLocality-DependentLocality).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Locality</em>' containment reference.
	 * @see #setDependentLocality(DependentLocality)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentLocality()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DependentLocality' namespace='##targetNamespace'"
	 * @generated
	 */
	DependentLocality getDependentLocality();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentLocality <em>Dependent Locality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Locality</em>' containment reference.
	 * @see #getDependentLocality()
	 * @generated
	 */
	void setDependentLocality(DependentLocality value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_Premise()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Premise' namespace='##targetNamespace'"
	 * @generated
	 */
	Premise getPremise();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getPremise <em>Premise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise</em>' containment reference.
	 * @see #getPremise()
	 * @generated
	 */
	void setPremise(Premise value);

	/**
	 * Returns the value of the '<em><b>Firm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a firm, company, organization, etc. It can be specified as part of an address that contains a street or a postbox. It is therefore different from 
	 * a large mail user address, which contains no street.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Firm</em>' containment reference.
	 * @see #setFirm(Firm)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_Firm()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Firm' namespace='##targetNamespace'"
	 * @generated
	 */
	Firm getFirm();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getFirm <em>Firm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firm</em>' containment reference.
	 * @see #getFirm()
	 * @generated
	 */
	void setFirm(Firm value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PostalCode is the container element for either simple or complex (extended) postal codes. Type: Area Code, Postcode, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' containment reference.
	 * @see #setPostalCode(PostalCode)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_PostalCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCode' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalCode getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getPostalCode <em>Postal Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' containment reference.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(PostalCode value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':16' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Dependent Thoroughfares</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.DependentThoroughfaresType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Does this thoroughfare have a a dependent thoroughfare? Corner of street X, etc
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Thoroughfares</em>' attribute.
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @see #isSetDependentThoroughfares()
	 * @see #unsetDependentThoroughfares()
	 * @see #setDependentThoroughfares(DependentThoroughfaresType)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentThoroughfares()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='DependentThoroughfares'"
	 * @generated
	 */
	DependentThoroughfaresType getDependentThoroughfares();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares <em>Dependent Thoroughfares</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Thoroughfares</em>' attribute.
	 * @see com.verticon.oasis.xal.DependentThoroughfaresType
	 * @see #isSetDependentThoroughfares()
	 * @see #unsetDependentThoroughfares()
	 * @see #getDependentThoroughfares()
	 * @generated
	 */
	void setDependentThoroughfares(DependentThoroughfaresType value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares <em>Dependent Thoroughfares</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDependentThoroughfares()
	 * @see #getDependentThoroughfares()
	 * @see #setDependentThoroughfares(DependentThoroughfaresType)
	 * @generated
	 */
	void unsetDependentThoroughfares();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfares <em>Dependent Thoroughfares</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dependent Thoroughfares</em>' attribute is set.
	 * @see #unsetDependentThoroughfares()
	 * @see #getDependentThoroughfares()
	 * @see #setDependentThoroughfares(DependentThoroughfaresType)
	 * @generated
	 */
	boolean isSetDependentThoroughfares();

	/**
	 * Returns the value of the '<em><b>Dependent Thoroughfares Connector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Corner of Street1 AND Street 2 where AND is the Connector
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Thoroughfares Connector</em>' attribute.
	 * @see #setDependentThoroughfaresConnector(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentThoroughfaresConnector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='DependentThoroughfaresConnector'"
	 * @generated
	 */
	Object getDependentThoroughfaresConnector();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresConnector <em>Dependent Thoroughfares Connector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Thoroughfares Connector</em>' attribute.
	 * @see #getDependentThoroughfaresConnector()
	 * @generated
	 */
	void setDependentThoroughfaresConnector(Object value);

	/**
	 * Returns the value of the '<em><b>Dependent Thoroughfares Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Corner of, Intersection of
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Thoroughfares Indicator</em>' attribute.
	 * @see #setDependentThoroughfaresIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentThoroughfaresIndicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='DependentThoroughfaresIndicator'"
	 * @generated
	 */
	Object getDependentThoroughfaresIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresIndicator <em>Dependent Thoroughfares Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Thoroughfares Indicator</em>' attribute.
	 * @see #getDependentThoroughfaresIndicator()
	 * @generated
	 */
	void setDependentThoroughfaresIndicator(Object value);

	/**
	 * Returns the value of the '<em><b>Dependent Thoroughfares Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * STS in GEORGE and ADELAIDE STS, RDS IN A and B RDS, etc. Use only when both the street types are the same
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Dependent Thoroughfares Type</em>' attribute.
	 * @see #setDependentThoroughfaresType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_DependentThoroughfaresType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='DependentThoroughfaresType'"
	 * @generated
	 */
	Object getDependentThoroughfaresType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getDependentThoroughfaresType <em>Dependent Thoroughfares Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent Thoroughfares Type</em>' attribute.
	 * @see #getDependentThoroughfaresType()
	 * @generated
	 */
	void setDependentThoroughfaresType(Object value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.Thoroughfare#getType <em>Type</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfare_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':22' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // Thoroughfare
