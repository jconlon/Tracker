package com.verticon.tracker.irouter.common;

import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_SCOPE;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;


public abstract class AbstractConsumer implements Consumer, IService {

	private static final String NODE_LABEL = "tracker.monitor.label";
	
	/**
	 * slf4j Logger
	 */
	protected final Logger log = LoggerFactory
			.getLogger(this.getClass());

	protected abstract Marker bundleMarker();

	
	protected final AtomicInteger wiresConnected
	    = new AtomicInteger(0);

	protected final IContext context;
	protected ServiceRegistration serviceRegistration = null;

	protected AbstractConsumer(IContext context) {
		super();
		this.context = context;
	}

	@Override
	public void producersConnected(Wire[] wires) {
		wiresConnected.set(0);
		if (wires == null) {
			log.debug(bundleMarker(),"{}: Not connected to any wires.", this);
			
		} else {
			HashSet<String> producers = new HashSet<String>();
			for (Wire wire : wires) {
				producers.add((String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID));
				wiresConnected.incrementAndGet();
			}

			log.debug(bundleMarker(),"{}: Connected to {} wires, and {} producers={}",
					new Object[] { this, wires.length, producers.size(),
							producers });
		}
	}

	/**
	 * 
	 * @param bc
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void start(BundleContext bc) throws InterruptedException,
			ExecutionException {
		log.info(bundleMarker(),"{}:Starting.", this);

		registerService(bc);
		if (log.isInfoEnabled()) {
			log.info(bundleMarker(),"{}:Started.", this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.common.IService#stop()
	 */
	public void stop() {
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
			serviceRegistration = null;
		}

	}

	public void logError(Wire wire, Object in) {
		String group = (String) wire.getProperties().get(
				TRACKER_WIRE_GROUP_NAME);
		log.error(bundleMarker(),"{}: Received unknown object={}, Wire group={}, scope={},",
				new Object[]{this, in.getClass(), group,
					Arrays.toString(wire.getScope())});
		
	}
	
	public void logUnknownScopeError(Wire wire, Object in) {
		String group = (String) wire.getProperties().get(
				TRACKER_WIRE_GROUP_NAME);
		log.error(bundleMarker(),"{}: Received unknown object={}, Wire group={}, scope={},",
					new Object[]{this, in, group,
					Arrays.toString(wire.getScope())});
		
	}
	
	public abstract String[] getScope();
	
	private void registerService(BundleContext bc) {
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, this.context.getPid());
		/*
		 * Using Composite Consumer/Producer have caused problems. Bug or usage?
		 * regProps.put(WireConstants.WIREADMIN_CONSUMER_COMPOSITE, new String[]
		 * {"Abbott-ServiceController"});
		 */
		regProps.put(WIREADMIN_CONSUMER_SCOPE, getScope());
		regProps
				.put(WIREADMIN_CONSUMER_FLAVORS, new Class[] { Envelope.class });
		regProps.put(TRACKER_WIRE_GROUP_NAME, this.context
				.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		
		regProps.put(NODE_LABEL, context.getConfigurationString(NODE_LABEL));
		serviceRegistration = bc.registerService(Consumer.class.getName(),
				this, regProps);
	}
	
	
}
