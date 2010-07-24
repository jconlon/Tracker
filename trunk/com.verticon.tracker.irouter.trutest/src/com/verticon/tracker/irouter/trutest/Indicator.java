package com.verticon.tracker.irouter.trutest;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.common.TrackerConstants.RETRY_CONNECTION_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.STABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.UNSTABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.trutest.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.Constants.CONSUME_COMMAND_DELAY;
import static com.verticon.tracker.irouter.trutest.Constants.CONSUME_COMMAND_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.DATA_SYNC_DIRECTORY;
import static com.verticon.tracker.irouter.trutest.Constants.DATA_SYNC_DIRECTORY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.Constants.DOWNLOAD_RECORD_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.Constants.FILE_HEADER_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.POLL_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.REQUEST_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.RESPONSE_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.RETRY_CONNECTION_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.SEND_UNSTABLE_WEIGHTS;
import static com.verticon.tracker.irouter.trutest.Constants.SEND_UNSTABLE_WEIGHTS_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.STABLE_WEIGHT_ERROR_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.UNSTABLE_WEIGHT_ERROR_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.UPLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.Constants.UPLOAD_RECORD_PATTERN_DEFAULT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import javax.microedition.io.StreamConnection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.ICallableFactory;
import com.verticon.tracker.irouter.common.TaskMonitoringService;

public class Indicator implements ICallableFactory, IIndicator {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory.getLogger(Indicator.class);


	public final static Dictionary<String, Object> DEFAULTS;
	private final BlockingQueue<String[]> commandQueue;
	private final String pid;
	private final ExecutorService exec;
	private final ScheduledExecutorService scheduler;
	private final EnvelopeProducer envelopeProducer;
	private final CommandConsumer commandConsumer;
	
	private volatile Future<Void> taskMonitorFuture;
	private volatile TaskMonitoringService taskMonitoringService = null;
	private volatile Dictionary<?, ?> config;
	protected volatile boolean initialized;

	private BundleContext bundleContext;
	
	private Writer out = null;
	private BufferedReader in = null;
	private volatile StreamConnection connection = null;
	
	
	

	static {
		DEFAULTS = new Hashtable<String, Object>();//socket://lantronix2:10001
		DEFAULTS.put(CONNECTION_URI, CONNECTION_URI_DEFAULT);
		DEFAULTS.put(TRACKER_WIRE_GROUP_NAME, TRACKER_WIRE_GROUP_NAME_DEFAULT);
		DEFAULTS.put(POLL_DELAY, POLL_DELAY_DEFAULT);
		DEFAULTS.put(REQUEST_COMMAND, REQUEST_COMMAND_DEFAULT);
		DEFAULTS.put(STABLE_WEIGHT_ERROR, STABLE_WEIGHT_ERROR_DEFAULT);
		DEFAULTS.put(UNSTABLE_WEIGHT_ERROR, UNSTABLE_WEIGHT_ERROR_DEFAULT);
		DEFAULTS.put(RESPONSE_PATTERN, RESPONSE_PATTERN_DEFAULT);// "^S (D|S)((\\s*)(.*))\\sg$");
		DEFAULTS.put(RETRY_CONNECTION_DELAY, RETRY_CONNECTION_DELAY_DEFAULT);
		DEFAULTS.put(CONSUME_COMMAND_DELAY, CONSUME_COMMAND_DELAY_DEFAULT);
		DEFAULTS.put(SEND_UNSTABLE_WEIGHTS, SEND_UNSTABLE_WEIGHTS_DEFAULT);
		
		DEFAULTS.put(DATA_SYNC_DIRECTORY, DATA_SYNC_DIRECTORY_DEFAULT);
		DEFAULTS.put(FILE_HEADER_COMMAND, FILE_HEADER_COMMAND_DEFAULT);
		DEFAULTS.put(DOWNLOAD_RECORD_PATTERN, DOWNLOAD_RECORD_PATTERN_DEFAULT);
		DEFAULTS.put(UPLOAD_RECORD_PATTERN, UPLOAD_RECORD_PATTERN_DEFAULT);

	}

	/**
	 * Constructor
	 * 
	 * @param pid
	 */
	public Indicator(String pid, ExecutorService exec,
			ScheduledExecutorService scheduler) {
		this.pid = pid;
		this.exec = exec;
		this.scheduler = scheduler;
		this.commandQueue = new LinkedBlockingQueue<String[]>();
		this.envelopeProducer = new EnvelopeProducer(this);
		this.commandConsumer = new CommandConsumer(this, commandQueue);
	}

	/**
	 * Constructor for testing
	 * 
	 * @param context
	 * @param measurementProducer
	 * @param commandConsumer
	 * @throws ConfigurationException
	 */
	Indicator(String pid, ExecutorService exec,
			ScheduledExecutorService scheduler,
			BlockingQueue<String[]> commandQueue) throws ConfigurationException {
		this.pid = pid;
		this.exec = exec;
		this.scheduler = scheduler;
		this.commandQueue = commandQueue;
		this.envelopeProducer = new EnvelopeProducer(this);
		this.commandConsumer = new CommandConsumer(this, commandQueue);
		
	}

