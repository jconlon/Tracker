/**
 * 
 */
package com.verticon.tracker.editor.actions;

import java.util.Collection;

import org.eclipse.ui.IObjectActionDelegate;

import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPackage;

/**
 * 
 * 
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
	protected Collection<Event> createChildren(Long tag) throws NoAnimalFoundException {
		TrackerFactory trackerFactory = TrackerFactory.eINSTANCE;
		
		Tag animalId = findAnimalId( tag, null);
		if(animalId==null){
			throw new NoAnimalFoundException("Could not find an animal with an animail ID tag="+tag);
		}
		return createEvents(trackerFactory,  animalId, tag);
		
	}

	/**
	 * Create an event if there is not already one of the same name.
	 * FIXME refactor to make it more comprehensible
	 * @param trackerFactory
	 * @param tag associated with the tagIdNumber
	 * @param tagIdNumber
	 * @return event or null if there was an existing event
	 */
	protected abstract Collection<Event> createEvents(TrackerFactory trackerFactory,Tag tag, Long tagIdNumber) ;
	
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.actions.AbstractAddToParentActionDelegate#createParent(com.verticon.tracker.Premises)
	 */
	@Override
	protected Object createParent(Premises premises) {
		return premises;
	}

	/* (non-Javadoc)
	 * REWORK
	 * @see com.verticon.tracker.editor.actions.AbstractAddToParentActionDelegate#getFeature()
	 */
	@Override
	protected Object getFeature() {
		return TrackerPackage.eINSTANCE.getTag();//getAnimals_Animal();
	}

}
