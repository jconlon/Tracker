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
package com.verticon.tracker.irouter.mettler;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.POLL_DELAY;
import static com.verticon.tracker.irouter.common.TrackerConstants.REQUEST_COMMAND;
import static com.verticon.tracker.irouter.common.TrackerConstants.RESPONSE_PATTERN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import javax.microedition.io.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.io.ConnectorService;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.connector.socket.SocketStreamConnection;
import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.IMeasurementSender;

public class BallanceProducerCallableTest{

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(BallanceProducerCallableTest.class);


	@Override
	public String toString() {
		return "BallanceCallableTest []";
	}

	private static final String METTLER_EMULATOR = "socket://localhost:2345";
	MeasurementProducerCallable instance = null;
	BalanceServicesProviderMockup balanceServicesProvider = null;
	ExecutorService exec = null;
	Future<Void> future = null;
	MeasurementSender measurementSender = null;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public  void setUp() throws Exception {
		balanceServicesProvider = new BalanceServicesProviderMockup(METTLER_EMULATOR);
		measurementSender = new MeasurementSender();
		instance = new MeasurementProducerCallable(balanceServicesProvider, measurementSender);
		exec = Executors.newSingleThreadExecutor();	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		if(future !=null){
			future.cancel(true);
			future = null;
		}
		exec.shutdownNow();
		try {
			balanceServicesProvider.connectorService.connection.close();
		} catch (Exception e) {
			
		}
		balanceServicesProvider = null;
		instance = null;
	}

	@Test
	public void testBalanceCallable() {
		assertNotNull(instance);
	}


	@Test
	public void testParseBalanceWeight() {
		String one = "S S "+"     20.11"+" g\r\n";
		Double d = instance.parseBalanceWeight(one);
		assertEquals(new Double(20.11), d);
		
		
		one = "S D "+"     20.11"+" g\r\n";
		d = instance.parseBalanceWeight(one);
		assertEquals(new Double(20.11), d);
		
		one = "S D "+"    -20.11"+" g\r\n";
		d = instance.parseBalanceWeight(one);
		assertEquals(new Double(-20.11), d);
		
		one = "S D "+"     120.1"+" g\r\n";
		d = instance.parseBalanceWeight(one);
		assertEquals(new Double(120.1), d);
		
		one = "S D     295.90 g\r\n";
		d = instance.parseBalanceWeight(one);
		assertEquals(new Double(295.9), d);
		
		
	}
	@Test
	public void testCreateWeight() {
		String one = "S S "+"     20.11"+" g\r\n";
		Measurement d = instance.createWeight(one);
		assertEquals(new Measurement(.02011, .002, Unit.kg),d);
		
		
		one = "S D "+"     20.11"+" g\r\n";
	    d = instance.createWeight(one);
		assertEquals(new Measurement(.02011, .010, Unit.kg),d);
		
		one = "S D "+"    -20.11"+" g\r\n";
		d = instance.createWeight(one);
		assertEquals(new Measurement(-.02011, .010, Unit.kg),d);
		
		one = "S D "+"     120.1"+" g\r\n";
		d = instance.createWeight(one);
		assertEquals(new Measurement(.1201, .010, Unit.kg),d);
		
	}

	class MeasurementSender implements IMeasurementSender{
		List<Measurement> measurements = new ArrayList<Measurement>();
		@Override
		public void send(Measurement measurement) {
			log.info("{} [mesurement=<{}>]", this, measurement);
			measurements.add(measurement);
		}
	}
	class BalanceServicesProviderMockup implements IBalance{
		@Override
		public String toString() {
			return "BalanceServicesProviderMockup";
		}

		final IContext context;
		
		public BalanceServicesProviderMockup(String uri) {
			super();
			this.context = new ContextMockup( uri);
		}

		
		ConnectorServiceMockup connectorService = new ConnectorServiceMockup();
	
		
		@Override
		public ConnectorService getConnectorService() throws IOException {
			return connectorService;
		}



		public Future<Void> getFuture() {
			return null;
		}

		public void setFuture(Future<Void> future) {
		}

		@Override
		public void registerProducer() {
			
		}

		@Override
		public void unregisterProducer() {
			
		}

		@Override
		public IContext getContext() {
			return context;
		}


	}
	
	private class ContextMockup implements IContext{

		final String uri;
		
		private ContextMockup(String uri) {
			super();
			this.uri = uri;
		}

		@Override
		public BundleContext getBundleContext() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String[] getConfigurationArray(String key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean getConfigurationBoolean(String key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Double getConfigurationDouble(String key) {
			// TODO Auto-generated method stub
			return (Double)Context.DEFAULTS.get(key);
		}

		@Override
		public Integer getConfigurationInteger(String key) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public ExecutorService getExecutor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPid() {
			// TODO Auto-generated method stub
			return "test";
		}

		@Override
		public ScheduledExecutorService getScheduler() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setBundleContext(BundleContext bundleContext) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setConfig(Dictionary<?, ?> config)
				throws ConfigurationException {
			// TODO Auto-generated method stub
			
		}
		/*
		 * (non-Javadoc)
		 * @see com.verticon.tracker.trutest.IContext#getConfigurationLong(java.lang.String)
		 */
		@Override
		public Long getConfigurationLong(String key) {
			Object conf = getConfiguration( key);
			if(conf instanceof String){
				return new Long((String)conf);
			}
			return (Long)conf;
		}
		
		@Override
		public String getConfigurationString(String key) {
			return (String) getConfiguration(key);
		}
		
		private Object getConfiguration(String key) {
			if(key.equals(CONNECTION_URI)){
				return uri;
			}else if(key.equals(RESPONSE_PATTERN)){
				return Context.DEFAULTS.get(RESPONSE_PATTERN);
			}else if(key.equals(POLL_DELAY)){
				return new Long(300);//Balance.DEFAULTS.get(Balance.POLL_DELAY);
			}else if(key.equals(REQUEST_COMMAND)){
				return "";//"S\r\n";//Balance.DEFAULTS.get(Balance.POLL_DELAY);
			}
			
			return null;
		}
	}
	
	class ConnectorServiceMockup implements ConnectorService{

		Connection connection = null;
		@Override
		public Connection open(String arg0) throws IOException {
			
			return null;
		}

		@Override
		public Connection open(String arg0, int arg1) throws IOException {
			
			return null;
		}

		@Override
		public Connection open(String name, int arg1, boolean timeouts)
				throws IOException {
			
			connection =  new SocketStreamConnection(name, timeouts);
			return connection;
		}

		@Override
		public DataInputStream openDataInputStream(String arg0)
				throws IOException {
			
			return null;
		}

		@Override
		public DataOutputStream openDataOutputStream(String arg0)
				throws IOException {
			
			return null;
		}

		@Override
		public InputStream openInputStream(String arg0) throws IOException {
			
			return null;
		}

		@Override
		public OutputStream openOutputStream(String arg0) throws IOException {
			
			return null;
		}
		
	}
	
}
