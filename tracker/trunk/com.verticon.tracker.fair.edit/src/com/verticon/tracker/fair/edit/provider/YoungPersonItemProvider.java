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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.YoungPerson;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.fair.YoungPerson} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class YoungPersonItemProvider
	extends PersonItemProvider
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
	public YoungPersonItemProvider(AdapterFactory adapterFactory) {
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

			addParentsPropertyDescriptor(object);
			addClubPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Parents feature.
	 * <!-- begin-user-doc -->
	 * Modified to display only Persons that are not already parents 
	 * of the YoungPerson.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addParentsPropertyDescriptor(Object object) {

		itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(
						((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						 getString("_UI_YoungPerson_parents_feature"),// displayName,
						 getString("_UI_PropertyDescriptor_description", "_UI_YoungPerson_parents_feature", "_UI_YoungPerson_type"),// description,
						 FairPackage.Literals.YOUNG_PERSON__PARENTS,// feature,
					     true,// isSettable,
					     false,// multiLine,
					     true,// sortChoices,
					     null, //staticImage,
					     getString("_UI_SponsorsPropertyCategory"),// category,
					     null){//filters


							@Override
							protected Collection<?> getComboBoxObjects(
									Object object) {
								YoungPerson yp = (YoungPerson)object;
								Collection<Object> results = new ArrayList<Object>();
								for (Object o :super.getComboBoxObjects(object)){
									if(o instanceof YoungPerson){
										//filter out youngPeople
									}else{
										//Show a Person but not if it is already a parent
										if(!yp.getParents().contains(o)){
											results.add(o);
										}
									}
								}
								
								return results;
								
							}

							}//filterFlags
		
		
		);
	}

	/**
	 * This adds a property descriptor for the Club feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClubPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_YoungPerson_club_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_YoungPerson_club_feature", "_UI_YoungPerson_type"),
				 FairPackage.Literals.YOUNG_PERSON__CLUB,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_SponsorsPropertyCategory"),
				 null));
	}

	/**
	 * This returns YoungPerson.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/YoungPerson"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((YoungPerson)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_YoungPerson_type") :
			getString("_UI_YoungPerson_type") + " " + label;
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
