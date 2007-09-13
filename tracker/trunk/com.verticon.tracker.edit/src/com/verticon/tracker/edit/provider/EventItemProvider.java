/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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

import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Event} object.
 * <!-- begin-user-doc -->
 * Note that this class will have to be UN-Not-ed inorder to generate additional properties, 
 * but then the interface ITableItemLabelProvider, will have to be put back in to pick up the 
 * functionality.
 * TODO always un NOT this class if event changes are made, but be sure to add the ITableItemLabelProvider and NOT it back.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class EventItemProvider
	extends ItemProviderAdapter
	implements	
	ITableItemLabelProvider, IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
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
			addIdNumberPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
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
				 null,
				 null));
	}

//	/**
//	 * This adds a property descriptor for the Ain feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addAinPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_Event_ain_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_Event_ain_feature", "_UI_Event_type"),
//				 TrackerPackage.Literals.EVENT__AIN,
//				 true,
//				 false,
//				 true,
//				 null,
//				 null,
//				 null));
//	}

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
				 null,
				 null));
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
				 null,
				 null));
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_correction_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__CORRECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Event_idNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_idNumber_feature", "_UI_Event_type"),
				 TrackerPackage.Literals.EVENT__ID_NUMBER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
				 null,
				 null));
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
		//TODO Give user a persistence var to control output format of date in Event Label
		if(date!=null){
			DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss z");
			return df.format(date)+" "+getString("_UI_"+resourceName+"_type");
		}
		return getString("_UI_"+resourceName+"_type") ;
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
			case TrackerPackage.EVENT__ID_NUMBER:
			case TrackerPackage.EVENT__ID:
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
	public String getColumnText(Object object, int columnIndex) // 14.2.2
	  {
	    Event event = (Event)object;
	    switch (columnIndex){
	    	case 0: return getText(object);
	    	case 1: 
	    		if(event.getDateTime()!=null){
	    			DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss z");
	    			return df.format(event.getDateTime());
	    		}
	    		return null;
	    	case 2: 
	    		Tag animalId = ((Event)object).getTag();
	    		if(animalId==null) return "";
	    		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(
	    				animalId, IItemLabelProvider.class);
	    		
	    		return itemLabelProvider.getText(animalId);
	    	case 3: 
	    		String simpleName = object.getClass().getSimpleName();
	    		return simpleName.substring(0,simpleName.indexOf("Impl"));
	    	
	    	
	    	default :
	    		return "unknown " + columnIndex;
	    }
	  }

	/**
	 * Adds table support
	 */
	public Object getColumnImage(Object object, int columnIndex) // 14.2.2
	  {
		switch (columnIndex){
    	case 0: return getImage(object);
    	default :
    		return null;
		}
	    
	  }

}
