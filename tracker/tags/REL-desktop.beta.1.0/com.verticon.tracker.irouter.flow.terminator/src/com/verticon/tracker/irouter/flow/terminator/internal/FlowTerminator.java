package com.verticon.tracker.irouter.flow.terminator.internal;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * FlowTerminator is a Information flow control service, that terminates flow of
 * information based on a specific State received.
 * 
 * Reception of the specific state terminates output flow between input and output, while
 * reception of any other state resumes the flow.
 * 
 * Two or more scopes can be consumed, but all will be output together.
 * 
 * Only Enveloped objects will be passed through this service.
 * 
 * 
 * @author jconlon
 * 
 */
public class FlowTerminator implements Consumer, Producer, Monitorable {
	private static final String CONNECTED_PRODUCERS_COUNT = "consumer.Connected_Producers";
	private static final String CONNECTED_CONSUMERS_COUNT = "producer.Connected_Consumers";
	private static final String TIME_OF_LAST_TERMINATION = "producer.Last_Termination";
	private static final String TOTAL_TERMINATIONS = "producer.Total_Terminations";
	
	private static final String TERMINATOR_STATE_NAME = "terminator.state.name";
	private static final String TERMINATOR_STATE_VALUE = "terminator.state.value";
	private static final String TERMINATOR_SCOPE_MAP = "terminator.scope.map";

