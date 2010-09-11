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
import static com.verticon.tracker.irouter.trutest.internal.Constants.BEEP_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.POLL_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_ACK;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_CRLF;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_ERROR_CODES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

import com.verticon.tracker.connector.socket.SocketStreamConnection;
import com.verticon.tracker.irouter.common.Utils;
import com.verticon.tracker.irouter.trutest.internal.IIndicator;

/**
 * This is an on-line exercising test of the Indicator class. 
 * 
 * A truTest mockIndicator or emulator must be running at the INDICATOR_URI
 * for it to test the Indicator class.
 * 
 * @deprecated use system tests instead
 * @author jconlon
 *
 */
public class IndicatorTest{
	
	
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
	private MockWritingCallable mockWritingCallable = null;
	private MockReadingCallable mockReadingCallable =  null;
	private ScheduledFuture<?> beeperFuture =null;
	private ScheduledFuture<?> display1Future =null;
	private ScheduledFuture<?> display2Future =null;
	
	private ExecutorService exec = null;
	private ScheduledExecutorService scheduler = null;
	
	private SocketStreamConnection connection =null;
	private Writer fileWriter;
	
	private File downLoadedRawFile = null;
	
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
		mockWritingCallable = new MockWritingCallable(mockIndicator,commandQueue);
		mockReadingCallable =  new MockReadingCallable(mockIndicator);
		//Clean out any downloads
		mockIndicator.getDownload().delete();
		
		downLoadedRawFile = new File("/home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.irouter.trutest.internal.internal.tests/testData/downloaded-raw.txt");
		if(downLoadedRawFile.exists()){
			downLoadedRawFile.delete();
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
		
		mockWritingCallable = null;
		mockReadingCallable = null;
		scheduler.shutdownNow();
		exec.shutdownNow();

		if(mockIndicator.sharedConnection !=null){
			mockIndicator.sharedConnection.close();
		}
		mockIndicator = null;
		commandQueue = null;
//		envelopeSender.envelopes.clear();
//		envelopeSender = null;
		exec = null;
		scheduler = null;
		if(connection !=null){
		 connection.close();
		 connection = null;
		}
		if(fileWriter!=null){
			fileWriter.close();
			fileWriter=null;
		}
		TimeUnit.SECONDS.sleep(5);
		downLoadedRawFile = null;
		log.debug("TearDown finished .......................................................................");
	}

