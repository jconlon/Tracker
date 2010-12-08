package com.verticon.tracker.irouter.measurement.logger.internal;

import static com.verticon.tracker.irouter.measurement.logger.internal.MeasurementLoggerConsumer.bundleMarker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
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
public class AggregatedTransactionLogger extends AbstractTransactionHandler implements ILogger{
	
	private String lastLogEntry = null;
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

	private final AtomicInteger transactionsLogged = new AtomicInteger(0);


	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}


	public AggregatedTransactionLogger(Logger log, State state) {
		super(log, state);
		
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
		List<Envelope> results = new ArrayList<Envelope>(envelopes.values());
		Collections.sort(results, ENVELOPE_DATE_ORDER);
	    StringBuilder builder = new StringBuilder();
	    String logEntry;
		for (Envelope envelope : results) {
			
			if(builder.length()>1){
				builder.append(';');
			}

			Measurement measurement = (Measurement)envelope.getValue();
			logEntry = String.format(
					OUTPUT_FORMAT,
					measurement.getTime(),
					id,
					envelope.getScope(),
					measurement.getValue(),
					measurement.getError(),
					measurement.getUnit()
			);
			//2009-12-14 12:32:34
			log.info(bundleMarker,logEntry);
			builder.append(logEntry);
		}
		lastLogEntry=builder.toString();
		transactionsLogged.incrementAndGet();
	}


	@Override
	public String getLastLogEntry() {
		return lastLogEntry;
	}

	@Override
	public String getLastLogEntryDescription() {
		return "Concatination of last set of log entries. Entries separated with semicolons.";
	}
	
	@Override
	public int transactionsLogged() {
		return transactionsLogged.get();
	}


	@Override
	public Long getCurrentEID() {
		return id!=null?id:0;
	}


	@Override
	public int getMeasurementsSize() {
		return envelopes.size();
	}
}
