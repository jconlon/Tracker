package com.verticon.tracker.irouter.measurement.converter.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * MeasurementConverter is a WireAdmin Arithmetic Measurement converter.
 * 
 * @author jconlon
 *
 */
public class MeasurementConverter implements Consumer, Producer, Monitorable {

	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
    private static final String LAST_MEASUREMENT_SENT ="producer.Last_Measurement_Sent";
    private static final String TOTAL_MEASUREMENTS_SENT ="producer.Total_Measurements_Sent";
    private static final String OPERAND = "operation.value";
    private static final String OPERATION= "operation.type";
    private static enum Operation{ADD,SUBTRACT,DIVIDE,MULTIPLY};
	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.measurement.converter";
	public static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);
	static { 
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(MeasurementConverter.class);
	private Wire[] wires = null; 
	private Map<String,Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalMeasurements = new AtomicInteger(0);
	private volatile Measurement lastMeasurement = null;

	   
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeasurementConverter [pid=" + getPid() + "]";
	}
	
	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config contains properties for this instance.
	 */
    void activate(Map<String,Object> config){
    	this.config=config;
    	logger.debug(bundleMarker, "{} activating properties={}",
				this, config);
			logger.debug(bundleMarker,"Activating {}",this);		
	}
    
	
     private Operation getOperation(){
    	String op = (String) config.get(OPERATION);
    	if(op ==null){
			throw new IllegalArgumentException( OPERATION+" parameter is not set.");
		}
    	return Operation.valueOf(op.toUpperCase());
    }
    
     private double getOperand(){
    	Object op = config.get(OPERAND);
    	if(op ==null){
			throw new IllegalArgumentException( OPERAND+" parameter is not set.");
		}
    	return getDouble(op);
    }
    
    private Double getDouble(Object value) {
		if(value instanceof String){
			return new Double((String)value);
		}
		return (Double)value;
	}
    
    /**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config contains properties for this instance.
	 */
    void deactivate(){
    	this.config.clear();
		logger.debug(bundleMarker,"{} deactivating",this);
	}

	
	@Override
	public synchronized Object polled(Wire wire) {
		return lastMeasurement;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} consumersConnected with wires={}", this,
				Arrays.toString(wires));
		this.wires = wires;
	}

	@Override
	public void updated(Wire wire, Object in) {
		logger.debug(bundleMarker,"Invoked updated with value={}",in);
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			if(envelope.getValue() instanceof Measurement){
				convert((Measurement)envelope.getValue());
			}else{
				logger.error(
						bundleMarker,
						"{} consumed unknown value={} from envelope outputScope={}",
						new Object[] { this, in,
								Arrays.toString(wire.getScope()) });
			}
		} else {
			logger.error(
					bundleMarker,
					"{} consumed unknown value={} from envelope outputScope={}",
					new Object[] { this, in,
							Arrays.toString(wire.getScope()) });
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} producersConnected with wires={}", this,
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	
	private synchronized void convert(Measurement in){
		lastMeasurement = null;
		switch (getOperation()) {
		case ADD:
			lastMeasurement = in.add(getOperand());
			produce(lastMeasurement);
			break;

		case DIVIDE:
			lastMeasurement = in.div(getOperand());
			produce(lastMeasurement);
			break;

		case MULTIPLY:
			lastMeasurement = in.mul(getOperand());
			produce(lastMeasurement);
			break;

		case SUBTRACT:
			lastMeasurement = in.sub(getOperand());
			produce(lastMeasurement);
			break;

		}
	}
	
	private void produce(Measurement measurement){
		Envelope envelope;
		
		for (Wire wire : wires) {
			 envelope = new BasicEnvelope(measurement, getPid(), getOutputScope());
			 wire.update(envelope);
			 totalMeasurements.incrementAndGet();
		 }
	}
	
	private String getPid(){
		return config!=null?(String)config.get("service.pid"):"null";
	}

	private String getOutputScope(){
		return ((String[])config.get("wireadmin.producer.scope"))[0];
	}
	
	
	@Override
	public String[] getStatusVariableNames() {
		return new String[]{CONNECTED_PRODUCERS_COUNT, 
				CONNECTED_CONSUMERS_COUNT, 
				LAST_MEASUREMENT_SENT, 
				TOTAL_MEASUREMENTS_SENT};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		
		if (CONNECTED_CONSUMERS_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wires.length
		    );
		}else if (CONNECTED_PRODUCERS_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					producersConnected.get()
		    );
		}else if (LAST_MEASUREMENT_SENT.equals(name)){
				return
				new StatusVariable(name,
						StatusVariable.CM_DER,
						lastMeasurement!=null?lastMeasurement.toString():""
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
		if (CONNECTED_CONSUMERS_COUNT.equals(name)){
			return
			"The number of connected consumer wires.";
		}else if (CONNECTED_PRODUCERS_COUNT.equals(name)){
			return
			"The number of producers connected to this converter.";
		}else if (LAST_MEASUREMENT_SENT.equals(name)){
			return "The last measurement sent to consumers.";
		}else if (TOTAL_MEASUREMENTS_SENT.equals(name)){
			return "The total numver of measurements sent to consumers.";
		}
		return null;
	}
}
