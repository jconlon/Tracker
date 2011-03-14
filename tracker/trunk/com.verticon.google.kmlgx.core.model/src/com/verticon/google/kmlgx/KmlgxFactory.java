/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.verticon.google.kmlgx.KmlgxPackage
 * @generated
 */
public interface KmlgxFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KmlgxFactory eINSTANCE = com.verticon.google.kmlgx.impl.KmlgxFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Animated Update</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animated Update</em>'.
	 * @generated
	 */
	AnimatedUpdate createAnimatedUpdate();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Fly To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fly To</em>'.
	 * @generated
	 */
	FlyTo createFlyTo();

	/**
	 * Returns a new object of class '<em>Lat Lon Quad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lat Lon Quad</em>'.
	 * @generated
	 */
	LatLonQuad createLatLonQuad();

	/**
	 * Returns a new object of class '<em>Multi Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Track</em>'.
	 * @generated
	 */
	MultiTrack createMultiTrack();

	/**
	 * Returns a new object of class '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option</em>'.
	 * @generated
	 */
	Option createOption();

	/**
	 * Returns a new object of class '<em>Playlist</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Playlist</em>'.
	 * @generated
	 */
	Playlist createPlaylist();

	/**
	 * Returns a new object of class '<em>Simple Array Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Array Data</em>'.
	 * @generated
	 */
	SimpleArrayData createSimpleArrayData();

	/**
	 * Returns a new object of class '<em>Simple Array Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Array Field</em>'.
	 * @generated
	 */
	SimpleArrayField createSimpleArrayField();

	/**
	 * Returns a new object of class '<em>Sound Cue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sound Cue</em>'.
	 * @generated
	 */
	SoundCue createSoundCue();

	/**
	 * Returns a new object of class '<em>Tour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tour</em>'.
	 * @generated
	 */
	Tour createTour();

	/**
	 * Returns a new object of class '<em>Tour Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tour Control</em>'.
	 * @generated
	 */
	TourControl createTourControl();

	/**
	 * Returns a new object of class '<em>Tour Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tour Primitive</em>'.
	 * @generated
	 */
	TourPrimitive createTourPrimitive();

	/**
	 * Returns a new object of class '<em>Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Track</em>'.
	 * @generated
	 */
	Track createTrack();

	/**
	 * Returns a new object of class '<em>Viewer Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Viewer Options</em>'.
	 * @generated
	 */
	ViewerOptions createViewerOptions();

	/**
	 * Returns a new object of class '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait</em>'.
	 * @generated
	 */
	Wait createWait();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KmlgxPackage getKmlgxPackage();

} //KmlgxFactory
