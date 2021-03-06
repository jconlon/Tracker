/**
 * 
 */
package com.verticon.tracker.logging;

/*******************************************************************************
 * Copyright (c) 2005 John J. Franey
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/


import java.text.MessageFormat;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * log4j appender to an eclipse plugin's Ilog.
 * @author John J. Franey
 *
 */
public class PluginLogAppender extends AppenderSkeleton {

	private String symbolicName;
	

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
	 */
	protected void append(LoggingEvent event) {
		
		// don't go any further if event is not severe enough.
		if(! isAsSevereAsThreshold(event.getLevel())) return;
		
		ILog log = getBundleILog();
		if(log == null) return;
		
		// if throwable information is available, extract it.
		Throwable t = null;
		if(event.getThrowableInformation() != null && layout.ignoresThrowable())
			t = event.getThrowableInformation().getThrowable();
		
		// build an Eclipse Status record, map severity and code from Event.
		Status s = new Status(getSeverity(event),
				getSymbolicName(),
				getCode(event),
				layout.format(event), t);

		
		log.log(s);

	}

	/**
	 * map LoggingEvent's level to Status severity
	 * @param ev
	 * @return
	 */
	private int getSeverity(LoggingEvent ev) {
		
		Level level = ev.getLevel();
		if(level == Level.FATAL || level == Level.ERROR)
			return IStatus.ERROR;
		else if(level == Level.WARN)
			return IStatus.WARNING;
		else if(level == Level.INFO) 
			return IStatus.INFO;
		else // debug, trace and custom levels
			return IStatus.OK;
	}
	
	/**
	 * Return the pluginId under which the messages will be logged
	 * @return
	 */
	public String getSymbolicName() {
		return this.symbolicName;
	}
	
	/**
	 * Sets the symbolic Name of the plugin for this appender.  
	 * The symbolicName is used to find the bundle, and the 
	 * ILog for this bundle.
	 * 
	 * It is set in the log4j.properties file. 
	 * 
	 * Initially set to the symbolicName of the symbolicName of 
	 * this bundle.
	 * com.verticon.tracker.logging
	 * @param name
	 */
	public void setSymbolicName(String name) {
		this.symbolicName = name;
	}
	/**
	 * map LoggingEvent to Status code
	 * @param ev
	 * @return
	 */
	private int getCode(LoggingEvent ev) {
		return 0;
	}
	
	private ILog getBundleILog() {
		// get the bundle for a plug-in
		Bundle b = Platform.getBundle(getSymbolicName());
		if(b == null) {
			String m = MessageFormat.format("Plugin: {0} not found in {1}.",
					new Object[] {getSymbolicName(), this.name});
			this.errorHandler.error(m);
			return null;
		}
	
		return Platform.getLog(b);
		

	}
	
	public void close() {
		// nothing to close
	}

	public boolean requiresLayout() {
		return true;
	}

}