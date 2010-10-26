package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.irouter.measurement.logger.internal.MeasurementLoggerConsumer.bundleMarker;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.osgi.util.measurement.State;

import com.verticon.tracker.irouter.measurement.logger.internal.NormalizedTransactionLogger;

public class NormalizingTransactionLoggerTest extends AbstractLoggerTest {

	private static final String TEST_GROUP = "Test group";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.verticon.tracker.irouter.measurement.logger.AbstractLoggerTest#setUp
	 * ()
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		instance = new NormalizedTransactionLogger(TEST_GROUP, new State(1,
				DOCARE_STATE_NAME), logger);

	}

	public void testAggregatingLoggerConstructor() {
		try {
			new NormalizedTransactionLogger(TEST_GROUP, new State(1, "x"),
					null);
			fail("Should have thrown an IllegalArgument Exception");
		} catch (IllegalArgumentException e) {
			// expected
		} catch (Exception e) {
			fail("Should have thrown an IllegalArgument Exception " + e);
		}
		assertNotNull(instance);
	}

	@Test
	public void testTriggerWeight() {
		logger.debug(bundleMarker, "{} ID={}", instance, idEnvelope.getValue());
		logger.info(eq(bundleMarker),
				matches("123456789012345,Test group,100.3"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(transactionStateEnvelope);
	}

	@Test
	public void testTriggerWeightBlood() {
		logger.debug(bundleMarker, "{} ID={}", instance, idEnvelope.getValue());
		logger.info(eq(bundleMarker),
				matches("123456789012345,Test group,100.3,1.999"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}

	@Test
	public void testTriggerWeightWithoutId() {
		logger.info(eq(bundleMarker), matches("null,Test group,100.3"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}

	@Test
	public void testTriggerWeightBloodWithoutId() {
		logger.info(eq(bundleMarker), matches("null,Test group,100.3,1.999"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}

}
