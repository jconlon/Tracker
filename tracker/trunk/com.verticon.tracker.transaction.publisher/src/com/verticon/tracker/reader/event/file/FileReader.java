/**
 * 
 */
package com.verticon.tracker.reader.event.file;

import java.io.IOException;
import java.net.URI;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.AbstractModelObject;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.reader.eventadmin.EventPublisher;
import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;
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
public class FileReader extends AbstractModelObject implements
		IReader, IResourceChangeListener {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(FileReader.class);
	
	private Preferences prefs = ReaderPlugin.getDefault()
	.getPluginPreferences();
	
	/**
	 * Keeps track of the count of FileReaders so a simple name appended 
	 * with a number is created as the default.
	 */
	private static int count;
	
	private String name = "";
	URI target = null;
	String template = "";
	boolean started = false;


	private ScheduledExecutorService exec;
	private ITagIdPublisher transactionPublisher = null;

	public FileReader(String name) {
		super();
		this.name=name;
	}
	
	public FileReader() {
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
				logger.error("Failed to start "+name, e);
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
	public URI getTarget() {
		return target;
	}

	public void setTarget(URI target) {
		URI oldValue = this.target;
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
	 * @see com.verticon.tracker.reader.event.file.FileReaderRunner
	 */
	private void start() throws IOException {
		if (transactionPublisher != null) {
			logger.info("{} is already Started ", name);
		} else if (transactionPublisher == null) {
			IFile templateFile = getTemplateFile();
			
			transactionPublisher = new EventPublisher( templateFile);
			transactionPublisher.init();

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(this);

			Runnable command = new FileReaderRunner(transactionPublisher, getTargetFile());
			exec = Executors.newScheduledThreadPool(1);
			exec.scheduleWithFixedDelay(command, 4, 
					prefs.getInt(PreferenceConstants.P_READ_INTERVAL), 
					TimeUnit.SECONDS);
			logger.info("{} monitoring {} at {} second intervals.", new Object[] {name, target, prefs.getInt(PreferenceConstants.P_READ_INTERVAL)});

		}
	}

	/**
	 * @return
	 */
	private IFile getTargetFile() {
		Path ipath;
		IFile ifile;
		ipath = new Path(getTarget().getPath());
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
			logger.info("{} stopped ",name);
		}
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(this);
	};

	private void reset() {
		if (isRunning()) {
			logger.info("{} reStarting",name);
			setStarted(false);
			setStarted(true);
		} 
	}

	private boolean isRunning() {
		return transactionPublisher != null;
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
				logger.error("Could not initialize the transactionPublisher for "+name,e);
			}
		}
		
	}

}
