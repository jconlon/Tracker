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


import static com.verticon.tracker.edit.provider.TrackerReportEditPlugin.bundleMarker;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osgi.service.metatype.AttributeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.GenericEvent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericEventItemProvider
	extends EventItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(GenericEventItemProvider.class);


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
	public GenericEventItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	Map <String,  List<IItemPropertyDescriptor>> itemPropertyDescriptorsMap = new HashMap<String,  List<IItemPropertyDescriptor>>();
	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		OCD ocd = ((GenericEvent)object).getOcd();
		
		if (!itemPropertyDescriptorsMap.containsKey(ocd.getID())) {
			//Build new propertyDescirptors for this unique ocdId GenericEvent
			super.getPropertyDescriptors(object);

			
			List<IItemPropertyDescriptor> genericEventOCDPropDescriptors = new ArrayList<IItemPropertyDescriptor>();
			//Add a propertyDesciptor for each attribute in the OCD
			for (AttributeDefinition eventAttributeDefinition : ocd.getAttributeDefinitions(OCD.ALL)) {
				addEventAttributePropertyDescriptor(
						genericEventOCDPropDescriptors,eventAttributeDefinition, ocd.getName(),(GenericEvent)object);
			}
			
			genericEventOCDPropDescriptors.addAll(itemPropertyDescriptors);
			
			itemPropertyDescriptorsMap.put(ocd.getID(), genericEventOCDPropDescriptors);
		}
		return itemPropertyDescriptorsMap.get(ocd.getID());
	}
	
	/**
	 * This creates type specific attributes that are based on 
	 * Attribute definition
	 * @param attributeDefinition
	 * @param value
	 */
	private void addEventAttributePropertyDescriptor(
			List<IItemPropertyDescriptor> genericEventOCDPropDescriptors, 
			final AttributeDefinition attributeDefinition, final String category, GenericEvent ge){

		ge.getEventAttributes().get(0);
		IItemPropertyDescriptor valueItemPropertyDescriptor = getValuePropertyDescriptor(ge.getEventAttributes().get(0));
			
		genericEventOCDPropDescriptors.add(
				new AttributeItemPropertyDescriptor(attributeDefinition, 
						valueItemPropertyDescriptor, category)
						
		);
		
	}
	
	
	
	//Have the other class build it
	protected IItemPropertyDescriptor getValuePropertyDescriptor(Entry<String,String> map) {
		StringToStringMapItemProvider mapItemProvider = (StringToStringMapItemProvider)
			adapterFactory.adapt(map, IItemPropertySource.class);
		List<IItemPropertyDescriptor> descriptors = mapItemProvider.getPropertyDescriptors(map);
		for (IItemPropertyDescriptor descriptor : descriptors) {
			if(descriptor.getDisplayName(map).toLowerCase().equals("value")){
				return descriptor;
			}
		}
		return null;
		
			 
	}

	//Build it 
	protected IItemPropertyDescriptor getValuePropertyDescriptor(){
		return createItemPropertyDescriptor
		(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
		 getResourceLocator(),
		 getString("_UI_StringToStringMap_value_feature"),
		 getString("_UI_PropertyDescriptor_description", "_UI_StringToStringMap_value_feature", "_UI_StringToStringMap_type"),
		 TrackerPackage.Literals.STRING_TO_STRING_MAP__VALUE,//STRING_TO_STRING_MAP__VALUE,
		 true,
		 false,
		 false,
		 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
		 null,
		 null);
	}

	/**
	 * This adds a property descriptor for the Event Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericEvent_eventAttributes_feature"),
				 getString("_UI_GenericEvent_eventAttributes_description"),
				 TrackerPackage.Literals.GENERIC_EVENT__EVENT_ATTRIBUTES,
				 false,
				 true,
				 false,
				 null,
				 null,
				 null));
	}
	


	/**
	 * This adds a property descriptor for the Ocd feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOcdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericEvent_ocd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericEvent_ocd_feature", "_UI_GenericEvent_type"),
				 TrackerPackage.Literals.GENERIC_EVENT__OCD,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
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
	 * This returns GenericEvent.gif.
	 * <!-- begin-user-doc -->
	 * Load a genericEvent icon if there is one defined in the metatype
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		GenericEvent ge = (GenericEvent)object;
		if(ge.getOcd()!=null && ge.getOcd().getIcon()!=null){
			
			String spec = ge.getOcd().getIcon().getResource();
			if(spec!=null){
				try {
					URI iconURI = URI.createURI(spec);
					if(iconURI.isRelative()){
						URI resourceURI = URI.createPlatformResourceURI(
								spec, true);
						logger.debug(bundleMarker, "Icon {} isRelative Trying {}",
								spec, resourceURI);
						return overlayImage(object, new URL(resourceURI.toString()));
					}else if(iconURI.isPlatform()){
						logger.debug(bundleMarker, "Icon {} isPlatform Trying {}",
								spec, iconURI);
						return overlayImage(object, new URL(iconURI.toString()));
					}else if(iconURI.isFile()){
						File file = new File(iconURI.toFileString());
						if(file.exists()){
							logger.debug(bundleMarker, "Icon {} isFile Trying {}",
									spec, file.toURI().toURL());
							return overlayImage(object, file.toURI().toURL());
						}
					}
				} catch (Exception e) {
					logger.error(bundleMarker, "Failed to load GenericEvent icon "+spec,e);
				}
			}

		}
	
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenericEvent"));
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
		GenericEvent ge = (GenericEvent)object;
		if(ge.findName()!=null){
			return super.getText(ge.getDateTime(),ge.findName())   ;
		}
		return super.getText(object);
	}
	
	/**
	 * Return the name based on metatype
	 * @generated NOT
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		if(columnIndex == 1){
			GenericEvent ge = (GenericEvent)object;
			if(ge.findName()!=null){
				return ge.findName();
			}
		}
		return super.getColumnText(object, columnIndex);
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

		switch (notification.getFeatureID(GenericEvent.class)) {
			case TrackerPackage.GENERIC_EVENT__EVENT_ATTRIBUTES:
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
	}


}
