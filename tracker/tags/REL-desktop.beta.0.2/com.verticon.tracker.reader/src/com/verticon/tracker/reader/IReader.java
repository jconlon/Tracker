/**
 * 
 */
package com.verticon.tracker.reader;

import java.beans.PropertyChangeListener;
import java.net.URI;

/**
 * A publisher of TagId numbers.
 * 
 * @author jconlon
 * 
 */
public interface IReader {

	/**
	 * Starts and Stops the IPublisher
	 * 
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
	 * 
	 * @param target
	 *            an implementation specific focal point of activity.
	 */
	void setTarget(URI target);

	URI getTarget();

	/**
	 * 
	 * @param template
	 *            Path to an AnimalDocument File used as an event Template
	 */
	void setTemplate(String template);

	String getTemplate();

	/**
	 * 
	 * @return the simplified class name of the IPublisher
	 */
	String getType();
	
	public void addPropertyChangeListener(PropertyChangeListener listener) ;

	

	public void removePropertyChangeListener(PropertyChangeListener listener) ;

	

}
