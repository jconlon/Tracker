package com.verticon.tracker.reader.eventadmin;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Constants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.util.ConsoleUtil;
import com.verticon.tracker.reader.ReaderPlugin;

public class EventPublisher implements ITagIdPublisher {

	private Animal templateAnimal;

	private final IFile animalTemplateFile;
	
	
	
	public EventPublisher(IFile animalTemplateFile) throws IOException {
		super();
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
	  public void init() throws IOException {
		printToConsole(new Date() + "\tSynchronizing contents of Template file: "
				+ animalTemplateFile.getName());
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

	public void publish(Long tagId) {
		for (Tag tag : templateAnimal.getTags()) {
			tag.setId(Long.toString(tagId));
		}
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		table.put(ReaderPlugin.EVENT_PROPERTY_ANIMAL, templateAnimal);
		table.put(Constants.BUNDLE_SYMBOLICNAME, ReaderPlugin.getDefault().getSymbolicName());
		
		EventAdmin ea = ReaderPlugin.getDefault().getService();
		
		if(ea != null) {
			ea.sendEvent(
					new Event(
							ReaderPlugin.TOPIC_ANIMAL, table));
		}else{
			ConsoleUtil.println(EventPublisher.class.getSimpleName(), "Could not find EventAdmin service");
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
	
	private void printToConsole(String msg) {
		ConsoleUtil.println(EventPublisher.class.getSimpleName(), msg);
	}
}
