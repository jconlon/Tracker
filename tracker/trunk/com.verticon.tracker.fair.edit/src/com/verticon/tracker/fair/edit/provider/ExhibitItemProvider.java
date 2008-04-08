/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.edit.provider;


import java.util.Collection;
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
import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;
import com.verticon.tracker.fair.Person;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.fair.Exhibit} object.
 * <!-- begin-user-doc -->
 * Adds support for Tables
 * @implements ITableItemLabelProvider
 * <!-- end-user-doc -->
 * @generated
 */
public class ExhibitItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider {
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
	public ExhibitItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addNumberPropertyDescriptor(object);
			addCommentsPropertyDescriptor(object);
			addAnimalPropertyDescriptor(object);
			addExhibitorPropertyDescriptor(object);
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
				 getString("_UI_Exhibit_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Exhibit_name_feature", "_UI_Exhibit_type"),
				 FairPackage.Literals.EXHIBIT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Exhibit_number_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Exhibit_number_feature", "_UI_Exhibit_type"),
				 FairPackage.Literals.EXHIBIT__NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
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
				 getString("_UI_Exhibit_comments_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Exhibit_comments_feature", "_UI_Exhibit_type"),
				 FairPackage.Literals.EXHIBIT__COMMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Animal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnimalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Exhibit_animal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Exhibit_animal_feature", "_UI_Exhibit_type"),
				 FairPackage.Literals.EXHIBIT__ANIMAL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exhibitor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExhibitorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Exhibit_exhibitor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Exhibit_exhibitor_feature", "_UI_Exhibit_type"),
				 FairPackage.Literals.EXHIBIT__EXHIBITOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Exhibit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Exhibit"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Exhibit)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Exhibit_type") :
			getString("_UI_Exhibit_type") + " " + label;
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

		switch (notification.getFeatureID(Exhibit.class)) {
			case FairPackage.EXHIBIT__NAME:
			case FairPackage.EXHIBIT__NUMBER:
			case FairPackage.EXHIBIT__COMMENTS:
			case FairPackage.EXHIBIT__ANIMAL:
			case FairPackage.EXHIBIT__EXHIBITOR:
			case FairPackage.EXHIBIT__LOT:
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
		return FairEditPlugin.INSTANCE;
	}

	/**
	 * 
	 * Table support that uses adapters to retrieve images and labels
	 * Note that to get animal label and images animal needs to adapt to the root
	 * AdapterFactory, because animal is adapted by the TrackerItemProviderAdapterFactory 
	 * which is a sibling to the FairItemProviderAdapterFactory. So the adaptation needs
	 * to be done one level up to see the TrackerItemProviderAdapterFactory.  
	 * @generated NOT
	 */
	public Object getColumnImage(Object object, int columnIndex) {
		Exhibit exhibit= (Exhibit)object;
		IItemLabelProvider itemLabelProvider;
	    switch (columnIndex){
	        case 0: return getImage(object); 
	    	case 1: return getImage(object); 
	    	
	    	case 2: 
	    		if(exhibit.getExhibitor()==null){
	    			return null;
	    		}
	    		Person person = exhibit.getExhibitor();
	    		
	    	    itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(person, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(person);
	    		
	    		
	    	case 3: 
	    		if(exhibit.getAnimal()==null){
	    			return null;
	    		}
	    		Animal animal = exhibit.getAnimal();
	    		FairItemProviderAdapterFactory faf = (FairItemProviderAdapterFactory)adapterFactory;
	    	    itemLabelProvider = (IItemLabelProvider)faf.getRootAdapterFactory().adapt(animal, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(animal);
	    	
	    	
	    	case 4: 
	    		if(exhibit.getLot()==null){
	    			return null;
	    		}
	    		Lot lot = exhibit.getLot();
	    	    itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(lot, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(lot);
	    		
	    	case 5: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null){
	    			return null;
	    		}
	    		com.verticon.tracker.fair.Class clazz =	exhibit.getLot().getClass_();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(clazz, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(clazz);
	    
	    	case 6: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null || 
	    				exhibit.getLot().getClass_().getDepartment()==null){
	    				return null;
	    		}
	    		
	    		Department department = exhibit.getLot().getClass_().getDepartment();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(department, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(department);
	    	case 7: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null || 
	    				exhibit.getLot().getClass_().getDepartment()==null ||
	    				exhibit.getLot().getClass_().getDepartment().getDivision()==null){
	    				return null;
	    		}
	    		Division division = exhibit.getLot().getClass_().getDepartment().getDivision();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(division, IItemLabelProvider.class);
	    		return itemLabelProvider.getImage(division);
	    	case 8: 
	    		return getImage(object);
	    	default :
	    		return null;
	    }
	}

	/**
	 * Name, Number, Exhibitor, Animal, Lot, Class, Department, Division, Comments
	 */
	public String getColumnText(Object object, int columnIndex) {
		Exhibit exhibit= (Exhibit)object;
		IItemLabelProvider itemLabelProvider;
	    switch (columnIndex){
	        case 0: return getText(object); 
	    	case 1: return Integer.toString(exhibit.getNumber()); 
	    	
	    	case 2: 
	    		if(exhibit.getExhibitor()==null){
	    			return "";
	    		}
	    		Person person = exhibit.getExhibitor();
	    		
	    	    itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(person, IItemLabelProvider.class);
	    		return itemLabelProvider.getText(person);
	    		
	    		
	    	case 3: 
	    		if(exhibit.getAnimal()==null){
	    			return "";
	    		}
	    		
	    		Animal animal = exhibit.getAnimal();
	    		FairItemProviderAdapterFactory faf = (FairItemProviderAdapterFactory)adapterFactory;
	    	    itemLabelProvider = (IItemLabelProvider)faf.getRootAdapterFactory().adapt(animal, IItemLabelProvider.class);
	    	    
	    		return itemLabelProvider.getText(animal);
//	    		return animal==null?"":exhibit.getAnimal().getId();
	    	
	    	case 4: 
	    		if(exhibit.getLot()==null){
	    			return "";
	    		}
	    		Lot lot = exhibit.getLot();
	    	    itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(lot, IItemLabelProvider.class);
	    		return itemLabelProvider.getText(lot);
	    		
	    	case 5: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null){
	    			return "";
	    		}
	    		com.verticon.tracker.fair.Class clazz =	exhibit.getLot().getClass_();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(clazz, IItemLabelProvider.class);
	    		return itemLabelProvider.getText(clazz);
	    
	    	case 6: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null || 
	    				exhibit.getLot().getClass_().getDepartment()==null){
	    				return "";
	    		}
	    		
	    		Department department = exhibit.getLot().getClass_().getDepartment();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(department, IItemLabelProvider.class);
	    		return itemLabelProvider.getText(department);
	    	case 7: 
	    		if (exhibit.getLot()==null || 
	    				exhibit.getLot().getClass_()==null || 
	    				exhibit.getLot().getClass_().getDepartment()==null ||
	    				exhibit.getLot().getClass_().getDepartment().getDivision()==null){
	    				return "";
	    		}
	    		Division division = exhibit.getLot().getClass_().getDepartment().getDivision();
	    		itemLabelProvider =
	    			(IItemLabelProvider)adapterFactory.adapt(division, IItemLabelProvider.class);
	    		return itemLabelProvider.getText(division);
	    	case 8: 
	    		return exhibit.getComments();
	    	default :
	    		return "unknown " + columnIndex;
	    }
	}

}
