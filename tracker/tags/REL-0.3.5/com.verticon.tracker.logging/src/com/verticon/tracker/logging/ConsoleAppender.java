/**
 * 
 */
package com.verticon.tracker.logging;

import org.eclipse.ui.PlatformUI;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * @author jconlon
 * 
 */
public class ConsoleAppender extends AppenderBase<LoggingEvent> {

	private String consoleName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent
	 * )
	 */
	protected void appendInternal(LoggingEvent event) {
		String message = super.getLayout().doLayout(event);
		switch (event.getLevel().toInt()) {
		case Level.ERROR_INT:
			ConsoleUtil.printError(consoleName, message);
			break;

		case Level.WARN_INT:
			ConsoleUtil.printWarning(consoleName, message);
			break;

		case Level.INFO_INT:
			ConsoleUtil.printInfo(consoleName, message);
			break;

		case Level.DEBUG_INT:
			ConsoleUtil.print(consoleName, message);
			break;

		default:
			ConsoleUtil.print(consoleName, message);
			break;
		}
	}

	/**
	 * The console is running on the SWT UI thre
	 */
	@Override
	protected void append(final LoggingEvent event) {

		try {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					appendInternal(event);
				}
			});
		} catch (RuntimeException e) {
			// ignore
		}

	}

	@Override
	public void stop() {
		ConsoleUtil.unregisterConsole(consoleName);
		super.stop();
	}

	@Override
	public void start() {
		ConsoleUtil.registerConsole(consoleName);
		super.start();
	}

	public String getConsoleName() {
		return consoleName;
	}

	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}

}
