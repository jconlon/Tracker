package com.verticon.tracker.reader;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.event.connection.ConnectionReaderTask;
import com.verticon.tracker.reader.event.connection.RefreshablePublisher;
import com.verticon.tracker.reader.eventadmin.EventPublisher;

/**
 * Superclass for ConnectionReaders. This class is meant to be subclassed by the
 * different Reader plugins. Little to no modification is needed in the
 * subclasse.
 * 
 * Instead of offering a single generic class for all ConnectionReaders,
 * extending this abstract class by different Reader plugins will accomplish
 * three goals.
 * <ul>
 * <li>to show a unique Type which is the simple name of the class</li>
 * <li>to trigger the start of the plugin activator on classload</li>
 * <li>to default to appropriate names of the Reader</li>
 * </ul>
 * 
 * @author jconlon
 * 
 */
public abstract class AbstractConnectionReader extends AbstractModelObject
		implements IReader, RefreshablePublisher {

	/**
	 * Keeps track of the count of Readers so the simple class name appended
	 * with a number is created as the default name.
	 * 
	 */
	private final static AtomicLong count = new AtomicLong(0);

	protected String name = "";
	protected URI target = null;
	protected String template = "";

	private EventPublisher tagIdPublisher = null;
	private Future<RefreshablePublisher> task = null;

	boolean started = false;
	/**
	 * slf4j Logger
	 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Construct and create a default name.
	 */
	public AbstractConnectionReader() {
		super();
		name = getType() + count.incrementAndGet();
	}

	/**
	 * The reader is considered to be started if there is a task, and that task
	 * is not done or canceled.
	 */
	public synchronized boolean isStarted() {
		return started;
//		if (task == null || task.isDone() || task.isCancelled()) {
//			return false;
//		}
//		return true;
	}

	/**
	 * Change the state of the Reader.
	 * 
	 * @param start
	 *            true starts the Reader, false stops it.
	 */
	public synchronized void setStarted(boolean start) {
		if (start == isStarted()) {
			return;
		}
		boolean oldValue = isStarted();
		if (start) {
			try {
				logger.debug("Starting {}",name);
				start();
			} catch (IOException e) {
				logger.error("Failed to start " + name, e);
				return;
			}
		} else {
			stop();
		}
//		if (isStarted() != oldValue) {
//			firePropertyChange("started", oldValue, isStarted());
//		}
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
		return getType() + ' ' + getName();
	}

	/**
	 * Called by the task thread to publish a tag.
	 * 
	 * @param tag
	 */
	public synchronized void publish(Long tag) {
		tagIdPublisher.publish(tag);
	}

	public synchronized void refresh() {
		boolean oldValue = isStarted();
		if (task == null || task.isDone() || task.isCancelled()) {
			started= false;
		}else{
			started=true;
		}
		if (isStarted() != oldValue) {
			firePropertyChange("started", oldValue, isStarted());
		}
	}

	/**
	 * Initialize and submit the background task to the
	 * completion service.
	 * 
	 * @throws IOException
	 */
	protected void start() throws IOException {
		if (tagIdPublisher == null) {
			tagIdPublisher = new EventPublisher(getTemplateFile());
		}
		tagIdPublisher.init();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(tagIdPublisher);
		submitTask();
	}

	/**
	 * Start a background ConnectionReaderTask
	 * 
	 * @see com.verticon.tracker.reader.event.file.FileReaderRunner
	 */
	protected Future<RefreshablePublisher> submitTask() {
		Callable<RefreshablePublisher> command = new ConnectionReaderTask(this,
				ReaderPlugin.getDefault().getBundleContext());

		Future<RefreshablePublisher> task = ReaderPlugin.getDefault().submit(
				command);

		logger.info("Submitted {} task, to read TagIds from {}.", name, target);
		return task;

	}

	/**
	 * Stop the background task.
	 */
	private void stop() {
		if (task != null) {
			task.cancel(true);
			logger.info("{} stopped ", name);
		}

		if (tagIdPublisher != null) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(tagIdPublisher);
			tagIdPublisher = null;
		}
	};

	private void reset() {
		if (isRunning()) {
			logger.info("{} reStarting", name);
			setStarted(false);
			setStarted(true);
		}
	}

	private boolean isRunning() {
		return tagIdPublisher != null;
	}

	/**
	 * @return
	 */
	private IFile getTemplateFile() {
		Path ipath = new Path(getTemplate());
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(ipath);
		return ifile;
	}

}
