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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Location;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Schema;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.EventHistoryAdapterFactory;

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
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getLocations <em>Locations</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.PremisesImpl#getName <em>Name</em>}</li>
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

	// /**
	// * slf4j Logger
	// */
	// private final Logger logger =
	// LoggerFactory.getLogger(PremisesImpl.class);

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
	 * The cached value of the '{@link #getLocations() <em>Locations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocations()
	 * @generated
	 * @ordered
	 */
	protected EList<Location> locations;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected Schema schema;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	public EList<Location> getLocations() {
		if (locations == null) {
			locations = new EObjectContainmentEList<Location>(Location.class, this, TrackerPackage.PREMISES__LOCATIONS);
		}
		return locations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema getSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchema(Schema newSchema, NotificationChain msgs) {
		Schema oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__SCHEMA, oldSchema, newSchema);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(Schema newSchema) {
		if (newSchema != schema) {
			NotificationChain msgs = null;
			if (schema != null)
				msgs = ((InternalEObject)schema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__SCHEMA, null, msgs);
			if (newSchema != null)
				msgs = ((InternalEObject)newSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackerPackage.PREMISES__SCHEMA, null, msgs);
			msgs = basicSetSchema(newSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__SCHEMA, newSchema, newSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.PREMISES__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> Hand implemented for speed (versus OCL??) because
	 * this method is used to generate all the events for the Premises.
	 * Originally generated with the following OCL: if (animals -> notEmpty())
	 * and (animals.tags->notEmpty()) then animals.tags.events else Set{} endif
	 * 
	 * Tested with an implementation using the
	 * ItemPropertyDescriptor.getReachableObjectsOfType getEventHistory2() but
	 * this is much slower.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Event> eventHistory() {

		// long startTime = System.nanoTime();
		 EList<Event> results = getEventHistory();
		// EList<Event> results = getEventHistory2();
		// long endTime = System.nanoTime();
		// logger.debug("event history fetched in {} nanoseconds", endTime
		// - startTime);
		return results;
	}

	/**
	 * 
	 * Use the original implementation
	 * 
	 * @return eventHistory
	 * @throws IllegalStateException
	 */
	private EList<Event> getEventHistory() throws IllegalStateException {
		
		EventHistory eventHistory = (EventHistory) EventHistoryAdapterFactory.INSTANCE
				.adapt(this, EventHistory.class);
		if (eventHistory == null) {
			throw new IllegalStateException("No eventHistory for premises");
		}
		return eventHistory.eventHistory();
	}

	// private final EList<Event> eventHistory = new BasicEList<Event>();
	//
	// /**
	// * Experiment with ItemPropertyDescriptor
	// *
	// * Alternatively try
	// * ItemPropertyDescriptor.collectReachableObjectsOfType(visitedEvents,
	// * eventHistory, this, TrackerPackage.Literals.EVENT);
	// *
	// * @return eventHistory
	// */
	// @SuppressWarnings("unused")
	// private EList<Event> getEventHistory2() {
	// Collection<EObject> retrievedEventHistory = ItemPropertyDescriptor
	// .getReachableObjectsOfType(this, TrackerPackage.Literals.EVENT);
	//		
	// // Remove all events from resultEvent list that are not in the retrieved
	// // list.
	// eventHistory.retainAll(retrievedEventHistory);
	//
	// for (EObject object : retrievedEventHistory) {
	// // Filter out the (Animal)event.getTag().eContainer()
	// if (getUnAppliedTags().contains(object.eContainer())) {
	// continue;
	// } else if (!eventHistory.contains(object)) {
	// eventHistory.add((Event) object);
	// }
	// }
	//		
	// return eventHistory;
	// }
	
	/**
	 * <!-- begin-user-doc -->
	 * Finds the animal with the ain idNumber.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Animal findAnimal(String id) {
		for (Animal animal : animals) {
			if(animal.getId().equals(id)){
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
			}else if (!animalTemplate.eventHistory().isEmpty()){
				EList<Event> eventsContainer = targetAnimal.activeTag().getEvents();
				eventsContainer.addAll(copier.copyAll(animalTemplate.eventHistory()));
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
			case TrackerPackage.PREMISES__LOCATIONS:
				return ((InternalEList<?>)getLocations()).basicRemove(otherEnd, msgs);
			case TrackerPackage.PREMISES__SCHEMA:
				return basicSetSchema(null, msgs);
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
			case TrackerPackage.PREMISES__LOCATIONS:
				return getLocations();
			case TrackerPackage.PREMISES__URI:
				return getUri();
			case TrackerPackage.PREMISES__SCHEMA:
				return getSchema();
			case TrackerPackage.PREMISES__NAME:
				return getName();
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
			case TrackerPackage.PREMISES__LOCATIONS:
				getLocations().clear();
				getLocations().addAll((Collection<? extends Location>)newValue);
				return;
			case TrackerPackage.PREMISES__URI:
				setUri((String)newValue);
				return;
			case TrackerPackage.PREMISES__SCHEMA:
				setSchema((Schema)newValue);
				return;
			case TrackerPackage.PREMISES__NAME:
				setName((String)newValue);
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
			case TrackerPackage.PREMISES__LOCATIONS:
				getLocations().clear();
				return;
			case TrackerPackage.PREMISES__URI:
				setUri(URI_EDEFAULT);
				return;
			case TrackerPackage.PREMISES__SCHEMA:
				setSchema((Schema)null);
				return;
			case TrackerPackage.PREMISES__NAME:
				setName(NAME_EDEFAULT);
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
			case TrackerPackage.PREMISES__LOCATIONS:
				return locations != null && !locations.isEmpty();
			case TrackerPackage.PREMISES__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case TrackerPackage.PREMISES__SCHEMA:
				return schema != null;
			case TrackerPackage.PREMISES__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", uri: ");
		result.append(uri);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PremisesImpl