	/**
	 * Using a Raw reader and writer sends 120 requests to the mockIndicator and checks to 
	 * see that 120 responses came back. Checks for errors.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testRawReaderAndWriterConnection() throws IOException, InterruptedException{
		log.debug("Starting: testReaderAndWriterConnection()");
		
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = mockIndicator.getReader();
		assertNotNull(reader);
		Writer writer = mockIndicator.getWriter();
		assertNotNull(writer);
		for (int i = 0; i < 120; i++) {
			writer.write(POLL_COMMAND);
			writer.flush();
			String response = reader.readLine();
			assertNotNull(response);
			lines.add(response);
//			log.debug(String.format("%s: processing response=%s",
//					this, response));
		}
		
		reader.close();
		writer.close();
		assertEquals(120, lines.size());
		//Any errors?
		boolean noErrors = true;
		for (String response : lines) {
			if(response.startsWith("(")){
				noErrors = false;
				log.error(this+" received an error response="+response);
			}
		}
		assertTrue("Received errors from the mockIndicator", noErrors);
	}
	
	/**
	 * Sets up a MockIndicator within a executors manager.  Send a message and a beep
	 * every second for 15 seconds. Make sure at least 14 came back.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testGenericCallables() throws IOException, InterruptedException{
		log.debug("Starting: testGenericCallables()");
		
		exec.submit(mockWritingCallable);
		exec.submit(mockReadingCallable);
		
		//Reset the mockIndicator
		commandQueue.put(new String[]{TURN_ON_CRLF,
									TURN_ON_ACK,
									  TURN_ON_ERROR_CODES,
									  BEEP_COMMAND});
		
		//Beep every second
		Runnable beeper = new CommandSender(new String[]{BEEP_COMMAND});
		beeperFuture = mockIndicator.getScheduler().scheduleWithFixedDelay(
				beeper, 1, 1, TimeUnit.SECONDS);
		
		//Sleep for 15 seconds
		TimeUnit.SECONDS.sleep(15);
		
		//Should have gotten at least 14 responses.
		int expected = 14;
		assertTrue("Should have sent at least "+expected+"lines but was "
				+ mockReadingCallable.lines.size(),
				mockReadingCallable.lines.size() > expected);
		
		//Any TruTest reported errors in the responses?
		boolean noErrors = true;
		for (String response : mockReadingCallable.lines) {
			if(response.startsWith("(")){
				noErrors = false;
				log.error(this+" received an error response="+response);
			}
		}
		assertTrue("Received errors from the mockIndicator", noErrors);
	}
	
	
	/**
	 * This test sends commands to the mockIndicator.  The effect of these commands should be
	 * visible and audible on/from the mockIndicator.
	 * 
	 * This test must be called with an external emulator or real mockIndicator.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void testEnvelopeProduction() throws InterruptedException, ExecutionException, IOException {
		log.debug("Starting: testEnvelopeProduction()");
		
		assertNotNull(mockIndicator);
		try {
			mockIndicator.updated(null, null);
		} catch (ConfigurationException e1) {
			fail(e1.toString());
		}
		log.debug(this + " updated mockIndicator");
		
		String returnedURI = mockIndicator.getConfigurationString(CONNECTION_URI);
		assertNotNull(returnedURI);
		assertEquals(INDICATOR_URI, returnedURI);
		
		Runnable beeper = new CommandSender(new String[]{BEEP_COMMAND});
		beeperFuture = mockIndicator.getScheduler().scheduleWithFixedDelay(
				beeper, 1, 5, TimeUnit.SECONDS);
		
		
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			fail("Interrupted Thread");
		}
		
		/*
		 *  To write actual and calculated data to the display, the ports fields, and the 
		 *  minimum number of characters must be specified. Change the defaults if the mockIndicator 
		 *  is reconfigured changing field locations.
		 *  SXD1 is Com Port 1, 8 is the first data field, 9 the second.
		 *  SXC1 is Com Port 1 and 6 is the number of characters.-
		 *  <AD name="Actual BW field"  id="trutest.actbw.field" required="false" type="String" default="{SXD19}%13%%10%{SXC16}%13%"/>
		 *  <AD name="Calc BW field"  id="trutest.calbw.field" required="false" type="String" default="{SXD18}%13%%10%{SXC16}%13%"/>

		 */
		//Send some commands to display a value in a field on the mockIndicator.
		String commands[] = {"{SABP500}\r","{SXD18}\r","{SXC16}\r","99.138\r\n"};
		commandQueue.put(commands);
		
		//Did it download a file?
		assertTrue(mockIndicator.getDownload().exists());
		assertEquals(mockIndicator.getDownload().getName(),"animalLifeDataDownload-one.txt");
		
		
		//Was weight data received ?
		assertTrue("Should have sent at least three envelopes but was "
				+mockIndicator.messageCount()+
				". Be sure to change weight on the scale to generate values.",
				mockIndicator.messageCount() > 2);
		
		
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
	@Test
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
	
