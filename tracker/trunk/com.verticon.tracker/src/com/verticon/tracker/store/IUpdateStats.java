package com.verticon.tracker.store;

import java.util.Collection;

public interface IUpdateStats {

	/**
	 * @return the eventsAdded
	 */
	public int getEventsAdded();

	/**
	 * @return the animalsAdded
	 */
	public int getAnimalsAdded();

	/**
	 * @return the tagsAdded
	 */
	public int getTagsAdded();

	/**
	 * 
	 * @return exceptions encountered
	 */
	public Collection<Exception> getExceptions();

	/**
	 * 
	 * @return number of animals processed
	 */
	public int getAnimalsProcessed();

	/**
	 * 
	 * @return pretty string describing the stats
	 */
	public String prettyPrint();

	public abstract String serializeExceptions();


}