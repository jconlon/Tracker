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
package com.verticon.tracker.fair.edit.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.fair.Fair} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FairItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	/**
	 * Holder for customChildren for the Fair.
	 * Ticket 240
	 */
	protected List<TransientFairItemProvider> children = null;
	
	@Override
	public Collection<?> getChildren(Object object) {
		if(children==null){
			initializeChildren(object);
		}
		return children;
	}

	/**
	 * @param object
	 */
	private void initializeChildren(Object object) {
		Fair fair = (Fair)object;
		children = new ArrayList<TransientFairItemProvider>();
		children.add(
				new YouthClubsItemProvider(adapterFactory, fair)
		);
		children.add(
				new DivisionsItemProvider(adapterFactory, fair)
		);
		children.add(
				new PeopleItemProvider(adapterFactory, fair)
		);
	}
	
	public Object getYouthClubs() {
		if(children==null){
			initializeChildren(target);
		}
		Assert.isNotNull(children, "Children can't be null. "+this);
		return children.get(0);
	}
	
	public Object getDivisions() {
		if(children==null){
			initializeChildren(target);
		}
		Assert.isNotNull(children, "Children can't be null. "+this);
		return children.get(1);
	}
	
	public Object getPeople() {
		if(children==null){
			initializeChildren(target);
		}
		Assert.isNotNull(children, "Children can't be null. "+this);
		return children.get(2);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addPremisesPropertyDescriptor(object);
			addCommentsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Fair_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Fair_name_feature", "_UI_Fair_type"),
				 FairPackage.Literals.FAIR__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Premises feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPremisesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Fair_premises_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Fair_premises_feature", "_UI_Fair_type"),
				 FairPackage.Literals.FAIR__PREMISES,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Comments feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Fair_comments_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Fair_comments_feature", "_UI_Fair_type"),
				 FairPackage.Literals.FAIR__COMMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FairPackage.Literals.FAIR__YOUTH_CLUBS);
			childrenFeatures.add(FairPackage.Literals.FAIR__DIVISIONS);
			childrenFeatures.add(FairPackage.Literals.FAIR__PEOPLE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Fair.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Fair"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Fair)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Fair_type") :
			getString("_UI_Fair_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * Modified for Ticket 240 
	 * See EMF Modeling book 14.2.3
	 * Do not need to send notifications for YouthClubs, the hand implemented 
	 * YouthClubsItemProvider does it now.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Fair.class)) {
			case FairPackage.FAIR__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
//			case FairPackage.FAIR__YOUTH_CLUBS:
//			case FairPackage.FAIR__DIVISIONS:
//			case FairPackage.FAIR__PEOPLE:
//				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
//				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * Modified for Ticket 240 
	 * See EMF Modeling book 14.2.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
//
//		newChildDescriptors.add
//			(createChildParameter
//				(FairPackage.Literals.FAIR__YOUTH_CLUBS,
//				 FairFactory.eINSTANCE.createYouthClub()));

//		newChildDescriptors.add
//			(createChildParameter
//				(FairPackage.Literals.FAIR__DIVISIONS,
//				 FairFactory.eINSTANCE.createDivision()));

//		newChildDescriptors.add
//			(createChildParameter
//				(FairPackage.Literals.FAIR__PEOPLE,
//				 FairFactory.eINSTANCE.createPerson()));

//		newChildDescriptors.add
//			(createChildParameter
//				(FairPackage.Literals.FAIR__PEOPLE,
//				 FairFactory.eINSTANCE.createYoungPerson()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FairEditPlugin.INSTANCE;
	}
	
	 public void dispose() // 14.2.3
	  {
	    super.dispose();
	    if (children != null)
	    {
	      for (Iterator<?> iter = children.iterator(); iter.hasNext(); )
	      {
	        ((IDisposable)iter.next()).dispose();
	      }
	    }
	  }

	 /**
	  * Modified for Ticket 240 
	  *  See EMF Modeling book 14.2.3
	  */
	 @SuppressWarnings("deprecation")
	 @Override
	 protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			 EReference feature, Collection<?> collection) 
	 {
		 return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner, feature);
	 }

	 /**
	  * Modified for Ticket 240 
	  * See EMF Modeling book 14.2.3
	  */
	 @SuppressWarnings("deprecation")
	 @Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			 EReference feature, Collection<?> collection, int index) 
	 {

		 return createWrappedCommand(super.createAddCommand(
				 domain, owner, feature, collection, index), owner, feature);
	 }

	 /**
	  * Modified for Ticket 240 
	  * See EMF Modeling book 14.2.3
	  * @param command
	  * @param owner
	  * @param feature
	  * @return
	  */
	 protected Command createWrappedCommand(Command command, 
			 final EObject owner, final EReference feature) {
		 if (feature == FairPackage.eINSTANCE.getFair_YouthClubs() 
				 || feature == FairPackage.eINSTANCE.getFair_Divisions()
				 || feature == FairPackage.eINSTANCE.getFair_People()){
			 return  new CommandWrapper(command){
				 public Collection<?> getAffectedObjects(){
					 Collection<?> affected = super.getAffectedObjects();
					 if (affected.contains(owner)){
						 if(feature == FairPackage.eINSTANCE.getFair_YouthClubs() ){
							 affected = Collections.singleton(getYouthClubs());
						 }else if(feature == FairPackage.eINSTANCE.getFair_Divisions()){
							 affected = Collections.singleton(getDivisions());
						 }else {
							 affected = Collections.singleton(getPeople());
						 }
					 }
					 return affected;
				 }
			 };
		 }else
			 return command;
	 }
}



