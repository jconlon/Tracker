package com.verticon.tracker.irouter.wireadmin.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.wireadmin.internal.Component.bundleMarker;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_SCOPE;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_SCOPE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates one wire between each Producer and Consumer that have intersecting
 * scoped elements.
 * 
 * @author jconlon
 *
 */
public class GroupConnector {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(GroupConnector.class);


	private final String group;
	private final IWireCreator wireCreator;
	
	private final Set<WireParameters> registeredWireParameters = new HashSet<WireParameters>();
	/*
	 * maps of producers and consumers indexed by PID
	 */
	private final Map<String,Map<String, ?>> producers = new ConcurrentHashMap<String, Map<String, ?>>();
	private final Map<String,Map<String, ?>> consumers = new ConcurrentHashMap<String, Map<String, ?>>();
	
	
	public GroupConnector(String group,IWireCreator wireCreator) {
		super();
		this.group = group;
		this.wireCreator = wireCreator;
	}



	@Override
	public String toString() {
		return "GroupConnector [group=" + group + "]";
	}
	
	

	/**
	 * A producer may have an array of WireConstants.WIREADMIN_PRODUCER_SCOPE which
	 * may contain: 
	 * <ul>
	 * <li>
	 * a single value like the Balance Producer {"mettler.weight.measurement"}
	 * </li>
	 * <li>
	 * multiple values like a TruTest CompositeProducer {"animal.weight.measurement", "transaction.state", "animal.tag.number"} 
	 * </li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param producer
	 * @param properties
	 */
	 void setProducer(Map<String, ?> properties){
		String producerPid = (String)properties.get(SERVICE_PID);
    	if(!isProducerRegistered(producerPid)){
    		producers.put(producerPid, properties);
    		logger.debug(bundleMarker,"{}: Added producer producerPid={}", 
								this, producerPid);
    		
    	}
		String[] producerScope = (String[]) properties.get(WIREADMIN_PRODUCER_SCOPE);
		//Find a Consumer that intersects with this scope
    	for (Map.Entry<String,Map<String, ?>> consumerEntry : consumers.entrySet()) {
    		//Does a wire already connect to this consumer
    		String consumerPid = 
    			(String) consumerEntry.getValue().get(SERVICE_PID);
    		
    		String[] wireScope = scopeIntersection(producerScope, 
    				(String[]) consumerEntry.getValue().get(WIREADMIN_CONSUMER_SCOPE));
    		
    		WireParameters wireParameters = new WireParameters(producerPid, consumerPid, group);
    		if(wireScope.length==0){
    			if(registeredWireParameters.contains(wireParameters)){
    				wireParameters.setDelete(true);
        		}else{
        			continue;
        		}
    		}
    		logger.debug(bundleMarker,
    			"{}: Handling wireParameters for Producer producerPid={}, consumerPid={}, calculatedScope={}", 
								new Object[]{this, 
								producerPid,
								consumerPid, 
								Arrays.toString(wireScope)});
    		
    		
    		
    		if(wireCreator.handleWire(wireParameters)){
    			registeredWireParameters.add(wireParameters);
    		}
    	}
	}



	boolean isProducerRegistered(String producerPid) {
		return producers.containsKey(producerPid);
	}
	

	/**
	 * A consumer may have an array of WireConstants.WIREADMIN_CONSUMER_SCOPE which
	 * may contain a single value like the Abbott CommandConsumer {"trutest.command.string"}
	 * or it may contain multiple like Abbott CompositeConsumer 
	 * {"animal.weight.measurement", "transaction.state", "animal.tag.number", "mettler.weight.measurement"}.
	 *
	 * 
	 * @param consumer
	 * @param properties
	 */
     void setConsumer(Map<String, ?> properties){
    	String consumerPid = (String)properties.get(SERVICE_PID);
    	if(!consumers.containsKey(consumerPid)){
    		consumers.put(consumerPid, properties);
    		logger.debug(bundleMarker,
    			"{}: Added consumer consumerPid={}", 
								this, consumerPid);
    		
    	}
    	String[] consumerScope = (String[]) properties.get(WIREADMIN_CONSUMER_SCOPE);
    	//Find a Producer that intersects with this scope
    	for (Map.Entry<String,Map<String, ?>> producerEntry : producers.entrySet()) {
    		//Does a wire already connect to this producer
    		String producerPid = 
    			(String) producerEntry.getValue().get(SERVICE_PID);
    		WireParameters wireParameters = new WireParameters(producerPid, consumerPid, group);
    		
    		
    		String[] wireScope = scopeIntersection(consumerScope, 
    				(String[]) producerEntry.getValue().get(WIREADMIN_PRODUCER_SCOPE));
    		
    		if(wireScope.length==0){
    			if(registeredWireParameters.contains(wireParameters)){
    				wireParameters.setDelete(true);
        		}else{
        			continue;
        		}
    		}
    		
    		logger.debug(bundleMarker,"{}: Handling wireParameters for Consumer producerPid={}, consumerPid={}, calculatedScope={}", 
								new Object[]{this, 
								producerPid,
								consumerPid, 
								Arrays.toString(wireScope)});
    		
    		
    		
    		if(wireCreator.handleWire(wireParameters)){
    			registeredWireParameters.add(wireParameters);
    		}
    		
    	}
    	
	}

    
	 String getGroup() {
		return group;
	}
	
	static String[] scopeIntersection(String[] array1, String[] array2){
		Set<String> one = new HashSet<String>(Arrays.asList(array1));
		Set<String> two = new HashSet<String>(Arrays.asList(array2));
		one.retainAll(two);
		return (String[]) one.toArray(new String[0]);
	}
	
}
