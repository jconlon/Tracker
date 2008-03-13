/**
 * Based on work done by 
 * (c) Copyright Mirasol Op'nWorks Inc. 2002, 2003. 
 * http://www.opnworks.com
 * Created on Apr 2, 2003 by lgauthier@opnworks.com
 * 
 */

package com.verticon.tracker.reader.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

import com.verticon.tracker.reader.AbstractReader;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.util.TrackerLog;

/**
 * The domain model for IReaders. Data is persisted in the
 * <workspace>\.metadata\.plugins\com.verticon.reader\readers.xml file.
 * 
 */

public class ReaderViewModel {

	private static final String TAG_NAME = "Name";
	private static final String TAG_TARGET = "Target";
	private static final String TAG_READERS = "Readers";
	private static final String TAG_READER = "Reader";
	private static final String TAG_TYPE = "Type";
	private static final String TAG_TEMPLATE = "Template";

	private List<IReader> readers;

	private Set<IReaderModelListener> changeListeners = new HashSet<IReaderModelListener>();

	/**
	 * Constructor
	 */
	public ReaderViewModel() {
		super();
		this.initData();
	}

	/*
	 * Initialize the table data. Create COUNT tasks and add them them to the
	 * collection of tasks
	 */
	private void initData() {
		loadReaders();
	};

	/**
	 * Return the collection of tasks
	 */
	public List<IReader> getTasks() {
		return readers;
	}

	/**
	 * Add a Dummy reader for testing to the collection of tasks
	 * 
	 */
	public void addReader() {
		IReader task = new AbstractReader("New dummy");
		readers.add(readers.size(), task);
		Iterator<IReaderModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext())
			iterator.next().addReader(task);
	}

	/**
	 * Add a new task to the collection of tasks
	 */
	public void addReader(IReader publisher) {
		readers.add(readers.size(), publisher);
		Iterator<IReaderModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().addReader(publisher);
		}
		saveReaders();
	}

	/**
	 * @param reader
	 */
	public void removeReader(IReader reader) {
		readers.remove(reader);
		Iterator<IReaderModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().removeReader(reader);
		}
		saveReaders();
	}

	/**
	 * @param reader
	 */
	public void readererChanged(IReader reader) {
		Iterator<IReaderModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().updateReader(reader);
		}
		saveReaders();
	}

	/**
	 * @param viewer
	 */
	public void removeChangeListener(IReaderModelListener viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(IReaderModelListener viewer) {
		changeListeners.add(viewer);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Persisting readers
	//
	// //////////////////////////////////////////////////////////////////////////

	private void loadReaders() {
		readers = new ArrayList<IReader>();
		FileReader reader = null;
		try {
			reader = new FileReader(getReadersFile());
			loadReaders(XMLMemento.createReadRoot(reader));
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

	private void loadReaders(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_READER);
		for (int i = 0; i < children.length; i++) {
			IReader item = newReaderFor(children[i].getString(TAG_NAME),
					children[i].getString(TAG_TYPE), children[i]
							.getString(TAG_TEMPLATE), children[i]
							.getString(TAG_TARGET));
			if (item != null)
				readers.add(item);
		}
	}

	private IReader newReaderFor(String name, String type, String template,
			String target) {
		IReader reader = null;
		if (AbstractReader.class.getSimpleName().equals(type)) {
			reader = new AbstractReader(name);
			reader.setTarget(URI.create(target));
			reader.setTemplate(template);
		} else if (FileReader.class.getSimpleName().equals(type)) {
			reader = new com.verticon.tracker.reader.event.file.FileReader(name);
			reader.setTarget(URI.create(target));
			reader.setTemplate(template);
		}
		return reader;
	}

	public void saveReaders() {
		if (readers == null)
			return;
		XMLMemento memento = XMLMemento.createWriteRoot(TAG_READERS);
		savePublishers(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getReadersFile());
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
		Iterator<IReader> iter = readers.iterator();
		while (iter.hasNext()) {
			IReader item = iter.next();
			IMemento child = memento.createChild(TAG_READER);
			child.putString(TAG_NAME, item.getName());
			child.putString(TAG_TYPE, item.getType());
			child.putString(TAG_TEMPLATE, item.getTemplate());
			child.putString(TAG_TARGET, item.getTarget().toString());
		}
	}

	private File getReadersFile() {
		return ReaderPlugin.getDefault().getStateLocation().append(
				"readers.xml").toFile();
	}

}
