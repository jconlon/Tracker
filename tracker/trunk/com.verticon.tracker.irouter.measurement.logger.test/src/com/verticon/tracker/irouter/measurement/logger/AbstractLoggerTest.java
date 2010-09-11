package com.verticon.tracker.irouter.measurement.logger;

import static com.verticon.tracker.irouter.common.TrackerConstants.ANIMAL_TAG_NUMBER_SCOPE;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRANSACTION_STATE_SCOPE;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.measurement.Unit;

import com.verticon.tracker.irouter.common.ITransactionHandler;

public abstract class AbstractLoggerTest {

	static final String BLOOD_WEIGHT = "bloodWeight";
	static final String ANIMAL_WEIGHT = "animalWeight";
	ITransactionHandler instance = null;
	Envelope mettlerWeightEnvelope = null;
	Envelope animalWeightEnvelope = null;
	Envelope idEnvelope = null;
	Envelope transactionStateEnvelope = null;
	Measurement animalMeasurement;
	Measurement mettlerMeasurement;
	
	
	/**
	 * Create 4 envelopes.
	 * Two weight measurement envelopes, an id envelope,
	 * and a transaction state envelope.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Balance Weight
		mettlerMeasurement = new Measurement(
				1.999, 
				0, 
				Unit.kg, 
				System.currentTimeMillis()
		);
		mettlerWeightEnvelope = new BasicEnvelope(
				mettlerMeasurement,
				"idm", 
				BLOOD_WEIGHT);
		
		
		//Animal Weight
		TimeUnit.SECONDS.sleep(1);//pause to create two different times
		animalMeasurement = new Measurement(
				100.3,  
				0, 
				Unit.kg, 
				System.currentTimeMillis());
		animalWeightEnvelope = new BasicEnvelope(
				animalMeasurement,//value
				"ida", //id
				ANIMAL_WEIGHT//scope
		);
		
		//ID
		idEnvelope = new BasicEnvelope(
				new Long(123456789012345L),
				"idid", 
				ANIMAL_TAG_NUMBER_SCOPE);
		
		//TRANSACTION
		transactionStateEnvelope = new BasicEnvelope(
				new State(1,"doncare"),"idtrans", 
				TRANSACTION_STATE_SCOPE);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		instance = null;
	}

}