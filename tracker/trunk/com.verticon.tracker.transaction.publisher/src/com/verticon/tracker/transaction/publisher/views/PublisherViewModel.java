/**
 * Based on work done by 
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.transaction.publisher.views;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

import com.verticon.tracker.transaction.publisher.IPublisher;
import com.verticon.tracker.transaction.publisher.PublisherPlugin;
import com.verticon.tracker.transaction.publisher.filetailer.FileTailerEventPublisher;
import com.verticon.tracker.transaction.publisher.utilities.MockPublisher;
import com.verticon.tracker.util.TrackerLog;

/**
 * The domain model for Publishers. Data is persisted in the 
 * <workspace>\.metadata\.plugins\com.verticon.transaction.publisher\publishers.xml
 * file.
 * 
 */

public class PublisherViewModel {

	private static final String TAG_NAME = "Name";
	private static final String TAG_TARGET = "Target";
	private static final String TAG_PUBLISHERS = "Publishers";
	private static final String TAG_PUBLISHER = "Publisher";
	private static final String TAG_TYPE = "Type";
	private static final String TAG_TEMPLATE = "Template";

	private List<IPublisher> publishers;
	
	private Set<IPublisherModelListener> changeListeners = new HashSet<IPublisherModelListener>();

	
	/**
	 * Constructor
	 */
	public PublisherViewModel() {
		super();
		this.initData();
	}
	
	/*
	 * Initialize the table data.
	 * Create COUNT tasks and add them them to the 
	 * collection of tasks
	 */
	private void initData() {
		loadPublishers();
	};

	/**
	 * Return the collection of tasks
	 */
	public List<IPublisher> getTasks() {
		return publishers;
	}
	
	/**
	 * Add a Dummy publisher for testing to
	 * the collection of tasks
	 * 
	 */
	public void addPublisher() {
		IPublisher task = new MockPublisher("New dummy");
		publishers.add(publishers.size(), task);
		Iterator<IPublisherModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext())
			iterator.next().addPublisher(task);
	}
	
	/**
	 * Add a new task to the collection of tasks
	 */
	public void addPublisher(IPublisher publisher) {
		publishers.add(publishers.size(), publisher);
		Iterator<IPublisherModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()){
			iterator.next().addPublisher(publisher);
		}
		savePublishers();
	}

	/**
	 * @param publisher
	 */
	public void removePublisher(IPublisher publisher) {
		publishers.remove(publisher);
		Iterator<IPublisherModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()){
			iterator.next().removePublisher(publisher);
		}
		savePublishers();
	}

	/**
	 * @param publisher
	 */
	public void publisherChanged(IPublisher publisher) {
		Iterator<IPublisherModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()){
			iterator.next().updatePublisher(publisher);
		}
		savePublishers();
	}

	/**
	 * @param viewer
	 */
	public void removeChangeListener(IPublisherModelListener viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(IPublisherModelListener viewer) {
		changeListeners.add(viewer);
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	// Persisting publishers
	//
	// //////////////////////////////////////////////////////////////////////////

	private void loadPublishers() {
		publishers = new ArrayList<IPublisher>();
		FileReader reader = null;
		try {
			reader = new FileReader(getPublishersFile());
			loadPublishers(XMLMemento.createReadRoot(reader));
		} catch (FileNotFoundException e) {
			// Ignored... no Favorites items exist yet.
		} catch (Exception e) {
			// Log the exception and move on.
			TrackerLog.logError(e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				TrackerLog.logError(e);
			}
		}
	}

	private void loadPublishers(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_PUBLISHER);
		for (int i = 0; i < children.length; i++) {
			IPublisher item = newPublisherFor(children[i].getString(TAG_NAME),
					children[i].getString(TAG_TYPE), children[i]
							.getString(TAG_TEMPLATE), children[i]
							.getString(TAG_TARGET));
			if (item != null)
				publishers.add(item);
		}
	}

	private IPublisher newPublisherFor(String name, String type,
			String template, String target) {
		IPublisher publisher = null;
		if (MockPublisher.class.getSimpleName().equals(type)) {
			publisher = new MockPublisher(name);
			publisher.setTarget(target);
			publisher.setTemplate(template);
		} else if (FileTailerEventPublisher.class.getSimpleName().equals(type)){
			publisher = new FileTailerEventPublisher(name);
			publisher.setTarget(target);
			publisher.setTemplate(template);
		}
		return publisher;
	}

	public void savePublishers() {
		if (publishers == null)
			return;
		XMLMemento memento = XMLMemento.createWriteRoot(TAG_PUBLISHERS);
		savePublishers(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getPublishersFile());
			memento.save(writer);
		} catch (IOException e) {
			TrackerLog.logError(e);
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				TrackerLog.logError(e);
			}
		}
	}

	private void savePublishers(XMLMemento memento) {
		Iterator<IPublisher> iter = publishers.iterator();
		while (iter.hasNext()) {
			IPublisher item = iter.next();
			IMemento child = memento.createChild(TAG_PUBLISHER);
			child.putString(TAG_NAME, item.getName());
			child.putString(TAG_TYPE, item.getType());
			child.putString(TAG_TEMPLATE, item.getTemplate());
			child.putString(TAG_TARGET, item.getTarget());
		}
	}

	private File getPublishersFile() {
		return PublisherPlugin.getDefault().getStateLocation()
				.append("publishers.xml").toFile();
	}

}
