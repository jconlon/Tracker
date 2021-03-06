/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.edit.provider;


import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

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

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Tag} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TagItemProvider
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
	public TagItemProvider(AdapterFactory adapterFactory) {
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

			addIdNumberPropertyDescriptor(object);
			addUsainNumberUsedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Tag_idNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Tag_idNumber_feature", "_UI_Tag_type"),
				 TrackerPackage.Literals.TAG__ID_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Usain Number Used feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsainNumberUsedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Tag_usainNumberUsed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Tag_usainNumberUsed_feature", "_UI_Tag_type"),
				 TrackerPackage.Literals.TAG__USAIN_NUMBER_USED,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(TrackerPackage.Literals.TAG__EVENTS);
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
	 * This returns Tag.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Tag"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Tag tag = (Tag)object;
		return getString("_UI_Tag_type") + " " + tag.getIdNumber();
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

		switch (notification.getFeatureID(Tag.class)) {
			case TrackerPackage.TAG__ID_NUMBER:
			case TrackerPackage.TAG__USAIN_NUMBER_USED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TrackerPackage.TAG__EVENTS:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createTagAllocated()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createTagApplied()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMovedIn()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMovedOut()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createLostTag()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createReplacedTag()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createImported()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createExported()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createSighting()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createSlaughtered()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createDied()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createTagRetired()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createAnimalMissing()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createICVI()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createFairRegistration()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createWeighIn()));
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
