/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.atom.authorlink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * There is no official atom XSD. This XSD is created based on:
 *       http://atompub.org/2005/08/17/atom.rnc. A subset of Atom as used in the
 *       ogckml22.xsd is defined here. 
 * <!-- end-model-doc -->
 * @see com.verticon.atom.authorlink.AuthorlinkFactory
 * @model kind="package"
 * @generated
 */
public interface AuthorlinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "authorlink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.w3.org/2005/Atom";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "atom";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.verticon.atom.authorlink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AuthorlinkPackage eINSTANCE = com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.atom.authorlink.impl.AtomRootImpl <em>Atom Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.atom.authorlink.impl.AtomRootImpl
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomRoot()
	 * @generated
	 */
	int ATOM_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__AUTHOR = 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__EMAIL = 4;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__LINK = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__NAME = 6;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT__URI = 7;

	/**
	 * The number of structural features of the '<em>Atom Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_ROOT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.verticon.atom.authorlink.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.atom.authorlink.impl.AuthorImpl
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__URI = 2;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__EMAIL = 3;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.verticon.atom.authorlink.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.atom.authorlink.impl.LinkImpl
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 2;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__HREF = 0;

	/**
	 * The feature id for the '<em><b>Hreflang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__HREFLANG = 1;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__LENGTH = 2;

	/**
	 * The feature id for the '<em><b>Rel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__REL = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TITLE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '<em>Atom Email Address</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomEmailAddress()
	 * @generated
	 */
	int ATOM_EMAIL_ADDRESS = 3;

	/**
	 * The meta object id for the '<em>Atom Language Tag</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomLanguageTag()
	 * @generated
	 */
	int ATOM_LANGUAGE_TAG = 4;

	/**
	 * The meta object id for the '<em>Atom Media Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomMediaType()
	 * @generated
	 */
	int ATOM_MEDIA_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link com.verticon.atom.authorlink.AtomRoot <em>Atom Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom Root</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot
	 * @generated
	 */
	EClass getAtomRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.atom.authorlink.AtomRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getMixed()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EAttribute getAtomRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.verticon.atom.authorlink.AtomRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getXMLNSPrefixMap()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EReference getAtomRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.verticon.atom.authorlink.AtomRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getXSISchemaLocation()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EReference getAtomRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.atom.authorlink.AtomRoot#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Author</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getAuthor()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EReference getAtomRoot_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.AtomRoot#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getEmail()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EAttribute getAtomRoot_Email();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.atom.authorlink.AtomRoot#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getLink()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EReference getAtomRoot_Link();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.AtomRoot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getName()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EAttribute getAtomRoot_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.AtomRoot#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see com.verticon.atom.authorlink.AtomRoot#getUri()
	 * @see #getAtomRoot()
	 * @generated
	 */
	EAttribute getAtomRoot_Uri();

	/**
	 * Returns the meta object for class '{@link com.verticon.atom.authorlink.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see com.verticon.atom.authorlink.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.atom.authorlink.Author#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.verticon.atom.authorlink.Author#getGroup()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Group();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.atom.authorlink.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see com.verticon.atom.authorlink.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.atom.authorlink.Author#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uri</em>'.
	 * @see com.verticon.atom.authorlink.Author#getUri()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Uri();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.atom.authorlink.Author#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Email</em>'.
	 * @see com.verticon.atom.authorlink.Author#getEmail()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Email();

	/**
	 * Returns the meta object for class '{@link com.verticon.atom.authorlink.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see com.verticon.atom.authorlink.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.verticon.atom.authorlink.Link#getHref()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Href();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getHreflang <em>Hreflang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hreflang</em>'.
	 * @see com.verticon.atom.authorlink.Link#getHreflang()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Hreflang();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.verticon.atom.authorlink.Link#getLength()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Length();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getRel <em>Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rel</em>'.
	 * @see com.verticon.atom.authorlink.Link#getRel()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Rel();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.verticon.atom.authorlink.Link#getTitle()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.atom.authorlink.Link#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.atom.authorlink.Link#getType()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Type();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Atom Email Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Atom Email Address</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='atomEmailAddress' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='.+@.+'"
	 * @generated
	 */
	EDataType getAtomEmailAddress();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Atom Language Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Atom Language Tag</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='atomLanguageTag' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[A-Za-z]{1,8}(-[A-Za-z0-9]{1,8})*'"
	 * @generated
	 */
	EDataType getAtomLanguageTag();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Atom Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Atom Media Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='atomMediaType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='.+/.+'"
	 * @generated
	 */
	EDataType getAtomMediaType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AuthorlinkFactory getAuthorlinkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.verticon.atom.authorlink.impl.AtomRootImpl <em>Atom Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.atom.authorlink.impl.AtomRootImpl
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomRoot()
		 * @generated
		 */
		EClass ATOM_ROOT = eINSTANCE.getAtomRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM_ROOT__MIXED = eINSTANCE.getAtomRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOM_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getAtomRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOM_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getAtomRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOM_ROOT__AUTHOR = eINSTANCE.getAtomRoot_Author();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM_ROOT__EMAIL = eINSTANCE.getAtomRoot_Email();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOM_ROOT__LINK = eINSTANCE.getAtomRoot_Link();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM_ROOT__NAME = eINSTANCE.getAtomRoot_Name();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM_ROOT__URI = eINSTANCE.getAtomRoot_Uri();

		/**
		 * The meta object literal for the '{@link com.verticon.atom.authorlink.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.atom.authorlink.impl.AuthorImpl
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__GROUP = eINSTANCE.getAuthor_Group();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__URI = eINSTANCE.getAuthor_Uri();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__EMAIL = eINSTANCE.getAuthor_Email();

		/**
		 * The meta object literal for the '{@link com.verticon.atom.authorlink.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.atom.authorlink.impl.LinkImpl
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__HREF = eINSTANCE.getLink_Href();

		/**
		 * The meta object literal for the '<em><b>Hreflang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__HREFLANG = eINSTANCE.getLink_Hreflang();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__LENGTH = eINSTANCE.getLink_Length();

		/**
		 * The meta object literal for the '<em><b>Rel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__REL = eINSTANCE.getLink_Rel();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__TITLE = eINSTANCE.getLink_Title();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__TYPE = eINSTANCE.getLink_Type();

		/**
		 * The meta object literal for the '<em>Atom Email Address</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomEmailAddress()
		 * @generated
		 */
		EDataType ATOM_EMAIL_ADDRESS = eINSTANCE.getAtomEmailAddress();

		/**
		 * The meta object literal for the '<em>Atom Language Tag</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomLanguageTag()
		 * @generated
		 */
		EDataType ATOM_LANGUAGE_TAG = eINSTANCE.getAtomLanguageTag();

		/**
		 * The meta object literal for the '<em>Atom Media Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.verticon.atom.authorlink.impl.AuthorlinkPackageImpl#getAtomMediaType()
		 * @generated
		 */
		EDataType ATOM_MEDIA_TYPE = eINSTANCE.getAtomMediaType();

	}

} //AuthorlinkPackage
