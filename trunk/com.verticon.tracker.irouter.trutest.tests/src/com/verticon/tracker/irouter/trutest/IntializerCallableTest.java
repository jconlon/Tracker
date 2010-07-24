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
package com.verticon.tracker.irouter.trutest;

import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.trutest.Constants.BEEP_COMMAND;
import static com.verticon.tracker.irouter.trutest.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.Constants.DOWNLOAD_RECORD_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.Constants.FILE_HEADER_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.Constants.TURN_ON_ACK;
import static com.verticon.tracker.irouter.trutest.Constants.TURN_ON_CRLF;
import static com.verticon.tracker.irouter.trutest.Constants.TURN_ON_ERROR_CODES;
import static com.verticon.tracker.irouter.trutest.Constants.UPLOAD_RECORD_PATTERN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.cm.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.connector.socket.SocketStreamConnection;
import com.verticon.tracker.irouter.common.Utils;
import com.verticon.tracker.irouter.trutest.IndicatorTest.CommandSender;

/**
 * This is an online test of the IntializerCallable.  It tests the downloading 
 * and uploading of data. 
 * @author jconlon
 *
 */
public class IntializerCallableTest {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory.getLogger(IntializerCallableTest.class);

	private SocketStreamConnection connection =null;
	private Writer fileWriter;
	BlockingQueue<String[]> commandQueue =null;
	private MockIndicator indicator = null;
	private InitializerCallable initializerCallable = null;
	private File downLoadedRawFile = null;

	@Before
	public void setUp() throws Exception {
		indicator = new MockIndicator();
		initializerCallable = new InitializerCallable(indicator);
		commandQueue = new LinkedBlockingQueue<String[]>();
		downLoadedRawFile = new File("/home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.irouter.trutest.tests/testData/downloaded-raw.txt");
		if(downLoadedRawFile.exists()){
			downLoadedRawFile.delete();
		}
	}

	@After
	public void tearDown() throws Exception {
		if(connection !=null){
			 connection.close();
			 connection = null;
		}
		if(fileWriter!=null){
			fileWriter.close();
			fileWriter=null;
		}
		commandQueue = null;
		downLoadedRawFile = null;
		
	}

	

	@Test
	public final void testNormalize() {
		log.debug("Starting: testNormalize()");
		
		Pattern pattern= Pattern.compile(indicator.getConfigurationString(DOWNLOAD_RECORD_PATTERN));
		Matcher matcher = pattern.matcher("");
		
		assertEquals( "900014000554784,555,0.01,1", InitializerCallable.normalize(matcher, "[0,900014000554784,555,0.01,1]"));
	
		assertNull(InitializerCallable.normalize(matcher, "[900014000554784,555,0.01,1]"));
	}
	

