package com.verticon.google.kmlgx.core.model.tests.extra;

import com.verticon.google.kmlgx.Playlist;
import com.verticon.google.kmlgx.Tour;
import com.verticon.google.kmlgx.util.KmlgxSwitch;
import com.verticon.opengis.kml.Feature;
import com.verticon.opengis.kml.Geometry;

public class KmlgxDiagnosticVisitor extends KmlgxSwitch<Object>{
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GX visited ";
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
	 * @see com.verticon.google.kmlgx.util.KmlgxSwitch#casePlaylist(com.verticon.google.kmlgx.Playlist)
	 */
	@Override
	public Object casePlaylist(Playlist object) {
		System.out.println(this+" gxPlaylist: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.google.kmlgx.util.KmlgxSwitch#caseTour(com.verticon.google.kmlgx.Tour)
	 */
	@Override
	public Object caseTour(Tour object) {
		System.out.println(this+" gxTour: " + object);
		return Boolean.TRUE;
	}

	
	
}
