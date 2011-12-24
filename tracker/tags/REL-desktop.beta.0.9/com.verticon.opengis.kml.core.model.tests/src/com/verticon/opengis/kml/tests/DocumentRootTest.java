/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.opengis.kml.tests;

import com.verticon.opengis.kml.DocumentRoot;
import com.verticon.opengis.kml.KmlFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleGroup() <em>Abstract Color Style Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleGroup() <em>Abstract Sub Style Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractObjectGroup() <em>Abstract Object Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleObjectExtensionGroup() <em>Abstract Color Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleSimpleExtensionGroup() <em>Abstract Color Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerGroup() <em>Abstract Container Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureGroup() <em>Abstract Feature Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerObjectExtensionGroup() <em>Abstract Container Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerSimpleExtensionGroup() <em>Abstract Container Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureObjectExtensionGroup() <em>Abstract Feature Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureSimpleExtensionGroup() <em>Abstract Feature Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryGroup() <em>Abstract Geometry Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryObjectExtensionGroup() <em>Abstract Geometry Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometrySimpleExtensionGroup() <em>Abstract Geometry Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxObjectExtensionGroup() <em>Abstract Lat Lon Box Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxSimpleExtensionGroup() <em>Abstract Lat Lon Box Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayGroup() <em>Abstract Overlay Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayObjectExtensionGroup() <em>Abstract Overlay Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlaySimpleExtensionGroup() <em>Abstract Overlay Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorGroup() <em>Abstract Style Selector Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorObjectExtensionGroup() <em>Abstract Style Selector Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorSimpleExtensionGroup() <em>Abstract Style Selector Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleObjectExtensionGroup() <em>Abstract Sub Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleSimpleExtensionGroup() <em>Abstract Sub Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveGroup() <em>Abstract Time Primitive Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveObjectExtensionGroup() <em>Abstract Time Primitive Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveSimpleExtensionGroup() <em>Abstract Time Primitive Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewGroup() <em>Abstract View Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewObjectExtensionGroup() <em>Abstract View Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewSimpleExtensionGroup() <em>Abstract View Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAddress() <em>Address</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAlias() <em>Alias</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAliasObjectExtensionGroup() <em>Alias Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAliasSimpleExtensionGroup() <em>Alias Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAltitude() <em>Altitude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAltitudeMode() <em>Altitude Mode</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getAltitudeModeGroup() <em>Altitude Mode Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyle() <em>Balloon Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyleObjectExtensionGroup() <em>Balloon Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyleSimpleExtensionGroup() <em>Balloon Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBasicLinkObjectExtensionGroup() <em>Basic Link Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBasicLinkSimpleExtensionGroup() <em>Basic Link Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBegin() <em>Begin</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBgColor() <em>Bg Color</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBottomFov() <em>Bottom Fov</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBoundaryObjectExtensionGroup() <em>Boundary Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getBoundarySimpleExtensionGroup() <em>Boundary Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCamera() <em>Camera</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCameraObjectExtensionGroup() <em>Camera Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCameraSimpleExtensionGroup() <em>Camera Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getChange() <em>Change</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getColor() <em>Color</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getColorMode() <em>Color Mode</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCookie() <em>Cookie</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCoordinates() <em>Coordinates</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getCreate() <em>Create</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getData() <em>Data</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDataExtension() <em>Data Extension</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDelete() <em>Delete</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDescription() <em>Description</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDisplayMode() <em>Display Mode</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDisplayName() <em>Display Name</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDocument() <em>Document</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDocumentObjectExtensionGroup() <em>Document Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDocumentSimpleExtensionGroup() <em>Document Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getDrawOrder() <em>Draw Order</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getEast() <em>East</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getEnd() <em>End</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getExpires() <em>Expires</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getExtendedData() <em>Extended Data</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isExtrude() <em>Extrude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isFill() <em>Fill</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isFlyToView() <em>Fly To View</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getFolder() <em>Folder</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getFolderObjectExtensionGroup() <em>Folder Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getFolderSimpleExtensionGroup() <em>Folder Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getGridOrigin() <em>Grid Origin</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlay() <em>Ground Overlay</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlayObjectExtensionGroup() <em>Ground Overlay Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlaySimpleExtensionGroup() <em>Ground Overlay Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getHeading() <em>Heading</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getHotSpot() <em>Hot Spot</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getHref() <em>Href</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getHttpQuery() <em>Http Query</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getIcon() <em>Icon</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getIconStyle() <em>Icon Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getIconStyleObjectExtensionGroup() <em>Icon Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getIconStyleSimpleExtensionGroup() <em>Icon Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramid() <em>Image Pyramid</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramidObjectExtensionGroup() <em>Image Pyramid Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramidSimpleExtensionGroup() <em>Image Pyramid Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getInnerBoundaryIs() <em>Inner Boundary Is</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getItemIcon() <em>Item Icon</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getItemIconObjectExtensionGroup() <em>Item Icon Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getItemIconSimpleExtensionGroup() <em>Item Icon Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getKey() <em>Key</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getKml() <em>Kml</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getKmlObjectExtensionGroup() <em>Kml Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getKmlSimpleExtensionGroup() <em>Kml Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyle() <em>Label Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyleObjectExtensionGroup() <em>Label Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyleSimpleExtensionGroup() <em>Label Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatitude() <em>Latitude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBox() <em>Lat Lon Alt Box</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxObjectExtensionGroup() <em>Lat Lon Alt Box Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxSimpleExtensionGroup() <em>Lat Lon Alt Box Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBox() <em>Lat Lon Box</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBoxObjectExtensionGroup() <em>Lat Lon Box Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBoxSimpleExtensionGroup() <em>Lat Lon Box Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLeftFov() <em>Left Fov</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinearRing() <em>Linear Ring</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinearRingObjectExtensionGroup() <em>Linear Ring Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinearRingSimpleExtensionGroup() <em>Linear Ring Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineString() <em>Line String</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineStringObjectExtensionGroup() <em>Line String Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineStringSimpleExtensionGroup() <em>Line String Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineStyle() <em>Line Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineStyleObjectExtensionGroup() <em>Line Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLineStyleSimpleExtensionGroup() <em>Line Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLink() <em>Link</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinkDescription() <em>Link Description</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinkName() <em>Link Name</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinkObjectExtensionGroup() <em>Link Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinkSimpleExtensionGroup() <em>Link Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLinkSnippet() <em>Link Snippet</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getListItemType() <em>List Item Type</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getListStyle() <em>List Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getListStyleObjectExtensionGroup() <em>List Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getListStyleSimpleExtensionGroup() <em>List Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLocation() <em>Location</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLocationObjectExtensionGroup() <em>Location Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLocationSimpleExtensionGroup() <em>Location Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLod() <em>Lod</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLodObjectExtensionGroup() <em>Lod Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLodSimpleExtensionGroup() <em>Lod Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLongitude() <em>Longitude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLookAt() <em>Look At</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLookAtObjectExtensionGroup() <em>Look At Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getLookAtSimpleExtensionGroup() <em>Look At Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxAltitude() <em>Max Altitude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxFadeExtent() <em>Max Fade Extent</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxHeight() <em>Max Height</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxLodPixels() <em>Max Lod Pixels</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxSessionLength() <em>Max Session Length</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxSnippetLines() <em>Max Snippet Lines</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMaxWidth() <em>Max Width</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMessage() <em>Message</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMetadata() <em>Metadata</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMinAltitude() <em>Min Altitude</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMinFadeExtent() <em>Min Fade Extent</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMinLodPixels() <em>Min Lod Pixels</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMinRefreshPeriod() <em>Min Refresh Period</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getModel() <em>Model</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getModelObjectExtensionGroup() <em>Model Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getModelSimpleExtensionGroup() <em>Model Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometry() <em>Multi Geometry</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometryObjectExtensionGroup() <em>Multi Geometry Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometrySimpleExtensionGroup() <em>Multi Geometry Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getName() <em>Name</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNear() <em>Near</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLink() <em>Network Link</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControl() <em>Network Link Control</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlObjectExtensionGroup() <em>Network Link Control Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlSimpleExtensionGroup() <em>Network Link Control Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkObjectExtensionGroup() <em>Network Link Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkSimpleExtensionGroup() <em>Network Link Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getNorth() <em>North</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getObjectSimpleExtensionGroup() <em>Object Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isOpen() <em>Open</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getOrientation() <em>Orientation</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getOrientationObjectExtensionGroup() <em>Orientation Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getOrientationSimpleExtensionGroup() <em>Orientation Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getOuterBoundaryIs() <em>Outer Boundary Is</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isOutline() <em>Outline</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getOverlayXY() <em>Overlay XY</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPair() <em>Pair</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPairObjectExtensionGroup() <em>Pair Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPairSimpleExtensionGroup() <em>Pair Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPhoneNumber() <em>Phone Number</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlay() <em>Photo Overlay</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlayObjectExtensionGroup() <em>Photo Overlay Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlaySimpleExtensionGroup() <em>Photo Overlay Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPlacemark() <em>Placemark</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPlacemarkObjectExtensionGroup() <em>Placemark Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPlacemarkSimpleExtensionGroup() <em>Placemark Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPoint() <em>Point</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPointObjectExtensionGroup() <em>Point Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPointSimpleExtensionGroup() <em>Point Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolygon() <em>Polygon</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolygonObjectExtensionGroup() <em>Polygon Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolygonSimpleExtensionGroup() <em>Polygon Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyle() <em>Poly Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyleObjectExtensionGroup() <em>Poly Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyleSimpleExtensionGroup() <em>Poly Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRange() <em>Range</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRefreshInterval() <em>Refresh Interval</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRefreshMode() <em>Refresh Mode</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isRefreshVisibility() <em>Refresh Visibility</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRegion() <em>Region</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRegionObjectExtensionGroup() <em>Region Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRegionSimpleExtensionGroup() <em>Region Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getResourceMap() <em>Resource Map</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getResourceMapObjectExtensionGroup() <em>Resource Map Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getResourceMapSimpleExtensionGroup() <em>Resource Map Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRightFov() <em>Right Fov</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRoll() <em>Roll</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRotation() <em>Rotation</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getRotationXY() <em>Rotation XY</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScale() <em>Scale</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScale1() <em>Scale1</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScaleObjectExtensionGroup() <em>Scale Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScaleSimpleExtensionGroup() <em>Scale Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSchema() <em>Schema</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSchemaData() <em>Schema Data</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSchemaDataExtension() <em>Schema Data Extension</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSchemaExtension() <em>Schema Extension</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlay() <em>Screen Overlay</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlayObjectExtensionGroup() <em>Screen Overlay Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlaySimpleExtensionGroup() <em>Screen Overlay Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getScreenXY() <em>Screen XY</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getShape() <em>Shape</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSimpleData() <em>Simple Data</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSimpleField() <em>Simple Field</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSimpleFieldExtension() <em>Simple Field Extension</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSize() <em>Size</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSnippet() <em>Snippet</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSnippet1() <em>Snippet1</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSourceHref() <em>Source Href</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getSouth() <em>South</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getState() <em>State</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyle() <em>Style</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleMap() <em>Style Map</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleMapObjectExtensionGroup() <em>Style Map Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleMapSimpleExtensionGroup() <em>Style Map Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleObjectExtensionGroup() <em>Style Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleSimpleExtensionGroup() <em>Style Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getStyleUrl() <em>Style Url</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTargetHref() <em>Target Href</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isTessellate() <em>Tessellate</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getText() <em>Text</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTextColor() <em>Text Color</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTileSize() <em>Tile Size</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTilt() <em>Tilt</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpan() <em>Time Span</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpanObjectExtensionGroup() <em>Time Span Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpanSimpleExtensionGroup() <em>Time Span Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeStamp() <em>Time Stamp</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeStampObjectExtensionGroup() <em>Time Stamp Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTimeStampSimpleExtensionGroup() <em>Time Stamp Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getTopFov() <em>Top Fov</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getUpdate() <em>Update</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getUpdateExtensionGroup() <em>Update Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getUpdateOpExtensionGroup() <em>Update Op Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getUrl() <em>Url</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getValue() <em>Value</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewBoundScale() <em>View Bound Scale</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewFormat() <em>View Format</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewRefreshMode() <em>View Refresh Mode</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewRefreshTime() <em>View Refresh Time</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewVolume() <em>View Volume</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewVolumeObjectExtensionGroup() <em>View Volume Object Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getViewVolumeSimpleExtensionGroup() <em>View Volume Simple Extension Group</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#isVisibility() <em>Visibility</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getWest() <em>West</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getWhen() <em>When</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getWidth() <em>Width</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getX() <em>X</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getY() <em>Y</em>}</li>
 *   <li>{@link com.verticon.opengis.kml.DocumentRoot#getZ() <em>Z</em>}</li>
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
		setFixture(KmlFactory.eINSTANCE.createDocumentRoot());
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
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleGroup() <em>Abstract Color Style Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleGroup()
	 * @generated
	 */
	public void testGetAbstractColorStyleGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleGroup() <em>Abstract Sub Style Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleGroup()
	 * @generated
	 */
	public void testGetAbstractSubStyleGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractObjectGroup() <em>Abstract Object Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractObjectGroup()
	 * @generated
	 */
	public void testGetAbstractObjectGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleObjectExtensionGroup() <em>Abstract Color Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractColorStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleSimpleExtensionGroup() <em>Abstract Color Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractColorStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractColorStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerGroup() <em>Abstract Container Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractContainerGroup()
	 * @generated
	 */
	public void testGetAbstractContainerGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureGroup() <em>Abstract Feature Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureGroup()
	 * @generated
	 */
	public void testGetAbstractFeatureGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerObjectExtensionGroup() <em>Abstract Container Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractContainerObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractContainerObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractContainerSimpleExtensionGroup() <em>Abstract Container Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractContainerSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractContainerSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureObjectExtensionGroup() <em>Abstract Feature Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractFeatureObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureSimpleExtensionGroup() <em>Abstract Feature Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractFeatureSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractFeatureSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryGroup() <em>Abstract Geometry Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryGroup()
	 * @generated
	 */
	public void testGetAbstractGeometryGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryObjectExtensionGroup() <em>Abstract Geometry Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractGeometryObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractGeometryObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractGeometrySimpleExtensionGroup() <em>Abstract Geometry Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractGeometrySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractGeometrySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxObjectExtensionGroup() <em>Abstract Lat Lon Box Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractLatLonBoxObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxSimpleExtensionGroup() <em>Abstract Lat Lon Box Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractLatLonBoxSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractLatLonBoxSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayGroup() <em>Abstract Overlay Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayGroup()
	 * @generated
	 */
	public void testGetAbstractOverlayGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayObjectExtensionGroup() <em>Abstract Overlay Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractOverlayObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractOverlayObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractOverlaySimpleExtensionGroup() <em>Abstract Overlay Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractOverlaySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractOverlaySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorGroup() <em>Abstract Style Selector Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorGroup()
	 * @generated
	 */
	public void testGetAbstractStyleSelectorGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorObjectExtensionGroup() <em>Abstract Style Selector Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractStyleSelectorObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorSimpleExtensionGroup() <em>Abstract Style Selector Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractStyleSelectorSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractStyleSelectorSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleObjectExtensionGroup() <em>Abstract Sub Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractSubStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleSimpleExtensionGroup() <em>Abstract Sub Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractSubStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractSubStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveGroup() <em>Abstract Time Primitive Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveGroup()
	 * @generated
	 */
	public void testGetAbstractTimePrimitiveGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveObjectExtensionGroup() <em>Abstract Time Primitive Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractTimePrimitiveObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveSimpleExtensionGroup() <em>Abstract Time Primitive Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractTimePrimitiveSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractTimePrimitiveSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewGroup() <em>Abstract View Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractViewGroup()
	 * @generated
	 */
	public void testGetAbstractViewGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewObjectExtensionGroup() <em>Abstract View Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractViewObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractViewObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAbstractViewSimpleExtensionGroup() <em>Abstract View Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAbstractViewSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAbstractViewSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAddress() <em>Address</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAddress()
	 * @generated
	 */
	public void testGetAddress() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setAddress(java.lang.String) <em>Address</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setAddress(java.lang.String)
	 * @generated
	 */
	public void testSetAddress() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAlias() <em>Alias</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAlias()
	 * @generated
	 */
	public void testGetAlias() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setAlias(com.verticon.opengis.kml.Alias) <em>Alias</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setAlias(com.verticon.opengis.kml.Alias)
	 * @generated
	 */
	public void testSetAlias() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAliasObjectExtensionGroup() <em>Alias Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAliasObjectExtensionGroup()
	 * @generated
	 */
	public void testGetAliasObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAliasSimpleExtensionGroup() <em>Alias Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAliasSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetAliasSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAltitude() <em>Altitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAltitude()
	 * @generated
	 */
	public void testGetAltitude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setAltitude(double) <em>Altitude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setAltitude(double)
	 * @generated
	 */
	public void testSetAltitude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAltitudeMode() <em>Altitude Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAltitudeMode()
	 * @generated
	 */
	public void testGetAltitudeMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setAltitudeMode(com.verticon.opengis.kml.AltitudeModeEnumType) <em>Altitude Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setAltitudeMode(com.verticon.opengis.kml.AltitudeModeEnumType)
	 * @generated
	 */
	public void testSetAltitudeMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getAltitudeModeGroup() <em>Altitude Mode Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getAltitudeModeGroup()
	 * @generated
	 */
	public void testGetAltitudeModeGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyle() <em>Balloon Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBalloonStyle()
	 * @generated
	 */
	public void testGetBalloonStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setBalloonStyle(com.verticon.opengis.kml.BalloonStyle) <em>Balloon Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setBalloonStyle(com.verticon.opengis.kml.BalloonStyle)
	 * @generated
	 */
	public void testSetBalloonStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyleObjectExtensionGroup() <em>Balloon Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBalloonStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetBalloonStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBalloonStyleSimpleExtensionGroup() <em>Balloon Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBalloonStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetBalloonStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBasicLinkObjectExtensionGroup() <em>Basic Link Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBasicLinkObjectExtensionGroup()
	 * @generated
	 */
	public void testGetBasicLinkObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBasicLinkSimpleExtensionGroup() <em>Basic Link Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBasicLinkSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetBasicLinkSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBegin() <em>Begin</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBegin()
	 * @generated
	 */
	public void testGetBegin() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setBegin(javax.xml.datatype.XMLGregorianCalendar) <em>Begin</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setBegin(javax.xml.datatype.XMLGregorianCalendar)
	 * @generated
	 */
	public void testSetBegin() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBgColor() <em>Bg Color</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBgColor()
	 * @generated
	 */
	public void testGetBgColor() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setBgColor(byte[]) <em>Bg Color</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setBgColor(byte[])
	 * @generated
	 */
	public void testSetBgColor() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBottomFov() <em>Bottom Fov</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBottomFov()
	 * @generated
	 */
	public void testGetBottomFov() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setBottomFov(double) <em>Bottom Fov</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setBottomFov(double)
	 * @generated
	 */
	public void testSetBottomFov() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBoundaryObjectExtensionGroup() <em>Boundary Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBoundaryObjectExtensionGroup()
	 * @generated
	 */
	public void testGetBoundaryObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getBoundarySimpleExtensionGroup() <em>Boundary Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getBoundarySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetBoundarySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCamera() <em>Camera</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCamera()
	 * @generated
	 */
	public void testGetCamera() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setCamera(com.verticon.opengis.kml.Camera) <em>Camera</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setCamera(com.verticon.opengis.kml.Camera)
	 * @generated
	 */
	public void testSetCamera() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCameraObjectExtensionGroup() <em>Camera Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCameraObjectExtensionGroup()
	 * @generated
	 */
	public void testGetCameraObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCameraSimpleExtensionGroup() <em>Camera Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCameraSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetCameraSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getChange() <em>Change</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getChange()
	 * @generated
	 */
	public void testGetChange() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setChange(com.verticon.opengis.kml.Change) <em>Change</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setChange(com.verticon.opengis.kml.Change)
	 * @generated
	 */
	public void testSetChange() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getColor() <em>Color</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getColor()
	 * @generated
	 */
	public void testGetColor() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setColor(byte[]) <em>Color</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setColor(byte[])
	 * @generated
	 */
	public void testSetColor() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getColorMode() <em>Color Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getColorMode()
	 * @generated
	 */
	public void testGetColorMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setColorMode(com.verticon.opengis.kml.ColorModeEnumType) <em>Color Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setColorMode(com.verticon.opengis.kml.ColorModeEnumType)
	 * @generated
	 */
	public void testSetColorMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCookie() <em>Cookie</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCookie()
	 * @generated
	 */
	public void testGetCookie() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setCookie(java.lang.String) <em>Cookie</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setCookie(java.lang.String)
	 * @generated
	 */
	public void testSetCookie() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCoordinates() <em>Coordinates</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCoordinates()
	 * @generated
	 */
	public void testGetCoordinates() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setCoordinates(java.util.List) <em>Coordinates</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setCoordinates(java.util.List)
	 * @generated
	 */
	public void testSetCoordinates() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getCreate() <em>Create</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getCreate()
	 * @generated
	 */
	public void testGetCreate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setCreate(com.verticon.opengis.kml.Create) <em>Create</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setCreate(com.verticon.opengis.kml.Create)
	 * @generated
	 */
	public void testSetCreate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getData() <em>Data</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getData()
	 * @generated
	 */
	public void testGetData() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setData(com.verticon.opengis.kml.Data) <em>Data</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setData(com.verticon.opengis.kml.Data)
	 * @generated
	 */
	public void testSetData() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDataExtension() <em>Data Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDataExtension()
	 * @generated
	 */
	public void testGetDataExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDelete() <em>Delete</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDelete()
	 * @generated
	 */
	public void testGetDelete() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDelete(com.verticon.opengis.kml.Delete) <em>Delete</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDelete(com.verticon.opengis.kml.Delete)
	 * @generated
	 */
	public void testSetDelete() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDescription() <em>Description</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDescription()
	 * @generated
	 */
	public void testGetDescription() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDescription(java.lang.String) <em>Description</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDescription(java.lang.String)
	 * @generated
	 */
	public void testSetDescription() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDisplayMode() <em>Display Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDisplayMode()
	 * @generated
	 */
	public void testGetDisplayMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDisplayMode(com.verticon.opengis.kml.DisplayModeEnumType) <em>Display Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDisplayMode(com.verticon.opengis.kml.DisplayModeEnumType)
	 * @generated
	 */
	public void testSetDisplayMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDisplayName() <em>Display Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDisplayName()
	 * @generated
	 */
	public void testGetDisplayName() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDisplayName(java.lang.String) <em>Display Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDisplayName(java.lang.String)
	 * @generated
	 */
	public void testSetDisplayName() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDocument() <em>Document</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDocument()
	 * @generated
	 */
	public void testGetDocument() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDocument(com.verticon.opengis.kml.Document) <em>Document</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDocument(com.verticon.opengis.kml.Document)
	 * @generated
	 */
	public void testSetDocument() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDocumentObjectExtensionGroup() <em>Document Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDocumentObjectExtensionGroup()
	 * @generated
	 */
	public void testGetDocumentObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDocumentSimpleExtensionGroup() <em>Document Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDocumentSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetDocumentSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getDrawOrder() <em>Draw Order</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getDrawOrder()
	 * @generated
	 */
	public void testGetDrawOrder() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setDrawOrder(int) <em>Draw Order</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setDrawOrder(int)
	 * @generated
	 */
	public void testSetDrawOrder() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getEast() <em>East</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getEast()
	 * @generated
	 */
	public void testGetEast() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setEast(double) <em>East</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setEast(double)
	 * @generated
	 */
	public void testSetEast() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getEnd() <em>End</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getEnd()
	 * @generated
	 */
	public void testGetEnd() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setEnd(javax.xml.datatype.XMLGregorianCalendar) <em>End</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setEnd(javax.xml.datatype.XMLGregorianCalendar)
	 * @generated
	 */
	public void testSetEnd() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getExpires() <em>Expires</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getExpires()
	 * @generated
	 */
	public void testGetExpires() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setExpires(javax.xml.datatype.XMLGregorianCalendar) <em>Expires</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setExpires(javax.xml.datatype.XMLGregorianCalendar)
	 * @generated
	 */
	public void testSetExpires() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getExtendedData() <em>Extended Data</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getExtendedData()
	 * @generated
	 */
	public void testGetExtendedData() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setExtendedData(com.verticon.opengis.kml.ExtendedData) <em>Extended Data</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setExtendedData(com.verticon.opengis.kml.ExtendedData)
	 * @generated
	 */
	public void testSetExtendedData() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isExtrude() <em>Extrude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isExtrude()
	 * @generated
	 */
	public void testIsExtrude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setExtrude(boolean) <em>Extrude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setExtrude(boolean)
	 * @generated
	 */
	public void testSetExtrude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isFill() <em>Fill</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isFill()
	 * @generated
	 */
	public void testIsFill() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setFill(boolean) <em>Fill</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setFill(boolean)
	 * @generated
	 */
	public void testSetFill() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isFlyToView() <em>Fly To View</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isFlyToView()
	 * @generated
	 */
	public void testIsFlyToView() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setFlyToView(boolean) <em>Fly To View</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setFlyToView(boolean)
	 * @generated
	 */
	public void testSetFlyToView() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getFolder() <em>Folder</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getFolder()
	 * @generated
	 */
	public void testGetFolder() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setFolder(com.verticon.opengis.kml.Folder) <em>Folder</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setFolder(com.verticon.opengis.kml.Folder)
	 * @generated
	 */
	public void testSetFolder() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getFolderObjectExtensionGroup() <em>Folder Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getFolderObjectExtensionGroup()
	 * @generated
	 */
	public void testGetFolderObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getFolderSimpleExtensionGroup() <em>Folder Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getFolderSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetFolderSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getGridOrigin() <em>Grid Origin</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getGridOrigin()
	 * @generated
	 */
	public void testGetGridOrigin() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setGridOrigin(com.verticon.opengis.kml.GridOriginEnumType) <em>Grid Origin</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setGridOrigin(com.verticon.opengis.kml.GridOriginEnumType)
	 * @generated
	 */
	public void testSetGridOrigin() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlay() <em>Ground Overlay</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getGroundOverlay()
	 * @generated
	 */
	public void testGetGroundOverlay() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setGroundOverlay(com.verticon.opengis.kml.GroundOverlay) <em>Ground Overlay</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setGroundOverlay(com.verticon.opengis.kml.GroundOverlay)
	 * @generated
	 */
	public void testSetGroundOverlay() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlayObjectExtensionGroup() <em>Ground Overlay Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getGroundOverlayObjectExtensionGroup()
	 * @generated
	 */
	public void testGetGroundOverlayObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getGroundOverlaySimpleExtensionGroup() <em>Ground Overlay Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getGroundOverlaySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetGroundOverlaySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getHeading() <em>Heading</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getHeading()
	 * @generated
	 */
	public void testGetHeading() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setHeading(double) <em>Heading</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setHeading(double)
	 * @generated
	 */
	public void testSetHeading() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getHotSpot() <em>Hot Spot</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getHotSpot()
	 * @generated
	 */
	public void testGetHotSpot() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setHotSpot(com.verticon.opengis.kml.vec2) <em>Hot Spot</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setHotSpot(com.verticon.opengis.kml.vec2)
	 * @generated
	 */
	public void testSetHotSpot() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getHref() <em>Href</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getHref()
	 * @generated
	 */
	public void testGetHref() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setHref(java.lang.String) <em>Href</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setHref(java.lang.String)
	 * @generated
	 */
	public void testSetHref() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getHttpQuery() <em>Http Query</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getHttpQuery()
	 * @generated
	 */
	public void testGetHttpQuery() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setHttpQuery(java.lang.String) <em>Http Query</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setHttpQuery(java.lang.String)
	 * @generated
	 */
	public void testSetHttpQuery() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getIcon() <em>Icon</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getIcon()
	 * @generated
	 */
	public void testGetIcon() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setIcon(com.verticon.opengis.kml.Link) <em>Icon</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setIcon(com.verticon.opengis.kml.Link)
	 * @generated
	 */
	public void testSetIcon() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getIconStyle() <em>Icon Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getIconStyle()
	 * @generated
	 */
	public void testGetIconStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setIconStyle(com.verticon.opengis.kml.IconStyle) <em>Icon Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setIconStyle(com.verticon.opengis.kml.IconStyle)
	 * @generated
	 */
	public void testSetIconStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getIconStyleObjectExtensionGroup() <em>Icon Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getIconStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetIconStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getIconStyleSimpleExtensionGroup() <em>Icon Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getIconStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetIconStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramid() <em>Image Pyramid</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getImagePyramid()
	 * @generated
	 */
	public void testGetImagePyramid() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setImagePyramid(com.verticon.opengis.kml.ImagePyramid) <em>Image Pyramid</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setImagePyramid(com.verticon.opengis.kml.ImagePyramid)
	 * @generated
	 */
	public void testSetImagePyramid() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramidObjectExtensionGroup() <em>Image Pyramid Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getImagePyramidObjectExtensionGroup()
	 * @generated
	 */
	public void testGetImagePyramidObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getImagePyramidSimpleExtensionGroup() <em>Image Pyramid Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getImagePyramidSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetImagePyramidSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getInnerBoundaryIs() <em>Inner Boundary Is</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getInnerBoundaryIs()
	 * @generated
	 */
	public void testGetInnerBoundaryIs() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setInnerBoundaryIs(com.verticon.opengis.kml.Boundary) <em>Inner Boundary Is</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setInnerBoundaryIs(com.verticon.opengis.kml.Boundary)
	 * @generated
	 */
	public void testSetInnerBoundaryIs() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getItemIcon() <em>Item Icon</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getItemIcon()
	 * @generated
	 */
	public void testGetItemIcon() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setItemIcon(com.verticon.opengis.kml.ItemIcon) <em>Item Icon</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setItemIcon(com.verticon.opengis.kml.ItemIcon)
	 * @generated
	 */
	public void testSetItemIcon() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getItemIconObjectExtensionGroup() <em>Item Icon Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getItemIconObjectExtensionGroup()
	 * @generated
	 */
	public void testGetItemIconObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getItemIconSimpleExtensionGroup() <em>Item Icon Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getItemIconSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetItemIconSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getKey() <em>Key</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getKey()
	 * @generated
	 */
	public void testGetKey() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setKey(com.verticon.opengis.kml.StyleStateEnumType) <em>Key</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setKey(com.verticon.opengis.kml.StyleStateEnumType)
	 * @generated
	 */
	public void testSetKey() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getKml() <em>Kml</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getKml()
	 * @generated
	 */
	public void testGetKml() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setKml(com.verticon.opengis.kml.Kml) <em>Kml</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setKml(com.verticon.opengis.kml.Kml)
	 * @generated
	 */
	public void testSetKml() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getKmlObjectExtensionGroup() <em>Kml Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getKmlObjectExtensionGroup()
	 * @generated
	 */
	public void testGetKmlObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getKmlSimpleExtensionGroup() <em>Kml Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getKmlSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetKmlSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyle() <em>Label Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLabelStyle()
	 * @generated
	 */
	public void testGetLabelStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLabelStyle(com.verticon.opengis.kml.LabelStyle) <em>Label Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLabelStyle(com.verticon.opengis.kml.LabelStyle)
	 * @generated
	 */
	public void testSetLabelStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyleObjectExtensionGroup() <em>Label Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLabelStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLabelStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLabelStyleSimpleExtensionGroup() <em>Label Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLabelStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLabelStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatitude() <em>Latitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatitude()
	 * @generated
	 */
	public void testGetLatitude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLatitude(double) <em>Latitude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLatitude(double)
	 * @generated
	 */
	public void testSetLatitude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBox() <em>Lat Lon Alt Box</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonAltBox()
	 * @generated
	 */
	public void testGetLatLonAltBox() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLatLonAltBox(com.verticon.opengis.kml.LatLonAltBox) <em>Lat Lon Alt Box</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLatLonAltBox(com.verticon.opengis.kml.LatLonAltBox)
	 * @generated
	 */
	public void testSetLatLonAltBox() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxObjectExtensionGroup() <em>Lat Lon Alt Box Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLatLonAltBoxObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxSimpleExtensionGroup() <em>Lat Lon Alt Box Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonAltBoxSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLatLonAltBoxSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBox() <em>Lat Lon Box</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonBox()
	 * @generated
	 */
	public void testGetLatLonBox() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLatLonBox(com.verticon.opengis.kml.LatLonBox) <em>Lat Lon Box</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLatLonBox(com.verticon.opengis.kml.LatLonBox)
	 * @generated
	 */
	public void testSetLatLonBox() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBoxObjectExtensionGroup() <em>Lat Lon Box Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonBoxObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLatLonBoxObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLatLonBoxSimpleExtensionGroup() <em>Lat Lon Box Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLatLonBoxSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLatLonBoxSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLeftFov() <em>Left Fov</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLeftFov()
	 * @generated
	 */
	public void testGetLeftFov() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLeftFov(double) <em>Left Fov</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLeftFov(double)
	 * @generated
	 */
	public void testSetLeftFov() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinearRing() <em>Linear Ring</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinearRing()
	 * @generated
	 */
	public void testGetLinearRing() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLinearRing(com.verticon.opengis.kml.LinearRing) <em>Linear Ring</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLinearRing(com.verticon.opengis.kml.LinearRing)
	 * @generated
	 */
	public void testSetLinearRing() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinearRingObjectExtensionGroup() <em>Linear Ring Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinearRingObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLinearRingObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinearRingSimpleExtensionGroup() <em>Linear Ring Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinearRingSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLinearRingSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineString() <em>Line String</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineString()
	 * @generated
	 */
	public void testGetLineString() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLineString(com.verticon.opengis.kml.LineString) <em>Line String</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLineString(com.verticon.opengis.kml.LineString)
	 * @generated
	 */
	public void testSetLineString() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineStringObjectExtensionGroup() <em>Line String Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineStringObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLineStringObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineStringSimpleExtensionGroup() <em>Line String Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineStringSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLineStringSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineStyle() <em>Line Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineStyle()
	 * @generated
	 */
	public void testGetLineStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLineStyle(com.verticon.opengis.kml.LineStyle) <em>Line Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLineStyle(com.verticon.opengis.kml.LineStyle)
	 * @generated
	 */
	public void testSetLineStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineStyleObjectExtensionGroup() <em>Line Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLineStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLineStyleSimpleExtensionGroup() <em>Line Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLineStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLineStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLink() <em>Link</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLink()
	 * @generated
	 */
	public void testGetLink() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLink(com.verticon.opengis.kml.Link) <em>Link</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLink(com.verticon.opengis.kml.Link)
	 * @generated
	 */
	public void testSetLink() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinkDescription() <em>Link Description</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinkDescription()
	 * @generated
	 */
	public void testGetLinkDescription() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLinkDescription(java.lang.String) <em>Link Description</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLinkDescription(java.lang.String)
	 * @generated
	 */
	public void testSetLinkDescription() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinkName() <em>Link Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinkName()
	 * @generated
	 */
	public void testGetLinkName() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLinkName(java.lang.String) <em>Link Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLinkName(java.lang.String)
	 * @generated
	 */
	public void testSetLinkName() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinkObjectExtensionGroup() <em>Link Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinkObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLinkObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinkSimpleExtensionGroup() <em>Link Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinkSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLinkSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLinkSnippet() <em>Link Snippet</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLinkSnippet()
	 * @generated
	 */
	public void testGetLinkSnippet() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLinkSnippet(com.verticon.opengis.kml.Snippet) <em>Link Snippet</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLinkSnippet(com.verticon.opengis.kml.Snippet)
	 * @generated
	 */
	public void testSetLinkSnippet() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getListItemType() <em>List Item Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getListItemType()
	 * @generated
	 */
	public void testGetListItemType() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setListItemType(com.verticon.opengis.kml.ListItemTypeEnumType) <em>List Item Type</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setListItemType(com.verticon.opengis.kml.ListItemTypeEnumType)
	 * @generated
	 */
	public void testSetListItemType() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getListStyle() <em>List Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getListStyle()
	 * @generated
	 */
	public void testGetListStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setListStyle(com.verticon.opengis.kml.ListStyle) <em>List Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setListStyle(com.verticon.opengis.kml.ListStyle)
	 * @generated
	 */
	public void testSetListStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getListStyleObjectExtensionGroup() <em>List Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getListStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetListStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getListStyleSimpleExtensionGroup() <em>List Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getListStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetListStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLocation() <em>Location</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLocation()
	 * @generated
	 */
	public void testGetLocation() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLocation(com.verticon.opengis.kml.Location) <em>Location</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLocation(com.verticon.opengis.kml.Location)
	 * @generated
	 */
	public void testSetLocation() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLocationObjectExtensionGroup() <em>Location Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLocationObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLocationObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLocationSimpleExtensionGroup() <em>Location Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLocationSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLocationSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLod() <em>Lod</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLod()
	 * @generated
	 */
	public void testGetLod() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLod(com.verticon.opengis.kml.Lod) <em>Lod</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLod(com.verticon.opengis.kml.Lod)
	 * @generated
	 */
	public void testSetLod() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLodObjectExtensionGroup() <em>Lod Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLodObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLodObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLodSimpleExtensionGroup() <em>Lod Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLodSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLodSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLongitude() <em>Longitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLongitude()
	 * @generated
	 */
	public void testGetLongitude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLongitude(double) <em>Longitude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLongitude(double)
	 * @generated
	 */
	public void testSetLongitude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLookAt() <em>Look At</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLookAt()
	 * @generated
	 */
	public void testGetLookAt() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setLookAt(com.verticon.opengis.kml.LookAt) <em>Look At</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setLookAt(com.verticon.opengis.kml.LookAt)
	 * @generated
	 */
	public void testSetLookAt() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLookAtObjectExtensionGroup() <em>Look At Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLookAtObjectExtensionGroup()
	 * @generated
	 */
	public void testGetLookAtObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getLookAtSimpleExtensionGroup() <em>Look At Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getLookAtSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetLookAtSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxAltitude() <em>Max Altitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxAltitude()
	 * @generated
	 */
	public void testGetMaxAltitude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxAltitude(double) <em>Max Altitude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxAltitude(double)
	 * @generated
	 */
	public void testSetMaxAltitude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxFadeExtent() <em>Max Fade Extent</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxFadeExtent()
	 * @generated
	 */
	public void testGetMaxFadeExtent() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxFadeExtent(double) <em>Max Fade Extent</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxFadeExtent(double)
	 * @generated
	 */
	public void testSetMaxFadeExtent() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxHeight() <em>Max Height</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxHeight()
	 * @generated
	 */
	public void testGetMaxHeight() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxHeight(int) <em>Max Height</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxHeight(int)
	 * @generated
	 */
	public void testSetMaxHeight() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxLodPixels() <em>Max Lod Pixels</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxLodPixels()
	 * @generated
	 */
	public void testGetMaxLodPixels() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxLodPixels(double) <em>Max Lod Pixels</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxLodPixels(double)
	 * @generated
	 */
	public void testSetMaxLodPixels() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxSessionLength() <em>Max Session Length</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxSessionLength()
	 * @generated
	 */
	public void testGetMaxSessionLength() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxSessionLength(double) <em>Max Session Length</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxSessionLength(double)
	 * @generated
	 */
	public void testSetMaxSessionLength() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxSnippetLines() <em>Max Snippet Lines</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxSnippetLines()
	 * @generated
	 */
	public void testGetMaxSnippetLines() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxSnippetLines(int) <em>Max Snippet Lines</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxSnippetLines(int)
	 * @generated
	 */
	public void testSetMaxSnippetLines() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMaxWidth() <em>Max Width</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMaxWidth()
	 * @generated
	 */
	public void testGetMaxWidth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMaxWidth(int) <em>Max Width</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMaxWidth(int)
	 * @generated
	 */
	public void testSetMaxWidth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMessage() <em>Message</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMessage()
	 * @generated
	 */
	public void testGetMessage() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMessage(java.lang.String) <em>Message</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMessage(java.lang.String)
	 * @generated
	 */
	public void testSetMessage() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMetadata() <em>Metadata</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMetadata()
	 * @generated
	 */
	public void testGetMetadata() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMetadata(com.verticon.opengis.kml.Metadata) <em>Metadata</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMetadata(com.verticon.opengis.kml.Metadata)
	 * @generated
	 */
	public void testSetMetadata() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMinAltitude() <em>Min Altitude</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMinAltitude()
	 * @generated
	 */
	public void testGetMinAltitude() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMinAltitude(double) <em>Min Altitude</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMinAltitude(double)
	 * @generated
	 */
	public void testSetMinAltitude() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMinFadeExtent() <em>Min Fade Extent</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMinFadeExtent()
	 * @generated
	 */
	public void testGetMinFadeExtent() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMinFadeExtent(double) <em>Min Fade Extent</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMinFadeExtent(double)
	 * @generated
	 */
	public void testSetMinFadeExtent() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMinLodPixels() <em>Min Lod Pixels</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMinLodPixels()
	 * @generated
	 */
	public void testGetMinLodPixels() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMinLodPixels(double) <em>Min Lod Pixels</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMinLodPixels(double)
	 * @generated
	 */
	public void testSetMinLodPixels() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMinRefreshPeriod() <em>Min Refresh Period</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMinRefreshPeriod()
	 * @generated
	 */
	public void testGetMinRefreshPeriod() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMinRefreshPeriod(double) <em>Min Refresh Period</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMinRefreshPeriod(double)
	 * @generated
	 */
	public void testSetMinRefreshPeriod() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getModel() <em>Model</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getModel()
	 * @generated
	 */
	public void testGetModel() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setModel(com.verticon.opengis.kml.Model) <em>Model</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setModel(com.verticon.opengis.kml.Model)
	 * @generated
	 */
	public void testSetModel() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getModelObjectExtensionGroup() <em>Model Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getModelObjectExtensionGroup()
	 * @generated
	 */
	public void testGetModelObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getModelSimpleExtensionGroup() <em>Model Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getModelSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetModelSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometry() <em>Multi Geometry</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMultiGeometry()
	 * @generated
	 */
	public void testGetMultiGeometry() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setMultiGeometry(com.verticon.opengis.kml.MultiGeometry) <em>Multi Geometry</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setMultiGeometry(com.verticon.opengis.kml.MultiGeometry)
	 * @generated
	 */
	public void testSetMultiGeometry() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometryObjectExtensionGroup() <em>Multi Geometry Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMultiGeometryObjectExtensionGroup()
	 * @generated
	 */
	public void testGetMultiGeometryObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getMultiGeometrySimpleExtensionGroup() <em>Multi Geometry Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getMultiGeometrySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetMultiGeometrySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getName() <em>Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getName()
	 * @generated
	 */
	public void testGetName() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setName(java.lang.String) <em>Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setName(java.lang.String)
	 * @generated
	 */
	public void testSetName() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNear() <em>Near</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNear()
	 * @generated
	 */
	public void testGetNear() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setNear(double) <em>Near</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setNear(double)
	 * @generated
	 */
	public void testSetNear() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLink() <em>Network Link</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLink()
	 * @generated
	 */
	public void testGetNetworkLink() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setNetworkLink(com.verticon.opengis.kml.NetworkLink) <em>Network Link</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setNetworkLink(com.verticon.opengis.kml.NetworkLink)
	 * @generated
	 */
	public void testSetNetworkLink() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControl() <em>Network Link Control</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControl()
	 * @generated
	 */
	public void testGetNetworkLinkControl() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setNetworkLinkControl(com.verticon.opengis.kml.NetworkLinkControl) <em>Network Link Control</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setNetworkLinkControl(com.verticon.opengis.kml.NetworkLinkControl)
	 * @generated
	 */
	public void testSetNetworkLinkControl() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlObjectExtensionGroup() <em>Network Link Control Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlObjectExtensionGroup()
	 * @generated
	 */
	public void testGetNetworkLinkControlObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlSimpleExtensionGroup() <em>Network Link Control Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLinkControlSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetNetworkLinkControlSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkObjectExtensionGroup() <em>Network Link Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLinkObjectExtensionGroup()
	 * @generated
	 */
	public void testGetNetworkLinkObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNetworkLinkSimpleExtensionGroup() <em>Network Link Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNetworkLinkSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetNetworkLinkSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getNorth() <em>North</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getNorth()
	 * @generated
	 */
	public void testGetNorth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setNorth(double) <em>North</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setNorth(double)
	 * @generated
	 */
	public void testSetNorth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getObjectSimpleExtensionGroup() <em>Object Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getObjectSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetObjectSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isOpen() <em>Open</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isOpen()
	 * @generated
	 */
	public void testIsOpen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setOpen(boolean) <em>Open</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setOpen(boolean)
	 * @generated
	 */
	public void testSetOpen() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getOrientation() <em>Orientation</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getOrientation()
	 * @generated
	 */
	public void testGetOrientation() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setOrientation(com.verticon.opengis.kml.Orientation) <em>Orientation</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setOrientation(com.verticon.opengis.kml.Orientation)
	 * @generated
	 */
	public void testSetOrientation() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getOrientationObjectExtensionGroup() <em>Orientation Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getOrientationObjectExtensionGroup()
	 * @generated
	 */
	public void testGetOrientationObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getOrientationSimpleExtensionGroup() <em>Orientation Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getOrientationSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetOrientationSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getOuterBoundaryIs() <em>Outer Boundary Is</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getOuterBoundaryIs()
	 * @generated
	 */
	public void testGetOuterBoundaryIs() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setOuterBoundaryIs(com.verticon.opengis.kml.Boundary) <em>Outer Boundary Is</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setOuterBoundaryIs(com.verticon.opengis.kml.Boundary)
	 * @generated
	 */
	public void testSetOuterBoundaryIs() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isOutline() <em>Outline</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isOutline()
	 * @generated
	 */
	public void testIsOutline() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setOutline(boolean) <em>Outline</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setOutline(boolean)
	 * @generated
	 */
	public void testSetOutline() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getOverlayXY() <em>Overlay XY</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getOverlayXY()
	 * @generated
	 */
	public void testGetOverlayXY() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setOverlayXY(com.verticon.opengis.kml.vec2) <em>Overlay XY</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setOverlayXY(com.verticon.opengis.kml.vec2)
	 * @generated
	 */
	public void testSetOverlayXY() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPair() <em>Pair</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPair()
	 * @generated
	 */
	public void testGetPair() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPair(com.verticon.opengis.kml.Pair) <em>Pair</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPair(com.verticon.opengis.kml.Pair)
	 * @generated
	 */
	public void testSetPair() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPairObjectExtensionGroup() <em>Pair Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPairObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPairObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPairSimpleExtensionGroup() <em>Pair Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPairSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPairSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPhoneNumber() <em>Phone Number</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPhoneNumber()
	 * @generated
	 */
	public void testGetPhoneNumber() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPhoneNumber(java.lang.String) <em>Phone Number</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPhoneNumber(java.lang.String)
	 * @generated
	 */
	public void testSetPhoneNumber() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlay() <em>Photo Overlay</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPhotoOverlay()
	 * @generated
	 */
	public void testGetPhotoOverlay() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPhotoOverlay(com.verticon.opengis.kml.PhotoOverlay) <em>Photo Overlay</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPhotoOverlay(com.verticon.opengis.kml.PhotoOverlay)
	 * @generated
	 */
	public void testSetPhotoOverlay() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlayObjectExtensionGroup() <em>Photo Overlay Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPhotoOverlayObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPhotoOverlayObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPhotoOverlaySimpleExtensionGroup() <em>Photo Overlay Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPhotoOverlaySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPhotoOverlaySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPlacemark() <em>Placemark</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPlacemark()
	 * @generated
	 */
	public void testGetPlacemark() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPlacemark(com.verticon.opengis.kml.Placemark) <em>Placemark</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPlacemark(com.verticon.opengis.kml.Placemark)
	 * @generated
	 */
	public void testSetPlacemark() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPlacemarkObjectExtensionGroup() <em>Placemark Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPlacemarkObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPlacemarkObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPlacemarkSimpleExtensionGroup() <em>Placemark Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPlacemarkSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPlacemarkSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPoint() <em>Point</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPoint()
	 * @generated
	 */
	public void testGetPoint() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPoint(com.verticon.opengis.kml.Point) <em>Point</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPoint(com.verticon.opengis.kml.Point)
	 * @generated
	 */
	public void testSetPoint() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPointObjectExtensionGroup() <em>Point Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPointObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPointObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPointSimpleExtensionGroup() <em>Point Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPointSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPointSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolygon() <em>Polygon</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolygon()
	 * @generated
	 */
	public void testGetPolygon() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPolygon(com.verticon.opengis.kml.Polygon) <em>Polygon</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPolygon(com.verticon.opengis.kml.Polygon)
	 * @generated
	 */
	public void testSetPolygon() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolygonObjectExtensionGroup() <em>Polygon Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolygonObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPolygonObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolygonSimpleExtensionGroup() <em>Polygon Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolygonSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPolygonSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyle() <em>Poly Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolyStyle()
	 * @generated
	 */
	public void testGetPolyStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setPolyStyle(com.verticon.opengis.kml.PolyStyle) <em>Poly Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setPolyStyle(com.verticon.opengis.kml.PolyStyle)
	 * @generated
	 */
	public void testSetPolyStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyleObjectExtensionGroup() <em>Poly Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolyStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetPolyStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getPolyStyleSimpleExtensionGroup() <em>Poly Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getPolyStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetPolyStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRange() <em>Range</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRange()
	 * @generated
	 */
	public void testGetRange() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRange(double) <em>Range</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRange(double)
	 * @generated
	 */
	public void testSetRange() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRefreshInterval() <em>Refresh Interval</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRefreshInterval()
	 * @generated
	 */
	public void testGetRefreshInterval() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRefreshInterval(double) <em>Refresh Interval</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRefreshInterval(double)
	 * @generated
	 */
	public void testSetRefreshInterval() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRefreshMode() <em>Refresh Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRefreshMode()
	 * @generated
	 */
	public void testGetRefreshMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRefreshMode(com.verticon.opengis.kml.RefreshModeEnumType) <em>Refresh Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRefreshMode(com.verticon.opengis.kml.RefreshModeEnumType)
	 * @generated
	 */
	public void testSetRefreshMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isRefreshVisibility() <em>Refresh Visibility</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isRefreshVisibility()
	 * @generated
	 */
	public void testIsRefreshVisibility() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRefreshVisibility(boolean) <em>Refresh Visibility</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRefreshVisibility(boolean)
	 * @generated
	 */
	public void testSetRefreshVisibility() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRegion() <em>Region</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRegion()
	 * @generated
	 */
	public void testGetRegion() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRegion(com.verticon.opengis.kml.Region) <em>Region</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRegion(com.verticon.opengis.kml.Region)
	 * @generated
	 */
	public void testSetRegion() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRegionObjectExtensionGroup() <em>Region Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRegionObjectExtensionGroup()
	 * @generated
	 */
	public void testGetRegionObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRegionSimpleExtensionGroup() <em>Region Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRegionSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetRegionSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getResourceMap() <em>Resource Map</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getResourceMap()
	 * @generated
	 */
	public void testGetResourceMap() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setResourceMap(com.verticon.opengis.kml.ResourceMap) <em>Resource Map</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setResourceMap(com.verticon.opengis.kml.ResourceMap)
	 * @generated
	 */
	public void testSetResourceMap() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getResourceMapObjectExtensionGroup() <em>Resource Map Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getResourceMapObjectExtensionGroup()
	 * @generated
	 */
	public void testGetResourceMapObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getResourceMapSimpleExtensionGroup() <em>Resource Map Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getResourceMapSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetResourceMapSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRightFov() <em>Right Fov</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRightFov()
	 * @generated
	 */
	public void testGetRightFov() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRightFov(double) <em>Right Fov</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRightFov(double)
	 * @generated
	 */
	public void testSetRightFov() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRoll() <em>Roll</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRoll()
	 * @generated
	 */
	public void testGetRoll() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRoll(double) <em>Roll</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRoll(double)
	 * @generated
	 */
	public void testSetRoll() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRotation() <em>Rotation</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRotation()
	 * @generated
	 */
	public void testGetRotation() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRotation(double) <em>Rotation</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRotation(double)
	 * @generated
	 */
	public void testSetRotation() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getRotationXY() <em>Rotation XY</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getRotationXY()
	 * @generated
	 */
	public void testGetRotationXY() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setRotationXY(com.verticon.opengis.kml.vec2) <em>Rotation XY</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setRotationXY(com.verticon.opengis.kml.vec2)
	 * @generated
	 */
	public void testSetRotationXY() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScale() <em>Scale</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScale()
	 * @generated
	 */
	public void testGetScale() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setScale(double) <em>Scale</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setScale(double)
	 * @generated
	 */
	public void testSetScale() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScale1() <em>Scale1</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScale1()
	 * @generated
	 */
	public void testGetScale1() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setScale1(com.verticon.opengis.kml.Scale) <em>Scale1</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setScale1(com.verticon.opengis.kml.Scale)
	 * @generated
	 */
	public void testSetScale1() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScaleObjectExtensionGroup() <em>Scale Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScaleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetScaleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScaleSimpleExtensionGroup() <em>Scale Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScaleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetScaleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSchema() <em>Schema</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSchema()
	 * @generated
	 */
	public void testGetSchema() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSchema(com.verticon.opengis.kml.Schema) <em>Schema</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSchema(com.verticon.opengis.kml.Schema)
	 * @generated
	 */
	public void testSetSchema() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSchemaData() <em>Schema Data</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSchemaData()
	 * @generated
	 */
	public void testGetSchemaData() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSchemaData(com.verticon.opengis.kml.SchemaData) <em>Schema Data</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSchemaData(com.verticon.opengis.kml.SchemaData)
	 * @generated
	 */
	public void testSetSchemaData() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSchemaDataExtension() <em>Schema Data Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSchemaDataExtension()
	 * @generated
	 */
	public void testGetSchemaDataExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSchemaExtension() <em>Schema Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSchemaExtension()
	 * @generated
	 */
	public void testGetSchemaExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlay() <em>Screen Overlay</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScreenOverlay()
	 * @generated
	 */
	public void testGetScreenOverlay() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setScreenOverlay(com.verticon.opengis.kml.ScreenOverlay) <em>Screen Overlay</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setScreenOverlay(com.verticon.opengis.kml.ScreenOverlay)
	 * @generated
	 */
	public void testSetScreenOverlay() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlayObjectExtensionGroup() <em>Screen Overlay Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScreenOverlayObjectExtensionGroup()
	 * @generated
	 */
	public void testGetScreenOverlayObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScreenOverlaySimpleExtensionGroup() <em>Screen Overlay Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScreenOverlaySimpleExtensionGroup()
	 * @generated
	 */
	public void testGetScreenOverlaySimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getScreenXY() <em>Screen XY</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getScreenXY()
	 * @generated
	 */
	public void testGetScreenXY() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setScreenXY(com.verticon.opengis.kml.vec2) <em>Screen XY</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setScreenXY(com.verticon.opengis.kml.vec2)
	 * @generated
	 */
	public void testSetScreenXY() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getShape() <em>Shape</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getShape()
	 * @generated
	 */
	public void testGetShape() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setShape(com.verticon.opengis.kml.ShapeEnumType) <em>Shape</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setShape(com.verticon.opengis.kml.ShapeEnumType)
	 * @generated
	 */
	public void testSetShape() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSimpleData() <em>Simple Data</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSimpleData()
	 * @generated
	 */
	public void testGetSimpleData() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSimpleData(com.verticon.opengis.kml.SimpleData) <em>Simple Data</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSimpleData(com.verticon.opengis.kml.SimpleData)
	 * @generated
	 */
	public void testSetSimpleData() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSimpleField() <em>Simple Field</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSimpleField()
	 * @generated
	 */
	public void testGetSimpleField() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSimpleField(com.verticon.opengis.kml.SimpleField) <em>Simple Field</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSimpleField(com.verticon.opengis.kml.SimpleField)
	 * @generated
	 */
	public void testSetSimpleField() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSimpleFieldExtension() <em>Simple Field Extension</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSimpleFieldExtension()
	 * @generated
	 */
	public void testGetSimpleFieldExtension() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSize() <em>Size</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSize()
	 * @generated
	 */
	public void testGetSize() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSize(com.verticon.opengis.kml.vec2) <em>Size</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSize(com.verticon.opengis.kml.vec2)
	 * @generated
	 */
	public void testSetSize() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSnippet() <em>Snippet</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSnippet()
	 * @generated
	 */
	public void testGetSnippet() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSnippet(java.lang.String) <em>Snippet</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSnippet(java.lang.String)
	 * @generated
	 */
	public void testSetSnippet() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSnippet1() <em>Snippet1</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSnippet1()
	 * @generated
	 */
	public void testGetSnippet1() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSnippet1(com.verticon.opengis.kml.Snippet) <em>Snippet1</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSnippet1(com.verticon.opengis.kml.Snippet)
	 * @generated
	 */
	public void testSetSnippet1() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSourceHref() <em>Source Href</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSourceHref()
	 * @generated
	 */
	public void testGetSourceHref() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSourceHref(java.lang.String) <em>Source Href</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSourceHref(java.lang.String)
	 * @generated
	 */
	public void testSetSourceHref() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getSouth() <em>South</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getSouth()
	 * @generated
	 */
	public void testGetSouth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setSouth(double) <em>South</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setSouth(double)
	 * @generated
	 */
	public void testSetSouth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getState() <em>State</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getState()
	 * @generated
	 */
	public void testGetState() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setState(java.util.List) <em>State</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setState(java.util.List)
	 * @generated
	 */
	public void testSetState() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyle() <em>Style</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyle()
	 * @generated
	 */
	public void testGetStyle() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setStyle(com.verticon.opengis.kml.Style) <em>Style</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setStyle(com.verticon.opengis.kml.Style)
	 * @generated
	 */
	public void testSetStyle() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleMap() <em>Style Map</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleMap()
	 * @generated
	 */
	public void testGetStyleMap() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setStyleMap(com.verticon.opengis.kml.StyleMap) <em>Style Map</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setStyleMap(com.verticon.opengis.kml.StyleMap)
	 * @generated
	 */
	public void testSetStyleMap() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleMapObjectExtensionGroup() <em>Style Map Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleMapObjectExtensionGroup()
	 * @generated
	 */
	public void testGetStyleMapObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleMapSimpleExtensionGroup() <em>Style Map Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleMapSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetStyleMapSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleObjectExtensionGroup() <em>Style Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleObjectExtensionGroup()
	 * @generated
	 */
	public void testGetStyleObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleSimpleExtensionGroup() <em>Style Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetStyleSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getStyleUrl() <em>Style Url</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getStyleUrl()
	 * @generated
	 */
	public void testGetStyleUrl() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setStyleUrl(java.lang.String) <em>Style Url</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setStyleUrl(java.lang.String)
	 * @generated
	 */
	public void testSetStyleUrl() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTargetHref() <em>Target Href</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTargetHref()
	 * @generated
	 */
	public void testGetTargetHref() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTargetHref(java.lang.String) <em>Target Href</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTargetHref(java.lang.String)
	 * @generated
	 */
	public void testSetTargetHref() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isTessellate() <em>Tessellate</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isTessellate()
	 * @generated
	 */
	public void testIsTessellate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTessellate(boolean) <em>Tessellate</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTessellate(boolean)
	 * @generated
	 */
	public void testSetTessellate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getText() <em>Text</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getText()
	 * @generated
	 */
	public void testGetText() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setText(java.lang.String) <em>Text</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setText(java.lang.String)
	 * @generated
	 */
	public void testSetText() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTextColor() <em>Text Color</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTextColor()
	 * @generated
	 */
	public void testGetTextColor() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTextColor(byte[]) <em>Text Color</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTextColor(byte[])
	 * @generated
	 */
	public void testSetTextColor() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTileSize() <em>Tile Size</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTileSize()
	 * @generated
	 */
	public void testGetTileSize() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTileSize(int) <em>Tile Size</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTileSize(int)
	 * @generated
	 */
	public void testSetTileSize() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTilt() <em>Tilt</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTilt()
	 * @generated
	 */
	public void testGetTilt() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTilt(double) <em>Tilt</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTilt(double)
	 * @generated
	 */
	public void testSetTilt() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpan() <em>Time Span</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeSpan()
	 * @generated
	 */
	public void testGetTimeSpan() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTimeSpan(com.verticon.opengis.kml.TimeSpan) <em>Time Span</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTimeSpan(com.verticon.opengis.kml.TimeSpan)
	 * @generated
	 */
	public void testSetTimeSpan() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpanObjectExtensionGroup() <em>Time Span Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeSpanObjectExtensionGroup()
	 * @generated
	 */
	public void testGetTimeSpanObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeSpanSimpleExtensionGroup() <em>Time Span Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeSpanSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetTimeSpanSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeStamp() <em>Time Stamp</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeStamp()
	 * @generated
	 */
	public void testGetTimeStamp() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTimeStamp(com.verticon.opengis.kml.TimeStamp) <em>Time Stamp</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTimeStamp(com.verticon.opengis.kml.TimeStamp)
	 * @generated
	 */
	public void testSetTimeStamp() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeStampObjectExtensionGroup() <em>Time Stamp Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeStampObjectExtensionGroup()
	 * @generated
	 */
	public void testGetTimeStampObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTimeStampSimpleExtensionGroup() <em>Time Stamp Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTimeStampSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetTimeStampSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getTopFov() <em>Top Fov</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getTopFov()
	 * @generated
	 */
	public void testGetTopFov() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setTopFov(double) <em>Top Fov</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setTopFov(double)
	 * @generated
	 */
	public void testSetTopFov() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getUpdate() <em>Update</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getUpdate()
	 * @generated
	 */
	public void testGetUpdate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setUpdate(com.verticon.opengis.kml.Update) <em>Update</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setUpdate(com.verticon.opengis.kml.Update)
	 * @generated
	 */
	public void testSetUpdate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getUpdateExtensionGroup() <em>Update Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getUpdateExtensionGroup()
	 * @generated
	 */
	public void testGetUpdateExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getUpdateOpExtensionGroup() <em>Update Op Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getUpdateOpExtensionGroup()
	 * @generated
	 */
	public void testGetUpdateOpExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getUrl() <em>Url</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getUrl()
	 * @generated
	 */
	public void testGetUrl() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setUrl(com.verticon.opengis.kml.Link) <em>Url</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setUrl(com.verticon.opengis.kml.Link)
	 * @generated
	 */
	public void testSetUrl() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getValue() <em>Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getValue()
	 * @generated
	 */
	public void testGetValue() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setValue(java.lang.String) <em>Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setValue(java.lang.String)
	 * @generated
	 */
	public void testSetValue() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewBoundScale() <em>View Bound Scale</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewBoundScale()
	 * @generated
	 */
	public void testGetViewBoundScale() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setViewBoundScale(double) <em>View Bound Scale</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setViewBoundScale(double)
	 * @generated
	 */
	public void testSetViewBoundScale() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewFormat() <em>View Format</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewFormat()
	 * @generated
	 */
	public void testGetViewFormat() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setViewFormat(java.lang.String) <em>View Format</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setViewFormat(java.lang.String)
	 * @generated
	 */
	public void testSetViewFormat() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewRefreshMode() <em>View Refresh Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewRefreshMode()
	 * @generated
	 */
	public void testGetViewRefreshMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setViewRefreshMode(com.verticon.opengis.kml.ViewRefreshModeEnumType) <em>View Refresh Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setViewRefreshMode(com.verticon.opengis.kml.ViewRefreshModeEnumType)
	 * @generated
	 */
	public void testSetViewRefreshMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewRefreshTime() <em>View Refresh Time</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewRefreshTime()
	 * @generated
	 */
	public void testGetViewRefreshTime() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setViewRefreshTime(double) <em>View Refresh Time</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setViewRefreshTime(double)
	 * @generated
	 */
	public void testSetViewRefreshTime() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewVolume() <em>View Volume</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewVolume()
	 * @generated
	 */
	public void testGetViewVolume() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setViewVolume(com.verticon.opengis.kml.ViewVolume) <em>View Volume</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setViewVolume(com.verticon.opengis.kml.ViewVolume)
	 * @generated
	 */
	public void testSetViewVolume() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewVolumeObjectExtensionGroup() <em>View Volume Object Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewVolumeObjectExtensionGroup()
	 * @generated
	 */
	public void testGetViewVolumeObjectExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getViewVolumeSimpleExtensionGroup() <em>View Volume Simple Extension Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getViewVolumeSimpleExtensionGroup()
	 * @generated
	 */
	public void testGetViewVolumeSimpleExtensionGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#isVisibility() <em>Visibility</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#isVisibility()
	 * @generated
	 */
	public void testIsVisibility() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setVisibility(boolean) <em>Visibility</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setVisibility(boolean)
	 * @generated
	 */
	public void testSetVisibility() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getWest() <em>West</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getWest()
	 * @generated
	 */
	public void testGetWest() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setWest(double) <em>West</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setWest(double)
	 * @generated
	 */
	public void testSetWest() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getWhen() <em>When</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getWhen()
	 * @generated
	 */
	public void testGetWhen() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setWhen(javax.xml.datatype.XMLGregorianCalendar) <em>When</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setWhen(javax.xml.datatype.XMLGregorianCalendar)
	 * @generated
	 */
	public void testSetWhen() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getWidth() <em>Width</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getWidth()
	 * @generated
	 */
	public void testGetWidth() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setWidth(double) <em>Width</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setWidth(double)
	 * @generated
	 */
	public void testSetWidth() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getX() <em>X</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getX()
	 * @generated
	 */
	public void testGetX() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setX(double) <em>X</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setX(double)
	 * @generated
	 */
	public void testSetX() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getY() <em>Y</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getY()
	 * @generated
	 */
	public void testGetY() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setY(double) <em>Y</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setY(double)
	 * @generated
	 */
	public void testSetY() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#getZ() <em>Z</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#getZ()
	 * @generated
	 */
	public void testGetZ() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link com.verticon.opengis.kml.DocumentRoot#setZ(double) <em>Z</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.verticon.opengis.kml.DocumentRoot#setZ(double)
	 * @generated
	 */
	public void testSetZ() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //DocumentRootTest
