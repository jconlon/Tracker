package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongodb.internal.Utils.ANIMAL;
import static com.verticon.tracker.store.mongodb.internal.Utils.ID_KEY;
import static com.verticon.tracker.store.mongodb.internal.Utils.TAG;
import static com.verticon.tracker.store.mongodb.internal.Utils.createResourceWithEmptyURI;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Premises;
import com.verticon.tracker.store.ITrackerFind;

public class AnimalFinder {

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			ITrackerFind.DATE_PATTERN);

	private final UpdateAndFind updateAndFind;

	public AnimalFinder(UpdateAndFind updateAndFind) {
		this.updateAndFind = updateAndFind;
	}

	/**
	 * Finds animal using the ain. Note, that if and when the Animals need to
	 * move to a sharded environment, with sharding index _id and a hashed
	 * index, animals can then be found using an index via getting the tag
	 * first, then the ObjectId of the animal from the Tag.
	 * 
	 * 
	 * @param ain
	 * @return
	 */
	Animal retrieveAnimal(String ain) {
		// Find the animal
		DBCollection coll = updateAndFind.getCollection(ANIMAL);
		DBObject q = new BasicDBObject("tags", ain);
		DBObject animalDbObject = coll.findOne(q);

		if (animalDbObject == null) {
			throw new IllegalStateException("Tag recorded but animal is not!");
		}

		// Transform the animal

		Function<DBObject, EObject> builder = updateAndFind
				.getFunctionProvider().getDBObjectToEObjectFunction(coll,
						createResourceWithEmptyURI());

		return (Animal) builder.apply(animalDbObject);

	}

	/**
	 * 
	 * Get Animals that have events with dates between the time frames. TODO
	 * should handle nulls for dates
	 * 
	 * @param premises
	 * @param from
	 * @param to
	 * @return
	 * @throws IOException
	 */
	int findAndAddAnimals(Premises premises, String from, String to)
			throws IOException {
		checkNotNull(premises, "Premises can not be null.");
		checkArgument(premises.getUri() != null,
				"Premises uri can not be null.");

		BasicDBObject query = null;

		if (Strings.isNullOrEmpty(from) && Strings.isNullOrEmpty(to)) {
			// Do nothing to the result
			return 0;
		} else if (Strings.isNullOrEmpty(from)) {
			query = buildQueryBeforeDate(premises, to);
		} else if (Strings.isNullOrEmpty(to)) {
			query = buildQueryAfterDate(premises, from);
		} else {
			query = buildQueryBetweenDates(premises, from, to);
		}

		BasicDBObject fields = new BasicDBObject("animal", 1).append(ID_KEY, 0);

		DBCollection coll = updateAndFind.getCollection(TAG);

		DBCursor tagDbos = coll.find(query, fields);
		Set<ObjectId> animalOids = newHashSet(Iterables.transform(tagDbos,
				Utils.tagAnimalDbToOId));

		// Now get all the animals for those tags by ObjectId
		query = new BasicDBObject();
		query.put(ID_KEY, new BasicDBObject("$in", animalOids));
		coll = updateAndFind.getCollection(ANIMAL);
		DBCursor animalDbos = coll.find(query);

		Function<DBObject, EObject> builder = updateAndFind
				.getFunctionProvider().getDBObjectToEObjectFunction(coll,
						createResourceWithEmptyURI());

		Iterable<EObject> eObjects = Iterables.transform(animalDbos, builder);

		List<Animal> animals = newArrayList();

		for (EObject eObject : eObjects) {
			animals.add((Animal) eObject);
		}

		Collections.sort(animals, new Comparator<Animal>() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.util.Comparator#compare(java.lang.Object,
			 * java.lang.Object)
			 */
			@Override
			public int compare(Animal a1, Animal a2) {
				return a1.getId().compareTo(a2.getId());
			}
		});

		premises.getAnimals().addAll(EcoreUtil.copyAll(animals));

		return Iterables.size(eObjects);
	}

	// Get all the Tags associated with the premises between the dates
	private BasicDBObject buildQueryBetweenDates(Premises premises,
			String from, String to) {
		BasicDBObject query;
		Date fromDate;
		Date toDate;
		try {
			toDate = DATE_FORMAT.parse(to);
			fromDate = DATE_FORMAT.parse(from);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		// db.Tag.find( { "events":
		// { $elemMatch: { dateTime: { $gte: start , $lt: end },
		// pid :"urn:pin:H89234X" } }
		// },
		// {ID_KEY:0 , "animal":1} )
		BasicDBObject arrayMatch = new BasicDBObject("dateTime",
				new BasicDBObject(QueryOperators.GTE, fromDate).append(
						QueryOperators.LT, toDate)).append("pid",
				premises.getUri());

		query = new BasicDBObject("events", new BasicDBObject("$elemMatch",
				arrayMatch));
		return query;
	}

	// Get all the Tags associated with the premises after the date
	private BasicDBObject buildQueryAfterDate(Premises premises, String from) {
		BasicDBObject query;
		Date fromDate;

		try {

			fromDate = DATE_FORMAT.parse(from);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
		// db.Tag.find( { "events":
		// { $elemMatch: { dateTime: { $gte: start},
		// pid :"urn:pin:H89234X" } }
		// },
		// {ID_KEY:0 , "animal":1} )

		BasicDBObject arrayMatch = new BasicDBObject("dateTime",
				new BasicDBObject(QueryOperators.GTE, fromDate)).append("pid",
				premises.getUri());

		query = new BasicDBObject("events", new BasicDBObject("$elemMatch",
				arrayMatch));
		return query;
	}

	// Get all the Tags associated with the premises between the dates
	private BasicDBObject buildQueryBeforeDate(Premises premises, String to) {
		BasicDBObject query;

		Date toDate;
		try {
			toDate = DATE_FORMAT.parse(to);

		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		// db.Tag.find( { "events":
		// { $elemMatch: { dateTime: { $gte: start , $lt: end },
		// pid :"urn:pin:H89234X" } }
		// },
		// {ID_KEY:0 , "animal":1} )
		BasicDBObject arrayMatch = new BasicDBObject("dateTime",
				new BasicDBObject(QueryOperators.LT, toDate)).append("pid",
				premises.getUri());

		query = new BasicDBObject("events", new BasicDBObject("$elemMatch",
				arrayMatch));
		return query;
	}
}
