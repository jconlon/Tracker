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
	protected final Map<String, Envelope> envelopes = new HashMap<String, Envelope>();
	protected Long id = null;
	/**
	 * The State that ends a transaction.  If null
	 * any State with a value of one will end a 
	 * transaction.
	 */
	protected State state;

	
	/**
	 * 
	 * @param log to send logging events
	 * @param state that ends a transaction, if null any state with a value of one 
	 * ends the transaction.
	 */
	protected AbstractTransactionHandler(Logger log, State state) {
		super();
		if(log==null){
			throw new IllegalArgumentException("Can not construct with a null log");
		}
		this.log = log;
		this.state = state;
	}

	protected abstract Marker bundleMarker();
	
	/**
	 * @deprecated
	 * @return
	 */
	protected String getTriggeringScopeName(){
		return TRANSACTION_STATE_SCOPE;
	}
	
	/**
	 * @deprecated
	 * @return
	 */
	protected String getAnimalIDNumberScopeName(){
		return ANIMAL_TAG_NUMBER_SCOPE;
	}
	
	

	
	public void add(Envelope envelope){
		if(envelope.getValue() instanceof State){
			if(state==null){
				if( ((State)envelope.getValue()).getValue()==1){
					 triggered();
					 envelopes.clear();
					 id=null;
				 }
			}else if(state.equals(envelope.getValue())){
				triggered();
				 envelopes.clear();
				 id=null;
			}
		}else if (envelope.getValue() instanceof Long){
			 id = (Long)envelope.getValue();

			 log.debug(bundleMarker(),"{} ID={}",
					 this,id);

		}else if (envelope.getValue() instanceof Measurement){
			envelopes.put(envelope.getScope(), envelope);
		}else{
			 log.error(bundleMarker(),"id='{}', type='{}' has unknown value of {}",
					 new Object[]{id,
				 envelope.getScope(),
				 envelope.getValue()});
		}
	}

	public Measurement get(String scope) {
		Measurement measurement = null;
		Envelope envelope = envelopes.get(scope);
		if(envelope!=null && envelope.getValue() instanceof Measurement){
			measurement = (Measurement) envelope.getValue();
		}
		return measurement;
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

   protected static final Comparator<Envelope> ENVELOPE_DATE_ORDER = new Comparator<Envelope>() {
		public int compare(Envelope e1, Envelope e2) { 
			Measurement m1 =(Measurement)e1.getValue();
			Measurement m2 =(Measurement)e2.getValue();
			if(m1.getTime() < m2.getTime()){
				return -1;//returning a negative integer, first argument is less than second
			}else if(m1.getTime() == m2.getTime()){
				return 0;//0, equal to, or 
			}
			return 1; //a positive integer depending on whether the ,  greater than the second.
		}
};
	

}
