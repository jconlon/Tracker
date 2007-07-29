/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.Sex;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.Age;
import com.verticon.tracker.util.Species;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSex <em>Sex</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getAins <em>Ains</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getIdNumber <em>Id Number</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getBreed <em>Breed</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getAge <em>Age</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSexCode <em>Sex Code</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.AnimalImpl#getSpeciesCode <em>Species Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnimalImpl extends EObjectImpl implements Animal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date BIRTH_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected Date birthDate = BIRTH_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSex() <em>Sex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSex()
	 * @generated
	 * @ordered
	 */
	protected static final Sex SEX_EDEFAULT = Sex.UNSPECIFIED_LITERAL;

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
	 * The cached value of the '{@link #getAins() <em>Ains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAins()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimalId> ains;

	/**
	 * The default value of the '{@link #getSpecies() <em>Species</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecies()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIES_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getIdNumber() <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNumber()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ID_NUMBER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBreed() <em>Breed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreed()
	 * @generated
	 * @ordered
	 */
	protected static final String BREED_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final Age AGE_EDEFAULT = (Age)TrackerFactory.eINSTANCE.createFromString(TrackerPackage.eINSTANCE.getAge(), "");

	/**
	 * The default value of the '{@link #getSexCode() <em>Sex Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSexCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SEX_CODE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSpeciesCode() <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeciesCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIES_CODE_EDEFAULT = null;

	/**
	 * The parsed OCL expression for the body of the '{@link #allEvents <em>All Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allEvents
	 * @generated
	 */
	private static OCLExpression<EClassifier> allEventsBodyOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/ocl/examples/OCL";

	private static final OCL OCL_ENV = OCL.newInstance();

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
		return TrackerPackage.Literals.ANIMAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirthDate(Date newBirthDate) {
		Date oldBirthDate = birthDate;
		birthDate = newBirthDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__BIRTH_DATE, oldBirthDate, birthDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.ANIMAL__SEX, oldSex, sex, !oldSexESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, TrackerPackage.ANIMAL__SEX, oldSex, SEX_EDEFAULT, oldSexESet));
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
	public EList<AnimalId> getAins() {
		if (ains == null) {
			ains = new EObjectContainmentEList<AnimalId>(AnimalId.class, this, TrackerPackage.ANIMAL__AINS);
		}
		return ains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSpecies(){
		return getSpeciesEnum().literal();
	}
	
	/**
	 * @NOT
	 * @return
	 */
	public abstract Species getSpeciesEnum();

	/**
	 * <!-- begin-user-doc -->
	 * FIXME Replace with OCL!
	 * return ain==null||ain.getIdNumber()==null?new BigInteger("0"):new BigInteger(ain.getIdNumber());
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BigInteger getIdNumber() {
		BigInteger result = null;
		if (ains ==null || ains.isEmpty()){
			result= new BigInteger("0");
		} else if (ains.size()==1){
			result = ains.get(0).getIdNumber()==null? new BigInteger("0"): new BigInteger(ains.get(0).getIdNumber());
		} else if(ains.size()>1){
			result = new BigInteger(findAnimalIdWithLatestEventDate(ains).getIdNumber());
		} else {
			result= new BigInteger("0");
		}
		return result;
	}
	
	private AnimalId findAnimalIdWithLatestEventDate(Collection<AnimalId> list){
		List<Event> winners = new LinkedList<Event>();
		for (AnimalId animalId : list) {
			winners.addAll(animalId.getEvents());
		}
		// Sort events according to date
		Collections.sort(winners, new Comparator<Event>() {
		    public int compare(Event o1, Event o2) {
		        return o1.getDateTime().compareTo(o2.getDateTime());
		    }});
		return winners.get(0).getAnimalId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getBreed();



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Age getAge() {
		return birthDate==null?null:new Age(birthDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * FIXME Replace with OCL
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSexCode() {
		return isSetSexCode()?sex.getName():"";
	}

	/**
	 * <!-- begin-user-doc -->
	 * FIXME Replace with OCL
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetSexCode() {
		return isSetSex();
	}

	/**
	 * <!-- begin-user-doc -->
	 * FIXME Replace with OCL
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSpeciesCode() {
		return getSpeciesEnum().name();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> allEvents() {
		if (allEventsBodyOCL == null) {
			EOperation eOperation = TrackerPackage.Literals.ANIMAL.getEOperations().get(0);
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setOperationContext(TrackerPackage.Literals.ANIMAL, eOperation);
			EAnnotation ocl = eOperation.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String body = ocl.getDetails().get("body");
			
			try {
				allEventsBodyOCL = helper.createQuery(body);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(allEventsBodyOCL);
	
		@SuppressWarnings("unchecked")
		Collection<Event> result = (Collection<Event>) query.evaluate(this);
		return new BasicEList.UnmodifiableEList<Event>(result.size(), result.toArray());
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.ANIMAL__AINS:
				return ((InternalEList<?>)getAins()).basicRemove(otherEnd, msgs);
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				return getBirthDate();
			case TrackerPackage.ANIMAL__SEX:
				return getSex();
			case TrackerPackage.ANIMAL__AINS:
				return getAins();
			case TrackerPackage.ANIMAL__SPECIES:
				return getSpecies();
			case TrackerPackage.ANIMAL__ID_NUMBER:
				return getIdNumber();
			case TrackerPackage.ANIMAL__BREED:
				return getBreed();
			case TrackerPackage.ANIMAL__AGE:
				return getAge();
			case TrackerPackage.ANIMAL__SEX_CODE:
				return getSexCode();
			case TrackerPackage.ANIMAL__SPECIES_CODE:
				return getSpeciesCode();
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				setBirthDate((Date)newValue);
				return;
			case TrackerPackage.ANIMAL__SEX:
				setSex((Sex)newValue);
				return;
			case TrackerPackage.ANIMAL__AINS:
				getAins().clear();
				getAins().addAll((Collection<? extends AnimalId>)newValue);
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				setBirthDate(BIRTH_DATE_EDEFAULT);
				return;
			case TrackerPackage.ANIMAL__SEX:
				unsetSex();
				return;
			case TrackerPackage.ANIMAL__AINS:
				getAins().clear();
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
			case TrackerPackage.ANIMAL__BIRTH_DATE:
				return BIRTH_DATE_EDEFAULT == null ? birthDate != null : !BIRTH_DATE_EDEFAULT.equals(birthDate);
			case TrackerPackage.ANIMAL__SEX:
				return isSetSex();
			case TrackerPackage.ANIMAL__AINS:
				return ains != null && !ains.isEmpty();
			case TrackerPackage.ANIMAL__SPECIES:
				return SPECIES_EDEFAULT == null ? getSpecies() != null : !SPECIES_EDEFAULT.equals(getSpecies());
			case TrackerPackage.ANIMAL__ID_NUMBER:
				return ID_NUMBER_EDEFAULT == null ? getIdNumber() != null : !ID_NUMBER_EDEFAULT.equals(getIdNumber());
			case TrackerPackage.ANIMAL__BREED:
				return BREED_EDEFAULT == null ? getBreed() != null : !BREED_EDEFAULT.equals(getBreed());
			case TrackerPackage.ANIMAL__AGE:
				return AGE_EDEFAULT == null ? getAge() != null : !AGE_EDEFAULT.equals(getAge());
			case TrackerPackage.ANIMAL__SEX_CODE:
				return isSetSexCode();
			case TrackerPackage.ANIMAL__SPECIES_CODE:
				return SPECIES_CODE_EDEFAULT == null ? getSpeciesCode() != null : !SPECIES_CODE_EDEFAULT.equals(getSpeciesCode());
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
		result.append(" (birthDate: ");
		result.append(birthDate);
		result.append(", sex: ");
		if (sexESet) result.append(sex); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AnimalImpl