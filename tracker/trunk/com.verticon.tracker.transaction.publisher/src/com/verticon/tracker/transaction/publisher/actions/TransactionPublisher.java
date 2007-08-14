package com.verticon.tracker.transaction.publisher.actions;

import java.io.IOException;
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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.transaction.publisher.views.EventPublisherView;
import com.verticon.transaction.editor.console.ConsoleUtil;

public class TransactionPublisher {

	private final TransactionalEditingDomain domain = 
		TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("com.verticon.transaction.editor.TrackerEditingDomain");
	
	private  Premises premisesTemplate;
	
	private  Animal defaultAnimal;
	
	private final IFile file;
	
	
	
	public TransactionPublisher(final IFile file) throws IOException{
		this.file=file;	
		Resource templateResource = getResource(file);
		if(templateResource.getContents().isEmpty()){
			throw new IOException("File Resource is empty.");
		}
		if(!(templateResource.getContents().get(0) instanceof Premises)){
			throw new IOException("File Resource does not contain a Premises");
		}
		syncTemplate();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		   IResourceChangeListener listener = new IResourceChangeListener() {
			  //REWORK  Listen or react to changes only on the template file.
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
	 * @param file
	 * @throws IOException
	 */
	private void syncTemplate() throws IOException {

  	  log(new Date()+"\tSynchronizing contents of Template file: "+file.getName());
		Resource templateResource = getResource(file);
		if(templateResource.getContents().isEmpty()){
			throw new IOException("File Resource is empty.");
		}
		if(!(templateResource.getContents().get(0) instanceof Premises)){
			throw new IOException("File Resource does not contain a Premises");
		}
	    Premises premisesTemplate = (Premises)templateResource.getContents().get(0);
		Animal animal = null;
		
		if(premisesTemplate.getAnimals()!=null){
			animal = (Animal)premisesTemplate.getAnimals().get(0);
		}
		this.defaultAnimal=animal;
		this.premisesTemplate=premisesTemplate;
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
					addTemplateEventsToPremises( tag, premises);
				}else{
					log(new Date()+"\tResource contained no premises to process");
				}
			}
		});
		
		
	}
	
	/**
	 * REWORK implement
	 * @param tag
	 * @param premises
	 */
	@SuppressWarnings("unchecked")
	private void addTemplateEventsToPremises( Long tag, Premises premises){
		log("Processing a premises");
//		AnimalId animalId = CommonUtilities.findAnimalId(tag, premises, defaultAnimal);
//		Collection<Event> events = CommonUtilities.createEvents(eventHistoryTemplate,  animalId,  premises);
//		for (Event event : events) {
//			log(event.getDateTime()+"\t"+event.getAnimalId().getIdNumber()+'\t'+simpleName( event));
//			premises.getEventHistory().getEvents().add(event);
//		}
	}
	
	
	private static final String simpleName(Event event){
		String name = event.getClass().getSimpleName();
		return name.substring(0, name.indexOf("Impl"));
	}
	
}
