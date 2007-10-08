/**
 * 
 */
package com.verticon.tracker.transaction.publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IFile;

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
public class FileTailRunner implements Runnable {

	private final TransactionPublisher transactionPublisher ;
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
	public FileTailRunner(TransactionPublisher transactionProcessor, IFile file) {
		this.transactionPublisher=transactionProcessor;
		this.file=new File(file.getLocationURI());
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
