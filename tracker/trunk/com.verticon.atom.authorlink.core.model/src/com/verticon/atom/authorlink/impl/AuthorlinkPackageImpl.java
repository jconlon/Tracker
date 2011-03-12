/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink.impl;

import com.verticon.atom.authorlink.AtomRoot;
import com.verticon.atom.authorlink.Author;
import com.verticon.atom.authorlink.AuthorlinkFactory;
import com.verticon.atom.authorlink.AuthorlinkPackage;
import com.verticon.atom.authorlink.Link;

import com.verticon.atom.authorlink.util.AuthorlinkValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AuthorlinkPackageImpl extends EPackageImpl implements AuthorlinkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType atomEmailAddressEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType atomLanguageTagEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType atomMediaTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.verticon.atom.authorlink.AuthorlinkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AuthorlinkPackageImpl() {
		super(eNS_URI, AuthorlinkFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AuthorlinkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AuthorlinkPackage init() {
		if (isInited) return (AuthorlinkPackage)EPackage.Registry.INSTANCE.getEPackage(AuthorlinkPackage.eNS_URI);

		// Obtain or create and register package
		AuthorlinkPackageImpl theAuthorlinkPackage = (AuthorlinkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AuthorlinkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AuthorlinkPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAuthorlinkPackage.createPackageContents();

		// Initialize created meta-data
		theAuthorlinkPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theAuthorlinkPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return AuthorlinkValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theAuthorlinkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AuthorlinkPackage.eNS_URI, theAuthorlinkPackage);
		return theAuthorlinkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomRoot() {
		return atomRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomRoot_Mixed() {
		return (EAttribute)atomRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomRoot_XMLNSPrefixMap() {
		return (EReference)atomRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomRoot_XSISchemaLocation() {
		return (EReference)atomRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomRoot_Author() {
		return (EReference)atomRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomRoot_Email() {
		return (EAttribute)atomRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomRoot_Link() {
		return (EReference)atomRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomRoot_Name() {
		return (EAttribute)atomRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomRoot_Uri() {
		return (EAttribute)atomRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthor() {
		return authorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthor_Group() {
		return (EAttribute)authorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthor_Name() {
		return (EAttribute)authorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthor_Uri() {
		return (EAttribute)authorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthor_Email() {
		return (EAttribute)authorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Href() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Hreflang() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Length() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Rel() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Title() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Type() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAtomEmailAddress() {
		return atomEmailAddressEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAtomLanguageTag() {
		return atomLanguageTagEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAtomMediaType() {
		return atomMediaTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorlinkFactory getAuthorlinkFactory() {
		return (AuthorlinkFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		atomRootEClass = createEClass(ATOM_ROOT);
		createEAttribute(atomRootEClass, ATOM_ROOT__MIXED);
		createEReference(atomRootEClass, ATOM_ROOT__XMLNS_PREFIX_MAP);
		createEReference(atomRootEClass, ATOM_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(atomRootEClass, ATOM_ROOT__AUTHOR);
		createEAttribute(atomRootEClass, ATOM_ROOT__EMAIL);
		createEReference(atomRootEClass, ATOM_ROOT__LINK);
		createEAttribute(atomRootEClass, ATOM_ROOT__NAME);
		createEAttribute(atomRootEClass, ATOM_ROOT__URI);

		authorEClass = createEClass(AUTHOR);
		createEAttribute(authorEClass, AUTHOR__GROUP);
		createEAttribute(authorEClass, AUTHOR__NAME);
		createEAttribute(authorEClass, AUTHOR__URI);
		createEAttribute(authorEClass, AUTHOR__EMAIL);

		linkEClass = createEClass(LINK);
		createEAttribute(linkEClass, LINK__HREF);
		createEAttribute(linkEClass, LINK__HREFLANG);
		createEAttribute(linkEClass, LINK__LENGTH);
		createEAttribute(linkEClass, LINK__REL);
		createEAttribute(linkEClass, LINK__TITLE);
		createEAttribute(linkEClass, LINK__TYPE);

		// Create data types
		atomEmailAddressEDataType = createEDataType(ATOM_EMAIL_ADDRESS);
		atomLanguageTagEDataType = createEDataType(ATOM_LANGUAGE_TAG);
		atomMediaTypeEDataType = createEDataType(ATOM_MEDIA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(atomRootEClass, AtomRoot.class, "AtomRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAtomRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAtomRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAtomRoot_Author(), this.getAuthor(), null, "author", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAtomRoot_Email(), this.getAtomEmailAddress(), "email", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAtomRoot_Link(), this.getLink(), null, "link", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAtomRoot_Name(), theXMLTypePackage.getString(), "name", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAtomRoot_Uri(), theXMLTypePackage.getString(), "uri", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(authorEClass, Author.class, "Author", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAuthor_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthor_Name(), theXMLTypePackage.getString(), "name", null, 0, -1, Author.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthor_Uri(), theXMLTypePackage.getString(), "uri", null, 0, -1, Author.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthor_Email(), this.getAtomEmailAddress(), "email", null, 0, -1, Author.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLink_Href(), theXMLTypePackage.getAnySimpleType(), "href", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Hreflang(), this.getAtomLanguageTag(), "hreflang", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Length(), theXMLTypePackage.getAnySimpleType(), "length", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Rel(), theXMLTypePackage.getAnySimpleType(), "rel", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Title(), theXMLTypePackage.getAnySimpleType(), "title", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Type(), this.getAtomMediaType(), "type", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(atomEmailAddressEDataType, String.class, "AtomEmailAddress", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(atomLanguageTagEDataType, String.class, "AtomLanguageTag", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(atomMediaTypeEDataType, String.class, "AtomMediaType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// null
		createNullAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>null</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNullAnnotations() {
		String source = null;			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "appinfo", "atom-author-link.xsd 2008-01-23"
		   });																								
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";				
		addAnnotation
		  (atomEmailAddressEDataType, 
		   source, 
		   new String[] {
			 "name", "atomEmailAddress",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", ".+@.+"
		   });		
		addAnnotation
		  (atomLanguageTagEDataType, 
		   source, 
		   new String[] {
			 "name", "atomLanguageTag",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "[A-Za-z]{1,8}(-[A-Za-z0-9]{1,8})*"
		   });		
		addAnnotation
		  (atomMediaTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "atomMediaType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", ".+/.+"
		   });		
		addAnnotation
		  (atomRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getAtomRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getAtomRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getAtomRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getAtomRoot_Author(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "author",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAtomRoot_Email(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "email",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAtomRoot_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAtomRoot_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAtomRoot_Uri(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "uri",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (authorEClass, 
		   source, 
		   new String[] {
			 "name", "atomPersonConstruct",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAuthor_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getAuthor_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getAuthor_Uri(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "uri",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getAuthor_Email(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "email",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "name", "link_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getLink_Href(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "href"
		   });		
		addAnnotation
		  (getLink_Hreflang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "hreflang"
		   });		
		addAnnotation
		  (getLink_Length(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "length"
		   });		
		addAnnotation
		  (getLink_Rel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rel"
		   });		
		addAnnotation
		  (getLink_Title(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "title"
		   });		
		addAnnotation
		  (getLink_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });
	}

} //AuthorlinkPackageImpl
