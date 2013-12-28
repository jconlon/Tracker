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

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.usaha.ecvi.Accessions;
import org.usaha.ecvi.Animal;
import org.usaha.ecvi.Attachement;
import org.usaha.ecvi.Contact;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.GroupLot;
import org.usaha.ecvi.MovementPurposes;
import org.usaha.ecvi.Premises;
import org.usaha.ecvi.SpeciesCode;
import org.usaha.ecvi.Veterinarian;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecvi</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getVeterinarian <em>Veterinarian</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getMovementPurposes <em>Movement Purposes</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getConsignor <em>Consignor</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getConsignee <em>Consignee</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getAccessions <em>Accessions</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getAnimal <em>Animal</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getGroup1 <em>Group1</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getGroupLot <em>Group Lot</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getAttachment <em>Attachment</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getCviNumber <em>Cvi Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getEntryPermitNumber <em>Entry Permit Number</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getExpirationDate <em>Expiration Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getShipmentDate <em>Shipment Date</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.EcviImpl#getSpeciesCode <em>Species Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EcviImpl extends MinimalEObjectImpl.Container implements Ecvi {
	/**
	 * The cached value of the '{@link #getVeterinarian() <em>Veterinarian</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVeterinarian()
	 * @generated
	 * @ordered
	 */
	protected Veterinarian veterinarian;

	/**
	 * The cached value of the '{@link #getMovementPurposes() <em>Movement Purposes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovementPurposes()
	 * @generated
	 * @ordered
	 */
	protected MovementPurposes movementPurposes;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected Premises origin;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Premises destination;

	/**
	 * The cached value of the '{@link #getConsignor() <em>Consignor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsignor()
	 * @generated
	 * @ordered
	 */
	protected Contact consignor;

	/**
	 * The cached value of the '{@link #getConsignee() <em>Consignee</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsignee()
	 * @generated
	 * @ordered
	 */
	protected Contact consignee;

	/**
	 * The cached value of the '{@link #getAccessions() <em>Accessions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessions()
	 * @generated
	 * @ordered
	 */
	protected Accessions accessions;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The cached value of the '{@link #getGroup1() <em>Group1</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup1()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group1;

	/**
	 * The cached value of the '{@link #getAttachment() <em>Attachment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachment()
	 * @generated
	 * @ordered
	 */
	protected EList<Attachement> attachment;

	/**
	 * The default value of the '{@link #getCviNumber() <em>Cvi Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCviNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String CVI_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCviNumber() <em>Cvi Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCviNumber()
	 * @generated
	 * @ordered
	 */
	protected String cviNumber = CVI_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntryPermitNumber() <em>Entry Permit Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPermitNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_PERMIT_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryPermitNumber() <em>Entry Permit Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPermitNumber()
	 * @generated
	 * @ordered
	 */
	protected String entryPermitNumber = ENTRY_PERMIT_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpirationDate() <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar EXPIRATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpirationDate() <em>Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar expirationDate = EXPIRATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar ISSUE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar issueDate = ISSUE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShipmentDate() <em>Shipment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShipmentDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar SHIPMENT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShipmentDate() <em>Shipment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShipmentDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar shipmentDate = SHIPMENT_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeciesCode() <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeciesCode()
	 * @generated
	 * @ordered
	 */
	protected static final SpeciesCode SPECIES_CODE_EDEFAULT = SpeciesCode.UNK;

	/**
	 * The cached value of the '{@link #getSpeciesCode() <em>Species Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeciesCode()
	 * @generated
	 * @ordered
	 */
	protected SpeciesCode speciesCode = SPECIES_CODE_EDEFAULT;

	/**
	 * This is true if the Species Code attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speciesCodeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcviImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.ECVI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVeterinarian(Veterinarian newVeterinarian, NotificationChain msgs) {
		Veterinarian oldVeterinarian = veterinarian;
		veterinarian = newVeterinarian;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__VETERINARIAN, oldVeterinarian, newVeterinarian);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVeterinarian(Veterinarian newVeterinarian) {
		if (newVeterinarian != veterinarian) {
			NotificationChain msgs = null;
			if (veterinarian != null)
				msgs = ((InternalEObject)veterinarian).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__VETERINARIAN, null, msgs);
			if (newVeterinarian != null)
				msgs = ((InternalEObject)newVeterinarian).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__VETERINARIAN, null, msgs);
			msgs = basicSetVeterinarian(newVeterinarian, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__VETERINARIAN, newVeterinarian, newVeterinarian));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovementPurposes getMovementPurposes() {
		return movementPurposes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMovementPurposes(MovementPurposes newMovementPurposes, NotificationChain msgs) {
		MovementPurposes oldMovementPurposes = movementPurposes;
		movementPurposes = newMovementPurposes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__MOVEMENT_PURPOSES, oldMovementPurposes, newMovementPurposes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMovementPurposes(MovementPurposes newMovementPurposes) {
		if (newMovementPurposes != movementPurposes) {
			NotificationChain msgs = null;
			if (movementPurposes != null)
				msgs = ((InternalEObject)movementPurposes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__MOVEMENT_PURPOSES, null, msgs);
			if (newMovementPurposes != null)
				msgs = ((InternalEObject)newMovementPurposes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__MOVEMENT_PURPOSES, null, msgs);
			msgs = basicSetMovementPurposes(newMovementPurposes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__MOVEMENT_PURPOSES, newMovementPurposes, newMovementPurposes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrigin(Premises newOrigin, NotificationChain msgs) {
		Premises oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ORIGIN, oldOrigin, newOrigin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(Premises newOrigin) {
		if (newOrigin != origin) {
			NotificationChain msgs = null;
			if (origin != null)
				msgs = ((InternalEObject)origin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__ORIGIN, null, msgs);
			if (newOrigin != null)
				msgs = ((InternalEObject)newOrigin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__ORIGIN, null, msgs);
			msgs = basicSetOrigin(newOrigin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ORIGIN, newOrigin, newOrigin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premises getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(Premises newDestination, NotificationChain msgs) {
		Premises oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Premises newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__DESTINATION, null, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__DESTINATION, null, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact getConsignor() {
		return consignor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsignor(Contact newConsignor, NotificationChain msgs) {
		Contact oldConsignor = consignor;
		consignor = newConsignor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__CONSIGNOR, oldConsignor, newConsignor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsignor(Contact newConsignor) {
		if (newConsignor != consignor) {
			NotificationChain msgs = null;
			if (consignor != null)
				msgs = ((InternalEObject)consignor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__CONSIGNOR, null, msgs);
			if (newConsignor != null)
				msgs = ((InternalEObject)newConsignor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__CONSIGNOR, null, msgs);
			msgs = basicSetConsignor(newConsignor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__CONSIGNOR, newConsignor, newConsignor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact getConsignee() {
		return consignee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsignee(Contact newConsignee, NotificationChain msgs) {
		Contact oldConsignee = consignee;
		consignee = newConsignee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__CONSIGNEE, oldConsignee, newConsignee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsignee(Contact newConsignee) {
		if (newConsignee != consignee) {
			NotificationChain msgs = null;
			if (consignee != null)
				msgs = ((InternalEObject)consignee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__CONSIGNEE, null, msgs);
			if (newConsignee != null)
				msgs = ((InternalEObject)newConsignee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__CONSIGNEE, null, msgs);
			msgs = basicSetConsignee(newConsignee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__CONSIGNEE, newConsignee, newConsignee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accessions getAccessions() {
		return accessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessions(Accessions newAccessions, NotificationChain msgs) {
		Accessions oldAccessions = accessions;
		accessions = newAccessions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ACCESSIONS, oldAccessions, newAccessions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessions(Accessions newAccessions) {
		if (newAccessions != accessions) {
			NotificationChain msgs = null;
			if (accessions != null)
				msgs = ((InternalEObject)accessions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__ACCESSIONS, null, msgs);
			if (newAccessions != null)
				msgs = ((InternalEObject)newAccessions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ECVI__ACCESSIONS, null, msgs);
			msgs = basicSetAccessions(newAccessions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ACCESSIONS, newAccessions, newAccessions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, EcviPackage.ECVI__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Animal> getAnimal() {
		return getGroup().list(EcviPackage.Literals.ECVI__ANIMAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup1() {
		if (group1 == null) {
			group1 = new BasicFeatureMap(this, EcviPackage.ECVI__GROUP1);
		}
		return group1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GroupLot> getGroupLot() {
		return getGroup1().list(EcviPackage.Literals.ECVI__GROUP_LOT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attachement> getAttachment() {
		if (attachment == null) {
			attachment = new EObjectContainmentEList<Attachement>(Attachement.class, this, EcviPackage.ECVI__ATTACHMENT);
		}
		return attachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCviNumber() {
		return cviNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCviNumber(String newCviNumber) {
		String oldCviNumber = cviNumber;
		cviNumber = newCviNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__CVI_NUMBER, oldCviNumber, cviNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryPermitNumber() {
		return entryPermitNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryPermitNumber(String newEntryPermitNumber) {
		String oldEntryPermitNumber = entryPermitNumber;
		entryPermitNumber = newEntryPermitNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ENTRY_PERMIT_NUMBER, oldEntryPermitNumber, entryPermitNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getExpirationDate() {
		return expirationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpirationDate(XMLGregorianCalendar newExpirationDate) {
		XMLGregorianCalendar oldExpirationDate = expirationDate;
		expirationDate = newExpirationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__EXPIRATION_DATE, oldExpirationDate, expirationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getIssueDate() {
		return issueDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssueDate(XMLGregorianCalendar newIssueDate) {
		XMLGregorianCalendar oldIssueDate = issueDate;
		issueDate = newIssueDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__ISSUE_DATE, oldIssueDate, issueDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShipmentDate(XMLGregorianCalendar newShipmentDate) {
		XMLGregorianCalendar oldShipmentDate = shipmentDate;
		shipmentDate = newShipmentDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__SHIPMENT_DATE, oldShipmentDate, shipmentDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeciesCode getSpeciesCode() {
		return speciesCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeciesCode(SpeciesCode newSpeciesCode) {
		SpeciesCode oldSpeciesCode = speciesCode;
		speciesCode = newSpeciesCode == null ? SPECIES_CODE_EDEFAULT : newSpeciesCode;
		boolean oldSpeciesCodeESet = speciesCodeESet;
		speciesCodeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ECVI__SPECIES_CODE, oldSpeciesCode, speciesCode, !oldSpeciesCodeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpeciesCode() {
		SpeciesCode oldSpeciesCode = speciesCode;
		boolean oldSpeciesCodeESet = speciesCodeESet;
		speciesCode = SPECIES_CODE_EDEFAULT;
		speciesCodeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.ECVI__SPECIES_CODE, oldSpeciesCode, SPECIES_CODE_EDEFAULT, oldSpeciesCodeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpeciesCode() {
		return speciesCodeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.ECVI__VETERINARIAN:
				return basicSetVeterinarian(null, msgs);
			case EcviPackage.ECVI__MOVEMENT_PURPOSES:
				return basicSetMovementPurposes(null, msgs);
			case EcviPackage.ECVI__ORIGIN:
				return basicSetOrigin(null, msgs);
			case EcviPackage.ECVI__DESTINATION:
				return basicSetDestination(null, msgs);
			case EcviPackage.ECVI__CONSIGNOR:
				return basicSetConsignor(null, msgs);
			case EcviPackage.ECVI__CONSIGNEE:
				return basicSetConsignee(null, msgs);
			case EcviPackage.ECVI__ACCESSIONS:
				return basicSetAccessions(null, msgs);
			case EcviPackage.ECVI__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case EcviPackage.ECVI__ANIMAL:
				return ((InternalEList<?>)getAnimal()).basicRemove(otherEnd, msgs);
			case EcviPackage.ECVI__GROUP1:
				return ((InternalEList<?>)getGroup1()).basicRemove(otherEnd, msgs);
			case EcviPackage.ECVI__GROUP_LOT:
				return ((InternalEList<?>)getGroupLot()).basicRemove(otherEnd, msgs);
			case EcviPackage.ECVI__ATTACHMENT:
				return ((InternalEList<?>)getAttachment()).basicRemove(otherEnd, msgs);
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
			case EcviPackage.ECVI__VETERINARIAN:
				return getVeterinarian();
			case EcviPackage.ECVI__MOVEMENT_PURPOSES:
				return getMovementPurposes();
			case EcviPackage.ECVI__ORIGIN:
				return getOrigin();
			case EcviPackage.ECVI__DESTINATION:
				return getDestination();
			case EcviPackage.ECVI__CONSIGNOR:
				return getConsignor();
			case EcviPackage.ECVI__CONSIGNEE:
				return getConsignee();
			case EcviPackage.ECVI__ACCESSIONS:
				return getAccessions();
			case EcviPackage.ECVI__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case EcviPackage.ECVI__ANIMAL:
				return getAnimal();
			case EcviPackage.ECVI__GROUP1:
				if (coreType) return getGroup1();
				return ((FeatureMap.Internal)getGroup1()).getWrapper();
			case EcviPackage.ECVI__GROUP_LOT:
				return getGroupLot();
			case EcviPackage.ECVI__ATTACHMENT:
				return getAttachment();
			case EcviPackage.ECVI__CVI_NUMBER:
				return getCviNumber();
			case EcviPackage.ECVI__ENTRY_PERMIT_NUMBER:
				return getEntryPermitNumber();
			case EcviPackage.ECVI__EXPIRATION_DATE:
				return getExpirationDate();
			case EcviPackage.ECVI__ISSUE_DATE:
				return getIssueDate();
			case EcviPackage.ECVI__SHIPMENT_DATE:
				return getShipmentDate();
			case EcviPackage.ECVI__SPECIES_CODE:
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
			case EcviPackage.ECVI__VETERINARIAN:
				setVeterinarian((Veterinarian)newValue);
				return;
			case EcviPackage.ECVI__MOVEMENT_PURPOSES:
				setMovementPurposes((MovementPurposes)newValue);
				return;
			case EcviPackage.ECVI__ORIGIN:
				setOrigin((Premises)newValue);
				return;
			case EcviPackage.ECVI__DESTINATION:
				setDestination((Premises)newValue);
				return;
			case EcviPackage.ECVI__CONSIGNOR:
				setConsignor((Contact)newValue);
				return;
			case EcviPackage.ECVI__CONSIGNEE:
				setConsignee((Contact)newValue);
				return;
			case EcviPackage.ECVI__ACCESSIONS:
				setAccessions((Accessions)newValue);
				return;
			case EcviPackage.ECVI__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case EcviPackage.ECVI__ANIMAL:
				getAnimal().clear();
				getAnimal().addAll((Collection<? extends Animal>)newValue);
				return;
			case EcviPackage.ECVI__GROUP1:
				((FeatureMap.Internal)getGroup1()).set(newValue);
				return;
			case EcviPackage.ECVI__GROUP_LOT:
				getGroupLot().clear();
				getGroupLot().addAll((Collection<? extends GroupLot>)newValue);
				return;
			case EcviPackage.ECVI__ATTACHMENT:
				getAttachment().clear();
				getAttachment().addAll((Collection<? extends Attachement>)newValue);
				return;
			case EcviPackage.ECVI__CVI_NUMBER:
				setCviNumber((String)newValue);
				return;
			case EcviPackage.ECVI__ENTRY_PERMIT_NUMBER:
				setEntryPermitNumber((String)newValue);
				return;
			case EcviPackage.ECVI__EXPIRATION_DATE:
				setExpirationDate((XMLGregorianCalendar)newValue);
				return;
			case EcviPackage.ECVI__ISSUE_DATE:
				setIssueDate((XMLGregorianCalendar)newValue);
				return;
			case EcviPackage.ECVI__SHIPMENT_DATE:
				setShipmentDate((XMLGregorianCalendar)newValue);
				return;
			case EcviPackage.ECVI__SPECIES_CODE:
				setSpeciesCode((SpeciesCode)newValue);
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
			case EcviPackage.ECVI__VETERINARIAN:
				setVeterinarian((Veterinarian)null);
				return;
			case EcviPackage.ECVI__MOVEMENT_PURPOSES:
				setMovementPurposes((MovementPurposes)null);
				return;
			case EcviPackage.ECVI__ORIGIN:
				setOrigin((Premises)null);
				return;
			case EcviPackage.ECVI__DESTINATION:
				setDestination((Premises)null);
				return;
			case EcviPackage.ECVI__CONSIGNOR:
				setConsignor((Contact)null);
				return;
			case EcviPackage.ECVI__CONSIGNEE:
				setConsignee((Contact)null);
				return;
			case EcviPackage.ECVI__ACCESSIONS:
				setAccessions((Accessions)null);
				return;
			case EcviPackage.ECVI__GROUP:
				getGroup().clear();
				return;
			case EcviPackage.ECVI__ANIMAL:
				getAnimal().clear();
				return;
			case EcviPackage.ECVI__GROUP1:
				getGroup1().clear();
				return;
			case EcviPackage.ECVI__GROUP_LOT:
				getGroupLot().clear();
				return;
			case EcviPackage.ECVI__ATTACHMENT:
				getAttachment().clear();
				return;
			case EcviPackage.ECVI__CVI_NUMBER:
				setCviNumber(CVI_NUMBER_EDEFAULT);
				return;
			case EcviPackage.ECVI__ENTRY_PERMIT_NUMBER:
				setEntryPermitNumber(ENTRY_PERMIT_NUMBER_EDEFAULT);
				return;
			case EcviPackage.ECVI__EXPIRATION_DATE:
				setExpirationDate(EXPIRATION_DATE_EDEFAULT);
				return;
			case EcviPackage.ECVI__ISSUE_DATE:
				setIssueDate(ISSUE_DATE_EDEFAULT);
				return;
			case EcviPackage.ECVI__SHIPMENT_DATE:
				setShipmentDate(SHIPMENT_DATE_EDEFAULT);
				return;
			case EcviPackage.ECVI__SPECIES_CODE:
				unsetSpeciesCode();
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
			case EcviPackage.ECVI__VETERINARIAN:
				return veterinarian != null;
			case EcviPackage.ECVI__MOVEMENT_PURPOSES:
				return movementPurposes != null;
			case EcviPackage.ECVI__ORIGIN:
				return origin != null;
			case EcviPackage.ECVI__DESTINATION:
				return destination != null;
			case EcviPackage.ECVI__CONSIGNOR:
				return consignor != null;
			case EcviPackage.ECVI__CONSIGNEE:
				return consignee != null;
			case EcviPackage.ECVI__ACCESSIONS:
				return accessions != null;
			case EcviPackage.ECVI__GROUP:
				return group != null && !group.isEmpty();
			case EcviPackage.ECVI__ANIMAL:
				return !getAnimal().isEmpty();
			case EcviPackage.ECVI__GROUP1:
				return group1 != null && !group1.isEmpty();
			case EcviPackage.ECVI__GROUP_LOT:
				return !getGroupLot().isEmpty();
			case EcviPackage.ECVI__ATTACHMENT:
				return attachment != null && !attachment.isEmpty();
			case EcviPackage.ECVI__CVI_NUMBER:
				return CVI_NUMBER_EDEFAULT == null ? cviNumber != null : !CVI_NUMBER_EDEFAULT.equals(cviNumber);
			case EcviPackage.ECVI__ENTRY_PERMIT_NUMBER:
				return ENTRY_PERMIT_NUMBER_EDEFAULT == null ? entryPermitNumber != null : !ENTRY_PERMIT_NUMBER_EDEFAULT.equals(entryPermitNumber);
			case EcviPackage.ECVI__EXPIRATION_DATE:
				return EXPIRATION_DATE_EDEFAULT == null ? expirationDate != null : !EXPIRATION_DATE_EDEFAULT.equals(expirationDate);
			case EcviPackage.ECVI__ISSUE_DATE:
				return ISSUE_DATE_EDEFAULT == null ? issueDate != null : !ISSUE_DATE_EDEFAULT.equals(issueDate);
			case EcviPackage.ECVI__SHIPMENT_DATE:
				return SHIPMENT_DATE_EDEFAULT == null ? shipmentDate != null : !SHIPMENT_DATE_EDEFAULT.equals(shipmentDate);
			case EcviPackage.ECVI__SPECIES_CODE:
				return isSetSpeciesCode();
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
		result.append(" (group: ");
		result.append(group);
		result.append(", group1: ");
		result.append(group1);
		result.append(", cviNumber: ");
		result.append(cviNumber);
		result.append(", entryPermitNumber: ");
		result.append(entryPermitNumber);
		result.append(", expirationDate: ");
		result.append(expirationDate);
		result.append(", issueDate: ");
		result.append(issueDate);
		result.append(", shipmentDate: ");
		result.append(shipmentDate);
		result.append(", speciesCode: ");
		if (speciesCodeESet) result.append(speciesCode); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EcviImpl
