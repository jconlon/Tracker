/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store.mongodb.test.system;

import static com.verticon.tracker.store.mongodb.test.system.Configurator.bundleMarker;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.hamcrest.CoreMatchers;
import org.osgi.framework.BundleContext;
import org.osgi.service.monitor.Monitorable;
import org.osgi.service.wireadmin.BasicEnvelope;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.osgi.util.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.tracker.Animal;
import com.verticon.tracker.BovineBison;
import com.verticon.tracker.Caprine;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.store.ITrackerFind;
import com.verticon.tracker.store.Query;
import com.verticon.tracker.store.TrackerStoreUtils;

/**
 * iRouter testing of the com.verticon.tracker.store.mongo component and its
 * primary class for delievering that functionality the MongoConsumer.
 * 
 * This class tests functionality of the WireAdmin Consumer service implemented
 * by c.v.t.store.mongo.MongoConsumer. MongoConsumer consumes Envelopes
 * containing Animals, Tags, Measurement, and Position payloads.
 * 
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>ITrackerStore</li>
 * <li>ConfigurationAdmin</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * Tests a mock Producer sending Tags to the Consumer implemented by the
 * TrackerStoreImpl
 * 
 * @author jconlon
 * 
 */
public class Test_MongoDB_ProducerConsumer extends TestCase implements
		IConsumerListener {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_MongoDB_ProducerConsumer.class);
	private static final String AIN_1 = "tag1";
	private static final String AIN_2 = "tag2";
	private static final String AIN_3 = "tag3";

	private static final String ANIMAL_SCOPE = "premises.animal";
	private static final String TAG_SCOPE = "premises.tag";
	private static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
	private static final String POSITION_SCOPE = "gps.position";
	private static final String METTLER_WEIGHT_SCOPE = "mettler.weight";

	//
	private static final String STATUS = "consumer.Connection_Status";
	//
	private static final String TAGS_ADDED = "consumer.Tags_Added";
	//
	private static final String ANIMALS_ADDED = "consumer.Animals_Added";
	//
	private static final String EVENTS_ADDED = "consumer.Events_Added";
	//
	private static final String ANIMALS_PROCESSED = "consumer.Animals_Processed";
	//
	private static final String PRODUCTS_CONSUMED = "consumer.Products_Consumed";
	private static final String EXCEPTIONS = "consumer.Exception_Count";

	private static final CyclicBarrier mockProductConsumedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected service
	 */
	private static ITrackerFind trackerFind;
	private static IProducerConsumer producerConsumer;
	private static Monitorable monitorable;
	/**
	 * This class is a JUnit class and a DS component. There needs to be a
	 * synchronization between the DS and JUnit initializations. This is done
	 * with a java.util.concurrent.CountDownLatch.
	 * 
	 * In the JUnit setUp() method the startUpGate.await() will be called which
	 * will block until all DS services are injected. When all services are
	 * injected and DS calls the startup() method startUpGate.countDown() is
	 * called unblocking the thread waiting in the setUp(). Once tripped the
	 * latch lets subsequent calls through.
	 */
	private static final CountDownLatch startUpGate = new CountDownLatch(1);

	/**
	 * 
	 * Called by the test framework to setup the test case. This method will
	 * block at a startupGate waiting for the ITrackerStore service under test
	 * to be injected by DS.
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		startUpGate.await();// wait for startUp to finish
		producerConsumer.clearSendCount();
		resetStatus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * On activation of this component this method is called.
	 * 
	 * @param context
	 */
	void activate(BundleContext context) {
		logger.debug(bundleMarker, "Activating");
		startUpGate.countDown();

	}

	void deactivate() {
		logger.debug(bundleMarker, "DEActivating");

	}

	/**
	 * Injected by ds
	 * 
	 * @param trackerFind
	 */
	void setTrackerFind(ITrackerFind trackerFind) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_MongoDB_ProducerConsumer.trackerFind = trackerFind;
	}

	void unsetTrackerFind(ITrackerFind trackerFind) {
		logger.debug(bundleMarker, "DS injecting the trackerStore");
		Test_MongoDB_ProducerConsumer.trackerFind = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	void setMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_MongoDB_ProducerConsumer.monitorable = monitorable;
	}

	/**
	 * Injected by ds
	 * 
	 * @param monitorable
	 */
	void unsetMonitorable(Monitorable monitorable) {
		logger.debug(bundleMarker, "DS injecting the monitorable");
		Test_MongoDB_ProducerConsumer.monitorable = null;
	}

	/**
	 * Injected by ds
	 * 
	 * @param producerConsumer
	 */
	void setController(IProducerConsumer producerConsumer) {
		logger.debug(bundleMarker, "DS injecting the producerConsumer");
		Test_MongoDB_ProducerConsumer.producerConsumer = producerConsumer;
		producerConsumer.setListener(this);
	}

	/**
	 * Injected by ds
	 * 
	 * @param producerConsumer
	 */
	void unsetController(IProducerConsumer producerConsumer) {
		logger.debug(bundleMarker, "DS injecting the producerConsumer");
		Test_MongoDB_ProducerConsumer.producerConsumer = null;
		producerConsumer.setListener(null);
	}

	public void testConsumer()
			throws InterruptedException, BrokenBarrierException, IOException {
		logger.debug(bundleMarker, "Animal_Sighting_ForNewAnimal");

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		assertThat("Must have a status", monitorable.getStatusVariable(STATUS)
				.getString(), is(notNullValue()));

		assertThat("Must be Activated  status",
				monitorable.getStatusVariable(STATUS).getString(),
				is(startsWith("Activated ")));

		Tag tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_3);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		Animal animalNew = TrackerFactory.eINSTANCE.createCaprine();
		animalNew.getTags().add(tag);

		Envelope envelope = new BasicEnvelope(animalNew, AIN_1, ANIMAL_SCOPE);

		producerConsumer.send(envelope);

		assertThat("Controller must have sent the envelope",
				producerConsumer.sentCount(), is(1));

		assertThat("Wrong number of products consumed.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat(
				"Must have no exceptions: "
						+ monitorable.getStatusVariable(STATUS).getString(),
				monitorable.getStatusVariable(EXCEPTIONS).getInteger(), is(0));

		assertThat("Wrong number of animals processed.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		assertThat("Wrong number of animals added.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(1));

		Animal animal = trackerFind.retrieveAnimal(AIN_3);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be one event", animal.eventHistory().size(),
				is(1));
		assertThat("Animal must be a Caprine", animal,
				is(instanceOf(Caprine.class)));


		//
		logger.debug(bundleMarker, "Tag_Sighting_ForNewAnimal");
		producerConsumer.clearSendCount();
		resetStatus();

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_1);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createSighting());
		envelope = new BasicEnvelope(tag, AIN_1, TAG_SCOPE);
		producerConsumer.send(envelope);

		assertThat("Controller must have sent the envelope",
				producerConsumer.sentCount(), is(1));

		assertThat("Wrong number of products consumed.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat(
				"Must have no exceptions: "
						+ monitorable.getStatusVariable(STATUS).getString(),
				monitorable.getStatusVariable(EXCEPTIONS).getInteger(), is(0));

		assertThat("Wrong number of animals processed.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		assertThat("Wrong number of animals added.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(1));

		animal = trackerFind.retrieveAnimal(AIN_1);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be one event", animal.eventHistory().size(),
				is(1));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));


		//
		logger.debug(bundleMarker, "Tag_Position_ForExistingAnimal");
		producerConsumer.clearSendCount();
		resetStatus();

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_1);
		tag.getEvents().add(TrackerFactory.eINSTANCE.createPosition());
		envelope = new BasicEnvelope(tag, AIN_1, TAG_SCOPE);
		producerConsumer.send(envelope);// should find the tag and add an event

		assertThat("Controller must have sent the envelope",
				producerConsumer.sentCount(), is(1));

		assertThat("Wrong number of products consumed.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat(
				"Encounted exceptions: "
						+ monitorable.getStatusVariable(STATUS).getString(),
				monitorable.getStatusVariable(EXCEPTIONS).getInteger(), is(0));

		assertThat("Wrong number of animals processed.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		assertThat("Wrong number of animals added.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));

		animal = trackerFind.retrieveAnimal(AIN_1);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("There must be one tag", animal.getTags().size(), is(1));
		assertThat("There must be two events", animal.eventHistory().size(),
				is(2));


		//
		logger.debug(bundleMarker, "Tag_ReplaceTag");
		producerConsumer.clearSendCount();
		resetStatus();

		assertThat("Controller must be connected to the consumer.",
				producerConsumer.hasWires(), is(true));

		tag = TrackerFactory.eINSTANCE.createTag();
		tag.setId(AIN_2);
		ReplacedTag rt = TrackerFactory.eINSTANCE.createReplacedTag();
		Tag tagOld = TrackerFactory.eINSTANCE.createTag();
		tagOld.setId(AIN_1);
		rt.setOldTag(tagOld);
		tag.getEvents().add(rt);
		envelope = new BasicEnvelope(tag, AIN_2, TAG_SCOPE);
		producerConsumer.send(envelope);

		assertThat("Must have processed one animal after the reset.",
				monitorable.getStatusVariable(ANIMALS_PROCESSED).getInteger(),
				is(1));
		assertThat("Must have not added as a new animal.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));
		assertThat("Must have updated an existing animal.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));


		//
		logger.debug(bundleMarker, "RetrieveOldAnimalWithTwoTags");
		producerConsumer.clearSendCount();
		resetStatus();
		assertThat("Controller must be connected to the consumer.",
				producerConsumer.hasWires(), is(true));

		animal = trackerFind.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There should be two tags", animal.getTags().size(), is(2));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("There must be three events", animal.eventHistory().size(),
				is(3));

		assertThat("Old tag should still be persisted.",
				trackerFind.retrieveAnimal(AIN_1), is(notNullValue()));

		assertThat("Animal should NOT have a container", animal.eContainer(),
				is(nullValue()));


		//
		logger.debug(bundleMarker, "Tag_ExistingEvents");
		producerConsumer.clearSendCount();
		resetStatus();
		assertThat("Controller must be connected to the consumer.",
				producerConsumer.hasWires(), is(true));

		animal = trackerFind.retrieveAnimal(AIN_2);
		assertThat("Animal must not be null", animal, is(notNullValue()));
		assertThat("Animal must have 2 tags", animal.getTags().size(), is(2));
		// Retrieve the tag and copy it
		tag = animal.activeTag();
		tag = EcoreUtil.copy(tag);
		envelope = new BasicEnvelope(tag, AIN_2, TAG_SCOPE);
		producerConsumer.send(envelope);
		assertThat("Must have NOT processed an animal after the reset.",
				monitorable.getStatusVariable(ANIMALS_PROCESSED).getInteger(),
				is(0));
		assertThat("Must have not added as a new animal.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));

		// // Envelope tests follow
		//
		/*
		 * Measurement Envelopes with scopes of animal.weight will be added as
		 * WeighIn events
		 */
		//
		logger.debug(bundleMarker, "Measurement_WeighIn");
		producerConsumer.clearSendCount();
		resetStatus();

		Measurement value = new Measurement(100, .1, Unit.kg,
				new Date().getTime());
		envelope = new BasicEnvelope(value, AIN_2, ANIMAL_WEIGHT_SCOPE);

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		producerConsumer.send(envelope);

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat("Must have processed one animal.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		animal = trackerFind.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be four events", animal.eventHistory().size(),
				is(4));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a WeighIn",
				animal.eventHistory().get(3), is(instanceOf(WeighIn.class)));
		WeighIn wi = (WeighIn) animal.eventHistory().get(3);
		assertThat("Weight must be 100", wi.getWeight(), is(100d));

		/*
		 * Position Envelopes are sent as Position events Envelope scope is
		 * gps.position
		 */
		//
		logger.debug(bundleMarker, "Consumer_Position");

		producerConsumer.clearSendCount();
		resetStatus();

		Measurement lat = new Measurement(Math.toRadians(45), .1, Unit.rad,
				new Date().getTime());
		Measurement longi = new Measurement(Math.toRadians(45), .1, Unit.rad,
				new Date().getTime());
		Position position = new Position(lat, longi, null, null, null);

		envelope = new BasicEnvelope(position, AIN_2, POSITION_SCOPE);

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		producerConsumer.send(envelope);

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));
		assertThat("Must have updated one animal.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat("Must have processed one animal.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		animal = trackerFind.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be five events", animal.eventHistory().size(),
				is(5));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a Position", animal.eventHistory()
				.get(4), is(instanceOf(com.verticon.tracker.Position.class)));
		com.verticon.tracker.Position posi = (com.verticon.tracker.Position) animal
				.eventHistory().get(4);
		double degrees = 45;// Math.toDegrees(44);
		assertThat("Latitude must be 45", posi.getLatitude(), is(degrees));

		/*
		 * Measurements Envelopes are sent as GenericEvent events with scope
		 * equal to the id of the OCD. Must already have a OCD loaded in the OCD
		 * collection for this to pass
		 */
		//
		logger.debug(bundleMarker, "Measurement_GenericEvent");

		producerConsumer.clearSendCount();
		resetStatus();

		value = new Measurement(100, .1, Unit.kg,
				new Date().getTime());
		envelope = new BasicEnvelope(value, AIN_2,
				METTLER_WEIGHT_SCOPE);

		assertThat("Controller must have wires", producerConsumer.hasWires(),
				is(true));

		producerConsumer.send(envelope);
		TimeUnit.SECONDS.sleep(2);

		assertThat("Wrong number of products consumed.", monitorable
				.getStatusVariable(PRODUCTS_CONSUMED).getInteger(), is(1));

		assertThat(
				"Must have no exceptions: "
						+ monitorable.getStatusVariable(STATUS).getString(),
				monitorable.getStatusVariable(EXCEPTIONS).getInteger(), is(0));

		assertThat("Wrong number of animals processed.", monitorable
				.getStatusVariable(ANIMALS_PROCESSED).getInteger(), is(1));

		assertThat("Must have added NO animals.", monitorable
				.getStatusVariable(ANIMALS_ADDED).getInteger(), is(0));

		animal = trackerFind.retrieveAnimal(AIN_2);
		assertThat("Animal should not be null", animal, is(notNullValue()));
		assertThat("There must be two tag", animal.getTags().size(), is(2));
		assertThat("There must be six events", animal.eventHistory().size(),
				is(6));
		assertThat("Animal must be a Bison", animal,
				is(instanceOf(BovineBison.class)));

		assertThat("Last event must be a GenericEvent", animal.eventHistory()
				.get(5), is(instanceOf(GenericEvent.class)));
		GenericEvent ge = (GenericEvent) animal.eventHistory().get(5);
		assertThat("No ocd", ge.getOcd(), is(notNullValue()));
		assertThat("Incorrect ocd", ge.getOcd().getID(),
				is(METTLER_WEIGHT_SCOPE));
		EMap<String, String> map = ge.getEventAttributes();
		assertThat("No attributes", map, is(notNullValue()));
		String bloodWeight = map.get("Blood Weight");
		assertThat("No bw attribute", bloodWeight, is(notNullValue()));
		assertThat("BW is wrong", bloodWeight, is("100.0"));

		String precision = map.get("Measurement Precision");
		assertThat("No bw attribute", precision, is(notNullValue()));
		assertThat("BW is wrong", precision, is("0.1"));

		//
		logger.debug(bundleMarker, "Retrieve_Premises");
		producerConsumer.clearSendCount();
		resetStatus();

		String pin = "urn:pin:003ALKM";
		// Query for a premises
		envelope = new BasicEnvelope(
Query.RETRIEVE_PREMISES_TEMPLATE
				.replace(pin).getBytes(),
				"Agriculture/Premises/" + pin + "/Query",
				"agriculture.premises.query");
		producerConsumer.send(envelope);

		logger.debug(bundleMarker, "Waiting for product");
		try {
			mockProductConsumedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for product.");
		}

		assertThat("Must have one message", producerConsumer
				.getConsumedProducts().size(), is(1));
		Entry<String, Object> productEntry = Iterables.get(producerConsumer
				.getConsumedProducts().entrySet(), 0);
		String scopes = productEntry.getKey();
		assertThat("Wrong scopes for received message", scopes,
				is("[agriculture.premises.response]"));

		envelope = (Envelope) productEntry.getValue();
		assertEquals("Wrong id for consumed", 
 "Agriculture/Premises/" + pin
				+ "/Response", envelope.getIdentification());

		byte[] payload = (byte[]) envelope.getValue();

		List<EObject> eobList = TrackerStoreUtils.toEObject(payload);
		assertThat("Must have one value", eobList.size(), is(1));
		EObject eob = Iterables.get(eobList, 0);

		// String value = new String(payload);
		assertThat("Must have a Premises", eob, is(instanceOf(Premises.class)));
		Premises premises = (Premises) eob;
		assertThat("Wrong uri", premises.getUri(), is(pin));

		/*
		 * Query for ain 840003002956353
		 */
		//
		logger.debug(bundleMarker, "Retrieve_Animal");

		producerConsumer.clearSendCount();
		resetStatus();

		String ain = "840003002956353";
		pin = "urn:pin:003ALKM";
		// Query for a premises
		envelope = new BasicEnvelope(
				Query.RETRIEVE_ANIMAL_TEMPLATE.replace(ain),
				"Agriculture/Premises/" + pin + "/Query",
				"agriculture.premises.query");
		producerConsumer.send(envelope);

		logger.debug(bundleMarker, "Waiting for product");
		try {
			mockProductConsumedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for product.");
		}

		assertThat("Must have one message", producerConsumer
				.getConsumedProducts().size(), is(1));
		productEntry = Iterables.get(producerConsumer
				.getConsumedProducts().entrySet(), 0);
		scopes = productEntry.getKey();
		assertThat("Wrong scopes for received message", scopes,
				is("[agriculture.premises.response]"));

		envelope = (Envelope) productEntry.getValue();
		assertEquals("Wrong id for consumed", "Agriculture/Premises/" + pin
				+ "/Response", envelope.getIdentification());

		payload = (byte[]) envelope.getValue();
		assertThat("Payload must not be empty", payload, is(notNullValue()));
		assertThat("Payload must contain bytes.", true,
				is(CoreMatchers.is(payload.length > 10)));
		eobList = TrackerStoreUtils.toEObject(payload);
		assertThat("Must have one value", eobList.size(), is(1));
		eob = Iterables.get(eobList, 0);

		assertThat("Must have a Animal", eob, is(instanceOf(Animal.class)));
		animal = (Animal) eob;
		assertThat("Wrong uri", animal.activeTag().getId(), is(ain));

	}

	private void resetStatus() {
		monitorable.resetStatusVariable(ANIMALS_ADDED);
		monitorable.resetStatusVariable(PRODUCTS_CONSUMED);
		monitorable.resetStatusVariable(ANIMALS_PROCESSED);
		monitorable.resetStatusVariable(TAGS_ADDED);
		monitorable.resetStatusVariable(EVENTS_ADDED);

	}

	@Override
	public void productConsumed() {
		logger.debug(bundleMarker, "Product consumed by MockConsumer");
		try {
			mockProductConsumedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}
}
