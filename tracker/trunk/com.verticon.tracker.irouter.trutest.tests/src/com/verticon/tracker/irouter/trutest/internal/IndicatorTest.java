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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.cm.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an on-line exercising test of the Indicator class. 
 * 
 * A truTest mockIndicator or emulator must be running at the INDICATOR_URI
 * for it to test the Indicator class.
 * 
 * Most, but not all tests have been deprecated and use system tests instead
 * @author jconlon
 *
 */
public class IndicatorTest{
	static final String PRODUCER_SCOPE_ANIMAL_EID ="producer.scope.eid";
	
	private static final double ZERO = 0;
	private static final String ZERO_COMMAND = String.format("%.4f\r",ZERO);


	/**
	 * slf4j Logger
	 */
	final Logger log = LoggerFactory.getLogger(IndicatorTest.class);


	/**
	 * A truTest mockIndicator or emulator must be accessible on this host socket.
	 */
    static final String INDICATOR_URI = "socket://lantronix:3001";//"socket://lantronix2:10001";
	BlockingQueue<String[]> commandQueue =null;
	private MockIndicator mockIndicator = null;
	
	private ScheduledFuture<?> beeperFuture =null;
	private ScheduledFuture<?> display1Future =null;
	private ScheduledFuture<?> display2Future =null;
	
	private ExecutorService exec = null;
	private ScheduledExecutorService scheduler = null;
	
	@Override
	public String toString() {
		return "IndicatorCallableTest []";
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log.debug("SetUp ===============================================================================");
		exec = Executors.newCachedThreadPool();
		scheduler = Executors.newSingleThreadScheduledExecutor();
	    commandQueue = new LinkedBlockingQueue<String[]>();
		mockIndicator = new MockIndicator( INDICATOR_URI, exec, scheduler,commandQueue);
		
		//Clean out any downloads
		try {
			mockIndicator.getDownload().delete();
		} catch (Exception e) {
			throw e;
		}
		
		log.debug("SetUp finished .......................................................................");
		
	}
	



	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		log.debug("tearDown started .......................................................................");
		if(beeperFuture !=null){
			beeperFuture.cancel(true);
			beeperFuture=null;
		}
		
		if(display1Future !=null){
			display1Future.cancel(true);
			display1Future=null;
		}
		
		if(display2Future !=null){
			display2Future.cancel(true);
			display2Future=null;
		}
		
		scheduler.shutdownNow();
		exec.shutdownNow();

		if(mockIndicator.sharedConnection !=null){
			mockIndicator.sharedConnection.close();
		}
		mockIndicator = null;
		commandQueue = null;
		exec = null;
		scheduler = null;
		
		
		TimeUnit.SECONDS.sleep(5);
		
