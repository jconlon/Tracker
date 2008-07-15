/**
 * 
 */
package com.verticon.tracker.transaction.publisher;

import java.io.IOException;


/**
 * A Publisher can be started, stopped and a logStatus can be output to the Console
 * @author jconlon
 *
 */
public interface Publisher {

	void start()throws IOException;
	void stop();
	void logStatus();
	
//	Image getColumnImage(int index);
//	String getColumnText(int index);
	
	String getName();
	String getDescription();
	String getStatus();
	String getTarget();
	String getTemplate();
}
