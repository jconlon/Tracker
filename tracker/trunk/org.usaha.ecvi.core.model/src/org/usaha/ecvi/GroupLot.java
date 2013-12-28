/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Lot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.GroupLot#getAge <em>Age</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getBreed <em>Breed</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getDescription <em>Description</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getSex <em>Sex</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getSexDetail <em>Sex Detail</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getSpecies <em>Species</em>}</li>
 *   <li>{@link org.usaha.ecvi.GroupLot#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getGroupLot()
 * @model extendedMetaData="name='GroupLot_._type' kind='empty'"
 * @generated
 */
public interface GroupLot extends EObject {
	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(String)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Age()
	 * @model dataType="org.usaha.ecvi.Age"
	 *        extendedMetaData="kind='attribute' name='Age'"
	 * @generated
	 */
	String getAge();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(String value);

	/**
	 * Returns the value of the '<em><b>Breed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Breed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Breed</em>' attribute.
	 * @see #setBreed(String)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Breed()
	 * @model dataType="org.usaha.ecvi.Breed"
	 *        extendedMetaData="kind='attribute' name='Breed'"
	 * @generated
	 */
	String getBreed();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getBreed <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Breed</em>' attribute.
	 * @see #getBreed()
	 * @generated
	 */
	void setBreed(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Description()
	 * @model dataType="org.usaha.ecvi.GroupLotDescription" required="true"
	 *        extendedMetaData="kind='attribute' name='Description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the quantity of animals or other commodity included in this GroupLot element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #isSetQuantity()
	 * @see #unsetQuantity()
	 * @see #setQuantity(float)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Quantity()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float" required="true"
	 *        extendedMetaData="kind='attribute' name='Quantity'"
	 * @generated
	 */
	float getQuantity();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #isSetQuantity()
	 * @see #unsetQuantity()
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(float value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.GroupLot#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuantity()
	 * @see #getQuantity()
	 * @see #setQuantity(float)
	 * @generated
	 */
	void unsetQuantity();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.GroupLot#getQuantity <em>Quantity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quantity</em>' attribute is set.
	 * @see #unsetQuantity()
	 * @see #getQuantity()
	 * @see #setQuantity(float)
	 * @generated
	 */
	boolean isSetQuantity();

	/**
	 * Returns the value of the '<em><b>Sex</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.Sex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex</em>' attribute.
	 * @see org.usaha.ecvi.Sex
	 * @see #isSetSex()
	 * @see #unsetSex()
	 * @see #setSex(Sex)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Sex()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Sex'"
	 * @generated
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex</em>' attribute.
	 * @see org.usaha.ecvi.Sex
	 * @see #isSetSex()
	 * @see #unsetSex()
	 * @see #getSex()
	 * @generated
	 */
	void setSex(Sex value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.GroupLot#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSex()
	 * @see #getSex()
	 * @see #setSex(Sex)
	 * @generated
	 */
	void unsetSex();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.GroupLot#getSex <em>Sex</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sex</em>' attribute is set.
	 * @see #unsetSex()
	 * @see #getSex()
	 * @see #setSex(Sex)
	 * @generated
	 */
	boolean isSetSex();

	/**
	 * Returns the value of the '<em><b>Sex Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sex Detail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sex Detail</em>' attribute.
	 * @see #setSexDetail(String)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_SexDetail()
	 * @model dataType="org.usaha.ecvi.GroupLotSexDetail"
	 *        extendedMetaData="kind='attribute' name='SexDetail'"
	 * @generated
	 */
	String getSexDetail();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getSexDetail <em>Sex Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex Detail</em>' attribute.
	 * @see #getSexDetail()
	 * @generated
	 */
	void setSexDetail(String value);

	/**
	 * Returns the value of the '<em><b>Species</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.SpeciesCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Species</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Species</em>' attribute.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see #isSetSpecies()
	 * @see #unsetSpecies()
	 * @see #setSpecies(SpeciesCode)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Species()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Species'"
	 * @generated
	 */
	SpeciesCode getSpecies();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getSpecies <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Species</em>' attribute.
	 * @see org.usaha.ecvi.SpeciesCode
	 * @see #isSetSpecies()
	 * @see #unsetSpecies()
	 * @see #getSpecies()
	 * @generated
	 */
	void setSpecies(SpeciesCode value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.GroupLot#getSpecies <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecies()
	 * @see #getSpecies()
	 * @see #setSpecies(SpeciesCode)
	 * @generated
	 */
	void unsetSpecies();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.GroupLot#getSpecies <em>Species</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Species</em>' attribute is set.
	 * @see #unsetSpecies()
	 * @see #getSpecies()
	 * @see #setSpecies(SpeciesCode)
	 * @generated
	 */
	boolean isSetSpecies();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The default value is <code>"Number"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the type of Units that the Quantity refers to. For example, it could be pounds or gallons.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #setUnit(String)
	 * @see org.usaha.ecvi.EcviPackage#getGroupLot_Unit()
	 * @model default="Number" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Unit'"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.GroupLot#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #isSetUnit()
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.GroupLot#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnit()
	 * @see #getUnit()
	 * @see #setUnit(String)
	 * @generated
	 */
	void unsetUnit();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.GroupLot#getUnit <em>Unit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit</em>' attribute is set.
	 * @see #unsetUnit()
	 * @see #getUnit()
	 * @see #setUnit(String)
	 * @generated
	 */
	boolean isSetUnit();

} // GroupLot
