/**
 */
package org.usaha.ecvi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.GroupLot;
import org.usaha.ecvi.Sex;
import org.usaha.ecvi.SpeciesCode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Lot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getAge <em>Age</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getBreed <em>Breed</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getSex <em>Sex</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getSexDetail <em>Sex Detail</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.GroupLotImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupLotImpl extends MinimalEObjectImpl.Container implements GroupLot {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final float QUANTITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected float quantity = QUANTITY_EDEFAULT;

	/**
	 * This is true if the Quantity attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean quantityESet;

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
	 * The default value of the '{@link #getSpecies() <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecies()
	 * @generated
	 * @ordered
	 */
	protected static final SpeciesCode SPECIES_EDEFAULT = SpeciesCode.UNK;

	/**
	 * The cached value of the '{@link #getSpecies() <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecies()
	 * @generated
	 * @ordered
	 */
	protected SpeciesCode species = SPECIES_EDEFAULT;

	/**
	 * This is true if the Species attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speciesESet;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = "Number";

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

	/**
	 * This is true if the Unit attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unitESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupLotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.GROUP_LOT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__AGE, oldAge, age));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__BREED, oldBreed, breed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(float newQuantity) {
		float oldQuantity = quantity;
		quantity = newQuantity;
		boolean oldQuantityESet = quantityESet;
		quantityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__QUANTITY, oldQuantity, quantity, !oldQuantityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQuantity() {
		float oldQuantity = quantity;
		boolean oldQuantityESet = quantityESet;
		quantity = QUANTITY_EDEFAULT;
		quantityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.GROUP_LOT__QUANTITY, oldQuantity, QUANTITY_EDEFAULT, oldQuantityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQuantity() {
		return quantityESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__SEX, oldSex, sex, !oldSexESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.GROUP_LOT__SEX, oldSex, SEX_EDEFAULT, oldSexESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__SEX_DETAIL, oldSexDetail, sexDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeciesCode getSpecies() {
		return species;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecies(SpeciesCode newSpecies) {
		SpeciesCode oldSpecies = species;
		species = newSpecies == null ? SPECIES_EDEFAULT : newSpecies;
		boolean oldSpeciesESet = speciesESet;
		speciesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__SPECIES, oldSpecies, species, !oldSpeciesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecies() {
		SpeciesCode oldSpecies = species;
		boolean oldSpeciesESet = speciesESet;
		species = SPECIES_EDEFAULT;
		speciesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.GROUP_LOT__SPECIES, oldSpecies, SPECIES_EDEFAULT, oldSpeciesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecies() {
		return speciesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		boolean oldUnitESet = unitESet;
		unitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.GROUP_LOT__UNIT, oldUnit, unit, !oldUnitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnit() {
		String oldUnit = unit;
		boolean oldUnitESet = unitESet;
		unit = UNIT_EDEFAULT;
		unitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.GROUP_LOT__UNIT, oldUnit, UNIT_EDEFAULT, oldUnitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnit() {
		return unitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcviPackage.GROUP_LOT__AGE:
				return getAge();
			case EcviPackage.GROUP_LOT__BREED:
				return getBreed();
			case EcviPackage.GROUP_LOT__DESCRIPTION:
				return getDescription();
			case EcviPackage.GROUP_LOT__QUANTITY:
				return getQuantity();
			case EcviPackage.GROUP_LOT__SEX:
				return getSex();
			case EcviPackage.GROUP_LOT__SEX_DETAIL:
				return getSexDetail();
			case EcviPackage.GROUP_LOT__SPECIES:
				return getSpecies();
			case EcviPackage.GROUP_LOT__UNIT:
				return getUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcviPackage.GROUP_LOT__AGE:
				setAge((String)newValue);
				return;
			case EcviPackage.GROUP_LOT__BREED:
				setBreed((String)newValue);
				return;
			case EcviPackage.GROUP_LOT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EcviPackage.GROUP_LOT__QUANTITY:
				setQuantity((Float)newValue);
				return;
			case EcviPackage.GROUP_LOT__SEX:
				setSex((Sex)newValue);
				return;
			case EcviPackage.GROUP_LOT__SEX_DETAIL:
				setSexDetail((String)newValue);
				return;
			case EcviPackage.GROUP_LOT__SPECIES:
				setSpecies((SpeciesCode)newValue);
				return;
			case EcviPackage.GROUP_LOT__UNIT:
				setUnit((String)newValue);
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
			case EcviPackage.GROUP_LOT__AGE:
				setAge(AGE_EDEFAULT);
				return;
			case EcviPackage.GROUP_LOT__BREED:
				setBreed(BREED_EDEFAULT);
				return;
			case EcviPackage.GROUP_LOT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EcviPackage.GROUP_LOT__QUANTITY:
				unsetQuantity();
				return;
			case EcviPackage.GROUP_LOT__SEX:
				unsetSex();
				return;
			case EcviPackage.GROUP_LOT__SEX_DETAIL:
				setSexDetail(SEX_DETAIL_EDEFAULT);
				return;
			case EcviPackage.GROUP_LOT__SPECIES:
				unsetSpecies();
				return;
			case EcviPackage.GROUP_LOT__UNIT:
				unsetUnit();
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
			case EcviPackage.GROUP_LOT__AGE:
				return AGE_EDEFAULT == null ? age != null : !AGE_EDEFAULT.equals(age);
			case EcviPackage.GROUP_LOT__BREED:
				return BREED_EDEFAULT == null ? breed != null : !BREED_EDEFAULT.equals(breed);
			case EcviPackage.GROUP_LOT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EcviPackage.GROUP_LOT__QUANTITY:
				return isSetQuantity();
			case EcviPackage.GROUP_LOT__SEX:
				return isSetSex();
			case EcviPackage.GROUP_LOT__SEX_DETAIL:
				return SEX_DETAIL_EDEFAULT == null ? sexDetail != null : !SEX_DETAIL_EDEFAULT.equals(sexDetail);
			case EcviPackage.GROUP_LOT__SPECIES:
				return isSetSpecies();
			case EcviPackage.GROUP_LOT__UNIT:
				return isSetUnit();
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
		result.append(", description: ");
		result.append(description);
		result.append(", quantity: ");
		if (quantityESet) result.append(quantity); else result.append("<unset>");
		result.append(", sex: ");
		if (sexESet) result.append(sex); else result.append("<unset>");
		result.append(", sexDetail: ");
		result.append(sexDetail);
		result.append(", species: ");
		if (speciesESet) result.append(species); else result.append("<unset>");
		result.append(", unit: ");
		if (unitESet) result.append(unit); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //GroupLotImpl
