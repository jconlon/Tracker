package com.verticon.tracker.irouter.common;

import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * ICallableFactory is the way {@link TaskMonitoringService} finds its
 * tasks to monitor.
 * 
 * @author jconlon
 *
 */
public interface ICallableFactory {

	/**
	 * 
	 * @return tasks to be monitored.
	 */
	public Collection<Callable<Void>> getCallables();
	
	/**
	 * 
	 * @return number of seconds before failed tasks are restarted.
	 */
	public long getSecondsBetweenRestarts();
	
	/**
	 * To identify the instance.
	 * @return pid
	 */
	public String getPid();
}