package com.verticon.tracker.irouter.eventadmin.gateway.internal;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.irouter.eventadmin.gateway.ConfigKey.EVENT_ADMIN_PROPERTY_PRODUCT_STRING;
import static com.verticon.tracker.irouter.eventadmin.gateway.ConfigKey.getFirstScope;
import static com.verticon.tracker.irouter.eventadmin.gateway.ConfigKey.getServicePid;
import static com.verticon.tracker.irouter.eventadmin.gateway.ConfigKey.getWiringGroup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Forwards strings from the eventAdmin to the iRouter.
 * 
 * @author jconlon
 * 
 */
public class EventAdminGateway implements Monitorable, Producer, EventHandler {

	private static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.trigger.file";

	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		EventAdminGateway.bundleMarker
				.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(EventAdminGateway.class);

	private final StatusMonitor statusMonitor = new StatusMonitor();
	private Map<String, Object> config;
	private Wire[] wires = new Wire[] {};
	private String lastProduct = null;

	@Override
	public void handleEvent(Event event) {
		String string = (String) event
				.getProperty(EVENT_ADMIN_PROPERTY_PRODUCT_STRING.getKey());
		if (isNullOrEmpty(string)) {
			logger.error(bundleMarker,
					"Null or Empty String recieved from EventAdmin.", string);
		} else {
			logger.debug(bundleMarker, "handling string={} ", string);
		produce(string);
		}
	}

	private void produce(String in) {
		if (wires != null) {
			Envelope envelope = new BasicEnvelope(in, getServicePid(config),
					getFirstScope(config));
			logger.debug(bundleMarker, "{}: firing {} to {} wires",
					new Object[] { this, in, wires.length });

			for (Wire wire : wires) {
				wire.update(envelope);
				logger.info(bundleMarker, "Updated wire {} with {}", wire, in);
			}
			statusMonitor.incCount();
			lastProduct = in;

		} else {
			logger.warn(bundleMarker,
					"Defered firing {} because there are no wires", in);
		}
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return lastProduct;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} consumersConnected with wires={}", this,
				Arrays.toString(wires));
		statusMonitor.setWiresConnected(wires.length);
		this.wires = wires;
	}

	@Override
	public String[] getStatusVariableNames() {
		return statusMonitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return statusMonitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return statusMonitor.getDescription(id);
	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void activate(Map<String, Object> config) throws IOException {
		logger.debug(bundleMarker, "Activating");
		this.config = config;
		statusMonitor.setWiringGroup(getWiringGroup(config));

	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		config = null;
		statusMonitor.deactivate();
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}

}
