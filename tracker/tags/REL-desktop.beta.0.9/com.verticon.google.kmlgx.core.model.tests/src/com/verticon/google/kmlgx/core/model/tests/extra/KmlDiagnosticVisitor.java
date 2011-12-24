package com.verticon.google.kmlgx.core.model.tests.extra;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.verticon.opengis.kml.AbstractLatLonBox;
import com.verticon.opengis.kml.AbstractObject;
import com.verticon.opengis.kml.AbstractView;
import com.verticon.opengis.kml.ColorStyle;
import com.verticon.opengis.kml.Container;
import com.verticon.opengis.kml.Document;
import com.verticon.opengis.kml.DocumentRoot;
import com.verticon.opengis.kml.Feature;
import com.verticon.opengis.kml.Geometry;
import com.verticon.opengis.kml.Kml;
import com.verticon.opengis.kml.Overlay;
import com.verticon.opengis.kml.Placemark;
import com.verticon.opengis.kml.Point;
import com.verticon.opengis.kml.StyleSelector;
import com.verticon.opengis.kml.SubStyle;
import com.verticon.opengis.kml.TimePrimitive;
import com.verticon.opengis.kml.util.KmlSwitch;

public class KmlDiagnosticVisitor extends KmlSwitch<Object>{
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Kml visited ";
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseDocument(com.verticon.opengis.kml.Document)
	 */
	@Override
	public Object caseDocument(Document object) {
		System.out.println(this+" Document: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseDocumentRoot(com.verticon.opengis.kml.DocumentRoot)
	 */
	@Override
	public Object caseDocumentRoot(DocumentRoot object) {
		System.out.println(this+" DocumentRoot: " + object);
		FeatureMap fm = object.getMixed();
		System.out.println("\t mixed featureMap: " + fm);
		System.out.println("\t kml: " + object.getKml());
		
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseKml(com.verticon.opengis.kml.Kml)
	 */
	@Override
	public Object caseKml(Kml object) {
		System.out.println(this+" kml: " + object);
//		FeatureMap fm = object.getAbstractFeatureGroupGroup();
//		System.out.println("\t abstractFeatureGroupGroup featureMap: " + fm);
//		for (Entry entry : fm) {
//			EStructuralFeature f = entry.getEStructuralFeature();
//			System.out.println("\t featureMap feature: " + f);
//			System.out.println("\t featureMap featureId: " + f.getFeatureID());
//			System.out.println("\t featureMap featureDefaultValueLiteral: " + f.getDefaultValueLiteral());
//			System.out.println("\t featureMap featureName: " + f.getName());
//			System.out.println("\t featureMap value: "+entry.getValue());
//		}
		System.out.println("\t abstractFeature: " + object.getAbstractFeatureGroup());
		System.out.println("\t kmlObjectExtensionGroup: " + object.getKmlObjectExtensionGroup());
		System.out.println("\t kmlSimpleExtensionGroup: " + object.getKmlSimpleExtensionGroup());
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#casePlacemark(com.verticon.opengis.kml.Placemark)
	 */
	@Override
	public Object casePlacemark(Placemark object) {
		System.out.println(this+" placemark: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractColorStyle(com.verticon.opengis.kml.AbstractColorStyle)
	 */
	@Override
	public Object caseColorStyle(ColorStyle object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractContainer(com.verticon.opengis.kml.AbstractContainer)
	 */
	@Override
	public Object caseContainer(Container object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractFeature(com.verticon.opengis.kml.AbstractFeature)
	 */
	@Override
	public Object caseFeature(Feature object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractGeometry(com.verticon.opengis.kml.AbstractGeometry)
	 */
	@Override
	public Object caseGeometry(Geometry object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractLatLonBox(com.verticon.opengis.kml.AbstractLatLonBox)
	 */
	@Override
	public Object caseAbstractLatLonBox(AbstractLatLonBox object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractObject(com.verticon.opengis.kml.AbstractObject)
	 */
	@Override
	public Object caseAbstractObject(AbstractObject object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractOverlay(com.verticon.opengis.kml.AbstractOverlay)
	 */
	@Override
	public Object caseOverlay(Overlay object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractStyleSelector(com.verticon.opengis.kml.AbstractStyleSelector)
	 */
	@Override
	public Object caseStyleSelector(StyleSelector object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractSubStyle(com.verticon.opengis.kml.AbstractSubStyle)
	 */
	@Override
	public Object caseSubStyle(SubStyle object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractTimePrimitive(com.verticon.opengis.kml.AbstractTimePrimitive)
	 */
	@Override
	public Object caseTimePrimitive(TimePrimitive object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#caseAbstractView(com.verticon.opengis.kml.AbstractView)
	 */
	@Override
	public Object caseAbstractView(AbstractView object) {
		System.out.println(this+" abstract: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.opengis.kml.util.KmlSwitch#casePoint(com.verticon.opengis.kml.Point)
	 */
	@Override
	public Object casePoint(Point object) {
		System.out.println(this+" point: " + object);
		return Boolean.TRUE;
	}
	
}
