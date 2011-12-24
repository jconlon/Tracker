/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.verticon.google.kmlgx.DocumentRoot;
import com.verticon.google.kmlgx.KmlgxFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive() <em>Abstract Tour Primitive</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup() <em>Abstract Tour Primitive Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup() <em>Abstract Track Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode() <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset() <em>Altitude Offset</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAngles() <em>Angles</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate() <em>Animated Update</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility() <em>Balloon Visibility</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getCoord() <em>Coord</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDelayedStart() <em>Delayed Start</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDrawOrder() <em>Draw Order</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getDuration() <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getFlyTo() <em>Fly To</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getFlyToMode() <em>Fly To Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getH() <em>H</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#isInterpolate() <em>Interpolate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad() <em>Lat Lon Quad</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getMultiTrack() <em>Multi Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOption() <em>Option</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOuterColor() <em>Outer Color</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getOuterWidth() <em>Outer Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth() <em>Physical Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPlaylist() <em>Playlist</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getPlayMode() <em>Play Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getRank() <em>Rank</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData() <em>Simple Array Data</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension() <em>Simple Array Data Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField() <em>Simple Array Field</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension() <em>Simple Array Field Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getSoundCue() <em>Sound Cue</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTimeSpan() <em>Time Span</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTimeStamp() <em>Time Stamp</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTour() <em>Tour</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTourControl() <em>Tour Control</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getTrack() <em>Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getValue() <em>Value</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getViewerOptions() <em>Viewer Options</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getW() <em>W</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getWait() <em>Wait</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getX() <em>X</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.DocumentRoot#getY() <em>Y</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class DocumentRootTest extends TestCase {

	/**
	 * The fixture for this Document Root test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRoot fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DocumentRootTest.class);
	}

	/**
	 * Constructs a new Document Root test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRootTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Document Root test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DocumentRoot fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Document Root test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRoot getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(KmlgxFactory.eINSTANCE.createDocumentRoot());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive() <em>Abstract Tour Primitive</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive()
	 * @generated NOT
	 */
	public void testGetAbstractTourPrimitive() {
//		Placemark placeMarkKmlFactory.eINSTANCE.createPlacemark();
//		KmlgxFactory.eINSTANCE.create
//		getFixture().setAbstractTourPrimitive(value)
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setAbstractTourPrimitive(com.verticon.google.kmlgx.TourPrimitive) <em>Abstract Tour Primitive</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setAbstractTourPrimitive(com.verticon.google.kmlgx.TourPrimitive)
	 * @generated
	 */
	public void testSetAbstractTourPrimitive() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup() <em>Abstract Tour Primitive Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup()
	 * @generated
	 */
	public void testGetAbstractTourPrimitiveGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup() <em>Abstract Track Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractTrackSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode() <em>Altitude Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode()
	 * @generated
	 */
	public void testGetAltitudeMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setAltitudeMode(com.verticon.google.kmlgx.AltitudeModeEnumType) <em>Altitude Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setAltitudeMode(com.verticon.google.kmlgx.AltitudeModeEnumType)
	 * @generated
	 */
	public void testSetAltitudeMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset() <em>Altitude Offset</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset()
	 * @generated
	 */
	public void testGetAltitudeOffset() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setAltitudeOffset(double) <em>Altitude Offset</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setAltitudeOffset(double)
	 * @generated
	 */
	public void testSetAltitudeOffset() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAngles() <em>Angles</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAngles()
	 * @generated
	 */
	public void testGetAngles() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setAngles(java.lang.String) <em>Angles</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setAngles(java.lang.String)
	 * @generated
	 */
	public void testSetAngles() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate() <em>Animated Update</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate()
	 * @generated
	 */
	public void testGetAnimatedUpdate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setAnimatedUpdate(com.verticon.google.kmlgx.AnimatedUpdate) <em>Animated Update</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setAnimatedUpdate(com.verticon.google.kmlgx.AnimatedUpdate)
	 * @generated
	 */
	public void testSetAnimatedUpdate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility() <em>Balloon Visibility</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility()
	 * @generated
	 */
	public void testIsBalloonVisibility() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setBalloonVisibility(boolean) <em>Balloon Visibility</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setBalloonVisibility(boolean)
	 * @generated
	 */
	public void testSetBalloonVisibility() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getCoord() <em>Coord</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getCoord()
	 * @generated
	 */
	public void testGetCoord() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setCoord(java.lang.String) <em>Coord</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setCoord(java.lang.String)
	 * @generated
	 */
	public void testSetCoord() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getDelayedStart() <em>Delayed Start</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDelayedStart()
	 * @generated
	 */
	public void testGetDelayedStart() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setDelayedStart(double) <em>Delayed Start</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setDelayedStart(double)
	 * @generated
	 */
	public void testSetDelayedStart() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getDrawOrder() <em>Draw Order</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDrawOrder()
	 * @generated
	 */
	public void testGetDrawOrder() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setDrawOrder(java.math.BigInteger) <em>Draw Order</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setDrawOrder(java.math.BigInteger)
	 * @generated
	 */
	public void testSetDrawOrder() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getDuration() <em>Duration</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDuration()
	 * @generated
	 */
	public void testGetDuration() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setDuration(double) <em>Duration</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setDuration(double)
	 * @generated
	 */
	public void testSetDuration() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyTo() <em>Fly To</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getFlyTo()
	 * @generated
	 */
	public void testGetFlyTo() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setFlyTo(com.verticon.google.kmlgx.FlyTo) <em>Fly To</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setFlyTo(com.verticon.google.kmlgx.FlyTo)
	 * @generated
	 */
	public void testSetFlyTo() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyToMode() <em>Fly To Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getFlyToMode()
	 * @generated
	 */
	public void testGetFlyToMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setFlyToMode(com.verticon.google.kmlgx.FlyToModeEnumType) <em>Fly To Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setFlyToMode(com.verticon.google.kmlgx.FlyToModeEnumType)
	 * @generated
	 */
	public void testSetFlyToMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getH() <em>H</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getH()
	 * @generated
	 */
	public void testGetH() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setH(java.math.BigInteger) <em>H</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setH(java.math.BigInteger)
	 * @generated
	 */
	public void testSetH() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#isInterpolate() <em>Interpolate</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#isInterpolate()
	 * @generated
	 */
	public void testIsInterpolate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setInterpolate(boolean) <em>Interpolate</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setInterpolate(boolean)
	 * @generated
	 */
	public void testSetInterpolate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad() <em>Lat Lon Quad</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad()
	 * @generated
	 */
	public void testGetLatLonQuad() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setLatLonQuad(com.verticon.google.kmlgx.LatLonQuad) <em>Lat Lon Quad</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setLatLonQuad(com.verticon.google.kmlgx.LatLonQuad)
	 * @generated
	 */
	public void testSetLatLonQuad() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getMultiTrack() <em>Multi Track</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getMultiTrack()
	 * @generated
	 */
	public void testGetMultiTrack() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setMultiTrack(com.verticon.google.kmlgx.MultiTrack) <em>Multi Track</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setMultiTrack(com.verticon.google.kmlgx.MultiTrack)
	 * @generated
	 */
	public void testSetMultiTrack() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getOption() <em>Option</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOption()
	 * @generated
	 */
	public void testGetOption() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setOption(com.verticon.google.kmlgx.Option) <em>Option</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setOption(com.verticon.google.kmlgx.Option)
	 * @generated
	 */
	public void testSetOption() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterColor() <em>Outer Color</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOuterColor()
	 * @generated
	 */
	public void testGetOuterColor() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setOuterColor(byte[]) <em>Outer Color</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setOuterColor(byte[])
	 * @generated
	 */
	public void testSetOuterColor() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterWidth() <em>Outer Width</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOuterWidth()
	 * @generated
	 */
	public void testGetOuterWidth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setOuterWidth(float) <em>Outer Width</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setOuterWidth(float)
	 * @generated
	 */
	public void testSetOuterWidth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth() <em>Physical Width</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth()
	 * @generated
	 */
	public void testGetPhysicalWidth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setPhysicalWidth(float) <em>Physical Width</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setPhysicalWidth(float)
	 * @generated
	 */
	public void testSetPhysicalWidth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getPlaylist() <em>Playlist</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPlaylist()
	 * @generated
	 */
	public void testGetPlaylist() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setPlaylist(com.verticon.google.kmlgx.Playlist) <em>Playlist</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setPlaylist(com.verticon.google.kmlgx.Playlist)
	 * @generated
	 */
	public void testSetPlaylist() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getPlayMode() <em>Play Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPlayMode()
	 * @generated
	 */
	public void testGetPlayMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setPlayMode(com.verticon.google.kmlgx.PlayModeEnumType) <em>Play Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setPlayMode(com.verticon.google.kmlgx.PlayModeEnumType)
	 * @generated
	 */
	public void testSetPlayMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getRank() <em>Rank</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getRank()
	 * @generated
	 */
	public void testGetRank() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setRank(double) <em>Rank</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setRank(double)
	 * @generated
	 */
	public void testSetRank() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData() <em>Simple Array Data</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData()
	 * @generated
	 */
	public void testGetSimpleArrayData() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setSimpleArrayData(com.verticon.google.kmlgx.SimpleArrayData) <em>Simple Array Data</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setSimpleArrayData(com.verticon.google.kmlgx.SimpleArrayData)
	 * @generated
	 */
	public void testSetSimpleArrayData() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension() <em>Simple Array Data Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension()
	 * @generated
	 */
	public void testGetSimpleArrayDataExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField() <em>Simple Array Field</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField()
	 * @generated
	 */
	public void testGetSimpleArrayField() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setSimpleArrayField(com.verticon.google.kmlgx.SimpleArrayField) <em>Simple Array Field</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setSimpleArrayField(com.verticon.google.kmlgx.SimpleArrayField)
	 * @generated
	 */
	public void testSetSimpleArrayField() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension() <em>Simple Array Field Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension()
	 * @generated
	 */
	public void testGetSimpleArrayFieldExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getSoundCue() <em>Sound Cue</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSoundCue()
	 * @generated
	 */
	public void testGetSoundCue() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setSoundCue(com.verticon.google.kmlgx.SoundCue) <em>Sound Cue</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setSoundCue(com.verticon.google.kmlgx.SoundCue)
	 * @generated
	 */
	public void testSetSoundCue() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeSpan() <em>Time Span</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTimeSpan()
	 * @generated
	 */
	public void testGetTimeSpan() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setTimeSpan(com.verticon.opengis.kml.TimeSpan) <em>Time Span</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setTimeSpan(com.verticon.opengis.kml.TimeSpan)
	 * @generated
	 */
	public void testSetTimeSpan() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeStamp() <em>Time Stamp</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTimeStamp()
	 * @generated
	 */
	public void testGetTimeStamp() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setTimeStamp(com.verticon.opengis.kml.TimeStamp) <em>Time Stamp</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setTimeStamp(com.verticon.opengis.kml.TimeStamp)
	 * @generated
	 */
	public void testSetTimeStamp() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getTour() <em>Tour</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTour()
	 * @generated
	 */
	public void testGetTour() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setTour(com.verticon.google.kmlgx.Tour) <em>Tour</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setTour(com.verticon.google.kmlgx.Tour)
	 * @generated
	 */
	public void testSetTour() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getTourControl() <em>Tour Control</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTourControl()
	 * @generated
	 */
	public void testGetTourControl() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setTourControl(com.verticon.google.kmlgx.TourControl) <em>Tour Control</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setTourControl(com.verticon.google.kmlgx.TourControl)
	 * @generated
	 */
	public void testSetTourControl() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getTrack() <em>Track</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTrack()
	 * @generated
	 */
	public void testGetTrack() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setTrack(com.verticon.google.kmlgx.Track) <em>Track</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setTrack(com.verticon.google.kmlgx.Track)
	 * @generated
	 */
	public void testSetTrack() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getValue() <em>Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getValue()
	 * @generated
	 */
	public void testGetValue() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setValue(java.lang.String) <em>Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setValue(java.lang.String)
	 * @generated
	 */
	public void testSetValue() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getViewerOptions() <em>Viewer Options</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getViewerOptions()
	 * @generated
	 */
	public void testGetViewerOptions() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setViewerOptions(com.verticon.google.kmlgx.ViewerOptions) <em>Viewer Options</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setViewerOptions(com.verticon.google.kmlgx.ViewerOptions)
	 * @generated
	 */
	public void testSetViewerOptions() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getW() <em>W</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getW()
	 * @generated
	 */
	public void testGetW() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setW(java.math.BigInteger) <em>W</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setW(java.math.BigInteger)
	 * @generated
	 */
	public void testSetW() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getWait() <em>Wait</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getWait()
	 * @generated
	 */
	public void testGetWait() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setWait(com.verticon.google.kmlgx.Wait) <em>Wait</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setWait(com.verticon.google.kmlgx.Wait)
	 * @generated
	 */
	public void testSetWait() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getX() <em>X</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getX()
	 * @generated
	 */
	public void testGetX() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setX(java.math.BigInteger) <em>X</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setX(java.math.BigInteger)
	 * @generated
	 */
	public void testSetX() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#getY() <em>Y</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#getY()
	 * @generated
	 */
	public void testGetY() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.google.kmlgx.DocumentRoot#setY(java.math.BigInteger) <em>Y</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.DocumentRoot#setY(java.math.BigInteger)
	 * @generated
	 */
	public void testSetY() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //DocumentRootTest
