package com.verticon.tracker.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.EventHistory;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.util.EventHistoryAdapterFactory;

/**
 * Implements the Animal allEvents method (aka eventHistory). Maintains 
 * a list of all events associated with this Animal.
 * @author jconlon
 *
 */
public class AnimalEventHistoryAdapter extends EContentAdapter implements
		EventHistory {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(AnimalEventHistoryAdapter.class);

	private Animal animal = null;
	private EList<Event> events = new BasicEList<Event>();
	private Adapter forwardingAdapter = null;

	public AnimalEventHistoryAdapter() {
		super();

	}

	public synchronized EList<Event> eventHistory() {
		if (animal.getTags().isEmpty()) {
			events.clear();
		} else if (events.isEmpty()) {
			for (Tag tag : animal.getTags()) {
				events.addAll(tag.getEvents());
			}
		}
		return ECollections.unmodifiableEList(events);
	}

	public void setForwarding(Adapter adapter) {
		this.forwardingAdapter = adapter;
	}

	/**
	 * Only handle Events, Tags, and the Animal notifications
	 */
	@Override
	public synchronized void notifyChanged(Notification notification) {
		super.notifyChanged(notification);// needed to walk the entire model
		if (notification.isTouch()) {
			return;
		}
		// find out the type of the notifier which could be either 'Book' or
		// 'Library'
		Object notifier = notification.getNotifier();
		if (notifier instanceof Tag) {
			handleTagNotification(notification);
		} else if (notifier instanceof Event) {
			handleEventNotification(notification);
		} else if (notifier instanceof Animal) {
			handleAnimalNotification(notification);
		} else {
			logger.error("BaseHandler: Did not handle {} from {}",
					notification, notifier);
		}
	}
	
	/**
	 * Set the animal before calling calling super.
	 */
	public void setTarget(Notifier target) {
		if (animal == null && target instanceof Animal) {
			animal = (Animal) target;
		}
		super.setTarget(target);
	}
	
	

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EventHistory.class;
	}

	/**
	 * Notifications from Tags
	 * 
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	private void handleTagNotification(Notification n) {
		switch (n.getFeatureID(Tag.class)) {
		case TrackerPackage.TAG__EVENTS:
			switch (n.getEventType()) {
			case Notification.ADD:
				Event event = (Event) n.getNewValue();
				if (events.contains(event)) {
					logger.warn("{} from tag {} already exists", event
							.getClass().getSimpleName(),
							((Tag) n.getNotifier()).getId());
				} else {
					events.add(event);
					logger.debug("{} added to tag {}", event.getClass()
							.getSimpleName(), ((Tag) n.getNotifier()).getId());
					forwardAdd(event);
				}
				break;

			case Notification.ADD_MANY:
				EList<Event> eventsToAdd = (EList<Event>) n.getNewValue();
				if (events.addAll(eventsToAdd)) {
					logger.debug("Tag {} added {} events", ((Tag) n
							.getNotifier()).getId(), eventsToAdd.size());
					forwardAdd(eventsToAdd);
				}
				break;
			case Notification.REMOVE_MANY:
				EList<Event> eventsToRemove = (EList<Event>) n.getOldValue();
				if (events.remove(eventsToRemove)) {
					logger.debug("Tag {} removed {} events", ((Tag) n
							.getNotifier()).getId(), eventsToRemove.size());
					forwardRemove(eventsToRemove);
				}
				break;
			case Notification.REMOVE:
				Event eventToRemove = (Event) n.getOldValue();
				if (events.contains(eventToRemove)) {
					events.remove(eventToRemove);
					logger.debug("{} removed ", eventToRemove.getClass()
							.getSimpleName());
					forwardRemove(eventToRemove);
				} else {
					logger.warn("TagHandler: {} already removed from events",
							eventToRemove.getClass().getSimpleName());
				}

				break;

			default:
				logger.error("Did not handle a Tag {}", n);
				break;
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Notifications from Event
	 * 
	 * @param n
	 */
	private void handleEventNotification(Notification n) {

		switch (n.getFeatureID(Event.class)) {

		case -1:
			switch (n.getEventType()) {
			case Notification.REMOVING_ADAPTER:
				Event eventAffected = (Event) n.getNotifier();
				if (events.contains(eventAffected)) {
					logger.debug("EventHandler: removing {}", eventAffected
							.getClass().getSimpleName());
					events.remove(eventAffected);
					forwardRemove(eventAffected);
				} else {
					logger.warn("EventHandler: already removed {} ",
							eventAffected.getClass().getSimpleName());
				}
				break;
			// case TrackerPackage.EVENT__COMMENTS:
			// case TrackerPackage.EVENT__TAG:
			// logger.warn("EventHandler: Ignored Event feature {}",
			// n.getFeature());
			// break;
			default:
				break;
			}

		default:
			// logger.error("EventHandler: Did not handle Event {}", n);
			break;
		}

	}

	/**
	 * Notifications from Animal
	 * 
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	private void handleAnimalNotification(Notification n) {
		switch (n.getFeatureID(Animal.class)) {
		case TrackerPackage.ANIMAL__TAGS:
			switch (n.getEventType()) {
			case Notification.ADD:
				Tag tag = (Tag) n.getNewValue();
				logger.debug("{} added to animal {}", tag.getId(), n);
				if (tag.getEvents().isEmpty()) {
					logger.debug("Tag {} had no events to add", tag.getId());
					break;
				}
				events.addAll(tag.getEvents());
				logger.debug("Tag {} added {} events", tag.getId(), tag
						.getEvents().size());
				// forward(new NotificationImpl(Notification.ADD_MANY, null, tag
				// .getEvents()));
				forwardAdd(tag.getEvents());
				break;
			case Notification.ADD_MANY:
				EList<Tag> tagsToAdd = (EList<Tag>) n.getNewValue();
				EList<Event> eventsToAdd = new BasicEList<Event>();
				for (Tag tagToAdd : tagsToAdd) {
					eventsToAdd.addAll(tagToAdd.getEvents());
				}
				if (events.addAll(eventsToAdd)) {
					logger.debug("Added {} tags {} with {} events", tagsToAdd
							.size(), eventsToAdd.size());
					forwardAdd(eventsToAdd);
				}
				break;
			case Notification.REMOVE:
				tag = (Tag) n.getOldValue();
				if (events.removeAll(tag.getEvents())) {
					logger
							.debug(
									"{} tag removed at least one event from a list of {} events",
									tag.getId(), tag.getEvents().size());
					forwardAdd(tag.getEvents());
				}

				break;

			case Notification.REMOVE_MANY:
				EList<Tag> tagsToRemove = (EList<Tag>) n.getOldValue();
				EList<Event> eventsToRemove = new BasicEList<Event>();

				for (Tag tagToRemove : tagsToRemove) {
					logger.debug("{} added to animal {}", tagToRemove.getId(),
							n);
					eventsToRemove.addAll(tagToRemove.getEvents());

				}
				if (events.removeAll(eventsToRemove)) {
					logger
							.debug(
									"At least one event was removed from a removal of {} tags ",
									tagsToRemove.size());
				}
				forwardRemove(eventsToRemove);
				break;
			default:
				// logger.error("Did not handle Animal {}", n);
				break;
			}

		default:
			break;
		}

	}

	private void forward(Notification n) {
		if (forwardingAdapter == null) {
			if (animal.eContainer() != null
					&& animal.eContainer() instanceof Premises) {
				Premises premises = (Premises) animal.eContainer();
				Adapter premisesAdapter = EventHistoryAdapterFactory.INSTANCE
						.adapt(premises, EventHistory.class);
				logger.debug("Forwarding notification {}", n);
				premisesAdapter.notifyChanged(new NotificationWrapper(this, n));

			}
		} else {
			forwardingAdapter.notifyChanged(new NotificationWrapper(this, n));
		}
	}

	private void forwardAdd(Event eventToAdd) {
		forward(new NotificationImpl(Notification.ADD, null, eventToAdd));
	}

	private void forwardAdd(EList<Event> eventsToAdd) {
		forward(new NotificationImpl(Notification.ADD_MANY, null, eventsToAdd));
	}

	private void forwardRemove(Event eventToRemove) {
		forward(new NotificationImpl(Notification.REMOVE, eventToRemove, null));
	}

	private void forwardRemove(EList<Event> eventsToRemove) {
		forward(new NotificationImpl(Notification.REMOVE_MANY, eventsToRemove,
				null));
	}

	

}
