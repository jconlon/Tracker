/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.util;

import com.verticon.google.kmlgx.*;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

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

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.verticon.google.kmlgx.KmlgxPackage
 * @generated
 */
public class KmlgxValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final KmlgxValidator INSTANCE = new KmlgxValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.verticon.google.kmlgx";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlgxValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return KmlgxPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case KmlgxPackage.ANIMATED_UPDATE:
				return validateAnimatedUpdate((AnimatedUpdate)value, diagnostics, context);
			case KmlgxPackage.DOCUMENT_ROOT:
				return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
			case KmlgxPackage.FLY_TO:
				return validateFlyTo((FlyTo)value, diagnostics, context);
			case KmlgxPackage.LAT_LON_QUAD:
				return validateLatLonQuad((LatLonQuad)value, diagnostics, context);
			case KmlgxPackage.MULTI_TRACK:
				return validateMultiTrack((MultiTrack)value, diagnostics, context);
			case KmlgxPackage.OPTION:
				return validateOption((Option)value, diagnostics, context);
			case KmlgxPackage.PLAYLIST:
				return validatePlaylist((Playlist)value, diagnostics, context);
			case KmlgxPackage.SIMPLE_ARRAY_DATA:
				return validateSimpleArrayData((SimpleArrayData)value, diagnostics, context);
			case KmlgxPackage.SIMPLE_ARRAY_FIELD:
				return validateSimpleArrayField((SimpleArrayField)value, diagnostics, context);
			case KmlgxPackage.SOUND_CUE:
				return validateSoundCue((SoundCue)value, diagnostics, context);
			case KmlgxPackage.TOUR:
				return validateTour((Tour)value, diagnostics, context);
			case KmlgxPackage.TOUR_CONTROL:
				return validateTourControl((TourControl)value, diagnostics, context);
			case KmlgxPackage.TOUR_PRIMITIVE:
				return validateTourPrimitive((TourPrimitive)value, diagnostics, context);
			case KmlgxPackage.TRACK:
				return validateTrack((Track)value, diagnostics, context);
			case KmlgxPackage.VIEWER_OPTIONS:
				return validateViewerOptions((ViewerOptions)value, diagnostics, context);
			case KmlgxPackage.WAIT:
				return validateWait((Wait)value, diagnostics, context);
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE:
				return validateAltitudeModeEnumType((AltitudeModeEnumType)value, diagnostics, context);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE:
				return validateFlyToModeEnumType((FlyToModeEnumType)value, diagnostics, context);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE:
				return validatePlayModeEnumType((PlayModeEnumType)value, diagnostics, context);
			case KmlgxPackage.ALTITUDE_MODE_ENUM_TYPE_OBJECT:
				return validateAltitudeModeEnumTypeObject((AltitudeModeEnumType)value, diagnostics, context);
			case KmlgxPackage.FLY_TO_MODE_ENUM_TYPE_OBJECT:
				return validateFlyToModeEnumTypeObject((FlyToModeEnumType)value, diagnostics, context);
			case KmlgxPackage.OUTER_WIDTH_TYPE:
				return validateOuterWidthType((Float)value, diagnostics, context);
			case KmlgxPackage.OUTER_WIDTH_TYPE_OBJECT:
				return validateOuterWidthTypeObject((Float)value, diagnostics, context);
			case KmlgxPackage.PLAY_MODE_ENUM_TYPE_OBJECT:
				return validatePlayModeEnumTypeObject((PlayModeEnumType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnimatedUpdate(AnimatedUpdate animatedUpdate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(animatedUpdate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlyTo(FlyTo flyTo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(flyTo, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatLonQuad(LatLonQuad latLonQuad, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(latLonQuad, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiTrack(MultiTrack multiTrack, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiTrack, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(option, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlaylist(Playlist playlist, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(playlist, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleArrayData(SimpleArrayData simpleArrayData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(simpleArrayData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleArrayField(SimpleArrayField simpleArrayField, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(simpleArrayField, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSoundCue(SoundCue soundCue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(soundCue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTour(Tour tour, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tour, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTourControl(TourControl tourControl, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tourControl, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTourPrimitive(TourPrimitive tourPrimitive, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tourPrimitive, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrack(Track track, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(track, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateViewerOptions(ViewerOptions viewerOptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(viewerOptions, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWait(Wait wait, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(wait, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAltitudeModeEnumType(AltitudeModeEnumType altitudeModeEnumType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlyToModeEnumType(FlyToModeEnumType flyToModeEnumType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayModeEnumType(PlayModeEnumType playModeEnumType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAltitudeModeEnumTypeObject(AltitudeModeEnumType altitudeModeEnumTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlyToModeEnumTypeObject(FlyToModeEnumType flyToModeEnumTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOuterWidthType(float outerWidthType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateOuterWidthType_Min(outerWidthType, diagnostics, context);
		if (result || diagnostics != null) result &= validateOuterWidthType_Max(outerWidthType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateOuterWidthType_Min
	 */
	public static final float OUTER_WIDTH_TYPE__MIN__VALUE = 0.0F;

	/**
	 * Validates the Min constraint of '<em>Outer Width Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOuterWidthType_Min(float outerWidthType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = outerWidthType >= OUTER_WIDTH_TYPE__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(KmlgxPackage.Literals.OUTER_WIDTH_TYPE, outerWidthType, OUTER_WIDTH_TYPE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateOuterWidthType_Max
	 */
	public static final float OUTER_WIDTH_TYPE__MAX__VALUE = 1.0F;

	/**
	 * Validates the Max constraint of '<em>Outer Width Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOuterWidthType_Max(float outerWidthType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = outerWidthType <= OUTER_WIDTH_TYPE__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(KmlgxPackage.Literals.OUTER_WIDTH_TYPE, outerWidthType, OUTER_WIDTH_TYPE__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOuterWidthTypeObject(Float outerWidthTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateOuterWidthType_Min(outerWidthTypeObject, diagnostics, context);
		if (result || diagnostics != null) result &= validateOuterWidthType_Max(outerWidthTypeObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlayModeEnumTypeObject(PlayModeEnumType playModeEnumTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //KmlgxValidator
