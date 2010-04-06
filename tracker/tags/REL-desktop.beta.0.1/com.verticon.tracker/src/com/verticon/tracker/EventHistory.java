package com.verticon.tracker;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;

/**
 * Provides a history of events.
 * @author jconlon
 *
 */
public interface EventHistory {

	/**
	 * 
	 * @return List of Events
	 */
	EList<Event> eventHistory();
	
	void setForwarding(Adapter adapter);
}
