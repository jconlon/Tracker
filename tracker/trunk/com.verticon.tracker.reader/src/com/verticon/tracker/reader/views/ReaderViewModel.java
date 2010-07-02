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

package com.verticon.tracker.reader.views;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.IReaderFactory;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.reader.wizards.ReaderFactoryProxy;

/**
 * The domain model for IReaders. Data is persisted in the
 * <workspace>\.metadata\.plugins\com.verticon.reader\readers.xml file.
 * 
 */

public class ReaderViewModel implements PropertyChangeListener{
	
	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ReaderViewModel.class);
	
	private static final String TAG_NAME = "Name";
	private static final String TAG_TARGET = "Target";
	private static final String TAG_READERS = "Readers";
	private static final String TAG_READER = "Reader";
	private static final String TAG_TYPE = "Type";
	private static final String TAG_TEMPLATE = "Template";

	private List<IReader> readers;

	private final Set<IReaderModelListener> readerModelListeners = new HashSet<IReaderModelListener>();
	
	private final List<IReaderFactory> factories = new ArrayList<IReaderFactory>();

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
	 * Add a new reader to the collection of readers
	 */
	public void addReader(IReader reader) {
		readers.add(readers.size(), reader);
		Iterator<IReaderModelListener> iterator = readerModelListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().addReader(reader);
		}
		reader.addPropertyChangeListener(this);
		saveReaders();
	}

	/**
	 * @param reader
	 */
	protected void removeReader(IReader reader) {
		reader.setStarted(false);
		readers.remove(reader);
		Iterator<IReaderModelListener> iterator = readerModelListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().removeReader(reader);
		}
		reader.removePropertyChangeListener(this);
		saveReaders();
	}

	

	/**
	 * @param viewer
	 */
	protected void removeChangeListener(IReaderModelListener viewer) {
		readerModelListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	protected void addChangeListener(IReaderModelListener viewer) {
		readerModelListeners.add(viewer);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Persisting readers
	//
	// //////////////////////////////////////////////////////////////////////////

	private void loadReaders() {
		readers = new ArrayList<IReader>();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(getReadersFile());
			loadReaders(XMLMemento.createReadRoot(fileReader));
		} catch (FileNotFoundException e) {
			// Ignored... no items exist yet.
		} catch (Exception e) {
			// Log the exception and move on.
			logger.error(bundleMarker,"Failed to load readers", e);
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				logger.error(bundleMarker,"Failed to close the fileReader",e);
			}
		}
	}

	private void loadReaders(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_READER);
		for (int i = 0; i < children.length; i++) {
			IReader reader = newReaderFor(children[i].getString(TAG_NAME),
					children[i].getString(TAG_TYPE), children[i]
							.getString(TAG_TEMPLATE), children[i]
							.getString(TAG_TARGET));
			if (reader != null){
				addReader( reader);
			}else{
				logger.error(bundleMarker,"Found no factory to create reader type {}", 
						children[i].getString(TAG_NAME));
			}
		}
	}

	/**
	 * 
	 * @param name
	 * @param type
	 * @param template
	 * @param target
	 * @return
	 */
	private IReader newReaderFor(String name, String type, String template,
			String target) {
		IReader reader = null;
		if(factories.isEmpty()){
			loadFactories();
		}
		
		for (IReaderFactory readerFactory : factories) {
			if(readerFactory.isSupportedType(type)){
				reader = readerFactory.instance(name, type, template, URI.create(target));
				break;
			}
		}

		return reader;
	}
	
	
	private void saveReaders() {
		if (readers == null)
			return;
		XMLMemento memento = XMLMemento.createWriteRoot(TAG_READERS);
		savePublishers(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getReadersFile());
			memento.save(writer);
		} catch (IOException e) {
			logger.error(bundleMarker,"Failed to save readers",e);
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				logger.error(bundleMarker,"Failed to close the fileWriter",e);
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

	/**
	 * 
	 * @throws InvalidRegistryObjectException
	 */
	 private void loadFactories()
			throws InvalidRegistryObjectException {
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
				 ReaderPlugin.PLUGIN_ID, "readerWizards")
				 .getExtensions();
		 
		 for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements =
					extensions[i].getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				IReaderFactory proxy =
					parseType(configElements[j],factories.size());
				if(proxy != null){
					factories.add(proxy);
				}
			}
		 }
	}

	private static IReaderFactory parseType(IConfigurationElement configElement, int ordinal){
		 if (!configElement.getName().equals("wizard"))
		      return null;
		   try {
		      return new ReaderFactoryProxy(configElement);
		   }
		   catch (Exception e) {
		      String factory = configElement.getAttribute("factory");
		      if (factory == null)
		    	  factory = "[missing factory attribute]";
		      String msg =
		         "Failed to load factory named "
		            + factory
		            + " in "
		            + configElement.getDeclaringExtension().getContributor().getName();
		           
		      logger.error(msg, e);
		      return null;
		   }
	}

	/**
	 * Implements PropertyChangeListener to listen to changes on the Readers and
	 * communicate to the list of readerModelListeners about the changed Reader.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		
		IReader reader = (IReader)evt.getSource();
//		logger.debug(bundleMarker,"Property {} changed on Reader {}",evt.getPropertyName(), reader);
		Iterator<IReaderModelListener> iterator = readerModelListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().updateReader(reader);
		}
		saveReaders();
	}
	
	
}
