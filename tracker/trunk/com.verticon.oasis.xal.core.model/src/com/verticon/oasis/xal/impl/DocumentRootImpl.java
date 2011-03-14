/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.oasis.xal.impl;

import com.verticon.oasis.xal.AddressDetails;
import com.verticon.oasis.xal.AddressLine;
import com.verticon.oasis.xal.AdministrativeArea;
import com.verticon.oasis.xal.CountryName;
import com.verticon.oasis.xal.Department;
import com.verticon.oasis.xal.DocumentRoot;
import com.verticon.oasis.xal.Locality;
import com.verticon.oasis.xal.PostBox;
import com.verticon.oasis.xal.PostOffice;
import com.verticon.oasis.xal.PostalCode;
import com.verticon.oasis.xal.Premise;
import com.verticon.oasis.xal.PremiseNumber;
import com.verticon.oasis.xal.PremiseNumberPrefix;
import com.verticon.oasis.xal.PremiseNumberSuffix;
import com.verticon.oasis.xal.Thoroughfare;
import com.verticon.oasis.xal.ThoroughfareNumber;
import com.verticon.oasis.xal.ThoroughfareNumberPrefix;
import com.verticon.oasis.xal.ThoroughfareNumberSuffix;
import com.verticon.oasis.xal.Xal;
import com.verticon.oasis.xal.XalPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getAddressDetails <em>Address Details</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getAddressLine <em>Address Line</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getAdministrativeArea <em>Administrative Area</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getCountryName <em>Country Name</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getLocality <em>Locality</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPostBox <em>Post Box</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPostOffice <em>Post Office</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPremise <em>Premise</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPremiseNumber <em>Premise Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPremiseNumberPrefix <em>Premise Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getPremiseNumberSuffix <em>Premise Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getThoroughfare <em>Thoroughfare</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getThoroughfareNumber <em>Thoroughfare Number</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getThoroughfareNumberPrefix <em>Thoroughfare Number Prefix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getThoroughfareNumberSuffix <em>Thoroughfare Number Suffix</em>}</li>
 *   <li>{@link com.verticon.oasis.xal.impl.DocumentRootImpl#getXAL <em>XAL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XalPackage.eINSTANCE.getDocumentRoot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, XalPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressDetails getAddressDetails() {
		return (AddressDetails)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_AddressDetails(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressDetails(AddressDetails newAddressDetails, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_AddressDetails(), newAddressDetails, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressDetails(AddressDetails newAddressDetails) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_AddressDetails(), newAddressDetails);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressLine getAddressLine() {
		return (AddressLine)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_AddressLine(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddressLine(AddressLine newAddressLine, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_AddressLine(), newAddressLine, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressLine(AddressLine newAddressLine) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_AddressLine(), newAddressLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdministrativeArea getAdministrativeArea() {
		return (AdministrativeArea)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_AdministrativeArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdministrativeArea(AdministrativeArea newAdministrativeArea, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_AdministrativeArea(), newAdministrativeArea, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdministrativeArea(AdministrativeArea newAdministrativeArea) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_AdministrativeArea(), newAdministrativeArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountryName getCountryName() {
		return (CountryName)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_CountryName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCountryName(CountryName newCountryName, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_CountryName(), newCountryName, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountryName(CountryName newCountryName) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_CountryName(), newCountryName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Department getDepartment() {
		return (Department)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_Department(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartment(Department newDepartment, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_Department(), newDepartment, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment(Department newDepartment) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_Department(), newDepartment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locality getLocality() {
		return (Locality)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_Locality(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocality(Locality newLocality, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_Locality(), newLocality, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocality(Locality newLocality) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_Locality(), newLocality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalCode getPostalCode() {
		return (PostalCode)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PostalCode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalCode(PostalCode newPostalCode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PostalCode(), newPostalCode, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(PostalCode newPostalCode) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PostalCode(), newPostalCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBox getPostBox() {
		return (PostBox)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PostBox(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostBox(PostBox newPostBox, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PostBox(), newPostBox, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostBox(PostBox newPostBox) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PostBox(), newPostBox);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostOffice getPostOffice() {
		return (PostOffice)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PostOffice(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostOffice(PostOffice newPostOffice, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PostOffice(), newPostOffice, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostOffice(PostOffice newPostOffice) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PostOffice(), newPostOffice);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Premise getPremise() {
		return (Premise)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_Premise(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremise(Premise newPremise, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_Premise(), newPremise, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremise(Premise newPremise) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_Premise(), newPremise);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumber getPremiseNumber() {
		return (PremiseNumber)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumber(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumber(PremiseNumber newPremiseNumber, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumber(), newPremiseNumber, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumber(PremiseNumber newPremiseNumber) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumber(), newPremiseNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberPrefix getPremiseNumberPrefix() {
		return (PremiseNumberPrefix)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberPrefix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumberPrefix(PremiseNumberPrefix newPremiseNumberPrefix, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberPrefix(), newPremiseNumberPrefix, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberPrefix(PremiseNumberPrefix newPremiseNumberPrefix) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberPrefix(), newPremiseNumberPrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PremiseNumberSuffix getPremiseNumberSuffix() {
		return (PremiseNumberSuffix)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberSuffix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPremiseNumberSuffix(PremiseNumberSuffix newPremiseNumberSuffix, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberSuffix(), newPremiseNumberSuffix, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremiseNumberSuffix(PremiseNumberSuffix newPremiseNumberSuffix) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_PremiseNumberSuffix(), newPremiseNumberSuffix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Thoroughfare getThoroughfare() {
		return (Thoroughfare)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_Thoroughfare(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfare(Thoroughfare newThoroughfare, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_Thoroughfare(), newThoroughfare, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfare(Thoroughfare newThoroughfare) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_Thoroughfare(), newThoroughfare);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumber getThoroughfareNumber() {
		return (ThoroughfareNumber)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumber(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareNumber(ThoroughfareNumber newThoroughfareNumber, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumber(), newThoroughfareNumber, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareNumber(ThoroughfareNumber newThoroughfareNumber) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumber(), newThoroughfareNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberPrefix getThoroughfareNumberPrefix() {
		return (ThoroughfareNumberPrefix)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberPrefix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareNumberPrefix(ThoroughfareNumberPrefix newThoroughfareNumberPrefix, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberPrefix(), newThoroughfareNumberPrefix, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareNumberPrefix(ThoroughfareNumberPrefix newThoroughfareNumberPrefix) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberPrefix(), newThoroughfareNumberPrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThoroughfareNumberSuffix getThoroughfareNumberSuffix() {
		return (ThoroughfareNumberSuffix)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberSuffix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThoroughfareNumberSuffix(ThoroughfareNumberSuffix newThoroughfareNumberSuffix, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberSuffix(), newThoroughfareNumberSuffix, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThoroughfareNumberSuffix(ThoroughfareNumberSuffix newThoroughfareNumberSuffix) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_ThoroughfareNumberSuffix(), newThoroughfareNumberSuffix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xal getXAL() {
		return (Xal)getMixed().get(XalPackage.eINSTANCE.getDocumentRoot_XAL(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXAL(Xal newXAL, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(XalPackage.eINSTANCE.getDocumentRoot_XAL(), newXAL, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAL(Xal newXAL) {
		((FeatureMap.Internal)getMixed()).set(XalPackage.eINSTANCE.getDocumentRoot_XAL(), newXAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XalPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case XalPackage.DOCUMENT_ROOT__ADDRESS_DETAILS:
				return basicSetAddressDetails(null, msgs);
			case XalPackage.DOCUMENT_ROOT__ADDRESS_LINE:
				return basicSetAddressLine(null, msgs);
			case XalPackage.DOCUMENT_ROOT__ADMINISTRATIVE_AREA:
				return basicSetAdministrativeArea(null, msgs);
			case XalPackage.DOCUMENT_ROOT__COUNTRY_NAME:
				return basicSetCountryName(null, msgs);
			case XalPackage.DOCUMENT_ROOT__DEPARTMENT:
				return basicSetDepartment(null, msgs);
			case XalPackage.DOCUMENT_ROOT__LOCALITY:
				return basicSetLocality(null, msgs);
			case XalPackage.DOCUMENT_ROOT__POSTAL_CODE:
				return basicSetPostalCode(null, msgs);
			case XalPackage.DOCUMENT_ROOT__POST_BOX:
				return basicSetPostBox(null, msgs);
			case XalPackage.DOCUMENT_ROOT__POST_OFFICE:
				return basicSetPostOffice(null, msgs);
			case XalPackage.DOCUMENT_ROOT__PREMISE:
				return basicSetPremise(null, msgs);
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER:
				return basicSetPremiseNumber(null, msgs);
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX:
				return basicSetPremiseNumberPrefix(null, msgs);
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX:
				return basicSetPremiseNumberSuffix(null, msgs);
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE:
				return basicSetThoroughfare(null, msgs);
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER:
				return basicSetThoroughfareNumber(null, msgs);
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX:
				return basicSetThoroughfareNumberPrefix(null, msgs);
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX:
				return basicSetThoroughfareNumberSuffix(null, msgs);
			case XalPackage.DOCUMENT_ROOT__XAL:
				return basicSetXAL(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XalPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case XalPackage.DOCUMENT_ROOT__ADDRESS_DETAILS:
				return getAddressDetails();
			case XalPackage.DOCUMENT_ROOT__ADDRESS_LINE:
				return getAddressLine();
			case XalPackage.DOCUMENT_ROOT__ADMINISTRATIVE_AREA:
				return getAdministrativeArea();
			case XalPackage.DOCUMENT_ROOT__COUNTRY_NAME:
				return getCountryName();
			case XalPackage.DOCUMENT_ROOT__DEPARTMENT:
				return getDepartment();
			case XalPackage.DOCUMENT_ROOT__LOCALITY:
				return getLocality();
			case XalPackage.DOCUMENT_ROOT__POSTAL_CODE:
				return getPostalCode();
			case XalPackage.DOCUMENT_ROOT__POST_BOX:
				return getPostBox();
			case XalPackage.DOCUMENT_ROOT__POST_OFFICE:
				return getPostOffice();
			case XalPackage.DOCUMENT_ROOT__PREMISE:
				return getPremise();
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER:
				return getPremiseNumber();
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX:
				return getPremiseNumberPrefix();
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX:
				return getPremiseNumberSuffix();
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE:
				return getThoroughfare();
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER:
				return getThoroughfareNumber();
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX:
				return getThoroughfareNumberPrefix();
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX:
				return getThoroughfareNumberSuffix();
			case XalPackage.DOCUMENT_ROOT__XAL:
				return getXAL();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XalPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__ADDRESS_DETAILS:
				setAddressDetails((AddressDetails)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__ADDRESS_LINE:
				setAddressLine((AddressLine)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__ADMINISTRATIVE_AREA:
				setAdministrativeArea((AdministrativeArea)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__COUNTRY_NAME:
				setCountryName((CountryName)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__DEPARTMENT:
				setDepartment((Department)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__LOCALITY:
				setLocality((Locality)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__POSTAL_CODE:
				setPostalCode((PostalCode)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__POST_BOX:
				setPostBox((PostBox)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__POST_OFFICE:
				setPostOffice((PostOffice)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE:
				setPremise((Premise)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER:
				setPremiseNumber((PremiseNumber)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX:
				setPremiseNumberPrefix((PremiseNumberPrefix)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX:
				setPremiseNumberSuffix((PremiseNumberSuffix)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE:
				setThoroughfare((Thoroughfare)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER:
				setThoroughfareNumber((ThoroughfareNumber)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX:
				setThoroughfareNumberPrefix((ThoroughfareNumberPrefix)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX:
				setThoroughfareNumberSuffix((ThoroughfareNumberSuffix)newValue);
				return;
			case XalPackage.DOCUMENT_ROOT__XAL:
				setXAL((Xal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XalPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case XalPackage.DOCUMENT_ROOT__ADDRESS_DETAILS:
				setAddressDetails((AddressDetails)null);
				return;
			case XalPackage.DOCUMENT_ROOT__ADDRESS_LINE:
				setAddressLine((AddressLine)null);
				return;
			case XalPackage.DOCUMENT_ROOT__ADMINISTRATIVE_AREA:
				setAdministrativeArea((AdministrativeArea)null);
				return;
			case XalPackage.DOCUMENT_ROOT__COUNTRY_NAME:
				setCountryName((CountryName)null);
				return;
			case XalPackage.DOCUMENT_ROOT__DEPARTMENT:
				setDepartment((Department)null);
				return;
			case XalPackage.DOCUMENT_ROOT__LOCALITY:
				setLocality((Locality)null);
				return;
			case XalPackage.DOCUMENT_ROOT__POSTAL_CODE:
				setPostalCode((PostalCode)null);
				return;
			case XalPackage.DOCUMENT_ROOT__POST_BOX:
				setPostBox((PostBox)null);
				return;
			case XalPackage.DOCUMENT_ROOT__POST_OFFICE:
				setPostOffice((PostOffice)null);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE:
				setPremise((Premise)null);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER:
				setPremiseNumber((PremiseNumber)null);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX:
				setPremiseNumberPrefix((PremiseNumberPrefix)null);
				return;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX:
				setPremiseNumberSuffix((PremiseNumberSuffix)null);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE:
				setThoroughfare((Thoroughfare)null);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER:
				setThoroughfareNumber((ThoroughfareNumber)null);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX:
				setThoroughfareNumberPrefix((ThoroughfareNumberPrefix)null);
				return;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX:
				setThoroughfareNumberSuffix((ThoroughfareNumberSuffix)null);
				return;
			case XalPackage.DOCUMENT_ROOT__XAL:
				setXAL((Xal)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XalPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case XalPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case XalPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case XalPackage.DOCUMENT_ROOT__ADDRESS_DETAILS:
				return getAddressDetails() != null;
			case XalPackage.DOCUMENT_ROOT__ADDRESS_LINE:
				return getAddressLine() != null;
			case XalPackage.DOCUMENT_ROOT__ADMINISTRATIVE_AREA:
				return getAdministrativeArea() != null;
			case XalPackage.DOCUMENT_ROOT__COUNTRY_NAME:
				return getCountryName() != null;
			case XalPackage.DOCUMENT_ROOT__DEPARTMENT:
				return getDepartment() != null;
			case XalPackage.DOCUMENT_ROOT__LOCALITY:
				return getLocality() != null;
			case XalPackage.DOCUMENT_ROOT__POSTAL_CODE:
				return getPostalCode() != null;
			case XalPackage.DOCUMENT_ROOT__POST_BOX:
				return getPostBox() != null;
			case XalPackage.DOCUMENT_ROOT__POST_OFFICE:
				return getPostOffice() != null;
			case XalPackage.DOCUMENT_ROOT__PREMISE:
				return getPremise() != null;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER:
				return getPremiseNumber() != null;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_PREFIX:
				return getPremiseNumberPrefix() != null;
			case XalPackage.DOCUMENT_ROOT__PREMISE_NUMBER_SUFFIX:
				return getPremiseNumberSuffix() != null;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE:
				return getThoroughfare() != null;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER:
				return getThoroughfareNumber() != null;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_PREFIX:
				return getThoroughfareNumberPrefix() != null;
			case XalPackage.DOCUMENT_ROOT__THOROUGHFARE_NUMBER_SUFFIX:
				return getThoroughfareNumberSuffix() != null;
			case XalPackage.DOCUMENT_ROOT__XAL:
				return getXAL() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
