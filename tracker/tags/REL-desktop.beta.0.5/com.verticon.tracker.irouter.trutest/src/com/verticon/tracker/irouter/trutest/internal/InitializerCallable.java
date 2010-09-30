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
import static com.verticon.tracker.irouter.common.TrackerConstants.TRACKER_WIRE_GROUP_NAME;
import static com.verticon.tracker.irouter.trutest.internal.Component.bundleMarker;
import static com.verticon.tracker.irouter.trutest.internal.Constants.CLEAR_FILE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.GET_NEXT_RECORD;
import static com.verticon.tracker.irouter.trutest.internal.Constants.RESET_TO_FIRST_RECORD;
import static com.verticon.tracker.irouter.trutest.internal.Constants.SELECT_LIFE_DATA_PAGE;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_ACK;
import static com.verticon.tracker.irouter.trutest.internal.Constants.TURN_ON_CRLF;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.Utils;

public class InitializerCallable implements Callable<Void> {


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
	
	

	/**
	 * 
	 * @param indicator
	 */
	public InitializerCallable(IIndicator indicator) {
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
		

		// Do any downloads before the uploads. 
		// All exceptions encountered in the download are caught and logged.
		download();

		// Do any uploads last
		upload();
		
		//Initialized completed.  Set gate on the indicator informing other components to start,
		//and this will not run again. 
		indicator.initialized();
		
//		indicator.getStartGate().countDown();
//		log.debug("{} : Waiting to terminate.", this);
//		indicator.getEndGate().await();
		log.debug(bundleMarker,"{} terminated.", this);
		return null;
	}

   void upload(){
	    indicator.setUpLoadedRecords(0);
		if (!fileToUpload.exists()) {
			log.info(bundleMarker,"{} deferred uploading. File: {} does not exist.", this,
					fileToUpload);
		} else {
			log.info(bundleMarker,"{} uploading: {} with pattern {}", new Object[]{this, fileToUpload, this.uploadRegEx});
			BufferedReader fileReader = null;
			try {
				fileReader = new BufferedReader(new FileReader(
						fileToUpload));
				int records = uploadFile(fileReader);
				indicator.setUpLoadedRecords(records);
				log.info(bundleMarker,"{} uploaded: {} records to {}", new Object[]{this, records, fileToUpload});
			} catch (Exception e) {
				log.error(bundleMarker,this + " failed to upload: " + fileToUpload, e);
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					log.error(bundleMarker,this + " failed to close the filReader for file: " + fileToUpload, e);
				}
			}
		}
	}

	private void download() {
		indicator.setDownLoadedRecords(0);
		BufferedWriter fileWriter = null;
		try {
		    fileWriter = new BufferedWriter(new FileWriter(
					fileToDownload));
			log.info(bundleMarker,"{} downloading: {} with pattern {}", new Object[]{this, fileToDownload, downloadPattern});
			int records = downloadFile(fileWriter);
			indicator.setDownLoadedRecords(records);
			log.info(bundleMarker,"{} downloaded: {} records to {}", new Object[]{this, records, fileToDownload});
		} catch (Exception e) {
			log.error(bundleMarker,this + " failed to download: " + fileToDownload, e);
		} finally {
			try {
				if(fileWriter!=null){
					fileWriter.close();
				}
			} catch (IOException e) {
				log.error(this + " failed to close the fileWriter for file: " + fileToDownload, e);
			}
		}
	}

	/**
	 * Down load the indicator records to the file.
	 * 
	 * @return number of down loaded records
	 * @throws Exception
	 */
	private int downloadFile(BufferedWriter fileWriter) throws Exception {
		int downloadedRecords = 0;
		
		/*
		 * Get each record. An empty response means there are no
		 * more records.
		 */
		List<String> commandsQueue = new LinkedList<String>();
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
					fileWriter.write(fileRecord + "\r\n");
					fileWriter.flush();
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
		return downloadedRecords;
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
	 * Up load the file to the indicator.
	 * @param fileReader
	 * @return number of uploaded records
	 * @throws Exception
	 */
	private int uploadFile(BufferedReader fileReader) throws Exception {

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
	    
		List<String> commandsQueue = new LinkedList<String>();
		commandsQueue.add(TURN_ON_CRLF);
		commandsQueue.add(TURN_ON_ACK);
//		commandsQueue.add(TURN_ON_ERROR_CODES);
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

		/*
		 * 9. Use {FN} to get each record. An empty response means there are no
		 * more records.
		 */
		while (!Thread.currentThread().isInterrupted()) {
			TimeUnit.MILLISECONDS.sleep(100);
			String command = null;
			if(!commandsQueue.isEmpty()){
				command = commandsQueue.remove(0);
				indicatorWriter.write(command);
				indicatorWriter.flush();
				log.debug(bundleMarker,"{} upload request {} ", this, command);
				String response = indicatorReader.readLine();
				log.debug(bundleMarker,"{} upload response {}",this, response);

			}
			
			if(commandsQueue.isEmpty()){
				String fileRecord = fileReader.readLine();
				fileRecordNumber++;
				String indicatorRecordCommand = createIndicatorRecordCommand(fileRecord,fileRecordNumber);
				if(indicatorRecordCommand != null && indicatorRecordCommand.equals("BAD")){
					log.warn("{} upload record <{}> from file at line number {} failed to match pattern.",
							new Object[]{this, fileRecord, fileRecordNumber});  
				}else if (indicatorRecordCommand != null) {
					log.debug(bundleMarker, "{} upload record number {} as command {}",
							new Object[] {this, fileRecordNumber, indicatorRecordCommand});
					commandsQueue.add(indicatorRecordCommand);
					uploadedRecords++;
				} else {
					break;
				}
			}
		}

		return uploadedRecords;
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

}
