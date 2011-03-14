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
 * A representation of the model object '<em><b>Thoroughfare Number Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberFrom <em>Thoroughfare Number From</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberTo <em>Thoroughfare Number To</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getCode <em>Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence <em>Indicator Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence <em>Number Range Occurrence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType <em>Range Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getSeparator <em>Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getType <em>Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange()
 * @model extendedMetaData="name='ThoroughfareNumberRange_._type' kind='elementOnly'"
 * @generated
 */
public interface ThoroughfareNumberRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Line</b></em>' containment reference list.
	 * The list contents are of type {@link com.verticon.oasis.xal.AddressLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Free format address representation. An address can have more than one line. The order of the AddressLine elements must be preserved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Line</em>' containment reference list.
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_AddressLine()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AddressLine' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AddressLine> getAddressLine();

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Starting number in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number From</em>' containment reference.
	 * @see #setThoroughfareNumberFrom(ThoroughfareNumberFrom)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_ThoroughfareNumberFrom()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumberFrom' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareNumberFrom getThoroughfareNumberFrom();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberFrom <em>Thoroughfare Number From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Number From</em>' containment reference.
	 * @see #getThoroughfareNumberFrom()
	 * @generated
	 */
	void setThoroughfareNumberFrom(ThoroughfareNumberFrom value);

	/**
	 * Returns the value of the '<em><b>Thoroughfare Number To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ending number in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Thoroughfare Number To</em>' containment reference.
	 * @see #setThoroughfareNumberTo(ThoroughfareNumberTo)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_ThoroughfareNumberTo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ThoroughfareNumberTo' namespace='##targetNamespace'"
	 * @generated
	 */
	ThoroughfareNumberTo getThoroughfareNumberTo();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getThoroughfareNumberTo <em>Thoroughfare Number To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thoroughfare Number To</em>' containment reference.
	 * @see #getThoroughfareNumberTo()
	 * @generated
	 */
	void setThoroughfareNumberTo(ThoroughfareNumberTo value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used by postal services to encode the name of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_Code()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Code'"
	 * @generated
	 */
	Object getCode();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getCode <em>Code</em>}' attribute.
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
	 * "No." No.12-13
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator</em>' attribute.
	 * @see #setIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_Indicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Indicator'"
	 * @generated
	 */
	Object getIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicator <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator</em>' attribute.
	 * @see #getIndicator()
	 * @generated
	 */
	void setIndicator(Object value);

	/**
	 * Returns the value of the '<em><b>Indicator Occurrence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.IndicatorOccurrence1}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No.12-14 where "No." is before actual street number
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @see #isSetIndicatorOccurrence()
	 * @see #unsetIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence1)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_IndicatorOccurrence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='IndicatorOccurrence'"
	 * @generated
	 */
	IndicatorOccurrence1 getIndicatorOccurrence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurrence1
	 * @see #isSetIndicatorOccurrence()
	 * @see #unsetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @generated
	 */
	void setIndicatorOccurrence(IndicatorOccurrence1 value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence1)
	 * @generated
	 */
	void unsetIndicatorOccurrence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getIndicatorOccurrence <em>Indicator Occurrence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Indicator Occurrence</em>' attribute is set.
	 * @see #unsetIndicatorOccurrence()
	 * @see #getIndicatorOccurrence()
	 * @see #setIndicatorOccurrence(IndicatorOccurrence1)
	 * @generated
	 */
	boolean isSetIndicatorOccurrence();

	/**
	 * Returns the value of the '<em><b>Number Range Occurrence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.NumberRangeOccurrence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 23-25 Archer St, where number appears before name
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Range Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @see #isSetNumberRangeOccurrence()
	 * @see #unsetNumberRangeOccurrence()
	 * @see #setNumberRangeOccurrence(NumberRangeOccurrence)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_NumberRangeOccurrence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='NumberRangeOccurrence'"
	 * @generated
	 */
	NumberRangeOccurrence getNumberRangeOccurrence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence <em>Number Range Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Range Occurrence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberRangeOccurrence
	 * @see #isSetNumberRangeOccurrence()
	 * @see #unsetNumberRangeOccurrence()
	 * @see #getNumberRangeOccurrence()
	 * @generated
	 */
	void setNumberRangeOccurrence(NumberRangeOccurrence value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence <em>Number Range Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberRangeOccurrence()
	 * @see #getNumberRangeOccurrence()
	 * @see #setNumberRangeOccurrence(NumberRangeOccurrence)
	 * @generated
	 */
	void unsetNumberRangeOccurrence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getNumberRangeOccurrence <em>Number Range Occurrence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Range Occurrence</em>' attribute is set.
	 * @see #unsetNumberRangeOccurrence()
	 * @see #getNumberRangeOccurrence()
	 * @see #setNumberRangeOccurrence(NumberRangeOccurrence)
	 * @generated
	 */
	boolean isSetNumberRangeOccurrence();

	/**
	 * Returns the value of the '<em><b>Range Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.RangeTypeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Thoroughfare number ranges are odd or even
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range Type</em>' attribute.
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @see #isSetRangeType()
	 * @see #unsetRangeType()
	 * @see #setRangeType(RangeTypeType)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_RangeType()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='RangeType'"
	 * @generated
	 */
	RangeTypeType getRangeType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Type</em>' attribute.
	 * @see com.verticon.oasis.xal.RangeTypeType
	 * @see #isSetRangeType()
	 * @see #unsetRangeType()
	 * @see #getRangeType()
	 * @generated
	 */
	void setRangeType(RangeTypeType value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRangeType()
	 * @see #getRangeType()
	 * @see #setRangeType(RangeTypeType)
	 * @generated
	 */
	void unsetRangeType();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getRangeType <em>Range Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Range Type</em>' attribute is set.
	 * @see #unsetRangeType()
	 * @see #getRangeType()
	 * @see #setRangeType(RangeTypeType)
	 * @generated
	 */
	boolean isSetRangeType();

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "-" in 12-14  or "Thru" in 12 Thru 14 etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #setSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_Separator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Separator'"
	 * @generated
	 */
	Object getSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(Object value);

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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.ThoroughfareNumberRange#getType <em>Type</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getThoroughfareNumberRange_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':10' processing='strict'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // ThoroughfareNumberRange
