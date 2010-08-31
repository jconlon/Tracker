package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.measurement.logger.internal.ComponentFactory.bundleMarker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractTransactionHandler;

/**
 * 
 * When triggered by the base class (on reception of a 'transaction.state') 
 * the AggregatedTransactionLogger will log all collected measurements as 
 * separate log entries in date time order, tagging each with the id element.
 * 
 * Output Format is comma delimited:
 * type='measurement',dateTime='%1$tF %1$tT',id='%2$s',scope='%3$s',value='%4$.4f',error='%5$.4f',unit='%6$s'"
 * 
 * @author jconlon
 *
 */
public class AggregatedTransactionLogger extends AbstractTransactionHandler {
	
	/**
	 * Multiple lines of measurement log entries, each looking like this.
	 */
	private static final String OUTPUT_FORMAT = 
	"type='measurement'," +
	"dateTime='%1$tF %1$tT'," +
	"id='%2$s',scope='%3$s'," +
	"value='%4$.4f'," +
	"error='%5$.4f'," +
	"unit='%6$s'";


	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}


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
			String wireAdminEnvelopeScope = null;
			for (Map.Entry<String, Measurement> entry : measurements.entrySet()) {
				if(measurement.equals(entry.getValue())){
					wireAdminEnvelopeScope=entry.getKey();
				}
			}
			//2009-12-14 12:32:34
			log.info(bundleMarker,
					String.format(
							OUTPUT_FORMAT,
							measurement.getTime(),
							id,
							wireAdminEnvelopeScope,
							measurement.getValue(),
							measurement.getError(),
							measurement.getUnit()
					)
			);
			}
	}
	

}
