/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import com.verticon.google.kmlgx.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.verticon.google.kmlgx.AltitudeModeEnumType;
import com.verticon.google.kmlgx.AnimatedUpdate;
import com.verticon.google.kmlgx.DocumentRoot;
import com.verticon.google.kmlgx.FlyTo;
import com.verticon.google.kmlgx.FlyToModeEnumType;
import com.verticon.google.kmlgx.KmlgxFactory;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KmlgxFactoryImpl extends EFactoryImpl implements KmlgxFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KmlgxFactory init() {
		try {
			KmlgxFactory theKmlgxFactory = (KmlgxFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.google.com/kml/ext/2.2"); 
			if (theKmlgxFactory != null) {
				return theKmlgxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KmlgxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlgxFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case KmlgxPackage.ANIMATED_UPDATE: return createAnimatedUpdate();
			case KmlgxPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case KmlgxPackage.FLY_TO: return createFlyTo();
			case KmlgxPackage.LAT_LON_QUAD: return createLatLonQuad();
			case KmlgxPackage.MULTI_TRACK: return createMultiTrack();
			case KmlgxPackage.OPTION: return createOption();
			case KmlgxPackage.PLAYLIST: return createPlaylist();
			case KmlgxPackage.SIMPLE_ARRAY_DATA: return createSimpleArrayData();
			case KmlgxPackage.SIMPLE_ARRAY_FIELD: return createSimpleArrayField();
			case KmlgxPackage.SOUND_CUE: return createSoundCue();
			case KmlgxPackage.TOUR: return createTour();
			case KmlgxPackage.TOUR_CONTROL: return createTourControl();
			case KmlgxPackage.TOUR_PRIMITIVE: return createTourPrimitive();
			case KmlgxPackage.TRACK: return createTrack();
			case KmlgxPackage.VIEWER_OPTIONS: return createViewerOptions();
			case KmlgxPackage.WAIT: return createWait();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE:
				return createAltitudeModeEnumTypeFromString(eDataType, initialValue);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE:
				return createFlyToModeEnumTypeFromString(eDataType, initialValue);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE:
				return createPlayModeEnumTypeFromString(eDataType, initialValue);
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE_OBJECT:
				return createAltitudeModeEnumTypeObjectFromString(eDataType, initialValue);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE_OBJECT:
				return createFlyToModeEnumTypeObjectFromString(eDataType, initialValue);
			case KmlgxPackage.OUTER_WIDTH_TYPE:
				return createOuterWidthTypeFromString(eDataType, initialValue);
			case KmlgxPackage.OUTER_WIDTH_TYPE_OBJECT:
				return createOuterWidthTypeObjectFromString(eDataType, initialValue);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE_OBJECT:
				return createPlayModeEnumTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE:
				return convertAltitudeModeEnumTypeToString(eDataType, instanceValue);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE:
				return convertFlyToModeEnumTypeToString(eDataType, instanceValue);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE:
				return convertPlayModeEnumTypeToString(eDataType, instanceValue);
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE_OBJECT:
				return convertAltitudeModeEnumTypeObjectToString(eDataType, instanceValue);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE_OBJECT:
				return convertFlyToModeEnumTypeObjectToString(eDataType, instanceValue);
			case KmlgxPackage.OUTER_WIDTH_TYPE:
				return convertOuterWidthTypeToString(eDataType, instanceValue);
			case KmlgxPackage.OUTER_WIDTH_TYPE_OBJECT:
				return convertOuterWidthTypeObjectToString(eDataType, instanceValue);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE_OBJECT:
				return convertPlayModeEnumTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimatedUpdate createAnimatedUpdate() {
		AnimatedUpdateImpl animatedUpdate = new AnimatedUpdateImpl();
		return animatedUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlyTo createFlyTo() {
		FlyToImpl flyTo = new FlyToImpl();
		return flyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatLonQuad createLatLonQuad() {
		LatLonQuadImpl latLonQuad = new LatLonQuadImpl();
		return latLonQuad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiTrack createMultiTrack() {
		MultiTrackImpl multiTrack = new MultiTrackImpl();
		return multiTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option createOption() {
		OptionImpl option = new OptionImpl();
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playlist createPlaylist() {
		PlaylistImpl playlist = new PlaylistImpl();
		return playlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleArrayData createSimpleArrayData() {
		SimpleArrayDataImpl simpleArrayData = new SimpleArrayDataImpl();
		return simpleArrayData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleArrayField createSimpleArrayField() {
		SimpleArrayFieldImpl simpleArrayField = new SimpleArrayFieldImpl();
		return simpleArrayField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoundCue createSoundCue() {
		SoundCueImpl soundCue = new SoundCueImpl();
		return soundCue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tour createTour() {
		TourImpl tour = new TourImpl();
		return tour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourControl createTourControl() {
		TourControlImpl tourControl = new TourControlImpl();
		return tourControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TourPrimitive createTourPrimitive() {
		TourPrimitiveImpl tourPrimitive = new TourPrimitiveImpl();
		return tourPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Track createTrack() {
		TrackImpl track = new TrackImpl();
		return track;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewerOptions createViewerOptions() {
		ViewerOptionsImpl viewerOptions = new ViewerOptionsImpl();
		return viewerOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wait createWait() {
		WaitImpl wait = new WaitImpl();
		return wait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltitudeModeEnumType createAltitudeModeEnumTypeFromString(EDataType eDataType, String initialValue) {
		AltitudeModeEnumType result = AltitudeModeEnumType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAltitudeModeEnumTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlyToModeEnumType createFlyToModeEnumTypeFromString(EDataType eDataType, String initialValue) {
		FlyToModeEnumType result = FlyToModeEnumType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlyToModeEnumTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayModeEnumType createPlayModeEnumTypeFromString(EDataType eDataType, String initialValue) {
		PlayModeEnumType result = PlayModeEnumType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlayModeEnumTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltitudeModeEnumType createAltitudeModeEnumTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createAltitudeModeEnumTypeFromString(KmlgxPackage.Literals.ALTITUDE_MODE_ENUM_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAltitudeModeEnumTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAltitudeModeEnumTypeToString(KmlgxPackage.Literals.ALTITUDE_MODE_ENUM_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlyToModeEnumType createFlyToModeEnumTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createFlyToModeEnumTypeFromString(KmlgxPackage.Literals.FLY_TO_MODE_ENUM_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlyToModeEnumTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertFlyToModeEnumTypeToString(KmlgxPackage.Literals.FLY_TO_MODE_ENUM_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float createOuterWidthTypeFromString(EDataType eDataType, String initialValue) {
		return (Float)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.FLOAT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOuterWidthTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.FLOAT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float createOuterWidthTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createOuterWidthTypeFromString(KmlgxPackage.Literals.OUTER_WIDTH_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOuterWidthTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertOuterWidthTypeToString(KmlgxPackage.Literals.OUTER_WIDTH_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayModeEnumType createPlayModeEnumTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createPlayModeEnumTypeFromString(KmlgxPackage.Literals.PLAY_MODE_ENUM_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlayModeEnumTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPlayModeEnumTypeToString(KmlgxPackage.Literals.PLAY_MODE_ENUM_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlgxPackage getKmlgxPackage() {
		return (KmlgxPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KmlgxPackage getPackage() {
		return KmlgxPackage.eINSTANCE;
	}

} //KmlgxFactoryImpl
