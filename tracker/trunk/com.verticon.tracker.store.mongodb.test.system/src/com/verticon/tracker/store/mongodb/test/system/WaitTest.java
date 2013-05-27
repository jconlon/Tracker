package com.verticon.tracker.store.mongodb.test.system;

import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.Test;

public class WaitTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test_Wait() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
	}
}