	/**
	 * This is a version of the previous test that strips all mockIndicator code and just writes
	 * directly to the connection.
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws IOException
	 */
	@Test //commented out.  If raw test needed uncomment
	public void testRawDisplayingFields() throws InterruptedException, ExecutionException, IOException {
		log.debug("Starting: testRawDisplayingFields()");
		
	    connection = new SocketStreamConnection(INDICATOR_URI, true);

	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection
				.openInputStream()));
	    
		Writer writer = new BufferedWriter(new OutputStreamWriter(connection
				.openOutputStream()));
		
		commandQueue.put(new String[]{TURN_ON_CRLF,
				TURN_ON_ACK,
				  TURN_ON_ERROR_CODES,
				  BEEP_COMMAND});
				
		String value1command = String.format("%.4f\r",
				 .2345
	    );
		String[] display1Commands = {BEEP_COMMAND,"{SXD18}\r","{SXC16}\r",value1command};
		String[] display1Commandsalt = {BEEP_COMMAND,"{SXD18}\r","{SXC16}\r",ZERO_COMMAND};
		display1Future = mockIndicator.getScheduler().scheduleAtFixedRate(
				new CommandToggleSender(display1Commands, display1Commandsalt), 
				1, 1000, TimeUnit.MILLISECONDS);
		
		
		String value2command = String.format("%.4f\r",
				6.7890
	    );
		String[] display2Commands = {BEEP_COMMAND,"{SXD19}\r","{SXC16}\r",value2command};
		String[] display2Commandsalt = {BEEP_COMMAND,"{SXD19}\r","{SXC16}\r",ZERO_COMMAND};
		display2Future = mockIndicator.getScheduler().scheduleAtFixedRate(
				new CommandToggleSender(display2Commands, display2Commandsalt), 
				1, 1000, TimeUnit.MILLISECONDS);
		
		int count = 0;
		while(!Thread.currentThread().isInterrupted() && count<83){
			count++;
			TimeUnit.MILLISECONDS.sleep(100);
			String[] commands = commandQueue.take();
			for (String command : commands) {
				
				log.debug("{}: Sending command={}", this,Utils.toAscii(command));
				writer.write(command);
				writer.flush();
				if(command.equals("{SXD18}\r")){
					log.debug(this+": Sent FIELD ONE -------------------: ");
					String response = reader.readLine();
					log.debug("{}: Received response={}", this,Utils.toAscii(response));
				}else if(command.equals("{SXD19}\r")){
					log.debug(this+": Sent FIELD TWO : ");
					String response = reader.readLine();
					log.debug("{}: Received response={}", this,Utils.toAscii(response));
				}else{
				//All values sent to the port are NOT Acknowledged
				//Don't ask for one it will throw a SocketTimeoutException
					//String response = reader.readLine();
				}
				
			}
			
		}
		
		
	}

	@Test  //FileUploading is not built into the mockIndicator.  Don't need to test this as it will write over previous uploaded data.
	public void testUploadRawData() throws InterruptedException, ExecutionException, IOException {
		log.debug("Starting: testRawFileUpload()");
		
		connection = new SocketStreamConnection(IndicatorTest.INDICATOR_URI, true);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection
				.openInputStream()));
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(connection
				.openOutputStream()));
		
		/*
		 * 
		 * 1. Optionally, turn acknowledgements on with {ZA1}.
		 * 2. Optionally, turn error responses on with {ZE1}.
		 * 3. Optionally change the bit rate to 38400 bps for faster uploading using {SEBX38400}.
		 * 
 		 * 6. Optionally, use {FC} to clear the file if necessary.
		 * 7. Optionally, use various {FPxx} commands to set file properties as necessary (if file is empty). Any
		 * 		File properties that are not set will take defaults. If the mockIndicator is only used with one type of load
		 * 		bars or load cells, the resolution etc will be set to what is normal for this mockIndicator.
		 * 8. Optionally us various {SFxx} commands to set up the File Data fields, {SLxx} commands to set up
		 * 		Life Data fields, and {SOCU} to set up custom field values.
		 * 9. Use {FI...} to specify which fields are to be uploaded.
		 * 10. Use {FU} to upload each record. Use CRCs in every upload record if required.
		 * 11. Use a long timeout of 20 seconds, because sometimes the mockIndicator must spend time rearranging
		 * 	   the heap during an upload.
		 * 
		 */
				
		//4. Optionally, select the page that is to be downloaded using {FGss} (defaults to File data).
		// {FGLD} for 
		String selectLifeDataPage = "{FGLD}\r";
		
		// 5. Optionally, change the file using {FFn} (defaults to the current file).
		
		/*
		 * 6. Optionally, use {FC} to clear the file if necessary. 
		 */
		String fileClear = "{FC1}\r";
		
		/*
		 * 
		 * 7. Optionally, use various {FPxx} commands to set file properties as necessary (if file is empty). Any
		 * 	  File properties that are not set will take defaults. If the mockIndicator is only used with one type of load
		 * 	  bars or load cells, the resolution etc will be set to what is normal for this mockIndicator.
		 * 8. Optionally us various {SFxx} commands to set up the File Data fields, {SLxx} commands to set up
		 * 	  Life Data fields, and {SOCU} to set up custom field values.
		 * 
		 * 
		 * 9. Use {FI...} to specify which fields are to be uploaded.
		 * {FH}
		 * [F1AEID]
		 * {FH}
		 * [F2ATAG]
		 * {FH}
		 * [F3NBW Mult]
		 * {FH}
		 * [F4OSPECIES]
		 * {FH}
		 * []
		 */
		// EID TAG SPECIES BWMult
		String fileHeaderList = "{FIF1,F2,F3,F4}\r";
		
		commandQueue.put(new String[]{TURN_ON_CRLF,
				TURN_ON_ACK,
				  TURN_ON_ERROR_CODES,
				  selectLifeDataPage, fileClear,fileHeaderList});
		
		
		/*
		 * 
		 * 10. Use {FU} to upload each record. Use CRCs in every upload record if required.
		 * 11. Use a long timeout of 20 seconds, because sometimes the mockIndicator must spend time rearranging
		 * 	   the heap during an upload.
		 * 
		 */
		// EID TAG BWMult SPECIES
		String[] records = new String[]{
				"{FU123456789012345,1234,1,0.01}\r", 
				"{FU123456789012346,4321,2,0.02}\r",
				"{FU123456789012347,1111,1,0.03}\r"
		};
		
		commandQueue.put(records);
		
		/*
		 * 9. Use {FN} to get each record. An empty response means there are no more records.
		 */
		
		String nextRecord = "{FN}\r";
		
		
		while(!Thread.currentThread().isInterrupted()){
			TimeUnit.MILLISECONDS.sleep(100);
			String[] commands = commandQueue.take();
			for (String command : commands) {
				log.debug("{}: Sending command={}", this,Utils.toAscii(command));
				writer.write(command);
				writer.flush();
				log.debug(this+": sent: "+command);
			}
			try {
				
				String response = reader.readLine();
				log.debug("{}: Received response={}", this,Utils.toAscii(response));
				if(response.startsWith("[]")){
					log.debug(this+": No more data");
					break;
				}else if(response.startsWith("[")){
					log.debug(this+": Record "+response);
					
				}
				
				commandQueue.add(new String[]{nextRecord});
				
			} catch (Exception e) {
				log.debug(this+": timedout");
			}
		}
		
		TimeUnit.SECONDS.sleep(2);
	}
	
	@Test  //FileDownloading is not built into the mockIndicator.  Don't need to test this as it will write over previous downloaded data.
	public void testDownloadRawDataFile() throws InterruptedException, ExecutionException, IOException {
		log.debug("Starting: testRawFileDownload()");
		
	    connection = new SocketStreamConnection(IndicatorTest.INDICATOR_URI, true);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection
				.openInputStream()));
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(connection
				.openOutputStream()));
		
		fileWriter = new BufferedWriter(
				new FileWriter(this.downLoadedRawFile));
		
		
				
		//4. Optionally, select the page that is to be downloaded using {FGss} (defaults to File data).
		// {FGLD} for 
		String selectLifeDataPage = "{FGLD}\r";
		
		// 5. Optionally, change the file using {FFn} (defaults to the current file).
		
		// 6. Optionally, use {FD} to reset to the 1st record of the file (defaults to first record).
		String resetRecordOne = "{FD}\r";
		/*
		 * 7. Optionally, use {FH} repeatedly to get field IDs, types and labels of the columns present in the screen.
		 */
		
		
		/*
		 * 8. Optionally, use {FI} e.g. {FIF0,DW,C0} to specify which fields returned by {FH} are required in the download (defaults to downloading all fields except ‘calculated’ fields).
		 */
		
		commandQueue.put(new String[]{TURN_ON_CRLF,
				TURN_ON_ACK,
				  TURN_ON_ERROR_CODES,
				  selectLifeDataPage, 
				  resetRecordOne});
		/*
		 * 9. Use {FN} to get each record. An empty response means there are no more records.
		 */
		
		String nextRecord = "{FN}\r";
		
		
		while(!Thread.currentThread().isInterrupted()){
			TimeUnit.MILLISECONDS.sleep(100);
			String[] commands = commandQueue.take();
			for (String command : commands) {
				log.debug("{}: Sending command={}", this,Utils.toAscii(command));
				writer.write(command);
				writer.flush();
				log.debug(this+": sent: "+command);
			}
			try {
				String response = reader.readLine();
				log.debug("{}: Received response={}", this,Utils.toAscii(response));
				if(response.startsWith("[]")){
					log.debug(this+": No more data");
					break;
				}else if(response.startsWith("[")){
					log.debug(this+": Record "+response);
					fileWriter.write(response+"\r");//[7,900014000554939,444,0.01,1]
					fileWriter.flush();
				}
				
				commandQueue.add(new String[]{nextRecord});
				
			} catch (Exception e) {
				log.debug(this+": timedout");
			}
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
