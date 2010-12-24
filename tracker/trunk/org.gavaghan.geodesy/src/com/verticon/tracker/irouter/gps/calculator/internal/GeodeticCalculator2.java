package com.verticon.tracker.irouter.gps.calculator.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.gavaghan.geodesy.Angle;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GeodeticMeasurement;
import org.gavaghan.geodesy.IGeodesicCalculator;
import org.gavaghan.geodesy.internal.Ellipsoid;
import org.gavaghan.geodesy.internal.GeodeticCalculator;
import org.gavaghan.geodesy.internal.GlobalCoordinates;
import org.gavaghan.geodesy.internal.GlobalPosition;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;

/**
 * Geodetic Calculator that uses OSGi Position and the Ellipsoid.WGS84 as the
 * default. Wraps GeodeticCalculator methods with Position objects.  
 * 
 * Note Java MATH conversion is not exact
 * double rads = Math.toRadians(LONGITUDE_D);
 * double degrees = Math.toDegrees(rads);
 * assertFalse(LONGITUDE_D == degrees);
 * double delta = 1.0E-13;
 * assertEquals(LONGITUDE_D, degrees, delta);
 * 
 * Use conversion in Angle class instead
 * 
 * @author jconlon
 * 
 */
public class GeodeticCalculator2 extends GeodeticCalculator implements
		IGeodesicCalculator {

	
	public GeodeticCalculator2() {
		super();
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateLongitudeError(double, double, double)
	 */
	@Override
	public double calculateLongitudeError(double latitude, double longitude,
			double distance) {
		double degrees = this.calculateLongitudeDegreesError(latitude,
				longitude, distance);
		return Angle.toRadians(degrees);
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateLatitudeError(double, double, double)
	 */
	@Override
	public double calculateLatitudeError(double latitude, double longitude,
			double distance) {
		double degrees = this.calculateLatitudeDegreesError(latitude,
				longitude, distance);
		return Angle.toRadians(degrees);
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateLongitudeDegreesError(double, double, double)
	 */
	@Override
	public double calculateLongitudeDegreesError(double latitude,
			double longitude, double distance) {

		GlobalCoordinates start = new GlobalCoordinates(latitude, longitude);
		GlobalCoordinates results = super.calculateEndingGlobalCoordinates(
				Ellipsoid.WGS84, start, 90, distance);
		return Math.abs(longitude - results.getLongitude());
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateLatitudeDegreesError(double, double, double)
	 */
	@Override
	public double calculateLatitudeDegreesError(double latitude,
			double longitude, double distance) {

		GlobalCoordinates start = new GlobalCoordinates(latitude, longitude);
		GlobalCoordinates results = super.calculateEndingGlobalCoordinates(
				Ellipsoid.WGS84, start, 0, distance);

		return Math.abs(latitude - results.getLatitude());
	}

	
//	/* (non-Javadoc)
//	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateEndingGlobalCoordinates(org.osgi.util.position.Position, double, double, double[])
//	 */
//	@Override
//	public Position calculateEndingGlobalCoordinates(Position position,
//			double startBearing, double distance, double[] endBearing) {
//
//		double latitudeRadians = checkNotNull(position.getLatitude().getValue());
//		double longitudeRadians = checkNotNull(position.getLongitude()
//				.getValue());
//		GlobalCoordinates start = new GlobalCoordinates(
//				degrees(latitudeRadians), degrees(longitudeRadians));
//
//		GlobalCoordinates results = super.calculateEndingGlobalCoordinates(
//				Ellipsoid.WGS84, start, startBearing, distance, endBearing);
//
//		return new Position(new Measurement(Angle.toRadians(results.getLatitude()),
//				Unit.rad), new Measurement(Angle.toRadians(results.getLongitude()),
//				Unit.rad), null, null, null);
//
//	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateEndingGlobalCoordinates(org.osgi.util.position.Position, double, double)
	 */
	@Override
	public Position calculateEndingGlobalCoordinates(Position position,
			double startBearing, double distance) {
		double latitudeRadians = checkNotNull(position.getLatitude().getValue());
		double longitudeRadians = checkNotNull(position.getLongitude()
				.getValue());
		GlobalCoordinates start = new GlobalCoordinates(
				Angle.toDegrees(latitudeRadians), Angle.toDegrees(longitudeRadians));

		GlobalCoordinates results = super.calculateEndingGlobalCoordinates(
				Ellipsoid.WGS84, start, startBearing, distance);

		return new Position(new Measurement(Angle.toRadians(results.getLatitude()),
				Unit.rad), new Measurement(Angle.toRadians(results.getLongitude()),
				Unit.rad), null, null, null);
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateGeodeticCurve(org.osgi.util.position.Position, org.osgi.util.position.Position)
	 */
	@Override
	public GeodeticCurve calculateGeodeticCurve(Position startPosition,
			Position endPosition) {

		double latitudeRadians = checkNotNull(startPosition.getLatitude()
				.getValue());
		double longitudeRadians = checkNotNull(startPosition.getLongitude()
				.getValue());
		GlobalCoordinates start = new GlobalCoordinates(
				Angle.toDegrees(latitudeRadians), Angle.toDegrees(longitudeRadians));

		latitudeRadians = checkNotNull(endPosition.getLatitude().getValue());
		longitudeRadians = checkNotNull(endPosition.getLongitude().getValue());
		GlobalCoordinates end = new GlobalCoordinates(Angle.toDegrees(latitudeRadians),
				Angle.toDegrees(longitudeRadians));

		return super.calculateGeodeticCurve(Ellipsoid.WGS84, start, end);
	}

	
	/* (non-Javadoc)
	 * @see org.gavaghan.geodesy.IGeodesicCalculator#calculateGeodeticMeasurement(org.osgi.util.position.Position, org.osgi.util.position.Position)
	 */
	@Override
	public GeodeticMeasurement calculateGeodeticMeasurement(
			Position startPosition, Position endPosition) {

		double latitudeRadians = checkNotNull(startPosition.getLatitude()
				.getValue());
		double longitudeRadians = checkNotNull(startPosition.getLongitude()
				.getValue());
		GlobalCoordinates coors = new GlobalCoordinates(
				Angle.toDegrees(latitudeRadians), Angle.toDegrees(longitudeRadians));
		double altitude = checkNotNull(startPosition.getAltitude().getValue());
		GlobalPosition start = new GlobalPosition(coors, altitude);

		latitudeRadians = checkNotNull(endPosition.getLatitude().getValue());
		longitudeRadians = checkNotNull(endPosition.getLongitude().getValue());
		coors = new GlobalCoordinates(Angle.toDegrees(latitudeRadians),
				Angle.toDegrees(longitudeRadians));
		altitude = checkNotNull(endPosition.getAltitude().getValue());
		GlobalPosition end = new GlobalPosition(coors, altitude);
		return super.calculateGeodeticMeasurement(Ellipsoid.WGS84, start, end);
	}

}
