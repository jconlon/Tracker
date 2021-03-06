package com.verticon.tracker.irouter.mettler;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.common.TrackerConstants.STABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.common.TrackerConstants.UNSTABLE_WEIGHT_ERROR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.microedition.io.StreamConnection;

import org.osgi.service.io.ConnectorService;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.IMeasurementSender;
import com.verticon.tracker.irouter.common.Utils;

/**
 * 
 * @author jconlon
 * 
 */
public class MeasurementProducerCallable implements Callable<Void> {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(MeasurementProducerCallable.class);

	private final IBalance balance;
	private final IMeasurementSender measurementSender;
	private final Matcher matcher;
	private final double stableWeightError;//.002
	private final double unStableWeightError;//.010
	private final String uri;
	private final String asciiCommand ;
	private final long delayI;
	private final String pid;

	/**
	 * Manages a connection to a balance. Continuously reads from a balance and
	 * outputs weight information.
	 * 
	 * @param balance
	 */
	public MeasurementProducerCallable(IBalance balance,
			IMeasurementSender measurementSender) {
		super();
		this.balance = balance;
		this.measurementSender = measurementSender;
		IContext context = balance.getContext();
		String responsePattern = context.getConfigurationString(RESPONSE_PATTERN);
		Pattern pattern = Pattern.compile(responsePattern);
		matcher = pattern.matcher("");
		stableWeightError= context.getConfigurationDouble(STABLE_WEIGHT_ERROR);
		unStableWeightError= context.getConfigurationDouble(UNSTABLE_WEIGHT_ERROR);
		uri = context.getConfigurationString(CONNECTION_URI);
	    asciiCommand = context.getConfigurationString(REQUEST_COMMAND);
	    delayI = context.getConfigurationLong(POLL_DELAY).longValue();
	    pid = context.getPid();
	}

	@Override
	public String toString() {
		return "MeasurementProducerCallable [uri=" + uri + ", pid="
				+ pid
				+ "]";
	}

	@Override
	public Void call() throws Exception {
		StreamConnection connection = null;
		Writer out = null;
		BufferedReader in = null;
		
		// There is a fixed 5 second timeout on socket if it blocking
		// waiting on a read. (there is no traffic)
		try {
			try {
				
				log.debug(this + ": Opening connection");
				ConnectorService cs = balance.getConnectorService();

				connection = (StreamConnection) cs.open(uri,
						ConnectorService.READ_WRITE, true);

				out = new BufferedWriter(new OutputStreamWriter(connection
						.openOutputStream()));
				in = new BufferedReader(new InputStreamReader(connection
						.openInputStream()));
			} catch (NoRouteToHostException e){
				log.warn("{} :No Route to Host {} ", this, uri);
				throw e;
			} catch (UnknownHostException e) {
				log.warn("{} :Unknown Host {}", this, uri);
				throw e;
			} catch (ConnectException e) {
				log.warn("{} :Couldn't connect to: {} because {}", new Object[]{this, uri, e.getMessage()});
				throw e;
			} catch (IOException e) {
				log.warn("{} :Couldn't io exception connecting to: {} because {}", new Object[]{this, uri, e.getMessage()});
				throw e;
			}

			

			String command = null;
			if (asciiCommand != null) {
				command = Utils.fromAscii(asciiCommand);
			}
			

			balance.registerProducer();
			// Main command response loop

			// try {
			while (!Thread.currentThread().isInterrupted()) {
				if (command != null && command.length() > 0) {
					log.debug("{} Polling for weight with command={}"
								,this, Utils.toAscii(command));
					
					out.write(command);
					out.flush();
				}
				try {
					process(in.readLine());
					if (delayI > 0) {
						// if(log.isDebugEnabled()){
						// log.debug(this+": Sleeping "+delayI+
						// " milliseconds");
						// }
						TimeUnit.MILLISECONDS.sleep(delayI);
					}
				} catch (SocketTimeoutException e) {
					log.debug("{}: Timeout waiting for response to command.",this);
					
					// normal

					// Typical reads will block waiting data, unless the
					// timeout
					// flag is set on the socket. Without this flag set If
					// there
					// is no
					// data to read the read will block awaiting data.
					// If this callable is then canceled through a thread
					// interruption
					// as is done by future.cancel(true) and
					// exec.shutdownNow().
					// the while condition will not be hit, and the thread
					// will
					// hangup
					// the shutdown or the future cancel. So we set the
					// timeout
					// on the
					// socket to timeout on reads allowing the testing of
					// the
					// condition
					// at the top of the loop. This way the interrupt
					// condition
					// is detected
					// in a timely fashion.
				}
			}
		} catch (InterruptedException e) {
			// // Allow thread to exit
			 log.debug("{}:Interrupted.....",this);
			 
		} finally {
			log.debug(this + ":Terminating.....");
			balance.unregisterProducer();
			if (Thread.currentThread().isInterrupted()) {
				log.debug("{}:Task was cancelled",this);
			}
			if (out != null) {
				log.debug("{}:Closing out",this);
				out.close();
			}
			if (in != null) {
				log.debug("{}:Closing in",this);
				in.close();
			}
			if (connection != null) {
				log.debug("{}:Closing connection",this);
				connection.close();
			}
			log.debug("{}:Terminated",this);
		}

		return null;
	}

	private void process(String response) throws InterruptedException {
		
		log.debug("{}: handling response={}",this, Utils.toAscii(response));
		
		Measurement measurement = createWeight(response);
		if (measurement != null) {
			log.debug("{}: sending {}", this,measurement);
			
			measurementSender.send(measurement);
		}
	}

	Measurement createWeight(String response) {
		Double polledWeight = parseBalanceWeight(response);
		
		if (polledWeight == null) {
			return null;
		}
		String stableWeight = matcher.group(1);
		Measurement measurement;
		if (stableWeight.equals("D")) {
			measurement = new Measurement(polledWeight.doubleValue() / 1000,
					unStableWeightError, Unit.kg, System.currentTimeMillis());
		} else {
			measurement = new Measurement(polledWeight.doubleValue() / 1000,
					stableWeightError, Unit.kg, System.currentTimeMillis());
		}
		return measurement;
	}

	Double parseBalanceWeight(String response) {
		Double result = null;
		matcher.reset(response.trim());
		if (matcher.matches()) {
			String s = matcher.group(4);
			try {
				result = new Double(Double.parseDouble(s));
			} catch (NumberFormatException e) {
				// ignore
			}
		}

		return result;
	}

}
