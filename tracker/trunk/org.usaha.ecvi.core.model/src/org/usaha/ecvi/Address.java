/**
 */
package org.usaha.ecvi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.usaha.ecvi.Address#getLine1 <em>Line1</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getLine2 <em>Line2</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getTown <em>Town</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getCounty <em>County</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getState <em>State</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getZIP <em>ZIP</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getCountry <em>Country</em>}</li>
 *   <li>{@link org.usaha.ecvi.Address#getGeoPoint <em>Geo Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.usaha.ecvi.EcviPackage#getAddress()
 * @model extendedMetaData="name='Address' kind='elementOnly'"
 * @generated
 */
public interface Address extends EObject {
	/**
	 * Returns the value of the '<em><b>Line1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * First line of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line1</em>' attribute.
	 * @see #setLine1(String)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_Line1()
	 * @model dataType="org.usaha.ecvi.AddressLine1" required="true"
	 *        extendedMetaData="kind='element' name='Line1' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLine1();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getLine1 <em>Line1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line1</em>' attribute.
	 * @see #getLine1()
	 * @generated
	 */
	void setLine1(String value);

	/**
	 * Returns the value of the '<em><b>Line2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Second line of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line2</em>' attribute.
	 * @see #setLine2(String)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_Line2()
	 * @model dataType="org.usaha.ecvi.AddressLine2"
	 *        extendedMetaData="kind='element' name='Line2' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLine2();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getLine2 <em>Line2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line2</em>' attribute.
	 * @see #getLine2()
	 * @generated
	 */
	void setLine2(String value);

	/**
	 * Returns the value of the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Town/City of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Town</em>' attribute.
	 * @see #setTown(String)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_Town()
	 * @model dataType="org.usaha.ecvi.Town" required="true"
	 *        extendedMetaData="kind='element' name='Town' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTown();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getTown <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Town</em>' attribute.
	 * @see #getTown()
	 * @generated
	 */
	void setTown(String value);

	/**
	 * Returns the value of the '<em><b>County</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * County of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>County</em>' attribute.
	 * @see #setCounty(String)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_County()
	 * @model dataType="org.usaha.ecvi.County"
	 *        extendedMetaData="kind='element' name='County' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCounty();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getCounty <em>County</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>County</em>' attribute.
	 * @see #getCounty()
	 * @generated
	 */
	void setCounty(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.UsState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * State of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.usaha.ecvi.UsState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(UsState)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_State()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='State' namespace='##targetNamespace'"
	 * @generated
	 */
	UsState getState();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.usaha.ecvi.UsState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(UsState value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Address#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(UsState)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Address#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(UsState)
	 * @generated
	 */
	boolean isSetState();

	/**
	 * Returns the value of the '<em><b>ZIP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ZipCode of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ZIP</em>' attribute.
	 * @see #setZIP(String)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_ZIP()
	 * @model dataType="org.usaha.ecvi.ZipCode" required="true"
	 *        extendedMetaData="kind='element' name='ZIP' namespace='##targetNamespace'"
	 * @generated
	 */
	String getZIP();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getZIP <em>ZIP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ZIP</em>' attribute.
	 * @see #getZIP()
	 * @generated
	 */
	void setZIP(String value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' attribute.
	 * The literals are from the enumeration {@link org.usaha.ecvi.ISO3166Country}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Country of the premises address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Country</em>' attribute.
	 * @see org.usaha.ecvi.ISO3166Country
	 * @see #isSetCountry()
	 * @see #unsetCountry()
	 * @see #setCountry(ISO3166Country)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_Country()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='element' name='Country' namespace='##targetNamespace'"
	 * @generated
	 */
	ISO3166Country getCountry();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' attribute.
	 * @see org.usaha.ecvi.ISO3166Country
	 * @see #isSetCountry()
	 * @see #unsetCountry()
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(ISO3166Country value);

	/**
	 * Unsets the value of the '{@link org.usaha.ecvi.Address#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCountry()
	 * @see #getCountry()
	 * @see #setCountry(ISO3166Country)
	 * @generated
	 */
	void unsetCountry();

	/**
	 * Returns whether the value of the '{@link org.usaha.ecvi.Address#getCountry <em>Country</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Country</em>' attribute is set.
	 * @see #unsetCountry()
	 * @see #getCountry()
	 * @see #setCountry(ISO3166Country)
	 * @generated
	 */
	boolean isSetCountry();

	/**
	 * Returns the value of the '<em><b>Geo Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The co-ordinates of this premises
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Geo Point</em>' containment reference.
	 * @see #setGeoPoint(GeoPoint)
	 * @see org.usaha.ecvi.EcviPackage#getAddress_GeoPoint()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='GeoPoint' namespace='##targetNamespace'"
	 * @generated
	 */
	GeoPoint getGeoPoint();

	/**
	 * Sets the value of the '{@link org.usaha.ecvi.Address#getGeoPoint <em>Geo Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geo Point</em>' containment reference.
	 * @see #getGeoPoint()
	 * @generated
	 */
	void setGeoPoint(GeoPoint value);

} // Address
