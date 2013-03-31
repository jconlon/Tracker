package com.verticon.osgi.useradmin.mongo.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;
import static com.verticon.osgi.useradmin.mongo.internal.Serializer.NAME;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.service.useradmin.UserAdminEvent;
import org.osgi.service.useradmin.UserAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.base.Optional;
import com.google.common.eventbus.Subscribe;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.verticon.mongo.MongoDBCollectionProvider;
import com.verticon.osgi.useradmin.impl.RoleChangedEvent;
import com.verticon.osgi.useradmin.impl.RoleCreatedEvent;
import com.verticon.osgi.useradmin.impl.RoleRemovedEvent;

/**
 * Main entry point for the UserAdmin component. This is a decorator that
 * handles listening for changes and firing events. This class delegates the
 * implementation of the UserAdmin to the base class UserAdminImpl.
 * 
 * 
 * @author jconlon based on ideas and snippets from the Apache Felix UserAdmin
 *         implementation org.apache.felix.useradmin
 * 
 */
public class UserAdminComponent extends UserAdminImpl implements UserAdmin {

	private static String PLUGIN_ID = "com.verticon.osgi.useradmin.mongo";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		UserAdminComponent.bundleMarker.add(MarkerFactory
				.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	protected Logger logger = LoggerFactory
			.getLogger(UserAdminComponent.class);

	private final List<UserAdminListener> listeners = new CopyOnWriteArrayList<UserAdminListener>();

	private static final String TOPIC_BASE = "org/osgi/service/useradmin/UserAdmin/";
	private ExecutorService exec = null;

	private EventAdmin eventAdmin;
	private EventDispatcher eventDispatcher;
	private ComponentContext componentContext;

	public UserAdminComponent() {
		super();
	}

	@Subscribe
	public void handle(RoleChangedEvent event) {
		Role role = event.getRole();
		handleChangedRoleEvent(role);
		logger.info(bundleMarker, "{} changed.", role);
		roleCache.put(role.getName(), Optional.of(role));
		if (role.getType() == Role.GROUP) {
			Group group = (Group) role;
			for (Role member : group.getMembers()) {
				roleCache.put(member.getName(), Optional.of(member));
			}
			for (Role member : group.getRequiredMembers()) {
				roleCache.put(member.getName(), Optional.of(member));
			}
		}
		eventDispatcher.dispatch(createUserAdminEvent(
				UserAdminEvent.ROLE_CHANGED, role));
	}

	@Subscribe
	public void handle(RoleCreatedEvent event) {
		eventDispatcher.dispatch(createUserAdminEvent(
				UserAdminEvent.ROLE_CREATED, event.getRole()));
	}

	@Subscribe
	public void handle(RoleRemovedEvent event) {
		eventDispatcher.dispatch(createUserAdminEvent(
				UserAdminEvent.ROLE_REMOVED, event.getRole()));
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * 
	 */
	void activate(ComponentContext context) {
		this.componentContext = context;
		logger.debug(bundleMarker, "activating ");
		exec = Executors.newSingleThreadExecutor();
		MongoUtils.ensureIndexes(collection);
		this.eventBus.register(this);
		eventDispatcher = new EventDispatcher();
		exec.submit(eventDispatcher);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		logger.debug(bundleMarker, "deactivating");
		this.eventBus.unregister(this);
		try {
			// Send a poison pill to stop the eventDispatcher
			eventDispatcher.eventQueue.put("Poison Pill");
		} catch (InterruptedException e) {
			// Restore interrupt flag...
			Thread.currentThread().interrupt();
		}
		exec.shutdown();
		exec = null;
		eventDispatcher = null;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param listener
	 */
	void addUserAdminListener(UserAdminListener listener) {
		listeners.add(listener);
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param listener
	 */
	void removeUserAdminListener(UserAdminListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param eventAdmin
	 *            the eventAdmin to set
	 */
	void setEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param eventAdmin
	 *            the eventAdmin to set
	 */
	void unsetEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = null;
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param mongoDBCollectionProvider
	 */
	void setMongoDBCollectionProvider(
			MongoDBCollectionProvider mongoDBCollectionProvider) {
		this.collection = mongoDBCollectionProvider.getCollection();
	}

	/**
	 * Declaratives Services injection.
	 * 
	 * @param mongoDBCollectionProvider
	 */
	void unsetMongoDBCollectionProvider(
			MongoDBCollectionProvider mongoDBCollectionProvider) {
		this.collection = null;
	}

	/**
	 * Updates changed roles in Mongo. It is called by the superclass which is a
	 * RoleChangeListener and before firing UserAdminEvent on UserAdminListeners
	 * or sending events to the EventAdmin.
	 * 
	 * @param changedRole
	 */
	private void handleChangedRoleEvent(Role changedRole) {
		try {

			DBObject query = new BasicDBObject(NAME,
					changedRole.getName());

			DBObject update = serializer.serializeUpdate(changedRole);

			WriteResult result = collection.update(query, update,
					false /* upsert */, false /* multi */);

			if (result.getLastError() != null) {
				result.getLastError().throwOnError();
			}
		} catch (MongoException e) {
			logger.error(bundleMarker, "Failed to update changed role: "
					+ changedRole.getName(), e);
		}
	}



	/**
	 * Converts a given {@link UserAdminEvent} to a {@link Event} that can be
	 * dispatched through the {@link EventAdmin} service.
	 * 
	 * @param event
	 *            the event to convert, cannot be <code>null</code>.
	 * @return a new {@link Event}
	 */
	private Event convertEvent(UserAdminEvent event) {
		String topic = getTopicName(event.getType());
		Role role = event.getRole();
		ServiceReference<?> serviceRef = event.getServiceReference();

		Map<String, Object> props = newHashMap();
		props.put(EventConstants.EVENT_TOPIC, TOPIC_BASE.concat(topic));
		props.put(EventConstants.EVENT, event);
		props.put("role", role);
		props.put("role.name", role.getName());
		props.put("role.type", new Integer(role.getType()));
		if (serviceRef != null) {
			props.put(EventConstants.SERVICE, serviceRef);
			Object property;

			property = serviceRef.getProperty(Constants.SERVICE_ID);
			if (property != null) {
				props.put(EventConstants.SERVICE_ID, property);
			}
			property = serviceRef.getProperty(Constants.OBJECTCLASS);
			if (property != null) {
				props.put(EventConstants.SERVICE_OBJECTCLASS, property);
			}
			property = serviceRef.getProperty(Constants.SERVICE_PID);
			if (property != null) {
				props.put(EventConstants.SERVICE_PID, property);
			}
		}

		return new Event(topic, props);
	}

	/**
	 * Delivers the given event synchronously to all interested listeners.
	 * 
	 * @param event
	 *            the event to deliver, cannot be <code>null</code>.
	 */
	private void deliverEventSynchronously(UserAdminEvent event) {
		// Asynchronously deliver an event to the EventAdmin service...
		eventAdmin.postEvent(convertEvent(event));

		// Synchronously call all UserAdminListeners to deliver the event...
		for (UserAdminListener listener : listeners) {
			listener.roleChanged(event);
		}
	}

	/**
	 * Converts a topic name for the given event-type.
	 * 
	 * @param type
	 *            the type of event to get the topic name for.
	 * @return a topic name, never <code>null</code>.
	 */
	private String getTopicName(int type) {
		switch (type) {
		case UserAdminEvent.ROLE_CREATED:
			return "ROLE_CREATED";
		case UserAdminEvent.ROLE_CHANGED:
			return "ROLE_CHANGED";
		case UserAdminEvent.ROLE_REMOVED:
			return "ROLE_REMOVED";
		default:
			return null;
		}
	}

	/**
	 * Creates a new {@link UserAdminEvent} instance for the given type and
	 * role.
	 * 
	 * @param type
	 *            the type of event to create;
	 * @param role
	 *            the role to create the event for.
	 * @return a new {@link UserAdminEvent} instance, never <code>null</code>.
	 */
	private UserAdminEvent createUserAdminEvent(int type, Role role) {
		checkNotNull(role, "role argument is null");
		return new UserAdminEvent(componentContext.getServiceReference(), type,
				role);
	}

	private final class EventDispatcher implements Runnable {

		private final LinkedBlockingQueue<Object> eventQueue = new LinkedBlockingQueue<Object>();

		/**
		 * Dispatches a given event for asynchronous delivery to all interested
		 * listeners, including those using the {@link EventAdmin} service.
		 * <p>
		 * This method will perform a best-effort to dispatch the event to all
		 * listeners, i.e., there is no guarantee that the listeners will
		 * actually obtain the event, nor any notification is given in case
		 * delivery fails.
		 * </p>
		 * 
		 * @param event
		 *            the event to dispatch, cannot be <code>null</code>.
		 * @throws IllegalStateException
		 *             in case this dispatcher is already stopped.
		 */
		public void dispatch(UserAdminEvent event) {
			if (Thread.currentThread().isInterrupted()) {
				return;
			}

			try {
				eventQueue.put(event);
			} catch (InterruptedException e) {
				// Restore interrupt flag...
				Thread.currentThread().interrupt();
			}
		}

		@Override
		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					// Blocks until a event is dispatched...
					Object event = eventQueue.take();

					if (event instanceof UserAdminEvent) {
						// Got a "normal" user admin event; lets dispatch it
						// further...
						deliverEventSynchronously((UserAdminEvent) event);
					} else {
						// Got a "poison" object; this means we must stop
						// running...
						return;
					}
				}
			} catch (InterruptedException e) {
				// Restore interrupt flag, and terminate thread...
				Thread.currentThread().interrupt();
			}

		}

	}

}
