package com.verticon.tracker.irouter.measurement.logger;
import static com.verticon.tracker.irouter.measurement.logger.internal.ComponentFactory.bundleMarker;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;

import com.verticon.tracker.irouter.measurement.logger.internal.NormalizedTransactionLogger;


public class NormalizingTransactionLoggerTest extends AbstractLoggerTest{

	private static final String TEST_GROUP = "Test group";

	
	public void testAggregatingLoggerConstructor() {
		try {
			new NormalizedTransactionLogger(TEST_GROUP,null);
			fail("Should have thrown an IllegalArgument Exception");
		} catch (IllegalArgumentException e) {
			//expected
		} catch (Exception e){
			fail("Should have thrown an IllegalArgument Exception "+e);
		}
		Logger logger = createMock(Logger.class);
		instance = new NormalizedTransactionLogger(TEST_GROUP,logger);
		assertNotNull(instance);
	}
	
	
	@Test
	public void testTriggerWeight() {
		Logger logger = createMock(Logger.class);
		instance = new NormalizedTransactionLogger(TEST_GROUP, logger);
		logger.debug(bundleMarker,"{} ID={}",
				instance,idEnvelope.getValue());
		logger.info(eq(bundleMarker),matches("123456789012345,Test group,100.3"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightBlood() {
		Logger logger = createMock(Logger.class);
		instance = new NormalizedTransactionLogger(TEST_GROUP, logger);
		logger.debug(bundleMarker,"{} ID={}",
				instance,idEnvelope.getValue());
		logger.info(eq(bundleMarker),matches("123456789012345,Test group,100.3,1.999"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightWithoutId() {
		Logger logger = createMock(Logger.class);
		instance = new NormalizedTransactionLogger(TEST_GROUP, logger);
		logger.info(eq(bundleMarker),matches("null,Test group,100.3"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightBloodWithoutId() {
		Logger logger = createMock(Logger.class);
		instance = new NormalizedTransactionLogger(TEST_GROUP, logger);
		logger.info(eq(bundleMarker),matches("null,Test group,100.3,1.999"));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}

	
}
