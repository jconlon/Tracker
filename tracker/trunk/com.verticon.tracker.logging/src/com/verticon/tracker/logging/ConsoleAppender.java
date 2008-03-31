/**
 * 
 */
package com.verticon.tracker.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.ui.PlatformUI;

/**
 * @author jconlon
 *
 */
public class ConsoleAppender extends AppenderSkeleton {
	

	private String consoleName;
	
	
	@Override
	public void activateOptions() {
		super.activateOptions();
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
	 */
	protected void appendInternal(LoggingEvent event) {
		 String message = this.layout.format(event);
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
	protected void append(final LoggingEvent event){
		
		PlatformUI.getWorkbench().getDisplay().asyncExec (new Runnable () {
	      public void run () {
	    	  appendInternal(event);
	      }
	   });
	
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#close()
	 */
	@Override
	public void close() {
		ConsoleUtil.unregisterConsole(consoleName);
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.AppenderSkeleton#requiresLayout()
	 */
	@Override
	public boolean requiresLayout() {
		return true;
	}

	public String getConsoleName() {
		return consoleName;
	}

	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}
	
	
}
