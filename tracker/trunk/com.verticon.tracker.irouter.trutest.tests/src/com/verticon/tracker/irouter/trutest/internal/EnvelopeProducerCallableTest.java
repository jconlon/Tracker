/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.irouter.trutest.internal;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.trutest.internal.MockIndicator.MockConnectorService;
import com.verticon.tracker.irouter.trutest.internal.EnvelopeProducer;
import com.verticon.tracker.irouter.trutest.internal.EnvelopeProducerCallable;
import com.verticon.tracker.irouter.trutest.internal.IIndicator;
import com.verticon.tracker.irouter.trutest.internal.Indicator;

/**
 * Off-line test of the CompositeReaderCallable.
 * 
 * @author jconlon
 *
 */
public class EnvelopeProducerCallableTest{

	EnvelopeProducerCallable instance = null;
	IIndicator context = null;
	MockCompositeProducer compositeProducer = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new MockIndicator("test",null, null);
		compositeProducer = new MockCompositeProducer(context);
		CountDownLatch startGate = new CountDownLatch(1);
		startGate.countDown();
		instance = new EnvelopeProducerCallable(context, compositeProducer,startGate);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		context = null;
		compositeProducer = null;
		instance = null;
	}
	
	
	/**
	 * Test the basic pattern used on the CompositeReaderCallable 
	 * for matching different kinds of responses to the 
	 * DEFAULTS.put(REQUEST_COMMAND, "{RP}%13%");
	 */
	@Test
	public void testDefaultFilter(){
		String filter = context.getConfigurationString(RESPONSE_PATTERN);
		assertNotNull(filter);
		String expected = "^\\[(.+)\\]$";
		assertEquals(filter, expected, filter);
		Pattern pattern = Pattern.compile(context.getConfigurationString(RESPONSE_PATTERN));
		Matcher matcher = pattern.matcher("");
		String response = "[ID123456789012345]";
		matcher.reset(response.trim());
		assertTrue(matcher.matches());
		String rpResponse = matcher.group(1);
		assertEquals(rpResponse, "ID123456789012345");
	}

	/**
	 * More comprehensive test of the CompositeReaderCallable using  
	 * @throws IOException 
	 */
	@Test
	public void testProcess() throws IOException {
		assertNotNull(instance);
		
		//Simple ID
		instance.process("[ID123456789012345]");
		assertEquals(1,compositeProducer.envelopes.size());
		assertEquals(PRODUCER_SCOPE_ANIMAL_EID_DEFAULT, 
				compositeProducer.envelopes.get(0).getScope());
		compositeProducer.envelopes.clear();
		
		//ID and WR
		instance.process("[ID123456789012345,WR147,DR2]");
		assertEquals(3,compositeProducer.envelopes.size());
		assertEquals(PRODUCER_SCOPE_ANIMAL_EID_DEFAULT, 
				compositeProducer.envelopes.get(0).getScope());
		assertEquals(PRODUCER_SCOPE_ANIMAL_WEIGHT_DEFAULT, 
				compositeProducer.envelopes.get(1).getScope());
		assertEquals(PRODUCER_SCOPE_ENTER_KEY_DEFAULT,
				compositeProducer.envelopes.get(2).getScope());
		compositeProducer.envelopes.clear();
		
	}

	class MockIndicator extends Indicator {

		@Override
		public String toString() {
			return "IndicatorServicesProviderMockup";
		}

		final String uri;
		MockConnectorService connectorService = null;// new MockConnectorService();

		public MockIndicator(String uri, ExecutorService exec,
				ScheduledExecutorService scheduler)
				throws ConfigurationException {
			super("test", exec, scheduler);
			this.uri = uri;
		}

		@Override
		protected ConnectorService getConnectorService() throws IOException {
			return connectorService;
		}

		protected Object getConfiguration(String key) {
			if (key.equals(CONNECTION_URI)) {
				return uri;
			} else {
				return DEFAULTS.get(key);
			}
		}
//
//		@Override
//		public BufferedReader getReader() throws IOException {
//			String uri = (String) getConfiguration(CONNECTION_URI);
//			log.debug(this + ": Opening connection");
//			ConnectorService cs = getConnectorService();
//
//			StreamConnection connection = (StreamConnection) cs.open(uri,
//					ConnectorService.READ_WRITE, true);
//
//			return new BufferedReader(new InputStreamReader(connection
//					.openInputStream()));
//
//		}

		public void setBundleContext(BundleContext bundleContext) {
		}

		public BundleContext getBundleContext() {
			return null;
		}

		@Override
		public void setConfig(Dictionary<?, ?> config)
				throws ConfigurationException {
		}

	}

	
	/**
	 * A mock TruTest Composite EnvelopeProducer that caches a list of all sent Animal
	 * Weight measurements, EID values, and Record State envelopes.
	 * @author jconlon
	 *
	 */
	class MockCompositeProducer extends EnvelopeProducer {
		
		/**
		 * slf4j Logger
		 */
		private final Logger log = LoggerFactory
				.getLogger(EnvelopeProducerCallableTest.MockCompositeProducer.class);


		List<Envelope> envelopes = new ArrayList<Envelope>();
		MockConnectorService connectorService = null;// new
														// MockConnectorService();

		MockCompositeProducer(IIndicator context) {
			super(context);
		}

		@Override
		public void send(Envelope envelope) {
			log.info(String.format("%s [envelopeValue=<%s>]", this, envelope.getValue()));
			envelopes.add(envelope);
		}

		@Override
		protected void register(BundleContext bc) {
		}
	}
}
