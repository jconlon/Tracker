/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.osgi.metatype.DocumentRoot;
import com.verticon.osgi.metatype.MetaData;
import com.verticon.osgi.metatype.OCD;
import com.verticon.osgi.metatype.util.MetatypeSwitch;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventType;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.TagImpl#isUsainNumberUsed <em>Usain Number Used</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.TagImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.TagImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.TagImpl#getAnimal <em>Animal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TagImpl extends MinimalEObjectImpl.Container implements Tag {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #isUsainNumberUsed() <em>Usain Number Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsainNumberUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USAIN_NUMBER_USED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUsainNumberUsed() {
		return TrackerUtils.isUsainNumberUsed(id);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentWithInverseEList.Resolving<Event>(Event.class, this, TrackerPackage.TAG__EVENTS, TrackerPackage.EVENT__TAG);
		}
		return events;
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
	 * @generated NOT
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.TAG__ID, oldId, id));
		if(this.eContainer() instanceof Animal){
			//Set the id on the animal so it knows the new one
			((Animal)this.eContainer()).setId(newId);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal getAnimal() {
		if (eContainerFeatureID() != TrackerPackage.TAG__ANIMAL) return null;
		return (Animal)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Animal basicGetAnimal() {
		if (eContainerFeatureID() != TrackerPackage.TAG__ANIMAL) return null;
		return (Animal)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnimal(Animal newAnimal, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAnimal, TrackerPackage.TAG__ANIMAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnimal(Animal newAnimal) {
		if (newAnimal != eInternalContainer() || (eContainerFeatureID() != TrackerPackage.TAG__ANIMAL && newAnimal != null)) {
			if (EcoreUtil.isAncestor(this, newAnimal))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAnimal != null)
				msgs = ((InternalEObject)newAnimal).eInverseAdd(this, TrackerPackage.ANIMAL__TAGS, Animal.class, msgs);
			msgs = basicSetAnimal(newAnimal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.TAG__ANIMAL, newAnimal, newAnimal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean canContain(EventType eventType, String ocdId) {
		if(eContainer instanceof Animal){
			return ((Animal)eContainer).canContain(eventType, ocdId);
		}else if (eContainer instanceof Premises){
			if(eventType!=EventType.TAG_APPLIED){
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCD findOCD(String ocdId) {
		for (OCD ocd : findOCDs()) {
			if(ocd.getID().equals(ocdId)){
				return ocd;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCD> findOCDs() {
		final EList<OCD> results = new BasicEList<OCD>();
		MetatypeSwitch<Boolean> ocdVisitor = new MetatypeSwitch<Boolean>(){
			@Override
			public Boolean caseOCD(OCD object) {
				results.add(object);
				return Boolean.FALSE;
			}
		
			@Override
			public Boolean caseDocumentRoot(DocumentRoot object) {
				return  Boolean.TRUE;
			}
		
					
			@Override
			public Boolean caseMetaData(MetaData object) {
				return  Boolean.TRUE;
			}
		
			@Override
			public Boolean defaultCase(EObject object) {
				return Boolean.FALSE;
			}
		};
		if(eResource()!=null && eResource().getResourceSet()!=null ){
			//Resolve all the proxies so the OCDs can be found
			EcoreUtil.resolveAll(eResource().getResourceSet());
			for(TreeIterator<?> iter = EcoreUtil.getAllContents(eResource().getResourceSet(), true); iter.hasNext();){
				Object o =  iter.next();
				if(o instanceof EObject){
					EObject eObject = (EObject)o;
					if(ocdVisitor.doSwitch(eObject) == Boolean.FALSE){
						iter.prune();
					}
				}
			}
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.TAG__EVENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvents()).basicAdd(otherEnd, msgs);
			case TrackerPackage.TAG__ANIMAL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAnimal((Animal)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.TAG__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case TrackerPackage.TAG__ANIMAL:
				return basicSetAnimal(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TrackerPackage.TAG__ANIMAL:
				return eInternalContainer().eInverseRemove(this, TrackerPackage.ANIMAL__TAGS, Animal.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.TAG__USAIN_NUMBER_USED:
				return isUsainNumberUsed();
			case TrackerPackage.TAG__EVENTS:
				return getEvents();
			case TrackerPackage.TAG__ID:
				return getId();
			case TrackerPackage.TAG__ANIMAL:
				if (resolve) return getAnimal();
				return basicGetAnimal();
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
			case TrackerPackage.TAG__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case TrackerPackage.TAG__ID:
				setId((String)newValue);
				return;
			case TrackerPackage.TAG__ANIMAL:
				setAnimal((Animal)newValue);
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
			case TrackerPackage.TAG__EVENTS:
				getEvents().clear();
				return;
			case TrackerPackage.TAG__ID:
				setId(ID_EDEFAULT);
				return;
			case TrackerPackage.TAG__ANIMAL:
				setAnimal((Animal)null);
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
			case TrackerPackage.TAG__USAIN_NUMBER_USED:
				return isUsainNumberUsed() != USAIN_NUMBER_USED_EDEFAULT;
			case TrackerPackage.TAG__EVENTS:
				return events != null && !events.isEmpty();
			case TrackerPackage.TAG__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TrackerPackage.TAG__ANIMAL:
				return basicGetAnimal() != null;
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
		result.append(')');
		return result.toString();
	}

} //TagImpl