		log.debug("TearDown finished .......................................................................");
	}

	
	
	
	
	/**
	 * Test the configuation
	 */
	@Test
	public void testConfiguration() {
		String someValue = mockIndicator.getConfigurationString(PRODUCER_SCOPE_ANIMAL_EID);
		assertNull("Should be null, but was "+someValue, someValue);
		
	}
	
	/**
	 * Update two display fields on the mockIndicator to test the workaround for 
	 * Ticket#482:
	 * When two TruTest mockIndicator display fields are rapidly updating at the same time, 
	 * display fields may intermittently show values in the wrong field.
	 * 
	 * The workaround is in CommandConsumerCallable.  It is a configurable X millisecond sleep
	 * in the take loop of the commandsQueue.
	 * 
	 * 
	 * Test requires a TruTest mockIndicator with two dataFile fields configured as numbers
	 * with formats #.#### and enabled to display on the weighing screen.
	 * 
	 * Test operator will have to watch these fields. 
	 * 
	 *  From the configuration metadata definition
	 *  
	 *  To write actual and calculated data to the display, the ports fields, and the 
	 *  minimum number of characters must be specified. Change the defaults if the mockIndicator 
	 *  is reconfigured changing field locations.
	 *  SXD1 is Com Port 1, 8 is the first data field, 9 the second.
	 *  SXC1 is Com Port 1 and 6 is the number of characters.-
	 *  <AD name="Actual BW field"  id="trutest.actbw.field" required="false" type="String" default="{SXD19}%13%%10%{SXC16}%13%"/>
	 *  <AD name="Calc BW field"  id="trutest.calbw.field" required="false" type="String" default="{SXD18}%13%%10%{SXC16}%13%"/>
	 * 
	 * These are the configurables for the workaround
	 * <AD name="Command consumption delay milliseconds" id="consumer.command.delay" required="false" type="Integer" default="100"/>
	 * <AD name="Send unstable weights" id="send.unstable.weights" required="false" type="Boolean" default="true"/>
 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws IOException
	 */
	//Test
	public void testDisplayingFields() throws InterruptedException, ExecutionException, IOException {
		log.debug("Starting: testDisplayingFields()");
		
		assertNotNull(mockIndicator);
//		mockIndicator.displayDelay=10;//will see the bug
		mockIndicator.displayDelay=100;//Default should not see the bug
		try {
			mockIndicator.updated(null, null);
		} catch (ConfigurationException e1) {
			fail(e1.toString());
		}
		log.debug(this + " updated mockIndicator");
		

		String value1command = String.format("%.4f\r",
				 .2345
	    );
		String[] display1Commands = {"{SXD18}\r","{SXC16}\r",value1command};
		String[] display1Commandsalt = {"{SXD18}\r","{SXC16}\r",ZERO_COMMAND};
//		String[] display1Commands = {BEEP_COMMAND,"{SXD18}\r","{SXC16}\r",value1command};
//		String[] display1Commandsalt = {BEEP_COMMAND,"{SXD18}\r","{SXC16}\r",ZERO_COMMAND};
		display1Future = mockIndicator.getScheduler().scheduleAtFixedRate(
				new CommandToggleSender(display1Commands, display1Commandsalt), 
				1, 1000, TimeUnit.MILLISECONDS);
		
		
		String value2command = String.format("%.4f\r",
				6.7890
	    );
		String[] display2Commands = {"{SXD19}\r","{SXC16}\r",value2command};
		String[] display2Commandsalt = {"{SXD19}\r","{SXC16}\r",ZERO_COMMAND};
//		String[] display2Commands = {BEEP_COMMAND,"{SXD19}\r","{SXC16}\r",value2command};
//		String[] display2Commandsalt = {BEEP_COMMAND,"{SXD19}\r","{SXC16}\r",ZERO_COMMAND};
		display2Future = mockIndicator.getScheduler().scheduleAtFixedRate(
				new CommandToggleSender(display2Commands, display2Commandsalt), 
				1, 1000, TimeUnit.MILLISECONDS);
		
		try {
			TimeUnit.SECONDS.sleep(35);
		} catch (InterruptedException e) {
			fail("Interrupted Thread");
		}
		
	}
	
	
	
	
	class CommandToggleSender implements Runnable{
		final String[] commands;
		final String[] altCommands;
		int count;
		
		private CommandToggleSender(String[] commands, String[] altCommands) {
			super();
			this.commands = commands;
			this.altCommands = altCommands;
		}

		@Override
		public void run() {
			count++;
			try {
				if(count % 2 ==0){
					commandQueue.put(commands);
				}else{
					commandQueue.put(altCommands);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	
	class CommandSender implements Runnable{
		final String[] commands;
		
		private CommandSender(String[] commands) {
			super();
			this.commands = commands;
		}

		@Override
		public void run() {
			try {
				commandQueue.put(commands);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	//Gets the Writer from the mockIndicator and wraps it in a Callable.
	class MockWritingCallable implements Callable<Void>{
        final IIndicator indicator;
        final BlockingQueue<String[]> commandQueue ;
        
        public MockWritingCallable(IIndicator indicator, BlockingQueue<String[]> commandQueue){
			super();
			this.indicator = indicator;
			this.commandQueue = commandQueue;
		}
        
		@Override
		public Void call() throws Exception {
			log.debug(this + " Called.");
			Writer writer = indicator.getWriter();
			assertNotNull(writer);
			
			while(!Thread.currentThread().isInterrupted()){
				log.debug(this + " took commands.");
				String[] commands = commandQueue.take();
				for (String command : commands) {
					log.debug(this+": writing "+command);
					writer.write(command);
					writer.flush();
				}
			}
			return null;
		}
		
		
	}
	
	//Gets the Reader from the mockIndicator and wraps it in a Callable.
	class MockReadingCallable implements Callable<Void>{
        final IIndicator indicator;
        List<String> lines = new ArrayList<String>();
        
        public MockReadingCallable(IIndicator indicator) {
			super();
			this.indicator = indicator;
		}
        
		@Override
		public Void call() throws Exception {
			BufferedReader reader = indicator.getReader();
			assertNotNull(reader);
			while(!Thread.currentThread().isInterrupted()){
				String response = reader.readLine();
				lines.add(response);
				log.debug(String.format("%s: processing response=%s",
						this, response));
				
			}
			return null;
		}
	}
	
//	class EnvelopeSender implements IEnvelopeSender{
//		List<Envelope> envelopes = new ArrayList<Envelope>();
//		
//		@Override
//		public void send(Envelope envelope) {
//			envelopes.add(envelope);
//		}
//		
//	}
}
