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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.connector.socket.SocketStreamConnection;
import com.verticon.tracker.irouter.trutest.internal.Constants;
import com.verticon.tracker.irouter.trutest.internal.IIndicator;
import com.verticon.tracker.irouter.trutest.internal.InitializerCallable;

import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.DOWNLOAD_RECORD_PATTERN_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND;
import static com.verticon.tracker.irouter.trutest.internal.Constants.FILE_HEADER_COMMAND_DEFAULT;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN;
import static com.verticon.tracker.irouter.trutest.internal.Constants.UPLOAD_RECORD_PATTERN_DEFAULT;

/**
 * This is an online test of the IntializerCallable. It tests the downloading
 * and uploading of data.
 * 
 * @author jconlon
 * 
 * 
 */
public class IntializerCallableTest {

	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(IntializerCallableTest.class);

	private SocketStreamConnection connection = null;
	private Writer fileWriter;
	BlockingQueue<String[]> commandQueue = null;
	private MockIndicator indicator = null;
	private InitializerCallable initializerCallable = null;

	@Before
	public void setUp() throws Exception {
		indicator = new MockIndicator();
		initializerCallable = new InitializerCallable(indicator, null);
		commandQueue = new LinkedBlockingQueue<String[]>();

	}

	@After
	public void tearDown() throws Exception {
		if (connection != null) {
			connection.close();
			connection = null;
		}
		if (fileWriter != null) {
			fileWriter.close();
			fileWriter = null;
		}
		commandQueue = null;
	}

	@Test
	public final void testDownloadRecordPattern_normalize() {
		log.debug(
				"Testing the Download record pattern used by the normalize method with default pattern {}",
				UPLOAD_RECORD_PATTERN_DEFAULT);

		assertEquals(DOWNLOAD_RECORD_PATTERN_DEFAULT,
				indicator.getConfigurationString(DOWNLOAD_RECORD_PATTERN));

		Pattern pattern = Pattern.compile(indicator
				.getConfigurationString(DOWNLOAD_RECORD_PATTERN));
		Matcher matcher = pattern.matcher("");

		assertEquals("Should be a valid value to normalize",
				"900014000554784,555,0.01,1", InitializerCallable.normalize(
						matcher, "[0,900014000554784,555,0.01,1]"));

		assertNull(
				"Should not be a valid pattern - not enough numbers in the tag",
				InitializerCallable.normalize(matcher,
						"[900014000554784,555,0.01,1]"));
	}

	/**
	 * 
	 * Will process input lines that look like: 900014000554952,0000,0.01,1 to
	 * make them look like "{FU123456789012345,1234,0.01,1}\r"
	 * 
	 **/
	@Test
	public void test_UploadRecordPattern_CreateIndicatorRecordCommand_default() {
		log.debug(
				"Testing the upload record pattern used by the createIndicatorRecordCommand method with default pattern {}",
				UPLOAD_RECORD_PATTERN_DEFAULT);

		assertEquals(UPLOAD_RECORD_PATTERN_DEFAULT,
				indicator.getConfigurationString(UPLOAD_RECORD_PATTERN));

		assertEquals("^[0-9]{15,15},[0-9]{4,4},\\d.\\d\\d,[1-2]$",
				indicator.getConfigurationString(UPLOAD_RECORD_PATTERN));

		// Good record
		assertEquals("{FU123456789012345,1234,0.01,1}\r",
				initializerCallable.createIndicatorRecordCommand(
						"123456789012345,1234,0.01,1", 1));

		// Good record
		assertEquals("{FU900014000554952,1224,0.01,1}\r",
				initializerCallable.createIndicatorRecordCommand(
						"900014000554952,1224,0.01,1", 2));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				"90001400055495,0000,0.01,1", 3));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				"900014000554952,1234,2,0.01", 4));

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
		
		// "^[0-9]{15,15},[0-9]{4,4},[1-2],\\d.\\d\\d$"
		String matcher = "^[0-9]{15,15}?,[0-9]{4,4}?,[1-2],\\d.\\d\\d$";

		String record = "900014000554756,1831,1,0.02";// 900014000554811,1854,1,0.01";

		assertTrue(record.matches(matcher));

		indicator.regex = matcher;
		initializerCallable = new InitializerCallable(indicator, null);
		//
		// Pattern pattern= Pattern.compile(alternate);
		// Matcher matcher = pattern.matcher("");

		// Good record<>
		assertEquals("{FU900014000554811,1854,1,0.01}\r",
				initializerCallable.createIndicatorRecordCommand(
						"900014000554811,1854,1,0.01", 1));

		// Good record
		assertEquals("{FU123456789012345,1234,2,0.01}\r",
				initializerCallable.createIndicatorRecordCommand(
						"123456789012345,1234,2,0.01", 2));

		// Good record
		assertEquals("{FU900014000554952,1224,1,0.01}\r",
				initializerCallable.createIndicatorRecordCommand(
						"900014000554952,1224,1,0.01", 3));

		// BAD record
		assertEquals("BAD", initializerCallable.createIndicatorRecordCommand(
				"90001400055495,0000,0.01,1", 4));

	}

	static class MockIndicator implements IIndicator {

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
			if (key.equals(UPLOAD_RECORD_PATTERN)) {
				return regex;
			} else if (key.equals(FILE_HEADER_COMMAND)) {
				return FILE_HEADER_COMMAND_DEFAULT;
			} else if (key.equals(DOWNLOAD_RECORD_PATTERN)) {
				return DOWNLOAD_RECORD_PATTERN_DEFAULT;
			}
			return null;
		}

		@Override
		public File getDownload() {
			return null;
		}

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
			
		}

		@Override
		public void registerMonitorable() {
			
		}

		@Override
		public void unregisterMonitorable() {
			
		}

		@Override
		public void setUpLoadedRecords(int upLoadedRecords) {
			
		}

		@Override
		public void setDownLoadedRecords(int downLoadedRecords) {
			
		}

		@Override
		public String[] getConfigurationStringArray(String key) {
			return null;
		}
	}
}
