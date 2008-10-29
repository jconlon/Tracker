package com.verticon.tracker.editor.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class ControlBuilderFactory {

	/**
	 * Constructor suppressed for noninstantiability
	 */
	private ControlBuilderFactory() {
		throw new AssertionError();
	}

	public static ControlBuilder getInstance(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		if (isEReference(object, itemPropertyDescriptor)) {
			EReference eReference = (EReference) itemPropertyDescriptor
					.getFeature(object);
			if (eReference.isMany()) {
				return new MultiValueEReferencControlBuilder();
			} else {
				return new SingleValueEReferenceControlBuilder();
			}
		
		//Boolean
		} else if (isSingleValueEAttributeEBoolean(object,
				itemPropertyDescriptor)) {
			return new SingleValueEAttributeEBooleanControlBuilder();
		
		//ENum
		} else if (isSingleValueEAttributeEENum(object, itemPropertyDescriptor)) {
			return new SingleValueEAttributeENumControlBuilder();
		
		//SingleValue
		} else if (isSingleValueEAttribute(object, itemPropertyDescriptor)) {
			return new SingleValueEAttributeControlBuilder();
		}	
		
		return new DefaultControlBuilder();
	}

	/**
	 * Object is an EReference ?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isEReference(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		Object genericFeature = itemPropertyDescriptor.getFeature(object);
		
		return (genericFeature instanceof EReference);
	}

	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isSingleValueEAttribute(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		
		Object genericFeature = itemPropertyDescriptor.getFeature(object);
		

		return (genericFeature instanceof EAttribute)
				&& !((EAttribute) genericFeature).isMany();

	}

	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isSingleValueEAttributeEBoolean(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		if (!isSingleValueEAttribute(object, itemPropertyDescriptor)) {
			return false;
		}
		EAttribute eAttribute = (EAttribute) itemPropertyDescriptor
				.getFeature(object);
		
		return eAttribute.getEAttributeType() == EcorePackage.Literals.EBOOLEAN;
		
	}
	
	/**
	 * Object is settable EAttribute with a single value?
	 * 
	 * @param object
	 * @param itemPropertyDescriptor
	 * @return
	 */
	private static boolean isSingleValueEAttributeEENum(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor) {

		if (!isSingleValueEAttribute(object, itemPropertyDescriptor)) {
			return false;
		}
		EAttribute eAttribute = (EAttribute) itemPropertyDescriptor
				.getFeature(object);

		return (eAttribute.getEAttributeType() instanceof EEnum);

	}
}
