/**
 * 
 */
package com.verticon.tracker.reader.event.file;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;
import static com.verticon.tracker.reader.event.file.PreferenceConstants.P_READ_INTERVAL;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.AbstractModelObject;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.reader.eventadmin.EventPublisher;
import com.verticon.tracker.reader.eventadmin.ITagIdPublisher;

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
	
	private final IPreferenceStore prefs = ReaderPlugin.getDefault().getPreferenceStore();
	
	
	/**
	 * Keeps track of the count of FileReaders so a simple name appended 
	 * with a number is created as the default.
	 */
	private static int count;
	
	private String name = "";
	private URI target = null;
	private String template = "";
	private boolean started = false;


	private ScheduledFuture<?> scheduledFuture = null;
	private ITagIdPublisher transactionPublisher = null;

	protected FileReader(String name) {
		super();
		this.name=name;
	}
	
	public FileReader() {
		super();
		name=getType()+count++;
	}

	public synchronized boolean isStarted() {
		return started;
	}

	public synchronized void setStarted(boolean start) {
		boolean oldValue = this.started;
		if(start){
			try {
				start();
			} catch (IOException e) {
				logger.error(bundleMarker,"Failed to start "+name, e);
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
	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		String oldValue = this.name;
		logger.info(bundleMarker,"{} name set to {}",this, name);
		this.name = name;
		firePropertyChange("name", oldValue, name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getDescription()
	 */
	public synchronized String getType() {
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getTemplate()
	 */
	public synchronized String getTemplate() {
		return template;
	}

	public synchronized void setTemplate(String template) {
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
	public synchronized URI getTarget() {
		return target;
	}

	public synchronized void setTarget(URI target) {
		URI oldValue = this.target;
		this.target = target;
		firePropertyChange("target", oldValue, target);
		reset();
	}

	@Override
	public String toString() {
		return getType() + ':' + getName();
	}

	/**
	 * Start a background task using a FileTailRunner to process the file and
	 * feed new tags to a TransactionPublisher.
	 * 
	 * @see com.verticon.tracker.reader.event.file.FileReaderRunner
	 */
	private void start() throws IOException {
		if (transactionPublisher != null) {
			logger.info(bundleMarker,"{} is already Started ", this);
		} else if (transactionPublisher == null) {
			IFile templateFile = getTemplateFile();
			
			transactionPublisher = new EventPublisher(this, templateFile);
			transactionPublisher.init();

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(this);

			Runnable command = new FileReaderRunner(this, transactionPublisher, getTargetFile());
			
			int delay = prefs.getInt(P_READ_INTERVAL);
			scheduledFuture = ReaderPlugin.getDefault().scheduleWithFixedDelay(command, 4, 
					delay, 
					TimeUnit.SECONDS);
			
			logger.info(bundleMarker,"{} monitoring {} at {} second intervals.", new Object[] {this, target, delay});

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
		if (scheduledFuture != null) {
			scheduledFuture.cancel(false);
			scheduledFuture = null;
			logger.info(bundleMarker,"{} stopped ",this);
		}
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(this);
	};

	private void reset() {
		if (isRunning()) {
			logger.info(bundleMarker,"{} reStarting",this);
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
		//we are only interested if there is a tagIdPublisher
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
				logger.error(this+" could not initialize the tagIdPublisher",e);
			}
		}
		
	}

}
