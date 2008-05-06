/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
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
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.Equine;
import com.verticon.tracker.EventSchema;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Swine;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.TrackerSwitch;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Tag} object.
 * <!-- begin-user-doc -->
 * TagItemProvider needs to dynamically determine and present to the user
 * the children Events that can be created for a Tag.  
 * AnimalSpecific Events are a few EMF Generated Events and various Schema variants of
 * GenericEvent.
 * The collectNewChildDescriptors method is modified to dynamically create the children 
 * based on animal.
 * The getCreateChildText method is overridden to change the test of the GenericEvent in 
 * the create child dropdown.
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

			addUsainNumberUsedPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_DetailsPropertyCategory"),
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
				 getString("_UI_Tag_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Tag_id_feature", "_UI_Tag_type"),
				 TrackerPackage.Literals.TAG__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_IdentificationPropertyCategory"),
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
		String label = ((Tag)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_Tag_type") :
			getString("_UI_Tag_type") + " " + label;
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
			case TrackerPackage.TAG__USAIN_NUMBER_USED:
			case TrackerPackage.TAG__ID:
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
	 * Modified to distinguish and filter species unique events.
	 * <!-- end-user-doc -->
	 * TODO Add all new events from model to this method
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		Tag tag = (Tag)object;
		if(tag.eContainer() instanceof Premises){
			if(tag.getEvents().isEmpty()){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createTagAllocated()));
			}
			return;//an unAppliedTag only gets a single TagAllocated Event
		}
		
		

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

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMedicalCondition()));

		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMedicalTreatment()));

		
		newChildDescriptors.add
		(createChildParameter
			(TrackerPackage.Literals.TAG__EVENTS,
			 TrackerFactory.eINSTANCE.createBirthDefect()));

		newChildDescriptors.add
		(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
						TrackerFactory.eINSTANCE.createMastitis()));

		newChildDescriptors.add
		(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
						TrackerFactory.eINSTANCE.createHerdTest()));
		
		
		//This is what is modified
		addChildrenBasedOnTagAnimal(newChildDescriptors, object);
		
	}

	/**
	 * @param newChildDescriptors
	 * @param object
	 */
	private void addChildrenBasedOnTagAnimal(
			final Collection<Object> newChildDescriptors, Object object) {
		
		Tag tag = (Tag)object;
		if(tag==null){
			return;
		}
		
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>(){
			@Override
			public Object caseOvine(Ovine object) {
				addBirthingEventChild(newChildDescriptors);
				addMilkTestEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.OVINE, object.eContainer());
				return object;
			}

			@Override
			public Object caseCaprine(Caprine object) {
				addBirthingEventChild(newChildDescriptors);
				addMilkTestEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.CAPRINE, object.eContainer());
				return object;
			}

			@Override
			public Object caseBovineBeef(BovineBeef object) {
				addCalvingEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.BOVINE_BEEF, object.eContainer());
				return object;
			}
			
			@Override
			public Object caseBovineDairy(BovineDairy object) {
				addCalvingEventChild(newChildDescriptors);
				addMilkTestEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.BOVINE_DAIRY, object.eContainer());
				return object;
			}
			
			@Override
			public Object caseBovineBison(BovineBison object) {
				addCalvingEventChild(newChildDescriptors);
				addMilkTestEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.BOVINE_BISON, object.eContainer());
				return object;
			}
			
			@Override
			public Object caseSwine(Swine object) {
				addBirthingEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.SWINE, object.eContainer());
				return object;
			}
			
			@Override
			public Object caseEquine(Equine object) {
				addBirthingEventChild(newChildDescriptors);
				createAnimalSpecificGenericEvents(newChildDescriptors, AnimalType.EQUINE, object.eContainer());
				return object;
			}
			
			@Override
			public Object caseAnimal(Animal eObject){
				addBirthingEventChild(newChildDescriptors);
				return eObject;
			}

			/**
			 * @param newChildDescriptors
			 */
			private void addBirthingEventChild(
					final Collection<Object> newChildDescriptors) {
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createBirthing()));
			}
			
			/**
			 * @param newChildDescriptors
			 */
			private void addCalvingEventChild(
					final Collection<Object> newChildDescriptors) {
				newChildDescriptors.add
				(createChildParameter
						(TrackerPackage.Literals.TAG__EVENTS,
								TrackerFactory.eINSTANCE.createCalving()));
			}

			/**
			 * @param newChildDescriptors
			 */
			private void addMilkTestEventChild(
					final Collection<Object> newChildDescriptors) {
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createMilkTest()));
			}
		};

		visitor.doSwitch(tag.eContainer());
	}

	/**
	 * @param newChildDescriptors
	 */
	private void createAnimalSpecificGenericEvents(
			final Collection<Object> newChildDescriptors, AnimalType animalType, EObject animalContainer) {
		if(animalContainer != null &&  animalContainer instanceof Premises){
			EList<EventSchema> eventSchemas = findEventSchemas(animalType,  (Premises)animalContainer);
			for (EventSchema eventSchema : eventSchemas) {
				createGenericEvent(newChildDescriptors,  eventSchema);
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param newChildDescriptors
	 * @param eventSchema
	 */
	private void createGenericEvent(final Collection<Object> newChildDescriptors, EventSchema eventSchema){
		GenericEvent ge = TrackerFactory.eINSTANCE.createGenericEvent();
		ge.setEventSchema(eventSchema);

		
		newChildDescriptors.add(
				createChildParameter(
						TrackerPackage.Literals.TAG__EVENTS, //feature
						ge)//child
				);
	}
	
	
	/**
	 * 
	 * @param animalType
	 * @param premises
	 * @return all EventSchema Elements for a specified animalType
	 */
	private EList<EventSchema> findEventSchemas(AnimalType animalType, Premises premises){
		if(premises.getSchema()==null){
			return ECollections.emptyEList();
		}
		EList<EventSchema> results = new BasicEList<EventSchema>();
	    for (EventSchema eventSchema : premises.getSchema().getEventSchemas()) {
			if(eventSchema.getAnimalType().contains(animalType)){
				results.add(eventSchema);
			}
		}
		return results;
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
	 * Change the child menu text for GenericEvent to be the EventSchema name
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		if(child instanceof GenericEvent){
			GenericEvent ge = (GenericEvent)child;
			if(ge.getEventSchema()!=null && ge.getEventSchema().getName()!=null){
				return ge.getEventSchema().getName();
			}
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
