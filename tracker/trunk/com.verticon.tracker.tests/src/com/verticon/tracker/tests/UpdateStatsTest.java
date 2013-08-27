package com.verticon.tracker.tests;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import junit.framework.TestCase;

import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.UpdateStats;

public class UpdateStatsTest extends TestCase {

	private static final UpdateStats UPDATESTATS;
	private IUpdateStats instance;

	static {
		UPDATESTATS = new UpdateStats();
		UPDATESTATS.setAnimalsProcessed(2);
		UPDATESTATS.animalsAdded(3);
		UPDATESTATS.eventsAdded(5);
		UPDATESTATS.tagsAdded(4);
		UPDATESTATS.addException(new IllegalStateException("testone"));
		UPDATESTATS.addException(new IOException("testtwo"));
		System.out.println(UPDATESTATS);
	}


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		instance = new UpdateStats(UPDATESTATS.toString());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		instance = null;
	}

	public final void testUpdateStatsString() {
		assertThat("Must not be null", instance, is(notNullValue()));

	}

	public final void testGetEventsAdded() {
		assertThat("Wrong number of Tags Added", instance.getEventsAdded(),
				is(5));
	}

	public final void testGetAnimalsAdded() {
		assertThat("Wrong number of Animals Added",
				instance.getAnimalsAdded(), is(3));
	}

	public final void testGetTagsAdded() {
		assertThat("Wrong number of Tags Added",
				instance.getTagsAdded(), is(4));
	}

	public final void testGetAnimalsProcessed() {
		assertThat("Wrong number of Animals Processed",
				instance.getAnimalsProcessed(), is(2));
	}

	public final void testGetExceptions() {
		assertThat("Wrong number of Exceptions", instance.getExceptions()
				.size(), is(2));
		assertEquals("Instance and template must be equal", instance,
				UPDATESTATS);
	}


}