	@Override
	public String toString() {
		return "Indicator [pid=" + pid + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.trutest.IIndicator#getConfigurationString(java.lang
	 * .String)
	 */
	@Override
	public String getConfigurationString(String key) {
		return (String) getConfiguration(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.trutest.IContext#getConfigurationLong(java.lang.
	 * String)
	 */
	@Override
	public Long getConfigurationLong(String key) {
		Object conf = getConfiguration(key);
		if (conf instanceof String) {
			return new Long((String) conf);
		}
		return (Long) conf;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getConfigurationInteger(java.lang.String)
	 */
	@Override
	public Integer getConfigurationInteger(String key) {
		Object conf = getConfiguration(key);
		if (conf instanceof String) {
			return new Integer((String) conf);
		}
		return (Integer) conf;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getConfigurationBoolean(java.lang.String)
	 */
	@Override
	public Boolean getConfigurationBoolean(String key) {
		Object conf = getConfiguration(key);
		if (conf instanceof String) {
			return new Boolean((String) conf);
		}
		return (Boolean) conf;
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getConfigurationDouble(java.lang.String)
	 */
	@Override
	public Double getConfigurationDouble(String key) {
		Object conf = getConfiguration(key);
		if (conf instanceof String) {
			return new Double((String) conf);
		}
		return (Double) conf;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IContext#getPid()
	 */
	@Override
	public String getPid() {
		return pid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IContext#getReader()
	 */
	@Override
	public synchronized BufferedReader getReader() throws IOException {

		if (in == null) {
			if (connection == null) {
				String uri = getConfigurationString(CONNECTION_URI);

				if (log.isDebugEnabled()) {
					log.debug(bundleMarker,String.format("%s Opening connection %s", this,
							uri));
				}
				ConnectorService cs = getConnectorService();

				connection = (StreamConnection) cs.open(uri,
						ConnectorService.READ_WRITE, true);
			} else {
				log.debug(bundleMarker,"{} Reusing connection {}", this,
							connection);
				
			}
			if (connection == null) {
				throw new IOException("Failed to create a connection to "
						+ getConfigurationString(CONNECTION_URI));
			}
			in = new BufferedReader(new InputStreamReader(connection
					.openInputStream()));
		}
		log.debug(bundleMarker,"{} Returning reader {} for connection {}",
					new Object[]{this, in, connection});
		
		return in;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IContext#getWriter()
	 */
	@Override
	public synchronized Writer getWriter() throws IOException {
		if (out == null) {
			if (connection == null) {
				String uri = getConfigurationString(CONNECTION_URI);
				;
				log.debug(bundleMarker,"{}: Opening connection {}.", this,uri);
				
				ConnectorService cs = getConnectorService();

				connection = (StreamConnection) cs.open(uri,
						ConnectorService.READ_WRITE, true);
			} else {
				log.debug(bundleMarker,"{}: Reusing connection {}.", this,connection);
				
			}
			if (connection == null) {
				throw new IOException("Failed to create a connection to "
						+ getConfigurationString(CONNECTION_URI));
			}
			out = new BufferedWriter(new OutputStreamWriter(connection
					.openOutputStream()));
		}
		if (log.isDebugEnabled()) {
			log.debug(bundleMarker,String.format("%s Returning writer %s for connection %s",
					this, out, connection));
		}
		return out;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#registerProducer()
	 */
	@Override
	public void registerProducer() {
		envelopeProducer.register(bundleContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#unregisterProducer()
	 */
	@Override
	public void unregisterProducer() {
		envelopeProducer.unRegister();
	}

	@Override
	public void registerConsumer() throws InterruptedException {
		commandConsumer.register(bundleContext);
		initialize();
	}

	void initialize() throws InterruptedException {
		commandConsumer.initialize();
	}

	@Override
	public void unregisterConsumer() {
		commandConsumer.unRegister();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.common.ICallableFactory2#getCallables()
	 */
	@Override
	public synchronized Collection<Callable<Void>> getCallables() {
		try {
			closeConnection();
		} catch (IOException e) {
			log.error(this + ": Failed to close connection.", e);
		}
		List<Callable<Void>> list = new ArrayList<Callable<Void>>();
		
		//Only start an InitializerCallable once 
		if(initialized){
			CountDownLatch startGate = new CountDownLatch(1);
			list.add(new EnvelopeProducerCallable(this, envelopeProducer, startGate));
			list.add(new CommandConsumerCallable(this, commandQueue, startGate));
		}else{
			list.add(new InitializerCallable(this));
		}
		
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.common.ICallableFactory2#getSecondsBetweenRestarts()
	 */
	@Override
	public long getSecondsBetweenRestarts() {
		return getConfigurationLong(RETRY_CONNECTION_DELAY).longValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getScheduler()
	 */
	@Override
	public ScheduledExecutorService getScheduler() {
		return scheduler;
	}

	/**
	 * Primary action method of the class. It is called by Component to
	 * configure or reconfigure this instance.
	 * 
	 * @param bc
	 * @param config
	 * @throws ConfigurationException
	 */
	void updated(BundleContext bc, Dictionary<?, ?> config)
			throws ConfigurationException {
		
		log.debug(bundleMarker,"{}: Updating.", this);
		this.bundleContext = bc;
		setConfig(config);
		// Use a taskMonitor to start/stop and watch all the background tasks.
		if (taskMonitoringService == null) {
			taskMonitoringService = new TaskMonitoringService(exec, this);
			taskMonitorFuture = exec.submit(taskMonitoringService);
		} else {
			// Canceling just cancels the monitored task. TaskMonitor will start
			// it again.
			taskMonitoringService.cancelAndRestartTasks(true);
		}

	}

//	/**
//	 * Called by Component to stop this instance.
//	 */
//	void stop() {
//		if (taskMonitorFuture != null) {
//			taskMonitorFuture.cancel(true);
//			taskMonitorFuture = null;
//		}
//		if (taskMonitoringService != null) {
//			taskMonitoringService.cancelAndRestartTasks(true);
//			taskMonitoringService = null;
//		}
//
//	}
	
	/**
	 * Called by Component to stop this balance.
	 */
	synchronized void stop() {
		if (taskMonitorFuture != null) {
			
			boolean canceledTaskMonitor = taskMonitorFuture.cancel(true);
			if(log.isDebugEnabled()){
				  if(canceledTaskMonitor){
					  log.debug(bundleMarker,this + ": Canceled the "+taskMonitorFuture);
				  }else{
					  log.debug(bundleMarker,this + ": Failed to cancel the "+taskMonitorFuture);
				  }
			}
			taskMonitorFuture = null;
		}else{
			log.error("Should have found a taskMonitor");
		}
		unregisterProducer();
		unregisterConsumer();
		taskMonitoringService = null;
		log.debug(bundleMarker,"{}: Stopped.", this);
	}


	/**
	 * Protected so a testing mock can override it.
	 * 
	 * @return
	 * @throws IOException
	 */
	protected ConnectorService getConnectorService() throws IOException {
		ServiceReference sr = bundleContext
				.getServiceReference(ConnectorService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ConnectorService.");
		}

		ConnectorService cs = (ConnectorService) bundleContext.getService(sr);

		if (sr == null) {
			throw new IOException("Failed to find a ConnectorService.");
		}

		return cs;
	}

	/**
	 * Protected so a test mock can override
	 * 
	 * @param key
	 * @return
	 */
	protected Object getConfiguration(String key) {
		Dictionary<?, ?> conf = config != null ? config : DEFAULTS;
		Object o = conf.get(key);
		if (o == null) {
			o = DEFAULTS.get(key);
		}
		if (o == null) {
			throw new IllegalArgumentException("Unknown key=" + key);
		}
		return o;
	}

	/**
	 * Protected for overriding by a test mock.
	 * 
	 * @param config
	 * @throws ConfigurationException
	 */
	protected void setConfig(Dictionary<?, ?> config)
			throws ConfigurationException {
		String uri = (String) config.get(CONNECTION_URI);
		if (uri == null || uri.trim().length() < 5) {
			throw new ConfigurationException(CONNECTION_URI, "Invalid value");
		}

		this.config = config;
	}

	private void closeConnection() throws IOException {
		if (in != null) {
			in.close();
			in = null;
		}
		if (out != null) {
			out.close();
			out = null;
		}
		if (connection != null) {
			log.debug(bundleMarker,"{}: Closing connection.", this);
			connection.close();
			connection = null;
		}
	}

//	/*
//	 * (non-Javadoc)
//	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getEndGate()
//	 */
//	@Override
//	public CountDownLatch getEndGate() {
//		return endGate;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see com.verticon.tracker.irouter.trutest.IIndicator#getStartGate()
//	 */
//	@Override
//	public CountDownLatch getStartGate() {
//		return startGate;
//	}

	@Override
	public File getDownload() {
		String groupName = getConfigurationString(TRACKER_WIRE_GROUP_NAME);
		return new File(getSynchronizationDirectory(), "animalLifeDataDownload-"+groupName+".txt");
	}

	@Override
	public File getUpload() {
		return new File(getSynchronizationDirectory(), "animalLifeDataUpLoad.txt");
	}


    File getSynchronizationDirectory(){
		String syncDir = getConfigurationString(DATA_SYNC_DIRECTORY);
		return new File(syncDir);
	}
	
	public synchronized void  initialized() {
		this.initialized = true;
	}

}
