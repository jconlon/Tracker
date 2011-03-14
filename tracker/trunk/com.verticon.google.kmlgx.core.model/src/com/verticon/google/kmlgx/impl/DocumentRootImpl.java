/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.AltitudeModeEnumType;
import com.verticon.google.kmlgx.AnimatedUpdate;
import com.verticon.google.kmlgx.DocumentRoot;
import com.verticon.google.kmlgx.FlyTo;
import com.verticon.google.kmlgx.FlyToModeEnumType;
import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.LatLonQuad;
import com.verticon.google.kmlgx.MultiTrack;
import com.verticon.google.kmlgx.Option;
import com.verticon.google.kmlgx.PlayModeEnumType;
import com.verticon.google.kmlgx.Playlist;
import com.verticon.google.kmlgx.SimpleArrayData;
import com.verticon.google.kmlgx.SimpleArrayField;
import com.verticon.google.kmlgx.SoundCue;
import com.verticon.google.kmlgx.Tour;
import com.verticon.google.kmlgx.TourControl;
import com.verticon.google.kmlgx.TourPrimitive;
import com.verticon.google.kmlgx.Track;
import com.verticon.google.kmlgx.ViewerOptions;
import com.verticon.google.kmlgx.Wait;
import com.verticon.opengis.kml.TimeSpan;
import com.verticon.opengis.kml.TimeStamp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAbstractTourPrimitive <em>Abstract Tour Primitive</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAltitudeMode <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAltitudeOffset <em>Altitude Offset</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAngles <em>Angles</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getAnimatedUpdate <em>Animated Update</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#isBalloonVisibility <em>Balloon Visibility</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getCoord <em>Coord</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getDelayedStart <em>Delayed Start</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getDrawOrder <em>Draw Order</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getFlyTo <em>Fly To</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getFlyToMode <em>Fly To Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getH <em>H</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#isInterpolate <em>Interpolate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getLatLonQuad <em>Lat Lon Quad</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getMultiTrack <em>Multi Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getOption <em>Option</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getOuterColor <em>Outer Color</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getOuterWidth <em>Outer Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getPhysicalWidth <em>Physical Width</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getPlaylist <em>Playlist</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getPlayMode <em>Play Mode</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getRank <em>Rank</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getSimpleArrayData <em>Simple Array Data</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getSimpleArrayField <em>Simple Array Field</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getSoundCue <em>Sound Cue</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getTimeSpan <em>Time Span</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getTour <em>Tour</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getTourControl <em>Tour Control</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getTrack <em>Track</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getViewerOptions <em>Viewer Options</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getW <em>W</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getX <em>X</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.DocumentRootImpl#getY <em>Y</em>}</li>
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
	 * The default value of the '{@link #getAbstractTrackSimpleExtensionGroup() <em>Abstract Track Simple Extension Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractTrackSimpleExtensionGroup()
	 * @generated
	 * @ordered
	 */
	protected static final Object ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getAltitudeMode() <em>Altitude Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeMode()
	 * @generated
	 * @ordered
	 */
	protected static final AltitudeModeEnumType ALTITUDE_MODE_EDEFAULT = AltitudeModeEnumType.CLAMP_TO_SEA_FLOOR;

	/**
	 * The default value of the '{@link #getAltitudeOffset() <em>Altitude Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeOffset()
	 * @generated
	 * @ordered
	 */
	protected static final double ALTITUDE_OFFSET_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getAngles() <em>Angles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngles()
	 * @generated
	 * @ordered
	 */
	protected static final String ANGLES_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isBalloonVisibility() <em>Balloon Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBalloonVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BALLOON_VISIBILITY_EDEFAULT = true;

	/**
	 * The default value of the '{@link #getCoord() <em>Coord</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoord()
	 * @generated
	 * @ordered
	 */
	protected static final String COORD_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDelayedStart() <em>Delayed Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelayedStart()
	 * @generated
	 * @ordered
	 */
	protected static final double DELAYED_START_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getDrawOrder() <em>Draw Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawOrder()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger DRAW_ORDER_EDEFAULT = new BigInteger("0");

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double DURATION_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getFlyToMode() <em>Fly To Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlyToMode()
	 * @generated
	 * @ordered
	 */
	protected static final FlyToModeEnumType FLY_TO_MODE_EDEFAULT = FlyToModeEnumType.BOUNCE;

	/**
	 * The default value of the '{@link #getH() <em>H</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getH()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger H_EDEFAULT = new BigInteger("-1");

	/**
	 * The default value of the '{@link #isInterpolate() <em>Interpolate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterpolate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERPOLATE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getOuterColor() <em>Outer Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterColor()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] OUTER_COLOR_EDEFAULT = { (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff };

	/**
	 * The default value of the '{@link #getOuterWidth() <em>Outer Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float OUTER_WIDTH_EDEFAULT = 0.0F;

	/**
	 * The default value of the '{@link #getPhysicalWidth() <em>Physical Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float PHYSICAL_WIDTH_EDEFAULT = 0.0F;

	/**
	 * The default value of the '{@link #getPlayMode() <em>Play Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayMode()
	 * @generated
	 * @ordered
	 */
	protected static final PlayModeEnumType PLAY_MODE_EDEFAULT = PlayModeEnumType.PAUSE;

	/**
	 * The default value of the '{@link #getRank() <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRank()
	 * @generated
	 * @ordered
	 */
	protected static final double RANK_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getW() <em>W</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger W_EDEFAULT = new BigInteger("-1");

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger X_EDEFAULT = new BigInteger("0");

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger Y_EDEFAULT = new BigInteger("0");

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
		return KmlgxPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, KmlgxPackage.DOCUMENT_ROOT__MIXED);
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
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
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
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourPrimitive getAbstractTourPrimitive() {
		return (TourPrimitive)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractTourPrimitive(TourPrimitive newAbstractTourPrimitive, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE, newAbstractTourPrimitive, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractTourPrimitive(TourPrimitive newAbstractTourPrimitive) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE, newAbstractTourPrimitive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourPrimitive getAbstractTourPrimitiveGroup() {
		return (TourPrimitive)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractTourPrimitiveGroup(TourPrimitive newAbstractTourPrimitiveGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP, newAbstractTourPrimitiveGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAbstractTrackSimpleExtensionGroup() {
		return getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltitudeModeEnumType getAltitudeMode() {
		return (AltitudeModeEnumType)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ALTITUDE_MODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltitudeMode(AltitudeModeEnumType newAltitudeMode) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__ALTITUDE_MODE, newAltitudeMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAltitudeOffset() {
		return (Double)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ALTITUDE_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltitudeOffset(double newAltitudeOffset) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__ALTITUDE_OFFSET, newAltitudeOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAngles() {
		return (String)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ANGLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngles(String newAngles) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__ANGLES, newAngles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimatedUpdate getAnimatedUpdate() {
		return (AnimatedUpdate)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__ANIMATED_UPDATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnimatedUpdate(AnimatedUpdate newAnimatedUpdate, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__ANIMATED_UPDATE, newAnimatedUpdate, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnimatedUpdate(AnimatedUpdate newAnimatedUpdate) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__ANIMATED_UPDATE, newAnimatedUpdate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBalloonVisibility() {
		return (Boolean)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__BALLOON_VISIBILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalloonVisibility(boolean newBalloonVisibility) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__BALLOON_VISIBILITY, newBalloonVisibility);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoord() {
		return (String)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__COORD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoord(String newCoord) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__COORD, newCoord);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDelayedStart() {
		return (Double)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__DELAYED_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelayedStart(double newDelayedStart) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__DELAYED_START, newDelayedStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getDrawOrder() {
		return (BigInteger)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__DRAW_ORDER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawOrder(BigInteger newDrawOrder) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__DRAW_ORDER, newDrawOrder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return (Double)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlyTo getFlyTo() {
		return (FlyTo)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__FLY_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlyTo(FlyTo newFlyTo, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__FLY_TO, newFlyTo, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlyTo(FlyTo newFlyTo) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__FLY_TO, newFlyTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlyToModeEnumType getFlyToMode() {
		return (FlyToModeEnumType)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__FLY_TO_MODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlyToMode(FlyToModeEnumType newFlyToMode) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__FLY_TO_MODE, newFlyToMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getH() {
		return (BigInteger)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__H, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setH(BigInteger newH) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__H, newH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterpolate() {
		return (Boolean)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__INTERPOLATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpolate(boolean newInterpolate) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__INTERPOLATE, newInterpolate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatLonQuad getLatLonQuad() {
		return (LatLonQuad)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__LAT_LON_QUAD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLatLonQuad(LatLonQuad newLatLonQuad, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__LAT_LON_QUAD, newLatLonQuad, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatLonQuad(LatLonQuad newLatLonQuad) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__LAT_LON_QUAD, newLatLonQuad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiTrack getMultiTrack() {
		return (MultiTrack)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__MULTI_TRACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiTrack(MultiTrack newMultiTrack, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__MULTI_TRACK, newMultiTrack, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiTrack(MultiTrack newMultiTrack) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__MULTI_TRACK, newMultiTrack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option getOption() {
		return (Option)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOption(Option newOption, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__OPTION, newOption, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(Option newOption) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getOuterColor() {
		return (byte[])getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__OUTER_COLOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterColor(byte[] newOuterColor) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__OUTER_COLOR, newOuterColor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOuterWidth() {
		return (Float)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__OUTER_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterWidth(float newOuterWidth) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__OUTER_WIDTH, newOuterWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPhysicalWidth() {
		return (Float)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__PHYSICAL_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalWidth(float newPhysicalWidth) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__PHYSICAL_WIDTH, newPhysicalWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playlist getPlaylist() {
		return (Playlist)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__PLAYLIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlaylist(Playlist newPlaylist, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__PLAYLIST, newPlaylist, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaylist(Playlist newPlaylist) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__PLAYLIST, newPlaylist);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayModeEnumType getPlayMode() {
		return (PlayModeEnumType)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__PLAY_MODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayMode(PlayModeEnumType newPlayMode) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__PLAY_MODE, newPlayMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRank() {
		return (Double)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__RANK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRank(double newRank) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__RANK, newRank);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleArrayData getSimpleArrayData() {
		return (SimpleArrayData)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleArrayData(SimpleArrayData newSimpleArrayData, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA, newSimpleArrayData, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleArrayData(SimpleArrayData newSimpleArrayData) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA, newSimpleArrayData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSimpleArrayDataExtension() {
		return (EObject)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleArrayDataExtension(EObject newSimpleArrayDataExtension, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION, newSimpleArrayDataExtension, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleArrayField getSimpleArrayField() {
		return (SimpleArrayField)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleArrayField(SimpleArrayField newSimpleArrayField, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD, newSimpleArrayField, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleArrayField(SimpleArrayField newSimpleArrayField) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD, newSimpleArrayField);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSimpleArrayFieldExtension() {
		return (EObject)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleArrayFieldExtension(EObject newSimpleArrayFieldExtension, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION, newSimpleArrayFieldExtension, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoundCue getSoundCue() {
		return (SoundCue)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__SOUND_CUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSoundCue(SoundCue newSoundCue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__SOUND_CUE, newSoundCue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundCue(SoundCue newSoundCue) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__SOUND_CUE, newSoundCue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSpan getTimeSpan() {
		return (TimeSpan)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_SPAN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeSpan(TimeSpan newTimeSpan, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_SPAN, newTimeSpan, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSpan(TimeSpan newTimeSpan) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_SPAN, newTimeSpan);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeStamp getTimeStamp() {
		return (TimeStamp)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_STAMP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeStamp(TimeStamp newTimeStamp, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_STAMP, newTimeStamp, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStamp(TimeStamp newTimeStamp) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__TIME_STAMP, newTimeStamp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tour getTour() {
		return (Tour)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTour(Tour newTour, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR, newTour, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTour(Tour newTour) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR, newTour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourControl getTourControl() {
		return (TourControl)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR_CONTROL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTourControl(TourControl newTourControl, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR_CONTROL, newTourControl, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTourControl(TourControl newTourControl) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__TOUR_CONTROL, newTourControl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Track getTrack() {
		return (Track)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__TRACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrack(Track newTrack, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__TRACK, newTrack, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrack(Track newTrack) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__TRACK, newTrack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewerOptions getViewerOptions() {
		return (ViewerOptions)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__VIEWER_OPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewerOptions(ViewerOptions newViewerOptions, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__VIEWER_OPTIONS, newViewerOptions, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewerOptions(ViewerOptions newViewerOptions) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__VIEWER_OPTIONS, newViewerOptions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getW() {
		return (BigInteger)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__W, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW(BigInteger newW) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__W, newW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wait getWait() {
		return (Wait)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__WAIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWait(Wait newWait, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(KmlgxPackage.Literals.DOCUMENT_ROOT__WAIT, newWait, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWait(Wait newWait) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__WAIT, newWait);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getX() {
		return (BigInteger)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(BigInteger newX) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__X, newX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getY() {
		return (BigInteger)getMixed().get(KmlgxPackage.Literals.DOCUMENT_ROOT__Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(BigInteger newY) {
		((FeatureMap.Internal)getMixed()).set(KmlgxPackage.Literals.DOCUMENT_ROOT__Y, newY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE:
				return basicSetAbstractTourPrimitive(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return basicSetAbstractTourPrimitiveGroup(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__ANIMATED_UPDATE:
				return basicSetAnimatedUpdate(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO:
				return basicSetFlyTo(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__LAT_LON_QUAD:
				return basicSetLatLonQuad(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__MULTI_TRACK:
				return basicSetMultiTrack(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__OPTION:
				return basicSetOption(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__PLAYLIST:
				return basicSetPlaylist(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA:
				return basicSetSimpleArrayData(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION:
				return basicSetSimpleArrayDataExtension(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD:
				return basicSetSimpleArrayField(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION:
				return basicSetSimpleArrayFieldExtension(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__SOUND_CUE:
				return basicSetSoundCue(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__TIME_SPAN:
				return basicSetTimeSpan(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__TIME_STAMP:
				return basicSetTimeStamp(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__TOUR:
				return basicSetTour(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__TOUR_CONTROL:
				return basicSetTourControl(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__TRACK:
				return basicSetTrack(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__VIEWER_OPTIONS:
				return basicSetViewerOptions(null, msgs);
			case KmlgxPackage.DOCUMENT_ROOT__WAIT:
				return basicSetWait(null, msgs);
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
			case KmlgxPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE:
				return getAbstractTourPrimitive();
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return getAbstractTourPrimitiveGroup();
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP:
				return getAbstractTrackSimpleExtensionGroup();
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_MODE:
				return getAltitudeMode();
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_OFFSET:
				return getAltitudeOffset();
			case KmlgxPackage.DOCUMENT_ROOT__ANGLES:
				return getAngles();
			case KmlgxPackage.DOCUMENT_ROOT__ANIMATED_UPDATE:
				return getAnimatedUpdate();
			case KmlgxPackage.DOCUMENT_ROOT__BALLOON_VISIBILITY:
				return isBalloonVisibility();
			case KmlgxPackage.DOCUMENT_ROOT__COORD:
				return getCoord();
			case KmlgxPackage.DOCUMENT_ROOT__DELAYED_START:
				return getDelayedStart();
			case KmlgxPackage.DOCUMENT_ROOT__DRAW_ORDER:
				return getDrawOrder();
			case KmlgxPackage.DOCUMENT_ROOT__DURATION:
				return getDuration();
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO:
				return getFlyTo();
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO_MODE:
				return getFlyToMode();
			case KmlgxPackage.DOCUMENT_ROOT__H:
				return getH();
			case KmlgxPackage.DOCUMENT_ROOT__INTERPOLATE:
				return isInterpolate();
			case KmlgxPackage.DOCUMENT_ROOT__LAT_LON_QUAD:
				return getLatLonQuad();
			case KmlgxPackage.DOCUMENT_ROOT__MULTI_TRACK:
				return getMultiTrack();
			case KmlgxPackage.DOCUMENT_ROOT__OPTION:
				return getOption();
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_COLOR:
				return getOuterColor();
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_WIDTH:
				return getOuterWidth();
			case KmlgxPackage.DOCUMENT_ROOT__PHYSICAL_WIDTH:
				return getPhysicalWidth();
			case KmlgxPackage.DOCUMENT_ROOT__PLAYLIST:
				return getPlaylist();
			case KmlgxPackage.DOCUMENT_ROOT__PLAY_MODE:
				return getPlayMode();
			case KmlgxPackage.DOCUMENT_ROOT__RANK:
				return getRank();
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA:
				return getSimpleArrayData();
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION:
				return getSimpleArrayDataExtension();
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD:
				return getSimpleArrayField();
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION:
				return getSimpleArrayFieldExtension();
			case KmlgxPackage.DOCUMENT_ROOT__SOUND_CUE:
				return getSoundCue();
			case KmlgxPackage.DOCUMENT_ROOT__TIME_SPAN:
				return getTimeSpan();
			case KmlgxPackage.DOCUMENT_ROOT__TIME_STAMP:
				return getTimeStamp();
			case KmlgxPackage.DOCUMENT_ROOT__TOUR:
				return getTour();
			case KmlgxPackage.DOCUMENT_ROOT__TOUR_CONTROL:
				return getTourControl();
			case KmlgxPackage.DOCUMENT_ROOT__TRACK:
				return getTrack();
			case KmlgxPackage.DOCUMENT_ROOT__VALUE:
				return getValue();
			case KmlgxPackage.DOCUMENT_ROOT__VIEWER_OPTIONS:
				return getViewerOptions();
			case KmlgxPackage.DOCUMENT_ROOT__W:
				return getW();
			case KmlgxPackage.DOCUMENT_ROOT__WAIT:
				return getWait();
			case KmlgxPackage.DOCUMENT_ROOT__X:
				return getX();
			case KmlgxPackage.DOCUMENT_ROOT__Y:
				return getY();
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
			case KmlgxPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE:
				setAbstractTourPrimitive((TourPrimitive)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_MODE:
				setAltitudeMode((AltitudeModeEnumType)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_OFFSET:
				setAltitudeOffset((Double)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ANGLES:
				setAngles((String)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ANIMATED_UPDATE:
				setAnimatedUpdate((AnimatedUpdate)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__BALLOON_VISIBILITY:
				setBalloonVisibility((Boolean)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__COORD:
				setCoord((String)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DELAYED_START:
				setDelayedStart((Double)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DRAW_ORDER:
				setDrawOrder((BigInteger)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DURATION:
				setDuration((Double)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO:
				setFlyTo((FlyTo)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO_MODE:
				setFlyToMode((FlyToModeEnumType)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__H:
				setH((BigInteger)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__INTERPOLATE:
				setInterpolate((Boolean)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__LAT_LON_QUAD:
				setLatLonQuad((LatLonQuad)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__MULTI_TRACK:
				setMultiTrack((MultiTrack)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OPTION:
				setOption((Option)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_COLOR:
				setOuterColor((byte[])newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_WIDTH:
				setOuterWidth((Float)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PHYSICAL_WIDTH:
				setPhysicalWidth((Float)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PLAYLIST:
				setPlaylist((Playlist)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PLAY_MODE:
				setPlayMode((PlayModeEnumType)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__RANK:
				setRank((Double)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA:
				setSimpleArrayData((SimpleArrayData)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD:
				setSimpleArrayField((SimpleArrayField)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SOUND_CUE:
				setSoundCue((SoundCue)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_SPAN:
				setTimeSpan((TimeSpan)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_STAMP:
				setTimeStamp((TimeStamp)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR:
				setTour((Tour)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR_CONTROL:
				setTourControl((TourControl)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TRACK:
				setTrack((Track)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__VALUE:
				setValue((String)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__VIEWER_OPTIONS:
				setViewerOptions((ViewerOptions)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__W:
				setW((BigInteger)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__WAIT:
				setWait((Wait)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__X:
				setX((BigInteger)newValue);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__Y:
				setY((BigInteger)newValue);
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
			case KmlgxPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE:
				setAbstractTourPrimitive((TourPrimitive)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_MODE:
				setAltitudeMode(ALTITUDE_MODE_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_OFFSET:
				setAltitudeOffset(ALTITUDE_OFFSET_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ANGLES:
				setAngles(ANGLES_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__ANIMATED_UPDATE:
				setAnimatedUpdate((AnimatedUpdate)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__BALLOON_VISIBILITY:
				setBalloonVisibility(BALLOON_VISIBILITY_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__COORD:
				setCoord(COORD_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DELAYED_START:
				setDelayedStart(DELAYED_START_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DRAW_ORDER:
				setDrawOrder(DRAW_ORDER_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO:
				setFlyTo((FlyTo)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO_MODE:
				setFlyToMode(FLY_TO_MODE_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__H:
				setH(H_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__INTERPOLATE:
				setInterpolate(INTERPOLATE_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__LAT_LON_QUAD:
				setLatLonQuad((LatLonQuad)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__MULTI_TRACK:
				setMultiTrack((MultiTrack)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OPTION:
				setOption((Option)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_COLOR:
				setOuterColor(OUTER_COLOR_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_WIDTH:
				setOuterWidth(OUTER_WIDTH_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PHYSICAL_WIDTH:
				setPhysicalWidth(PHYSICAL_WIDTH_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PLAYLIST:
				setPlaylist((Playlist)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__PLAY_MODE:
				setPlayMode(PLAY_MODE_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__RANK:
				setRank(RANK_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA:
				setSimpleArrayData((SimpleArrayData)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD:
				setSimpleArrayField((SimpleArrayField)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__SOUND_CUE:
				setSoundCue((SoundCue)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_SPAN:
				setTimeSpan((TimeSpan)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_STAMP:
				setTimeStamp((TimeStamp)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR:
				setTour((Tour)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR_CONTROL:
				setTourControl((TourControl)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__TRACK:
				setTrack((Track)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__VIEWER_OPTIONS:
				setViewerOptions((ViewerOptions)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__W:
				setW(W_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__WAIT:
				setWait((Wait)null);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__X:
				setX(X_EDEFAULT);
				return;
			case KmlgxPackage.DOCUMENT_ROOT__Y:
				setY(Y_EDEFAULT);
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
			case KmlgxPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case KmlgxPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case KmlgxPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE:
				return getAbstractTourPrimitive() != null;
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP:
				return getAbstractTourPrimitiveGroup() != null;
			case KmlgxPackage.DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP:
				return ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_EDEFAULT == null ? getAbstractTrackSimpleExtensionGroup() != null : !ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_EDEFAULT.equals(getAbstractTrackSimpleExtensionGroup());
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_MODE:
				return getAltitudeMode() != ALTITUDE_MODE_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__ALTITUDE_OFFSET:
				return getAltitudeOffset() != ALTITUDE_OFFSET_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__ANGLES:
				return ANGLES_EDEFAULT == null ? getAngles() != null : !ANGLES_EDEFAULT.equals(getAngles());
			case KmlgxPackage.DOCUMENT_ROOT__ANIMATED_UPDATE:
				return getAnimatedUpdate() != null;
			case KmlgxPackage.DOCUMENT_ROOT__BALLOON_VISIBILITY:
				return isBalloonVisibility() != BALLOON_VISIBILITY_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__COORD:
				return COORD_EDEFAULT == null ? getCoord() != null : !COORD_EDEFAULT.equals(getCoord());
			case KmlgxPackage.DOCUMENT_ROOT__DELAYED_START:
				return getDelayedStart() != DELAYED_START_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__DRAW_ORDER:
				return DRAW_ORDER_EDEFAULT == null ? getDrawOrder() != null : !DRAW_ORDER_EDEFAULT.equals(getDrawOrder());
			case KmlgxPackage.DOCUMENT_ROOT__DURATION:
				return getDuration() != DURATION_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO:
				return getFlyTo() != null;
			case KmlgxPackage.DOCUMENT_ROOT__FLY_TO_MODE:
				return getFlyToMode() != FLY_TO_MODE_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__H:
				return H_EDEFAULT == null ? getH() != null : !H_EDEFAULT.equals(getH());
			case KmlgxPackage.DOCUMENT_ROOT__INTERPOLATE:
				return isInterpolate() != INTERPOLATE_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__LAT_LON_QUAD:
				return getLatLonQuad() != null;
			case KmlgxPackage.DOCUMENT_ROOT__MULTI_TRACK:
				return getMultiTrack() != null;
			case KmlgxPackage.DOCUMENT_ROOT__OPTION:
				return getOption() != null;
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_COLOR:
				return OUTER_COLOR_EDEFAULT == null ? getOuterColor() != null : !OUTER_COLOR_EDEFAULT.equals(getOuterColor());
			case KmlgxPackage.DOCUMENT_ROOT__OUTER_WIDTH:
				return getOuterWidth() != OUTER_WIDTH_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__PHYSICAL_WIDTH:
				return getPhysicalWidth() != PHYSICAL_WIDTH_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__PLAYLIST:
				return getPlaylist() != null;
			case KmlgxPackage.DOCUMENT_ROOT__PLAY_MODE:
				return getPlayMode() != PLAY_MODE_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__RANK:
				return getRank() != RANK_EDEFAULT;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA:
				return getSimpleArrayData() != null;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION:
				return getSimpleArrayDataExtension() != null;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD:
				return getSimpleArrayField() != null;
			case KmlgxPackage.DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION:
				return getSimpleArrayFieldExtension() != null;
			case KmlgxPackage.DOCUMENT_ROOT__SOUND_CUE:
				return getSoundCue() != null;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_SPAN:
				return getTimeSpan() != null;
			case KmlgxPackage.DOCUMENT_ROOT__TIME_STAMP:
				return getTimeStamp() != null;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR:
				return getTour() != null;
			case KmlgxPackage.DOCUMENT_ROOT__TOUR_CONTROL:
				return getTourControl() != null;
			case KmlgxPackage.DOCUMENT_ROOT__TRACK:
				return getTrack() != null;
			case KmlgxPackage.DOCUMENT_ROOT__VALUE:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
			case KmlgxPackage.DOCUMENT_ROOT__VIEWER_OPTIONS:
				return getViewerOptions() != null;
			case KmlgxPackage.DOCUMENT_ROOT__W:
				return W_EDEFAULT == null ? getW() != null : !W_EDEFAULT.equals(getW());
			case KmlgxPackage.DOCUMENT_ROOT__WAIT:
				return getWait() != null;
			case KmlgxPackage.DOCUMENT_ROOT__X:
				return X_EDEFAULT == null ? getX() != null : !X_EDEFAULT.equals(getX());
			case KmlgxPackage.DOCUMENT_ROOT__Y:
				return Y_EDEFAULT == null ? getY() != null : !Y_EDEFAULT.equals(getY());
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
