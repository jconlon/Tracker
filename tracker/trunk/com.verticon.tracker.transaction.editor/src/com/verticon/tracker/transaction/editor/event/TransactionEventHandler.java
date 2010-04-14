package com.verticon.tracker.transaction.editor.event;
import static com.verticon.tracker.editor.preferences.PreferenceConstants.P_SPREAD_INTERVAL;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_PROPERTY_ANIMAL_ID;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_PROPERTY_ANIMAL_TEMPLATE;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_PROPERTY_READER_NAME;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_PROPERTY_SOURCE;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_TOPIC_EVENT;
import static com.verticon.tracker.editor.util.TrackerEditorConstants.EVENT_ADMIN_TOPIC_READER;
import static com.verticon.tracker.transaction.editor.TransactionEditorPlugin.bundleMarker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.util.TrackerUtils;


public class TransactionEventHandler implements EventHandler {

	private static final String TRACKER_EDITING_DOMAIN = "com.verticon.transaction.editor.TrackerEditingDomain";
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
				.getEditingDomain(TRACKER_EDITING_DOMAIN);
		if(domain==null){
			logger.error(bundleMarker,"Can't find the EditingDomain");
			return;
		}
		if(EVENT_ADMIN_TOPIC_READER.equals(event.getTopic())){
			handleReaderEvent(event,domain);
		}else if(EVENT_ADMIN_TOPIC_EVENT.equals(event.getTopic())){
			handleTrackerEvent(event,domain);
		}
	}

	private void handleTrackerEvent(org.osgi.service.event.Event event, TransactionalEditingDomain domain){
		String source = (String)event.getProperty(EVENT_ADMIN_PROPERTY_SOURCE);
		String id = (String)event.getProperty(EVENT_ADMIN_PROPERTY_ANIMAL_ID);
		
		Properties props = new Properties();
		for (String name : event.getPropertyNames()) {
			if(EVENT_ADMIN_PROPERTY_ANIMAL_ID.equals(name) || EVENT_ADMIN_PROPERTY_SOURCE.equals(name)){
				continue;
			}
			props.put(name, event.getProperty(name));
		}
		
		addEventToDomain( source,  domain,  props, id);
	}
	
	private void handleReaderEvent(org.osgi.service.event.Event event, TransactionalEditingDomain domain) {
		
		Animal templateAnimal = (Animal)event.getProperty(
				EVENT_ADMIN_PROPERTY_ANIMAL_TEMPLATE);
		
		String readerName = (String) event
				.getProperty(EVENT_ADMIN_PROPERTY_READER_NAME);
		
		if(templateAnimal ==null){
			
			return;
		}
		addAnimalTemplateToDomain(readerName, domain,  templateAnimal);
	}
	
	/**
	 * Handle an AnimalTemplate
	 * @param readerName
	 * @param domain
	 * @param animalTemplate
	 */
	private void addAnimalTemplateToDomain(String readerName, TransactionalEditingDomain domain, Animal animalTemplate) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				logger.debug(bundleMarker,"Processing {}",resource.toString());
			}
			addAnimalTemplateToResource(readerName, domain, resource, animalTemplate);

		}
	}
	
	/**
	 * Handle an event
	 * @param source
	 * @param domain
	 * @param event
	 * @param id
	 */
	private void addEventToDomain(String source, TransactionalEditingDomain domain, Properties props, String id) {
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
			if (resources.size() > 1) {
				logger.debug(bundleMarker,"Processing {}",resource.toString());
			}
			addEventToResource(source, domain, resource, props,  id);

		}
	}
	
	private void addAnimalTemplateToResource(final String readerName, final TransactionalEditingDomain domain, 
			final Resource resource, final Animal templateAnimal) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					addAnimalTemplateToPremises(readerName, templateAnimal, premises);
				} else {
					logger.warn(bundleMarker,"{} resource {} contained no premises to process",readerName, resource.toString());
				}
			}
		});

	}
	
	private void addEventToResource(final String source, final TransactionalEditingDomain domain, 
			final Resource resource, final Properties props,  final String id) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				if (resource.getContents().get(0) instanceof Premises) {
					Premises premises = (Premises) resource.getContents()
							.get(0);
					Animal animal =premises.findAnimal(id);
					
					if(animal==null){
				    	logger.warn(bundleMarker,"The Premises in resource {} contained no animal with id = {}",
				    			 resource.toString(), id);
				    	return;
				    }
					Event trackerEvent = TrackerUtils.createEvent(props, animal.activeTag());
					if(trackerEvent==null){
				    	return;
				    }
					addEventToAnimal(props, trackerEvent, source, animal);
				} else {
					logger.warn(bundleMarker,"Resource {} contained no premises to process",resource.toString());
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
	private void addAnimalTemplateToPremises(
			 String readerName,
			 Animal templateAnimal,
			Premises activePremises) {
		Animal animal = TrackerUtils.findOrCreateAnimal(templateAnimal.getId().toString(),
				activePremises, templateAnimal);
		Collection<com.verticon.tracker.Event> events = 
			copyValidEvents(templateAnimal.eventHistory(), animal);
		for (com.verticon.tracker.Event event : events) {
			logger.info(bundleMarker,"{} added {}, to animal {}, ", 
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
	
	
	
	private void addEventToAnimal(Properties props,
			 Event event,
			 String source,
			 Animal animal) {
		
		   
		    animal.activeTag().getEvents().add(event);
			
		    logger.info(bundleMarker,"{} added {}, to animal {}, ", 
					new Object[]{
						source,
						simpleName( event),  
						animal.getId()});
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
		IPreferenceStore prefs = TrackerReportEditorPlugin.getPlugin().getPreferenceStore();
		Calendar currentDate =null;
		
		Copier copier = new Copier();
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Event o : templateEvents) {
			if(currentDate==null){
				currentDate= Calendar.getInstance();
			}else{
				currentDate.add(Calendar.SECOND, prefs.getInt(P_SPREAD_INTERVAL));
			}
			outputEvent = (Event) copier.copy(o);
			//Copy the references to pickup any OCD references on any GenericEvent
			copier.copyReferences();
			outputEvent.setDateTime(currentDate.getTime());
			if (TrackerEditorUtils.canAddEventToAnimal(animal, outputEvent)) {
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
	
}
