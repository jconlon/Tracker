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

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newLinkedList;
import static com.verticon.tracker.irouter.common.TrackerConstants.CONNECTION_URI;
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CLEAR_FILE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.GET_NEXT_RECORD;
import static com.verticon.tracker.irouter.trutest.internal.Constants.INITIALIZATION_CONSUMER_SCOPE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.INITIALIZATION_CONSUMER_TIMEOUT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.NODE_LABEL;
import static com.verticon.tracker.irouter.trutest.internal.Constants.RESET_TO_FIRST_RECORD;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SELECT_LIFE_DATA_PAGE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_ACK;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_CRLF;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN;
import static org.osgi.framework.Constants.SERVICE_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_FLAVORS;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_SCOPE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Wire;
import org.osgi.service.wireadmin.WireConstants;
import org.osgi.util.measurement.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import com.verticon.tracker.irouter.common.Utils;

/**
 * Initializes the TruTest Proxy by downloading animal life data
 * to the a specified data 
 * @author jconlon
 *
 */
public class InitializerCallable implements Callable<Void>, Consumer{


	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(InitializerCallable.class);

	// Config for download Pattern?
	private final Pattern downloadPattern;
	
	private final String uploadRegEx;

	// Config for upload headerList?
	private final String fileHeaderList;

	private final File fileToUpload;
	private final File fileToDownload;
	private final IIndicator indicator;

	private Writer indicatorWriter = null;
	private BufferedReader indicatorReader = null;
	private String uri = null;
	private final String pid;
	private final String wiregroup;
	private final BundleContext bundleContext;
	private ServiceRegistration serviceRegistration = null;
	private CountDownLatch importUploadIsReady = new CountDownLatch(1);
	private ImmutableList<String> importedRecordsForUpload = null;
	private String recordImportedFromPid = null;
	

	/**
	 * 
	 * @param indicator
	 */
	public InitializerCallable(IIndicator indicator, BundleContext bundleContext) {
		super();
		this.fileToUpload = indicator.getUpload();
		this.fileToDownload = indicator.getDownload();
		this.indicator = indicator;
		fileHeaderList = Utils.fromAscii(indicator
				.getConfigurationString(FILE_HEADER_COMMAND));
		downloadPattern = Pattern.compile(indicator.getConfigurationString(DOWNLOAD_RECORD_PATTERN));
		uploadRegEx = indicator.getConfigurationString(UPLOAD_RECORD_PATTERN);
		pid=indicator.getPid();
		wiregroup=indicator.getConfigurationString(TRACKER_WIRE_GROUP_NAME);
		uri = indicator.getConfigurationString(CONNECTION_URI);
		this.bundleContext=bundleContext;
	}

	/**
	 * String representation shows pid and tracker wiregroup.
	 */
	@Override
	public String toString() {
		return "InitializerCallable [wiregroup="+ wiregroup+" pid=" + pid + "]";
	}
	
	@Override
	public Void call() throws Exception {
		// Initializing a connection may throw exceptions, which will cause a 
		// canceling of this session.

		initializeConnection();
//		log.debug("{} : starting with download pattern = {} uploadpattern = {}", new Object[]{this, indicator.getConfigurationString(DOWNLOAD_RECORD_PATTERN), indicator.getConfigurationString(UPLOAD_RECORD_PATTERN)});
		
		if(bundleContext !=null && indicator.getConfigurationString(INITIALIZATION_CONSUMER_SCOPE) !=null){
		  register(bundleContext, new String[]{indicator.getConfigurationString(INITIALIZATION_CONSUMER_SCOPE)});
		  log.info(bundleMarker, "{} register Consumer service",
					this);
		}else{
			//Configured as standalone, open the latch so there is no waiting
			importUploadIsReady.countDown();
		}
		

		// Do download before the uploads. 
		// All exceptions encountered in the download are caught and logged.
		try {
			download(fileToDownload);
		} catch (Exception e) {
			log.error(bundleMarker,this+" failed download.", e);
		}
		
		
		//wait for an import file to be ready
		boolean importUploadWasReady = importUploadIsReady.await(
				indicator.getConfigurationInteger(INITIALIZATION_CONSUMER_TIMEOUT)!=null?
						indicator.getConfigurationInteger(INITIALIZATION_CONSUMER_TIMEOUT):5, 
				TimeUnit.SECONDS);
		
		if(importUploadWasReady){
			log.info(bundleMarker, "{} import to upload was ready",
					this);
		}else{
			log.warn(bundleMarker, "{} import to upload was NOT ready",
					this);
		}
		//unregister consumer
		if(serviceRegistration !=null){
			serviceRegistration.unregister();
			log.debug(bundleMarker, "{} unregister Consumer service",
					this);
		}

		//Producer could either have sent a notification as a State indicating that the 
		if(importedRecordsForUpload!=null){
			//list of commands were sent. upload these
			upload(importedRecordsForUpload, recordImportedFromPid);
		}else{
			//upload the file, if it exists from the data sync directory
			upload(fileToUpload);
		}
		
		//Initialized completed.  Set gate on the indicator informing other components to start,
		//and this will not run again. 
		indicator.initialized();

		log.debug(bundleMarker,"{} terminated.", this);
		return null;
	}


