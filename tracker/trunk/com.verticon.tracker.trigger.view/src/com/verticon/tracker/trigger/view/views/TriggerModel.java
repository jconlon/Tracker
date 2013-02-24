/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.trigger.view.views;

import static com.verticon.tracker.trigger.view.TriggerViewPlugin.bundleMarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.ITriggerEntryModelListener;
import com.verticon.tracker.trigger.view.TriggerEntryFactory;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;

/**
 * Model for ITriggerEntry Objects.
 * 
 * @author jconlon
 * 
 */
public class TriggerModel implements IChangeListener {
	private static final String STATE_FILE_NAME = "measurementTriggerFileView.xml";
	private static final String TAG_ENTRIES = "TriggerEntries";
	private static final String TAG_ENTRY = "TriggerEntry";
	private static final String NEW_TRIGGER_ENTRY_NAME = "New Entry";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(TriggerModel.class);

	private List<ITriggerEntry> entries;

	// private WritableList writables;

	private final Set<ITriggerEntryModelListener> changeListeners = new HashSet<ITriggerEntryModelListener>();

	/**
	 * Constructor
	 */
	TriggerModel() {
		super();
		loadEntries();
	}


	/**
	 * Return the collection of entries
	 */
	List<ITriggerEntry> entries() {
		return entries;
	}

	/**
	 * Add a new entry to the model
	 * 
	 */
	public void add() {
		ITriggerEntry query = TriggerEntryFactory.create(NEW_TRIGGER_ENTRY_NAME);
		add(query);
	}

	
	/**
	 * 
	 * @param entries
	 *            to add
	 * @return number of entries added to the model
	 */
	public int add(Collection<ITriggerEntry> entries) {
		int addedQueries = 0;
		for (ITriggerEntry query : entries) {
			if (!contains(query)) {
				add(query);
				addedQueries++;
			}
		}
		return addedQueries;
	}

	

	/**
	 * @param entry
	 *            to remove
	 */
	public void remove(ITriggerEntry entry) {
		entries.remove(entry);
		Iterator<ITriggerEntryModelListener> iterator = changeListeners
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().removeEntry(entry);
		}
		saveEntries();
	}

	@Override
	public void handleChange(ChangeEvent event) {
		saveEntries();
	}

	/**
	 * @param entry
	 *            to change
	 */
	@SuppressWarnings("unused")
	private void update(ITriggerEntry entry) {
		Iterator<ITriggerEntryModelListener> iterator = changeListeners
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().updateEntry(entry);
		}
		saveEntries();
	}

	/**
	 * @param listener
	 */
	public void removeChangeListener(ITriggerEntryModelListener listener) {
		changeListeners.remove(listener);
	}

	/**
	 * @param listener
	 */
	public void addChangeListener(ITriggerEntryModelListener listener) {
		changeListeners.add(listener);
	}

	/**
	 * 
	 * @return copy of the entries
	 */
	public List<ITriggerEntry> getEntries() {
		return ImmutableList.copyOf(entries);
	}

	/**
	 * 
	 * @param query
	 * @return true if the query is already in the model
	 */
	private boolean contains(ITriggerEntry query) {
		return entries.contains(query);
	}

	/**
	 * 
	 * @param entry
	 *            to add
	 */
	private void add(ITriggerEntry entry) {
		entries.add(entries.size(), entry);
		Iterator<ITriggerEntryModelListener> iterator = changeListeners
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().addEntry(entry);
		}
		saveEntries();
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Persisting entries
	//
	// //////////////////////////////////////////////////////////////////////////

	private void loadEntries() {
		entries = new ArrayList<ITriggerEntry>();
		FileReader reader = null;
		try {
			reader = new FileReader(getQueriesFile());
			loadEntries(XMLMemento.createReadRoot(reader));
		} catch (FileNotFoundException e) {
			// Ignored... no items exist yet.
		} catch (Exception e) {
			// Log the exception and move on.
			logger.error(bundleMarker, "Failed to load the entries", e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				logger.error(bundleMarker, "Failed to close the FileReader", e);
			}
		}
	}

	private void loadEntries(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_ENTRY);
		for (int i = 0; i < children.length; i++) {
			ITriggerEntry item = Column.load(children[i]);
			if (item != null)
				entries.add(item);
		}
	}

	private void saveEntries() {
		if (entries == null)
			return;

		XMLMemento memento = XMLMemento.createWriteRoot(TAG_ENTRIES);
		saveEntries(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getQueriesFile());
			memento.save(writer);
			logger.debug(bundleMarker, "Saved entries");
		} catch (IOException e) {
			logger.error(bundleMarker, "Failed to save the entries", e);
			// launched
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				logger.error(bundleMarker, "Failed to close the fileWriter", e);
			}
		}
	}


	private void saveEntries(XMLMemento memento) {
		Iterator<ITriggerEntry> iter = entries.iterator();
		while (iter.hasNext()) {
			ITriggerEntry entry = iter.next();
			IMemento child = memento.createChild(TAG_ENTRY);
			Column.save(child, entry);
		}
	}

	private File getQueriesFile() {
		return TriggerViewPlugin.getDefault().getStateLocation()
				.append(STATE_FILE_NAME).toFile();
	}



}