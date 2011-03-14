/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.verticon.opengis.kml.KmlPackage;

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
 * XML Schema Document for OGC KML version 2.2. Copyright
 * 			(c)
 * 			2008 Open Geospatial Consortium, Inc. All Rights Reserved.
 * 		
 * There is no official atom XSD. This XSD is created based on:
 *       http://atompub.org/2005/08/17/atom.rnc. A subset of Atom as used in the
 *       ogckml22.xsd is defined here. 
 * xAL: eXtensible Address Language 
 * This is an XML document type definition (DTD) for
 * defining addresses.
 * Original Date of Creation: 1 March 2001
 * Copyright(c) 2000, OASIS. All Rights Reserved [http://www.oasis-open.org]
 * Contact: Customer Information Quality Technical Committee, OASIS
 * http://www.oasis-open.org/committees/ciq
 * VERSION: 2.0 [MAJOR RELEASE] Date of Creation: 01 May 2002
 * Last Update: 24 July 2002
 * Previous Version: 1.3
 * Common Attributes:Type - If not documented then it means, possible values of Type not limited to: Official, Unique, Abbreviation, OldName, Synonym
 * Code:Address element codes are used by groups like postal groups like ECCMA, ADIS, UN/PROLIST for postal services
 * <!-- end-model-doc -->
 * @see com.verticon.google.kmlgx.KmlgxFactory
 * @model kind="package"
 * @generated
 */
public interface KmlgxPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kmlgx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.google.com/kml/ext/2.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KmlgxPackage eINSTANCE = com.verticon.google.kmlgx.impl.KmlgxPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.TourPrimitiveImpl <em>Tour Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.TourPrimitiveImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTourPrimitive()
	 * @generated
	 */
	int TOUR_PRIMITIVE = 12;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_PRIMITIVE__ID = KmlPackage.ABSTRACT_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_PRIMITIVE__TARGET_ID = KmlPackage.ABSTRACT_OBJECT__TARGET_ID;

	/**
	 * The number of structural features of the '<em>Tour Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_PRIMITIVE_FEATURE_COUNT = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.AnimatedUpdateImpl <em>Animated Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.AnimatedUpdateImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAnimatedUpdate()
	 * @generated
	 */
	int ANIMATED_UPDATE = 0;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__OBJECT_SIMPLE_EXTENSION_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__ID = TOUR_PRIMITIVE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__TARGET_ID = TOUR_PRIMITIVE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__DURATION = TOUR_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__UPDATE = TOUR_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Delayed Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE__DELAYED_START = TOUR_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Animated Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATED_UPDATE_FEATURE_COUNT = TOUR_PRIMITIVE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.DocumentRootImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Abstract Tour Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE = 3;

	/**
	 * The feature id for the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Altitude Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ALTITUDE_MODE = 6;

	/**
	 * The feature id for the '<em><b>Altitude Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ALTITUDE_OFFSET = 7;

	/**
	 * The feature id for the '<em><b>Angles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ANGLES = 8;

	/**
	 * The feature id for the '<em><b>Animated Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ANIMATED_UPDATE = 9;

	/**
	 * The feature id for the '<em><b>Balloon Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BALLOON_VISIBILITY = 10;

	/**
	 * The feature id for the '<em><b>Coord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COORD = 11;

	/**
	 * The feature id for the '<em><b>Delayed Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DELAYED_START = 12;

	/**
	 * The feature id for the '<em><b>Draw Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DRAW_ORDER = 13;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DURATION = 14;

	/**
	 * The feature id for the '<em><b>Fly To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FLY_TO = 15;

	/**
	 * The feature id for the '<em><b>Fly To Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FLY_TO_MODE = 16;

	/**
	 * The feature id for the '<em><b>H</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__H = 17;

	/**
	 * The feature id for the '<em><b>Interpolate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INTERPOLATE = 18;

	/**
	 * The feature id for the '<em><b>Lat Lon Quad</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LAT_LON_QUAD = 19;

	/**
	 * The feature id for the '<em><b>Multi Track</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MULTI_TRACK = 20;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OPTION = 21;

	/**
	 * The feature id for the '<em><b>Outer Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OUTER_COLOR = 22;

	/**
	 * The feature id for the '<em><b>Outer Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OUTER_WIDTH = 23;

	/**
	 * The feature id for the '<em><b>Physical Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PHYSICAL_WIDTH = 24;

	/**
	 * The feature id for the '<em><b>Playlist</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PLAYLIST = 25;

	/**
	 * The feature id for the '<em><b>Play Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PLAY_MODE = 26;

	/**
	 * The feature id for the '<em><b>Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RANK = 27;

	/**
	 * The feature id for the '<em><b>Simple Array Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SIMPLE_ARRAY_DATA = 28;

	/**
	 * The feature id for the '<em><b>Simple Array Data Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION = 29;

	/**
	 * The feature id for the '<em><b>Simple Array Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD = 30;

	/**
	 * The feature id for the '<em><b>Simple Array Field Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION = 31;

	/**
	 * The feature id for the '<em><b>Sound Cue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SOUND_CUE = 32;

	/**
	 * The feature id for the '<em><b>Time Span</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TIME_SPAN = 33;

	/**
	 * The feature id for the '<em><b>Time Stamp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TIME_STAMP = 34;

	/**
	 * The feature id for the '<em><b>Tour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TOUR = 35;

	/**
	 * The feature id for the '<em><b>Tour Control</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TOUR_CONTROL = 36;

	/**
	 * The feature id for the '<em><b>Track</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TRACK = 37;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VALUE = 38;

	/**
	 * The feature id for the '<em><b>Viewer Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VIEWER_OPTIONS = 39;

	/**
	 * The feature id for the '<em><b>W</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__W = 40;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__WAIT = 41;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__X = 42;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__Y = 43;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 44;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.FlyToImpl <em>Fly To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.FlyToImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyTo()
	 * @generated
	 */
	int FLY_TO = 2;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__OBJECT_SIMPLE_EXTENSION_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__ID = TOUR_PRIMITIVE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__TARGET_ID = TOUR_PRIMITIVE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__DURATION = TOUR_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fly To Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__FLY_TO_MODE = TOUR_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract View Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__ABSTRACT_VIEW_GROUP_GROUP = TOUR_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abstract View Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO__ABSTRACT_VIEW_GROUP = TOUR_PRIMITIVE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fly To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLY_TO_FEATURE_COUNT = TOUR_PRIMITIVE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.LatLonQuadImpl <em>Lat Lon Quad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.LatLonQuadImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getLatLonQuad()
	 * @generated
	 */
	int LAT_LON_QUAD = 3;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD__ID = KmlPackage.ABSTRACT_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD__TARGET_ID = KmlPackage.ABSTRACT_OBJECT__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD__COORDINATES = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lat Lon Quad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAT_LON_QUAD_FEATURE_COUNT = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.MultiTrackImpl <em>Multi Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.MultiTrackImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getMultiTrack()
	 * @generated
	 */
	int MULTI_TRACK = 4;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.GEOMETRY__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ID = KmlPackage.GEOMETRY__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__TARGET_ID = KmlPackage.GEOMETRY__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Object Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Object Extension Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Altitude Mode Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Altitude Mode Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__ALTITUDE_MODE_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interpolate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__INTERPOLATE = KmlPackage.GEOMETRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Track</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK__TRACK = KmlPackage.GEOMETRY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Multi Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TRACK_FEATURE_COUNT = KmlPackage.GEOMETRY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.OptionImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 5;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.PlaylistImpl <em>Playlist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.PlaylistImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlaylist()
	 * @generated
	 */
	int PLAYLIST = 6;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__ID = KmlPackage.ABSTRACT_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__TARGET_ID = KmlPackage.ABSTRACT_OBJECT__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Abstract Tour Primitive Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Playlist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_FEATURE_COUNT = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl <em>Simple Array Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.SimpleArrayDataImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSimpleArrayData()
	 * @generated
	 */
	int SIMPLE_ARRAY_DATA = 7;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__ID = KmlPackage.ABSTRACT_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__TARGET_ID = KmlPackage.ABSTRACT_OBJECT__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__VALUE = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Array Data Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Array Data Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA__NAME = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Simple Array Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_DATA_FEATURE_COUNT = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl <em>Simple Array Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSimpleArrayField()
	 * @generated
	 */
	int SIMPLE_ARRAY_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD__DISPLAY_NAME = 0;

	/**
	 * The feature id for the '<em><b>Simple Array Field Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Simple Array Field Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Simple Array Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARRAY_FIELD_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.SoundCueImpl <em>Sound Cue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.SoundCueImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSoundCue()
	 * @generated
	 */
	int SOUND_CUE = 9;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__OBJECT_SIMPLE_EXTENSION_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__ID = TOUR_PRIMITIVE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__TARGET_ID = TOUR_PRIMITIVE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__HREF = TOUR_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Delayed Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE__DELAYED_START = TOUR_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sound Cue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOUND_CUE_FEATURE_COUNT = TOUR_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.TourImpl <em>Tour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.TourImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTour()
	 * @generated
	 */
	int TOUR = 10;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.FEATURE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.FEATURE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ID = KmlPackage.FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__TARGET_ID = KmlPackage.FEATURE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__NAME = KmlPackage.FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__VISIBILITY = KmlPackage.FEATURE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__OPEN = KmlPackage.FEATURE__OPEN;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__AUTHOR = KmlPackage.FEATURE__AUTHOR;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__LINK = KmlPackage.FEATURE__LINK;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ADDRESS = KmlPackage.FEATURE__ADDRESS;

	/**
	 * The feature id for the '<em><b>Address Details</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ADDRESS_DETAILS = KmlPackage.FEATURE__ADDRESS_DETAILS;

	/**
	 * The feature id for the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__PHONE_NUMBER = KmlPackage.FEATURE__PHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>Snippet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__SNIPPET = KmlPackage.FEATURE__SNIPPET;

	/**
	 * The feature id for the '<em><b>Snippet1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__SNIPPET1 = KmlPackage.FEATURE__SNIPPET1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__DESCRIPTION = KmlPackage.FEATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Abstract View Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_VIEW_GROUP_GROUP = KmlPackage.FEATURE__ABSTRACT_VIEW_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract View Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_VIEW_GROUP = KmlPackage.FEATURE__ABSTRACT_VIEW_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Time Primitive Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_TIME_PRIMITIVE_GROUP_GROUP = KmlPackage.FEATURE__ABSTRACT_TIME_PRIMITIVE_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Time Primitive Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_TIME_PRIMITIVE_GROUP = KmlPackage.FEATURE__ABSTRACT_TIME_PRIMITIVE_GROUP;

	/**
	 * The feature id for the '<em><b>Style Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__STYLE_URL = KmlPackage.FEATURE__STYLE_URL;

	/**
	 * The feature id for the '<em><b>Abstract Style Selector Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_STYLE_SELECTOR_GROUP_GROUP = KmlPackage.FEATURE__ABSTRACT_STYLE_SELECTOR_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Style Selector Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_STYLE_SELECTOR_GROUP = KmlPackage.FEATURE__ABSTRACT_STYLE_SELECTOR_GROUP;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__REGION = KmlPackage.FEATURE__REGION;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__METADATA = KmlPackage.FEATURE__METADATA;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__EXTENDED_DATA = KmlPackage.FEATURE__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Abstract Feature Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_FEATURE_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.FEATURE__ABSTRACT_FEATURE_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Feature Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_FEATURE_SIMPLE_EXTENSION_GROUP = KmlPackage.FEATURE__ABSTRACT_FEATURE_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Feature Object Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_FEATURE_OBJECT_EXTENSION_GROUP_GROUP = KmlPackage.FEATURE__ABSTRACT_FEATURE_OBJECT_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Feature Object Extension Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__ABSTRACT_FEATURE_OBJECT_EXTENSION_GROUP = KmlPackage.FEATURE__ABSTRACT_FEATURE_OBJECT_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Playlist</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR__PLAYLIST = KmlPackage.FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_FEATURE_COUNT = KmlPackage.FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.TourControlImpl <em>Tour Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.TourControlImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTourControl()
	 * @generated
	 */
	int TOUR_CONTROL = 11;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL__OBJECT_SIMPLE_EXTENSION_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL__ID = TOUR_PRIMITIVE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL__TARGET_ID = TOUR_PRIMITIVE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Play Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL__PLAY_MODE = TOUR_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tour Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUR_CONTROL_FEATURE_COUNT = TOUR_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.TrackImpl <em>Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.TrackImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTrack()
	 * @generated
	 */
	int TRACK = 13;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.GEOMETRY__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ID = KmlPackage.GEOMETRY__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__TARGET_ID = KmlPackage.GEOMETRY__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Object Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Abstract Geometry Object Extension Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP = KmlPackage.GEOMETRY__ABSTRACT_GEOMETRY_OBJECT_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Extrude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__EXTRUDE = KmlPackage.GEOMETRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tessellate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__TESSELLATE = KmlPackage.GEOMETRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Altitude Mode Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ALTITUDE_MODE_GROUP_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Altitude Mode Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ALTITUDE_MODE_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__WHEN = KmlPackage.GEOMETRY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Coord</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__COORD = KmlPackage.GEOMETRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Angles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ANGLES = KmlPackage.GEOMETRY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__MODEL = KmlPackage.GEOMETRY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__EXTENDED_DATA = KmlPackage.GEOMETRY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Abstract Track Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP = KmlPackage.GEOMETRY_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACK_FEATURE_COUNT = KmlPackage.GEOMETRY_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.ViewerOptionsImpl <em>Viewer Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.ViewerOptionsImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getViewerOptions()
	 * @generated
	 */
	int VIEWER_OPTIONS = 14;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS__OBJECT_SIMPLE_EXTENSION_GROUP = KmlPackage.ABSTRACT_OBJECT__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS__ID = KmlPackage.ABSTRACT_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS__TARGET_ID = KmlPackage.ABSTRACT_OBJECT__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS__OPTION = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Viewer Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_OPTIONS_FEATURE_COUNT = KmlPackage.ABSTRACT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.impl.WaitImpl <em>Wait</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.WaitImpl
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getWait()
	 * @generated
	 */
	int WAIT = 15;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP_GROUP;

	/**
	 * The feature id for the '<em><b>Object Simple Extension Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__OBJECT_SIMPLE_EXTENSION_GROUP = TOUR_PRIMITIVE__OBJECT_SIMPLE_EXTENSION_GROUP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__ID = TOUR_PRIMITIVE__ID;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__TARGET_ID = TOUR_PRIMITIVE__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__DURATION = TOUR_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FEATURE_COUNT = TOUR_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.AltitudeModeEnumType <em>Altitude Mode Enum Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAltitudeModeEnumType()
	 * @generated
	 */
	int ALTITUDE_MODE_ENUM_TYPE = 16;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.FlyToModeEnumType <em>Fly To Mode Enum Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyToModeEnumType()
	 * @generated
	 */
	int FLY_TO_MODE_ENUM_TYPE = 17;

	/**
	 * The meta object id for the '{@link com.verticon.google.kmlgx.PlayModeEnumType <em>Play Mode Enum Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlayModeEnumType()
	 * @generated
	 */
	int PLAY_MODE_ENUM_TYPE = 18;

	/**
	 * The meta object id for the '<em>Altitude Mode Enum Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAltitudeModeEnumTypeObject()
	 * @generated
	 */
	int ALTITUDE_MODE_ENUM_TYPE_OBJECT = 19;

	/**
	 * The meta object id for the '<em>Fly To Mode Enum Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyToModeEnumTypeObject()
	 * @generated
	 */
	int FLY_TO_MODE_ENUM_TYPE_OBJECT = 20;

	/**
	 * The meta object id for the '<em>Outer Width Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOuterWidthType()
	 * @generated
	 */
	int OUTER_WIDTH_TYPE = 21;

	/**
	 * The meta object id for the '<em>Outer Width Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Float
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOuterWidthTypeObject()
	 * @generated
	 */
	int OUTER_WIDTH_TYPE_OBJECT = 22;

	/**
	 * The meta object id for the '<em>Play Mode Enum Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlayModeEnumTypeObject()
	 * @generated
	 */
	int PLAY_MODE_ENUM_TYPE_OBJECT = 23;


	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.AnimatedUpdate <em>Animated Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animated Update</em>'.
	 * @see com.verticon.google.kmlgx.AnimatedUpdate
	 * @generated
	 */
	EClass getAnimatedUpdate();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.verticon.google.kmlgx.AnimatedUpdate#getDuration()
	 * @see #getAnimatedUpdate()
	 * @generated
	 */
	EAttribute getAnimatedUpdate_Duration();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.AnimatedUpdate#getUpdate <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Update</em>'.
	 * @see com.verticon.google.kmlgx.AnimatedUpdate#getUpdate()
	 * @see #getAnimatedUpdate()
	 * @generated
	 */
	EReference getAnimatedUpdate_Update();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart <em>Delayed Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delayed Start</em>'.
	 * @see com.verticon.google.kmlgx.AnimatedUpdate#getDelayedStart()
	 * @see #getAnimatedUpdate()
	 * @generated
	 */
	EAttribute getAnimatedUpdate_DelayedStart();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.verticon.google.kmlgx.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.verticon.google.kmlgx.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive <em>Abstract Tour Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abstract Tour Primitive</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitive()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AbstractTourPrimitive();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abstract Tour Primitive Group</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTourPrimitiveGroup()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AbstractTourPrimitiveGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract Track Simple Extension Group</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAbstractTrackSimpleExtensionGroup()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_AbstractTrackSimpleExtensionGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode <em>Altitude Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude Mode</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAltitudeMode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_AltitudeMode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset <em>Altitude Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude Offset</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAltitudeOffset()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_AltitudeOffset();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getAngles <em>Angles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Angles</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAngles()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Angles();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate <em>Animated Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Animated Update</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getAnimatedUpdate()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AnimatedUpdate();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility <em>Balloon Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balloon Visibility</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#isBalloonVisibility()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_BalloonVisibility();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getCoord <em>Coord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coord</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getCoord()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Coord();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getDelayedStart <em>Delayed Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delayed Start</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDelayedStart()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_DelayedStart();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getDrawOrder <em>Draw Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Draw Order</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDrawOrder()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_DrawOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getDuration()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Duration();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyTo <em>Fly To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fly To</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getFlyTo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FlyTo();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getFlyToMode <em>Fly To Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fly To Mode</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getFlyToMode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_FlyToMode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getH <em>H</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>H</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getH()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_H();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#isInterpolate <em>Interpolate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpolate</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#isInterpolate()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Interpolate();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad <em>Lat Lon Quad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lat Lon Quad</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getLatLonQuad()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LatLonQuad();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getMultiTrack <em>Multi Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multi Track</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getMultiTrack()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_MultiTrack();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Option</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOption()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Option();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterColor <em>Outer Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outer Color</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOuterColor()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_OuterColor();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getOuterWidth <em>Outer Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outer Width</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getOuterWidth()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_OuterWidth();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth <em>Physical Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physical Width</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPhysicalWidth()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_PhysicalWidth();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getPlaylist <em>Playlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Playlist</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPlaylist()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Playlist();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getPlayMode <em>Play Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Mode</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getPlayMode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_PlayMode();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getRank <em>Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rank</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getRank()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Rank();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData <em>Simple Array Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Array Data</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayData()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SimpleArrayData();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Array Data Extension</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayDataExtension()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SimpleArrayDataExtension();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField <em>Simple Array Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Array Field</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayField()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SimpleArrayField();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Array Field Extension</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSimpleArrayFieldExtension()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SimpleArrayFieldExtension();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getSoundCue <em>Sound Cue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sound Cue</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getSoundCue()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SoundCue();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeSpan <em>Time Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Span</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTimeSpan()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TimeSpan();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getTimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Stamp</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTimeStamp()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TimeStamp();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getTour <em>Tour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tour</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTour()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Tour();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getTourControl <em>Tour Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tour Control</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTourControl()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TourControl();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getTrack <em>Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Track</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getTrack()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Track();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getValue()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Value();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getViewerOptions <em>Viewer Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Viewer Options</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getViewerOptions()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ViewerOptions();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getW <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>W</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getW()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_W();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.DocumentRoot#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getWait()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Wait();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getX()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_X();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.DocumentRoot#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see com.verticon.google.kmlgx.DocumentRoot#getY()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Y();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.FlyTo <em>Fly To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fly To</em>'.
	 * @see com.verticon.google.kmlgx.FlyTo
	 * @generated
	 */
	EClass getFlyTo();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.FlyTo#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.verticon.google.kmlgx.FlyTo#getDuration()
	 * @see #getFlyTo()
	 * @generated
	 */
	EAttribute getFlyTo_Duration();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.FlyTo#getFlyToMode <em>Fly To Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fly To Mode</em>'.
	 * @see com.verticon.google.kmlgx.FlyTo#getFlyToMode()
	 * @see #getFlyTo()
	 * @generated
	 */
	EAttribute getFlyTo_FlyToMode();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.FlyTo#getAbstractViewGroupGroup <em>Abstract View Group Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract View Group Group</em>'.
	 * @see com.verticon.google.kmlgx.FlyTo#getAbstractViewGroupGroup()
	 * @see #getFlyTo()
	 * @generated
	 */
	EAttribute getFlyTo_AbstractViewGroupGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.FlyTo#getAbstractViewGroup <em>Abstract View Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Abstract View Group</em>'.
	 * @see com.verticon.google.kmlgx.FlyTo#getAbstractViewGroup()
	 * @see #getFlyTo()
	 * @generated
	 */
	EReference getFlyTo_AbstractViewGroup();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.LatLonQuad <em>Lat Lon Quad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lat Lon Quad</em>'.
	 * @see com.verticon.google.kmlgx.LatLonQuad
	 * @generated
	 */
	EClass getLatLonQuad();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.LatLonQuad#getCoordinates <em>Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coordinates</em>'.
	 * @see com.verticon.google.kmlgx.LatLonQuad#getCoordinates()
	 * @see #getLatLonQuad()
	 * @generated
	 */
	EAttribute getLatLonQuad_Coordinates();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.MultiTrack <em>Multi Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Track</em>'.
	 * @see com.verticon.google.kmlgx.MultiTrack
	 * @generated
	 */
	EClass getMultiTrack();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Altitude Mode Group Group</em>'.
	 * @see com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroupGroup()
	 * @see #getMultiTrack()
	 * @generated
	 */
	EAttribute getMultiTrack_AltitudeModeGroupGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroup <em>Altitude Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Altitude Mode Group</em>'.
	 * @see com.verticon.google.kmlgx.MultiTrack#getAltitudeModeGroup()
	 * @see #getMultiTrack()
	 * @generated
	 */
	EReference getMultiTrack_AltitudeModeGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.MultiTrack#isInterpolate <em>Interpolate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpolate</em>'.
	 * @see com.verticon.google.kmlgx.MultiTrack#isInterpolate()
	 * @see #getMultiTrack()
	 * @generated
	 */
	EAttribute getMultiTrack_Interpolate();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.google.kmlgx.MultiTrack#getTrack <em>Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Track</em>'.
	 * @see com.verticon.google.kmlgx.MultiTrack#getTrack()
	 * @see #getMultiTrack()
	 * @generated
	 */
	EReference getMultiTrack_Track();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see com.verticon.google.kmlgx.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.Option#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see com.verticon.google.kmlgx.Option#isEnabled()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.Option#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.google.kmlgx.Option#getName()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Name();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.Playlist <em>Playlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Playlist</em>'.
	 * @see com.verticon.google.kmlgx.Playlist
	 * @generated
	 */
	EClass getPlaylist();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroupGroup <em>Abstract Tour Primitive Group Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract Tour Primitive Group Group</em>'.
	 * @see com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroupGroup()
	 * @see #getPlaylist()
	 * @generated
	 */
	EAttribute getPlaylist_AbstractTourPrimitiveGroupGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroup <em>Abstract Tour Primitive Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Tour Primitive Group</em>'.
	 * @see com.verticon.google.kmlgx.Playlist#getAbstractTourPrimitiveGroup()
	 * @see #getPlaylist()
	 * @generated
	 */
	EReference getPlaylist_AbstractTourPrimitiveGroup();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.SimpleArrayData <em>Simple Array Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Array Data</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayData
	 * @generated
	 */
	EClass getSimpleArrayData();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.SimpleArrayData#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayData#getValue()
	 * @see #getSimpleArrayData()
	 * @generated
	 */
	EAttribute getSimpleArrayData_Value();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtensionGroup <em>Simple Array Data Extension Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Simple Array Data Extension Group</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtensionGroup()
	 * @see #getSimpleArrayData()
	 * @generated
	 */
	EAttribute getSimpleArrayData_SimpleArrayDataExtensionGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtension <em>Simple Array Data Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Array Data Extension</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayData#getSimpleArrayDataExtension()
	 * @see #getSimpleArrayData()
	 * @generated
	 */
	EReference getSimpleArrayData_SimpleArrayDataExtension();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SimpleArrayData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayData#getName()
	 * @see #getSimpleArrayData()
	 * @generated
	 */
	EAttribute getSimpleArrayData_Name();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.SimpleArrayField <em>Simple Array Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Array Field</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField
	 * @generated
	 */
	EClass getSimpleArrayField();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SimpleArrayField#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField#getDisplayName()
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	EAttribute getSimpleArrayField_DisplayName();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtensionGroup <em>Simple Array Field Extension Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Simple Array Field Extension Group</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtensionGroup()
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	EAttribute getSimpleArrayField_SimpleArrayFieldExtensionGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtension <em>Simple Array Field Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Array Field Extension</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField#getSimpleArrayFieldExtension()
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	EReference getSimpleArrayField_SimpleArrayFieldExtension();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SimpleArrayField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField#getName()
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	EAttribute getSimpleArrayField_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SimpleArrayField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.verticon.google.kmlgx.SimpleArrayField#getType()
	 * @see #getSimpleArrayField()
	 * @generated
	 */
	EAttribute getSimpleArrayField_Type();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.SoundCue <em>Sound Cue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sound Cue</em>'.
	 * @see com.verticon.google.kmlgx.SoundCue
	 * @generated
	 */
	EClass getSoundCue();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SoundCue#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.verticon.google.kmlgx.SoundCue#getHref()
	 * @see #getSoundCue()
	 * @generated
	 */
	EAttribute getSoundCue_Href();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.SoundCue#getDelayedStart <em>Delayed Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delayed Start</em>'.
	 * @see com.verticon.google.kmlgx.SoundCue#getDelayedStart()
	 * @see #getSoundCue()
	 * @generated
	 */
	EAttribute getSoundCue_DelayedStart();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.Tour <em>Tour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tour</em>'.
	 * @see com.verticon.google.kmlgx.Tour
	 * @generated
	 */
	EClass getTour();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.Tour#getPlaylist <em>Playlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Playlist</em>'.
	 * @see com.verticon.google.kmlgx.Tour#getPlaylist()
	 * @see #getTour()
	 * @generated
	 */
	EReference getTour_Playlist();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.TourControl <em>Tour Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tour Control</em>'.
	 * @see com.verticon.google.kmlgx.TourControl
	 * @generated
	 */
	EClass getTourControl();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.TourControl#getPlayMode <em>Play Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Play Mode</em>'.
	 * @see com.verticon.google.kmlgx.TourControl#getPlayMode()
	 * @see #getTourControl()
	 * @generated
	 */
	EAttribute getTourControl_PlayMode();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.TourPrimitive <em>Tour Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tour Primitive</em>'.
	 * @see com.verticon.google.kmlgx.TourPrimitive
	 * @generated
	 */
	EClass getTourPrimitive();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.Track <em>Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Track</em>'.
	 * @see com.verticon.google.kmlgx.Track
	 * @generated
	 */
	EClass getTrack();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.Track#isExtrude <em>Extrude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extrude</em>'.
	 * @see com.verticon.google.kmlgx.Track#isExtrude()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_Extrude();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.Track#isTessellate <em>Tessellate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tessellate</em>'.
	 * @see com.verticon.google.kmlgx.Track#isTessellate()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_Tessellate();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Altitude Mode Group Group</em>'.
	 * @see com.verticon.google.kmlgx.Track#getAltitudeModeGroupGroup()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_AltitudeModeGroupGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.Track#getAltitudeModeGroup <em>Altitude Mode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Altitude Mode Group</em>'.
	 * @see com.verticon.google.kmlgx.Track#getAltitudeModeGroup()
	 * @see #getTrack()
	 * @generated
	 */
	EReference getTrack_AltitudeModeGroup();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>When</em>'.
	 * @see com.verticon.google.kmlgx.Track#getWhen()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_When();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getCoord <em>Coord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Coord</em>'.
	 * @see com.verticon.google.kmlgx.Track#getCoord()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_Coord();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getAngles <em>Angles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Angles</em>'.
	 * @see com.verticon.google.kmlgx.Track#getAngles()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_Angles();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.Track#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see com.verticon.google.kmlgx.Track#getModel()
	 * @see #getTrack()
	 * @generated
	 */
	EReference getTrack_Model();

	/**
	 * Returns the meta object for the containment reference '{@link com.verticon.google.kmlgx.Track#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extended Data</em>'.
	 * @see com.verticon.google.kmlgx.Track#getExtendedData()
	 * @see #getTrack()
	 * @generated
	 */
	EReference getTrack_ExtendedData();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroupGroup <em>Abstract Track Simple Extension Group Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract Track Simple Extension Group Group</em>'.
	 * @see com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroupGroup()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_AbstractTrackSimpleExtensionGroupGroup();

	/**
	 * Returns the meta object for the attribute list '{@link com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Abstract Track Simple Extension Group</em>'.
	 * @see com.verticon.google.kmlgx.Track#getAbstractTrackSimpleExtensionGroup()
	 * @see #getTrack()
	 * @generated
	 */
	EAttribute getTrack_AbstractTrackSimpleExtensionGroup();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.ViewerOptions <em>Viewer Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewer Options</em>'.
	 * @see com.verticon.google.kmlgx.ViewerOptions
	 * @generated
	 */
	EClass getViewerOptions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.verticon.google.kmlgx.ViewerOptions#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Option</em>'.
	 * @see com.verticon.google.kmlgx.ViewerOptions#getOption()
	 * @see #getViewerOptions()
	 * @generated
	 */
	EReference getViewerOptions_Option();

	/**
	 * Returns the meta object for class '{@link com.verticon.google.kmlgx.Wait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait</em>'.
	 * @see com.verticon.google.kmlgx.Wait
	 * @generated
	 */
	EClass getWait();

	/**
	 * Returns the meta object for the attribute '{@link com.verticon.google.kmlgx.Wait#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.verticon.google.kmlgx.Wait#getDuration()
	 * @see #getWait()
	 * @generated
	 */
	EAttribute getWait_Duration();

	/**
	 * Returns the meta object for enum '{@link com.verticon.google.kmlgx.AltitudeModeEnumType <em>Altitude Mode Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Altitude Mode Enum Type</em>'.
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @generated
	 */
	EEnum getAltitudeModeEnumType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.google.kmlgx.FlyToModeEnumType <em>Fly To Mode Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fly To Mode Enum Type</em>'.
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @generated
	 */
	EEnum getFlyToModeEnumType();

	/**
	 * Returns the meta object for enum '{@link com.verticon.google.kmlgx.PlayModeEnumType <em>Play Mode Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Play Mode Enum Type</em>'.
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @generated
	 */
	EEnum getPlayModeEnumType();

	/**
	 * Returns the meta object for data type '{@link com.verticon.google.kmlgx.AltitudeModeEnumType <em>Altitude Mode Enum Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Altitude Mode Enum Type Object</em>'.
	 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
	 * @model instanceClass="com.verticon.google.kmlgx.AltitudeModeEnumType"
	 *        extendedMetaData="name='altitudeModeEnumType:Object' baseType='altitudeModeEnumType'"
	 * @generated
	 */
	EDataType getAltitudeModeEnumTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.google.kmlgx.FlyToModeEnumType <em>Fly To Mode Enum Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Fly To Mode Enum Type Object</em>'.
	 * @see com.verticon.google.kmlgx.FlyToModeEnumType
	 * @model instanceClass="com.verticon.google.kmlgx.FlyToModeEnumType"
	 *        extendedMetaData="name='flyToModeEnumType:Object' baseType='flyToModeEnumType'"
	 * @generated
	 */
	EDataType getFlyToModeEnumTypeObject();

	/**
	 * Returns the meta object for data type '<em>Outer Width Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Outer Width Type</em>'.
	 * @model instanceClass="float"
	 *        extendedMetaData="name='outerWidthType' baseType='http://www.eclipse.org/emf/2003/XMLType#float' minInclusive='0.0' maxInclusive='1.0'"
	 * @generated
	 */
	EDataType getOuterWidthType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Float <em>Outer Width Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Outer Width Type Object</em>'.
	 * @see java.lang.Float
	 * @model instanceClass="java.lang.Float"
	 *        extendedMetaData="name='outerWidthType:Object' baseType='outerWidthType'"
	 * @generated
	 */
	EDataType getOuterWidthTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.verticon.google.kmlgx.PlayModeEnumType <em>Play Mode Enum Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Play Mode Enum Type Object</em>'.
	 * @see com.verticon.google.kmlgx.PlayModeEnumType
	 * @model instanceClass="com.verticon.google.kmlgx.PlayModeEnumType"
	 *        extendedMetaData="name='playModeEnumType:Object' baseType='playModeEnumType'"
	 * @generated
	 */
	EDataType getPlayModeEnumTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KmlgxFactory getKmlgxFactory();

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
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.AnimatedUpdateImpl <em>Animated Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.AnimatedUpdateImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAnimatedUpdate()
		 * @generated
		 */
		EClass ANIMATED_UPDATE = eINSTANCE.getAnimatedUpdate();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMATED_UPDATE__DURATION = eINSTANCE.getAnimatedUpdate_Duration();

		/**
		 * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMATED_UPDATE__UPDATE = eINSTANCE.getAnimatedUpdate_Update();

		/**
		 * The meta object literal for the '<em><b>Delayed Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMATED_UPDATE__DELAYED_START = eINSTANCE.getAnimatedUpdate_DelayedStart();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.DocumentRootImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Abstract Tour Primitive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE = eINSTANCE.getDocumentRoot_AbstractTourPrimitive();

		/**
		 * The meta object literal for the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ABSTRACT_TOUR_PRIMITIVE_GROUP = eINSTANCE.getDocumentRoot_AbstractTourPrimitiveGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP = eINSTANCE.getDocumentRoot_AbstractTrackSimpleExtensionGroup();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ALTITUDE_MODE = eINSTANCE.getDocumentRoot_AltitudeMode();

		/**
		 * The meta object literal for the '<em><b>Altitude Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ALTITUDE_OFFSET = eINSTANCE.getDocumentRoot_AltitudeOffset();

		/**
		 * The meta object literal for the '<em><b>Angles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ANGLES = eINSTANCE.getDocumentRoot_Angles();

		/**
		 * The meta object literal for the '<em><b>Animated Update</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ANIMATED_UPDATE = eINSTANCE.getDocumentRoot_AnimatedUpdate();

		/**
		 * The meta object literal for the '<em><b>Balloon Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__BALLOON_VISIBILITY = eINSTANCE.getDocumentRoot_BalloonVisibility();

		/**
		 * The meta object literal for the '<em><b>Coord</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__COORD = eINSTANCE.getDocumentRoot_Coord();

		/**
		 * The meta object literal for the '<em><b>Delayed Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__DELAYED_START = eINSTANCE.getDocumentRoot_DelayedStart();

		/**
		 * The meta object literal for the '<em><b>Draw Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__DRAW_ORDER = eINSTANCE.getDocumentRoot_DrawOrder();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__DURATION = eINSTANCE.getDocumentRoot_Duration();

		/**
		 * The meta object literal for the '<em><b>Fly To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FLY_TO = eINSTANCE.getDocumentRoot_FlyTo();

		/**
		 * The meta object literal for the '<em><b>Fly To Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__FLY_TO_MODE = eINSTANCE.getDocumentRoot_FlyToMode();

		/**
		 * The meta object literal for the '<em><b>H</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__H = eINSTANCE.getDocumentRoot_H();

		/**
		 * The meta object literal for the '<em><b>Interpolate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__INTERPOLATE = eINSTANCE.getDocumentRoot_Interpolate();

		/**
		 * The meta object literal for the '<em><b>Lat Lon Quad</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LAT_LON_QUAD = eINSTANCE.getDocumentRoot_LatLonQuad();

		/**
		 * The meta object literal for the '<em><b>Multi Track</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MULTI_TRACK = eINSTANCE.getDocumentRoot_MultiTrack();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OPTION = eINSTANCE.getDocumentRoot_Option();

		/**
		 * The meta object literal for the '<em><b>Outer Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__OUTER_COLOR = eINSTANCE.getDocumentRoot_OuterColor();

		/**
		 * The meta object literal for the '<em><b>Outer Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__OUTER_WIDTH = eINSTANCE.getDocumentRoot_OuterWidth();

		/**
		 * The meta object literal for the '<em><b>Physical Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__PHYSICAL_WIDTH = eINSTANCE.getDocumentRoot_PhysicalWidth();

		/**
		 * The meta object literal for the '<em><b>Playlist</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PLAYLIST = eINSTANCE.getDocumentRoot_Playlist();

		/**
		 * The meta object literal for the '<em><b>Play Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__PLAY_MODE = eINSTANCE.getDocumentRoot_PlayMode();

		/**
		 * The meta object literal for the '<em><b>Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__RANK = eINSTANCE.getDocumentRoot_Rank();

		/**
		 * The meta object literal for the '<em><b>Simple Array Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SIMPLE_ARRAY_DATA = eINSTANCE.getDocumentRoot_SimpleArrayData();

		/**
		 * The meta object literal for the '<em><b>Simple Array Data Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SIMPLE_ARRAY_DATA_EXTENSION = eINSTANCE.getDocumentRoot_SimpleArrayDataExtension();

		/**
		 * The meta object literal for the '<em><b>Simple Array Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD = eINSTANCE.getDocumentRoot_SimpleArrayField();

		/**
		 * The meta object literal for the '<em><b>Simple Array Field Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SIMPLE_ARRAY_FIELD_EXTENSION = eINSTANCE.getDocumentRoot_SimpleArrayFieldExtension();

		/**
		 * The meta object literal for the '<em><b>Sound Cue</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SOUND_CUE = eINSTANCE.getDocumentRoot_SoundCue();

		/**
		 * The meta object literal for the '<em><b>Time Span</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TIME_SPAN = eINSTANCE.getDocumentRoot_TimeSpan();

		/**
		 * The meta object literal for the '<em><b>Time Stamp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TIME_STAMP = eINSTANCE.getDocumentRoot_TimeStamp();

		/**
		 * The meta object literal for the '<em><b>Tour</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TOUR = eINSTANCE.getDocumentRoot_Tour();

		/**
		 * The meta object literal for the '<em><b>Tour Control</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TOUR_CONTROL = eINSTANCE.getDocumentRoot_TourControl();

		/**
		 * The meta object literal for the '<em><b>Track</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TRACK = eINSTANCE.getDocumentRoot_Track();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__VALUE = eINSTANCE.getDocumentRoot_Value();

		/**
		 * The meta object literal for the '<em><b>Viewer Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__VIEWER_OPTIONS = eINSTANCE.getDocumentRoot_ViewerOptions();

		/**
		 * The meta object literal for the '<em><b>W</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__W = eINSTANCE.getDocumentRoot_W();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__WAIT = eINSTANCE.getDocumentRoot_Wait();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__X = eINSTANCE.getDocumentRoot_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__Y = eINSTANCE.getDocumentRoot_Y();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.FlyToImpl <em>Fly To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.FlyToImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyTo()
		 * @generated
		 */
		EClass FLY_TO = eINSTANCE.getFlyTo();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLY_TO__DURATION = eINSTANCE.getFlyTo_Duration();

		/**
		 * The meta object literal for the '<em><b>Fly To Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLY_TO__FLY_TO_MODE = eINSTANCE.getFlyTo_FlyToMode();

		/**
		 * The meta object literal for the '<em><b>Abstract View Group Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLY_TO__ABSTRACT_VIEW_GROUP_GROUP = eINSTANCE.getFlyTo_AbstractViewGroupGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract View Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLY_TO__ABSTRACT_VIEW_GROUP = eINSTANCE.getFlyTo_AbstractViewGroup();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.LatLonQuadImpl <em>Lat Lon Quad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.LatLonQuadImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getLatLonQuad()
		 * @generated
		 */
		EClass LAT_LON_QUAD = eINSTANCE.getLatLonQuad();

		/**
		 * The meta object literal for the '<em><b>Coordinates</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAT_LON_QUAD__COORDINATES = eINSTANCE.getLatLonQuad_Coordinates();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.MultiTrackImpl <em>Multi Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.MultiTrackImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getMultiTrack()
		 * @generated
		 */
		EClass MULTI_TRACK = eINSTANCE.getMultiTrack();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode Group Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TRACK__ALTITUDE_MODE_GROUP_GROUP = eINSTANCE.getMultiTrack_AltitudeModeGroupGroup();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_TRACK__ALTITUDE_MODE_GROUP = eINSTANCE.getMultiTrack_AltitudeModeGroup();

		/**
		 * The meta object literal for the '<em><b>Interpolate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TRACK__INTERPOLATE = eINSTANCE.getMultiTrack_Interpolate();

		/**
		 * The meta object literal for the '<em><b>Track</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_TRACK__TRACK = eINSTANCE.getMultiTrack_Track();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.OptionImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__ENABLED = eINSTANCE.getOption_Enabled();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.PlaylistImpl <em>Playlist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.PlaylistImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlaylist()
		 * @generated
		 */
		EClass PLAYLIST = eINSTANCE.getPlaylist();

		/**
		 * The meta object literal for the '<em><b>Abstract Tour Primitive Group Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP_GROUP = eINSTANCE.getPlaylist_AbstractTourPrimitiveGroupGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract Tour Primitive Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYLIST__ABSTRACT_TOUR_PRIMITIVE_GROUP = eINSTANCE.getPlaylist_AbstractTourPrimitiveGroup();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.SimpleArrayDataImpl <em>Simple Array Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.SimpleArrayDataImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSimpleArrayData()
		 * @generated
		 */
		EClass SIMPLE_ARRAY_DATA = eINSTANCE.getSimpleArrayData();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_DATA__VALUE = eINSTANCE.getSimpleArrayData_Value();

		/**
		 * The meta object literal for the '<em><b>Simple Array Data Extension Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION_GROUP = eINSTANCE.getSimpleArrayData_SimpleArrayDataExtensionGroup();

		/**
		 * The meta object literal for the '<em><b>Simple Array Data Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_ARRAY_DATA__SIMPLE_ARRAY_DATA_EXTENSION = eINSTANCE.getSimpleArrayData_SimpleArrayDataExtension();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_DATA__NAME = eINSTANCE.getSimpleArrayData_Name();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl <em>Simple Array Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.SimpleArrayFieldImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSimpleArrayField()
		 * @generated
		 */
		EClass SIMPLE_ARRAY_FIELD = eINSTANCE.getSimpleArrayField();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_FIELD__DISPLAY_NAME = eINSTANCE.getSimpleArrayField_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Simple Array Field Extension Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION_GROUP = eINSTANCE.getSimpleArrayField_SimpleArrayFieldExtensionGroup();

		/**
		 * The meta object literal for the '<em><b>Simple Array Field Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_ARRAY_FIELD__SIMPLE_ARRAY_FIELD_EXTENSION = eINSTANCE.getSimpleArrayField_SimpleArrayFieldExtension();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_FIELD__NAME = eINSTANCE.getSimpleArrayField_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_ARRAY_FIELD__TYPE = eINSTANCE.getSimpleArrayField_Type();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.SoundCueImpl <em>Sound Cue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.SoundCueImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getSoundCue()
		 * @generated
		 */
		EClass SOUND_CUE = eINSTANCE.getSoundCue();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOUND_CUE__HREF = eINSTANCE.getSoundCue_Href();

		/**
		 * The meta object literal for the '<em><b>Delayed Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOUND_CUE__DELAYED_START = eINSTANCE.getSoundCue_DelayedStart();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.TourImpl <em>Tour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.TourImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTour()
		 * @generated
		 */
		EClass TOUR = eINSTANCE.getTour();

		/**
		 * The meta object literal for the '<em><b>Playlist</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOUR__PLAYLIST = eINSTANCE.getTour_Playlist();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.TourControlImpl <em>Tour Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.TourControlImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTourControl()
		 * @generated
		 */
		EClass TOUR_CONTROL = eINSTANCE.getTourControl();

		/**
		 * The meta object literal for the '<em><b>Play Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOUR_CONTROL__PLAY_MODE = eINSTANCE.getTourControl_PlayMode();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.TourPrimitiveImpl <em>Tour Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.TourPrimitiveImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTourPrimitive()
		 * @generated
		 */
		EClass TOUR_PRIMITIVE = eINSTANCE.getTourPrimitive();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.TrackImpl <em>Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.TrackImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getTrack()
		 * @generated
		 */
		EClass TRACK = eINSTANCE.getTrack();

		/**
		 * The meta object literal for the '<em><b>Extrude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__EXTRUDE = eINSTANCE.getTrack_Extrude();

		/**
		 * The meta object literal for the '<em><b>Tessellate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__TESSELLATE = eINSTANCE.getTrack_Tessellate();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode Group Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__ALTITUDE_MODE_GROUP_GROUP = eINSTANCE.getTrack_AltitudeModeGroupGroup();

		/**
		 * The meta object literal for the '<em><b>Altitude Mode Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACK__ALTITUDE_MODE_GROUP = eINSTANCE.getTrack_AltitudeModeGroup();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__WHEN = eINSTANCE.getTrack_When();

		/**
		 * The meta object literal for the '<em><b>Coord</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__COORD = eINSTANCE.getTrack_Coord();

		/**
		 * The meta object literal for the '<em><b>Angles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__ANGLES = eINSTANCE.getTrack_Angles();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACK__MODEL = eINSTANCE.getTrack_Model();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACK__EXTENDED_DATA = eINSTANCE.getTrack_ExtendedData();

		/**
		 * The meta object literal for the '<em><b>Abstract Track Simple Extension Group Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP = eINSTANCE.getTrack_AbstractTrackSimpleExtensionGroupGroup();

		/**
		 * The meta object literal for the '<em><b>Abstract Track Simple Extension Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP = eINSTANCE.getTrack_AbstractTrackSimpleExtensionGroup();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.ViewerOptionsImpl <em>Viewer Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.ViewerOptionsImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getViewerOptions()
		 * @generated
		 */
		EClass VIEWER_OPTIONS = eINSTANCE.getViewerOptions();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEWER_OPTIONS__OPTION = eINSTANCE.getViewerOptions_Option();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.impl.WaitImpl <em>Wait</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.WaitImpl
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getWait()
		 * @generated
		 */
		EClass WAIT = eINSTANCE.getWait();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT__DURATION = eINSTANCE.getWait_Duration();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.AltitudeModeEnumType <em>Altitude Mode Enum Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAltitudeModeEnumType()
		 * @generated
		 */
		EEnum ALTITUDE_MODE_ENUM_TYPE = eINSTANCE.getAltitudeModeEnumType();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.FlyToModeEnumType <em>Fly To Mode Enum Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.FlyToModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyToModeEnumType()
		 * @generated
		 */
		EEnum FLY_TO_MODE_ENUM_TYPE = eINSTANCE.getFlyToModeEnumType();

		/**
		 * The meta object literal for the '{@link com.verticon.google.kmlgx.PlayModeEnumType <em>Play Mode Enum Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.PlayModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlayModeEnumType()
		 * @generated
		 */
		EEnum PLAY_MODE_ENUM_TYPE = eINSTANCE.getPlayModeEnumType();

		/**
		 * The meta object literal for the '<em>Altitude Mode Enum Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.AltitudeModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getAltitudeModeEnumTypeObject()
		 * @generated
		 */
		EDataType ALTITUDE_MODE_ENUM_TYPE_OBJECT = eINSTANCE.getAltitudeModeEnumTypeObject();

		/**
		 * The meta object literal for the '<em>Fly To Mode Enum Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.FlyToModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getFlyToModeEnumTypeObject()
		 * @generated
		 */
		EDataType FLY_TO_MODE_ENUM_TYPE_OBJECT = eINSTANCE.getFlyToModeEnumTypeObject();

		/**
		 * The meta object literal for the '<em>Outer Width Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOuterWidthType()
		 * @generated
		 */
		EDataType OUTER_WIDTH_TYPE = eINSTANCE.getOuterWidthType();

		/**
		 * The meta object literal for the '<em>Outer Width Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Float
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getOuterWidthTypeObject()
		 * @generated
		 */
		EDataType OUTER_WIDTH_TYPE_OBJECT = eINSTANCE.getOuterWidthTypeObject();

		/**
		 * The meta object literal for the '<em>Play Mode Enum Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.verticon.google.kmlgx.PlayModeEnumType
		 * @see com.verticon.google.kmlgx.impl.KmlgxPackageImpl#getPlayModeEnumTypeObject()
		 * @generated
		 */
		EDataType PLAY_MODE_ENUM_TYPE_OBJECT = eINSTANCE.getPlayModeEnumTypeObject();

	}

} //KmlgxPackage
