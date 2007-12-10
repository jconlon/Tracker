/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.verticon.tracker.Event#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getEventCode <em>Event Code</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#isElectronicallyRead <em>Electronically Read</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#isCorrection <em>Correction</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getComments <em>Comments</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getTag <em>Tag</em>}</li>
 *   <li>{@link com.verticon.tracker.Event#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.verticon.tracker.TrackerPackage#getEvent()
 * @model abstract="true"
 * @generated
 */
public interface Event extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * Returns the value of the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Time</em>' attribute.
	 * @see #setDateTime(Date)
	 * @see com.verticon.tracker.TrackerPackage#getEvent_DateTime()
	 * @model required="true"
	 * @generated
	 */
	Date getDateTime();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Event#getDateTime <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Time</em>' attribute.
	 * @see #getDateTime()
	 * @generated
	 */
	void setDateTime(Date value);

	/**
	 * Returns the value of the '<em><b>Event Code</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Code</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getEvent_EventCode()
	 * @model default="0" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getEventCode();

	/**
	 * Returns the value of the '<em><b>Electronically Read</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electronically Read</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electronically Read</em>' attribute.
	 * @see #setElectronicallyRead(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getEvent_ElectronicallyRead()
	 * @model default="false"
	 * @generated
	 */
	boolean isElectronicallyRead();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Event#isElectronicallyRead <em>Electronically Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Electronically Read</em>' attribute.
	 * @see #isElectronicallyRead()
	 * @generated
	 */
	void setElectronicallyRead(boolean value);

	/**
	 * Returns the value of the '<em><b>Correction</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correction</em>' attribute.
	 * @see #setCorrection(boolean)
	 * @see com.verticon.tracker.TrackerPackage#getEvent_Correction()
	 * @model default="false"
	 * @generated
	 */
	boolean isCorrection();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Event#isCorrection <em>Correction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correction</em>' attribute.
	 * @see #isCorrection()
	 * @generated
	 */
	void setCorrection(boolean value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see com.verticon.tracker.TrackerPackage#getEvent_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Event#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.verticon.tracker.Tag#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' container reference.
	 * @see #setTag(Tag)
	 * @see com.verticon.tracker.TrackerPackage#getEvent_Tag()
	 * @see com.verticon.tracker.Tag#getEvents
	 * @model opposite="events" required="true"
	 * @generated
	 */
	Tag getTag();

	/**
	 * Sets the value of the '{@link com.verticon.tracker.Event#getTag <em>Tag</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' container reference.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(Tag value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see com.verticon.tracker.TrackerPackage#getEvent_Id()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getId();

} // Event