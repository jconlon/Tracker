/**
 * 
 */
package com.verticon.tracker.transaction.publisher;



/**
 * A publisher of TagId numbers. 
 * 
 * @author jconlon
 *
 */
public interface IPublisher {

	/**
	 * Starts and Stops the IPublisher 
	 * @param start
	 */
	void setStarted(boolean start);
	
	/**
	 * 
	 * @return started status
	 */
	boolean isStarted();
	
	
	String getName();
	void setName(String name);
	
	/**
	 * Set the target of the IPublisher.
	 * @param target an implementation specific focal point of activity.
	 */
	void setTarget(String target);
	String getTarget();
	
	
	/**
	 * 
	 * @param template Path to an AnimalDocument File used as an event Template
	 */
	void setTemplate(String template);
	String getTemplate();
	

	/**
	 * 
	 * @return the simplified class name of the IPublisher
	 */
	String getType();
	
}
