/**
 */
package org.usaha.ecvi;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Animal#getAnimalTag <em>Animal Tag</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getTest <em>Test</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getAge <em>Age</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getBreed <em>Breed</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getInspectionDate <em>Inspection Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getSex <em>Sex</em>}</li>
 *   <li>{@link org.usaha.ecvi.Animal#getSexDetail <em>Sex Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAnimal()
 * @model extendedMetaData="name='Animal_._type' kind='elementOnly'"
 * @generated
 */
public interface Animal extends EObject {
	/**
	 * Returns the value of the '<em><b>Animal Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.AnimalTag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal Tag</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_AnimalTag()
	 * @model containment="true" required="true" upper="6"
	 *        extendedMetaData="kind='element' name='AnimalTag' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AnimalTag> getAnimalTag();

	/**
	 * Returns the value of the '<em><b>Test</b></em>' containment reference list.
	 * The list contents are of type {@link org.usaha.ecvi.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' containment reference list.
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_Test()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Test' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Test> getTest();

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
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_Age()
	 * @model dataType="org.usaha.ecvi.Age"
	 *        extendedMetaData="kind='attribute' name='Age'"
	 * @generated
	 */
	String getAge();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Animal#getAge <em>Age</em>}' attribute.
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
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_Breed()
	 * @model dataType="org.usaha.ecvi.Breed"
	 *        extendedMetaData="kind='attribute' name='Breed'"
	 * @generated
	 */
	String getBreed();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Animal#getBreed <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Breed</em>' attribute.
	 * @see #getBreed()
	 * @generated
	 */
	void setBreed(String value);

	/**
	 * Returns the value of the '<em><b>Inspection Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the date on which the animals were inspected by the accrediting veterinarian. If the inspection took place over multiple days, the first day of the inspection should be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inspection Date</em>' attribute.
	 * @see #setInspectionDate(XMLGregorianCalendar)
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_InspectionDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
	 *        extendedMetaData="kind='attribute' name='InspectionDate'"
	 * @generated
	 */
	XMLGregorianCalendar getInspectionDate();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Animal#getInspectionDate <em>Inspection Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inspection Date</em>' attribute.
	 * @see #getInspectionDate()
	 * @generated
	 */
	void setInspectionDate(XMLGregorianCalendar value);

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
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_Sex()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Sex'"
	 * @generated
	 */
	Sex getSex();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Animal#getSex <em>Sex</em>}' attribute.
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
	 * Unsets the value of the '{@link org.usaha.ecvi.Animal#getSex <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSex()
	 * @see #getSex()
	 * @see #setSex(Sex)
	 * @generated
	 */
	void unsetSex();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Animal#getSex <em>Sex</em>}' attribute is set.
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
	 * @see org.usaha.ecvi.EcviPackage#getAnimal_SexDetail()
	 * @model dataType="org.usaha.ecvi.AnimalSexDetail"
	 *        extendedMetaData="kind='attribute' name='SexDetail'"
	 * @generated
	 */
	String getSexDetail();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Animal#getSexDetail <em>Sex Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sex Detail</em>' attribute.
	 * @see #getSexDetail()
	 * @generated
	 */
	void setSexDetail(String value);

} // Animal
