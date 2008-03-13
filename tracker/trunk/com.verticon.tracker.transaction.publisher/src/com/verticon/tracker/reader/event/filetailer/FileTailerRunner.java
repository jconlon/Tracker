/**
 * 
 */
package com.verticon.tracker.reader.event.filetailer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IFile;

import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;
import com.verticon.tracker.util.TrackerLog;

/**
 * Runnable that scans a file for Long numbers and sends them
 * to a TransactionPublisher.
 * Used by the FileTailer Publisher.  
 * 
 * @see FileTailer
 * @author jconlon
 *
 */
public class FileTailerRunner implements Runnable {

	private final ITagIdPublisher transactionPublisher ;
	private final File file ;
	private final Set<Long> tagNumbersToSend = new HashSet<Long>();
	private final Set<Long> tagNumbersSent = new HashSet<Long>();
	
	
	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param transactionProcessor to send Long numbers to.
	 * @param file to Scan
	 */
	public FileTailerRunner(ITagIdPublisher transactionProcessor, IFile file) {
		this.transactionPublisher=transactionProcessor;
		this.file=new File(file.getLocationURI());
		TrackerLog.logInfo("Created FileTailRunner");
	}

	
	/**
	 * Scans the file and adds new tags to the Set of 
	 * tagNumbersToSend.
	 */
	public void run() {
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
			TrackerLog.logError("Could not find the tags file.", e);


		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		sendTags();

	}

	private void sendTags(){
		for (Long tag : tagNumbersToSend) {
			transactionPublisher.publish(tag);
			tagNumbersSent.add(tag);
		}
		
	}
}
