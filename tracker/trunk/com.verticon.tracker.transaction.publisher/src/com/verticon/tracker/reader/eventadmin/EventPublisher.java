package com.verticon.tracker.reader.eventadmin;

import java.io.IOException;
import java.util.Hashtable;

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
		logger.debug("{} synchronizing contents of template file: {}"
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
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		table.put(ReaderPlugin.EVENT_PROPERTY_ANIMAL, templateAnimal);
		table.put(Constants.BUNDLE_SYMBOLICNAME, ReaderPlugin.getDefault().getSymbolicName());
		table.put(ReaderPlugin.EVENT_PROPERTY_READER_NAME, reader.toString());
		
		EventAdmin ea = ReaderPlugin.getDefault().getService();
		
		if(ea != null) {
			ea.sendEvent(
					new Event(
							ReaderPlugin.TOPIC_ANIMAL, table));
		}else{
			logger.warn("{} failed to find EventAdmin service",reader);
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
