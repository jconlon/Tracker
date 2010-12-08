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
package com.verticon.tracker.irouter.mettler;

import static com.verticon.tracker.irouter.mettler.FactoryComponent.bundleMarker;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.RETRY_CONNECTION_DELAY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.ICallableFactory;
import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.TaskMonitoringService;

/**
 * Context for holding a balance configuration and connection.
 * 
 * @author jconlon
 * 
 */
public class Balance implements ICallableFactory, IBalance {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory.getLogger(Balance.class);

	private final IContext context;

    static final Double UNSTABLE_WEIGHT_ERROR_DEFAULT = new Double(.01);
	static final Double STABLE_WEIGHT_ERROR_DEFAULT = new Double(.002);
	
	private final MeasurementProducer measurementProducer;

	private volatile Future<Void> taskMonitorFuture;
	private volatile TaskMonitoringService taskMonitoringService = null;


//	/**
//	 * Constructor
//	 * 
//	 * @param pid
//	 */
//	public Balance(String pid, ExecutorService exec) {
//		this.pid = pid;
//		this.exec = exec;
//		this.measurementProducer=new MeasurementProducer(this);
//	}

	/**
	 * Constructor
	 * 
	 * @param pid
	 */
	public Balance(String pid, Dictionary<?, ?> configuration,
			ExecutorService exec) throws ConfigurationException {
		context = new Context(pid, configuration, exec, null);
		this.measurementProducer=new MeasurementProducer(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Balance [pid=" + context.getPid() + ", uri="
				+ context.getConfigurationString(CONNECTION_URI) + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.ICallableFactory2#getCallables()
	 */
	@Override
	public Collection<Callable<Void>> getCallables() {
		List<Callable<Void>> list = new ArrayList<Callable<Void>>();
		list.add(new MeasurementProducerCallable(this,measurementProducer));
		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.ICallableFactory2#getSecondsBetweenRestarts()
	 */
	@Override
	public long getSecondsBetweenRestarts() {
		return context.getConfigurationLong(RETRY_CONNECTION_DELAY).longValue();
	}
	
	/*
	 * 
	 */
	@Override
	public String getPid() {
		return context.getPid();
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mettler.IBalance#getConnectorService()
	 */
	@Override
	public ConnectorService getConnectorService() throws IOException {
		ServiceReference sr = context.getBundleContext()
				.getServiceReference(ConnectorService.class.getName());

		if (sr == null) {
			throw new IOException(
					"Failed to find a Reference to the ConnectorService.");
		}

		ConnectorService cs = (ConnectorService) context.getBundleContext().getService(sr);

		return cs;
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mettler.IBalance#registerProducer()
	 */
	@Override
	public void registerProducer() {//TODO Refactor 
		measurementProducer.register(context.getBundleContext());
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mettler.IBalance#unregisterProducer()
	 */
	@Override
	public void unregisterProducer() {//TODO Refactor
		measurementProducer.unRegister();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.mettler.IBalance#getContext()
	 */
	@Override
	public IContext getContext() {
		return context;
	}
	
	/**
	 * Called by FactoryComponent to configure or reconfigure this balance.
	 * 
	 * @param bc
	 * @param config
	 * @throws ConfigurationException
	 */
	synchronized void updated(BundleContext bc, Dictionary<?, ?> config)
			throws ConfigurationException {
		log.debug(bundleMarker,"{}: Updating",this);
		
		context.setBundleContext(bc);
		context.setConfig(config);
		// Use a taskMonitor to start/stop and watch a connection task.
		if (taskMonitoringService == null) {
			taskMonitoringService = new TaskMonitoringService(context.getExecutor(), this);
			taskMonitorFuture = context.getExecutor().submit(taskMonitoringService);
		} else {
			// Canceling just cancels the monitored task. TaskMonitor will start
			// it again.
			taskMonitoringService.cancelAndRestartTasks(true);
		}

	}

	/**
	 * Called by FactoryComponent to stop this balance.
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
			log.error(bundleMarker,"{}: Should have found a taskMonitor",this);
		}
		unregisterProducer();
		taskMonitoringService = null;
		log.debug("{}: Stopped",this);
	}


}
