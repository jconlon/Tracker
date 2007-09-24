package com.verticon.tracker.transaction.publisher.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
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
import com.verticon.tracker.transaction.publisher.views.EventPublisherView;
import com.verticon.tracker.util.CommonUtilities;

public class TransactionPublisher {

	private final TransactionalEditingDomain domain = 
		TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("com.verticon.transaction.editor.TrackerEditingDomain");
	
	private  Animal templateAnimal;
	
	private final IFile file;
	
	
	public TransactionPublisher(final IFile file) throws IOException{
		this.file=file;	
		Resource templateResource = getResource(file);
		if(templateResource.getContents().isEmpty()){
			throw new IOException("File Resource is empty.");
		}
		if(!(templateResource.getContents().get(0) instanceof Animal)){
			throw new IOException("File Resource does not contain an Animal root");
		}
		syncTemplate();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		   IResourceChangeListener listener = new IResourceChangeListener() {
			  //Listen or react to changes only on the template file.
		      public void resourceChanged(IResourceChangeEvent event) {
		    	  log(new Date()+"\tWorkspace changed event detected.");
		    	  try {
					syncTemplate();
				} catch (IOException e) {
					log(new Date()+"\tFailed to sync file because: "+e.toString());
				}
		      }
		   };
	    workspace.addResourceChangeListener(listener);
	}



	/**
	 * Sets the  animalTeplate and premisesTemplate 
	 * @throws IOException
	 */
	private void syncTemplate() throws IOException {
		log(new Date()+"\tSynchronizing contents of Template file: "+file.getName());
		Resource templateResource = getResource(file);
		if(templateResource.getContents().isEmpty()){
			throw new IOException("File Resource is empty.");
		}
		if(!(templateResource.getContents().get(0) instanceof Animal)){
			throw new IOException("File Resource does not contain an Animal root");
		}
		 
		templateAnimal =  (Animal)templateResource.getContents().get(0);;

	}
	
	
	
	public String getName(){
		return file.getName();
	}
	
	public static Resource getResource(IFile file) throws IOException {
	      
        ResourceSet resourceSet = new ResourceSetImpl();

         URI uri = URI.createPlatformResourceURI(file.getFullPath()
                 .toString(),true);
         Resource resource = resourceSet.createResource(uri);
         if (!resource.isLoaded()) {
             resource.load(null);
         }
         return resource;
}


	/**
	 * Publish the tag as a Templated Event to all Premises in all Resources 
	 * of the EditingDomain
	 * @param tag
	 */
	public void publish(Long tag){
		ResourceSet rs = domain.getResourceSet();
		EList<Resource> resources = rs.getResources();
		for (Resource resource : resources) {
		   if(resources.size()>1){
				log(new Date()+ "\tprocessing "+resource.toString());
			}
		   process( resource,  tag);
		   
		}
	}
	
	private void log(String msg){
		ConsoleUtil.println(
				   EventPublisherView.CONSOLE,
					msg);
	}
	
	private void process(final Resource resource, final Long tag){
		if(resource.getContents().isEmpty()){
			return;
		}
		
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				if(resource.getContents().get(0) instanceof Premises){
					Premises premises = (Premises)resource.getContents().get(0);
					addTemplateEventsToAnimalInPremises(templateAnimal.allEvents(), tag, premises);
				}else{
					log(new Date()+"\tResource contained no premises to process");
				}
			}
		});
		
		
	}
	
	
	/**
	 * Find or create an animal in the premises and add only valid templateEvents to it.
	 * @param templateEvents
	 * @param tagNumberToAdd
	 * @param activePremises
	 */
	@SuppressWarnings("unchecked")
	private void addTemplateEventsToAnimalInPremises(Collection<Event> templateEvents, Long tagNumberToAdd, Premises activePremises){
		Animal animal= CommonUtilities.findAnimal(tagNumberToAdd, activePremises, templateAnimal);
		Collection<Event> events = copyValidEvents(templateEvents,  animal);
		for (Event event : events) {
			log(event.getDateTime()+"\t"+animal.getId()+'\t'+animal.getSpecies()+'\t'+simpleName( event));
			Tag tag = animal.activeTag();
			//If the animal was created from the template, because it did not exist in the premises
			// then it has no activeTag, but it will have a tag that was added during the creation
			// check for it here
			if(tag==null){
				tag = animal.getTags().get(0);
			}
			
			tag.getEvents().add(event);
		}
	}
	
	
	
	private static final String simpleName(Event event){
		String name = event.getClass().getSimpleName();
		return name.substring(0, name.indexOf("Impl"));
	}
	
	/**
	 * Creates a Collection of valid events for the animal
	 * @param templateEvents
	 * @param animal
	 * @return Copy of all valid templateEvents for the animal
	 */
   private static Collection<Event> copyValidEvents(Collection<Event> templateEvents, Animal animal) {
		Copier copier = new Copier();	  
		ArrayList<Event> outputResults = new ArrayList<Event>();
		Event outputEvent;
		for (Event o : templateEvents) {
			outputEvent= (Event) copier.copy(o);
			CommonUtilities.setEventDate(outputEvent);
			if(ActionUtils.canAddEventToAnimal(animal, outputEvent) ){
				outputResults.add(outputEvent);
			}
		}
		return outputResults;
	}
	
}
