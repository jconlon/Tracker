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
import java.util.Iterator;
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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Sex;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Animal} object.
 * <!-- begin-user-doc -->
 * Now using a separate plugin for tables so this class no longer supports Tables via an ITableItemLabelProvider
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimalItemProvider
	extends ItemProviderAdapter
	implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
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
	public AnimalItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * Adds the AnimalId child as a property descriptor. See the 
	 * AnimalIdItemProvider.createSetCommand for additional modifications
	 * to support notifications of changes to the AnimalId model object.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBirthDatePropertyDescriptor(object);
			addSexPropertyDescriptor(object);
			addSpeciesPropertyDescriptor(object);
			addBreedPropertyDescriptor(object);
			addSexCodePropertyDescriptor(object);
			addSpeciesCodePropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addCommentsPropertyDescriptor(object);
			addLastEventDateTimePropertyDescriptor(object);
			addDamPropertyDescriptor(object);
			addSirePropertyDescriptor(object);
			addWeightPropertyDescriptor(object);
			addWeightGainPerDayPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addVisualIDPropertyDescriptor(object);
			addAgeInDaysPropertyDescriptor(object);
			addAlternativeIDPropertyDescriptor(object);
			addLocationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	

	/**
	 * This adds a property descriptor for the Birth Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBirthDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_birthDate_feature"),
				 getString("_UI_Animal_birthDate_description"),
				 TrackerPackage.Literals.ANIMAL__BIRTH_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_AgePropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Sex feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSexPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_sex_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_sex_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__SEX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_GenderPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Species feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpeciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_species_feature"),
				 getString("_UI_Animal_species_description"),
				 TrackerPackage.Literals.ANIMAL__SPECIES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_GenealogyPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Breed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBreedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_breed_feature"),
				 getString("_UI_Animal_breed_description"),
				 TrackerPackage.Literals.ANIMAL__BREED,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_CodesPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Sex Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSexCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_sexCode_feature"),
				 getString("_UI_Animal_sexCode_description"),
				 TrackerPackage.Literals.ANIMAL__SEX_CODE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_CodesPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Species Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpeciesCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_speciesCode_feature"),
				 getString("_UI_Animal_speciesCode_description"),
				 TrackerPackage.Literals.ANIMAL__SPECIES_CODE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_CodesPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
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
				 getString("_UI_Animal_id_feature"),
				 getString("_UI_Animal_id_description"),
				 TrackerPackage.Literals.ANIMAL__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_Animal_comments_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_comments_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__COMMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

/**
	 * This adds a property descriptor for the Last Event Date Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastEventDateTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_lastEventDateTime_feature"),
				 getString("_UI_Animal_lastEventDateTime_description"),
				 TrackerPackage.Literals.ANIMAL__LAST_EVENT_DATE_TIME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_EventStatisticsPropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

/**
 * 
	 * This adds a property descriptor for the Dam feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDamPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
	      (new ItemPropertyDescriptor
	        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
	         getResourceLocator(),
	         getString("_UI_Animal_dam_feature"),
			 getString("_UI_PropertyDescriptor_description", "_UI_Animal_dam_feature", "_UI_Animal_type"),
			 TrackerPackage.Literals.ANIMAL__DAM,
	         true,
	         false,
	         true,
	         null,
	         getString("_UI_GenealogyPropertyCategory"),
	         new String[] {
					"org.eclipse.ui.views.properties.expert"
				 })
	       {
	         @Override
			public Collection<?> getChoiceOfValues(Object object)
	         {
	        	 Animal animal = (Animal)object;
	          
	           // Filter out classes that aren't permitted.
	           //
	           Collection<?> result = super.getChoiceOfValues(object);
	           for (Iterator<?> i = result.iterator(); i.hasNext(); )
	           {
	        	 Animal otherAnimal = (Animal)i.next();
	             if (otherAnimal == animal){
	               i.remove();//remove self
	             }else if(otherAnimal==null){
	            	 //Ticket 270 there has to be a null so this value can be unset
	             }else if (otherAnimal.getSex()==null){
	            	 i.remove();//remove unspecified
	             }else if (!Sex.F_LITERAL.equals( otherAnimal.getSex())){
	            	 i.remove();//remove non males
	             }else if(!animal.getSpeciesCode().equals(otherAnimal.getSpeciesCode())){
	            	 i.remove();//foreign species
	             }
	           }
	           return result;
	         }
	       });
	  }

/**
	 * This adds a property descriptor for the Sire feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSirePropertyDescriptor(Object object){
	    itemPropertyDescriptors.add
	      (new ItemPropertyDescriptor
	        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
	         getResourceLocator(),
	         getString("_UI_Animal_sire_feature"),
			 getString("_UI_PropertyDescriptor_description", "_UI_Animal_sire_feature", "_UI_Animal_type"),
			 TrackerPackage.Literals.ANIMAL__SIRE,
	         true,
	         false,
	         true,
	         null,
	         getString("_UI_GenealogyPropertyCategory"),
	         new String[] {
					"org.eclipse.ui.views.properties.expert"
				 })
	       {
	         @Override
			public Collection<?> getChoiceOfValues(Object object)
	         {
	        	 Animal animal = (Animal)object;
	          
	           // Filter out classes that aren't permitted.
	           //
	           Collection<?> result = super.getChoiceOfValues(object);
	           for (Iterator<?> i = result.iterator(); i.hasNext(); )
	           {
	        	 Animal otherAnimal = (Animal)i.next();
	             if (otherAnimal == animal){//remove self
	               i.remove();
	             }else if(otherAnimal==null){
	            	//Ticket 270 there has to be a null so this value can be unset
	             }else if (otherAnimal.getSex()==null){
	            	 i.remove();//remove unspecified
	             }else if (!Sex.M_LITERAL.equals( otherAnimal.getSex())){
	            	 i.remove();//remove non males
	             }else if(!animal.getSpeciesCode().equals(otherAnimal.getSpeciesCode())){
	            	 i.remove();//foreign species
	             }
	           }
	           return result;
	         }
	       });
	  }
/**
	 * This adds a property descriptor for the Weight feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_weight_feature"),
				 getString("_UI_Animal_weight_description"),
				 TrackerPackage.Literals.ANIMAL__WEIGHT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_WeightPropertyCategory"),
				 null));
	}

/**
	 * This adds a property descriptor for the Weight Gain Per Day feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeightGainPerDayPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_weightGainPerDay_feature"),
				 getString("_UI_Animal_weightGainPerDay_description"),
				 TrackerPackage.Literals.ANIMAL__WEIGHT_GAIN_PER_DAY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_WeightPropertyCategory"),
				 null));
	}

/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_type_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__TYPE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

/**
	 * This adds a property descriptor for the Visual ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisualIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_visualID_feature"),
				 getString("_UI_Animal_visualID_description"),
				 TrackerPackage.Literals.ANIMAL__VISUAL_ID,
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
	 * This adds a property descriptor for the Age In Days feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgeInDaysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_ageInDays_feature"),
				 getString("_UI_Animal_ageInDays_description"),
				 TrackerPackage.Literals.ANIMAL__AGE_IN_DAYS,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AgePropertyCategory"),
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

/**
	 * This adds a property descriptor for the Alternative ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlternativeIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_alternativeID_feature"),
				 getString("_UI_Animal_alternativeID_description"),
				 TrackerPackage.Literals.ANIMAL__ALTERNATIVE_ID,
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
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_location_feature"),
				 getString("_UI_Animal_location_description"),
				 TrackerPackage.Literals.ANIMAL__LOCATION,
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
			childrenFeatures.add(TrackerPackage.Literals.ANIMAL__TAGS);
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
	 * This returns Animal.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Animal"));
	}
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * This will use the name of the subclass to find a local specific label.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextGen(Object object) {
		String label = ((Animal)object).getSpecies();
		return label == null || label.length() == 0 ?
			getString("_UI_Animal_type") :
			getString("_UI_Animal_type") + " " + label;
	}
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * This will use the name of the subclass to find a local specific label.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Animal)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_"+getResourceName(object)+"_type") :
			label+" "+getString("_UI_"+getResourceName(object)+"_type");
	}

	/**
	 * @param object
	 * @return resourceName
	 */
	public static final String getResourceName(Object object) {
		String simpleName = object.getClass().getSimpleName();
		String resourceName = simpleName.substring(0,simpleName.indexOf("Impl"));
		return resourceName;
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

		switch (notification.getFeatureID(Animal.class)) {
			case TrackerPackage.ANIMAL__BIRTH_DATE:
			case TrackerPackage.ANIMAL__SEX:
			case TrackerPackage.ANIMAL__SPECIES:
			case TrackerPackage.ANIMAL__BREED:
			case TrackerPackage.ANIMAL__SEX_CODE:
			case TrackerPackage.ANIMAL__SPECIES_CODE:
			case TrackerPackage.ANIMAL__ID:
			case TrackerPackage.ANIMAL__COMMENTS:
			case TrackerPackage.ANIMAL__LAST_EVENT_DATE_TIME:
			case TrackerPackage.ANIMAL__WEIGHT:
			case TrackerPackage.ANIMAL__WEIGHT_GAIN_PER_DAY:
			case TrackerPackage.ANIMAL__TYPE:
			case TrackerPackage.ANIMAL__VISUAL_ID:
			case TrackerPackage.ANIMAL__AGE_IN_DAYS:
			case TrackerPackage.ANIMAL__ALTERNATIVE_ID:
			case TrackerPackage.ANIMAL__LOCATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TrackerPackage.ANIMAL__TAGS:
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
				(TrackerPackage.Literals.ANIMAL__TAGS,
				 TrackerFactory.eINSTANCE.createTag()));
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