	/**
	 * Uploads the records of a file to the indicator.
	 * @param from
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void upload(File from) throws IOException, InterruptedException{
		indicator.setUpLoadedRecords(0);
		if (!from.exists()) {
			log.info(bundleMarker,"{} deferred uploading. File: {} does not exist.", this,
					from);
			return;
		} 
		
		List<String> records =  Files.readLines(from, Charsets.UTF_8);
		upload(records, from.toString());
	}

	private void upload(List<String> records, String from) throws InterruptedException,
			IOException {
		log.info(bundleMarker,"{} uploading {} records from {} with pattern {}", 
				new Object[]{this, records.size(), from, this.uploadRegEx});

		int uploadedRecords=0;
		int fileRecordNumber=0;
		/*
		 * 
		 * 1. Optionally, turn acknowledgements on with {ZA1}. 2. Optionally,
		 * turn error responses on with {ZE1}. 3. Optionally change the bit rate
		 * to 38400 bps for faster uploading using {SEBX38400}.
		 * 
		 * 6. Optionally, use {FC} to clear the file if necessary. 7.
		 * Optionally, use various {FPxx} commands to set file properties as
		 * necessary (if file is empty). Any File properties that are not set
		 * will take defaults. If the indicator is only used with one type of
		 * load bars or load cells, the resolution etc will be set to what is
		 * normal for this indicator. 8. Optionally us various {SFxx} commands
		 * to set up the File Data fields, {SLxx} commands to set up Life Data
		 * fields, and {SOCU} to set up custom field values. 9. Use {FI...} to
		 * specify which fields are to be uploaded. 10. Use {FU} to upload each
		 * record. Use CRCs in every upload record if required. 11. Use a long
		 * timeout of 20 seconds, because sometimes the indicator must spend
		 * time rearranging the heap during an upload.
		 */

		// 4. Optionally, select the page that is to be downloaded using {FGss}
		// (defaults to File data).
		// {FGLD} for

		// 5. Optionally, change the file using {FFn} (defaults to the current
		// file).

		/*
		 * 6. Optionally, use {FC} to clear the file if necessary.
		 */


		/*
		 * 
		 * 7. Optionally, use various {FPxx} commands to set file properties as
		 * necessary (if file is empty). Any File properties that are not set
		 * will take defaults. If the indicator is only used with one type of
		 * load bars or load cells, the resolution etc will be set to what is
		 * normal for this indicator. 8. Optionally us various {SFxx} commands
		 * to set up the File Data fields, {SLxx} commands to set up Life Data
		 * fields, and {SOCU} to set up custom field values.
		 * 
		 * 
		 * 9. Use {FI...} to specify which fields are to be uploaded. {FH}
		 * [F1AEID] {FH} [F2ATAG] {FH} [F3NBW Mult] {FH} [F4OSPECIES] {FH} []
		 */

