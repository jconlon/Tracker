/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.util.Collection;

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
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Premises</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getPremisesId <em>Premises Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getEmailContact <em>Email Contact</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getUnAppliedTags <em>Un Applied Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PremisesImpl extends EObjectImpl implements Premises {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Used for copying animalTemplates.
	 */
	private static final Copier copier = new Copier();
	
	
	/**
	 * The default value of the '{@link #getPremisesId() <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremisesId()
	 * @generated
	 * @ordered
	 */
	protected static final String PREMISES_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPremisesId() <em>Premises Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremisesId()
	 * @generated
	 * @ordered
	 */
	protected String premisesId = PREMISES_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmailContact() <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailContact()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_CONTACT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getEmailContact() <em>Email Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailContact()
	 * @generated
	 * @ordered
	 */
	protected String emailContact = EMAIL_CONTACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnimals() <em>Animals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimals()
	 * @generated
	 * @ordered
	 */
	protected EList<Animal> animals;

	/**
	 * The cached value of the '{@link #getUnAppliedTags() <em>Un Applied Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnAppliedTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> unAppliedTags;

	/**
	 * The parsed OCL expression for the body of the '{@link #eventHistory <em>Event History</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eventHistory
	 * @generated
	 */
	private static OCLExpression<EClassifier> eventHistoryBodyOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/ocl/examples/OCL";

	private static final OCL OCL_ENV = OCL.newInstance();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PremisesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.PREMISES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPremisesId() {
		return premisesId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremisesId(String newPremisesId) {
		String oldPremisesId = premisesId;
		premisesId = newPremisesId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__PREMISES_ID, oldPremisesId, premisesId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailContact() {
		return emailContact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailContact(String newEmailContact) {
		String oldEmailContact = emailContact;
		emailContact = newEmailContact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__EMAIL_CONTACT, oldEmailContact, emailContact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Animal> getAnimals() {
		if (animals == null) {
			animals = new EObjectContainmentEList<Animal>(Animal.class, this, TrackerPackage.PREMISES__ANIMALS);
		}
		return animals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getUnAppliedTags() {
		if (unAppliedTags == null) {
			unAppliedTags = new EObjectContainmentEList<Tag>(Tag.class, this, TrackerPackage.PREMISES__UN_APPLIED_TAGS);
		}
		return unAppliedTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> eventHistory() {
		if (eventHistoryBodyOCL == null) {
			EOperation eOperation = TrackerPackage.Literals.PREMISES.getEOperations().get(0);
			OCL.Helper helper = OCL_ENV.createOCLHelper();
			helper.setOperationContext(TrackerPackage.Literals.PREMISES, eOperation);
			EAnnotation ocl = eOperation.getEAnnotation(OCL_ANNOTATION_SOURCE);
			String body = ocl.getDetails().get("body");
			
			try {
				eventHistoryBodyOCL = helper.createQuery(body);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query<EClassifier, ?, ?> query = OCL_ENV.createQuery(eventHistoryBodyOCL);
	
		@SuppressWarnings("unchecked")
		Collection<Event> result = (Collection<Event>) query.evaluate(this);
		return new BasicEList.UnmodifiableEList<Event>(result.size(), result.toArray());
	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Finds the animal with the ain idNumber.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Animal findAnimal(String id) {
		for (Animal animal : animals) {
			if(animal.getId() == id){
				return animal;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Creates new Animals with events or adds templateEvents to old Animals.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addTemplate(EList<String> ains, Animal animalTemplate) {
		Animal targetAnimal = null;
		for (String animalId : ains) {
			targetAnimal = findAnimal(animalId);
			if(targetAnimal ==null){
				targetAnimal  =  (Animal) copier.copy(animalTemplate);
				targetAnimal.activeTag().setId(animalId);
				animals.add(targetAnimal);
			}else if (!animalTemplate.allEvents().isEmpty()){
				EList<Event> eventsContainer = targetAnimal.activeTag().getEvents();
				eventsContainer.addAll(copier.copyAll(animalTemplate.allEvents()));
			}
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.PREMISES__ANIMALS:
				return ((InternalEList<?>)getAnimals()).basicRemove(otherEnd, msgs);
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return ((InternalEList<?>)getUnAppliedTags()).basicRemove(otherEnd, msgs);
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
			case TrackerPackage.PREMISES__PREMISES_ID:
				return getPremisesId();
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				return getEmailContact();
			case TrackerPackage.PREMISES__ANIMALS:
				return getAnimals();
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return getUnAppliedTags();
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
			case TrackerPackage.PREMISES__PREMISES_ID:
				setPremisesId((String)newValue);
				return;
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				setEmailContact((String)newValue);
				return;
			case TrackerPackage.PREMISES__ANIMALS:
				getAnimals().clear();
				getAnimals().addAll((Collection<? extends Animal>)newValue);
				return;
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				getUnAppliedTags().clear();
				getUnAppliedTags().addAll((Collection<? extends Tag>)newValue);
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
			case TrackerPackage.PREMISES__PREMISES_ID:
				setPremisesId(PREMISES_ID_EDEFAULT);
				return;
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				setEmailContact(EMAIL_CONTACT_EDEFAULT);
				return;
			case TrackerPackage.PREMISES__ANIMALS:
				getAnimals().clear();
				return;
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				getUnAppliedTags().clear();
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
			case TrackerPackage.PREMISES__PREMISES_ID:
				return PREMISES_ID_EDEFAULT == null ? premisesId != null : !PREMISES_ID_EDEFAULT.equals(premisesId);
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
				return EMAIL_CONTACT_EDEFAULT == null ? emailContact != null : !EMAIL_CONTACT_EDEFAULT.equals(emailContact);
			case TrackerPackage.PREMISES__ANIMALS:
				return animals != null && !animals.isEmpty();
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
				return unAppliedTags != null && !unAppliedTags.isEmpty();
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
		result.append(" (premisesId: ");
		result.append(premisesId);
		result.append(", emailContact: ");
		result.append(emailContact);
		result.append(')');
		return result.toString();
	}

} //PremisesImpl