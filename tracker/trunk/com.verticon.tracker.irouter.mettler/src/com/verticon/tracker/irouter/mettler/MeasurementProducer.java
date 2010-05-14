package com.verticon.tracker.irouter.mettler;

import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.WEIGHT_MEASUREMENT_SCOPE;
import static com.verticon.tracker.irouter.mettler.Context.*;
import static com.verticon.tracker.irouter.mettler.FactoryComponent.bundleMarker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.IMeasurementSender;


public class MeasurementProducer implements Producer, IMeasurementSender{

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(MeasurementProducer.class);

	private final IContext context;
	
	//Shared wires protected with concurrent collection
	private List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	//Shared envelope protected with volatile
	private volatile Envelope envelope = null;
	
	private final String scopeName;
	
	private ServiceRegistration wireAdminReg = null;
	
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
	}
}
