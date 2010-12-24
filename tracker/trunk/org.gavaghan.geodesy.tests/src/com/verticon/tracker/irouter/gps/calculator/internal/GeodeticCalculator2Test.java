package com.verticon.tracker.irouter.gps.calculator.internal;

import junit.framework.TestCase;

import org.gavaghan.geodesy.Angle;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.internal.Ellipsoid;
import org.gavaghan.geodesy.internal.GlobalCoordinates;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;

/**
 * 
 * @author jconlon
 * 
 */
public class GeodeticCalculator2Test extends TestCase {

	private static final double LENGTH_LON_DEGREE = 80801.40426516657;
	private static final double LENGTH_LAT_DEGREE = 111113.33664514624;
	private static final double LENGTH_LAT_RADIAN = 6389408.267912255;
	private static final double LENGTH_LAT_RADIANM = 6389664.470171027;
	private static final double LONGITUDE_D = -90.888;
	private static final double LATITUDE_D = 43.556;

	private static final double ALT = 255;
	private static final GlobalCoordinates START_COOR = new GlobalCoordinates(
			LATITUDE_D, LONGITUDE_D);
	private static final Measurement LAT_MEASUREMENT = new Measurement(
			Math.toRadians(LATITUDE_D), Unit.rad);
	private static final Measurement LON_MEASUREMENT = new Measurement(
			Math.toRadians(LONGITUDE_D), Unit.rad);
	private static final Measurement ALT_MEASUREMENT = new Measurement(ALT,
			Unit.m);
	private static final Position START_POSITION = new Position(
			LAT_MEASUREMENT, LON_MEASUREMENT, ALT_MEASUREMENT, null, null);

	private GeodeticCalculator2 instance = null;

	protected void setUp() throws Exception {
		super.setUp();
		instance = new GeodeticCalculator2();

	}

	protected void tearDown() throws Exception {
		instance = null;
		super.tearDown();
	}

	/**
	 * Note MATH.toRadians/toDegrees conversion is not exact
	 */
	public final void testConversion() {
		double rads = Angle.toRadians(LONGITUDE_D);
		assertFalse(rads == Math.toRadians(LONGITUDE_D));
		double degrees = Angle.toDegrees(rads);
		assertFalse(degrees == Math.toDegrees(rads));
		assertEquals(LONGITUDE_D, degrees);
	}

	public final void testCalculateLongitudeError() {
		/*
		 * 
		 * @param latitude in degrees
		 * 
		 * @param longitude in degrees
		 * 
		 * @param distance
		 * 
		 * @return radians error
		 */
		double actual = instance.calculateLongitudeError(LATITUDE_D,
				LONGITUDE_D, LENGTH_LON_DEGREE);
		double expected = Angle.toRadians(1);
		assertEquals(expected, Angle.toRadians(1));
		double delta = 1.0E-4;
		double error = (Math.abs(expected - actual));
		assertEquals("Error is: " + error + ", but the tolerence is: " + delta,
				expected, actual, 1.0E-6);
	}

	/*
	 * 
	 * @param latitude
	 * 
	 * @param longitude
	 * 
	 * @param distance
	 * 
	 * @return radians error
	 */
	public final void testCalculateLatitudeError() {
		double actual = instance.calculateLatitudeError(LATITUDE_D,
				LONGITUDE_D, LENGTH_LAT_DEGREE);
		double expected = Angle.toRadians(1);
		double delta = 1.0E-4;
		double error = (Math.abs(expected - actual));
		assertEquals("Error is: " + error + ", but the tolerence is: " + delta,
				expected, actual, 1.0E-6);
	}

	public final void testCalculateLongitudeDegreesError() {
		/*
		 * 
		 * @param latitude
		 * 
		 * @param longitude
		 * 
		 * @param distance
		 * 
		 * @return degrees error
		 */
		double result = instance.calculateLongitudeDegreesError(LATITUDE_D,
				LONGITUDE_D, LENGTH_LON_DEGREE);
		assertEquals(1d, result, 1.0E-4);
	}

