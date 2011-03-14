/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Premise Number Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeFrom <em>Premise Number Range From</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeTo <em>Premise Number Range To</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicator <em>Indicator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence <em>Indicator Occurence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence <em>Number Range Occurence</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getRangeType <em>Range Type</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getSeparator <em>Separator</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.PremiseNumberRange#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange()
 * @model extendedMetaData="name='PremiseNumberRange_._type' kind='elementOnly'"
 * @generated
 */
public interface PremiseNumberRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Premise Number Range From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Start number details of the premise number range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Range From</em>' containment reference.
	 * @see #setPremiseNumberRangeFrom(PremiseNumberRangeFrom)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_PremiseNumberRangeFrom()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberRangeFrom' namespace='##targetNamespace'"
	 * @generated
	 */
	PremiseNumberRangeFrom getPremiseNumberRangeFrom();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeFrom <em>Premise Number Range From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Number Range From</em>' containment reference.
	 * @see #getPremiseNumberRangeFrom()
	 * @generated
	 */
	void setPremiseNumberRangeFrom(PremiseNumberRangeFrom value);

	/**
	 * Returns the value of the '<em><b>Premise Number Range To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * End number details of the premise number range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Premise Number Range To</em>' containment reference.
	 * @see #setPremiseNumberRangeTo(PremiseNumberRangeTo)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_PremiseNumberRangeTo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PremiseNumberRangeTo' namespace='##targetNamespace'"
	 * @generated
	 */
	PremiseNumberRangeTo getPremiseNumberRangeTo();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getPremiseNumberRangeTo <em>Premise Number Range To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise Number Range To</em>' containment reference.
	 * @see #getPremiseNumberRangeTo()
	 * @generated
	 */
	void setPremiseNumberRangeTo(PremiseNumberRangeTo value);

	/**
	 * Returns the value of the '<em><b>Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Eg. No. in Building No:C1-C5
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator</em>' attribute.
	 * @see #setIndicator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_Indicator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Indicator'"
	 * @generated
	 */
	Object getIndicator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicator <em>Indicator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator</em>' attribute.
	 * @see #getIndicator()
	 * @generated
	 */
	void setIndicator(Object value);

	/**
	 * Returns the value of the '<em><b>Indicator Occurence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.IndicatorOccurence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No.12-14 where "No." is before actual street number
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Indicator Occurence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @see #isSetIndicatorOccurence()
	 * @see #unsetIndicatorOccurence()
	 * @see #setIndicatorOccurence(IndicatorOccurence)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_IndicatorOccurence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='IndicatorOccurence'"
	 * @generated
	 */
	IndicatorOccurence getIndicatorOccurence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence <em>Indicator Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indicator Occurence</em>' attribute.
	 * @see com.verticon.oasis.xal.IndicatorOccurence
	 * @see #isSetIndicatorOccurence()
	 * @see #unsetIndicatorOccurence()
	 * @see #getIndicatorOccurence()
	 * @generated
	 */
	void setIndicatorOccurence(IndicatorOccurence value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence <em>Indicator Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndicatorOccurence()
	 * @see #getIndicatorOccurence()
	 * @see #setIndicatorOccurence(IndicatorOccurence)
	 * @generated
	 */
	void unsetIndicatorOccurence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getIndicatorOccurence <em>Indicator Occurence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Indicator Occurence</em>' attribute is set.
	 * @see #unsetIndicatorOccurence()
	 * @see #getIndicatorOccurence()
	 * @see #setIndicatorOccurence(IndicatorOccurence)
	 * @generated
	 */
	boolean isSetIndicatorOccurence();

	/**
	 * Returns the value of the '<em><b>Number Range Occurence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.verticon.oasis.xal.NumberRangeOccurence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Building 23-25 where the number occurs after building name
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Range Occurence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @see #isSetNumberRangeOccurence()
	 * @see #unsetNumberRangeOccurence()
	 * @see #setNumberRangeOccurence(NumberRangeOccurence)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_NumberRangeOccurence()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='NumberRangeOccurence'"
	 * @generated
	 */
	NumberRangeOccurence getNumberRangeOccurence();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence <em>Number Range Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Range Occurence</em>' attribute.
	 * @see com.verticon.oasis.xal.NumberRangeOccurence
	 * @see #isSetNumberRangeOccurence()
	 * @see #unsetNumberRangeOccurence()
	 * @see #getNumberRangeOccurence()
	 * @generated
	 */
	void setNumberRangeOccurence(NumberRangeOccurence value);

	/**
	 * Unsets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence <em>Number Range Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberRangeOccurence()
	 * @see #getNumberRangeOccurence()
	 * @see #setNumberRangeOccurence(NumberRangeOccurence)
	 * @generated
	 */
	void unsetNumberRangeOccurence();

	/**
	 * Returns whether the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getNumberRangeOccurence <em>Number Range Occurence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Range Occurence</em>' attribute is set.
	 * @see #unsetNumberRangeOccurence()
	 * @see #getNumberRangeOccurence()
	 * @see #setNumberRangeOccurence(NumberRangeOccurence)
	 * @generated
	 */
	boolean isSetNumberRangeOccurence();

	/**
	 * Returns the value of the '<em><b>Range Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Eg. Odd or even number range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range Type</em>' attribute.
	 * @see #setRangeType(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_RangeType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='RangeType'"
	 * @generated
	 */
	Object getRangeType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getRangeType <em>Range Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Type</em>' attribute.
	 * @see #getRangeType()
	 * @generated
	 */
	void setRangeType(Object value);

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "-" in 12-14  or "Thru" in 12 Thru 14 etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #setSeparator(Object)
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_Separator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Separator'"
	 * @generated
	 */
	Object getSeparator();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getSeparator <em>Separator</em>}' attribute.
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
	 * @see com.verticon.oasis.xal.XalPackage#getPremiseNumberRange_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link com.verticon.oasis.xal.PremiseNumberRange#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

} // PremiseNumberRange
