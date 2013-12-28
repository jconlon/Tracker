/**
 */
package org.usaha.ecvi.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.usaha.ecvi.Animal;
import org.usaha.ecvi.AnimalTag;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Sex;
import org.usaha.ecvi.Test;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getAnimalTag <em>Animal Tag</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getTest <em>Test</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getAge <em>Age</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getBreed <em>Breed</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getInspectionDate <em>Inspection Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getSex <em>Sex</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AnimalImpl#getSexDetail <em>Sex Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimalImpl extends MinimalEObjectImpl.Container implements Animal {
	/**
	 * The cached value of the '{@link #getAnimalTag() <em>Animal Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimalTag()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalTag> animalTag;

	/**
	 * The cached value of the '{@link #getTest() <em>Test</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTest()
	 * @generated
	 * @ordered
	 */
	protected EList<Test> test;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final String AGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected String age = AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBreed() <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreed()
	 * @generated
	 * @ordered
	 */
	protected static final String BREED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBreed() <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreed()
	 * @generated
	 * @ordered
	 */
	protected String breed = BREED_EDEFAULT;

	/**
	 * The default value of the '{@link #getInspectionDate() <em>Inspection Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInspectionDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar INSPECTION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInspectionDate() <em>Inspection Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInspectionDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar inspectionDate = INSPECTION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSex()
	 * @generated
	 * @ordered
	 */
	protected static final Sex SEX_EDEFAULT = Sex.FEMALE;

	/**
	 * The cached value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSex()
	 * @generated
	 * @ordered
	 */
	protected Sex sex = SEX_EDEFAULT;

	/**
	 * This is true if the Sex attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sexESet;

	/**
	 * The default value of the '{@link #getSexDetail() <em>Sex Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSexDetail()
	 * @generated
	 * @ordered
	 */
	protected static final String SEX_DETAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSexDetail() <em>Sex Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSexDetail()
	 * @generated
	 * @ordered
	 */
	protected String sexDetail = SEX_DETAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.ANIMAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimalTag> getAnimalTag() {
		if (animalTag == null) {
			animalTag = new EObjectContainmentEList<AnimalTag>(AnimalTag.class, this, EcviPackage.ANIMAL__ANIMAL_TAG);
		}
		return animalTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Test> getTest() {
		if (test == null) {
			test = new EObjectContainmentEList<Test>(Test.class, this, EcviPackage.ANIMAL__TEST);
		}
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(String newAge) {
		String oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ANIMAL__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreed(String newBreed) {
		String oldBreed = breed;
		breed = newBreed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ANIMAL__BREED, oldBreed, breed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getInspectionDate() {
		return inspectionDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInspectionDate(XMLGregorianCalendar newInspectionDate) {
		XMLGregorianCalendar oldInspectionDate = inspectionDate;
		inspectionDate = newInspectionDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ANIMAL__INSPECTION_DATE, oldInspectionDate, inspectionDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSex(Sex newSex) {
		Sex oldSex = sex;
		sex = newSex == null ? SEX_EDEFAULT : newSex;
		boolean oldSexESet = sexESet;
		sexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ANIMAL__SEX, oldSex, sex, !oldSexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSex() {
		Sex oldSex = sex;
		boolean oldSexESet = sexESet;
		sex = SEX_EDEFAULT;
		sexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.ANIMAL__SEX, oldSex, SEX_EDEFAULT, oldSexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSex() {
		return sexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSexDetail() {
		return sexDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSexDetail(String newSexDetail) {
		String oldSexDetail = sexDetail;
		sexDetail = newSexDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ANIMAL__SEX_DETAIL, oldSexDetail, sexDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.ANIMAL__ANIMAL_TAG:
				return ((InternalEList<?>)getAnimalTag()).basicRemove(otherEnd, msgs);
			case EcviPackage.ANIMAL__TEST:
				return ((InternalEList<?>)getTest()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.ANIMAL__ANIMAL_TAG:
				return getAnimalTag();
			case EcviPackage.ANIMAL__TEST:
				return getTest();
			case EcviPackage.ANIMAL__AGE:
				return getAge();
			case EcviPackage.ANIMAL__BREED:
				return getBreed();
			case EcviPackage.ANIMAL__INSPECTION_DATE:
				return getInspectionDate();
			case EcviPackage.ANIMAL__SEX:
				return getSex();
			case EcviPackage.ANIMAL__SEX_DETAIL:
				return getSexDetail();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcviPackage.ANIMAL__ANIMAL_TAG:
				getAnimalTag().clear();
				getAnimalTag().addAll((Collection<? extends AnimalTag>)newValue);
				return;
			case EcviPackage.ANIMAL__TEST:
				getTest().clear();
				getTest().addAll((Collection<? extends Test>)newValue);
				return;
			case EcviPackage.ANIMAL__AGE:
				setAge((String)newValue);
				return;
			case EcviPackage.ANIMAL__BREED:
				setBreed((String)newValue);
				return;
			case EcviPackage.ANIMAL__INSPECTION_DATE:
				setInspectionDate((XMLGregorianCalendar)newValue);
				return;
			case EcviPackage.ANIMAL__SEX:
				setSex((Sex)newValue);
				return;
			case EcviPackage.ANIMAL__SEX_DETAIL:
				setSexDetail((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EcviPackage.ANIMAL__ANIMAL_TAG:
				getAnimalTag().clear();
				return;
			case EcviPackage.ANIMAL__TEST:
				getTest().clear();
				return;
			case EcviPackage.ANIMAL__AGE:
				setAge(AGE_EDEFAULT);
				return;
			case EcviPackage.ANIMAL__BREED:
				setBreed(BREED_EDEFAULT);
				return;
			case EcviPackage.ANIMAL__INSPECTION_DATE:
				setInspectionDate(INSPECTION_DATE_EDEFAULT);
				return;
			case EcviPackage.ANIMAL__SEX:
				unsetSex();
				return;
			case EcviPackage.ANIMAL__SEX_DETAIL:
				setSexDetail(SEX_DETAIL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EcviPackage.ANIMAL__ANIMAL_TAG:
				return animalTag != null && !animalTag.isEmpty();
			case EcviPackage.ANIMAL__TEST:
				return test != null && !test.isEmpty();
			case EcviPackage.ANIMAL__AGE:
				return AGE_EDEFAULT == null ? age != null : !AGE_EDEFAULT.equals(age);
			case EcviPackage.ANIMAL__BREED:
				return BREED_EDEFAULT == null ? breed != null : !BREED_EDEFAULT.equals(breed);
			case EcviPackage.ANIMAL__INSPECTION_DATE:
				return INSPECTION_DATE_EDEFAULT == null ? inspectionDate != null : !INSPECTION_DATE_EDEFAULT.equals(inspectionDate);
			case EcviPackage.ANIMAL__SEX:
				return isSetSex();
			case EcviPackage.ANIMAL__SEX_DETAIL:
				return SEX_DETAIL_EDEFAULT == null ? sexDetail != null : !SEX_DETAIL_EDEFAULT.equals(sexDetail);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (age: ");
		result.append(age);
		result.append(", breed: ");
		result.append(breed);
		result.append(", inspectionDate: ");
		result.append(inspectionDate);
		result.append(", sex: ");
		if (sexESet) result.append(sex); else result.append("<unset>");
		result.append(", sexDetail: ");
		result.append(sexDetail);
		result.append(')');
		return result.toString();
	}

} //AnimalImpl
