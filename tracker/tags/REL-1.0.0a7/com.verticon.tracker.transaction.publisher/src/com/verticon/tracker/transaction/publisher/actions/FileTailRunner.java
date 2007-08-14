/**
 * 
 */
package com.verticon.tracker.transaction.publisher.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import com.verticon.tracker.util.TrackerLog;

/**
 * @author jconlon
 *
 */
public class FileTailRunner implements Runnable {

	private final TransactionPublisher tp ;
	private final File file ;
	private final Set<Long> tagNumbersToSend = new HashSet<Long>();
	private final Set<Long> tagNumbersSent = new HashSet<Long>();
	
	/**
	 * 
	 */
	public FileTailRunner(TransactionPublisher tp, IFile file) {
		this.tp=tp;
		this.file=new File(file.getLocationURI());
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
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
		send();

	}

	private void send(){
		for (Long tag : tagNumbersToSend) {
			tp.publish(tag);
			tagNumbersSent.add(tag);
		}
		
	}
}
