/*******************************************************************************
 * 
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store.mqtt.test.system;


import static com.google.common.collect.Lists.newArrayList;
import static com.verticon.tracker.store.mqtt.test.system.Configurator.PREMISES_URI_H89234X;
import static com.verticon.tracker.store.mqtt.test.system.Configurator.bundleMarker;
import static com.verticon.tracker.store.mqtt.test.system.Configurator.getXMIResource;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.verticon.osgi.metatype.OCD;
import com.verticon.tracker.Animal;
import com.verticon.tracker.AnimalType;
import com.verticon.tracker.Event;
import com.verticon.tracker.GenericEvent;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.store.ITrackerStore;
import com.verticon.tracker.store.IUpdateStats;
import com.verticon.tracker.store.TrackerStoreUtils;

/**
 * 
 * Basic testing of an com.verticon.tracker.store.mongodb service and its
 * dependent services.
 * 
 * Depends on Declarative service to inject the following services;
 * <ol>
 * <li>IMongoClientProvider</li>
 * <li>IFunctionProvider</li>
 * </ol>
 * 
 * This system test uses both JUnit Plugin framework and a Declarative Services
 * specification to inject the ITrackerStore. Use of both of these frameworks
 * require synchronization of the initialization of the injected services and
 * the test setup. To accomplish this a CountDownLatch is used.
 * 
 * 
 * @author jconlon
 * 
 */
