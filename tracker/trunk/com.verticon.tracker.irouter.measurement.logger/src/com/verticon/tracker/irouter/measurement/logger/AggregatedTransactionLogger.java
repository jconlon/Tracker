package com.verticon.tracker.irouter.measurement.logger;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * 
 * 
 * @author jconlon
 *
 */
public class AggregatedTransactionLogger extends AbstractTransactionHandler {
	
	
	public AggregatedTransactionLogger(Logger log) {
		super(log);
	}


	@Override
	public String toString() {
		return "AggregatedTransactionLogger []";
	}


	/**
	 * Default behavior is to log all the events in a date time order.  Subclasses 
	 * can override.
	 */
	protected void triggered() {
		List<Measurement> m = new ArrayList<Measurement>(measurements.values());
		Collections.sort(m, DATE_ORDER);
	
		for (Measurement measurement : m) {
			String key = null;
			for (Map.Entry<String, Measurement> entry : measurements.entrySet()) {
				if(measurement.equals(entry.getValue())){
					key=entry.getKey();
				}
			}
			//2009-12-14 12:32:34
			log.info(String.format("Aggregated Transaction: dateTime='%1$tF %1$tT', id='%2$s', type='%3$s', value='%4$.4f'",
					measurement.getTime(),
					id,
					key,
					measurement.getValue()));
			}
	}
	

}