	/**
	 * 
	 * Will process input lines that look like: 900014000554952,0000,0.01,1 to
	 * make them look like "{FU123456789012345,1234,0.01,1}\r"
	 * 
	 **/
	@Test
	public void testCreateIndicatorRecordCommand_default() {
		log.debug("Starting: testInitializerCallable_normalize()");

		assertEquals("^[0-9]{15,15},[0-9]{4,4},\\d.\\d\\d,[1-2]$", indicator
				.getConfigurationString(UPLOAD_RECORD_PATTERN));

		// Good record
		assertEquals("{FU123456789012345,1234,0.01,1}\r", initializerCallable
				.createIndicatorRecordCommand(
						"123456789012345,1234,0.01,1",1));

		// Good record
		assertEquals("{FU900014000554952,1224,0.01,1}\r", initializerCallable
				.createIndicatorRecordCommand(
						"900014000554952,1224,0.01,1",2));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				"90001400055495,0000,0.01,1",3));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				"900014000554952,1234,2,0.01",4));

	}

	/**
	 * 
	 * Will process input lines that look like: 900014000554952,0000,0.01,1 to
	 * make them look like "{FU123456789012345,1234,0.01,1}\r"
	 * 
	 **/
	@Test
	public void testCreateIndicatorRecordCommand_alternate() {
		log.debug("Starting: testInitializerCallable_normalize()");
		               //"^[0-9]{15,15},[0-9]{4,4},[1-2],\\d.\\d\\d$"
		String matcher = "^[0-9]{15,15}?,[0-9]{4,4}?,[1-2],\\d.\\d\\d$";

		String record = "900014000554756,1831,1,0.02";//900014000554811,1854,1,0.01";

		assertTrue(record.matches(matcher));

		indicator.regex= matcher;
		initializerCallable = new InitializerCallable(indicator);
		//		
		// Pattern pattern= Pattern.compile(alternate);
		// Matcher matcher = pattern.matcher("");

		// Good record<>
		assertEquals("{FU900014000554811,1854,1,0.01}\r", initializerCallable
				.createIndicatorRecordCommand(
						"900014000554811,1854,1,0.01",1));

		// Good record
		assertEquals("{FU123456789012345,1234,2,0.01}\r", initializerCallable
				.createIndicatorRecordCommand(
						"123456789012345,1234,2,0.01",2));

		// Good record
		assertEquals("{FU900014000554952,1224,1,0.01}\r", initializerCallable
				.createIndicatorRecordCommand(
						"900014000554952,1224,1,0.01",3));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				 "90001400055495,0000,0.01,1",4));

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
	
	@Test
	public final void testCall() {
//		assertNotNull(indicator);
//		try {
//			indicator.updated(null, null);
//		} catch (ConfigurationException e1) {
//			fail(e1.toString());
//		}
//		log.debug(this + " updated mockIndicator");
//		
//		String returnedURI = indicator.getConfigurationString(CONNECTION_URI);
//		assertNotNull(returnedURI);
//		assertEquals(INDICATOR_URI, returnedURI);
//		
////		Runnable beeper = new CommandSender(new String[]{BEEP_COMMAND});
////		beeperFuture = mockIndicator.getScheduler().scheduleWithFixedDelay(
////				beeper, 1, 5, TimeUnit.SECONDS);
////		
//		
//		try {
//			TimeUnit.SECONDS.sleep(25);
//		} catch (InterruptedException e) {
//			fail("Interrupted Thread");
//		}
	}
	
	
	class MockIndicator implements IIndicator {

		String regex = Constants.UPLOAD_RECORD_PATTERN_DEFAULT;
		
		@Override
		public Boolean getConfigurationBoolean(String key) {
			
			return null;
		}

		@Override
		public Double getConfigurationDouble(String key) {
			return null;
		}

		@Override
		public Integer getConfigurationInteger(String key) {
			return null;
		}

		@Override
		public Long getConfigurationLong(String key) {
			return null;
		}

		@Override
		public String getConfigurationString(String key) {
			if(key.equals(UPLOAD_RECORD_PATTERN)){
				return regex;
			}else if(key.equals(FILE_HEADER_COMMAND)){
				return FILE_HEADER_COMMAND_DEFAULT;
			}else if(key.equals(DOWNLOAD_RECORD_PATTERN)){
				return DOWNLOAD_RECORD_PATTERN_DEFAULT;
			}
			return null;
		}

		@Override
		public File getDownload() {
			return null;
		}

//		@Override
//		public CountDownLatch getEndGate() {
//			return null;
//		}

		@Override
		public String getPid() {
			return null;
		}

		@Override
		public BufferedReader getReader() throws IOException {
			return null;
		}

		@Override
		public ScheduledExecutorService getScheduler() {
			return null;
		}

//		@Override
//		public CountDownLatch getStartGate() {
//			return null;
//		}

//		@Override
//		public File getSynchronizationDirectory() {
//			return null;
//		}

		@Override
		public File getUpload() {
			return null;
		}

		@Override
		public Writer getWriter() throws IOException {
			return null;
		}

		@Override
		public void registerConsumer() throws InterruptedException {
			
		}

		@Override
		public void registerProducer() {
			
		}

		@Override
		public void unregisterConsumer() {
			
		}

		@Override
		public void unregisterProducer() {
			
		}

		@Override
		public void initialized() {
			// TODO Auto-generated method stub
			
		}
	}
}
