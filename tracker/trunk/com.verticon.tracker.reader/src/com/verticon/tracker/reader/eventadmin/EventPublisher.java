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
package com.verticon.tracker.reader.eventadmin;
import static com.verticon.tracker.reader.ReaderPlugin.bundleMarker;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Constants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Tag;
import com.verticon.tracker.reader.IReader;
import com.verticon.tracker.reader.ReaderPlugin;

public class EventPublisher implements ITagIdPublisher, IResourceChangeListener{

	private Animal templateAnimal;

	private final IFile animalTemplateFile;
	
	private final IReader reader;
	
	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
	
	public EventPublisher(IReader name, IFile animalTemplateFile) throws IOException {
		super();
		if(!animalTemplateFile.exists()){
			throw new IOException(animalTemplateFile.getName()+" does not exist.");
		}
		this.reader=name;
		this.animalTemplateFile = animalTemplateFile;
		Resource templateResource = getResource(animalTemplateFile);
		if (templateResource.getContents().isEmpty()) {
			throw new IOException("File Resource is empty.");
		}
		if (!(templateResource.getContents().get(0) instanceof Animal)) {
			throw new IOException(
					"File Resource does not contain an Animal root");
		}
	}

	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.reader.ITransactionPublisher#init()
	 */
	  public synchronized void init() throws IOException {
		logger.debug(bundleMarker,"{} synchronizing contents of template file: {}"
				,reader, animalTemplateFile.getName());
		Resource templateResource = getResource(animalTemplateFile);
		if (templateResource.getContents().isEmpty()) {
			throw new IOException("File Resource is empty.");
		}
		if (!(templateResource.getContents().get(0) instanceof Animal)) {
			throw new IOException(
					"File Resource does not contain an Animal root");
		}

		templateAnimal = (Animal) templateResource.getContents().get(0);
	}

	public synchronized void publish(Long tagId) {
		for (Tag tag : templateAnimal.getTags()) {
			tag.setId(Long.toString(tagId));
		}
		Map<String, Object> table = new HashMap<String, Object>();
		// FIXME Ticket 280 should not send a mutable object as a property
		table.put(EVENT_ADMIN_PROPERTY_ANIMAL_TEMPLATE,
				templateAnimal);
		table.put(Constants.BUNDLE_SYMBOLICNAME, ReaderPlugin.getDefault().getSymbolicName());
		table.put(EVENT_ADMIN_PROPERTY_READER_NAME, reader
				.toString());
		table.put(EVENT_ADMIN_PROPERTY_ANIMAL_ID, tagId);
		
		EventAdmin ea = ReaderPlugin.getDefault().getService();
		
		if(ea != null) {
			// Todo Sends synchronously but could (should) asynchronous with a
			// postEvent call
			ea.sendEvent(
					new Event(
							EVENT_ADMIN_TOPIC_READER, table));
		}else{
			logger.warn(bundleMarker,"{} failed to find EventAdmin service",reader);
		}
	}

	
	private static Resource getResource(IFile file) throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		
		Resource resource = resourceSet.createResource(uri);
		if (!resource.isLoaded()) {
			resource.load(null);
		}
		return resource;
	}


	/**
	 * Listen for resource changes to the template File
	 */
	public void resourceChanged(IResourceChangeEvent event) {

		//we are only interested in POST_CHANGE events
		if (event.getType() != IResourceChangeEvent.POST_CHANGE)
			return;

		IResourceDelta rootDelta = event.getDelta();
		IResourceDelta templateDelta = rootDelta.findMember(animalTemplateFile.getFullPath());
		if (templateDelta == null)
			return;

		try {
			init();
		} catch (IOException e) {
			logger.error(reader+" could not initialize the tagIdPublisher for "+animalTemplateFile,e);
		}


	}
	
}
