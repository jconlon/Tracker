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


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Event} object.
 * <!-- begin-user-doc -->
 * Adds support for Tables
 * @implements ITableItemLabelProvider
 * <!-- end-user-doc -->
 * @generated
 */
public class EventItemProvider
	extends ItemProviderAdapter
	implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	 final static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss z");
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventItemProvider(AdapterFactory adapterFactory) {
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

			addDateTimePropertyDescriptor(object);
			addEventCodePropertyDescriptor(object);
			addElectronicallyReadPropertyDescriptor(object);
			addCorrectionPropertyDescriptor(object);
			addCommentsPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addPidPropertyDescriptor(object);
			addPublisherNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Date Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_dateTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_dateTime_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__DATE_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TimeofEventPropertyCategory"),
				 null));
	}



	/**
	 * This adds a property descriptor for the Event Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_eventCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_eventCode_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__EVENT_CODE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_CodesPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Electronically Read feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElectronicallyReadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_electronicallyRead_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_electronicallyRead_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__ELECTRONICALLY_READ,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_DetailsPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Correction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCorrectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_correction_feature"),
				 getString("_UI_Event_correction_description"),
				 TrackerPackage.Literals.EVENT__CORRECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_DetailsPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
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
				 getString("_UI_Event_comments_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_comments_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__COMMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_id_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Pid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_pid_feature"),
				 getString("_UI_Event_pid_description"),
				 TrackerPackage.Literals.EVENT__PID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Publisher Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublisherNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_publisherName_feature"),
				 getString("_UI_Event_publisherName_description"),
				 TrackerPackage.Literals.EVENT__PUBLISHER_NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.property.expert"
				 }));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * This will use the name of the subclass to find a local specific label.
	 * 
		return formatter.format((Date)instanceValue);
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Date date = ((Event)object).getDateTime();
		String simpleName = object.getClass().getSimpleName();
		String resourceName = simpleName.substring(0,simpleName.indexOf("Impl"));
		return getText(date, resourceName);
	}

	/**
	 * @param date
	 * @param resourceName
	 * @return
	 */
	protected String getText(Date date, String resourceName) {
		String resourcedName;
		try {
			resourcedName = getString("_UI_"+resourceName+"_type");
		} catch (RuntimeException e) {
			resourcedName = resourceName;
		}
		if(date!=null){
			
			return df.format(date)+" "+resourcedName;
		}
		return resourcedName ;
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

		switch (notification.getFeatureID(Event.class)) {
			case TrackerPackage.EVENT__DATE_TIME:
			case TrackerPackage.EVENT__EVENT_CODE:
			case TrackerPackage.EVENT__ELECTRONICALLY_READ:
			case TrackerPackage.EVENT__CORRECTION:
			case TrackerPackage.EVENT__COMMENTS:
			case TrackerPackage.EVENT__ID:
			case TrackerPackage.EVENT__DATE:
			case TrackerPackage.EVENT__DATE_KEY:
			case TrackerPackage.EVENT__PID:
			case TrackerPackage.EVENT__PUBLISHER_NAME:
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

	/**
	 * Adds table support
	 * 
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) // 14.2.2
	{
		Event event = (Event)object;
		switch (columnIndex){
		case 0: //Date of Event
			if(event.getDateTime()!=null){
				return df.format(event.getDateTime());
			}
			return "";
			
		case 1: //Event Type
			String simpleName = event.getClass().getSimpleName();
			return simpleName.substring(0,simpleName.indexOf("Impl"));
			
		case 2: //Animal
			
			if(event.getTag()==null || event.getTag().eContainer()==null){
    			return "";
    		}
    		Animal animal = (Animal)event.getTag().eContainer();
    		
    		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(animal, IItemLabelProvider.class);
    		String numAnimal = itemLabelProvider.getText(animal);
    		
    		int space = numAnimal.indexOf(' ');
    		//Some animals may not have a name with a tag if so just use the numAnimal
    		if(space == -1){
    			return numAnimal;
    		}
    		String numPart = numAnimal.substring(0, space);
    		StringBuilder sb = new StringBuilder(
    				numAnimal.substring(space, numAnimal.length()).trim());
    				sb.append(' ');
    				sb.append(numPart);
    		return sb.toString();
    	
		case 3: //Tag ID Number
			return event.getTag()!=null?event.getTag().getId():"";

		case 4: //Comments
			return event.getComments();
		default :
			StringBuilder sb2 = new StringBuilder("unknown ");
			sb2.append(columnIndex);
			return sb2.toString();
		}
	}

	/**
	 * Adds table support
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) // 14.2.2
	  {
		switch (columnIndex){
    	case 0: return null;//return getImage(object);
    	case 1: return getImage(object);
    	case 2:
    		Event event = (Event)object;
    		if(event.getTag()==null || event.getTag().eContainer()==null){
    			return null;
    		}
    		Animal animal = (Animal)event.getTag().eContainer();
    		
    		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(animal, IItemLabelProvider.class);
    		return itemLabelProvider.getImage(animal);
    	
    	default :
    		return null;
		}
	    
	  }

}
