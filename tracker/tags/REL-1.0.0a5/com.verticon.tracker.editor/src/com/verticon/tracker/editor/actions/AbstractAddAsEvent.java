/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.eclipse.ui.IObjectActionDelegate;

import com.verticon.tracker.AnimalId;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * @author jconlon
 *
 */
public abstract class AbstractAddAsEvent extends AbstractAddToParentActionDelegate
		implements IObjectActionDelegate {

	

	/**
	 * 
	 * Create an event from the tag.
	 * @return event or null if a duplicate event already exists
	 * @throws NoAnimalFoundException if an animal with the tag id could not be found
	 * @see com.verticon.tracker.editor.actions.AbstractAddToParentActionDelegate#createChildren(java.lang.Long)
	 */
	@Override
	protected Collection createChildren(Long tag) throws NoAnimalFoundException {
		TrackerFactory trackerFactory = TrackerFactory.eINSTANCE;
		
		AnimalId animalId = findAnimalId( tag);
		if(animalId==null){
			throw new NoAnimalFoundException("Could not find an animal with an animail ID tag="+tag);
		}
		return createEvents(trackerFactory,  animalId, tag);
		
	}

	/**
	 * Create an event if there is not already one of the same name.
	 * @param trackerFactory
	 * @param animalId assocated with the tag.
	 * @param tag
	 * @return event or null if there was an existing event
	 */
	protected abstract Collection<Event> createEvents(TrackerFactory trackerFactory,AnimalId animalId, Long tag) ;
	
	
	protected Date findDate(){	
		String fileName = resource.getName().substring(0, resource.getName().indexOf('.'));
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyMMddHHmmss");
		Date date = null;
		try {
			 date = dateFormater.parse(fileName);
		} catch (ParseException e) {
			return new Date();
		}
		
		return date;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.actions.AbstractAddToParentActionDelegate#createParent(com.verticon.tracker.Premises)
	 */
	@Override
	protected Object createParent(Premises premises) {
		return premises.getEventHistory();
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.actions.AbstractAddToParentActionDelegate#getFeature()
	 */
	@Override
	protected Object getFeature() {
		return TrackerPackage.eINSTANCE.getEventHistory_Events();//getAnimals_Animal();
	}

}
