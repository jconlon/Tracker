/**
 * 
 */
package com.verticon.tracker.transaction.publisher;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;

import com.verticon.tracker.transaction.publisher.actions.FileTailRunner;
import com.verticon.tracker.transaction.publisher.actions.TransactionPublisher;
import com.verticon.tracker.transaction.publisher.preferences.PreferenceConstants;
import com.verticon.transaction.editor.console.ConsoleUtil;

/**
 * Publisher that tails a file looking for new tags being added to the
 * end of the file.
 * Uses preferences to specify
 * <ul>
 * 	<li>the template file to use for building events,</li>
 * 	<li>the capture file where tags are being added</li>
 *  <li>an interval for rereading the capture file.</li>
 *  </ul>
 * 
 * @author jconlon
 * 
 */
public class FileTailPublisher extends PreferenceConstants implements
		IPropertyChangeListener, Publisher {

	public FileTailPublisher() {
		super();
	}

	private static final String DESCRIPTION = "File Tailing Event Publisher";

	@Override
	public String toString() {
		
		return CONSOLE
			+"; "+prefs.getString(P_TEMPLATE_FILE)
			+"; "+prefs.getString(P_CAPTURE_FILE);
	}

	private static final String CONSOLE = FileTailPublisher.class.getSimpleName();

	private Preferences prefs = TrackerFileTailPublisherPlugin.getDefault()
			.getPluginPreferences();

	private ScheduledExecutorService exec;

	private TransactionPublisher tp = null;

	/**
	 * Start a background task using a FileTailRunner to process the file and 
	 * feed new tags to a TransactionPublisher.
	 * 
	 * @see com.verticon.tracker.transaction.publisher.actions.FileTailRunner
	 * @see com.verticon.tracker.transaction.publisher.actions.TransactionPublisher
	 */
	public void start() throws IOException {
		if (tp != null ) {
			log("Already Started ");
		} else if (tp == null) {
			String path = prefs.getString(P_TEMPLATE_FILE);
			Path ipath = new Path(path);
			IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(
					ipath);
			tp = new TransactionPublisher(ifile);

			path = prefs.getString(P_CAPTURE_FILE);
			ipath = new Path(path);
			ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(ipath);

			Runnable command = new FileTailRunner(tp, ifile);
			exec = Executors.newScheduledThreadPool(1);
			exec.scheduleWithFixedDelay(command, 4, prefs
					.getInt(P_READ_INTERVAL), TimeUnit.SECONDS);
			log("Started ");
		}
	};

	/**
	 * Stop the background task.
	 */
	public void stop() {
		tp = null;
		if(exec!=null){
			exec.shutdownNow();
			exec = null;
		}
	};

	/**
	 * Watches for changes to the Preferences settings.
	 * 
	 * @see org.eclipse.core.runtime.Preferences.IPropertyChangeListener#propertyChange(org.eclipse.core.runtime.Preferences.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(P_READ_INTERVAL)
				|| event.getProperty().equals(P_TEMPLATE_FILE)
				|| event.getProperty().equals(P_CAPTURE_FILE)) {
			reset();
		}
	}

	private void reset() {
		if ( isRunning()) {
			log("ReStarting");
			stop();
			try {
				start();
			} catch (IOException e) {
				log("Failed to start because: " + e);
			}
		} else if ( !isRunning()) {
			log("Starting");
			try {
				start();
			} catch (IOException e) {
				log("Failed to start because: " + e);
			}
		} 
	}

	/**
	 * 
	 */
	public void logStatus() {
		log(this.getClass().getSimpleName() 
				+ "\n\trunning = "+ isRunning() 
				+ "\n\tcapture file read interval = "+ prefs.getInt(P_READ_INTERVAL) 
				+ "\n\tcapture file = "+ prefs.getString(P_CAPTURE_FILE) 
				+ "\n\ttemplate file = "+prefs.getString(P_TEMPLATE_FILE)

		);
	}

	private boolean isRunning() {
		return tp != null;
	}

	public static void log(String msg) {
//		ConsoleUtil.showConsole(CONSOLE);
		ConsoleUtil.println(CONSOLE, new Date()+"\t"+msg);
	}

	public String getDescription() {
		return DESCRIPTION;
	}

	public String getName() {
		return CONSOLE;
	}

	public String getStatus() {
		return isRunning()?"isRunning":"isStopped";
	}

	public String getTarget() {
		return prefs.getString(P_CAPTURE_FILE);
	}

	public String getTemplate() {
		return prefs.getString(P_TEMPLATE_FILE);
	}
}
