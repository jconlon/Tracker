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
import org.usaha.ecvi.Contact;
import org.usaha.ecvi.Ecvi;
import org.usaha.ecvi.EcviFactory;
import org.usaha.ecvi.EcviPackage;

/**
 * This is the item provider adapter for a {@link org.usaha.ecvi.Contact} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ContactItemProvider
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
	public ContactItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_Contact_premId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_premId_feature", "_UI_Contact_type"),
				 EcviPackage.Literals.CONTACT__PREM_ID,
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
				 getString("_UI_Contact_premName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_premName_feature", "_UI_Contact_type"),
				 EcviPackage.Literals.CONTACT__PREM_NAME,
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
			childrenFeatures.add(EcviPackage.Literals.CONTACT__ADDRESS);
			childrenFeatures.add(EcviPackage.Literals.CONTACT__PERSON);
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
		Contact contact = (Contact) object;
		Object container = contact.eContainer();
		if (container != null && container instanceof Ecvi) {
			Ecvi ecvi = (Ecvi) container;
			if (contact.equals(ecvi.getConsignee())) {
				return overlayImage(
						object,
						getResourceLocator().getImage(
								"full/obj16/Consignee.gif"));
			} else if (contact.equals(ecvi.getConsignor())) {
				return overlayImage(
						object,
						getResourceLocator().getImage(
								"full/obj16/Consignor.gif"));
			}
		}

		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/Premises.gif"));
	}


	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> Give different label based on if it is a Consignee or a Consignor
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Contact)object).getPremName();
		Contact contact = (Contact) object;
		Object container = contact.eContainer();
		String containerName = getString("_UI_Contact_type");
		if (container != null && container instanceof Ecvi) {
			Ecvi ecvi = (Ecvi) container;
			if (contact.equals(ecvi.getConsignee())) {
				containerName = "Consignee";
			} else if (contact.equals(ecvi.getConsignor())) {
				containerName = "Consignor";
			}

		}
		return label == null || label.length() == 0 ? containerName : label;

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

		switch (notification.getFeatureID(Contact.class)) {
			case EcviPackage.CONTACT__PREM_ID:
			case EcviPackage.CONTACT__PREM_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EcviPackage.CONTACT__ADDRESS:
			case EcviPackage.CONTACT__PERSON:
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
				(EcviPackage.Literals.CONTACT__ADDRESS,
				 EcviFactory.eINSTANCE.createAddress()));

		newChildDescriptors.add
			(createChildParameter
				(EcviPackage.Literals.CONTACT__PERSON,
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
