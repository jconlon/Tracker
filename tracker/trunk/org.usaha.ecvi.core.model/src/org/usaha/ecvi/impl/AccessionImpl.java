/**
 */
package org.usaha.ecvi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.usaha.ecvi.Accession;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Laboratory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accession</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.usaha.ecvi.impl.AccessionImpl#getLaboratory <em>Laboratory</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AccessionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.usaha.ecvi.impl.AccessionImpl#isInfieldTest <em>Infield Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessionImpl extends MinimalEObjectImpl.Container implements Accession {
	/**
	 * The cached value of the '{@link #getLaboratory() <em>Laboratory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaboratory()
	 * @generated
	 * @ordered
	 */
	protected Laboratory laboratory;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isInfieldTest() <em>Infield Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInfieldTest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INFIELD_TEST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInfieldTest() <em>Infield Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInfieldTest()
	 * @generated
	 * @ordered
	 */
	protected boolean infieldTest = INFIELD_TEST_EDEFAULT;

	/**
	 * This is true if the Infield Test attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean infieldTestESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcviPackage.Literals.ACCESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Laboratory getLaboratory() {
		return laboratory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLaboratory(Laboratory newLaboratory, NotificationChain msgs) {
		Laboratory oldLaboratory = laboratory;
		laboratory = newLaboratory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcviPackage.ACCESSION__LABORATORY, oldLaboratory, newLaboratory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaboratory(Laboratory newLaboratory) {
		if (newLaboratory != laboratory) {
			NotificationChain msgs = null;
			if (laboratory != null)
				msgs = ((InternalEObject)laboratory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ACCESSION__LABORATORY, null, msgs);
			if (newLaboratory != null)
				msgs = ((InternalEObject)newLaboratory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcviPackage.ACCESSION__LABORATORY, null, msgs);
			msgs = basicSetLaboratory(newLaboratory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ACCESSION__LABORATORY, newLaboratory, newLaboratory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ACCESSION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInfieldTest() {
		return infieldTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfieldTest(boolean newInfieldTest) {
		boolean oldInfieldTest = infieldTest;
		infieldTest = newInfieldTest;
		boolean oldInfieldTestESet = infieldTestESet;
		infieldTestESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcviPackage.ACCESSION__INFIELD_TEST, oldInfieldTest, infieldTest, !oldInfieldTestESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInfieldTest() {
		boolean oldInfieldTest = infieldTest;
		boolean oldInfieldTestESet = infieldTestESet;
		infieldTest = INFIELD_TEST_EDEFAULT;
		infieldTestESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EcviPackage.ACCESSION__INFIELD_TEST, oldInfieldTest, INFIELD_TEST_EDEFAULT, oldInfieldTestESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInfieldTest() {
		return infieldTestESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcviPackage.ACCESSION__LABORATORY:
				return basicSetLaboratory(null, msgs);
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
			case EcviPackage.ACCESSION__LABORATORY:
				return getLaboratory();
			case EcviPackage.ACCESSION__ID:
				return getId();
			case EcviPackage.ACCESSION__INFIELD_TEST:
				return isInfieldTest();
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
			case EcviPackage.ACCESSION__LABORATORY:
				setLaboratory((Laboratory)newValue);
				return;
			case EcviPackage.ACCESSION__ID:
				setId((String)newValue);
				return;
			case EcviPackage.ACCESSION__INFIELD_TEST:
				setInfieldTest((Boolean)newValue);
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
			case EcviPackage.ACCESSION__LABORATORY:
				setLaboratory((Laboratory)null);
				return;
			case EcviPackage.ACCESSION__ID:
				setId(ID_EDEFAULT);
				return;
			case EcviPackage.ACCESSION__INFIELD_TEST:
				unsetInfieldTest();
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
			case EcviPackage.ACCESSION__LABORATORY:
				return laboratory != null;
			case EcviPackage.ACCESSION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EcviPackage.ACCESSION__INFIELD_TEST:
				return isSetInfieldTest();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", infieldTest: ");
		if (infieldTestESet) result.append(infieldTest); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AccessionImpl
