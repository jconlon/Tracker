package com.verticon.tracker.transaction.publisher.eventadmin;

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
import com.verticon.tracker.transaction.publisher.ITransactionPublisher;
import com.verticon.tracker.transaction.publisher.PublisherPlugin;

public class TransactionEventPublisher implements ITransactionPublisher {

	private Animal templateAnimal;

	private final IFile animalTemplateFile;
	
	
	
	public TransactionEventPublisher(IFile animalTemplateFile) throws IOException {
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
	 * @see com.verticon.tracker.transaction.publisher.ITransactionPublisher#init()
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
		table.put(PublisherPlugin.EVENT_PROPERTY_ANIMAL, templateAnimal);
		table.put(Constants.BUNDLE_SYMBOLICNAME, PublisherPlugin.getDefault().getSymbolicName());
		
		EventAdmin ea = PublisherPlugin.getDefault().getService();
		
		if(ea != null) {
			ea.sendEvent(
					new Event(
							PublisherPlugin.TOPIC_ANIMAL, table));
		}else{
			ConsoleUtil.println(TransactionEventPublisher.class.getSimpleName(), "Could not find EventAdmin service");
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
		ConsoleUtil.println(TransactionEventPublisher.class.getSimpleName(), msg);
	}
}
