package com.verticon.tracker.irouter.eid.event.test.system.internal;

import static com.verticon.tracker.irouter.eid.event.test.system.internal.EIDEventProducerSystemTest.PLUGIN_ID;
import static com.verticon.tracker.irouter.eid.event.test.system.internal.EIDEventProducerSystemTest.bundleMarker;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Constants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.eid.event.test.system.Publisher;

/**
 * Mock producer of Envelopes.
 * 
 * @author jconlon
 * 
 */
public class MockEventGenerator implements Publisher {
	public static final String EVENT_ADMIN_PROPERTY_READER_NAME = "com.verticon.tracker.reader.name";
	public static final String EVENT_ADMIN_PROPERTY_ANIMAL_ID = "com.verticon.tracker.animal.id";
	public static final String EVENT_ADMIN_TOPIC_READER = "com/verticon/tracker/reader";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MockEventGenerator.class);

	private EventAdmin eventAdmin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockEventGenerator []";
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.eid.event.test.system.internal.Publisher#publish(java.lang.Long, java.lang.String)
	 */
	@Override
	public synchronized void publish(Long tagId, String name) {

		Map<String, Object> table = new HashMap<String, Object>();

		table.put(Constants.BUNDLE_SYMBOLICNAME, PLUGIN_ID);
		table.put(EVENT_ADMIN_PROPERTY_READER_NAME, name);
		table.put(EVENT_ADMIN_PROPERTY_ANIMAL_ID, tagId);

		if (eventAdmin != null) {
			// Todo Sends synchronously but could (should) asynchronous with a
			// postEvent call
			eventAdmin.sendEvent(new Event(EVENT_ADMIN_TOPIC_READER, table));
		} else {
			logger.warn(bundleMarker, "{} failed to find EventAdmin service",
					name);
		}
	}

	public synchronized void setEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}

}
