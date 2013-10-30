/**
 */
package org.usaha.ecvi.provider;


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
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.EcviPackage;
import org.usaha.ecvi.Premises;

/**
 * This is the item provider adapter for a {@link org.usaha.ecvi.Premises} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PremisesItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremisesItemProvider(AdapterFactory adapterFactory) {
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

			addPremIdPropertyDescriptor(object);
			addPremNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	

	/**
	 * This adds a property descriptor for the Prem Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPremIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_premId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_premId_feature", "_UI_Premises_type"),
				 EcviPackage.Literals.PREMISES__PREM_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prem Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPremNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Premises_premName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Premises_premName_feature", "_UI_Premises_type"),
				 EcviPackage.Literals.PREMISES__PREM_NAME,
				 true,
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
			childrenFeatures.add(EcviPackage.Literals.PREMISES__ADDRESS);
			childrenFeatures.add(EcviPackage.Literals.PREMISES__PROGRAM_STATUS_TYPE);
			childrenFeatures.add(EcviPackage.Literals.PREMISES__PERSON);
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
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> Give different t based on if it is a PremisesSource or a
	 * PremisesDestination <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Premises)object).getPremName();
		Premises premises = (Premises) object;
		Object container = premises.eContainer();
		String containerName = getString("_UI_Premises_type");
		if (container != null && container instanceof Ecvi) {
			Ecvi ecvi = (Ecvi) container;
			if (premises.equals(ecvi.getDestination())) {
				containerName = "Destination";
			} else if (premises.equals(ecvi.getOrigin())) {
				containerName = "Origin";
			}

		}
		return label == null || label.length() == 0 ? containerName
 : label;
	}
	
	/**
	 * Override to give different images based on if it is a PremisesSource or a
	 * PremisesDestination
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.
	 *      Object)
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		Premises premises = (Premises) object;
		Object container = premises.eContainer();
		if (container != null && container instanceof Ecvi) {
			Ecvi ecvi = (Ecvi)container;
			if(premises.equals(ecvi.getDestination())) {
				return overlayImage(object,
					getResourceLocator().getImage("full/obj16/MovedIn.gif"));
			}else 
				if(premises.equals(ecvi.getOrigin())) {
					return overlayImage(object,
						getResourceLocator().getImage("full/obj16/MovedOut.gif"));
			}
		} 
		
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/Premises.gif"));
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

		switch (notification.getFeatureID(Premises.class)) {
			case EcviPackage.PREMISES__PREM_ID:
			case EcviPackage.PREMISES__PREM_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EcviPackage.PREMISES__ADDRESS:
			case EcviPackage.PREMISES__PROGRAM_STATUS_TYPE:
			case EcviPackage.PREMISES__PERSON:
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
				(EcviPackage.Literals.PREMISES__ADDRESS,
				 EcviFactory.eINSTANCE.createAddress()));

		newChildDescriptors.add
			(createChildParameter
				(EcviPackage.Literals.PREMISES__PROGRAM_STATUS_TYPE,
				 EcviFactory.eINSTANCE.createProgramStatus()));

		newChildDescriptors.add
			(createChildParameter
				(EcviPackage.Literals.PREMISES__PERSON,
				 EcviFactory.eINSTANCE.createPerson()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EcviEditPlugin.INSTANCE;
	}

}
