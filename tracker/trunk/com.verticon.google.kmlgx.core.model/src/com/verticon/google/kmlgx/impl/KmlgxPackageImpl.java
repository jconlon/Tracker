/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
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
import com.verticon.google.kmlgx.util.KmlgxValidator;
import com.verticon.opengis.kml.KmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KmlgxPackageImpl extends EPackageImpl implements KmlgxPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animatedUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flyToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latLonQuadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playlistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleArrayDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleArrayFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soundCueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tourControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tourPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewerOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum altitudeModeEnumTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum flyToModeEnumTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum playModeEnumTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType altitudeModeEnumTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType flyToModeEnumTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType outerWidthTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType outerWidthTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType playModeEnumTypeObjectEDataType = null;

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
	 * @see com.verticon.google.kmlgx.KmlgxPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KmlgxPackageImpl() {
		super(eNS_URI, KmlgxFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link KmlgxPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static KmlgxPackage init() {
		if (isInited) return (KmlgxPackage)EPackage.Registry.INSTANCE.getEPackage(KmlgxPackage.eNS_URI);

		// Obtain or create and register package
		KmlgxPackageImpl theKmlgxPackage = (KmlgxPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof KmlgxPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new KmlgxPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		KmlPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theKmlgxPackage.createPackageContents();

		// Initialize created meta-data
		theKmlgxPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theKmlgxPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return KmlgxValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theKmlgxPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KmlgxPackage.eNS_URI, theKmlgxPackage);
		return theKmlgxPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimatedUpdate() {
		return animatedUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimatedUpdate_Duration() {
		return (EAttribute)animatedUpdateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimatedUpdate_Update() {
		return (EReference)animatedUpdateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimatedUpdate_DelayedStart() {
		return (EAttribute)animatedUpdateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AbstractTourPrimitive() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AbstractTourPrimitiveGroup() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_AbstractTrackSimpleExtensionGroup() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_AltitudeMode() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_AltitudeOffset() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Angles() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AnimatedUpdate() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_BalloonVisibility() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Coord() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_DelayedStart() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_DrawOrder() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Duration() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FlyTo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_FlyToMode() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_H() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Interpolate() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LatLonQuad() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MultiTrack() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Option() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_OuterColor() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_OuterWidth() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_PhysicalWidth() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Playlist() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_PlayMode() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Rank() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SimpleArrayData() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SimpleArrayDataExtension() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SimpleArrayField() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SimpleArrayFieldExtension() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SoundCue() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TimeSpan() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TimeStamp() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Tour() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TourControl() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Track() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Value() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ViewerOptions() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_W() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Wait() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_X() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Y() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlyTo() {
		return flyToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlyTo_Duration() {
		return (EAttribute)flyToEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlyTo_FlyToMode() {
		return (EAttribute)flyToEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlyTo_AbstractViewGroupGroup() {
		return (EAttribute)flyToEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlyTo_AbstractViewGroup() {
		return (EReference)flyToEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatLonQuad() {
		return latLonQuadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatLonQuad_Coordinates() {
		return (EAttribute)latLonQuadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiTrack() {
		return multiTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTrack_AltitudeModeGroupGroup() {
		return (EAttribute)multiTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiTrack_AltitudeModeGroup() {
		return (EReference)multiTrackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTrack_Interpolate() {
		return (EAttribute)multiTrackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiTrack_Track() {
		return (EReference)multiTrackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOption() {
		return optionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Enabled() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Name() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaylist() {
		return playlistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlaylist_AbstractTourPrimitiveGroupGroup() {
		return (EAttribute)playlistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlaylist_AbstractTourPrimitiveGroup() {
		return (EReference)playlistEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleArrayData() {
		return simpleArrayDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayData_Value() {
		return (EAttribute)simpleArrayDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayData_SimpleArrayDataExtensionGroup() {
		return (EAttribute)simpleArrayDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleArrayData_SimpleArrayDataExtension() {
		return (EReference)simpleArrayDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayData_Name() {
		return (EAttribute)simpleArrayDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleArrayField() {
		return simpleArrayFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayField_DisplayName() {
		return (EAttribute)simpleArrayFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayField_SimpleArrayFieldExtensionGroup() {
		return (EAttribute)simpleArrayFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleArrayField_SimpleArrayFieldExtension() {
		return (EReference)simpleArrayFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayField_Name() {
		return (EAttribute)simpleArrayFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleArrayField_Type() {
		return (EAttribute)simpleArrayFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoundCue() {
		return soundCueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoundCue_Href() {
		return (EAttribute)soundCueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoundCue_DelayedStart() {
		return (EAttribute)soundCueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTour() {
		return tourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTour_Playlist() {
		return (EReference)tourEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTourControl() {
		return tourControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTourControl_PlayMode() {
		return (EAttribute)tourControlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTourPrimitive() {
		return tourPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrack() {
		return trackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_Extrude() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_Tessellate() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_AltitudeModeGroupGroup() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrack_AltitudeModeGroup() {
		return (EReference)trackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_When() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_Coord() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_Angles() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrack_Model() {
		return (EReference)trackEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrack_ExtendedData() {
		return (EReference)trackEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_AbstractTrackSimpleExtensionGroupGroup() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrack_AbstractTrackSimpleExtensionGroup() {
		return (EAttribute)trackEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewerOptions() {
		return viewerOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewerOptions_Option() {
		return (EReference)viewerOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWait() {
		return waitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWait_Duration() {
		return (EAttribute)waitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAltitudeModeEnumType() {
		return altitudeModeEnumTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFlyToModeEnumType() {
		return flyToModeEnumTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPlayModeEnumType() {
		return playModeEnumTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAltitudeModeEnumTypeObject() {
		return altitudeModeEnumTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFlyToModeEnumTypeObject() {
		return flyToModeEnumTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOuterWidthType() {
		return outerWidthTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOuterWidthTypeObject() {
		return outerWidthTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPlayModeEnumTypeObject() {
		return playModeEnumTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KmlgxFactory getKmlgxFactory() {
		return (KmlgxFactory)getEFactoryInstance();
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
		animatedUpdateEClass = createEClass(ANIMATED_UPDATE);
		createEAttribute(animatedUpdateEClass, ANIMATED_UPDATE__DURATION);
		createEReference(animatedUpdateEClass, ANIMATED_UPDATE__UPDATE);
		createEAttribute(animatedUpdateEClass, ANIMATED_UPDATE__DELAYED_START);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ALTITUDE_MODE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ALTITUDE_OFFSET);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ANGLES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ANIMATED_UPDATE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__BALLOON_VISIBILITY);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__COORD);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__DELAYED_START);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__DRAW_ORDER);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__DURATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FLY_TO);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__FLY_TO_MODE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__H);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__INTERPOLATE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LAT_LON_QUAD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MULTI_TRACK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OPTION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__OUTER_COLOR);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__OUTER_WIDTH);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__PHYSICAL_WIDTH);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PLAYLIST);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__PLAY_MODE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__RANK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIMPLE_ARRAY_DATA);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SOUND_CUE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TIME_SPAN);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TIME_STAMP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TOUR);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TOUR_CONTROL);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TRACK);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__VALUE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__VIEWER_OPTIONS);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__W);
		createEReference(documentRootEClass, DOCUMENT_ROOT__WAIT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__X);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__Y);

		flyToEClass = createEClass(FLY_TO);
		createEAttribute(flyToEClass, FLY_TO__DURATION);
		createEAttribute(flyToEClass, FLY_TO__FLY_TO_MODE);
		createEAttribute(flyToEClass, FLY_TO__ABSTRACT_VIEW_GROUP_GROUP);
		createEReference(flyToEClass, FLY_TO__ABSTRACT_VIEW_GROUP);

		latLonQuadEClass = createEClass(LAT_LON_QUAD);
		createEAttribute(latLonQuadEClass, LAT_LON_QUAD__COORDINATES);

		multiTrackEClass = createEClass(MULTI_TRACK);
		createEAttribute(multiTrackEClass, MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP);
		createEReference(multiTrackEClass, MULTI_TRACK__ALTITUDE_MODE_GROUP);
		createEAttribute(multiTrackEClass, MULTI_TRACK__INTERPOLATE);
		createEReference(multiTrackEClass, MULTI_TRACK__TRACK);

		optionEClass = createEClass(OPTION);
		createEAttribute(optionEClass, OPTION__ENABLED);
		createEAttribute(optionEClass, OPTION__NAME);

		playlistEClass = createEClass(PLAYLIST);
		createEAttribute(playlistEClass, PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP);
		createEReference(playlistEClass, PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP);

		simpleArrayDataEClass = createEClass(SIMPLE_ARRAY_DATA);
		createEAttribute(simpleArrayDataEClass, SIMPLE_ARRAY_DATA__VALUE);
		createEAttribute(simpleArrayDataEClass, SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP);
		createEReference(simpleArrayDataEClass, SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION);
		createEAttribute(simpleArrayDataEClass, SIMPLE_ARRAY_DATA__NAME);

		simpleArrayFieldEClass = createEClass(SIMPLE_ARRAY_FIELD);
		createEAttribute(simpleArrayFieldEClass, SIMPLE_ARRAY_FIELD__DISPLAY_NAME);
		createEAttribute(simpleArrayFieldEClass, SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP);
		createEReference(simpleArrayFieldEClass, SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION);
		createEAttribute(simpleArrayFieldEClass, SIMPLE_ARRAY_FIELD__NAME);
		createEAttribute(simpleArrayFieldEClass, SIMPLE_ARRAY_FIELD__TYPE);

		soundCueEClass = createEClass(SOUND_CUE);
		createEAttribute(soundCueEClass, SOUND_CUE__HREF);
		createEAttribute(soundCueEClass, SOUND_CUE__DELAYED_START);

		tourEClass = createEClass(TOUR);
		createEReference(tourEClass, TOUR__PLAYLIST);

		tourControlEClass = createEClass(TOUR_CONTROL);
		createEAttribute(tourControlEClass, TOUR_CONTROL__PLAY_MODE);

		tourPrimitiveEClass = createEClass(TOUR_PRIMITIVE);

		trackEClass = createEClass(TRACK);
		createEAttribute(trackEClass, TRACK__EXTRUDE);
		createEAttribute(trackEClass, TRACK__TESSELLATE);
		createEAttribute(trackEClass, TRACK__ALTITUDE_MODE_GROUP_GROUP);
		createEReference(trackEClass, TRACK__ALTITUDE_MODE_GROUP);
		createEAttribute(trackEClass, TRACK__WHEN);
		createEAttribute(trackEClass, TRACK__COORD);
		createEAttribute(trackEClass, TRACK__ANGLES);
		createEReference(trackEClass, TRACK__MODEL);
		createEReference(trackEClass, TRACK__EXTENDED_DATA);
		createEAttribute(trackEClass, TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP);
		createEAttribute(trackEClass, TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP);

		viewerOptionsEClass = createEClass(VIEWER_OPTIONS);
		createEReference(viewerOptionsEClass, VIEWER_OPTIONS__OPTION);

		waitEClass = createEClass(WAIT);
		createEAttribute(waitEClass, WAIT__DURATION);

		// Create enums
		altitudeModeEnumTypeEEnum = createEEnum(ALTITUDE_MODE_ENUM_TYPE);
		flyToModeEnumTypeEEnum = createEEnum(FLY_TO_MODE_ENUM_TYPE);
		playModeEnumTypeEEnum = createEEnum(PLAY_MODE_ENUM_TYPE);

		// Create data types
		altitudeModeEnumTypeObjectEDataType = createEDataType(ALTITUDE_MODE_ENUM_TYPE_OBJECT);
		flyToModeEnumTypeObjectEDataType = createEDataType(FLY_TO_MODE_ENUM_TYPE_OBJECT);
		outerWidthTypeEDataType = createEDataType(OUTER_WIDTH_TYPE);
		outerWidthTypeObjectEDataType = createEDataType(OUTER_WIDTH_TYPE_OBJECT);
		playModeEnumTypeObjectEDataType = createEDataType(PLAY_MODE_ENUM_TYPE_OBJECT);
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
		KmlPackage theKmlPackage = (KmlPackage)EPackage.Registry.INSTANCE.getEPackage(KmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		animatedUpdateEClass.getESuperTypes().add(this.getTourPrimitive());
		flyToEClass.getESuperTypes().add(this.getTourPrimitive());
		latLonQuadEClass.getESuperTypes().add(theKmlPackage.getAbstractObject());
		multiTrackEClass.getESuperTypes().add(theKmlPackage.getGeometry());
		playlistEClass.getESuperTypes().add(theKmlPackage.getAbstractObject());
		simpleArrayDataEClass.getESuperTypes().add(theKmlPackage.getAbstractObject());
		soundCueEClass.getESuperTypes().add(this.getTourPrimitive());
		tourEClass.getESuperTypes().add(theKmlPackage.getFeature());
		tourControlEClass.getESuperTypes().add(this.getTourPrimitive());
		tourPrimitiveEClass.getESuperTypes().add(theKmlPackage.getAbstractObject());
		trackEClass.getESuperTypes().add(theKmlPackage.getGeometry());
		viewerOptionsEClass.getESuperTypes().add(theKmlPackage.getAbstractObject());
		waitEClass.getESuperTypes().add(this.getTourPrimitive());

		// Initialize classes and features; add operations and parameters
		initEClass(animatedUpdateEClass, AnimatedUpdate.class, "AnimatedUpdate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnimatedUpdate_Duration(), theXMLTypePackage.getDouble(), "duration", "0.0", 0, 1, AnimatedUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnimatedUpdate_Update(), theKmlPackage.getUpdate(), null, "update", null, 0, 1, AnimatedUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimatedUpdate_DelayedStart(), theXMLTypePackage.getDouble(), "delayedStart", "0.0", 0, 1, AnimatedUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AbstractTourPrimitive(), this.getTourPrimitive(), null, "abstractTourPrimitive", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AbstractTourPrimitiveGroup(), this.getTourPrimitive(), null, "abstractTourPrimitiveGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_AbstractTrackSimpleExtensionGroup(), theXMLTypePackage.getAnySimpleType(), "abstractTrackSimpleExtensionGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_AltitudeMode(), this.getAltitudeModeEnumType(), "altitudeMode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_AltitudeOffset(), theXMLTypePackage.getDouble(), "altitudeOffset", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Angles(), theXMLTypePackage.getString(), "angles", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AnimatedUpdate(), this.getAnimatedUpdate(), null, "animatedUpdate", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_BalloonVisibility(), theXMLTypePackage.getBoolean(), "balloonVisibility", "true", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Coord(), theXMLTypePackage.getString(), "coord", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_DelayedStart(), theXMLTypePackage.getDouble(), "delayedStart", "0.0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_DrawOrder(), theXMLTypePackage.getInteger(), "drawOrder", "0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Duration(), theXMLTypePackage.getDouble(), "duration", "0.0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FlyTo(), this.getFlyTo(), null, "flyTo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_FlyToMode(), this.getFlyToModeEnumType(), "flyToMode", "bounce", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_H(), theXMLTypePackage.getInteger(), "h", "-1", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Interpolate(), theXMLTypePackage.getBoolean(), "interpolate", "false", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LatLonQuad(), this.getLatLonQuad(), null, "latLonQuad", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MultiTrack(), this.getMultiTrack(), null, "multiTrack", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Option(), this.getOption(), null, "option", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_OuterColor(), theKmlPackage.getColorType(), "outerColor", "ffffffff", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_OuterWidth(), this.getOuterWidthType(), "outerWidth", "0.0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_PhysicalWidth(), theXMLTypePackage.getFloat(), "physicalWidth", "0.0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Playlist(), this.getPlaylist(), null, "playlist", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_PlayMode(), this.getPlayModeEnumType(), "playMode", "pause", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Rank(), theXMLTypePackage.getDouble(), "rank", "0.0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SimpleArrayData(), this.getSimpleArrayData(), null, "simpleArrayData", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SimpleArrayDataExtension(), ecorePackage.getEObject(), null, "simpleArrayDataExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SimpleArrayField(), this.getSimpleArrayField(), null, "simpleArrayField", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SimpleArrayFieldExtension(), ecorePackage.getEObject(), null, "simpleArrayFieldExtension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SoundCue(), this.getSoundCue(), null, "soundCue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TimeSpan(), theKmlPackage.getTimeSpan(), null, "timeSpan", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TimeStamp(), theKmlPackage.getTimeStamp(), null, "timeStamp", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Tour(), this.getTour(), null, "tour", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TourControl(), this.getTourControl(), null, "tourControl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Track(), this.getTrack(), null, "track", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Value(), theXMLTypePackage.getString(), "value", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ViewerOptions(), this.getViewerOptions(), null, "viewerOptions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_W(), theXMLTypePackage.getInteger(), "w", "-1", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Wait(), this.getWait(), null, "wait", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_X(), theXMLTypePackage.getInteger(), "x", "0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Y(), theXMLTypePackage.getInteger(), "y", "0", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(flyToEClass, FlyTo.class, "FlyTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFlyTo_Duration(), theXMLTypePackage.getDouble(), "duration", "0.0", 0, 1, FlyTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlyTo_FlyToMode(), this.getFlyToModeEnumType(), "flyToMode", "bounce", 0, 1, FlyTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlyTo_AbstractViewGroupGroup(), ecorePackage.getEFeatureMapEntry(), "abstractViewGroupGroup", null, 0, 1, FlyTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlyTo_AbstractViewGroup(), theKmlPackage.getAbstractView(), null, "abstractViewGroup", null, 0, 1, FlyTo.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(latLonQuadEClass, LatLonQuad.class, "LatLonQuad", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLatLonQuad_Coordinates(), theKmlPackage.getCoordinatesType(), "coordinates", null, 0, 1, LatLonQuad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiTrackEClass, MultiTrack.class, "MultiTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiTrack_AltitudeModeGroupGroup(), ecorePackage.getEFeatureMapEntry(), "altitudeModeGroupGroup", null, 0, 1, MultiTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiTrack_AltitudeModeGroup(), ecorePackage.getEObject(), null, "altitudeModeGroup", null, 0, 1, MultiTrack.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiTrack_Interpolate(), theXMLTypePackage.getBoolean(), "interpolate", "false", 0, 1, MultiTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiTrack_Track(), this.getTrack(), null, "track", null, 0, -1, MultiTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOption_Enabled(), theXMLTypePackage.getBoolean(), "enabled", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playlistEClass, Playlist.class, "Playlist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaylist_AbstractTourPrimitiveGroupGroup(), ecorePackage.getEFeatureMapEntry(), "abstractTourPrimitiveGroupGroup", null, 0, -1, Playlist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlaylist_AbstractTourPrimitiveGroup(), this.getTourPrimitive(), null, "abstractTourPrimitiveGroup", null, 0, -1, Playlist.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(simpleArrayDataEClass, SimpleArrayData.class, "SimpleArrayData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleArrayData_Value(), theXMLTypePackage.getString(), "value", null, 0, -1, SimpleArrayData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleArrayData_SimpleArrayDataExtensionGroup(), ecorePackage.getEFeatureMapEntry(), "simpleArrayDataExtensionGroup", null, 0, -1, SimpleArrayData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleArrayData_SimpleArrayDataExtension(), ecorePackage.getEObject(), null, "simpleArrayDataExtension", null, 0, -1, SimpleArrayData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleArrayData_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, SimpleArrayData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleArrayFieldEClass, SimpleArrayField.class, "SimpleArrayField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleArrayField_DisplayName(), theXMLTypePackage.getString(), "displayName", null, 0, 1, SimpleArrayField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleArrayField_SimpleArrayFieldExtensionGroup(), ecorePackage.getEFeatureMapEntry(), "simpleArrayFieldExtensionGroup", null, 0, -1, SimpleArrayField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleArrayField_SimpleArrayFieldExtension(), ecorePackage.getEObject(), null, "simpleArrayFieldExtension", null, 0, -1, SimpleArrayField.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleArrayField_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, SimpleArrayField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleArrayField_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, SimpleArrayField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(soundCueEClass, SoundCue.class, "SoundCue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoundCue_Href(), theXMLTypePackage.getString(), "href", null, 0, 1, SoundCue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoundCue_DelayedStart(), theXMLTypePackage.getDouble(), "delayedStart", "0.0", 0, 1, SoundCue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tourEClass, Tour.class, "Tour", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTour_Playlist(), this.getPlaylist(), null, "playlist", null, 0, 1, Tour.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tourControlEClass, TourControl.class, "TourControl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTourControl_PlayMode(), this.getPlayModeEnumType(), "playMode", "pause", 0, 1, TourControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tourPrimitiveEClass, TourPrimitive.class, "TourPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trackEClass, Track.class, "Track", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTrack_Extrude(), theXMLTypePackage.getBoolean(), "extrude", "0", 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_Tessellate(), theXMLTypePackage.getBoolean(), "tessellate", "0", 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_AltitudeModeGroupGroup(), ecorePackage.getEFeatureMapEntry(), "altitudeModeGroupGroup", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrack_AltitudeModeGroup(), ecorePackage.getEObject(), null, "altitudeModeGroup", null, 0, 1, Track.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_When(), theKmlPackage.getDateTimeType(), "when", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_Coord(), theXMLTypePackage.getString(), "coord", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_Angles(), theXMLTypePackage.getString(), "angles", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrack_Model(), theKmlPackage.getModel(), null, "model", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrack_ExtendedData(), theKmlPackage.getExtendedData(), null, "extendedData", null, 0, 1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_AbstractTrackSimpleExtensionGroupGroup(), ecorePackage.getEFeatureMapEntry(), "abstractTrackSimpleExtensionGroupGroup", null, 0, -1, Track.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrack_AbstractTrackSimpleExtensionGroup(), theXMLTypePackage.getAnySimpleType(), "abstractTrackSimpleExtensionGroup", null, 0, -1, Track.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(viewerOptionsEClass, ViewerOptions.class, "ViewerOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewerOptions_Option(), this.getOption(), null, "option", null, 1, -1, ViewerOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitEClass, Wait.class, "Wait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWait_Duration(), theXMLTypePackage.getDouble(), "duration", "0.0", 0, 1, Wait.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(altitudeModeEnumTypeEEnum, AltitudeModeEnumType.class, "AltitudeModeEnumType");
		addEEnumLiteral(altitudeModeEnumTypeEEnum, AltitudeModeEnumType.CLAMP_TO_SEA_FLOOR);
		addEEnumLiteral(altitudeModeEnumTypeEEnum, AltitudeModeEnumType.RELATIVE_TO_SEA_FLOOR);

		initEEnum(flyToModeEnumTypeEEnum, FlyToModeEnumType.class, "FlyToModeEnumType");
		addEEnumLiteral(flyToModeEnumTypeEEnum, FlyToModeEnumType.BOUNCE);
		addEEnumLiteral(flyToModeEnumTypeEEnum, FlyToModeEnumType.SMOOTH);

		initEEnum(playModeEnumTypeEEnum, PlayModeEnumType.class, "PlayModeEnumType");
		addEEnumLiteral(playModeEnumTypeEEnum, PlayModeEnumType.PAUSE);

		// Initialize data types
		initEDataType(altitudeModeEnumTypeObjectEDataType, AltitudeModeEnumType.class, "AltitudeModeEnumTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(flyToModeEnumTypeObjectEDataType, FlyToModeEnumType.class, "FlyToModeEnumTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(outerWidthTypeEDataType, float.class, "OuterWidthType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(outerWidthTypeObjectEDataType, Float.class, "OuterWidthTypeObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(playModeEnumTypeObjectEDataType, PlayModeEnumType.class, "PlayModeEnumTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
			 "appinfo", "ogckml22.xsd 2008-01-23\natom-author-link.xsd 2008-01-23"
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
		  (altitudeModeEnumTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "altitudeModeEnumType"
		   });		
		addAnnotation
		  (altitudeModeEnumTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "altitudeModeEnumType:Object",
			 "baseType", "altitudeModeEnumType"
		   });		
		addAnnotation
		  (animatedUpdateEClass, 
		   source, 
		   new String[] {
			 "name", "AnimatedUpdateType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAnimatedUpdate_Duration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "duration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAnimatedUpdate_Update(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Update",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getAnimatedUpdate_DelayedStart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delayedStart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_AbstractTourPrimitive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractTourPrimitive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_AbstractTourPrimitiveGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractTourPrimitiveGroup",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractObjectGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_AbstractTrackSimpleExtensionGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractTrackSimpleExtensionGroup",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_AltitudeMode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "altitudeMode",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#altitudeModeGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_AltitudeOffset(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "altitudeOffset",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractGeometrySimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Angles(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "angles",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_AnimatedUpdate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AnimatedUpdate",
			 "namespace", "##targetNamespace",
			 "affiliation", "AbstractTourPrimitiveGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_BalloonVisibility(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "balloonVisibility",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractFeatureSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Coord(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "coord",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_DelayedStart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delayedStart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_DrawOrder(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "drawOrder",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractGeometrySimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Duration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "duration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_FlyTo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FlyTo",
			 "namespace", "##targetNamespace",
			 "affiliation", "AbstractTourPrimitiveGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_FlyToMode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flyToMode",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_H(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "h",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Interpolate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interpolate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_LatLonQuad(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LatLonQuad",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#GroundOverlayObjectExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_MultiTrack(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MultiTrack",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractGeometryGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Option(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "option",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_OuterColor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outerColor",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_OuterWidth(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outerWidth",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_PhysicalWidth(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "physicalWidth",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#LineStyleSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Playlist(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Playlist",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractObjectGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_PlayMode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "playMode",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Rank(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rank",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractFeatureSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_SimpleArrayData(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayData",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#SchemaDataExtension"
		   });		
		addAnnotation
		  (getDocumentRoot_SimpleArrayDataExtension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayDataExtension",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_SimpleArrayField(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayField",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#SchemaExtension"
		   });		
		addAnnotation
		  (getDocumentRoot_SimpleArrayFieldExtension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayFieldExtension",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_SoundCue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SoundCue",
			 "namespace", "##targetNamespace",
			 "affiliation", "AbstractTourPrimitiveGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_TimeSpan(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TimeSpan",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_TimeStamp(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TimeStamp",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Tour(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tour",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractFeatureGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_TourControl(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TourControl",
			 "namespace", "##targetNamespace",
			 "affiliation", "AbstractTourPrimitiveGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Track(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Track",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractGeometryGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ViewerOptions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ViewerOptions",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#AbstractViewObjectExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_W(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "w",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Wait",
			 "namespace", "##targetNamespace",
			 "affiliation", "AbstractTourPrimitiveGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_X(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "x",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup"
		   });		
		addAnnotation
		  (getDocumentRoot_Y(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "y",
			 "namespace", "##targetNamespace",
			 "affiliation", "http://www.opengis.net/kml/2.2#BasicLinkSimpleExtensionGroup"
		   });		
		addAnnotation
		  (flyToEClass, 
		   source, 
		   new String[] {
			 "name", "FlyToType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFlyTo_Duration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "duration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFlyTo_FlyToMode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flyToMode",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFlyTo_AbstractViewGroupGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "AbstractViewGroup:group",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getFlyTo_AbstractViewGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractViewGroup",
			 "namespace", "http://www.opengis.net/kml/2.2",
			 "group", "http://www.opengis.net/kml/2.2#AbstractViewGroup:group"
		   });		
		addAnnotation
		  (flyToModeEnumTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "flyToModeEnumType"
		   });		
		addAnnotation
		  (flyToModeEnumTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "flyToModeEnumType:Object",
			 "baseType", "flyToModeEnumType"
		   });		
		addAnnotation
		  (latLonQuadEClass, 
		   source, 
		   new String[] {
			 "name", "LatLonQuadType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLatLonQuad_Coordinates(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "coordinates",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (multiTrackEClass, 
		   source, 
		   new String[] {
			 "name", "MultiTrackType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMultiTrack_AltitudeModeGroupGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "altitudeModeGroup:group",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getMultiTrack_AltitudeModeGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "altitudeModeGroup",
			 "namespace", "http://www.opengis.net/kml/2.2",
			 "group", "http://www.opengis.net/kml/2.2#altitudeModeGroup:group"
		   });		
		addAnnotation
		  (getMultiTrack_Interpolate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interpolate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMultiTrack_Track(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Track",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (optionEClass, 
		   source, 
		   new String[] {
			 "name", "optionType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getOption_Enabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "enabled"
		   });		
		addAnnotation
		  (getOption_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (outerWidthTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "outerWidthType",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#float",
			 "minInclusive", "0.0",
			 "maxInclusive", "1.0"
		   });		
		addAnnotation
		  (outerWidthTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "outerWidthType:Object",
			 "baseType", "outerWidthType"
		   });		
		addAnnotation
		  (playlistEClass, 
		   source, 
		   new String[] {
			 "name", "PlaylistType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPlaylist_AbstractTourPrimitiveGroupGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "AbstractTourPrimitiveGroup:group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPlaylist_AbstractTourPrimitiveGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractTourPrimitiveGroup",
			 "namespace", "##targetNamespace",
			 "group", "AbstractTourPrimitiveGroup:group"
		   });		
		addAnnotation
		  (playModeEnumTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "playModeEnumType"
		   });		
		addAnnotation
		  (playModeEnumTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "playModeEnumType:Object",
			 "baseType", "playModeEnumType"
		   });		
		addAnnotation
		  (simpleArrayDataEClass, 
		   source, 
		   new String[] {
			 "name", "SimpleArrayDataType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSimpleArrayData_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSimpleArrayData_SimpleArrayDataExtensionGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "SimpleArrayDataExtension:group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSimpleArrayData_SimpleArrayDataExtension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayDataExtension",
			 "namespace", "##targetNamespace",
			 "group", "SimpleArrayDataExtension:group"
		   });		
		addAnnotation
		  (getSimpleArrayData_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (simpleArrayFieldEClass, 
		   source, 
		   new String[] {
			 "name", "SimpleArrayFieldType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSimpleArrayField_DisplayName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "displayName",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getSimpleArrayField_SimpleArrayFieldExtensionGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "SimpleArrayFieldExtension:group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSimpleArrayField_SimpleArrayFieldExtension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SimpleArrayFieldExtension",
			 "namespace", "##targetNamespace",
			 "group", "SimpleArrayFieldExtension:group"
		   });		
		addAnnotation
		  (getSimpleArrayField_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getSimpleArrayField_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (soundCueEClass, 
		   source, 
		   new String[] {
			 "name", "SoundCueType",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSoundCue_Href(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "href",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getSoundCue_DelayedStart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delayedStart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tourEClass, 
		   source, 
		   new String[] {
			 "name", "TourType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTour_Playlist(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Playlist",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tourControlEClass, 
		   source, 
		   new String[] {
			 "name", "TourControlType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTourControl_PlayMode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "playMode",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tourPrimitiveEClass, 
		   source, 
		   new String[] {
			 "name", "AbstractTourPrimitiveType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (trackEClass, 
		   source, 
		   new String[] {
			 "name", "TrackType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTrack_Extrude(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extrude",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_Tessellate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tessellate",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_AltitudeModeGroupGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "altitudeModeGroup:group",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_AltitudeModeGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "altitudeModeGroup",
			 "namespace", "http://www.opengis.net/kml/2.2",
			 "group", "http://www.opengis.net/kml/2.2#altitudeModeGroup:group"
		   });		
		addAnnotation
		  (getTrack_When(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "when",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_Coord(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "coord",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTrack_Angles(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "angles",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTrack_Model(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Model",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_ExtendedData(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExtendedData",
			 "namespace", "http://www.opengis.net/kml/2.2"
		   });		
		addAnnotation
		  (getTrack_AbstractTrackSimpleExtensionGroupGroup(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "AbstractTrackSimpleExtensionGroup:group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTrack_AbstractTrackSimpleExtensionGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AbstractTrackSimpleExtensionGroup",
			 "namespace", "##targetNamespace",
			 "group", "AbstractTrackSimpleExtensionGroup:group"
		   });		
		addAnnotation
		  (viewerOptionsEClass, 
		   source, 
		   new String[] {
			 "name", "ViewerOptionsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getViewerOptions_Option(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "option",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (waitEClass, 
		   source, 
		   new String[] {
			 "name", "WaitType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getWait_Duration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "duration",
			 "namespace", "##targetNamespace"
		   });
	}

} //KmlgxPackageImpl
