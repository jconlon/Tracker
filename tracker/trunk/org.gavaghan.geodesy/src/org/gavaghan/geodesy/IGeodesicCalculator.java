package org.gavaghan.geodesy;

import org.osgi.util.position.Position;

/**
 * http://www.gavaghan.org/blog/free-source-code/geodesy-library-vincentys-formula-java/
 * @author jconlon
 *
 */
public interface IGeodesicCalculator {

//	/**
//	 *
//	 * @param position
//	 * @param startBearing in degrees
//	 * @param distance
//	 * @param endBearing in degrees
//	 * @return end Position
//	 */
//	Position calculateEndingGlobalCoordinates(Position position,
//			double startBearing, double distance, double[] endBearing);

	/**
	 * 
	 * @param position
	 * @param startBearing in degrees
	 * @param distance
	 * @return end Position
	 */
	Position calculateEndingGlobalCoordinates(Position position,
			double startBearing, double distance);

	/**
	 * 
	 * @param startPosition
	 * @param endPosition
	 * @return GeodeticCurve
	 */
	GeodeticCurve calculateGeodeticCurve(Position startPosition,
			Position endPosition);

	/**
	 * 
	 * @param startPosition
	 * @param endPosition
	 * @return GeodeticMeasurement
	 */
	GeodeticMeasurement calculateGeodeticMeasurement(Position startPosition,
			Position endPosition);

	/**
	 * 
	 * @param latitude in degrees
	 * @param longitude in degrees
	 * @param distance
	 * @return radians error
	 */
	double calculateLongitudeError(double latitude, double longitude,
			double distance);

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @param distance
	 * @return radians error
	 */
	double calculateLatitudeError(double latitude, double longitude,
			double distance);

	/**
	 * 
	 * Note: large movements will also effect latitude due to the ellipsoid calculations
	 *
	 * @param latitude
	 * @param longitude
	 * @param distance
	 * @return degrees error
	 */
	double calculateLongitudeDegreesError(double latitude, double longitude,
			double distance);

	/**
	 * Note: large movements will also effect longitude due to the ellipsoid calculations
	 * @param latitude
	 * @param longitude
	 * @param distance
	 * @return degrees error
	 */
	double calculateLatitudeDegreesError(double latitude, double longitude,
			double distance);

}