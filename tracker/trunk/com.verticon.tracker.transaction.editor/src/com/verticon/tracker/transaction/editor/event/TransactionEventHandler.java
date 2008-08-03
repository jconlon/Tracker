package com.verticon.tracker.transaction.editor.event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.preferences.PreferenceConstants;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.ActionUtils;
import com.verticon.tracker.util.TrackerUtils;


public class TransactionEventHandler implements EventHandler {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TransactionEventHandler.class);
	
	
	/**
	 * Get the animal from the event and publish it.
	 */
	public void handleEvent(org.osgi.service.event.Event event) {
	   
		TransactionalEditingDomain domain = 
			TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("com.verticon.transaction.editor.TrackerEditingDomain");
		if(domain==null){
			logger.error("Can't find the EditingDomain");
			return;
		}
		Animal templateAnimal = (Animal)event.getProperty(
				"com.verticon.tracker.animal");
		
		String readerName = (String)event.getProperty("com.verticon.tracker.reader.name");
		
		if(templateAnimal ==null){
			
			return;
		}
		publish(readerName, domain,  templateAnimal);
	}
	
	/**
	 * 
	 * @param domain
	 * @param templateAnimal
	 */
	private void publish(String readerName, TransactionalEditingDomain domain, Animal templateAnimal) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				logger.debug("Processing {}",resource.toString());
			}
			process(readerName, domain, resource, templateAnimal);

		}
	}
	
	private void process(final String readerName, final TransactionalEditingDomain domain, final Resource resource, final Animal templateAnimal) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					addTemplateEventsToAnimalInPremises(readerName, templateAnimal, premises);
				} else {
					logger.warn("{} resource {} contained no premises to process",readerName, resource.toString());
				}
			}
		});

	}
	

	/**
	 * Find or create an animal in the premises and add only valid
	 * templateEvents to it.
	 * @param tagNumberToAdd
	 * @param activePremises
	 */
	@SuppressWarnings("unchecked")
	private void addTemplateEventsToAnimalInPremises(
			 String readerName,
			 Animal templateAnimal,
			Premises activePremises) {
		Animal animal = TrackerUtils.findOrCreateAnimal(templateAnimal.getId().toString(),
				activePremises, templateAnimal);
		Collection<com.verticon.tracker.Event> events = 
			copyValidEvents(templateAnimal.eventHistory(), animal);
		for (com.verticon.tracker.Event event : events) {
			logger.info("{} added {}, to animal {}, ", 
					new Object[]{
						readerName,
						simpleName( event),  
						animal.getId()});
			
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
	private  Collection<Event> copyValidEvents(
			
			Collection<Event> templateEvents, Animal animal) {
		Preferences prefs = TrackerReportEditorPlugin.getPlugin().getPluginPreferences();
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
