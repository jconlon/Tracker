/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink.util;

import com.verticon.atom.authorlink.AuthorlinkPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AuthorlinkXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorlinkXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		AuthorlinkPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the AuthorlinkResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new AuthorlinkResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new AuthorlinkResourceFactoryImpl());
		}
		return registrations;
	}

} //AuthorlinkXMLProcessor
