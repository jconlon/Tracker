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
/**
 * 
 */
package com.verticon.tracker.reader.event.generator;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;

/**
 * Runnable that scans a file for Long numbers and randomly 
 * chooses one to send to a ITagIdPublisher.
 *
 * 
 * @see GeneratingReader
 * @author jconlon
 *
 */
class GeneratingReaderRunner implements Runnable {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(GeneratingReaderRunner.class);
	private final ITagIdPublisher tagIDPublisher ;
	private final File file ;
	
	private final List<Long> cache = new ArrayList<Long>();
	
	private final IReader reader;
	
	
	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param transactionProcessor to send Long numbers to.
	 * @param file to Scan
	 */
	protected GeneratingReaderRunner(IReader reader, ITagIdPublisher transactionProcessor, IFile file) {
		this.tagIDPublisher=transactionProcessor;
		this.reader = reader;
		this.file=new File(file.getLocationURI());
	}

	
	/**
	 * Scans the file and adds new tags to the Set of 
	 * tagNumbersToSend.
	 */
	public void run() {
		if(cache.isEmpty()){
			loadTags();
		}
		if(cache.isEmpty()){
			return;
		}
		sendARandomTag();

	}
	
	
	private void loadTags(){
		Scanner sc = null;
		Long tag = null;
		try {
			sc = new Scanner(file);
			
			while (sc.hasNextLong()) {
				tag = sc.nextLong();
				
					cache.add(tag);
			}

		} catch (FileNotFoundException e) {
			logger.error(reader+" could not find the tags file.", e);


		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	
	private void sendARandomTag(){
		int index = (int) (Math.random() * cache.size());
		Long tag = cache.get(index);
		logger.debug(bundleMarker,"Sending {} which is #{} out of {} cached tags.",
				new Object[]{tag, index, cache.size()});
		tagIDPublisher.publish(tag);
	}
}
