package com.verticon.tracker.irouter.wireadmin.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

/**
 * iRouter Producers and Consumers contain certain properties that aid in the 
 * creation of wires between them.  WireGroup, Consumer_Scope, and Producer_Scope.
 * For the WireGroup must match and there must be a common name between the Consumer 
 * Producer Scopes.
 * 
 * As Producers and Consumers are injected by DS, this Component will add 
 * their properties to a map of GroupConnector objects. The GroupConnector
 * will call back this Component for the creation of appropriate wires.
 * 
 * @author jconlon
 *
 */
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

	private List<WireParameters> wireParametersToBeHandled = new ArrayList<WireParameters>();
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Component [name=Wire Admin and Utils]";
	}
	
	/**
	 * Declarative Services deactivation
	 */
	public void deactivate(){
		groupConnectors.clear();
		wireParametersToBeHandled.clear();
	}
	
	
	/**
	 * Called by the GroupConnector to create the wire. If one already exists,
	 * it will delete it first.
	 * 
	 * @param wireParameters
	 * @see com.verticon.tracker.irouter.wireadmin.internal.IWireCreator#handleWire(com.verticon.tracker.irouter.wireadmin.internal.WireParameters)
	 */
	@Override
	public boolean handleWire(WireParameters wireParameters) {
		synchronized(wireParametersToBeHandled){
			if(wireAdmin==null){
				logger.warn(bundleMarker,
						"No wireAdmin Service found, so could not create wire with {}",
						wireParameters);

				wireParametersToBeHandled.add(wireParameters);

				return false;
			}
		}
		
		if(wireParameters.getConsumerPid()==null){
		    deleteAllProducerWires(wireParameters);
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
			if(wireParameters.isDelete()){
				return false;
			}else{
				logger.debug(bundleMarker,
						"Create a new wire for {}",wireParameters);
				wireAdmin.createWire(wireParameters.getProducerPid(), wireParameters
					.getConsumerPid(), wireParameters.getProperties());
				return true;
			}

		}else{
			
			deleteWires(wires, wireAdmin);
			if(wireParameters.isDelete()){
				logger.debug(bundleMarker,
						"Deleting {} existing wires.",
						wires.length);
				return false;
			}else{
				logger.debug(bundleMarker,
						"Deleted {} existing wires, before creating a new one.",
						wires.length);
				 wireAdmin.createWire(wireParameters.getProducerPid(), wireParameters
							.getConsumerPid(), wireParameters.getProperties());	
			}
		}
		
		return true;
	}

	private void deleteAllProducerWires(WireParameters wireParameters) {
		// "(&(" + Constants.OBJECTCLASS + "=Person)(|(sn=Jensen)(cn=Babs J*)))"
		String filter = 
			"(" + WIREADMIN_PRODUCER_PID + "="+wireParameters.getProducerPid()+")";
		Wire[] wires = null;
		try {
			wires = wireAdmin.getWires(filter);
			
		} catch (InvalidSyntaxException e) {
			logger.error(bundleMarker,
					"Programing error, bad filter={}",filter);
			return ;
		}
		if(wires == null || wires.length==0){
			return;
		}
		
		deleteWires(wires, wireAdmin);
	}

	private static void deleteWires(Wire[] wires, WireAdmin wireAdmin) {
		for (Wire wire : wires) {
			wireAdmin.deleteWire(wire);
		}
	}

	/**
	 * Just Logs wire events.
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
		String producerPid = (String)properties.get(SERVICE_PID);
		if(! groupConnectors.get(group).isProducerRegistered(producerPid)){
			deleteAllWires(producerPid);
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

	/**
	 * DS Inject point for WireAdmin.  To avoid timing problems with wireAdmin
	 * setting WireAdmin late, after Producers and Consumers may have already 
	 * started setting wireAdmin will check to see if there are any wiresToBeCreated
	 * which represents queued up wireCreationRequests.
	 * 
	 * @param wireAdmin
	 * @since 0.2.0
	 */
	public void setWireAdmin(WireAdmin wireAdmin) {
		synchronized(wireParametersToBeHandled){
			logger.debug(bundleMarker, "wireAdmin set");
			this.wireAdmin = wireAdmin;
			for (WireParameters wireParameters : wireParametersToBeHandled) {
				handleWire( wireParameters);
			}
			wireParametersToBeHandled.clear();
		}
		
	}

	public void unsetWireAdmin(WireAdmin wireAdmin) {
		this.wireAdmin = wireAdmin;
	}


	private void deleteAllWires(String producerPid) {
		handleWire(new WireParameters(producerPid, null, null));
	}

}
