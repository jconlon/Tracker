/**
 * Copyright 2012 Verticon, Inc. All rights reserved.
 */
package com.verticon.tracker.store.admin.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.verticon.tracker.store.admin.Access;
import com.verticon.tracker.store.admin.Admin;
import com.verticon.tracker.store.admin.AdminPackage;
import com.verticon.tracker.store.admin.Association;
import com.verticon.tracker.store.admin.Member;
import com.verticon.tracker.store.admin.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.store.admin.impl.ResourceImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.verticon.tracker.store.admin.impl.ResourceImpl#getPublic <em>Public</em>}</li>
 *   <li>{@link com.verticon.tracker.store.admin.impl.ResourceImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link com.verticon.tracker.store.admin.impl.ResourceImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link com.verticon.tracker.store.admin.impl.ResourceImpl#getLastMod <em>Last Mod</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceImpl extends EObjectImpl implements Resource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2012 Verticon, Inc. All rights reserved.";

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
	 * The default value of the '{@link #getPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublic()
	 * @generated
	 * @ordered
	 */
	protected static final Access PUBLIC_EDEFAULT = Access.OPEN;

	/**
	 * The cached value of the '{@link #getPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublic()
	 * @generated
	 * @ordered
	 */
	protected Access public_ = PUBLIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected Member publisher;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> association;

	/**
	 * The default value of the '{@link #getLastMod() <em>Last Mod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMod()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_MOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastMod() <em>Last Mod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMod()
	 * @generated
	 * @ordered
	 */
	protected Date lastMod = LAST_MOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdminPackage.Literals.RESOURCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.RESOURCE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access getPublic() {
		return public_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublic(Access newPublic) {
		Access oldPublic = public_;
		public_ = newPublic == null ? PUBLIC_EDEFAULT : newPublic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.RESOURCE__PUBLIC, oldPublic, public_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member getPublisher() {
		if (publisher != null && publisher.eIsProxy()) {
			InternalEObject oldPublisher = (InternalEObject)publisher;
			publisher = (Member)eResolveProxy(oldPublisher);
			if (publisher != oldPublisher) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.RESOURCE__PUBLISHER, oldPublisher, publisher));
			}
		}
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member basicGetPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(Member newPublisher) {
		Member oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.RESOURCE__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociation() {
		if (association == null) {
			association = new EObjectResolvingEList<Association>(Association.class, this, AdminPackage.RESOURCE__ASSOCIATION);
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastMod() {
		return lastMod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastMod(Date newLastMod) {
		Date oldLastMod = lastMod;
		lastMod = newLastMod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.RESOURCE__LAST_MOD, oldLastMod, lastMod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canAccess(String targetUri) {
		if(getPublic().equals(Access.OPEN)){
			return true;
		}
		for (Resource resource : ((Admin)eContainer).getResource()) {
			if(resource.getUri().equals(targetUri)){
				for (Association targetAssociation : resource.getAssociation()) {
					for (Association myAssociation : getAssociation()) {
						if(targetAssociation.equals(myAssociation)){
							return true;
						}
					}
				}
				break;
			}

		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdminPackage.RESOURCE__URI:
				return getUri();
			case AdminPackage.RESOURCE__PUBLIC:
				return getPublic();
			case AdminPackage.RESOURCE__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
			case AdminPackage.RESOURCE__ASSOCIATION:
				return getAssociation();
			case AdminPackage.RESOURCE__LAST_MOD:
				return getLastMod();
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
			case AdminPackage.RESOURCE__URI:
				setUri((String)newValue);
				return;
			case AdminPackage.RESOURCE__PUBLIC:
				setPublic((Access)newValue);
				return;
			case AdminPackage.RESOURCE__PUBLISHER:
				setPublisher((Member)newValue);
				return;
			case AdminPackage.RESOURCE__ASSOCIATION:
				getAssociation().clear();
				getAssociation().addAll((Collection<? extends Association>)newValue);
				return;
			case AdminPackage.RESOURCE__LAST_MOD:
				setLastMod((Date)newValue);
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
			case AdminPackage.RESOURCE__URI:
				setUri(URI_EDEFAULT);
				return;
			case AdminPackage.RESOURCE__PUBLIC:
				setPublic(PUBLIC_EDEFAULT);
				return;
			case AdminPackage.RESOURCE__PUBLISHER:
				setPublisher((Member)null);
				return;
			case AdminPackage.RESOURCE__ASSOCIATION:
				getAssociation().clear();
				return;
			case AdminPackage.RESOURCE__LAST_MOD:
				setLastMod(LAST_MOD_EDEFAULT);
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
			case AdminPackage.RESOURCE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case AdminPackage.RESOURCE__PUBLIC:
				return public_ != PUBLIC_EDEFAULT;
			case AdminPackage.RESOURCE__PUBLISHER:
				return publisher != null;
			case AdminPackage.RESOURCE__ASSOCIATION:
				return association != null && !association.isEmpty();
			case AdminPackage.RESOURCE__LAST_MOD:
				return LAST_MOD_EDEFAULT == null ? lastMod != null : !LAST_MOD_EDEFAULT.equals(lastMod);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", public: ");
		result.append(public_);
		result.append(", lastMod: ");
		result.append(lastMod);
		result.append(')');
		return result.toString();
	}

} //ResourceImpl