	private final static String PLUGIN_ID = "com.verticon.tracker.irouter.flow.terminator";
	public static final Marker bundleMarker = MarkerFactory
			.getMarker(PLUGIN_ID);
	static {
		bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(FlowTerminator.class);
	private Wire[] wires = new Wire[] {};
	private Map<String, Object> config = null;
	private final AtomicInteger producersConnected = new AtomicInteger(0);
	private final AtomicInteger totalTerminations = new AtomicInteger(0);
	private final AtomicBoolean forwarding = new AtomicBoolean(true);
	private volatile long lastTerminationTime = 0;

	private State terminatingState = null;
	private Map<String,String> scopeMap = new HashMap<String,String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlowTerminator [pid=" + getPid() + ", state="
				+ terminatingState + ", forwarding=" + forwarding + "]";
	}

	private String getPid() {
		return config != null ? (String) config.get("service.pid") : "null";
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> config) {
		this.config = config;
		logger.debug(bundleMarker, "{} activating properties={}", this, config);
		terminatingState = buildState();
		buildMap();
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		this.config.clear();
		logger.debug(bundleMarker, "deactivating {}", this);
		terminatingState = null;
	}

	@Override
	public synchronized Object polled(Wire wire) {
		return lastTerminationTime;
	}

	@Override
	public void consumersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} consumersConnected with wires={}", this,
				Arrays.toString(wires));
		this.wires = wires;
	}

	/**
	 * Inspect all in objects for the triggering State object, forwarding
	 * all objects if the State is not found.  Any received State
	 * object that is not the triggering State will turn forwarding back on.
	 */
	@Override
	public void updated(Wire wire, Object in) {
		if (in instanceof Envelope) {
			Envelope envelope = (Envelope) in;
			if (envelope.getValue() instanceof State) {
					processState((State) envelope.getValue());

			} else {
				Envelope out = reWrap(envelope);
				if(out!=null){
					forward(out);
				}
			}
		} else if (in instanceof State) {
			processState((State) in);

		} else {
			logger.warn(bundleMarker,
					"{} defered sending {} because it was not in an Envelope", this,
					in);
		}
	}

	@Override
	public void producersConnected(Wire[] wires) {
		logger.debug(bundleMarker, "{} producersConnected with wires={}", this,
				Arrays.toString(wires));
		producersConnected.set(wires!=null?wires.length:0);
	}

	private void processState(State state) {
		logger.debug(bundleMarker, "{} processing state={}", this, state);
		if (terminatingState.equals(state)) {
			forwarding.set(false);
			totalTerminations.incrementAndGet();
			lastTerminationTime = System.currentTimeMillis();
		} else {
			forwarding.set(true);
		}
	}

	private State buildState() {
		return new State(
				getConfigurationInteger(TERMINATOR_STATE_VALUE),
				(String) config.get(TERMINATOR_STATE_NAME));
	}
	
	private void buildMap() {
		scopeMap.clear();
		Object o = config.get( TERMINATOR_SCOPE_MAP);
		if(o == null || !o.getClass().isArray()){
			throw new IllegalStateException("Scope map is not an array.");
		}
		String[] conf = (String[])o;
		for (String entry : conf) {
			String[] token = entry.split(":");
			if(token == null || token.length!=2){
				logger.debug(bundleMarker, "{} entry={} could not be parsed.", this,
						entry);
				continue;
			}
			scopeMap.put(token[0], token[1]);
		}
	}
	
	private Integer getConfigurationInteger(String key) {
		Object conf = config.get( key);
		if(conf instanceof String){
			return new Integer((String)conf);
		}
		return (Integer)conf;
	}
	
	private Envelope reWrap(Envelope envelope){
		String outScope = findOutScope(envelope.getScope());
		return outScope!=null?
				new BasicEnvelope(envelope.getValue(),envelope.getIdentification(),outScope):null;
	}
	
	private String findOutScope(String inScope){
		String result = scopeMap.get(inScope);
		if(result==null){
			logger.warn(bundleMarker, "{} inScope={} could not be mapped.", this,
					inScope);
		}
		return result;
	}

	/**
	 * Forwarding policy is to send 
	 * <ol>
	 * <li>raw (non Envelope) in objects to all wires if 
	 * the forwarding flag is enabled.</li>
	 * <li>Envelope objects</li>
	 * </ol>
	 * @param in
	 */
	private void forward(Envelope in) {
		if (!forwarding.get()) {
			logger.debug(bundleMarker,
					"{}: flow ternminated. Will not forward {} to {} wires",
					new Object[] { this, in, wires!=null?wires.length:0 });
			return;
		}
		if (wires != null) {

			logger.debug(bundleMarker, "{}: forwarding {} to {} wires",
					new Object[] { this, in, wires.length });

			for (Wire wire : wires) {
				if(Arrays.asList(wire.getScope()).contains(in.getScope())){
					wire.update(in);
				}
			}

		} else {
			logger.warn(bundleMarker,
					"{} defered sending {} because there are no wires", this,
					in);
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[] { CONNECTED_PRODUCERS_COUNT,
				CONNECTED_CONSUMERS_COUNT, TIME_OF_LAST_TERMINATION,
				TOTAL_TERMINATIONS };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {

		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					wires == null ? 0 : wires.length);
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_GAUGE,
					producersConnected.get());
		} else if (TIME_OF_LAST_TERMINATION.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_DER,
					lastTerminationTime == 0 ? new Date(lastTerminationTime)
							.toString() : "");
		} else if (TOTAL_TERMINATIONS.equals(name)) {
			return new StatusVariable(name, StatusVariable.CM_CC,
					totalTerminations.get());
		} else {
			throw new IllegalArgumentException("Invalid Status Variable name "
					+ name);
		}
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String name)
			throws IllegalArgumentException {

		if (TOTAL_TERMINATIONS.equals(name)) {
			totalTerminations.set(0);
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {
		if (CONNECTED_CONSUMERS_COUNT.equals(name)) {
			return "The number of connected consumer wires.";
		} else if (CONNECTED_PRODUCERS_COUNT.equals(name)) {
			return "The number of producers connected to this flow terminator.";
		} else if (TIME_OF_LAST_TERMINATION.equals(name)) {
			return "The last time the flow was terminated.";
		} else if (TOTAL_TERMINATIONS.equals(name)) {
			return "The total number of flow terminations.";
		}
		return null;
	}

}
