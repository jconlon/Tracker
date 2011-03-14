/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Premise Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getPremiseNumberSeparator <em>Premise Number Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.SubPremiseNumber#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber()
 * @model extendedMetaData="name='SubPremiseNumber_._type' kind='mixed'"
 * @generated
 */
public interface SubPremiseNumber extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used by postal services to encode the name of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_Code()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	Object getCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Object value);

	/**
	 * Returns the value of the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "TH" in 12TH which is a floor number, "NO." in NO.1, "#" in APT #12, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator</em>' attribute.
	 * @see #setIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_Indicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Indicator'"
	 * @generated
	 */
	Object getIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicator <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator</em>' attribute.
	 * @see #getIndicator()
	 * @generated
	 */
	void setIndicator(Object value);

	/**
	 * Returns the value of the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.IndicatorOccurrence2}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "No." occurs before 1 in No.1, or TH occurs after 12 in 12TH
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @see #isSetIndicatorOccurrence()
	 * @see #unsetIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence2)
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_IndicatorOccurrence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='IndicatorOccurrence'"
	 * @generated
	 */
	IndicatorOccurrence2 getIndicatorOccurrence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence2
	 * @see #isSetIndicatorOccurrence()
	 * @see #unsetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @generated
	 */
	void setIndicatorOccurrence(IndicatorOccurrence2 value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence2)
	 * @generated
	 */
	void unsetIndicatorOccurrence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Indicator Occurrence</em>' attribute is set.
	 * @see #unsetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence2)
	 * @generated
	 */
	boolean isSetIndicatorOccurrence();

	/**
	 * Returns the value of the '<em><b>Number Type Occurrence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.NumberTypeOccurrence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 12TH occurs "before" FLOOR (a type of subpremise) in 12TH FLOOR
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Type Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @see #isSetNumberTypeOccurrence()
	 * @see #unsetNumberTypeOccurrence()
	 * @see #setNumberTypeOccurrence(NumberTypeOccurrence)
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_NumberTypeOccurrence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='NumberTypeOccurrence'"
	 * @generated
	 */
	NumberTypeOccurrence getNumberTypeOccurrence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Type Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberTypeOccurrence
	 * @see #isSetNumberTypeOccurrence()
	 * @see #unsetNumberTypeOccurrence()
	 * @see #getNumberTypeOccurrence()
	 * @generated
	 */
	void setNumberTypeOccurrence(NumberTypeOccurrence value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberTypeOccurrence()
	 * @see #getNumberTypeOccurrence()
	 * @see #setNumberTypeOccurrence(NumberTypeOccurrence)
	 * @generated
	 */
	void unsetNumberTypeOccurrence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getNumberTypeOccurrence <em>Number Type Occurrence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Type Occurrence</em>' attribute is set.
	 * @see #unsetNumberTypeOccurrence()
	 * @see #getNumberTypeOccurrence()
	 * @see #setNumberTypeOccurrence(NumberTypeOccurrence)
	 * @generated
	 */
	boolean isSetNumberTypeOccurrence();

	/**
	 * Returns the value of the '<em><b>Premise Number Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "/" in 12/14 Archer Street where 12 is sub-premise number and 14 is premise number
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Separator</em>' attribute.
	 * @see #setPremiseNumberSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_PremiseNumberSeparator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='PremiseNumberSeparator'"
	 * @generated
	 */
	Object getPremiseNumberSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getPremiseNumberSeparator <em>Premise Number Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Number Separator</em>' attribute.
	 * @see #getPremiseNumberSeparator()
	 * @generated
	 */
	void setPremiseNumberSeparator(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.SubPremiseNumber#getType <em>Type</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getSubPremiseNumber_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':7' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // SubPremiseNumber
