/**
 * 
 */
package com.verticon.tracker.irouter.ohaus.internal;

import static com.verticon.tracker.irouter.ohaus.ConfigKey.getConnectionRetrySeconds;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getScope;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getServicePid;
import static com.verticon.tracker.irouter.ohaus.ConfigKey.getURI;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.osgi.service.io.ConnectorService;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Producer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.google.common.util.concurrent.AbstractCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;


/**
 * @author jconlon
 *
 */
public class OhausProducer implements Monitorable, Producer {

	static String PLUGIN_ID = "com.verticon.tracker.irouter.ohaus";
	/**
	 * slf4j Marker to keep track of bundle
	 */
	static final Marker bundleMarker = MarkerFactory.getMarker(PLUGIN_ID);

	static {
		OhausProducer.bundleMarker.add(MarkerFactory.getMarker("IS_BUNDLE"));
	}

	/**
	 * this.config.clear(); config = null; slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(OhausProducer.class);

	private final StatusMonitor statusMonitor = new StatusMonitor();

	// Shared wires protected with concurrent collection
	private final List<Wire> wires = new CopyOnWriteArrayList<Wire>();
	// Shared envelope protected with volatile
	private volatile Envelope envelope = null;

	// DS Injected dependencies
	private ConnectorService connectorService;

	private Map<String, Object> config;

	// private ExecutorService exec = null;
	private static ListeningExecutorService exec = MoreExecutors
			.listeningDecorator(Executors.newCachedThreadPool());

	private volatile OhausProxy proxy;

	private volatile AbstractCheckedFuture<Void, IOException> lfuture = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#polled(org.osgi.service.wireadmin
	 * .Wire)
	 */
	@Override
	public Object polled(Wire wire) {
		return envelope;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.service.wireadmin.Producer#consumersConnected(org.osgi.service
	 * .wireadmin.Wire[])
	 */
	@Override
	public void consumersConnected(Wire[] wires) {
		this.wires.clear();
		if (wires != null) {
			this.wires.addAll(Arrays.asList(wires));
			statusMonitor.setWiresConnected(wires.length);
		}
		if (this.wires.isEmpty()) {
			logger.debug(bundleMarker, "{}: Not connected to any wires.", this);
			statusMonitor.setWiresConnected(0);
		} else {
			HashSet<String> consumers = new HashSet<String>();
			for (Wire wire : wires) {
				consumers.add((String) wire.getProperties().get(
						WIREADMIN_CONSUMER_PID));
			}

			logger.debug(bundleMarker,
					"{}: Connected to {} wires, and {} consumers={}",
					new Object[] { this, wires.length, consumers.size(),
							consumers });
		}

	}

	@Override
	public String[] getStatusVariableNames() {
		return statusMonitor.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.getStatusVariable(id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return statusMonitor.notifiesOnChange(id);
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return statusMonitor.resetStatusVariable(id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return statusMonitor.getDescription(id);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to set
	 */
	void setMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param connectorService
	 *            the connectorService to set
	 */
	void setConnectorService(ConnectorService connectorService) {
		this.connectorService = connectorService;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param connectorService
	 *            the connectorService to set
	 */
	void unsetConnectorService(ConnectorService connectorService) {
		this.connectorService = null;
	}

	/**
	 * Declaratives Services service injection
	 * 
	 * @param monitorListener
	 *            the monitorListener to unset
	 */
	void unsetMonitorListener(MonitorListener monitorListener) {
		statusMonitor.setMonitorListener(monitorListener);
	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void activate(Map<String, Object> config) throws IOException {
		logger.debug(bundleMarker, "Activating");
		this.config = config;
		proxy = new OhausProxy(this);
		logger.debug(bundleMarker, "{}: Initial Proxy submit.", this);
		lfuture = new IOFuture(exec.submit(proxy));
		lfuture.addListener(monitoringListener, exec);
	}

	/**
	 * Declaratives Services deactivation of instance.
	 * 
	 */
	void deactivate() {
		logger.debug(bundleMarker, "Deactivating");
		exec.shutdownNow();
		config = null;
	}

	/**
	 * @return the config
	 */
	Map<String, Object> getConfig() {
		return config;
	}

	/**
	 * @return the statusMonitor
	 */
	StatusMonitor getStatusMonitor() {
		return statusMonitor;
	}

	/**
	 * @return the connectorService
	 */
	ConnectorService getConnectorService() {
		return connectorService;
	}

	void send(Measurement measurement) {
		this.envelope = new BasicEnvelope(measurement, "0", getScope(config));
		if (!wires.isEmpty()) {
			logger.debug(bundleMarker,
					"{}: sending measuement={}, to {} wires",
					new Object[] { this, wires.size(), measurement });

			// Send to all wires
			for (Wire wire : wires) {
				wire.update(envelope);
				logger.debug("{} sent to {}", measurement, wire);
			}
			statusMonitor.incMeasurementCount();
		} else {
			logger.warn(bundleMarker,
					"{}: No wires found. Aborted sending measuement={}", this,
					measurement);
		}
	}

	/**
	 * Future for encapsulating the OhausProxy. If an exception is thrown by the
	 * proxy it will be normalized as an IOException.
	 * 
	 * @author jconlon
	 * 
	 */
	private class IOFuture extends AbstractCheckedFuture<Void, IOException> {

		protected IOFuture(ListenableFuture<Void> delegate) {
			super(delegate);
		}

		@Override
		protected IOException mapException(Exception e) {
			if (e instanceof IOException) {
				return (IOException) e;
			} else if (e instanceof ExecutionException) {
				ExecutionException exex = (ExecutionException) e;
				if (exex.getCause() instanceof IOException) {
					return (IOException) exex.getCause();
				} else {
					return new IOException(exex.getCause());
				}
			}
			return new IOException(e);
		}

	}

	/**
	 * This will listen to the OhausProxy that is wrapped in an IOFuture,
	 * resubmitting it if it experienced an error or ended prematurely
	 */
	private final Runnable monitoringListener = new Runnable() {
		private final String LABEL = "Connection Monitor";

		@Override
		public void run() {
			if (lfuture.isCancelled()) {
				logger.warn(
						bundleMarker,
						"{}: Defering resubmission of the proxy because it was canceled. ",
						LABEL);
			} else {
				try {
					lfuture.checkedGet();
				} catch (IOException e) {
					logger.warn(bundleMarker, LABEL + ": pid="
							+ getServicePid(config) + " failed to connect to "
							+ getURI(config), e);
				}
				resubmit();
			}
		}
	};

	/**
	 * Resubmits the OhausProxy if it ended with an exception or ended
	 * prematurely.
	 */
	private void resubmit() {
		logger.warn(bundleMarker, "{}: resubmit invoked", this);
		if (!Thread.currentThread().isInterrupted()) {
			long delay = getConnectionRetrySeconds(config);
			try {
				logger.debug(
						bundleMarker,
						"{} waiting {} seconds before attempting a connection to the device.",
						this, delay);
				TimeUnit.SECONDS.sleep(delay);
			} catch (InterruptedException e) {
				logger.warn(
						bundleMarker,
						"{}: Thread is Interrupted. Defering resubmission of proxy.",
						this);
				Thread.currentThread().interrupt();
				return;
			}
		} else {
			logger.warn(
					bundleMarker,
					"{}: Thread is Interrupted. Defering resubmission of proxy.",
					this);
			Thread.currentThread().interrupt();
			return;
		}
		logger.debug(bundleMarker, "{}: resubmitting proxy.", this);
		lfuture = new IOFuture(exec.submit(proxy));
		lfuture.addListener(monitoringListener, exec);
	}

}
