/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.trutest.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.NODE_LABEL;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_EID;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_WEIGHT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ENTER_KEY;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_SCOPE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IEnvelopeSender;

/**
 * 
 * A WireAdmin Producer that produces Envelopes Animal Weight Measurements, a EID States
 * and a Record States coming from a TruTest indicator.
 * @author jconlon
 */
public class EnvelopeProducer implements Producer, IEnvelopeSender, Monitorable {

	private static final String LAST_WEIGHT = "producer.Last_Weight_Sent";
	private static final String LAST_EID = "producer.Last_EID_Sent";
	private static final String WIRES_COUNT = "producer.Connected_Consumers";
	
	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(EnvelopeProducer.class);


	private final IIndicator indicator;
	
	//Shared instances accessed by multiple threads protected with a concurrent collection
	private final List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	private final Map<String, Envelope> lastEnvelope = new ConcurrentHashMap<String, Envelope>();
	private ServiceRegistration<?> wireAdminReg = null;

	public EnvelopeProducer(IIndicator indicator) {
		super();
		this.indicator = indicator;;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnvelopeProducer [pid="+indicator.getPid()+", uri=" + indicator.getConfigurationString(CONNECTION_URI) + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Producer#consumersConnected(org.osgi.service.wireadmin.Wire[])
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires.clear();
		if(wires!=null){
			this.wires.addAll(Arrays.asList(wires));
		}
		if(this.wires.isEmpty()){
			
			log.debug(bundleMarker,"{}: Not connected to any wires.", this);
		}else{
			HashSet<String> consumers = new HashSet<String>();
			for (Wire wire : wires) {
				consumers.add((String)wire.getProperties().get(WIREADMIN_CONSUMER_PID));
			}
			
			log.debug(bundleMarker,"{}: Connected to {} wires, and {} consumers={}",
						new Object[]{this, wires.length, consumers.size() ,consumers}
			);
			
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Producer#polled(org.osgi.service.wireadmin.Wire)
	 */
	@Override
	public Object polled(Wire wire) {
		String scopes[] = wire.getScope();
        Object result = null;
		for (String scope : scopes) {
			result = lastEnvelope.get(scope);
			if(result!=null){
				break;
			}

		}
		return result;
	}			

	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.trutest.internal.IEnvelopeSender#send(org.osgi.service.wireadmin.Envelope)
	 */
	public void send(Envelope envelope) {
		boolean sent = false;
		
		log.debug(bundleMarker,"{}: Sending {} with scope={} to {} wires.",
					new Object[]{this, envelope.getValue(), envelope.getScope(), wires.size()}
		);
		
		for (Wire wire : wires) {
			String wireScopes[] =  wire.getScope();
			if(wireScopes.length==0){
				log.debug(bundleMarker,"{}: Defered sending {} wire has no scopes",
							this, envelope);
			}
			for (String wireScope : wireScopes) {
				if (wireScope.equals(envelope.getScope())) {
					wire.update(envelope);
					sent=true;
					break;
				}
			}  
		}
		
		if(sent){
			lastEnvelope.put(envelope.getScope(), envelope);
		}
		
	}
	
	/**
	 * Called by the Balance to unregister the service.
	 */
	void unRegister(){
		if(wireAdminReg != null){
			wireAdminReg.unregister();
			wireAdminReg=null;
		}
	}

	/**
	 * Called by the balance to register this service.
	 * @param bc
	 */
	void register(BundleContext bc){
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, indicator.getPid());
		regProps.put(WIREADMIN_PRODUCER_SCOPE, 
				buildProducerScope());
		regProps.put(WIREADMIN_PRODUCER_FLAVORS,
				new Class[] { Envelope.class });
		regProps.put(CONNECTION_URI, indicator.getConfigurationString(CONNECTION_URI));
		regProps.put(TRACKER_WIRE_GROUP_NAME, 
				indicator.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		regProps.put(NODE_LABEL, indicator.getConfigurationString(NODE_LABEL));
		wireAdminReg = bc.registerService(Producer.class
				.getName(), this, regProps);
	}
	
	private String[] buildProducerScope(){
		if(indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID)==null){
			return new String[]{
					indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_WEIGHT),
					indicator.getConfigurationString(PRODUCER_SCOPE_ENTER_KEY)};
		}
		return new String[]{
				indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_WEIGHT),
				indicator.getConfigurationString(PRODUCER_SCOPE_ENTER_KEY),
				indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID)};
	}

    @Override
	public String[] getStatusVariableNames() {
		return new String[]{LAST_WEIGHT,LAST_EID,WIRES_COUNT };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		if (LAST_WEIGHT.equals(name)){
			Envelope ev = lastEnvelope.get(indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_WEIGHT));
			Measurement m = ev!=null?(Measurement)ev.getValue():null;
			return
			new StatusVariable(name,
					StatusVariable.CM_SI,
					m!=null?new Float(m.getValue()):new Float(0)
					);
		}
		if (LAST_EID.equals(name)){
			if(indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID)==null){
				return
				new StatusVariable(name,
						StatusVariable.CM_SI,
						""
						);	
			}
			Envelope ev = lastEnvelope.get(indicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID));
			String lastEID = ev!=null?ev.getValue().toString():""; 
			return
			new StatusVariable(name,
					StatusVariable.CM_SI,
					lastEID
					);
		}
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wires.size()
					);
		}else{
			throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
		}
	}
	
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (LAST_WEIGHT.equals(name)){
			return
			"The last weight sent to the scalehead";
		}
		
		if (LAST_EID.equals(name)){
			return
			"The last electronic tag number sent to the scalehead";
		}
		
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected wires.";
		}
		
		return null;
	}
}
