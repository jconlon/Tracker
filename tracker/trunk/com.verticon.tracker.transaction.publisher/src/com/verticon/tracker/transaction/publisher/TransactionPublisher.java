package com.verticon.tracker.transaction.publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.editor.util.ConsoleUtil;
import com.verticon.tracker.transaction.publisher.preferences.PreferenceConstants;
import com.verticon.tracker.util.CommonUtilities;

public class TransactionPublisher {

	private final TransactionalEditingDomain domain = 
		TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("com.verticon.transaction.editor.TrackerEditingDomain");

	private Animal templateAnimal;

	private final IFile animalTemplateFile;

	private static Preferences prefs = PublisherPlugin.getDefault()
	.getPluginPreferences();
	
	/**
	 * Constructs the TransactionPublisher 
	 * @param animalTemplateFile
	 * @throws IOException
	 */
	public TransactionPublisher(final IFile animalTemplateFile) throws IOException {
		this.animalTemplateFile = animalTemplateFile;
		Resource templateResource = getResource(animalTemplateFile);
		if (templateResource.getContents().isEmpty()) {
			throw new IOException("File Resource is empty.");
		}
		if (!(templateResource.getContents().get(0) instanceof Animal)) {
			throw new IOException(
					"File Resource does not contain an Animal root");
		}
		init();
	}

	/**
	 * Loads the animalTeplate from the file
	 * 
	 * @throws IOException
	 */
	  void init() throws IOException {
		log(new Date() + "\tSynchronizing contents of Template file: "
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
	 * Called by client objects to publish the tag as a Templated Event to 
	 * all Premises in all Resources of the EditingDomain
	 * 
	 * @param tag
	 */
	public void publish(Long tag) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				log(new Date() + "\tprocessing " + resource.toString());
			}
			process(resource, tag);

		}
	}

	private void log(String msg) {
		ConsoleUtil.println(TransactionPublisher.class.getSimpleName(), msg);
	}

	private void process(final Resource resource, final Long tag) {
		if (resource.getContents().isEmpty()) {
			return;
		}

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					addTemplateEventsToAnimalInPremises(templateAnimal
							.allEvents(), tag, premises);
				} else {
					log(new Date()
							+ "\tResource contained no premises to process");
				}
			}
		});

	}

	/**
	 * Find or create an animal in the premises and add only valid
	 * templateEvents to it.
	 * 
	 * @param templateEvents
	 * @param tagNumberToAdd
	 * @param activePremises
	 */
	@SuppressWarnings("unchecked")
	private void addTemplateEventsToAnimalInPremises(
			Collection<Event> templateEvents, Long tagNumberToAdd,
			Premises activePremises) {
		Animal animal = CommonUtilities.findAnimal(tagNumberToAdd,
				activePremises, templateAnimal);
		Collection<Event> events = copyValidEvents(templateEvents, animal);
		for (Event event : events) {
			log(event.getDateTime() + "\t" + animal.getId() + '\t'
					+ animal.getSpecies() + '\t' + simpleName(event));
			Tag tag = animal.activeTag();
			// If the animal was created from the template, because it did not
			// exist in the premises
			// then it has no activeTag, but it will have a tag that was added
			// during the creation
			// check for it here
			if (tag == null) {
				tag = animal.getTags().get(0);
			}

			tag.getEvents().add(event);
		}
	}

	private static final String simpleName(Event event) {
		String name = event.getClass().getSimpleName();
		return name.substring(0, name.indexOf("Impl"));
	}

	/**
	 * Creates a Collection of valid events for the animal
	 * Using the current date for the first event and the Spread
	 * Interval set in the preferences each subsequent event
	 * @param templateEvents
	 * @param animal
	 * @return Copy of all valid templateEvents for the animal
	 */
	private static Collection<Event> copyValidEvents(
			Collection<Event> templateEvents, Animal animal) {
		Calendar currentDate =null;
		
		Copier copier = new Copier();
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Event o : templateEvents) {
			if(currentDate==null){
				currentDate= Calendar.getInstance();
			}else{
				currentDate.add(Calendar.SECOND, prefs.getInt(PreferenceConstants.P_SPREAD_INTERVAL));
			}
			outputEvent = (Event) copier.copy(o);
			outputEvent.setDateTime(currentDate.getTime());
			if (ActionUtils.canAddEventToAnimal(animal, outputEvent)) {
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
	

}