	/*
	 * 
	 * @param latitude
	 * 
	 * @param longitude
	 * 
	 * @param distance
	 * 
	 * @return degrees error
	 */
	public final void testCalculateLatitudeDegreesError() {
		double actual = instance.calculateLatitudeDegreesError(LATITUDE_D,
				LONGITUDE_D, LENGTH_LAT_DEGREE);
		double expected = 1;
		double delta = 1.0E-4;
		double error = (Math.abs(expected - actual));
		assertEquals("Error is: " + error + ", but the tolerence is: " + delta,
				expected, actual, 1.0E-4);
	}

	/*
	 * 
	 * @param position
	 * 
	 * @param startBearing in degrees
	 * 
	 * @param distance
	 * 
	 * @return end Position
	 */
	public final void testCalculateEndingGlobalCoordinatesPositionDoubleDouble() {
		Position result = instance.calculateEndingGlobalCoordinates(
				START_POSITION, 90,// bearing
				1000// Distance in meters
				);

		double stopLatDegrees = Angle
				.toDegrees(result.getLatitude().getValue());
		double stopLonDegrees = Angle.toDegrees(result.getLongitude()
				.getValue());
		double expectedLat = 43.55599933018189;
		double expectedLon = -90.87562405214152;

		System.out.println("Destination 90 bearing 1K lat=" + stopLatDegrees
				+ " lon=" + stopLonDegrees);

		assertEquals(expectedLat, stopLatDegrees);
		assertEquals(expectedLon, stopLonDegrees);
	}

	/**
	 * Move one radian of LATitude
	 */
	public final void testCalculateGeodeticCurveMovingLatitudeOneRadian() {
		Measurement lat_measurement_end = new Measurement(
				LAT_MEASUREMENT.getValue() + 1, Unit.rad);
		// Measurement lon2 = new
		// Measurement(Angle.toRadians(LONGITUDE_D),Unit.rad);
		Position endPosition = new Position(lat_measurement_end,
				LON_MEASUREMENT, ALT_MEASUREMENT, null, null);
		GeodeticCurve result = instance.calculateGeodeticCurve(START_POSITION,
				endPosition);
		System.out.println("Latitude One Radian:" + result.toString());
		assertEquals(LENGTH_LAT_RADIAN, result.getEllipsoidalDistance());
	}

	public final void testCalculateGeodeticCurveMovingLatitudeOneDegree() {
		GlobalCoordinates end = new GlobalCoordinates(LATITUDE_D + 1,
				LONGITUDE_D);
		GeodeticCurve result = instance.calculateGeodeticCurve(Ellipsoid.WGS84,
				START_COOR, end);
		System.out.println("Latitude One Degree:" + result.toString());
		assertEquals(LENGTH_LAT_DEGREE, result.getEllipsoidalDistance());

	}

	public final void testCalculateGeodeticCurveMovingLongitudeOneDegree() {
		GlobalCoordinates end = new GlobalCoordinates(LATITUDE_D,
				LONGITUDE_D + 1);
		GeodeticCurve result = instance.calculateGeodeticCurve(Ellipsoid.WGS84,
				START_COOR, end);
		System.out.println("Longitude One Degree:" + result.toString());
		assertEquals(LENGTH_LON_DEGREE, result.getEllipsoidalDistance());

	}

	public final void testCalculateGeodeticMeasurementMovingLatitudeOneRadian() {
		Measurement lat_measurement_end = new Measurement(
				LAT_MEASUREMENT.getValue() + 1, Unit.rad);
		// Measurement lon2 = new
		// Measurement(Angle.toRadians(LONGITUDE_D),Unit.rad);
		Position endPosition = new Position(lat_measurement_end,
				LON_MEASUREMENT, ALT_MEASUREMENT, null, null);
		GeodeticCurve result = instance.calculateGeodeticMeasurement(
				START_POSITION, endPosition);
		System.out.println("Latitude One Radian Measurement:"
				+ result.toString());
		assertEquals(LENGTH_LAT_RADIANM, result.getEllipsoidalDistance());
	}

}
