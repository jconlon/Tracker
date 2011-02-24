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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.command.CommandParameter;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.BovineDairy;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.Equine;
import com.verticon.tracker.EventType;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Ovine;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sex;
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
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TagItemProvider.class);

	private static final CommandComparator commandComparator = new CommandComparator();
	

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
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
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
		
		
		if(tag.canContain(EventType.TAG_APPLIED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createTagApplied()));
		}

		if(tag.canContain(EventType.MOVED_IN, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMovedIn()));
		}
		
		if(tag.canContain(EventType.MOVED_OUT, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMovedOut()));
		}

		if(tag.canContain(EventType.LOST_TAG, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createLostTag()));
		}

		if(tag.canContain(EventType.REPLACED_TAG, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createReplacedTag()));
		}
		if(tag.canContain(EventType.IMPORTED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createImported()));
		}
		if(tag.canContain(EventType.EXPORTED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createExported()));
		}
		
		if(tag.canContain(EventType.SIGHTING, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createSighting()));
		}

		if(tag.canContain(EventType.SLAUGHTERED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createSlaughtered()));
		}

		if(tag.canContain(EventType.DIED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createDied()));
		}

		if(tag.canContain(EventType.TAG_RETIRED, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createTagRetired()));
		}
		
		if(tag.canContain(EventType.ANIMAL_MISSING, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createAnimalMissing()));
		}

		if(tag.canContain(EventType.ICVI, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createICVI()));
		}

		if(tag.canContain(EventType.WEIGH_IN, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createWeighIn()));
		}

		if(tag.canContain(EventType.MEDICAL_CONDITION, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMedicalCondition()));
		}
		

		if(tag.canContain(EventType.MEDICAL_TREATMENT, null)){
		newChildDescriptors.add
			(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
				 TrackerFactory.eINSTANCE.createMedicalTreatment()));
		}

		if(tag.canContain(EventType.BIRTH_DEFECT, null)){
		newChildDescriptors.add
		(createChildParameter
			(TrackerPackage.Literals.TAG__EVENTS,
			 TrackerFactory.eINSTANCE.createBirthDefect()));
		}

		if(tag.canContain(EventType.MASTITIS, null)){
		newChildDescriptors.add
		(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
						TrackerFactory.eINSTANCE.createMastitis()));
		}

		if(tag.canContain(EventType.HERD_TEST, null)){
		newChildDescriptors.add
		(createChildParameter
				(TrackerPackage.Literals.TAG__EVENTS,
						TrackerFactory.eINSTANCE.createHerdTest()));
		}
		
		if(tag.canContain(EventType.POSITION, null)){
			newChildDescriptors.add
			(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
							TrackerFactory.eINSTANCE.createPosition()));
		}
		
		addGenericEventChildern(newChildDescriptors, tag);
		
		//This is what is modified
		addChildrenBasedOnAnimalSpecies(newChildDescriptors, tag);
		
		//Sort the newChildDescriptors
		if(newChildDescriptors instanceof List<?>){
			Collections.sort((List)newChildDescriptors, commandComparator);
			
		}
		
	}

	/**
	 * 
	 * Constrains to species and sex.  This will override illogical user policies.
	 * @param newChildDescriptors
	 * @param object
	 */
	private void addChildrenBasedOnAnimalSpecies(
			final Collection<Object> newChildDescriptors, final Tag tag) {
		
		if(tag==null){
			return;
		}
		
		//Create an animalVisitor to create tags based on animals
		TrackerSwitch<Object> visitor = new TrackerSwitch<Object>(){
			@Override
			public Object caseOvine(Ovine object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addBirthingEventChild(newChildDescriptors);
					addMilkTestEventChild(newChildDescriptors);
				}
				addUSOvineGradingEventChild(newChildDescriptors);
				return object;
			}

			@Override
			public Object caseCaprine(Caprine object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addBirthingEventChild(newChildDescriptors);
					addMilkTestEventChild(newChildDescriptors);
				}
				return object;
			}

			@Override
			public Object caseBovineBeef(BovineBeef object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addCalvingEventChild(newChildDescriptors);
				}
				addUSBeefGradingEventChild(newChildDescriptors);
				return object;
			}
			
			@Override
			public Object caseBovineDairy(BovineDairy object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addCalvingEventChild(newChildDescriptors);
					addMilkTestEventChild(newChildDescriptors);
				}
				addUSBeefGradingEventChild(newChildDescriptors);
				return object;
			}
			
			@Override
			public Object caseBovineBison(BovineBison object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
				addCalvingEventChild(newChildDescriptors);
//				addMilkTestEventChild(newChildDescriptors);
				}
				addUSBeefGradingEventChild(newChildDescriptors);
				return object;
			}
			
			@Override
			public Object caseSwine(Swine object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addBirthingEventChild(newChildDescriptors);
				}
				addUSSwineGradingEventChild(newChildDescriptors);
				return object;
			}
			
			@Override
			public Object caseEquine(Equine object) {
				if(object.getSex().equals(Sex.F_LITERAL)){
					addBirthingEventChild(newChildDescriptors);
				}
				return object;
			}
			
			@Override
			public Object caseAnimal(Animal object){
				if(object.getSex().equals(Sex.F_LITERAL)){
					addBirthingEventChild(newChildDescriptors);
				}
				return object;
			}

			/**
			 * @param newChildDescriptors
			 */
			private void addBirthingEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.BIRTHING, null)){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createBirthing()));
				}
			}
			
			/**
			 * @param newChildDescriptors
			 */
			private void addCalvingEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.CALVING, null)){
				newChildDescriptors.add
				(createChildParameter
						(TrackerPackage.Literals.TAG__EVENTS,
								TrackerFactory.eINSTANCE.createCalving()));
				}
			}

			/**
			 * @param newChildDescriptors
			 */
			private void addMilkTestEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.MILK_TEST, null)){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createMilkTest()));
				}
			}
			
			/**
			 * @param newChildDescriptors
			 */
			private void addUSBeefGradingEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.US_BEEF_GRADING, null)){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createUSBeefGrading()));
				}
			}
			
			/**
			 * @param newChildDescriptors
			 */
			private void addUSOvineGradingEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.US_OVINE_GRADING, null)){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createUSOvineGrading()));
				}
			}
			
			/**
			 * @param newChildDescriptors
			 */
			private void addUSSwineGradingEventChild(
					final Collection<Object> newChildDescriptors) {
				if(tag.canContain(EventType.US_SWINE_GRADING, null)){
				newChildDescriptors.add
				(createChildParameter
					(TrackerPackage.Literals.TAG__EVENTS,
					 TrackerFactory.eINSTANCE.createUSSwineGrading()));
				}
			}
		};

		//Creates ch
		visitor.doSwitch(tag.eContainer());
	}

	/**
	 * Add GenericEvent children descriptors to the newChildDescriptors.
	 * @param newChildDescriptors
	 * @param tag
	 */
	private void addGenericEventChildern(
			final Collection<Object> newChildDescriptors, Tag tag) {
		if(tag.eContainer() != null &&  tag.eContainer() instanceof Animal){
			EList<OCD> objectClassDescriptors = tag.findOCDs();
			
			for (OCD ocd : objectClassDescriptors) {
				//validate it first
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(ocd);
				if(diagnostic.getSeverity() != Diagnostic.OK){
					logger.error(bundleMarker,"Can not create genericEvent for Metatype OCD name={} because it is invalid. {}",
							ocd.getName(), 
							diagnostic.getMessage()
					);
					for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
						switch (childDiagnostic.getSeverity()) {
						case Diagnostic.ERROR:
						case Diagnostic.WARNING:	
							logger.error(bundleMarker,"Can not create genericEvent for Metatype OCD name={} because it is invalid. {}",
									ocd.getName(), 
									childDiagnostic.getMessage()
							);
						}
					}
					continue;
				}
				if(tag.canContain(EventType.GENERIC_EVENT, ocd.getID())){
					addGenericEventCommandParameter(newChildDescriptors,  ocd);
				}
				
			}
			
		}
	}
	
	
	/**
	 * 
	 * @param newChildDescriptors
	 * @param ocd
	 */
	private void addGenericEventCommandParameter(
			final Collection<Object> newChildDescriptors, OCD ocd){
		GenericEvent ge = TrackerFactory.eINSTANCE.createGenericEvent();
		ge.setOcd(ocd);
		
		newChildDescriptors.add(
				createChildParameter(
						TrackerPackage.Literals.TAG__EVENTS, //feature
						ge)//child
				);
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
	 * Change the child menu text for GenericEvent to be the name of the generic event
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		if(child instanceof GenericEvent){
			GenericEvent ge = (GenericEvent)child;
			if(ge.findName()!=null){
				return ge.findName();
			}
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}

final class CommandComparator implements Comparator<CommandParameter>{

	@Override
	public int compare(CommandParameter parm1, CommandParameter parm2) {
		String name1 = getName(parm1);
		String name2 = getName(parm2);
		
		return name1.compareTo(name2);
	}
	
	private String getName(CommandParameter parm){
		if(parm.getValue() instanceof GenericEvent){
			return ((GenericEvent)parm.getValue()).findName();
		}
			
		return parm.getValue().getClass().getSimpleName();
	}
	
}