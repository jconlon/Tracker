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

	public Collection<Exception> getExceptions();

	public int getAnimalsProcessed();

}