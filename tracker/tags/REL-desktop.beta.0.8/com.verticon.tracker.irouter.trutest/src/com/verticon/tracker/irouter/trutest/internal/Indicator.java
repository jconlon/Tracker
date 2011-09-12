/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.trutest.internal;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.common.TrackerConstants.RETRY_CONNECTION_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.STABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME_DEFAULT;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRANSACTION_STATE_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.UNSTABLE_WEIGHT_ERROR;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUMER_SCOPE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUMER_SCOPE_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUME_COMMAND_DELAY;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CONSUME_COMMAND_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DATA_SYNC_DIRECTORY;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DATA_SYNC_DIRECTORY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.NODE_LABEL;
import static com.verticon.tracker.irouter.trutest.internal.Constants.NODE_LABEL_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.POLL_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_WEIGHT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ANIMAL_WEIGHT_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ENTER_KEY;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_SCOPE_ENTER_KEY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.PRODUCER_STATE_ENTER_KEY_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Constants.REQUEST_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.RESPONSE_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.RETRY_CONNECTION_DELAY_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SEND_UNSTABLE_WEIGHTS;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SEND_UNSTABLE_WEIGHTS_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.STABLE_WEIGHT_ERROR_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UNSTABLE_WEIGHT_ERROR_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN_DEFAULT;

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
import java.util.concurrent.atomic.AtomicBoolean;

import javax.microedition.io.StreamConnection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.osgi.service.monitor.MonitorListener;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.ICallableFactory;
import com.verticon.tracker.irouter.common.MonitorableHandler;
import com.verticon.tracker.irouter.common.TaskMonitoringService;

/**
 * 
 * Implementation of an TruTest Indicator and ICallableFactory. 
 * 
 * Provides a Writer, Reader, PID, configuration, executorService 
 * and a scheduledExecutorService.
 * 
 * @author jconlon
 *
 */
public class Indicator implements ICallableFactory, IIndicator, Monitorable{

	private static final String NAME_OF_ANIMAL_LIFE_DATA_UP_LOAD_FILE = "animalLifeDataUpLoad.txt";

	public final static Dictionary<String, Object> DEFAULTS;
	
	protected volatile boolean initialized;
	
	private static final String DOWNLOAD_RECORDS_COUNT = "producer.Downloaded_Records";
	private static final String UPLOAD_RECORDS_COUNT = "producer.Uploaded_Records";
	private static final String CONNECTED = "producer.Is_Connected";
	private static final String CONNECTION_URI_STATUS_VAR = "producer.Connection_URI";
	private final Logger log = LoggerFactory.getLogger(Indicator.class);
	private final BlockingQueue<String[]> commandQueue;
	private final String pid;
	private final ExecutorService exec;
	private final ScheduledExecutorService scheduler;
	private final EnvelopeProducer envelopeProducer;
	private final CommandConsumer commandConsumer;
	private volatile Future<Void> taskMonitorFuture;
	private volatile TaskMonitoringService taskMonitoringService = null;
	private volatile Dictionary<?, ?> config;
	private BundleContext bundleContext;
	private Writer out = null;
	private BufferedReader in = null;
	private volatile StreamConnection connection = null;
	private int upLoadedRecords;
	private int downLoadedRecords;
	private final Monitorable monitorableDelegate;
	private ServiceRegistration<?> monitorableRegistration;
	private AtomicBoolean connected = new AtomicBoolean();
	private AtomicBoolean monitorRegistered = new AtomicBoolean();
	
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
		DEFAULTS.put(CONSUMER_SCOPE, CONSUMER_SCOPE_DEFAULT);

		DEFAULTS.put(PRODUCER_SCOPE_ANIMAL_WEIGHT, PRODUCER_SCOPE_ANIMAL_WEIGHT_DEFAULT);
		DEFAULTS.put(PRODUCER_SCOPE_ENTER_KEY, PRODUCER_SCOPE_ENTER_KEY_DEFAULT);
		
