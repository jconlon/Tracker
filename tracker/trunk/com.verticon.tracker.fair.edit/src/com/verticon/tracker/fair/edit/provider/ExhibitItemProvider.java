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

import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.FairPackage;

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

	public Object getColumnImage(Object object, int columnIndex) {
		return null;
	}

	/**
	 * Name, Number, Exhibitor, Animal, Lot, Class, Department, Division, Comments
	 */
	public String getColumnText(Object object, int columnIndex) {
		Exhibit exhibit= (Exhibit)object;
	    switch (columnIndex){
	        case 0: return exhibit.getName(); 
	    	case 1: return Integer.toString(exhibit.getNumber()); 
	    	
	    	case 2: 
	    		return (exhibit.getExhibitor()==null || exhibit.getExhibitor().getName()==null)?
	    				null:exhibit.getExhibitor().getName();  
	    		
	    	case 3: 
	    		return (exhibit.getAnimal()==null || exhibit.getAnimal().getId()==null)?
	    				null:exhibit.getAnimal().getId();
	    	
	    	case 4: 
	    		return (exhibit.getLot()==null || exhibit.getLot().getName()==null)?
	    				null:exhibit.getLot().getName();
	    		
	    	case 5: 
	    		return exhibit.getLot().getClass_().getName();
	    	case 6: 
	    		return exhibit.getLot().getClass_().getDepartment().getName();
	    	case 7: 
	    		return exhibit.getLot().getClass_().getDepartment().getDivision().getName();
	    	case 8: 
	    		return exhibit.getComments();
	    	default :
	    		return "unknown " + columnIndex;
	    }
	}

}
