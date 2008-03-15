/**
 * 
 */
package com.verticon.tracker.reader.event.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;

import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;
import com.verticon.tracker.util.TrackerLog;

/**
 * Runnable that scans a file for Long numbers and randomly 
 * chooses one to send to a ITagIdPublisher.
 *
 * 
 * @see GeneratingReader
 * @author jconlon
 *
 */
public class GeneratingReaderRunner implements Runnable {

	private final ITagIdPublisher tagIDPublisher ;
	private final File file ;
	
	private final List<Long> cache = new ArrayList<Long>();
	
	
	/**
	 * 
	 * Primary Constructor
	 * 
	 * @param transactionProcessor to send Long numbers to.
	 * @param file to Scan
	 */
	public GeneratingReaderRunner(ITagIdPublisher transactionProcessor, IFile file) {
		this.tagIDPublisher=transactionProcessor;
		this.file=new File(file.getLocationURI());
		TrackerLog.logInfo("Created "+this.getClass().getSimpleName());
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
	
	
	void loadTags(){
		Scanner sc = null;
		Long tag = null;
		try {
			sc = new Scanner(file);
			
			while (sc.hasNextLong()) {
				tag = sc.nextLong();
				
					cache.add(tag);
			}

		} catch (FileNotFoundException e) {
			TrackerLog.logError("Could not find the tags file.", e);


		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	
	private void sendARandomTag(){
		int index = (int) (Math.random() * cache.size());
		Long tag = cache.get(index);
		TrackerLog.logInfo("Sending "+ tag +" index "+index+
				" out of "+ cache.size() +" cached tags.");
		tagIDPublisher.publish(tag);
	}
}
