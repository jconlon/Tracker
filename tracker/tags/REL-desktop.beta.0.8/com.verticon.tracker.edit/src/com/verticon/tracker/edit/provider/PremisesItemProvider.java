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
package com.verticon.tracker.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Premises} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PremisesItemProvider
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
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremisesItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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

			addPremisesIdPropertyDescriptor(object);
			addEmailContactPropertyDescriptor(object);
			addUriPropertyDescriptor(object);
			addAdministratorPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addPhoneNumberPropertyDescriptor(object);
			addAddressPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Premises Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPremisesIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_premisesId_feature"),
				 getString("_UI_Premises_premisesId_description"),
				 TrackerPackage.Literals.PREMISES__PREMISES_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Email Contact feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmailContactPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_emailContact_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_emailContact_feature", "_UI_Premises_type"),
				 TrackerPackage.Literals.PREMISES__EMAIL_CONTACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ContactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_uri_feature"),
				 getString("_UI_Premises_uri_description"),
				 TrackerPackage.Literals.PREMISES__URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Administrator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdministratorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_administrator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_administrator_feature", "_UI_Premises_type"),
				 TrackerPackage.Literals.PREMISES__ADMINISTRATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ContactsPropertyCategory"),
				 null));
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
				 getString("_UI_Premises_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_name_feature", "_UI_Premises_type"),
				 TrackerPackage.Literals.PREMISES__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_description_feature", "_UI_Premises_type"),
				 TrackerPackage.Literals.PREMISES__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Phone Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhoneNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_phoneNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_phoneNumber_feature", "_UI_Premises_type"),
				 TrackerPackage.Literals.PREMISES__PHONE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ContactsPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_address_feature"),
				 getString("_UI_Premises_address_description"),
				 TrackerPackage.Literals.PREMISES__ADDRESS,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_LocationPropertyCategory"),
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
			childrenFeatures.add(TrackerPackage.Literals.PREMISES__ANIMALS);
			childrenFeatures.add(TrackerPackage.Literals.PREMISES__UN_APPLIED_TAGS);
			childrenFeatures.add(TrackerPackage.Literals.PREMISES__POLICY);
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
	 * This returns Premises.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Premises"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Premises)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Premises_type") :
			getString("_UI_Premises_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Premises.class)) {
			case TrackerPackage.PREMISES__PREMISES_ID:
			case TrackerPackage.PREMISES__EMAIL_CONTACT:
			case TrackerPackage.PREMISES__URI:
			case TrackerPackage.PREMISES__ADMINISTRATOR:
			case TrackerPackage.PREMISES__NAME:
			case TrackerPackage.PREMISES__DESCRIPTION:
			case TrackerPackage.PREMISES__PHONE_NUMBER:
			case TrackerPackage.PREMISES__ADDRESS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TrackerPackage.PREMISES__ANIMALS:
			case TrackerPackage.PREMISES__UN_APPLIED_TAGS:
			case TrackerPackage.PREMISES__POLICY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		Premises premises = (Premises)object;
		if(premises.canContain(null,null,AnimalType.BOVINE_BEEF)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createBovineBeef()));
		}

		if(premises.canContain(null,null,AnimalType.OVINE)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createOvine()));
		}

		if(premises.canContain(null,null,AnimalType.BOVINE_BISON)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createBovineBison()));
		}

		if(premises.canContain(null,null,AnimalType.BOVINE_DAIRY)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createBovineDairy()));
		}

		if(premises.canContain(null,null,AnimalType.SWINE)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createSwine()));
		}

		if(premises.canContain(null,null,AnimalType.EQUINE)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createEquine()));
		}

		if(premises.canContain(null,null,AnimalType.CAPRINE)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__ANIMALS,
				 TrackerFactory.eINSTANCE.createCaprine()));
		}

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__UN_APPLIED_TAGS,
				 TrackerFactory.eINSTANCE.createTag()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.PREMISES__POLICY,
				 TrackerFactory.eINSTANCE.createPolicy()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TrackerReportEditPlugin.INSTANCE;
	}

}
