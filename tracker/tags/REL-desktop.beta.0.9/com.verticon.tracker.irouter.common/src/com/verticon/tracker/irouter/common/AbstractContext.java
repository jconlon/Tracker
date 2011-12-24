package com.verticon.tracker.irouter.common;

import java.util.Dictionary;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;


public abstract class AbstractContext implements IContext {

	protected final ExecutorService executor;
	protected final ScheduledExecutorService scheduler;
	protected final String pid;
	private Dictionary<?, ?> config;
	private BundleContext bundleContext = null;

	/**
	 * Constructor
	 * 
	 * @param pid
	 */
	public AbstractContext(String pid, Dictionary<?, ?> configuration,
			ExecutorService exec, ScheduledExecutorService scheduler)
			throws ConfigurationException {
		setConfig(configuration);
		this.executor = exec;
		this.scheduler = scheduler;
		this.pid = pid;
	}
	
	@Override
	public BundleContext getBundleContext() {
		return bundleContext;
	}

	@Override
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	@Override
	public Boolean getConfigurationBoolean(String key) {
		Object conf = getConfiguration( key);
		if(conf instanceof String){
			return Boolean.valueOf((String)conf);
		}
		return (Boolean)conf;
	}

	@Override
	public Long getConfigurationLong(String key) {
		Object conf = getConfiguration( key);
		if(conf instanceof String){
			return new Long((String)conf);
		}
		return (Long)conf;
	}

	@Override
	public String getConfigurationString(String key) {
		return (String)getConfiguration( key);
	}

	@Override
	public Double getConfigurationDouble(String key) {
		Object conf = getConfiguration( key);
		if(conf instanceof String){
			return new Double((String)conf);
		}
		return (Double)conf;
	}
	
	@Override
	public String[] getConfigurationArray(String key) {
		Object conf = getConfiguration( key);
		if(conf instanceof String){
			return ((String)conf).split(",");
		}
		return (String[])conf;
	}

	@Override
	public Integer getConfigurationInteger(String key) {
		Object conf = getConfiguration( key);
		if(conf instanceof String){
			return new Integer((String)conf);
		}
		return (Integer)conf;
	}

	@Override
	public String getPid() {
		return pid;
	}

	@Override
	public ExecutorService getExecutor() {
		return executor;
	}

	@Override
	public ScheduledExecutorService getScheduler() {
		return scheduler;
	}

	@Override
	public void setConfig(Dictionary<?, ?> config) throws ConfigurationException {
	
		this.config = config;
	}

	protected Object getConfiguration(String key) {
		Dictionary<?, ?> conf = config != null ? config : getDefaults();
		Object o = conf.get(key);
		if (o == null) {
			o = getDefaults().get(key);
		}
		if (o == null) {
			throw new IllegalArgumentException("Unknown key=" + key);
		}
		return o;
	}

	protected abstract Dictionary<?,?> getDefaults();
}
