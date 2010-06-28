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


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.ReplacedTag} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReplacedTagItemProvider
	extends EventItemProvider
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
	public ReplacedTagItemProvider(AdapterFactory adapterFactory) {
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

			addOldIdPropertyDescriptor(object);
			addUsainNumberUsedForOldIdPropertyDescriptor(object);
			addOldTagPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Old Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOldIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ReplacedTag_oldId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ReplacedTag_oldId_feature", "_UI_ReplacedTag_type"),
				 TrackerPackage.Literals.REPLACED_TAG__OLD_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_OldTagPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Usain Number Used For Old Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsainNumberUsedForOldIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ReplacedTag_usainNumberUsedForOldId_feature"),
				 getString("_UI_ReplacedTag_usainNumberUsedForOldId_description"),
				 TrackerPackage.Literals.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_OldTagPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Old Tag feature.
	 * <!-- begin-user-doc -->
	 * Modified to filter out all Tags not associated with parent animal 
	 * and the parent Tag of this event as well.
	 * this event.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOldTagPropertyDescriptor(Object object) {
		
		/*
		 * createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ReplacedTag_oldTag_feature"),
				 getString("_UI_PropertyDescriptor_description", 
						 "_UI_ReplacedTag_oldTag_feature", 
						 "_UI_ReplacedTag_type"),
				 TrackerPackage.Literals.REPLACED_TAG__OLD_TAG,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
		 */
		itemPropertyDescriptors.add(
					new ItemPropertyDescriptor(
						((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),// adapterFactory,
				 getResourceLocator(),//resourceLocator
				 getString("_UI_ReplacedTag_oldTag_feature"),//displayName
				 getString("_UI_PropertyDescriptor_description", 
						 "_UI_ReplacedTag_oldTag_feature", 
						 "_UI_ReplacedTag_type"),//description
				 TrackerPackage.Literals.REPLACED_TAG__OLD_TAG,//feature
				 true,//isSettable
				 false,//multiLine
				 true,//sortChoices
				 null,//staticImage
				 null,//category
				 null)//filterFlags
					{
						protected Collection<?> getComboBoxObjects(Object object)
						  {
							ArrayList<Tag> result = new ArrayList<Tag>();
						    ReplacedTag replacedTagEvent = (ReplacedTag)object;
						    EObject tagContainer = replacedTagEvent.eContainer();
						    if(tagContainer==null ){
						    	return result;
						    }
						    
							Tag mytag = (Tag)tagContainer;
							EObject animalContainer = mytag.eContainer();
						    if(animalContainer==null || animalContainer instanceof Premises){
						    	return result;
						    }
							
						    Animal animal = (Animal)animalContainer;
						    result.addAll(animal.getTags());
						    result.remove(mytag);
						    

						    return result;
						  }
					}
					
		);
	}

	/**
	 * This returns ReplacedTag.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ReplacedTag"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * Uses superclass implemenation to return a local specific label
	 * appropriate to this subclass
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getText(Object object) {
		return super.getText(object);
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

		switch (notification.getFeatureID(ReplacedTag.class)) {
			case TrackerPackage.REPLACED_TAG__OLD_ID:
			case TrackerPackage.REPLACED_TAG__USAIN_NUMBER_USED_FOR_OLD_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
