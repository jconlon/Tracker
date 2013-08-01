package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.tracker.store.mongodb.internal.Utils.ID_KEY;
import static com.verticon.tracker.store.mongodb.internal.Utils.bundleMarker;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.mongodb.DBObject;
import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.store.UpdateStats;

//import com.mongodb.DBObject;

public class AnimalUpdate {

	enum State {
		ANIMAL, TAGS, EVENTS, EVENTS_AND_TAG, ANIMAL_EXCEPTION, TAGS_EXCEPTION, EVENTS_AND_TAG_EXCEPTION, EVENTS_EXCEPTION
	};

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(AnimalUpdate.class);

	private final Animal animal;
	private final Date date;
	private final String premiseURI;

	private final List<Tag> tags = newArrayList();
	private final Multimap<String, Event> eventsToRecord = ArrayListMultimap
			.create();
	private final List<Map<String, ?>> persistedTags = newArrayList();

	private State state = State.ANIMAL;
	private UpdateException exception = null;
	private BSONObject animalDBObject = null;

	public AnimalUpdate(Animal animal, Date date, String premiseURI) {
		this.animal = animal;
		this.date = date;
		this.premiseURI = premiseURI;
		initialize();
	}

	/**
	 * @return the premiseURI
	 */
	String getPremiseURI() {
		return premiseURI;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalUpdate [state=" + state + ", animal=" + animal.getId()
				+ ", date=" + date + ", premiseURI=" + premiseURI
				+ ", exception=" + exception + ", persistedTags="
				+ persistedTags + ", animalDBObject=" + animalDBObject + "]";
	}

	/**
	 * @return the animal
	 */
	Animal getAnimal() {
		return animal;
	}

	/**
	 * @return the tag
	 */
	Collection<Tag> getTags() {
		return tags;
	}

	/**
	 * @return the eventsToRecord
	 */
	Multimap<String, Event> getEvents() {
		return eventsToRecord;
	}

	/**
	 * @return the state
	 */
	State getState() {
		return state;
	}

	void addPersistedTag(Map<String, ?> dbo) {
		persistedTags.add(dbo);
	}

	void validate() throws IllegalStateException {
		Set<String> persistedIds = newHashSet(Iterables.transform(
				persistedTags, Utils.dbToId));
		Set<String> targetTagIDs = newHashSet(Iterables.transform(tags,
				Utils.tagToId));

		switch (state) {
		case ANIMAL:
			if (!targetTagIDs.isEmpty() && !eventsToRecord.isEmpty()
					&& !persistedIds.isEmpty()) {
				// There are EventsToRecord, Tags, and persistedTags
				state = State.EVENTS_AND_TAG;
				processAlreadyRecordedTags(persistedIds, targetTagIDs);
			} else if (!eventsToRecord.isEmpty() && !persistedTags.isEmpty()) {
				// Events only
				state = State.EVENTS;
			} else if (!tags.isEmpty() && !persistedTags.isEmpty()) {
				// Tags and persisted Tags
				state = State.TAGS;
				processAlreadyRecordedTags(persistedIds, targetTagIDs);
			}
			break;
		default:
		}

		// Find any new tags
		switch (state) {
		case EVENTS_AND_TAG:
		case EVENTS:
			for (String tagIdForEvents : eventsToRecord.keySet()) {
				if (!persistedIds.contains(tagIdForEvents)) {
					// This tag is a new Tag
					for (Tag tag : animal.getTags()) {
						if (tag.getId().equals(tagIdForEvents)) {
							tags.add(tag);
						}
					}
				}
			}

			break;
		default:
			break;
		}
		targetTagIDs = newHashSet(Iterables.transform(tags, Utils.tagToId));

		switch (state) {
		case EVENTS_AND_TAG:
		case EVENTS:
			if (!targetTagIDs.isEmpty()) {
				// Remove any events that are now new tags
				for (String tagId : targetTagIDs) {
					eventsToRecord.removeAll(tagId);
				}
			}

			if (eventsToRecord.isEmpty() && !tags.isEmpty()) {
				this.state = State.TAGS;
			}
		default:
			break;
		}

		switch (state) {
		case ANIMAL:
			// Check to see if the animal already is persisted
			if (persistedTags.isEmpty()) {
				// expected
				setPidOnTags();

			} else {
				state = State.ANIMAL_EXCEPTION;
				exception = new UpdateException(state, String.format(
						"Persisted Animal %s can not be inserted.",
						animal.getId()));
				logger.error(bundleMarker, "", exception);
			}

			break;
		case EVENTS_AND_TAG:
			// Check to see if list of eventsToRecord are targeted for a
			// persisted Tag

			// There must be tags and eventsToRecord
			if (tags.isEmpty() || eventsToRecord.isEmpty()) {
				this.state = State.EVENTS_AND_TAG_EXCEPTION;
				exception = new UpdateException(
						state,
						String.format(
								"Animal id = %s, Tags are empty = %s. events are empty = %s",
								animal.getId(), tags.isEmpty(),
								eventsToRecord.isEmpty()));
				logger.error(bundleMarker, "", exception);
			} else {
				setPidOnEvents(eventsToRecord);
			}
		case TAGS:
			// Check to see if any of the target tags are already persisted

			if (tags.isEmpty() || !eventsToRecord.isEmpty()) {
				this.state = State.TAGS_EXCEPTION;
				exception = new UpdateException(
						state,
						String.format(
								"Animal id = %s, Tags are empty = %s. events are empty = %s",
								animal.getId(), tags.isEmpty(),
								eventsToRecord.isEmpty()));
				logger.error(bundleMarker, "", exception);
				break;
			}
			Set<String> targetAlreadyPersisted = Sets.intersection(
					persistedIds, targetTagIDs);
			if (!targetAlreadyPersisted.isEmpty()) {
				this.state = State.TAGS_EXCEPTION;
				exception = new UpdateException(
						state,
						String.format(
								"Animal id = %s, Cannot insert already persisted tag ids = %s",
								animal.getId(), targetAlreadyPersisted));
				logger.error(bundleMarker, "", exception);

			} else {
				setPidOnTags();
			}
			break;
		case EVENTS:

			// There must be No tags and only eventsToRecord
			if (!tags.isEmpty() || eventsToRecord.isEmpty()) {
				this.state = State.EVENTS_EXCEPTION;
				exception = new UpdateException(
						state,
						String.format(
								"Animal id = %s, Tags or Events are empty. Number of tags = %s, number of events = %s",
								animal.getId(), tags.size(),
								eventsToRecord.size()));
				logger.error(bundleMarker, "", exception);

			} else {
				setPidOnEvents(eventsToRecord);
			}
			break;
		default:
			break;
		}

	}

	private void processAlreadyRecordedTags(Set<String> persistedIds,
			Set<String> targetTagIDs) {
		Set<String> alreadyRecorded = Sets.intersection(targetTagIDs,
				persistedIds);

		if (!Iterables.isEmpty(alreadyRecorded)) {
			// Some tags are already recorded.
			Collection<Tag> toRemove = newArrayList();
			for (String id : alreadyRecorded) {
				for (Tag tag : tags) {
					if (id.equals(tag.getId())) {
						eventsToRecord.putAll(id, tag.getEvents());
						toRemove.add(tag);
					}
				}
			}
			tags.removeAll(toRemove);
			if (tags.isEmpty()) {
				state = State.EVENTS;
			} else {
				state = State.EVENTS_AND_TAG;
			}

		}
	}

	/**
	 * 
	 * 
	 * @return the animal OID
	 */
	ObjectId getAnimalOID() {
		ObjectId result = null;
		switch (state) {
		case ANIMAL:
			result = (ObjectId) animalDBObject.get(ID_KEY);
			break;
		case TAGS:
		case EVENTS_AND_TAG:
			result = (ObjectId) persistedTags.get(0).get("animal");
			break;
		default:

		}
		return result;
	}

	void finish(UpdateStats stats) {
		switch (state) {
		case ANIMAL:
			stats.animalsAdded(1);
			stats.tagsAdded(animal.getTags().size());
			stats.eventsAdded(animal.eventHistory().size());
			break;
		case EVENTS_AND_TAG:
			stats.eventsAdded(eventsToRecord.size());
			break;
		case TAGS:
			stats.tagsAdded(tags.size());
			for (Tag tag : tags) {
				stats.eventsAdded(tag.getEvents().size());
			}
			break;
		case EVENTS:
			stats.eventsAdded(eventsToRecord.size());
			break;
		case ANIMAL_EXCEPTION:
			animal.setComments(exception.toString());
			stats.addException(exception);
			break;
		case EVENTS_AND_TAG_EXCEPTION:
			setExceptionOnEvents(eventsToRecord.values());
			// stats.exceptionsEncounted(eventsToRecord.size());
			stats.addException(exception);
		case TAGS_EXCEPTION:
			setExceptionOnTags();
			// stats.exceptionsEncounted(tags.size());
			stats.addException(exception);
			break;
		case EVENTS_EXCEPTION:
			setExceptionOnEvents(eventsToRecord.values());
			// stats.exceptionsEncounted(eventsToRecord.size());
			stats.addException(exception);
		default:
			break;
		}
		tags.clear();
		eventsToRecord.clear();
		persistedTags.clear();
	}

	/**
	 * @param animalDBObject
	 *            the animalDBObject to set
	 */
	void setAnimalDBObject(DBObject animalDBObject) {
		this.animalDBObject = animalDBObject;
	}

	/**
	 * Called by the constructor
	 */
	private void initialize() {
		// Find all Tags to be published
		for (Tag tag : animal.getTags()) {
			// Do all eventsToRecord in the tag need to be published
			if (Iterables.all(tag.getEvents(), unPublished)) {
				// Yes add the whole tag
				tags.add(tag);
				switch (state) {
				case EVENTS:
					state = State.EVENTS_AND_TAG;
					break;
				default:
					break;
				}
			} else {
				// Tag is recorded these are extra eventsToRecord
				Iterable<Event> unPublishedEvents = Iterables.filter(
						tag.getEvents(), unPublished);
				if (Iterables.isEmpty(unPublishedEvents)) {
					continue;
				}
				for (Event event : unPublishedEvents) {
					eventsToRecord.put(tag.getId(), event);
				}

				switch (state) {
				case TAGS:
					state = State.EVENTS_AND_TAG;
					break;
				case ANIMAL:
					state = State.EVENTS;
					break;
				case EVENTS_AND_TAG:
					state = State.ANIMAL_EXCEPTION;
					exception = new UpdateException(
							state,
							String.format(
									"Animal id = %s, Initialization error: More than one tag in this animal has new eventsToRecord.",
									animal.getId(), tags.size(),
									eventsToRecord.size()));
					logger.error(bundleMarker, "", exception);
				default:
					break;
				}

			}
		}

	}

	private void setPidOnTags() {
		for (Tag tag : tags) {
			setPidOnEvents(tag.getEvents());
		}
	}

	private void setPidOnEvents(List<Event> eventsToSet) {
		for (Event event : eventsToSet) {
			event.setPid(premiseURI);
		}
	}

	private void setPidOnEvents(Multimap<String, Event> eventsToSet) {
		for (Event event : eventsToSet.values()) {
			event.setPid(premiseURI);
		}
	}

	private void setExceptionOnTags() {
		for (Tag tag : tags) {
			setExceptionOnEvents(tag.getEvents());
		}
	}

	private void setExceptionOnEvents(Collection<Event> eventsToSet) {
		for (Event event : eventsToSet) {
			event.setComments(exception.toString());
		}
	}

	private final Predicate<Event> unPublished = new Predicate<Event>() {
		@Override
		public boolean apply(Event event) {
			return date == null || event.getDateTime().after(date)
					&& isNullOrEmpty(event.getPid());
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((premiseURI == null) ? 0 : premiseURI.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AnimalUpdate)) {
			return false;
		}
		AnimalUpdate other = (AnimalUpdate) obj;
		if (animal == null) {
			if (other.animal != null) {
				return false;
			}
		} else if (!animal.equals(other.animal)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (premiseURI == null) {
			if (other.premiseURI != null) {
				return false;
			}
		} else if (!premiseURI.equals(other.premiseURI)) {
			return false;
		}
		return true;
	}

}
