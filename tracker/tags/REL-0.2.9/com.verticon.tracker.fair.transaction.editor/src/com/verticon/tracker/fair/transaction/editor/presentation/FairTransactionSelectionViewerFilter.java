package com.verticon.tracker.fair.transaction.editor.presentation;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Person;

public class FairTransactionSelectionViewerFilter extends SelectionViewerFilter {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FairTransactionSelectionViewerFilter.class);
	
	protected final ArrayList<Exhibit> targetedExhibits = new ArrayList<Exhibit>();
	
	protected final ArrayList<Person> targetedPeople = new ArrayList<Person>();
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.action.ViewerFilterAction#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public synchronized boolean select(Viewer viewer, Object parentElement, Object element) {
		if(noTargets()){
			return true;//No targets enabled
		}
		if(element instanceof Premises){//Always return the Premises
			return true;
		}
		if(element instanceof Tag){
			return true;
		}
		if(element instanceof Animal){
			if( targetedAnimals.contains(element)){
				return true;
			}
			Animal animal = (Animal)element;
			logger.debug("Filtering {} with targeted animals ={} ",animal, targetedAnimals.size());
			
			return false;
		}
		if(element instanceof Event){
			if(viewer==mainViewer){//Main Viewer should see all the children events
				return true;
			}else{
				if( targetedEvents.contains(element)){
					return true;
				}
				Event event = (Event)element;
				logger.debug("Filtering {} with targeted events ={} ",event, targetedEvents.size());
				return false;
			}
			
		}
		if(element instanceof Exhibit){
			if( targetedExhibits.contains(element)){
						return true;
			}
			Exhibit exhibit = (Exhibit)element; 
			if(exhibit.getAnimal()!=null && targetedAnimals.contains(exhibit.getAnimal())){
					return true;
			}
			if(exhibit.getExhibitor()!=null && targetedPeople.contains(exhibit.getExhibitor())){
					return true;
			}		
			return false;
		}
		if(element instanceof Person){
			if( targetedPeople.contains(element)){
						return true;
			}
			return false;
		}
		
		return true;
	}
	
	/**
	 * From the selection in the MainViewer target the Selected Animals, the Animal
	 * parents of selected Events, and selected Events.
	 */
	protected void computeTargets(ISelection selection) {
		logger.debug("computing targets ");
		 
		clearTargets();
		if (selection instanceof IStructuredSelection) {
			Event event = null;
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				Object o = iter.next();
				if (o instanceof Animal) {
					targetedAnimals.add((Animal) o);
				}else if (o instanceof Event) {
				    event = (Event)o;
					targetedEvents.add(event);
					//A selected event implies that it's animal is also selected
					if(event.getTag()!=null){
						if(event.getTag().eContainer()!=null){
							targetedAnimals.add((Animal)event.getTag().eContainer());
						}
					}
				}else if (o instanceof Exhibit) {
					Exhibit exhibit = (Exhibit)o;
					targetedExhibits.add(exhibit);
					if(exhibit.getAnimal()!=null ){
						targetedAnimals.add(exhibit.getAnimal());
					}
					if(exhibit.getExhibitor()!=null){
						targetedPeople.add(exhibit.getExhibitor()) ;
					}
					
				}else if (o instanceof Person) {
					targetedPeople.add((Person)o);
				}
			}
		}
		logger.debug("Targeted animals = {}",targetedAnimals.size());
		logger.debug("Targeted events = {}",targetedEvents.size());
	}

}
