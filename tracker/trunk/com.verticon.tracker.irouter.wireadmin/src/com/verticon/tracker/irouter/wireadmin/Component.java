package com.verticon.tracker.irouter.wireadmin;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireAdmin;
import org.osgi.service.wireadmin.WireAdminEvent;
import org.osgi.service.wireadmin.WireAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Component implements WireAdminListener, IWireCreator {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(Component.class);
	/**
	 * Identify the plugin to the logger
	 */
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.wireadmin";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	public static final Marker bundleMarker;
	static {
		bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}


	private final Map<String, GroupConnector> groupConnectors = new HashMap<String, GroupConnector>();

	/**
	 * Bound Service
	 */
	private WireAdmin wireAdmin;

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Component [name=Wire Admin and Utils]";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.wireadmin.IWireCreator#createWire(com.verticon.tracker
	 * .wireadmin.WireParameters)
	 */
	@Override
	public boolean createWire(WireParameters wireParameters) {
		if(wireAdmin==null){
			logger.warn(bundleMarker,
					"No wireAdmin Service found, so could not create wire with {}",
					wireParameters);
			return false;
		}
		// "(&(" + Constants.OBJECTCLASS + "=Person)(|(sn=Jensen)(cn=Babs J*)))"
		String filter = 
			"(&(" + WIREADMIN_PRODUCER_PID + "="+wireParameters.getProducerPid()+")("+
					WIREADMIN_CONSUMER_PID + "="+wireParameters.getConsumerPid()+"))";
		Wire[] wires = null;
		try {
			
			wires = wireAdmin.getWires(filter);
			
		} catch (InvalidSyntaxException e) {
			logger.error(bundleMarker,
					"Programing error, bad filter={}",filter);
			return false;
		}
		if(wires == null || wires.length==0){
			logger.debug(bundleMarker,
					"Create a new wire for {}",wireParameters);
					
			wireAdmin.createWire(wireParameters.getProducerPid(), wireParameters
					.getConsumerPid(), wireParameters.getProperties());
			return true;
//		}else if(wires.length ==1){
//			log.debug((String.format(
//					"{}: A wire already exists. Defered creating a new one.",this)));
		}else{
			logger.debug(bundleMarker,
					"{} wires already exist. Deleting all existing wires, before creating one.",
					wires.length);
			for (Wire wire : wires) {
				wireAdmin.deleteWire(wire);
			}
			wireAdmin.createWire(wireParameters.getProducerPid(), wireParameters
					.getConsumerPid(), wireParameters.getProperties());		
		}
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.WireAdminListener#wireAdminEvent(org.osgi.
	 * service.wireadmin.WireAdminEvent)
	 */
	@Override
	public void wireAdminEvent(WireAdminEvent event) {
		String group = (String) event.getWire().getProperties().get(
				TRACKER_WIRE_GROUP_NAME);
		String scope[] = (String[]) event.getWire().getScope();
		switch (event.getType()) {
		case WireAdminEvent.WIRE_CREATED:
			if (logger.isInfoEnabled()) {
				String producerPid = (String) event.getWire().getProperties()
						.get(WIREADMIN_PRODUCER_PID);
				String consumerPid = (String) event.getWire().getProperties()
						.get(WIREADMIN_CONSUMER_PID);
				logger.info(bundleMarker,
						"Wire created entity={}, producerPid={}, consumerPid={}, scope={},",
										new Object[]{group, producerPid, consumerPid,
										Arrays.toString(scope)});
			}
			break;
		case WireAdminEvent.WIRE_CONNECTED:
			if (logger.isDebugEnabled()) {
				String producerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_PRODUCER_PID);
				String consumerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_CONSUMER_PID);
				logger.debug(bundleMarker,
						"Wire connected entity={}, producerPid={}, consumerPid={}, scope={},",
						new Object[]{group, producerPid, consumerPid,
						Arrays.toString(scope)});
			}
			break;
		case WireAdminEvent.WIRE_DISCONNECTED:
			if (logger.isDebugEnabled()) {
				String producerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_PRODUCER_PID);
				String consumerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_CONSUMER_PID);
				logger.debug(bundleMarker,
						"Wire disconnected entity={}, producerPid={}, consumerPid={}, scope={},",
						new Object[]{group, producerPid, consumerPid,
						Arrays.toString(scope)});
			}
			break;
		case WireAdminEvent.CONSUMER_EXCEPTION:
				String producerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_PRODUCER_PID);
				String consumerPid = (String) event.getWire().getProperties()
				.get(WIREADMIN_CONSUMER_PID);
				logger.error(bundleMarker,
						String.format(
						"Consumer Exception entity=%s, producerPid=%s, consumerPid=%s, scope=%s,",
						group, producerPid, consumerPid,
						Arrays.toString(scope)),event.getThrowable());
			
			break;
		case WireAdminEvent.PRODUCER_EXCEPTION:
			producerPid = (String) event.getWire().getProperties()
			.get(WIREADMIN_PRODUCER_PID);
			consumerPid = (String) event.getWire().getProperties()
			.get(WIREADMIN_CONSUMER_PID);
			logger.error(bundleMarker,
					String.format(
					"Producer Exception wire for entity=%s, producerPid=%s, consumerPid=%s, scope=%s,",
					group, producerPid, consumerPid,
					Arrays.toString(scope)),event.getThrowable());
		
		break;
		default:
			break;
		}

	}

	// Component services binding methods

	public void setProducer(Producer producer, Map<String, Object> properties) {
		String group = (String) properties
				.get(TRACKER_WIRE_GROUP_NAME);
		if (!groupConnectors.containsKey(group)) {
			groupConnectors.put(group, new GroupConnector(group, this));
		}
		groupConnectors.get(group).setProducer(properties);
	}

	public void setConsumer(Consumer consumer, Map<String, Object> properties) {
		String group = (String) properties
				.get(TRACKER_WIRE_GROUP_NAME);
		if (!groupConnectors.containsKey(group)) {
			groupConnectors.put(group, new GroupConnector(group, this));
		}
		groupConnectors.get(group).setConsumer(properties);
	}

	public void setWireAdmin(WireAdmin wireAdmin) {
		this.wireAdmin = wireAdmin;
		
	}

	public void unsetWireAdmin(WireAdmin wireAdmin) {
		this.wireAdmin = wireAdmin;
	}

}