		List<String> commandsQueue = newLinkedList();
		commandsQueue.add(TURN_ON_CRLF);
		commandsQueue.add(TURN_ON_ACK);
		//			commandsQueue.add(TURN_ON_ERROR_CODES);
		commandsQueue.add(SELECT_LIFE_DATA_PAGE);
		commandsQueue.add(CLEAR_FILE);
		commandsQueue.add(fileHeaderList);
		/*
		 * 
		 * 10. Use {FU} to upload each record. Use CRCs in every upload record
		 * if required. 11. Use a long timeout of 20 seconds, because sometimes
		 * the indicator must spend time rearranging the heap during an upload.
		 */
		// // EID TAG BWMult SPECIES
		// String[] records = new String[]{
		// "{FU123456789012345,1234,0.01,1}\r",
		// "{FU123456789012346,4321,0.02,2}\r",
		// "{FU123456789012347,1111,0.03,1}\r"
		// };
		//		
		// commandQueue.put(records);

		for (String record : records) {
			TimeUnit.MILLISECONDS.sleep(100);
			String command = null;
			while(!commandsQueue.isEmpty()){
				command = commandsQueue.remove(0);
				indicatorWriter.write(command);
				indicatorWriter.flush();
				log.debug(bundleMarker,"{} upload request {} ", this, command);
				String response = indicatorReader.readLine();
				log.debug(bundleMarker,"{} upload response {}",this, response);

			}

			fileRecordNumber++;
			String indicatorRecordCommand = createIndicatorRecordCommand(record,fileRecordNumber);
			if(indicatorRecordCommand != null && indicatorRecordCommand.equals("BAD")){
				log.warn("{} upload record <{}> from {} at line number {} failed to match pattern {}",
						new Object[]{this, record, from, fileRecordNumber, uploadRegEx});  
			}else if (indicatorRecordCommand != null) {
				log.debug(bundleMarker, "{} upload record number {} as command {}",
						new Object[] {this, fileRecordNumber, indicatorRecordCommand});
				commandsQueue.add(indicatorRecordCommand);
				uploadedRecords++;
			} 
		}

