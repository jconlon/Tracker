/**
 * 
 */
package com.verticon.tracker.reader.event.connection;

/**
 * 
 * A task associated with a user interface may need to be updated
 * after completing or being canceled.
 * 
 * @author jconlon
 *
 */
public interface RefreshablePublisher {
	void refresh();
	void publish(Long tag);
}
