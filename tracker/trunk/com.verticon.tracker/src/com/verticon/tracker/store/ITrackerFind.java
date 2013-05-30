package com.verticon.tracker.store;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;

public interface ITrackerFind {
	final String COORDINATE_REGEX = "^(\\-?\\d+(\\.\\d+)?),(\\-?\\d+(\\.\\d+)?),(\\-?\\d+(\\.\\d+)?)$";

	final String DATE_PATTERN = "yyyy-MM-dd";
	/**
	 * 
	 * Gets the Premises with all the animals that
	 * were located or contained in the premises between the 
	 * in date and the out date. If both dates are null,
	 * returns a premises without animals.
	 * 
	 * This will create a MongoDB query like:
	 * db.Tag.find({'events.dateTime': {$gte: start, $lt: end}})
	 * 
	 * Which  return all tags that have events less greater than start and le than the end
	 * so not just tags with event datetimes between the dates meet these criteria tags that
	 * have events earlier than start and later than end will be returned.
	 * 
	 * In other words events that surround the time period - which from an application point of view means that 
	 * the animal is in the premises for the time period but may not have generated any events during the time period.
	 * 
	 * @param uri
	 * @param in
	 *            date animal entered premises
	 * @param out
	 *            date animal left premises
	 * @return Premises animals that were in the premises during the span of
	 *         dates
	 */
	public abstract Premises retrievePremises(String uri, String in, String out)
			throws IOException;

	/**
	 * 
	 * @param uri
	 * @return Premises with no animals
	 * @throws IOException
	 */
	public abstract Premises retrievePremises(String uri) throws IOException;

	/**
	 * Gets the premises that contains the point. No animals are returned
	 * @param point
	 * @return premises
	 */
	public abstract Premises retrievePremises(LongLatPoint point)
			throws IOException;

	/**
	 * 
	 * Gets the Premises that contains the point with all the animals that
	 * were located or contained in the premises between the 
	 * in date and the out date. If both dates are null,
	 * returns a premises without animals.
	 * 
	 * 
	 * Which  return all tags that have events less greater than start and le than the end
	 * so not just tags with event datetimes between the dates meet these criteria tags that
	 * have events earlier than start and later than end will be returned.
	 * 
	 * In other words events that surround the time period - which from an application point of view means that 
	 * the animal is in the premises for the time period but may not have generated any events during the time period.
	 * 
	 * @param point
	 * @param in
	 *            date animal entered premises
	 * @param out
	 *            date animal left premises
	 * @return Premises animals that were in the premises during the span of
	 *         dates
	 */
	public abstract Premises retrievePremises(LongLatPoint point, String in,
			String out) throws IOException;

	/**
	 * 
	 * @param ain
	 *            the animal id
	 * 
	 * @return animal with the id
	 */
	public abstract Animal retrieveAnimal(String ain);

	/**
	 * 
	 * @param uris
	 *            of the Premises to retrieve
	 * @return map of uri to names for the Premises
	 */
	public abstract Map<String, String> getPremisesNames(Set<String> uris);

	class LongLatPoint {
		final String coordinates;
		final String longLat;

		final double[] array;

		public LongLatPoint(String coordinates) {
			if (coordinates == null) {
				throw new IllegalArgumentException(
						"coordinates argument can not be null.");
			}
			this.coordinates = coordinates;
			this.longLat = createLongLat();
			String[] s = longLat.split(",");
			double lon = Double.parseDouble(s[0]);
			double lat = Double.parseDouble(s[1]);
			this.array = new double[] { lon, lat };

		}

		public String getLongLat() {
			return longLat;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return coordinates;
		}

		public double[] toArray() {
			return array;
		}

		private String createLongLat() {
			String coordinatesTrimmed = coordinates.trim();
			boolean isValid = coordinatesTrimmed.matches(COORDINATE_REGEX);
			if (!isValid) {
				throw new IllegalArgumentException(coordinates
						+ " are not valid point coordinates.");
			}
			return coordinatesTrimmed.substring(0,
					coordinatesTrimmed.lastIndexOf(','));

		}

	}
}