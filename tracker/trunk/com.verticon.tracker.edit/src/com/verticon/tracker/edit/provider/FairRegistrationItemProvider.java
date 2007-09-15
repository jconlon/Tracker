/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.edit.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.FairRegistration;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.CommonUtilities;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.FairRegistration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FairRegistrationItemProvider
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

	@Override
	public String getColumnText(Object object, int columnIndex) // 14.2.2
	{
		FairRegistration fr = (FairRegistration)object;
		switch (columnIndex){
		
		case 0: 
			
		case 1: 

		case 2: 
		case 3: 
		case 4:
		case 5: 
		case 6: //Comments
			return super.getColumnText(object, columnIndex);
			
		//These events are for the FairRegistration Table
		case 10: //Animal Id
			return ((Animal)fr.getTag().eContainer()).getId();
			
		case 11: //Tag Id
			return fr.getTag().getId();
			
		case 12: //Date
			if(fr.getDateTime()!=null){
				return df.format(fr.getDateTime());
			}
			return null;
			
		case 13: //Participant
			return fr.getParticipant();
		
		case 14: //BeginWt
			return Integer.toString(getBeginWeight( fr));
			
		case 15: //EndWt
			return Integer.toString(getEndWeight( fr));
				
		case 16: //Parents
			return fr.getParent();
			
		case 17: //Club
			return fr.getClub();
			
		case 18: //Phone
			return fr.getPhone();
			
		case 19: //Address
			return fr.getAddress();

		case 20: //Comments
			return fr.getComments();
		
		default :
			return "unknown " + columnIndex;
		}
	}
	
	public static final int getBeginWeight(FairRegistration fr){
		List<WeighIn> weights = getSortedWeighIns( fr);
		return  weights.isEmpty()?0:weights.get(0).getWeight();
	}
	
	public static final int getEndWeight(FairRegistration fr){
		List<WeighIn> weights = getSortedWeighIns( fr);
		if(weights.isEmpty() || weights.size()<2){
			return 0;
		}
		return weights.get(weights.size()-1).getWeight();
	}
	
	/**
	 * 
	 * @param fr
	 * @return
	 */
	public static final List<WeighIn> getSortedWeighIns(FairRegistration fr){
		List<WeighIn> weights = new ArrayList<WeighIn>();
		Animal animal = (Animal)fr.getTag().eContainer();
		for (Event event : animal.allEvents()){
			if(event instanceof WeighIn ){
				weights.add((WeighIn)event);
			}
		}
		Collections.sort(weights, new Comparator<WeighIn>() {
		    public int compare(WeighIn event1, WeighIn event2) {
		        return compareDateTimes( event1,  event2);
		    }});
		return weights;
	}
	


	public static final int compareDateTimes(Event event1, Event event2) {
		Date date1 = event1.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():event1.getDateTime();
		Date date2 = event2.getDateTime()==null?CommonUtilities.DATE_REFERENCE.getTime():event2.getDateTime();
		return date1.compareTo(date2);
	}

	
	
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairRegistrationItemProvider(AdapterFactory adapterFactory) {
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

			addParticipantPropertyDescriptor(object);
			addAddressPropertyDescriptor(object);
			addPhonePropertyDescriptor(object);
			addParentPropertyDescriptor(object);
			addClubPropertyDescriptor(object);
			addSaleOrderPropertyDescriptor(object);
			addExhibitPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Participant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FairRegistration_participant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_participant_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__PARTICIPANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
				 getString("_UI_FairRegistration_address_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_address_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FairRegistration_phone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_phone_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FairRegistration_parent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_parent_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__PARENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_FairRegistration_club_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_club_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__CLUB,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sale Order feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSaleOrderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FairRegistration_SaleOrder_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_SaleOrder_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__SALE_ORDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exhibit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExhibitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FairRegistration_Exhibit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FairRegistration_Exhibit_feature", "_UI_FairRegistration_type"),
				 TrackerPackage.Literals.FAIR_REGISTRATION__EXHIBIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns FairRegistration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FairRegistration"));
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

		switch (notification.getFeatureID(FairRegistration.class)) {
			case TrackerPackage.FAIR_REGISTRATION__PARTICIPANT:
			case TrackerPackage.FAIR_REGISTRATION__ADDRESS:
			case TrackerPackage.FAIR_REGISTRATION__PHONE:
			case TrackerPackage.FAIR_REGISTRATION__PARENT:
			case TrackerPackage.FAIR_REGISTRATION__CLUB:
			case TrackerPackage.FAIR_REGISTRATION__SALE_ORDER:
			case TrackerPackage.FAIR_REGISTRATION__EXHIBIT:
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

}
