package com.verticon.tracker.irouter.common;

import java.util.Dictionary;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;

/**
 * Provides a PID, configuration,
 * executorService and a scheduledExecutorService.
 * @author jconlon
 *
 */
public interface IContext {
	String getConfigurationString(String key);
	Double getConfigurationDouble(String key);
	Long getConfigurationLong(String key);
	Boolean getConfigurationBoolean(String key);
	Integer getConfigurationInteger(String key);
	String[] getConfigurationArray(String key);
	
	String getPid();
	public ExecutorService getExecutor();
	public ScheduledExecutorService getScheduler();
	public BundleContext getBundleContext();
	public void setBundleContext(BundleContext bundleContext);
	public void setConfig(Dictionary<?, ?> config) throws ConfigurationException;
}
