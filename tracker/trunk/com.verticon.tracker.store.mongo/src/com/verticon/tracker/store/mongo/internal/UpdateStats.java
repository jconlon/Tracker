package com.verticon.tracker.store.mongo.internal;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;

import com.verticon.tracker.store.IUpdateStats;

public class UpdateStats implements IUpdateStats {

	private int animalsAdded;
	private int tagsAdded;
	private int eventsAdded;
	private int exceptionCount;
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

	void exceptionsEncounted(int count) {
		exceptionCount = exceptionCount + count;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateStats [animalsAdded=" + animalsAdded + ", tagsAdded="
				+ tagsAdded + ", eventsAdded=" + eventsAdded + "]";
	}

	@Override
	public int getAnimalsProcessed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Exception> getExceptions() {
		return exceptions;
	}

}
