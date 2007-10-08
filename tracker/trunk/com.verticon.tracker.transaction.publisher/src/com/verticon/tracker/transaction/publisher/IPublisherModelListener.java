package com.verticon.tracker.transaction.publisher;



/**
 * Listener to changes on a model of IPublishers
 * 
 * @see PublisherViewModel
 * @author jconlon
 *
 */
public interface IPublisherModelListener {
	
	/**
	 * Reflect the fact that a IPublisher was added 
	 * to the IPublisher Model
	 * 
	 * @param publisher
	 */
	public void addPublisher(IPublisher publisher);
	
	/**
	 * Update the view to reflect the fact that a IPublisher was removed 
	 * from the IPublisher Model
	 * 
	 * @param publisher
	 */
	public void removePublisher(IPublisher publisher);
	
	/**
	 * Update the view to reflect the fact that one of the IPublishers
	 * was modified in the IPublisher Model
	 * 
	 * @param publisher
	 */
	public void updatePublisher(IPublisher publisher);
}
