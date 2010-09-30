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
package com.verticon.tracker.reader.event.file;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;


/**
 * Runnable that scans a file for Long numbers and sends them
 * to a ITagIdPublisher.
 * 
 * @see FileReader
 * @author jconlon
 *
 */
class FileReaderRunner implements Runnable {
	private final Logger logger = LoggerFactory.getLogger(FileReaderRunner.class);
	private final ITagIdPublisher tagIdPublisher ;
	private final File file ;
	private final Set<Long> tagNumbersToSend = new HashSet<Long>();
	private final Set<Long> tagNumbersSent = new HashSet<Long>();
	private final IReader reader;
	
	
	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param transactionProcessor to send Long numbers to.
	 * @param file to Scan
	 */
	protected FileReaderRunner(IReader reader,ITagIdPublisher transactionProcessor, IFile file) {
		this.tagIdPublisher=transactionProcessor;
		this.file=new File(file.getLocationURI());
		this.reader=reader;
	}

	
	/**
	 * Scans the file and adds new tags to the Set of 
	 * tagNumbersToSend.
	 */
	public void run() {
		logger.debug(bundleMarker,"{} scanning for new TagIds in {}",reader,file.getAbsolutePath());
		tagNumbersToSend.clear();
		Scanner sc = null;
		Long tag = null;
		try {
			sc = new Scanner(file);
			
			while (sc.hasNextLong()) {
				tag = sc.nextLong();
				if(!tagNumbersSent.contains(tag)){
					tagNumbersToSend.add(tag);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error(reader+" could not find "+file.getAbsolutePath()+" tags file.", e);


		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		sendTags();

	}

	private void sendTags(){
		for (Long tag : tagNumbersToSend) {
			tagIdPublisher.publish(tag);
			tagNumbersSent.add(tag);
		}
		
	}
}
