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
 * A representation of the model object '<em><b>Large Mail User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getLargeMailUserName <em>Large Mail User Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getLargeMailUserIdentifier <em>Large Mail User Identifier</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getBuildingName <em>Building Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getAny <em>Any</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.LargeMailUser#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser()
 * @model extendedMetaData="name='LargeMailUserType' kind='elementOnly'"
 * @generated
 */
public interface LargeMailUser extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Large Mail User Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.LargeMailUserName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the large mail user. eg. Smith Ford International airport
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Large Mail User Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_LargeMailUserName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='LargeMailUserName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<LargeMailUserName> getLargeMailUserName();

	/**
	 * Returns the value of the '<em><b>Large Mail User Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of the identification number of a large mail user. An example are the Cedex codes in France.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Large Mail User Identifier</em>' containment reference.
	 * @see #setLargeMailUserIdentifier(LargeMailUserIdentifier)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_LargeMailUserIdentifier()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='LargeMailUserIdentifier' namespace='##targetNamespace'"
	 * @generated
	 */
	LargeMailUserIdentifier getLargeMailUserIdentifier();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getLargeMailUserIdentifier <em>Large Mail User Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Large Mail User Identifier</em>' containment reference.
	 * @see #getLargeMailUserIdentifier()
	 * @generated
	 */
	void setLargeMailUserIdentifier(LargeMailUserIdentifier value);

	/**
	 * Returns the value of the '<em><b>Building Name</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.BuildingName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the building
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Building Name</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_BuildingName()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BuildingName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BuildingName> getBuildingName();

	/**
	 * Returns the value of the '<em><b>Department</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Subdivision in the firm: School of Physics at Victoria University (School of Physics is the department)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Department</em>' containment reference.
	 * @see #setDepartment(Department)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_Department()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Department' namespace='##targetNamespace'"
	 * @generated
	 */
	Department getDepartment();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getDepartment <em>Department</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department</em>' containment reference.
	 * @see #getDepartment()
	 * @generated
	 */
	void setDepartment(Department value);

	/**
	 * Returns the value of the '<em><b>Post Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a postbox like mail delivery point. Only a single postbox number can be specified. Examples of postboxes are POBox, free mail numbers, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Box</em>' containment reference.
	 * @see #setPostBox(PostBox)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_PostBox()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostBox' namespace='##targetNamespace'"
	 * @generated
	 */
	PostBox getPostBox();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getPostBox <em>Post Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Box</em>' containment reference.
	 * @see #getPostBox()
	 * @generated
	 */
	void setPostBox(PostBox value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specification of a thoroughfare. A thoroughfare could be a rd, street, canal, river, etc.  Note dependentlocality in a street. For example, in some countries, a large street will 
	 * have many subdivisions with numbers. Normally the subdivision name is the same as the road name, but with a number to identifiy it. Eg. SOI SUKUMVIT 3, SUKUMVIT RD, BANGKOK
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare</em>' containment reference.
	 * @see #setThoroughfare(Thoroughfare)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_Thoroughfare()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Thoroughfare' namespace='##targetNamespace'"
	 * @generated
	 */
	Thoroughfare getThoroughfare();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getThoroughfare <em>Thoroughfare</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare</em>' containment reference.
	 * @see #getThoroughfare()
	 * @generated
	 */
	void setThoroughfare(Thoroughfare value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PostalCode is the container element for either simple or complex (extended) postal codes. Type: Area Code, Postcode, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' containment reference.
	 * @see #setPostalCode(PostalCode)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_PostalCode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PostalCode' namespace='##targetNamespace'"
	 * @generated
	 */
	PostalCode getPostalCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getPostalCode <em>Postal Code</em>}' containment reference.
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
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':8' processing='strict'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.LargeMailUser#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getLargeMailUser_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':10' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // LargeMailUser
