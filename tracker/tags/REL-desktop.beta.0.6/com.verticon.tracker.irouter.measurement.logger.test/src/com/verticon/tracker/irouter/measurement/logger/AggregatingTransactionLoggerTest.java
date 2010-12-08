/**
 * 
 */
package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.irouter.measurement.logger.internal.MeasurementLoggerConsumer.bundleMarker;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;

import com.verticon.tracker.irouter.measurement.logger.internal.AggregatedTransactionLogger;



/**
 * 
 * The AggregatedTransactionLogger will cache multiple measurements, 
 * and an id until a 'transaction.state' triggers the logging of multiple
 * log entries, each entry looking like this.
	 
	"type='measurement'," +
	"dateTime='%1$tF %1$tT'," +
	"id='%2$s',scope='%3$s'," +
	"value='%4$.4f'," +
	"error='%5$.4f'," +
	"unit='%6$s'";
 * 
 * @author jconlon
 *
 */
public class AggregatingTransactionLoggerTest extends AbstractLoggerTest {
	

	private static final String NULL_ID_ANIMALWEIGHT_MATCHER = 
		"type='measurement',dateTime='.*',id='null',scope='animalWeight',value='100.3000',error='0.0000',unit='kg'";
	
	private static final String NULL_ID_BLOODWEIGHT_MATCHER = 
		"type='measurement',dateTime='.*',id='null',scope='bloodWeight',value='1.9990',error='0.0000',unit='kg'";
	
	private static final String ANIMALWEIGHT_MATCHER = 
		"type='measurement',dateTime='.*',id='123456789012345',scope='animalWeight',value='100.3000',error='0.0000',unit='kg'";
	
	private static final String BLOODWEIGHT_MATCHER = 
		"type='measurement',dateTime='.*',id='123456789012345',scope='bloodWeight',value='1.9990',error='0.0000',unit='kg'";
	
		
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.irouter.measurement.logger.AbstractLoggerTest#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		instance = new AggregatedTransactionLogger(logger, new State(1,DOCARE_STATE_NAME));
	}

	@Test
	public void testAggregatingLoggerConstructor() {
		try {
			new AggregatedTransactionLogger(null,new State(1,"some.state"));
			fail("Should have thrown an IllegalArgument Exception");
		} catch (IllegalArgumentException e) {
			//expected
		} catch (Exception e){
			fail("Should have thrown an IllegalArgument Exception "+e);
		}
		Logger logger = createMock(Logger.class);
		instance = new AggregatedTransactionLogger(logger,new State(1,"some.state"));
		assertNotNull(instance);
	}

	/**
	 * Add the two measurements and the id, but don't trigger
	 * the logging.
	 * 
	 * Just will log the id as debug.
	 */
	@Test
	public void testAddWithNoTrigger() {
		logger.debug(bundleMarker,"{} ID={}",
				instance,idEnvelope.getValue());
		assertNotNull(instance);
		replay(logger);
		
		
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(mettlerWeightEnvelope);
	}
	
	
	@Test
	public void testTriggerWeight() {
		logger.debug(bundleMarker,"{} ID={}",
				instance,idEnvelope.getValue());
		logger.info(eq(bundleMarker),matches(ANIMALWEIGHT_MATCHER));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightBlood() {
		logger.debug(bundleMarker,"{} ID={}",
				instance,idEnvelope.getValue());
		logger.info(eq(bundleMarker),matches(ANIMALWEIGHT_MATCHER));
		logger.info(eq(bundleMarker),matches(BLOODWEIGHT_MATCHER));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(idEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightWithoutId() {
		logger.info(eq(bundleMarker),matches(NULL_ID_ANIMALWEIGHT_MATCHER));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testTriggerWeightBloodWithoutId() {
		logger.info(eq(bundleMarker),matches(NULL_ID_ANIMALWEIGHT_MATCHER));
		logger.info(eq(bundleMarker),matches(NULL_ID_BLOODWEIGHT_MATCHER));
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(mettlerWeightEnvelope);
		instance.add(transactionStateEnvelope);
	}
	
	@Test
	public void testGet() {
		assertNotNull(instance);
		replay(logger);
		instance.add(animalWeightEnvelope);
		instance.add(mettlerWeightEnvelope);
		Measurement m =instance.get(BLOOD_WEIGHT);
		assertEquals(mettlerMeasurement, m);
	}
	
	@Test
	public void testGetAfterTriggered() {
		testTriggerWeightBloodWithoutId();
		Measurement m =instance.get(BLOOD_WEIGHT);
		assertNull("Measurement should be null after triggered",m);
	}

}
