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
package com.verticon.tracker.irouter.mettler;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.WEIGHT_MEASUREMENT_SCOPE;
import static com.verticon.tracker.irouter.mettler.Context.PRODUCER_WEIGHT_MEASUREMENT_NAME;
import static com.verticon.tracker.irouter.mettler.FactoryComponent.bundleMarker;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_SCOPE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.IMeasurementSender;


public class MeasurementProducer implements Producer, IMeasurementSender, Monitorable{

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(MeasurementProducer.class);

	private static final String COMMAND_LAST = "producer.Last_Weight_Sent";
	private static final String WIRES_COUNT = "producer.Connected_Consumers";
	
	private final IContext context;
	
	//Shared wires protected with concurrent collection
	private List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	//Shared envelope protected with volatile
	private volatile Envelope envelope = null;
	
	private final String scopeName;
	
	private ServiceRegistration wireAdminReg = null;
	private ServiceRegistration monitorableReg = null;
	
	
	private Float lastWeight = new Float(0);
	
	public MeasurementProducer(IContext context) {
		super();
		this.context = context;
		scopeName = 
			context.getConfigurationString(PRODUCER_WEIGHT_MEASUREMENT_NAME)+
			'.'+WEIGHT_MEASUREMENT_SCOPE;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BalanceMeasurementProducer [pid="+context.getPid()+", uri=" + context.getConfigurationString(CONNECTION_URI) + "]";
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
			log.debug(bundleMarker,"{}: Not connected to any wires.",
					this
			);
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
					return envelope;
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.IMeasurementSender#send(org.osgi.util.measurement.Measurement)
	 */
	@Override
	public void send(Measurement measurement) {
		lastWeight = new Float(measurement.getValue());
		this.envelope = new BasicEnvelope(measurement,context.getPid(),scopeName);
		if(!wires.isEmpty()){
			log.debug(bundleMarker,"{}: sending measuement={}, to {} wires",
					new Object[]{this,wires.size(), measurement}
				);
			
			//Send to all wires
			for (Wire wire : wires) {
				wire.update(envelope);
//				log.debug(String.format("%s: Sent %s to %s",
//						this,measurement,wire));
			}
		}else{
			log.warn(bundleMarker,"{}: No wires found. Aborted sending measuement={}",
					this,measurement);
		}
	}
	
	/**
	 * Called by the Balance to unregister the service.
	 */
	void unRegister(){
		if(wireAdminReg != null){
			log.debug(bundleMarker,this + ":Unregistering.....");
			 wireAdminReg.unregister();
			 wireAdminReg=null;
		 }
		if(monitorableReg != null){
			log.debug(bundleMarker,this + ":Unregistering monitorable.....");
			monitorableReg.unregister();
			monitorableReg=null;
		 }
		log.debug(bundleMarker,this + ":Unregistered");
	}
	
	/**
	 * Called by the context to register this service.
	 * @param bc
	 */
    void register(BundleContext bc){
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, context.getPid());
		regProps.put(WIREADMIN_PRODUCER_SCOPE, 
				new String[]{scopeName});
		regProps.put(WIREADMIN_PRODUCER_FLAVORS,
				new Class[] { Envelope.class });
		regProps.put(CONNECTION_URI, context.getConfigurationString(CONNECTION_URI));
		regProps.put(TRACKER_WIRE_GROUP_NAME, 
				context.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		wireAdminReg = bc.registerService(Producer.class
				.getName(), this, regProps);
		monitorableReg = bc.registerService(Monitorable.class.getName(), this, regProps);
	}

    @Override
	public String[] getStatusVariableNames() {
		return new String[]{COMMAND_LAST,WIRES_COUNT};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		if (COMMAND_LAST.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_SI,
					lastWeight
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
		if (COMMAND_LAST.equals(name)){
			return
			"The last command sent to the TruTest scalehead";
		}
		
		
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected wires.";
		}
		return null;
	}
}
