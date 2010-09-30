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
package com.verticon.tracker.reader;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

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
import com.verticon.tracker.reader.event.connection.RefreshableReader;
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
		implements IReader, RefreshableReader {

	/**
	 * Keeps track of the count of Readers so the simple class name appended
	 * with a number is created as the default name.
	 * 
	 */
	private final static AtomicLong count = new AtomicLong(0);

	private String name = "";
	private URI target = null;
	private String template = "";

	private EventPublisher tagIdPublisher = null;
	private Future<RefreshableReader> futureTask = null;
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Construct and create a default name.
	 */
	public AbstractConnectionReader() {
		super();
		name = getType() + count.incrementAndGet();
	}
	
	/**
	 * Construct and create a default name.
	 */
	public AbstractConnectionReader(String name) {
		super();
		this.name=name;
	}

	/**
	 * The reader is considered to be started if there is a futureTask, and that futureTask
	 * is not done or canceled.
	 */
	public synchronized boolean isStarted() {
		if (futureTask == null || futureTask.isDone() || futureTask.isCancelled()) {
			return false;
		}
		return true;
	}

	/**
	 * SetStart will start or stop the reader,
	 * effectively changing the state of the Reader.
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
				logger.debug(bundleMarker,"{} starting",this);
				start();
			} catch (IOException e) {
				logger.error(bundleMarker,toString()+" failed to start. "+e.getLocalizedMessage(), e);
				e.printStackTrace();
				return;
			}
		} else {
			logger.debug(bundleMarker,"{} user requested cancellation of connection to {}",this,target);
			stop();
		}
		firePropertyChange("started", oldValue, !oldValue);
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
	 * Called by the futureTask thread to publish a tag.
	 * 
	 * @param tag
	 */
	public synchronized void publish(Long tag) {
		if(tag < 100000000000000L){
			logger.warn(bundleMarker,"{} received a partial tag {}",this,tag );
			return;
		}
		tagIdPublisher.publish(tag);
	}

	public synchronized void refresh() {
		firePropertyChange("started", null, isStarted());
		logger.debug(bundleMarker,"{} refreshed state, isStarted={}",
				this,isStarted());
	}

	/**
	 * Initialize and submit the background futureTask to the
	 * completion service.
	 * 
	 * @throws IOException
	 */
	private void start() throws IOException {
		if (tagIdPublisher == null) {
			tagIdPublisher = new EventPublisher(this,getTemplateFile());
		}
		tagIdPublisher.init();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(tagIdPublisher);
		this.futureTask=submitTask();
	}

	/**
	 * Start a background ConnectionReaderTask
	 * 
	 * @see com.verticon.tracker.reader.event.file.FileReaderRunner
	 */
	private Future<RefreshableReader> submitTask() {
		Callable<RefreshableReader> command = new ConnectionReaderTask(this,
				ReaderPlugin.getDefault().getBundleContext());

		logger.info(bundleMarker,"{} submitting futureTask, to read TagIds from {}.", this, target);
		Future<RefreshableReader> task = ReaderPlugin.getDefault().submit(
				command);

		
		logger.debug(bundleMarker,"{} submitted futureTask, to read TagIds from {}.", this, target);
		return task;

	}

	/**
	 * Stop the background futureTask.
	 */
	private void stop() {
		if (futureTask != null) {
			futureTask.cancel(true);
			logger.info(bundleMarker,"{} canceled connnection to {}", this,target);
		}

		if (tagIdPublisher != null) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.removeResourceChangeListener(tagIdPublisher);
			tagIdPublisher = null;
		}
	};

	private void reset() {
		if (isRunning()) {
			logger.info(bundleMarker,"{} reStarting", this);
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
