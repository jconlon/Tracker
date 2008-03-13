/**
 * 
 */
package com.verticon.tracker.reader.event.filetailer;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Preferences;

import com.verticon.tracker.editor.util.ConsoleUtil;
import com.verticon.tracker.reader.AbstractModelObject;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;
import com.verticon.tracker.reader.eventadmin.EventPublisher;
import com.verticon.tracker.reader.preferences.PreferenceConstants;

/**
 * Publisher that tails a file looking for new tags being added to the end of
 * the file. Uses preferences to specify
 * <ul>
 * <li>the template file to use for building events,</li>
 * <li>the capture file where tags are being added</li>
 * <li>an interval for rereading the capture file.</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class FileTailerEventReader extends AbstractModelObject implements
		IReader, IResourceChangeListener {

	private static final String CONSOLE = FileTailerEventReader.class.getSimpleName();
	private Preferences prefs = ReaderPlugin.getDefault()
	.getPluginPreferences();
	
	private static int count;
	
	private String name = "";
	String target = "";
	String template = "";
	boolean started = false;


	private ScheduledExecutorService exec;
	private ITagIdPublisher transactionPublisher = null;

	public FileTailerEventReader(String name) {
		super();
		this.name=name;
	}
	
	public FileTailerEventReader() {
		super();
		name=getType()+count++;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean start) {
		boolean oldValue = this.started;
		if(start){
			try {
				start();
			} catch (IOException e) {
				printToConsoleWithName("Failed to start because: " + e);
				return;
			}
		}else{
			stop();
		}
		this.started = start;
		firePropertyChange("started", oldValue, started);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getDescription()
	 */
	public String getType() {
		return this.getClass().getSimpleName();
	}

	public void setType(String type) {
		throw new UnsupportedOperationException(
				"Setting the type is unsupported");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getTemplate()
	 */
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		String oldValue = this.template;
		this.template = template;
		firePropertyChange("template", oldValue, template);
		reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getTarget()
	 */
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		String oldValue = this.target;
		this.target = target;
		firePropertyChange("target", oldValue, target);
		reset();
	}

	@Override
	public String toString() {
		return getType() + ' ' + getName();
	}

	/**
	 * Start a background task using a FileTailRunner to process the file and
	 * feed new tags to a TransactionPublisher.
	 * 
	 * @see com.verticon.tracker.reader.event.filetailer.FileTailerRunner
	 */
	private void start() throws IOException {
		if (transactionPublisher != null) {
			printToConsoleWithName("Already Started ");
		} else if (transactionPublisher == null) {
			IFile templateFile = getTemplateFile();
			
			transactionPublisher = new EventPublisher( templateFile);
			transactionPublisher.init();

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(this);

			Runnable command = new FileTailerRunner(transactionPublisher, getTargetFile());
			exec = Executors.newScheduledThreadPool(1);
			exec.scheduleWithFixedDelay(command, 4, 
					prefs.getInt(PreferenceConstants.P_READ_INTERVAL), 
					TimeUnit.SECONDS);
			printToConsoleWithName(
					"Started monitoring "+target+" at "+
					prefs.getInt(PreferenceConstants.P_READ_INTERVAL)+" second intervals.");
		}
	}

	/**
	 * @return
	 */
	private IFile getTargetFile() {
		Path ipath;
		IFile ifile;
		ipath = new Path(getTarget());
		ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(ipath);
		return ifile;
	}

	/**
	 * @return
	 */
	private IFile getTemplateFile() {
		Path ipath = getTemplatePath();
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				ipath);
		return ifile;
	}

	/**
	 * @return
	 */
	private Path getTemplatePath() {
		Path ipath = new Path(getTemplate());
		return ipath;
	};

	/**
	 * Stop the background task.
	 */
	private void stop() {
		transactionPublisher = null;
		if (exec != null) {
			exec.shutdownNow();
			exec = null;
			printToConsoleWithName("Stopped ");
		}
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(this);
	};

	private void reset() {
		if (isRunning()) {
			printToConsoleWithName("ReStarting");
			setStarted(false);
			setStarted(true);
		} 
	}

	private boolean isRunning() {
		return transactionPublisher != null;
	}

	private static void printToConsole(String msg) {
		ConsoleUtil.println(CONSOLE, new Date()
				+ "\t" + msg);
	}
	
	private void printToConsoleWithName(String msg) {
		printToConsole(name+'\t'+msg);
	}

	/**
	 * Listen for resource changes to the template File
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		//we are only interested if there is a transactionPublisher
		if(transactionPublisher==null){
			return;
		}
		 //we are only interested in POST_CHANGE events
        if (event.getType() != IResourceChangeEvent.POST_CHANGE)
           return;
        
        IResourceDelta rootDelta = event.getDelta();
        IResourceDelta templateDelta = rootDelta.findMember(getTemplatePath());
        if (templateDelta == null)
           return;
        
        
		if(transactionPublisher!=null){
			try {
				transactionPublisher.init();
			} catch (IOException e) {
				printToConsoleWithName(e.getMessage());
			}
		}
		
	}

}