		DEFAULTS.put(PRODUCER_STATE_ENTER_KEY_NAME, TRANSACTION_STATE_SCOPE);
		DEFAULTS.put(NODE_LABEL, NODE_LABEL_DEFAULT);
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
		this.monitorableDelegate=createMonitorables();
	}

	private Monitorable createMonitorables() {
		List<Monitorable> monitorables = new ArrayList<Monitorable>();
		monitorables.add(envelopeProducer);
		monitorables.add(commandConsumer);
		monitorables.add(this);
		return new MonitorableHandler(monitorables);
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
		this.monitorableDelegate=createMonitorables();
	}

	@Override
	public String toString() {
		return "Indicator [pid=" + pid + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.trutest.internal.IIndicator#getConfigurationString(java.lang
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
	 * com.verticon.tracker.irouter.trutest.internal.IContext#getConfigurationLong(java.lang.
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#getConfigurationInteger(java.lang.String)
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#getConfigurationBoolean(java.lang.String)
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#getConfigurationDouble(java.lang.String)
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IContext#getPid()
	 */
	@Override
	public String getPid() {
		return pid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.internal.IContext#getReader()
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
			setConnectedStatusVariable(true);
		}
		log.debug(bundleMarker,"{} Returning reader {} for connection {}",
					new Object[]{this, in, connection});
		
		return in;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.internal.IContext#getWriter()
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#registerProducer()
	 */
	@Override
	public void registerProducer() {
		envelopeProducer.register(bundleContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#unregisterProducer()
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
			list.add(new InitializerCallable(this, bundleContext));
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
	 * @see com.verticon.tracker.irouter.trutest.internal.IIndicator#getScheduler()
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
		ServiceReference<?> sr = bundleContext
				.getServiceReference(ConnectorService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ConnectorService.");
		}

		ConnectorService cs = (ConnectorService) bundleContext.getService(sr);

		return cs;
	}
	
	/**
	 * Used for scopes
	 * @param key
	 * @return an array
	 */
	 @Override
	public String[] getConfigurationStringArray(String key) {
		Object conf = getConfiguration(key);
		if (conf instanceof String) {
			return new String[]{(String) conf};
		}
		return (String[]) conf;
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



	@Override
	public File getDownload() {
		String groupName = getConfigurationString(TRACKER_WIRE_GROUP_NAME);
		return new File(getSynchronizationDirectory(), "animalLifeDataDownload-"+groupName+".txt");
	}

	@Override
	public File getUpload() {
		return new File(getSynchronizationDirectory(), NAME_OF_ANIMAL_LIFE_DATA_UP_LOAD_FILE);
	}


	/**
	 * 
	 * @return a valid directory specified in the configuration or the user home directory. 
	 */
    File getSynchronizationDirectory(){
    	String syncDir = getConfigurationString(DATA_SYNC_DIRECTORY);
    	File dir = null;
    	if(isNullOrEmpty(syncDir)){
    		dir = new File(System.getProperty("user.home"));
    	}else{
    		dir =  new File(syncDir);
    		if(!dir.exists() || dir.isFile()){
    			log.warn(bundleMarker,"{}: Invalid data sync directory {}, using your home directory instead.", new Object[] {this,dir});
    			dir = new File(System.getProperty("user.home"));
    		}
    	}
		return dir;
	}
	
	public synchronized void  initialized() {
		this.initialized = true;
	}

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{DOWNLOAD_RECORDS_COUNT,UPLOAD_RECORDS_COUNT,CONNECTED,CONNECTION_URI_STATUS_VAR };
	}

	@Override
	public StatusVariable getStatusVariable(String name)
			throws IllegalArgumentException {
		if (DOWNLOAD_RECORDS_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_CC,
					downLoadedRecords
					);
		}
		
		if (UPLOAD_RECORDS_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_CC,
					upLoadedRecords
					);
		}
		if (CONNECTED.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_DER,
					in!=null
			);
		}
	    if (CONNECTION_URI_STATUS_VAR.equals(name)){
			return
				new StatusVariable(name,
						StatusVariable.CM_DER,
						getConfigurationString(CONNECTION_URI)
				);
		
		}
		throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
		
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		if (CONNECTED.equals(id)){
			return true;
		}
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if (DOWNLOAD_RECORDS_COUNT.equals(id)){
			return
			"The number of records downloaded to the scalehead.";
		}
		if (UPLOAD_RECORDS_COUNT.equals(id)){
			return
			"The number of records uploaded to the scalehead.";
		}
		if (CONNECTED.equals(id)){
			return
			"If there is a connected scalehead.";
		}
		if (CONNECTION_URI_STATUS_VAR.equals(id)){
			return "The URI of the connected indicator.";
		}
		return null;
	}

	@Override
	public void setUpLoadedRecords(int upLoadedRecords) {
		this.upLoadedRecords = upLoadedRecords;
	}

	/**
	 * @param downLoadedRecords the downLoadedRecords to set
	 */
	public void setDownLoadedRecords(int downLoadedRecords) {
		this.downLoadedRecords = downLoadedRecords;
	}
	
	void setConnectedStatusVariable(boolean connected){
		this.connected.set(connected);
		MonitorListener l = Component.getMonitorListener();
		if(l!=null && monitorRegistered.get()){
			l.updated(pid, 
					getStatusVariable(CONNECTED));
		}
	}

	@Override
	public void registerMonitorable() {
		Dictionary<String, String> props = new Hashtable<String,String>();
		props.put("service.pid", pid);
		monitorableRegistration = FrameworkUtil.getBundle(this.getClass()).getBundleContext()
			.registerService(
				Monitorable.class.getName(), monitorableDelegate, props);
		monitorRegistered.set(true);
	}

	@Override
	public void unregisterMonitorable() {
		monitorableRegistration.unregister();
		monitorRegistered.set(false);
	}

}
