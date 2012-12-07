
package com.verticon.tracker.logging;

import java.text.MessageFormat;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.spi.FilterReply;


public class PluginLogAppender  extends AppenderBase<LoggingEvent> {

	private String symbolicName;
	
	@Override
	protected void append(LoggingEvent event) {
		
		// don't go any further if event is not severe enough.
		FilterReply reply = this.getFilterChainDecision(event);
		
		if(reply != FilterReply.ACCEPT) return;
		
		ILog log = getBundleILog();
		if(log == null) return;
		
		// if throwable information is available, extract it.
		Throwable t = null;
		
		if(event.getThrowableProxy() != null )
			t = event.getThrowableProxy().getThrowable();
		
		// build an Eclipse Status record, map severity and code from Event.
		Status s = new Status(getSeverity(event),
				getSymbolicName(),
				getCode(event),
				getLayout().doLayout(event), t);

		
		log.log(s);

	}

	/**
	 * map LoggingEvent's level to Status severity
	 * @param ev
	 * @return
	 */
	private int getSeverity(LoggingEvent event) {
		int result;
		switch (event.getLevel().toInt()) {
		case Level.ERROR_INT:
			result = IStatus.ERROR;
			break;

		case Level.WARN_INT:
			result = IStatus.WARNING;
			break;

		case Level.INFO_INT:
			result = IStatus.INFO;
			break;

		// debug, trace and custom levels
		default:
			result = IStatus.OK;
			break;
		}
		return result;
	}
	
	/**
	 * Return the pluginId under which the messages will be logged
	 * @return symbolicName
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
			this.addError(m);
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