public class Test_TrackerStore_1 extends TestCase implements
		ISubscriberListener {

	static final String DOC_PREMISES = "example.premises";
	private static final String TAG_ID_2 = "abcd";
	static final String TAG_ID_1 = "1234567890";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(Test_TrackerStore_1.class);

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

	// private static final CountDownLatch messageReceivedGate = new
	// CountDownLatch(
	// 1);

	private static final CyclicBarrier messageReceivedBarrier = new CyclicBarrier(
			2);

	/**
	 * Injected services
	 */
	static ITrackerStore trackerStore;
	static ISubscriber subscriber;

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void setTrackerStore(ITrackerStore trackerStore) {
		Test_TrackerStore_1.trackerStore = trackerStore;
	}

	/**
	 * Injected by ds
	 * 
	 * 
	 */
	void unsetTrackerStore(ITrackerStore trackerStore) {
		Test_TrackerStore_1.trackerStore = null;
	}

	void setSubscriber(ISubscriber subscriber) {
		Test_TrackerStore_1.subscriber = subscriber;
		subscriber.setListener(this);
	}

	void unsetSubscriber(ISubscriber subscriber) {
		logger.debug(bundleMarker, "DS removing the subscriber");
		subscriber.setListener(null);
		Test_TrackerStore_1.subscriber = null;

	}

// void setMockAuthenticatorController(
	// IMockAuthenticatorController mockAuthenticatorController) {
	// Test_TrackerStore_1.mockAuthenticatorController =
	// mockAuthenticatorController;
	// }

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
	 */
	void activate() {
		startUpGate.countDown();
		logger.debug(bundleMarker, "Activate.");
	}

	void deactivate() {
		logger.debug(bundleMarker, "DeActivated.");
	}

	/**
	 * Test authorization and set it
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws BrokenBarrierException
	 */
	@Test
	public void test_Register() throws IOException, InterruptedException,
			BrokenBarrierException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		assertThat("URI must be urn:pin:H89234X", premises.getUri(),
				is(PREMISES_URI_H89234X));
		logger.debug(bundleMarker, "Registering premises {}", premises.getUri());
		trackerStore.register(premises);
		logger.debug(bundleMarker, "Waiting for message");
		try {
			messageReceivedBarrier.await(3, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			fail("Timed out wait for message.");
		}

		assertThat("Must have one message", subscriber.messages().size(), is(1));
		Entry<String, MqttMessage> messageEntry = Iterables.get(subscriber
				.messages().entrySet(), 0);
		String topicName = messageEntry.getKey();
		MqttMessage message = messageEntry.getValue();
		byte[] payload = message.getPayload();
		List<EObject> eObjects = toEObject(payload);
		assertThat("Must have one eObject", eObjects.size(), is(1));
		assertThat("Must be a premises", eObjects.get(0),
				is(instanceOf(Premises.class)));

		assertThat("Topic name is wrong", topicName,
				is("Agriculture/Premises/urn:pin:H89234X/Register/EMF"));
	}

	@Test
	public void test_SaveBinaryResource() throws IOException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);
		List<EObject> ocds = newArrayList();
		for (Event event : premises.eventHistory()) {
			if (event instanceof GenericEvent) {
				GenericEvent ge = (GenericEvent) event;
				OCD ocd = ge.getOcd();
				ocds.add(ocd);
			}
		}

		// EcoreUtil.CrossReferencer x = new
		// EcoreUtil.CrossReferencer(premises);

		for (Animal animal : premises.getAnimals()) {
			if (animal.eIsSet(TrackerPackage.eINSTANCE.getAnimal_Sire())) {
				EObject targetObject = (EObject) animal.eGet(
						TrackerPackage.eINSTANCE.getAnimal_Sire(), false);
//				System.out.println("From: "
//						+ EcoreUtil.getURI(animal).fragment() + " to "
//						+ EcoreUtil.getURI(targetObject).fragment());
				assertThat(
						"Wrong reference from target "
								+ EcoreUtil.getURI(animal).fragment(),
						EcoreUtil.getURI(targetObject).fragment(),
						is("840456789012341"));
			}
		}

		// OCD ocd = MetatypeFactory.eINSTANCE.createOCD();
		// ocd.setID("1234");

		List<EObject> list = newArrayList();

		list.add(premises);
		list.addAll(ocds);

		byte[] payload = TrackerStoreUtils.toPayload(list);

		List<EObject> list2 = TrackerStoreUtils.toEObject(payload);
		premises = (Premises) list2.get(0);// TrackerStoreUtils.toPremises(payload);
		for (Animal animal : premises.getAnimals()) {
			if (animal.eIsSet(TrackerPackage.eINSTANCE.getAnimal_Sire())) {
				EObject targetObject = (EObject) animal.eGet(
						TrackerPackage.eINSTANCE.getAnimal_Sire(), false);
				// System.out.println("From: "
				// + EcoreUtil.getURI(animal).fragment() + " to "
				// + EcoreUtil.getURI(targetObject).fragment());
				assertThat(
						"Wrong reference from target "
								+ EcoreUtil.getURI(animal).fragment(),
						EcoreUtil.getURI(targetObject).fragment(),
						is("840456789012341"));
			}
		}

		assertThat("Second object must be an OCD", list2.get(1),
				is(instanceOf(OCD.class)));

		OCD ocd = (OCD) list2.get(1);

		assertThat("Must have an id", ocd.getID(), is("mettler.weight"));

	}

	@Test
	public void test_RecordAnimalEvents() throws IOException,
			InterruptedException,
			BrokenBarrierException {
		Resource resource = getXMIResource(DOC_PREMISES, "");
		Premises premises = (Premises) resource.getContents().get(0);

		assertThat("Premises has wrong number of animals", premises
				.getAnimals().size(), is(7));

		logger.debug(bundleMarker, "Recording events premises {}",
				premises.getUri());

		IUpdateStats stats = trackerStore.recordAnimals(premises);


		assertThat("Must have two message", stats.getAnimalsAdded(), is(3));


	}

	@Test
	public void test_RetrieveAnimal() throws IOException, InterruptedException,
			BrokenBarrierException {
		Animal animal = trackerStore.retrieveAnimal(TAG_ID_1);

		assertThat("Animal should not be null", animal, is(notNullValue()));

		assertThat("Animal should be a swine", animal.getType(),
				is(AnimalType.SWINE));

		assertThat("Animal should have 1 tag", animal.getTags().size(), is(1));
		assertThat("Animal should have id", animal.getId(), is(TAG_ID_1));
		assertThat("Animal should have 2 events", animal.eventHistory().size(),
				is(2));

	}

	@Override
	public void messageArrived() {
		logger.debug(bundleMarker, "Message arrived in testcase");
		try {
			messageReceivedBarrier.await();
		} catch (Exception e) {
			logger.error(bundleMarker, "Barrier problem.", e);
		}

	}

	private final List<EObject> toEObject(byte[] payload) throws IOException {
		ByteArrayInputStream ba = new ByteArrayInputStream(payload);
		Resource resource = new BinaryResourceImpl();
		resource.load(ba, null);
		return resource.getContents();
	}

}
