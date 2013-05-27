package com.verticon.tracker.store.mongodb.internal;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;

import com.verticon.tracker.store.IUpdateStats;

public class UpdateStats implements IUpdateStats {

	private int animalsProcessed;

	private int animalsAdded;
	private int tagsAdded;
	private int eventsAdded;

	private final Collection<Exception> exceptions = newArrayList();

	UpdateStats() {
		this(0, 0, 0);
	}
	UpdateStats(int animalsAdded, int tagsAdded, int eventsAdded) {
		super();
		this.animalsAdded = animalsAdded;
		this.tagsAdded = tagsAdded;
		this.eventsAdded = eventsAdded;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getEventsAdded()
	 */
	@Override
	public int getEventsAdded() {
		return eventsAdded;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getAnimalsAdded()
	 */
	@Override
	public int getAnimalsAdded() {
		return animalsAdded;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getTagsAdded()
	 */
	@Override
	public int getTagsAdded() {
		return tagsAdded;
	}
	

	void animalsAdded(int count) {
		animalsAdded = animalsAdded + count;
	}

	void tagsAdded(int count) {
		tagsAdded = tagsAdded + count;
	}

	void eventsAdded(int count) {
		eventsAdded = eventsAdded + count;
	}

	void addException(Exception exception) {
		exceptions.add(exception);
	}
	
	/**
	 * @param animalsProcessed
	 *            the animalsProcessed to set
	 */
	void setAnimalsProcessed(int animalsProcessed) {
		this.animalsProcessed = animalsProcessed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateStats [animalsProcessed=" + animalsProcessed
				+ ", animalsAdded=" + animalsAdded + ", tagsAdded=" + tagsAdded
				+ ", eventsAdded=" + eventsAdded + ", exceptions=" + exceptions
				+ "]";
	}
	@Override
	public int getAnimalsProcessed() {
		return animalsProcessed;
	}

	@Override
	public Collection<Exception> getExceptions() {
		return exceptions;
	}

}
