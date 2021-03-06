/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.edit.provider;


import java.text.DateFormat;
import java.util.Collection;
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
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalId;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * This is the item provider adapter for a {@link com.verticon.tracker.Animal} object.
 * <!-- begin-user-doc -->
 * Note that this class will have to be UN-Not-ed inorder to generate additional properties, 
 * but then the interface ITableItemLabelProvider, will have to be put back in to pick up the 
 * functionality.
 * TODO always un NOT this class if animal changes are made, but be sure to add the ITableItemLabelProvider and NOT it back.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class AnimalItemProvider
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
			addIdNumberPropertyDescriptor(object);
			addBreedPropertyDescriptor(object);
			addAgePropertyDescriptor(object);
			addSexCodePropertyDescriptor(object);
			addSpeciesCodePropertyDescriptor(object);
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_birthDate_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__BIRTH_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 null,
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_species_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__SPECIES,
				 false,
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
				 getString("_UI_Animal_idNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_idNumber_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__ID_NUMBER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_breed_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__BREED,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Age feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Animal_age_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_age_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__AGE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_sexCode_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__SEX_CODE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_PropertyDescriptor_description", "_UI_Animal_speciesCode_feature", "_UI_Animal_type"),
				 TrackerPackage.Literals.ANIMAL__SPECIES_CODE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
			childrenFeatures.add(TrackerPackage.Literals.ANIMAL__AIN);
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
		AnimalId labelValue = ((Animal)object).getAin();
		String label = labelValue == null ? null : labelValue.getIdNumber();
		String simpleName = object.getClass().getSimpleName();
		String resourceName = simpleName.substring(0,simpleName.indexOf("Impl"));
		return label == null || label.length() == 0 ?
			getString("_UI_"+resourceName+"_type") :
			label+" "+getString("_UI_"+resourceName+"_type");
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
			case TrackerPackage.ANIMAL__ID_NUMBER:
			case TrackerPackage.ANIMAL__BREED:
			case TrackerPackage.ANIMAL__AGE:
			case TrackerPackage.ANIMAL__SEX_CODE:
			case TrackerPackage.ANIMAL__SPECIES_CODE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TrackerPackage.ANIMAL__AIN:
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
				(TrackerPackage.Literals.ANIMAL__AIN,
				 TrackerFactory.eINSTANCE.createAnimalId()));
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
	    Animal animal = (Animal)object;
	    switch (columnIndex){
	    	case 0: return animal.getIdNumber().toString();
	    	case 1: return animal.getSpecies();
	    	case 2: return animal.getSex()==null?"unspecified":animal.getSex().toString();
	    	case 3: return animal.getBreed()==null?"unspecified":animal.getBreed();
	    	case 4: 
	    		if(animal.getBirthDate()!=null){
	    			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
//	    			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
	    			return df.format(animal.getBirthDate());
	    		}
	    		return null;
	    	case 5: 
	    		if(animal.getAge()!=null){
	    			return animal.getAge().getYears() + " years, "
					+ animal.getAge().getMonths() + " month, " + animal.getAge().getDays()
					+ " days " + animal.getAge().getStatus();
	    		}
	    		return null;
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
    	case 0: return null;
    	default :
    		return getImage(object);
		}
	    
	  }


}
