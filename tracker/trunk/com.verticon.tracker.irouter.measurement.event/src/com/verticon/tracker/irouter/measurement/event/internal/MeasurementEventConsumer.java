/**
 * 
 */
package com.verticon.tracker.irouter.measurement.event.internal;

import static com.verticon.tracker.common.EventAdminConstant.EVENT_ADMIN_TOPIC;
import static com.verticon.tracker.common.EventAdminConstant.IROUTER_PAYLOAD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.verticon.tracker.common.MeasurementTransaction;
import com.verticon.tracker.irouter.common.AbstractTransactionHandler;


/**
 * Measurement to Tracker Event Gateway that caches measurements and animal ids 
 * transforming them into MeasurementTransactinos and sending these to the
 * EventAdmin service to be converted on the receiving end into Tracker Events.
 * 
 * @author jconlon
 *
 */
public class MeasurementEventConsumer  extends AbstractTransactionHandler implements Consumer, Monitorable{
	private static final String WIRES_COUNT = "consumer.Connected_Wires";
    private static final String LAST_MEASUREMENT_SENT ="consumer.Last_Measurement_Sent";
    private static final String TOTAL_MEASUREMENTS_SENT ="consumer.Total_Measurements_Sent";
    private static final String CONTROL_STATE_NAME ="consumer.transaction.state";
	private static final String CONTROL_STATE_VALUE = "consumer.transaction.state.value";
	
    private final AtomicInteger wiresConnected = new AtomicInteger(0);
    private final AtomicInteger totalMeasurements = new AtomicInteger(0);
    private MeasurementTransaction measurementTransaction = null;
	private Map<String,Object> config = null;
	private EventAdmin eventAdmin = null;
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.event";
	public static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static { 
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	
	public MeasurementEventConsumer() {
		super(LoggerFactory.getLogger(MeasurementEventConsumer.class),null);
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementEventConsumer [config=" + config + "]";
	}



	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config contains properties for this instance.
	 */
    void activate(Map<String,Object> config){
    	this.config=config;
		log.debug(bundleMarker,"Activating...");
		for (Map.Entry<String, Object> entry : config.entrySet()) {
			log.debug(bundleMarker, "Property key={} value={}",entry.getKey(),entry.getValue());
		}
		this.state = new State(
				getConfigInteger(CONTROL_STATE_VALUE),
				getConfigString(CONTROL_STATE_NAME));
		
	}
    
    private String getConfigString(String key){
    	return (String)config.get(key);
    }
    
    private Integer getConfigInteger(String key){
    	return (Integer)config.get(key);
    }
    
    /**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config contains properties for this instance.
	 */
    void deactivate(){
    	this.config.clear();
		log.debug(bundleMarker,"deactivating...");
	}

    /**
     * Declaratives Services service injection point
     *
     * @param eventAdmin
     */
    void setEventAdmin(EventAdmin eventAdminService) {
		this.eventAdmin = eventAdminService;
	}
    
    /**
     * Declaratives Services service injection point
     * .
     * @param eventAdmin
     */
    void unsetEventAdmin(EventAdmin eventAdminService) {
		this.eventAdmin = null;
	}

	@Override
	public void updated(Wire wire, Object in) {
		log.debug(bundleMarker,"Invoked updated with value={}",in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			add(envelope);
		} else {
			log.error(bundleMarker, 
			"Unknown object={} was received from wire scope={}",in, 
			Arrays.toString(wire.getScope()));
		}
	}


	@Override
	public void producersConnected(Wire[] wires) {
		log.debug(bundleMarker,"Invoked producerConnected with wires={}",
				Arrays.toString(wires));
		wiresConnected.set(wires.length);
	}


	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}


	@Override
	protected void triggered() {
		if(id==null){
			log.error(bundleMarker, "ID is null, abort generating output");
			return;
		}
		List<Measurement> m = new ArrayList<Measurement>(measurements.values());
		Collections.sort(m, DATE_ORDER);
		for (Measurement measurement : m) {
			String wireAdminEnvelopeScope = null;
			//Find the scope associated with the entry
			for (Map.Entry<String, Measurement> entry : measurements.entrySet()) {
				if(measurement.equals(entry.getValue())){
					wireAdminEnvelopeScope=entry.getKey();
				}
			}
			output(wireAdminEnvelopeScope, measurement, id);
		}
	}
	
	/**
	 * Output the measurement as a MeasurementTransaction to the eventAdmin
	 * topic that is common to the iRouter and the Tracker
	 * 
	 * @param scope
	 * @param measurement
	 * @param id
	 */
	private void output(String scope, Measurement measurement, Long id){
		measurementTransaction = 
			MeasurementTransaction.newInstance(measurement, scope, id);
		
		Map<String, Object> table = new HashMap<String, Object>();
		table.put(IROUTER_PAYLOAD.toProp(),
				measurementTransaction);
		table.put(Constants.BUNDLE_SYMBOLICNAME, 
				FrameworkUtil.getBundle(this.getClass()).getSymbolicName());
		
		if(eventAdmin != null) {
			eventAdmin.postEvent(
					new Event(
							EVENT_ADMIN_TOPIC.toProp(), table));
			int i = totalMeasurements.incrementAndGet();
			log.info(bundleMarker, "{} sent {} #{} to the event service",
					new Object[] {this, measurementTransaction,i});
		}else{
			log.warn(bundleMarker,"{} failed to find EventAdmin service",this);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{WIRES_COUNT, LAST_MEASUREMENT_SENT, TOTAL_MEASUREMENTS_SENT};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
		    );
		}else if (LAST_MEASUREMENT_SENT.equals(name)){
				return
				new StatusVariable(name,
						StatusVariable.CM_DER,
						measurementTransaction!=null?measurementTransaction.toString():""
				);
		}else if (TOTAL_MEASUREMENTS_SENT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_CC,
					totalMeasurements.get()
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
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {

		if (TOTAL_MEASUREMENTS_SENT.equals(name)){
			totalMeasurements.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {	
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected wires.";
		}else if (LAST_MEASUREMENT_SENT.equals(name)){
			return "The last measurement sent to the Tracker transaction editor.";
		}else if (TOTAL_MEASUREMENTS_SENT.equals(name)){
			return "The total numver of measurements sent to the Tracker transaction editor.";
		}
		return null;
	}
	
}