		indicator.setUpLoadedRecords(uploadedRecords);
		log.info(bundleMarker,"{} uploaded: {} records from {}", new Object[]{this, uploadedRecords, from});
	}
	
	private void download(File to) throws IOException, InterruptedException {
		indicator.setDownLoadedRecords(0);
		int downloadedRecords = 0;
		/*
		 * Get each record. An empty response means there are no
		 * more records.
		 */
		List<String> commandsQueue = newLinkedList();
		commandsQueue.add(TURN_ON_CRLF);
		commandsQueue.add(TURN_ON_ACK);
//		commandsQueue.add(TURN_ON_ERROR_CODES);
		commandsQueue.add(SELECT_LIFE_DATA_PAGE);
		commandsQueue.add(RESET_TO_FIRST_RECORD);

		Matcher matcher = downloadPattern.matcher("");
		while (!Thread.currentThread().isInterrupted()) {
			TimeUnit.MILLISECONDS.sleep(100);
			String command = null;
			if(!commandsQueue.isEmpty()){
				command = commandsQueue.remove(0);
				indicatorWriter.write(command);
				indicatorWriter.flush();
				log.debug(bundleMarker,"{} download request {} ", this, command);
			}

			String indicatorRecord = indicatorReader.readLine();
			if (indicatorRecord.startsWith("[]")) {
				log.debug(bundleMarker,"{} no more download data",this);
				break;
			} else if (indicatorRecord.startsWith("[")) {
				log.debug(bundleMarker,"{} download record {}",this, indicatorRecord);
				String fileRecord = normalize(matcher, indicatorRecord);
				if (fileRecord != null) {
					if(downloadedRecords==0){
						Files.write(fileRecord + "\r\n", to, Charsets.UTF_8);
					}else{
						Files.append(fileRecord + "\r\n", to, Charsets.UTF_8);
					}
					downloadedRecords++;
				} else {
					log.error(bundleMarker,
							"{} download record <{}> failed to match the download pattern.", this, indicatorRecord);
				}
			} else {
				log.debug(bundleMarker,"{} download response <{}>",this, indicatorRecord);
			}

			if(commandsQueue.isEmpty()){
				commandsQueue.add(GET_NEXT_RECORD);
			}

		}
		indicator.setDownLoadedRecords(downloadedRecords);
		log.info(bundleMarker,"{} downloaded: {} records to {}", new Object[]{this, downloadedRecords, to});
		
	}

	

	/**
	 * Remove brackets, and record index from indicatorRecord
	 * @param indicatorRecord in the form of: [7,900014000554939,444,0.01,1]
	 * @return cleanup record
	 */
	public static String normalize(Matcher matcher, String indicatorRecord) {
		matcher.reset(indicatorRecord.trim());
		if (matcher.matches()) {
			return matcher.group(1);
		}
		return null;
	}

	

	/**
	 * 
	 * Will process input lines that look like:
	 * 900014000554952,0000,0.01,1
	 * to make them look like
	 * "{FU123456789012345,1234,0.01,1}\r"
	 * 
	 * @param fileRecord
	 * @return indicatorRecordCommand
	 */
	final String createIndicatorRecordCommand(String fileRecord, int fileRecordNumber) {
		if (fileRecord ==null){
			return null;
		}

		if (fileRecord.matches(uploadRegEx)) {
			return "{FU"+fileRecord+"}\r";
		}
		return "BAD";
	}

	private void initializeConnection() throws NoRouteToHostException,
			UnknownHostException, ConnectException, IOException {
		// There is a fixed 5 second timeout on socket if it blocking
		// waiting on a read. (there is no traffic)
		try {
			
			indicatorReader = indicator.getReader();
			indicatorWriter = new BufferedWriter(indicator.getWriter());
		} catch (NoRouteToHostException e) {
			log.warn(bundleMarker,"{} no route to host {} ", this, uri);
			throw e;
		} catch (UnknownHostException e) {
			log.warn(bundleMarker,"{} unknown host {}", this, uri);
			throw e;
		} catch (ConnectException e) {
			log.warn(bundleMarker,"{} couldn't connect to: {} because {}", new Object[] {
					this, uri, e.getMessage() });
			throw e;
		} catch (IOException e) {
			log.warn(bundleMarker,"{} io exception connecting to: {} because {}",
					new Object[] { this, uri, e.getMessage() });
			throw e;
		}
	}
	
	
	/**
	 * Register as an OSGi consumer service to listen for a Producer send an 
	 * State indicating a file is ready or a Producer sending a list of commands
	 * to upload.
	 * @param bc
	 * @throws InterruptedException
	 */
	private void register(BundleContext bc, String[] scope) throws InterruptedException {
		Hashtable<String, Object> regProps = new Hashtable<String, Object>();
		regProps.put(SERVICE_PID, indicator.getPid());
		regProps.put(WIREADMIN_CONSUMER_FLAVORS,
				new Class[] { State.class, List.class });
		regProps.put(TRACKER_WIRE_GROUP_NAME, indicator
				.getConfigurationString(TRACKER_WIRE_GROUP_NAME));
		regProps.put(CONNECTION_URI, indicator
				.getConfigurationString(CONNECTION_URI));
		regProps.put(NODE_LABEL, "TruTest Initializer");
		
		regProps.put(WIREADMIN_CONSUMER_SCOPE,scope);
		serviceRegistration = bc.registerService(Consumer.class.getName(),
				this, regProps);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updated(Wire wire, Object value) {
		if(value instanceof State){
			log.info(bundleMarker, "{} received value={}, upload in datasync directory ",
					this,value);
		}else if(value instanceof List){
			log.info(bundleMarker, "{} received list of records to upload",
					this);	
			Collection<String> records = transform(
					filter((List<Object>)value, instanceOf(String.class)),//collection of IExternalNodes 
					new Function<Object, String>(){
						@Override
						public String apply(Object input) {
							return (String) input;
						}}
			);
			recordImportedFromPid = (String)wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID);
			
			importedRecordsForUpload=ImmutableList.copyOf(records);
		}
		
		importUploadIsReady.countDown();
	}
	
	

	@Override
	public void producersConnected(Wire[] wires) {
		if(wires==null || wires.length==0){
			log.info(bundleMarker, "{} disconnected from all producers",this);
			return;
		}
		for (Wire wire : wires) {
			log.info(bundleMarker, "{} connected to producer={}",
					this,wire.getProperties().get(WireConstants.WIREADMIN_PRODUCER_PID));
		}
		
	}

}
