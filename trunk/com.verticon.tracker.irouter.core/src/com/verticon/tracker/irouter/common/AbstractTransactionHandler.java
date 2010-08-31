package com.verticon.tracker.irouter.common;

import static com.verticon.tracker.irouter.common.TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRANSACTION_STATE_SCOPE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.Marker;


public abstract class AbstractTransactionHandler implements ITransactionHandler {

	/**
	 * slf4j Logger
	 */
	protected final Logger log;
	protected final Map<String, Measurement> measurements = new HashMap<String, Measurement>();
	protected Long id = null;

	protected abstract Marker bundleMarker();
	
	protected AbstractTransactionHandler(Logger log) {
		super();
		if(log==null){
			throw new IllegalArgumentException("Can not construct with a null log");
		}
		this.log = log;
	}

	public void add(Envelope envelope) {
		 if(envelope.getScope().equals(TRANSACTION_STATE_SCOPE)){
			 if(((State)envelope.getValue()).getValue()==1){
				 triggered();
				 measurements.clear();
				 id=null;
			 }
		 }else if(envelope.getScope().equals(ANIMAL_TAG_NUMBER_SCOPE)){
			 if(envelope.getValue() instanceof Long){
				 id = (Long)envelope.getValue();

				 log.debug(bundleMarker(),"{} ID={}",
						 this,id);

			 }else{
				 log.error(bundleMarker(),"EID Envelope unknown value={}",envelope.getValue());
			 }
		 }else{
			 if(envelope.getValue() instanceof Measurement){
				 measurements.put(envelope.getScope(), (Measurement) envelope.getValue());
			 }else{
				 log.error(bundleMarker(),"id='{}', type='{}' has unknown value of {}",
						 new Object[]{id,
					 envelope.getScope(),
					 envelope.getValue()});
			 }
		 }
	}

	public Measurement get(String scope) {
		return measurements.get(scope);
	}

	protected abstract void triggered();
	
	protected static final Comparator<Measurement> DATE_ORDER = new Comparator<Measurement>() {
			public int compare(Measurement e1, Measurement e2) { 
				if(e1.getTime() < e2.getTime()){
					return -1;//returning a negative integer, first argument is less than second
				}else if(e1.getTime() == e2.getTime()){
					return 0;//0, equal to, or 
				}
				return 1; //a positive integer depending on whether the ,  greater than the second.
			}
   };

	

}
